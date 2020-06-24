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

import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.HttpClient;
import de.acegen.aceGen.HttpClientStateFunction;
import java.util.ArrayList;
import java.util.List;
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
    String _functionName = this.functionName(it.getStateElement(), it.getStateElement().eContainer());
    _builder.append(_functionName);
    return _builder.toString();
  }
  
  public String functionName(final Attribute it, final EObject parent) {
    StringConcatenation _builder = new StringConcatenation();
    String _functionNameRec = this.functionNameRec(it, parent, "");
    _builder.append(_functionNameRec);
    return _builder.toString();
  }
  
  public String functionNameRec(final Attribute it, final EObject parent, final String suffix) {
    if (((parent != null) && (parent instanceof Attribute))) {
      String _functionNameRec = this.functionNameRec(((Attribute) parent), parent.eContainer(), it.getName());
      StringConcatenation _builder = new StringConcatenation();
      {
        int _length = suffix.length();
        boolean _greaterThan = (_length > 0);
        if (_greaterThan) {
          _builder.append("_");
          _builder.append(suffix);
        }
      }
      return (_functionNameRec + _builder);
    } else {
      String _name = it.getName();
      StringConcatenation _builder_1 = new StringConcatenation();
      {
        int _length_1 = suffix.length();
        boolean _greaterThan_1 = (_length_1 > 0);
        if (_greaterThan_1) {
          _builder_1.append("_");
          _builder_1.append(suffix);
        }
      }
      return (_name + _builder_1);
    }
  }
  
  public String elementPath(final Attribute it, final EObject parent) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("appState.");
    String _elementPathRec = this.elementPathRec(it, parent, "");
    _builder.append(_elementPathRec);
    return _builder.toString();
  }
  
  public String elementPathRec(final Attribute it, final EObject parent, final String suffix) {
    if (((parent != null) && (parent instanceof Attribute))) {
      String _elementPathRec = this.elementPathRec(((Attribute) parent), parent.eContainer(), it.getName());
      StringConcatenation _builder = new StringConcatenation();
      {
        int _length = suffix.length();
        boolean _greaterThan = (_length > 0);
        if (_greaterThan) {
          _builder.append(".");
          _builder.append(suffix);
        }
      }
      return (_elementPathRec + _builder);
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
  
  public List<Attribute> allParentAttributes(final Attribute it) {
    ArrayList<Attribute> attributes = new ArrayList<Attribute>();
    EObject parent = it.eContainer();
    while ((parent instanceof Attribute)) {
      {
        attributes.add(0, ((Attribute) parent));
        parent = ((Attribute)parent).eContainer();
      }
    }
    return attributes;
  }
}
