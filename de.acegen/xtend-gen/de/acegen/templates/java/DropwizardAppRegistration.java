package de.acegen.templates.java;

import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.java.AceExtension;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class DropwizardAppRegistration {
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  @Inject
  @Extension
  private AceExtension _aceExtension;
  
  @Inject
  private AppRegistration appRegistration;
  
  public CharSequence generateAppRegistration(final HttpServer it) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = it.getName();
    _builder.append(_name);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import io.dropwizard.setup.Environment;");
    _builder.newLine();
    _builder.append("import de.acegen.PersistenceConnection;");
    _builder.newLine();
    _builder.append("import de.acegen.CustomAppConfiguration;");
    _builder.newLine();
    _builder.append("import de.acegen.IDaoProvider;");
    _builder.newLine();
    _builder.append("import de.acegen.E2E;");
    _builder.newLine();
    _builder.append("import de.acegen.ViewProvider;");
    _builder.newLine();
    _builder.newLine();
    {
      int _size = it.getAceOperations().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _builder.append("import ");
        String _name_1 = it.getName();
        _builder.append(_name_1);
        _builder.append(".resources.*;");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"all\")");
    _builder.newLine();
    _builder.append("public class AppRegistration {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void registerResources(Environment environment, PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {");
    _builder.newLine();
    {
      EList<HttpServerAce> _aceOperations = it.getAceOperations();
      for(final HttpServerAce aceOperation : _aceOperations) {
        _builder.append("\t\t");
        _builder.append("environment.jersey().register(new ");
        String _resourceName = this._aceExtension.resourceName(aceOperation);
        _builder.append(_resourceName, "\t\t");
        _builder.append("(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e));");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _registerConsumers = this.appRegistration.registerConsumers(it);
    _builder.append(_registerConsumers, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateAppRegistration() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import io.dropwizard.setup.Environment;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class AppRegistration {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void registerResources(Environment environment, PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration,");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void registerConsumers(ViewProvider viewProvider, String mode) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
}
