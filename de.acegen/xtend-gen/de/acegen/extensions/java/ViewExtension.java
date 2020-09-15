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
package de.acegen.extensions.java;

import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerView;
import de.acegen.aceGen.HttpServerViewFunction;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ViewExtension {
  public String viewName(final HttpServerView it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("View");
    return _builder.toString();
  }
  
  public String viewInterfaceName(final HttpServerView it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("I");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("View");
    return _builder.toString();
  }
  
  public String viewNameWithPackage(final HttpServerView it) {
    StringConcatenation _builder = new StringConcatenation();
    EObject _eContainer = it.eContainer();
    String _name = ((HttpServer) _eContainer).getName();
    _builder.append(_name);
    _builder.append(".views.");
    String _viewName = this.viewName(it);
    _builder.append(_viewName);
    return _builder.toString();
  }
  
  public String viewNameAsVariable(final HttpServerView it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstLower = StringExtensions.toFirstLower(it.getName());
    _builder.append(_firstLower);
    _builder.append("View");
    return _builder.toString();
  }
  
  public String viewFunctionWithViewName(final HttpServerViewFunction it) {
    StringConcatenation _builder = new StringConcatenation();
    EObject _eContainer = it.eContainer();
    String _viewName = this.viewName(((HttpServerView) _eContainer));
    _builder.append(_viewName);
    _builder.append(".");
    String _name = it.getName();
    _builder.append(_name);
    return _builder.toString();
  }
  
  public String viewFunctionWithViewNameAsVariable(final HttpServerViewFunction it) {
    StringConcatenation _builder = new StringConcatenation();
    EObject _eContainer = it.eContainer();
    String _viewNameAsVariable = this.viewNameAsVariable(((HttpServerView) _eContainer));
    _builder.append(_viewNameAsVariable);
    _builder.append(".");
    String _name = it.getName();
    _builder.append(_name);
    return _builder.toString();
  }
  
  public HttpServerView view(final HttpServerViewFunction it) {
    EObject _eContainer = it.eContainer();
    return ((HttpServerView) _eContainer);
  }
}
