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
		
		    replay() {
		    }
		
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
		
		    replay() {
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
		    	«FOR event : events»
		    		«FOR renderFunction : event.listeners»
		    			MainController.registerListener('«event.eventName»', «renderFunction.renderFunctionWithViewName»);
		    		«ENDFOR»
		    	«ENDFOR»
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
		<script type="text/javascript" src="es6/gen/ace/MainController.es6"></script>
		<script type="text/javascript" src="es6/gen/ace/ReplayController.es6"></script>
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
		
		    initActionDataFromView() {
		        throw "no function initActionDataFromView defined for " + this.actionName;
		    }
		
		    getCommand() {
		        throw "no command defined for " + this.actionName;
		    }
		
		    apply() {
		        MainController.addActionToQueue(this);
		    }
		
		    replay() {
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
		        return MainController.publishEvent(this);
		    }
		}
		
		
		/*       S.D.G.       */
	'''
	
	def generateMainController() '''
		'use strict';
		
		class MainController {
		
		    static init() {
		        MainController.timeLine = [];
		        MainController.timeLineLocalStorageChunks = [];
		        MainController.writeTimeLine = true;
		        MainController.listeners = {};
		        MainController.replayLevel = undefined;
		        MainController.views = {};
		        MainController.EVENT_REPLAY_LEVEL = 1;
		        MainController.COMMAND_REPLAY_LEVEL = 2;
		        MainController.ACTION_REPLAY_LEVEL = 3;
		        MainController.verificationCleanupFunctionsForReplayLevel = {};
		        MainController.registerListener('TriggerAction', MainController.triggerAction);
		        MainController.actionIsProcessing = false;
		        MainController.actionQueue = [];
		        MainController.uuidGenerator = new UUID();
		    }
		
		    static start() {
		        MainController.timeLine = [];
		        MainController.timeLineLocalStorageChunks = [];
		        sessionStorage.clear();
		        MainController.actionQueue = [];
		        MainController.actionIsProcessing = false;
		    }
		
		    static registerListener(eventName, listener) {
		        if (!eventName.trim()) {
		            throw new Error('cannot register listener for empty eventName');
		        }
		        if (!listener) {
		            throw new Error('cannot register undefined listener');
		        }
		        var listenersForEventName;
		        if (MainController.listeners[eventName] === undefined) {
		            MainController.listeners[eventName] = [];
		        }
		        listenersForEventName = MainController.listeners[eventName];
		        listenersForEventName.push(listener);
		    }
		
		    static deRegisterListener(eventName, listener) {
		        if (!eventName.trim()) {
		            throw new Error('cannot deRegister listener for empty eventName');
		        }
		        if (!listener) {
		            throw new Error('cannot deRegister undefined listener');
		        }
		        var listenersForEventName;
		        if (MainController.listeners[eventName] !== undefined) {
		            listenersForEventName = MainController.listeners[eventName];
		            for (var i = 0; i < listenersForEventName.length; i++) {
		                if (listenersForEventName[i] === listener) {
		                    break;
		                }
		            }
		            listenersForEventName.splice(i, 1);
		            if (listenersForEventName.length === 0) {
		                MainController.listeners[eventName] = undefined;
		            }
		        }
		    }
		
		    static applyAction(action) {
		        return new Promise((resolve, reject) => {
		            if (!MainController.replayLevel || MainController.replayLevel === MainController.ACTION_REPLAY_LEVEL) {
		                if (MainController.replayLevel !== MainController.ACTION_REPLAY_LEVEL) {
		                    action.actionData.uuid = MainController.uuidGenerator.createUUID();
		                    action.initActionDataFromView().then(() => {
		                            MainController.addItemToTimeLine({action: action});
		                            if (action.getCommand()) {
		                                MainController.executeCommandOfAction(action).then(function () {
		                                    resolve();
		                                }, function (error) {
		                                    reject(error + " when executing command " + action.getCommand().commandName);
		                                });
		                            } else {
		                                resolve();
		                            }
		                        },
		                        (error) => {
		                            reject(error + " when init action from view " + action.actionName);
		                        });
		                }
		            } else {
		                resolve();
		            }
		        });
		    }
		
		    static executeCommandOfAction(action) {
		        return new Promise((resolve, reject) => {
		            if (!MainController.replayLevel || MainController.replayLevel === MainController.ACTION_REPLAY_LEVEL) {
		                let command = action.getCommand();
		                command.execute().then(function () {
		                    MainController.addItemToTimeLine({command: command});
		                    MainController.publishEventsOfCommand(command).then(function () {
		                        resolve();
		                    }, function (error) {
		                        reject(error + " when executing command " + command.commandName);
		                    });
		                }, function () {
		                    reject();
		                });
		            } else {
		                resolve();
		            }
		        });
		    }
		
		    static publishEventsOfCommand(command) {
		        return new Promise((resolve, reject) => {
		            command.publishEvents().then(function () {
		                MainController.applyNextActions();
		                resolve();
		            }, function (error) {
		                reject(error + "when publishing events of command " + command.commandName);
		            });
		        });
		    }
		
		    static applyNextActions() {
		        let action = MainController.getNextAction();
		        if (action && !this.replayLevel) {
		            MainController.applyAction(action).then(function () {
		            }, function (error) {
		                MainController.actionIsProcessing = false;
		                throw error;
		            });
		        } else if (action === undefined) {
		            MainController.actionIsProcessing = false;
		        }
		    }
		
		    static publishEvent(event) {
		        return new Promise((resolve, reject) => {
		            if (!MainController.replayLevel || MainController.replayLevel === MainController.ACTION_REPLAY_LEVEL || MainController.replayLevel === MainController.COMMAND_REPLAY_LEVEL) {
		                event.prepareDataForView();
		                MainController.addItemToTimeLine({event: event});
		                Promise.all(MainController.notifyListeners(event)).then(function () {
		                    resolve();
		                }, function (error) {
		                    reject(error + " when notifying listeners of event " + event.eventName);
		                });
		            } else {
		                resolve();
		            }
		        });
		    }
		
		    static notifyListeners(event) {
		        let promises = [];
		        var i, listener, eventName = event.eventName;
		        if (eventName !== undefined) {
		            var listenersForEvent = MainController.listeners[eventName];
		            if (listenersForEvent !== undefined) {
		                for (i = 0; i < listenersForEvent.length; i += 1) {
		                    listener = listenersForEvent[i];
		                    promises.push(listener(event.eventData));
		                }
		            }
		        }
		        return promises;
		    }
		
		    static addItemToTimeLine(item) {
		        let timestamp = new Date();
		        item.timestamp = timestamp.getTime();
		        if (!MainController.replayLevel) {
		            if (MainController.writeTimeLine) {
		                MainController.timeLine.push(JSON.parse(JSON.stringify(item)));
		                if (MainController.timeLine.length > 50) {
		                    let timestampInMillis  = timestamp.getTime();
		                    try {
		                        sessionStorage[timestampInMillis] = JSON.stringify(MainController.timeLine, null, 2);
		                        MainController.timeLineLocalStorageChunks.push(timestampInMillis);
		                    } catch (exception) {
		                        MainController.writeTimeLine = false;
		                    }
		                    MainController.timeLine = [];
		                }
		            }
		        } else {
		            ReplayController.addItemToReplayTimeLine(item);
		        }
		    }
		
		    static getCompleteTimeline() {
		        var completeTimeline = [];
		        for(var i=0; i<MainController.timeLineLocalStorageChunks.length; i++) {
		            let timelineChunk = sessionStorage[MainController.timeLineLocalStorageChunks[i]];
		            completeTimeline.push.apply(completeTimeline, JSON.parse(timelineChunk));
		        }
		        completeTimeline.push.apply(completeTimeline, MainController.timeLine);
		        return completeTimeline;
		    }
		
		    static addActionToQueue(action) {
		        MainController.actionQueue.push(action);
		        if (MainController.actionIsProcessing === false) {
		            MainController.actionIsProcessing = true;
		            MainController.applyNextActions();
		        }
		    }
		
		    static getNextAction() {
		        return MainController.actionQueue.shift();
		    }
		
		    static triggerAction(action) {
		        MainController.addActionToQueue(action);
		    }
		
		}
		
		/*       S.D.G.       */
		
	'''
	
	def generateReplayController() '''
		'use strict';
		
		class ReplayController {
		    static init() {
		        ReplayController.id = "ReplayController";
		        ReplayController.passed = undefined;
		        ReplayController.timeLine = [];
		        ReplayController.expectedTimeLine = [];
		        ReplayController.pauseInMillis = undefined;
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
		
		    static startReplay(replayLevel) {
		        if (!replayLevel && replayLevel !== MainController.EVENT_REPLAY_LEVEL && replayLevel !== MainController.COMMAND_REPLAY_LEVEL && replayLevel !== MainController.ACTION_REPLAY_LEVEL) {
		            throw new Error(replayLevel + ' is no valid replay level');
		        }
		
		        ReplayController.clearReplayResultDiv();
		
		        ReplayController.expectedTimeLine = [];
		        for (let i = 0; i < ReplayController.timeLine.length; i++) {
		            let item = ReplayController.timeLine[i];
		            if (item.action && replayLevel === MainController.ACTION_REPLAY_LEVEL) {
		                ReplayController.expectedTimeLine.push(item);
		            } else if (item.command && (replayLevel === MainController.ACTION_REPLAY_LEVEL || replayLevel === MainController.COMMAND_REPLAY_LEVEL)) {
		                ReplayController.expectedTimeLine.push(item);
		            } else if (item.event) {
		                ReplayController.expectedTimeLine.push(item);
		            }
		        }
		
		        if (document.getElementById('pauseInMillisInput')) {
		            ReplayController.pauseInMillis = document.getElementById('pauseInMillisInput').value;
		        }
		
		        MainController.replayLevel = replayLevel;
		    }
		
		    static finishReplay() {
		        App.completeReplay();
		        ReplayController.passed = true;
		        if (document.getElementById("replayResultDiv")) {
		            let table = document.getElementById("replayResultDiv");
		            for (let i = 0; i < ReplayController.expectedTimeLine.length; i++) {
		                let expectedItem = ReplayController.expectedTimeLine[i];
		                let actualItem = undefined;
		                if (i < ReplayController.replayTimeLine.length) {
		                    actualItem = ReplayController.replayTimeLine[i];
		                }
		                let row = table.insertRow(table.rows.length);
		                let originalExpectedItemCell = row.insertCell(0);
		                let expectedItemCell = row.insertCell(1);
		                let actualItemCell = row.insertCell(2);
		                let originalActualItemCell = row.insertCell(3);
		                originalExpectedItemCell.innerHTML = '<pre style="font-size: 10px;">' + JSON.stringify(expectedItem, null, 2) + '</pre>';
		                expectedItemCell.innerHTML = '<pre style="font-size: 10px;">' + JSON.stringify(expectedItem, MainController.verificationCleanupFunctionsForReplayLevel[MainController.replayLevel], 2) + '</pre>';
		                actualItemCell.innerHTML = '<pre style="font-size: 10px;">' + JSON.stringify(actualItem, MainController.verificationCleanupFunctionsForReplayLevel[MainController.replayLevel], 2) + '</pre>';
		                originalActualItemCell.innerHTML = '<pre style="font-size: 10px;">' + JSON.stringify(actualItem, null, 2) + '</pre>';
		                if (JSON.stringify(expectedItem, MainController.verificationCleanupFunctionsForReplayLevel[MainController.replayLevel]) === JSON.stringify(actualItem, MainController.verificationCleanupFunctionsForReplayLevel[MainController.replayLevel])) {
		                    row.className = 'success';
		                } else {
		                    row.className = 'danger';
		                    ReplayController.passed = false;
		                }
		            }
		            if (ReplayController.passed) {
		                table.rows[0].className = 'success';
		            } else {
		                table.rows[0].className = 'danger';
		            }
		        } else {
		            for (let i = 0; i < ReplayController.expectedTimeLine.length; i++) {
		                let expectedItem = ReplayController.expectedTimeLine[i];
		                let actualItem = undefined;
		                if (i < ReplayController.replayTimeLine.length) {
		                    actualItem = ReplayController.replayTimeLine[i];
		                }
		                if (JSON.stringify(expectedItem, MainController.verificationCleanupFunctionsForReplayLevel[MainController.replayLevel]) !== JSON.stringify(actualItem, MainController.verificationCleanupFunctionsForReplayLevel[MainController.replayLevel])) {
		                    ReplayController.passed = false;
		                }
		            }
		        }
		        MainController.replayLevel = undefined;
		        MainController.actionQueue.splice(0, MainController.actionQueue.length);
		        MainController.actionIsProcessing = false;
		    }
		
		    static replayEvents() {
		        ReplayController.startReplay(MainController.EVENT_REPLAY_LEVEL);
		        ReplayController.replayTimeLine = [];
		        var index = 0;
		        if (index < ReplayController.timeLine.length) {
		            ReplayController.replayEvent(index, ReplayController.pauseInMillis);
		        }
		    }
		
		    static replayEvent(index, timeout) {
		        var item = ReplayController.timeLine[index];
		        while (item && item.event === undefined && index < ReplayController.timeLine.length) {
		            index++;
		            item = ReplayController.timeLine[index];
		        }
		        if (item && item.event) {
		            ReplayController.addItemToReplayTimeLine({event: item.event});
		            var event = eval('new ' + item.event.eventName + '(item.event.eventData)');
		            event.prepareDataForView();
		            Promise.all(MainController.notifyListeners(event)).then(function () {
		                const nextItem = index + 1 < ReplayController.timeLine.length ? ReplayController.timeLine[index+1] : undefined;
		                if (nextItem !== undefined && nextItem.event === undefined ) {
		                    MainController.applyNextActions();
		                    index++;
		                    if (index < ReplayController.timeLine.length) {
		                        setTimeout(ReplayController.replayEvent, timeout, index, timeout);
		                    } else {
		                        ReplayController.finishReplay();
		                        }
		                } else {
		                    index++;
		                    if (index < ReplayController.timeLine.length) {
		                        setTimeout(ReplayController.replayEvent, timeout, index, timeout);
		                    } else {
		                        ReplayController.finishReplay();
		                    }
		                }
		            }, function (error) {
		                throw error;
		            });
		        } else {
		            ReplayController.finishReplay();
		        }
		    }
		
		    static replayCommands() {
		        ReplayController.startReplay(MainController.COMMAND_REPLAY_LEVEL);
		        ReplayController.replayTimeLine = [];
		        var index = 0;
		        if (index < ReplayController.timeLine.length) {
		            ReplayController.replayCommand(index, ReplayController.pauseInMillis);
		        }
		    }
		
		    static replayCommand(index, timeout) {
		        var item = ReplayController.timeLine[index];
		        while (item && item.command === undefined && index < ReplayController.timeLine.length) {
		            index++;
		            item = ReplayController.timeLine[index];
		        }
		        if (item && item.command) {
		            var command = eval('new ' + item.command.commandName + '(item.command.commandParam)');
		            command.commandData = item.command.commandData;
		            ReplayController.addItemToReplayTimeLine({command: command});
		            MainController.publishEventsOfCommand(command).then(function () {
		                    index++;
		                    if (index < ReplayController.timeLine.length) {
		                        setTimeout(ReplayController.replayCommand, timeout, index, timeout);
		                    } else {
		                        ReplayController.finishReplay();
		                    }
		                },
		                function (error) {
		                    throw error;
		                });
		        } else {
		            ReplayController.finishReplay();
		        }
		    }
		
		    static replayActions() {
		        ReplayController.startReplay(MainController.ACTION_REPLAY_LEVEL);
		        ReplayController.replayTimeLine = [];
		        var index = 0;
		        if (index < ReplayController.timeLine.length) {
		            ReplayController.replayAction(index, ReplayController.pauseInMillis);
		        }
		    }
		
		    static replayAction(index, timeout) {
		        var item = ReplayController.timeLine[index];
		        while (item && item.action === undefined && index < ReplayController.timeLine.length) {
		            index++;
		            item = ReplayController.timeLine[index];
		        }
		        if (item && item.action) {
		            let action = undefined;
		            action = eval('new ' + item.action.actionName + '(item.action.actionParam)');
		            action.actionData = item.action.actionData;
		            action.isUndoAction = item.action.isUndoAction;
		            action.isRedoAction = item.action.isRedoAction;
		            ReplayController.addItemToReplayTimeLine({action: action});
		            action.replay();
		            setTimeout(function () {
		                MainController.executeCommandOfAction(action).then(function () {
		                    index++;
		                    if (index < ReplayController.timeLine.length) {
		                        setTimeout(ReplayController.replayAction, timeout, index, timeout);
		                    } else {
		                        ReplayController.finishReplay();
		                    }
		                }, function (error) {
		                    throw error;
		                });
		            }, timeout);
		        } else {
		            ReplayController.finishReplay();
		        }
		    }
		
		    static executeCommand(command) {
		        ReplayController.addItemToReplayTimeLine({command: command});
		        command.execute();
		    }
		
		    static addItemToReplayTimeLine(item) {
		        item.timestamp = new Date().getTime();
		        ReplayController.replayTimeLine.push(JSON.parse(JSON.stringify(item)));
		    }
		
		    static downloadTimeline() {
		        let timelineJson = JSON.stringify(MainController.getCompleteTimeline(), null, 2);
		
		        let a = window.document.createElement('a');
		        a.href = window.URL.createObjectURL(new Blob([timelineJson], {type: 'text/json'}));
		        a.download = 'scenario.json';
		
		        document.body.appendChild(a);
		        a.click();
		
		        document.body.removeChild(a);
		    }
		
		    static uploadTimeline(event) {
		        ReplayController.clearReplayResultDiv();
		
		        var input = event.target;
		        var reader = new FileReader();
		        reader.onload = function () {
		            let json = reader.result;
		            ReplayController.timeLine = JSON.parse(json);
		            document.getElementById("uploadTimelineInputField").value = "";
		        };
		        reader.readAsText(input.files[0]);
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
		/**
		 * Created by annette on 08.08.16.
		 */
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
