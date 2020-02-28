package de.acegen.templates.java

import de.acegen.aceGen.AttributeDefinition
import de.acegen.aceGen.Authorization
import de.acegen.aceGen.DataDefinition
import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerAce
import de.acegen.aceGen.Model
import de.acegen.aceGen.Scenario
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.java.AceExtension
import de.acegen.extensions.java.AttributeExtension
import de.acegen.extensions.java.ModelExtension
import javax.inject.Inject

class ScenarioTemplate {

	@Inject
	extension ModelExtension

	@Inject
	extension AttributeExtension

	@Inject
	extension AceExtension

	@Inject
	extension CommonExtension

	def generateScenario(Scenario it, HttpServer java) '''
		«copyright»
		
		package «java.getName».scenarios;
		
		import javax.ws.rs.core.Response;
		
		@SuppressWarnings("unused")
		public class «name»Scenario extends Abstract«name»Scenario {

			@Override
			protected void verifications(Response response) {
			}
		
		}
		
		
		«sdg»
		
	'''

	def generateAbstractScenario(Scenario it, HttpServer java) '''
		«copyright»
		
		package «java.getName».scenarios;
		
		import java.util.ArrayList;
		import java.util.List;
		
		import javax.ws.rs.core.Response;
		
		import org.joda.time.DateTime;
		import org.joda.time.format.DateTimeFormat;
		
		import org.junit.Test;
		
		import com.anfelisa.ace.BaseScenario;
		import com.anfelisa.ace.ITimelineItem;
		import «java.getName».ActionCalls;
		
		@SuppressWarnings("unused")
		public abstract class Abstract«name»Scenario extends BaseScenario {
		
			private void given() throws Exception {
				«FOR scenario : scenarios»
					«generateActionCalls(scenario.whenBlock.action, scenario.whenBlock.dataDefinition, scenario.whenBlock.authorization, java)»
				«ENDFOR»
			}
			
			private Response when() throws Exception {
				«IF whenBlock.dataDefinition.systemtime !== null»
					// TODO
				«ENDIF»
				return «generateActionCalls(whenBlock.action, whenBlock.dataDefinition, whenBlock.authorization, java)»
			}
			
			private void then(Response response) throws Exception {
				«IF thenBlock.statusCode !== 0»
					assertThat(response.getStatus(), «thenBlock.statusCode»);
				«ENDIF»
				
				«IF thenBlock.response !== null»
					«generateDataCreation(thenBlock.response, whenBlock.action.model, "expectedData")»
					
					«whenBlock.action.responseDataNameWithPackage(java)» expected = new «whenBlock.action.responseDataNameWithPackage(java)»(expectedData);

					«whenBlock.action.responseDataNameWithPackage(java)» actual = response.readEntity(«whenBlock.action.responseDataNameWithPackage(java)».class);

					assertThat(actual, expected);
				«ENDIF»
				
			}
			
			@Test
			public void «name.toFirstLower»() throws Exception {
				given();
				
				Response response = when();
		
				then(response);
				
				verifications(response);
			}
			
			protected abstract void verifications(Response response);
		
		}
		
		
		«sdg»
		
	'''
	
	def generateDataCreation(DataDefinition it, Model model, String varName) '''
		«model.dataNameWithPackage» «varName» = new «model.dataNameWithPackage»(«IF uuid !== null»"«uuid»"«ELSE»randomUUID()«ENDIF»);
		«IF systemtime !== null»
			«varName».setSystemTime(DateTime.parse("«systemtime»", DateTimeFormat.forPattern("dd.MM.yyyy HH:mm:ss")));
		«ENDIF»
		«FOR attributeDefinition : data.attributeDefinitions»
			«IF attributeDefinition.value.attributeDefinitionList !== null»
				«generateModelCreation(attributeDefinition, varName + attributeDefinition.attribute.name.toFirstUpper)»
				«varName».«attributeDefinition.attribute.setterCall(varName + attributeDefinition.attribute.name.toFirstUpper)»;
			«ELSEIF attributeDefinition.value.listAttributeDefinitionList !== null»
				«generateModelListCreation(attributeDefinition, varName + attributeDefinition.attribute.name.toFirstUpper)»
				«varName».«attributeDefinition.attribute.setterCall(varName + attributeDefinition.attribute.name.toFirstUpper)»;
			«ELSE»
				«varName».«attributeDefinition.attribute.setterCall(attributeDefinition.valueFrom)»;
			«ENDIF»
		«ENDFOR»
	'''

	def generateModelCreation(AttributeDefinition it, String varName) '''
		«attribute.model.interfaceWithPackage» «varName» = new «attribute.model.modelClassNameWithPackage»();
		«FOR attributeDefinition : value.attributeDefinitionList.attributeDefinitions»
			«varName».«attributeDefinition.attribute.setterCall(attributeDefinition.valueFrom)»;
		«ENDFOR»
	'''

	def generateModelListCreation(AttributeDefinition it, String varName) '''
		List<«attribute.model.interfaceWithPackage»> «varName» = new ArrayList<«attribute.model.interfaceWithPackage»>();
		«FOR attributeDefinitionList : value.listAttributeDefinitionList.attributeDefinitionList»
			«attribute.model.interfaceWithPackage» «varName + value.listAttributeDefinitionList.attributeDefinitionList.indexOf(attributeDefinitionList)» = new «attribute.model.modelClassNameWithPackage»();
			«FOR attributeDefinition : attributeDefinitionList.attributeDefinitions»
				«varName»«value.listAttributeDefinitionList.attributeDefinitionList.indexOf(attributeDefinitionList)».«attributeDefinition.attribute.setterCall(attributeDefinition.valueFrom)»;
			«ENDFOR»
			«varName».add(«varName + value.listAttributeDefinitionList.attributeDefinitionList.indexOf(attributeDefinitionList)»);
		«ENDFOR»
	'''

	def generateActionCalls(HttpServerAce aceOperation, DataDefinition dataDefinition, Authorization authorization, HttpServer java) '''
		«IF aceOperation.getType == "POST"»
			ActionCalls.call«aceOperation.getName.toFirstUpper»(«FOR param : mergeAttributesForPostCall(aceOperation, dataDefinition) SEPARATOR ', '»«param.paramString»«ENDFOR»«IF aceOperation.isAuthorize», authorization("«authorization.username»", "«authorization.password»")«ENDIF»);
		«ELSEIF aceOperation.getType == "PUT"»
			ActionCalls.call«aceOperation.getName.toFirstUpper»(«FOR param : mergeAttributesForPutCall(aceOperation, dataDefinition) SEPARATOR ', '»«param.paramString»«ENDFOR»«IF aceOperation.isAuthorize», authorization("«authorization.username»", "«authorization.password»")«ENDIF»);
		«ELSEIF aceOperation.getType == "DELETE"»
			ActionCalls.call«aceOperation.getName.toFirstUpper»(«FOR param : mergeAttributesForDeleteCall(aceOperation, dataDefinition) SEPARATOR ', '»«param.paramString»«ENDFOR»«IF aceOperation.isAuthorize», authorization("«authorization.username»", "«authorization.password»")«ENDIF»);
		«ELSE»
			ActionCalls.call«aceOperation.getName.toFirstUpper»(«FOR param : mergeAttributesForGetCall(aceOperation, dataDefinition) SEPARATOR ', '»«param.paramString»«ENDFOR»«IF aceOperation.isAuthorize», authorization("«authorization.username»", "«authorization.password»")«ENDIF»);
		«ENDIF»
	'''
	
	private def paramString(String param) '''«IF param !== null && param.length > 0»«param»«ELSE»null«ENDIF»'''	
	
	def generateBaseScenario() '''
		«copyright»
		
		package com.anfelisa.ace;
		
		import org.jdbi.v3.core.Jdbi;
		import org.junit.After;
		import org.junit.AfterClass;
		import org.junit.Before;
		import org.junit.BeforeClass;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import com.anfelisa.ace.AbstractBaseScenario;
		import com.anfelisa.ace.App;
		import com.anfelisa.ace.CustomAppConfiguration;
		import com.anfelisa.ace.DaoProvider;
		
		import io.dropwizard.jdbi3.JdbiFactory;
		import io.dropwizard.testing.DropwizardTestSupport;
		
		public class BaseScenario extends AbstractBaseScenario {
		
			static final Logger LOG = LoggerFactory.getLogger(BaseScenario.class);
		
			public static final DropwizardTestSupport<CustomAppConfiguration> DROPWIZARD = new DropwizardTestSupport<CustomAppConfiguration>(
					App.class, "test.yml");
			
			private static Jdbi jdbi;
		
			@BeforeClass
			public static void beforeClass() {
				DROPWIZARD.before();
				final JdbiFactory factory = new JdbiFactory();
				jdbi = factory.build(DROPWIZARD.getEnvironment(), DROPWIZARD.getConfiguration().getDataSourceFactory(), "testdb");
			}
		
			@AfterClass
			public static void afterClass() {
				try {
					DROPWIZARD.after();
				} catch (Exception x) {
					LOG.error("exception when cleaning up dropwizard", x);
				}
			}
		
			@Before
			public void before() {
				daoProvider = new DaoProvider();
				handle = jdbi.open();
			}
			
			@After
			public void after() {
				handle.close();
			}
			
			@Override
			protected String authorization(String username, String password) {
				return "";
			}
		
			@Override
			protected void assertThat(int actual, int expected) {
				throw new RuntimeException("BaseScenario.assertThat not implemented");
			}

			@Override
			protected void assertThat(Object actual, Object expected) {
				throw new RuntimeException("BaseScenario.assertThat not implemented");
			}
			
			@Override
			protected abstract void assertIsNull(Object actual) {
				throw new RuntimeException("BaseScenario.assertIsNull not implemented");
			}
		}
		
	'''

	def generateAbstractBaseScenario() '''
		«copyright»
		
		package com.anfelisa.ace;
		
		import java.util.UUID;
		
		import org.jdbi.v3.core.Handle;
		
		public abstract class AbstractBaseScenario {
		
			protected final JodaObjectMapper mapper = new JodaObjectMapper();
		
			protected DaoProvider daoProvider;
		
			protected Handle handle;
		
			public static String randomUUID() {
				return UUID.randomUUID().toString();
			}
		
			protected abstract String authorization(String username, String password);

			protected abstract void assertThat(int actual, int expected);

			protected abstract void assertThat(Object actual, Object expected);

			protected abstract void assertIsNull(Object actual);
		
		}
		
		
		«sdg»
		
	'''

}
