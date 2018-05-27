package com.anfelisa.generator

import com.anfelisa.ace.ACE
import com.anfelisa.ace.Attribute
import com.anfelisa.ace.Data
import com.anfelisa.ace.Model
import com.anfelisa.ace.Outcome
import com.anfelisa.ace.Project
import com.anfelisa.ace.View
import com.anfelisa.ace.ViewFunction
import com.anfelisa.extensions.AceExtension
import com.anfelisa.extensions.AttributeExtension
import com.anfelisa.extensions.DataExtension
import com.anfelisa.extensions.ModelExtension
import com.anfelisa.extensions.ProjectExtension
import com.anfelisa.extensions.ViewExtension
import javax.inject.Inject

class JavaTemplate {
	
	@Inject
	extension ProjectExtension

	@Inject
	extension AceExtension

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
		
		import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
		
		@JsonDeserialize(as=«modelClassName».class)
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

		@SuppressWarnings("all")
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
		
		import javax.validation.constraints.NotNull;
		import org.hibernate.validator.constraints.NotEmpty;
		import org.joda.time.DateTime;
		import java.util.List;
		
		import com.anfelisa.ace.AbstractData;
		
		public class «dataName» extends AbstractData implements «dataInterfaceName» {
			
			«FOR attribute : allAttributes»
				«attribute.declaration»
				
			«ENDFOR»
		
			public «dataName»(
				«FOR attribute : allAttributes SEPARATOR ',' AFTER ','»
					«attribute.param»
				«ENDFOR»
				@JsonProperty("uuid") String uuid
			) {
				super(uuid);
				«FOR attribute : allAttributes»
					«attribute.assign»
				«ENDFOR»
			}
		
			«IF allAttributes.length > 0»
				public «dataName»( String uuid ) {
					super(uuid);
				}
			«ENDIF»
		
			«FOR attribute : allAttributes»
				«attribute.getter»
				«attribute.setter»
				«attribute.initializer(dataName)»
				
			«ENDFOR»
		
			@Override
			public Object toPresentationalData() {
				return new «presentationalDataName»(
					«FOR attribute : allAttributes SEPARATOR ','»
						this.«attribute.name»
					«ENDFOR»
				);
			}

		}
		
		/*       S.D.G.       */
	'''
	
	def generateAbstractData() '''
		package com.anfelisa.ace;
		
		import org.joda.time.DateTime;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		
		public abstract class AbstractData implements IDataContainer {
		
			private String uuid;
			
			private String outcome;
			
			private String[] notifiedListeners;
		
			private org.joda.time.DateTime systemTime;
			
			public AbstractData(String uuid, String outcome, String[] notifiedListeners, DateTime systemTime) {
				super();
				this.uuid = uuid;
				this.outcome = outcome;
				this.notifiedListeners = notifiedListeners;
				this.systemTime = systemTime;
			}
		
			public AbstractData( String uuid ) {
				this.uuid = uuid;
			}
		
			@JsonProperty
			public String getUuid() {
				return this.uuid;
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
		
			@Override
			@JsonProperty
			public String[] getNotifiedListeners() {
				return notifiedListeners;
			}
		
			@Override
			@JsonProperty
			public void setNotifiedListeners(String[] listeners) {
				this.notifiedListeners = listeners;
			}
		
		}
		
		/*       S.D.G.       */
	'''
	
	def generatePresentationalData(Data it, Project project) '''
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
		public class «presentationalDataName» implements «presentationalDataInterfaceName» {
			
			«FOR attribute : allAttributes»
				«attribute.declaration»
				
			«ENDFOR»
			
			public «presentationalDataName»(
				«FOR attribute : allAttributes SEPARATOR ','»
					«attribute.param»
				«ENDFOR»
			) {
				«FOR attribute : allAttributes»
					«attribute.assign»
				«ENDFOR»
				
			}
		
			«FOR attribute : allAttributes»
				«attribute.getter»
				«attribute.setter»
				«attribute.initializer(presentationalDataName)»
				
			«ENDFOR»
		}
		
		/*       S.D.G.       */
	'''
	
	def generatePresentationalInterfaceData(Data it, Project project) '''
		package «project.name».data;
		
		«FOR model : models»
			«model.model.importModel»
		«ENDFOR»
		
		public interface «presentationalDataInterfaceName» «IF models.size > 0»extends «FOR modelRef : models SEPARATOR ', '»«modelRef.model.modelName»«ENDFOR»«ENDIF» {
		
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
			
			public void insert(Handle handle, «modelName» «modelParam») {
				Update statement = handle.createStatement("INSERT INTO «project.schema».«table» («FOR attribute : attributes SEPARATOR ', '»«attribute.name.toLowerCase»«ENDFOR») VALUES («FOR attribute : attributes SEPARATOR ', '»«modelAttributeSqlValue(project, attribute)»«ENDFOR»)");
				«FOR attribute : attributes»
					statement.bind("«attribute.name.toLowerCase»", «modelGetAttribute(attribute)»);
				«ENDFOR»
				statement.execute();
			}
			
			
			«FOR attribute : allUniqueAttributes»
				public void updateBy«attribute.name.toFirstUpper»(Handle handle, «modelName» «modelParam») {
					Update statement = handle.createStatement("UPDATE «project.schema».«table» SET «FOR attr : attributes SEPARATOR ', '»«attr.name.toLowerCase» = :«attr.name.toLowerCase»«ENDFOR» WHERE «attribute.name.toLowerCase» = :«attribute.name.toLowerCase»");
					«FOR attr : attributes»
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
			}

		}
		
		/*       S.D.G.       */
	'''
	
	def generateMigration(Model it, Project project) '''
		<createTable tableName="«table»">
			«FOR attribute : attributes»
				<column name="«attribute.name.toLowerCase»" type="«attribute.sqlType»">
					<constraints «IF attribute.isPrimaryKey»primaryKey="true"«ENDIF» «IF attribute.constraint !== null && attribute.constraint.equals('NotNull')»nullable="false"«ENDIF» «IF attribute.foreignKey !== null»	references="«(attribute.foreignKey.eContainer as Attribute).tableName»(«attribute.foreignKey.name.toLowerCase»)" deleteCascade="true" foreignKeyName="fk_«table»_«attribute.foreignKey.name.toLowerCase»"«ENDIF» />
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
	
	def generateAbstractActionFile(ACE it, Project project) '''
		package «project.name».actions;
		
		import org.skife.jdbi.v2.DBI;
		import javax.ws.rs.WebApplicationException;

		import com.anfelisa.ace.Action;
		import com.anfelisa.ace.CustomAppConfiguration;
		import com.anfelisa.ace.IDaoProvider;
		import com.anfelisa.ace.ViewProvider;
		import com.anfelisa.ace.HttpMethod;
		import com.anfelisa.ace.ICommand;
		«data.dataImport»
		
		«IF outcomes.size > 0»
			import «project.name».commands.«commandName»;
		«ENDIF»
		
		public abstract class «abstractActionName» extends Action<«data.dataParamType»> {
		
			public «abstractActionName»(DBI jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
				super("«project.name».actions.«actionName»", HttpMethod.«type», jdbi, appConfiguration, daoProvider, viewProvider);
			}
		
			@Override
			public ICommand getCommand() {
				«IF outcomes.size > 0»
					return new «commandName»(this.actionData, databaseHandle, daoProvider, viewProvider);
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

	def generateAbstractCommandFile(ACE it, Project project) '''
		package «project.name».commands;
		
		import javax.ws.rs.WebApplicationException;
		
		import com.anfelisa.ace.Command;
		import com.anfelisa.ace.DatabaseHandle;
		import com.anfelisa.ace.IDaoProvider;
		import com.anfelisa.ace.ViewProvider;

		«data.dataImport»

		public abstract class «abstractCommandName» extends Command<«data.dataParamType»> {
		
			«FOR outcome : outcomes»
				protected static final String «outcome.name» = "«outcome.name»";
			«ENDFOR»
		
			public «abstractCommandName»(«data.dataParamType» commandParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
				super("«project.name».commands.«commandName»", commandParam, databaseHandle, daoProvider, viewProvider);
			}
		
			public «abstractCommandName»(DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
				super("«project.name».commands.«commandName»", null, databaseHandle, daoProvider, viewProvider);
			}
		
			@Override
			public void publishEvents() {
				switch (this.commandData.getOutcome()) {
				«FOR outcome : outcomes»
					case «outcome.name»:
						«IF outcome.listeners.size > 0»
							new «eventNameWithPackage(outcome)»(this.commandData, databaseHandle, daoProvider, viewProvider).publish();
						«ENDIF»
						«FOR aceOperation : outcome.aceOperations»
							«aceOperation.newAction»
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

	def generateAbstractEventFile(ACE it, Outcome outcome, Project project) '''
		package «project.name».events;
		
		import javax.ws.rs.WebApplicationException;

		import com.anfelisa.ace.DatabaseHandle;
		import com.anfelisa.ace.Event;
		import com.anfelisa.ace.IDaoProvider;
		import com.anfelisa.ace.ViewProvider;
		
		«data.dataImport»
		
		public abstract class «abstractEventName(outcome)» extends Event<«data.dataParamType»> {
		
			public «abstractEventName(outcome)»(«data.dataParamType» eventParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
				super("«project.name».events.«eventName(outcome)»", eventParam, databaseHandle, daoProvider, viewProvider);
			}
			
			public «abstractEventName(outcome)»(DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
				super("«project.name».events.«eventName(outcome)»", null, databaseHandle, daoProvider, viewProvider);
			}
			
			public void initEventData(String json) {
				try {
					this.eventData = mapper.readValue(json, «data.dataParamType».class);
				} catch (Exception e) {
					throw new WebApplicationException(e);
				}
			}
			
			protected String[] getNotifiedListeners() {
				«IF outcome.listeners.size == 0»
					return new String[] {}; 
				«ELSE»
					return new String[] { «FOR listener : outcome.listeners SEPARATOR ', '»"«(listener.eContainer as View).viewNameWithPackage».«listener.name»"«ENDFOR» };
				«ENDIF»
			}
			
			
		
		}
		
		/*       S.D.G.       */
	'''

	def generateInitialActionFile(ACE it, Project project) '''
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
		
		import com.anfelisa.ace.CustomAppConfiguration;
		import com.anfelisa.ace.ViewProvider;
		import com.anfelisa.ace.IDaoProvider;
		import com.anfelisa.ace.IDaoProvider;
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

			public «actionName»(DBI jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
				super(jdbi,appConfiguration, daoProvider, viewProvider);
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
	
	def generateInitialCommandFile(ACE it, Project project) '''
		package «project.name».commands;
		
		import com.anfelisa.ace.DatabaseHandle;
		import com.anfelisa.ace.ViewProvider;
		import com.anfelisa.ace.IDaoProvider;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		«data.dataImport»
		
		public class «commandName» extends «abstractCommandName» {
		
			static final Logger LOG = LoggerFactory.getLogger(«commandName».class);

			public «commandName»(«data.dataParamType» commandData, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
				super(commandData, databaseHandle, daoProvider, viewProvider);
			}
		
			@Override
			protected void executeCommand() {
				«IF outcomes.size > 0»
					this.commandData.setOutcome(«outcomes.get(0).name»);
				«ENDIF»
			}
		
		}
		
		/*       S.D.G.       */
	'''
	
	def generateInitialEventFile(ACE it, Outcome outcome, Project project) '''
		package «project.name».events;
		
		import com.anfelisa.ace.DatabaseHandle;
		import com.anfelisa.ace.IDaoProvider;
		import com.anfelisa.ace.ViewProvider;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		«data.dataImport»
		
		public class «eventName(outcome)» extends «abstractEventName(outcome)» {
		
			static final Logger LOG = LoggerFactory.getLogger(«eventName(outcome)».class);

			public «eventName(outcome)»(«data.dataParamType» eventParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
				super(eventParam, databaseHandle, daoProvider, viewProvider);
			}
		
			public «eventName(outcome)»(DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
				this(null, databaseHandle, daoProvider, viewProvider);
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

			private IDaoProvider daoProvider;
			
			public «viewName»(IDaoProvider daoProvider) {
				super();
				this.daoProvider = daoProvider;
			}
		
			«FOR renderFunction : renderFunctions»
			    public BiConsumer<«renderFunction.data.dataName», Handle> «renderFunction.name» = (dataContainer, handle) -> {
			    };
			«ENDFOR»
		
		}
		
		/*                    S.D.G.                    */
	'''

	def generateAppRegistration(Project it) '''
		package «name»;
		
		import io.dropwizard.setup.Environment;
		import com.anfelisa.ace.CustomAppConfiguration;
		import com.anfelisa.ace.AceExecutionMode;
		import com.anfelisa.ace.IDaoProvider;
		import com.anfelisa.ace.ViewProvider;
		import com.anfelisa.ace.ServerConfiguration;
		
		import org.skife.jdbi.v2.DBI;
		
		«FOR view : it.referencedViews()»
			import «view.viewNameWithPackage»;
    	«ENDFOR»
		«IF aceOperations.size > 0»
			import «name».actions.*;
		«ENDIF»

		@SuppressWarnings("all")
		public class AppRegistration {
		
			public void registerResources(Environment environment, DBI jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
				«FOR aceOperation : aceOperations»
					environment.jersey().register(new «aceOperation.actionName»(jdbi, appConfiguration, daoProvider, viewProvider));
				«ENDFOR»
			}
		
			public void registerConsumers(ViewProvider viewProvider, String mode) {
				«FOR aceOperation : aceOperations»
					«FOR outcome : aceOperation.outcomes»
						«FOR listener : outcome.listeners»
							«IF (listener.eContainer as View).isExternal»if (ServerConfiguration.LIVE.equals(mode) || ServerConfiguration.DEV.equals(mode)) {
								«addConsumers(it, aceOperation, outcome, listener)»
							}
							«ELSE»
							«addConsumers(it, aceOperation, outcome, listener)»
							«ENDIF»
							«ENDFOR»
					«ENDFOR»
				«ENDFOR»
		    }
		}
		
		/*                    S.D.G.                    */
	'''
	
	private def addConsumers(Project project, ACE aceOperation, Outcome outcome, ViewFunction listener) '''
		viewProvider.addConsumer("«project.name».events.«aceOperation.eventName(outcome)»", viewProvider.«listener.viewFunctionWithViewNameAsVariable»);
	'''
	
	def generateApp() '''
		package com.anfelisa.ace;
		
		import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
		import org.skife.jdbi.v2.DBI;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import com.anfelisa.ace.AceDao;
		import com.anfelisa.ace.AceExecutionMode;
		
		import io.dropwizard.Application;
		import io.dropwizard.db.DataSourceFactory;
		import io.dropwizard.jdbi.DBIFactory;
		import io.dropwizard.jdbi.bundles.DBIExceptionsBundle;
		import io.dropwizard.migrations.MigrationsBundle;
		import io.dropwizard.setup.Bootstrap;
		import io.dropwizard.setup.Environment;
		
		public class App extends Application<CustomAppConfiguration> {
		
			static final Logger LOG = LoggerFactory.getLogger(App.class);
		
			public static void main(String[] args) throws Exception {
				new App().run(args);
			}
		
			@Override
			public String getName() {
				return "app name";
			}
		
			public static String getVersion() {
				return "app version";
			}
		
			@Override
			public void initialize(Bootstrap<CustomAppConfiguration> bootstrap) {
				bootstrap.addBundle(new MigrationsBundle<CustomAppConfiguration>() {
					@Override
					public DataSourceFactory getDataSourceFactory(CustomAppConfiguration configuration) {
						return configuration.getDataSourceFactory();
					}
				});
				
				bootstrap.addCommand(new EventReplayCommand(this));
			}
		
			@Override
			public void run(CustomAppConfiguration configuration, Environment environment) throws ClassNotFoundException {
				LOG.info("running version {}", getVersion());
		
				AceDao.setSchemaName(null);
		
				final DBIFactory factory = new DBIFactory();
		
				DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "data-source-name");
		
				if (ServerConfiguration.REPLAY.equals(configuration.getServerConfiguration().getMode())) {
					environment.jersey().register(new PrepareE2EResource(jdbi));
					environment.jersey().register(new StartE2ESessionResource(jdbi));
					environment.jersey().register(new StopE2ESessionResource());
					environment.jersey().register(new GetServerTimelineResource(jdbi));
				} else if (ServerConfiguration.DEV.equals(configuration.getServerConfiguration().getMode())) {
					environment.jersey().register(new GetServerTimelineResource(jdbi));
				}

				environment.jersey().register(new GetServerInfoResource());

				DBIExceptionsBundle dbiExceptionsBundle = new DBIExceptionsBundle();
				environment.jersey().register(dbiExceptionsBundle);
		
				environment.jersey().register(RolesAllowedDynamicFeature.class);
		
				// register resources
				// register consumers
		
			}
		
		}
	'''
	
	def generateE2E() '''
		package com.anfelisa.ace;
		
		import java.util.List;
		
		import org.joda.time.DateTime;
		
		public class E2E {
			
			public static boolean sessionIsRunning;
			
			public static DateTime sessionStartedAt;
			
			public static List<ITimelineItem> timeline;
			
			public static ITimelineItem selectAction(String uuid) {
				for (ITimelineItem timelineItem : timeline) {
					if (timelineItem.getUuid().equals(uuid) && timelineItem.getType().equals("action")) {
						return timelineItem;
					}
				}
				return null;
			}
			
			public static ITimelineItem selectEvent(String uuid) {
				for (ITimelineItem timelineItem : timeline) {
					if (timelineItem.getUuid().equals(uuid) && timelineItem.getType().equals("event")) {
						return timelineItem;
					}
				}
				return null;
			}
		
			
			public static ITimelineItem selectNextAction(String uuid) {
				if (uuid != null) {
					boolean returnNextAction = false;
					for (ITimelineItem timelineItem : timeline) {
						if (returnNextAction && timelineItem.getType().equals("action")) {
							return timelineItem;
						}
						if (timelineItem.getUuid().equals(uuid) && timelineItem.getType().equals("action")) {
							returnNextAction = true;
						}
					}
				} else {
					for (ITimelineItem timelineItem : timeline) {
						if (timelineItem.getType().equals("action")) {
							return timelineItem;
						}
					}
				}
				return null;
			}
		
			
		}
	'''
	
	def generateServerConfiguration() '''
		package com.anfelisa.ace;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		
		public class ServerConfiguration {
			public static final String REPLAY = "REPLAY";
			public static final String LIVE = "LIVE";
			public static final String DEV = "DEV";
			
			private String mode = DEV;
		
			@JsonProperty("mode")
			public String getMode() {
				return mode;
			}
		
			@JsonProperty("mode")
			public void setMode(String mode) {
				this.mode = mode;
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
		
			@Valid
			@NotNull
			private ServerConfiguration serverConfiguration = new ServerConfiguration();
		
			@JsonProperty("database")
			public DataSourceFactory getDataSourceFactory() {
				return database;
			}
		
			@JsonProperty("database")
			public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {
				this.database = dataSourceFactory;
			}
		
			@JsonProperty("config")
			public ServerConfiguration getServerConfiguration() {
				return serverConfiguration;
			}
		
			@JsonProperty("config")
			public void setServerConfiguration(ServerConfiguration serverConfiguration) {
				this.serverConfiguration = serverConfiguration;
			}
		
		}
	'''
	
	def generateCustomAppConfiguration() '''
		package com.anfelisa.ace;
		
		import javax.validation.Valid;
		import javax.validation.constraints.NotNull;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		
		import io.dropwizard.Configuration;
		import io.dropwizard.db.DataSourceFactory;
		
		public class CustomAppConfiguration extends AppConfiguration {
		
		}
	'''
	
	def generateStartE2ESessionResource() '''
		package com.anfelisa.ace;
		
		import java.util.List;
		
		import javax.validation.constraints.NotNull;
		import javax.ws.rs.Consumes;
		import javax.ws.rs.PUT;
		import javax.ws.rs.Path;
		import javax.ws.rs.Produces;
		import javax.ws.rs.WebApplicationException;
		import javax.ws.rs.core.MediaType;
		import javax.ws.rs.core.Response;
		
		import org.skife.jdbi.v2.DBI;
		import org.skife.jdbi.v2.Handle;

		import org.joda.time.DateTime;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import com.codahale.metrics.annotation.Timed;
		import com.fasterxml.jackson.core.JsonProcessingException;
		
		@Path("/e2e")
		@Produces(MediaType.TEXT_PLAIN)
		@Consumes(MediaType.APPLICATION_JSON)
		public class StartE2ESessionResource {
		
			static final Logger LOG = LoggerFactory.getLogger(StartE2ESessionResource.class);
		
			private DBI jdbi;
		
			private IDaoProvider daoProvider = new DaoProvider();

			public StartE2ESessionResource(DBI jdbi, IDaoProvider daoProvider) {
				super();
				this.jdbi = jdbi;
				this.daoProvider = daoProvider;
			}
		
			@PUT
			@Timed
			@Path("/start")
			public Response put(@NotNull List<ITimelineItem> timeline) throws JsonProcessingException {
				if (E2E.sessionIsRunning && E2E.sessionStartedAt.plusMinutes(1).isAfterNow()) {
					throw new WebApplicationException("session is already running", Response.Status.SERVICE_UNAVAILABLE);
				}
				E2E.sessionIsRunning = true;
				E2E.sessionStartedAt = new DateTime(System.currentTimeMillis());
				E2E.timeline = timeline;
				
				Handle handle = jdbi.open();
				try {
					handle.getConnection().setAutoCommit(false);
					
					daoProvider.getAceDao().truncateErrorTimelineTable(handle);
					daoProvider.getAceDao().truncateTimelineTable(handle);

					daoProvider.truncateAllViews(handle);

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
	
	def generateEventReplayCommand() '''
		package com.anfelisa.ace;
		
		import java.lang.reflect.Constructor;
		import java.util.List;
		
		import org.skife.jdbi.v2.DBI;
		import org.skife.jdbi.v2.Handle;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import io.dropwizard.Application;
		import io.dropwizard.cli.EnvironmentCommand;
		import io.dropwizard.jdbi.DBIFactory;
		import io.dropwizard.setup.Environment;
		import net.sourceforge.argparse4j.inf.Namespace;
		
		public class EventReplayCommand extends EnvironmentCommand<CustomAppConfiguration> {
		
			static final Logger LOG = LoggerFactory.getLogger(EventReplayCommand.class);
		
			private IDaoProvider daoProvider;
			
			protected EventReplayCommCustomAppConfigurationAppConfiguration> application, IDaoProvider daoProvider) {
				super(application, "replay", "truncates views and replays events");
				this.daoProvider = daoProvider;
			}
		
			@Override
			protected void run(Environment environment, Namespace namespace, CustomAppConfiguration configuration) throws Exception {
				if (ServerConfiguration.LIVE.equals(configuration.getServerConfiguration().getMode())) {	
					throw new RuntimeException("we won't truncate all views and replay events in a live environment");
				}
				if (ServerConfiguration.REPLAY.equals(configuration.getServerConfiguration().getMode())) {	
					throw new RuntimeException("replay events in a replay environment doesn't make sense");
				}
				
				final DBIFactory factory = new DBIFactory();
		
				DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "data-source-name");
		
				DatabaseHandle databaseHandle = new DatabaseHandle(jdbi.open(), null);
				LOG.info("START EVENT REPLAY");
				try {
					databaseHandle.beginTransaction();
					Handle handle = databaseHandle.getHandle();
					AppUtils.truncateAllViews(handle);
		
					List<ITimelineItem> timeline = daoProvider.getAceDao().selectTimeline(handle);
					E2E.timeline = timeline;
		
					int eventCount = 0;
					ITimelineItem nextAction = E2E.selectNextAction(null);
					while (nextAction != null) {
						if (!nextAction.getMethod().equalsIgnoreCase("GET")) {
							ITimelineItem nextEvent = E2E.selectEvent(nextAction.getUuid());
							if (nextEvent != null) {
								try {
									Class<?> cl = Class.forName(nextEvent.getName());
									Constructor<?> con = cl.getConstructor(DatabaseHandle.class);
									IEvent event = (IEvent) con.newInstance(databaseHandle);
									event.initEventData(nextEvent.getData());
									event.notifyListeners();
									eventCount++;
									LOG.info("published " + nextEvent.getUuid() + " - " + nextEvent.getName());
								} catch (Exception e) {
									LOG.error("failed to replay event " + nextEvent.getUuid() + " - " + nextEvent.getName());
									LOG.error(e.getMessage());
								}
							}
						}
						nextAction = E2E.selectNextAction(nextAction.getUuid());
					}
		
					databaseHandle.commitTransaction();
		
					LOG.info("EVENT REPLAY FINISHED: successfully replayed " + eventCount + " events");
					
				} catch (Exception e) {
					databaseHandle.rollbackTransaction();
					LOG.info("EVENT REPLAY ABORTED " + e.getMessage());
					throw e;
				} finally {
					databaseHandle.close();
				}
		
			}
		
		}
		
	'''
	
	def generateGetServerInfoResource() '''
		package com.anfelisa.ace;
		
		import javax.ws.rs.Consumes;
		import javax.ws.rs.GET;
		import javax.ws.rs.Path;
		import javax.ws.rs.Produces;
		import javax.ws.rs.core.MediaType;
		import javax.ws.rs.core.Response;
		
		import com.codahale.metrics.annotation.Timed;
		
		@Path("/server")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public class GetServerInfoResource {
		
			public GetServerInfoResource() {
				super();
			}
		
			@GET
			@Timed
			@Path("/info")
			public Response put() {
				return Response.ok(new ServerInfo(App.getVersion())).build();
			}
		
		}
		
	'''
	
	def generateServerInfo() '''
		package com.anfelisa.ace;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		
		public class ServerInfo {
		
			private String serverVersion;
			
			public ServerInfo(String serverVersion) {
				super();
				this.serverVersion = serverVersion;
			}
		
			@JsonProperty
			public String getServerVersion() {
				return serverVersion;
			}
			
		}
		
	'''
	
	def generateGetServerTimelineResource() '''
		package com.anfelisa.ace;
		
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
		
		@Path("/e2e")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public class GetServerTimelineResource {
		
			private DBI jdbi;
		
			static final Logger LOG = LoggerFactory.getLogger(GetServerTimelineResource.class);
		
			private AceDao aceDao = new AceDao();
		
			public GetServerTimelineResource(DBI jdbi) {
				super();
				this.jdbi = jdbi;
			}
		
			@GET
			@Timed
			@Path("/timeline")
			public Response get() {
				Handle timelineHandle = jdbi.open();
				try {
					List<ITimelineItem> serverTimeline = aceDao.selectTimeline(timelineHandle);
					return Response.ok(serverTimeline).build();
				} catch (Exception e) {
					throw new WebApplicationException(e);
				} finally {
					timelineHandle.close();
				}
			}
		
		}
		
	'''
	
	def generatePrepareE2EResource() '''
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
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import com.codahale.metrics.annotation.Timed;
		
		@Path("/e2e")
		@Produces(MediaType.TEXT_PLAIN)
		@Consumes(MediaType.APPLICATION_JSON)
		public class PrepareE2EResource {
		
			private DBI jdbi;
		
			static final Logger LOG = LoggerFactory.getLogger(PrepareE2EResource.class);
		
			private IDaoProvider daoProvider;
			private ViewProvider viewProvider;
		
			public PrepareE2EResource(DBI jdbi, IDaoProvider daoProvider, ViewProvider viewProvider) {
				super();
				this.jdbi = jdbi;
				this.daoProvider = daoProvider;
				this.viewProvider = viewProvider;
			}
		
			@PUT
			@Timed
			@Path("/prepare")
			public Response put(@NotNull @QueryParam("uuid") String uuid) {
				ITimelineItem actionToBePrepared = E2E.selectAction(uuid);
		
				DatabaseHandle databaseHandle = new DatabaseHandle(jdbi.open(), null);
				LOG.info("PREPARE ACTION " + actionToBePrepared);
				try {
					databaseHandle.beginTransaction();
		
					ITimelineItem lastAction = daoProvider.getAceDao().selectLastAction(databaseHandle.getHandle());
		
					int eventCount = 0;
					ITimelineItem nextAction = E2E.selectNextAction(lastAction != null ? lastAction.getUuid() : null);
					while (nextAction != null && !nextAction.getUuid().equals(uuid)) {
						if (!nextAction.getMethod().equalsIgnoreCase("GET")) {
							ITimelineItem nextEvent = E2E.selectEvent(nextAction.getUuid());
							if (nextEvent != null) {
								LOG.info("PUBLISH EVENT " + nextEvent);
								Class<?> cl = Class.forName(nextEvent.getName());
								Constructor<?> con = cl.getConstructor(DatabaseHandle.class, IDaoProvider.class, ViewProvider.class);
								IEvent event = (IEvent) con.newInstance(databaseHandle, daoProvider, viewProvider);
								event.initEventData(nextEvent.getData());
								event.notifyListeners();
								daoProvider.addPreparingEventToTimeline(event, nextAction.getUuid());
								eventCount++;
							}
						}
						nextAction = E2E.selectNextAction(nextAction.getUuid());
					}
		
					databaseHandle.commitTransaction();
					return Response.ok("prepared action " + uuid + " by publishing " + eventCount + " events").build();
				} catch (Exception e) {
					databaseHandle.rollbackTransaction();
					throw new WebApplicationException(e);
				} finally {
					databaseHandle.close();
				}
			}
		
		}
		
	'''
	
	def generateStopE2ESessionResource() '''
		package com.anfelisa.ace;
		
		import javax.ws.rs.Consumes;
		import javax.ws.rs.PUT;
		import javax.ws.rs.Path;
		import javax.ws.rs.Produces;
		import javax.ws.rs.core.MediaType;
		import javax.ws.rs.core.Response;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import com.codahale.metrics.annotation.Timed;
		
		@Path("/e2e")
		@Produces(MediaType.TEXT_PLAIN)
		@Consumes(MediaType.APPLICATION_JSON)
		public class StopE2ESessionResource {
		
			static final Logger LOG = LoggerFactory.getLogger(StopE2ESessionResource.class);
		
			public StopE2ESessionResource() {
				super();
			}
		
			@PUT
			@Timed
			@Path("/stop")
			public Response put() {
				E2E.sessionIsRunning = false;
				E2E.sessionStartedAt = null;
				E2E.timeline = null;
				return Response.ok().build();
			}
		
		}
	'''
	
	def generateAceDao() '''
		package com.anfelisa.ace;
		
		import java.util.List;

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
			}
		
			public void truncateErrorTimelineTable(Handle handle) {
				handle.execute("TRUNCATE " + errorTimelineTable());
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
		
			public ITimelineItem selectLastAction(Handle handle) {
				return handle
						.createQuery("SELECT type, method, name, time, data, uuid " + "FROM " + timelineTable() + " "
								+ "where type = 'action' " + "order by time desc " + "limit 1")
						.map(new TimelineItemMapper()).first();
			}
		
			public List<ITimelineItem> selectTimeline(Handle handle) {
				return handle
						.createQuery("SELECT type, method, name, time, data, uuid " + "FROM " + timelineTable() + " "
								+ "order by time asc ")
						.map(new TimelineItemMapper()).list();
			}

		}
	'''
	
	def generateAceExecutionMode() '''
		package com.anfelisa.ace;
		
		public enum AceExecutionMode {
			LIVE, REPLAY, DEV
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
			protected JodaObjectMapper mapper;
			private CustomAppConfiguration appConfiguration;
			protected IDaoProvider daoProvider;
			protected ViewProvider viewProvider;
		
			public Action(String actionName, HttpMethod httpMethod, DBI jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
				super();
				this.actionName = actionName;
				this.httpMethod = httpMethod;
				this.jdbi = jdbi;
				mapper = new JodaObjectMapper();
				this.appConfiguration = appConfiguration;
				this.daoProvider = daoProvider;
				this.viewProvider = viewProvider;
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
				this.databaseHandle = new DatabaseHandle(jdbi.open(), jdbi.open());
				Handle timelineHandle = null;
				databaseHandle.beginTransaction();
				try {
					if (!ServerConfiguration.REPLAY.equals(appConfiguration.getServerConfiguration().getMode())) {
						this.actionData.setSystemTime(new DateTime());
					} else {
						ITimelineItem timelineItem = E2E.selectAction(this.actionData.getUuid());
						if (timelineItem != null) {
							Class<?> cl = Class.forName(timelineItem.getName());
							Constructor<?> con = cl.getConstructor(DBI.class, CustomAppConfiguration.class, IDaoProvider.class, ViewProvider.class);
							IAction action = (IAction) con.newInstance(jdbi, appConfiguration, daoProvider, viewProvider);
							action.initActionData(timelineItem.getData());
							this.actionData.setSystemTime(action.getActionData().getSystemTime());
						} else {
							this.actionData.setSystemTime(new DateTime());
						}
					}
					daoProvider.addActionToTimeline(this);
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
						return Response.ok(this.getActionData().toPresentationalData()).build();
					} else if (httpMethod == HttpMethod.POST) {
						return Response.ok(this.getActionData().getUuid()).build();
					} else {
						return Response.ok().build();
					}
				} catch (WebApplicationException x) {
					daoProvider.addExceptionToTimeline(this.actionData.getUuid(), x, databaseHandle);
					databaseHandle.rollbackTransaction();
					LOG.error(actionName + " failed " + x.getMessage());
					x.printStackTrace();
					return Response.status(x.getResponse().getStatusInfo()).entity(x.getMessage()).build();
				} catch (Exception x) {
					daoProvider.addExceptionToTimeline(this.actionData.getUuid(), x, databaseHandle);
					databaseHandle.rollbackTransaction();
					LOG.error(actionName + " failed " + x.getMessage());
					x.printStackTrace();
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
			protected IDaoProvider daoProvider;
			protected ViewProvider viewProvider;
		
			public Command(String commandName, T commandData, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
				super();
				this.commandData = commandData;
				this.commandName = commandName;
				this.databaseHandle = databaseHandle;
				mapper = new JodaObjectMapper();
				this.daoProvider = daoProvider;
				this.viewProvider = viewProvider;
			}
		
			protected void executeCommand() {
			}
		
			public void execute() {
				this.executeCommand();
				daoProvider.addCommandToTimeline(this);
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
			protected IDaoProvider daoProvider;
			private ViewProvider viewProvider;
		
			public Event(String eventName, T eventParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
				super();
				this.eventParam = eventParam;
				this.eventName = eventName;
				this.databaseHandle = databaseHandle;
				this.daoProvider = daoProvider;
				mapper = new JodaObjectMapper();
				this.viewProvider = viewProvider;
			}

			protected void prepareDataForView() {
			}
		
			@SuppressWarnings("unchecked")
			public void notifyListeners() {
				List<BiConsumer<? extends IDataContainer, Handle>> consumerList = viewProvider.getConsumerForEvent(eventName);
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
		
			protected abstract String[] getNotifiedListeners();
		
			public void publish() {
				this.prepareDataForView();
				this.eventData.setNotifiedListeners(this.getNotifiedListeners());
				daoProvider.addEventToTimeline(this);
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
			
			DateTime getSystemTime();
			
			void setSystemTime(DateTime systemTime);
		
			String[] getNotifiedListeners();

			void setNotifiedListeners(String[] listeners);
			
			Object toPresentationalData();
		
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
		import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
		
		@JsonDeserialize(as=TimelineItem.class)
		public interface ITimelineItem {
		
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
		import com.fasterxml.jackson.annotation.JsonProperty;
		
		public class TimelineItem implements ITimelineItem {
		
			private String type;
			
			private String method;
			
			private String name;
			
			private DateTime timestamp;
			
			private String data;
			
			private String uuid;
		
			
			public TimelineItem(
				@JsonProperty("type") String type, 
				@JsonProperty("method") String method, 
				@JsonProperty("name") String name, 
				@JsonProperty("timestamp") DateTime timestamp, 
				@JsonProperty("data") String data,
				@JsonProperty("uuid") String uuid
			) {
				super();
				this.type = type;
				this.method = method;
				this.name = name;
				this.timestamp = timestamp;
				this.data = data;
				this.uuid = uuid;
			}
		
			@JsonProperty
			public String getType() {
				return type;
			}
		
			@JsonProperty
			public String getMethod() {
				return method;
			}
		
			@JsonProperty
			public String getName() {
				return name;
			}
		
			@JsonProperty
			public DateTime getTimestamp() {
				return timestamp;
			}
		
			@JsonProperty
			public String getData() {
				return data;
			}
		
			@JsonProperty
			public String getUuid() {
				return uuid;
			}
			
			@Override
			public String toString() {
				return "TimelineItem [type=" + type + ", method=" + method + ", name=" + name + ", timestamp="
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
	
	def generateAbstractDaoProvider() '''
		package com.anfelisa.ace;
		
		import javax.ws.rs.WebApplicationException;
		
		import com.anfelisa.ace.encryption.EncryptionService;
		import com.fasterxml.jackson.core.JsonProcessingException;
		
		public abstract class AbstractDaoProvider implements IDaoProvider {
		
			protected final AceDao aceDao = new AceDao();
		
			protected final JodaObjectMapper mapper = new JodaObjectMapper();
		
			@Override
			public AceDao getAceDao() {
				return this.aceDao;
			}
			
			@Override
			public void addActionToTimeline(IAction action) {
				try {
					String json = mapper.writeValueAsString(action.getActionData());
					addItemToTimeline("action", action.getHttpMethod().name(), action.getActionName(), json,
							action.getActionData().getUuid(), action.getDatabaseHandle());
				} catch (JsonProcessingException e) {
					throw new WebApplicationException(e);
				}
			}
		
			@Override
			public void addCommandToTimeline(ICommand command) {
				try {
					addItemToTimeline("command", null, command.getCommandName(),
							mapper.writeValueAsString(command.getCommandData()), command.getCommandData().getUuid(),
							command.getDatabaseHandle());
				} catch (JsonProcessingException e) {
					throw new WebApplicationException(e);
				}
			}
		
			@Override
			public void addEventToTimeline(IEvent event) {
				try {
					addItemToTimeline("event", null, event.getEventName(), mapper.writeValueAsString(event.getEventData()),
							event.getEventParam().getUuid(), event.getDatabaseHandle());
				} catch (JsonProcessingException e) {
					throw new WebApplicationException(e);
				}
			}
		
			@Override
			public void addPreparingEventToTimeline(IEvent event, String uuid) {
				try {
					addItemToTimeline("preparing event", null, event.getEventName(),
							mapper.writeValueAsString(event.getEventData()), uuid, event.getDatabaseHandle());
				} catch (JsonProcessingException e) {
					throw new WebApplicationException(e);
				}
			}
		
			@Override
			public void addExceptionToTimeline(String uuid, Throwable x, DatabaseHandle databaseHandle) {
				aceDao.insertIntoErrorTimeline(databaseHandle.getErrorHandle(), "exception", null, x.getClass().getName(),
						x.getMessage(), uuid);
			}
		
			private void addItemToTimeline(String type, String method, String name, String json, String uuid,
					DatabaseHandle databaseHandle) {
				if (databaseHandle == null) {
					throw new WebApplicationException("no database handle");
				}
				aceDao.insertIntoTimeline(databaseHandle.getHandle(), type, method, name, EncryptionService.encrypt(json),
						uuid);
				aceDao.insertIntoErrorTimeline(databaseHandle.getErrorHandle(), type, method, name,
						EncryptionService.encrypt(json), uuid);
			}
		
		}
		
	'''
	
	def generateDaoProvider() '''
		package com.anfelisa.ace;
		
		public class DaoProvider extends AbstractDaoProvider {
			
		}
		
	'''
	
	def generateIDaoProvider() '''
		package com.anfelisa.ace;
		
		public interface IDaoProvider {
			
			AceDao getAceDao();
			
			void addExceptionToTimeline(String uuid, Throwable x, DatabaseHandle databaseHandle);
			
			void addPreparingEventToTimeline(IEvent event, String uuid);
			
			public void addEventToTimeline(IEvent event);
			
			public void addCommandToTimeline(ICommand command);
			
			void addActionToTimeline(IAction action);
			
		}
		
	'''
	
	def generateViewProvider() '''
		package com.anfelisa.ace;
		
		import java.util.ArrayList;
		import java.util.HashMap;
		import java.util.List;
		import java.util.Map;
		import java.util.function.BiConsumer;
		
		import org.skife.jdbi.v2.Handle;
		
		public class ViewProvider {
		
			private final Map<String, List<BiConsumer<? extends IDataContainer, Handle>>> consumerMap;
		
			public ViewProvider(IDaoProvider daoProvider, EmailService emailService) {
				consumerMap = new HashMap<String, List<BiConsumer<? extends IDataContainer, Handle>>>();
			}
			
			public void addConsumer(String eventName, BiConsumer<? extends IDataContainer, Handle> createUserTable) {
				List<BiConsumer<? extends IDataContainer, Handle>> consumerForEvent = consumerMap.get(eventName);
				if (consumerForEvent == null) {
					consumerForEvent = new ArrayList<BiConsumer<? extends IDataContainer, Handle>>();
					consumerMap.put(eventName, consumerForEvent);
				}
				consumerForEvent.add(createUserTable);
			}
		
			public List<BiConsumer<? extends IDataContainer, Handle>> getConsumerForEvent(String eventName) {
				return consumerMap.get(eventName);
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
		
		<addUniqueConstraint columnNames="type, uuid" tableName="timeline" />
		<addUniqueConstraint columnNames="type, uuid" tableName="errortimeline" />

	'''
	
}