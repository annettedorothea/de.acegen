package com.anfelisa.generator

import com.anfelisa.ace.ACE
import com.anfelisa.ace.Outcome
import com.anfelisa.ace.Project
import com.anfelisa.ace.View
import com.anfelisa.extensions.AceExtension
import com.anfelisa.extensions.ProjectExtension
import com.anfelisa.extensions.ViewExtension
import javax.inject.Inject

class ES6Template {
	
	@Inject
	extension AceExtension

	@Inject
	extension ViewExtension
	
	@Inject
	extension ProjectExtension
	
	def generateAbstractActionFile(ACE it, Project project) '''
		import Action from "../../ace/Action";
		«IF outcomes.size > 0»
			import «commandName» from "../../../src/«project.name»/commands/«commandName»";
	    «ENDIF»
		«FOR view : preAndPostUpdateUIViews»
			import «view.viewName» from "../../../src/«(view.eContainer as Project).name»/views/«view.viewName»";
		«ENDFOR»

		export default class «abstractActionName» extends Action {
		
		    constructor(actionParam) {
		        super(actionParam, '«project.name».«actionName»', «IF init»true«ELSE»false«ENDIF»);
		    }
		
			«IF outcomes.size > 0»
				getCommand() {
					return new «commandName»(this.actionData);
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

	def generateInitialActionFile(ACE it, Project project) '''
		import «abstractActionName» from "../../../gen/«project.name»/actions/«abstractActionName»";
		
		export default class «actionName» extends «abstractActionName» {
		
		    initActionData() {
		    }
		
		}
		
		/*       S.D.G.       */
	'''
	
	def generateAbstractCommandFile(ACE it, Project project) '''
		import Command from "../../../gen/ace/Command";
		import TriggerAction from "../../../gen/ace/TriggerAction";
		«FOR outcome : outcomes»
			«IF outcome.listeners.size > 0»
				import «eventName(outcome)» from "../../../src/«project.name»/events/«eventName(outcome)»";
			«ENDIF»
		«ENDFOR»
		«FOR aceOperation : triggeredAceOperations»
			import «aceOperation.actionName» from "../../../src/«(aceOperation.eContainer as Project).name»/actions/«aceOperation.actionName»";
		«ENDFOR»
		
		export default class «abstractCommandName» extends Command {
		    constructor(commandParam) {
		        super(commandParam, "«project.name».«commandName»");
		        «FOR outcome : outcomes»
		        	this.«outcome.name» = "«outcome.name»";
		        «ENDFOR»
		    }
		
		    publishEvents() {
				let promises = [];
			    	
				switch (this.commandData.outcome) {
				«FOR outcome : outcomes»
					case this.«outcome.name»:
						«IF outcome.listeners.size > 0»
							promises.push(new «eventName(outcome)»(this.commandData).publish());
						«ENDIF»
						«FOR aceOperation : outcome.aceOperations»
							promises.push(new TriggerAction(new «aceOperation.actionName»(this.commandData)).publish());
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
	
	def generateInitialCommandFile(ACE it, Project project) '''
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
	
	def generateAbstractEventFile(ACE it, Outcome outcome, Project project) '''
		import Event from "../../../gen/ace/Event";
		
		export default class «abstractEventName(outcome)» extends Event {
		    constructor(eventParam) {
		        super(eventParam, '«project.name».«eventName(outcome)»');
		    }
			getNotifiedListeners() {
			    return [ «FOR listener : outcome.listeners SEPARATOR ', '»"«(listener.eContainer as View).viewNameWithPackage».«listener.name»"«ENDFOR» ];
			}
		}
		
		
		/*       S.D.G.       */
	'''
	def generateInitialEventFile(ACE it, Outcome outcome, Project project) '''
		import «abstractEventName(outcome)» from "../../../gen/«project.name»/events/«abstractEventName(outcome)»";
		import AppUtils from "../../app/AppUtils";
		
		export default class «eventName(outcome)» extends «abstractEventName(outcome)» {
		    prepareDataForView() {
		        this.eventData = AppUtils.deepCopy(this.eventParam);
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
				«FOR aceOperation : aceOperations»
					«FOR outcome : aceOperation.outcomes»
						«FOR listener : outcome.listeners»
							ACEController.registerListener('«name».«aceOperation.eventName(outcome)»', «listener.viewFunctionWithViewName»);
						«ENDFOR»
					«ENDFOR»
				«ENDFOR»
			}
		
		}
		
		/*       S.D.G.       */
	'''
	def generateActionFactoryRegistration(Project it) '''
		import ACEController from "../ace/ACEController";
		«FOR aceOperation : aceOperations»
			import «aceOperation.actionName» from "../../src/«name»/actions/«aceOperation.actionName»";
		«ENDFOR»
		
		export default class ActionFactoryRegistration«projectName» {
		
			static init() {
				«FOR aceOperation : aceOperations»
					ACEController.registerFactory('«name».«aceOperation.actionName»', (actionParam) => new «aceOperation.actionName»(actionParam));
				«ENDFOR»
			}
		
		}
		
		/*       S.D.G.       */
	'''
	def generateActionFunctionExports(Project it) '''
		«FOR aceOperation : aceOperations»
			import «aceOperation.actionName» from "../../src/«name»/actions/«aceOperation.actionName»";
		«ENDFOR»
		
		«FOR aceOperation : aceOperations»
			export function «aceOperation.name.toFirstLower»(actionParam) {
			    new «aceOperation.actionName»(actionParam).apply();
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
		        this.actionParam = AppUtils.deepCopy(actionParam);
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
		import Utils from "./Utils";
		
		export default class Command {
		    constructor(commandParam, commandName) {
		        this.commandName = commandName;
		        this.commandParam = AppUtils.deepCopy(commandParam);
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
		        return Utils.prepareAction(this.commandParam.uuid).then(() => {
		            queryParams = this.addUuidToQueryParams(queryParams);
		            return AppUtils.httpGet(url, queryParams, this.commandParam);
		        }, (error) => {
		            reject(error);
		        });
		    }
		
		    httpPost(url, queryParams, data) {
		        return Utils.prepareAction(this.commandParam.uuid).then(() => {
		            queryParams = this.addUuidToQueryParams(queryParams);
		            data = this.addUuidToData(data);
		            return AppUtils.httpPost(url, queryParams, data, this.commandParam);
		        }, (error) => {
		            reject(error);
		        });
		    }
		
		    httpPut(url, queryParams, data) {
		        return Utils.prepareAction(this.commandParam.uuid).then(() => {
		            queryParams = this.addUuidToQueryParams(queryParams);
		            data = this.addUuidToData(data);
		            return AppUtils.httpPut(url, queryParams, data, this.commandParam);
		        }, (error) => {
		            reject(error);
		        });
		    }
		
		    httpDelete(url, queryParams, data) {
		        return Utils.prepareAction(this.commandParam.uuid).then(() => {
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
		import AppUtils from "../../src/app/AppUtils";
		
		export default class Event {
		    constructor(eventParam, eventName) {
		        this.eventName = eventName;
		        this.eventParam = AppUtils.deepCopy(eventParam);
		    }
		
		    prepareDataForView() {
		        throw "no prepareDataForView method defined for " + this.eventName;
		    }

		    getNotifiedListeners() {
		        return [];
		    }
		
		    publish() {
		        return new Promise((resolve, reject) => {
		            this.prepareDataForView();
					if (this.eventName !== "TriggerAction") {
					    this.eventData.notifiedListeners = this.getNotifiedListeners();
					}
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
		
		    static getApiKey() {
		        return "API-KEY";
		    }
		
		    static getAceScenariosBaseUrl() {
		        return "http://127.0.0.1:8070/";
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
		        // return uuid.v4();
		    }
		
		    static displayUnexpectedError(error) {
		    }

			static deepCopy(object) {
			    return JSON.parse(JSON.stringify(object));
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
		            ACEController.timeline.push(AppUtils.deepCopy(item));
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
		                Utils.finishReplay();
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
		import AppUtils from "../../src/app/AppUtils";
		import ReplayUtils from "../../src/app/ReplayUtils";
		import ACEController from "./ACEController";
		import Utils from "./Utils";
		
		export function runScenario(scenarioId, executor = "unknown", pauseInMillis = 0) {
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
		
		export function runAllScenarios(executor = "unknown", pauseInMillis = 0) {
		    Utils.loadNextScenario(-1).then((scenario) => {
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
		
		export function saveScenario(description, creator) {
		    Utils.saveScenario(description, creator).then((id) => {
		        console.log(`saved scenario with id ${id}`);
		        ACEController.timeline = [];
		        AppUtils.start();
		    });
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
		                apiKey: AppUtils.getApiKey(),
		                serverVersion: serverInfo.serverVersion
		            };
		            return AppUtils.httpPost(AppUtils.getAceScenariosBaseUrl() + 'api/bugs/create', [], data);
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
		            value: AppUtils.getApiKey()
		        });
		        queryParams.push({
		            key: "uuid",
		            value: uuid
		        });
		        return AppUtils.httpGet(AppUtils.getAceScenariosBaseUrl() + 'api/bugs/get', queryParams);
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
		                    apiKey: AppUtils.getApiKey(),
		                    serverVersion: serverInfo.serverVersion
		                };
		                return AppUtils.httpPost(AppUtils.getAceScenariosBaseUrl() + 'api/scenarios/create', [], data);
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
		                    apiKey: AppUtils.getApiKey(),
		                    serverVersion: serverInfo.serverVersion,
		                    serverTimeline: JSON.stringify(serverTimeline)
		                };
		                return AppUtils.httpPost(AppUtils.getAceScenariosBaseUrl() + 'api/results/create', null, data);
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
		            value: AppUtils.getApiKey()
		        });
		        queryParams.push({
		            key: "uuid",
		            value: uuid
		        });
		        return AppUtils.httpGet(AppUtils.getAceScenariosBaseUrl() + 'api/scenarios/get', queryParams);
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
		            value: AppUtils.getApiKey()
		        });
		        queryParams.push({
		            key: "uuid",
		            value: uuid
		        });
		        return AppUtils.httpGet(AppUtils.getAceScenariosBaseUrl() + 'api/scenarios/next', queryParams);
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
		        ACEController.startReplay(ACEController.REPLAY, pauseInMillis)
		    }
		
		    static replayE2E(pauseInMillis, serverTimeline) {
		        AppUtils.httpPut('replay/e2e/start', [], JSON.parse(serverTimeline)).then(() => {
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
		        if (ReplayUtils.scenarioConfig.saveScenarioResult === true) {
		            const normalized = Utils.normalizeTimelines(ACEController.expectedTimeline, ACEController.actualTimeline);
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
}
