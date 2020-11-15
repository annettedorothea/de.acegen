package de.acegen.templates.es6

import de.acegen.aceGen.ClientScenario
import de.acegen.aceGen.HttpClient
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.es6.Es6Extension
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
		
		import * as ScenarioUtils from "../../src/ScenarioUtils";
		«FOR httpClient: allReferencedHttpClients»
			import * as «httpClient.actionIdName» from "../«httpClient.name»/«httpClient.actionIdName»";
		«ENDFOR»
		
		const testId = ScenarioUtils.testId();
		
		context('«name»', () => {
		    beforeEach(() => {
		    	«FOR givenRef: givenRefs»
		    		ScenarioUtils.getCypressFor(«(givenRef.scenario.whenBlock.action.eContainer as HttpClient).actionIdName».«givenRef.scenario.whenBlock.action.getName.toFirstLower», «FOR arg: givenRef.scenario.whenBlock.inputValues BEFORE '[' SEPARATOR ',' AFTER ']'»«arg.value.primitiveValueFrom»«ENDFOR»)
		    	«ENDFOR»
		    	
		    	«IF whenBlock.uuid !== null»
		    		localStorage.setItem("uuid", "whenBlock.uuid")
		    	«ENDIF»
		    })
		
		    it('should change appState', () => {
		    	ScenarioUtils.getCypressFor(«(whenBlock.action.eContainer as HttpClient).actionIdName».«whenBlock.action.getName.toFirstLower», «FOR arg: whenBlock.inputValues BEFORE '[' SEPARATOR ',' AFTER ']'»«arg.value.primitiveValueFrom»«ENDFOR»).should(() => {
		    		ScenarioUtils.wait(500).should(() => {
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
	
}