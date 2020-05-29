/* 
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */
 

package de.acegen.templates.es6

import de.acegen.aceGen.HttpClient
import de.acegen.aceGen.HttpClientAce
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.es6.AceExtension
import javax.inject.Inject

class CommandTemplate {
	@Inject
	extension AceExtension

	@Inject
	extension CommonExtension
	
	def generateAsynchronousAbstractCommandFile(HttpClientAce it, HttpClient es6) '''
		«copyright»

		import Command from "../../../gen/ace/AsynchronousCommand";
		import TriggerAction from "../../../gen/ace/TriggerAction";
		import Utils from "../../ace/Utils";
		import ACEController from "../../ace/ACEController";
		«FOR outcome : outcomes»
			«IF outcome.listeners.size > 0»
				import «eventName(outcome)» from "../../../gen/«es6.getName»/events/«eventName(outcome)»";
			«ENDIF»
		«ENDFOR»
		«FOR aceOperation : triggeredAceOperations»
			import «aceOperation.actionName» from "../../../src/«(aceOperation.eContainer as HttpClient).getName»/actions/«aceOperation.actionName»";
		«ENDFOR»
		
		export default class «abstractCommandName» extends Command {
		    constructor(commandData) {
		        super(commandData, "«es6.getName».«commandName»");
		        «FOR outcome : outcomes»
		        	this.«outcome.getName» = "«outcome.getName»";
		        «ENDFOR»
		    }
		
		    publishEvents() {
				let promises = [];
			    	
				switch (this.commandData.outcome) {
				«FOR outcome : outcomes»
					case this.«outcome.getName»:
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
		    
			«IF serverCall !== null»
				execute() {
				    return new Promise((resolve, reject) => {
				    	«IF serverCall.type != 'GET'»
				    		let payload = {
				    			uuid : this.commandData.uuid«FOR payload : getServerCall.payload BEFORE ",\n" SEPARATOR ",\n"»«payload.attribute.name» : this.commandData.«payload.attribute.name»«ENDFOR»
				    		};
				        «ENDIF»
				
						this.«httpCall»(`«httpUrl»?uuid=${this.commandData.uuid}«FOR queryParam : getServerCall.queryParams»&«queryParam.attribute.name»=${this.commandData.«queryParam.attribute.name»}«ENDFOR»`, «IF getServerCall.isAuthorize»true«ELSE»false«ENDIF»«IF (getServerCall.getType == "POST" || getServerCall.getType == "PUT") && getServerCall.payload.size > 0», payload«ENDIF»).then((data) => {
							«FOR responseAttribute : getServerCall.response»
								this.commandData.«responseAttribute.name» = data.«responseAttribute.name»;
							«ENDFOR»
							this.handleResponse(resolve, reject);
						}, (error) => {
							this.commandData.error = error;
							this.handleError(resolve, reject);
						});
				    });
				}
			«ENDIF»
		
		}
		
		
		«sdg»
		
	'''
	
	def generateSynchronousAbstractCommandFile(HttpClientAce it, HttpClient es6) '''
		«copyright»

		import Command from "../../../gen/ace/SynchronousCommand";
		import TriggerAction from "../../../gen/ace/TriggerAction";
		«FOR outcome : outcomes»
			«IF outcome.listeners.size > 0»
				import «eventName(outcome)» from "../../../gen/«es6.getName»/events/«eventName(outcome)»";
			«ENDIF»
		«ENDFOR»
		«FOR aceOperation : triggeredAceOperations»
			import «aceOperation.actionName» from "../../../src/«(aceOperation.eContainer as HttpClient).getName»/actions/«aceOperation.actionName»";
		«ENDFOR»
		
		export default class «abstractCommandName» extends Command {
		    constructor(commandData) {
		        super(commandData, "«es6.getName».«commandName»");
		        «FOR outcome : outcomes»
		        	this.«outcome.getName» = "«outcome.getName»";
		        «ENDFOR»
		    }
		
		    publishEvents() {
				switch (this.commandData.outcome) {
				«FOR outcome : outcomes»
					case this.«outcome.getName»:
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
		
		
		«sdg»
		
	'''
	
	def generateAsynchronousInitialCommandFile(HttpClientAce it, HttpClient es6) '''
		«copyright»

		import «abstractCommandName» from "../../../gen/«es6.getName»/commands/«abstractCommandName»";
		import * as AppState from "../../../gen/ace/ReadAppState";
		//please do not import "../../../gen/ace/WriteAppState" for you should not write the state in a command
		
		export default class «commandName» extends «abstractCommandName» {

		«IF serverCall !== null»
		    initCommandData() {
		    	//add from appState to commandData
		    	return true;
		    }
		
		    handleResponse(resolve, reject) {
		    	«IF outcomes.size == 1»this.commandData.outcome = this.«outcomes.get(0).getName»;«ENDIF»
		    	resolve();
		    }
		    handleError(resolve, reject) {
		    	reject(this.commandData.error);
		    }
		«ELSE»
			execute() {
				return new Promise((resolve, reject) => {
			    });			    
			}
		«ENDIF»
		}
		
		
		«sdg»
		
	'''
	
	def generateSynchronousInitialCommandFile(HttpClientAce it, HttpClient es6) '''
		«copyright»

		import «abstractCommandName» from "../../../gen/«es6.getName»/commands/«abstractCommandName»";
		import * as AppState from "../../../gen/ace/ReadAppState";
		//please do not import "../../../gen/ace/WriteAppState" for you should not write the state in a command
		
		export default class «commandName» extends «abstractCommandName» {
		    execute() {
		    	«IF outcomes.size == 1»this.commandData.outcome = this.«outcomes.get(0).getName»;«ENDIF»
		    }
		}
		
		
		«sdg»
		
	'''
	
	def generateCommand() '''
		«copyright»

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
		
		
		«sdg»
		
	'''
	
	def generateAsynchronousCommand() '''
		«copyright»

		import ACEController from "./ACEController";
		import Command from "./Command";
		import AppUtils from "../../src/app/AppUtils";
		import Utils from "./Utils";
		
		export default class AsynchronousCommand extends Command {
		    executeCommand() {
		        return new Promise((resolve, reject) => {
					if (ACEController.execution !== ACEController.REPLAY) {
						if (this.initCommandData()) {
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
		    	return true;
		    }
		
		    httpGet(url, authorize) {
		        return Utils.prepareAction(this.commandData.uuid).then(() => {
		            return AppUtils.httpGet(url, authorize);
		        }, (error) => {
		            throw error;
		        });
		    }
		
		    httpPost(url, authorize, data) {
		        return Utils.prepareAction(this.commandData.uuid).then(() => {
		            return AppUtils.httpPost(url, authorize, data);
		        }, (error) => {
		            throw error;
		        });
		    }
		
		    httpPut(url, authorize, data) {
		        return Utils.prepareAction(this.commandData.uuid).then(() => {
		            return AppUtils.httpPut(url, authorize, data);
		        }, (error) => {
		            throw error;
		        });
		    }
		
		    httpDelete(url, authorize, data) {
		        return Utils.prepareAction(this.commandData.uuid).then(() => {
		            return AppUtils.httpDelete(url, authorize, data);
		        }, (error) => {
		            throw error;
		        });
		    }
		
		}
		
		
		«sdg»
		
		
		
	'''
	
	def generateSynchronousCommand() '''
		«copyright»

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
		
		
		«sdg»
		
		
		
	'''
	
 	
}	

	
/******* S.D.G. *******/
	
	
