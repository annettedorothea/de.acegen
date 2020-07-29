/* 
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */
 

package de.acegen.templates.es6

import de.acegen.aceGen.ClientAttribute
import de.acegen.aceGen.GroupedClientAttribute
import de.acegen.aceGen.SingleClientAttribute
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.es6.Es6Extension
import java.util.List
import javax.inject.Inject

class AceTemplate {
	
	@Inject
	extension Es6Extension
	
	@Inject
	extension CommonExtension
	
	def generateAppUtilsStub() '''
		«copyright»
		
		import CryptoJS from "crypto-js";
		import * as AppState from "../../gen/ace/AppState";
		import * as App from "./App";
		import Utils from "../../gen/ace/Utils";
		
		export default class AppUtils {
		
			static initEventListenersAndActionFactories() {
				// add EventListenerRegistration.init() of all modules
				// add ActionFactoryRegistrationTodo.init() of all modules
			}
		
		    static start() {
		        Utils.loadSettings().then((settings) => {
		            Utils.settings = settings;
		            // call init action
		        });
		    }
		
		    static createInitialAppState() {
		        const initialAppState = {
		        };
		        AppState.setInitialAppState(initialAppState);
		    }
		
		    static renderNewState() {
		        App.render(AppState.getAppState());
		    }
		
		    static httpGet(url, authorize) {
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
		
		            const request = new Request(url, options);
		
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
		
		    static httpChange(methodType, url, authorize, data) {
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
		
		            const request = new Request(url, options);
		
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
		                    resolve(JSON.parse(data));
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
		
		    static httpPost(url, authorize, data) {
		        return AppUtils.httpChange("POST", url, authorize, data);
		    }
		
		    static httpPut(url, authorize, data) {
		        return AppUtils.httpChange("PUT", url, authorize, data);
		    }
		
		    static httpDelete(url, authorize, data) {
		        return AppUtils.httpChange("DELETE", url, authorize, data);
		    }
		
		    static basicAuth() {
		        return "<your authorization>";
		    }
		
		    static createUUID() {
		        let d = new Date().getTime();
		        return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
		            const r = (d + Math.random() * 16) % 16 | 0;
		            d = Math.floor(d / 16);
		            return (c === 'x' ? r : (r & 0x3 | 0x8)).toString(16);
		        });
		    }
		
		    static displayUnexpectedError(error) {
		        console.error(error);
		        try {
		            if (typeof error !== "object") {
		                error = {
		                    errorKey: error
		                };
		                //displayError(error)
		            } else {
		                if (error.code === 401) {
		                    error.errorKey = "unauthorized";
		                    //displayErrorAndLogout(error);
		                } else if (error.code === 400) {
		                    //displayError(error)
		                } else {
		                    error = {
		                        errorKey: error.text
		                    };
		                    //displayError(error)
		                }
		            }
		        } catch (e) {
		            console.error(e);
		        }
		        //displaySaveBugDialog();
		    }
		
		    static deepCopy(object) {
		        return object ? JSON.parse(JSON.stringify(object)) : undefined;
		    }
		
		}
		
		/*       S.D.G.       */
		
		
		
		
		«sdg»
		
	'''
	
	def generateAppStub() '''
		«copyright»


		import AppUtils from "./AppUtils";
		
		//import Container from "../web/Container";
		
		export * from "../../gen/ace/Scenario";
		export * from "../../gen/ace/Bug";
		
		const React = require('react');
		const ReactDOM = require('react-dom');
		
		AppUtils.createInitialAppState();
		
		/*export const container = ReactDOM.render(
		    <Container/>,
		    document.getElementById('root')
		);
		
		export function render(newAppState) {
		    container.setState(newAppState);
		}*/
		
		window.onhashchange = () => {
		};
		
		
		AppUtils.initEventListenersAndActionFactories();
		
		AppUtils.start();
		
		
		«sdg»
		
		
	'''
	
	def generateReplayUtilsStub() '''
		«copyright»

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
				// localStorage.removeItem("<key>");
		    }

		    static tearDownReplay() {
				// localStorage.removeItem("<key>");
		    	//window.location.hash = "#";
		    }

		}
		
		
		«sdg»
		
		
	'''
	
	def generateACEController() '''
		«copyright»

		import AppUtils from "../../src/app/AppUtils";
		import Utils from "./Utils";
		import * as AppState from "./AppState";
		
		export default class ACEController {
		
		    static init() {
		        ACEController.timeline = [];
		        ACEController.listeners = {};
		        ACEController.factories = {};
		        ACEController.registerListener('TriggerAction', ACEController.triggerAction);
		        ACEController.actionIsProcessing = false;
		        ACEController.actionQueue = [];
		        ACEController.UI = 1;
		        ACEController.REPLAY = 2;
		        ACEController.E2E = 3;
		        ACEController.execution = ACEController.UI;
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
				if (ACEController.execution === ACEController.UI && Utils.isDevelopment() && Utils.getTimelineSize() > 0) {
				    ACEController.timeline.push(AppUtils.deepCopy(item));
				    if (ACEController.timeline.length > Utils.getTimelineSize()) {
		                ACEController.timeline.shift();
				        while (ACEController.timeline.length > 0 && ACEController.timeline.length > 0 && !ACEController.timeline[0].appState) {
		                    ACEController.timeline.shift();
		                }
				    }
				} else if (ACEController.execution !== ACEController.UI) {
				    ACEController.actualTimeline.push(AppUtils.deepCopy(item));
				}
		    }
		
		    static addActionToQueue(action) {
		        if (ACEController.execution === ACEController.UI) {
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
			    	ACEController.addItemToTimeLine({appState: AppState.getAppState()});
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
		            if (ACEController.execution !== ACEController.UI) {
		                ACEController.timeline = [];
		                ACEController.actionIsProcessing = false;
		                ACEController.actionQueue = [];
		                ACEController.execution = ACEController.UI;
		                Utils.finishReplay();
		                AppUtils.start();
		            }
		        }
		    }
		    
		    static callApplyNextActions() {
		    	if (ACEController.execution === ACEController.UI) {
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
				
				let appStateWasSet = false;
		        for (let i = 0; i < ACEController.expectedTimeline.length; i++) {
		            let item = ACEController.expectedTimeline[i];
		            if (item.action) {
		                const actionData = item.action.actionData;
		                let action = ACEController.factories[item.action.actionName](actionData);
		                action.actionData = actionData;
		                actions.push(action);
		            }
					if (item.appState && !appStateWasSet) {
					    AppState.setInitialAppState(item.appState);
					    appStateWasSet = true;
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
		
		
		«sdg»
		
		
	'''
	
	def generateScenario() '''
		«copyright»

		import AppUtils from "../../src/app/AppUtils";
		import ReplayUtils from "../../src/app/ReplayUtils";
		import ACEController from "./ACEController";
		import Utils from "./Utils";
		
		export function runScenario(scenarioId, executor = "unknown", pauseInMillis = 0) {
		    if (Utils.isDevelopment() === false) {
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
		    if (Utils.isDevelopment() === false) {
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
		    if (Utils.isDevelopment() === false) {
		        console.error("saveScenario is only available during development");
		    } else {
		        Utils.saveScenario(description, creator).then((id) => {
		            console.log(`saved scenario with id ${id}`);
		            ACEController.timeline = [];
		            AppUtils.start();
		        });
		    }
		}
		
		
		«sdg»
		


	'''

	def generateBug() '''
		«copyright»

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
		
		
		«sdg»
		
		
	'''

	def generateTriggerAction() '''
		«copyright»

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
		
		
		«sdg»
		
		
	'''
	
	def generateUtils() '''
		«copyright»

		import AppUtils from "../../src/app/AppUtils";
		import ACEController from "./ACEController";
		import ReplayUtils from "../../src/app/ReplayUtils";
		
		export default class Utils {
		
		    static getServerInfo() {
		        return AppUtils.httpGet(Utils.getRootPath() + '/server/info');
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
		        return Utils.settings ? Utils.settings.clientVersion : "";
		    }
		
		    static isDevelopment() {
		        return Utils.settings ? Utils.settings.development : false;
		    }
		
		    static getAceScenariosApiKey() {
		        return Utils.settings ? Utils.settings.aceScenariosApiKey : "";
		    }
		
		    static getAceScenariosBaseUrl() {
		        return Utils.settings ? Utils.settings.aceScenariosBaseUrl : "";
		    }
		
		    static getRootPath() {
		        return Utils.settings ? (ACEController.execution !== ACEController.E2E ? Utils.settings.rootPath :  Utils.settings.replayRootPath) : "";
		    }
		
		    static getTimelineSize() {
		        return Utils.settings ? Utils.settings.timelineSize : 0;
		    }

		    static saveBug(description, creator) {
		        return Utils.getServerInfo().then((serverInfo) => {
		            const browser = Utils.getBrowserInfo();
		            const uuid = AppUtils.createUUID();
		            const data = {
		                description,
		                timeline: JSON.stringify(ACEController.timeline),
		                creator,
		                clientVersion: Utils.getClientVersion(),
		                device: browser.name + " " + browser.version,
		                uuid,
		                apiKey: Utils.getAceScenariosApiKey(),
		                serverVersion: serverInfo.serverVersion
		            };
		            return AppUtils.httpPost(Utils.getAceScenariosBaseUrl() + 'api/bugs/create', false, data).then(() => {
		                return new Promise((resolve) => {
		                    resolve(uuid);
		                });
		            });
		        });
		    }
		
		    static loadBug(id) {
		        return AppUtils.httpGet(Utils.getAceScenariosBaseUrl() + `api/bugs/get?id=${id}&apiKey=${Utils.getAceScenariosApiKey()}&uuid=${AppUtils.createUUID()}`, false);
		    }
		
		    static saveScenario(description, creator) {
		        return AppUtils.httpGet(Utils.getRootPath() + '/e2e/timeline').then((serverTimeline) => {
		            return Utils.getServerInfo().then((serverInfo) => {
		                const browser = Utils.getBrowserInfo();
		                const uuid = AppUtils.createUUID();
		                const data = {
		                    description,
		                    timeline: JSON.stringify(ACEController.timeline),
		                    serverTimeline: JSON.stringify(serverTimeline),
		                    creator,
		                    clientVersion: Utils.getClientVersion(),
		                    device: browser.name + " " + browser.version,
		                    uuid,
		                    apiKey: Utils.getAceScenariosApiKey(),
		                    serverVersion: serverInfo.serverVersion
		                };
		                return AppUtils.httpPost(Utils.getAceScenariosBaseUrl() + 'api/scenarios/create', false, data).then(() => {
		                    return new Promise((resolve) => {
		                        resolve(uuid);
		                    });
		                });
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
		                    clientVersion: Utils.getClientVersion(),
		                    device: browser.name + " " + browser.version,
		                    apiKey: Utils.getAceScenariosApiKey(),
		                    serverVersion: serverInfo.serverVersion,
		                    serverTimeline: JSON.stringify(serverTimeline)
		                };
		                return AppUtils.httpPost(Utils.getAceScenariosBaseUrl() + 'api/results/create', false, data);
		            });
		        });
		    }
		
		    static loadScenario(id) {
		        return AppUtils.httpGet(Utils.getAceScenariosBaseUrl() + `api/scenarios/get?id=${id}&apiKey=${Utils.getAceScenariosApiKey()}&uuid=${AppUtils.createUUID()}`, false);
		    }
		
		    static loadNextScenario(lastId) {
		        return AppUtils.httpGet(Utils.getAceScenariosBaseUrl() + `api/scenarios/next?lastId=${lastId}&apiKey=${Utils.getAceScenariosApiKey()}&uuid=${AppUtils.createUUID()}`, false);
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
		        AppUtils.createInitialAppState();
		        ACEController.startReplay(ACEController.REPLAY, pauseInMillis)
		    }
		
		    static replayE2E(pauseInMillis, serverTimeline) {
		        ReplayUtils.prepareReplay();
		        AppUtils.createInitialAppState();
		        AppUtils.httpPut('replay/e2e/start', false, JSON.parse(serverTimeline)).then(() => {
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
		        console.log("replay finished");
		    	ReplayUtils.tearDownReplay();
		    	AppUtils.createInitialAppState();
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
				return "AppState";
		    }
		    
		}
		
		
		«sdg»
		
		
		
	'''
	
	def String generateAppState(List<ClientAttribute> attributes, String prefix) '''
		«copyright»

		import AppUtils from "../../src/app/AppUtils";
		
		export let appState;
		
		export function getAppState() {
			return AppUtils.deepCopy(appState);
		}
		
		export function setInitialAppState(initialAppState) {
			appState = AppUtils.deepCopy(initialAppState);
		}
		
		«FOR attribute : attributes»
			«attribute.generateAppStateRec»
		«ENDFOR»
	'''
	
	private def getStateFunction(SingleClientAttribute it) '''
		export function get_«functionName»() {
			«IF isHash»
				return location.hash;
			«ELSEIF isStorage»
				return localStorage.getItem("«getName»");
			«ELSE»
				«FOR attribute: allParentAttributes»
					if (!«attribute.elementPath») {
						return undefined;
					}
					«IF attribute.eContainer instanceof GroupedClientAttribute»
						if («attribute.elementPath».is«attribute.name.toFirstUpper» !== true) {
							return undefined;
						}
					«ENDIF»
				«ENDFOR»
				«IF attributes === null || attributes.length == 0»
					return «elementPath»;
				«ELSE»
					«IF eContainer instanceof GroupedClientAttribute»
						if («elementPath» && «elementPath».is«name.toFirstUpper» === true) {
							return AppUtils.deepCopy(«elementPath»);
						}
						return undefined;
					«ELSE»
						if (!«elementPath») {
							return undefined;
						}
						return AppUtils.deepCopy(«elementPath»);
					«ENDIF»
				«ENDIF»
			«ENDIF»
		}
		
	'''
	
	private def setStateFunction(SingleClientAttribute it) '''
		export function set_«functionName»(eventData) {
			«IF isHash»
				location.hash = eventData.«getName»;
			«ELSEIF isStorage»
				localStorage.setItem("«getName»", eventData.«getName»);
			«ELSE»
				«FOR attribute: allParentAttributes»
					«IF attribute.eContainer instanceof GroupedClientAttribute»
						if (!«attribute.elementPath» || «attribute.elementPath».is«attribute.name.toFirstUpper» !== true) {
							«attribute.elementPath» = {
								is«attribute.name.toFirstUpper» : true
							};
						}
					«ELSE»
						if (!«attribute.elementPath») {
							«attribute.elementPath» = {};
						}
					«ENDIF»
				«ENDFOR»
				«IF eContainer instanceof GroupedClientAttribute»
					if (!!eventData.«getName») {
						«elementPath» = eventData.«getName»;
						«elementPath».is«name.toFirstUpper» = true;
					} else {
						«elementPath» = {
							is«name.toFirstUpper» : true
						};
					}
				«ELSE»
					«elementPath» = eventData.«getName»;
				«ENDIF»
			«ENDIF»
		}
		
	'''
	
	private def resetStateFunction(SingleClientAttribute it) '''
		export function reset_«functionName»() {
			«IF isHash»
				location.hash = "";
			«ELSEIF isStorage»
				localStorage.removeItem("«getName»");
			«ELSE»
				«FOR attribute: allParentAttributes»
					if (!«attribute.elementPath») {
						return;
					}
				«ENDFOR»
				«elementPath» = undefined;
			«ENDIF»
		}
		
	'''
	
	private def mergeStateFunction(SingleClientAttribute it) '''
		«IF attributes !== null && attributes.length > 0 && !isHash && !isStorage» 
			export function merge_«functionName»(eventData) {
				«FOR attr : allParentAttributes»
					if (!«attr.elementPath») {
						«attr.elementPath» = {};
					}
				«ENDFOR»
				if (!«elementPath») {
					«IF eContainer instanceof GroupedClientAttribute»
						«elementPath» = {
							is«name.toFirstUpper» : true
						};
					«ELSE»
						«elementPath» = {};
					«ENDIF»
				}
				«FOR attribute : attributes»
					«IF attribute instanceof SingleClientAttribute»
						if (eventData.«attribute.name» !== undefined) {
							«attribute.elementPath» = eventData.«attribute.getName»;
						}
					«ENDIF»
				«ENDFOR»
			}
			
		«ENDIF»
	'''
	
	private def childAttributes(SingleClientAttribute it) '''
		«IF attributes !== null && !isList && !isHash && !isStorage»
			«FOR attribute : attributes»
				«attribute.generateAppStateRec»
			«ENDFOR»
		«ENDIF»
	'''
	
	def dispatch String generateAppStateRec(SingleClientAttribute it) '''
		«getStateFunction»
		«setStateFunction»
		«resetStateFunction»
		«mergeStateFunction»
		«childAttributes»
	'''
	
	def dispatch String generateAppStateRec(GroupedClientAttribute it) '''
		«IF attributeGroup === null || attributeGroup.length > 0»
			«FOR attribute : attributeGroup»
				«IF attribute instanceof SingleClientAttribute»
					«attribute.getStateFunction»
					«attribute.setStateFunction»
					«attribute.resetStateFunction»
					«attribute.mergeStateFunction»
					«attribute.childAttributes»
				«ELSE»
					«attribute.generateAppStateRec»
				«ENDIF»
			«ENDFOR»
		«ENDIF»
	'''
	
}	
	
/******* S.D.G. *******/
	
	
