/**
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 * 
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */
package de.acegen.extensions.cs;

import com.google.common.base.Objects;
import de.acegen.aceGen.AttributeParamRef;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.HttpServerAceRead;
import de.acegen.aceGen.HttpServerOutcome;
import de.acegen.extensions.cs.AttributeExtension;
import de.acegen.extensions.cs.ModelExtension;
import java.util.ArrayList;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class AceExtension {
  @Inject
  @Extension
  private ModelExtension _modelExtension;
  
  @Inject
  @Extension
  private AttributeExtension _attributeExtension;
  
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
  
  public String actionNameWithPackage(final HttpServerAce it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = java.getName();
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
  
  public String newAction(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("final ");
    String _actionNameWithPackage = this.actionNameWithPackage(it);
    _builder.append(_actionNameWithPackage);
    _builder.append(" action = new ");
    String _actionNameWithPackage_1 = this.actionNameWithPackage(it);
    _builder.append(_actionNameWithPackage_1);
    _builder.append("(");
    CharSequence _newFromCommandData = this._modelExtension.newFromCommandData(it.getModel());
    _builder.append(_newFromCommandData);
    _builder.append(", DatabaseService.getDatabaseHandle());");
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
  
  public String commandNameWithPackage(final HttpServerAce it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = java.getName();
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
  
  public String responseDataNameWithPackage(final HttpServerAce it, final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = httpServer.getName();
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
          _builder.append("?uuid=\" + ");
          _builder.append(dataVarName);
          _builder.append(".getUuid() + \"");
          {
            EList<AttributeParamRef> _queryParams = it.getQueryParams();
            for(final AttributeParamRef queryParam : _queryParams) {
              _builder.append("&");
              String _name = queryParam.getAttribute().getName();
              _builder.append(_name);
              _builder.append("=\" + ");
              _builder.append(dataVarName);
              _builder.append(".");
              String _terCall = this._attributeExtension.getterCall(queryParam.getAttribute());
              _builder.append(_terCall);
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
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("\" + ");
        _builder_1.append(dataVarName);
        _builder_1.append(".get");
        String _firstUpper = StringExtensions.toFirstUpper(urlElements.get(i));
        _builder_1.append(_firstUpper);
        _builder_1.append("() + \"");
        urlWithPathParam = (_urlWithPathParam_1 + _builder_1);
      }
    }
    String _urlWithPathParam = urlWithPathParam;
    StringConcatenation _builder_1 = new StringConcatenation();
    {
      if (generateQueryParams) {
        _builder_1.append("?uuid=\" + ");
        _builder_1.append(dataVarName);
        _builder_1.append(".getUuid() + \"");
        {
          EList<AttributeParamRef> _queryParams_1 = it.getQueryParams();
          for(final AttributeParamRef queryParam_1 : _queryParams_1) {
            _builder_1.append("&");
            String _name_1 = queryParam_1.getAttribute().getName();
            _builder_1.append(_name_1);
            _builder_1.append("=\" + ");
            _builder_1.append(dataVarName);
            _builder_1.append(".");
            String _terCall_1 = this._attributeExtension.getterCall(queryParam_1.getAttribute());
            _builder_1.append(_terCall_1);
            _builder_1.append(" + \"");
          }
        }
      }
    }
    urlWithPathParam = (_urlWithPathParam + _builder_1);
    return urlWithPathParam;
  }
  
  public boolean isDropwizard(final HttpServer it) {
    String _type = it.getType();
    return Objects.equal(_type, "Dropwizard");
  }
  
  public boolean isJDBI3(final HttpServer it) {
    String _persistenceLayer = it.getPersistenceLayer();
    return Objects.equal(_persistenceLayer, "JDBI3");
  }
  
  public boolean isLiquibase(final HttpServer it) {
    String _migrations = it.getMigrations();
    return Objects.equal(_migrations, "Liquibase");
  }
}
