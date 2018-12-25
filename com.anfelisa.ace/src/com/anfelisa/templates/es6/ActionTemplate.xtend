package com.anfelisa.templates.es6

import com.anfelisa.ace.ES6
import com.anfelisa.ace.ES6_ACE
import com.anfelisa.extensions.es6.AceExtension
import com.anfelisa.extensions.es6.Es6Extension
import com.anfelisa.extensions.es6.ViewExtension
import javax.inject.Inject

class ActionTemplate {
	@Inject
	extension AceExtension

	@Inject
	extension ViewExtension
	
	@Inject
	extension Es6Extension
	
	def generateAbstractActionFile(ES6_ACE it, ES6 es6) '''
		import Action from "../../ace/«IF serverCall !== null»AsynchronousAction«ELSE»SynchronousAction«ENDIF»";
		«IF outcomes.size > 0»
			import «commandName» from "../../../src/«es6.name»/commands/«commandName»";
	    «ENDIF»
		«FOR view : preAndPostUpdateUIViews»
			import «view.viewName» from "../../../src/«(view.eContainer as ES6).name»/views/«view.viewName»";
		«ENDFOR»

		export default class «abstractActionName» extends Action {
		
		    constructor(actionData) {
		        super(actionData, '«es6.name».«actionName»');
				«IF serverCall !== null»
					this.postCall = this.postCall.bind(this);
				«ENDIF»
		    }
		
			«IF outcomes.size > 0»
				getCommand() {
					return new «commandName»(this.actionData);
				}
			«ENDIF»
		
			«IF serverCall !== null»
				preCall() {
					«FOR viewFunction : preCall»
						«viewFunction.viewFunctionWithViewName»(this.actionData);
					«ENDFOR»
				}
			
				postCall() {
					«FOR viewFunction : postCall»
						«viewFunction.viewFunctionWithViewName»(this.actionData);
					«ENDFOR»
				}
			«ENDIF»
		
		}
		
		/*       S.D.G.       */
	'''

	def generateInitialActionFile(ES6_ACE it, ES6 es6) '''
		import «abstractActionName» from "../../../gen/«es6.name»/actions/«abstractActionName»";
		
		export default class «actionName» extends «abstractActionName» {
		
		    initActionData() {
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
					ACEController.registerFactory('«name».«aceOperation.actionName»', (actionData) => new «aceOperation.actionName»(actionData));
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
			export function «aceOperation.name.toFirstLower»(actionData) {
			    new «aceOperation.actionName»(actionData).apply();
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
		
		    extendActionData() {
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
		            this.preCall();
		            if (ACEController.execution === ACEController.LIVE) {
		                this.actionData.uuid = AppUtils.createUUID();
		                this.extendActionData();
		            }
		            this.initActionData();
		            ACEController.addItemToTimeLine({action: this});
		            let command = this.getCommand();
		            if (command) {
		                command.executeCommand().then(
		                    () => {
		                        this.postCall();
		                        resolve();
		                    },
		                    (error) => {
		                        this.postCall();
		                        reject(error);
		                    }
		                );
		            } else {
		                this.postCall();
		                resolve();
		            }
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
		            this.extendActionData();
		        }
		        this.initActionData();
		        ACEController.addItemToTimeLine({action: this});
		        let command = this.getCommand();
		        if (command) {
		            command.executeCommand();
		        }
		    }
		}
		
		/*       S.D.G.       */
		
	'''

}