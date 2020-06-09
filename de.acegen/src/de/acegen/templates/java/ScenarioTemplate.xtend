package de.acegen.templates.java

import de.acegen.aceGen.Attribute
import de.acegen.aceGen.AttributeAndValue
import de.acegen.aceGen.Count
import de.acegen.aceGen.DataDefinition
import de.acegen.aceGen.GivenRef
import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.JsonObject
import de.acegen.aceGen.Model
import de.acegen.aceGen.Scenario
import de.acegen.aceGen.SelectByPrimaryKeys
import de.acegen.aceGen.SelectByUniqueAttribute
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
	
	int index;
	
	private def void resetIndex() {
		index = 0;
	}

	private def void incIndex() {
		index += 1;
	}

	def generateScenario(Scenario it, HttpServer java) '''
		«copyright»
		«resetIndex»
		
		package «java.getName».scenarios;
		
		«IF whenBlock.action.isRead»
			import «whenBlock.action.responseDataNameWithPackage(whenBlock.action.eContainer as HttpServer)»;
			import javax.ws.rs.core.Response;
		«ENDIF»
		
		@SuppressWarnings("unused")
		public class «name»Scenario extends Abstract«name»Scenario {
		
			«FOR verification : thenBlock.verifications»
				@Override
				protected void «verification»(«IF whenBlock.action.isRead»«whenBlock.action.responseDataNameWithPackage(whenBlock.action.eContainer as HttpServer)» response«ENDIF») {
					assertFail("«verification» not implemented");
					LOG.info("THEN: «verification» passed");
				}
			«ENDFOR»
			
		
		}
		
		
		«sdg»
		
	'''

	def generateAbstractScenario(Scenario it, HttpServer java) '''
		«copyright»
		
		package «java.getName».scenarios;
		
		import java.util.ArrayList;
		import java.util.Arrays;
		import java.util.List;
		import java.util.Map;
		import java.util.HashMap;
		
		import javax.ws.rs.core.Response;
		
		import java.time.LocalDateTime;
		import java.time.format.DateTimeFormatter;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import de.acegen.BaseScenario;
		import de.acegen.ITimelineItem;
		import de.acegen.NotReplayableDataProvider;
		
		@SuppressWarnings("unused")
		public abstract class Abstract«name»Scenario extends BaseScenario {
		
			static final Logger LOG = LoggerFactory.getLogger(Abstract«name»Scenario.class);
			
			private void given() throws Exception {
				Response response;
				String uuid;
				long timeBeforeRequest;
				long timeAfterRequest;
				«resetIndex»
				«FOR givenRef : allGivenRefs»
					«IF givenRef.times > 0»
						for (int i=0; i<«givenRef.times»; i++) {
							if (prerequisite("«givenRef.scenario.name»")) {
								uuid = «IF givenRef.scenario.whenBlock.dataDefinition.uuid !== null»"«givenRef.scenario.whenBlock.dataDefinition.uuid.valueFromString»"«ELSE»this.randomUUID()«ENDIF»;
								«givenRef.scenario.whenBlock.generatePrepare»
								«givenRef.scenario.whenBlock.generateDataCreation()»
								timeBeforeRequest = System.currentTimeMillis();
								response = «givenRef.scenario.whenBlock.generateActionCalls(java)»
								timeAfterRequest = System.currentTimeMillis();
								if (response.getStatus() >= 400) {
									String message = "GIVEN «givenRef.scenario.name» fails\n" + response.readEntity(String.class);
									LOG.info("GIVEN: «givenRef.scenario.name» fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
									addToMetrics("«givenRef.scenario.whenBlock.action.name»", (timeAfterRequest-timeBeforeRequest));
									assertFail(message);
								}
								LOG.info("GIVEN: «givenRef.scenario.name» success in {} ms", (timeAfterRequest-timeBeforeRequest));
								addToMetrics("«givenRef.scenario.whenBlock.action.name»", (timeAfterRequest-timeBeforeRequest));
							} else {
								LOG.info("GIVEN: prerequisite for «givenRef.scenario.name» not met");
							}
						}
						«incIndex»
							
					«ELSE»
						«incIndex»
						if (prerequisite("«givenRef.scenario.name»")) {
							uuid = «IF givenRef.scenario.whenBlock.dataDefinition.uuid !== null»"«givenRef.scenario.whenBlock.dataDefinition.uuid.valueFromString»"«ELSE»this.randomUUID()«ENDIF»;
							«givenRef.scenario.whenBlock.generatePrepare»
							«givenRef.scenario.whenBlock.generateDataCreation()»
							timeBeforeRequest = System.currentTimeMillis();
							response = «givenRef.scenario.whenBlock.generateActionCalls(java)»
							timeAfterRequest = System.currentTimeMillis();
							if (response.getStatus() >= 400) {
								String message = "GIVEN «givenRef.scenario.name» fails\n" + response.readEntity(String.class);
								LOG.info("GIVEN: «givenRef.scenario.name» fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
								addToMetrics("«givenRef.scenario.whenBlock.action.name»", (timeAfterRequest-timeBeforeRequest));
								assertFail(message);
							}
							LOG.info("GIVEN: «givenRef.scenario.name» success in {} ms", (timeAfterRequest-timeBeforeRequest));
							addToMetrics("«givenRef.scenario.whenBlock.action.name»", (timeAfterRequest-timeBeforeRequest));
						} else {
							LOG.info("GIVEN: prerequisite for «givenRef.scenario.name» not met");
						}
						
					«ENDIF»

			«ENDFOR»
			}
			
			private Response when() throws Exception {
				«resetIndex»
				String uuid = «IF whenBlock.dataDefinition.uuid !== null»"«whenBlock.dataDefinition.uuid.valueFromString»"«ELSE»this.randomUUID()«ENDIF»;
				«whenBlock.generatePrepare»
				«whenBlock.generateDataCreation()»
				long timeBeforeRequest = System.currentTimeMillis();
				Response response = «whenBlock.generateActionCalls(java)»
				long timeAfterRequest = System.currentTimeMillis();
				LOG.info("WHEN: «whenBlock.action.name» finished in {} ms", (timeAfterRequest-timeBeforeRequest));
				addToMetrics("«whenBlock.action.name»", (timeAfterRequest-timeBeforeRequest));
				return response;
			}
			
			private «IF whenBlock.action.isRead»«whenBlock.action.responseDataNameWithPackage(whenBlock.action.eContainer as HttpServer)»«ELSE»void«ENDIF» then(Response response) throws Exception {
				if (response.getStatus() == 500) {
					String message = response.readEntity(String.class);
					assertFail(message);
				}
				«IF thenBlock.statusCode !== 0»
					if (response.getStatus() != «thenBlock.statusCode») {
						String message = response.readEntity(String.class);
						assertFail(message);
					} else {
						LOG.info("THEN: status «thenBlock.statusCode» passed");
					}
				«ENDIF»
				
				«IF whenBlock.action.isRead»
					«whenBlock.action.responseDataNameWithPackage(whenBlock.action.eContainer as HttpServer)» actual = null;
					try {
						actual = response.readEntity(«whenBlock.action.responseDataNameWithPackage(whenBlock.action.eContainer as HttpServer)».class);
					} catch (Exception x) {
					}
				«ENDIF»
				«IF thenBlock.response !== null»
					«whenBlock.action.model.dataNameWithPackage» expectedData = «objectMapperCallExpectedData(thenBlock.response, whenBlock.action.model)»;
					
					«whenBlock.action.responseDataNameWithPackage(whenBlock.action.eContainer as HttpServer)» expected = new «whenBlock.action.responseDataNameWithPackage(whenBlock.action.eContainer as HttpServer)»(expectedData);


					assertThat(actual, expected);
					
					LOG.info("THEN: response passed");
				«ENDIF»
				
				«IF whenBlock.action.isRead»
					return actual;
				«ENDIF»
			}
					
			@Override
			public void runTest() throws Exception {
				given();
					
				if (prerequisite("«name»")) {
					Response response = when();

					«IF whenBlock.action.isRead»«whenBlock.action.responseDataNameWithPackage(whenBlock.action.eContainer as HttpServer)» actualResponse = «ENDIF»then(response);
					
					«FOR persistenceVerification : thenBlock.persistenceVerifications»
						this.«persistenceVerification.name»();
					«ENDFOR»
				
					«FOR verification : thenBlock.verifications»
						«verification.name»(«IF whenBlock.action.isRead»actualResponse«ENDIF»);
					«ENDFOR»
				} else {
					LOG.info("WHEN: prerequisite for «name» not met");
				}
			}
			
			«FOR verification : thenBlock.verifications»
				protected abstract void «verification.name»(«IF whenBlock.action.isRead»«whenBlock.action.responseDataNameWithPackage(whenBlock.action.eContainer as HttpServer)» response«ENDIF»);
			«ENDFOR»
			
			«FOR persistenceVerification : thenBlock.persistenceVerifications»
				private void «persistenceVerification.name»() throws Exception {
					«persistenceVerification.expression.persistenceVerification(persistenceVerification.model)»

					LOG.info("THEN: «persistenceVerification.name» passed");
				}
			«ENDFOR»
			
			@Override
			protected String scenarioName() {
				return "«name»";
			}
		
		}
		
		«sdg»
					
	'''
	
	private dispatch def persistenceVerification(SelectByUniqueAttribute it, Model model) '''
		«model.interfaceWithPackage» actual = daoProvider.get«model.modelDao»().selectBy«attributeAndValue.attribute.name.toFirstUpper»(handle, «attributeAndValue.value.primitiveValueFrom»);
		
		«IF expected.object !== null»
			«model.interfaceWithPackage» expected = «objectMapperCallExpectedPersistenceData(expected.object, model)»;
			assertThat(actual, expected);
		«ELSEIF expected.isNull»
			assertIsNull(actual);
		«ELSEIF expected.isNotNull»
			assertIsNotNull(actual);
		«ENDIF»
	'''
	
	private dispatch def persistenceVerification(SelectByPrimaryKeys it, Model model) '''
		«model.interfaceWithPackage» actual = daoProvider.get«model.modelDao»().selectByPrimaryKey(handle, «FOR attribute: model.allPrimaryKeyAttributes SEPARATOR ', '»«attribute.findForPrimaryKey(attributeAndValues).value.primitiveValueFrom»«ENDFOR»);
		
		«IF expected.object !== null»
			«model.interfaceWithPackage» expected = «objectMapperCallExpectedPersistenceData(expected.object, model)»;
			assertThat(actual, expected);
		«ELSEIF expected.isNull»
			assertIsNull(actual);
		«ELSEIF expected.isNotNull»
			assertIsNotNull(actual);
		«ENDIF»
	'''
	
	private dispatch def persistenceVerification(Count it, Model model) '''
		Map<String, String> filterMap = new HashMap<String, String>();
		«FOR attributeValue: attributeAndValues»
			filterMap.put("«attributeValue.attribute.name»", «attributeValue.value.primitiveValueFrom»);
		«ENDFOR»
		int actual = daoProvider.get«model.modelDao»().filterAndCountBy(handle, filterMap);
		
		assertThat(actual, «expected»);
	'''
	
	private def AttributeAndValue findForPrimaryKey(Attribute it, List<AttributeAndValue> list) {
		for(attributeAndValue: list) {
			if (attributeAndValue.attribute.name == name) {
				return attributeAndValue
			}
		}
		return null;
	}
	
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
			this.callNotReplayableDataProviderPutSystemTime(uuid, LocalDateTime.parse("«dataDefinition.systemtime»", DateTimeFormatter.ofPattern("«dataDefinition.pattern»")));
		«ENDIF»
		«IF dataDefinition !== null && dataDefinition.data !== null && dataDefinition.data.members !== null»
			«FOR attributeDefinition: dataDefinition.data.members»
				«IF attributeDefinition.attribute.notReplayable»
					this.callNotReplayableDataProviderPutValue(uuid, "«attributeDefinition.attribute.name»", 
								objectMapper.readValue("«attributeDefinition.value.valueFrom»", «IF attributeDefinition.attribute.model !== null» «attributeDefinition.attribute.model.dataNameWithPackage».class)«ELSEIF attributeDefinition.attribute.type !== null» «attributeDefinition.attribute.javaType».class)«ENDIF»);
				«ENDIF»
			«ENDFOR»
		«ENDIF»
	'''

	private def generateDataCreation(WhenBlock it) '''
		«action.model.dataNameWithPackage» data_«index» = «dataDefinition.objectMapperCall(action.model)»;
	'''

	private def objectMapperCall(DataDefinition it, Model model) '''
		objectMapper.readValue("«IF data !== null && data.members !== null»{" +
			"\"uuid\" : \"" + uuid + "\"«FOR member : data.members.filter[!attribute.notReplayable] BEFORE stringLineBreak SEPARATOR stringLineBreak»\"«member.attribute.name»\" : «member.value.valueFrom»«ENDFOR»} «ELSE»{ \"uuid\" : \"" + uuid + "\"}«ENDIF»",
		«model.dataNameWithPackage».class)'''
	
	private def objectMapperCallExpectedData(DataDefinition it, Model model) '''
		objectMapper.readValue("«IF data !== null && data.members !== null»{" +
			"\"uuid\" : \"«uuid»\"«FOR member : data.members.filter[!attribute.notReplayable] BEFORE stringLineBreak SEPARATOR stringLineBreak»\"«member.attribute.name»\" : «member.value.valueFrom»«ENDFOR»} «ELSE»{}«ENDIF»",
		«model.dataNameWithPackage».class)'''
	
	private def objectMapperCallExpectedPersistenceData(JsonObject it, Model model) '''
		objectMapper.readValue("«IF it !== null && it.members !== null»{" +
			"«FOR member : members SEPARATOR stringLineBreak»\"«member.attribute.name»\" : «member.value.valueFrom»«ENDFOR»} «ELSE»{}«ENDIF»",
		«model.modelClassNameWithPackage».class)'''
	
	private def generateActionCalls(WhenBlock it, HttpServer java) '''
		
		«IF action.getType == "POST"»
			this.httpPost(
				"«action.urlWithPathParams('''data_«index»''', false)»", 
				data_«index»,
				«IF action.isAuthorize && authorization !== null»authorization("«authorization.username»", "«authorization.password»")«ELSE»null«ENDIF»
			);
		«ELSEIF action.getType == "PUT"»
			this.httpPut(
				"«action.urlWithPathParams('''data_«index»''', true)»", 
				data_«index»,
				«IF action.isAuthorize && authorization !== null»authorization("«authorization.username»", "«authorization.password»")«ELSE»null«ENDIF»
			);
		«ELSEIF action.getType == "DELETE"»
			this.httpDelete(
				"«action.urlWithPathParams('''data_«index»''', true)»", 
				«IF action.isAuthorize && authorization !== null»authorization("«authorization.username»", "«authorization.password»")«ELSE»null«ENDIF»
			);
		«ELSE»
			this.httpGet(
				"«action.urlWithPathParams('''data_«index»''', true)»", 
				«IF action.isAuthorize && authorization !== null»authorization("«authorization.username»", "«authorization.password»")«ELSE»null«ENDIF»
			);
		«ENDIF»
		
	'''

	def generateBaseScenario() '''
		«copyright»
		
		package de.acegen;
		
		import static org.hamcrest.CoreMatchers.is;
		import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
		
		import java.io.File;
		import java.util.Base64;
		import java.util.UUID;
		
		import javax.ws.rs.client.Client;
		import javax.ws.rs.client.Entity;
		import javax.ws.rs.client.Invocation.Builder;
		import javax.ws.rs.core.Response;
		
		import org.glassfish.jersey.client.JerseyClientBuilder;
		import org.jdbi.v3.core.Jdbi;
		import java.time.LocalDateTime;
		import org.junit.jupiter.api.AfterAll;
		import org.junit.jupiter.api.AfterEach;
		import org.junit.jupiter.api.BeforeAll;
		import org.junit.jupiter.api.BeforeEach;
		import org.junit.jupiter.api.Test;
		import org.junit.platform.runner.JUnitPlatform;
		import org.junit.runner.RunWith;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import com.fasterxml.jackson.databind.DeserializationFeature;
		import com.fasterxml.jackson.databind.ObjectMapper;
		import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
		
		@RunWith(JUnitPlatform.class)
		public abstract class BaseScenario extends AbstractBaseScenario {
		
			static final Logger LOG = LoggerFactory.getLogger(BaseScenario.class);
		
			private static Jdbi jdbi;
		
			private static int port;
		
			private static String host = "localhost";
		
			private static String protocol;
		
			private static String rootPath;
		
			private String testId;
		
			public Client client;
		
			@BeforeAll
			public static void beforeClass() throws Exception {
				ObjectMapper mapper = new ObjectMapper(new YAMLFactory())
						.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				YamlConfiguration config = mapper.readValue(new File("test.yml"), YamlConfiguration.class);
				port = Integer.parseInt(config.getServer().getApplicationConnectors()[0].getPort());
				protocol = config.getServer().getApplicationConnectors()[0].getType();
				rootPath = config.getServer().getRootPath();
				jdbi = Jdbi.create(config.getDatabase().getUrl());
			}
		
			@AfterAll
			public static void afterClass() {
			}
		
			@BeforeEach
			public void before() {
				daoProvider = new DaoProvider();
				handle = new PersistenceHandle(jdbi.open());
				testId = randomString();
				client = new JerseyClientBuilder().build();
				LOG.info("testId {}", testId);
				LOG.info("*********************************************************************************");
				LOG.info("********   {} test id {}", this.scenarioName(), testId);
				LOG.info("*********************************************************************************");
			}
		
			@AfterEach
			public void after() {
				handle.getHandle().close();
			}
			
			@Test
			public void test() throws Exception {
				this.runTest();
			}
		
			private String buidlUrl(String path) {
				return String.format("%s://%s:%d%s%s", protocol, host, port, rootPath, path);
			}
		
			protected Response httpGet(String path, String authorization) {
				Builder builder = client.target(buidlUrl(path)).request();
				if (authorization != null) {
					builder.header("Authorization", authorization);
				}
				return builder.get();
			}
		
			protected Response httpPost(String path, Object data, String authorization) {
				Builder builder = client.target(buidlUrl(path)).request();
				if (authorization != null) {
					builder.header("Authorization", authorization);
				}
				return builder.post(Entity.json(data));
			}
		
			protected Response httpPut(String path, Object data, String authorization) {
				Builder builder = client.target(buidlUrl(path)).request();
				if (authorization != null) {
					builder.header("Authorization", authorization);
				}
				return builder.put(Entity.json(data));
			}
		
			protected Response httpDelete(String path, String authorization) {
				Builder builder = client.target(buidlUrl(path)).request();
				if (authorization != null) {
					builder.header("Authorization", authorization);
				}
				return builder.delete();
			}
		
			protected String randomString() {
				return randomUUID().replace("-", "").substring(0, 8);
			}
		
			@Override
			protected String randomUUID() {
				return UUID.randomUUID().toString();
			}
		
			@Override
			protected String authorization(String username, String password) {
				String string = username.replace("${testId}", testId) + ":" + password;
				String hash = Base64.getEncoder().encodeToString(string.getBytes());
				return "basic " + hash;
			}
		
			@Override
			protected void assertThat(int actual, int expected) {
				org.hamcrest.MatcherAssert.assertThat(actual, is(expected));
			}
		
			@Override
			protected void assertFail(String message) {
				org.junit.jupiter.api.Assertions.fail(message);
			}
		
			@Override
			protected void assertThat(Object actual, Object expected) {
				if (actual == null) {
					assertIsNull(expected);
				}
				org.hamcrest.MatcherAssert.assertThat(actual, is(samePropertyValuesAs(expected)));
			}
		
			@Override
			protected void assertIsNull(Object actual) {
				org.junit.jupiter.api.Assertions.assertNull(actual);
			}
		
			@Override
			protected void assertIsNotNull(Object actual) {
				org.junit.jupiter.api.Assertions.assertNotNull(actual);
			}
		
			@Override
			protected boolean prerequisite(String scenarioName) {
				return true;
			}
		
			@Override
			protected String getTestId() {
				return testId;
			}
		
			protected String replaceTestId(String string) {
				return string.replace("${testId}", testId);
			}
		
			@Override
			protected Response callNotReplayableDataProviderPutValue(
					String uuid, String key, Object data) {
				Client client = new JerseyClientBuilder().build();
				Builder builder = client
						.target(String.format("%s://%s:%d%s/test/not-replayable/value?uuid=" + uuid + "&key=" + key, protocol,
								host, port, rootPath))
						.request();
				return builder.put(Entity.json(data));
			}
		
			@Override
			protected Response callNotReplayableDataProviderPutSystemTime(
					String uuid, LocalDateTime dateTime) {
				Client client = new JerseyClientBuilder().build();
				Builder builder = client
						.target(String.format(
								"%s://%s:%d%s/test/not-replayable/system-time?uuid=" + uuid + "&system-time=" + dateTime,
								protocol, host, port, rootPath))
						.request();
				return builder.put(Entity.json(dateTime));
			}
		
		}
		
		«sdg»
		
		
	'''

	def generateAbstractBaseScenario() '''
		«copyright»
		
		package de.acegen;
		
		import com.fasterxml.jackson.databind.ObjectMapper;
		import javax.ws.rs.core.Response;
		import java.time.LocalDateTime;
		
		public abstract class AbstractBaseScenario {
		
			protected final JodaObjectMapper mapper = new JodaObjectMapper();
		
			protected DaoProvider daoProvider;
		
			protected PersistenceHandle handle;
			
			protected ObjectMapper objectMapper;
			
			public AbstractBaseScenario() {
				objectMapper = new ObjectMapper();
			}
		
			protected abstract void runTest() throws Exception;

			protected abstract Response httpGet(String path, String authorization);
			
			protected abstract Response httpPost(String path, Object data, String authorization);
			
			protected abstract Response httpPut(String path, Object data, String authorization);
			
			protected abstract Response httpDelete(String path, String authorization);
			
			protected abstract String randomString();
			
			protected abstract String randomUUID();

			protected abstract String authorization(String username, String password);
		
			protected abstract void assertThat(int actual, int expected);

			protected abstract void assertThat(Object actual, Object expected);
		
			protected abstract void assertIsNull(Object actual);

			protected abstract void assertIsNotNull(Object actual);
		
			protected abstract void assertFail(String message);
		
			protected abstract String scenarioName();
			
			protected abstract String getTestId();

			protected abstract boolean prerequisite(String scenarioName);
			
			protected abstract Response callNotReplayableDataProviderPutValue(
						String uuid, String key, Object data);
						
			protected abstract Response callNotReplayableDataProviderPutSystemTime(
						String uuid, LocalDateTime dateTime);
						
			protected abstract void addToMetrics(String action, Long duration);

		}
		
		
		«sdg»
		
	'''

}
