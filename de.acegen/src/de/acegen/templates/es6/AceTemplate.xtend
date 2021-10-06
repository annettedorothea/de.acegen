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

import de.acegen.aceGen.HttpClient
import de.acegen.extensions.CommonExtension
import javax.inject.Inject

class AceTemplate {
	
	@Inject
	extension CommonExtension
	
	def generateAppUtilsStub() '''
		«copyright»
		

		export let settings;


		export function initEventListeners() {
		}
		
		export function startApp() {
		}
		
		export function startReplay() {
		}
		
		export function httpGet(url, uuid, authorize) {
		}
		
		export function httpPost(url, uuid, authorize, data) {
		}
		
		export function httpPut(url, uuid, authorize, data) {
		}
		
		export function httpDelete(url, uuid, authorize, data) {
		}
		
		export function createUUID() {
		}
		
		export function displayUnexpectedError(error) {
		}
		
		export function deepCopy(object) {
		}
		
		export function renderApp() {
		}
		
		«sdg»
		
	'''
	
	def generateAppStateStub() '''
		«copyright»
		


		export function get(path) {
		}
		
		export function getLocation() {
		}
		
		export function getStorage(path) {
		}
		
		export function set(data, path, groupVerifications, attributes) {
		}
		
		export function setLocation(data, path) {
		}
		
		export function setStorage(data, path) {
		}
		
		export function merge(data, path, groupVerifications, attributes) {
		}
		
		export function mergeLocation(data, path) {
		}
		
		export function mergeStorage(data, path) {
		}
		
		export function createInitialAppState() {
		}
		
		export function setInitialAppState(initialAppState) {
		}

		export function stateUpdated() {
		}
		
		«sdg»
		
	'''
	
	def generateApp(HttpClient httpClient) '''
		«copyright»

		import * as AppUtils from "./AppUtils";
		
		export * from "../gen/ace/Timeline";
		
		export function dumpAppState() {
		    console.info(AppUtils.get([]));
		}
		
		AppUtils.initEventListeners();
		AppUtils.startApp();
		AppUtils.renderApp();
		
		// for Selenium tests
		export function getAppState() {
		    return AppUtils.get([])
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
		    return new Promise(() => {
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
		
		
		«sdg»
		
		
	'''
	
	def generateACEController() '''
	«copyright»
	
	import * as AppUtils from "../../src/AppUtils";
	import Event from "./Event";
	
	export let timeline = [];
	export let listeners = {};
	export let delayedActions = {};
	
	let actionQueue = [];
	let triggeredActionsQueue = [];
	let idle = true;
	
	
	export function registerListener(eventName, listener) {
		if (!listener) {
			console.warn("you try to register an undefined listener for event " + eventName)
		} else {
			let listenersForEventName;
			if (listeners[eventName] === undefined) {
				listeners[eventName] = [];
			}
			listenersForEventName = listeners[eventName];
			listenersForEventName.push(listener);
		}
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

	export function addActionToTriggeredActionsQueue(action, data) {
		triggeredActionsQueue.push({action, data});
		if (idle) {
			applyNextActions();
		}
	}

	function applyNextActions() {
		idle = false;
	    let nextAction = actionQueue.shift();
	    if (nextAction) {
			if (nextAction.action.asynchronous) {
	            nextAction.action.applyAction(nextAction.data).then(() => {
	            	if (nextAction.action.callback && typeof nextAction.action.callback === 'function') {
	            		nextAction.action.callback(nextAction.callback);
	            	}
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
		let nextTriggeredAction = triggeredActionsQueue.shift();
		while (nextTriggeredAction) {
		    nextTriggeredAction.action.apply(nextTriggeredAction.data);
		    nextTriggeredAction = triggeredActionsQueue.shift();
		}
		idle = true;
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
			    AppUtils.setInitialAppState(item.appState);
	            AppUtils.stateUpdated();
			    appStateWasSet = true;
			}
	    }
	    
	    console.info(`replay ${events.length} events`);
	
		setTimeout(() => replayNextEvent(events, pauseInMillis), pauseInMillis);
	}
	
	function replayNextEvent(events, pauseInMillis) {
	    let nextEvent = events.shift();
	    if (nextEvent) {
	    	console.info("replay", nextEvent);
	    	nextEvent.event.replay(nextEvent.data);
			AppUtils.stateUpdated();
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

		import * as AppUtils from "../../src/AppUtils";
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

		import * as AppUtils from "../../src/AppUtils";
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
	
}	
	
/******* S.D.G. *******/
	
	
