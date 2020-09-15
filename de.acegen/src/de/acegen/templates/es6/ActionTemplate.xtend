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

class ActionTemplate {
	@Inject
	extension AceExtension

	@Inject
	extension Es6Extension
	
	@Inject
	extension CommonExtension
	
	def generateAbstractActionFile(HttpClientAce it, HttpClient es6) '''
		«copyright»

		import Action from "../../ace/«IF isAsync || getServerCall !== null»AsynchronousAction«ELSE»SynchronousAction«ENDIF»";
		«IF outcomes.size > 0»
			import «commandName» from "../../../src/«es6.getName»/commands/«commandName»";
		«ENDIF»
		«IF getLoadingFlag !== null»
			import * as AppState from "../../ace/AppState";
		«ENDIF»
		
		export default class «abstractActionName» extends Action {
		
		    constructor(«FOR inputParam: input SEPARATOR ','» «inputParam.name»«ENDFOR») {
		        super({«FOR inputParam: input SEPARATOR ', '»«inputParam.name»«ENDFOR»}, '«es6.getName».«actionName»');
				«IF getLoadingFlag !== null»
					this.postCall = this.postCall.bind(this);
				«ENDIF»
				}
				
			«IF outcomes.size > 0»
				getCommand() {
					return new «commandName»(this.actionData);
				}
			«ENDIF»
		
			«IF getLoadingFlag !== null»
				preCall() {
					AppState.set_«getLoadingFlag.functionName»({«getLoadingFlag.getName»: true});
				}
				
				postCall() {
					AppState.set_«getLoadingFlag.functionName»({«getLoadingFlag.getName»: false});
				}
			«ENDIF»
		
		}
		
		
		«sdg»
		
	'''

	def generateInitialActionFile(HttpClientAce it, HttpClient es6) '''
		«copyright»

		import «abstractActionName» from "../../../gen/«es6.getName»/actions/«abstractActionName»";
		
		export default class «actionName» extends «abstractActionName» {
		
		    initActionData() {
		    	//add not replayable data to action data in order to freeze for replay (e.g. time or date)
		    }
		
		}
		
		
		«sdg»
		
	'''
	
	def generateActionFactoryRegistration(HttpClient it) '''
		«copyright»

		import ACEController from "../ace/ACEController";
		«FOR aceOperation : aceOperations»
			import «aceOperation.actionName» from "../../src/«getName»/actions/«aceOperation.actionName»";
		«ENDFOR»
		
		export default class ActionFactoryRegistration«projectName» {
		
			static init() {
				«FOR aceOperation : aceOperations»
					ACEController.registerFactory('«getName».«aceOperation.actionName»', 
						(actionData) => new «aceOperation.actionName»(«FOR attr: aceOperation.input SEPARATOR ", "»actionData.«attr.name»«ENDFOR»));
				«ENDFOR»
			}
		
		}
		
		
		«sdg»
		
	'''
	def generateActionFunctionExports(HttpClient it) '''
		«copyright»

		«FOR aceOperation : aceOperations»
			import «aceOperation.actionName» from "../../src/«getName»/actions/«aceOperation.actionName»";
		«ENDFOR»
		
		«FOR aceOperation : aceOperations»
			export function «aceOperation.getName.toFirstLower»(«FOR attr: aceOperation.input SEPARATOR ", "»«attr.name»«ENDFOR») {
			    new «aceOperation.actionName»(«FOR attr: aceOperation.input SEPARATOR ", "»«attr.name»«ENDFOR»).apply();
			}
			
		«ENDFOR»
		
		
		«sdg»
		
	'''
	
	def generateAction() '''
		«copyright»

		import ACEController from "./ACEController";
		import AppUtils from "../../src/app/AppUtils";
		
		export default class Action {
		    constructor(actionData, actionName) {
		        this.actionName = actionName;
		        if (actionData === undefined) {
		            actionData = {};
		        }
		        this.actionData = AppUtils.deepCopy(actionData);
		    }
		
		    initActionData() {
		    }
		
		    getCommand() {
		        throw "no command defined for " + this.actionName;
		    }
		
		    apply() {
		        ACEController.addActionToQueue(this);
		    }
		}
		
		
		«sdg»
		
		
	'''
	
	def generateAsynchronousAction() '''
		«copyright»

		import ACEController from "./ACEController";
		import Action from "./Action";
		import AppUtils from "../../src/app/AppUtils";
		
		export default class AsynchronousAction extends Action {
		
		    constructor(actionData, actionName) {
		    	super(actionData, actionName);
		    	   this.asynchronous = true;
		    }
			
			   applyAction() {
			       return new Promise((resolve, reject) => {
			           if (this.preCall) {
			           	this.preCall();
			           }
			           AppUtils.renderNewState();
			           if (ACEController.execution === ACEController.UI) {
			               this.actionData.uuid = AppUtils.createUUID();
			               this.initActionData();
			           }
			           ACEController.addItemToTimeLine({action: this});
			           let command = this.getCommand();
					command.executeCommand().then(
					    () => {
					           if (this.postCall) {
					           	this.postCall();
					           }
					        AppUtils.renderNewState();
					        resolve();
					    },
					    (error) => {
					           if (this.postCall) {
					           	this.postCall();
					           }
					        AppUtils.renderNewState();
					        reject(error);
					    }
					);
					     });
					 }
		
		}
		
		
		«sdg»
		
		
	'''
	
	def generateSynchronousAction() '''
		«copyright»

		import ACEController from "./ACEController";
		import Action from "./Action";
		import AppUtils from "../../src/app/AppUtils";
		
		export default class SynchronousAction extends Action {
		
		    constructor(actionData, actionName) {
		    	super(actionData, actionName);
		    	   this.asynchronous = false;
		    }
		
		    applyAction() {
		    if (ACEController.execution === ACEController.UI) {
		        this.actionData.uuid = AppUtils.createUUID();
		        this.initActionData();
		    }
		    ACEController.addItemToTimeLine({action: this});
		    let command = this.getCommand();
		    command.executeCommand();
		    AppUtils.renderNewState();
		    }
		}
		
		
		«sdg»
		
		
	'''

}
	
	
/******* S.D.G. *******/
	
	
