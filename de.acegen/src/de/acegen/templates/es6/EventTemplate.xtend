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
import de.acegen.aceGen.HttpClientOutcome
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.es6.AceExtension
import de.acegen.extensions.es6.Es6Extension
import javax.inject.Inject

class EventTemplate {
	
	@Inject
	extension AceExtension

	@Inject
	extension Es6Extension
	
	@Inject
	extension CommonExtension
	
	def generateAbstractEventFile(HttpClientAce it, HttpClientOutcome outcome, HttpClient es6) '''
		«copyright»

		import Event from "../../../gen/ace/Event";
		
		export default class «eventName(outcome)» extends Event {
		    constructor(eventData) {
		        super(eventData, '«es6.getName».«eventName(outcome)»');
		    }
		}
		
		
		«sdg»
		
	'''
	def generateEventListenerRegistration(HttpClient it) '''
		«copyright»

		import ACEController from "../ace/ACEController";
		import * as AppState from "../ace/AppState";
		
		export default class EventListenerRegistration«projectName» {
		
			static init() {
				«FOR aceOperation : aceOperations»
					«FOR outcome : aceOperation.outcomes»
						«FOR listener : outcome.listeners»
							ACEController.registerListener('«getName».«aceOperation.eventName(outcome)»', «listener.appStateFunction()»);
						«ENDFOR»
					«ENDFOR»
				«ENDFOR»
			}
		
		}
		
		
		«sdg»
		
	'''

	def generateEvent() '''
		«copyright»

		import AppUtils from "../../src/app/AppUtils";
		import ACEController from "./ACEController";
		
		export default class Event {
		    constructor(eventData, eventName) {
		        this.eventName = eventName;
		        this.eventData = AppUtils.deepCopy(eventData);
		    }
		
		    publish() {
				ACEController.addItemToTimeLine({event: this});
		        this.notifyListeners();
		    }
		
		    replay() {
		        this.notifyListeners();
		    }

		    notifyListeners() {
		        let i, listener;
		        if (this.eventName !== undefined) {
		            const listenersForEvent = ACEController.listeners[this.eventName];
		            if (listenersForEvent !== undefined) {
		                for (i = 0; i < listenersForEvent.length; i += 1) {
		                    listener = listenersForEvent[i];
							listener(AppUtils.deepCopy(this.eventData));
		                }
		            }
		        }
		    }
		
		}
		
		
		«sdg»
		
		
	'''

	def generateTriggerAction() '''
		«copyright»

		import Event from "./Event";
		import ACEController from "./ACEController";
		
		export default class TriggerAction extends Event {
		    constructor(action) {
		        super(action, 'TriggerAction');
		        this.eventData = action;
		    }
		
			publish() {
			    ACEController.addItemToTimeLine({event: this});
			    this.notifyListeners();
			}
			
			publishWithDelay(delayInMillis) {
		    	setTimeout(() => {
					ACEController.addItemToTimeLine({event: this});
					this.notifyListeners();
				}, delayInMillis);
			}

			publishWithDelayTakeLatest(delayInMillis) {
				const existingTimeout = ACEController.delayedActions[this.eventData.actionName];
				if (existingTimeout) {
					clearTimeout(existingTimeout);
				}
				const timeout = setTimeout(() => {
					ACEController.delayedActions[this.eventData.actionName] = undefined;
					ACEController.addItemToTimeLine({event: this});
					this.notifyListeners();
				}, delayInMillis);
				ACEController.delayedActions[this.eventData.actionName] = timeout;
			}

			replay() {
			}
			
			notifyListeners() {
				let i, listener;
				if (this.eventName !== undefined) {
					const listenersForEvent = ACEController.listeners[this.eventName];
					if (listenersForEvent !== undefined) {
						for (i = 0; i < listenersForEvent.length; i += 1) {
							listener = listenersForEvent[i];
							listener(this.eventData);
						}
					}
				}
			}

		}
		
		
		«sdg»
		
		
	'''
	

	def generateEventFactoryRegistration(HttpClient it) '''
		«copyright»

		import ACEController from "../ace/ACEController";
		«FOR aceOperation : aceOperations»
			«FOR outcome : aceOperation.outcomes»
				«IF outcome.listeners.size > 0»
					import «aceOperation.eventName(outcome)» from "./events/«aceOperation.eventName(outcome)»";
				«ENDIF»
			«ENDFOR»
		«ENDFOR»
		
		export default class EventFactoryRegistration«projectName» {
		
			static init() {
				«FOR aceOperation : aceOperations»
					«FOR outcome : aceOperation.outcomes»
						«IF outcome.listeners.size > 0»
							ACEController.registerFactory('«getName».«aceOperation.eventName(outcome)»', 
								(eventData) => new «aceOperation.eventName(outcome)»(eventData));
						«ENDIF»
					«ENDFOR»
				«ENDFOR»
			}
		
		}
		
		
		«sdg»
		
	'''
	
}
	
	
/******* S.D.G. *******/
	
	
