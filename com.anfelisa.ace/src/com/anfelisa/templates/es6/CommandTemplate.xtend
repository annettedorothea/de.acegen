package com.anfelisa.templates.es6

import com.anfelisa.ace.ES6
import com.anfelisa.ace.ES6_ACE
import com.anfelisa.extensions.es6.AceExtension
import javax.inject.Inject

class CommandTemplate {
	@Inject
	extension AceExtension

	def generateAsynchronousAbstractCommandFile(ES6_ACE it, ES6 es6) '''
		import Command from "../../../gen/ace/«IF serverCall !== null»AsynchronousCommand«ELSE»SynchronousCommand«ENDIF»";
		import TriggerAction from "../../../gen/ace/TriggerAction";
		«FOR outcome : outcomes»
			«IF outcome.listeners.size > 0»
				import «eventName(outcome)» from "../../../gen/«es6.name»/events/«eventName(outcome)»";
			«ENDIF»
		«ENDFOR»
		«FOR aceOperation : triggeredAceOperations»
			import «aceOperation.actionName» from "../../../src/«(aceOperation.eContainer as ES6).name»/actions/«aceOperation.actionName»";
		«ENDFOR»
		
		export default class «abstractCommandName» extends Command {
		    constructor(commandData) {
		        super(commandData, "«es6.name».«commandName»");
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
							promises.push(new TriggerAction(new «aceOperation.actionName»(«FOR inputParam : aceOperation.input SEPARATOR ', '»this.commandData.«inputParam»«ENDFOR»)).publish());
						«ENDFOR»
						break;
				«ENDFOR»
				default:
					return new Promise((resolve, reject) => {reject('«commandName» unhandled outcome: ' + this.commandData.outcome)});
				}
				return Promise.all(promises);
		    }
		    
			execute() {
			    return new Promise((resolve, reject) => {
					let queryParams = [];
				    «FOR queryParam : serverCall.queryParams»
				    	queryParams.push({key: "«queryParam.name»",value: this.commandData.«queryParam.name»});
			        «ENDFOR»
			        «IF serverCall.payload.size > 0»let payload = {	
			        	«FOR payload : serverCall.payload»
			        		«payload.name» : this.commandData.«payload.name»,
			        	«ENDFOR»
			        	};
			        «ENDIF»
		
					this.«httpCall»(`«httpUrl»`, «IF serverCall.authorize»true«ELSE»false«ENDIF», queryParams«IF (serverCall.type == "POST" || serverCall.type == "PUT") && serverCall.payload.size > 0», payload«ENDIF»).then((data) => {
						«FOR responseAttribute : serverCall.response»
							this.commandData.«responseAttribute.name» = data.«responseAttribute.name»;
						«ENDFOR»
						this.handleResponse(resolve, reject);
					}, (error) => {
						this.commandData.error = error;
						this.handleError(resolve, reject);
					});
			    });
			}
		
		}
		
		/*       S.D.G.       */
	'''
	
	def generateSynchronousAbstractCommandFile(ES6_ACE it, ES6 es6) '''
		import Command from "../../../gen/ace/«IF serverCall !== null»AsynchronousCommand«ELSE»SynchronousCommand«ENDIF»";
		import TriggerAction from "../../../gen/ace/TriggerAction";
		«FOR outcome : outcomes»
			«IF outcome.listeners.size > 0»
				import «eventName(outcome)» from "../../../gen/«es6.name»/events/«eventName(outcome)»";
			«ENDIF»
		«ENDFOR»
		«FOR aceOperation : triggeredAceOperations»
			import «aceOperation.actionName» from "../../../src/«(aceOperation.eContainer as ES6).name»/actions/«aceOperation.actionName»";
		«ENDFOR»
		
		export default class «abstractCommandName» extends Command {
		    constructor(commandData) {
		        super(commandData, "«es6.name».«commandName»");
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
							new TriggerAction(new «aceOperation.actionName»(«FOR inputParam : aceOperation.input SEPARATOR ', '»this.commandData.«inputParam»«ENDFOR»)).publish();
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
	
	def generateAsynchronousInitialCommandFile(ES6_ACE it, ES6 es6) '''
		import «abstractCommandName» from "../../../gen/«es6.name»/commands/«abstractCommandName»";
		
		export default class «commandName» extends «abstractCommandName» {

		    initCommandData() {
		    	//add from appState to commandData 
		    }

		    isCommandDataValid() {
		    	return true;
		    }

		    handleResponse(resolve, reject) {
		    	«IF outcomes.size == 1»this.commandData.outcome = this.«outcomes.get(0).name»;«ENDIF»
		    	resolve();
		    }
		    handleError(resolve, reject) {
		    	reject(this.commandData.error);
		    }
		}
		
		/*       S.D.G.       */
	'''
	
	def generateSynchronousInitialCommandFile(ES6_ACE it, ES6 es6) '''
		import «abstractCommandName» from "../../../gen/«es6.name»/commands/«abstractCommandName»";
		
		export default class «commandName» extends «abstractCommandName» {
		    execute() {
		    	«IF outcomes.size == 1»this.commandData.outcome = this.«outcomes.get(0).name»;«ENDIF»
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
						this.initCommandData();
						if (this.isCommandDataValid() === true) {
						    this.execute().then(() => {
						        ACEController.addItemToTimeLine({command: this});
						        this.publishEvents();
						        resolve();
						    }, (error) => {
						        reject(error);
						    });
						} else {
					        ACEController.addItemToTimeLine({command: this});
					        this.publishEvents();
							resolve();
						}
					} else {
					    const timelineCommand = ACEController.getCommandByUuid(this.commandData.uuid);
					    this.commandData = timelineCommand.commandData;
					    ACEController.addItemToTimeLine({command: this});
				        this.publishEvents();
				        resolve();
					}
		        });
		    }
		
		    initCommandData() {
		    }
		
		    isCommandDataValid() {
		    	return true;
		    }
		
		    httpGet(url, authorize, queryParams) {
		        return Utils.prepareAction(this.commandData.uuid).then(() => {
		            queryParams = this.addUuidToQueryParams(queryParams);
		            return AppUtils.httpGet(url, authorize, queryParams, this.commandData);
		        }, (error) => {
		            reject(error);
		        });
		    }
		
		    httpPost(url, authorize, queryParams, data) {
		        return Utils.prepareAction(this.commandData.uuid).then(() => {
		            queryParams = this.addUuidToQueryParams(queryParams);
		            data = this.addUuidToData(data);
		            return AppUtils.httpPost(url, authorize, queryParams, data);
		        }, (error) => {
		            reject(error);
		        });
		    }
		
		    httpPut(url, authorize, queryParams, data) {
		        return Utils.prepareAction(this.commandData.uuid).then(() => {
		            queryParams = this.addUuidToQueryParams(queryParams);
		            data = this.addUuidToData(data);
		            return AppUtils.httpPut(url, authorize, queryParams, data);
		        }, (error) => {
		            reject(error);
		        });
		    }
		
		    httpDelete(url, authorize, queryParams, data) {
		        return Utils.prepareAction(this.commandData.uuid).then(() => {
		            queryParams = this.addUuidToQueryParams(queryParams);
		            data = this.addUuidToData(data);
		            return AppUtils.httpDelete(url, authorize, queryParams, data);
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
	
 	
}