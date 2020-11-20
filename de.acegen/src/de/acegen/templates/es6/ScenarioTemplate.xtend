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

	def generateScenario(ClientScenario it) '''
		«copyright»
		
		import * as ScenarioUtils from "../../../acegen/src/ScenarioUtils";
		import AppUtils from "../../../../es6/src/app/AppUtils";
		«FOR httpClient: allReferencedHttpClients»
			import * as «httpClient.actionIdName» from "../../../acegen/gen/«httpClient.name»/«httpClient.actionIdName»";
		«ENDFOR»
		
		const testId = ScenarioUtils.testId();
		
		context('«name»', () => {
		    beforeEach(() => {
		    	«FOR givenRef: allGivenItems»
		    		«givenRef.scenario.whenBlock.initNonDeterministicData»
		    		ScenarioUtils.getCypressFor(«(givenRef.scenario.whenBlock.action.eContainer as HttpClient).actionIdName».«givenRef.scenario.whenBlock.action.getName.toFirstLower», «FOR arg: givenRef.scenario.whenBlock.inputValues BEFORE '[' SEPARATOR ',' AFTER ']'»«arg.value.primitiveValueFrom»«ENDFOR»)
		    		ScenarioUtils.wait(«givenRef.scenario.whenBlock.action.numberOfSyncCalls()», «givenRef.scenario.whenBlock.action.numberOfAsyncCalls()»)
		    	«ENDFOR»
		    })
		
		    it('should change appState', () => {
		    	«whenBlock.initNonDeterministicData»
		    	ScenarioUtils.getCypressFor(«(whenBlock.action.eContainer as HttpClient).actionIdName».«whenBlock.action.getName.toFirstLower», «FOR arg: whenBlock.inputValues BEFORE '[' SEPARATOR ',' AFTER ']'»«arg.value.primitiveValueFrom»«ENDFOR»).should(() => {
		    		ScenarioUtils.wait(«whenBlock.action.numberOfSyncCalls()», «whenBlock.action.numberOfAsyncCalls()»).should(() => {
			            const appState = JSON.parse(localStorage.getItem('appState'))
			            «FOR stateVerification: thenBlock.stateVerifications»
			            	expect(appState.«stateVerification.stateRef.name», "«stateVerification.name»").to.eql(«stateVerification.value.valueFrom»)
			            «ENDFOR»
		    		})
		        })
		    })
		})
		
		
		«sdg»
		
		
	'''
	
	private def initNonDeterministicData(ClientWhenBlock it) '''
    	«IF uuid !== null»
    		localStorage.setItem("uuid", `«uuid»`)
    		«IF serverSystemTime !== null»
    			AppUtils.httpPut(`/api/test/non-deterministic/system-time?uuid=«uuid»&system-time=${new Date('«serverSystemTime»').toISOString()}`)
    		«ENDIF»
    	«ENDIF»
    	«IF clientSystemTime !== null»
    		localStorage.setItem("clientSystemTime", "«clientSystemTime»")
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
	
}