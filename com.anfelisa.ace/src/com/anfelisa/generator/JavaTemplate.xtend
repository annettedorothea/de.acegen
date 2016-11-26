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
import com.anfelisa.ace.Model
import com.anfelisa.extensions.ModelExtension
import com.anfelisa.ace.Data
import com.anfelisa.extensions.DataExtension
import com.anfelisa.extensions.AttributeExtension

class JavaTemplate {
	
	@Inject
	extension ActionExtension

	@Inject
	extension CommandExtension

	@Inject
	extension EventExtension
	
	@Inject
	extension ViewExtension
	
	@Inject
	extension ModelExtension
	
	@Inject
	extension DataExtension
	
	@Inject
	extension AttributeExtension
	
	def generateModel(Model it, Project project) '''
		package «project.name».models;
		
		import org.joda.time.DateTime;

		@SuppressWarnings("unused")
		public interface «modelName» {
		
			«FOR attribute : attributes»
				«attribute.interfaceGetter»
			«ENDFOR»

		}
		
		/*       S.D.G.       */
	'''
	
	def generateModelClass(Model it, Project project) '''
		package «project.name».models;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		import javax.validation.constraints.NotNull;
		import org.hibernate.validator.constraints.NotEmpty;
		import org.joda.time.DateTime;

		@SuppressWarnings("unused")
		public class «modelClassName» implements «modelName» {
		
			«FOR attribute : attributes»
				«attribute.declaration»
				
			«ENDFOR»
		
			public «modelClassName»(
				«FOR attribute : attributes SEPARATOR ','»
					«attribute.param»
				«ENDFOR»
			) {
				«FOR attribute : attributes»
					«attribute.assign»
				«ENDFOR»
			}
		
			«FOR attribute : attributes»
				«attribute.getter»
				«attribute.setter»
				
			«ENDFOR»
		
		}
		
		/*       S.D.G.       */
	'''
	
	def generateData(Data it, Project project) '''
		package «project.name».data;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		import javax.validation.constraints.NotNull;
		import org.hibernate.validator.constraints.NotEmpty;
		import org.joda.time.DateTime;
		import java.util.List;
		
		import com.anfelisa.ace.IDataContainer;
		
		«FOR model : models»
			«model.model.importModel»
		«ENDFOR»
		
		@SuppressWarnings("unused")
		public class «dataName» implements «FOR model : allNonListModels SEPARATOR ', ' AFTER ','»«model.modelName»«ENDFOR» IDataContainer {
			
			private String uuid;
			
			private String schema;
			
			«FOR attribute : allAttributes»
				«attribute.declaration»
				
			«ENDFOR»
		
			«FOR model : allListModels»
				List<«model.modelName»> «model.modelListAttributeName»;
				
			«ENDFOR»
		
			«FOR data : dataLists»
				List<«data.data.dataNameWithPackage»> «data.data.dataName.toFirstLower»List;
				
			«ENDFOR»
		
			public «dataName»(
				«FOR attribute : allAttributes SEPARATOR ',' AFTER ','»
					«attribute.param»
				«ENDFOR»
				@JsonProperty("uuid") String uuid,
				@JsonProperty("schema") String schema
			) {
				«FOR attribute : allAttributes»
					«attribute.assign»
				«ENDFOR»
				this.uuid = uuid;
				this.schema = schema;
			}
		
			«FOR attribute : allAttributes»
				«attribute.getter»
				«attribute.setter»
				
			«ENDFOR»
			«FOR model : allListModels»
				«model.listGetter»
				«model.listSetter»
				
			«ENDFOR»
			«FOR data : dataLists»
				«data.data.listGetter»
				«data.data.listSetter»
				
			«ENDFOR»
			@JsonProperty
			public String getUuid() {
				return this.uuid;
			}
		
			@JsonProperty
			public String getSchema() {
				return this.schema;
			}
		
		}
		
		/*       S.D.G.       */
	'''
	
	def generateDao(Model it, Project project) '''
		package «project.name».models;
		
		import org.skife.jdbi.v2.Handle;
		import org.skife.jdbi.v2.Update;
		
		import java.util.List;
		
		public class «modelDao» {
			
			public static void create(Handle handle, String schema) {
				handle.execute("CREATE TABLE IF NOT EXISTS " + schema + ".«table» («FOR attribute : attributes SEPARATOR ', '»«attribute.tableDefinition»«ENDFOR»«FOR attribute : attributes»«attribute.primaryKey(table)»«ENDFOR»«FOR attribute : attributes»«attribute.foreignKey(table)»«ENDFOR»«FOR attribute : attributes»«attribute.uniqueConstraint(table)»«ENDFOR»)");
			}
			
			public static void insert(Handle handle, «modelName» «modelParam», String schema) {
				«IF findSerialAttribute != null»
					if («modelParam».«findSerialAttribute.getterCall» != null) {
						Update statement = handle.createStatement("INSERT INTO " + schema + ".«table» («FOR attribute : attributes SEPARATOR ', '»«attribute.name»«ENDFOR») VALUES («FOR attribute : attributes SEPARATOR ', '»:«attribute.name»«ENDFOR»)");
						«FOR attribute : attributes»
							statement.bind("«attribute.name»", «modelParam».«attribute.getterCall»);
						«ENDFOR»
						statement.execute();
					} else {
						Update statement = handle.createStatement("INSERT INTO " + schema + ".«table» («FOR attribute : allNonSerialAttributes SEPARATOR ', '»«attribute.name»«ENDFOR») VALUES («FOR attribute : allNonSerialAttributes SEPARATOR ', '»:«attribute.name»«ENDFOR»)");
						«FOR attribute : allNonSerialAttributes»
							statement.bind("«attribute.name»", «modelParam».«attribute.getterCall»);
						«ENDFOR»
						statement.execute();
					}
				«ELSE»
					Update statement = handle.createStatement("INSERT INTO " + schema + ".«table» («FOR attribute : allNonSerialAttributes SEPARATOR ', '»«attribute.name»«ENDFOR») VALUES («FOR attribute : allNonSerialAttributes SEPARATOR ', '»:«attribute.name»«ENDFOR»)");
					«FOR attribute : allNonSerialAttributes»
						statement.bind("«attribute.name»", «modelParam».«attribute.getterCall»);
					«ENDFOR»
					statement.execute();
				«ENDIF»
			}
			
			public static void update(Handle handle, «modelName» «modelParam», String schema) {
				Update statement = handle.createStatement("UPDATE " + schema + ".«table» SET «FOR attribute : attributes SEPARATOR ', '»«attribute.name» = :«attribute.name»«ENDFOR»");
				«FOR attribute : attributes»
					statement.bind("«attribute.name»", «modelParam».«attribute.getterCall»);
				«ENDFOR»
				statement.execute();
			}
			
			«FOR attribute : allUniqueAttributes»
				public static void deleteBy«attribute.name.toFirstUpper»(Handle handle, «attribute.javaType» «attribute.name», String schema) {
					Update statement = handle.createStatement("DELETE FROM " + schema + ".«table» WHERE «attribute.name» = :«attribute.name»");
					statement.bind("«attribute.name»", «attribute.name»);
					statement.execute();
				}

				public static «modelName» selectBy«attribute.name.toFirstUpper»(Handle handle, «attribute.javaType» «attribute.name», String schema) {
					return handle.createQuery("SELECT * FROM " + schema + ".«table» WHERE «attribute.name» = :«attribute.name»")
						.bind("«attribute.name»", «attribute.name»)
						.map(new «modelMapper»())
						.first();
				}
			«ENDFOR»
			
			public static List<«modelName»> selectAll(Handle handle, String schema) {
				return handle.createQuery("SELECT * FROM " + schema + ".«table»")
					.map(new «modelMapper»())
					.list();
			}
		}
		
		/*       S.D.G.       */
	'''
	
	def generateMapper(Model it, Project project) '''
		package «project.name».models;
		
		import java.sql.ResultSet;
		import java.sql.SQLException;
		import org.joda.time.DateTime;
		
		import org.skife.jdbi.v2.StatementContext;
		import org.skife.jdbi.v2.tweak.ResultSetMapper;
		
		public class «modelMapper» implements ResultSetMapper<«modelName»> {
			
			public «modelName» map(int index, ResultSet r, StatementContext ctx) throws SQLException {
				return new «modelClassName»(
					«FOR attribute : attributes SEPARATOR ','»
						«attribute.mapperInit»
					«ENDFOR»
				);
			}
		}
		
		/*       S.D.G.       */
	'''
	
	def generateAbstractActionFile(Action it, Project project) '''
		package «project.name».actions;
		
		import com.anfelisa.ace.Action;
		import com.anfelisa.ace.DatabaseHandle;
		import com.anfelisa.ace.HttpMethod;
		import com.anfelisa.ace.ICommand;
		«data.dataImport»
		
		«IF command != null»
			import «project.name».commands.«command.commandName»;
		«ENDIF»
		
		public abstract class «abstractActionName» extends Action<«data.dataParamType»> {
		
			public «abstractActionName»(«data.dataParamType» actionParam, DatabaseHandle databaseHandle) {
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

		«data.dataImport»

		public abstract class «abstractCommandName» extends Command<«data.dataParamType»> {
		
			«FOR eventOnOutcome : eventsOnOutcome»
				protected static final String «eventOnOutcome.outcome» = "«eventOnOutcome.outcome»";
			«ENDFOR»
		
			public «abstractCommandName»(«data.dataParamType» commandParam, DatabaseHandle databaseHandle) {
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
							«action.newAction»
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
		
		«data.dataImport»
		
		public abstract class «abstractEventName» extends Event<«data.dataParamType»> {
		
			public «abstractEventName»(«data.dataParamType» eventParam, DatabaseHandle databaseHandle) {
				super("«eventName»", eventParam, databaseHandle);
			}
		
		}
		
		/*       S.D.G.       */
	'''

	def generateInitialActionFile(Action it, Project project) '''
		package «project.name».actions;
		
		import com.anfelisa.ace.DatabaseHandle;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		«data.dataImport»
		
		public class «actionName» extends «abstractActionName» {
		
			static final Logger LOG = LoggerFactory.getLogger(«actionName».class);

			public «actionName»(«data.dataParamType» actionParam, DatabaseHandle databaseHandle) {
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
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		«data.dataImport»
		
		public class «commandName» extends «abstractCommandName» {
		
			static final Logger LOG = LoggerFactory.getLogger(«commandName».class);

			public «commandName»(«data.dataParamType» commandParam, DatabaseHandle databaseHandle) {
				super(commandParam, databaseHandle);
			}
		
			@Override
			protected void executeCommand() {
				// execute command and set outcome
				this.commandData = this.commandParam;
				«IF eventsOnOutcome.size > 0»
					this.outcome = «eventsOnOutcome.get(0).outcome»;
				«ENDIF»
			}
		
		}
		
		/*       S.D.G.       */
	'''
	
	def generateInitialEventFile(Event it, Project project) '''
		package «project.name».events;
		
		import com.anfelisa.ace.DatabaseHandle;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		«data.dataImport»
		
		public class «eventName» extends «abstractEventName» {
		
			static final Logger LOG = LoggerFactory.getLogger(«eventName».class);

			public «eventName»(«data.dataParamType» eventParam, DatabaseHandle databaseHandle) {
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
		import org.skife.jdbi.v2.DBI;
		
		import com.anfelisa.ace.Resource;
		import com.codahale.metrics.annotation.Timed;
		import com.fasterxml.jackson.core.JsonProcessingException;
		
		import «project.name».actions.«actionName»;
		
		«data.dataImport»
		
		@Path("/«resourceName.toLowerCase»")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public class «resourceName» extends Resource {
		
			static final Logger LOG = LoggerFactory.getLogger(«resourceName».class);
		
			public «resourceName»( DBI jdbi ) {
				super(jdbi);
			}
		
			«IF type != null»@«type»«ENDIF»
			@Timed
			@Path("/«IF type != null»«type.toLowerCase»«ELSE»«resourceName.toLowerCase»«ENDIF»")
			@PermitAll // set permission
			public Response «IF type != null»«type.toLowerCase»«ELSE»«resourceName.toFirstLower»«ENDIF»(/* params here */) throws JsonProcessingException {
				DatabaseHandle handle = this.createDatabaseHandle();
				«data.dataParamType» actionParam = null;  // init actionParam
				return new «actionName»(actionParam, handle).apply();
			}
		
		}
		
		/*       S.D.G.       */
	'''
	
	def generateView(View it, Project project) '''
		package «project.name».views;
		
		import java.util.function.BiConsumer;
		
		import org.skife.jdbi.v2.Handle;
		
		import com.anfelisa.ace.IDataContainer;
		«FOR renderFunction : renderFunctions»
			«renderFunction.data.dataImport»
		«ENDFOR»
		
		public class «viewName» {
		
			«FOR renderFunction : renderFunctions»
			    public BiConsumer<«renderFunction.data.dataName», Handle> «renderFunction.name» = (dataContainer, handle) -> {
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
		
		import org.skife.jdbi.v2.DBI;
		
		«IF views.size > 0»
			import «name».views.*;
		«ENDIF»
		«IF actions.size > 0»
			import «name».resources.*;
		«ENDIF»

		public class AppRegistration {
		
			public static void registerResources(Environment environment, DBI jdbi) {
				«FOR action : actions»
					environment.jersey().register(new «action.resourceName»(jdbi));
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