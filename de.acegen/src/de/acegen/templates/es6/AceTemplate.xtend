/********************************************************************************
 * Copyright (c) 2020 Annette Pohl
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 ********************************************************************************/


 

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
		
			static initEventListenersAndEventFactories() {
				// add EventListenerRegistration.init() of all modules
				// add EventFactoryRegistration.init() of all modules
			}
		
		    static start() {
		        Utils.loadSettings().then(() => {
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
		
		    static httpGet(url, uuid, authorize) {
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
		
					if (uuid) {
			            if (url.indexOf("?") < 0) {
			            	url += "?uuid=" + uuid;
			            } else {
			            	url += "&uuid=" + uuid;
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
		
		    static httpChange(methodType, url, uuid, authorize, data) {
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
		
					if (uuid) {
					    if (url.indexOf("?") < 0) {
					        url += "?uuid=" + uuid;
					    } else {
					        url += "&uuid=" + uuid;
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
			                if (data) {
			                    resolve(JSON.parse(data));
			                } else {
			                    resolve();
			                }
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
		
		    static httpPost(url, uuid, authorize, data) {
		        return AppUtils.httpChange("POST", url, uuid, authorize, data);
		    }
		
		    static httpPut(url, uuid, authorize, data) {
		        return AppUtils.httpChange("PUT", url, uuid, authorize, data);
		    }
		
		    static httpDelete(url, uuid, authorize, data) {
		        return AppUtils.httpChange("DELETE", url, uuid, authorize, data);
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
		
		
		AppUtils.initEventListenersAndEventFactories();
		
		AppUtils.start();
		
		
		«sdg»
		
		
	'''
	
	def generateACEController() '''
		«copyright»

		import AppUtils from "../../src/app/AppUtils";
		import ReplayUtils from "../../src/app/ReplayUtils";
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
		        ACEController.execution = ACEController.UI;
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
		
		    static registerFactory(eventName, factory) {
		        if (!eventName.trim()) {
		            throw new Error('cannot register factory for empty eventName');
		        }
		        if (!factory) {
		            throw new Error('cannot register undefined factory for event ' + eventName);
		        }
		        ACEController.factories[eventName] = factory;
		    }
		
		    static addItemToTimeLine(item) {
		        let timestamp = new Date();
		        item.timestamp = timestamp.getTime();
				if (ACEController.execution === ACEController.UI && Utils.settings.timelineSize > 0) {
				    ACEController.timeline.push(AppUtils.deepCopy(item));
				    if (ACEController.timeline.length > Utils.settings.timelineSize) {
		                ACEController.timeline.shift();
				        while (ACEController.timeline.length > 0 && ACEController.timeline.length > 0 && !ACEController.timeline[0].appState) {
		                    ACEController.timeline.shift();
		                }
				    }
				} else if (ACEController.execution === ACEController.REPLAY) {
					console.log("replayed", item);
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
		            if (ACEController.execution === ACEController.REPLAY) {
				    	console.log("replay finished");
		                ACEController.timeline = [];
		                ACEController.actionIsProcessing = false;
		                ACEController.actionQueue = [];
		                ACEController.execution = ACEController.UI;
				    	ReplayUtils.tearDownReplay();
				    	AppUtils.createInitialAppState();
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
		
		    static startReplay(pauseInMillis) {
		        ACEController.execution = ACEController.REPLAY;
		        ACEController.pauseInMillis = pauseInMillis;
		        ACEController.readTimelineAndCreateReplayEvents();
		    }
		
		    static readTimelineAndCreateReplayEvents() {
		        let events = [];
				
				let appStateWasSet = false;
		        for (let i = 0; i < ACEController.expectedTimeline.length; i++) {
		            let item = ACEController.expectedTimeline[i];
		            if (item.event && appStateWasSet && item.event.eventName !== "TriggerAction") {
		                const eventData = item.event.eventData;
		                let event = ACEController.factories[item.event.eventName](eventData);
		                events.push(event);
		            }
					if (item.appState && !appStateWasSet) {
					    AppState.setInitialAppState(item.appState);
					    appStateWasSet = true;
					}
		            
		        }
		
		        ACEController.replayNextEvent(events);
		    }
		    
		    static replayNextEvent(events) {
		        let event = events.shift();
		        if (event) {
		        	event.publish();
		        	setTimeout(() => ACEController.replayNextEvent(events), ACEController.pauseInMillis);
		        } else {
					console.log("replay finished");
					ACEController.timeline = [];
					ACEController.actionIsProcessing = false;
					ACEController.actionQueue = [];
					ACEController.execution = ACEController.UI;
					ReplayUtils.tearDownReplay();
					AppUtils.createInitialAppState();
					AppUtils.start();
				}
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
	
	def generateBug() '''
		«copyright»

		import AppUtils from "../../src/app/AppUtils";
		import ReplayUtils from "../../src/app/ReplayUtils";
		import ACEController from "./ACEController";
		import Utils from "./Utils";
		
		export function runBug(bugId, pauseInMillis = 0) {
		    Utils.loadBug(bugId).then((scenario) => {
		        ReplayUtils.scenarioConfig = {};
		        ACEController.expectedTimeline = JSON.parse(scenario.timeline);
		        ReplayUtils.prepareReplay();
		        AppUtils.createInitialAppState();
		        ACEController.startReplay(pauseInMillis)
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
		        return AppUtils.httpGet(Utils.settings.rootPath + '/server/info');
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
		            }).then(function (settings) {
		                Utils.settings = settings;
		                if (!Utils.settings.development) {
		                    Utils.settings.development = false;
		                }
		                if (!Utils.settings.clientVersion) {
		                    Utils.settings.clientVersion = "";
		                }
		                if (!Utils.settings.aceScenariosApiKey) {
		                    Utils.settings.aceScenariosApiKey = "";
		                }
		                if (!Utils.settings.aceScenariosBaseUrl) {
		                    Utils.settings.aceScenariosBaseUrl = "";
		                }
		                if (!Utils.settings.rootPath) {
		                    Utils.settings.rootPath = "";
		                }
		                if (!Utils.settings.timelineSize) {
		                    Utils.settings.timelineSize = 0;
		                }
		                if (Utils.settings.rootPath.startsWith("/")) {
		                    Utils.settings.rootPath = Utils.settings.rootPath.substring(1);
		                }
		                if (Utils.settings.rootPath.endsWith("/")) {
		                    Utils.settings.rootPath = Utils.settings.rootPath.substring(0, Utils.settings.rootPath.length - 1);
		                }
		                resolve();
		            }).catch(function (error) {
		                reject(error);
		            });
				
		        });
		    }
		
		    static saveBug(description, creator) {
		        return Utils.getServerInfo().then((serverInfo) => {
		            const browser = Utils.getBrowserInfo();
		            const uuid = AppUtils.createUUID();
		            const data = {
		                description,
		                timeline: JSON.stringify(ACEController.timeline),
		                creator,
		                clientVersion: Utils.settings.clientVersion,
		                device: browser.name + " " + browser.version,
		                apiKey: Utils.settings.aceScenariosApiKey,
		                serverVersion: serverInfo.serverVersion
		            };
		            return AppUtils.httpPost(Utils.settings.aceScenariosBaseUrl + 'api/bugs/create', uuid, false, data).then(() => {
		                return new Promise((resolve) => {
		                    resolve(uuid);
		                });
		            });
		        });
		    }
		
		    static loadBug(id) {
		        return AppUtils.httpGet(Utils.settings.aceScenariosBaseUrl + `api/bugs/get?id=${id}&apiKey=${Utils.settings.aceScenariosApiKey}`, AppUtils.createUUID(), false);
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
	
	
