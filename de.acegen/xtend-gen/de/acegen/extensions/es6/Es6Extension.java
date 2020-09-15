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

import de.acegen.aceGen.ClientAttribute;
import de.acegen.aceGen.GroupedClientAttribute;
import de.acegen.aceGen.HttpClient;
import de.acegen.aceGen.HttpClientStateFunction;
import de.acegen.aceGen.SingleClientAttribute;
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
    String _functionName = this.functionName(it.getStateElement());
    _builder.append(_functionName);
    return _builder.toString();
  }
  
  public String functionName(final SingleClientAttribute it) {
    StringConcatenation _builder = new StringConcatenation();
    String _functionNameRec = this.functionNameRec(it, "");
    _builder.append(_functionNameRec);
    return _builder.toString();
  }
  
  public String functionNameRec(final ClientAttribute it, final String suffix) {
    final SingleClientAttribute parent = this.findNextSingleClientAttributeParent(it);
    if ((parent != null)) {
      String _functionNameRec = this.functionNameRec(parent, it.getName());
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
  
  public String elementPath(final ClientAttribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("appState.");
    String _elementPathRec = this.elementPathRec(it, "");
    _builder.append(_elementPathRec);
    return _builder.toString();
  }
  
  public String elementPathRec(final ClientAttribute attr, final String suffix) {
    ClientAttribute clientAttribute = attr;
    EObject _eContainer = clientAttribute.eContainer();
    if ((_eContainer instanceof GroupedClientAttribute)) {
      EObject _eContainer_1 = attr.eContainer();
      clientAttribute = ((ClientAttribute) _eContainer_1);
    }
    final ClientAttribute parent = this.findNextClientAttributeParent(clientAttribute);
    if ((parent != null)) {
      String _elementPathRec = this.elementPathRec(parent, clientAttribute.getName());
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
      String _name = clientAttribute.getName();
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
  
  private SingleClientAttribute findNextSingleClientAttributeParent(final ClientAttribute it) {
    EObject parent = it.eContainer();
    while ((parent != null)) {
      {
        if ((parent instanceof SingleClientAttribute)) {
          return ((SingleClientAttribute) parent);
        }
        parent = parent.eContainer();
      }
    }
    return null;
  }
  
  private ClientAttribute findNextClientAttributeParent(final ClientAttribute it) {
    EObject parent = it.eContainer();
    while ((parent != null)) {
      {
        final EObject grandParent = parent.eContainer();
        if (((grandParent != null) && (grandParent instanceof GroupedClientAttribute))) {
          return ((GroupedClientAttribute) grandParent);
        } else {
          if ((parent instanceof SingleClientAttribute)) {
            return ((SingleClientAttribute) parent);
          }
        }
        parent = grandParent;
      }
    }
    return null;
  }
  
  public List<ClientAttribute> allParentAttributes(final ClientAttribute it) {
    ArrayList<ClientAttribute> attributes = new ArrayList<ClientAttribute>();
    EObject parent = it.eContainer();
    while ((parent != null)) {
      {
        final EObject grandParent = parent.eContainer();
        if ((parent instanceof SingleClientAttribute)) {
          attributes.add(0, ((SingleClientAttribute) parent));
        }
        parent = grandParent;
      }
    }
    return attributes;
  }
}
