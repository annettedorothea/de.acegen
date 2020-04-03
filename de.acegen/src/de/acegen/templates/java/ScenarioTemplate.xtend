package de.acegen.templates.java

import de.acegen.aceGen.AttributeDefinition
import de.acegen.aceGen.AttributeDefinitionListForList
import de.acegen.aceGen.Authorization
import de.acegen.aceGen.DataDefinition
import de.acegen.aceGen.GivenRef
import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerAce
import de.acegen.aceGen.Model
import de.acegen.aceGen.PrimitiveValueDefinitionForList
import de.acegen.aceGen.Scenario
import de.acegen.aceGen.WhenBlock
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.java.AceExtension
import de.acegen.extensions.java.AttributeExtension
import de.acegen.extensions.java.ModelExtension
import java.util.ArrayList
import java.util.List
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

	int varIndex = 0;

	def generateScenario(Scenario it, HttpServer java) '''
		«copyright»
		
		package «java.getName».scenarios;
		
		import javax.ws.rs.core.Response;
		
		@SuppressWarnings("unused")
		public class «name»Scenario extends Abstract«name»Scenario {
		
			@Override
			protected void verifications(«IF whenBlock.action.isRead»«whenBlock.action.responseDataNameWithPackage(whenBlock.action.eContainer as HttpServer)» response «ENDIF») {
			}
		
		}
		
		
		«sdg»
		
	'''

	def generateAbstractScenario(Scenario it, HttpServer java) '''
		«copyright»
		
		package «java.getName».scenarios;
		
		import java.util.ArrayList;
		import java.util.Arrays;
		import java.util.List;
		
		import javax.ws.rs.core.Response;
		
		import org.joda.time.DateTime;
		import org.joda.time.format.DateTimeFormat;
		
		import org.junit.Test;
		
		import de.acegen.BaseScenario;
		import de.acegen.ITimelineItem;
		import de.acegen.NotReplayableDataProvider;
		
		@SuppressWarnings("unused")
		public abstract class Abstract«name»Scenario extends BaseScenario {
		
			private void given() throws Exception {
				«var index = 0»
				«FOR givenRef : allGivenRefs»
					«IF givenRef.times > 0»
						«FOR i: givenRef.times.timesIterator»
							«givenRef.scenario.whenBlock.generatePrepare»
							«givenRef.scenario.whenBlock.generateActionCall(java, index++)»
						«ENDFOR»
					«ELSE»
						«givenRef.scenario.whenBlock.generatePrepare»
						«givenRef.scenario.whenBlock.generateActionCall(java, index++)»
					«ENDIF»

			«ENDFOR»
			}
			
			private Response when() throws Exception {
				«whenBlock.generatePrepare»
				return «whenBlock.generateActionCall(java, 0)»
			}
			
			private «IF whenBlock.action.isRead»«whenBlock.action.responseDataNameWithPackage(whenBlock.action.eContainer as HttpServer)»«ELSE»void«ENDIF» then(Response response) throws Exception {
				«IF thenBlock.statusCode !== 0»
					assertThat(response.getStatus(), «thenBlock.statusCode»);
				«ENDIF»
				
				«IF whenBlock.action.isRead»
					«whenBlock.action.responseDataNameWithPackage(whenBlock.action.eContainer as HttpServer)» actual = null;
					try {
						actual = response.readEntity(«whenBlock.action.responseDataNameWithPackage(whenBlock.action.eContainer as HttpServer)».class);
					} catch (Exception x) {
					}
				«ENDIF»
				«IF thenBlock.response !== null»
					«generateDataCreation(thenBlock.response, whenBlock.action.model, "expectedData")»
					
					«whenBlock.action.responseDataNameWithPackage(whenBlock.action.eContainer as HttpServer)» expected = new «whenBlock.action.responseDataNameWithPackage(whenBlock.action.eContainer as HttpServer)»(expectedData);


					assertThat(actual, expected);
					«ENDIF»
					
					«IF whenBlock.action.isRead»
						return actual;
						«ENDIF»
						}
						
						@Test
						public void «name.toFirstLower»() throws Exception {
							given();
							
							Response response = when();
					
							«IF whenBlock.action.isRead»«whenBlock.action.responseDataNameWithPackage(whenBlock.action.eContainer as HttpServer)» actualResponse = «ENDIF»then(response);
							
							verifications(«IF whenBlock.action.isRead»actualResponse«ENDIF»);
					}
					
					protected abstract void verifications(«IF whenBlock.action.isRead»«whenBlock.action.responseDataNameWithPackage(whenBlock.action.eContainer as HttpServer)» response«ENDIF»);
					
					}
					
					
					«sdg»
					
	'''

	private def allGivenRefs(Scenario it) {
		var allWhenBlocks = new ArrayList<GivenRef>();
		for (givenRef : givenRefs) {
			allGivenRefsRec(givenRef, allWhenBlocks)
		}
		return allWhenBlocks
	}

	private def void allGivenRefsRec(GivenRef it, List<GivenRef> allWhenBlocks) {
		for (scenario : scenario.givenRefs) {
			allGivenRefsRec(scenario, allWhenBlocks)
		}
		if (!allWhenBlocks.contains(it)) {
			allWhenBlocks.add(it)
		} 
	}
	
	private def generatePrepare(WhenBlock it) '''
		«IF dataDefinition.systemtime !== null»
			NotReplayableDataProvider.setSystemTime(«dateTimeParse(dataDefinition.systemtime, dataDefinition.pattern)»);
		«ENDIF»
		«IF dataDefinition !== null && dataDefinition.data !== null && dataDefinition.data.attributeDefinitions !== null»
			«FOR attributeDefinition: dataDefinition.data.attributeDefinitions»
				«IF attributeDefinition.attribute.notReplayable»
					NotReplayableDataProvider.put("«attributeDefinition.attribute.name»", «attributeDefinition.valueFrom»);
				«ENDIF»
			«ENDFOR»
		«ENDIF»
	'''

	private def generateActionCall(WhenBlock it, HttpServer java,
		int index) '''«generateActionCalls(action, dataDefinition, authorization, java, index)»'''

	def generateDataCreation(DataDefinition it, Model model, String varName) '''
		«resetVarIndex»
		«model.dataNameWithPackage» «varName» = new «model.dataNameWithPackage»(«IF uuid !== null»"«uuid»"«ELSE»randomUUID()«ENDIF»);
		«IF systemtime !== null»
			«varName».setSystemTime(«dateTimeParse(systemtime, pattern)»);
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
				«IF attributeDefinition.attribute.isList»
					«val listVarName = newVarName("list")»
					«generateModelListCreation(attributeDefinition, listVarName)»
					«varName».«attributeDefinition.attribute.setterCall(listVarName)»;
				«ELSE»
					«varName».«attributeDefinition.attribute.setterCall(attributeDefinition.valueFrom)»;
				«ENDIF»
			«ENDFOR»
			
	'''

	def String generateModelListCreation(AttributeDefinition it, String varName) '''
		
			«IF value.listAttributeDefinitionList instanceof AttributeDefinitionListForList»
				List<«attribute.model.interfaceWithPackage»> «varName» = new ArrayList<«attribute.model.interfaceWithPackage»>();
				«FOR attributeDefinitionList : (value.listAttributeDefinitionList as AttributeDefinitionListForList).attributeDefinitionList»
					«val itemVarName = newVarName("item")»
					«attribute.model.interfaceWithPackage» «itemVarName» = new «attribute.model.modelClassNameWithPackage»();
					«FOR attributeDefinition : attributeDefinitionList.attributeDefinitions»
						«IF attributeDefinition.attribute.isList»
							«val listVarName = newVarName("list")»
							«generateModelListCreation(attributeDefinition, listVarName)»
							«itemVarName».«attributeDefinition.attribute.setterCall(listVarName)»;
						«ELSE»
							«itemVarName».«attributeDefinition.attribute.setterCall(attributeDefinition.valueFrom)»;
						«ENDIF»
					«ENDFOR»
					«varName».add(«itemVarName»);

				«ENDFOR»
			«ELSE»
				«FOR primitiveValueDefinitionList : (value.listAttributeDefinitionList as PrimitiveValueDefinitionForList).valueDefinitionList»
					«varName».add(«primitiveValueDefinitionList.primitiveValue»);

				«ENDFOR»
			«ENDIF»
			
	'''

	private def newVarName(String prefix) {
		varIndex++;
		return prefix + varIndex;
	}

	private def void resetVarIndex() {
		varIndex = 0;
	}

	def generateActionCalls(HttpServerAce aceOperation, DataDefinition dataDefinition, Authorization authorization,
		HttpServer java, int index) '''
		«IF aceOperation.getType == "POST"»
			«aceOperation.packageFor».ActionCalls.call«aceOperation.getName.toFirstUpper»(«FOR param : mergeAttributesForPostCall(aceOperation, dataDefinition, index) SEPARATOR ', '»«param.paramString»«ENDFOR»«IF aceOperation.isAuthorize && authorization !== null», authorization("«authorization.username»", "«authorization.password»")«ELSEIF aceOperation.isAuthorize», null«ENDIF»);
		«ELSEIF aceOperation.getType == "PUT"»
			«aceOperation.packageFor».ActionCalls.call«aceOperation.getName.toFirstUpper»(«FOR param : mergeAttributesForPutCall(aceOperation, dataDefinition, index) SEPARATOR ', '»«param.paramString»«ENDFOR»«IF aceOperation.isAuthorize && authorization !== null», authorization("«authorization.username»", "«authorization.password»")«ELSEIF aceOperation.isAuthorize», null«ENDIF»);
		«ELSEIF aceOperation.getType == "DELETE"»
			«aceOperation.packageFor».ActionCalls.call«aceOperation.getName.toFirstUpper»(«FOR param : mergeAttributesForDeleteCall(aceOperation, dataDefinition, index) SEPARATOR ', '»«param.paramString»«ENDFOR»«IF aceOperation.isAuthorize && authorization !== null», authorization("«authorization.username»", "«authorization.password»")«ELSEIF aceOperation.isAuthorize», null«ENDIF»);
		«ELSE»
			«aceOperation.packageFor».ActionCalls.call«aceOperation.getName.toFirstUpper»(«FOR param : mergeAttributesForGetCall(aceOperation, dataDefinition, index) SEPARATOR ', '»«param.paramString»«ENDFOR»«IF aceOperation.isAuthorize && authorization !== null», authorization("«authorization.username»", "«authorization.password»")«ELSEIF aceOperation.isAuthorize», null«ENDIF»);
		«ENDIF»
	'''

	private def paramString(String param) '''«IF param !== null && param.length > 0»«param»«ELSE»null«ENDIF»'''

	def generateBaseScenario() '''
		«copyright»
		
		package de.acegen;
		
		import org.jdbi.v3.core.Jdbi;
		import org.junit.After;
		import org.junit.AfterClass;
		import org.junit.Before;
		import org.junit.BeforeClass;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import de.acegen.AbstractBaseScenario;
		import de.acegen.App;
		import de.acegen.CustomAppConfiguration;
		import de.acegen.DaoProvider;
		
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
				handle = new PersistenceHandle(jdbi.open());
				daoProvider = new DaoProvider();
				daoProvider.truncateAllViews(handle);
			}
			
			@After
			public void after() {
				handle.getHandle().close();
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
			protected void assertIsNull(Object actual) {
				throw new RuntimeException("BaseScenario.assertIsNull not implemented");
			}
		}
		
	'''

	def generateAbstractBaseScenario() '''
		«copyright»
		
		package de.acegen;
		
		import java.util.UUID;
		
		public abstract class AbstractBaseScenario {
		
			protected final JodaObjectMapper mapper = new JodaObjectMapper();
		
			protected DaoProvider daoProvider;
		
			protected PersistenceHandle handle;
		
			public static String randomUUID() {
				return UUID.randomUUID().toString();
			}
		
			protected String templateStringValue(String value, Integer index) {
				String returnString = value;
				if (index != null && value.contains("${index}")) {
					returnString = returnString.replace("${index}", index.toString());
				}
				if (value.contains("${random}")) {
					returnString = returnString.replace("${random}", UUID.randomUUID().toString().substring(0, 8));
				}
				return returnString;
			}
		
			protected abstract String authorization(String username, String password);
		
			protected abstract void assertThat(int actual, int expected);
		
			protected abstract void assertThat(Object actual, Object expected);
		
			protected abstract void assertIsNull(Object actual);
		
		}
		
		
		«sdg»
		
	'''

}
