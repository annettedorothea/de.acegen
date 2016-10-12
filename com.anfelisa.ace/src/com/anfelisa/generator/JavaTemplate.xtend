package com.anfelisa.generator

import com.anfelisa.ace.Action
import com.anfelisa.ace.Command
import com.anfelisa.ace.Event
import com.anfelisa.ace.Project
import com.anfelisa.ace.View
import com.anfelisa.extensions.ActionExtension
import com.anfelisa.extensions.CommandExtension
import com.anfelisa.extensions.EventExtension
import com.anfelisa.extensions.ViewExtension
import javax.inject.Inject

class JavaTemplate {
	
	@Inject
	extension ActionExtension

	@Inject
	extension CommandExtension

	@Inject
	extension EventExtension
	
	@Inject
	extension ViewExtension
	
	def generateAbstractActionFile(Action it, Project project) '''
		package «project.name».actions;
		
		import com.anfelisa.ace.Action;
		import com.anfelisa.ace.DatabaseHandle;
		import com.anfelisa.ace.HttpMethod;
		import com.anfelisa.ace.ICommand;
		import com.anfelisa.ace.IDataContainer;
		
		«IF command != null»
			import «project.name».commands.«command.commandName»;
		«ENDIF»
		
		public abstract class «abstractActionName» extends Action {
		
			public «abstractActionName»(IDataContainer actionParam, DatabaseHandle databaseHandle) {
				super("«actionName»", HttpMethod.«type», actionParam, databaseHandle);
			}
		
			@Override
			public ICommand getCommand() {
				«IF command != null»
					return new «command.commandName»(this.actionData, databaseHandle);
				«ELSE»
					return null;
				«ENDIF»
			}
		}
		
		/*       S.D.G.       */
	'''

	def generateAbstractCommandFile(Command it, Project project) '''
		package «project.name».commands;
		
		import javax.ws.rs.WebApplicationException;
		
		import com.anfelisa.ace.Command;
		import com.anfelisa.ace.DatabaseHandle;
		import com.anfelisa.ace.DatabaseService;
		import com.anfelisa.ace.IDataContainer;

		public abstract class «abstractCommandName» extends Command {
		
			«FOR eventOnOutcome : eventsOnOutcome»
				protected static final String «eventOnOutcome.outcome» = "«eventOnOutcome.outcome»";
			«ENDFOR»
		
			public «abstractCommandName»(IDataContainer commandParam, DatabaseHandle databaseHandle) {
				super("«commandName»", commandParam, databaseHandle);
			}
		
			@Override
			protected void publishEvents() {
				switch (this.outcome) {
				«FOR eventOnOutcome : eventsOnOutcome»
					case «eventOnOutcome.outcome»:
						«FOR event : eventOnOutcome.events»
							new «event.eventNameWithPackage»(this.commandData, databaseHandle).publish();
						«ENDFOR»
						«FOR action : eventOnOutcome.actions»
							final «action.actionNameWithPackage» action = new «action.actionNameWithPackage»(this.commandData, DatabaseService.getDatabaseHandle());
							Thread actionThread = new Thread(new Runnable() {
								public void run() {
									action.apply();
								}
							});
							actionThread.start();
							
						«ENDFOR»
						break;
				«ENDFOR»
				default:
					throw new WebApplicationException("unhandled outcome " + outcome);
				}
			}
		}
		
		/*       S.D.G.       */
	'''

	def generateAbstractEventFile(Event it, Project project) '''
		package «project.name».events;
		
		import com.anfelisa.ace.DatabaseHandle;
		import com.anfelisa.ace.Event;
		import com.anfelisa.ace.IDataContainer;
		
		public abstract class «abstractEventName» extends Event {
		
			public «abstractEventName»(IDataContainer eventParam, DatabaseHandle databaseHandle) {
				super("«eventName»", eventParam, databaseHandle);
			}
		
		}
		
		/*       S.D.G.       */
	'''

	def generateInitialActionFile(Action it, Project project) '''
		package «project.name».actions;
		
		import com.anfelisa.ace.DatabaseHandle;
		import com.anfelisa.ace.IDataContainer;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		public class «actionName» extends «abstractActionName» {
		
			static final Logger LOG = LoggerFactory.getLogger(«actionName».class);

			public «actionName»(IDataContainer actionParam, DatabaseHandle databaseHandle) {
				super(actionParam, databaseHandle);
			}
		
			@Override
			protected void captureActionParam() {
				// capture all stuff that we need to replay this action (e.g. system time)
			}
		
			@Override
			protected void applyAction() {
				// init actionData
				this.actionData = this.actionParam;
			}
		
		}
		
		/*       S.D.G.       */
	'''
	
	def generateInitialCommandFile(Command it, Project project) '''
		package «project.name».commands;
		
		import com.anfelisa.ace.DatabaseHandle;
		import com.anfelisa.ace.IDataContainer;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		public class «commandName» extends «abstractCommandName» {
		
			static final Logger LOG = LoggerFactory.getLogger(«commandName».class);

			public «commandName»(IDataContainer commandParam, DatabaseHandle databaseHandle) {
				super(commandParam, databaseHandle);
			}
		
			@Override
			protected void executeCommand() {
				// execute command and set outcome
			}
		
		}
		
		/*       S.D.G.       */
	'''
	
	def generateInitialEventFile(Event it, Project project) '''
		package «project.name».events;
		
		import com.anfelisa.ace.DatabaseHandle;
		import com.anfelisa.ace.IDataContainer;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		public class «eventName» extends «abstractEventName» {
		
			static final Logger LOG = LoggerFactory.getLogger(«eventName».class);

			public «eventName»(IDataContainer eventParam, DatabaseHandle databaseHandle) {
				super(eventParam, databaseHandle);
			}
		
			@Override
			protected void prepareDataForView() {
				// prepare data for view
				this.eventData = this.eventParam;
			}
		
		}
		
		/*       S.D.G.       */
	'''
	
	def generateInitialResourceFile(Action it, Project project) '''
		package «project.name».resources;
		
		import javax.annotation.security.PermitAll;
		import javax.ws.rs.Consumes;
		import javax.ws.rs.POST;
		import javax.ws.rs.PUT;
		import javax.ws.rs.DELETE;
		import javax.ws.rs.GET;
		import javax.ws.rs.Path;
		import javax.ws.rs.Produces;
		import javax.ws.rs.core.MediaType;
		import javax.ws.rs.core.Response;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import com.anfelisa.ace.DatabaseService;
		import com.anfelisa.ace.IDataContainer;
		import com.codahale.metrics.annotation.Timed;
		import com.fasterxml.jackson.core.JsonProcessingException;
		
		import «project.name».actions.«actionName»;
		
		@Path("/path")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public class «resourceName» {
		
			static final Logger LOG = LoggerFactory.getLogger(«resourceName».class);
		
			@«type»
			@Timed
			@Path("/path")
			@PermitAll // set permission
			public Response «type.toLowerCase»(/* params here */) throws JsonProcessingException {
				IDataContainer actionParam = null;  // init actionParam
				return new «actionName»(actionParam, DatabaseService.getDatabaseHandle()).apply();
			}
		
		}
		
		/*       S.D.G.       */
	'''
	
	def generateView(View it, Project project) '''
		package «project.name».views;
		
		import java.util.function.BiConsumer;
		
		import org.skife.jdbi.v2.Handle;
		
		import com.anfelisa.ace.IDataContainer;
		
		public class «viewName» {
		
			«FOR renderFunction : renderFunctions»
			    public BiConsumer<IDataContainer, Handle> «renderFunction.name» = (dataContainer, handle) -> {
			    	// update view
			    };
			«ENDFOR»
		
		}
		
		/*                    S.D.G.                    */
	'''

	def generateAppRegistration(Project it) '''
		package «name»;
		
		import io.dropwizard.setup.Environment;
		import com.anfelisa.ace.AceController;
		
		import «name».views.*;
		import «name».resources.*;
		
		public class AppRegistration {
		
			public static void registerResources(Environment environment) {
				«FOR action : actions»
					environment.jersey().register(new «action.resourceName»());
				«ENDFOR»
			}
		
			public static void registerConsumers() {
				«FOR view : views»
					«view.viewName» «view.viewNameAsVariable» = new «view.viewName»();
				«ENDFOR»
				
				«FOR event : events»
					«FOR renderFunction : event.listeners»
						AceController.addConsumer("«event.eventName»", «renderFunction.viewFunctionWithViewNameAsVariable»);
			    	«ENDFOR»
		    	«ENDFOR»
		    }
		}
		
		/*                    S.D.G.                    */
	'''

	
}