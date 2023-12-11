/********************************************************************************
 * Copyright (c) 2020 Annette Pohl
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 ********************************************************************************/


package de.acegen.templates.java

import de.acegen.aceGen.AuthUser
import de.acegen.extensions.CommonExtension

class DropwizardApp {

	extension CommonExtension

	def generate(AuthUser authUser) '''
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
		
		import de.acegen.resources.GetServerInfoResource;
		import de.acegen.resources.SquishyDataProviderResource;

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
		
		«IF authUser !== null»//import de.acegen.auth.«authUser.name.toFirstUpper»;«ENDIF»
		
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
				//bootstrap.addCommand(new EventReplayCommand(this));
			}
		
			@Override
			public void run(CustomAppConfiguration configuration, Environment environment) throws ClassNotFoundException {
				LOG.info("running version {}", getVersion());
		
				DaoProvider daoProvider = new DaoProvider();
				ViewProvider viewProvider = ViewProvider.create(daoProvider, configuration);
		
				final JdbiFactory factory = new JdbiFactory();
		
				Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "data-source-name");
		
				mode = configuration.getConfig().getMode();
				LOG.info("running in {} mode", mode);
				if (Config.DEV.equals(mode)) {
					environment.jersey().register(new SquishyDataProviderResource());
				}
		
				environment.jersey().register(new GetServerInfoResource());
		
				JdbiExceptionsBundle dbiExceptionsBundle = new JdbiExceptionsBundle();
				environment.jersey().register(dbiExceptionsBundle);
				«IF authUser !== null»
					//environment.jersey()
					//		.register(new AuthDynamicFeature(
					//				new BasicCredentialAuthFilter.Builder<«authUser.name.toFirstUpper»>()
					//						.setAuthenticator(new MyAuthenticator(new PersistenceConnection(jdbi)))
					//						.setPrefix("basic").setRealm("basic private realm").buildAuthFilter()));
					//environment.jersey().register(new AuthValueFactoryProvider.Binder<>(«authUser.name.toFirstUpper».class));
				«ENDIF»
		
				environment.jersey().register(RolesAllowedDynamicFeature.class);
		
				environment.jersey().register(new AdminServlet());
		
				configureCors(environment);
		
				AppRegistration.registerResources(environment, new PersistenceConnection(jdbi), configuration, daoProvider,
						viewProvider);
				AppRegistration.registerConsumers(environment, viewProvider);
			}
		
			private void configureCors(Environment environment) {
				final FilterRegistration.Dynamic cors = environment.servlets().addFilter("CORS", CrossOriginFilter.class);
		
				// Configure CORS parameters
				cors.setInitParameter("allowedOrigins", "*");
				cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
				cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");
		
				// Add URL mapping
				cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
		
				// DO NOT pass a preflight request to down-stream auth filters
				// unauthenticated preflight requests should be permitted by spec
				cors.setInitParameter(CrossOriginFilter.CHAIN_PREFLIGHT_PARAM, Boolean.FALSE.toString());
			}
		
		}		
		
		«sdg»
		
	'''

	
}