/**
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
 */
package de.acegen.templates.java;

import de.acegen.aceGen.AuthUser;
import de.acegen.extensions.CommonExtension;
import javax.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class DropwizardApp {
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  public CharSequence generate(final AuthUser authUser) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.util.EnumSet;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import javax.servlet.DispatcherType;");
    _builder.newLine();
    _builder.append("import javax.servlet.FilterRegistration;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.jetty.servlets.CrossOriginFilter;");
    _builder.newLine();
    _builder.append("import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;");
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.Jdbi;");
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import de.acegen.resources.GetServerInfoResource;");
    _builder.newLine();
    _builder.append("import de.acegen.resources.NonDeterministicDataProviderResource;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.codahale.metrics.servlets.AdminServlet;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import io.dropwizard.Application;");
    _builder.newLine();
    _builder.append("import io.dropwizard.auth.AuthDynamicFeature;");
    _builder.newLine();
    _builder.append("import io.dropwizard.auth.AuthValueFactoryProvider;");
    _builder.newLine();
    _builder.append("import io.dropwizard.auth.basic.BasicCredentialAuthFilter;");
    _builder.newLine();
    _builder.append("import io.dropwizard.db.DataSourceFactory;");
    _builder.newLine();
    _builder.append("import io.dropwizard.jdbi3.JdbiFactory;");
    _builder.newLine();
    _builder.append("import io.dropwizard.jdbi3.bundles.JdbiExceptionsBundle;");
    _builder.newLine();
    _builder.append("import io.dropwizard.migrations.MigrationsBundle;");
    _builder.newLine();
    _builder.append("import io.dropwizard.setup.Bootstrap;");
    _builder.newLine();
    _builder.append("import io.dropwizard.setup.Environment;");
    _builder.newLine();
    _builder.newLine();
    {
      if ((authUser != null)) {
        _builder.append("//import de.acegen.auth.");
        String _firstUpper = StringExtensions.toFirstUpper(authUser.getName());
        _builder.append(_firstUpper);
        _builder.append(";");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class App extends Application<CustomAppConfiguration> {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(App.class);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static String mode;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void main(String[] args) throws Exception {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new App().run(args);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String getName() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return \"app name\";");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static String getVersion() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return \"app version\";");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void initialize(Bootstrap<CustomAppConfiguration> bootstrap) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("bootstrap.addBundle(new MigrationsBundle<CustomAppConfiguration>() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("public DataSourceFactory getDataSourceFactory(CustomAppConfiguration configuration) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return configuration.getDataSourceFactory();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("});");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("//bootstrap.addCommand(new EventReplayCommand(this));");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void run(CustomAppConfiguration configuration, Environment environment) throws ClassNotFoundException {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("LOG.info(\"running version {}\", getVersion());");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("DaoProvider daoProvider = new DaoProvider();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ViewProvider viewProvider = ViewProvider.create(daoProvider, configuration);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("final JdbiFactory factory = new JdbiFactory();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), \"data-source-name\");");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("mode = configuration.getConfig().getMode();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("LOG.info(\"running in {} mode\", mode);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (Config.DEV.equals(mode)) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("environment.jersey().register(new NonDeterministicDataProviderResource());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("environment.jersey().register(new GetServerInfoResource());");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("JdbiExceptionsBundle dbiExceptionsBundle = new JdbiExceptionsBundle();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("environment.jersey().register(dbiExceptionsBundle);");
    _builder.newLine();
    {
      if ((authUser != null)) {
        _builder.append("\t\t");
        _builder.append("//environment.jersey()");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//\t\t.register(new AuthDynamicFeature(");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//\t\t\t\tnew BasicCredentialAuthFilter.Builder<");
        String _firstUpper_1 = StringExtensions.toFirstUpper(authUser.getName());
        _builder.append(_firstUpper_1, "\t\t");
        _builder.append(">()");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("//\t\t\t\t\t\t.setAuthenticator(new MyAuthenticator(new PersistenceConnection(jdbi)))");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//\t\t\t\t\t\t.setPrefix(\"basic\").setRealm(\"basic private realm\").buildAuthFilter()));");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//environment.jersey().register(new AuthValueFactoryProvider.Binder<>(");
        String _firstUpper_2 = StringExtensions.toFirstUpper(authUser.getName());
        _builder.append(_firstUpper_2, "\t\t");
        _builder.append(".class));");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("environment.jersey().register(RolesAllowedDynamicFeature.class);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("environment.jersey().register(new AdminServlet());");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("configureCors(environment);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("AppRegistration.registerResources(environment, new PersistenceConnection(jdbi), configuration, daoProvider,");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("viewProvider);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("AppRegistration.registerConsumers(viewProvider);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private void configureCors(Environment environment) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("final FilterRegistration.Dynamic cors = environment.servlets().addFilter(\"CORS\", CrossOriginFilter.class);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// Configure CORS parameters");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("cors.setInitParameter(\"allowedOrigins\", \"*\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("cors.setInitParameter(\"allowedHeaders\", \"X-Requested-With,Content-Type,Accept,Origin\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("cors.setInitParameter(\"allowedMethods\", \"OPTIONS,GET,PUT,POST,DELETE,HEAD\");");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// Add URL mapping");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, \"/*\");");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// DO NOT pass a preflight request to down-stream auth filters");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// unauthenticated preflight requests should be permitted by spec");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("cors.setInitParameter(CrossOriginFilter.CHAIN_PREFLIGHT_PARAM, Boolean.FALSE.toString());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}\t\t");
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
}
