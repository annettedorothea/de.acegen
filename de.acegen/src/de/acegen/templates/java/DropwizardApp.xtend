package de.acegen.templates.java

import de.acegen.extensions.CommonExtension
import javax.inject.Inject

class DropwizardApp {

	@Inject
	extension CommonExtension

	def generate() '''
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

	
}