package de.acegen.templates.java.scenario

import de.acegen.aceGen.Attribute
import de.acegen.aceGen.AttributeAndValue
import de.acegen.aceGen.Count
import de.acegen.aceGen.DataDefinition
import de.acegen.aceGen.GivenRef
import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.JsonObject
import de.acegen.aceGen.Model
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

class Scenario {

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

	def generateScenario(de.acegen.aceGen.Scenario it, HttpServer java) '''
		«copyright»
		«resetIndex»
		
		package «java.getName».scenarios;
		
		import «whenBlock.action.responseDataNameWithPackage(whenBlock.action.eContainer as HttpServer)»;
		import javax.ws.rs.core.Response;
		
		@SuppressWarnings("unused")
		public class «name»Scenario extends Abstract«name»Scenario {
		
			«FOR verification : thenBlock.verifications»
				@Override
				protected void «verification.name»(«whenBlock.action.responseDataNameWithPackage(whenBlock.action.eContainer as HttpServer)» response) {
					assertFail("«verification.name» not implemented");
					LOG.info("THEN: «verification.name» passed");
				}
			«ENDFOR»
			
		
		}
		
		
		«sdg»
		
	'''

	def generateAbstractScenario(de.acegen.aceGen.Scenario it, HttpServer java) '''
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
			
			private Map<String, Object> extractedValues = new HashMap<String, Object>();
			
			private void given() throws Exception {
				Response response;
				String uuid;
				long timeBeforeRequest;
				long timeAfterRequest;
				«resetIndex»
				«FOR givenRef : allGivenRefs»
					«IF givenRef.times > 0»
						for (int i=0; i<«givenRef.times»; i++) {
							«givenRef.givenBlock(java, true)»
						}
						«incIndex»
							
					«ELSE»
						«incIndex»
						«givenRef.givenBlock(java, false)»
						
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
			
			private «whenBlock.action.responseDataNameWithPackage(whenBlock.action.eContainer as HttpServer)» then(Response response) throws Exception {
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
				
				«whenBlock.action.responseDataNameWithPackage(whenBlock.action.eContainer as HttpServer)» actual = null;
				try {
					actual = response.readEntity(«whenBlock.action.responseDataNameWithPackage(whenBlock.action.eContainer as HttpServer)».class);
					
					«IF whenBlock.extractions.size > 0»
						try {
							«FOR extraction: whenBlock.extractions»
								
								Object «extraction.name» = this.extract«extraction.name.toFirstUpper»(actual);
								extractedValues.put("«extraction.name»", «extraction.name»);
								LOG.info("THEN: extracted " + «extraction.name».toString()  + " as «extraction.name»");
							«ENDFOR»
						} catch (Exception x) {
							LOG.info("THEN: failed to extract values from response ", x);
						}
					«ENDIF»
				} catch (Exception x) {
				}
				«IF thenBlock.response !== null»
					«whenBlock.action.model.dataNameWithPackage» expectedData = «objectMapperCallExpectedData(thenBlock.response, whenBlock.action.model)»;
					
					«whenBlock.action.responseDataNameWithPackage(whenBlock.action.eContainer as HttpServer)» expected = new «whenBlock.action.responseDataNameWithPackage(whenBlock.action.eContainer as HttpServer)»(expectedData);


					assertThat(actual, expected);
					
					LOG.info("THEN: response passed");
				«ENDIF»
				
				return actual;
			}
					
			@Override
			public void runTest() throws Exception {
				given();
					
				if (prerequisite("«name»")) {
					Response response = when();

					«whenBlock.action.responseDataNameWithPackage(whenBlock.action.eContainer as HttpServer)» actualResponse = then(response);
					
					«FOR persistenceVerification : thenBlock.persistenceVerifications»
						this.«persistenceVerification.name»();
					«ENDFOR»
				
					«FOR verification : thenBlock.verifications»
						«verification.name»(actualResponse);
					«ENDFOR»
				} else {
					LOG.info("WHEN: prerequisite for «name» not met");
				}
			}
			
			«FOR verification : thenBlock.verifications»
				protected abstract void «verification.name»(«whenBlock.action.responseDataNameWithPackage(whenBlock.action.eContainer as HttpServer)» response);
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
	
	private def givenBlock(GivenRef givenRef, HttpServer java, boolean forLoop) '''
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
			«IF givenRef.scenario.whenBlock.extractions.size > 0»
				«givenRef.scenario.whenBlock.action.responseDataNameWithPackage(givenRef.scenario.whenBlock.action.eContainer as HttpServer)» responseEntity_«index» = null;
				try {
					responseEntity_«index» = response.readEntity(«givenRef.scenario.whenBlock.action.responseDataNameWithPackage(givenRef.scenario.whenBlock.action.eContainer as HttpServer)».class);
					«FOR extraction: givenRef.scenario.whenBlock.extractions»
						
						Object «extraction.name» = this.extract«extraction.name.toFirstUpper»(responseEntity_«index»);
						extractedValues.put("«extraction.name»«IF forLoop»_" + i«ELSE»"«ENDIF», «extraction.name»);
						LOG.info("GIVEN: extracted " + «extraction.name».toString()  + " as «extraction.name»«IF forLoop»_" + i«ELSE»"«ENDIF»);
					«ENDFOR»
				} catch (Exception x) {
					LOG.info("GIVEN: failed to extract values from response ", x);
				}
			«ENDIF»
		} else {
			LOG.info("GIVEN: prerequisite for «givenRef.scenario.name» not met");
		}
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
	
	private def allGivenRefs(de.acegen.aceGen.Scenario it) {
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

	
}