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

		const { Builder} = require('selenium-webdriver');
		const chrome = require('selenium-webdriver/chrome');

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
			
			createDriver: function() {
				return new Builder()
					.forBrowser(ScenarioUtils.browserName)
					.build();
			}	
			
		}
		
		«sdg»


	'''
	
	def generateScenario(ClientScenario it, HttpClient httpClient) '''
		«copyright»
		
		const ScenarioUtils = require("../../src/ScenarioUtils");
		«FOR referencedHttpClient: allReferencedHttpClients»
			const «referencedHttpClient.actionIdName»  = require("../../gen/actionIds/«referencedHttpClient.name»/«referencedHttpClient.actionIdName»");
		«ENDFOR»
		«IF allVerifications.size > 0»
			const Verifications = require("../../src/«httpClient.name»/«name»Verifications");
		«ENDIF»
		
		jasmine.DEFAULT_TIMEOUT_INTERVAL = ScenarioUtils.defaultTimeout;

		const testId = ScenarioUtils.generateTestId();
		
		let driver;
		
		let appStates = {};
		let verifications = {};
		    
		describe("«httpClient.name».«name»", function () {
		    beforeAll(async function () {
		    	driver = ScenarioUtils.createDriver();
		    	let appState;
				«FOR givenRef: allGivenItems»
					«FOR whenThenItem: givenRef.scenario.clientWhenThen»
						«whenThenItem.whenBlock.initSquishyData»
						await ScenarioUtils.invokeAction(driver, «(whenThenItem.whenBlock.action.eContainer as HttpClient).actionIdName».«whenThenItem.whenBlock.action.getName.toFirstLower»«FOR arg: whenThenItem.whenBlock.inputValues BEFORE ', [' SEPARATOR ',' AFTER ']'»«arg.value.primitiveValueFrom»«ENDFOR»);
						«IF whenThenItem.delayInMillis > 0»
							await ScenarioUtils.waitInMillis(«whenThenItem.delayInMillis»);
						«ENDIF»
					«ENDFOR»
				«ENDFOR»

				«FOR whenThenItem: clientWhenThen»
					«IF whenThenItem.whenBlock !== null»
						«whenThenItem.whenBlock.initSquishyData»
						await ScenarioUtils.invokeAction(driver, «(whenThenItem.whenBlock.action.eContainer as HttpClient).actionIdName».«whenThenItem.whenBlock.action.getName.toFirstLower»«FOR arg: whenThenItem.whenBlock.inputValues BEFORE ', [' SEPARATOR ',' AFTER ']'»«arg.value.primitiveValueFrom»«ENDFOR»);
						await ScenarioUtils.waitInMillis(10);
						«IF whenThenItem.delayInMillis > 0»
							await ScenarioUtils.waitInMillis(«whenThenItem.delayInMillis»);
						«ENDIF»
					«ELSEIF whenThenItem.delayInMillis > 0»
						await ScenarioUtils.waitInMillis(«whenThenItem.delayInMillis»);
					«ENDIF»
					
					«IF whenThenItem.thenBlock !== null && whenThenItem.thenBlock.stateVerifications !== null»
						appState = await ScenarioUtils.getAppState(driver);
						«FOR stateVerification: whenThenItem.thenBlock.stateVerifications»
							appStates.«stateVerification.name» = appState;
						«ENDFOR»
						
					«ENDIF»
					«IF whenThenItem.thenBlock !== null && whenThenItem.thenBlock.verifications !== null»
						«FOR verification: whenThenItem.thenBlock.verifications»
							verifications.«verification» = await Verifications.«verification»(driver, testId);
						«ENDFOR»
						
					«ENDIF»
				«ENDFOR»
		    });

			«FOR whenThenItem: clientWhenThen»
				«IF whenThenItem.thenBlock !== null && whenThenItem.thenBlock.stateVerifications !== null»
					«FOR stateVerification: whenThenItem.thenBlock.stateVerifications»
						it("«stateVerification.name»", async () => {
							expect(appStates.«stateVerification.name».«stateVerification.stateRef.stateRefPath», "«stateVerification.name»")«IF stateVerification.not == true».not«ENDIF».toEqual(«stateVerification.value.valueFrom»)
						});
					«ENDFOR»
				«ENDIF»
				
				«IF whenThenItem.thenBlock !== null && whenThenItem.thenBlock.verifications !== null»
					«FOR verification: whenThenItem.thenBlock.verifications»
						it("«verification»", async () => {
							expect(verifications.«verification», "verifications.«verification»").toBeTrue();
						});
					«ENDFOR»
				«ENDIF»
			«ENDFOR»

		    afterAll(async function () {
		        await ScenarioUtils.tearDown(driver);
		    });
		    
		    
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
			if (given.excludeGiven) {
				allWhenBlocks.add(given)
			} else if (given instanceof ClientGivenRef) {
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
			«FOR verification: allVerifications SEPARATOR ","»
				«verification»: async function(driver, testId) {
					fail("«verification» not implemented");
				}
			«ENDFOR»
		}
		
		«sdg»
	'''
	
}