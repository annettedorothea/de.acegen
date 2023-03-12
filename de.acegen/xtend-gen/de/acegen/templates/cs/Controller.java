package de.acegen.templates.cs;

import de.acegen.aceGen.AuthUser;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.cs.TypeExtension;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class Controller {
  @Inject
  @Extension
  private CommonExtension _commonExtension;

  @Inject
  @Extension
  private TypeExtension _typeExtension;

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
    CharSequence _controllerNamespace = this._typeExtension.controllerNamespace(it);
    _builder.append(_controllerNamespace);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("[ApiController]");
    _builder.newLine();
    _builder.append("public class ");
    CharSequence _controllerName = this._typeExtension.controllerName(it);
    _builder.append(_controllerName);
    _builder.newLineIfNotEmpty();
    _builder.append("{");
    _builder.newLine();
    {
      EList<HttpServerAce> _aceOperations = it.getAceOperations();
      for(final HttpServerAce ace : _aceOperations) {
        _builder.append("\t");
        _builder.append("[Http");
        String _firstUpper = StringExtensions.toFirstUpper(ace.getType().toLowerCase());
        _builder.append(_firstUpper, "\t");
        _builder.append("(\"");
        String _url = ace.getUrl();
        _builder.append(_url, "\t");
        _builder.append("\")]");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("public ActionResult ");
        String _firstUpper_1 = StringExtensions.toFirstUpper(ace.getName());
        _builder.append(_firstUpper_1, "\t");
        _builder.append("([FromQuery] string? uuid)");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("{");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("    ");
        _builder.append("return new OkResult();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
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
