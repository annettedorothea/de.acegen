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
package de.acegen.templates.cs.models;

import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.HttpServer;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.cs.AttributeExtension;
import de.acegen.extensions.cs.CsHttpServerExtension;
import de.acegen.extensions.cs.ModelExtension;
import java.util.List;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class Model {
  @Inject
  @Extension
  private ModelExtension _modelExtension;
  
  @Inject
  @Extension
  private AttributeExtension _attributeExtension;
  
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  @Inject
  @Extension
  private CsHttpServerExtension _csHttpServerExtension;
  
  public CharSequence generateInterface(final de.acegen.aceGen.Model it, final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("namespace ");
    String _namespace = this._csHttpServerExtension.namespace(httpServer);
    _builder.append(_namespace);
    _builder.append(".Models;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public interface ");
    String _modelName = this._modelExtension.modelName(it);
    _builder.append(_modelName);
    _builder.append(" ");
    {
      int _size = it.getSuperModels().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _builder.append(": ");
        {
          EList<de.acegen.aceGen.Model> _superModels = it.getSuperModels();
          boolean _hasElements = false;
          for(final de.acegen.aceGen.Model superModel : _superModels) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(",", "");
            }
            String _interfaceWithPackage = this._modelExtension.interfaceWithPackage(superModel);
            _builder.append(_interfaceWithPackage);
          }
        }
      }
    }
    _builder.append("{");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      EList<Attribute> _attributes = it.getAttributes();
      for(final Attribute attribute : _attributes) {
        _builder.append("\t");
        String _set = this._attributeExtension.getSet(attribute);
        _builder.append(_set, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("\t");
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
  
  public CharSequence generateClass(final de.acegen.aceGen.Model it, final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("namespace ");
    String _namespace = this._csHttpServerExtension.namespace(httpServer);
    _builder.append(_namespace);
    _builder.append(".Models;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _modelClassName = this._modelExtension.modelClassName(it);
    _builder.append(_modelClassName);
    _builder.append(" : ");
    String _modelName = this._modelExtension.modelName(it);
    _builder.append(_modelName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      List<Attribute> _allAttributes = this._modelExtension.allAttributes(it);
      for(final Attribute attribute : _allAttributes) {
        _builder.append("\t");
        _builder.append("public ");
        String _set = this._attributeExtension.getSet(attribute);
        _builder.append(_set, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    {
      int _length = ((Object[])Conversions.unwrapArray(this._modelExtension.allAttributes(it), Object.class)).length;
      boolean _greaterThan = (_length > 0);
      if (_greaterThan) {
        _builder.append("\t");
        _builder.append("public ");
        String _modelClassName_1 = this._modelExtension.modelClassName(it);
        _builder.append(_modelClassName_1, "\t");
        _builder.append("() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _modelClassName_2 = this._modelExtension.modelClassName(it);
    _builder.append(_modelClassName_2, "\t");
    _builder.append("(");
    _builder.newLineIfNotEmpty();
    {
      List<Attribute> _allAttributes_1 = this._modelExtension.allAttributes(it);
      boolean _hasElements = false;
      for(final Attribute attribute_1 : _allAttributes_1) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "\t\t");
        }
        _builder.append("\t\t");
        String _param = this._attributeExtension.param(attribute_1);
        _builder.append(_param, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append(") {");
    _builder.newLine();
    {
      List<Attribute> _allAttributes_2 = this._modelExtension.allAttributes(it);
      for(final Attribute attribute_2 : _allAttributes_2) {
        _builder.append("\t\t");
        String _assign = this._attributeExtension.assign(attribute_2);
        _builder.append(_assign, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
}
