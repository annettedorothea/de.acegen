/* 
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */
 

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
		import * as AppState from "../ace/WriteAppState";
		
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
		        this.notifyListeners();
				ACEController.addItemToTimeLine({event: this});
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
	
}
	
	
/******* S.D.G. *******/
	
	
