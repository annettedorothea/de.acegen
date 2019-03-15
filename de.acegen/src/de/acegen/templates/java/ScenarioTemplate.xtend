package de.acegen.templates.java

import de.acegen.aceGen.AttributeDefinition
import de.acegen.aceGen.DataDefinition
import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerAce
import de.acegen.aceGen.HttpServerAceRead
import de.acegen.aceGen.HttpServerAceWrite
import de.acegen.aceGen.Model
import de.acegen.aceGen.Scenario
import de.acegen.aceGen.ScenarioEvent
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.java.AceExtension
import de.acegen.extensions.java.AttributeExtension
import de.acegen.extensions.java.ModelExtension
import javax.inject.Inject
import de.acegen.aceGen.Authorization

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
		
		import java.util.ArrayList;
		import java.util.List;
		
		import javax.ws.rs.core.Response;
		
		import org.joda.time.DateTime;
		import org.joda.time.format.DateTimeFormat;
		
		import org.junit.Test;
		
		import com.anfelisa.ace.BaseScenario;
		import com.anfelisa.ace.ITimelineItem;
		import com.anfelisa.todo.TestUtils;
		import com.anfelisa.todo.ActionCalls;
		
		import static org.hamcrest.MatcherAssert.assertThat;
		import static org.hamcrest.Matchers.is;
		import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;
		
		@SuppressWarnings("unused")
		public class «name»Scenario extends BaseScenario {
		
			private void given() throws Exception {
				List<ITimelineItem> timeline = new ArrayList<>();
				
				«FOR scenarioEvent : events»
					«generateEventCreation(scenarioEvent, (scenarioEvent.outcome.eContainer as HttpServerAceWrite).model, events.indexOf(scenarioEvent))»
					
				«ENDFOR»
				prepare(timeline, DROPWIZARD.getLocalPort());
			}
			
			private Response when() throws Exception {
				«IF dataDefinition.systemtime !== null»
					setSystemTime(«dateFrom(dataDefinition.systemtime)», DROPWIZARD.getLocalPort());
				«ENDIF»
				return «generateActionCalls(action, dataDefinition, authorization, java)»
			}
			
			private void then(Response response) throws Exception {
				«IF statusCode !== 0»
					assertThat(response.getStatus(), is(«statusCode»));
				«ENDIF»
				
				«IF response !== null»
					«generateDataCreation(response, action.model, "expectedData")»
					
					«action.responseDataNameWithPackage(java)» expected = new «action.responseDataNameWithPackage(java)»(expectedData);

					«action.responseDataNameWithPackage(java)» actual = response.readEntity(«action.responseDataNameWithPackage(java)».class);

					assertThat(actual, sameBeanAs(expected));
				«ENDIF»
				
				«FOR verification : verifications»
					«IF verification.response !== null»
						«IF verification.dataDefinition.systemtime !== null»
							setSystemTime(«dateFrom(verification.dataDefinition.systemtime)», DROPWIZARD.getLocalPort());
						«ENDIF»

						Response «verification.action.name.toFirstLower»«verifications.indexOf(verification)» = «generateActionCalls(verification.action, verification.dataDefinition, verification.authorization, java)»
						
						«generateDataCreation(verification.response, verification.action.model, '''expected«verification.action.name.toFirstUpper»«verifications.indexOf(verification)»Data''')»
						
						«verification.action.responseDataNameWithPackage(java)» expected«verification.action.name.toFirstUpper»«verifications.indexOf(verification)» = new «verification.action.responseDataNameWithPackage(java)»(expected«verification.action.name.toFirstUpper»«verifications.indexOf(verification)»Data);

						«verification.action.responseDataNameWithPackage(java)» actual«verification.action.name.toFirstUpper»«verifications.indexOf(verification)» = «verification.action.name.toFirstLower»«verifications.indexOf(verification)».readEntity(«verification.action.responseDataNameWithPackage(java)».class);

						assertThat(actual«verification.action.name.toFirstUpper»«verifications.indexOf(verification)», sameBeanAs(expected«verification.action.name.toFirstUpper»«verifications.indexOf(verification)»));
						
						
					«ENDIF»
				«ENDFOR»
			}
			
			@Test
			public void «name.toFirstLower»() throws Exception {
				given();
				
				Response response = when();
		
				then(response);
			}
			
			
		}
		
		
		«sdg»
		
	'''
	
	def generateEventCreation(ScenarioEvent it, Model model, int index) '''
		«generateDataCreation(dataDefinition, model, '''«model.name.toFirstLower»«index»''')»
		timeline.add(TestUtils.create«(outcome.eContainer as HttpServerAceWrite).eventName(outcome)»TimelineItem(«model.name.toFirstLower»«index»));
	'''
	
	def generateDataCreation(DataDefinition it, Model model, String varName) '''
		«model.dataNameWithPackage» «varName» = new «model.dataNameWithPackage»("«uuid»");
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
			ActionCalls.call«aceOperation.getName.toFirstUpper»(«FOR param : mergeAttributesForPostCall(aceOperation, dataDefinition) SEPARATOR ', '»«param»«ENDFOR»«IF aceOperation.isAuthorize», authorization(«authorization.username», «authorization.password»)«ENDIF»);
		«ELSEIF aceOperation.getType == "PUT"»
			ActionCalls.call«aceOperation.getName.toFirstUpper»(«FOR param : mergeAttributesForPutCall(aceOperation, dataDefinition) SEPARATOR ', '»«param»«ENDFOR»«IF aceOperation.isAuthorize», authorization(«authorization.username», «authorization.password»)«ENDIF»);
		«ELSEIF aceOperation.getType == "DELETE"»
			ActionCalls.call«aceOperation.getName.toFirstUpper»(«FOR param : mergeAttributesForDeleteCall(aceOperation, dataDefinition) SEPARATOR ', '»«param»«ENDFOR»«IF aceOperation.isAuthorize», authorization(«authorization.username», «authorization.password»)«ENDIF»);
		«ELSE»
			ActionCalls.call«aceOperation.getName.toFirstUpper»(«FOR param : mergeAttributesForGetCall(aceOperation, dataDefinition) SEPARATOR ', '»«param»«ENDFOR»«IF aceOperation.isAuthorize», authorization(«authorization.username», «authorization.password»)«ENDIF»);
		«ENDIF»
	'''
	
	def generateBaseScenario() '''
		«copyright»
		
		package com.anfelisa.ace;
		
		import org.jdbi.v3.core.Jdbi;
		import org.junit.After;
		import org.junit.AfterClass;
		import org.junit.Before;
		import org.junit.BeforeClass;
		import org.mockito.MockitoAnnotations;
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
				MockitoAnnotations.initMocks(this);
			}
			
			@After
			public void after() {
				handle.close();
			}
			
			@Override
			protected String authorization(String username, String password) {
				return "";
			}
		
		}
		
	'''

	def generateAbstractBaseScenario() '''
		«copyright»
		
		package com.anfelisa.ace;
		
		import java.util.ArrayList;
		import java.util.List;
		import java.util.UUID;
		
		import javax.ws.rs.client.Client;
		import javax.ws.rs.client.Entity;
		
		import org.glassfish.jersey.client.JerseyClientBuilder;
		import org.jdbi.v3.core.Handle;
		import org.joda.time.DateTime;
		
		public abstract class AbstractBaseScenario {
		
			protected final JodaObjectMapper mapper = new JodaObjectMapper();
		
			protected DaoProvider daoProvider;
		
			protected Handle handle;
		
			public static String randomUUID() {
				return UUID.randomUUID().toString();
			}
		
			protected void prepare(List<ITimelineItem> timeline, int port) {
				Client client = new JerseyClientBuilder().build();
				client.target(String.format("http://localhost:%d/api/test/replay-events", port))
						.request().put(Entity.json(timeline));
			}
		
			protected void prepare(int port) {
				List<ITimelineItem> timeline = new ArrayList<>();
				Client client = new JerseyClientBuilder().build();
				client.target(String.format("http://localhost:%d/api/test/replay-events", port))
						.request().put(Entity.json(timeline));
			}
		
			protected void setSystemTime(DateTime systemTime, int port) {
				Client client = new JerseyClientBuilder().build();
				client.target(String.format("http://localhost:%d/api/test/system-time", port))
						.request().put(Entity.json(systemTime.toString()));
			}
			
			protected abstract String authorization(String username, String password);
		
		}
		
		
		«sdg»
		
	'''

	def generateTestUtils(HttpServer it) '''
		«copyright»
		
		package «getName»;
		
		import com.anfelisa.ace.JodaObjectMapper;
		import com.anfelisa.ace.TimelineItem;
		import com.fasterxml.jackson.core.JsonProcessingException;
		
		public class TestUtils {
		
			private static final JodaObjectMapper mapper = new JodaObjectMapper();
		
			«FOR aceOperation : aceOperations»
				«aceOperation.createTimelineItem»

			«ENDFOR»
			
		}
		
		
		«sdg»
		
	'''

	private def dispatch createTimelineItem(HttpServerAceWrite it) '''
		«FOR outcome : outcomes»
			public static TimelineItem create«eventName(outcome)»TimelineItem(«getModel.dataInterfaceNameWithPackage» data) throws JsonProcessingException {
				String json = mapper.writeValueAsString(data);
				return new TimelineItem("prepare", null, "«eventNameWithPackage(outcome)»", null, json, data.getUuid());
			}
		«ENDFOR»
	'''

	private def dispatch createTimelineItem(HttpServerAceRead it) ''''''

}
