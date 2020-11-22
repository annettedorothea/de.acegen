package de.acegen.templates.es6

import de.acegen.aceGen.ClientGivenRef
import de.acegen.aceGen.ClientScenario
import de.acegen.aceGen.ClientWhenBlock
import de.acegen.aceGen.HttpClient
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.es6.Es6Extension
import java.util.ArrayList
import java.util.List
import javax.inject.Inject

class ScenarioTemplate {
	
	@Inject
	extension CommonExtension
	
	@Inject
	extension Es6Extension

	def generateScenarioUtils() '''
		«copyright»
		
		«sdg»
		
		
	'''

	def generateScenario(ClientScenario it, HttpClient httpClient) '''
		«copyright»
		
		import * as ScenarioUtils from "../../../acegen/src/ScenarioUtils";
		import AppUtils from "../../../../es6/src/app/AppUtils";
		«FOR referencedHttpClient: allReferencedHttpClients»
			import * as «referencedHttpClient.actionIdName» from "../../../acegen/gen/«referencedHttpClient.name»/«referencedHttpClient.actionIdName»";
		«ENDFOR»
		«IF thenBlock.verifications.size > 0»
			import * as Verifications from "../../../acegen/src/«httpClient.name»/«name»Verifications";
		«ENDIF»
		
		const testId = ScenarioUtils.testId();
		
		context('«name»', () => {
		    beforeEach(() => {
		    	let nonDeterministicValues;
		    	let nonDeterministicValue;
				«FOR givenRef: allGivenItems»
					«givenRef.scenario.whenBlock.initNonDeterministicData»
					ScenarioUtils.getCypressFor(«(givenRef.scenario.whenBlock.action.eContainer as HttpClient).actionIdName».«givenRef.scenario.whenBlock.action.getName.toFirstLower», «FOR arg: givenRef.scenario.whenBlock.inputValues BEFORE '[' SEPARATOR ',' AFTER ']'»«arg.value.primitiveValueFrom»«ENDFOR»).should(() => {
					ScenarioUtils.wait(«givenRef.scenario.whenBlock.action.numberOfSyncCalls()», «givenRef.scenario.whenBlock.action.numberOfAsyncCalls()»).should(() => {
				«ENDFOR»
				«FOR givenRef: allGivenItems»
					});
					});
				«ENDFOR»
		    })
		
		    it('«FOR stateVerification: thenBlock.stateVerifications SEPARATOR " "»«stateVerification.name»«ENDFOR» «FOR verification: thenBlock.verifications SEPARATOR " "»«verification»«ENDFOR»', () => {
				«IF whenBlock.nonDeterministicValues !== null && whenBlock.nonDeterministicValues.size > 0»
					let nonDeterministicValues;
					let nonDeterministicValue;
				«ENDIF»
		    	«whenBlock.initNonDeterministicData»
		    	
		    	ScenarioUtils.getCypressFor(«(whenBlock.action.eContainer as HttpClient).actionIdName».«whenBlock.action.getName.toFirstLower», «FOR arg: whenBlock.inputValues BEFORE '[' SEPARATOR ',' AFTER ']'»«arg.value.primitiveValueFrom»«ENDFOR»).should(() => {
		    		ScenarioUtils.wait(«whenBlock.action.numberOfSyncCalls()», «whenBlock.action.numberOfAsyncCalls()»).should(() => {
			            const appState = JSON.parse(localStorage.getItem('appState'))
			            «FOR stateVerification: thenBlock.stateVerifications»
			            	expect(appState.«stateVerification.stateRef.name», "«stateVerification.name»").to.eql(«stateVerification.value.valueFrom»)
			            «ENDFOR»
			            «FOR verification: thenBlock.verifications»
			            	Verifications.«verification»();
			            «ENDFOR»
		    		})
		        })
		    })
		})
		
		
		«sdg»
		
		
	'''
	
	private def initNonDeterministicData(ClientWhenBlock it) '''
		«IF nonDeterministicValues !== null && nonDeterministicValues.size > 0»
			nonDeterministicValues = JSON.parse(localStorage.getItem('nonDeterministicValues'));
			if (!nonDeterministicValues) {
				nonDeterministicValues = [];
			}
			«FOR nonDeterministicValue: nonDeterministicValues»
				nonDeterministicValue = {
					uuid: `«nonDeterministicValue.uuid»`«IF nonDeterministicValue.clientSystemTime !== null»,
					clientSystemTime: `«nonDeterministicValue.clientSystemTime»`«ENDIF»
				};
				nonDeterministicValues.push(nonDeterministicValue);
				«IF nonDeterministicValue.serverSystemTime !== null»
					AppUtils.httpPut(`/api/test/non-deterministic/system-time?uuid=«nonDeterministicValue.uuid»&system-time=${new Date('«nonDeterministicValue.serverSystemTime»').toISOString()}`)
				«ENDIF»
				«IF nonDeterministicValue.attribute !== null»
					AppUtils.httpPut(`/api/test/non-deterministic/value?uuid=«nonDeterministicValue.uuid»&«nonDeterministicValue.attribute.name.toFirstLower»=${«nonDeterministicValue.value.primitiveValueFrom»}`);
				«ENDIF»
			«ENDFOR»
			localStorage.setItem('nonDeterministicValues', JSON.stringify(nonDeterministicValues));
		«ENDIF»
	'''

	private def allGivenItems(ClientScenario it) {
		var allWhenBlocks = new ArrayList<ClientGivenRef>();
		for (given : givenRefs) {
			if (given instanceof ClientGivenRef) {
				allGivenItemsRec(given, allWhenBlocks)
			}
		}
		return allWhenBlocks
	}

	private def void allGivenItemsRec(ClientGivenRef it, List<ClientGivenRef> allWhenBlocks) {
		if (it instanceof ClientGivenRef) {
			for (given : it.scenario.givenRefs) {
				allGivenItemsRec(given, allWhenBlocks)
			}
		}
		allWhenBlocks.add(it)
	}
	
	def generateVerifications(ClientScenario it) '''
		«copyright»
		
		«FOR verification: thenBlock.verifications»
			export function «verification»() {
				assert.fail("«verification» not implemented");
			}
		«ENDFOR»
		
		«sdg»
	'''
	
}