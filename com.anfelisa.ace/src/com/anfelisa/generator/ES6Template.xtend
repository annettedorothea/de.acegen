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
		import Action from "../../ace/«IF async»AsynchronousAction«ELSE»SynchronousAction«ENDIF»";
		«IF outcomes.size > 0»
			import «commandName» from "../../../src/«project.name»/commands/«commandName»";
	    «ENDIF»
		«FOR view : preAndPostUpdateUIViews»
			import «view.viewName» from "../../../src/«(view.eContainer as Project).name»/views/«view.viewName»";
		«ENDFOR»

		export default class «abstractActionName» extends Action {
		
		    constructor(actionData) {
		        super(actionData, '«project.name».«actionName»');
				«IF async»
					this.postUpdateUI = this.postUpdateUI.bind(this);
				«ENDIF»
		    }
		
			«IF outcomes.size > 0»
				getCommand() {
					return new «commandName»(this.actionData);
				}
			«ENDIF»
		
			«IF async»
				preUpdateUI() {
					«FOR viewFunction : preUpdateUI»
						«viewFunction.viewFunctionWithViewName»(this.actionData);
					«ENDFOR»
				}
			
				postUpdateUI() {
					«FOR viewFunction : postUpdateUI»
						«viewFunction.viewFunctionWithViewName»(this.actionData);
					«ENDFOR»
				}
			«ENDIF»
		
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
	
	def generateAsynchronousAbstractCommandFile(ACE it, Project project) '''
		import Command from "../../../gen/ace/«IF async»AsynchronousCommand«ELSE»SynchronousCommand«ENDIF»";
		import TriggerAction from "../../../gen/ace/TriggerAction";
		«FOR outcome : outcomes»
			«IF outcome.listeners.size > 0»
				import «eventName(outcome)» from "../../../gen/«project.name»/events/«eventName(outcome)»";
			«ENDIF»
		«ENDFOR»
		«FOR aceOperation : triggeredAceOperations»
			import «aceOperation.actionName» from "../../../src/«(aceOperation.eContainer as Project).name»/actions/«aceOperation.actionName»";
		«ENDFOR»
		
		export default class «abstractCommandName» extends Command {
		    constructor(commandData) {
		        super(commandData, "«project.name».«commandName»");
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
	
	def generateSynchronousAbstractCommandFile(ACE it, Project project) '''
		import Command from "../../../gen/ace/«IF async»AsynchronousCommand«ELSE»SynchronousCommand«ENDIF»";
		import TriggerAction from "../../../gen/ace/TriggerAction";
		«FOR outcome : outcomes»
			«IF outcome.listeners.size > 0»
				import «eventName(outcome)» from "../../../gen/«project.name»/events/«eventName(outcome)»";
			«ENDIF»
		«ENDFOR»
		«FOR aceOperation : triggeredAceOperations»
			import «aceOperation.actionName» from "../../../src/«(aceOperation.eContainer as Project).name»/actions/«aceOperation.actionName»";
		«ENDFOR»
		
		export default class «abstractCommandName» extends Command {
		    constructor(commandData) {
		        super(commandData, "«project.name».«commandName»");
		        «FOR outcome : outcomes»
		        	this.«outcome.name» = "«outcome.name»";
		        «ENDFOR»
		    }
		
		    publishEvents() {
				switch (this.commandData.outcome) {
				«FOR outcome : outcomes»
					case this.«outcome.name»:
						«IF outcome.listeners.size > 0»
							new «eventName(outcome)»(this.commandData).publish();
						«ENDIF»
						«FOR aceOperation : outcome.aceOperations»
							new TriggerAction(new «aceOperation.actionName»(this.commandData)).publish();
						«ENDFOR»
						break;
				«ENDFOR»
				default:
					throw '«commandName» unhandled outcome: ' + this.commandData.outcome;
				}
		    }
		}
		
		/*       S.D.G.       */
	'''
	
	def generateAsynchronousInitialCommandFile(ACE it, Project project) '''
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
	
	def generateSynchronousInitialCommandFile(ACE it, Project project) '''
		import «abstractCommandName» from "../../../gen/«project.name»/commands/«abstractCommandName»";
		
		export default class «commandName» extends «abstractCommandName» {
		    execute() {
		    }
		}
		
		/*       S.D.G.       */
	'''
	
	def generateAbstractEventFile(ACE it, Outcome outcome, Project project) '''
		import Event from "../../../gen/ace/Event";
		
		export default class «eventName(outcome)» extends Event {
		    constructor(eventData) {
		        super(eventData, '«project.name».«eventName(outcome)»');
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
					ACEController.registerFactory('«name».«aceOperation.actionName»', (actionData) => new «aceOperation.actionName»(actionData));
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
			export function «aceOperation.name.toFirstLower»(actionData) {
			    new «aceOperation.actionName»(actionData).apply();
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
		    constructor(actionData, actionName) {
		        this.actionName = actionName;
		        if (actionData === undefined) {
		            actionData = {};
		        }
		        this.actionData = AppUtils.deepCopy(actionData);
		    }
		
		    initActionData() {
		    }
		
		    extendActionData() {
		    }
		
		    getCommand() {
		        throw "no command defined for " + this.actionName;
		    }
		
		    apply() {
		        ACEController.addActionToQueue(this);
		    }
		}
		
		/*       S.D.G.       */
		
	'''
	
	def generateAsynchronousAction() '''
		import ACEController from "./ACEController";
		import Action from "./Action";
		import AppUtils from "../../src/app/AppUtils";
		
		export default class AsynchronousAction extends Action {

		    constructor(actionData, actionName) {
		    	super(actionData, actionName);
		        this.asynchronous = true;
		    }
			
		    applyAction() {
		        return new Promise((resolve, reject) => {
		            this.preUpdateUI();
		            if (ACEController.execution === ACEController.LIVE) {
		                this.actionData.uuid = AppUtils.createUUID();
		                this.extendActionData();
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
		                        reject(error);
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
	
	def generateSynchronousAction() '''
		import ACEController from "./ACEController";
		import Action from "./Action";
		import AppUtils from "../../src/app/AppUtils";
		
		export default class SynchronousAction extends Action {

		    constructor(actionData, actionName) {
		    	super(actionData, actionName);
		        this.asynchronous = false;
		    }

		    applyAction() {
		        if (ACEController.execution === ACEController.LIVE) {
		            this.actionData.uuid = AppUtils.createUUID();
		            this.extendActionData();
		        }
		        this.initActionData();
		        ACEController.addItemToTimeLine({action: this});
		        let command = this.getCommand();
		        if (command) {
		            command.executeCommand();
		        }
		    }
		}
		
		/*       S.D.G.       */
		
	'''

	def generateCommand() '''
		import AppUtils from "../../src/app/AppUtils";
		
		export default class Command {
		    constructor(commandData, commandName) {
		        this.commandName = commandName;
		        this.commandData = AppUtils.deepCopy(commandData);
		    }
		
		    execute() {
		        throw "no execute method defined for " + this.commandName;
		    }
		
		    publishEvents() {
		        throw "no publishEvents method defined for " + this.commandName;
		    }
		
		}
		
		/*       S.D.G.       */
		
	'''
	
	def generateAsynchronousCommand() '''
		import ACEController from "./ACEController";
		import Command from "./Command";
		import AppUtils from "../../src/app/AppUtils";
		import Utils from "./Utils";
		
		export default class AsynchronousCommand extends Command {
		    executeCommand() {
		        return new Promise((resolve, reject) => {
					if (ACEController.execution !== ACEController.REPLAY) {
					    this.execute().then(() => {
					        ACEController.addItemToTimeLine({command: this});
					        this.publishEvents();
					        resolve();
					    }, (error) => {
					        reject(error);
					    });
					} else {
					    const timelineCommand = ACEController.getCommandByUuid(this.commandData.uuid);
					    this.commandData = timelineCommand.commandData;
					    ACEController.addItemToTimeLine({command: this});
				        this.publishEvents();
				        resolve();
					}
		        });
		    }
		
		    httpGet(url, queryParams) {
		        return Utils.prepareAction(this.commandData.uuid).then(() => {
		            queryParams = this.addUuidToQueryParams(queryParams);
		            return AppUtils.httpGet(url, queryParams, this.commandData);
		        }, (error) => {
		            reject(error);
		        });
		    }
		
		    httpPost(url, queryParams, data) {
		        return Utils.prepareAction(this.commandData.uuid).then(() => {
		            queryParams = this.addUuidToQueryParams(queryParams);
		            data = this.addUuidToData(data);
		            return AppUtils.httpPost(url, queryParams, data);
		        }, (error) => {
		            reject(error);
		        });
		    }
		
		    httpPut(url, queryParams, data) {
		        return Utils.prepareAction(this.commandData.uuid).then(() => {
		            queryParams = this.addUuidToQueryParams(queryParams);
		            data = this.addUuidToData(data);
		            return AppUtils.httpPut(url, queryParams, data);
		        }, (error) => {
		            reject(error);
		        });
		    }
		
		    httpDelete(url, queryParams, data) {
		        return Utils.prepareAction(this.commandData.uuid).then(() => {
		            queryParams = this.addUuidToQueryParams(queryParams);
		            data = this.addUuidToData(data);
		            return AppUtils.httpDelete(url, queryParams, data);
		        }, (error) => {
		            reject(error);
		        });
		    }
		
		    addUuidToQueryParams(queryParams) {
		        if (!queryParams) {
		            queryParams = [];
		        }
		        if (this.commandData.uuid) {
		            queryParams.push({
		                key: "uuid",
		                value: this.commandData.uuid
		            });
		        }
		        return queryParams;
		    }
		
		    addUuidToData(data) {
		        if (!data) {
		            data = {};
		        }
		        if (this.commandData.uuid) {
		            data.uuid = this.commandData.uuid;
		        }
		        return data;
		    }
		
		}
		
		/*       S.D.G.       */
		
		
	'''
	
	def generateSynchronousCommand() '''
		import ACEController from "./ACEController";
		import Command from "./Command";
		
		export default class SynchronousCommand extends Command {
		    executeCommand() {
				if (ACEController.execution !== ACEController.REPLAY) {
				    this.execute();
				} else {
				    const timelineCommand = ACEController.getCommandByUuid(this.commandData.uuid);
				    this.commandData = timelineCommand.commandData;
				}
				ACEController.addItemToTimeLine({command: this});
				this.publishEvents();
		    }
		
		}
		
		/*       S.D.G.       */
		
		
	'''
	
	def generateEvent() '''
		import AppUtils from "../../src/app/AppUtils";
		import ACEController from "./ACEController";
		
		export default class Event {
		    constructor(eventData, eventName) {
		        this.eventName = eventName;
		        this.eventData = AppUtils.deepCopy(eventData);
		    }
		
		    publish() {
		        this.notifyListeners();
		        this.eventData.appState = AppUtils.getAppState();
				ACEController.addItemToTimeLine({event: this});
		    }
		
		    notifyListeners() {
		        let i, listener;
		        if (this.eventName !== undefined) {
		            const listenersForEvent = ACEController.listeners[this.eventName];
		            if (listenersForEvent !== undefined) {
		                for (i = 0; i < listenersForEvent.length; i += 1) {
		                    listener = listenersForEvent[i];
							listener(AppUtils.deepCopy(this.eventData));
		                }
		            }
		        }
		    }
		
		}
		
		/*       S.D.G.       */
		
		
	'''
	
	def generateAppUtilsStub(Project it) '''
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
		
		    static httpGet(url, queryParams, commandData, adjustUrl = true) {
				return new Promise((resolve, reject) => {
				    let authorization = AppUtils.basicAuth();
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
				
					let adjustedUrl = url;
					if (adjustUrl === true) {
					    adjustedUrl = AppUtils.url(url);
					}
				    const completeUrl = adjustedUrl + AppUtils.queryParamString(adjustedUrl, queryParams);
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
		
		    static httpChange(methodType, url, queryParams, data, adjustUrl = true) {
				return new Promise((resolve, reject) => {
				    let authorization = AppUtils.basicAuth();
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
				
					let adjustedUrl = url;
					if (adjustUrl === true) {
					    adjustedUrl = AppUtils.url(url);
					}
				    const completeUrl = adjustedUrl + AppUtils.queryParamString(adjustedUrl, queryParams);
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
		
		    static httpPost(url, queryParams, data) {
		        return AppUtils.httpChange("POST", url, queryParams, data);
		    }
		
		    static httpPut(url, queryParams, data) {
		        return AppUtils.httpChange("PUT", url, queryParams, data);
		    }
		
		    static httpDelete(url, queryParams, data) {
		        return AppUtils.httpChange("DELETE", url, queryParams, data);
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
		
			static basicAuth() {
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
	
	def generateAppStub(Project it) '''
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
		            return AppUtils.httpPost(AppUtils.getAceScenariosBaseUrl() + 'api/bugs/create', [], data, false);
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
		        return AppUtils.httpGet(AppUtils.getAceScenariosBaseUrl() + 'api/bugs/get', queryParams, {}, false);
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
		                return AppUtils.httpPost(AppUtils.getAceScenariosBaseUrl() + 'api/scenarios/create', [], data, false);
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
		                return AppUtils.httpPost(AppUtils.getAceScenariosBaseUrl() + 'api/results/create', null, data, false);
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
		        return AppUtils.httpGet(AppUtils.getAceScenariosBaseUrl() + 'api/scenarios/get', queryParams, {}, false);
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
		        return AppUtils.httpGet(AppUtils.getAceScenariosBaseUrl() + 'api/scenarios/next', queryParams, {}, false);
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
		        ReplayUtils.prepareReplay();
		        ACEController.startReplay(ACEController.REPLAY, pauseInMillis)
		    }
		
		    static replayE2E(pauseInMillis, serverTimeline) {
		        ReplayUtils.prepareReplay();
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
}
