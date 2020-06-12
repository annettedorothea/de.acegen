package de.acegen.templates.java;

import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.HttpServerAceRead;
import de.acegen.aceGen.HttpServerAceWrite;
import de.acegen.aceGen.HttpServerOutcome;
import de.acegen.aceGen.HttpServerViewFunction;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.java.AceExtension;
import de.acegen.extensions.java.ModelExtension;
import de.acegen.extensions.java.ViewExtension;
import java.util.Arrays;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class AppRegistration {
  @Inject
  @Extension
  private ModelExtension _modelExtension;
  
  @Inject
  @Extension
  private AceExtension _aceExtension;
  
  @Inject
  @Extension
  private ViewExtension _viewExtension;
  
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  public CharSequence generateAppRegistration(final HttpServer it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("package ");
    String _name = it.getName();
    _builder.append(_name, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import de.acegen.ViewProvider;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@SuppressWarnings(\"all\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public class AppRegistration {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _registerConsumers = this.registerConsumers(it);
    _builder.append(_registerConsumers, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
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
    _builder.append("public class AppRegistration {");
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
  
  public CharSequence registerConsumers(final HttpServer it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public static void registerConsumers(ViewProvider viewProvider, String mode) {");
    _builder.newLine();
    {
      EList<HttpServerAce> _aceOperations = it.getAceOperations();
      for(final HttpServerAce aceOperation : _aceOperations) {
        _builder.append("\t");
        CharSequence _registerConsumer = this.registerConsumer(aceOperation, it);
        _builder.append(_registerConsumer, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence _registerConsumer(final HttpServerAceWrite it, final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<HttpServerOutcome> _outcomes = it.getOutcomes();
      for(final HttpServerOutcome outcome : _outcomes) {
        {
          EList<HttpServerViewFunction> _listeners = outcome.getListeners();
          for(final HttpServerViewFunction listener : _listeners) {
            CharSequence _addConsumers = this.addConsumers(httpServer, it, outcome, listener);
            _builder.append(_addConsumers);
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  private CharSequence _registerConsumer(final HttpServerAceRead it, final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  private CharSequence addConsumers(final HttpServer java, final HttpServerAce aceOperation, final HttpServerOutcome outcome, final HttpServerViewFunction listener) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("viewProvider.addConsumer(\"");
    String _name = java.getName();
    _builder.append(_name);
    _builder.append(".events.");
    String _eventName = this._aceExtension.eventName(aceOperation, outcome);
    _builder.append(_eventName);
    _builder.append("\", (dataContainer, handle) -> {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("viewProvider.");
    String _viewFunctionWithViewNameAsVariable = this._viewExtension.viewFunctionWithViewNameAsVariable(listener);
    _builder.append(_viewFunctionWithViewNameAsVariable, "\t");
    _builder.append("((");
    String _dataNameWithPackage = this._modelExtension.dataNameWithPackage(listener.getModel());
    _builder.append(_dataNameWithPackage, "\t");
    _builder.append(") dataContainer, handle);");
    _builder.newLineIfNotEmpty();
    _builder.append("});");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence registerConsumer(final HttpServerAce it, final HttpServer httpServer) {
    if (it instanceof HttpServerAceRead) {
      return _registerConsumer((HttpServerAceRead)it, httpServer);
    } else if (it instanceof HttpServerAceWrite) {
      return _registerConsumer((HttpServerAceWrite)it, httpServer);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, httpServer).toString());
    }
  }
}
