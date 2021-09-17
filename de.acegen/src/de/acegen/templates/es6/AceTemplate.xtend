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
import de.acegen.aceGen.HttpClient
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
		
		
		import * as AppState from "../../gen/ace/AppState";
		import * as Utils from "../../gen/ace/Utils";
		

		export let settings;

		function loadSettings() {
		    return httpGet("settings.json").then((loadedSettings) => {
		        settings = loadedSettings;
		        if (!settings.clientVersion) {
		            settings.clientVersion = "";
		        }
		        if (!settings.aceScenariosApiKey) {
		            settings.aceScenariosApiKey = "";
		        }
		        if (!settings.aceScenariosBaseUrl) {
		            settings.aceScenariosBaseUrl = "";
		        }
		        if (!settings.rootPath) {
		            settings.rootPath = "";
		        }
		        if (!settings.timelineSize) {
		            settings.timelineSize = 0;
		        }
				if (!settings.mode) {
				    settings.mode = "live";
				}
		        if (settings.rootPath.startsWith("/")) {
		            settings.rootPath = settings.rootPath.substring(1);
		        }
		        if (settings.rootPath.endsWith("/")) {
		            settings.rootPath = settings.rootPath.substring(0, settings.rootPath.length - 1);
		        }
		    });
		}
		
		export function initEventListeners() {
		    //EventListenerRegistration.init();
		}
		
		export function startApp() {
		    loadSettings().then(() => {
		    });
		}
		
		export function startReplay() {
		}
		
		export function createInitialAppState() {
		    const initialAppState = {
		    };
		    AppState.setInitialAppState(initialAppState);
		}
		
		function createHeaders(authorize) {
		    const headers = new Headers();
		    headers.append("Content-Type", "application/json");
		    headers.append("Accept", "application/json");
		    if (authorize === true) {
		        let authorization = basicAuth();
		        if (authorization !== undefined) {
		            headers.append("Authorization", authorization);
		        }
		    }
		    return headers;
		}
		
		function addUuidToUrl(url, uuid) {
		    if (uuid) {
		        if (url.indexOf("?") < 0) {
		            url += "?uuid=" + uuid;
		        } else {
		            url += "&uuid=" + uuid;
		        }
		    }
		    return url;
		}
		
		function httpRequest(methodType, url, uuid, authorize, data) {
		    return new Promise((resolve, reject) => {
		        const options = {
		            method: methodType,
		            headers: createHeaders(authorize),
		            mode: 'cors',
		            cache: 'no-cache'
		        };
		        if (data && methodType !== "GET") {
		            options.body = JSON.stringify(data);
		        }
		        url = addUuidToUrl(url, uuid);
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
		
		export function httpGet(url, uuid, authorize) {
		    return httpRequest("GET", url, uuid, authorize, null);
		}
		
		export function httpPost(url, uuid, authorize, data) {
		    return httpRequest("POST", url, uuid, authorize, data);
		}
		
		export function httpPut(url, uuid, authorize, data) {
		    return httpRequest("PUT", url, uuid, authorize, data);
		}
		
		export function httpDelete(url, uuid, authorize, data) {
		    return httpRequest("DELETE", url, uuid, authorize, data);
		}
		
		function basicAuth() {
		    return "<your authorization>";
		}
		
		export function createUUID() {
		    let d = new Date().getTime();
		    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
		        let r = (d + Math.random() * 16) % 16 | 0;
		        d = Math.floor(d / 16);
		        return (c === 'x' ? r : (r & 0x3 | 0x8)).toString(16);
		    });
		}
		
		export function displayUnexpectedError(error) {
		    console.error("unexpected error ", error);
		}
		
		export function deepCopy(object) {
		    return JSON.parse(JSON.stringify(object));
		}
		
		export function stateUpdated() {
		    // re-render app
		}
		
		export function renderApp() {
		}
		
		«sdg»
		
	'''
	
	def generateApp(HttpClient httpClient) '''
		«copyright»

		import * as AppUtils from "./app/AppUtils";
		import * as AppState from "../gen/ace/AppState";
		import * as ACEController from "../gen/ace/ACEController";
		
		export * from "../gen/ace/Timeline";

		export function dumpAppState() {
		    console.info(AppState.getAppState());
		}

		AppUtils.createInitialAppState();
		ACEController.addItemToTimeLine({
			appState: AppState.getAppState()
		});
		AppUtils.initEventListeners();
		AppUtils.startApp();
		AppUtils.renderApp();
		
		// for Selenium tests
		export function getAppState() {
		    return AppState.getAppState();
		}
		
		export function addSquishyValueClient(value) {
		    let squishyValues = JSON.parse(localStorage.getItem('squishyValues'));
		    if (!squishyValues) {
		        squishyValues = [];
		    }
		    squishyValues.push(value);
		    localStorage.setItem('squishyValues', JSON.stringify(squishyValues));
		}

		export function addSquishyValueServer(uuid, key, value) {
		    return new Promise((resolve, reject) => {
		        let url = "";
		        if (key === "system-time") {
		            url =`/api/test/squishy/system-time?uuid=${uuid}&system-time=${value}`;
		        } else {
		            url =`/api/test/squishy/value?uuid=${uuid}&key=${key}&value=${value}`
		        }
		        return new Promise((resolve, reject) => {
		            AppUtils.httpPut(url).then(() => {
		                resolve();
		            }, (error) => {
		                reject(error);
		            });
		        });
		    })
		}
		
		export function getValueFromLocalStorage(key) {
		    return localStorage.getItem(key);
		}
		
		
		«sdg»
		
		
	'''
	
	def generateACEController() '''
	«copyright»
	
	import * as AppUtils from "../../src/app/AppUtils";
	import * as AppState from "./AppState";
	import Event from "./Event";
	
	export let timeline = [];
	export let listeners = {};
	export let delayedActions = {};
	
	let actionQueue = [];

	export function registerListener(eventName, listener) {
	    if (!eventName.trim()) {
	        throw new Error('cannot register listener for empty eventName');
	    }
	    if (!listener) {
	        throw new Error('cannot register undefined listener for event ' + eventName);
	    }
	    let listenersForEventName;
	    if (listeners[eventName] === undefined) {
	        listeners[eventName] = [];
	    }
	    listenersForEventName = listeners[eventName];
	    listenersForEventName.push(listener);
	}
	
	export function addItemToTimeLine(item) {
		if (AppUtils.settings && AppUtils.settings.timelineSize > 0) {
		    timeline.push(AppUtils.deepCopy(item));
			if (timeline.length > AppUtils.settings.timelineSize) {
			    timeline.shift();
			    while (timeline.length > 0 && timeline.length > 0 && !timeline[0].appState) {
			        timeline.shift();
			    }
			}
		}
	}
	
	export function addActionToQueue(action) {
		actionQueue.push(action);
	    applyNextActions();
	}

	function applyNextActions() {
	    let nextAction = actionQueue.shift();
	    if (nextAction) {
			if (nextAction.action.asynchronous) {
	            nextAction.action.applyAction(nextAction.data).then(() => {
			    	applyNextActions();
			    }, (error) => {
			        AppUtils.displayUnexpectedError(error);
			    	applyNextActions();
			    });
			} else {
				try {
	                nextAction.action.applyAction(nextAction.data);
			    	applyNextActions();
				} catch(error) {
			        AppUtils.displayUnexpectedError(error);
			    	applyNextActions();
				}
			}
	    }
	}
	
	export function startReplay(timeline, pauseInMillis) {
	    AppUtils.startReplay();
	
	    let events = [];
		
		let appStateWasSet = false;
	    for (let i = 0; i < timeline.length; i++) {
	        let item = timeline[i];
	        if (item.event && appStateWasSet && item.event.eventName !== "TriggerAction") {
	            events.push({
	            	event: new Event(item.event.eventName),
	            	data: item.event.data
	            });
	        }
			if (item.appState && !appStateWasSet) {
			    AppState.setInitialAppState(item.appState);
			    appStateWasSet = true;
			}
	    }
	
		setTimeout(() => replayNextEvent(events, pauseInMillis), pauseInMillis);
	}
	
	function replayNextEvent(events, pauseInMillis) {
	    let nextEvent = events.shift();
	    if (nextEvent) {
	    	nextEvent.event.replay(nextEvent.data);
	    	setTimeout(() => replayNextEvent(events, pauseInMillis), pauseInMillis);
	    } else {
	        setTimeout(() => finishReplay(), pauseInMillis);
	    }
	}
	
	function finishReplay() {
	    console.info("replay finished");
	    timeline = [];
	    actionQueue = [];
	    AppUtils.createInitialAppState();
	    AppUtils.startApp();
	}
	
	
	«sdg»
	
	
	'''
	
	def generateTimeline() '''
		«copyright»

		import * as AppUtils from "../../src/app/AppUtils";
		import * as ACEController from "./ACEController";
		import * as Utils from "./Utils";
		
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
		        console.info(`saved timeline with id ${id}`);
		    });
		}
		
		export function dumpTimeline() {
		    console.info(ACEController.timeline);
		}
		
		
		«sdg»
		
		
	'''

	def generateUtils() '''
		«copyright»

		import * as AppUtils from "../../src/app/AppUtils";
		import * as ACEController from "./ACEController";
		
		function getServerInfo() {
		    return AppUtils.httpGet(AppUtils.settings.rootPath + '/server/info');
		}
		
		export function saveTimeline(description, creator) {
		    return getServerInfo().then((serverInfo) => {
		        const browser = getBrowserInfo();
		        const uuid = AppUtils.createUUID();
		        const data = {
		            description,
		            timeline: JSON.stringify(ACEController.timeline),
		            creator,
		            clientVersion: AppUtils.settings.clientVersion,
		            device: browser.name + " " + browser.version,
		            apiKey: AppUtils.settings.aceScenariosApiKey,
		            serverVersion: serverInfo.serverVersion
		        };
		        return AppUtils.httpPost(AppUtils.settings.aceScenariosBaseUrl + 'api/client-timeline/create', uuid, false, data).then(() => {
		            return new Promise((resolve) => {
		                resolve(uuid);
		            });
		        });
		    });
		}
		
		export function loadTimeline(id) {
		    return AppUtils.httpGet(AppUtils.settings.aceScenariosBaseUrl + `api/timeline?id=${id}&apiKey=${AppUtils.settings.aceScenariosApiKey}`, AppUtils.createUUID(), false);
		}
		
		function getBrowserInfo() {
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
		
		
		«sdg»
		
		
		
	'''
	
	def String generateAppState(List<ClientAttribute> attributes, String prefix, HttpClient httpClient) '''
		«copyright»

		import * as AppUtils from "../../src/app/AppUtils";
		
		let appState;

		export function getAppState() {
			return AppUtils.deepCopy(appState);
		}
		
		export function setInitialAppState(initialAppState) {
			appState = AppUtils.deepCopy(initialAppState);
		}
		
		«FOR attribute : attributes»
			«attribute.generateAppStateRec(httpClient)»
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
	
	private def setStateFunction(SingleClientAttribute it, HttpClient httpClient) '''
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
	
	private def stateObjectCreation(ClientAttribute it) '''
		«IF eContainer !== null && eContainer instanceof GroupedClientAttribute»
			if («elementPath» && !«elementPath».is«name.toFirstUpper») {
				return;
			}
			if (!«elementPath») {
				«elementPath» = {
					is«name.toFirstUpper» : true
				};
			}
		«ELSE»
			if (!«elementPath») {
				«elementPath» = {};
			}
		«ENDIF»
	'''
	
	private def mergeStateFunction(SingleClientAttribute it, HttpClient httpClient) '''
		«IF isHash || isStorage || isList»
		«ELSEIF attributes !== null && attributes.length > 0» 
			export function merge_«functionName»(eventData) {
				«FOR attr : allParentAttributes»
					«attr.stateObjectCreation»
				«ENDFOR»
				«stateObjectCreation»
				«FOR attribute : attributes»
					«IF attribute instanceof SingleClientAttribute»
						if (eventData.«name» && eventData.«name».«attribute.name» !== undefined) {
							«attribute.elementPath» = eventData.«name».«attribute.getName»;
						}
					«ENDIF»
				«ENDFOR»
			}
			
		«ELSE»
			export function merge_«functionName»(eventData) {
				«FOR attr : allParentAttributes»
					«attr.stateObjectCreation»
				«ENDFOR»
				«elementPath» = eventData.«getName»;
			}
			
		«ENDIF»
	'''
	
	private def childAttributes(SingleClientAttribute it, HttpClient httpClient) '''
		«IF attributes !== null && !isList && !isHash && !isStorage»
			«FOR attribute : attributes»
				«attribute.generateAppStateRec(httpClient)»
			«ENDFOR»
		«ENDIF»
	'''
	
	def dispatch String generateAppStateRec(SingleClientAttribute it, HttpClient httpClient) '''
		«getStateFunction()»
		«setStateFunction(httpClient)»
		«mergeStateFunction(httpClient)»
		«childAttributes(httpClient)»
	'''
	
	def dispatch String generateAppStateRec(GroupedClientAttribute it, HttpClient httpClient) '''
		«IF attributeGroup === null || attributeGroup.length > 0»
			«FOR attribute : attributeGroup»
				«IF attribute instanceof SingleClientAttribute»
					«attribute.getStateFunction()»
					«attribute.setStateFunction(httpClient)»
					«attribute.mergeStateFunction(httpClient)»
					«attribute.childAttributes(httpClient)»
				«ELSE»
					«attribute.generateAppStateRec(httpClient)»
				«ENDIF»
			«ENDFOR»
		«ENDIF»
	'''
	
}	
	
/******* S.D.G. *******/
	
	
