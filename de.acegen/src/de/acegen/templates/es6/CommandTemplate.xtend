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
import de.acegen.extensions.HttpServerExtension
import de.acegen.extensions.es6.AceExtension
import de.acegen.extensions.es6.Es6Extension
import de.acegen.extensions.java.ModelExtension
import javax.inject.Inject

class CommandTemplate {
	@Inject
	extension AceExtension

	@Inject
	extension CommonExtension
	
	@Inject
	extension Es6Extension
	
	@Inject
	extension HttpServerExtension

	@Inject
	extension ModelExtension
	
	def boolean hasEventOutcome(HttpClientAce it) {
		for(outcome: outcomes) {
			if (outcome.listeners.size > 0 || outcome.functions.size > 0) {
				return true;
			}
		}
		return false
	}
	
	def generateAsynchronousAbstractCommandFile(HttpClientAce it, HttpClient es6) '''
		«copyright»

		import AsynchronousCommand from "../../ace/AsynchronousCommand";
		import Event from "../../ace/Event";
		import * as AppUtils from "../../../src/AppUtils";
		import * as AppState from "../../../src/AppState";
		«FOR aceOperation : aggregatedTriggeredAceOperations»
			import «aceOperation.actionName» from "../../../src/«(aceOperation.eContainer as HttpClient).getName»/actions/«aceOperation.actionName»";
		«ENDFOR»
		
		export default class «abstractCommandName» extends AsynchronousCommand {
		    constructor() {
		        super("«es6.getName».«commandName»");
		    }
		    
		    initCommandData(data) {
		        «FOR ref : refs»
		        	data.«ref.varName !== null ? ref.varName : ref.stateElement.name» = «ref.stateElement.stateFunctionCall("get", "data")»;
		        «ENDFOR»
		        data.outcomes = [];
		    }
		
			«FOR outcome : outcomes»
				add«outcome.getName.toFirstUpper»Outcome(data) {
					data.outcomes.push("«outcome.getName»");
				}
			«ENDFOR»

			«IF serverCall !== null»
				execute(data) {
				    return new Promise((resolve, reject) => {
				    	«IF (getServerCall.getType == "POST" || getServerCall.getType == "PUT") && getServerCall.payload.size > 0 && !getServerCall.isMulitpartFormData»
				    		let payload = {
				    			«FOR payload : getServerCall.payload SEPARATOR ",\n"»«payload.attribute.name» : data.«payload.attribute.name»«ENDFOR»
				    		};
				    	«ELSEIF (getServerCall.getType == "POST" || getServerCall.getType == "PUT") && getServerCall.isMulitpartFormData»
				    		const formData = data.«getServerCall.getModel.formDataAttributeName»;
				        «ENDIF»
						AppUtils.«httpCall»(
								`«httpUrl»«FOR queryParam : getServerCall.queryParams BEFORE "?" SEPARATOR "&"»${data.«queryParam.attribute.name» ? `«queryParam.attribute.name»=${data.«queryParam.attribute.name»}` : ""}«ENDFOR»`, 
								data.uuid, 
								«IF getServerCall.isAuthorize»true«ELSE»false«ENDIF»«IF (getServerCall.getType == "POST" || getServerCall.getType == "PUT")»«IF getServerCall.isMulitpartFormData»,
								 formData, "«getServerCall.getModel.formDataAttributeName»"«ELSEIF getServerCall.payload.size > 0»,
								 payload«ENDIF»«ENDIF»).then((«IF serverCall.response.size > 0»response«ENDIF») => {
							«FOR attribute : serverCall.response»
								data.«attribute.name» = response.«attribute.name»;
							«ENDFOR»
							this.handleResponse(data, resolve, reject);
						}, (error) => {
							data.error = error;
							this.handleError(data, resolve, reject);
						});
				    });
				}
			«ENDIF»
			
			publishEvents(data) {
				return new Promise((resolve) => {
					const events = [];
					const actionsToBeTriggered = [];
					«FOR outcome : outcomes»
						«IF outcome.listeners.size > 0 || outcome.triggerdAceOperations.size > 0 || outcome.functions.size > 0»
							if (data.outcomes.includes("«outcome.getName»")) {
								events.push(new Event('«es6.getName».«eventName(outcome)»'));
								«FOR triggerdAceOperation : outcome.triggerdAceOperations»
									«IF triggerdAceOperation.delay == 0»
										actionsToBeTriggered.push(
											{
												action: new «triggerdAceOperation.aceOperation.actionName»(), 
												data: {
													«FOR inputParam : triggerdAceOperation.aceOperation.input SEPARATOR ', '»
														«inputParam.name»: data.«inputParam.name»
													«ENDFOR»
												}
											}
										);
									«ELSE»
										«IF triggerdAceOperation.takeLatest»
											this.triggerWithDelayTakeLatest(new «triggerdAceOperation.aceOperation.actionName»(), 
												{
													«FOR inputParam : triggerdAceOperation.aceOperation.input SEPARATOR ', '»
														«inputParam.name»: data.«inputParam.name»
													«ENDFOR»
												},
												«triggerdAceOperation.delay»
											);
										«ELSE»
											this.triggerWithDelay(new «triggerdAceOperation.aceOperation.actionName»(), 
												{
													«FOR inputParam : triggerdAceOperation.aceOperation.input SEPARATOR ', '»
														«inputParam.name»: data.«inputParam.name»
													«ENDFOR»
												},
												«triggerdAceOperation.delay»
											);
										«ENDIF»
									«ENDIF»
								«ENDFOR»
							}
						«ENDIF»
					«ENDFOR»
					
					this.publish(events, data).then(() => {
				  		AppState.stateUpdated();
						this.trigger(actionsToBeTriggered).then(resolve);
					});
				})
			
			}

		}
		
		«sdg»
		
	'''
	
	def generateSynchronousAbstractCommandFile(HttpClientAce it, HttpClient es6) '''
		«copyright»

		import SynchronousCommand from "../../ace/SynchronousCommand";
		import Event from "../../ace/Event";
		«FOR aceOperation : aggregatedTriggeredAceOperations»
			import «aceOperation.actionName» from "../../../src/«(aceOperation.eContainer as HttpClient).getName»/actions/«aceOperation.actionName»";
		«ENDFOR»
		import * as AppUtils from "../../../src/AppUtils";
		import * as AppState from "../../../src/AppState";
		
		export default class «abstractCommandName» extends SynchronousCommand {
		    constructor() {
		        super("«es6.getName».«commandName»");
		    }
		
		    initCommandData(data) {
		        «FOR ref : refs»
		        	data.«ref.varName !== null ? ref.varName : ref.stateElement.name» = «ref.stateElement.stateFunctionCall("get", "data")»;
		        «ENDFOR»
		        data.outcomes = [];
		    }

			«FOR outcome : outcomes»
				add«outcome.getName.toFirstUpper»Outcome(data) {
					data.outcomes.push("«outcome.getName»");
				}
			«ENDFOR»
			
			publishEvents(data) {
				const events = [];
				const actionsToBeTriggered = [];
				«FOR outcome : outcomes»
					«IF outcome.listeners.size > 0 || outcome.triggerdAceOperations.size > 0 || outcome.functions.size > 0»
						if (data.outcomes.includes("«outcome.getName»")) {
							events.push(new Event('«es6.getName».«eventName(outcome)»'));
							«FOR triggerdAceOperation : outcome.triggerdAceOperations»
								«IF triggerdAceOperation.delay == 0»
									actionsToBeTriggered.push(
										{
											action: new «triggerdAceOperation.aceOperation.actionName»(), 
											data: {
												«FOR inputParam : triggerdAceOperation.aceOperation.input SEPARATOR ', '»
													«inputParam.name»: data.«inputParam.name»
												«ENDFOR»
											}
										}
									);
								«ELSE»
									«IF triggerdAceOperation.takeLatest»
										this.triggerWithDelayTakeLatest(new «triggerdAceOperation.aceOperation.actionName»(), 
											{
												«FOR inputParam : triggerdAceOperation.aceOperation.input SEPARATOR ', '»
													«inputParam.name»: data.«inputParam.name»
												«ENDFOR»
											},
											«triggerdAceOperation.delay»
										);
									«ELSE»
										this.triggerWithDelay(new «triggerdAceOperation.aceOperation.actionName»(), 
											{
												«FOR inputParam : triggerdAceOperation.aceOperation.input SEPARATOR ', '»
													«inputParam.name»: data.«inputParam.name»
												«ENDFOR»
											},
											«triggerdAceOperation.delay»
										);
									«ENDIF»
								«ENDIF»
							«ENDFOR»
						}
					«ENDIF»
				«ENDFOR»
				
				this.publish(events, data);
			  	AppState.stateUpdated();
				this.trigger(actionsToBeTriggered);
		
			}
	
		}
		
		«sdg»
		
	'''
	
	def generateAsynchronousInitialCommandFile(HttpClientAce it, HttpClient es6) '''
		«copyright»

		import «abstractCommandName» from "../../../gen/«es6.getName»/commands/«abstractCommandName»";
		
		export default class «commandName» extends «abstractCommandName» {

		«IF serverCall !== null»
		    validateCommandData(data) {
		    	«FOR param : serverCall.queryParams»
		    		«IF param.isNotNull»//data.«param.attribute.name» is mandatory «param.attribute.type»«ENDIF»
		    	«ENDFOR»
		    	«FOR param : serverCall.pathParams»
		    		«IF param.isNotNull»//data.«param.attribute.name» is mandatory «param.attribute.type»«ENDIF»
		    	«ENDFOR»
		    	«FOR param : serverCall.payload»
		    		«IF param.isNotNull»//data.«param.attribute.name» is mandatory «param.attribute.type»«ENDIF»
		    	«ENDFOR»
		    	return true;
		    }
		
		    handleResponse(data, resolve, reject) {
		    	«IF outcomes.size == 1»this.add«outcomes.get(0).getName.toFirstUpper»Outcome(data);«ENDIF»
		    	resolve(data);
		    }
		    handleError(data, resolve, reject) {
		    	reject(data.error);
		    }
		«ELSE»
			execute(data) {
			    return new Promise((resolve, reject) => {
				    resolve(data);
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
		    execute(data) {
		    	«IF outcomes.size == 1»this.add«outcomes.get(0).getName.toFirstUpper»Outcome(data);«ENDIF»
		    	return data;
		    }
		}
		
		
		«sdg»
		
	'''
	
	def generateCommand() '''
		«copyright»
		
		
		let delayedActions = {};
		
		export default class Command {
		    
		    constructor(commandName) {
		        this.commandName = commandName;
		    }
		    
			triggerWithDelay(action, data, delayInMillis) {
				setTimeout(() => {
					action.apply(data);
				}, delayInMillis);
			}
			
			triggerWithDelayTakeLatest(action, data, delayInMillis) {
				const existingTimeout = delayedActions[action.actionName];
				if (existingTimeout) {
					clearTimeout(existingTimeout);
				}
				delayedActions[action.actionName] = setTimeout(() => {
					delayedActions[action.actionName] = undefined;
					action.apply(data);
				}, delayInMillis);
			}
			
		
		}
		
		
		«sdg»
		
	'''
	
	def generateAsynchronousCommand() '''
		«copyright»


		import * as ACEController from "./ACEController";
		import Command from "./Command";
		
		export default class AsynchronousCommand extends Command {
		    
		    executeCommand(data) {
				this.initCommandData(data);
		        ACEController.addItemToTimeLine({
					command: {
						commandName: this.commandName,
						data
					}
		        });
		        return new Promise((resolve, reject) => {
					if (this.validateCommandData(data)) {
					    this.execute(data).then((data) => {
					        this.publishEvents(data).then(resolve);
					    }, (error) => {
					        reject(error);
					    });
					} else {
					    this.publishEvents(data).then(resolve);
					}
		        });
		    }
		
		    validateCommandData() {
		    	return true;
		    }
		
			createEventPromise(event, data) {
				return new Promise(resolve => {
					event.publish(data);
					resolve();
				})
			}
			
			publish(events, data) {
				if (events.length === 0) {
					return new Promise(resolve => resolve());
				}
				return this.createEventPromise(events.shift(), data)
					.then(event => events.length === 0 ? event : this.publish(events, data));
			}
			
			createActionPromise(actionToBeTriggered) {
				return new Promise(resolve => {
					if (actionToBeTriggered.action.asynchronous) {
						actionToBeTriggered.action.apply(actionToBeTriggered.data).then(resolve);
					} else {
						actionToBeTriggered.action.apply(actionToBeTriggered.data);
						resolve();
					}
				})
			}
			
			trigger(actionsToBeTriggered) {
				if (actionsToBeTriggered.length === 0) {
					return new Promise(resolve => resolve());
				}
				return this.createActionPromise(actionsToBeTriggered.shift())
					.then(actionToBeTriggered => actionsToBeTriggered.length === 0 ? actionToBeTriggered : this.trigger(actionsToBeTriggered));
			}
			
		}

		
		«sdg»
		
		
		
	'''
	
	def generateSynchronousCommand() '''
		«copyright»

		import * as ACEController from "./ACEController";
		import Command from "./Command";
		
		export default class SynchronousCommand extends Command {
		    
		    executeCommand(data) {
				this.initCommandData(data);
		        ACEController.addItemToTimeLine({
					command: {
						commandName: this.commandName,
						data
					}
		        });
			    data = this.execute(data);
			    this.publishEvents(data)
		    }
		
			publish(events, data) {
				events.forEach(
					event => event.publish(data)
				)
			}
		
			trigger(actionsToBeTriggered) {
				actionsToBeTriggered.forEach(
				    actionToBeTriggered => this.triggerWithDelay(actionToBeTriggered.action, actionToBeTriggered.data, 1)
				)
			}
		
		}
		
		
		«sdg»
		
		
		
	'''
	
 	
}	

	
/******* S.D.G. *******/
	
	
