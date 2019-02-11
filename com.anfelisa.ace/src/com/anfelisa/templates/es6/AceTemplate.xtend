package com.anfelisa.templates.es6

import com.anfelisa.ace.ES6_StateElement
import com.anfelisa.extensions.es6.Es6Extension
import javax.inject.Inject

class AceTemplate {
	@Inject
	extension Es6Extension
	
	def generateAppUtilsStub() '''
		import ACEController from "../../gen/ace/ACEController";
		import uuid from "uuid";
		
		export default class AppUtils {
		
		    static start() {
				AppUtils.loadSettings().then((settings) => {
				    AppUtils.settings = settings;
		    		// call initial action
				});
		    }
		    
			static loadSettings() {
			    return new Promise((resolve, reject) => {
			        const headers = new Headers();
			        headers.append("Content-Type", "application/json");
			        headers.append("Accept", "application/json");
			
			        const options = {
			            method: 'GET',
			            headers: headers,
			            mode: 'cors',
			            cache: 'no-cache'
			        };
			
			        const request = new Request("settings.json", options);
			
			        fetch(request).then(function (response) {
			            return response.json();
			        }).then(function (data) {
			                resolve(data);
			        }).catch(function (error) {
			            reject(error);
			        });
			    });
			}
		
		    static getClientVersion() {
				return AppUtils.settings.clientVersion;
		    }
		
		    static getAceScenariosApiKey() {
		        return AppUtils.settings.aceScenariosApiKey;
		    }
		
		    static getAceScenariosBaseUrl() {
		        return AppUtils.settings.aceScenariosBaseUrl;
		    }
		    
			static isDevelopment() {
			    return AppUtils.settings.development;
			}
			
			static createInitialAppState() {
				return {};
			}
			
		    static renderNewState() {
		        // render the new state
		        // you should get it from AppState
		    }
			
		
		    static httpGet(url, authorize, queryParams, commandData) {
				return new Promise((resolve, reject) => {
				    const headers = new Headers();
				    headers.append("Content-Type", "application/json");
				    headers.append("Accept", "application/json");
					if (authorize === true) {
					    let authorization = AppUtils.basicAuth();
					    if (authorization !== undefined) {
					        headers.append("Authorization", authorization);
					    }
					}
				
				    const options = {
				        method: 'GET',
				        headers: headers,
				        mode: 'cors',
				        cache: 'no-cache'
				    };
				
				    const completeUrl = url + AppUtils.queryParamString(url, queryParams);
				    const request = new Request(completeUrl, options);
				
					let status;
					let statusText;
					fetch(request).then(function (response) {
					    status = response.status;
					    statusText = response.statusText;
					    if (status >= 300) {
					        return response.text();
					    } else {
					        return response.json();
					    }
					}).then(function (data) {
					    if (status >= 300) {
					        const error = {
					            code: status,
					            text: statusText,
					            errorKey: data
					        };
					        reject(error);
					    } else {
					        resolve(data);
					    }
					}).catch(function (error) {
					    const status = {
					        code: error.name,
					        text: error.message
					    };
					    reject(status);
					});
				});
		    }
		
		    static httpChange(methodType, url, authorize, queryParams, data) {
				return new Promise((resolve, reject) => {
				    const headers = new Headers();
				    headers.append("Content-Type", "application/json");
				    headers.append("Accept", "application/json");
					if (authorize === true) {
					    let authorization = AppUtils.basicAuth();
					    if (authorization !== undefined) {
					        headers.append("Authorization", authorization);
					    }
					}
				
				    const options = {
				        method: methodType,
				        headers: headers,
				        mode: 'cors',
				        cache: 'no-cache',
				        body: JSON.stringify(data)
				    };
				
				    const completeUrl = url + AppUtils.queryParamString(url, queryParams);
				    const request = new Request(completeUrl, options);
				
					let status;
					let statusText;
					fetch(request).then(function (response) {
					    status = response.status;
					    statusText = response.statusText;
					    return response.text();
					}).then(function (data) {
					    if (status >= 300) {
					        const error = {
					            code: status,
					            text: statusText,
					            errorKey: data
					        };
					        reject(error);
					    } else {
					        resolve(data);
					    }
					}).catch(function (error) {
					    const status = {
					        code: error.name,
					        text: error.message
					    };
					    reject(status);
					});
				});
		    }
		
		    static httpPost(url, authorize, queryParams, data) {
		        return AppUtils.httpChange("POST", authorize, url, queryParams, data);
		    }
		
		    static httpPut(url, authorize, queryParams, data) {
		        return AppUtils.httpChange("PUT", authorize, url, queryParams, data);
		    }
		
		    static httpDelete(url, authorize, queryParams, data) {
		        return AppUtils.httpChange("DELETE", authorize, url, queryParams, data);
		    }
		
		    static queryParamString(url, queryParams) {
		        let queryString = "";
		        if (queryParams && queryParams.length > 0) {
		            for (let i = 0; i < queryParams.length; i++) {
		                if (url.indexOf('?') < 0 && i === 0) {
		                    queryString += '?'
		                } else {
		                    queryString += '&'
		                }
		                queryString += queryParams[i].key + "=" + queryParams[i].value;
		            }
		        }
		        return queryString;
		    }
		
			static basicAuth() {
				// implement your basic auth
			    return undefined;
			}

		    static createUUID() {
		        let d = new Date().getTime();
		        return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
		            var r = (d + Math.random() * 16) % 16 | 0;
		            d = Math.floor(d / 16);
		            return (c == 'x' ? r : (r & 0x3 | 0x8)).toString(16);
		        });
		    }
		
		    static displayUnexpectedError(error) {
		    }

			static deepCopy(object) {
			    return JSON.parse(JSON.stringify(object));
			}
			
			static getMaxTimelineSize() {
		        return 2000;
		    }
		    
			static getAppState() {
			    return {};
			}
		    
			static deepMerge(newState, appState) {
			    for (let property in newState) {
			        if (newState.hasOwnProperty(property)) {
			            if (appState[property] === undefined) {
			                appState[property] = newState[property];
			            } else if (newState[property] === undefined) {
			                appState[property] = undefined;
			            } else if (typeof newState[property] === 'object') {
			                AppUtils.deepMerge(newState[property], appState[property]);
			            } else {
			                appState[property] = newState[property];
			            }
			        }
			    }
			    return appState;
			}
			
			static merge(newState, appState) {
			    for (let property in newState) {
			        if (newState.hasOwnProperty(property)) {
			            appState[property] = newState[property];
			        }
			    }
			    return appState;
			}

		}
		
		/*       S.D.G.       */
		
	'''
	
	def generateAppStub() '''
		import AppUtils from "./AppUtils";
		
		export * from "../../gen/ace/Scenario";
		export * from "../../gen/ace/Bug";
		
		AppUtils.start();
		
		export function deepMergeState(newAppState) {
		    appState = AppUtils.deepMerge(newAppState, appState);
		}
		
		export function mergeState(newAppState) {
		    appState = AppUtils.merge(newAppState, appState);
		}
		
		// add EventListenerRegistration.init() of all modules
		// add ActionFactoryRegistrationTodo.init() of all modules
		
		/*       S.D.G.       */
		
	'''
	
	def generateReplayUtilsStub() '''
		export default class ReplayUtils {
		
		    static itemStringifyReplacer(key, value) {
		        if (key === 'timestamp') {
		            return undefined;
		        } else {
		            return value;
		        }
		    }

		    static compareItems(expected, actual) {
		    	// will return false if just the order of props is different
		    	// for a better result use https://www.npmjs.com/package/json-stable-stringify
		        return JSON.stringify(expected, ReplayUtils.itemStringifyReplacer) === JSON.stringify(actual, ReplayUtils.itemStringifyReplacer);
		    }
		    
		    static prepareReplay() {
		    }

		    static tearDownReplay() {
		    }

		}
		
		/*       S.D.G.       */
		
	'''
	
	def generateACEController() '''
		import AppUtils from "../../src/app/AppUtils";
		import Utils from "./Utils";
		
		export default class ACEController {
		
		    static init() {
		        ACEController.timeline = [];
		        ACEController.listeners = {};
		        ACEController.factories = {};
		        ACEController.registerListener('TriggerAction', ACEController.triggerAction);
		        ACEController.actionIsProcessing = false;
		        ACEController.actionQueue = [];
		        ACEController.LIVE = 1;
		        ACEController.REPLAY = 2;
		        ACEController.E2E = 3;
		        ACEController.execution = ACEController.LIVE;
		        ACEController.actualTimeline = [];
		        ACEController.expectedTimeline = [];
		    }
		
		    static registerListener(eventName, listener) {
		        if (!eventName.trim()) {
		            throw new Error('cannot register listener for empty eventName');
		        }
		        if (!listener) {
		            throw new Error('cannot register undefined listener for event ' + eventName);
		        }
		        let listenersForEventName;
		        if (ACEController.listeners[eventName] === undefined) {
		            ACEController.listeners[eventName] = [];
		        }
		        listenersForEventName = ACEController.listeners[eventName];
		        listenersForEventName.push(listener);
		    }
		
		    static registerFactory(actionName, factory) {
		        if (!actionName.trim()) {
		            throw new Error('cannot register factory for empty actionName');
		        }
		        if (!factory) {
		            throw new Error('cannot register undefined factory for action ' + actionName);
		        }
		        ACEController.factories[actionName] = factory;
		    }
		
		    static addItemToTimeLine(item) {
		        let timestamp = new Date();
		        item.timestamp = timestamp.getTime();
		        if (ACEController.execution === ACEController.LIVE) {
		            if (ACEController.timeline.length < AppUtils.getMaxTimelineSize()) {
						ACEController.timeline.push(AppUtils.deepCopy(item));
					} else {
						console.debug(`timeline size ${AppUtils.getMaxTimelineSize()} exceeded - item was not added`, item);
					}
		        } else {
		            ACEController.actualTimeline.push(AppUtils.deepCopy(item));
		        }
		    }
		
		    static addActionToQueue(action) {
		        if (ACEController.execution === ACEController.LIVE) {
		            ACEController.actionQueue.push(action);
		            if (ACEController.actionIsProcessing === false) {
		                ACEController.actionIsProcessing = true;
		                ACEController.applyNextActions();
		            }
		        }
		    }
		
		    static applyNextActions() {
		        let action = ACEController.actionQueue.shift();
		        if (action) {
					if (action.asynchronous) {
					    action.applyAction().then(() => {
					    	ACEController.callApplyNextActions();
					    }, (error) => {
					        AppUtils.displayUnexpectedError(error);
					    	ACEController.callApplyNextActions();
					    });
					} else {
						try {
							action.applyAction();
					    	ACEController.callApplyNextActions();
						} catch(error) {
					        AppUtils.displayUnexpectedError(error);
					    	ACEController.callApplyNextActions();
						}
					}
		        } else if (action === undefined) {
		            ACEController.actionIsProcessing = false;
		            if (ACEController.execution !== ACEController.LIVE) {
		                ACEController.timeline = [];
		                ACEController.actionIsProcessing = false;
		                ACEController.actionQueue = [];
		                ACEController.execution = ACEController.LIVE;
		                Utils.finishReplay();
		                AppUtils.start();
		            }
		        }
		    }
		    
		    static callApplyNextActions() {
		    	if (ACEController.execution === ACEController.LIVE) {
		    		ACEController.applyNextActions();
		    	} else {
					setTimeout(ACEController.applyNextActions, ACEController.pauseInMillis);
				}
		    }
		
		    static triggerAction(action) {
		        ACEController.addActionToQueue(action);
		    }
		
		    static startReplay(level, pauseInMillis) {
		        ACEController.actualTimeline = [];
		        ACEController.execution = level;
		        ACEController.pauseInMillis = pauseInMillis;
		        ACEController.readTimelineAndCreateReplayActions();
		    }
		
		    static readTimelineAndCreateReplayActions() {
		        let actions = [];
		        if (ACEController.expectedTimeline.length === 0) {
		            for (let i = 0; i < ACEController.timeline.length; i++) {
		                let item = ACEController.timeline[i];
		                ACEController.expectedTimeline.push(item);
		            }
		        }
		
		        for (let i = 0; i < ACEController.expectedTimeline.length; i++) {
		            let item = ACEController.expectedTimeline[i];
		            if (item.action) {
		                const actionData = item.action.actionData;
		                let action = ACEController.factories[item.action.actionName](actionData);
		                action.actionData = actionData;
		                actions.push(action);
		            }
		        }
		
		        ACEController.actionQueue = actions;
		
		        ACEController.applyNextActions();
		    }
		
		    static getCommandByUuid(uuid) {
		        for (let i = 0; i < ACEController.expectedTimeline.length; i++) {
		            let item = ACEController.expectedTimeline[i];
		            if (item.command && item.command.commandData.uuid === uuid) {
		                return item.command;
		            }
		        }
		    }
		
		}
		
		ACEController.init();
		
		/*       S.D.G.       */
		
	'''
	
	def generateScenario() '''
		import AppUtils from "../../src/app/AppUtils";
		import ReplayUtils from "../../src/app/ReplayUtils";
		import ACEController from "./ACEController";
		import Utils from "./Utils";
		
		export function runScenario(scenarioId, executor = "unknown", pauseInMillis = 0) {
		    if (AppUtils.isDevelopment() === false) {
		        console.error("runScenario is only available during development");
		    } else {
		        Utils.loadScenario(scenarioId).then((scenario) => {
		            ReplayUtils.scenarioConfig = {
		                executor,
		                scenarioId,
		                saveScenarioResult: true
		            };
		            ACEController.expectedTimeline = JSON.parse(scenario.timeline);
		            Utils.replayE2E(pauseInMillis, scenario.serverTimeline);
		        });
		    }
		}
		
		export function runAllScenarios(executor = "unknown", pauseInMillis = 0) {
		    if (AppUtils.isDevelopment() === false) {
		        console.error("runAllScenarios is only available during development");
		    } else {
		        Utils.loadNextScenario(null).then((scenario) => {
		            if (scenario) {
		                ReplayUtils.scenarioConfig = {
		                    executor,
		                    scenarioId: scenario.id,
		                    saveScenarioResult: true,
		                    runAllScenarios: true,
		                    pauseInMillis
		                };
		                ACEController.expectedTimeline = JSON.parse(scenario.timeline);
		                Utils.replayE2E(pauseInMillis, scenario.serverTimeline);
		            }
		        });
		    }
		}
		
		export function saveScenario(description, creator) {
		    if (AppUtils.isDevelopment() === false) {
		        console.error("saveScenario is only available during development");
		    } else {
		        Utils.saveScenario(description, creator).then((id) => {
		            console.log(`saved scenario with id ${id}`);
		            ACEController.timeline = [];
		            AppUtils.start();
		        });
		    }
		}
		
		/*       S.D.G.       */


	'''

	def generateBug() '''
		import ReplayUtils from "../../src/app/ReplayUtils";
		import ACEController from "./ACEController";
		import Utils from "./Utils";
		
		export function runBug(bugId, pauseInMillis = 0) {
		    Utils.loadBug(bugId).then((scenario) => {
		        ReplayUtils.scenarioConfig = {};
		        ACEController.expectedTimeline = JSON.parse(scenario.timeline);
		        Utils.replayServerless(pauseInMillis);
		    });
		}
		
		export function saveBug(description, creator) {
		    Utils.saveBug(description, creator).then((id) => {
		        console.log(`saved bug with id ${id}`);
		    });
		}
		
		/*       S.D.G.       */
		
	'''

	def generateTriggerAction() '''
		import Event from "./Event";
		import ACEController from "./ACEController";
		
		export default class TriggerAction extends Event {
		    constructor(action) {
		        super(action, 'TriggerAction');
		        this.eventData = action;
		    }
		
			publish() {
			    ACEController.addItemToTimeLine({event: this});
			    this.notifyListeners();
			}
			
			notifyListeners() {
			    let i, listener;
			    if (this.eventName !== undefined) {
			        const listenersForEvent = ACEController.listeners[this.eventName];
			        if (listenersForEvent !== undefined) {
			            for (i = 0; i < listenersForEvent.length; i += 1) {
			                listener = listenersForEvent[i];
			                listener(this.eventData);
			            }
			        }
			    }
			}
		}
		
		/*       S.D.G.       */
		
	'''
	
	def generateUtils() '''
		import AppUtils from "../../src/app/AppUtils";
		import ACEController from "./ACEController";
		import ReplayUtils from "../../src/app/ReplayUtils";
		
		export default class Utils {
		
		    static getServerInfo() {
		        return AppUtils.httpGet('api/server/info');
		    }
		
		    static saveBug(description, creator) {
		        return Utils.getServerInfo().then((serverInfo) => {
		            const browser = Utils.getBrowserInfo();
		            const uuid = AppUtils.createUUID();
		            const data = {
		                description,
		                timeline: JSON.stringify(ACEController.timeline),
		                creator,
		                clientVersion: AppUtils.getClientVersion(),
		                device: browser.name + " " + browser.version,
		                uuid,
		                apiKey: AppUtils.getAceScenariosApiKey(),
		                serverVersion: serverInfo.serverVersion
		            };
		            return AppUtils.httpPost(AppUtils.getAceScenariosBaseUrl() + 'api/bugs/create', false, [], data);
		        });
		    }
		
		    static loadBug(id) {
		        const uuid = AppUtils.createUUID();
		        let queryParams = [];
		        queryParams.push({
		            key: "id",
		            value: id
		        });
		        queryParams.push({
		            key: "apiKey",
		            value: AppUtils.getAceScenariosApiKey()
		        });
		        queryParams.push({
		            key: "uuid",
		            value: uuid
		        });
		        return AppUtils.httpGet(AppUtils.getAceScenariosBaseUrl() + 'api/bugs/get', false, queryParams);
		    }
		
		    static saveScenario(description, creator) {
		        return AppUtils.httpGet('api/e2e/timeline').then((serverTimeline) => {
		            return Utils.getServerInfo().then((serverInfo) => {
		                const browser = Utils.getBrowserInfo();
		                const uuid = AppUtils.createUUID();
		                const data = {
		                    description,
		                    timeline: JSON.stringify(ACEController.timeline),
		                    serverTimeline: JSON.stringify(serverTimeline),
		                    creator,
		                    clientVersion: AppUtils.getClientVersion(),
		                    device: browser.name + " " + browser.version,
		                    uuid,
		                    apiKey: AppUtils.getAceScenariosApiKey(),
		                    serverVersion: serverInfo.serverVersion
		                };
		                return AppUtils.httpPost(AppUtils.getAceScenariosBaseUrl() + 'api/scenarios/create', false, [], data);
		            });
		        });
		    }
		
		    static saveScenarioResult(normalized, result) {
		        return AppUtils.httpGet('replay/e2e/timeline').then((serverTimeline) => {
		            return Utils.getServerInfo().then((serverInfo) => {
		                const browser = Utils.getBrowserInfo();
		                const uuid = AppUtils.createUUID();
		                const data = {
		                    scenarioId: ReplayUtils.scenarioConfig.scenarioId,
		                    timeline: JSON.stringify(normalized),
		                    executor: ReplayUtils.scenarioConfig.executor,
		                    result,
		                    uuid,
		                    clientVersion: AppUtils.getClientVersion(),
		                    device: browser.name + " " + browser.version,
		                    apiKey: AppUtils.getAceScenariosApiKey(),
		                    serverVersion: serverInfo.serverVersion,
		                    serverTimeline: JSON.stringify(serverTimeline)
		                };
		                return AppUtils.httpPost(AppUtils.getAceScenariosBaseUrl() + 'api/results/create', false, [], data);
		            });
		        });
		    }
		
		    static loadScenario(id) {
		        const uuid = AppUtils.createUUID();
		        let queryParams = [];
		        queryParams.push({
		            key: "id",
		            value: id
		        });
		        queryParams.push({
		            key: "apiKey",
		            value: AppUtils.getAceScenariosApiKey()
		        });
		        queryParams.push({
		            key: "uuid",
		            value: uuid
		        });
		        return AppUtils.httpGet(AppUtils.getAceScenariosBaseUrl() + 'api/scenarios/get', false, queryParams);
		    }
		
		    static loadNextScenario(lastId) {
		        const uuid = AppUtils.createUUID();
		        let queryParams = [];
		        queryParams.push({
		            key: "lastId",
		            value: lastId
		        });
		        queryParams.push({
		            key: "apiKey",
		            value: AppUtils.getAceScenariosApiKey()
		        });
		        queryParams.push({
		            key: "uuid",
		            value: uuid
		        });
		        return AppUtils.httpGet(AppUtils.getAceScenariosBaseUrl() + 'api/scenarios/next', false, queryParams);
		    }
		
		    static getBrowserInfo() {
		        let ua = navigator.userAgent, tem,
		            M = ua.match(/(opera|chrome|safari|firefox|msie|trident(?=\/))\/?\s*(\d+)/i) || [];
		        if (/trident/i.test(M[1])) {
		            tem = /\brv[ :]+(\d+)/g.exec(ua) || [];
		            return {name: 'IE ', version: (tem[1] || '')};
		        }
		        if (M[1] === 'Chrome') {
		            tem = ua.match(/\bOPR\/(\d+)/);
		            if (tem != null) {
		                return {name: 'Opera', version: tem[1]};
		            }
		        }
		        M = M[2] ? [M[1], M[2]] : [navigator.appName, navigator.appVersion, '-?'];
		        if ((tem = ua.match(/version\/(\d+)/i)) != null) {
		            M.splice(1, 1, tem[1]);
		        }
		        return {
		            name: M[0],
		            version: M[1]
		        };
		    }
		
		    static prepareAction(uuid) {
		        if (ACEController.execution === ACEController.E2E) {
		            return AppUtils.httpPut('replay/e2e/prepare?uuid=' + uuid);
		        } else {
		            return new Promise((resolve) => {
		                resolve();
		            });
		        }
		    }
		
		    static replayServerless(pauseInMillis) {
		        ReplayUtils.prepareReplay();
		        ACEController.startReplay(ACEController.REPLAY, pauseInMillis)
		    }
		
		    static replayE2E(pauseInMillis, serverTimeline) {
		        ReplayUtils.prepareReplay();
		        AppUtils.httpPut('replay/e2e/start', false, [], JSON.parse(serverTimeline)).then(() => {
		            ACEController.startReplay(ACEController.E2E, pauseInMillis)
		        });
		    }
		
		    static normalizeTimelines(expected, actual) {
		        let normalizedExpected = [];
		        let normalizedActual = [];
		        let expectedIndex = 0;
		        let actualIndex = 0;
		        while (expectedIndex < expected.length) {
		            if (actualIndex >= actual.length) {
		                normalizedExpected.push(expected[expectedIndex]);
		                normalizedActual.push({});
		                expectedIndex++;
		            } else if (expected[expectedIndex].action && actual[actualIndex].action || !expected[expectedIndex].action && !actual[actualIndex].action) {
		                normalizedExpected.push(expected[expectedIndex]);
		                normalizedActual.push(actual[actualIndex]);
		                expectedIndex++;
		                actualIndex++;
		            } else if (expected[expectedIndex].action && !actual[actualIndex].action) {
		                normalizedExpected.push({});
		                normalizedActual.push(actual[actualIndex]);
		                actualIndex++;
		            } else if (!expected[expectedIndex].action && actual[actualIndex].action) {
		                normalizedExpected.push(expected[expectedIndex]);
		                normalizedActual.push({});
		                expectedIndex++;
		            }
		        }
		        while (actualIndex < actual.length) {
		            normalizedExpected.push({});
		            normalizedActual.push(actual[actualIndex]);
		            actualIndex++;
		        }
		        return {
		            expected: normalizedExpected,
		            actual: normalizedActual
		        };
		    }
		
		    static finishReplay() {
		    	ReplayUtils.tearDownReplay();
		        if (ReplayUtils.scenarioConfig.saveScenarioResult === true) {
		            const normalized = Utils.normalizeTimelines(ACEController.expectedTimeline, ACEController.actualTimeline);
		            const result = ReplayUtils.compareItems(normalized.expected, normalized.actual);
		
		            if (normalized.expected && normalized.actual) {
		                const size = normalized.expected.length > normalized.actual.length ? normalized.expected.length : normalized.actual.length;
		                for (let i = 0; i < size; i++) {
		                    const expected = normalized.expected[i] ? normalized.expected[i] : null;
		                    const actual = normalized.actual[i] ? normalized.actual[i] : null;
		                    const result = ReplayUtils.compareItems(expected, actual);
		                    const item = {
		                        expected,
		                        actual,
		                        result
		                    };
		                    if (result === true) {
		                        console.log("%cSUCCESS expected " + Utils.name(item.expected) + " actual " + Utils.name(item.actual), "color: green;", item);
		                    } else {
		                        console.log("%cFAILURE expected " + Utils.name(item.expected) + " actual " + Utils.name(item.actual), "color: red;", item);
		                    }
		                }
		            }
		            if (result === true) {
		                console.log("%c===============", "color: green;");
		                console.log("%c=== SCENARIO " + ReplayUtils.scenarioConfig.scenarioId + " SUCCESS ===", "color: green;");
		                console.log("%c===============", "color: green;");
		            } else {
		                console.log("%c===============", "color: red;");
		                console.log("%c=== SCENARIO " + ReplayUtils.scenarioConfig.scenarioId + " FAILURE ===", "color: red;");
		                console.log("%c===============", "color: red;");
		            }
		            Utils.saveScenarioResult(normalized, result);
		            AppUtils.httpPut('replay/e2e/stop').then(() => {
		                if (ReplayUtils.scenarioConfig.runAllScenarios === true) {
		                    Utils.loadNextScenario(ReplayUtils.scenarioConfig.scenarioId).then((scenario) => {
		                        if (scenario.id) {
		                            ReplayUtils.scenarioConfig.scenarioId = scenario.id;
		                            ACEController.expectedTimeline = JSON.parse(scenario.timeline);
		                            Utils.replayE2E(ReplayUtils.scenarioConfig.pauseInMillis, scenario.serverTimeline);
		                        }
		                    });
		                }
		            });
		        }
		    }
		
		    static name(item) {
		        if (item.action) {
		            return item.action.actionName;
		        }
		        if (item.command) {
		            return item.command.commandName;
		        }
		        if (item.event) {
		            return item.event.eventName;
		        }
		    }
		
		}
		
		/*       S.D.G.       */
		
		
	'''
	
	def String generateWriteAppState(ES6_StateElement it, String prefix) '''
		import AppUtils from "../../src/app/AppUtils";
		
		export let «name»;
		
		export function setInitial«name.toFirstUpper»(initial«name.toFirstUpper») {
			«name» = AppUtils.deepCopy(initial«name.toFirstUpper»);
		}
		
		«IF types !== null»
			«FOR type : types»
				«FOR element : type.elements»
					«element.generateWriteAppStateRec()»
				«ENDFOR»
			«ENDFOR»
		«ENDIF»
	'''
	
	def String generateWriteAppStateRec(ES6_StateElement it) '''
		«IF types === null || types.length == 0»
			export function set_«functionName»(eventData) {
				«IF hash»
					location.hash = eventData.«name»;
				«ELSEIF storage»
					localStorage.setItem("«name»", eventData.«name»);
				«ELSE»
					«elementPath» = eventData.«name»;
				«ENDIF»
			}
			
			export function reset_«functionName»() {
				«IF hash»
					location.hash = "";
				«ELSEIF storage»
					localStorage.removeItem("«name»");
				«ELSE»
					«elementPath» = null;
				«ENDIF»
			}
			
			export function init_«functionName»() {
				«IF hash»
					location.hash = "";
				«ELSEIF storage»
					localStorage.removeItem("«name»");
				«ELSE»
					«elementPath» = null;
				«ENDIF»
			}
		«ELSE»
			export function set_«functionName»(eventData) {
				«IF hash»
					location.hash = eventData.«name»;
				«ELSEIF storage»
					localStorage.setItem("«name»", eventData.«name»);
				«ELSE»
					«elementPath» = eventData.«name»;
				«ENDIF»
			}
			
			«IF !list && !hash && !storage»
				export function merge_«functionName»(eventData) {
					«FOR type : types»
						«FOR element : type.elements»
							if (eventData.«element.name» !== undefined) {
								«element.elementPath» = eventData.«element.name»;
							}
						«ENDFOR»
					«ENDFOR»
				}
			«ENDIF»
			
			export function reset_«functionName»() {
				«IF hash»
					location.hash = "";
				«ELSEIF storage»
					localStorage.removeItem("«name»");
				«ELSE»
					«elementPath» = null;
				«ENDIF»
			}
			
			export function init_«functionName»() {
				«IF hash»
					location.hash = "";
				«ELSEIF storage»
					localStorage.removeItem("«name»");
				«ELSE»
					«elementPath» = {};
				«ENDIF»
			}
			
			«IF types !== null && !list && !hash && !storage»
				«FOR type : types»
					«FOR element : type.elements»
						«element.generateWriteAppStateRec()»
					«ENDFOR»
				«ENDFOR»
			«ENDIF»
			
		«ENDIF»
	'''
	
	def String generateReadAppState(ES6_StateElement it, String prefix) '''
		import AppUtils from "../../src/app/AppUtils";
		import { state } from "./WriteAppState";
		
		export function get«name.toFirstUpper»() {
			return AppUtils.deepCopy(«name»);
		}
		
		«IF types !== null»
			«FOR type : types»
				«FOR element : type.elements»
					«element.generateReadAppStateRec()»
				«ENDFOR»
			«ENDFOR»
		«ENDIF»
	'''
	
	def String generateReadAppStateRec(ES6_StateElement it) '''
		«IF types === null || types.length == 0»
			export function get_«functionName»() {
				«IF hash»
					return location.hash;
				«ELSEIF storage»
					return localStorage.getItem("«name»");
				«ELSE»
					return «elementPath»;
				«ENDIF»
			}
			
		«ELSE»
			export function get_«functionName»() {
				«IF hash»
					return location.hash;
				«ELSEIF storage»
					localStorage.getItem("«name»");
				«ELSE»
					return AppUtils.deepCopy(«elementPath»);
				«ENDIF»
			}

			«IF types !== null && !list && !hash && !storage»
				«FOR type : types»
					«FOR element : type.elements»
						«element.generateReadAppStateRec()»
					«ENDFOR»
				«ENDFOR»
			«ENDIF»
			
		«ENDIF»
	'''
	
}