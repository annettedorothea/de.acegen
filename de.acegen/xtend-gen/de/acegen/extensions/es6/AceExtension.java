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
package de.acegen.extensions.es6;

import com.google.common.base.Objects;
import de.acegen.aceGen.HttpClient;
import de.acegen.aceGen.HttpClientAce;
import de.acegen.aceGen.HttpClientOutcome;
import de.acegen.aceGen.HttpClientStateFunction;
import de.acegen.aceGen.TriggerdAceOperation;
import de.acegen.extensions.java.EcoreExtension;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class AceExtension {
  @Extension
  private EcoreExtension _ecoreExtension;

  public String abstractActionName(final HttpClientAce it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Abstract");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Action");
    return _builder.toString();
  }

  public String actionName(final HttpClientAce it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Action");
    return _builder.toString();
  }

  public String abstractName(final HttpClientAce it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Abstract");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    return _builder.toString();
  }

  public String nameUppercase(final HttpClientAce it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    return _builder.toString();
  }

  public String resourceName(final HttpClientAce it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Resource");
    return _builder.toString();
  }

  public String actionNameWithPackage(final HttpClientAce it) {
    StringConcatenation _builder = new StringConcatenation();
    EObject _eContainer = it.eContainer();
    String _name = ((HttpClient) _eContainer).getName();
    _builder.append(_name);
    _builder.append(".actions.");
    String _actionName = this.actionName(it);
    _builder.append(_actionName);
    return _builder.toString();
  }

  public String abstractCommandName(final HttpClientAce it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Abstract");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Command");
    return _builder.toString();
  }

  public String commandName(final HttpClientAce it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Command");
    return _builder.toString();
  }

  public List<HttpClientAce> aggregatedTriggeredAceOperations(final HttpClientAce it) {
    ArrayList<HttpClientAce> list = new ArrayList<HttpClientAce>();
    EList<HttpClientOutcome> _outcomes = it.getOutcomes();
    for (final HttpClientOutcome outcome : _outcomes) {
      EList<TriggerdAceOperation> _triggerdAceOperations = outcome.getTriggerdAceOperations();
      for (final TriggerdAceOperation triggerdAceOperation : _triggerdAceOperations) {
        boolean _contains = list.contains(triggerdAceOperation.getAceOperation());
        boolean _not = (!_contains);
        if (_not) {
          list.add(triggerdAceOperation.getAceOperation());
        }
      }
    }
    return list;
  }

  public List<HttpClientStateFunction> aggregatedListeners(final HttpClientAce it) {
    ArrayList<HttpClientStateFunction> list = new ArrayList<HttpClientStateFunction>();
    EList<HttpClientOutcome> _outcomes = it.getOutcomes();
    for (final HttpClientOutcome outcome : _outcomes) {
      EList<HttpClientStateFunction> _listeners = outcome.getListeners();
      for (final HttpClientStateFunction listener : _listeners) {
        boolean _contains = list.contains(listener);
        boolean _not = (!_contains);
        if (_not) {
          list.add(listener);
        }
      }
    }
    return list;
  }

  public String eventName(final HttpClientAce it, final HttpClientOutcome outcome) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    String _firstUpper_1 = StringExtensions.toFirstUpper(outcome.getName());
    _builder.append(_firstUpper_1);
    _builder.append("Event");
    return _builder.toString();
  }

  public String eventNameWithPackage(final HttpClientAce it, final HttpClientOutcome outcome) {
    StringConcatenation _builder = new StringConcatenation();
    EObject _eContainer = it.eContainer();
    String _name = ((HttpClient) _eContainer).getName();
    _builder.append(_name);
    _builder.append(".events.");
    String _eventName = this.eventName(it, outcome);
    _builder.append(_eventName);
    return _builder.toString();
  }

  public String httpCall(final HttpClientAce it) {
    Boolean _isMulitpartFormData = this._ecoreExtension.isMulitpartFormData(it.getServerCall());
    if ((_isMulitpartFormData).booleanValue()) {
      String _type = it.getServerCall().getType();
      boolean _equals = Objects.equal(_type, "POST");
      if (_equals) {
        return "httpMulitpartFormDataPost";
      } else {
        return "httpMulitpartFormDataPut";
      }
    } else {
      String _type_1 = it.getServerCall().getType();
      boolean _equals_1 = Objects.equal(_type_1, "DELETE");
      if (_equals_1) {
        return "httpDelete";
      } else {
        String _type_2 = it.getServerCall().getType();
        boolean _equals_2 = Objects.equal(_type_2, "POST");
        if (_equals_2) {
          return "httpPost";
        } else {
          String _type_3 = it.getServerCall().getType();
          boolean _equals_3 = Objects.equal(_type_3, "PUT");
          if (_equals_3) {
            return "httpPut";
          } else {
            return "httpGet";
          }
        }
      }
    }
  }

  public String httpUrl(final HttpClientAce it) {
    String url = it.getServerCall().getUrl();
    int _indexOf = url.indexOf("/");
    boolean _notEquals = (_indexOf != 0);
    if (_notEquals) {
      url = ("/" + url);
    }
    final String[] split1 = url.split("\\{");
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
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("${data.");
        String _get_1 = urlElements.get(i);
        _builder.append(_get_1);
        _builder.append("}");
        urlWithPathParam = (_urlWithPathParam_1 + _builder);
      }
    }
    return ("${AppUtils.settings.rootPath}" + urlWithPathParam);
  }
}
