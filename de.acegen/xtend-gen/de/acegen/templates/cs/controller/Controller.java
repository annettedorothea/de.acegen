package de.acegen.templates.cs.controller;

import de.acegen.aceGen.AuthUser;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.cs.CsHttpServerExtension;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class Controller {
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  @Inject
  @Extension
  private CsHttpServerExtension _csHttpServerExtension;
  
  public CharSequence generate(final HttpServer it, final AuthUser authUser) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("using Microsoft.AspNetCore.Mvc;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("namespace ");
    String _controllerNamespace = this._csHttpServerExtension.controllerNamespace(it);
    _builder.append(_controllerNamespace);
    _builder.append(".Controller;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("[ApiController]");
    _builder.newLine();
    _builder.append("[Route(\"[controller]\")]");
    _builder.newLine();
    _builder.append("public class ");
    String _controllerName = this._csHttpServerExtension.controllerName(it);
    _builder.append(_controllerName);
    _builder.append(" : ControllerBase");
    _builder.newLineIfNotEmpty();
    _builder.append("{");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("private readonly ILogger<");
    String _controllerName_1 = this._csHttpServerExtension.controllerName(it);
    _builder.append(_controllerName_1, "    ");
    _builder.append("> _logger;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public ");
    String _controllerName_2 = this._csHttpServerExtension.controllerName(it);
    _builder.append(_controllerName_2, "    ");
    _builder.append("(ILogger<");
    String _controllerName_3 = this._csHttpServerExtension.controllerName(it);
    _builder.append(_controllerName_3, "    ");
    _builder.append("> logger)");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("_logger = logger;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    {
      EList<HttpServerAce> _aceOperations = it.getAceOperations();
      for(final HttpServerAce aceOperation : _aceOperations) {
        _builder.append("    ");
        _builder.append("//");
        String _name = aceOperation.getName();
        _builder.append(_name, "    ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
}
