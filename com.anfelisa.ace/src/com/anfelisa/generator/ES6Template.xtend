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

class ES6Template {
	
	@Inject
	extension ActionExtension

	@Inject
	extension CommandExtension

	@Inject
	extension EventExtension
	
	@Inject
	extension ViewExtension
	
	def generateAbstractActionFile(Action it) '''
		'use strict';
		
		class «abstractActionName» extends Action {
		
		    constructor(actionParam) {
		        super(actionParam, '«actionName»');
		    }
		
			«IF command != null»
			    getCommand() {
			        return new «command.commandName»(this.actionData);
			    }
		    «ENDIF»
		
		}
		
		/*       S.D.G.       */
	'''

	def generateInitialActionFile(Action it) '''
		'use strict';
		
		class «actionName» extends «abstractActionName» {
		
		    initActionDataFromView() {
		        return new Promise((resolve) => {
		            resolve();
		        });
		    }
		
		    captureActionParam() {
		    	// capture user input
		    }
		
		    initActionData() {
		    	// bind action parameters to action data
		    }
		
		    releaseActionParam() {
		    	// replease action params during replay
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
		    }
		}
		
		/*       S.D.G.       */
	'''
	def generateEventListenerRegistration(Project it) '''
		'use strict';
		
		class EventListenerRegistration {
		
			static init() {
				EventListenerRegistration.listeners = {};
		    	«FOR event : events»
		    		«FOR renderFunction : event.listeners»
		    			EventListenerRegistration.registerListener('«event.eventName»', «renderFunction.viewFunctionWithViewName»);
		    		«ENDFOR»
		    	«ENDFOR»
			}
			
			static registerListener(eventName, listener) {
				if (!eventName.trim()) {
					throw new Error('cannot register listener for empty eventName');
				}
				if (!listener) {
					throw new Error('cannot register undefined listener');
				}
				var listenersForEventName;
				if (EventListenerRegistration.listeners[eventName] === undefined) {
					EventListenerRegistration.listeners[eventName] = [];
				}
				listenersForEventName = EventListenerRegistration.listeners[eventName];
				listenersForEventName.push(listener);
			}
		
		}
		
		/*       S.D.G.       */
	'''
	def generateView(View it) '''
		'use strict';
		
		class «viewName» {
		    «FOR renderFunction : renderFunctions»
		    	static «renderFunction.name»(data) {
		    	};
		    	
		    «ENDFOR»
		}
		
		/*                    S.D.G.                    */
	'''

	def generateHtmlDevSnippet(Project it) '''
		<script type="text/javascript" src="es6/gen/ace/Action.es6"></script>
		<script type="text/javascript" src="es6/gen/ace/Command.es6"></script>
		<script type="text/javascript" src="es6/gen/ace/Event.es6"></script>
		<script type="text/javascript" src="es6/gen/ace/ACEController.es6"></script>
		<script type="text/javascript" src="es6/gen/ace/TriggerAction.es6"></script>
		<script type="text/javascript" src="es6/gen/ace/UUID.js"></script>
		
		«FOR action: actions»
			<script type="text/javascript" src="es6/gen/«name»/actions/«action.abstractActionName».es6"></script>
			<script type="text/javascript" src="es6/src/«name»/actions/«action.actionName».es6"></script>
		«ENDFOR»
		«FOR command: commands»
			<script type="text/javascript" src="es6/gen/«name»/commands/«command.abstractCommandName».es6"></script>
			<script type="text/javascript" src="es6/src/«name»/commands/«command.commandName».es6"></script>
		«ENDFOR»
		«FOR event: events»
			<script type="text/javascript" src="es6/gen/«name»/events/«event.abstractEventName».es6"></script>
			<script type="text/javascript" src="es6/src/«name»/events/«event.eventName».es6"></script>
		«ENDFOR»
		<script type="text/javascript" src="es6/gen/«name»/EventListenerRegistration.es6"></script>
		«FOR view: views»
			<script type="text/javascript" src="es6/src/«name»/«view.viewName».es6"></script>
		«ENDFOR»
	'''

	def generateAction() '''
		'use strict';
		
		class Action {
		    constructor(actionParam, actionName) {
		        if (actionParam === undefined) {
		            actionParam = {};
		        }
		        this.actionParam = JSON.parse(JSON.stringify(actionParam));
		        this.actionName = actionName;
		        this.actionData = {};
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
		            let command = this.getCommand()
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
		                var timelineCommand = ACEController.getCommandByUuid(this.commandParam.uuid);
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
		            var listenersForEvent = EventListenerRegistration.listeners[this.eventName];
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
	
	def generateACEController() '''
		'use strict';
		
		class ACEController {
		
		    static init() {
		        ACEController.timeLine = [];
		        ACEController.timeLineLocalStorageChunks = [];
		        ACEController.writeTimeLine = true;
		        EventListenerRegistration.init();
		        EventListenerRegistration.registerListener('TriggerAction', ACEController.triggerAction);
		        ACEController.actionIsProcessing = false;
		        ACEController.actionQueue = [];
		        ACEController.uuidGenerator = new UUID();
		        ACEController.LIVE = 1;
		        ACEController.REPLAY = 2;
		        ACEController.E2E = 3;
		        ACEController.execution = ACEController.LIVE;
		        ACEController.replayTimeLine = [];
		        sessionStorage.clear();
		    }
		
		    static addItemToTimeLine(item) {
		        let timestamp = new Date();
		        item.timestamp = timestamp.getTime();
		        if (ACEController.execution === ACEController.LIVE) {
		            if (ACEController.writeTimeLine) {
		                ACEController.timeLine.push(JSON.parse(JSON.stringify(item)));
		                if (ACEController.timeLine.length > 50) {
		                    let timestampInMillis  = timestamp.getTime();
		                    try {
		                        sessionStorage[timestampInMillis] = JSON.stringify(ACEController.timeLine, null, 2);
		                        ACEController.timeLineLocalStorageChunks.push(timestampInMillis);
		                    } catch (exception) {
		                        ACEController.writeTimeLine = false;
		                    }
		                    ACEController.timeLine = [];
		                }
		            }
		        } else {
		            ACEController.replayTimeLine.push(JSON.parse(JSON.stringify(item)));
		        }
		    }
		
		    static getCompleteTimeline() {
		        var completeTimeline = [];
		        for(var i=0; i<ACEController.timeLineLocalStorageChunks.length; i++) {
		            let timelineChunk = sessionStorage[ACEController.timeLineLocalStorageChunks[i]];
		            completeTimeline.push.apply(completeTimeline, JSON.parse(timelineChunk));
		        }
		        completeTimeline.push.apply(completeTimeline, ACEController.timeLine);
		        return completeTimeline;
		    }
		
		    static downloadTimeline() {
		        let timelineJson = JSON.stringify(ACEController.getCompleteTimeline(), null, 2);
		
		        let a = window.document.createElement('a');
		        a.href = window.URL.createObjectURL(new Blob([timelineJson], {type: 'text/json'}));
		        a.download = 'scenario.json';
		
		        document.body.appendChild(a);
		        a.click();
		
		        document.body.removeChild(a);
		    }
		
		    static uploadTimeline(event) {
		        ACEController.clearReplayResultDiv();
		
		        var input = event.target;
		        var reader = new FileReader();
		        reader.onload = function () {
		            let json = reader.result;
		            ACEController.timeLine = JSON.parse(json);
		            document.getElementById("uploadTimelineInputField").value = "";
		        };
		        reader.readAsText(input.files[0]);
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
		                throw error + " when applying action " + action.actionName;
		            });
		        } else if (action === undefined) {
		            ACEController.actionIsProcessing = false;
		            if (ACEController.execution !== ACEController.LIVE) {
		                ACEController.finishReplay();
		            }
		        }
		    }
		
		    static triggerAction(action) {
		        ACEController.addActionToQueue(action);
		    }
		
		    static clearReplayResultDiv() {
		        if (document.getElementById("replayResultDiv")) {
		            let table = document.getElementById("replayResultDiv");
		            var rowCount = table.rows.length;
		            while (--rowCount) {
		                table.deleteRow(rowCount);
		            }
		            table.rows[0].className = '';
		        }
		    }
		
		    static replay() {
		        ACEController.startReplay(ACEController.REPLAY)
		    }
		
		    static e2e() {
		        ACEController.startReplay(ACEController.E2E)
		    }
		
		    static startReplay(level) {
		        ACEController.passed = undefined;
		        ACEController.expectedTimeLine = [];
		        ACEController.replayTimeLine = [];
		        ACEController.pauseInMillis = undefined;
		
		        ACEController.clearReplayResultDiv();
		
		        var actions = [];
		        var completeTimeLine = ACEController.getCompleteTimeline();
		        for (let i = 0; i < completeTimeLine.length; i++) {
		            let item = completeTimeLine[i];
		            ACEController.expectedTimeLine.push(item);
		            if (item.action) {
		                var action = eval('new ' + item.action.actionName + '(item.action.actionParam)');
		                action.actionData.uuid = item.action.actionData.uuid;
		                actions.push(action);
		            }
		        }
		
		        ACEController.actionQueue = actions;
		
		        if (document.getElementById('pauseInMillisInput')) {
		            ACEController.pauseInMillis = document.getElementById('pauseInMillisInput').value;
		        }
		
		        ACEController.execution = level;
		
		        ACEController.applyNextActions();
		    }
		
		    static getCommandByUuid(uuid) {
		        for (let i = 0; i < ACEController.expectedTimeLine.length; i++) {
		            let item = ACEController.expectedTimeLine[i];
		            if (item.command && item.command.commandParam.uuid === uuid) {
		                return item.command;
		            }
		        }
		    }
		
		    static finishReplay() {
		        App.completeReplay();
		        ACEController.passed = true;
		        if (document.getElementById("replayResultDiv")) {
		            let table = document.getElementById("replayResultDiv");
		            for (let i = 0; i < ACEController.expectedTimeLine.length; i++) {
		                let expectedItem = ACEController.expectedTimeLine[i];
		                let actualItem = undefined;
		                if (i < ACEController.replayTimeLine.length) {
		                    actualItem = ACEController.replayTimeLine[i];
		                }
		
		                let rowAbstract = table.insertRow(table.rows.length);
		                rowAbstract.insertCell(0);
		                let original = rowAbstract.insertCell(1);
		                let actual= rowAbstract.insertCell(2);
		                rowAbstract.insertCell(3);
		                original.innerHTML = '<a onclick=\'toggleVisibilityOfRow("row_' + i + '")\'>' + ACEController.abstractText(expectedItem) + '</a>';
		                actual.innerHTML = '<a onclick=\'toggleVisibilityOfRow("row_' + i + '")\'>' + ACEController.abstractText(actualItem) + '</a>';
		
		                let row = table.insertRow(table.rows.length);
		                row.id = "row_" + i;
		                row.style = "display: none;";
		                let originalExpectedItemCell = row.insertCell(0);
		                let expectedItemCell = row.insertCell(1);
		                let actualItemCell = row.insertCell(2);
		                let originalActualItemCell = row.insertCell(3);
		                originalExpectedItemCell.innerHTML = '<pre style="font-size: 10px;">' + JSON.stringify(expectedItem, null, 2) + '</pre>';
		                expectedItemCell.innerHTML = '<pre style="font-size: 10px;">' + JSON.stringify(expectedItem, ACEController.verificationCleanupFunction, 2) + '</pre>';
		                actualItemCell.innerHTML = '<pre style="font-size: 10px;">' + JSON.stringify(actualItem, ACEController.verificationCleanupFunction, 2) + '</pre>';
		                originalActualItemCell.innerHTML = '<pre style="font-size: 10px;">' + JSON.stringify(actualItem, null, 2) + '</pre>';
		                if (JSON.stringify(expectedItem, ACEController.verificationCleanupFunction) === JSON.stringify(actualItem, ACEController.verificationCleanupFunction)) {
		                    row.className = 'success';
		                    rowAbstract.className = 'success';
		                } else {
		                    row.className = 'danger';
		                    rowAbstract.className = 'danger';
		                    ACEController.passed = false;
		                }
		            }
		            if (ACEController.passed) {
		                table.rows[0].className = 'success';
		            } else {
		                table.rows[0].className = 'danger';
		            }
		        }
		
		        ACEController.actionIsProcessing = false;
		        ACEController.actionQueue = [];
		        ACEController.execution = ACEController.LIVE;
		    }
		
		    static abstractText(item) {
		        if (item.action) {
		            return "A " + item.action.actionName;
		        }
		        if (item.command) {
		            return "C " + item.command.commandName;
		        }
		        if (item.event) {
		            var triggerActionName = item.event.eventName === 'TriggerAction' ? " " + item.event.eventParam.actionName : "";
		            return "E " + item.event.eventName + triggerActionName;
		        }
		    }
		
		}
		
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
