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
package de.acegen.templates.java.views;

import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerView;
import de.acegen.aceGen.HttpServerViewFunction;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.java.ModelExtension;
import de.acegen.extensions.java.ViewExtension;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class View {
  @Inject
  @Extension
  private ViewExtension _viewExtension;

  @Inject
  @Extension
  private ModelExtension _modelExtension;

  @Inject
  @Extension
  private CommonExtension _commonExtension;

  public CharSequence generateView(final HttpServerView it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = java.getName();
    _builder.append(_name);
    _builder.append(".views;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import de.acegen.IDaoProvider;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import de.acegen.IDataContainer;");
    _builder.newLine();
    _builder.append("import de.acegen.PersistenceHandle;");
    _builder.newLine();
    {
      EList<HttpServerViewFunction> _renderFunctions = it.getRenderFunctions();
      for(final HttpServerViewFunction renderFunction : _renderFunctions) {
        String _dataImport = this._modelExtension.dataImport(renderFunction.getModel());
        _builder.append(_dataImport);
        _builder.newLineIfNotEmpty();
      }
    }
    {
      boolean _isQueued = it.isQueued();
      if (_isQueued) {
        _builder.append("import de.acegen.QueuedView;");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _viewName = this._viewExtension.viewName(it);
    _builder.append(_viewName);
    {
      boolean _isQueued_1 = it.isQueued();
      if (_isQueued_1) {
        _builder.append(" extends QueuedView");
      }
    }
    _builder.append(" implements ");
    String _viewInterfaceName = this._viewExtension.viewInterfaceName(it);
    _builder.append(_viewInterfaceName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private IDaoProvider daoProvider;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _viewName_1 = this._viewExtension.viewName(it);
    _builder.append(_viewName_1, "\t");
    _builder.append("(IDaoProvider daoProvider) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.daoProvider = daoProvider;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<HttpServerViewFunction> _renderFunctions_1 = it.getRenderFunctions();
      for(final HttpServerViewFunction renderFunction_1 : _renderFunctions_1) {
        _builder.append("\t");
        _builder.append("public void ");
        String _name_1 = renderFunction_1.getName();
        _builder.append(_name_1, "\t");
        _builder.append("(");
        String _dataInterfaceName = this._modelExtension.dataInterfaceName(renderFunction_1.getModel());
        _builder.append(_dataInterfaceName, "\t");
        _builder.append(" data, PersistenceHandle handle) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected boolean canStop() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return true;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }

  public CharSequence generateViewInterface(final HttpServerView it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = java.getName();
    _builder.append(_name);
    _builder.append(".views;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    _builder.append("import de.acegen.IDataContainer;");
    _builder.newLine();
    _builder.append("import de.acegen.PersistenceHandle;");
    _builder.newLine();
    {
      EList<HttpServerViewFunction> _renderFunctions = it.getRenderFunctions();
      for(final HttpServerViewFunction renderFunction : _renderFunctions) {
        String _dataImport = this._modelExtension.dataImport(renderFunction.getModel());
        _builder.append(_dataImport);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"all\")");
    _builder.newLine();
    _builder.append("public interface ");
    String _viewInterfaceName = this._viewExtension.viewInterfaceName(it);
    _builder.append(_viewInterfaceName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      EList<HttpServerViewFunction> _renderFunctions_1 = it.getRenderFunctions();
      for(final HttpServerViewFunction renderFunction_1 : _renderFunctions_1) {
        _builder.append("\t");
        _builder.append("void ");
        String _name_1 = renderFunction_1.getName();
        _builder.append(_name_1, "\t");
        _builder.append("(");
        String _dataInterfaceName = this._modelExtension.dataInterfaceName(renderFunction_1.getModel());
        _builder.append(_dataInterfaceName, "\t");
        _builder.append(" data, PersistenceHandle handle);");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      boolean _isQueued = it.isQueued();
      if (_isQueued) {
        _builder.append("\t");
        _builder.append("void start();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("void stop();");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
}
