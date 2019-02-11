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

import de.acegen.aceGen.HttpClient;
import de.acegen.aceGen.HttpClientStateElement;
import de.acegen.aceGen.HttpClientStateFunction;
import de.acegen.aceGen.HttpClientTypeDefinition;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class Es6Extension {
  public String packageFolder(final HttpClient it) {
    StringConcatenation _builder = new StringConcatenation();
    String _replace = it.getName().replace(".", "/");
    _builder.append(_replace);
    return _builder.toString();
  }
  
  public String projectName(final HttpClient it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    return _builder.toString();
  }
  
  public String appStateFunction(final HttpClientStateFunction it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("AppState.");
    String _stateFunctionType = it.getStateFunctionType();
    _builder.append(_stateFunctionType);
    _builder.append("_");
    String _functionName = this.functionName(it.getAttribute(), "");
    _builder.append(_functionName);
    return _builder.toString();
  }
  
  public String functionName(final HttpClientStateElement element) {
    StringConcatenation _builder = new StringConcatenation();
    String _functionName = this.functionName(element, "");
    _builder.append(_functionName);
    return _builder.toString();
  }
  
  public String functionName(final HttpClientStateElement it, final String suffix) {
    final EObject parent = it.eContainer();
    if ((parent instanceof HttpClientTypeDefinition)) {
      HttpClientTypeDefinition typeDef = ((HttpClientTypeDefinition) parent);
      EObject _eContainer = typeDef.eContainer();
      String _name = typeDef.getName();
      String _plus = (_name + "_");
      String _name_1 = it.getName();
      String _plus_1 = (_plus + _name_1);
      String _functionName = this.functionName(((HttpClientStateElement) _eContainer), _plus_1);
      StringConcatenation _builder = new StringConcatenation();
      {
        int _length = suffix.length();
        boolean _greaterThan = (_length > 0);
        if (_greaterThan) {
          _builder.append("_");
          _builder.append(suffix);
        }
      }
      return (_functionName + _builder);
    } else {
      String _name_2 = it.getName();
      StringConcatenation _builder_1 = new StringConcatenation();
      {
        int _length_1 = suffix.length();
        boolean _greaterThan_1 = (_length_1 > 0);
        if (_greaterThan_1) {
          _builder_1.append("_");
          _builder_1.append(suffix);
        }
      }
      return (_name_2 + _builder_1);
    }
  }
  
  public String elementPath(final HttpClientStateElement element) {
    StringConcatenation _builder = new StringConcatenation();
    String _elementPath = this.elementPath(element, "");
    _builder.append(_elementPath);
    return _builder.toString();
  }
  
  public String elementPath(final HttpClientStateElement it, final String suffix) {
    final EObject parent = it.eContainer();
    if ((parent instanceof HttpClientTypeDefinition)) {
      HttpClientTypeDefinition typeDef = ((HttpClientTypeDefinition) parent);
      EObject _eContainer = typeDef.eContainer();
      String _elementPath = this.elementPath(((HttpClientStateElement) _eContainer), it.getName());
      StringConcatenation _builder = new StringConcatenation();
      {
        int _length = suffix.length();
        boolean _greaterThan = (_length > 0);
        if (_greaterThan) {
          _builder.append(".");
          _builder.append(suffix);
        }
      }
      return (_elementPath + _builder);
    } else {
      String _name = it.getName();
      StringConcatenation _builder_1 = new StringConcatenation();
      {
        int _length_1 = suffix.length();
        boolean _greaterThan_1 = (_length_1 > 0);
        if (_greaterThan_1) {
          _builder_1.append(".");
          _builder_1.append(suffix);
        }
      }
      return (_name + _builder_1);
    }
  }
}
