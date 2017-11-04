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
		«IF project.generateModules»
			import Action from "../../../ace/Action";
			«IF command !== null»
				import «command.commandName» from "../../../../src/«project.name»/commands/«command.commandName»";
		    «ENDIF»
		«ENDIF»
		
		«IF project.generateModules»export default «ENDIF»class «abstractActionName» extends Action {
		
		    constructor(actionParam) {
		        super(actionParam, '«actionName»', «IF init»true«ELSE»false«ENDIF»);
		    }
		
			«IF command !== null»
			    getCommand() {
			    		return new «command.commandName»(this.actionData);
			    }
		    «ENDIF»
		
		}
		
		/*       S.D.G.       */
	'''

	def generateInitialActionFile(Action it, Project project) '''
		«IF project.generateModules»
			import «abstractActionName» from "../../../gen/app/«project.name»/actions/«abstractActionName»";
		«ENDIF»
		
		«IF project.generateModules»export default «ENDIF»class «actionName» extends «abstractActionName» {
		
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
		«IF project.generateModules»
			import Command from "../../../../gen/ace/Command";
			import TriggerAction from "../../../../gen/ace/TriggerAction";
			«FOR event : eventsOfCommand»
				import «event.eventName» from "../../../../src/«(event.eContainer as Project).name»/events/«event.eventName»";
			«ENDFOR»
			«FOR action : triggeredActionsOfCommand»
				import «action.actionName» from "../../../../src/«(action.eContainer as Project).name»/actions/«action.actionName»";
			«ENDFOR»
		«ENDIF»
		
		«IF project.generateModules»export default «ENDIF»class «abstractCommandName» extends Command {
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
	
	def generateInitialCommandFile(Command it, Project project) '''
		«IF project.generateModules»
			import «abstractCommandName» from "../../../gen/app/«project.name»/commands/«abstractCommandName»";
		«ENDIF»
		
		«IF project.generateModules»export default «ENDIF»class «commandName» extends «abstractCommandName» {
		    execute() {
		        return new Promise((resolve) => {
					resolve();
		        });
		    }
		}
		
		/*       S.D.G.       */
	'''
	
	def generateAbstractEventFile(Event it, Project project) '''
		«IF project.generateModules»
			import Event from "../../../../gen/ace/Event";
		«ENDIF»
		
		«IF project.generateModules»export default «ENDIF»class «abstractEventName» extends Event {
		    constructor(eventParam) {
		        super(eventParam, '«eventName»');
		    }
		}
		
		/*       S.D.G.       */
	'''
	def generateInitialEventFile(Event it, Project project) '''
		«IF project.generateModules»
			import «abstractEventName» from "../../../gen/app/«project.name»/events/«abstractEventName»";
		«ENDIF»
		
		«IF project.generateModules»export default «ENDIF»class «eventName» extends «abstractEventName» {
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
		«IF generateModules»
			import ACEController from "../../ace/ACEController";
			«FOR view : referencedViews»
				import «view.viewName» from "../../../src/«(view.eContainer as Project).name»/«view.viewName»";
			«ENDFOR»
		«ENDIF»
		
		«IF generateModules»export default «ENDIF»class EventListenerRegistration«projectName» {
		
			static init() {
		    	«FOR event : events»
		    		«FOR renderFunction : event.listeners»
		    			ACEController.registerListener('«event.eventName»', «renderFunction.viewFunctionWithViewName»);
		    		«ENDFOR»
		    	«ENDFOR»
			}
		
		}
		
		/*       S.D.G.       */
	'''
	def generateView(View it, Project project) '''

		«IF project.generateModules»export default «ENDIF»class «viewName» {
		    «FOR renderFunction : renderFunctions»
		    	static «renderFunction.name»(eventData) {
		    	};
		    	
		    «ENDFOR»
		}
		
		/*                    S.D.G.                    */
	'''

	def generateAction(Project it) '''
		«IF generateModules»
			import ACEController from "./ACEController";
			import AppUtils from "../../app/AppUtils";
		«ENDIF»
		
		«IF generateModules»export default «ENDIF»class Action {
		    constructor(actionParam, actionName, isInitAction) {
		        this.actionName = actionName;
		        if (actionParam === undefined) {
		            actionParam = {};
		        }
		        this.actionParam = JSON.parse(JSON.stringify(actionParam));
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

	def generateCommand(Project it) '''
		«IF generateModules»
			import ACEController from "./ACEController";
			import AppUtils from "../../app/AppUtils";
			import ReplayUtils from "../../app/ReplayUtils";
		«ENDIF»
		
		«IF generateModules»export default «ENDIF»class Command {
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
	
	def generateEvent(Project it) '''
		«IF generateModules»
			import ACEController from "./ACEController";
		«ENDIF»
		
		«IF generateModules»export default «ENDIF»class Event {
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
	
	def generateAppUtilsStub(Project it) '''
		«IF generateModules»
			import ACEController from "ACEController";
		«ENDIF»
		
		«IF generateModules»export default «ENDIF»class AppUtils {
		
		    static start() {
		    }
		
		    static timelineChanged(items) {
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
		    
			static createUUID() {
			    //return some kind of uuid
			}
		    
		    
		
		}
		
		/*       S.D.G.       */
		
	'''
	
	def generateAppStub(Project it) '''
		«IF generateModules»
			import ACEController from "ACEController";
			import AppUtils from "AppUtils";
		«ENDIF»
		
		AppUtils.start();
		
		// add EventListenerRegistration.init() of all modules
		
		/*       S.D.G.       */
		
	'''
	
	def generateReplayUtilsStub(Project it) '''
		«IF generateModules»
			import ACEController from "ACEController";
		«ENDIF»
		
		«IF generateModules»export default «ENDIF»class ReplayUtils {
		
		    static actualTimelineChanged(items) {
		    }
		
		    static expectedTimelineChanged(items) {
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
	
	def generateACEController(Project it) '''
		«IF generateModules»
			import AppUtils from "../../app/AppUtils";
			import ReplayUtils from "../../app/ReplayUtils";
		«ENDIF»
		
		«IF generateModules»export default «ENDIF»class ACEController {
		
		    static init() {
		        ACEController.timeline = [];
		        ACEController.listeners = {};
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
		            AppUtils.timelineChanged([item]);
		        } else {
		            ACEController.actualTimeline.push(JSON.parse(JSON.stringify(item)));
		            ReplayUtils.actualTimelineChanged([item]);
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
		        ReplayUtils.expectedTimelineChanged(ACEController.expectedTimeline);
				ACEController.actualTimeline = [];
				ReplayUtils.actualTimelineChanged([]);
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
		        
		        ReplayUtils.actualTimelineChanged([]);
		
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
		        
		        ReplayUtils.expectedTimelineChanged(ACEController.expectedTimeline);
		        
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
		
		}
		
		ACEController.init();
		
		/*       S.D.G.       */
		
	'''
	
	def generateTriggerAction(Project it) '''
		«IF generateModules»
			import Event from "./Event";
		«ENDIF»
		
		«IF generateModules»export default «ENDIF»class TriggerAction extends Event {
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

	
}
