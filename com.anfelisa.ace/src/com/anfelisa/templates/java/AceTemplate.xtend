package com.anfelisa.templates.java

import com.anfelisa.ace.AuthUser
import com.anfelisa.ace.JAVA
import com.anfelisa.extensions.java.AceExtension
import com.anfelisa.extensions.java.AttributeExtension
import com.anfelisa.extensions.java.ModelExtension
import javax.inject.Inject
import com.anfelisa.ace.JAVA_ACE_WRITE
import com.anfelisa.ace.JAVA_ACE_READ

class AceTemplate {

	@Inject
	extension AttributeExtension

	@Inject
	extension ModelExtension

	@Inject
	extension AceExtension

	def generateApp() '''
		package com.anfelisa.ace;
		
		import org.eclipse.jetty.server.Connector;
		import org.eclipse.jetty.server.Server;
		import org.eclipse.jetty.server.ServerConnector;
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
		
				environment.lifecycle().addServerLifecycleListener(new ServerLifecycleListener() {
					@Override
					public void serverStarted(Server server) {
						for (Connector connector : server.getConnectors()) {
							if (connector instanceof ServerConnector) {
								try (ServerConnector serverConnector = (ServerConnector) connector) {
									configuration.setPort(serverConnector.getPort());
								}
							}
						}
					}
				});

				final DBIFactory factory = new DBIFactory();
		
				Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "data-source-name");
				
				E2E e2e = new E2E();
		
				if (ServerConfiguration.REPLAY.equals(configuration.getServerConfiguration().getMode())) {
					environment.jersey().register(new PrepareE2EResource(jdbi, e2e));
					environment.jersey().register(new StartE2ESessionResource(jdbi, e2e));
					environment.jersey().register(new StopE2ESessionResource(e2e));
					environment.jersey().register(new GetServerTimelineResource(jdbi, e2e));
				} else if (ServerConfiguration.DEV.equals(mode)) {
					environment.jersey().register(new GetServerTimelineResource(jdbi, e2e));
				} else if (ServerConfiguration.TEST.equals(mode)) {
					environment.jersey().register(new ReplayEventsResource(jdbi, daoProvider, viewProvider, e2e));
				}
		
				environment.jersey().register(new GetServerInfoResource());
		
				DBIExceptionsBundle dbiExceptionsBundle = new DBIExceptionsBundle();
				environment.jersey().register(dbiExceptionsBundle);
		
				environment.jersey().register(RolesAllowedDynamicFeature.class);
		
				AppRegistration.registerResources(environment, jdbi, appConfiguration, daoProvider, viewProvider, e2e);
				AppRegistration.registerConsumers(viewProvider, mode);
		
			}
		
		}
	'''

	def generateAppRegistration() '''
		package com.anfelisa.ace;
		
		import org.jdbi.v3.core.Jdbi;
		
		import io.dropwizard.setup.Environment;
		
		public class AppRegistration {
		
			public static void registerResources(Environment environment, Jdbi jdbi, CustomAppConfiguration appConfiguration,
					IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
			}
		
			public static void registerConsumers(ViewProvider viewProvider, String mode) {
			}
		}
		
	'''

	def generateE2E() '''
		package com.anfelisa.ace;
		
		import java.util.ArrayList;
		import java.util.HashMap;
		import java.util.List;
		import java.util.Map;
		
		import org.joda.time.DateTime;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		public class E2E {
		
			private boolean sessionIsRunning;
		
			private DateTime sessionStartedAt;
		
			private Map<String, AceOperation> timeline;
		
			private List<String> uuidList;
		
			private int index;
			
			private List<Thread> triggerdThreads;
		
			static final Logger LOG = LoggerFactory.getLogger(E2E.class);
		
			public E2E() {
				this.sessionIsRunning = false;
				this.sessionStartedAt = null;
				this.timeline = null;
				this.index = 0;
				this.triggerdThreads = new ArrayList<>();
			}
			
			public void addTriggeredThread(Thread thread) {
				triggerdThreads.add(thread);
			}
			
			public boolean isSessionRunning() {
				return this.sessionIsRunning;
			}
		
			public DateTime getSessionStartedAt() {
				return this.sessionStartedAt;
			}
		
			public void reset() {
				for (Thread thread : triggerdThreads) {
					try {
						LOG.info("wait for thread {} to finish before resetting E2E session", thread.getName());
						thread.join();
					} catch (InterruptedException e) {
						LOG.error("thread.join {} was interrupted", thread.getName(), e);
					}
				}
				this.sessionIsRunning = false;
				this.sessionStartedAt = null;
				this.timeline = null;
				this.index = 0;
				this.triggerdThreads.clear();
			}

		
			public void init(List<ITimelineItem> initialTimeline) {
				timeline = new HashMap<>();
				uuidList = new ArrayList<>();
				for (ITimelineItem timelineItem : initialTimeline) {
					String uuid = timelineItem.getUuid();
					if (!uuidList.contains(uuid)) {
						uuidList.add(uuid);
					}
					AceOperation aceOperation = timeline.get(uuid);
					if (aceOperation == null) {
						aceOperation = new AceOperation(uuid);
						timeline.put(uuid, aceOperation);
					}
					if ("action".equals(timelineItem.getType())) {
						aceOperation.setAction(timelineItem);
					} else if ("command".equals(timelineItem.getType())) {
						aceOperation.setCommand(timelineItem);
					} else if ("event".equals(timelineItem.getType())) {
						aceOperation.setEvent(timelineItem);
					}
				}
				this.sessionIsRunning = true;
				this.sessionStartedAt = new DateTime(System.currentTimeMillis());
				this.index = 0;
			}
		
			public ITimelineItem selectNextAction() {
				if (index < uuidList.size()) {
					String uuid = uuidList.get(index);
					index++;
					return timeline.get(uuid).getAction();
				}
				return null;
			}
		
			public ITimelineItem selectAction(String uuid) {
				return timeline.get(uuid).getAction();
			}
		
			public ITimelineItem selectCommand(String uuid) {
				return timeline.get(uuid).getCommand();
			}
		
			public ITimelineItem selectEvent(String uuid) {
				return timeline.get(uuid).getEvent();
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
			public static final String TEST = "TEST";
			
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
		
			private int port;
			
			public int getPort() {
				return port;
			}
		
			public void setPort(int port) {
				this.port = port;
			}
		
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
		
		import org.jdbi.v3.core.Handle;
		import org.jdbi.v3.core.Jdbi;
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
			
			private E2E e2e;
		
			public StartE2ESessionResource(Jdbi jdbi, IDaoProvider daoProvider, E2E e2e) {
				super();
				this.jdbi = jdbi;
				this.daoProvider = daoProvider;
				this.e2e = e2e;
			}
		
			@PUT
			@Timed
			@Path("/start")
			public Response put(@NotNull List<ITimelineItem> timeline) throws JsonProcessingException {
				if (e2e.isSessionRunning() && e2e.getSessionStartedAt().plusMinutes(1).isAfterNow()) {
					throw new WebApplicationException("session is already running", Response.Status.SERVICE_UNAVAILABLE);
				}
				e2e.init(timeline);
				
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

	def generateReplayEventsResource() '''
		package com.anfelisa.ace;
		
		import java.util.List;
		
		import javax.ws.rs.Consumes;
		import javax.ws.rs.PUT;
		import javax.ws.rs.Path;
		import javax.ws.rs.Produces;
		import javax.ws.rs.WebApplicationException;
		import javax.ws.rs.core.MediaType;
		import javax.ws.rs.core.Response;
		
		import com.fasterxml.jackson.core.JsonProcessingException;
		
		import org.jdbi.v3.core.Handle;
		import org.jdbi.v3.core.Jdbi;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import com.codahale.metrics.annotation.Timed;
		
		@Path("/test")
		@Produces(MediaType.TEXT_PLAIN)
		@Consumes(MediaType.APPLICATION_JSON)
		public class ReplayEventsResource {
		
			private Jdbi jdbi;
		
			static final Logger LOG = LoggerFactory.getLogger(ReplayEventsResource.class);
		
			private IDaoProvider daoProvider;
			private ViewProvider viewProvider;
		
			public ReplayEventsResource(Jdbi jdbi, IDaoProvider daoProvider, ViewProvider viewProvider) {
				super();
				this.jdbi = jdbi;
				this.daoProvider = daoProvider;
				this.viewProvider = viewProvider;
			}
		
			@PUT
			@Timed
			@Path("/replay-events")
			public Response put(List<ITimelineItem> timeline) throws JsonProcessingException {
				DatabaseHandle databaseHandle = new DatabaseHandle(jdbi);
				try {
					databaseHandle.beginTransaction();
		
					Handle handle = databaseHandle.getHandle();
					daoProvider.truncateAllViews(handle);
					daoProvider.getAceDao().truncateTimelineTable(handle);
					databaseHandle.commitTransaction();
		
					databaseHandle.beginTransaction();
					if (timeline != null) {
						for (ITimelineItem nextEvent : timeline) {
							IEvent event = EventFactory.createEvent(nextEvent.getName(), nextEvent.getData(), daoProvider, viewProvider);
							event.notifyListeners(databaseHandle.getHandle());
							daoProvider.getAceDao().addPreparingEventToTimeline(event, nextEvent.getUuid(), databaseHandle.getTimelineHandle());
							LOG.info("published " + nextEvent.getUuid() + " - " + nextEvent.getName());
						}
						LOG.info("EVENT REPLAY FINISHED: successfully replayed " + timeline.size() + " events");
					}
		
					databaseHandle.commitTransaction();
		
					return Response.ok().build();
				} catch (Exception e) {
					databaseHandle.rollbackTransaction();
					LOG.error("exception during prepare test");
					LOG.error(e.getMessage());
					throw new WebApplicationException(e);
				} finally {
					databaseHandle.close();
				}
			}
		
		}
		
		
	'''

	def generateSetSystemTimeResource() '''
		package com.anfelisa.ace;
		
		import javax.validation.constraints.NotNull;
		import javax.ws.rs.Consumes;
		import javax.ws.rs.PUT;
		import javax.ws.rs.Path;
		import javax.ws.rs.Produces;
		import javax.ws.rs.core.MediaType;
		import javax.ws.rs.core.Response;
		
		import org.joda.time.DateTime;
		
		import com.codahale.metrics.annotation.Timed;
		
		@Path("/test")
		@Produces(MediaType.TEXT_PLAIN)
		@Consumes(MediaType.APPLICATION_JSON)
		public class SetSystemTimeResource {
		
			public static DateTime systemTime;
			
			@PUT
			@Timed
			@Path("/system-time")
			public Response put(@NotNull String systemTime) {
				SetSystemTimeResource.systemTime = new DateTime(systemTime);
				return Response.ok("set system time to " + systemTime).build();
			}
		
		}
		
	'''

	def generateEventReplayCommand() '''
		package com.anfelisa.ace;
		
		import java.util.List;
		
		import org.jdbi.v3.core.Handle;
		import org.jdbi.v3.core.Jdbi;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import io.dropwizard.Application;
		import io.dropwizard.cli.EnvironmentCommand;
		import io.dropwizard.jdbi3.JdbiFactory;
		import io.dropwizard.setup.Environment;
		import net.sourceforge.argparse4j.inf.Namespace;
		
		public class EventReplayCommand extends EnvironmentCommand<CustomAppConfiguration> {
		
			static final Logger LOG = LoggerFactory.getLogger(EventReplayCommand.class);
		
			protected EventReplayCommand(Application<CustomAppConfiguration> application) {
				super(application, "replay", "truncates views and replays events");
			}
		
			@Override
			protected void run(Environment environment, Namespace namespace, CustomAppConfiguration configuration)
					throws Exception {
				if (ServerConfiguration.LIVE.equals(configuration.getServerConfiguration().getMode())) {
					throw new RuntimeException("we won't truncate all views and replay events in a live environment");
				}
				if (ServerConfiguration.REPLAY.equals(configuration.getServerConfiguration().getMode())) {
					throw new RuntimeException("replay events in a replay environment doesn't make sense");
				}
		
				IDaoProvider daoProvider = DaoProvider.create();
				ViewProvider viewProvider = ViewProvider.create(daoProvider, configuration);
		
				final JdbiFactory factory = new JdbiFactory();
				Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "data-source-name");
				DatabaseHandle databaseHandle = new DatabaseHandle(jdbi);
		
				AppRegistration.registerConsumers(viewProvider, ServerConfiguration.REPLAY);
		
				LOG.info("START EVENT REPLAY");
				try {
					databaseHandle.beginTransaction();
					Handle handle = databaseHandle.getHandle();
					daoProvider.truncateAllViews(handle);
		
					List<ITimelineItem> timeline = daoProvider.getAceDao().selectReplayTimeline(handle);
		
					int i = 0;
					for (ITimelineItem nextEvent : timeline) {
						IEvent event = EventFactory.createEvent(nextEvent.getName(), nextEvent.getData(), daoProvider, viewProvider);
						event.notifyListeners(databaseHandle.getHandle());
						i++;
						if (i%1000 == 0) {
							LOG.info("published " + i + " events");
						}
						//LOG.info("published " + nextEvent.getUuid() + " - " + nextEvent.getName());
					}
		
					databaseHandle.commitTransaction();
		
					LOG.info("EVENT REPLAY FINISHED: successfully replayed " + i + " events");
		
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
			private E2E e2e;
		
			public PrepareE2EResource(Jdbi jdbi, IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
				super();
				this.jdbi = jdbi;
				this.daoProvider = daoProvider;
				this.viewProvider = viewProvider;
				this.e2e = e2e;
			}
		
			@PUT
			@Timed
			@Path("/prepare")
			public Response put(@NotNull @QueryParam("uuid") String uuid) {
				DatabaseHandle databaseHandle = new DatabaseHandle(jdbi);
				LOG.info("PREPARE ACTION " + uuid);
				try {
					databaseHandle.beginTransaction();
		
					int eventCount = 0;
					ITimelineItem nextAction = e2e.selectNextAction();
					while (nextAction != null && !nextAction.getUuid().equals(uuid)) {
						if (!nextAction.getMethod().equalsIgnoreCase("GET")) {
							ITimelineItem nextEvent = e2e.selectEvent(nextAction.getUuid());
							if (nextEvent != null) {
								LOG.info("PUBLISH EVENT " + nextEvent.getUuid() + " - " + nextEvent.getName());
								IEvent event = EventFactory.createEvent(nextEvent.getName(), nextEvent.getData(), daoProvider, viewProvider);
								if (event != null) {
									event.notifyListeners(databaseHandle.getHandle());
									daoProvider.getAceDao().addPreparingEventToTimeline(event, nextAction.getUuid(), databaseHandle.getTimelineHandle());
									eventCount++;
								} else {
									LOG.error("failed to create " + nextEvent.getName());
								}
							}
						}
						nextAction = e2e.selectNextAction();
					}
		
					databaseHandle.commitTransaction();
					return Response.ok("prepared action " + uuid + " by publishing " + eventCount + " events").build();
				} catch (Exception e) {
					databaseHandle.rollbackTransaction();
					LOG.error("exception during prepare action " + uuid);
					LOG.error(e.getMessage());
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
		
			private E2E e2e;
			
			public StopE2ESessionResource(E2E e2e) {
				super();
				this.e2e = e2e;
			}
		
			@PUT
			@Timed
			@Path("/stop")
			public Response put() {
				e2e.reset();
				return Response.ok().build();
			}
		
		}
		
	'''

	def generateAceOperation() '''
		package com.anfelisa.ace;
		
		public class AceOperation {
		
			private ITimelineItem action;
			private ITimelineItem command;
			private ITimelineItem event;
			private String uuid;
		
			public AceOperation(String uuid) {
				super();
				this.uuid = uuid;
			}
			public ITimelineItem getAction() {
				return action;
			}
			public ITimelineItem getCommand() {
				return command;
			}
			public ITimelineItem getEvent() {
				return event;
			}
			public void setAction(ITimelineItem action) {
				this.action = action;
			}
			public void setCommand(ITimelineItem command) {
				this.command = command;
			}
			public void setEvent(ITimelineItem event) {
				this.event = event;
			}
			public String getUuid() {
				return uuid;
			}
			
		}
		
	'''

	def generateAceDao() '''
		package com.anfelisa.ace;
		
		import java.util.List;
		import java.util.Optional;
		
		import org.jdbi.v3.core.Handle;
		import org.jdbi.v3.core.statement.Update;
		
		import com.fasterxml.jackson.core.JsonProcessingException;
		import javax.ws.rs.WebApplicationException;
		
		public class AceDao {
		
			private JodaObjectMapper mapper = new JodaObjectMapper();
		
			public void truncateTimelineTable(Handle handle) {
				handle.execute("TRUNCATE TABLE timeline");
			}
		
			public boolean contains(Handle handle, String uuid) {
				Optional<Integer> optional = handle
						.createQuery("SELECT count(uuid) " + "FROM timeline "
								+ "where uuid = :uuid")
						.bind("uuid", uuid)
						.mapTo((Integer.class)).findFirst();
				Integer count = optional.isPresent() ? optional.get() : 0;
				return count > 0;
			}
		
			public void insertIntoTimeline(Handle handle, String type, String method, String name, String data, String uuid) {
				Update statement = handle.createUpdate("INSERT INTO timeline (type, method, name, time, data, uuid) " + "VALUES (:type, :method, :name, NOW(), :data, :uuid);");
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
						.createQuery("SELECT type, method, name, time, data, uuid FROM timeline order by time desc limit 1")
						.map(new TimelineItemMapper())
						.findFirst();
				return optional.isPresent() ? optional.get() : null;
			}
		
			public List<ITimelineItem> selectTimeline(Handle handle) {
				return handle
						.createQuery("SELECT type, method, name, time, data, uuid FROM timeline order by time asc")
						.map(new TimelineItemMapper()).list();
			}
			
			public List<ITimelineItem> selectReplayTimeline(Handle handle) {
				return handle
						.createQuery("SELECT type, method, name, time, data, uuid FROM timeline where type = 'event' order by time asc ")
						.map(new TimelineItemMapper()).list();
			}
			
			public void addActionToTimeline(IAction action, Handle timelineHandle) {
				try {
					String json = mapper.writeValueAsString(action.getActionData());
					addItemToTimeline("action", action.getHttpMethod().name(), action.getActionName(), json,
							action.getActionData().getUuid(), timelineHandle);
				} catch (JsonProcessingException e) {
					throw new WebApplicationException(e);
				}
			}
		
			public void addCommandToTimeline(ICommand command, Handle timelineHandle) {
				try {
					addItemToTimeline("command", null, command.getCommandName(),
							mapper.writeValueAsString(command.getCommandData()), command.getCommandData().getUuid(),
							timelineHandle);
				} catch (JsonProcessingException e) {
					throw new WebApplicationException(e);
				}
			}
		
			public void addEventToTimeline(IEvent event, Handle timelineHandle) {
				try {
					addItemToTimeline("event", null, event.getEventName(), mapper.writeValueAsString(event.getEventData()),
							event.getEventData().getUuid(), timelineHandle);
				} catch (JsonProcessingException e) {
					throw new WebApplicationException(e);
				}
			}
		
			public void addPreparingEventToTimeline(IEvent event, String uuid, Handle timelineHandle) {
				try {
					addItemToTimeline("preparing event", null, event.getEventName(),
							mapper.writeValueAsString(event.getEventData()), uuid, timelineHandle);
				} catch (JsonProcessingException e) {
					throw new WebApplicationException(e);
				}
			}
		
			public void addExceptionToTimeline(String uuid, Throwable x, Handle timelineHandle) {
				this.insertIntoTimeline(timelineHandle, "exception", "", x.getClass().getName(),
						x.getMessage() != null ? x.getMessage() : "", uuid);
			}
		
			private void addItemToTimeline(String type, String method, String name, String json, String uuid,
					Handle timelineHandle) {
				this.insertIntoTimeline(timelineHandle, type, method, name, json, uuid);
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
		
		public abstract class AbstractDaoProvider implements IDaoProvider {
		
			protected final AceDao aceDao = new AceDao();
		
			@Override
			public AceDao getAceDao() {
				return this.aceDao;
			}
			
		}
		
	'''

	def generateDaoProvider() '''
		package com.anfelisa.ace;
		
		import org.jdbi.v3.core.Handle;
		
		public class DaoProvider extends AbstractDaoProvider implements IDaoProvider {
			
			public static IDaoProvider create() {
				return new DaoProvider();
			}
			
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
		
		}
		
	'''

	def generateViewProvider() '''
		package com.anfelisa.ace;
		
		import java.util.ArrayList;
		import java.util.HashMap;
		import java.util.List;
		import java.util.Map;
		
		public class ViewProvider extends AbstractViewProvider {
		
			public ViewProvider() {
			}
		
			public static ViewProvider create() {
				return new ViewProvider();
			}
		
		}
		
	'''

	def generateAbstractViewProvider() '''
		package com.anfelisa.ace;
		
		import java.util.ArrayList;
		import java.util.HashMap;
		import java.util.List;
		import java.util.Map;
		
		public class AbstractViewProvider {
		
			private final Map<String, List<EventConsumer>> consumerMap;
		
			public AbstractViewProvider() {
				consumerMap = new HashMap<String, List<EventConsumer>>();
			}
			
			public void addConsumer(String eventName, EventConsumer eventConsumer) {
				List<EventConsumer> consumerForEvent = consumerMap.get(eventName);
				if (consumerForEvent == null) {
					consumerForEvent = new ArrayList<EventConsumer>();
					consumerMap.put(eventName, consumerForEvent);
				}
				consumerForEvent.add(eventConsumer);
			}
		
			public List<EventConsumer> getConsumerForEvent(String eventName) {
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
			<column name="data" type="text">
				<constraints nullable="false" />
			</column>
			<column name="uuid" type="character varying">
				<constraints nullable="false" />
			</column>
		</createTable>
		
		<addUniqueConstraint columnNames="type, uuid" tableName="timeline" />
		
	'''

	def generateAuthUser(AuthUser it) '''
		package com.anfelisa.auth;
		
		import java.security.Principal;
		
		public class «name.toFirstUpper» implements Principal {
		
			«FOR attribute : attributes»
				«attribute.declaration»
				
			«ENDFOR»
		
			public «name.toFirstUpper» (
				«FOR attribute : attributes SEPARATOR ','»
					«attribute.param(false)»
				«ENDFOR»
			) {
				«FOR attribute : attributes»
					«attribute.assign»
				«ENDFOR»
			}
		
			«FOR attribute : attributes»
				«attribute.getter(false)»
				
			«ENDFOR»
			public String getName() {
				return "AuthUser";
			}
		}
		
		/*       S.D.G.       */
	'''

	def generateEventconsumer() '''
		package com.anfelisa.ace;
		
		import org.jdbi.v3.core.Handle;
		
		@FunctionalInterface
		public interface EventConsumer {
			public void consumeEvent(IDataContainer data, Handle handle);
		}
	'''

	def generateBaseTest() '''
		package com.anfelisa.ace;
		
		import java.util.ArrayList;
		import java.util.List;
		import java.util.UUID;
		
		import javax.ws.rs.client.Client;
		import javax.ws.rs.client.Entity;
		
		import org.glassfish.jersey.client.JerseyClientBuilder;
		import org.jdbi.v3.core.Handle;
		import org.joda.time.DateTime;

		public abstract class AbstractBaseTest {
		
			protected final JodaObjectMapper mapper = new JodaObjectMapper();
		
			protected DaoProvider daoProvider;
		
			protected Handle handle;
		
			public static String randomUUID() {
				return UUID.randomUUID().toString();
			}
		
			protected void prepare(List<ITimelineItem> timeline, int port) {
				Client client = new JerseyClientBuilder().build();
				client.target(String.format("http://localhost:%d/api/test/replay-events", port))
						.request().put(Entity.json(timeline));
			}
		
			protected void prepare(int port) {
				List<ITimelineItem> timeline = new ArrayList<>();
				Client client = new JerseyClientBuilder().build();
				client.target(String.format("http://localhost:%d/api/test/replay-events", port))
						.request().put(Entity.json(timeline));
			}
		
			protected void setSystemTime(DateTime systemTime, int port) {
				Client client = new JerseyClientBuilder().build();
				client.target(String.format("http://localhost:%d/api/test/system-time", port))
						.request().put(Entity.json(systemTime.toString()));
			}
		
		}
		
	'''

	def generateTestUtils(JAVA it) '''
		package «name»;
		
		import com.anfelisa.ace.JodaObjectMapper;
		import com.anfelisa.ace.TimelineItem;
		import com.fasterxml.jackson.core.JsonProcessingException;
		
		public class TestUtils {
		
			private static final JodaObjectMapper mapper = new JodaObjectMapper();
		
			«FOR aceOperation : aceOperations»
				«aceOperation.createTimelineItem»

			«ENDFOR»
			
		}
		
	'''
	
	private def dispatch createTimelineItem(JAVA_ACE_WRITE it) '''
		«FOR outcome : outcomes»
			public static TimelineItem create«eventName(outcome)»TimelineItem(«model.dataInterfaceNameWithPackage» data) throws JsonProcessingException {
				String json = mapper.writeValueAsString(data);
				return new TimelineItem("prepare", null, "«eventNameWithPackage(outcome)»", null, json, data.getUuid());
			}
		«ENDFOR»
	'''

	private def dispatch createTimelineItem(JAVA_ACE_READ it) ''''''

	def generateActionCalls(JAVA it) '''
		package «name»;
		
		import javax.ws.rs.client.Client;
		import javax.ws.rs.client.Entity;
		import javax.ws.rs.client.Invocation.Builder;
		import javax.ws.rs.core.Response;
		
		import org.glassfish.jersey.client.JerseyClientBuilder;
		
		@SuppressWarnings("unused")
		public class ActionCalls {
		
			«FOR aceOperation : aceOperations»
				«IF aceOperation.type == "POST"»
					public static Response call«aceOperation.name.toFirstUpper»(«FOR param : mergeAttributesForPost(aceOperation) SEPARATOR ', '»«param»«ENDFOR»«IF aceOperation.authorize», String authorization«ENDIF») {
						Client client = new JerseyClientBuilder().build();
						Builder builder = client.target(String.format("http://localhost:%d/api«aceOperation.urlWithPathParams»", port)).request(); 
						«aceOperation.model.dataInterfaceNameWithPackage» data = new «aceOperation.model.dataNameWithPackage»(uuid);
						«IF aceOperation.payload.length > 0»
							«FOR param : aceOperation.payload»
								data.«param.setterCall(param.name.toFirstLower)»;
							«ENDFOR»
						«ENDIF»
						«IF aceOperation.authorize»
							builder.header("Authorization", authorization);
						«ENDIF»
						return builder.post(Entity.json(data));
					}
				«ELSEIF aceOperation.type == "PUT"»
					public static Response call«aceOperation.name.toFirstUpper»(«FOR param : mergeAttributesForPut(aceOperation) SEPARATOR ', '»«param»«ENDFOR»«IF aceOperation.authorize», String authorization«ENDIF») {
						Client client = new JerseyClientBuilder().build();
						Builder builder = client.target(String.format("http://localhost:%d/api«aceOperation.urlWithPathParams»?uuid=" + uuid«FOR queryParam : aceOperation.queryParams» + "&«queryParam.name»=" + «queryParam.name»«ENDFOR», port)).request();
						«aceOperation.model.dataInterfaceNameWithPackage» data = new «aceOperation.model.dataNameWithPackage»(uuid);
						«FOR param : aceOperation.payload»
							data.«param.setterCall(param.name.toFirstLower)»;
						«ENDFOR»
						«IF aceOperation.authorize»
							builder.header("Authorization", authorization);
						«ENDIF»
						return builder.put(Entity.json(«IF aceOperation.payload.length > 0»data«ELSE»null«ENDIF»));
					}
				«ELSEIF aceOperation.type == "DELETE"»
					public static Response call«aceOperation.name.toFirstUpper»(«FOR param : mergeAttributesForDelete(aceOperation) SEPARATOR ', '»«param»«ENDFOR»«IF aceOperation.authorize», String authorization«ENDIF») {
						Client client = new JerseyClientBuilder().build();
						Builder builder = client.target(String.format("http://localhost:%d/api«aceOperation.urlWithPathParams»?uuid=" + uuid«FOR queryParam : aceOperation.queryParams» + "&«queryParam.name»=" + «queryParam.name»«ENDFOR», port)).request();
						«IF aceOperation.authorize»
							builder.header("Authorization", authorization);
						«ENDIF»
						return builder.delete();
					}
				«ELSE»
					public static Response call«aceOperation.name.toFirstUpper»(«FOR param : mergeAttributesForGet(aceOperation) SEPARATOR ', '»«param»«ENDFOR»«IF aceOperation.authorize», String authorization«ENDIF») {
						Client client = new JerseyClientBuilder().build();
						Builder builder = client.target(String.format("http://localhost:%d/api«aceOperation.urlWithPathParams»?uuid=" + uuid«FOR queryParam : aceOperation.queryParams» + "&«queryParam.name»=" + «queryParam.name»«ENDFOR», port)).request(); 
						«IF aceOperation.authorize»
							builder.header("Authorization", authorization);
						«ENDIF»
						return builder.get();
					}
				«ENDIF»
				
			«ENDFOR»
			
		}
		
	'''

}
