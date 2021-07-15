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
	
	def boolean hasEventOutcome(HttpClientAce it) {
		for(outcome: outcomes) {
			if (outcome.listeners.size > 0) {
				return true;
			}
		}
		return false
	}
	
	def generateAsynchronousAbstractCommandFile(HttpClientAce it, HttpClient es6) '''
		«copyright»

		import AsynchronousCommand from "../../ace/AsynchronousCommand";
		«IF hasEventOutcome»
			import Event from "../../ace/Event";
		«ENDIF»
		«IF aggregatedTriggeredAceOperations.size > 0»
			import TriggerAction from "../../ace/TriggerAction";
		«ENDIF»
		import * as Utils from "../../ace/Utils";
		import * as AppUtils from "../../../src/app/AppUtils";
		«IF refs.size > 0 || aggregatedListeners.size > 0»
			import * as AppState from "../../ace/AppState";
		«ENDIF»
		«FOR aceOperation : aggregatedTriggeredAceOperations»
			import «aceOperation.actionName» from "../../../src/«(aceOperation.eContainer as HttpClient).getName»/actions/«aceOperation.actionName»";
		«ENDFOR»
		
		export default class «abstractCommandName» extends AsynchronousCommand {
		    constructor() {
		        super("«es6.getName».«commandName»");
		    }
		    
		    initCommandData(data) {
		        «FOR ref : refs»
		        	data.«ref.varName !== null ? ref.varName : ref.stateElement.name» = AppState.get_«ref.stateElement.functionName»();
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
				    	«IF (getServerCall.getType == "POST" || getServerCall.getType == "PUT") && getServerCall.payload.size > 0»
				    		let payload = {
				    			«FOR payload : getServerCall.payload SEPARATOR ",\n"»«payload.attribute.name» : data.«payload.attribute.name»«ENDFOR»
				    		};
				        «ENDIF»
						AppUtils.«httpCall»(`«httpUrl»«FOR queryParam : getServerCall.queryParams BEFORE "?" SEPARATOR "&"»«queryParam.attribute.name»=${data.«queryParam.attribute.name»}«ENDFOR»`, data.uuid, «IF getServerCall.isAuthorize»true«ELSE»false«ENDIF»«IF (getServerCall.getType == "POST" || getServerCall.getType == "PUT") && getServerCall.payload.size > 0», payload«ENDIF»).then((«IF serverCall.response.size > 0»response«ENDIF») => {
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
				«FOR outcome : outcomes»
					«IF outcome.listeners.size > 0 || outcome.triggerdAceOperations.size > 0»
						if (data.outcomes.includes("«outcome.getName»")) {
							«IF outcome.listeners.size > 0»
								new Event('«es6.getName».«eventName(outcome)»').publish(data);
								AppUtils.stateUpdated(AppState.getAppState());
							«ENDIF»
							«FOR triggerdAceOperation : outcome.triggerdAceOperations»
								«IF triggerdAceOperation.delay == 0»
									new TriggerAction().publish(
										new «triggerdAceOperation.aceOperation.actionName»(), 
											{
												«FOR inputParam : triggerdAceOperation.aceOperation.input SEPARATOR ', '»
													«inputParam.name»: data.«inputParam.name»
												«ENDFOR»
											}
									)
								«ELSE»
									«IF triggerdAceOperation.takeLatest»
										new TriggerAction().publishWithDelayTakeLatest(
											new «triggerdAceOperation.aceOperation.actionName»(), 
												{
													«FOR inputParam : triggerdAceOperation.aceOperation.input SEPARATOR ', '»
														«inputParam.name»: data.«inputParam.name»
													«ENDFOR»
												},
											«triggerdAceOperation.delay»
										)
									«ELSE»
										new TriggerAction().publishWithDelay(
											new «triggerdAceOperation.aceOperation.actionName»(), 
												{
													«FOR inputParam : triggerdAceOperation.aceOperation.input SEPARATOR ', '»
														«inputParam.name»: data.«inputParam.name»
													«ENDFOR»
												},
											«triggerdAceOperation.delay»
										)
									«ENDIF»
								«ENDIF»
							«ENDFOR»
						}
					«ENDIF»
				«ENDFOR»
		    }

		}
		
		«sdg»
		
	'''
	
	def generateSynchronousAbstractCommandFile(HttpClientAce it, HttpClient es6) '''
		«copyright»

		import SynchronousCommand from "../../ace/SynchronousCommand";
		«IF hasEventOutcome»
			import Event from "../../ace/Event";
		«ENDIF»
		«IF aggregatedListeners.size > 0»
			import * as AppUtils from "../../../src/app/AppUtils";
		«ENDIF»
		«IF aggregatedTriggeredAceOperations.size > 0»
			import TriggerAction from "../../ace/TriggerAction";
		«ENDIF»
		«IF refs.size > 0 || aggregatedListeners.size > 0»
			import * as AppState from "../../ace/AppState";
		«ENDIF»
		«FOR aceOperation : aggregatedTriggeredAceOperations»
			import «aceOperation.actionName» from "../../../src/«(aceOperation.eContainer as HttpClient).getName»/actions/«aceOperation.actionName»";
		«ENDFOR»
		
		export default class «abstractCommandName» extends SynchronousCommand {
		    constructor() {
		        super("«es6.getName».«commandName»");
		    }
		
		    initCommandData(data) {
		        «FOR ref : refs»
		        	data.«ref.varName !== null ? ref.varName : ref.stateElement.name» = AppState.get_«ref.stateElement.functionName»();
		        «ENDFOR»
		        data.outcomes = [];
		    }

			«FOR outcome : outcomes»
				add«outcome.getName.toFirstUpper»Outcome(data) {
					data.outcomes.push("«outcome.getName»");
				}
			«ENDFOR»

		    publishEvents(data) {
				«FOR outcome : outcomes»
					«IF outcome.listeners.size > 0 || outcome.triggerdAceOperations.size > 0»
						if (data.outcomes.includes("«outcome.getName»")) {
							«IF outcome.listeners.size > 0»
								new Event('«es6.getName».«eventName(outcome)»').publish(data);
								AppUtils.stateUpdated(AppState.getAppState());
							«ENDIF»
							«FOR triggerdAceOperation : outcome.triggerdAceOperations»
								«IF triggerdAceOperation.delay == 0»
									new TriggerAction().publish(
										new «triggerdAceOperation.aceOperation.actionName»(), 
											{
												«FOR inputParam : triggerdAceOperation.aceOperation.input SEPARATOR ', '»
													«inputParam.name»: data.«inputParam.name»
												«ENDFOR»
											}
									)
								«ELSE»
									«IF triggerdAceOperation.takeLatest»
										new TriggerAction().publishWithDelayTakeLatest(
											new «triggerdAceOperation.aceOperation.actionName»(), 
												{
													«FOR inputParam : triggerdAceOperation.aceOperation.input SEPARATOR ', '»
														«inputParam.name»: data.«inputParam.name»
													«ENDFOR»
												},
											«triggerdAceOperation.delay»
										)
									«ELSE»
										new TriggerAction().publishWithDelay(
											new «triggerdAceOperation.aceOperation.actionName»(), 
												{
													«FOR inputParam : triggerdAceOperation.aceOperation.input SEPARATOR ', '»
														«inputParam.name»: data.«inputParam.name»
													«ENDFOR»
												},
											«triggerdAceOperation.delay»
										)
									«ENDIF»
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


		export default class Command {
		    
		    constructor(commandName) {
		        this.commandName = commandName;
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
					        this.publishEvents(data);
					        resolve();
					    }, (error) => {
					        reject(error);
					    });
					} else {
				        this.publishEvents(data);
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
				this.publishEvents(data);
		    }
		
		}
		
		
		«sdg»
		
		
		
	'''
	
 	
}	

	
/******* S.D.G. *******/
	
	
