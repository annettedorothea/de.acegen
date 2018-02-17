package com.anfelisa.generator

import com.anfelisa.ace.Action
import com.anfelisa.ace.Command
import com.anfelisa.ace.Event
import com.anfelisa.extensions.ActionExtension
import com.anfelisa.extensions.CommandExtension
import com.anfelisa.extensions.EventExtension
import com.anfelisa.ace.Project
import javax.inject.Inject
import com.anfelisa.extensions.ViewExtension
import com.anfelisa.ace.View
import com.anfelisa.extensions.ProjectExtension

class ES6Template {
	
	@Inject
	extension ActionExtension

	@Inject
	extension CommandExtension

	@Inject
	extension EventExtension
	
	@Inject
	extension ViewExtension
	
	@Inject
	extension ProjectExtension
	
	def generateAbstractActionFile(Action it, Project project) '''
		import Action from "../../ace/Action";
		«IF command !== null»
			import «command.commandName» from "../../../src/«project.name»/commands/«command.commandName»";
	    «ENDIF»
		«FOR view : preAndPostUpdateUIViews»
			import «view.viewName» from "../../../src/«(view.eContainer as Project).name»/views/«view.viewName»";
		«ENDFOR»

		export default class «abstractActionName» extends Action {
		
		    constructor(actionParam) {
		        super(actionParam, '«project.name».«actionName»', «IF init»true«ELSE»false«ENDIF»);
		    }
		
			«IF command !== null»
				getCommand() {
					return new «command.commandName»(this.actionData);
				}
			«ENDIF»
		
			preUpdateUI() {
				«FOR viewFunction : preUpdateUI»
					«viewFunction.viewFunctionWithViewName»(this.actionParam);
				«ENDFOR»
			}
		
			postUpdateUI() {
				«FOR viewFunction : postUpdateUI»
					«viewFunction.viewFunctionWithViewName»(this.actionParam);
				«ENDFOR»
			}
		
		}
		
		/*       S.D.G.       */
	'''

	def generateInitialActionFile(Action it, Project project) '''
		import «abstractActionName» from "../../../gen/«project.name»/actions/«abstractActionName»";
		
		export default class «actionName» extends «abstractActionName» {
		
		    captureActionParam() {
		    }
		
		    initActionData() {
		    }
		
		    releaseActionParam() {
		    }
		}
		
		/*       S.D.G.       */
	'''
	
	def generateAbstractCommandFile(Command it, Project project) '''
		import Command from "../../../gen/ace/Command";
		import TriggerAction from "../../../gen/ace/TriggerAction";
		«FOR event : eventsOfCommand»
			import «event.eventName» from "../../../src/«(event.eContainer as Project).name»/events/«event.eventName»";
		«ENDFOR»
		«FOR action : triggeredActionsOfCommand»
			import «action.actionName» from "../../../src/«(action.eContainer as Project).name»/actions/«action.actionName»";
		«ENDFOR»
		
		export default class «abstractCommandName» extends Command {
		    constructor(commandParam) {
		        super(commandParam, "«project.name».«commandName»");
		        «FOR eventOnOutcome : eventsOnOutcome»
		        	this.«eventOnOutcome.outcome» = "«eventOnOutcome.outcome»";
		        «ENDFOR»
		    }
		
		    publishEvents() {
				let promises = [];
			    	
				switch (this.commandData.outcome) {
				«FOR eventOnOutcome : eventsOnOutcome»
					case this.«eventOnOutcome.outcome»:
						«FOR event : eventOnOutcome.events»
							promises.push(new «event.eventName»(this.commandData).publish());
						«ENDFOR»
						«FOR action : eventOnOutcome.actions»
							promises.push(new TriggerAction(new «action.actionName»(this.commandData)).publish());
						«ENDFOR»
						break;
				«ENDFOR»
				default:
					return new Promise((resolve, reject) => {reject('«commandName» unhandled outcome: ' + this.commandData.outcome)});
				}
				return Promise.all(promises);
		    }
		}
		
		/*       S.D.G.       */
	'''
	
	def generateInitialCommandFile(Command it, Project project) '''
		import «abstractCommandName» from "../../../gen/«project.name»/commands/«abstractCommandName»";
		
		export default class «commandName» extends «abstractCommandName» {
		    execute() {
		        return new Promise((resolve, reject) => {
					resolve();
		        });
		    }
		}
		
		/*       S.D.G.       */
	'''
	
	def generateAbstractEventFile(Event it, Project project) '''
		import Event from "../../../gen/ace/Event";
		
		export default class «abstractEventName» extends Event {
		    constructor(eventParam) {
		        super(eventParam, '«project.name».«eventName»');
		    }
		}
		
		/*       S.D.G.       */
	'''
	def generateInitialEventFile(Event it, Project project) '''
		import «abstractEventName» from "../../../gen/«project.name»/events/«abstractEventName»";
		
		export default class «eventName» extends «abstractEventName» {
		    prepareDataForView() {
		        this.eventData = JSON.parse(JSON.stringify(this.eventParam));
		        if (this.eventData.data === undefined) {
		        	this.eventData.data = {};
		        }
		    }
		}
		
		/*       S.D.G.       */
	'''
	def generateEventListenerRegistration(Project it) '''
		import ACEController from "../ace/ACEController";
		«FOR view : referencedViews»
			import «view.viewName» from "../../src/«(view.eContainer as Project).name»/views/«view.viewName»";
		«ENDFOR»
		
		export default class EventListenerRegistration«projectName» {
		
			static init() {
				«FOR event : events»
					«FOR renderFunction : event.listeners»
						ACEController.registerListener('«name».«event.eventName»', «renderFunction.viewFunctionWithViewName»);
					«ENDFOR»
				«ENDFOR»
			}
		
		}
		
		/*       S.D.G.       */
	'''
	def generateActionFactoryRegistration(Project it) '''
		import ACEController from "../ace/ACEController";
		«FOR action : actions»
			import «action.actionName» from "../../src/«name»/actions/«action.actionName»";
		«ENDFOR»
		
		export default class ActionFactoryRegistration«projectName» {
		
			static init() {
				«FOR action : actions»
					ACEController.registerFactory('«name».«action.actionName»', (actionParam) => new «action.actionName»(actionParam));
				«ENDFOR»
			}
		
		}
		
		/*       S.D.G.       */
	'''
	def generateActionFunctionExports(Project it) '''
		«FOR action : actions»
			import «action.actionName» from "../../src/«name»/actions/«action.actionName»";
		«ENDFOR»
		
		«FOR action : actions»
			export function «action.name.toFirstLower»(actionParam) {
			    new «action.actionName»(actionParam).apply();
			}
			
		«ENDFOR»
		
		/*       S.D.G.       */
	'''
	def generateView(View it, Project project) '''

		export default class «viewName» {
			«FOR renderFunction : renderFunctions»
				static «renderFunction.name»(eventData) {
				};
				
			«ENDFOR»
		}
		
		/*                    S.D.G.                    */
	'''

	def generateAction() '''
		import ACEController from "./ACEController";
		import AppUtils from "../../src/app/AppUtils";
		
		export default class Action {
		    constructor(actionParam, actionName, isInitAction) {
		        this.actionName = actionName;
		        if (actionParam === undefined) {
		            actionParam = {};
		        }
		        this.actionParam = JSON.parse(JSON.stringify(actionParam));
		        this.actionData = {};
		        this.isInitAction = isInitAction === true;
		        this.postUpdateUI = this.postUpdateUI.bind(this);
		    }
		
		    captureActionParam() {
		    }
		
		    releaseActionParam() {
		    }
		
		    initActionData() {
		    }
		
		    getCommand() {
		        throw "no command defined for " + this.actionName;
		    }
		
		    apply() {
		        ACEController.addActionToQueue(this);
		    }
		
		    applyAction() {
		        return new Promise((resolve, reject) => {
		            this.preUpdateUI();
		            if (ACEController.execution === ACEController.LIVE) {
		                this.actionData.uuid = AppUtils.createUUID();
		            }
		            if (ACEController.execution === ACEController.LIVE) {
		                this.captureActionParam();
		            } else {
		                this.releaseActionParam();
		            }
		            this.initActionData();
		            ACEController.addItemToTimeLine({action: this});
		            let command = this.getCommand();
		            if (command) {
						command.executeCommand().then(
						    () => {
						        this.postUpdateUI();
						        resolve();
						    },
						    (error) => {
						        this.postUpdateUI();
						        reject(error + "\n" + command.commandName);
						    }
						);
		            } else {
		                this.postUpdateUI();
		                resolve();
		            }
		        });
		    }
		
		}
		
		/*       S.D.G.       */
		
	'''

	def generateCommand() '''
		import ACEController from "./ACEController";
		import AppUtils from "../../src/app/AppUtils";
		import ReplayUtils from "../../src/app/ReplayUtils";
		
		export default class Command {
		    constructor(commandParam, commandName) {
		        this.commandName = commandName;
		        this.commandParam = JSON.parse(JSON.stringify(commandParam));
		        this.commandData = {};
		    }
		
		    execute() {
		        throw "no execute method defined for " + this.commandName;
		    }
		
		    publishEvents() {
		        throw "no publishEvents method defined for " + this.commandName;
		    }
		
		    executeCommand() {
		        return new Promise((resolve, reject) => {
		            if (ACEController.execution !== ACEController.REPLAY) {
		                this.execute().then(() => {
		                    ACEController.addItemToTimeLine({command: this});
		                    this.publishEvents().then(() => {
		                        if (ACEController.execution === ACEController.LIVE) {
		                            ACEController.applyNextActions();
		                        } else {
		                            setTimeout(ACEController.applyNextActions, ACEController.pauseInMillis);
		                        }
		                        resolve();
		                    }, (error) => {
								if (ACEController.execution === ACEController.LIVE) {
								    ACEController.applyNextActions();
								} else {
								    setTimeout(ACEController.applyNextActions, ACEController.pauseInMillis);
								}
		                        reject(error + "\n" + this.commandName);
		                    });
		                }, (error) => {
							if (ACEController.execution === ACEController.LIVE) {
							    ACEController.applyNextActions();
							} else {
							    setTimeout(ACEController.applyNextActions, ACEController.pauseInMillis);
							}
		                    reject(error + "\n" + this.commandName);
		                });
		            } else {
		                const timelineCommand = ACEController.getCommandByUuid(this.commandParam.uuid);
		                this.commandData = timelineCommand.commandData;
		                ACEController.addItemToTimeLine({command: this});
		                this.publishEvents().then(() => {
		                    setTimeout(ACEController.applyNextActions, ACEController.pauseInMillis);
		                    resolve();
		                }, (error) => {
							setTimeout(ACEController.applyNextActions, ACEController.pauseInMillis);
		                    reject(error + "\n" + this.commandName);
		                });
		            }
		        });
		    }
		
		    httpGet(url, queryParams) {
		        return ReplayUtils.prepareAction(this.commandParam.uuid).then(() => {
		            queryParams = this.addUuidToQueryParams(queryParams);
		            return AppUtils.httpGet(url, queryParams, this.commandParam);
		        }, (error) => {
		            reject(error);
		        });
		    }
		
		    httpPost(url, queryParams, data) {
		        return ReplayUtils.prepareAction(this.commandParam.uuid).then(() => {
		            queryParams = this.addUuidToQueryParams(queryParams);
		            data = this.addUuidToData(data);
		            return AppUtils.httpPost(url, queryParams, data, this.commandParam);
		        }, (error) => {
		            reject(error);
		        });
		    }
		
		    httpPut(url, queryParams, data) {
		        return ReplayUtils.prepareAction(this.commandParam.uuid).then(() => {
		            queryParams = this.addUuidToQueryParams(queryParams);
		            data = this.addUuidToData(data);
		            return AppUtils.httpPut(url, queryParams, data, this.commandParam);
		        }, (error) => {
		            reject(error);
		        });
		    }
		
		    httpDelete(url, queryParams, data) {
		        return ReplayUtils.prepareAction(this.commandParam.uuid).then(() => {
		            queryParams = this.addUuidToQueryParams(queryParams);
		            data = this.addUuidToData(data);
		            return AppUtils.httpDelete(url, queryParams, data, this.commandParam);
		        }, (error) => {
		            reject(error);
		        });
		    }
		
		    addUuidToQueryParams(queryParams) {
		        if (!queryParams) {
		            queryParams = [];
		        }
		        if (this.commandParam.uuid) {
		            queryParams.push({
		                key: "uuid",
		                value: this.commandParam.uuid
		            });
		        }
		        return queryParams;
		    }
		
		    addUuidToData(data) {
		        if (!data) {
		            data = {};
		        }
		        if (this.commandParam.uuid) {
		            data.uuid = this.commandParam.uuid;
		        }
		        return data;
		    }
		
		}
		
		/*       S.D.G.       */
		
	'''
	
	def generateEvent() '''
		import ACEController from "./ACEController";
		
		export default class Event {
		    constructor(eventParam, eventName) {
		        this.eventName = eventName;
		        this.eventParam = eventParam;
		    }
		
		    prepareDataForView() {
		        throw "no prepareDataForView method defined for " + this.eventName;
		
		    }
		
		    publish() {
		        return new Promise((resolve, reject) => {
		            this.prepareDataForView();
		            ACEController.addItemToTimeLine({event: this});
		            Promise.all(this.notifyListeners()).then(() => {
		                resolve();
		            }, (error) => {
		                reject(error + "\n" + this.eventName);
		            });
		        });
		    }
		
		    notifyListeners() {
		        let promises = [];
		        let i, listener;
		        if (this.eventName !== undefined) {
		            const listenersForEvent = ACEController.listeners[this.eventName];
		            if (listenersForEvent !== undefined) {
		                for (i = 0; i < listenersForEvent.length; i += 1) {
		                    listener = listenersForEvent[i];
		                    promises.push(listener(this.eventData));
		                }
		            }
		        }
		        return promises;
		    }
		
		}
		
		/*       S.D.G.       */
		
	'''
	
	def generateAppUtilsStub(Project it) '''
		import ACEController from "../../gen/ace/ACEController";
		import uuid from "uuid";
		
		export default class AppUtils {
		
		    static start() {
		    		// call initial action
		    }
		
		    static getClientVersion() {
		        return "1.0.0";
		    }
		
		    static httpGet(url, queryParams, commandParam) {
				return new Promise((resolve, reject) => {
				    let authorization = commandParam ? AppUtils.basicAuth(commandParam.username, commandParam.password) : undefined;
				    const headers = new Headers();
				    headers.append("Content-Type", "application/json");
				    headers.append("Accept", "application/json");
				    if (authorization !== undefined) {
				        headers.append("Authorization", authorization);
				    }
				
				    const options = {
				        method: 'GET',
				        headers: headers,
				        mode: 'cors',
				        cache: 'no-cache'
				    };
				
				    const adjustedUrl = AppUtils.url(url);
				    const completeUrl = adjustedUrl + AppUtils.queryParamString(adjustedUrl, queryParams);
				    const request = new Request(completeUrl, options);
				
				    fetch(request).then(function (response) {
				        if (response.status >= 300) {
				            const status = {
				                code: response.status,
				                text: response.statusText
				            };
				            reject(status);
				        } else {
				            return response.json();
				        }
				    }).then(function (data) {
				        resolve(data);
				    }).catch(function (error) {
				        const status = {
				            code: error.name,
				            text: error.message
				        };
				        reject(status);
				    });
				});
		    }
		
		    static httpChange(methodType, url, queryParams, data, commandParam) {
				return new Promise((resolve, reject) => {
				    let authorization = commandParam ? AppUtils.basicAuth(commandParam.username, commandParam.password) : undefined;
				    const headers = new Headers();
				    headers.append("Content-Type", "application/json");
				    headers.append("Accept", "text/plain");
				    if (authorization !== undefined) {
				        headers.append("Authorization", authorization);
				    }
				
				    const options = {
				        method: methodType,
				        headers: headers,
				        mode: 'cors',
				        cache: 'no-cache',
				        body: JSON.stringify(data)
				    };
				
				    const adjustedUrl = AppUtils.url(url);
				    const completeUrl = adjustedUrl + AppUtils.queryParamString(adjustedUrl, queryParams);
				    const request = new Request(completeUrl, options);
				
				    fetch(request).then(function (response) {
				        if (response.status >= 300) {
				            const status = {
				                code: response.status,
				                text: response.statusText
				            };
				            reject(status);
				        } else {
				            return response.text();
				        }
				    }).then(function (data) {
				        resolve(data);
				    }).catch(function (error) {
				        const status = {
				            code: error.name,
				            text: error.message
				        };
				        reject(status);
				    });
				});
		    }
		
		    static httpPost(url, queryParams, data, commandParam) {
		        return AppUtils.httpChange("POST", url, queryParams, data, commandParam);
		    }
		
		    static httpPut(url, queryParams, data, commandParam) {
		        return AppUtils.httpChange("PUT", url, queryParams, data, commandParam);
		    }
		
		    static httpDelete(url, queryParams, data, commandParam) {
		        return AppUtils.httpChange("DELETE", url, queryParams, data, commandParam);
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
		
		    static url(url) {
		        if (ACEController.execution !== ACEController.E2E) {
		            return url;
		        } else {
		            return url.replace('api', 'replay');
		        }
		    }
		
			static basicAuth(user, password) {
				// implement your basic auth
			    return undefined;
			}

		    static createUUID() {
		    		// return a uuid, you could use npm package uuid
		        //return uuid.v4();
		    }
		
		    static saveBug(description, reporter) {
				const browser = AppUtils.getBrowserInfo();
		        const data = {
		            description: description,
		            reporter: reporter,
		            timeline: JSON.stringify(ACEController.timeline),
					clientVersion: AppUtils.getClientVersion(),
					device: browser.name + " " + browser.version
		        };
		        return AppUtils.httpPost('api/bug/create', null, data);
		    }
		
		    static deleteBug(id) {
		        let queryParams = [
		            {
		                key: "id",
		                value: id
		            }
		        ];
		        return AppUtils.httpDelete('api/bug/delete', queryParams);
		    }
		
		    static resolveBug(id) {
		        let queryParams = [
		            {
		                key: "id",
		                value: id
		            }
		        ];
		        return AppUtils.httpDelete('api/bug/resolve', queryParams);
		    }
		
		    static loadBugs() {
		        return AppUtils.httpGet('api/bug/all');
		    }
		
			static loadBug(id) {
			    let queryParams = [
			        {
			            key: "id",
			            value: id
			        }
			    ];
			    return AppUtils.httpGet('api/bug/single', queryParams);
			}

		    static getBrowserInfo() {
		        let ua = navigator.userAgent, tem,
		            M = ua.match(/(opera|chrome|safari|firefox|msie|trident(?=\/))\/?\s*(\d+)/i) || [];
		        if (/trident/i.test(M[1])) {
		            tem = /\brv[ :]+(\d+)/g.exec(ua) || [];
		            return {name: 'IE ', version: (tem[1] || '')};
		        }
		        if (M[1] === 'Chrome') {
		            tem = ua.match(/\bOPR\/(\d+)/)
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
		
		    static displayUnexpectedError(error) {
		    }
		
		}
		
		/*       S.D.G.       */
		
	'''
	
	def generateAppStub(Project it) '''
		import AppUtils from "./AppUtils";
		
		export * from "../../gen/ace/Scenario";
		export * from "../../gen/ace/Bug";
		
		AppUtils.start();
		
		// add EventListenerRegistration.init() of all modules
		// add ActionFactoryRegistrationTodo.init() of all modules
		
		/*       S.D.G.       */
		
	'''
	
	def generateReplayUtilsStub(Project it) '''
		import ACEController from "../../gen/ace/ACEController";
		import AppUtils from "./AppUtils";
		
		export default class ReplayUtils {
		
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
		
		    static resetDatabase() {
		        return AppUtils.httpDelete('replay/database/reset');
		    }
		
		    static prepareAction(uuid) {
		        if (ACEController.execution === ACEController.E2E) {
		            return AppUtils.httpPut('replay/database/prepare?uuid=' + uuid);
		        } else {
		            return new Promise((resolve) => {
		                resolve();
		            });
		        }
		    }
		
		    static replay(pauseInMillis) {
		        ACEController.startReplay(ACEController.REPLAY, pauseInMillis)
		    }
		
		    static e2e(pauseInMillis) {
		        ACEController.startReplay(ACEController.E2E, pauseInMillis)
		    }
		
		    static finishReplay() {
		        const normalized = ReplayUtils.normalizeTimelines(ACEController.expectedTimeline, ACEController.actualTimeline);
		        const result = JSON.stringify(normalized.expected, ReplayUtils.itemStringifyReplacer) === JSON.stringify(normalized.actual, ReplayUtils.itemStringifyReplacer);
		
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
		                    console.log("%cSUCCESS", "color: green;", item);
		                } else {
		                    console.log("%cFAILURE", "color: red;", item);
		                }
		            }
		        }
		        if (result === true) {
		            console.log("%c===============", "color: green;");
		            console.log("%c=== SUCCESS ===", "color: green;");
		            console.log("%c===============", "color: green;");
		        } else {
		            console.log("%c===============", "color: red;");
		            console.log("%c=== FAILURE ===", "color: red;");
		            console.log("%c===============", "color: red;");
		        }
				if (ReplayUtils.scenarioConfig.finishReplay) {
				    ReplayUtils.scenarioConfig.finishReplay(normalized, result);
				}
		    }
		
		    static compareItems(expected, actual) {
		        return JSON.stringify(expected, ReplayUtils.itemStringifyReplacer) === JSON.stringify(actual, ReplayUtils.itemStringifyReplacer);
		    }
		
		
		    static itemStringifyReplacer(key, value) {
		        if (key === 'timestamp') {
		            return undefined;
		        } else {
		            return value;
		        }
		    }
		
		    static saveScenario(description, creator) {
		        const browser = AppUtils.getBrowserInfo();
		        const data = {
		            description,
		            timeline: JSON.stringify(ACEController.timeline),
		            creator,
		            clientVersion: AppUtils.getClientVersion(),
		            device: browser.name + " " + browser.version
		        };
		        return AppUtils.httpPost('api/scenario/create', null, data);
		    }
		
		    static deleteScenario(id) {
		        let queryParams = [
		            {
		                key: "id",
		                value: id
		            }
		        ];
		        return AppUtils.httpDelete('api/scenario/delete', queryParams);
		    }
		
		    static loadScenarios() {
		        return AppUtils.httpGet('api/scenario/all');
		    }
		
		    static loadScenario(id) {
		        let queryParams = [];
		        queryParams.push({
		            key: "id",
		            value: id
		        });
		        return AppUtils.httpGet('api/scenario/single', queryParams);
		    }
		
		    static saveScenarioResult(normalized, result) {
		        const browser = AppUtils.getBrowserInfo();
		        const data = {
		            description: ReplayUtils.scenarioConfig.description,
		            scenarioId: ReplayUtils.scenarioConfig.scenarioId,
		            timeline: JSON.stringify(normalized),
		            executor: ReplayUtils.scenarioConfig.executor,
		            e2e: ReplayUtils.scenarioConfig.e2e,
		            result,
		            clientVersion: AppUtils.getClientVersion(),
		            device: browser.name + " " + browser.version
		        };
		        return AppUtils.httpPost('api/scenario-result/create', null, data);
		    }
		
		
		}
		
		/*       S.D.G.       */
		
	'''
	
	def generateACEController() '''
		import AppUtils from "../../src/app/AppUtils";
		import ReplayUtils from "../../src/app/ReplayUtils";
		import {runScenario} from "./Scenario";
		
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
		        ACEController.timelineSize = 200;
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
		            ACEController.timeline.push(JSON.parse(JSON.stringify(item)));
		            if (ACEController.timeline.length > ACEController.timelineSize) {
		                let i;
		                for (i = 1; i < ACEController.timeline.length; i++) {
		                    if (ACEController.timeline[i].action && ACEController.timeline[i].action.isInitAction) {
		                        break;
		                    }
		                }
		                if (i < ACEController.timeline.length) {
		                    for (let j = 0; j < i; j++) {
		                        ACEController.timeline.shift();
		                    }
		                }
		            }
		        } else {
		            ACEController.actualTimeline.push(JSON.parse(JSON.stringify(item)));
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
		            action.applyAction().then(() => {
		            }, (error) => {
		                ACEController.actionIsProcessing = false;
		                console.error(error + "\n" + action.actionName);
		                AppUtils.displayUnexpectedError(error + "\n" + action.actionName);
		            });
		        } else if (action === undefined) {
		            ACEController.actionIsProcessing = false;
		            if (ACEController.execution !== ACEController.LIVE) {
		                ACEController.timeline = [];
		                ACEController.actionIsProcessing = false;
		                ACEController.actionQueue = [];
		                ACEController.execution = ACEController.LIVE;
		                ReplayUtils.finishReplay();
		                AppUtils.start();
		            }
		        }
		    }
		
		    static triggerAction(action) {
		        ACEController.addActionToQueue(action);
		    }
		
		    static startReplay(level, pauseInMillis) {
		        ACEController.actualTimeline = [];
		        ACEController.execution = level;
		        ACEController.pauseInMillis = pauseInMillis;
		
		        if (ACEController.execution === ACEController.REPLAY) {
		            ACEController.readTimelineAndCreateReplayActions();
		        } else {
		            ReplayUtils.resetDatabase().then(
		                () => {
		                    ACEController.readTimelineAndCreateReplayActions();
		                },
		                (error) => {
		                    throw error;
		                }
		            );
		        }
		
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
		                const actionParam = item.action.actionParam;
		                let action = ACEController.factories[item.action.actionName](actionParam);
		                action.actionData.uuid = item.action.actionData.uuid;
		                actions.push(action);
		            }
		        }
		
		        ACEController.actionQueue = actions;
		
		        ACEController.applyNextActions();
		    }
		
		    static getCommandByUuid(uuid) {
		        for (let i = 0; i < ACEController.expectedTimeline.length; i++) {
		            let item = ACEController.expectedTimeline[i];
		            if (item.command && item.command.commandParam.uuid === uuid) {
		                return item.command;
		            }
		        }
		    }
		
		}
		
		ACEController.init();
		
		/*       S.D.G.       */
		
	'''
	
	def generateScenario() '''
		import ReplayUtils from "../../src/app/ReplayUtils";
		import AppUtils from "../../src/app/AppUtils";
		import ACEController from "./ACEController";
		
		export function runScenarioE2E(scenarioId, pauseInMillis = 250, executor = "unknown") {
		    ReplayUtils.loadScenario(scenarioId).then((scenario) => {
		        ReplayUtils.scenarioConfig = {
		            executor,
		            scenarioId,
		            e2e: true,
					finishReplay: ReplayUtils.saveScenarioResult
		        };
		        ACEController.expectedTimeline = JSON.parse(scenario.timeline);
		        ReplayUtils.e2e(pauseInMillis);
		    });
		}
		
		export function runScenarioReplay(scenarioId, pauseInMillis = 250, executor = "unknown") {
		    ReplayUtils.loadScenario(scenarioId).then((scenario) => {
		        ReplayUtils.scenarioConfig = {
		            executor,
		            scenarioId,
		            e2e: false,
					finishReplay: ReplayUtils.saveScenarioResult
		        };
		        ACEController.expectedTimeline = JSON.parse(scenario.timeline);
		        ReplayUtils.replay(pauseInMillis);
		    });
		}
		
		export function saveScenario(description, creator) {
			ReplayUtils.saveScenario(description, creator).then((id) => {
			    console.log(`saved scenario with id ${id}`);
				ACEController.timeline = [];
				AppUtils.start();
			});
		}
		
		export function displayScenarios() {
		    ReplayUtils.loadScenarios().then((scenarios) => {
		        scenarios.forEach((scenario) => {
		            console.log("scenario", scenario)
		        })
		    });
		}
		
		/*       S.D.G.       */
		
	'''

	def generateBug() '''
		import ReplayUtils from "../../src/app/ReplayUtils";
		import AppUtils from "../../src/app/AppUtils";
		import ACEController from "./ACEController";
		
		export function runBugE2E(bugId, pauseInMillis = 250, description = "unknown", executor = "unknown") {
		    AppUtils.loadBug(bugId).then((bug) => {
		        ReplayUtils.scenarioConfig = {
		            executor,
		            bugId,
		            description,
		            e2e: true
		        };
		        ACEController.expectedTimeline = JSON.parse(bug.timeline);
		        ReplayUtils.e2e(pauseInMillis);
		    });
		}
		
		export function runBugReplay(bugId, pauseInMillis = 250, description = "unknown", executor = "unknown") {
		    AppUtils.loadBug(bugId).then((bug) => {
		        ReplayUtils.scenarioConfig = {
		            executor,
		            bugId,
		            description,
		            e2e: false
		        };
		        ACEController.expectedTimeline = JSON.parse(bug.timeline);
		        ReplayUtils.replay(pauseInMillis);
		    });
		}
		
		export function saveBug(description, creator) {
			AppUtils.saveBug(description, creator).then((id) => {
			    console.log(`saved bug with id ${id}`);
			});
		}
		
		export function deleteBug(id) {
		    AppUtils.deleteBug(id);
		}
		
		export function resolveBug(id) {
		    AppUtils.resolveBug(id);
		}
		
		export function displayBugs() {
		    AppUtils.loadBugs().then((bugs) => {
		        bugs.forEach((bug) => {
		            console.log("bug", bug)
		        })
		    });
		}
		
		/*       S.D.G.       */
		
	'''

	def generateTriggerAction() '''
		import Event from "./Event";
		
		export default class TriggerAction extends Event {
		    constructor(action) {
		        super(action, 'TriggerAction');
		        this.eventData = action;
		    }
		
		    prepareDataForView() {
		    }
		}
		
		/*       S.D.G.       */
		
	'''
}
