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
package de.acegen.extensions.es6;

import com.google.common.base.Objects;
import de.acegen.aceGen.HttpClient;
import de.acegen.aceGen.HttpClientAce;
import de.acegen.aceGen.HttpClientOutcome;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class AceExtension {
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
  
  public List<HttpClientAce> triggeredAceOperations(final HttpClientAce it) {
    ArrayList<HttpClientAce> list = new ArrayList<HttpClientAce>();
    EList<HttpClientOutcome> _outcomes = it.getOutcomes();
    for (final HttpClientOutcome outcome : _outcomes) {
      EList<HttpClientAce> _aceOperations = outcome.getAceOperations();
      for (final HttpClientAce aceOperation : _aceOperations) {
        boolean _contains = list.contains(aceOperation);
        boolean _not = (!_contains);
        if (_not) {
          list.add(aceOperation);
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
    StringConcatenation _builder = new StringConcatenation();
    {
      String _type = it.getServerCall().getType();
      boolean _equals = Objects.equal(_type, "DELETE");
      if (_equals) {
        _builder.append("httpDelete");
      } else {
        String _type_1 = it.getServerCall().getType();
        boolean _equals_1 = Objects.equal(_type_1, "POST");
        if (_equals_1) {
          _builder.append("httpPost");
        } else {
          String _type_2 = it.getServerCall().getType();
          boolean _equals_2 = Objects.equal(_type_2, "PUT");
          if (_equals_2) {
            _builder.append("httpPut");
          } else {
            _builder.append("httpGet");
          }
        }
      }
    }
    return _builder.toString();
  }
  
  public String httpUrl(final HttpClientAce it) {
    String url = it.getServerCall().getUrl();
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
        _builder.append("${this.commandData.");
        String _get_1 = urlElements.get(i);
        _builder.append(_get_1);
        _builder.append("}");
        urlWithPathParam = (_urlWithPathParam_1 + _builder);
      }
    }
    return ("/api" + urlWithPathParam);
  }
}
