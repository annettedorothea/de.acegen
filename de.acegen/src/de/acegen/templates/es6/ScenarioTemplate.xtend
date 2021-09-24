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

		module.exports = {
			tearDown: async function(driver) {
				await driver.quit();
			},

			invokeAction: async function(driver, action, args) {
				throw "invokeAction not implemented";
			},
			
			waitInMillis: async function(millis) {
				return new Promise(function(resolve){
					setTimeout(resolve,millis);
				});
			},
			
			getAppState: async function(driver) {
				return await driver.executeScript('return appName.getAppState()');
			},
			
			generateTestId: function() {
			    let d = new Date().getTime();
			    return 'xxxxxxxx'.replace(/[xy]/g, function (c) {
			        let r = (d + Math.random() * 16) % 16 | 0;
			        d = Math.floor(d / 16);
			        return (c === 'x' ? r : (r & 0x3 | 0x8)).toString(16);
			    });
			},
				
			addSquishyValueClient: async function(driver, value) {
				const jsonValue = JSON.stringify(value);
				await driver.executeScript(`appName.addSquishyValueClient('${jsonValue}')`);
			},
		
			addSquishyValueServer: async function(driver, uuid, key, value) {
				await driver.executeScript(`appName.addSquishyValueServer("${uuid}", "${key}", "${value}")`);
			},

			defaultTimeout: 30 * 1000,
			
			browserName: "firefox"
			//browserName: "chrome"
			
		}
		
		«sdg»


	'''
	
	def generateScenario(ClientScenario it, HttpClient httpClient) '''
		«copyright»
		
		const ScenarioUtils = require("../../src/ScenarioUtils");
		«FOR referencedHttpClient: allReferencedHttpClients»
			const «referencedHttpClient.actionIdName»  = require("../../gen/actionIds/«referencedHttpClient.name»/«referencedHttpClient.actionIdName»");
		«ENDFOR»
		«IF thenBlock.verifications.size > 0»
			const Verifications = require("../../src/«httpClient.name»/«name»Verifications");
		«ENDIF»
		const { Builder } = require('selenium-webdriver');
		
		jasmine.DEFAULT_TIMEOUT_INTERVAL = ScenarioUtils.defaultTimeout;

		const testId = ScenarioUtils.generateTestId();
		
		let driver;
		
		let appState;
		    
		describe("«httpClient.name».«name»", function () {
		    beforeAll(async function () {
		    	driver = new Builder()
		    			    .forBrowser(ScenarioUtils.browserName)
		    			    .build();
				«FOR givenRef: allGivenItems»
					«givenRef.scenario.whenBlock.initSquishyData»
					await ScenarioUtils.invokeAction(driver, «(givenRef.scenario.whenBlock.action.eContainer as HttpClient).actionIdName».«givenRef.scenario.whenBlock.action.getName.toFirstLower»«FOR arg: givenRef.scenario.whenBlock.inputValues BEFORE ', [' SEPARATOR ',' AFTER ']'»«arg.value.primitiveValueFrom»«ENDFOR»);
					«IF givenRef.scenario.delayInMillis > 0»
						await ScenarioUtils.waitInMillis(«givenRef.scenario.delayInMillis»);
					«ENDIF»
				«ENDFOR»

				«IF whenBlock !== null»
					«whenBlock.initSquishyData»
					await ScenarioUtils.invokeAction(driver, «(whenBlock.action.eContainer as HttpClient).actionIdName».«whenBlock.action.getName.toFirstLower»«FOR arg: whenBlock.inputValues BEFORE ', [' SEPARATOR ',' AFTER ']'»«arg.value.primitiveValueFrom»«ENDFOR»);
					«IF delayInMillis > 0»
						await ScenarioUtils.waitInMillis(«delayInMillis»);
					«ENDIF»
				«ELSEIF delayInMillis > 0»
					await ScenarioUtils.waitInMillis(«delayInMillis»);
				«ENDIF»
				
				appState = await ScenarioUtils.getAppState(driver);
		    });

		    afterAll(async function () {
		        await ScenarioUtils.tearDown(driver);
		    });
		    
			«FOR stateVerification: thenBlock.stateVerifications»
				it("«stateVerification.name»", async () => {
					expect(appState.«stateVerification.stateRef.stateRefPath», "«stateVerification.name»")«IF stateVerification.not == true».not«ENDIF».toEqual(«stateVerification.value.valueFrom»)
				});
			«ENDFOR»
		    
			«FOR verification: thenBlock.verifications»
				it("«verification»", async () => {
					await Verifications.«verification»(driver, testId);
				});
	        «ENDFOR»
		    
		});
		
		
		
		«sdg»
		
		
	'''
	
	private def initSquishyData(ClientWhenBlock it) '''
		«IF squishyValues !== null && squishyValues.size > 0»
			«FOR squishyValue: squishyValues»
				await ScenarioUtils.addSquishyValueClient(
					driver,
					{
						uuid: `«squishyValue.uuid»`«IF squishyValue.clientSystemTime !== null»,
						clientSystemTime: `«squishyValue.clientSystemTime»`«ENDIF»
					}
				);
				«IF squishyValue.serverSystemTime !== null»
					await ScenarioUtils.addSquishyValueServer(driver, `«squishyValue.uuid»`, "system-time", new Date('«squishyValue.serverSystemTime»').toISOString());
				«ENDIF»
				«IF squishyValue.attribute !== null»
					await ScenarioUtils.addSquishyValueServer(driver, `«squishyValue.uuid»`, "«squishyValue.attribute.name.toFirstLower»", `«squishyValue.value.primitiveParamFrom»`);
				«ENDIF»
			«ENDFOR»
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
		
		module.exports = {
			«FOR verification: thenBlock.verifications SEPARATOR ","»
				«verification»: async function(driver, testId) {
					fail("«verification» not implemented");
				}
			«ENDFOR»
		}
		
		«sdg»
	'''
	
}