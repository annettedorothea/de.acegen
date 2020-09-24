/********************************************************************************
 * Copyright (c) 2020 Annette Pohl
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 ********************************************************************************/


package de.acegen.templates.java.scenario

import de.acegen.aceGen.Attribute
import de.acegen.aceGen.AttributeAndValue
import de.acegen.aceGen.Count
import de.acegen.aceGen.CustomCall
import de.acegen.aceGen.DataDefinition
import de.acegen.aceGen.Given
import de.acegen.aceGen.GivenRef
import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerAce
import de.acegen.aceGen.JsonObjectAce
import de.acegen.aceGen.Model
import de.acegen.aceGen.SelectByPrimaryKeys
import de.acegen.aceGen.SelectByUniqueAttribute
import de.acegen.aceGen.StringType
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
		
		import «whenBlock.action.responseDataNameWithPackage»;
		import javax.ws.rs.core.Response;
		
		@SuppressWarnings("unused")
		public class «name»Scenario extends Abstract«name»Scenario {
		
			«FOR verification : thenBlock.verifications»
				@Override
				protected void «verification.name»(«IF whenBlock.action.response.size > 0»«whenBlock.action.responseDataNameWithPackage» response«ENDIF») {
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
		import de.acegen.NonDeterministicDataProvider;
		
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
				«FOR given : allGivenItems»
					«given.givenItem(java)»

				«ENDFOR»
			}
			
			private Response when() throws Exception {
				«resetIndex»
				String uuid = «IF whenBlock.dataDefinition.uuid !== null»"«whenBlock.dataDefinition.uuid.valueFromString»"«ELSE»this.randomUUID()«ENDIF»;
				«whenBlock.generatePrepare»
				«whenBlock.generateDataCreation»
				long timeBeforeRequest = System.currentTimeMillis();
				Response response = «whenBlock.generateActionCalls(java)»
				long timeAfterRequest = System.currentTimeMillis();
				LOG.info("WHEN: «whenBlock.action.name» finished in {} ms", (timeAfterRequest-timeBeforeRequest));
				addToMetrics("«whenBlock.action.name»", (timeAfterRequest-timeBeforeRequest));
				return response;
			}
			
			private «IF whenBlock.action.response.size > 0»«whenBlock.action.responseDataNameWithPackage»«ELSE»void«ENDIF» then(Response response) throws Exception {
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
				
				«IF whenBlock.action.response.size > 0»
					«whenBlock.action.responseDataNameWithPackage» actual = null;
					if (response.getStatus() < 400) {
						try {
							actual = response.readEntity(«whenBlock.action.responseDataNameWithPackage».class);
							
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
							LOG.error("THEN: failed to read response", x);
							assertFail(x.getMessage());
						}
	
						«IF thenBlock.response !== null»
							«whenBlock.action.model.dataNameWithPackage» expectedData = «thenBlock.response.data.objectMapperCallExpectedData(whenBlock.action.model)»;
							
							«whenBlock.action.responseDataNameWithPackage» expected = new «whenBlock.action.responseDataNameWithPackage»(expectedData);
							
							assertThat(actual, expected);
							
							LOG.info("THEN: response passed");
						«ENDIF»
					}

					return actual;
				«ENDIF»
			}
					
			@Override
			public void runTest() throws Exception {
				given();
					
				if (prerequisite("«name»")) {
					Response response = when();
		
					«IF whenBlock.action.response.size > 0»«whenBlock.action.responseDataNameWithPackage» actualResponse = «ENDIF»then(response);
					
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
				protected abstract void «verification.name»(«whenBlock.action.responseDataNameWithPackage» response);
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
	
	private def dispatch givenItem(GivenRef it, HttpServer java) '''
		«IF times > 0»
			for (int i=0; i<«times»; i++) {
				«givenBlock(java, true)»
			}
			«incIndex»
		«ELSE»
			«givenBlock(java, false)»
			«incIndex»
		«ENDIF»
	'''

	private def dispatch givenItem(CustomCall it, HttpServer java) '''
		this.«customCallName»(«FOR value : values SEPARATOR ', '»«value.primitiveValueFrom»«ENDFOR»);
	'''

	private def givenBlock(GivenRef givenRef, HttpServer java, boolean forLoop) '''
		if (prerequisite("«givenRef.scenario.name»")) {
			uuid = «IF givenRef.scenario.whenBlock.dataDefinition.uuid !== null»"«givenRef.scenario.whenBlock.dataDefinition.uuid.valueFromString»"«ELSE»this.randomUUID()«ENDIF»;
			«givenRef.scenario.whenBlock.generatePrepare»
			«givenRef.scenario.whenBlock.generateDataCreation»
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
			«IF givenRef.scenario.whenBlock.extractions.size > 0 && givenRef.scenario.whenBlock.action.response.size > 0»
				«givenRef.scenario.whenBlock.action.responseDataNameWithPackage» responseEntity_«index» = null;
				try {
					responseEntity_«index» = response.readEntity(«givenRef.scenario.whenBlock.action.responseDataNameWithPackage».class);
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
			«model.interfaceWithPackage» expected = «expected.object.objectMapperCallExpectedPersistenceData(model)»;
			assertThat(actual, expected);
		«ELSEIF expected.isNull»
			assertIsNull(actual);
		«ELSEIF expected.isNotNull»
			assertIsNotNull(actual);
		«ENDIF»
	'''

	private dispatch def persistenceVerification(SelectByPrimaryKeys it, Model model) '''
		«model.interfaceWithPackage» actual = daoProvider.get«model.modelDao»().selectByPrimaryKey(handle, «FOR attribute : model.allPrimaryKeyAttributes SEPARATOR ', '»«attribute.findForPrimaryKey(attributeAndValues).value.primitiveValueFrom»«ENDFOR»);
		
		«IF expected.object !== null»
			«model.interfaceWithPackage» expected = «expected.object.objectMapperCallExpectedPersistenceData(model)»;
			assertThat(actual, expected);
		«ELSEIF expected.isNull»
			assertIsNull(actual);
		«ELSEIF expected.isNotNull»
			assertIsNotNull(actual);
		«ENDIF»
	'''

	private dispatch def persistenceVerification(Count it, Model model) '''
		Map<String, String> filterMap = new HashMap<String, String>();
		«FOR attributeValue : attributeAndValues»
			filterMap.put("«attributeValue.attribute.name»", «attributeValue.value.primitiveValueFrom»);
		«ENDFOR»
		int actual = daoProvider.get«model.modelDao»().filterAndCountBy(handle, filterMap);
		
		assertThat(actual, «expected»);
	'''

	private def AttributeAndValue findForPrimaryKey(Attribute it, List<AttributeAndValue> list) {
		for (attributeAndValue : list) {
			if (attributeAndValue.attribute.name == name) {
				return attributeAndValue
			}
		}
		return null;
	}

	private def allGivenItems(de.acegen.aceGen.Scenario it) {
		var allWhenBlocks = new ArrayList<Given>();
		for (given : givenItems) {
			if (given instanceof GivenRef) {
				if (given.excludeGiven) {
					allWhenBlocks.add(given)
				} else {
					allGivenItemsRec(given, allWhenBlocks)
				}
			} else if (given instanceof CustomCall) {
				allWhenBlocks.add(given)
			}
		}
		return allWhenBlocks
	}

	private def void allGivenItemsRec(Given it, List<Given> allWhenBlocks) {
		if (it instanceof GivenRef) {
			if (!excludeGiven) {
				for (given : scenario.givenItems) {
					allGivenItemsRec(given, allWhenBlocks)
				}
			}
		}
		allWhenBlocks.add(it)
	}

	private def generatePrepare(WhenBlock it) '''
		«IF dataDefinition.systemtime !== null»
			this.callNonDeterministicDataProviderPutSystemTime(uuid, LocalDateTime.parse("«dataDefinition.systemtime»", DateTimeFormatter.ofPattern("«dataDefinition.pattern»")));
		«ENDIF»
		«IF dataDefinition !== null && dataDefinition.data !== null && dataDefinition.data instanceof JsonObjectAce && (dataDefinition.data as JsonObjectAce).members !== null»
			«FOR attributeDefinition: (dataDefinition.data as JsonObjectAce).members»
				«IF attributeDefinition.attribute.nonDeterministic»
					this.callNonDeterministicDataProviderPutValue(uuid, "«attributeDefinition.attribute.name»", 
								objectMapper.readValue("«attributeDefinition.value.valueFrom»", «IF attributeDefinition.attribute.model !== null» «attributeDefinition.attribute.model.dataNameWithPackage».class)«ELSEIF attributeDefinition.attribute.type !== null» «attributeDefinition.attribute.javaType».class)«ENDIF»);
				«ENDIF»
			«ENDFOR»
		«ENDIF»
	'''

	private def generateDataCreation(WhenBlock it) '''
		«IF action.payload.size > 0»
			«action.payloadDataNameWithPackage» payload_«index» = «dataDefinition.data.objectMapperCallPayload(action)»;
		«ENDIF»
		«action.model.dataNameWithPackage» data_«index» = «dataDefinition.data.objectMapperCall(action.model)»;
	'''

	private dispatch def objectMapperCall(JsonObjectAce it, Model model) '''
 		objectMapper.readValue("«IF it !== null && it.members !== null»{" +
 		"\"uuid\" : \"" + uuid + "\"«FOR member : it.members.filter[!attribute.nonDeterministic] BEFORE stringLineBreak SEPARATOR stringLineBreak»\"«member.attribute.name»\" : «member.value.valueFrom»«ENDFOR»} «ELSE»{ \"uuid\" : \"" + uuid + "\"}«ENDIF»",
		«model.dataNameWithPackage».class)'''

	private dispatch def objectMapperCall(StringType it, Model model) '''
 		objectMapper.readValue("«string.valueFrom»",
		«model.dataNameWithPackage».class)'''

	private dispatch def objectMapperCall(Void it, Model model) '''
		objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\" }",
		«model.dataNameWithPackage».class)'''

	private dispatch def objectMapperCallPayload(JsonObjectAce it, HttpServerAce action) '''
 		objectMapper.readValue("«IF it !== null && it.members !== null && it.members.filter[!attribute.nonDeterministic].size > 0»{" +
 			"«FOR member : it.members.filter[!attribute.nonDeterministic] SEPARATOR stringLineBreak»\"«member.attribute.name»\" : «member.value.valueFrom»«ENDFOR»} «ELSE»{}«ENDIF»",
		«action.payloadDataNameWithPackage».class)'''
	
	private dispatch def objectMapperCallPayload(StringType it, HttpServerAce action) '''
 		objectMapper.readValue("«string.valueFrom»",
		«action.payloadDataNameWithPackage».class)'''
	
	private dispatch def objectMapperCallPayload(Void it, HttpServerAce action) '''
		objectMapper.readValue("{}",
		«action.payloadDataNameWithPackage».class)'''
	
	private dispatch def objectMapperCallExpectedData(JsonObjectAce it, Model model) '''
		objectMapper.readValue("«IF it !== null && members !== null»{" +
			"\"uuid\" : \"«(eContainer as DataDefinition).uuid»\"«FOR member : members.filter[!attribute.nonDeterministic] BEFORE stringLineBreak SEPARATOR stringLineBreak»\"«member.attribute.name»\" : «member.value.valueFrom»«ENDFOR»} «ELSE»{}«ENDIF»",
		«model.dataNameWithPackage».class)'''
	
	private dispatch def objectMapperCallExpectedData(StringType it, Model model) '''
		objectMapper.readValue("«string.valueFrom»",
		«model.dataNameWithPackage».class)'''
	
	private dispatch def objectMapperCallExpectedPersistenceData(JsonObjectAce it, Model model) '''
		objectMapper.readValue("«IF it !== null && it.members !== null»{" +
			"«FOR member : members SEPARATOR stringLineBreak»\"«member.attribute.name»\" : «member.value.valueFrom»«ENDFOR»} «ELSE»{}«ENDIF»",
		«model.modelClassNameWithPackage».class)'''
		
	private dispatch def objectMapperCallExpectedPersistenceData(StringType it, Model model) '''
		objectMapper.readValue("«string.valueFrom»",
		«model.modelClassNameWithPackage».class)'''
		
	private dispatch def objectMapperCallExpectedPersistenceData(Void it, Model model) '''
		objectMapper.readValue("{}",
		«model.modelClassNameWithPackage».class)'''
		
	private def generateActionCalls(WhenBlock it, HttpServer java) '''
		
		«IF action.getType == "POST"»
			this.httpPost(
				"«action.urlWithPathParams('''data_«index»''', false)»", 
			 	«IF action.payload.size > 0»payload_«index»«ELSE»null«ENDIF»,
				«IF action.isAuthorize && authorization !== null»authorization("«authorization.username»", "«authorization.password»")«ELSE»null«ENDIF»,
				uuid
			);
		«ELSEIF action.getType == "PUT"»
			this.httpPut(
				"«action.urlWithPathParams('''data_«index»''', true)»", 
			 	«IF action.payload.size > 0»payload_«index»«ELSE»null«ENDIF»,
				«IF action.isAuthorize && authorization !== null»authorization("«authorization.username»", "«authorization.password»")«ELSE»null«ENDIF»,
				uuid
			);
		«ELSEIF action.getType == "DELETE"»
			this.httpDelete(
				"«action.urlWithPathParams('''data_«index»''', true)»", 
				«IF action.isAuthorize && authorization !== null»authorization("«authorization.username»", "«authorization.password»")«ELSE»null«ENDIF»,
				uuid
			);
		«ELSE»
			this.httpGet(
				"«action.urlWithPathParams('''data_«index»''', true)»", 
				«IF action.isAuthorize && authorization !== null»authorization("«authorization.username»", "«authorization.password»")«ELSE»null«ENDIF»,
				uuid
			);
		«ENDIF»
		
	'''

}
