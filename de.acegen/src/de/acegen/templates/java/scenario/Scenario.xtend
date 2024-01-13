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
import de.acegen.aceGen.BooleanType
import de.acegen.aceGen.Count
import de.acegen.aceGen.CustomCall
import de.acegen.aceGen.Given
import de.acegen.aceGen.GivenRef
import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerAce
import de.acegen.aceGen.JsonArray
import de.acegen.aceGen.JsonDateTime
import de.acegen.aceGen.JsonObjectAce
import de.acegen.aceGen.JsonValue
import de.acegen.aceGen.LongType
import de.acegen.aceGen.Model
import de.acegen.aceGen.NullType
import de.acegen.aceGen.PrimitiveValue
import de.acegen.aceGen.SelectByPrimaryKeys
import de.acegen.aceGen.SelectByUniqueAttribute
import de.acegen.aceGen.StringType
import de.acegen.aceGen.WhenBlock
import de.acegen.aceGen.WhenThen
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.java.AttributeExtension
import de.acegen.extensions.java.TypeExtension
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.ArrayList
import java.util.List
import javax.inject.Inject

class Scenario {

	@Inject
	extension TypeExtension

	@Inject
	extension AttributeExtension

	@Inject
	extension CommonExtension

	int index;

	private def void resetIndex() {
		index = 0;
	}

	private def void incIndex() {
		index += 1;
	}
	
	String stringLineBreak = '''," + 
"'''
	

	def generateScenario(de.acegen.aceGen.Scenario it, HttpServer java) '''
		«copyright»
		«resetIndex»
		
		package «java.getName».scenarios;
		
		«FOR whenThenItem : whenThen»
			«IF whenThenItem.whenBlock.action.response.size > 0» import «whenThenItem.whenBlock.action.responseDataNameWithPackage»;«ENDIF»
		«ENDFOR»
		
		public class «name»Scenario extends Abstract«name»Scenario {
		
			«FOR whenThenItem : whenThen»
				«FOR verification : whenThenItem.thenBlock.verifications»
					@Override
					protected void «verification.name»(«IF whenThenItem.whenBlock.action.response.size > 0»«whenThenItem.whenBlock.action.responseDataNameWithPackage» response«ENDIF») {
						assertFail("«verification.name» not implemented");
						LOG.info("THEN: «verification.name» passed");
					}
				«ENDFOR»
			«ENDFOR»
			
		
		}
		
		
		«sdg»
		
	'''

	def generateAbstractScenario(de.acegen.aceGen.Scenario it, HttpServer java) '''
		«copyright»
		
		package «java.getName».scenarios;
		
		import java.util.Map;
		import java.util.HashMap;
		import java.net.URLEncoder;
		import java.nio.charset.StandardCharsets;
		
		import java.time.LocalDateTime;
		import java.time.format.DateTimeFormatter;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import de.acegen.BaseScenario;
		import de.acegen.HttpResponse;
		import de.acegen.Data;
		
		import com.fasterxml.jackson.core.type.TypeReference;
		
		@SuppressWarnings("unused")
		public abstract class Abstract«name»Scenario extends BaseScenario {
		
			static final Logger LOG = LoggerFactory.getLogger(Abstract«name»Scenario.class);
			
			private void given() throws Exception {
				String uuid;
				
				«resetIndex»
				«FOR given : allGivenItems»
					«given.givenItem(java)»

				«ENDFOR»
			}
			
			«var index = 0»
			«FOR whenThenItem : whenThen»
				«whenThenItem.whenThenBlock(index++, java)»
			«ENDFOR»
					
			@Override
			public void runTest() throws Exception {
				given();
				
				if (prerequisite("«name»")) {
					«var testIndex = 0»
					«FOR whenThenItem: whenThen»
						«whenThenItem.whenThenTestBlock(it, java, testIndex++)»
					«ENDFOR»
				
				} else {
					LOG.info("WHEN: prerequisite for «name» not met");
				}
				
					
			}
			
			«FOR whenThenItem: whenThen»
				«FOR verification : whenThenItem.thenBlock.verifications»
					protected abstract void «verification.name»(«IF whenThenItem.whenBlock.action.response.size > 0»«whenThenItem.whenBlock.action.responseDataNameWithPackage» response«ENDIF»);
				«ENDFOR»
				
				«FOR persistenceVerification : whenThenItem.thenBlock.persistenceVerifications»
					private void «persistenceVerification.name»() throws Exception {
						«persistenceVerification.expression.persistenceVerification(persistenceVerification.model)»
					
						LOG.info("THEN: «persistenceVerification.name» passed");
					}
				«ENDFOR»
			«ENDFOR»
				
			@Override
			protected String scenarioName() {
				return "«name»";
			}
			
		}
		
		«sdg»

	'''
	
	private def whenThenTestBlock(WhenThen it, de.acegen.aceGen.Scenario scenario, HttpServer java, int index) '''
	
		HttpResponse<«IF whenBlock.action.response.size > 0»«whenBlock.action.responseDataNameWithPackage»«ELSE»Object«ENDIF»> response_«index» = when_«index»();
		«IF whenBlock.action.response.size > 0»«whenBlock.action.responseDataNameWithPackage» actualResponse_«index» = «ENDIF»then_«index»(response_«index»);
		«FOR persistenceVerification : thenBlock.persistenceVerifications»
			this.«persistenceVerification.name»();
		«ENDFOR»
		«FOR verification : thenBlock.verifications»
			«verification.name»(«IF whenBlock.action.response.size > 0»actualResponse_«index»«ENDIF»);
		«ENDFOR»
		
	'''
	
	private def whenThenBlock(WhenThen it, int index, HttpServer java) '''
		private HttpResponse<«IF whenBlock.action.response.size > 0»«whenBlock.action.responseDataNameWithPackage»«ELSE»Object«ENDIF»> when_«index»() throws Exception {
			«resetIndex»
			String uuid = «IF whenBlock.dataDefinition.uuid !== null»"«whenBlock.dataDefinition.uuid.valueFromString»"«ELSE»this.randomUUID()«ENDIF»;
			«whenBlock.generatePrepare»
			«whenBlock.generateDataCreation»
			HttpResponse<«IF whenBlock.action.response.size > 0»«whenBlock.action.responseDataNameWithPackage»«ELSE»Object«ENDIF»> response = «whenBlock.generateActionCalls(java)»
			LOG.info("WHEN: «whenBlock.action.name» finished in {} ms", response.getDuration());
			if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
				addToMetrics("«whenBlock.action.name»", response.getDuration());
			}
			return response;
		}
		
		private «IF whenBlock.action.response.size > 0»«whenBlock.action.responseDataNameWithPackage»«ELSE»void«ENDIF» then_«index»(HttpResponse<«IF whenBlock.action.response.size > 0»«whenBlock.action.responseDataNameWithPackage»«ELSE»Object«ENDIF»> response) throws Exception {
			if (response.getStatusCode() == 500) {
				String statusMessage = response.getStatusMessage() != null ? response.getStatusMessage() : "";
				String errorMessage = "status " + response.getStatusCode() + " failed: " + statusMessage;
				LOG.error("THEN: " + errorMessage);
				assertFail(errorMessage);
			}
			«IF thenBlock.statusCode !== 0»
				if (response.getStatusCode() != «thenBlock.statusCode») {
					String statusMessage = response.getStatusMessage() != null ? response.getStatusMessage() : "";
					String errorMessage = "status " + response.getStatusCode() + " failed, expected «thenBlock.statusCode»: " + statusMessage;
					LOG.error("THEN: " + errorMessage);
					assertFail(errorMessage);
				} else {
					LOG.info("THEN: status «thenBlock.statusCode» passed");
				}
			«ENDIF»
			
			«IF whenBlock.action.response.size > 0»
				«whenBlock.action.responseDataNameWithPackage» actual = null;
				if (response.getStatusCode() < 400) {
					try {
						actual = response.getEntity();
						
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
						«whenBlock.action.model.modelClassNameWithPackage» expectedData = «thenBlock.response.data.objectMapperCallExpectedData(whenBlock.action.model)»;
						
						«whenBlock.action.responseDataNameWithPackage» expected = new «whenBlock.action.responseDataNameWithPackage»(expectedData);
						
						assertThat(actual, expected);
						
						LOG.info("THEN: response passed");
					«ENDIF»
				}

				return actual;
			«ENDIF»
		}
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
		«IF times > 0»
			for (int i=0; i<«times»; i++) {
				this.«customCallName»(«FOR value : values SEPARATOR ', '»«value.primitiveValueFrom»«ENDFOR»);
			}
			«incIndex»
		«ELSE»
			this.«customCallName»(«FOR value : values SEPARATOR ', '»«value.primitiveValueFrom»«ENDFOR»);
			«incIndex»
		«ENDIF»
	'''

	private def givenBlock(GivenRef givenRef, HttpServer java, boolean forLoop) '''
		«FOR whenThenItem: givenRef.scenario.whenThen»
			if (prerequisite("«givenRef.scenario.name»")) {
				uuid = «IF whenThenItem.whenBlock.dataDefinition.uuid !== null»"«whenThenItem.whenBlock.dataDefinition.uuid.valueFromString»"«ELSE»this.randomUUID()«ENDIF»;
				«whenThenItem.whenBlock.generatePrepare»
				«whenThenItem.whenBlock.generateDataCreation»
				HttpResponse<«IF whenThenItem.whenBlock.action.response.size > 0»«whenThenItem.whenBlock.action.responseDataNameWithPackage»«ELSE»Object«ENDIF»> response_«index» = «whenThenItem.whenBlock.generateActionCalls(java)»
				if (response_«index».getStatusCode() >= 400) {
					String statusMessage = response_«index».getStatusMessage() != null ? response_«index».getStatusMessage() : "";
					String message = "GIVEN «givenRef.scenario.name» fails\n" + statusMessage;
					LOG.error("GIVEN: «givenRef.scenario.name» fails due to {} in {} ms", message, response_«index».getDuration());
					assertFail(message);
				}
				LOG.info("GIVEN: «givenRef.scenario.name» success in {} ms", response_«index».getDuration());
				addToMetrics("«whenThenItem.whenBlock.action.name»", response_«index».getDuration());
				«IF whenThenItem.whenBlock.extractions.size > 0 && whenThenItem.whenBlock.action.response.size > 0»
					«whenThenItem.whenBlock.action.responseDataNameWithPackage» responseEntity_«index» = null;
					try {
						«FOR extraction: whenThenItem.whenBlock.extractions»
							
							Object «extraction.name» = this.extract«extraction.name.toFirstUpper»(response_«index».getEntity());
							extractedValues.put("«extraction.name»«IF forLoop»_" + i«ELSE»"«ENDIF», «extraction.name»);
							LOG.info("GIVEN: extracted " + «extraction.name».toString()  + " as «extraction.name»«IF forLoop»_" + i«ELSE»"«ENDIF»);
						«ENDFOR»
					} catch (Exception x) {
						LOG.error("GIVEN: failed to extract values from response ", x);
					}
				«ENDIF»
			} else {
				LOG.info("GIVEN: prerequisite for «givenRef.scenario.name» not met");
			}
		«ENDFOR»
	'''

	private dispatch def persistenceVerification(SelectByUniqueAttribute it, Model model) '''
		«model.modelClassNameWithPackage» actual = daoProvider.get«model.modelDao»().selectBy«attributeAndValue.attribute.name.toFirstUpper»(handle, «attributeAndValue.value.primitiveValueFrom»);
		
		«IF expected.object !== null»
			«model.modelClassNameWithPackage» expected = «expected.object.objectMapperCallExpectedPersistenceData(model)»;
			assertThat(actual, expected);
		«ELSEIF expected.isNull»
			assertIsNull(actual);
		«ELSEIF expected.isNotNull»
			assertIsNotNull(actual);
		«ENDIF»
	'''

	private dispatch def persistenceVerification(SelectByPrimaryKeys it, Model model) '''
		«model.modelClassNameWithPackage» actual = daoProvider.get«model.modelDao»().selectByPrimaryKey(handle, «FOR attribute : model.allPrimaryKeyAttributes SEPARATOR ', '»«attribute.findForPrimaryKey(attributeAndValues).value.primitiveValueFrom»«ENDFOR»);
		
		«IF expected.object !== null»
			«model.modelClassNameWithPackage» expected = «expected.object.objectMapperCallExpectedPersistenceData(model)»;
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
			this.callSquishyDataProviderPutSystemTime(uuid, LocalDateTime.parse("«dataDefinition.systemtime»", DateTimeFormatter.ofPattern("«dataDefinition.pattern»")));
		«ENDIF»
		«IF dataDefinition !== null && dataDefinition.data !== null && dataDefinition.data instanceof JsonObjectAce && (dataDefinition.data as JsonObjectAce).members !== null»
			«FOR attributeDefinition: (dataDefinition.data as JsonObjectAce).members»
				«IF attributeDefinition.attribute.squishy»
					this.callSquishyDataProviderPutValue(uuid, "«attributeDefinition.attribute.name»",	"«attributeDefinition.value.squishyValueFrom»");
				«ENDIF»
			«ENDFOR»
		«ENDIF»
	'''

	private def generateDataCreation(WhenBlock it) '''
		«IF action.payload.size > 0»
			«action.payloadDataNameWithPackage» payload_«index» = «dataDefinition.data.objectMapperCallPayload(action)»;
		«ENDIF»
		«action.model.modelClassNameWithPackage» model_«index» = «dataDefinition.data.objectMapperCall(action.model)»;
		«action.model.dataWithGenericModel» data_«index» = new «action.model.dataWithGenericModel»(uuid);
		data_«index».setModel(model_«index»);
	'''

	private dispatch def objectMapperCall(JsonObjectAce it, Model model) '''
 		objectMapper.readValue("«IF it !== null && it.members !== null»{" +
 			"«FOR member : it.members.filter[!attribute.squishy] SEPARATOR stringLineBreak»\"«member.attribute.name»\" : «member.value.valueFrom»«ENDFOR»} «ELSE»{ }«ENDIF»", «model.modelClassNameWithPackage».class)'''

	private dispatch def objectMapperCall(StringType it, Model model) '''
 		objectMapper.readValue("«string.valueFrom»", «model.modelClassNameWithPackage».class)'''

	private dispatch def objectMapperCall(Void it, Model model) '''new «model.modelClassNameWithPackage»()'''

	private dispatch def objectMapperCallPayload(JsonObjectAce it, HttpServerAce action) '''
 		objectMapper.readValue("«IF it !== null && it.members !== null && it.members.filter[!attribute.squishy].size > 0»{" +
 			"«FOR member : it.members.filter[!attribute.squishy] SEPARATOR stringLineBreak»\"«member.attribute.name»\" : «member.value.valueFrom»«ENDFOR»} «ELSE»{}«ENDIF»",
		«action.payloadDataNameWithPackage».class)'''
	
	private dispatch def objectMapperCallPayload(StringType it, HttpServerAce action) '''
 		objectMapper.readValue("«string.valueFrom»",
		«action.payloadDataNameWithPackage».class)'''
	
	private dispatch def objectMapperCallPayload(Void it, HttpServerAce action) '''
		objectMapper.readValue("{}",
		«action.payloadDataNameWithPackage».class)'''
	
	private dispatch def objectMapperCallExpectedData(JsonObjectAce it, Model model) '''
		objectMapper.readValue("«IF it !== null && members !== null»{" +
			"«FOR member : members.filter[!attribute.squishy] SEPARATOR stringLineBreak»\"«member.attribute.name»\" : «member.value.valueFrom»«ENDFOR»} «ELSE»{}«ENDIF»", «model.modelClassNameWithPackage».class)'''
	
	private dispatch def objectMapperCallExpectedData(StringType it, Model model) '''
		objectMapper.readValue("«string.valueFrom»", new TypeReference<Data<«model.modelClassNameWithPackage»>>() {})'''
	
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
				"«action.urlWithPathParams('''data_«index».getModel()''', false)»", 
			 	«IF action.payload.size > 0»payload_«index»«ELSE»null«ENDIF»,
				«IF action.isAuthorize && authorization !== null»authorization("«authorization.username»", "«authorization.password»")«ELSE»null«ENDIF»,
				uuid,
				«IF action.response.size > 0»«action.responseDataNameWithPackage».class«ELSE»null«ENDIF»
			);
		«ELSEIF action.getType == "PUT"»
			this.httpPut(
				"«action.urlWithPathParams('''data_«index».getModel()''', true)»", 
			 	«IF action.payload.size > 0»payload_«index»«ELSE»null«ENDIF»,
				«IF action.isAuthorize && authorization !== null»authorization("«authorization.username»", "«authorization.password»")«ELSE»null«ENDIF»,
				uuid,
				«IF action.response.size > 0»«action.responseDataNameWithPackage».class«ELSE»null«ENDIF»
			);
		«ELSEIF action.getType == "DELETE"»
			this.httpDelete(
				"«action.urlWithPathParams('''data_«index».getModel()''', true)»", 
				«IF action.isAuthorize && authorization !== null»authorization("«authorization.username»", "«authorization.password»")«ELSE»null«ENDIF»,
				uuid,
				«IF action.response.size > 0»«action.responseDataNameWithPackage».class«ELSE»null«ENDIF»
			);
		«ELSE»
			this.httpGet(
				"«action.urlWithPathParams('''data_«index».getModel()''', true)»", 
				«IF action.isAuthorize && authorization !== null»authorization("«authorization.username»", "«authorization.password»")«ELSE»null«ENDIF»,
				uuid,
				«IF action.response.size > 0»«action.responseDataNameWithPackage».class«ELSE»null«ENDIF»
			);
		«ENDIF»
		
	'''
	
	private def String urlWithPathParams(HttpServerAce it, String dataVarName, boolean generateQueryParams) {
		if (pathParams.size == 0) {
			var retUrl = url +
				'''«IF generateQueryParams»«FOR queryParam : queryParams BEFORE "?" SEPARATOR "&"»«queryParam.attribute.name»=" + «IF queryParam.attribute.type == "String"»«urlEncodedValue('''«dataVarName».«queryParam.attribute.getterName»()''')»«ELSE»«dataVarName».«queryParam.attribute.getterName»()«ENDIF» + "«ENDFOR»«ENDIF»'''
			return retUrl
		}
		val split1 = getUrl.split('\\{')
		var urlElements = new ArrayList();
		for (split : split1) {
			val split2 = split.split('\\}');
			urlElements.addAll(split2)
		}
		var urlWithPathParam = "";
		for (var i = 0; i < urlElements.size; i++) {
			if (i % 2 == 0) {
				urlWithPathParam += urlElements.get(i)
			} else {
				urlWithPathParam +=
					'''" + «urlEncodedValue('''«dataVarName».get«urlElements.get(i).toFirstUpper»()''')» + "'''
			}
		}
		urlWithPathParam +=
			'''«IF generateQueryParams»«FOR queryParam : queryParams BEFORE "?" SEPARATOR "&"»«queryParam.attribute.name»=" + «urlEncodedValue('''«dataVarName».«queryParam.attribute.getterName»()''')» + "«ENDFOR»«ENDIF»'''
		return urlWithPathParam;
	}

	private def String urlEncodedValue(
		String valueVar) '''(«valueVar» != null ? URLEncoder.encode(«valueVar», StandardCharsets.UTF_8.toString()) : "")'''
	

	private def primitiveValueFrom(PrimitiveValue it) {
		if (string !== null) {
			var returnString = string;
			if (string.contains("${testId}")) {
				returnString = returnString.replace("${testId}", '''" + this.getTestId() + "''');
			} else if (string.contains("${")) {
				val beginIndex = string.indexOf("${")
				val endIndex = string.indexOf("}")
				val templateString = string.substring(beginIndex, endIndex + 1)
				val templateStringName = string.substring(beginIndex + 2, endIndex)
				returnString = returnString.replace(
					templateString, '''" + this.extractedValues.get("«templateStringName»").toString() + "''');
			}
			return '''"«returnString»"''';
		}
		if (isMinus) {
			return getLong() * (-1)
		}
		return getLong()
	}
	
	private def LocalDateTime dateTimeParse(String dateString, String pattern) {
		try {
			return LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern(pattern));
		} catch (Exception x) {
			return null;
		}
	}

	private def dispatch CharSequence valueFrom(
		JsonObjectAce it) '''«IF it !== null && members !== null && members.size > 0»{ «FOR member : members SEPARATOR stringLineBreak»\"«member.attribute.name»\" : «member.value.valueFrom()»«ENDFOR»}«ELSE»{}«ENDIF»'''

	private def dispatch CharSequence valueFrom(String it) {
		return valueFromString
	}

	private def dispatch CharSequence valueFrom(JsonValue it) {
		if (it instanceof StringType) {
			return '''\"«string.valueFromString»\"''';
		} else if (it instanceof BooleanType) {
			return boolean;
		} else if (it instanceof NullType) {
			return "null";
		} else if (it instanceof LongType) {
			return '''«IF minus»-«ENDIF»«long»''';
		}
	}

	private def dispatch CharSequence squishyValueFrom(
		JsonObjectAce it) '''null'''

	private def dispatch CharSequence squishyValueFrom(String it) {
		return valueFromString
	}

	private def dispatch CharSequence squishyValueFrom(JsonValue it) {
		if (it instanceof StringType) {
			return '''«string.valueFromString»''';
		} else if (it instanceof BooleanType) {
			return boolean;
		} else if (it instanceof NullType) {
			return "null";
		} else if (it instanceof LongType) {
			return '''«long»''';
		}
	}

	private def CharSequence valueFromString(String it) {
		var returnString = it;
		if (it.contains("${random}")) {
			returnString = returnString.replace("${random}", '''" + this.randomString() + "''');
		}
		if (it.contains("${testId}")) {
			returnString = returnString.replace("${testId}", '''" + this.getTestId() + "''');
		}
		while (returnString.contains("${")) {
			val beginIndex = returnString.indexOf("${")
			val endIndex = returnString.indexOf("}")
			val templateString = returnString.substring(beginIndex, endIndex + 1)
			val templateStringName = returnString.substring(beginIndex + 2, endIndex)

			returnString = returnString.replace(
				templateString, '''" + this.extractedValues.get("«templateStringName»").toString() + "''');
		}
		return '''«returnString»''';
	}

	private def dispatch CharSequence valueFrom(
		JsonArray it) '''«IF it !== null && values !== null && values.size > 0»[ «FOR value : values SEPARATOR stringLineBreak»«value.valueFrom»«ENDFOR»]«ELSE»[]«ENDIF»'''

	private def dispatch CharSequence valueFrom(JsonDateTime it) {
		if (dateTime.contains("${")) {
			val beginIndex = dateTime.indexOf("${")
			val endIndex = dateTime.indexOf("}")
			val templateStringName = dateTime.substring(beginIndex + 2, endIndex)
			return '''\"" + LocalDateTime.parse(this.extractedValues.get("«templateStringName»").toString(), DateTimeFormatter.ofPattern("«pattern»"))  + "\"''';
		}
		return '''\"«dateTimeParse(dateTime, pattern)»\"'''
	}

	

}
