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
		
		
		import * as App from "./App";
		import * as AppState from "../../gen/ace/AppState";
		import Utils from "../../gen/ace/Utils";
		
		export function dumpAppState() {
		    console.log(AppState.getAppState());
		}

		export default class AppUtils {
		
		    static initEventListenersAndActionFactories() {
		        //EventListenerRegistration.init();
		        //EventFactoryRegistration.init();
		    }
		
		    static startApp() {
		        Utils.loadSettings().then(() => {
		        	// call init action
		        });
		    }
		
		    static startReplay() {
		    }
		
		    static createInitialAppState() {
		        const initialAppState = {
		        };
		        AppState.setInitialAppState(initialAppState);
		    }
		
		    static renderNewState() {
		    	// render AppState.getAppState()
		    }
		
		    static createHeaders(authorize) {
		        const headers = new Headers();
		        headers.append("Content-Type", "application/json");
		        headers.append("Accept", "application/json");
		        if (authorize === true) {
		            let authorization = AppUtils.basicAuth();
		            if (authorization !== undefined) {
		                headers.append("Authorization", authorization);
		            }
		        }
		        return headers;
		    }
		
		    static addUuidToUrl(url, uuid) {
		        if (uuid) {
		            if (url.indexOf("?") < 0) {
		                url += "?uuid=" + uuid;
		            } else {
		                url += "&uuid=" + uuid;
		            }
		        }
		        return url;
		    }
		
		    static httpRequest(methodType, url, uuid, authorize, data) {
		        return new Promise((resolve, reject) => {
		            const options = {
		                method: methodType,
		                headers: AppUtils.createHeaders(authorize),
		                mode: 'cors',
		                cache: 'no-cache'
		            };
		            if (data && methodType !== "GET") {
		                options.body = JSON.stringify(data);
		            }
		            url = AppUtils.addUuidToUrl(url, uuid);
		            const request = new Request(url, options);
		
		            fetch(request).then(function (response) {
		                response.text().then((text) => {
		                    if (response.status >= 300) {
		                        const error = {
		                            code: response.status,
		                            text: response.statusText,
		                            key: text
		                        };
		                        reject(error);
		                    } else {
		                        let data = {};
		                        if (text.length > 0) {
		                            data = JSON.parse(text);
		                        }
		                        resolve(data);
		                    }
		                });
		            }).catch(function (error) {
		                const status = {
		                    code: error.name,
		                    text: error.message
		                };
		                reject(status);
		            });
		        });
		    }
		
		    static httpGet(url, uuid, authorize) {
		        return AppUtils.httpRequest("GET", url, uuid, authorize, null);
		    }
		
		    static httpPost(url, uuid, authorize, data) {
		        return AppUtils.httpRequest("POST", url, uuid, authorize, data);
		    }
		
		    static httpPut(url, uuid, authorize, data) {
		        return AppUtils.httpRequest("PUT", url, uuid, authorize, data);
		    }
		
		    static httpDelete(url, uuid, authorize, data) {
		        return AppUtils.httpRequest("DELETE", url, uuid, authorize, data);
		    }
		
		    static basicAuth() {
		        return "<your authorization>";
		    }
		
		    static createUUID() {
		        let d = new Date().getTime();
		        return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
		            let r = (d + Math.random() * 16) % 16 | 0;
		            d = Math.floor(d / 16);
		            return (c === 'x' ? r : (r & 0x3 | 0x8)).toString(16);
		        });
		    }
		
		    static displayUnexpectedError(error) {
		        console.error("unexpected error ", error);
		    }
		
		    static deepCopy(object) {
		        return JSON.parse(JSON.stringify(object));
		    }
		
		}

		«sdg»
		
	'''
	
	def generateAppStub() '''
		«copyright»


		import AppUtils from "./AppUtils";
		
		//import Container from "../web/Container";
		
		import React from "react";
		import ReactDOM from "react-dom";
		
		export * from "../../gen/ace/Timeline";
		export { dumpAppState } from "./AppUtils";
		
		AppUtils.createInitialAppState();
		
		/*export const container = ReactDOM.render(
		    <Container/>,
		    document.getElementById('root')
		);*/
		
		window.onhashchange = () => {
		};
		
		AppUtils.initEventListenersAndEventFactories();
		AppUtils.startApp();
		
		
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
		        ACEController.actionQueue = [];
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
		    	if (Utils.settings && Utils.settings.timelineSize > 0) {
				    ACEController.timeline.push(AppUtils.deepCopy(item));
					if (ACEController.timeline.length > Utils.settings.timelineSize) {
					    ACEController.timeline.shift();
					    while (ACEController.timeline.length > 0 && ACEController.timeline.length > 0 && !ACEController.timeline[0].appState) {
					        ACEController.timeline.shift();
					    }
					}
				}
		    }
		
		    static addActionToQueue(action) {
				ACEController.actionQueue.push(action);
			    ACEController.applyNextActions();
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
		        }
		    }
		    
		    static callApplyNextActions() {
				ACEController.applyNextActions();
		    }
		
		    static triggerAction(action) {
		        ACEController.addActionToQueue(action);
		    }
		
		    static startReplay(timeline, pauseInMillis) {
			    AppUtils.startReplay();

		        let events = [];
				
				let appStateWasSet = false;
		        for (let i = 0; i < timeline.length; i++) {
		            let item = timeline[i];
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
		
				setTimeout(() => ACEController.replayNextEvent(events, pauseInMillis), pauseInMillis);
		    }
		    
		    static replayNextEvent(events, pauseInMillis) {
		        let event = events.shift();
		        if (event) {
		        	event.replay();
		        	setTimeout(() => ACEController.replayNextEvent(events, pauseInMillis), pauseInMillis);
			    } else {
			        setTimeout(() => ACEController.finishReplay(), pauseInMillis);
			    }
			}
			
			static finishReplay() {
			    console.log("replay finished");
			    ACEController.timeline = [];
			    ACEController.actionQueue = [];
			    AppUtils.createInitialAppState();
			    AppUtils.startApp();
			}
		
		
		}
		
		ACEController.init();
		
		
		«sdg»
		
		
	'''
	
	def generateTimeline() '''
		«copyright»

		import AppUtils from "../../src/app/AppUtils";
		import ACEController from "./ACEController";
		import Utils from "./Utils";
		
		export function replayTimeline(timelineId, pauseInMillis = 100) {
			if (pauseInMillis < 100) {
				pauseInMillis = 100;
			}
		    Utils.loadTimeline(timelineId).then((scenario) => {
		        AppUtils.createInitialAppState();
		        ACEController.startReplay(JSON.parse(scenario.timeline), pauseInMillis)
		    });
		}
		
		export function saveTimeline(description, creator) {
		    Utils.saveTimeline(description, creator).then((id) => {
		        console.log(`saved timeline with id ${id}`);
		    });
		}
		
		export function dumpTimeline() {
		    console.log(ACEController.timeline);
		}
		
		
		«sdg»
		
		
	'''

	def generateUtils() '''
		«copyright»

		import AppUtils from "../../src/app/AppUtils";
		import ACEController from "./ACEController";
		
		export default class Utils {
		
		    static getServerInfo() {
		        return AppUtils.httpGet(Utils.settings.rootPath + '/server/info');
		    }
		    
			static loadSettings() {
			    return AppUtils.httpRequest("GET", "settings.json").then((settings) => {
			        Utils.settings = settings;
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
					if (!Utils.settings.mode) {
					    Utils.settings.mode = "live";
					}
			        if (Utils.settings.rootPath.startsWith("/")) {
			            Utils.settings.rootPath = Utils.settings.rootPath.substring(1);
			        }
			        if (Utils.settings.rootPath.endsWith("/")) {
			            Utils.settings.rootPath = Utils.settings.rootPath.substring(0, Utils.settings.rootPath.length - 1);
			        }
			    });
			}
		
		    static saveTimeline(description, creator) {
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
		            return AppUtils.httpPost(Utils.settings.aceScenariosBaseUrl + 'api/client-timeline/create', uuid, false, data).then(() => {
		                return new Promise((resolve) => {
		                    resolve(uuid);
		                });
		            });
		        });
		    }
		
		    static loadTimeline(id) {
		        return AppUtils.httpGet(Utils.settings.aceScenariosBaseUrl + `api/timeline?id=${id}&apiKey=${Utils.settings.aceScenariosApiKey}`, AppUtils.createUUID(), false);
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
				if (eventData.«getName») {
					localStorage.setItem("«getName»", eventData.«getName»);
				} else {
					localStorage.removeItem("«getName»");
				}
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
		«mergeStateFunction»
		«childAttributes»
	'''
	
	def dispatch String generateAppStateRec(GroupedClientAttribute it) '''
		«IF attributeGroup === null || attributeGroup.length > 0»
			«FOR attribute : attributeGroup»
				«IF attribute instanceof SingleClientAttribute»
					«attribute.getStateFunction»
					«attribute.setStateFunction»
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
	
	
