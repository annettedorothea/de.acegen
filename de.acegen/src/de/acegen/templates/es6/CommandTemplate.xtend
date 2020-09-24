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
import de.acegen.aceGen.HttpClientAce
import de.acegen.aceGen.HttpServerAceRead
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.es6.AceExtension
import de.acegen.extensions.es6.Es6Extension
import javax.inject.Inject

class CommandTemplate {
	@Inject
	extension AceExtension

	@Inject
	extension CommonExtension
	
	@Inject
	extension Es6Extension
	
	def generateAsynchronousAbstractCommandFile(HttpClientAce it, HttpClient es6) '''
		«copyright»

		import AbstractAsynchronousCommand from "../../../gen/ace/AbstractAsynchronousCommand";
		import TriggerAction from "../../../gen/ace/TriggerAction";
		import Utils from "../../ace/Utils";
		import AppUtils from "../../../src/app/AppUtils";
		«IF refs.size > 0»
			import * as AppState from "../../ace/AppState";
		«ENDIF»
		«FOR outcome : outcomes»
			«IF outcome.listeners.size > 0»
				import «eventName(outcome)» from "../../../gen/«es6.getName»/events/«eventName(outcome)»";
			«ENDIF»
		«ENDFOR»
		«FOR aceOperation : triggeredAceOperations»
			import «aceOperation.actionName» from "../../../src/«(aceOperation.eContainer as HttpClient).getName»/actions/«aceOperation.actionName»";
		«ENDFOR»
		
		export default class «abstractCommandName» extends AbstractAsynchronousCommand {
		    constructor(commandData) {
		        super(commandData, "«es6.getName».«commandName»");
		        «FOR outcome : outcomes»
		        	this.«outcome.getName» = "«outcome.getName»";
		        «ENDFOR»
		        «FOR ref : refs»
		        	this.commandData.«ref.varName !== null ? ref.varName : ref.stateElement.name» = AppState.get_«ref.stateElement.functionName»();
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
							promises.push(new TriggerAction(new «aceOperation.actionName»(«FOR inputParam : aceOperation.input SEPARATOR ', '»this.commandData.«inputParam.name»«ENDFOR»)).publish());
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
				    			«FOR payload : getServerCall.payload SEPARATOR ",\n"»«payload.attribute.name» : this.commandData.«payload.attribute.name»«ENDFOR»
				    		};
				        «ENDIF»
				
						AppUtils.«httpCall»(`«httpUrl»«FOR queryParam : getServerCall.queryParams BEFORE "?" SEPARATOR "&"»«queryParam.attribute.name»=${this.commandData.«queryParam.attribute.name»}«ENDFOR»`, this.commandData.uuid, «IF getServerCall.isAuthorize»true«ELSE»false«ENDIF»«IF (getServerCall.getType == "POST" || getServerCall.getType == "PUT") && getServerCall.payload.size > 0», payload«ENDIF»).then((data) => {
							«IF getServerCall instanceof HttpServerAceRead»
								«FOR attribute : (getServerCall as HttpServerAceRead).response»
									this.commandData.«attribute.name» = data.«attribute.name»;
								«ENDFOR»
							«ENDIF»
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

		import AbstractSynchronousCommand from "../../../gen/ace/AbstractSynchronousCommand";
		import TriggerAction from "../../../gen/ace/TriggerAction";
		«IF refs.size > 0»
			import * as AppState from "../../ace/AppState";
		«ENDIF»
		«FOR outcome : outcomes»
			«IF outcome.listeners.size > 0»
				import «eventName(outcome)» from "../../../gen/«es6.getName»/events/«eventName(outcome)»";
			«ENDIF»
		«ENDFOR»
		«FOR aceOperation : triggeredAceOperations»
			import «aceOperation.actionName» from "../../../src/«(aceOperation.eContainer as HttpClient).getName»/actions/«aceOperation.actionName»";
		«ENDFOR»
		
		export default class «abstractCommandName» extends AbstractSynchronousCommand {
		    constructor(commandData) {
		        super(commandData, "«es6.getName».«commandName»");
		        «FOR outcome : outcomes»
		        	this.«outcome.getName» = "«outcome.getName»";
		        «ENDFOR»
		        «FOR ref : refs»
		        	this.commandData.«ref.varName !== null ? ref.varName : ref.stateElement.name» = AppState.get_«ref.stateElement.functionName»();
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
							new TriggerAction(new «aceOperation.actionName»(«FOR inputParam : aceOperation.input SEPARATOR ', '»this.commandData.«inputParam.name»«ENDFOR»)).publish();
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
		
		export default class «commandName» extends «abstractCommandName» {

		«IF serverCall !== null»
		    validateCommandData() {
		    	«FOR param : serverCall.queryParams»
		    		«IF param.isNotNull»//this.commandData.«param.attribute.name» is mandatory «param.attribute.type»«ENDIF»
		    	«ENDFOR»
		    	«FOR param : serverCall.pathParams»
		    		«IF param.isNotNull»//this.commandData.«param.attribute.name» is mandatory «param.attribute.type»«ENDIF»
		    	«ENDFOR»
		    	«FOR param : serverCall.payload»
		    		«IF param.isNotNull»//this.commandData.«param.attribute.name» is mandatory «param.attribute.type»«ENDIF»
		    	«ENDFOR»
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
	
	def generateAbstractAsynchronousCommand() '''
		«copyright»

		import ACEController from "./ACEController";
		import Command from "./Command";
		
		export default class AbstractAsynchronousCommand extends Command {
		    executeCommand() {
		        return new Promise((resolve, reject) => {
					if (ACEController.execution === ACEController.UI) {
						if (this.validateCommandData()) {
						    this.execute().then(() => {
						        ACEController.addItemToTimeLine({command: this});
						        this.publishEvents();
						        resolve();
						    }, (error) => {
						    	ACEController.addItemToTimeLine({command: this});
						        reject(error);
						    });
						} else {
					        ACEController.addItemToTimeLine({command: this});
					        this.publishEvents();
							resolve();
						}
					} else {
						const timelineCommand = ACEController.getCommandByUuid(this.commandData.uuid);
						if (timelineCommand) {
						    if (timelineCommand.commandData.error) {
						        reject(timelineCommand.commandData.error);
						    } else {
						        this.commandData = timelineCommand.commandData;
						        ACEController.addItemToTimeLine({command: this});
						        this.publishEvents();
						        resolve();
						    }
						} else {
						    resolve();
						}
					}
		        });
		    }
		
		    validateCommandData() {
		    	return true;
		    }
		
		}
		
		
		«sdg»
		
		
		
	'''
	
	def generateAbstractSynchronousCommand() '''
		«copyright»

		import ACEController from "./ACEController";
		import Command from "./Command";
		
		export default class AbstractSynchronousCommand extends Command {
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
	
	
