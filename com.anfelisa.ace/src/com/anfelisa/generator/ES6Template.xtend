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
	
	def generateAbstractActionFile(Action it) '''
		'use strict';
		
		class «abstractActionName» extends Action {
		
		    constructor(actionParam) {
		        super(actionParam, '«actionName»', «IF init»true«ELSE»false«ENDIF»);
		    }
		
			«IF command !== null»
			    getCommand() {
			    	«IF command !== null»
			    		return new «command.commandName»(this.actionData);
			    	«ELSE»
			    		return null;
			        «ENDIF»
			    }
		    «ENDIF»
		
		}
		
		/*       S.D.G.       */
	'''

	def generateInitialActionFile(Action it) '''
		'use strict';
		
		class «actionName» extends «abstractActionName» {
		
		    captureActionParam() {
		    }
		
		    initActionData() {
		    }
		
		    releaseActionParam() {
		    }
		}
		
		/*       S.D.G.       */
	'''
	
	def generateAbstractCommandFile(Command it) '''
		'use strict';
		
		class «abstractCommandName» extends Command {
		    constructor(commandParam) {
		        super(commandParam, "«commandName»");
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
		    		throw 'unhandled outcome: ' + this.commandData.outcome;
		    	}
		    	return Promise.all(promises);
		    }
		}
		
		/*       S.D.G.       */
	'''
	
	def generateInitialCommandFile(Command it) '''
		'use strict';
		
		class «commandName» extends «abstractCommandName» {
		    execute() {
		        return new Promise((resolve) => {
					resolve();
		        });
		    }
		}
		
		/*       S.D.G.       */
	'''
	
	def generateAbstractEventFile(Event it) '''
		'use strict';
		
		class «abstractEventName» extends Event {
		    constructor(eventParam) {
		        super(eventParam, '«eventName»');
		    }
		}
		
		/*       S.D.G.       */
	'''
	def generateInitialEventFile(Event it) '''
		'use strict';
		
		class «eventName» extends «abstractEventName» {
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
		'use strict';
		
		class EventListenerRegistration«projectName» {
		
			static init() {
		    	«FOR event : events»
		    		«FOR renderFunction : event.listeners»
		    			ACEController.registerListener('«event.eventName»', «renderFunction.viewFunctionWithViewName»);
		    		«ENDFOR»
		    	«ENDFOR»
			}
		
		}
		
		EventListenerRegistration«projectName».init();
		
		/*       S.D.G.       */
	'''
	def generateView(View it) '''
		'use strict';
		
		class «viewName» {
		    «FOR renderFunction : renderFunctions»
		    	static «renderFunction.name»(eventData) {
		    	};
		    	
		    «ENDFOR»
		}
		
		/*                    S.D.G.                    */
	'''

	def generateAction() '''
		'use strict';
		
		class Action {
		    constructor(actionParam, actionName, isInitAction) {
		        if (actionParam === undefined) {
		            actionParam = {};
		        }
		        this.actionParam = JSON.parse(JSON.stringify(actionParam));
		        this.actionName = actionName;
		        this.actionData = {};
		        this.isInitAction = isInitAction === true;
		        
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
		            if (ACEController.execution === ACEController.LIVE) {
		                this.actionData.uuid = ACEController.uuidGenerator.createUUID();
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
		                command.executeCommand().then(() => {
		                    resolve();
		                },
		                (error) => {
		                    reject(error + " when executing command " + command.commandName);
		                });
		            } else {
		                resolve();
		            }
		        });
		    }
		
		}
		
		/*       S.D.G.       */
		
	'''

	def generateCommand() '''
		'use strict';
		
		class Command {
		    constructor(commandParam, commandName) {
		        this.commandParam = JSON.parse(JSON.stringify(commandParam));
		        this.commandName = commandName;
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
		                        ACEController.applyNextActions();
		                        resolve();
		                    }, (error) => {
		                        reject(error + " when publishing events of command " + this.commandName);
		                    });
		                }, (error) => {
		                    reject(error + " when executing command " + this.commandName);
		                });
		            } else {
		                const timelineCommand = ACEController.getCommandByUuid(this.commandParam.uuid);
		                this.commandData = timelineCommand.commandData;
		                ACEController.addItemToTimeLine({command: this});
		                this.publishEvents().then(() => {
		                    setTimeout(ACEController.applyNextActions, ACEController.pauseInMillis);
		                    resolve();
		                }, (error) => {
		                    reject(error + " when publishing events of command " + this.commandName);
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
		'use strict';
		
		class Event {
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
		                reject(error + " when notifying listeners of event " + this.eventName);
		            });
		        });
		    }
		
		    notifyListeners() {
		        let promises = [];
		        var i, listener;
		        if (this.eventName !== undefined) {
		            var listenersForEvent = ACEController.listeners[this.eventName];
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
	
	def generateAppUtilsStub() '''
		'use strict';
		
		class AppUtils {
		
		    static start() {
		    }
		
		    static itemAddedToTimelineCallback(item) {
		    }
		
		    static httpGet(url, queryParams, commandParam) {
		        return new Promise((resolve) => {
		            resolve();
		        });
		    }
		
		    static httpPost(url, queryParams, data, commandParam) {
		        return new Promise((resolve) => {
		            resolve();
		        });
		    }
		
		    static httpPut(url, queryParams, data, commandParam) {
		        return new Promise((resolve) => {
		            resolve();
		        });
		    }
		
		    static httpDelete(url, queryParams, data, commandParam) {
		        return new Promise((resolve) => {
		            resolve();
		        });
		    }
		
		}
		
		/*       S.D.G.       */
		
	'''
	
	def generateAppStub() '''
		'use strict';
		
		AppUtils.start();
		
		/*       S.D.G.       */
		
	'''
	
	def generateReplayUtilsStub() '''
		'use strict';
		
		class ReplayUtils {
		
		    static replayVerification(actualIndex, expectedIndexStart, expectedIndexEnd) {
				const actualTimelineItems = ACEController.actualTimeline.slice(actualIndex);
				const expectedTimelineItems = ACEController.expectedTimeLine.slice(expectedIndexStart, expectedIndexEnd);
		    }
		
		    static resetDatabase() {
		        return new Promise((resolve) => {
		            resolve();
		        });
		    }
		
		    static prepareAction(uuid) {
				if (ACEController.execution === ACEController.E2E) {
				    return new Promise((resolve) => {
				    		// prepare action
				    		resolve();
				    });
				} else {
				    return new Promise((resolve) => {
				        resolve();
				    });
				}
		    }
		
		    static replay() {
		    		const pauseInMillis = 0;
		        ACEController.startReplay(ACEController.REPLAY, pauseInMillis)
		    }
		
		    static e2e() {
		    		const pauseInMillis = 0;
		        ACEController.startReplay(ACEController.E2E, pauseInMillis)
		    }

			static uploadTimeline() {
				// upload timeline
				const json = '';
		        ACEController.initTimeline(JSON.parse(json));
			}
		
			static finishReplay() {
			}

		}
		
		/*       S.D.G.       */
		
	'''
	
	def generateACEController() '''
		'use strict';
		
		class ACEController {
		
		    static init() {
		        ACEController.timeline = [];
		        ACEController.listeners = {};
		        ACEController.registerListener('TriggerAction', ACEController.triggerAction);
		        ACEController.actionIsProcessing = false;
		        ACEController.actionQueue = [];
		        ACEController.uuidGenerator = new UUID();
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
		
		    static addItemToTimeLine(item) {
		        let timestamp = new Date();
		        item.timestamp = timestamp.getTime();
		        if (ACEController.execution === ACEController.LIVE) {
		            ACEController.timeline.push(JSON.parse(JSON.stringify(item)));
		            AppUtils.itemAddedToTimelineCallback(item);
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
		
		    static downloadTimeline() {
		        let timelineJson = JSON.stringify(ACEController.timeline, null, 2);
		
		        let a = window.document.createElement('a');
		        a.href = window.URL.createObjectURL(new Blob([timelineJson], {type: 'text/json'}));
		        a.download = 'scenario.json';
		
		        document.body.appendChild(a);
		        a.click();
		
		        document.body.removeChild(a);
		    }
		
		    static initTimeline(timelineJson) {
		        ACEController.expectedTimeline = timelineJson;
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
		                if (ACEController.execution !== ACEController.LIVE) {
		                    const actualIndices = ACEController.getActionIndicesByUuid(action.actionData.uuid, ACEController.actualTimeline);
		                    const expectedIndices = ACEController.getActionIndicesByUuid(action.actionData.uuid, ACEController.expectedTimeline);
		                    ReplayUtils.replayVerification(actualIndices.start, actualIndices.end, expectedIndices.start, expectedIndices.end);
		                }
		            }, (error) => {
		                ACEController.actionIsProcessing = false;
		                throw new Error(error + " when applying action " + action.actionName);
		            });
		        } else if (action === undefined) {
		            ACEController.actionIsProcessing = false;
		            if (ACEController.execution !== ACEController.LIVE) {
		                ReplayUtils.finishReplay();
						ACEController.timeline = [];
						ACEController.actionIsProcessing = false;
						ACEController.actionQueue = [];
						ACEController.execution = ACEController.LIVE;
		                AppUtils.start();
		            }
		        }
		    }
		
		    static triggerAction(action) {
		        ACEController.addActionToQueue(action);
		    }
		
		    static replay(pauseInMillis) {
		        ACEController.startReplay(ACEController.REPLAY, pauseInMillis)
		    }
		
		    static e2e(pauseInMillis) {
		        ACEController.startReplay(ACEController.E2E, pauseInMillis)
		    }
		
		    static startReplay(level, pauseInMillis) {
		        ACEController.passed = undefined;
		        ACEController.actualTimeline = [];
		        ACEController.pauseInMillis = undefined;
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
						let action = eval('new ' + item.action.actionName + '(actionParam)');
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
		
		    static getActionIndicesByUuid(uuid, timeline) {
		        let start = -1;
		        let end = -1;
		        for (let i = 0; i < timeline.length; i++) {
		            let item = timeline[i];
		            if (item.action && item.action.actionData.uuid === uuid) {
		                start = i;
		            } else if (start !== -1 && item.action) {
		                end = i - 1;
		                break;
		            }
		        }
		        if (start !== -1 && end === -1) {
		            end = timeline.length;
		        }
		        return {
		            start: start,
		            end: end
		        }
		    }
		
		}
		
		ACEController.init();
		
		/*       S.D.G.       */
		
	'''
	
	def generateTriggerAction() '''
		'use strict';
		
		class TriggerAction extends Event {
		    constructor(action) {
		        super(action, 'TriggerAction');
		        this.eventData = action;
		    }
		    prepareDataForView() {
		    }
		}
		
		/*       S.D.G.       */
		
	'''

	def generateAceHtmlDevSnippet(Project it) '''
		<script type="text/javascript" src="es6/gen/ace/UUID.js"></script>
		<script type="text/javascript" src="es6/gen/ace/Action.es6"></script>
		<script type="text/javascript" src="es6/gen/ace/Command.es6"></script>
		<script type="text/javascript" src="es6/gen/ace/Event.es6"></script>
		<script type="text/javascript" src="es6/gen/ace/ACEController.es6"></script>
		<script type="text/javascript" src="es6/gen/ace/TriggerAction.es6"></script>
	'''

	def generateHtmlDevSnippet(Project it) '''
		«FOR action: actions»
			<script type="text/javascript" src="es6/gen/app/«name»/actions/«action.abstractActionName».es6"></script>
			<script type="text/javascript" src="es6/src/«name»/actions/«action.actionName».es6"></script>
		«ENDFOR»
		«FOR command: commands»
			<script type="text/javascript" src="es6/gen/app/«name»/commands/«command.abstractCommandName».es6"></script>
			<script type="text/javascript" src="es6/src/«name»/commands/«command.commandName».es6"></script>
		«ENDFOR»
		«FOR event: events»
			<script type="text/javascript" src="es6/gen/app/«name»/events/«event.abstractEventName».es6"></script>
			<script type="text/javascript" src="es6/src/«name»/events/«event.eventName».es6"></script>
		«ENDFOR»
		«FOR view: views»
			<script type="text/javascript" src="es6/src/«name»/«view.viewName».es6"></script>
		«ENDFOR»






		<script type="text/javascript" src="es6/gen/elr/«name»/EventListenerRegistration.es6"></script>
	'''

	
	def generateUUID() '''
		/*
		 uuid.js - Version 0.3
		 JavaScript Class to create a UUID like identifier
		
		 Copyright (C) 2006-2008, Erik Giberti (AF-Design), All rights reserved.
		
		 This program is free software; you can redistribute it and/or modify it under
		 the terms of the GNU General Public License as published by the Free Software
		 Foundation; either version 2 of the License, or (at your option) any later
		 version.
		
		 This program is distributed in the hope that it will be useful, but WITHOUT ANY
		 WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
		 PARTICULAR PURPOSE. See the GNU General Public License for more details.
		
		 You should have received a copy of the GNU General Public License along with
		 this program; if not, write to the Free Software Foundation, Inc., 59 Temple
		 Place, Suite 330, Boston, MA 02111-1307 USA
		
		 The latest version of this file can be downloaded from
		 http://www.af-design.com/resources/javascript_uuid.php
		
		 HISTORY:
		 6/5/06 	- Initial Release
		 5/22/08 - Updated code to run faster, removed randrange(min,max) in favor of
		 a simpler rand(max) function. Reduced overhead by using getTime()
		 method of date class (suggestion by James Hall).
		 9/5/08	- Fixed a bug with rand(max) and additional efficiencies pointed out
		 by Robert Kieffer http://broofa.com/
		
		 KNOWN ISSUES:
		 - Still no way to get MAC address in JavaScript
		 - Research into other versions of UUID show promising possibilities
		 (more research needed)
		 - Documentation needs improvement
		
		 */
		
		// On creation of a UUID object, set it's initial value
		function UUID(){
		    this.id = this.createUUID();
		}
		
		// When asked what this Object is, lie and return it's value
		UUID.prototype.valueOf = function(){ return this.id; }
		UUID.prototype.toString = function(){ return this.id; }
		
		//
		// INSTANCE SPECIFIC METHODS
		//
		
		UUID.prototype.createUUID = function(){
		    //
		    // Loose interpretation of the specification DCE 1.1: Remote Procedure Call
		    // described at http://www.opengroup.org/onlinepubs/009629399/apdxa.htm#tagtcjh_37
		    // since JavaScript doesn't allow access to internal systems, the last 48 bits
		    // of the node section is made up using a series of random numbers (6 octets long).
		    //
		    var dg = new Date(1582, 10, 15, 0, 0, 0, 0);
		    var dc = new Date();
		    var t = dc.getTime() - dg.getTime();
		    var h = '-';
		    var tl = UUID.getIntegerBits(t,0,31);
		    var tm = UUID.getIntegerBits(t,32,47);
		    var thv = UUID.getIntegerBits(t,48,59) + '1'; // version 1, security version is 2
		    var csar = UUID.getIntegerBits(UUID.rand(4095),0,7);
		    var csl = UUID.getIntegerBits(UUID.rand(4095),0,7);
		
		    // since detection of anything about the machine/browser is far to buggy,
		    // include some more random numbers here
		    // if NIC or an IP can be obtained reliably, that should be put in
		    // here instead.
		    var n = UUID.getIntegerBits(UUID.rand(8191),0,7) +
		        UUID.getIntegerBits(UUID.rand(8191),8,15) +
		        UUID.getIntegerBits(UUID.rand(8191),0,7) +
		        UUID.getIntegerBits(UUID.rand(8191),8,15) +
		        UUID.getIntegerBits(UUID.rand(8191),0,15); // this last number is two octets long
		    return tl + h + tm + h + thv + h + csar + csl + h + n;
		}
		
		
		//
		// GENERAL METHODS (Not instance specific)
		//
		
		
		// Pull out only certain bits from a very large integer, used to get the time
		// code information for the first part of a UUID. Will return zero's if there
		// aren't enough bits to shift where it needs to.
		UUID.getIntegerBits = function(val,start,end){
		    var base16 = UUID.returnBase(val,16);
		    var quadArray = new Array();
		    var quadString = '';
		    var i = 0;
		    for(i=0;i<base16.length;i++){
		        quadArray.push(base16.substring(i,i+1));
		    }
		    for(i=Math.floor(start/4);i<=Math.floor(end/4);i++){
		        if(!quadArray[i] || quadArray[i] == '') quadString += '0';
		        else quadString += quadArray[i];
		    }
		    return quadString;
		}
		
		// Replaced from the original function to leverage the built in methods in
		// JavaScript. Thanks to Robert Kieffer for pointing this one out
		UUID.returnBase = function(number, base){
		    return (number).toString(base).toUpperCase();
		}
		
		// pick a random number within a range of numbers
		// int b rand(int a); where 0 <= b <= a
		UUID.rand = function(max){
		    return Math.floor(Math.random() * (max + 1));
		}
		
		// end of UUID class file
		
		
		
	'''


}
