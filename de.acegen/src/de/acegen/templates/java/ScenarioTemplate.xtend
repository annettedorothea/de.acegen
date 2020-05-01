package de.acegen.templates.java

import de.acegen.aceGen.Authorization
import de.acegen.aceGen.DataDefinition
import de.acegen.aceGen.GivenRef
import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerAce
import de.acegen.aceGen.Model
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

	def generateScenario(Scenario it, HttpServer java) '''
		«copyright»
		«resetIndex»
		
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
		import org.joda.time.DateTimeZone;
		import org.joda.time.format.DateTimeFormat;
		
		import org.junit.Test;
		
		import de.acegen.BaseScenario;
		import de.acegen.ITimelineItem;
		import de.acegen.NotReplayableDataProvider;
		
		@SuppressWarnings("unused")
		public abstract class Abstract«name»Scenario extends BaseScenario {
		
			private void given() throws Exception {
				Response response;
				«FOR givenRef : allGivenRefs»
					«IF givenRef.times > 0»
						«FOR i: givenRef.times.timesIterator»
							«givenRef.scenario.whenBlock.generatePrepare»
							response = «givenRef.scenario.whenBlock.generateActionCall(java, false)»
							if (response.getStatus() == 500) {
								String message = "GIVEN «givenRef.scenario.whenBlock.action.name» fails\n" + response.readEntity(String.class);
								assertFail(message);
							}
							
						«ENDFOR»
					«ELSE»
						«givenRef.scenario.whenBlock.generatePrepare»
						response = «givenRef.scenario.whenBlock.generateActionCall(java, false)»
						if (response.getStatus() == 500) {
							String message = "GIVEN «givenRef.scenario.whenBlock.action.name» fails\n" + response.readEntity(String.class);
							assertFail(message);
						}
						
					«ENDIF»

			«ENDFOR»
			}
			
			private Response when() throws Exception {
				«whenBlock.generatePrepare»
				«whenBlock.generateActionCall(java, true)»
			}
			
			private «IF whenBlock.action.isRead»«whenBlock.action.responseDataNameWithPackage(whenBlock.action.eContainer as HttpServer)»«ELSE»void«ENDIF» then(Response response) throws Exception {
				if (response.getStatus() == 500) {
					String message = response.readEntity(String.class);
					assertFail(message);
				}
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
					«whenBlock.action.model.dataNameWithPackage» expectedData = «objectMapperCall(thenBlock.response, whenBlock.action.model)»;
					
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
						
						@Override
						protected String scenarioName() {
							return "«name»";
						}
					
					}
					
					«sdg»
					
	'''

	private def allGivenRefs(Scenario it) {
		var allWhenBlocks = new ArrayList<GivenRef>();
		for (givenRef : givenRefs) {
			if (givenRef.excludeGiven) {
				allWhenBlocks.add(givenRef)
			} else {
				allGivenRefsRec(givenRef, allWhenBlocks)
			}
		}
		return allWhenBlocks
	}

	private def void allGivenRefsRec(GivenRef it, List<GivenRef> allWhenBlocks) {
		if (!excludeGiven) {
			for (scenario : scenario.givenRefs) {
				allGivenRefsRec(scenario, allWhenBlocks)
			}
		}
		allWhenBlocks.add(it)
	}
	
	private def generatePrepare(WhenBlock it) '''
		«IF dataDefinition.systemtime !== null»
			NotReplayableDataProvider.setSystemTime(DateTime.parse("«dataDefinition.systemtime»", DateTimeFormat.forPattern("«dataDefinition.pattern»")).withZone(DateTimeZone.UTC));
		«ENDIF»
		«IF dataDefinition !== null && dataDefinition.data !== null && dataDefinition.data.members !== null»
			«FOR attributeDefinition: dataDefinition.data.members»
				«IF attributeDefinition.attribute.notReplayable»
					NotReplayableDataProvider.put("«attributeDefinition.attribute.name»", objectMapper.readValue("«attributeDefinition.value.valueFrom»",
							«IF attributeDefinition.attribute.model !== null» «attributeDefinition.attribute.model.dataNameWithPackage».class));
							«ELSEIF attributeDefinition.attribute.type !== null» «attributeDefinition.attribute.javaType».class));«ENDIF»
				«ENDIF»
			«ENDFOR»
		«ENDIF»
	'''

	private def generateActionCall(WhenBlock it, HttpServer java, boolean returnResponse) '''«generateActionCalls(action, dataDefinition, authorization, java, returnResponse)»'''

	private def objectMapperCall(DataDefinition it, Model model) '''
		objectMapper.readValue("«IF data !== null && data.members !== null»{" +
			"\"uuid\" : \"«IF uuid !== null»«uuid»«ELSE»" + this.randomUUID() + "«ENDIF»\"«FOR member : data.members.filter[!attribute.notReplayable] BEFORE stringLineBreak SEPARATOR stringLineBreak»\"«member.attribute.name»\" : «member.value.valueFrom»«ENDFOR»} «ELSE»{}«ENDIF»",
		«model.dataNameWithPackage».class)
		
	'''
	

	private def generateActionCalls(HttpServerAce it, DataDefinition dataDefinition, Authorization authorization,
		HttpServer java, boolean returnResponse) '''
		
		«IF returnResponse»return «ENDIF»
		«IF getType == "POST"»
			«packageFor».ActionCalls.call«getName.toFirstUpper»(«dataDefinition.objectMapperCall(model)», DROPWIZARD.getLocalPort()«IF isAuthorize && authorization !== null», authorization("«authorization.username»", "«authorization.password»")«ELSEIF isAuthorize», null«ENDIF»);
		«ELSEIF getType == "PUT"»
			«packageFor».ActionCalls.call«getName.toFirstUpper»(«dataDefinition.objectMapperCall(model)», DROPWIZARD.getLocalPort()«IF isAuthorize && authorization !== null», authorization("«authorization.username»", "«authorization.password»")«ELSEIF isAuthorize», null«ENDIF»);
		«ELSEIF getType == "DELETE"»
			«packageFor».ActionCalls.call«getName.toFirstUpper»(«dataDefinition.objectMapperCall(model)», DROPWIZARD.getLocalPort()«IF isAuthorize && authorization !== null», authorization("«authorization.username»", "«authorization.password»")«ELSEIF isAuthorize», null«ENDIF»);
		«ELSE»
			«packageFor».ActionCalls.call«getName.toFirstUpper»(«dataDefinition.objectMapperCall(model)», DROPWIZARD.getLocalPort()«IF isAuthorize && authorization !== null», authorization("«authorization.username»", "«authorization.password»")«ELSEIF isAuthorize», null«ENDIF»);
		«ENDIF»
		
	'''

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
		import java.util.UUID;
		
		public abstract class BaseScenario extends AbstractBaseScenario {
		
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
				LOG.info("*********************************************************************************");
				LOG.info("********   " + this.scenarioName());
				LOG.info("*********************************************************************************");
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
			protected String randomString() {
				return UUID.randomUUID().toString().substring(0, 8);
			}
		
			@Override
			protected String randomUUID() {
				return UUID.randomUUID().toString();
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

			@Override
			protected void assertIsNotNull(Object actual) {
				throw new RuntimeException("BaseScenario.assertIsNotNull not implemented");
			}

			@Override
			protected void assertFail(String message) {
				org.junit.Assert.fail(message);
			}
		}
		
	'''

	def generateAbstractBaseScenario() '''
		«copyright»
		
		package de.acegen;
		
		import com.fasterxml.jackson.databind.ObjectMapper;
		
		public abstract class AbstractBaseScenario {
		
			protected final JodaObjectMapper mapper = new JodaObjectMapper();
		
			protected DaoProvider daoProvider;
		
			protected PersistenceHandle handle;
			
			protected ObjectMapper objectMapper;
			
			public AbstractBaseScenario() {
				objectMapper = new ObjectMapper();
			}
		
			protected abstract String randomString();
			
			protected abstract String randomUUID();

			protected abstract String authorization(String username, String password);
		
			protected abstract void assertThat(int actual, int expected);
		
			protected abstract void assertThat(Object actual, Object expected);
		
			protected abstract void assertIsNull(Object actual);

			protected abstract void assertIsNotNull(Object actual);
		
			protected abstract void assertFail(String message);
		
			protected abstract String scenarioName();

		}
		
		
		«sdg»
		
	'''

}
