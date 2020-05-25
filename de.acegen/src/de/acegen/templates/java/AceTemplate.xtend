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
 

package de.acegen.templates.java

import de.acegen.aceGen.AuthUser
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.java.AttributeExtension
import javax.inject.Inject

class AceTemplate {

	@Inject
	extension AttributeExtension

	@Inject
	extension CommonExtension
	
	def generateApp() '''
		«copyright»

		package de.acegen;
		
		import java.util.EnumSet;
		
		import javax.servlet.DispatcherType;
		import javax.servlet.FilterRegistration;
		
		import org.eclipse.jetty.servlets.CrossOriginFilter;
		import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
		import org.jdbi.v3.core.Jdbi;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import com.codahale.metrics.servlets.AdminServlet;
		
		import io.dropwizard.Application;
		import io.dropwizard.auth.AuthDynamicFeature;
		import io.dropwizard.auth.AuthValueFactoryProvider;
		import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
		import io.dropwizard.db.DataSourceFactory;
		import io.dropwizard.jdbi3.JdbiFactory;
		import io.dropwizard.jdbi3.bundles.JdbiExceptionsBundle;
		import io.dropwizard.migrations.MigrationsBundle;
		import io.dropwizard.setup.Bootstrap;
		import io.dropwizard.setup.Environment;
		
		//import de.acegen.auth.AuthUser;
		
		public class App extends Application<CustomAppConfiguration> {
		
			static final Logger LOG = LoggerFactory.getLogger(App.class);
		
			private static String mode;
		
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
		
				if (!Config.LIVE.equals(mode)) {
					bootstrap.addCommand(new EventReplayCommand(this));
				}
			}
		
			@Override
			public void run(CustomAppConfiguration configuration, Environment environment) throws ClassNotFoundException {
				LOG.info("running version {}", getVersion());
		
				DaoProvider daoProvider = new DaoProvider();
				ViewProvider viewProvider = new ViewProvider(daoProvider, configuration);
		
				final JdbiFactory factory = new JdbiFactory();
		
				Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "data-source-name");
		
				E2E e2e = new E2E();
		
				mode = configuration.getConfig().getMode();
				LOG.info("running in {} mode", mode);
				if (Config.REPLAY.equals(mode)) {
					environment.jersey().register(new PrepareE2EResource(jdbi, daoProvider, viewProvider, e2e, configuration));
					environment.jersey().register(new StartE2ESessionResource(jdbi, daoProvider, e2e, configuration));
					environment.jersey().register(new StopE2ESessionResource(e2e, configuration));
					environment.jersey().register(new GetServerTimelineResource(jdbi, configuration));
					LOG.warn("You are running in REPLAY mode. This is a security risc.");
				} else if (Config.DEV.equals(mode)) {
					environment.jersey().register(new GetServerTimelineResource(jdbi, configuration));
					LOG.warn("You are running in DEV mode. This is a security risc.");
				} else if (Config.TEST.equals(mode)) {
					LOG.warn("You are running in TEST mode and the database is going to be cleared.");
					PersistenceHandle handle = new PersistenceHandle(jdbi.open());
					daoProvider.truncateAllViews(handle);
					handle.getHandle().close();
					environment.jersey().register(new NotReplayableDataProviderResource());
				}
		
				environment.jersey().register(new GetServerInfoResource());
		
				JdbiExceptionsBundle dbiExceptionsBundle = new JdbiExceptionsBundle();
				environment.jersey().register(dbiExceptionsBundle);
		
				//environment.jersey()
				//		.register(new AuthDynamicFeature(
				//				new BasicCredentialAuthFilter.Builder<AuthUser>()
				//						.setAuthenticator(new MyAuthenticator(new PersistenceConnection(jdbi)))
				//						.setPrefix("basic").setRealm("basic private realm").buildAuthFilter()));
				//environment.jersey().register(new AuthValueFactoryProvider.Binder<>(AuthUser.class));
		
				environment.jersey().register(RolesAllowedDynamicFeature.class);
		
				environment.jersey().register(new AdminServlet());
		
				configureCors(environment);
		
				AppRegistration.registerResources(environment, new PersistenceConnection(jdbi), configuration, daoProvider,
						viewProvider, e2e);
				AppRegistration.registerConsumers(viewProvider, mode);
			}
		
			private void configureCors(Environment environment) {
				final FilterRegistration.Dynamic cors = environment.servlets().addFilter("CORS", CrossOriginFilter.class);
		
				// Configure CORS parameters
				cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
				cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM,
						"X-Requested-With,Content-Type,Accept,Origin,Authorization");
				cors.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "OPTIONS,GET,PUT,POST,DELETE,HEAD");
				cors.setInitParameter(CrossOriginFilter.ALLOW_CREDENTIALS_PARAM, "true");
		
				// Add URL mapping
				cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
		
			}
		
		}		
		
		«sdg»
		
	'''

	def generateAppRegistration() '''
		«copyright»
		
		package de.acegen;
		
		import io.dropwizard.setup.Environment;
		
		public class AppRegistration {
		
			public static void registerResources(Environment environment, PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration,
					IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
			}
		
			public static void registerConsumers(ViewProvider viewProvider, String mode) {
			}
		}
		
		«sdg»
		
		
	'''

	def generateE2E() '''
		«copyright»
		
		package de.acegen;
		
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

		
		«sdg»
		
	'''

	def generateConfig() '''
		«copyright»
		
		package de.acegen;
		
		import com.fasterxml.jackson.annotation.JsonProperty;

		public class Config {
			public static final String REPLAY = "REPLAY";
			public static final String LIVE = "LIVE";
			public static final String DEV = "DEV";
			public static final String TEST = "TEST";
		
			public static final String ALWAYS = "ALWAYS";
			public static final String ON_ERROR = "ON_ERROR";
			public static final String NEVER = "NEVER";
			
			private String mode = DEV;
			
			private String writeTimeline = ON_ERROR;
		
			@JsonProperty("mode")
			public String getMode() {
				return mode;
			}
		
			@JsonProperty("mode")
			public void setMode(String mode) {
				this.mode = mode;
			}
		
			@JsonProperty("writeTimeline")
			public String getWriteTimeline() {
				return writeTimeline;
			}
		
			@JsonProperty("writeTimeline")
			public void setWriteTimeline(String writeTimeline) {
				this.writeTimeline = writeTimeline;
			}
			
			public boolean writeTimeline() {
				return !NEVER.equals(writeTimeline);
			}
			
			public boolean writeError() {
				return ON_ERROR.equals(writeTimeline) || ALWAYS.equals(writeTimeline);
			}
	
		}
		
		«sdg»
		
	'''

	def generateAppConfiguration() '''
		«copyright»
		
		
		package de.acegen;
		
		import javax.validation.Valid;
		import javax.validation.constraints.NotNull;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		
		import io.dropwizard.Configuration;
		import io.dropwizard.db.DataSourceFactory;
		import io.dropwizard.server.DefaultServerFactory;
		import io.dropwizard.server.ServerFactory;
		
		public class AppConfiguration extends Configuration {
		
		    @Valid
		    @NotNull
		    private ServerFactory server = new DefaultServerFactory();
		
		    @JsonProperty("server")
		    public ServerFactory getServerFactory() {
		        return server;
		    }
		
		    @JsonProperty("server")
		    public void setServerFactory(ServerFactory factory) {
		        this.server = factory;
		    }
		
		    @Valid
			@NotNull
			private DataSourceFactory database = new DataSourceFactory();
		
			@JsonProperty("database")
			public DataSourceFactory getDataSourceFactory() {
				return database;
			}
		
			@JsonProperty("database")
			public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {
				this.database = dataSourceFactory;
			}
		
			@Valid
			@NotNull
			private Config config = new Config();
		
			@JsonProperty("config")
			public Config getConfig() {
				return config;
			}
		
			@JsonProperty("config")
			public void setConfig(Config config) {
				this.config = config;
			}
			
		}
				
		
		«sdg»
		
	'''

	def generateCustomAppConfiguration() '''
		«copyright»
		
		package de.acegen;
		
		public class CustomAppConfiguration extends AppConfiguration {
		
		}
		
		«sdg»
		
	'''

	def generateStartE2ESessionResource() '''
		«copyright»
		
		package de.acegen;
		
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
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import com.fasterxml.jackson.core.JsonProcessingException;
		
		@Path("/e2e")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public class StartE2ESessionResource {
		
			static final Logger LOG = LoggerFactory.getLogger(StartE2ESessionResource.class);
		
			private Jdbi jdbi;			
			private CustomAppConfiguration configuration;
		
			private IDaoProvider daoProvider = new DaoProvider();
			
			private E2E e2e;
		
			public StartE2ESessionResource(Jdbi jdbi, IDaoProvider daoProvider, E2E e2e, CustomAppConfiguration configuration) {
				super();
				this.jdbi = jdbi;
				this.daoProvider = daoProvider;
				this.e2e = e2e;
				this.configuration = configuration;
			}
		
			@PUT
			@Path("/start")
			public Response put(@NotNull List<ITimelineItem> timeline) throws JsonProcessingException {
				if (Config.LIVE.equals(configuration.getConfig().getMode())) {
					throw new WebApplicationException("start e2e session is not available in a live environment", Response.Status.FORBIDDEN);
				}
				if (e2e.isSessionRunning() && e2e.getSessionStartedAt().plusMinutes(1).isAfterNow()) {
					throw new WebApplicationException("session is already running", Response.Status.SERVICE_UNAVAILABLE);
				}
				e2e.init(timeline);
				
				PersistenceHandle handle = new PersistenceHandle(jdbi.open());
				try {
					handle.getHandle().begin();
					
					daoProvider.getAceDao().truncateTimelineTable(handle);
		
					daoProvider.truncateAllViews(handle);
		
					handle.getHandle().commit();
		
					return Response.ok().build();
				} catch (Exception e) {
					handle.getHandle().rollback();
					throw new WebApplicationException(e);
				} finally {
					handle.getHandle().close();
				}
			}
		
		}
		
		«sdg»
		
	'''

	def generateEventReplayCommand() '''
		«copyright»
		
		package de.acegen;
		
		import java.util.List;
		
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
				if (Config.LIVE.equals(configuration.getConfig().getMode())) {
					throw new RuntimeException("we won't truncate all views and replay events in a live environment");
				}
		
				IDaoProvider daoProvider = DaoProvider.create();
				ViewProvider viewProvider = ViewProvider.create(daoProvider, configuration);
		
				final JdbiFactory factory = new JdbiFactory();
				Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "data-source-name");
				DatabaseHandle databaseHandle = new DatabaseHandle(jdbi, configuration);
		
				AppRegistration.registerConsumers(viewProvider, Config.REPLAY);
		
				LOG.info("START EVENT REPLAY");
				try {
					databaseHandle.beginTransaction();
					PersistenceHandle handle = databaseHandle.getHandle();
					daoProvider.truncateAllViews(handle);
		
					List<ITimelineItem> timeline = daoProvider.getAceDao().selectReplayTimeline(handle);
		
					int i = 0;
					for (ITimelineItem nextEvent : timeline) {
						IEvent event = EventFactory.createEvent(nextEvent.getName(), nextEvent.getData(), daoProvider, viewProvider, configuration);
						if (event != null) {
							event.notifyListeners(databaseHandle.getHandle());
							i++;
							if (i%1000 == 0) {
								LOG.info("published " + i + " events");
							}
							//LOG.info("published " + nextEvent.getUuid() + " - " + nextEvent.getName());
						} else {
							LOG.info("event " + nextEvent.getName() + " seems to be obsolete and was not replayed");
						}
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
		
		
		«sdg»
		
	'''

	def generateNotReplayableDataProvider() '''
		«copyright»
		
			package de.acegen;
			
			import java.util.concurrent.ConcurrentHashMap;
			import java.util.concurrent.ConcurrentMap;
			
			import org.joda.time.DateTime;
			
			public class NotReplayableDataProvider {
				
				private static ConcurrentMap<String, DateTime> systemTimeMap = new ConcurrentHashMap<>();
		
				private static ConcurrentMap<String, ConcurrentMap<String, Object>> valueMap = new ConcurrentHashMap<>();
			
				public static DateTime consumeSystemTime(String uuid) {
					DateTime value = systemTimeMap.get(uuid);
					if (value != null) {
						systemTimeMap.remove(uuid);
					}
					return value;
				}
			
				public static void putSystemTime(String uuid, DateTime systemTime) {
					systemTimeMap.put(uuid, systemTime);
				}
				
				public static void put(String uuid, String key, Object value) {
					ConcurrentMap<String, Object> mapForUuid = valueMap.get(uuid);
					if (mapForUuid == null) {
						mapForUuid = new ConcurrentHashMap<String, Object>();
						valueMap.put(uuid, mapForUuid);
					}
					mapForUuid.put(key, value);
				}
				
				public static Object consumeValue(String uuid, String key) {
					ConcurrentMap<String, Object> mapForUuid = valueMap.get(uuid);
					if (mapForUuid == null) {
						return null;
					}
					Object value = mapForUuid.get(key);
					mapForUuid.remove(key);
					if (mapForUuid.size() == 0) {
						valueMap.remove(uuid);
					}
					return value;
				}
				
			}					
			
		«sdg»
		
	'''

	def generateNotReplayableDataProviderResource() '''
		«copyright»
		
		package de.acegen;
		
		import javax.ws.rs.Consumes;
		import javax.ws.rs.PUT;
		import javax.ws.rs.Path;
		import javax.ws.rs.Produces;
		import javax.ws.rs.QueryParam;
		import javax.ws.rs.core.MediaType;
		import javax.ws.rs.core.Response;
		
		import org.joda.time.DateTime;
		import org.joda.time.DateTimeZone;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		@Path("/test/not-replayable")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public class NotReplayableDataProviderResource {
		
			static final Logger LOG = LoggerFactory.getLogger(NotReplayableDataProviderResource.class);
		
			public NotReplayableDataProviderResource() {
				super();
			}
		
			@PUT
			@Path("/value")
			public Response putValue(@QueryParam("uuid") String uuid, @QueryParam("key") String key, String json) {
				NotReplayableDataProvider.put(uuid, key, json);
				return Response.ok().build();
			}
		
			@PUT
			@Path("/system-time")
			public Response putSystemTime(@QueryParam("uuid") String uuid, @QueryParam("system-time") String systemTime) {
				NotReplayableDataProvider.putSystemTime(uuid, DateTime.parse(systemTime).withZone(DateTimeZone.UTC));
				return Response.ok().build();
			}
			
		}
		
		
		«sdg»
		
	'''

	def generateGetServerInfoResource() '''
		«copyright»
		
		package de.acegen;
		
		import javax.ws.rs.Consumes;
		import javax.ws.rs.GET;
		import javax.ws.rs.Path;
		import javax.ws.rs.Produces;
		import javax.ws.rs.core.MediaType;
		import javax.ws.rs.core.Response;
		
		@Path("/server")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public class GetServerInfoResource {
		
			public GetServerInfoResource() {
				super();
			}
		
			@GET
			@Path("/info")
			public Response put() {
				return Response.ok(new ServerInfo(App.getVersion())).build();
			}
		
		}
		
		
		«sdg»
		
	'''

	def generateServerInfo() '''
		«copyright»
		
		package de.acegen;
		
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
		
		
		«sdg»
		
	'''

	def generateGetServerTimelineResource() '''
		«copyright»

		package de.acegen;
		
		import java.util.List;
		
		import javax.ws.rs.Consumes;
		import javax.ws.rs.GET;
		import javax.ws.rs.Path;
		import javax.ws.rs.Produces;
		import javax.ws.rs.WebApplicationException;
		import javax.ws.rs.core.MediaType;
		import javax.ws.rs.core.Response;
		
		import org.jdbi.v3.core.Jdbi;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		@Path("/e2e")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public class GetServerTimelineResource {
		
			private Jdbi jdbi;
			private CustomAppConfiguration configuration;
		
			static final Logger LOG = LoggerFactory.getLogger(GetServerTimelineResource.class);
		
			private AceDao aceDao = new AceDao();
		
			public GetServerTimelineResource(Jdbi jdbi, CustomAppConfiguration configuration) {
				super();
				this.jdbi = jdbi;
				this.configuration = configuration;
			}
		
			@GET
			@Path("/timeline")
			public Response get() {
				if (Config.LIVE.equals(configuration.getConfig().getMode())) {
					throw new WebApplicationException("get server timeline is not available in a live environment", Response.Status.FORBIDDEN);
				}
				PersistenceHandle timelineHandle = new PersistenceHandle(jdbi.open());
				
				try {
					List<ITimelineItem> serverTimeline = aceDao.selectTimeline(timelineHandle);
					return Response.ok(serverTimeline).build();
				} catch (Exception e) {
					throw new WebApplicationException(e);
				} finally {
					timelineHandle.getHandle().close();
				}
			}
		
		}
		
		«sdg»
		
	'''

	def generatePrepareE2EResource() '''
		«copyright»
		
		package de.acegen;
		
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
		
		@Path("/e2e")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public class PrepareE2EResource {
		
			private Jdbi jdbi;
			private CustomAppConfiguration configuration;
		
			static final Logger LOG = LoggerFactory.getLogger(PrepareE2EResource.class);
		
			private IDaoProvider daoProvider;
			private ViewProvider viewProvider;
			private E2E e2e;
		
			public PrepareE2EResource(Jdbi jdbi, IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e, CustomAppConfiguration configuration) {
				super();
				this.jdbi = jdbi;
				this.daoProvider = daoProvider;
				this.viewProvider = viewProvider;
				this.e2e = e2e;
				this.configuration = configuration;
			}
		
			@PUT
			@Path("/prepare")
			public Response put(@NotNull @QueryParam("uuid") String uuid) {
				if (Config.LIVE.equals(configuration.getConfig().getMode())) {
					throw new WebApplicationException("prepare e2e replay is not available in a live environment", Response.Status.FORBIDDEN);
				}
				DatabaseHandle databaseHandle = new DatabaseHandle(jdbi, configuration);
				LOG.info("PREPARE ACTION " + uuid);
				try {
					databaseHandle.beginTransaction();
		
					int eventCount = 0;
					ITimelineItem nextAction = e2e.selectNextAction();
					while (nextAction != null && !nextAction.getUuid().equals(uuid)) {
						ITimelineItem nextEvent = e2e.selectEvent(nextAction.getUuid());
						if (nextEvent != null) {
							LOG.info("PUBLISH EVENT " + nextEvent.getUuid() + " - " + nextEvent.getName());
							IEvent event = EventFactory.createEvent(nextEvent.getName(), nextEvent.getData(), daoProvider, viewProvider, configuration);
							if (event != null) {
								event.notifyListeners(databaseHandle.getHandle());
								daoProvider.getAceDao().addPreparingEventToTimeline(event, nextAction.getUuid(), databaseHandle.getTimelineHandle());
								eventCount++;
							} else {
								LOG.error("failed to create " + nextEvent.getName());
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
		
		
		«sdg»
		
	'''

	def generateStopE2ESessionResource() '''
		«copyright»
		
		package de.acegen;
		
		import javax.ws.rs.Consumes;
		import javax.ws.rs.PUT;
		import javax.ws.rs.Path;
		import javax.ws.rs.Produces;
		import javax.ws.rs.core.MediaType;
		import javax.ws.rs.core.Response;
		import javax.ws.rs.WebApplicationException;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		@Path("/e2e")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public class StopE2ESessionResource {
		
			static final Logger LOG = LoggerFactory.getLogger(StopE2ESessionResource.class);
		
			private E2E e2e;
			private CustomAppConfiguration configuration;
			
			public StopE2ESessionResource(E2E e2e, CustomAppConfiguration configuration) {
				super();
				this.e2e = e2e;
				this.configuration = configuration;
			}
		
			@PUT
			@Path("/stop")
			public Response put() {
				if (Config.LIVE.equals(configuration.getConfig().getMode())) {
					throw new WebApplicationException("stop e2e session is not available in a live environment", Response.Status.FORBIDDEN);
				}
				e2e.reset();
				return Response.ok().build();
			}
		
		}
		
		
		«sdg»
		
	'''

	def generateAceOperation() '''
		«copyright»
		
		package de.acegen;
		
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
		
		
		«sdg»
		
	'''

	def generateAceDao() '''
		«copyright»
		
		package de.acegen;

		import java.util.List;
		import java.util.Optional;
		import java.util.concurrent.ConcurrentLinkedQueue;
		
		import org.jdbi.v3.core.statement.Update;
		
		import com.fasterxml.jackson.core.JsonProcessingException;
		import javax.ws.rs.WebApplicationException;
		
		public class AceDao {
		
			private JodaObjectMapper mapper;
		
			private ConcurrentLinkedQueue<String> lastUuids;
		
			public AceDao() {
				mapper = new JodaObjectMapper();
				lastUuids = new ConcurrentLinkedQueue<>();
			}

			public boolean checkUuid(String uuid) {
				boolean alreadyUsed = lastUuids.contains(uuid);
				if (alreadyUsed) {
					return false;
				}
				lastUuids.add(uuid);
				if (lastUuids.size() > 1000) {
					lastUuids.remove();
				}
				return true;
			}

			public void truncateTimelineTable(PersistenceHandle handle) {
				handle.getHandle().execute("TRUNCATE TABLE timeline");
			}
		
			public boolean contains(PersistenceHandle handle, String uuid) {
				Optional<Integer> optional = handle.getHandle()
						.createQuery("SELECT count(uuid) " + "FROM timeline "
								+ "where uuid = :uuid")
						.bind("uuid", uuid)
						.mapTo((Integer.class)).findFirst();
				Integer count = optional.isPresent() ? optional.get() : 0;
				return count > 0;
			}
		
			public void insertIntoTimeline(PersistenceHandle handle, String type, String name, String data, String uuid) {
				Update statement = handle.getHandle().createUpdate("INSERT INTO timeline (type, name, time, data, uuid) " + "VALUES (:type, :name, NOW(), :data, :uuid);");
				statement.bind("type", type);
				statement.bind("name", name);
				statement.bind("data", data);
				statement.bind("uuid", uuid);
				statement.execute();
			}
		
			public ITimelineItem selectLastAction(PersistenceHandle handle) {
				Optional<ITimelineItem> optional = handle.getHandle()
						.createQuery("SELECT type, name, time, data, uuid FROM timeline order by time desc limit 1")
						.map(new TimelineItemMapper())
						.findFirst();
				return optional.isPresent() ? optional.get() : null;
			}
		
			public List<ITimelineItem> selectTimeline(PersistenceHandle handle) {
				return handle.getHandle()
						.createQuery("SELECT type, name, time, data, uuid FROM timeline order by time asc")
						.map(new TimelineItemMapper()).list();
			}
			
			public List<ITimelineItem> selectReplayTimeline(PersistenceHandle handle) {
				return handle.getHandle()
						.createQuery("SELECT type, name, time, data, uuid FROM timeline where type = 'event' order by time asc ")
						.map(new TimelineItemMapper()).list();
			}
			
			public void addActionToTimeline(IAction action, PersistenceHandle timelineHandle) {
				try {
					String json = mapper.writeValueAsString(action.getActionData());
					addItemToTimeline("action", action.getActionName(), json,
							action.getActionData().getUuid(), timelineHandle);
				} catch (JsonProcessingException e) {
					throw new WebApplicationException(e);
				}
			}
		
			public void addCommandToTimeline(ICommand command, PersistenceHandle timelineHandle) {
				try {
					addItemToTimeline("command", command.getCommandName(),
							mapper.writeValueAsString(command.getCommandData()), command.getCommandData().getUuid(),
							timelineHandle);
				} catch (JsonProcessingException e) {
					throw new WebApplicationException(e);
				}
			}
		
			public void addEventToTimeline(IEvent event, PersistenceHandle timelineHandle) {
				try {
					addItemToTimeline("event", event.getEventName(), mapper.writeValueAsString(event.getEventData()),
							event.getEventData().getUuid(), timelineHandle);
				} catch (JsonProcessingException e) {
					throw new WebApplicationException(e);
				}
			}
		
			public void addPreparingEventToTimeline(IEvent event, String uuid, PersistenceHandle timelineHandle) {
				try {
					addItemToTimeline("preparing event", event.getEventName(),
							mapper.writeValueAsString(event.getEventData()), uuid, timelineHandle);
				} catch (JsonProcessingException e) {
					throw new WebApplicationException(e);
				}
			}
		
			public void addExceptionToTimeline(String uuid, Throwable x, PersistenceHandle timelineHandle) {
				this.insertIntoTimeline(timelineHandle, "exception", x.getClass().getName(),
						x.getMessage() != null ? x.getMessage() : "", uuid);
			}
		
			private void addItemToTimeline(String type, String name, String json, String uuid,
					PersistenceHandle timelineHandle) {
				this.insertIntoTimeline(timelineHandle, type, name, json, uuid);
			}
		
		}
		
		«sdg»
		
	'''

	def generateITimelineItem() '''
		«copyright»
		
		package de.acegen;
		
		import org.joda.time.DateTime;
		import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
		
		@JsonDeserialize(as=TimelineItem.class)
		public interface ITimelineItem {
		
			String getType();
			
			String getName();
			
			DateTime getTimestamp();
			
			String getData();
			
			String getUuid();
		}
		
		
		«sdg»
		
	'''

	def generateJodaObjectMapper() '''
		«copyright»
		
		package de.acegen;
		
		import com.fasterxml.jackson.databind.ObjectMapper;
		import com.fasterxml.jackson.datatype.joda.JodaModule;
		
		public class JodaObjectMapper extends ObjectMapper {
		
			private static final long serialVersionUID = 3204337293769989499L;
		
			public JodaObjectMapper() {
			       super();
			       registerModule(new JodaModule());
			   }
		}
		
		«sdg»
		
	'''

	def generateTimelineItem() '''
		«copyright»
		
		package de.acegen;
		
		import org.joda.time.DateTime;
		import com.fasterxml.jackson.annotation.JsonProperty;
		
		public class TimelineItem implements ITimelineItem {
		
			private String type;
			
			private String name;
			
			private DateTime timestamp;
			
			private String data;
			
			private String uuid;
		
			
			public TimelineItem(
				@JsonProperty("type") String type, 
				@JsonProperty("name") String name, 
				@JsonProperty("timestamp") DateTime timestamp, 
				@JsonProperty("data") String data,
				@JsonProperty("uuid") String uuid
			) {
				super();
				this.type = type;
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
				return "TimelineItem [type=" + type + ", name=" + name + ", timestamp="
						+ timestamp + ", uuid=" + uuid + "]";
			}
		
		}
		
		
		«sdg»
		
	'''

	def generateTimelineItemMapper() '''
		«copyright»
		
		package de.acegen;
		
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
					r.getString("name"),
					time,
					r.getString("data"),
					r.getString("uuid")
				);
			}
		}
		
		«sdg»
		
	'''

	def generateAbstractDaoProvider() '''
		«copyright»
		
		package de.acegen;
		
		public abstract class AbstractDaoProvider implements IDaoProvider {
		
			protected final AceDao aceDao = new AceDao();
		
			@Override
			public AceDao getAceDao() {
				return this.aceDao;
			}
			
		}
		
		
		«sdg»
		
	'''

	def generateDaoProvider() '''
		«copyright»
		
		package de.acegen;
		
		public class DaoProvider extends AbstractDaoProvider implements IDaoProvider {
			
			public static IDaoProvider create() {
				return new DaoProvider();
			}
			
			@Override
			public void truncateAllViews(PersistenceHandle handle) {
			}
			
		}
		
		
		«sdg»
		
	'''

	def generateIDaoProvider() '''
		«copyright»
		
		package de.acegen;
		
		public interface IDaoProvider {
			
			void truncateAllViews(PersistenceHandle handle);
			
			AceDao getAceDao();
		
		}
		
		
		«sdg»
		
	'''

	def generateViewProvider() '''
		«copyright»
		
		package de.acegen;
		
		public class ViewProvider extends AbstractViewProvider {
		
			public ViewProvider() {
			}
		
			public static ViewProvider create(IDaoProvider daoProvider, CustomAppConfiguration configuration) {
				return new ViewProvider();
			}
		
		}
		
		
		«sdg»
		
	'''

	def generateAbstractViewProvider() '''
		«copyright»
		
		package de.acegen;
		
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
		
		
		«sdg»
		
	'''

	def generateAceMigration() '''
		<createTable tableName="timeline">
			<column name="type" type="character varying">
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
		«copyright»
		
		package de.acegen.auth;
		
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
		
		
		«sdg»
		
	'''

	def generatePersistenceHandle() '''
		«copyright»

		package de.acegen;
		
		import org.jdbi.v3.core.Handle;
		
		public class PersistenceHandle {
			
			private Handle handle;
		
			public PersistenceHandle(Handle handle) {
				super();
				this.handle = handle;
			}
		
			public Handle getHandle() {
				return handle;
			}
		
		}
		
		«sdg»
		
	'''

	def generatePersistenceConnection() '''
		«copyright»

		package de.acegen;
		
		import org.jdbi.v3.core.Jdbi;
		
		public class PersistenceConnection {
		
			private Jdbi jdbi;
		
			public PersistenceConnection(Jdbi jdbi) {
				super();
				this.jdbi = jdbi;
			}
		
			public Jdbi getJdbi() {
				return jdbi;
			}
			
		}
		
		«sdg»
		
	'''

	def generateDateTimeToStringConverter() '''
		«copyright»
		
		package de.acegen;
		
		import org.joda.time.DateTime;
		
		import com.fasterxml.jackson.databind.util.StdConverter;
		
		public class DateTimeToStringConverter extends StdConverter<DateTime, String> {
			@Override
			public String convert(DateTime value) {
				return value.toString();
			}
		}
		
		«sdg»
		
	'''

	def generateStringToDateTimeConverter() '''
		«copyright»
		
		package de.acegen;
		
		import org.joda.time.DateTime;
		import org.joda.time.DateTimeZone;
		
		import com.fasterxml.jackson.databind.util.StdConverter;
		
		public class StringToDateTimeConverter extends StdConverter<String, DateTime> {
			@Override
			public DateTime convert(String value) {
				return DateTime.parse(value).withZone(DateTimeZone.UTC);
			}
		}
		
		«sdg»
		
	'''

	

}
	
	
/******* S.D.G. *******/
	
	
