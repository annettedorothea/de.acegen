package com.anfelisa.generator

import com.anfelisa.ace.Action
import com.anfelisa.ace.Command
import com.anfelisa.ace.Data
import com.anfelisa.ace.Event
import com.anfelisa.ace.Model
import com.anfelisa.ace.Project
import com.anfelisa.ace.View
import com.anfelisa.extensions.ActionExtension
import com.anfelisa.extensions.AttributeExtension
import com.anfelisa.extensions.CommandExtension
import com.anfelisa.extensions.ComplexAttributeExtension
import com.anfelisa.extensions.DataExtension
import com.anfelisa.extensions.EventExtension
import com.anfelisa.extensions.ModelExtension
import com.anfelisa.extensions.ViewExtension
import javax.inject.Inject
import com.anfelisa.extensions.ProjectExtension

class JavaTemplate {
	
	@Inject
	extension ProjectExtension

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
	
	@Inject
	extension ComplexAttributeExtension
	
	def generateModel(Model it, Project project) '''
		package «project.name».models;
		
		import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
		
		@JsonDeserialize(as=«modelClassName».class)
		public interface «modelName» {
		
			«FOR attribute : attributes»
				«attribute.interfaceGetter»
			«ENDFOR»

			«FOR complexAttribute : models»
				«complexAttribute.interfaceGetter»
			«ENDFOR»

		}
		
		/*       S.D.G.       */
	'''
	
	def generateModelResource(Model it) '''
		<form class="form-horizontal">

		    <div class="form-group">
		        <label class="col-sm-3 control-label"></label>
		        <div class="col-sm-9">
		            <h4>{{texts.«name.toFirstLower»}}</h4>
		        </div>
		    </div>

			«FOR attribute : attributes»
			    <div class="form-group" id="«name.toFirstLower»«attribute.name.toFirstUpper»Div">
			        <label for="«name.toFirstLower»«attribute.name.toFirstUpper»" class="col-sm-3 control-label">«IF attribute.constraint !== null»* «ENDIF»{{texts.«name.toLowerCase».«attribute.name»}}</label>
			        <div class="col-sm-9">
			            <input type="text" class="form-control" id="«name.toFirstLower»«attribute.name.toFirstUpper»" placeholder="{{texts.«name.toLowerCase».«attribute.name»}}" value="{{«name.toFirstLower».«attribute.name»}}"«IF attribute.constraint !== null» onblur="new ValidateRequiredFieldAction({id : '«name.toFirstLower»«attribute.name.toFirstUpper»'}).apply()"«ENDIF»>
			            «IF attribute.constraint !== null»<span class="help-block notEmpty" style="display: none">{{texts.«name.toLowerCase».«attribute.name»NotEmpty}}</span>«ENDIF»
			        </div>
			    </div>
			    
			«ENDFOR»
			«FOR modelRef : models»
				«IF modelRef.list»
					{{#«modelRef.name»}}
					<div class="panel panel-default">
					    <div class="panel-heading">
							«FOR attribute : modelRef.model.attributes»
								<h4 class="panel-title">{{texts.«attribute.name»}}: {{«attribute.name»}}</h4>
							«ENDFOR»
					    </div>
					    <div class="panel-body">
							«FOR attribute : modelRef.model.attributes»
								{{texts.«attribute.name»}}: {{«attribute.name»}}<br>
							«ENDFOR»
					    </div>
					</div>
					{{/«modelRef.name»}}
					{{^«modelRef.name»}}
					<div class="panel panel-default">
					    <div class="panel-heading">
					        <h3 class="panel-title">{{texts.empty«modelRef.name.toFirstUpper»}}</h3>
					    </div>
					</div>
					{{/«modelRef.name»}}
					
					<div class="table-responsive">
					    <table class="table table-bordered table-hover table-responsive">
					        <tr>
								«FOR attribute : modelRef.model.attributes»
									<th>{{texts.«attribute.name»}}</th>
								«ENDFOR»
					        </tr>
					        {{#«modelRef.name»}}
					        <tr>
								«FOR attribute : modelRef.model.attributes»
									<td>{{«attribute.name»}}</td>
								«ENDFOR»
					        </tr>
					        {{/«modelRef.name»}}
					        {{^«modelRef.name»}}
					        <tr>
					            <td colspan="«modelRef.model.attributes.size»">{{texts.empty«modelRef.name.toFirstUpper»}}</td>
					        </tr>
					        {{/«modelRef.name»}}
					    </table>
					</div>
					
				«ENDIF»
				
			«ENDFOR»
			
		</form>
	'''
	
	def generateModelClass(Model it, Project project) '''
		package «project.name».models;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		import javax.validation.constraints.NotNull;
		import org.hibernate.validator.constraints.NotEmpty;

		@SuppressWarnings("all")
		public class «modelClassName» implements «modelName» {
		
			«FOR attribute : attributes»
				«attribute.declaration»
				
			«ENDFOR»
		
			«FOR modelRef : models»
				«modelRef.declaration»
				
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
		
			«FOR modelRef : models»
				«modelRef.getter»
				«modelRef.setter»
				
			«ENDFOR»
				
		}
		
		/*       S.D.G.       */
	'''
	
	def generateDataInterface(Data it, Project project) '''
		package «project.name».data;
		
		import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
		
		import com.anfelisa.ace.IDataContainer;
		
		«FOR model : models»
			«model.model.importModel»
		«ENDFOR»
		
		@JsonDeserialize(as=«dataName».class)
		public interface «dataInterfaceName» extends «FOR modelRef : models SEPARATOR ', ' AFTER ','»«modelRef.model.modelName»«ENDFOR» IDataContainer {
		
		}
		
		/*       S.D.G.       */
	'''
	
	def generateData(Data it, Project project) '''
		package «project.name».data;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		import com.fasterxml.jackson.annotation.JsonIgnore;
		
		import javax.validation.constraints.NotNull;
		import org.hibernate.validator.constraints.NotEmpty;
		import org.joda.time.DateTime;
		import java.util.List;
		
		import com.anfelisa.ace.IDataContainer;
		
		«FOR model : models»
			«model.model.importModel»
		«ENDFOR»
		
		@SuppressWarnings("all")
		public class «dataName» implements «dataInterfaceName» {
			
			private String uuid;
			
			private String outcome;
			
			private String createdId;
			
			«FOR attribute : allAttributes»
				«attribute.declaration»
				
			«ENDFOR»
		
			«FOR modelRef : models»
				«FOR modelModelRef : modelRef.model.models»
					«modelModelRef.declaration»
				«ENDFOR»
				
			«ENDFOR»
			private org.joda.time.DateTime systemTime;
			
			public «dataName»(
				«FOR attribute : allAttributes SEPARATOR ',' AFTER ','»
					«attribute.param»
				«ENDFOR»
				@JsonProperty("uuid") String uuid
			) {
				«FOR attribute : allAttributes»
					«attribute.assign»
				«ENDFOR»
				this.uuid = uuid;
			}
		
			«IF allAttributes.length > 0»
				public «dataName»( String uuid ) {
					this.uuid = uuid;
				}
			«ENDIF»
		
			«FOR attribute : allAttributes»
				«attribute.getter»
				«attribute.setter»
				«attribute.initializer(dataName)»
				
			«ENDFOR»
			«FOR modelRef : models»
				«FOR modelModelRef : modelRef.model.models»
					«modelModelRef.getter»
					«modelModelRef.setter»
				«ENDFOR»
				
			«ENDFOR»
		
			@JsonProperty
			public String getUuid() {
				return this.uuid;
			}
		
			@JsonIgnore
			public String getCreatedId() {
				return createdId;
			}
		
			public void setCreatedId(String createdId) {
				this.createdId = createdId;
			}
		
			@JsonProperty
			public org.joda.time.DateTime getSystemTime() {
				return systemTime;
			}
		
			@JsonProperty
			public void setSystemTime(org.joda.time.DateTime systemTime) {
				this.systemTime = systemTime;
			}
		
			@JsonProperty
			public String getOutcome() {
				return outcome;
			}
		
			@JsonProperty
			public void setOutcome(String outcome) {
				this.outcome = outcome;
			}
		
		}
		
		/*       S.D.G.       */
	'''
	
	def generateDao(Model it, Project project) '''
		package «project.name».models;
		
		import org.skife.jdbi.v2.Handle;
		import org.skife.jdbi.v2.Query;
		import org.skife.jdbi.v2.Update;
		
		import java.util.List;
		import java.util.Map;
		
		import com.fasterxml.jackson.annotation.JsonIgnoreType;

		import com.anfelisa.ace.encryption.EncryptionService;

		@SuppressWarnings("all")
		@JsonIgnoreType
		public class «modelDao» {
			
			public «IF findPrimaryKeyAttribute !== null»«findPrimaryKeyAttribute.javaType»«ELSE»void«ENDIF» insert(Handle handle, «modelName» «modelParam») {
				«IF findPrimaryKeyAttribute !== null»
					Query<Map<String, Object>> statement = handle.createQuery("INSERT INTO «project.schema».«table» («FOR attribute : allNonSerialAttributes SEPARATOR ', '»«attribute.name.toLowerCase»«ENDFOR») VALUES («FOR attribute : allNonSerialAttributes SEPARATOR ', '»«modelAttributeSqlValue(project, attribute)»«ENDFOR») RETURNING «findPrimaryKeyAttribute.name.toLowerCase»");
					«FOR attribute : allNonSerialAttributes»
						statement.bind("«attribute.name.toLowerCase»", «modelGetAttribute(attribute)»);
					«ENDFOR»
					Map<String, Object> first = statement.first();
					return («findPrimaryKeyAttribute.javaType») first.get("«findPrimaryKeyAttribute.name.toLowerCase»");
				«ELSE»
					Update statement = handle.createStatement("INSERT INTO «project.schema».«table» («FOR attribute : allNonSerialAttributes SEPARATOR ', '»«attribute.name.toLowerCase»«ENDFOR») VALUES («FOR attribute : allNonSerialAttributes SEPARATOR ', '»«modelAttributeSqlValue(project, attribute)»«ENDFOR»)");
					«FOR attribute : allNonSerialAttributes»
						statement.bind("«attribute.name.toLowerCase»", «modelGetAttribute(attribute)»);
					«ENDFOR»
					statement.execute();
				«ENDIF»
			}
			
			
			«FOR attribute : allUniqueAttributes»
				public void updateBy«attribute.name.toFirstUpper»(Handle handle, «modelName» «modelParam») {
					Update statement = handle.createStatement("UPDATE «project.schema».«table» SET «FOR attr : allNonSerialAttributes SEPARATOR ', '»«attr.name.toLowerCase» = :«attr.name.toLowerCase»«ENDFOR» WHERE «attribute.name.toLowerCase» = :«attribute.name.toLowerCase»");
					«FOR attr : allNonSerialAttributes»
						statement.bind("«attr.name.toLowerCase»", «modelGetAttribute(attr)»);
					«ENDFOR»
					statement.bind("«attribute.name.toLowerCase»", «modelGetAttribute(attribute)» );
					statement.execute();
				}

				public void deleteBy«attribute.name.toFirstUpper»(Handle handle, «attribute.javaType» «attribute.name») {
					Update statement = handle.createStatement("DELETE FROM «project.schema».«table» WHERE «attribute.name.toLowerCase» = :«attribute.name.toLowerCase»");
					statement.bind("«attribute.name.toLowerCase»", «attribute.name»);
					statement.execute();
				}

				public «modelName» selectBy«attribute.name.toFirstUpper»(Handle handle, «attribute.javaType» «attribute.name») {
					return handle.createQuery("SELECT «FOR attr : attributes SEPARATOR ', '»«attr.name.toLowerCase»«ENDFOR» FROM «project.schema».«table» WHERE «attribute.name.toLowerCase» = :«attribute.name.toLowerCase»")
						.bind("«attribute.name.toLowerCase»", «attribute.name»)
						.map(new «modelMapper»())
						.first();
				}
			«ENDFOR»
			
			public List<«modelName»> selectAll(Handle handle) {
				return handle.createQuery("SELECT «FOR attr : attributes SEPARATOR ', '»«attr.name.toLowerCase»«ENDFOR» FROM «project.schema».«table»")
					.map(new «modelMapper»())
					.list();
			}

			public void truncate(Handle handle) {
				Update statement = handle.createStatement("TRUNCATE «project.schema».«table» CASCADE");
				statement.execute();
				«IF findSerialAttribute !== null»
					statement = handle.createStatement("ALTER SEQUENCE «project.schema».«table»_«findSerialAttribute.name»_seq RESTART");
					statement.execute();
				«ENDIF»
			}

		}
		
		/*       S.D.G.       */
	'''
	
	def generateMigration(Model it, Project project) '''
		<createTable tableName="«table»">
			«FOR attribute : attributes»
				<column name="«attribute.name.toLowerCase»" type="«attribute.sqlType»">
					<constraints «IF attribute.isPrimaryKey»primaryKey="true"«ENDIF» «IF attribute.constraint !== null && attribute.constraint.equals('NotNull')»nullable="false"«ENDIF» «IF attribute.foreignKey !== null»	references="«attribute.foreignKey.tableName»(«attribute.foreignKey.name.toLowerCase»)" deleteCascade="true" foreignKeyName="fk_«attribute.tableName»_«attribute.foreignKey.tableName»"«ENDIF» />
				</column>
			«ENDFOR»
		</createTable>
	'''
	
	def generateMapper(Model it, Project project) '''
		package «project.name».models;
		
		import java.sql.ResultSet;
		import java.sql.SQLException;
		
		import org.skife.jdbi.v2.StatementContext;
		import org.skife.jdbi.v2.tweak.ResultSetMapper;
		
		import com.anfelisa.ace.encryption.EncryptionService;
		
		@SuppressWarnings("all")
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
		
		import org.skife.jdbi.v2.DBI;
		import javax.ws.rs.WebApplicationException;

		import com.anfelisa.ace.Action;
		import com.anfelisa.ace.HttpMethod;
		import com.anfelisa.ace.ICommand;
		«data.dataImport»
		
		«IF command !== null»
			import «project.name».commands.«command.commandName»;
		«ENDIF»
		
		public abstract class «abstractActionName» extends Action<«data.dataParamType»> {
		
			public «abstractActionName»(DBI jdbi, DBI jdbiTimeline) {
				super("«project.name».actions.«actionName»", HttpMethod.«type», jdbi, jdbiTimeline);
			}
		
			@Override
			public ICommand getCommand() {
				«IF command !== null»
					return new «command.commandName»(this.actionData, databaseHandle);
				«ELSE»
					return null;
				«ENDIF»
			}
		
			«IF !type.equals("GET")»
				protected final void loadDataForGetRequest() {
				}
			«ENDIF»
		
			public void initActionData(String json) {
				try {
					this.actionData = mapper.readValue(json, «data.dataParamType».class);
				} catch (Exception e) {
					throw new WebApplicationException(e);
				}
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
				super("«project.name».commands.«commandName»", commandParam, databaseHandle);
			}
		
			public «abstractCommandName»(DatabaseHandle databaseHandle) {
				super("«project.name».commands.«commandName»", null, databaseHandle);
			}
		
			@Override
			public void publishEvents() {
				switch (this.commandData.getOutcome()) {
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
					throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
				}
			}
			
			public void initCommandData(String json) {
				try {
					this.commandData = mapper.readValue(json, «data.dataParamType».class);
				} catch (Exception e) {
					throw new WebApplicationException(e);
				}
			}
		
		}
		
		/*       S.D.G.       */
	'''

	def generateAbstractEventFile(Event it, Project project) '''
		package «project.name».events;
		
		import javax.ws.rs.WebApplicationException;

		import com.anfelisa.ace.DatabaseHandle;
		import com.anfelisa.ace.Event;
		
		«data.dataImport»
		
		public abstract class «abstractEventName» extends Event<«data.dataParamType»> {
		
			public «abstractEventName»(«data.dataParamType» eventParam, DatabaseHandle databaseHandle) {
				super("«project.name».events.«eventName»", eventParam, databaseHandle);
			}
			
			public «abstractEventName»(DatabaseHandle databaseHandle) {
				super("«project.name».events.«eventName»", null, databaseHandle);
			}
			
			public void initEventData(String json) {
				try {
					this.eventData = mapper.readValue(json, «data.dataParamType».class);
				} catch (Exception e) {
					throw new WebApplicationException(e);
				}
			}
			
		
		}
		
		/*       S.D.G.       */
	'''

	def generateInitialActionFile(Action it, Project project) '''
		package «project.name».actions;
		
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
		
		import com.anfelisa.ace.DatabaseHandle;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;

		import com.codahale.metrics.annotation.Timed;
		import com.fasterxml.jackson.core.JsonProcessingException;
		import org.skife.jdbi.v2.DBI;
		
		«data.dataImport»
		
		@Path("/«data.name»")
		«IF type !== null && type == "GET"»@Produces(MediaType.APPLICATION_JSON)«ELSE»@Produces(MediaType.TEXT_PLAIN)«ENDIF»
		@Consumes(MediaType.APPLICATION_JSON)
			public class «actionName» extends «abstractActionName» {
		
			static final Logger LOG = LoggerFactory.getLogger(«actionName».class);

			public «actionName»(DBI jdbi, DBI jdbiTimeline) {
				super(jdbi, jdbiTimeline);
			}
		
			«IF type !== null»@«type»«ENDIF»
			@Timed
			@Path("/«IF type !== null»«type.toLowerCase»«ELSE»«resourceName.toLowerCase»«ENDIF»")
			@PermitAll
			public Response «IF type !== null»«type.toLowerCase»«ELSE»«resourceName.toFirstLower»«ENDIF»() throws JsonProcessingException {
				this.actionData = null;
				return this.apply();
			}
		
			«IF type.equals("GET")»
				protected final void loadDataForGetRequest() {
				}
			«ENDIF»
		
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
		
			public «commandName»(DatabaseHandle databaseHandle) {
				super(null, databaseHandle);
			}
		
			@Override
			protected void executeCommand() {
				«IF eventsOnOutcome.size > 0»
					this.commandData.setOutcome(«eventsOnOutcome.get(0).outcome»);
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
		
			public «eventName»(DatabaseHandle databaseHandle) {
				this(null, databaseHandle);
			}
		
			@Override
			protected void prepareDataForView() {
				this.eventData = this.eventParam;
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
		
		@SuppressWarnings("all")
		public class «viewName» {
		
			«FOR renderFunction : renderFunctions»
			    public static BiConsumer<«renderFunction.data.dataName», Handle> «renderFunction.name» = (dataContainer, handle) -> {
			    };
			«ENDFOR»
		
		}
		
		/*                    S.D.G.                    */
	'''

	def generateAppRegistration(Project it) '''
		package «name»;
		
		import io.dropwizard.setup.Environment;
		import com.anfelisa.ace.AceController;
		import com.anfelisa.ace.AceExecutionMode;
		
		import org.skife.jdbi.v2.DBI;
		
		«FOR view : it.referencedViews()»
			import «view.viewNameWithPackage»;
	    	«ENDFOR»
		«IF actions.size > 0»
			import «name».actions.*;
		«ENDIF»

		@SuppressWarnings("all")
		public class AppRegistration {
		
			public static void registerResources(Environment environment, DBI jdbi, DBI jdbiTimeline) {
				«FOR action : actions»
					environment.jersey().register(new «action.actionName»(jdbi, jdbiTimeline));
				«ENDFOR»
			}
		
			public static void registerConsumers() {
				«FOR event : events»
					«FOR renderFunction : event.listeners»
						«IF (renderFunction.eContainer as View).isExternal»if (AceController.getAceExecutionMode() == AceExecutionMode.LIVE) {«ENDIF»
							AceController.addConsumer("«name».events.«event.eventName»", «renderFunction.viewFunctionWithViewName»);
						«IF (renderFunction.eContainer as View).isExternal»}«ENDIF»
					«ENDFOR»
				«ENDFOR»
		    }
		}
		
		/*                    S.D.G.                    */
	'''
	
	def generateApp() '''
		package com.anfelisa.ace;
		
		import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
		import org.skife.jdbi.v2.DBI;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import com.anfelisa.ace.bug.CreateBugResource;
		import com.anfelisa.ace.bug.DeleteBugResource;
		import com.anfelisa.ace.bug.GetAllBugsResource;
		import com.anfelisa.ace.bug.ResolveBugResource;
		import com.anfelisa.ace.scenario.CreateScenarioResource;
		import com.anfelisa.ace.scenario.DeleteScenarioResource;
		import com.anfelisa.ace.scenario.GetAllScenariosResource;
		
		import com.anfelisa.ace.AceController;
		import com.anfelisa.ace.AceDao;
		import com.anfelisa.ace.AceExecutionMode;
		
		import io.dropwizard.Application;
		import io.dropwizard.db.DataSourceFactory;
		import io.dropwizard.jdbi.DBIFactory;
		import io.dropwizard.jdbi.bundles.DBIExceptionsBundle;
		import io.dropwizard.migrations.MigrationsBundle;
		import io.dropwizard.setup.Bootstrap;
		import io.dropwizard.setup.Environment;
		
		public class App extends Application<AppConfiguration> {
		
			static final Logger LOG = LoggerFactory.getLogger(App.class);
		
			public static void main(String[] args) throws Exception {
				new App().run(args);
			}
		
			@Override
			public String getName() {
				return "app name";
			}
		
			public String getVersion() {
				return "app version";
			}
		
			@Override
			public void initialize(Bootstrap<AppConfiguration> bootstrap) {
				bootstrap.addBundle(new MigrationsBundle<AppConfiguration>() {
					@Override
					public DataSourceFactory getDataSourceFactory(AppConfiguration configuration) {
						return configuration.getDataSourceFactory();
					}
				});
			}
		
			@Override
			public void run(AppConfiguration configuration, Environment environment) throws ClassNotFoundException {
				LOG.info("running version {}", getVersion());
		
				AceDao.setSchemaName(null);
		
				final DBIFactory factory = new DBIFactory();
		
				DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "data-source-name");
				DBI jdbiTimeline = null;
		
				if (configuration.getTimelineDataSourceFactory().getUrl() != null) {
					AceController.setAceExecutionMode(AceExecutionMode.REPLAY);
					jdbiTimeline = factory.build(environment, configuration.getTimelineDataSourceFactory(),
							"replay-data-source-name");
					environment.jersey().register(new ClearDatabaseResource(jdbi));
					environment.jersey().register(new PrepareDatabaseResource(jdbi, jdbiTimeline));
				} else {
					AceController.setAceExecutionMode(AceExecutionMode.LIVE);
					environment.jersey().register(new MigrateDatabaseResource(jdbi));
				}
		
				DBIExceptionsBundle dbiExceptionsBundle = new DBIExceptionsBundle();
				environment.jersey().register(dbiExceptionsBundle);
		
				environment.jersey().register(RolesAllowedDynamicFeature.class);
		
				// register resources
				// register consumers
		
			}
		
		}
	'''
	
	def generateAppConfiguration() '''
		package com.anfelisa.ace;
		
		import javax.validation.Valid;
		import javax.validation.constraints.NotNull;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		
		import io.dropwizard.Configuration;
		import io.dropwizard.db.DataSourceFactory;
		
		public class AppConfiguration extends Configuration {
		
			@Valid
			@NotNull
			private DataSourceFactory database = new DataSourceFactory();
		
			private DataSourceFactory timelineDatabase = new DataSourceFactory();
			
			@JsonProperty("database")
			public DataSourceFactory getDataSourceFactory() {
				return database;
			}
		
			@JsonProperty("database")
			public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {
				this.database = dataSourceFactory;
			}
		
			@JsonProperty("timelineDatabase")
			public DataSourceFactory getTimelineDataSourceFactory() {
				return timelineDatabase;
			}
			
			@JsonProperty("timelineDatabase")
			public void setTimelineDataSourceFactory(DataSourceFactory dataSourceFactory) {
				this.timelineDatabase = dataSourceFactory;
			}
			
		}
	'''
	
	def generateClearDatabaseResource() '''
		package com.anfelisa.ace;
		
		import javax.ws.rs.Consumes;
		import javax.ws.rs.DELETE;
		import javax.ws.rs.Path;
		import javax.ws.rs.Produces;
		import javax.ws.rs.WebApplicationException;
		import javax.ws.rs.core.MediaType;
		import javax.ws.rs.core.Response;
		
		import org.skife.jdbi.v2.DBI;
		import org.skife.jdbi.v2.Handle;
		
		import com.anfelisa.ace.AceDao;

		import com.codahale.metrics.annotation.Timed;
		
		@Path("/database")
		@Produces(MediaType.TEXT_PLAIN)
		@Consumes(MediaType.APPLICATION_JSON)
		public class ClearDatabaseResource {
		
			private DBI jdbi;
		
			private AceDao aceDao = new AceDao();
		
			public ClearDatabaseResource(DBI jdbi) {
				super();
				this.jdbi = jdbi;
			}
		
			@DELETE
			@Timed
			@Path("/reset")
			public Response put() {
				Handle handle = jdbi.open();
				try {
					handle.getConnection().setAutoCommit(false);
					
					aceDao.truncateErrorTimelineTable(handle);
					aceDao.truncateTimelineTable(handle);

					//truncate all tables

					handle.commit();

					return Response.ok().build();
				} catch (Exception e) {
					handle.rollback();
					throw new WebApplicationException(e);
				} finally {
					handle.close();
				}
			}
		
		}
	'''
	
	def generateMigrateDatabaseResource() '''
		package com.anfelisa.ace;
		
		import java.lang.reflect.Constructor;
		
		import javax.ws.rs.Consumes;
		import javax.ws.rs.PUT;
		import javax.ws.rs.Path;
		import javax.ws.rs.Produces;
		import javax.ws.rs.QueryParam;
		import javax.ws.rs.WebApplicationException;
		import javax.ws.rs.core.MediaType;
		import javax.ws.rs.core.Response;
		
		import org.skife.jdbi.v2.DBI;
		import org.skife.jdbi.v2.Handle;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import com.codahale.metrics.annotation.Timed;
		
		@Path("/database")
		@Produces(MediaType.TEXT_PLAIN)
		@Consumes(MediaType.APPLICATION_JSON)
		public class MigrateDatabaseResource {
		
			private DBI jdbi;
		
			static final Logger LOG = LoggerFactory.getLogger(MigrateDatabaseResource.class);
		
			private AceDao aceDao = new AceDao();
		
			private TodoDao todoDao = new TodoDao();
			private TodoHistoryDao todoHistoryDao = new TodoHistoryDao();
		
			public MigrateDatabaseResource(DBI jdbi) {
				super();
				this.jdbi = jdbi;
			}
		
			@PUT
			@Timed
			@Path("/migrate")
			// We should protect this resource!
			public Response put(@QueryParam("uuid") String uuid) {
				AceController.setAceExecutionMode(AceExecutionMode.MIGRATE);
		
				DatabaseHandle databaseHandle = new DatabaseHandle(jdbi.open(), null);
				LOG.info("START MIGRATION");
				try {
					databaseHandle.beginTransaction();
		
					Handle handle = databaseHandle.getHandle();
					
					// truncate all view-tables
		
					ITimelineItem nextAction = aceDao.selectNextAction(handle, null);
					while (nextAction != null && !nextAction.getUuid().equals(uuid)) {
						if (!nextAction.getMethod().equalsIgnoreCase("GET")) {
							ITimelineItem nextEvent = aceDao.selectEvent(handle, nextAction.getUuid());
							LOG.info("PUBLISH EVENT " + nextEvent);
							Class<?> cl = Class.forName(nextEvent.getName());
							Constructor<?> con = cl.getConstructor(DatabaseHandle.class);
							IEvent event = (IEvent) con.newInstance(databaseHandle);
							event.initEventData(nextEvent.getData());
							event.notifyListeners();
							AceController.addPreparingEventToTimeline(event, nextAction.getUuid());
						}
						nextAction = aceDao.selectNextAction(handle, nextAction.getUuid());
					}
		
					databaseHandle.commitTransaction();
		
					LOG.info("MIGRATION FINISHED");
					return Response.ok().build();
				} catch (Exception e) {
					databaseHandle.rollbackTransaction();
					LOG.info("MIGRATION ABORTED " + e.getMessage());
					throw new WebApplicationException(e);
				} finally {
					databaseHandle.close();
					AceController.setAceExecutionMode(AceExecutionMode.LIVE);
				}
			}
		
		}
		
	'''
	
	def generatePrepareDatabaseResource() '''
		package com.anfelisa.ace;
		
		import java.lang.reflect.Constructor;
		
		import javax.validation.constraints.NotNull;
		import javax.ws.rs.Consumes;
		import javax.ws.rs.PUT;
		import javax.ws.rs.Path;
		import javax.ws.rs.Produces;
		import javax.ws.rs.QueryParam;
		import javax.ws.rs.WebApplicationException;
		import javax.ws.rs.core.MediaType;
		import javax.ws.rs.core.Response;
		
		import org.skife.jdbi.v2.DBI;
		import org.skife.jdbi.v2.Handle;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import com.anfelisa.ace.AceController;
		import com.anfelisa.ace.AceDao;
		import com.anfelisa.ace.DatabaseHandle;
		import com.anfelisa.ace.IEvent;
		import com.anfelisa.ace.ITimelineItem;
		import com.codahale.metrics.annotation.Timed;
		
		@Path("/database")
		@Produces(MediaType.TEXT_PLAIN)
		@Consumes(MediaType.APPLICATION_JSON)
		public class PrepareDatabaseResource {
		
			private DBI jdbi;
			private DBI jdbiTimeline;
		
			static final Logger LOG = LoggerFactory.getLogger(PrepareDatabaseResource.class);
			
			private AceDao aceDao = new AceDao();
		
			public PrepareDatabaseResource(DBI jdbi, DBI jdbiTimeline) {
				super();
				this.jdbi = jdbi;
				this.jdbiTimeline = jdbiTimeline;
			}
		
			@PUT
			@Timed
			@Path("/prepare")
			public Response put(@NotNull @QueryParam("uuid") String uuid) {
				Handle timelineHandle = jdbiTimeline.open();
				ITimelineItem actionToBePrepared = aceDao.selectTimelineItem(timelineHandle, uuid);
				
				DatabaseHandle databaseHandle = new DatabaseHandle(jdbi.open(), null);
				LOG.info("PREPARE ACTION " + actionToBePrepared);
				try {
					databaseHandle.beginTransaction();
		
					ITimelineItem lastAction = aceDao.selectLastAction(databaseHandle.getHandle());
		
					ITimelineItem nextAction = aceDao.selectNextAction(timelineHandle,
							lastAction != null ? lastAction.getUuid() : null);
					while (nextAction != null && !nextAction.getUuid().equals(uuid)) {
						if (!nextAction.getMethod().equalsIgnoreCase("GET")) {
							ITimelineItem nextEvent = aceDao.selectEvent(timelineHandle, nextAction.getUuid());
							LOG.info("PUBLISH EVENT " + nextEvent);
							Class<?> cl = Class.forName(nextEvent.getName());
							Constructor<?> con = cl.getConstructor(DatabaseHandle.class);
							IEvent event = (IEvent) con.newInstance(databaseHandle);
							event.initEventData(nextEvent.getData());
							event.notifyListeners();
							AceController.addPreparingEventToTimeline(event, nextAction.getUuid());
						}
						nextAction = aceDao.selectNextAction(timelineHandle, nextAction.getUuid());
					}
		
					databaseHandle.commitTransaction();
					return Response.ok().build();
				} catch (Exception e) {
					databaseHandle.rollbackTransaction();
					throw new WebApplicationException(e);
				} finally {
					timelineHandle.close();
					databaseHandle.close();
				}
			}
		
		}
		
	'''
	
	def generateAceController() '''
		package com.anfelisa.ace;
		
		import java.util.ArrayList;
		import java.util.HashMap;
		import java.util.List;
		import java.util.Map;
		import java.util.function.BiConsumer;
		
		import javax.ws.rs.WebApplicationException;
		
		import org.skife.jdbi.v2.Handle;
		
		import com.anfelisa.ace.encryption.EncryptionService;
		import com.fasterxml.jackson.core.JsonProcessingException;
		
		public class AceController {
		
			private static AceExecutionMode aceExecutionMode;
		
			private final static JodaObjectMapper mapper = new JodaObjectMapper();
		
			private final static Map<String, List<BiConsumer<? extends IDataContainer, Handle>>> consumerMap = new HashMap<String, List<BiConsumer<? extends IDataContainer, Handle>>>();
		
			private final static AceDao aceDao = new AceDao();
		
			public static AceExecutionMode getAceExecutionMode() {
				return aceExecutionMode;
			}
		
			public static void setAceExecutionMode(AceExecutionMode aceExecutionMode) {
				AceController.aceExecutionMode = aceExecutionMode;
			}
		
			public static void addActionToTimeline(IAction action) {
				try {
					String json = mapper.writeValueAsString(action.getActionData());
					addItemToTimeline("action", action.getHttpMethod().name(), action.getActionName(), json,
							action.getActionData().getUuid(), action.getDatabaseHandle());
				} catch (JsonProcessingException e) {
					throw new WebApplicationException(e);
				}
			}
		
			public static void addCommandToTimeline(ICommand command) {
				try {
					addItemToTimeline("command", null, command.getCommandName(),
							mapper.writeValueAsString(command.getCommandData()), command.getCommandData().getUuid(),
							command.getDatabaseHandle());
				} catch (JsonProcessingException e) {
					throw new WebApplicationException(e);
				}
			}
		
			public static void addEventToTimeline(IEvent event) {
				try {
					addItemToTimeline("event", null, event.getEventName(), mapper.writeValueAsString(event.getEventData()),
							event.getEventParam().getUuid(), event.getDatabaseHandle());
				} catch (JsonProcessingException e) {
					throw new WebApplicationException(e);
				}
			}
		
			public static void addPreparingEventToTimeline(IEvent event, String uuid) {
				try {
					addItemToTimeline("preparing event", null, event.getEventName(), mapper.writeValueAsString(event.getEventData()),
							uuid, event.getDatabaseHandle());
				} catch (JsonProcessingException e) {
					throw new WebApplicationException(e);
				}
			}
		
			public static void addExceptionToTimeline(String uuid, Throwable x, DatabaseHandle databaseHandle) {
				aceDao.insertIntoErrorTimeline(databaseHandle.getErrorHandle(), "exception", null, x.getClass().getName(),
						x.getMessage(), uuid);
			}
		
			private static void addItemToTimeline(String type, String method, String name, String json, String uuid,
					DatabaseHandle databaseHandle) {
				if (databaseHandle == null) {
					throw new WebApplicationException("no database handle");
				}
				aceDao.insertIntoTimeline(databaseHandle.getHandle(), type, method, name, EncryptionService.encrypt(json),
						uuid);
				aceDao.insertIntoErrorTimeline(databaseHandle.getErrorHandle(), type, method, name,
						EncryptionService.encrypt(json), uuid);
			}
		
			public static void addConsumer(String eventName, BiConsumer<? extends IDataContainer, Handle> createUserTable) {
				List<BiConsumer<? extends IDataContainer, Handle>> consumerForEvent = consumerMap.get(eventName);
				if (consumerForEvent == null) {
					consumerForEvent = new ArrayList<BiConsumer<? extends IDataContainer, Handle>>();
					consumerMap.put(eventName, consumerForEvent);
				}
				consumerForEvent.add(createUserTable);
			}
		
			public static List<BiConsumer<? extends IDataContainer, Handle>> getConsumerForEvent(String eventName) {
				return consumerMap.get(eventName);
			}
		
		}
	'''
	
	def generateAceDao() '''
		package com.anfelisa.ace;
		
		import org.apache.commons.lang3.StringUtils;
		import org.skife.jdbi.v2.Handle;
		import org.skife.jdbi.v2.Update;
		
		public class AceDao {
		
			private static String schemaName = "public";
		
			public static void setSchemaName(String schemaName) {
				AceDao.schemaName = schemaName;
			}
		
			private String timelineTable() {
				if (StringUtils.isBlank(AceDao.schemaName)) {
					return "public.timeline";
				} else {
					return AceDao.schemaName + ".timeline";
				}
			}
		
			private String errorTimelineTable() {
				if (StringUtils.isBlank(AceDao.schemaName)) {
					return "public.errorTimeline";
				} else {
					return AceDao.schemaName + ".errorTimeline";
				}
			}
		
			public void truncateTimelineTable(Handle handle) {
				handle.execute("TRUNCATE " + timelineTable());
				handle.execute("ALTER SEQUENCE " + timelineTable() + "_id_seq RESTART");
			}
		
			public void truncateErrorTimelineTable(Handle handle) {
				handle.execute("TRUNCATE " + errorTimelineTable());
				handle.execute("ALTER SEQUENCE " + errorTimelineTable() + "_id_seq RESTART");
			}
		
			public void insertIntoTimeline(Handle handle, String type, String method, String name, String data, String uuid) {
				Update statement = handle.createStatement("INSERT INTO " + timelineTable()
						+ " (type, method, name, time, data, uuid) " + "VALUES (:type, :method, :name, NOW(), :data, :uuid);");
				statement.bind("type", type);
				if (method != null) {
					statement.bind("method", method);
				} else {
					statement.bind("method", "---");
				}
				statement.bind("name", name);
				statement.bind("data", data);
				statement.bind("uuid", uuid);
				statement.execute();
			}
		
			public void insertIntoErrorTimeline(Handle handle, String type, String method, String name, String data,
					String uuid) {
				if (handle != null) {
					Update statement = handle.createStatement("INSERT INTO " + errorTimelineTable()
							+ " (type, method, name, time, data, uuid) " + "VALUES (:type, :method, :name, NOW(), :data, :uuid);");
					statement.bind("type", type);
					if (method != null) {
						statement.bind("method", method);
					} else {
						statement.bind("method", "---");
					}
					statement.bind("name", name);
					if (data != null) {
						statement.bind("data", data);
					} else {
						statement.bind("data", "unknown exception");
					}
					statement.bind("uuid", uuid);
					statement.execute();
				}
			}
		
			public ITimelineItem selectNextAction(Handle handle, String uuid) {
				if (uuid != null) {
					return handle
							.createQuery("SELECT id, type, method, name, time, data, uuid " + "FROM " + timelineTable() + " "
									+ "where id > " + "(select id from " + timelineTable()
									+ " where uuid = :uuid and type = 'action' limit 1) " + "and type = 'action' "
									+ "order by time asc " + "limit 1")
							.bind("uuid", uuid).map(new TimelineItemMapper()).first();
				} else {
					return handle
							.createQuery("SELECT id, type, method, name, time, data, uuid " + "FROM " + timelineTable() + " "
									+ "where type = 'action' " + "order by time asc " + "limit 1")
							.bind("uuid", uuid).map(new TimelineItemMapper()).first();
				}
			}
		
			public ITimelineItem selectLastAction(Handle handle) {
				return handle
						.createQuery("SELECT id, type, method, name, time, data, uuid " + "FROM " + timelineTable() + " "
								+ "where type = 'action' " + "order by time desc " + "limit 1")
						.map(new TimelineItemMapper()).first();
			}
		
			public ITimelineItem selectTimelineItem(Handle handle, String uuid) {
				return handle.createQuery("SELECT id, type, method, name, time, data, uuid " + "FROM " + timelineTable() + " "
						+ "where uuid = :uuid").bind("uuid", uuid).map(new TimelineItemMapper()).first();
			}
		
			public ITimelineItem selectNextCommand(Handle handle, String uuid) {
				if (uuid != null) {
					return handle
							.createQuery("SELECT id, type, method, name, time, data, uuid " + "FROM " + timelineTable() + " "
									+ "where id > " + "(select id from " + timelineTable()
									+ " where uuid = :uuid and type = 'command' limit 1) " + "and type = 'command' "
									+ "order by time asc " + "limit 1")
							.bind("uuid", uuid).map(new TimelineItemMapper()).first();
				} else {
					return handle
							.createQuery("SELECT id, type, method, name, time, data, uuid " + "FROM " + timelineTable() + " "
									+ "where type = 'command' " + "order by time asc " + "limit 1")
							.bind("uuid", uuid).map(new TimelineItemMapper()).first();
				}
			}
		
			public ITimelineItem selectCommand(Handle handle, String uuid) {
				return handle
						.createQuery("SELECT id, type, method, name, time, data, uuid " + "FROM " + timelineTable() + " "
								+ "where uuid = :uuid and type = 'command'")
						.bind("uuid", uuid).map(new TimelineItemMapper()).first();
			}

			public ITimelineItem selectNextEvent(Handle handle, String uuid) {
				if (uuid != null) {
					return handle
							.createQuery("SELECT id, type, method, name, time, data, uuid " + "FROM " + timelineTable() + " "
									+ "where id > " + "(select id from " + timelineTable()
									+ " where uuid = :uuid and type = 'event' limit 1) " + "and type = 'event' "
									+ "order by time asc " + "limit 1")
							.bind("uuid", uuid).map(new TimelineItemMapper()).first();
				} else {
					return handle
							.createQuery("SELECT id, type, method, name, time, data, uuid " + "FROM " + timelineTable() + " "
									+ "where type = 'event' " + "order by time asc " + "limit 1")
							.bind("uuid", uuid).map(new TimelineItemMapper()).first();
				}
			}
		
			public ITimelineItem selectEvent(Handle handle, String uuid) {
				return handle
						.createQuery("SELECT id, type, method, name, time, data, uuid " + "FROM " + timelineTable() + " "
								+ "where uuid = :uuid and type = 'event'")
						.bind("uuid", uuid).map(new TimelineItemMapper()).first();
			}

		}
	'''
	
	def generateAceExecutionMode() '''
		package com.anfelisa.ace;
		
		public enum AceExecutionMode {
			LIVE, REPLAY, MIGRATE
		}
		
	'''

	def generateAction() '''
		package com.anfelisa.ace;
		
		import java.lang.reflect.Constructor;
		
		import javax.ws.rs.WebApplicationException;
		import javax.ws.rs.core.Response;
		
		import org.joda.time.DateTime;
		import org.skife.jdbi.v2.DBI;
		import org.skife.jdbi.v2.Handle;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		public abstract class Action<T extends IDataContainer> implements IAction {
		
			static final Logger LOG = LoggerFactory.getLogger(Action.class);
		
			protected T actionData;
			private String actionName;
			private HttpMethod httpMethod;
			protected DatabaseHandle databaseHandle;
			private DBI jdbi;
			private DBI jdbiTimeline;
			protected JodaObjectMapper mapper;
			private AceDao aceDao = new AceDao();
		
			public Action(String actionName, HttpMethod httpMethod, DBI jdbi, DBI jdbiTimeline) {
				super();
				this.actionName = actionName;
				this.httpMethod = httpMethod;
				this.jdbi = jdbi;
				this.jdbiTimeline = jdbiTimeline;
				mapper = new JodaObjectMapper();
			}
		
			public String getActionName() {
				return this.actionName;
			}
		
			public HttpMethod getHttpMethod() {
				return this.httpMethod;
			}
		
			public IDataContainer getActionData() {
				return this.actionData;
			}
		
			protected abstract void loadDataForGetRequest();
		
			public Response apply() {
				if (AceController.getAceExecutionMode() == AceExecutionMode.MIGRATE) {
					this.throwServiceUnavailable("service is in maintenance mode");
				}
				this.databaseHandle = new DatabaseHandle(jdbi.open(), jdbi.open());
				Handle timelineHandle = null;
				databaseHandle.beginTransaction();
				try {
					if (AceController.getAceExecutionMode() == AceExecutionMode.LIVE) {
						this.actionData.setSystemTime(new DateTime());
					} else {
						timelineHandle = jdbiTimeline.open();
						ITimelineItem timelineItem = aceDao.selectTimelineItem(timelineHandle, this.actionData.getUuid());
						if (timelineItem != null) {
							Class<?> cl = Class.forName(timelineItem.getName());
							Constructor<?> con = cl.getConstructor(DBI.class, DBI.class);
							IAction action = (IAction) con.newInstance(jdbi, jdbiTimeline);
							action.initActionData(timelineItem.getData());
							this.actionData.setSystemTime(action.getActionData().getSystemTime());
						} else {
							this.actionData.setSystemTime(new DateTime());
						}
					}
					AceController.addActionToTimeline(this);
					if (httpMethod != HttpMethod.GET) {
						ICommand command = this.getCommand();
						if (command != null) {
							command.execute();
						} else {
							throw new WebApplicationException(actionName + " returns no command");
						}
					} else {
						this.loadDataForGetRequest();
					}
					databaseHandle.commitTransaction();
					if (httpMethod == HttpMethod.GET) {
						return Response.ok(this.getActionData()).build();
					} else if (httpMethod == HttpMethod.POST) {
						return Response.ok(this.getActionData().getCreatedId()).build();
					} else {
						return Response.ok().build();
					}
				} catch (WebApplicationException x) {
					AceController.addExceptionToTimeline(this.actionData.getUuid(), x, databaseHandle);
					databaseHandle.rollbackTransaction();
					LOG.error(actionName + " failed " + x.getMessage());
					//x.printStackTrace();
					return Response.status(x.getResponse().getStatusInfo()).entity(x.getMessage()).build();
				} catch (Exception x) {
					AceController.addExceptionToTimeline(this.actionData.getUuid(), x, databaseHandle);
					databaseHandle.rollbackTransaction();
					LOG.error(actionName + " failed " + x.getMessage());
					//x.printStackTrace();
					return Response.status(500).entity(x.getMessage()).build();
				} finally {
					databaseHandle.close();
					if (timelineHandle != null) {
						timelineHandle.close();
					}
				}
			}
		
			public DatabaseHandle getDatabaseHandle() {
				return databaseHandle;
			}
		
			public void setDatabaseHandle(DatabaseHandle databaseHandle) {
				this.databaseHandle = databaseHandle;
			}
		
			protected Handle getHandle() {
				if (databaseHandle != null) {
					return databaseHandle.getHandle();
				} else {
					throw new RuntimeException("no database handle");
				}
			}
			
			protected void throwUnauthorized() {
				throw new WebApplicationException(Response.Status.UNAUTHORIZED);
			}
		
			protected void throwBadRequest() {
				throw new WebApplicationException(Response.Status.BAD_REQUEST);
			}
		
			protected void throwBadRequest(String error) {
				throw new WebApplicationException(error, Response.Status.BAD_REQUEST);
			}
		
			protected void throwForbidden(String error) {
				throw new WebApplicationException(error, Response.Status.FORBIDDEN);
			}
			
			protected void throwServiceUnavailable(String error) {
				throw new WebApplicationException(error, Response.Status.SERVICE_UNAVAILABLE);
			}

			protected void throwInternalServerError(Exception x) {
				String message = x.getMessage();
				StackTraceElement[] stackTrace = x.getStackTrace();
				int i = 1;
				for (StackTraceElement stackTraceElement : stackTrace) {
					message += "\n" + stackTraceElement.toString();
					if (i > 3) {
						message += "\n" + (stackTrace.length - 4) + " more...";
						break;
					}
					i++;
				}
				throw new WebApplicationException(message, Response.Status.INTERNAL_SERVER_ERROR);
			}
		
		}
	'''
	
	def generateCommand() '''
		package com.anfelisa.ace;
		
		import javax.ws.rs.WebApplicationException;
		import javax.ws.rs.core.Response;
		
		import org.skife.jdbi.v2.Handle;
		
		import com.fasterxml.jackson.annotation.JsonIgnore;
		
		public abstract class Command<T extends IDataContainer> implements ICommand {
		
			protected T commandData;
			private String commandName;
			@JsonIgnore
			protected DatabaseHandle databaseHandle;
			protected JodaObjectMapper mapper;
		
			public Command(String commandName, T commandData, DatabaseHandle databaseHandle) {
				super();
				this.commandData = commandData;
				this.commandName = commandName;
				this.databaseHandle = databaseHandle;
				mapper = new JodaObjectMapper();
			}
		
			protected void executeCommand() {
			}
		
			public void execute() {
				this.executeCommand();
				if (AceController.getAceExecutionMode() != AceExecutionMode.MIGRATE) {
					AceController.addCommandToTimeline(this);
				}
				this.publishEvents();
			}
		
			public IDataContainer getCommandData() {
				return commandData;
			}
		
			public String getCommandName() {
				return commandName;
			}
		
			@JsonIgnore
			public DatabaseHandle getDatabaseHandle() {
				return databaseHandle;
			}
		
			@JsonIgnore
			protected Handle getHandle() {
				if (databaseHandle != null) {
					return databaseHandle.getHandle();
				} else {
					throw new RuntimeException("no database handle");
				}
			}
		
			protected void throwUnauthorized() {
				throw new WebApplicationException(Response.Status.UNAUTHORIZED);
			}
		
			protected void throwBadRequest() {
				throw new WebApplicationException(Response.Status.BAD_REQUEST);
			}
		
			protected void throwBadRequest(String error) {
				throw new WebApplicationException(error, Response.Status.BAD_REQUEST);
			}
		
			protected void throwForbidden(String error) {
				throw new WebApplicationException(error, Response.Status.FORBIDDEN);
			}
		
			protected void throwInternalServerError(Exception x) {
				String message = x.getMessage();
				StackTraceElement[] stackTrace = x.getStackTrace();
				int i = 1;
				for (StackTraceElement stackTraceElement : stackTrace) {
					message += "\n" + stackTraceElement.toString();
					if (i > 3) {
						message += "\n" + (stackTrace.length - 4) + " more...";
						break;
					}
					i++;
				}
				throw new WebApplicationException(message, Response.Status.INTERNAL_SERVER_ERROR);
			}
		
		}
		
	'''
	
	def generateDatabaseHandle() '''
		package com.anfelisa.ace;
		
		import org.skife.jdbi.v2.Handle;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		public class DatabaseHandle {
		
			static final Logger LOG = LoggerFactory.getLogger(DatabaseHandle.class);
		
			private Handle handle;
			private Handle errorHandle;
		
			public DatabaseHandle(Handle handle, Handle errorHandle) {
				super();
				try {
					if (handle != null) {
						this.handle = handle;
						this.handle.getConnection().setAutoCommit(false);
					}
					if (errorHandle != null) {
						this.errorHandle = errorHandle;
						this.errorHandle.getConnection().setAutoCommit(false);
					}
				} catch (Exception e) {
					LOG.error("failed to set auto commit off", e);
				}
			}
		
			public void beginTransaction() {
				if (handle != null) {
					handle.begin();
				}
				if (errorHandle != null) {
					errorHandle.begin();
				}
			}
		
			public void commitTransaction() {
				if (handle != null) {
					handle.commit();
				}
				if (errorHandle != null) {
					errorHandle.rollback();
				}
			}
		
			public void rollbackTransaction() {
				if (handle != null) {
					handle.rollback();
				}
				if (errorHandle != null) {
					errorHandle.commit();
				}
			}
		
			public void close() {
				if (handle != null) {
					handle.close();
				}
				if (errorHandle != null) {
					errorHandle.close();
				}
			}
		
			public Handle getHandle() {
				return handle;
			}
		
			public Handle getErrorHandle() {
				return errorHandle;
			}
		
		}
		
	'''
	
	def generateEvent() '''
		package com.anfelisa.ace;
		
		import java.util.List;
		import java.util.function.BiConsumer;
		
		import org.skife.jdbi.v2.Handle;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import com.fasterxml.jackson.annotation.JsonIgnore;
		
		public abstract class Event<T extends IDataContainer> implements IEvent {
		
			static final Logger LOG = LoggerFactory.getLogger(Event.class);
		
			protected T eventParam;
			protected T eventData;
			private String eventName;
			@JsonIgnore
			protected DatabaseHandle databaseHandle;
			protected JodaObjectMapper mapper;
		
			public Event(String eventName, T eventParam, DatabaseHandle databaseHandle) {
				super();
				this.eventParam = eventParam;
				this.eventName = eventName;
				this.databaseHandle = databaseHandle;
				mapper = new JodaObjectMapper();
			}

			protected void prepareDataForView() {
			}
		
			@SuppressWarnings("unchecked")
			public void notifyListeners() {
				List<BiConsumer<? extends IDataContainer, Handle>> consumerList = AceController.getConsumerForEvent(eventName);
				if (consumerList != null) {
					for (BiConsumer<? extends IDataContainer, Handle> consumer : consumerList) {
						((BiConsumer<T, Handle>)consumer).accept(this.eventData, databaseHandle.getHandle());
					}
				}
			}
		
			public IDataContainer getEventParam() {
				return eventParam;
			}
		
			public IDataContainer getEventData() {
				return eventData;
			}
		
			public String getEventName() {
				return eventName;
			}
		
			@JsonIgnore
			public DatabaseHandle getDatabaseHandle() {
				return databaseHandle;
			}
		
			public void publish() {
				this.prepareDataForView();
				if (AceController.getAceExecutionMode() != AceExecutionMode.MIGRATE) {
					AceController.addEventToTimeline(this);
				}
				this.notifyListeners();
			}
		
		}
		
	'''
	
	def generateHttpMethod() '''
		package com.anfelisa.ace;
		
		public enum HttpMethod {
			GET, POST, PUT, DELETE
		}
		
	'''
	
	def generateIAction() '''
		package com.anfelisa.ace;
		
		import javax.ws.rs.core.Response;
		
		public interface IAction {
		
			String getActionName();
			
			HttpMethod getHttpMethod();
			
			IDataContainer getActionData();
			
			ICommand getCommand();
			
		    DatabaseHandle getDatabaseHandle();
			
		    void setDatabaseHandle(DatabaseHandle databaseHandle);
		
		    Response apply();
			
			void initActionData(String json);
			
		}
		
	'''
	
	def generateICommand() '''
		package com.anfelisa.ace;
		
		import com.fasterxml.jackson.annotation.JsonIgnore;
		
		public interface ICommand {
		
			String getCommandName();

			IDataContainer getCommandData();

			@JsonIgnore
			DatabaseHandle getDatabaseHandle();

			void initCommandData(String json);

			void execute();
		
			void publishEvents();
		}
		
	'''
	
	def generateIDataContainer() '''
		package com.anfelisa.ace;
		
		import org.joda.time.DateTime;
		
		public interface IDataContainer {
		
			String getUuid();

			String getOutcome();

			void setOutcome(String outcome);
			
			String getCreatedId();
			
			void setCreatedId(String createdId);
			
			DateTime getSystemTime();
			
			void setSystemTime(DateTime systemTime);
		
		}
		
	'''
	
	def generateIEvent() '''
		package com.anfelisa.ace;
		
		import com.fasterxml.jackson.annotation.JsonIgnore;
		
		public interface IEvent {
		
			String getEventName();
			
			IDataContainer getEventParam();
			
			IDataContainer getEventData();
			
			@JsonIgnore
			DatabaseHandle getDatabaseHandle();
			
			void publish();
			
			void initEventData(String json);
			
			void notifyListeners();
		
		}
		
	'''
	
	def generateITimelineItem() '''
		package com.anfelisa.ace;
		
		import org.joda.time.DateTime;
		
		public interface ITimelineItem {
		
			Integer getId();
			
			String getType();
			
			String getMethod();
			
			String getName();
			
			DateTime getTimestamp();
			
			String getData();
			
			String getUuid();
		}
		
	'''
	
	def generateJodaObjectMapper() '''
		package com.anfelisa.ace;
		
		import com.fasterxml.jackson.databind.ObjectMapper;
		import com.fasterxml.jackson.datatype.joda.JodaModule;
		
		public class JodaObjectMapper extends ObjectMapper {
		
			private static final long serialVersionUID = 3204337293769989499L;
		
			public JodaObjectMapper() {
		        super();
		        registerModule(new JodaModule());
		    }
		}
	''' 
	
	def generateResource() '''
		package com.anfelisa.ace;
		
		import org.skife.jdbi.v2.DBI;
		
		public class Resource {
		
			private DBI jdbi;
		
			public Resource( DBI jdbi) {
				super();
				this.jdbi = jdbi;
			}
		
			public DatabaseHandle createDatabaseHandle() {
				return new DatabaseHandle(jdbi.open(), jdbi.open());
			}
		
			public DBI getJdbi() {
				return jdbi;
			}
			
		}
		
	'''
	
	def generateTimelineItem() '''
		package com.anfelisa.ace;
		
		import org.joda.time.DateTime;
		
		public class TimelineItem implements ITimelineItem {
		
			private Integer id;
			
			private String type;
			
			private String method;
			
			private String name;
			
			private DateTime timestamp;
			
			private String data;
			
			private String uuid;
		
			
			public TimelineItem(Integer id, String type, String method, String name, DateTime timestamp, String data,
					String uuid) {
				super();
				this.id = id;
				this.type = type;
				this.method = method;
				this.name = name;
				this.timestamp = timestamp;
				this.data = data;
				this.uuid = uuid;
			}
		
			public Integer getId() {
				return id;
			}
		
			public String getType() {
				return type;
			}
		
			public String getMethod() {
				return method;
			}
		
			public String getName() {
				return name;
			}
		
			public DateTime getTimestamp() {
				return timestamp;
			}
		
			public String getData() {
				return data;
			}
		
			public String getUuid() {
				return uuid;
			}
			
			@Override
			public String toString() {
				return "TimelineItem [id=" + id + ", type=" + type + ", method=" + method + ", name=" + name + ", timestamp="
						+ timestamp + ", uuid=" + uuid + "]";
			}
		
		}
		
	'''
	
	def generateTimelineItemMapper() '''
		package com.anfelisa.ace;
		
		import java.sql.ResultSet;
		import java.sql.SQLException;
		
		import org.joda.time.DateTime;
		import org.joda.time.format.DateTimeFormat;
		import org.joda.time.format.DateTimeFormatter;
		import org.skife.jdbi.v2.StatementContext;
		import org.skife.jdbi.v2.tweak.ResultSetMapper;
		
		import com.anfelisa.ace.encryption.EncryptionService;
		
		public class TimelineItemMapper implements ResultSetMapper<ITimelineItem> {
			
			public ITimelineItem map(int index, ResultSet r, StatementContext ctx) throws SQLException {
				DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
				DateTime time = DateTime.parse(r.getString("time"), fmt);
				return new TimelineItem(
					r.getInt("id"),
					r.getString("type"),
					r.getString("method"),
					r.getString("name"),
					time,
					EncryptionService.decrypt(r.getString("data")),
					r.getString("uuid")
				);
			}
		}
	'''
	
	def generateAESEncryption() '''
		package com.anfelisa.ace.encryption;
		
		import static com.anfelisa.ace.encryption.KeyStoreUtils.generateCipher;
		import static com.anfelisa.ace.encryption.KeyStoreUtils.loadKey;
		
		import java.io.File;
		
		import javax.crypto.Cipher;
		import javax.crypto.SecretKey;
		
		import org.apache.commons.lang3.StringUtils;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import sun.misc.BASE64Decoder;
		import sun.misc.BASE64Encoder;
		
		@SuppressWarnings("restriction")
		public class AESEncryption implements IEncryptionService {
		
			static final Logger LOG = LoggerFactory.getLogger(AESEncryption.class);
		
		    private SecretKey key;
			private Cipher encryptCipher;
			private Cipher decryptCipher;
		
			public void initKey(File file) {
				try {
					key = loadKey(file);
					encryptCipher = generateCipher(key, Cipher.ENCRYPT_MODE);
					decryptCipher = generateCipher(key, Cipher.DECRYPT_MODE);
				} catch (Exception e) {
					LOG.error("error in initKey", e);
				}
			}
		
			public String encrypt(String string) {
				if (StringUtils.isEmpty(string)) {
					return "";
				}
				try {
					byte[] bytes = encryptCipher.doFinal(string.getBytes());
					BASE64Encoder myEncoder = new BASE64Encoder();
					return myEncoder.encode(bytes);
				} catch (Exception x) {
					LOG.error("error in encrypt", x);
					return string;
				}
			}
		
			public String decrypt(String string) {
				if (StringUtils.isEmpty(string)) {
					return "";
				}
				try {
					BASE64Decoder myDecoder = new BASE64Decoder();
					byte[] crypted = myDecoder.decodeBuffer(string);
					byte[] recoveredBytes = decryptCipher.doFinal(crypted);
					return new String(recoveredBytes);
				} catch (Exception x) {
					LOG.error("error in decrypt", x);
					return string;
				}
			}
		
		}
		
	'''
	
	def generateEncryptionService() '''
		package com.anfelisa.ace.encryption;
		
		public class EncryptionService {
		
			private static IEncryptionService encryptionService = new NoEncryption();
		
			public static void setEncryptionService(IEncryptionService encryptionService) {
				EncryptionService.encryptionService = encryptionService;
			}
		
			public static String encrypt(String string) {
				return encryptionService.encrypt(string);
			}
			
			public static  String decrypt(String string) {
				return encryptionService.decrypt(string);
			}
		
		
		}
		
	'''
	
	def generateIEncryptionService() '''
		package com.anfelisa.ace.encryption;
		
		import java.io.File;
		
		public interface IEncryptionService {
			void initKey(File file);
			String encrypt(String string);
			String decrypt(String string);
		}
		
	'''
	
	def generateKeystoreUtils() '''
		package com.anfelisa.ace.encryption;
		
		import static org.apache.commons.codec.binary.Hex.decodeHex;
		import static org.apache.commons.codec.binary.Hex.encodeHex;
		import static org.apache.commons.io.FileUtils.readFileToByteArray;
		import static org.apache.commons.io.FileUtils.writeStringToFile;
		
		import java.io.File;
		import java.io.IOException;
		import java.security.InvalidKeyException;
		import java.security.NoSuchAlgorithmException;
		
		import javax.crypto.Cipher;
		import javax.crypto.KeyGenerator;
		import javax.crypto.NoSuchPaddingException;
		import javax.crypto.SecretKey;
		import javax.crypto.spec.SecretKeySpec;
		
		import org.apache.commons.codec.DecoderException;
		
		public class KeyStoreUtils {
			public static final String ALGO = "AES";
		
			public static SecretKey generateKey() throws NoSuchAlgorithmException {
				KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGO);
				SecretKey key = keyGenerator.generateKey();
				return key;
			}
		
			public static void saveKey(SecretKey key, File file) throws IOException {
				byte[] encoded = key.getEncoded();
				char[] hex = encodeHex(encoded);
				String data = String.valueOf(hex);
				writeStringToFile(file, data);
			}
		
			public static SecretKey loadKey(File file) throws IOException {
				String data = new String(readFileToByteArray(file));
				char[] hex = data.toCharArray();
				byte[] encoded;
				try {
					encoded = decodeHex(hex);
				} catch (DecoderException e) {
					e.printStackTrace();
					return null;
				}
				SecretKey key = new SecretKeySpec(encoded, ALGO);
				return key;
			}
			
			public static Cipher generateCipher(SecretKey key, int mode) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
				Cipher cipher = Cipher.getInstance(ALGO);
				cipher.init(mode, key);
				return cipher;
			}
		}
	'''
	
	def generateNoEncryption() '''
		package com.anfelisa.ace.encryption;
		
		import java.io.File;
		
		public class NoEncryption implements IEncryptionService {
		
			public void initKey(File file) {
			}
		
			public String encrypt(String string) {
				return string;
			}
		
			public String decrypt(String string) {
				return string;
			}
		
		}
		
	'''
	
	def generateAceMigration() '''
		<createTable tableName="timeline">
			<column name="id" type="serial">
				<constraints primaryKey="true" nullable="false" />
			</column>
			<column name="type" type="character varying">
				<constraints nullable="false" />
			</column>
			<column name="method" type="character varying">
				<constraints nullable="false" />
			</column>
			<column name="name" type="character varying">
				<constraints nullable="false" />
			</column>
			<column name="time" type="timestamp">
				<constraints nullable="false" />
			</column>
			<column name="data" type="character varying">
				<constraints nullable="false" />
			</column>
			<column name="uuid" type="character varying">
				<constraints nullable="false" />
			</column>
		</createTable>
		
		<createTable tableName="errortimeline">
			<column name="id" type="serial">
				<constraints primaryKey="true" nullable="false" />
			</column>
			<column name="type" type="character varying">
				<constraints nullable="false" />
			</column>
			<column name="method" type="character varying">
				<constraints nullable="false" />
			</column>
			<column name="name" type="character varying">
				<constraints nullable="false" />
			</column>
			<column name="time" type="timestamp">
				<constraints nullable="false" />
			</column>
			<column name="data" type="character varying">
				<constraints nullable="false" />
			</column>
			<column name="uuid" type="character varying">
				<constraints nullable="false" />
			</column>
		</createTable>

		<createTable tableName="scenario">
			<column name="id" type="serial">
				<constraints primaryKey="true" nullable="false"/>
			</column>
			<column name="description" type="character varying">
				<constraints  nullable="false"/>
			</column>
			<column name="timeline" type="character varying">
				<constraints  nullable="false"/>
			</column>
			<column name="creator" type="character varying">
				<constraints  nullable="false"/>
			</column>
			<column name="createddatetime" type="timestamp with time zone">
				<constraints  />
			</column>
			<column name="updateddatetime" type="timestamp with time zone">
				<constraints  />
			</column>
			<column name="serverversion" type="character varying">
				<constraints  nullable="false"/>
			</column>
			<column name="clientversion" type="character varying">
				<constraints  nullable="false"/>
			</column>
			<column name="device" type="character varying">
				<constraints  nullable="false"/>
			</column>
		</createTable>
		
		<createTable tableName="bug">
			<column name="id" type="serial">
				<constraints primaryKey="true" nullable="false"/>
			</column>
			<column name="description" type="character varying">
				<constraints  nullable="false"/>
			</column>
			<column name="timeline" type="character varying">
				<constraints  nullable="false"/>
			</column>
			<column name="reporter" type="character varying">
				<constraints  nullable="false"/>
			</column>
			<column name="resolved" type="boolean">
				<constraints  nullable="false"/>
			</column>
			<column name="createddatetime" type="timestamp with time zone">
				<constraints  />
			</column>
			<column name="updateddatetime" type="timestamp with time zone">
				<constraints  />
			</column>
			<column name="serverversion" type="character varying">
				<constraints  nullable="false"/>
			</column>
			<column name="clientversion" type="character varying">
				<constraints  nullable="false"/>
			</column>
			<column name="device" type="character varying">
				<constraints  nullable="false"/>
			</column>
		</createTable>
		
		<createTable tableName="scenarioresult">
			<column name="id" type="serial">
				<constraints primaryKey="true" nullable="false"/>
			</column>
			<column name="scenarioid" type="integer">
				<constraints nullable="false" references="scenario(id)"
					deleteCascade="true" foreignKeyName="fk_scenarioresult_scenario" />
			</column>
			<column name="description" type="character varying">
				<constraints  nullable="false"/>
			</column>
			<column name="timeline" type="character varying">
				<constraints  nullable="false"/>
			</column>
			<column name="executor" type="character varying">
				<constraints  nullable="false"/>
			</column>
			<column name="createddatetime" type="timestamp with time zone">
				<constraints  />
			</column>
			<column name="serverversion" type="character varying">
				<constraints  nullable="false"/>
			</column>
			<column name="clientversion" type="character varying">
				<constraints  nullable="false"/>
			</column>
			<column name="device" type="character varying">
				<constraints  nullable="false"/>
			</column>
			<column name="result" type="boolean">
				<constraints  nullable="false"/>
			</column>
			<column name="e2e" type="boolean">
				<constraints  nullable="false"/>
			</column>
		</createTable>
		
	'''
	
	def generateBugDao() '''
		package com.anfelisa.ace.bug;
		
		import org.skife.jdbi.v2.Handle;
		import org.skife.jdbi.v2.Query;
		import org.skife.jdbi.v2.Update;
		
		import java.util.List;
		import java.util.Map;
		
		import com.fasterxml.jackson.annotation.JsonIgnoreType;
		
		import com.anfelisa.ace.encryption.EncryptionService;
		
		@SuppressWarnings("all")
		@JsonIgnoreType
		public class BugDao {
			
			public Integer insert(Handle handle, IBugModel bugModel) {
				Query<Map<String, Object>> statement = handle.createQuery("INSERT INTO public.bug (description, timeline, reporter, resolved, createddatetime, updateddatetime, serverversion, clientversion, device) VALUES (:description, :timeline, :reporter, :resolved, :createddatetime, :updateddatetime, :serverversion, :clientversion, :device) RETURNING id");
				statement.bind("description",  bugModel.getDescription() );
				statement.bind("timeline",  bugModel.getTimeline() );
				statement.bind("reporter",  bugModel.getReporter() );
				statement.bind("resolved",  bugModel.getResolved() );
				statement.bind("createddatetime",  bugModel.getCreatedDateTime() );
				statement.bind("updateddatetime",  bugModel.getUpdatedDateTime() );
				statement.bind("serverversion",  bugModel.getServerVersion() );
				statement.bind("clientversion",  bugModel.getClientVersion() );
				statement.bind("device",  bugModel.getDevice() );
				Map<String, Object> first = statement.first();
				return (Integer) first.get("id");
			}
			
			
			public void updateById(Handle handle, IBugModel bugModel) {
				Update statement = handle.createStatement("UPDATE public.bug SET description = :description, timeline = :timeline, reporter = :reporter, resolved = :resolved, createddatetime = :createddatetime, updateddatetime = :updateddatetime, serverversion = :serverversion, clientversion = :clientversion, device = :device WHERE id = :id");
				statement.bind("description",  bugModel.getDescription() );
				statement.bind("timeline",  bugModel.getTimeline() );
				statement.bind("reporter",  bugModel.getReporter() );
				statement.bind("resolved",  bugModel.getResolved() );
				statement.bind("createddatetime",  bugModel.getCreatedDateTime() );
				statement.bind("updateddatetime",  bugModel.getUpdatedDateTime() );
				statement.bind("serverversion",  bugModel.getServerVersion() );
				statement.bind("clientversion",  bugModel.getClientVersion() );
				statement.bind("device",  bugModel.getDevice() );
				statement.bind("id",  bugModel.getId()  );
				statement.execute();
			}

			public void updateResolvedById(Handle handle, Integer id, org.joda.time.DateTime updateddatetime) {
				Update statement = handle.createStatement("UPDATE public.bug SET resolved = true, updateddatetime = :updateddatetime WHERE id = :id");
				statement.bind("id",  id );
				statement.bind("updateddatetime",  updateddatetime );
				statement.execute();
			}
		
			public void deleteById(Handle handle, Integer id) {
				Update statement = handle.createStatement("DELETE FROM public.bug WHERE id = :id");
				statement.bind("id", id);
				statement.execute();
			}
		
			public IBugModel selectById(Handle handle, Integer id) {
				return handle.createQuery("SELECT id, description, timeline, reporter, resolved, createddatetime, updateddatetime, serverversion, clientversion, device FROM public.bug WHERE id = :id")
					.bind("id", id)
					.map(new BugMapper())
					.first();
			}
			
			public List<IBugModel> selectAll(Handle handle) {
				return handle.createQuery("SELECT id, description, timeline, reporter, resolved, createddatetime, updateddatetime, serverversion, clientversion, device FROM public.bug")
					.map(new BugMapper())
					.list();
			}
		
			public void truncate(Handle handle) {
				Update statement = handle.createStatement("TRUNCATE public.bug");
				statement.execute();
				statement = handle.createStatement("ALTER SEQUENCE public.bug_id_seq RESTART");
				statement.execute();
			}
		
		}
		
		/*       S.D.G.       */
				
		
	'''
	
	def generateBugMapper() '''
		package com.anfelisa.ace.bug;
		
		import java.sql.ResultSet;
		import java.sql.SQLException;
		
		import org.skife.jdbi.v2.StatementContext;
		import org.skife.jdbi.v2.tweak.ResultSetMapper;
		
		import com.anfelisa.ace.encryption.EncryptionService;
		
		@SuppressWarnings("all")
		public class BugMapper implements ResultSetMapper<IBugModel> {
			
			public IBugModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
				return new BugModel(
					r.getInt("id"),
					r.getString("description"),
					r.getString("timeline"),
					r.getString("reporter"),
					r.getBoolean("resolved"),
					r.getTimestamp("createdDateTime") != null ? new org.joda.time.DateTime(r.getTimestamp("createdDateTime")) : null,
					r.getTimestamp("updatedDateTime") != null ? new org.joda.time.DateTime(r.getTimestamp("updatedDateTime")) : null,
					r.getString("serverVersion"),
					r.getString("clientVersion"),
					r.getString("device")
				);
			}
		}
		
		/*       S.D.G.       */
				
	'''
	
	def generateBugModel() '''
		package com.anfelisa.ace.bug;

		import com.fasterxml.jackson.annotation.JsonProperty;
		import javax.validation.constraints.NotNull;
		import org.hibernate.validator.constraints.NotEmpty;
		
		@SuppressWarnings("all")
		public class BugModel implements IBugModel {
		
			private Integer id;
			
			private String description;
			
			@NotNull
			private String timeline;
			
			private String reporter;
			
			private Boolean resolved;
			
			private org.joda.time.DateTime createdDateTime;
			
			private org.joda.time.DateTime updatedDateTime;
			
			private String serverVersion;
			
			private String clientVersion;
			
			private String device;
		
			public BugModel(
				@JsonProperty("id") Integer id,
				@JsonProperty("description") String description,
				@JsonProperty("timeline") String timeline,
				@JsonProperty("reporter") String reporter,
				@JsonProperty("resolved") Boolean resolved,
				@JsonProperty("createdDateTime") org.joda.time.DateTime createdDateTime,
				@JsonProperty("updatedDateTime") org.joda.time.DateTime updatedDateTime,
				@JsonProperty("serverVersion") String serverVersion,
				@JsonProperty("clientVersion") String clientVersion,
				@JsonProperty("device") String device
			) {
				this.id = id;
				this.description = description;
				this.timeline = timeline;
				this.reporter = reporter;
				this.resolved = resolved;
				this.createdDateTime = createdDateTime;
				this.updatedDateTime = updatedDateTime;
				this.serverVersion = serverVersion;
				this.clientVersion = clientVersion;
				this.device = device;
			}
		
			@JsonProperty
			public Integer getId() {
				return this.id;
			}
			public void setId(Integer id) {
				this.id = id;
			}
			
			@JsonProperty
			public String getDescription() {
				return this.description;
			}
			public void setDescription(String description) {
				this.description = description;
			}
			
			@JsonProperty
			public String getTimeline() {
				return this.timeline;
			}
			public void setTimeline(String timeline) {
				this.timeline = timeline;
			}
			
			@JsonProperty
			public String getReporter() {
				return this.reporter;
			}
			public void setReporter(String reporter) {
				this.reporter = reporter;
			}
			
			@JsonProperty
			public Boolean getResolved() {
				return this.resolved;
			}
			public void setResolved(Boolean resolved) {
				this.resolved = resolved;
			}
			
			@JsonProperty
			public org.joda.time.DateTime getCreatedDateTime() {
				return this.createdDateTime;
			}
			public void setCreatedDateTime(org.joda.time.DateTime createdDateTime) {
				this.createdDateTime = createdDateTime;
			}
			
			@JsonProperty
			public org.joda.time.DateTime getUpdatedDateTime() {
				return this.updatedDateTime;
			}
			public void setUpdatedDateTime(org.joda.time.DateTime updatedDateTime) {
				this.updatedDateTime = updatedDateTime;
			}
			
			@JsonProperty
			public String getServerVersion() {
				return this.serverVersion;
			}
			public void setServerVersion(String serverVersion) {
				this.serverVersion = serverVersion;
			}
			
			@JsonProperty
			public String getClientVersion() {
				return this.clientVersion;
			}
			public void setClientVersion(String clientVersion) {
				this.clientVersion = clientVersion;
			}
			
			@JsonProperty
			public String getDevice() {
				return this.device;
			}
			public void setDevice(String device) {
				this.device = device;
			}
			
		
				
		}
		
		/*       S.D.G.       */
		
	'''
	
	def generateIBugModel() '''
		package com.anfelisa.ace.bug;

		import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
		
		@JsonDeserialize(as=BugModel.class)
		public interface IBugModel {
		
			Integer getId();
			String getDescription();
			String getTimeline();
			String getReporter();
			Boolean getResolved();
			org.joda.time.DateTime getCreatedDateTime();
			org.joda.time.DateTime getUpdatedDateTime();
			String getServerVersion();
			String getClientVersion();
			String getDevice();
		
		
		}
		
		/*       S.D.G.       */
		
	'''
	
	def generateIScenarioModel() '''
		package com.anfelisa.ace.scenario;
		
		import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
		
		@JsonDeserialize(as=ScenarioModel.class)
		public interface IScenarioModel {
		
			Integer getId();
			String getDescription();
			String getTimeline();
			String getCreator();
			org.joda.time.DateTime getCreatedDateTime();
			org.joda.time.DateTime getUpdatedDateTime();
			String getServerVersion();
			String getClientVersion();
			String getDevice();
		
		
		}
		
		/*       S.D.G.       */

	'''
	
	def generateScenarioModel() '''
		package com.anfelisa.ace.scenario;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		import javax.validation.constraints.NotNull;
		import org.hibernate.validator.constraints.NotEmpty;
		
		@SuppressWarnings("all")
		public class ScenarioModel implements IScenarioModel {
		
			private Integer id;
			
			private String description;
			
			@NotNull
			private String timeline;
			
			private String creator;
			
			private org.joda.time.DateTime createdDateTime;
			
			private org.joda.time.DateTime updatedDateTime;
			
			private String serverVersion;
			
			private String clientVersion;
			
			private String device;
			
		
		
			public ScenarioModel(
				@JsonProperty("id") Integer id,
				@JsonProperty("description") String description,
				@JsonProperty("timeline") String timeline,
				@JsonProperty("creator") String creator,
				@JsonProperty("createdDateTime") org.joda.time.DateTime createdDateTime,
				@JsonProperty("updatedDateTime") org.joda.time.DateTime updatedDateTime,
				@JsonProperty("serverVersion") String serverVersion,
				@JsonProperty("clientVersion") String clientVersion,
				@JsonProperty("device") String device
			) {
				this.id = id;
				this.description = description;
				this.timeline = timeline;
				this.creator = creator;
				this.createdDateTime = createdDateTime;
				this.updatedDateTime = updatedDateTime;
				this.serverVersion = serverVersion;
				this.clientVersion = clientVersion;
				this.device = device;
			}
		
			@JsonProperty
			public Integer getId() {
				return this.id;
			}
			public void setId(Integer id) {
				this.id = id;
			}
			
			@JsonProperty
			public String getDescription() {
				return this.description;
			}
			public void setDescription(String description) {
				this.description = description;
			}
			
			@JsonProperty
			public String getTimeline() {
				return this.timeline;
			}
			public void setTimeline(String timeline) {
				this.timeline = timeline;
			}
			
			@JsonProperty
			public String getCreator() {
				return this.creator;
			}
			public void setCreator(String creator) {
				this.creator = creator;
			}
			
			@JsonProperty
			public org.joda.time.DateTime getCreatedDateTime() {
				return this.createdDateTime;
			}
			public void setCreatedDateTime(org.joda.time.DateTime createdDateTime) {
				this.createdDateTime = createdDateTime;
			}
			
			@JsonProperty
			public org.joda.time.DateTime getUpdatedDateTime() {
				return this.updatedDateTime;
			}
			public void setUpdatedDateTime(org.joda.time.DateTime updatedDateTime) {
				this.updatedDateTime = updatedDateTime;
			}
			
			@JsonProperty
			public String getServerVersion() {
				return this.serverVersion;
			}
			public void setServerVersion(String serverVersion) {
				this.serverVersion = serverVersion;
			}
			
			@JsonProperty
			public String getClientVersion() {
				return this.clientVersion;
			}
			public void setClientVersion(String clientVersion) {
				this.clientVersion = clientVersion;
			}
			
			@JsonProperty
			public String getDevice() {
				return this.device;
			}
			public void setDevice(String device) {
				this.device = device;
			}
			
		
				
		}
		
		/*       S.D.G.       */
		
		
	'''
	
	def generateScenarioDao() '''
		package com.anfelisa.ace.scenario;
		
		import org.skife.jdbi.v2.Handle;
		import org.skife.jdbi.v2.Query;
		import org.skife.jdbi.v2.Update;
		
		import java.util.List;
		import java.util.Map;
		
		import com.fasterxml.jackson.annotation.JsonIgnoreType;
		
		import com.anfelisa.ace.encryption.EncryptionService;
		
		@SuppressWarnings("all")
		@JsonIgnoreType
		public class ScenarioDao {
			
			public Integer insert(Handle handle, IScenarioModel scenarioModel) {
				Query<Map<String, Object>> statement = handle.createQuery("INSERT INTO public.scenario (description, timeline, creator, createddatetime, updateddatetime, serverversion, clientversion, device) VALUES (:description, :timeline, :creator, :createddatetime, :updateddatetime, :serverversion, :clientversion, :device) RETURNING id");
				statement.bind("description",  scenarioModel.getDescription() );
				statement.bind("timeline",  scenarioModel.getTimeline() );
				statement.bind("creator",  scenarioModel.getCreator() );
				statement.bind("createddatetime",  scenarioModel.getCreatedDateTime() );
				statement.bind("updateddatetime",  scenarioModel.getUpdatedDateTime() );
				statement.bind("serverversion",  scenarioModel.getServerVersion() );
				statement.bind("clientversion",  scenarioModel.getClientVersion() );
				statement.bind("device",  scenarioModel.getDevice() );
				Map<String, Object> first = statement.first();
				return (Integer) first.get("id");
			}
			
			
			public void updateById(Handle handle, IScenarioModel scenarioModel) {
				Update statement = handle.createStatement("UPDATE public.scenario SET description = :description, timeline = :timeline, creator = :creator, createddatetime = :createddatetime, updateddatetime = :updateddatetime, serverversion = :serverversion, clientversion = :clientversion, device = :device WHERE id = :id");
				statement.bind("description",  scenarioModel.getDescription() );
				statement.bind("timeline",  scenarioModel.getTimeline() );
				statement.bind("creator",  scenarioModel.getCreator() );
				statement.bind("createddatetime",  scenarioModel.getCreatedDateTime() );
				statement.bind("updateddatetime",  scenarioModel.getUpdatedDateTime() );
				statement.bind("serverversion",  scenarioModel.getServerVersion() );
				statement.bind("clientversion",  scenarioModel.getClientVersion() );
				statement.bind("device",  scenarioModel.getDevice() );
				statement.bind("id",  scenarioModel.getId()  );
				statement.execute();
			}
		
			public void deleteById(Handle handle, Integer id) {
				Update statement = handle.createStatement("DELETE FROM public.scenario WHERE id = :id");
				statement.bind("id", id);
				statement.execute();
			}
		
			public IScenarioModel selectById(Handle handle, Integer id) {
				return handle.createQuery("SELECT id, description, timeline, creator, createddatetime, updateddatetime, serverversion, clientversion, device FROM public.scenario WHERE id = :id")
					.bind("id", id)
					.map(new ScenarioMapper())
					.first();
			}
			
			public List<IScenarioModel> selectAll(Handle handle) {
				return handle.createQuery("SELECT id, description, timeline, creator, createddatetime, updateddatetime, serverversion, clientversion, device FROM public.scenario")
					.map(new ScenarioMapper())
					.list();
			}
		
			public void truncate(Handle handle) {
				Update statement = handle.createStatement("TRUNCATE public.scenario");
				statement.execute();
				statement = handle.createStatement("ALTER SEQUENCE public.scenario_id_seq RESTART");
				statement.execute();
			}
		
		}
		
		/*       S.D.G.       */
		
	'''
	
	def generateScenarioMapper() '''
		package com.anfelisa.ace.scenario;
		
		import java.sql.ResultSet;
		import java.sql.SQLException;
		
		import org.skife.jdbi.v2.StatementContext;
		import org.skife.jdbi.v2.tweak.ResultSetMapper;
		
		import com.anfelisa.ace.encryption.EncryptionService;
		
		@SuppressWarnings("all")
		public class ScenarioMapper implements ResultSetMapper<IScenarioModel> {
			
			public IScenarioModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
				return new ScenarioModel(
					r.getInt("id"),
					r.getString("description"),
					r.getString("timeline"),
					r.getString("creator"),
					r.getTimestamp("createdDateTime") != null ? new org.joda.time.DateTime(r.getTimestamp("createdDateTime")) : null,
					r.getTimestamp("updatedDateTime") != null ? new org.joda.time.DateTime(r.getTimestamp("updatedDateTime")) : null,
					r.getString("serverVersion"),
					r.getString("clientVersion"),
					r.getString("device")
				);
			}
		}
		
		/*       S.D.G.       */
		
	'''
	
	def generateIScenarioResultModel() '''
		package com.anfelisa.ace.scenario;

		import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
		
		@JsonDeserialize(as=ScenarioResultModel.class)
		public interface IScenarioResultModel {
		
			Integer getId();
			Integer getScenarioId();
			String getDescription();
			String getTimeline();
			String getExecutor();
			org.joda.time.DateTime getCreatedDateTime();
			String getServerVersion();
			String getClientVersion();
			String getDevice();
			Boolean getResult();
			Boolean getE2E();
		
		
		}
		
		/*       S.D.G.       */
		
	'''
	
	def generateScenarioResultModel() '''
		package com.anfelisa.ace.scenario;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		import javax.validation.constraints.NotNull;
		import org.hibernate.validator.constraints.NotEmpty;
		
		@SuppressWarnings("all")
		public class ScenarioResultModel implements IScenarioResultModel {
		
			@NotNull
			private Integer id;
			
			@NotNull
			private Integer scenarioId;
			
			@NotNull
			private String description;
			
			@NotNull
			private String timeline;
			
			@NotNull
			private String executor;
			
			private org.joda.time.DateTime createdDateTime;
			
			@NotNull
			private String serverVersion;
			
			@NotNull
			private String clientVersion;
			
			@NotNull
			private String device;
			
			@NotNull
			private Boolean result;
		
			@NotNull
			private Boolean e2e;
		
			public ScenarioResultModel(
				@JsonProperty("id") Integer id,
				@JsonProperty("scenarioId") Integer scenarioId,
				@JsonProperty("description") String description,
				@JsonProperty("timeline") String timeline,
				@JsonProperty("executor") String executor,
				@JsonProperty("createdDateTime") org.joda.time.DateTime createdDateTime,
				@JsonProperty("serverVersion") String serverVersion,
				@JsonProperty("clientVersion") String clientVersion,
				@JsonProperty("device") String device,
				@JsonProperty("result") Boolean result,
				@JsonProperty("e2e") Boolean e2e
			) {
				this.id = id;
				this.scenarioId = scenarioId;
				this.description = description;
				this.timeline = timeline;
				this.executor = executor;
				this.createdDateTime = createdDateTime;
				this.serverVersion = serverVersion;
				this.clientVersion = clientVersion;
				this.device = device;
				this.result = result;
				this.e2e = e2e;
			}
		
			@JsonProperty
			public Integer getId() {
				return this.id;
			}
			public void setId(Integer id) {
				this.id = id;
			}
			
			@JsonProperty
			public Integer getScenarioId() {
				return this.scenarioId;
			}
			public void setScenarioId(Integer scenarioId) {
				this.scenarioId = scenarioId;
			}
			
			@JsonProperty
			public String getDescription() {
				return this.description;
			}
			public void setDescription(String description) {
				this.description = description;
			}
			
			@JsonProperty
			public String getTimeline() {
				return this.timeline;
			}
			public void setTimeline(String timeline) {
				this.timeline = timeline;
			}
			
			@JsonProperty
			public String getExecutor() {
				return this.executor;
			}
			public void setExecutor(String executor) {
				this.executor = executor;
			}
			
			@JsonProperty
			public org.joda.time.DateTime getCreatedDateTime() {
				return this.createdDateTime;
			}
			public void setCreatedDateTime(org.joda.time.DateTime createdDateTime) {
				this.createdDateTime = createdDateTime;
			}
			
			@JsonProperty
			public String getServerVersion() {
				return this.serverVersion;
			}
			public void setServerVersion(String serverVersion) {
				this.serverVersion = serverVersion;
			}
			
			@JsonProperty
			public String getClientVersion() {
				return this.clientVersion;
			}
			public void setClientVersion(String clientVersion) {
				this.clientVersion = clientVersion;
			}
			
			@JsonProperty
			public String getDevice() {
				return this.device;
			}
			public void setDevice(String device) {
				this.device = device;
			}
			
			@JsonProperty
			public Boolean getResult() {
				return this.result;
			}
			public void setResult(Boolean result) {
				this.result = result;
			}
			
			@JsonProperty
			public Boolean getE2E() {
				return this.e2e;
			}
			public void setE2E(Boolean e2e) {
				this.e2e = e2e;
			}
			
		}
		
		/*       S.D.G.       */
		
	'''
	
	def generateScenarioResultDao() '''
		package com.anfelisa.ace.scenario;
		
		import org.skife.jdbi.v2.Handle;
		import org.skife.jdbi.v2.Query;
		import org.skife.jdbi.v2.Update;
		
		import java.util.List;
		import java.util.Map;
		
		import com.fasterxml.jackson.annotation.JsonIgnoreType;
		
		import com.anfelisa.ace.encryption.EncryptionService;
		
		@SuppressWarnings("all")
		@JsonIgnoreType
		public class ScenarioResultDao {
			
			public Integer insert(Handle handle, IScenarioResultModel scenarioResultModel) {
				Query<Map<String, Object>> statement = handle.createQuery("INSERT INTO public.scenarioresult (scenarioid, description, timeline, executor, createddatetime, serverversion, clientversion, device, result, e2e) VALUES (:scenarioid, :description, :timeline, :executor, :createddatetime, :serverversion, :clientversion, :device, :result, :e2e) RETURNING id");
				statement.bind("scenarioid",  scenarioResultModel.getScenarioId() );
				statement.bind("description",  scenarioResultModel.getDescription() );
				statement.bind("timeline",  scenarioResultModel.getTimeline() );
				statement.bind("executor",  scenarioResultModel.getExecutor() );
				statement.bind("createddatetime",  scenarioResultModel.getCreatedDateTime() );
				statement.bind("serverversion",  scenarioResultModel.getServerVersion() );
				statement.bind("clientversion",  scenarioResultModel.getClientVersion() );
				statement.bind("device",  scenarioResultModel.getDevice() );
				statement.bind("result",  scenarioResultModel.getResult() );
				statement.bind("e2e",  scenarioResultModel.getE2E() );
				Map<String, Object> first = statement.first();
				return (Integer) first.get("id");
			}
			
			
			public void updateById(Handle handle, IScenarioResultModel scenarioResultModel) {
				Update statement = handle.createStatement("UPDATE public.scenarioresult SET scenarioid = :scenarioid, description = :description, timeline = :timeline, executor = :executor, createddatetime = :createddatetime, serverversion = :serverversion, clientversion = :clientversion, device = :device, result = :result, e2e = :e2e WHERE id = :id");
				statement.bind("scenarioid",  scenarioResultModel.getScenarioId() );
				statement.bind("description",  scenarioResultModel.getDescription() );
				statement.bind("timeline",  scenarioResultModel.getTimeline() );
				statement.bind("executor",  scenarioResultModel.getExecutor() );
				statement.bind("createddatetime",  scenarioResultModel.getCreatedDateTime() );
				statement.bind("serverversion",  scenarioResultModel.getServerVersion() );
				statement.bind("clientversion",  scenarioResultModel.getClientVersion() );
				statement.bind("device",  scenarioResultModel.getDevice() );
				statement.bind("result",  scenarioResultModel.getResult()  );
				statement.bind("e2e",  scenarioResultModel.getE2E()  );
				statement.bind("id",  scenarioResultModel.getId()  );
				statement.execute();
			}
		
			public void deleteById(Handle handle, Integer id) {
				Update statement = handle.createStatement("DELETE FROM public.scenarioresult WHERE id = :id");
				statement.bind("id", id);
				statement.execute();
			}
		
			public IScenarioResultModel selectById(Handle handle, Integer id) {
				return handle.createQuery("SELECT id, scenarioid, description, timeline, executor, createddatetime, serverversion, clientversion, device, result, e2e FROM public.scenarioresult WHERE id = :id")
					.bind("id", id)
					.map(new ScenarioResultMapper())
					.first();
			}
			
			public List<IScenarioResultModel> selectAll(Handle handle) {
				return handle.createQuery("SELECT id, scenarioid, description, timeline, executor, createddatetime, serverversion, clientversion, device, result, e2e FROM public.scenarioresult")
					.map(new ScenarioResultMapper())
					.list();
			}
		
			public void truncate(Handle handle) {
				Update statement = handle.createStatement("TRUNCATE public.scenarioresult");
				statement.execute();
				statement = handle.createStatement("ALTER SEQUENCE public.scenarioresult_id_seq RESTART");
				statement.execute();
			}
		
		}
		
		/*       S.D.G.       */
		
	'''
	
	def generateScenarioResultMapper() '''
		package com.anfelisa.ace.scenario;
		
		import java.sql.ResultSet;
		import java.sql.SQLException;
		
		import org.skife.jdbi.v2.StatementContext;
		import org.skife.jdbi.v2.tweak.ResultSetMapper;
		
		import com.anfelisa.ace.encryption.EncryptionService;
		
		@SuppressWarnings("all")
		public class ScenarioResultMapper implements ResultSetMapper<IScenarioResultModel> {
			
			public IScenarioResultModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
				return new ScenarioResultModel(
					r.getInt("id"),
					r.getInt("scenarioId"),
					r.getString("description"),
					r.getString("timeline"),
					r.getString("executor"),
					r.getTimestamp("createdDateTime") != null ? new org.joda.time.DateTime(r.getTimestamp("createdDateTime")) : null,
					r.getString("serverVersion"),
					r.getString("clientVersion"),
					r.getString("device"),
					r.getBoolean("result"),
					r.getBoolean("e2e")
				);
			}
		}
		
		/*       S.D.G.       */
				
	'''
	
	def generateCreateBugResource() '''
		package com.anfelisa.ace.bug;
		
		import javax.validation.constraints.NotNull;
		import javax.ws.rs.Consumes;
		import javax.ws.rs.POST;
		import javax.ws.rs.Path;
		import javax.ws.rs.Produces;
		import javax.ws.rs.WebApplicationException;
		import javax.ws.rs.core.MediaType;
		import javax.ws.rs.core.Response;
		
		import org.joda.time.DateTime;
		import org.skife.jdbi.v2.DBI;
		import org.skife.jdbi.v2.Handle;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import com.anfelisa.ace.App;
		import com.codahale.metrics.annotation.Timed;
		import com.fasterxml.jackson.core.JsonProcessingException;
		
		@Path("/bug")
		@Produces(MediaType.TEXT_PLAIN)
		@Consumes(MediaType.APPLICATION_JSON)
		public class CreateBugResource {
			static final Logger LOG = LoggerFactory.getLogger(CreateBugResource.class);
		
			private DBI jdbi;
		
			private BugDao bugDao = new BugDao();
		
			public CreateBugResource(DBI jdbi) {
				super();
				this.jdbi = jdbi;
			}
		
			@POST
			@Timed
			@Path("/create")
			// We might want to protect this resource!
			public Response post(@NotNull BugModel data) throws JsonProcessingException {
				Handle handle = jdbi.open();
				try {
					data.setCreatedDateTime(new DateTime());
					data.setResolved(false);
					if (data.getClientVersion() == null) {
						data.setClientVersion("unknown");
					}
					if (data.getReporter() == null) {
						data.setReporter("unknown");
					}
					if (data.getDescription() == null) {
						data.setDescription("unknown");
					}
					if (data.getDevice() == null) {
						data.setDevice("unknown");
					}
					data.setServerVersion(App.getVersion());
					Integer id = bugDao.insert(handle, data);
					return Response.ok(id).build();
				} catch (Exception e) {
					throw new WebApplicationException(e);
				} finally {
					handle.close();
				}
			}
		
		}
		
		/* S.D.G. */
		
	'''
	
	def generateDeleteBugResource() '''
		package com.anfelisa.ace.bug;
		
		import javax.validation.constraints.NotNull;
		import javax.ws.rs.Consumes;
		import javax.ws.rs.DELETE;
		import javax.ws.rs.Path;
		import javax.ws.rs.Produces;
		import javax.ws.rs.QueryParam;
		import javax.ws.rs.WebApplicationException;
		import javax.ws.rs.core.MediaType;
		import javax.ws.rs.core.Response;
		
		import org.skife.jdbi.v2.DBI;
		import org.skife.jdbi.v2.Handle;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import com.codahale.metrics.annotation.Timed;
		import com.fasterxml.jackson.core.JsonProcessingException;
		
		@Path("/bug")
		@Produces(MediaType.TEXT_PLAIN)
		@Consumes(MediaType.APPLICATION_JSON)
		public class DeleteBugResource {
			static final Logger LOG = LoggerFactory.getLogger(DeleteBugResource.class);
		
			private DBI jdbi;
			
			private BugDao bugDao = new BugDao();
		
			public DeleteBugResource(DBI jdbi) {
				super();
				this.jdbi = jdbi;
			}
		
			@DELETE
			@Timed
			@Path("/delete")
			// We should protect this resource!
			public Response delete(@NotNull @QueryParam("id") int id) throws JsonProcessingException {
				Handle handle = jdbi.open();
				try {
					IBugModel bug = bugDao.selectById(handle, id);
					if (bug == null) {
						throw new WebApplicationException(Response.Status.BAD_REQUEST);
					}
					bugDao.deleteById(handle, id);
					return Response.ok().build();
				} catch (Exception e) {
					throw new WebApplicationException(e);
				} finally {
					handle.close();
				}
			}
		
		}
		
		/* S.D.G. */
		
	'''
	
	def generateGetAllBugsResource() '''
		package com.anfelisa.ace.bug;
		
		import java.util.List;
		
		import javax.ws.rs.Consumes;
		import javax.ws.rs.GET;
		import javax.ws.rs.Path;
		import javax.ws.rs.Produces;
		import javax.ws.rs.WebApplicationException;
		import javax.ws.rs.core.MediaType;
		import javax.ws.rs.core.Response;
		
		import org.skife.jdbi.v2.DBI;
		import org.skife.jdbi.v2.Handle;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import com.codahale.metrics.annotation.Timed;
		import com.fasterxml.jackson.core.JsonProcessingException;
		
		@Path("/bug")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public class GetAllBugsResource {
			static final Logger LOG = LoggerFactory.getLogger(GetAllBugsResource.class);
		
			private DBI jdbi;
		
			private BugDao bugDao = new BugDao();
		
			public GetAllBugsResource(DBI jdbi) {
				super();
				this.jdbi = jdbi;
			}
		
			@GET
			@Timed
			@Path("/all")
			// We should protect this resource!
			public Response get() throws JsonProcessingException {
				Handle handle = jdbi.open();
				try {
					List<IBugModel> bugs = bugDao.selectAll(handle);
					return Response.ok(bugs).build();
				} catch (Exception e) {
					throw new WebApplicationException(e);
				} finally {
					handle.close();
				}
			}
		
		}
		
		/* S.D.G. */
		
	'''
	
	def generateResolveBugResource() '''
		package com.anfelisa.ace.bug;
		
		import javax.validation.constraints.NotNull;
		import javax.ws.rs.Consumes;
		import javax.ws.rs.DELETE;
		import javax.ws.rs.Path;
		import javax.ws.rs.Produces;
		import javax.ws.rs.QueryParam;
		import javax.ws.rs.WebApplicationException;
		import javax.ws.rs.core.MediaType;
		import javax.ws.rs.core.Response;
		
		import org.joda.time.DateTime;
		import org.skife.jdbi.v2.DBI;
		import org.skife.jdbi.v2.Handle;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import com.codahale.metrics.annotation.Timed;
		import com.fasterxml.jackson.core.JsonProcessingException;
		
		@Path("/bug")
		@Produces(MediaType.TEXT_PLAIN)
		@Consumes(MediaType.APPLICATION_JSON)
		public class ResolveBugResource {
			static final Logger LOG = LoggerFactory.getLogger(ResolveBugResource.class);
		
			private DBI jdbi;
			
			private BugDao bugDao = new BugDao();
		
			public ResolveBugResource(DBI jdbi) {
				super();
				this.jdbi = jdbi;
			}
		
			@DELETE
			@Timed
			@Path("/resolve")
			// We should protect this resource!
			public Response delete(@NotNull @QueryParam("id") int id) throws JsonProcessingException {
				Handle handle = jdbi.open();
				try {
					IBugModel bug = bugDao.selectById(handle, id);
					if (bug == null) {
						throw new WebApplicationException(Response.Status.BAD_REQUEST);
					}
					bugDao.updateResolvedById(handle, id, new DateTime());
					return Response.ok().build();
				} catch (Exception e) {
					throw new WebApplicationException(e);
				} finally {
					handle.close();
				}
			}
		
		}
		
		/* S.D.G. */
		
	'''
	
	def generateCreateScenarioResource() '''
		package com.anfelisa.ace.scenario;
		
		import javax.validation.constraints.NotNull;
		import javax.ws.rs.Consumes;
		import javax.ws.rs.POST;
		import javax.ws.rs.Path;
		import javax.ws.rs.Produces;
		import javax.ws.rs.WebApplicationException;
		import javax.ws.rs.core.MediaType;
		import javax.ws.rs.core.Response;
		
		import org.joda.time.DateTime;
		import org.skife.jdbi.v2.DBI;
		import org.skife.jdbi.v2.Handle;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import com.anfelisa.ace.App;
		import com.codahale.metrics.annotation.Timed;
		import com.fasterxml.jackson.core.JsonProcessingException;
		
		@Path("/scenario")
		@Produces(MediaType.TEXT_PLAIN)
		@Consumes(MediaType.APPLICATION_JSON)
		public class CreateScenarioResource {
			static final Logger LOG = LoggerFactory.getLogger(CreateScenarioResource.class);
		
			private DBI jdbi;
		
			private ScenarioDao scenarioDao = new ScenarioDao();
		
			public CreateScenarioResource(DBI jdbi) {
				super();
				this.jdbi = jdbi;
			}
		
			@POST
			@Timed
			@Path("/create")
			// We should protect this resource!
			public Response post(@NotNull ScenarioModel data) throws JsonProcessingException {
				Handle handle = jdbi.open();
				try {
					data.setCreatedDateTime(new DateTime());
					if (data.getClientVersion() == null) {
						data.setClientVersion("unknown");
					}
					if (data.getCreator() == null) {
						data.setCreator("unknown");
					}
					if (data.getDescription() == null) {
						data.setDescription("unknown");
					}
					if (data.getDevice() == null) {
						data.setDevice("unknown");
					}
					data.setServerVersion(App.getVersion());
					Integer id = scenarioDao.insert(handle, data);
					return Response.ok(id).build();
				} catch (Exception e) {
					throw new WebApplicationException(e);
				} finally {
					handle.close();
				}
			}
		
		}
		
		/* S.D.G. */
		
	'''
	
	def generateDeleteScenarioResource() '''
		package com.anfelisa.ace.scenario;
		
		import javax.validation.constraints.NotNull;
		import javax.ws.rs.Consumes;
		import javax.ws.rs.DELETE;
		import javax.ws.rs.Path;
		import javax.ws.rs.Produces;
		import javax.ws.rs.QueryParam;
		import javax.ws.rs.WebApplicationException;
		import javax.ws.rs.core.MediaType;
		import javax.ws.rs.core.Response;
		
		import org.skife.jdbi.v2.DBI;
		import org.skife.jdbi.v2.Handle;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import com.codahale.metrics.annotation.Timed;
		import com.fasterxml.jackson.core.JsonProcessingException;
		
		@Path("/scenario")
		@Produces(MediaType.TEXT_PLAIN)
		@Consumes(MediaType.APPLICATION_JSON)
		public class DeleteScenarioResource {
			static final Logger LOG = LoggerFactory.getLogger(DeleteScenarioResource.class);
		
			private DBI jdbi;
			
			private ScenarioDao scenarioDao = new ScenarioDao();
		
			public DeleteScenarioResource(DBI jdbi) {
				super();
				this.jdbi = jdbi;
			}
		
			@DELETE
			@Timed
			@Path("/delete")
			// We should protect this resource!
			public Response delete(@NotNull @QueryParam("id") int id) throws JsonProcessingException {
				Handle handle = jdbi.open();
				try {
					IScenarioModel scenario = scenarioDao.selectById(handle, id);
					if (scenario == null) {
						throw new WebApplicationException(Response.Status.BAD_REQUEST);
					}
					scenarioDao.deleteById(handle, id);
					return Response.ok().build();
				} catch (Exception e) {
					throw new WebApplicationException(e);
				} finally {
					handle.close();
				}
			}
		
		}
		
		/* S.D.G. */
		
	'''
	
	def generateGetAllScenariosResource() '''
		package com.anfelisa.ace.scenario;
		
		import java.util.List;
		
		import javax.ws.rs.Consumes;
		import javax.ws.rs.GET;
		import javax.ws.rs.Path;
		import javax.ws.rs.Produces;
		import javax.ws.rs.WebApplicationException;
		import javax.ws.rs.core.MediaType;
		import javax.ws.rs.core.Response;
		
		import org.skife.jdbi.v2.DBI;
		import org.skife.jdbi.v2.Handle;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import com.codahale.metrics.annotation.Timed;
		import com.fasterxml.jackson.core.JsonProcessingException;
		
		@Path("/scenario")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public class GetAllScenariosResource {
			static final Logger LOG = LoggerFactory.getLogger(GetAllScenariosResource.class);
		
			private DBI jdbi;
		
			private ScenarioDao scenarioDao = new ScenarioDao();
		
			public GetAllScenariosResource(DBI jdbi) {
				super();
				this.jdbi = jdbi;
			}
		
			@GET
			@Timed
			@Path("/all")
			// We should protect this resource!
			public Response get() throws JsonProcessingException {
				Handle handle = jdbi.open();
				try {
					List<IScenarioModel> scenarios = scenarioDao.selectAll(handle);
					return Response.ok(scenarios).build();
				} catch (Exception e) {
					throw new WebApplicationException(e);
				} finally {
					handle.close();
				}
			}
		
		}
		
		/* S.D.G. */
		
	'''
	
	def generateGetScenarioResource() '''
		package com.anfelisa.ace.scenario;
		
		import javax.validation.constraints.NotNull;
		import javax.ws.rs.Consumes;
		import javax.ws.rs.GET;
		import javax.ws.rs.Path;
		import javax.ws.rs.Produces;
		import javax.ws.rs.QueryParam;
		import javax.ws.rs.WebApplicationException;
		import javax.ws.rs.core.MediaType;
		import javax.ws.rs.core.Response;
		
		import org.skife.jdbi.v2.DBI;
		import org.skife.jdbi.v2.Handle;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import com.codahale.metrics.annotation.Timed;
		import com.fasterxml.jackson.core.JsonProcessingException;
		
		@Path("/scenario")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public class GetScenarioResource {
			static final Logger LOG = LoggerFactory.getLogger(GetScenarioResource.class);
		
			private DBI jdbi;
		
			private ScenarioDao scenarioDao = new ScenarioDao();
		
			public GetScenarioResource(DBI jdbi) {
				super();
				this.jdbi = jdbi;
			}
		
			@GET
			@Timed
			@Path("/all")
			// We should protect this resource!
			public Response get(@NotNull @QueryParam("id") int id) throws JsonProcessingException {
				Handle handle = jdbi.open();
				try {
					IScenarioModel scenario = scenarioDao.selectById(handle, id);
					return Response.ok(scenario).build();
				} catch (Exception e) {
					throw new WebApplicationException(e);
				} finally {
					handle.close();
				}
			}
		
		}
		
		/* S.D.G. */
		
	'''
	
}