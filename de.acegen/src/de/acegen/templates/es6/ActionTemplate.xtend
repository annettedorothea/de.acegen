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
		«IF loadingIndicators.size > 0»
			import * as AppState from "../../../src/AppState";
		«ENDIF»
		
		export default class «abstractActionName» extends Action {
		
		    constructor() {
		        super('«es6.getName».«actionName»');
				«IF loadingIndicators.size > 0»
					this.postCall = this.postCall.bind(this);
				«ENDIF»
			}
				
			«IF outcomes.size > 0»
				getCommand() {
					return new «commandName»();
				}
			«ENDIF»
		
			«IF loadingIndicators.size > 0»
				preCall() {
					«FOR loadingIndicator: loadingIndicators»
						«loadingIndicator.stateFunctionCall("merge", '''{«loadingIndicator.getName»: true}''')»
					«ENDFOR»
					AppState.stateUpdated();
				}
				
				postCall() {
					«FOR loadingIndicator: loadingIndicators»
						«loadingIndicator.stateFunctionCall("merge", '''{«loadingIndicator.getName»: false}''')»
					«ENDFOR»
					AppState.stateUpdated();
				}
			«ENDIF»
		
		}
		
		
		«sdg»
		
	'''

	def generateInitialActionFile(HttpClientAce it, HttpClient es6) '''
		«copyright»

		import «abstractActionName» from "../../../gen/«es6.getName»/actions/«abstractActionName»";
		
		export default class «actionName» extends «abstractActionName» {
		
		    initActionData(data) {
		    	return data;
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
			    return new «aceOperation.actionName»().apply({«FOR inputParam: aceOperation.input SEPARATOR ', '»«inputParam.name»«ENDFOR»});
			}
			
		«ENDFOR»
		
		
		«sdg»
		
	'''
	
	def generateActionIds(HttpClient it) '''
		«copyright»

		module.exports = {
			«FOR aceOperation : aceOperations SEPARATOR ","»
				«aceOperation.getName.toFirstLower» : "«packageFolder»_«aceOperation.getName.toFirstLower»"
				
			«ENDFOR»
		}
		
		
		«sdg»
		
	'''
	
	def generateAction() '''
		«copyright»


		import * as AppUtils from "../../src/AppUtils";
		
		export default class Action {
		
		    constructor(actionName) {
		        this.actionName = actionName;
		    }
		    
		    initSquishy(data) {
				if (AppUtils.settings.mode === "dev") {
				    AppUtils.readSquishyValuesClient(data);
				} else {
				    data.uuid = AppUtils.createUUID();
				    data.clientSystemTime = new Date();
				}
		    }
		    
		}
		

		
		«sdg»
		
		
	'''
	
	def generateAsynchronousAction() '''
		«copyright»


		import Action from "./Action";
		import * as ACEController from "./ACEController";
		import * as AppState from "../../src/AppState";
		import * as AppUtils from "../../src/AppUtils";
		
		export default class AsynchronousAction extends Action {
		
		    constructor(actionName, callback) {
		        super(actionName, callback);
		        this.asynchronous = true;
		    }
		
		    apply(data) {
		        return new Promise((resolve) => {
		            ACEController.addItemToTimeLine({
		                appState: AppState.get([])
		            });
		            ACEController.addItemToTimeLine({
		                action: {
		                    actionName: this.actionName,
		                    data
		                }
		            });
		            this.initSquishy(data);
		            this.applyAction(data).then(
		                resolve,
		                (error) => {
		                    AppUtils.displayUnexpectedError(error);
		                }
		            );
		        });
		    }

		    applyAction(data) {
		        return new Promise((resolve, reject) => {
		            this.preCall();
		            data = this.initActionData(data);
		            let command = this.getCommand();
		            command.executeCommand(data).then(() => {
		                this.postCall();
		                resolve();
		            }, (error) => {
		                this.postCall();
		                reject(error);
		            });
		        });
		    }
		
		    preCall() {
		    }
		
		    postCall() {
		    }
		
		}

		
		«sdg»
		
		
	'''
	
	def generateSynchronousAction() '''
		«copyright»

		import Action from "./Action";
		import * as ACEController from "./ACEController";
		import * as AppState from "../../src/AppState";
		import * as AppUtils from "../../src/AppUtils";
		
		export default class SynchronousAction extends Action {
		
		    constructor(actionName, callback) {
		    	super(actionName, callback);
		    	this.asynchronous = false;
		    }
		    
			apply(data) {
			    ACEController.addItemToTimeLine({
			        appState: AppState.get([])
			    });
			    ACEController.addItemToTimeLine({
			        action: {
			            actionName: this.actionName,
			            data
			        }
			    });
			    this.initSquishy(data);
			    try {
			        this.applyAction(data);
			    } catch (error) {
			        AppUtils.displayUnexpectedError(error);
			    }
			}
		
		    applyAction(data) {
		        data = this.initActionData(data);
			    let command = this.getCommand();
			    command.executeCommand(data);
		    }
		}
		

		
		«sdg»
		
		
	'''

}
	
	
/******* S.D.G. *******/
	
	
