package de.acegen.extensions.java;

import com.google.common.base.Objects;
import de.acegen.aceGen.AttributeParamRef;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.HttpServerAceRead;
import de.acegen.aceGen.HttpServerOutcome;
import java.util.ArrayList;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class JavaHttpServerExtension {
  @Inject
  @Extension
  private AttributeExtension _attributeExtension;

  public String packageFolder(final HttpServer it) {
    StringConcatenation _builder = new StringConcatenation();
    String _replace = it.getName().replace(".", "/");
    _builder.append(_replace);
    return _builder.toString();
  }

  public String projectName(final HttpServer it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    return _builder.toString();
  }

  public String fileExtension() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(".java");
    return _builder.toString();
  }

  public String abstractActionName(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Abstract");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Action");
    return _builder.toString();
  }

  public String actionName(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Action");
    return _builder.toString();
  }

  public String actionNameWithPackage(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    EObject _eContainer = it.eContainer();
    String _name = ((HttpServer) _eContainer).getName();
    _builder.append(_name);
    _builder.append(".actions.");
    String _actionName = this.actionName(it);
    _builder.append(_actionName);
    return _builder.toString();
  }

  public String abstractName(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Abstract");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    return _builder.toString();
  }

  public String nameUppercase(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    return _builder.toString();
  }

  public String resourceName(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Resource");
    return _builder.toString();
  }

  public String abstractCommandName(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Abstract");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Command");
    return _builder.toString();
  }

  public String commandName(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Command");
    return _builder.toString();
  }

  public String commandNameWithPackage(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    EObject _eContainer = it.eContainer();
    String _name = ((HttpServer) _eContainer).getName();
    _builder.append(_name);
    _builder.append(".commands.");
    String _commandName = this.commandName(it);
    _builder.append(_commandName);
    return _builder.toString();
  }

  public String eventName(final HttpServerAce it, final HttpServerOutcome outcome) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    String _firstUpper_1 = StringExtensions.toFirstUpper(outcome.getName());
    _builder.append(_firstUpper_1);
    _builder.append("Event");
    return _builder.toString();
  }

  public String eventNameWithPackage(final HttpServerAce it, final HttpServerOutcome outcome) {
    StringConcatenation _builder = new StringConcatenation();
    EObject _eContainer = it.eContainer();
    String _name = ((HttpServer) _eContainer).getName();
    _builder.append(_name);
    _builder.append(".events.");
    String _eventName = this.eventName(it, outcome);
    _builder.append(_eventName);
    return _builder.toString();
  }

  public String responseDataName(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Response");
    return _builder.toString();
  }

  public String responseDataNameWithPackage(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    EObject _eContainer = it.eContainer();
    String _name = ((HttpServer) _eContainer).getName();
    _builder.append(_name);
    _builder.append(".data.");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Response");
    return _builder.toString();
  }

  public String responseDataInterfaceName(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("I");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Response");
    return _builder.toString();
  }

  public String payloadDataName(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Payload");
    return _builder.toString();
  }

  public String payloadDataNameWithPackage(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    EObject _eContainer = it.eContainer();
    String _name = ((HttpServer) _eContainer).getName();
    _builder.append(_name);
    _builder.append(".data.");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Payload");
    return _builder.toString();
  }

  public String payloadDataInterfaceName(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("I");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Payload");
    return _builder.toString();
  }

  public boolean isRead(final HttpServerAce it) {
    return (it instanceof HttpServerAceRead);
  }

  public String packageFor(final HttpServerAce it) {
    EObject _eContainer = it.eContainer();
    final HttpServer java = ((HttpServer) _eContainer);
    StringConcatenation _builder = new StringConcatenation();
    String _name = java.getName();
    _builder.append(_name);
    return _builder.toString();
  }

  public String urlWithPathParams(final HttpServerAce it, final String dataVarName, final boolean generateQueryParams) {
    int _size = it.getPathParams().size();
    boolean _equals = (_size == 0);
    if (_equals) {
      String _url = it.getUrl();
      StringConcatenation _builder = new StringConcatenation();
      {
        if (generateQueryParams) {
          {
            EList<AttributeParamRef> _queryParams = it.getQueryParams();
            boolean _hasElements = false;
            for(final AttributeParamRef queryParam : _queryParams) {
              if (!_hasElements) {
                _hasElements = true;
                _builder.append("?");
              } else {
                _builder.appendImmediate("&", "");
              }
              String _name = queryParam.getAttribute().getName();
              _builder.append(_name);
              _builder.append("=\" + ");
              {
                String _type = queryParam.getAttribute().getType();
                boolean _equals_1 = Objects.equal(_type, "String");
                if (_equals_1) {
                  StringConcatenation _builder_1 = new StringConcatenation();
                  _builder_1.append(dataVarName);
                  _builder_1.append(".");
                  String _terCall = this._attributeExtension.getterCall(queryParam.getAttribute());
                  _builder_1.append(_terCall);
                  String _urlEncodedValue = this.urlEncodedValue(_builder_1.toString());
                  _builder.append(_urlEncodedValue);
                } else {
                  _builder.append(dataVarName);
                  _builder.append(".");
                  String _terCall_1 = this._attributeExtension.getterCall(queryParam.getAttribute());
                  _builder.append(_terCall_1);
                }
              }
              _builder.append(" + \"");
            }
          }
        }
      }
      String retUrl = (_url + _builder);
      return retUrl;
    }
    final String[] split1 = it.getUrl().split("\\{");
    ArrayList<String> urlElements = new ArrayList<String>();
    for (final String split : split1) {
      {
        final String[] split2 = split.split("\\}");
        CollectionExtensions.<String>addAll(urlElements, split2);
      }
    }
    String urlWithPathParam = "";
    for (int i = 0; (i < urlElements.size()); i++) {
      if (((i % 2) == 0)) {
        String _urlWithPathParam = urlWithPathParam;
        String _get = urlElements.get(i);
        urlWithPathParam = (_urlWithPathParam + _get);
      } else {
        String _urlWithPathParam_1 = urlWithPathParam;
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("\" + ");
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append(dataVarName);
        _builder_3.append(".get");
        String _firstUpper = StringExtensions.toFirstUpper(urlElements.get(i));
        _builder_3.append(_firstUpper);
        _builder_3.append("()");
        String _urlEncodedValue_1 = this.urlEncodedValue(_builder_3.toString());
        _builder_2.append(_urlEncodedValue_1);
        _builder_2.append(" + \"");
        urlWithPathParam = (_urlWithPathParam_1 + _builder_2);
      }
    }
    String _urlWithPathParam = urlWithPathParam;
    StringConcatenation _builder_2 = new StringConcatenation();
    {
      if (generateQueryParams) {
        {
          EList<AttributeParamRef> _queryParams_1 = it.getQueryParams();
          boolean _hasElements_1 = false;
          for(final AttributeParamRef queryParam_1 : _queryParams_1) {
            if (!_hasElements_1) {
              _hasElements_1 = true;
              _builder_2.append("?");
            } else {
              _builder_2.appendImmediate("&", "");
            }
            String _name_1 = queryParam_1.getAttribute().getName();
            _builder_2.append(_name_1);
            _builder_2.append("=\" + ");
            StringConcatenation _builder_3 = new StringConcatenation();
            _builder_3.append(dataVarName);
            _builder_3.append(".");
            String _terCall_2 = this._attributeExtension.getterCall(queryParam_1.getAttribute());
            _builder_3.append(_terCall_2);
            String _urlEncodedValue_1 = this.urlEncodedValue(_builder_3.toString());
            _builder_2.append(_urlEncodedValue_1);
            _builder_2.append(" + \"");
          }
        }
      }
    }
    urlWithPathParam = (_urlWithPathParam + _builder_2);
    return urlWithPathParam;
  }

  public String urlEncodedValue(final String valueVar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    _builder.append(valueVar);
    _builder.append(" != null ? URLEncoder.encode(");
    _builder.append(valueVar);
    _builder.append(", StandardCharsets.UTF_8.toString()) : \"\")");
    return _builder.toString();
  }
}
