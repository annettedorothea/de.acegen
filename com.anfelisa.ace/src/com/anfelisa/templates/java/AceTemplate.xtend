package com.anfelisa.templates.java

import com.anfelisa.ace.JAVA

class AceTemplate {

	def generateApp() '''
		package com.anfelisa.ace;
		
		import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
		import org.jdbi.v3.core.Jdbi;

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
		
			public static void reportException(Exception x) {
				// do somehting to notify someone about exception
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
		
				Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "data-source-name");
		
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
					if (timelineItem.getUuid().equals(uuid) && timelineItem.getType().equals("event") && !E2E.hasException(uuid)) {
						return timelineItem;
					}
					
				}
				return null;
			}
			
			private static boolean hasException(String uuid) {
				for (ITimelineItem timelineItem : timeline) {
					if (timelineItem.getUuid().equals(uuid) && timelineItem.getType().equals("exception")) {
						return true;
					}
					
				}
				return false;
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
			public static final String REPLAY_EVENTS = "REPLAY_EVENTS";
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
		
		import org.jdbi.v3.core.Jdbi;

		import org.jdbi.v3.core.Handle;

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
		
			private Jdbi jdbi;
		
			private IDaoProvider daoProvider = new DaoProvider();

			public StartE2ESessionResource(Jdbi jdbi, IDaoProvider daoProvider) {
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
					handle.begin();
					
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
		
		import org.jdbi.v3.core.Jdbi;

		import org.jdbi.v3.core.Handle;
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
			
			protected EventReplayCommand(Application<CustomAppConfiguration> application, IDaoProvider daoProvider) {
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
		
				Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "data-source-name");
		
				DatabaseHandle databaseHandle = new DatabaseHandle(jdbi.open(), null);
				
				ViewProvider viewProvider = new ViewProvider(daoProvider);
				
				LOG.info("START EVENT REPLAY");
				try {
					databaseHandle.beginTransaction();
					Handle handle = databaseHandle.getHandle();
					daoProvider.truncateAllViews(handle);
		
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
									Constructor<?> con = cl.getConstructor(DatabaseHandle.class, IDaoProvider.class, ViewProvider.class);
									IEvent event = (IEvent) con.newInstance(databaseHandle, daoProvider, viewProvider);
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
		
		import org.jdbi.v3.core.Jdbi;

		import org.jdbi.v3.core.Handle;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import com.codahale.metrics.annotation.Timed;
		
		@Path("/e2e")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public class GetServerTimelineResource {
		
			private Jdbi jdbi;
		
			static final Logger LOG = LoggerFactory.getLogger(GetServerTimelineResource.class);
		
			private AceDao aceDao = new AceDao();
		
			public GetServerTimelineResource(Jdbi jdbi) {
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
		
		import org.jdbi.v3.core.Jdbi;

		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import com.codahale.metrics.annotation.Timed;
		
		@Path("/e2e")
		@Produces(MediaType.TEXT_PLAIN)
		@Consumes(MediaType.APPLICATION_JSON)
		public class PrepareE2EResource {
		
			private Jdbi jdbi;
		
			static final Logger LOG = LoggerFactory.getLogger(PrepareE2EResource.class);
		
			private IDaoProvider daoProvider;
			private ViewProvider viewProvider;
		
			public PrepareE2EResource(Jdbi jdbi, IDaoProvider daoProvider, ViewProvider viewProvider) {
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
				if (actionToBePrepared == null) {
					return Response.ok("prepared action " + uuid + " by doing nothing - action was not found").build();
				}
		
				DatabaseHandle databaseHandle = new DatabaseHandle(jdbi.open(), jdbi.open());
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
		import java.util.Optional;

		import org.apache.commons.lang3.StringUtils;
		import org.jdbi.v3.core.Handle;
		import org.jdbi.v3.core.statement.Update;
		
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
		
			public void truncateTimelineTable(Handle handle) {
				handle.execute("TRUNCATE " + timelineTable());
			}
		
			public void insertIntoTimeline(Handle handle, String type, String method, String name, String data, String uuid) {
				Update statement = handle.createUpdate("INSERT INTO " + timelineTable()
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
		
			public ITimelineItem selectLastAction(Handle handle) {
				Optional<ITimelineItem> optional = handle
						.createQuery("SELECT type, method, name, time, data, uuid " + "FROM " + timelineTable() + " "
								+ "where type = 'action' " + "order by time desc " + "limit 1")
						.map(new TimelineItemMapper())
						.findFirst();
				return optional.isPresent() ? optional.get() : null;
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
		
		import org.jdbi.v3.core.Jdbi;

		
		public class Resource {
		
			private Jdbi jdbi;
		
			public Resource( Jdbi jdbi) {
				super();
				this.jdbi = jdbi;
			}
		
			public DatabaseHandle createDatabaseHandle() {
				return new DatabaseHandle(jdbi.open(), jdbi.open());
			}
		
			public Jdbi getJdbi() {
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
		import org.jdbi.v3.core.mapper.RowMapper;
		import org.jdbi.v3.core.statement.StatementContext;
		
		public class TimelineItemMapper implements RowMapper<ITimelineItem> {
			
			public ITimelineItem map(ResultSet r, StatementContext ctx) throws SQLException {
				DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
				DateTime time = DateTime.parse(r.getString("time"), fmt);
				return new TimelineItem(
					r.getString("type"),
					r.getString("method"),
					r.getString("name"),
					time,
					r.getString("data"),
					r.getString("uuid")
				);
			}
		}
	'''
	
	def generateAbstractDaoProvider() '''
		package com.anfelisa.ace;
		
		import javax.ws.rs.WebApplicationException;
		
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
							event.getEventData().getUuid(), event.getDatabaseHandle());
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
				aceDao.insertIntoTimeline(databaseHandle.getTimelineHandle(), "exception", null, x.getClass().getName(),
						x.getMessage(), uuid);
			}
		
			private void addItemToTimeline(String type, String method, String name, String json, String uuid,
					DatabaseHandle databaseHandle) {
				if (databaseHandle == null) {
					throw new WebApplicationException("no database handle");
				}
				aceDao.insertIntoTimeline(databaseHandle.getTimelineHandle(), type, method, name, json, uuid);
			}
		
		}
		
	'''
	
	def generateDaoProvider() '''
		package com.anfelisa.ace;
		
		import org.jdbi.v3.core.Handle;

		public class DaoProvider extends AbstractDaoProvider {
			@Override
			public void truncateAllViews(Handle handle) {
			}
		}
		
	'''
	
	def generateIDaoProvider() '''
		package com.anfelisa.ace;
		
		import org.jdbi.v3.core.Handle;
		
		public interface IDaoProvider {
			
			void truncateAllViews(Handle handle);
			
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
		
		import org.jdbi.v3.core.Handle;
		
		public class ViewProvider {
		
			private final Map<String, List<BiConsumer<? extends IDataContainer, Handle>>> consumerMap;
		
			public ViewProvider(IDaoProvider daoProvider) {
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
		
		<addUniqueConstraint columnNames="type, uuid" tableName="timeline" />

	'''

	def generateAuthUser(JAVA it) '''
		package com.anfelisa.auth;
		
		import java.security.Principal;
		
		public class AuthUser implements Principal {
			public String getName() {
				return "AuthUser";
			}
		}
		
		/*       S.D.G.       */
	'''

}
