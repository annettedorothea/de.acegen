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
	
	def generateEventListenerRegistration(HttpClient it) '''
		«copyright»

		import * as ACEController from "../ace/ACEController";
		import * as AppState from "../../src/AppState";
		
		export default class EventListenerRegistration«projectName» {
		
			static init() {
				«FOR aceOperation : aceOperations»
					«FOR outcome : aceOperation.outcomes»
						«FOR listener : outcome.listeners»
							ACEController.registerListener('«getName».«aceOperation.eventName(outcome)»', «listener.appStateFunction()»);
						«ENDFOR»
						«FOR function : outcome.functions»
							ACEController.registerListener('«getName».«aceOperation.eventName(outcome)»', «function.appStateFunction()»);
						«ENDFOR»
					«ENDFOR»
				«ENDFOR»
			}
		
		}
		
		
		«sdg»
		
	'''

	def generateEvent() '''
		«copyright»

		import * as ACEController from "./ACEController";
		
		export default class Event {
		    constructor(eventName) {
		        this.eventName = eventName;
		    }

		    publish(data) {
		        ACEController.addItemToTimeLine({
		            event: {
		                eventName: this.eventName,
		                data
		            }
		        });
		        this.notifyListeners(data);
		    }
		
		    replay(data) {
		        this.notifyListeners(data);
		    }
		
		    notifyListeners(data) {
		        let i, listener;
		        if (this.eventName !== undefined) {
		            const listenersForEvent = ACEController.listeners[this.eventName];
		            if (listenersForEvent !== undefined) {
		                for (i = 0; i < listenersForEvent.length; i += 1) {
		                    listener = listenersForEvent[i];
							listener(data);
		                }
		            }
		        }
		    }
		
		}
		
		
		«sdg»
		
		
	'''

}
	
	
/******* S.D.G. *******/
	
	
