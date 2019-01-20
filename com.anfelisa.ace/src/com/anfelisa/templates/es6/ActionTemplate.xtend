package com.anfelisa.templates.es6

import com.anfelisa.ace.ES6
import com.anfelisa.ace.ES6_ACE
import com.anfelisa.extensions.es6.AceExtension
import com.anfelisa.extensions.es6.Es6Extension
import javax.inject.Inject

class ActionTemplate {
	@Inject
	extension AceExtension

	@Inject
	extension Es6Extension
	
	def generateAbstractActionFile(ES6_ACE it, ES6 es6) '''
		import Action from "../../ace/«IF serverCall !== null»AsynchronousAction«ELSE»SynchronousAction«ENDIF»";
		«IF outcomes.size > 0»
			import «commandName» from "../../../src/«es6.name»/commands/«commandName»";
		«ENDIF»
		«IF loadingFlag !== null»
			import * as AppState from "../../ace/AppState";
		«ENDIF»

		export default class «abstractActionName» extends Action {
		
		    constructor(«FOR inputParam: input SEPARATOR ','» «inputParam»«ENDFOR») {
		        super({«FOR inputParam: input SEPARATOR ', '»«inputParam»«ENDFOR»}, '«es6.name».«actionName»');
				«IF loadingFlag !== null»
					this.postCall = this.postCall.bind(this);
				«ENDIF»
		    }
		    
			«IF outcomes.size > 0»
				getCommand() {
					return new «commandName»(this.actionData);
				}
			«ENDIF»
		
			«IF loadingFlag !== null»
				preCall() {
					AppState.set_«loadingFlag.functionName»({«loadingFlag.name»: true});
				}
				
				postCall() {
					AppState.set_«loadingFlag.functionName»({«loadingFlag.name»: false});
				}
			«ENDIF»
		
		}
		
		/*       S.D.G.       */
	'''

	def generateInitialActionFile(ES6_ACE it, ES6 es6) '''
		import «abstractActionName» from "../../../gen/«es6.name»/actions/«abstractActionName»";
		
		export default class «actionName» extends «abstractActionName» {
		
		    initActionData() {
		    	//add not replayable data to action data in order to freeze for replay (e.g. time or date)
		    }
		
		}
		
		/*       S.D.G.       */
	'''
	
	def generateActionFactoryRegistration(ES6 it) '''
		import ACEController from "../ace/ACEController";
		«FOR aceOperation : aceOperations»
			import «aceOperation.actionName» from "../../src/«name»/actions/«aceOperation.actionName»";
		«ENDFOR»
		
		export default class ActionFactoryRegistration«projectName» {
		
			static init() {
				«FOR aceOperation : aceOperations»
					ACEController.registerFactory('«name».«aceOperation.actionName»', 
						(actionData) => new «aceOperation.actionName»(«FOR attr: aceOperation.input SEPARATOR ", "»actionData.«attr»«ENDFOR»));
				«ENDFOR»
			}
		
		}
		
		/*       S.D.G.       */
	'''
	def generateActionFunctionExports(ES6 it) '''
		«FOR aceOperation : aceOperations»
			import «aceOperation.actionName» from "../../src/«name»/actions/«aceOperation.actionName»";
		«ENDFOR»
		
		«FOR aceOperation : aceOperations»
			export function «aceOperation.name.toFirstLower»(«FOR attr: aceOperation.input SEPARATOR ", "»«attr»«ENDFOR») {
			    new «aceOperation.actionName»(«FOR attr: aceOperation.input SEPARATOR ", "»«attr»«ENDFOR»).apply();
			}
			
		«ENDFOR»
		
		/*       S.D.G.       */
	'''
	
	def generateAction() '''
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
		
		/*       S.D.G.       */
		
	'''
	
	def generateAsynchronousAction() '''
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
		            if (ACEController.execution === ACEController.LIVE) {
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
		
		/*       S.D.G.       */
		
	'''
	
	def generateSynchronousAction() '''
		import ACEController from "./ACEController";
		import Action from "./Action";
		import AppUtils from "../../src/app/AppUtils";
		
		export default class SynchronousAction extends Action {

		    constructor(actionData, actionName) {
		    	super(actionData, actionName);
		        this.asynchronous = false;
		    }

		    applyAction() {
		        if (ACEController.execution === ACEController.LIVE) {
		            this.actionData.uuid = AppUtils.createUUID();
		            this.initActionData();
		        }
		        ACEController.addItemToTimeLine({action: this});
		        let command = this.getCommand();
		        command.executeCommand();
		        AppUtils.renderNewState();
		    }
		}
		
		/*       S.D.G.       */
		
	'''

}