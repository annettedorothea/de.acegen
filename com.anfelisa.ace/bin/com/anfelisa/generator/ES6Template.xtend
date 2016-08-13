package com.anfelisa.generator

import com.anfelisa.ace.Action
import com.anfelisa.ace.Command
import com.anfelisa.ace.Event
import com.anfelisa.extensions.ActionExtension
import com.anfelisa.extensions.CommandExtension
import com.anfelisa.extensions.EventExtension
import com.anfelisa.ace.Project
import javax.inject.Inject
import com.anfelisa.extensions.ViewExtension
import com.anfelisa.ace.View

class ES6Template {
	
	@Inject
	extension ActionExtension

	@Inject
	extension CommandExtension

	@Inject
	extension EventExtension
	
	@Inject
	extension ViewExtension
	
	def generateAbstractActionFile(Action it) '''
		'use strict';
		
		class «abstractActionName» extends Action {
		
		    constructor(actionParam) {
		        super(actionParam, '«actionName»');
		    }
		
			«IF command != null»
			    getCommand() {
			        return new «command.commandName»(this.actionData);
			    }
		    «ENDIF»
		
		    replay() {
		    }
		
		}
		
		/*       S.D.G.       */
	'''

	def generateInitialActionFile(Action it) '''
		'use strict';
		
		class «actionName» extends «abstractActionName» {
		
		    initActionDataFromView() {
		        return new Promise((resolve) => {
		            resolve();
		        });
		    }
		
		    replay() {
		    }
		}
		
		/*       S.D.G.       */
	'''
	
	def generateAbstractCommandFile(Command it) '''
		'use strict';
		
		class «abstractCommandName» extends Command {
		    constructor(commandParam) {
		        super(commandParam, "«commandName»");
		        «FOR eventOnOutcome : eventsOnOutcome»
		        	this.«eventOnOutcome.outcome» = "«eventOnOutcome.outcome»";
		        «ENDFOR»
		    }
		
		    publishEvents() {
		    	let promises = [];
		    	
		        switch (this.commandData.outcome) {
		        «FOR eventOnOutcome : eventsOnOutcome»
		        	case this.«eventOnOutcome.outcome»:
		        		«FOR event : eventOnOutcome.events»
		        			promises.push(new «event.eventName»(this.commandData).publish());
		        		«ENDFOR»
		        		«FOR action : eventOnOutcome.actions»
		        			promises.push(new TriggerAction(new «action.actionName»(this.commandData)).publish());
		        		«ENDFOR»
		        		break;
		        «ENDFOR»
		    	default:
		    		throw 'unhandled outcome: ' + this.commandData.outcome;
		    	}
		    	return Promise.all(promises);
		    }
		}
		
		/*       S.D.G.       */
	'''
	
	def generateInitialCommandFile(Command it) '''
		'use strict';
		
		class «commandName» extends «abstractCommandName» {
		    execute() {
		        return new Promise((resolve) => {
					resolve();
		        });
		    }
		}
		
		/*       S.D.G.       */
	'''
	
	def generateEventFile(Event it) '''
		'use strict';
		
		class «eventName» extends Event {
		    constructor(eventParam) {
		        super(eventParam, «eventName».getName());
		    }
		    static getName() {
		        return '«eventName»';
		    }
		}
		
		/*       S.D.G.       */
	'''
	def generateEventListenerRegistration(Project it) '''
		'use strict';
		
		class EventListenerRegistration {
			static init() {
		    	«FOR event : events»
		    		«FOR renderFunction : event.listeners»
		    			MainController.registerListener(«event.eventName».getName(), «renderFunction.renderFunctionWithViewName»);
		    		«ENDFOR»
		    	«ENDFOR»
			}
		}
		
		/*       S.D.G.       */
	'''
	def generateView(View it) '''
		'use strict';
		
		class «viewName» extends View {
		    constructor() {
		        super('«viewName»');
		    }
		
		    reset() {
		        return new Promise(() => {
		            //MainController.addActionToQueue(new InitAppAction());
		        });
		    }
		    
		    «FOR renderFunction : renderFunctions»
		    	static «renderFunction.name»(data) {
		    	};
		    	
		    «ENDFOR»
		}
		
		/*                    S.D.G.                    */
	'''

	def generateHtmlDevSnippet(Project it) '''
		«FOR action: actions»
			<script type="text/javascript" src="es6/gen/«name»/actions/«action.abstractActionName».es6"></script>
			<script type="text/javascript" src="es6/src/«name»/actions/«action.actionName».es6"></script>
		«ENDFOR»
		«FOR command: commands»
			<script type="text/javascript" src="es6/gen/«name»/commands/«command.abstractCommandName».es6"></script>
			<script type="text/javascript" src="es6/src/«name»/commands/«command.commandName».es6"></script>
		«ENDFOR»
		«FOR event: events»
			<script type="text/javascript" src="es6/gen/«name»/events/«event.eventName».es6"></script>
		«ENDFOR»
		<script type="text/javascript" src="es6/gen/«name»/EventListenerRegistration.es6"></script>
		«FOR view: views»
			<script type="text/javascript" src="es6/src/«name»/«view.viewName».es6"></script>
		«ENDFOR»
	'''

}
