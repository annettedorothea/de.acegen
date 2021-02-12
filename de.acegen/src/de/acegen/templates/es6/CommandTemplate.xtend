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

		import AsynchronousCommand from "../../../gen/ace/AsynchronousCommand";
		«IF aggregatedTriggeredAceOperations.size > 0»
			import TriggerAction from "../../../gen/ace/TriggerAction";
		«ENDIF»
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
		«FOR aceOperation : aggregatedTriggeredAceOperations»
			import «aceOperation.actionName» from "../../../src/«(aceOperation.eContainer as HttpClient).getName»/actions/«aceOperation.actionName»";
		«ENDFOR»
		
		export default class «abstractCommandName» extends AsynchronousCommand {
		    constructor(commandData) {
		        super(commandData, "«es6.getName».«commandName»");
		        «FOR ref : refs»
		        	this.commandData.«ref.varName !== null ? ref.varName : ref.stateElement.name» = AppState.get_«ref.stateElement.functionName»();
		        «ENDFOR»
		        this.commandData.outcomes = [];
		    }
		
			«FOR outcome : outcomes»
				add«outcome.getName.toFirstUpper»Outcome() {
					this.commandData.outcomes.push("«outcome.getName»");
				}
			«ENDFOR»

		    publishEvents() {
				let promises = [];
			    
				«FOR outcome : outcomes»
					«IF outcome.listeners.size > 0 || outcome.triggerdAceOperations.size > 0»
						if (this.commandData.outcomes.includes("«outcome.getName»")) {
							«IF outcome.listeners.size > 0»
								promises.push(new «eventName(outcome)»(this.commandData).publish());
							«ENDIF»
							«FOR triggerdAceOperation : outcome.triggerdAceOperations»
								«IF triggerdAceOperation.delay == 0»
									promises.push(new TriggerAction(new «triggerdAceOperation.aceOperation.actionName»(«FOR inputParam : triggerdAceOperation.aceOperation.input SEPARATOR ', '»this.commandData.«inputParam.name»«ENDFOR»)).publish());
								«ELSE»
									promises.push(new TriggerAction(new «triggerdAceOperation.aceOperation.actionName»(«FOR inputParam : triggerdAceOperation.aceOperation.input SEPARATOR ', '»this.commandData.«inputParam.name»«ENDFOR»)).publishWithDelay(«triggerdAceOperation.delay»));
								«ENDIF»
							«ENDFOR»
						}
					«ENDIF»
				«ENDFOR»
				return Promise.all(promises);
		    }
		    
			«IF serverCall !== null»
				execute() {
				    return new Promise((resolve, reject) => {
				    	«IF (getServerCall.getType == "POST" || getServerCall.getType == "PUT") && getServerCall.payload.size > 0»
				    		let payload = {
				    			«FOR payload : getServerCall.payload SEPARATOR ",\n"»«payload.attribute.name» : this.commandData.«payload.attribute.name»«ENDFOR»
				    		};
				        «ENDIF»
				
						AppUtils.«httpCall»(`«httpUrl»«FOR queryParam : getServerCall.queryParams BEFORE "?" SEPARATOR "&"»«queryParam.attribute.name»=${this.commandData.«queryParam.attribute.name»}«ENDFOR»`, this.commandData.uuid, «IF getServerCall.isAuthorize»true«ELSE»false«ENDIF»«IF (getServerCall.getType == "POST" || getServerCall.getType == "PUT") && getServerCall.payload.size > 0», payload«ENDIF»).then((«IF serverCall.response.size > 0»data«ENDIF») => {
							«FOR attribute : serverCall.response»
								this.commandData.«attribute.name» = data.«attribute.name»;
							«ENDFOR»
							this.handleResponse(resolve, reject);
						}, (message) => {
							this.commandData.message = message;
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

		import SynchronousCommand from "../../../gen/ace/SynchronousCommand";
		«IF aggregatedTriggeredAceOperations.size > 0»
			import TriggerAction from "../../../gen/ace/TriggerAction";
		«ENDIF»
		«IF refs.size > 0»
			import * as AppState from "../../ace/AppState";
		«ENDIF»
		«FOR outcome : outcomes»
			«IF outcome.listeners.size > 0»
				import «eventName(outcome)» from "../../../gen/«es6.getName»/events/«eventName(outcome)»";
			«ENDIF»
		«ENDFOR»
		«FOR aceOperation : aggregatedTriggeredAceOperations»
			import «aceOperation.actionName» from "../../../src/«(aceOperation.eContainer as HttpClient).getName»/actions/«aceOperation.actionName»";
		«ENDFOR»
		
		export default class «abstractCommandName» extends SynchronousCommand {
		    constructor(commandData) {
		        super(commandData, "«es6.getName».«commandName»");
		        this.commandData.outcomes = [];
		        «FOR ref : refs»
		        	this.commandData.«ref.varName !== null ? ref.varName : ref.stateElement.name» = AppState.get_«ref.stateElement.functionName»();
		        «ENDFOR»
		    }
		
			«FOR outcome : outcomes»
				add«outcome.getName.toFirstUpper»Outcome() {
					this.commandData.outcomes.push("«outcome.getName»");
				}
			«ENDFOR»

		    publishEvents() {
				«FOR outcome : outcomes»
					«IF outcome.listeners.size > 0 || outcome.triggerdAceOperations.size > 0»
						if (this.commandData.outcomes.includes("«outcome.getName»")) {
							«IF outcome.listeners.size > 0»
								new «eventName(outcome)»(this.commandData).publish();
							«ENDIF»
							«FOR triggerdAceOperation : outcome.triggerdAceOperations»
								«IF triggerdAceOperation.delay == 0»
									new TriggerAction(new «triggerdAceOperation.aceOperation.actionName»(«FOR inputParam : triggerdAceOperation.aceOperation.input SEPARATOR ', '»this.commandData.«inputParam.name»«ENDFOR»)).publish();
								«ELSE»
									new TriggerAction(new «triggerdAceOperation.aceOperation.actionName»(«FOR inputParam : triggerdAceOperation.aceOperation.input SEPARATOR ', '»this.commandData.«inputParam.name»«ENDFOR»)).publishWithDelay(«triggerdAceOperation.delay»);
								«ENDIF»
							«ENDFOR»
						}
					«ENDIF»
				«ENDFOR»
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
		    	«IF outcomes.size == 1»this.add«outcomes.get(0).getName.toFirstUpper»Outcome();«ENDIF»
		    	resolve();
		    }
		    handleError(resolve, reject) {
		    	reject(this.commandData.message);
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
		    	«IF outcomes.size == 1»this.add«outcomes.get(0).getName.toFirstUpper»Outcome();«ENDIF»
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
		
		export default class AsynchronousCommand extends Command {
		    executeCommand() {
		        ACEController.addItemToTimeLine({command: this});
		        return new Promise((resolve, reject) => {
					if (this.validateCommandData()) {
					    this.execute().then(() => {
					        this.publishEvents();
					        resolve();
					    }, (error) => {
					        reject(error);
					    });
					} else {
				        this.publishEvents();
						resolve();
					}
		        });
		    }
		
		    validateCommandData() {
		    	return true;
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
				ACEController.addItemToTimeLine({command: this});
			    this.execute();
				this.publishEvents();
		    }
		
		}
		
		
		«sdg»
		
		
		
	'''
	
 	
}	

	
/******* S.D.G. *******/
	
	
