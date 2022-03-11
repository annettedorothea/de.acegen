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
package de.acegen.extensions.cs;

import com.google.common.base.Objects;
import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.Model;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ModelExtension {
  @Inject
  @Extension
  private AttributeExtension _attributeExtension;
  
  public String modelName(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("I");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Model");
    return _builder.toString();
  }
  
  public String modelListAttributeName(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = it.getName();
    _builder.append(_name);
    _builder.append("List");
    return _builder.toString();
  }
  
  public String modelClassName(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Model");
    return _builder.toString();
  }
  
  public String modelClassNameWithPackage(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    EObject _eContainer = it.eContainer();
    String _name = ((HttpServer) _eContainer).getName();
    _builder.append(_name);
    _builder.append(".Models.");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Model");
    return _builder.toString();
  }
  
  public String modelParam(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstLower = StringExtensions.toFirstLower(it.getName());
    _builder.append(_firstLower);
    _builder.append("Model");
    return _builder.toString();
  }
  
  public String modelDao(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Dao");
    return _builder.toString();
  }
  
  public String modelDaoWithPackage(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    EObject _eContainer = it.eContainer();
    String _name = ((HttpServer) _eContainer).getName();
    _builder.append(_name);
    _builder.append(".models.");
    String _modelDao = this.modelDao(it);
    _builder.append(_modelDao);
    return _builder.toString();
  }
  
  public String abstractModelDao(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Abstract");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Dao");
    return _builder.toString();
  }
  
  public String modelMapper(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Mapper");
    return _builder.toString();
  }
  
  public String table(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\\\"");
    String _lowerCase = it.getName().toLowerCase();
    _builder.append(_lowerCase);
    _builder.append("\\\"");
    return _builder.toString();
  }
  
  public String tableFkRef(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    String _lowerCase = it.getName().toLowerCase();
    _builder.append(_lowerCase);
    return _builder.toString();
  }
  
  public String importModel(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("using ");
    String _interfacePackage = this.interfacePackage(it);
    _builder.append(_interfacePackage);
    _builder.append(";");
    return _builder.toString();
  }
  
  public String interfaceWithPackage(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    EObject _eContainer = it.eContainer();
    String _name = ((HttpServer) _eContainer).getName();
    _builder.append(_name);
    _builder.append(".Models.");
    String _modelName = this.modelName(it);
    _builder.append(_modelName);
    return _builder.toString();
  }
  
  public String interfacePackage(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    EObject _eContainer = it.eContainer();
    String _name = ((HttpServer) _eContainer).getName();
    _builder.append(_name);
    _builder.append(".Models");
    return _builder.toString();
  }
  
  public String modelGetAttribute(final Model it, final Attribute attribute) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(" ");
    String _modelParam = this.modelParam(it);
    _builder.append(_modelParam, " ");
    _builder.append(".");
    String _terCall = this._attributeExtension.getterCall(attribute);
    _builder.append(_terCall, " ");
    _builder.append(" ");
    return _builder.toString();
  }
  
  public String modelAttributeSqlValue(final Model it, final Attribute attribute) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(":");
    String _lowerCase = attribute.getName().toLowerCase();
    _builder.append(_lowerCase);
    return _builder.toString();
  }
  
  public List<Attribute> allUniqueAttributes(final Model it) {
    ArrayList<Attribute> list = new ArrayList<Attribute>();
    EList<Attribute> _attributes = it.getAttributes();
    for (final Attribute attribute : _attributes) {
      boolean _isUnique = attribute.isUnique();
      if (_isUnique) {
        list.add(attribute);
      }
    }
    return list;
  }
  
  public List<Attribute> allPrimaryKeyAttributes(final Model it) {
    ArrayList<Attribute> list = new ArrayList<Attribute>();
    EList<Attribute> _attributes = it.getAttributes();
    for (final Attribute attribute : _attributes) {
      boolean _isPrimaryKey = attribute.isPrimaryKey();
      if (_isPrimaryKey) {
        list.add(attribute);
      }
    }
    return list;
  }
  
  public List<Attribute> allSquishyAttributes(final Model it) {
    ArrayList<Attribute> list = new ArrayList<Attribute>();
    if ((it == null)) {
      return list;
    }
    ArrayList<Attribute> allAttributes = new ArrayList<Attribute>();
    this.allAttributesRec(it, allAttributes);
    for (final Attribute attribute : allAttributes) {
      boolean _isSquishy = attribute.isSquishy();
      if (_isSquishy) {
        list.add(attribute);
      }
    }
    return list;
  }
  
  public boolean containsPrimitiveAttributes(final Model it) {
    EList<Attribute> _attributes = it.getAttributes();
    for (final Attribute attribute : _attributes) {
      boolean _isPrimitive = this._attributeExtension.isPrimitive(attribute);
      if (_isPrimitive) {
        return true;
      }
    }
    return false;
  }
  
  public String listGetter(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("public java.util.List<");
    String _modelName = this.modelName(it);
    _builder.append(_modelName);
    _builder.append("> get");
    String _firstUpper = StringExtensions.toFirstUpper(this.modelListAttributeName(it));
    _builder.append(_firstUpper);
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return this.");
    String _modelListAttributeName = this.modelListAttributeName(it);
    _builder.append(_modelListAttributeName, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    return _builder.toString();
  }
  
  public String listSetter(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public void set");
    String _firstUpper = StringExtensions.toFirstUpper(this.modelListAttributeName(it));
    _builder.append(_firstUpper);
    _builder.append("(java.util.List<");
    String _modelName = this.modelName(it);
    _builder.append(_modelName);
    _builder.append("> ");
    String _modelListAttributeName = this.modelListAttributeName(it);
    _builder.append(_modelListAttributeName);
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("this.");
    String _modelListAttributeName_1 = this.modelListAttributeName(it);
    _builder.append(_modelListAttributeName_1, "\t");
    _builder.append(" = ");
    String _modelListAttributeName_2 = this.modelListAttributeName(it);
    _builder.append(_modelListAttributeName_2, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    return _builder.toString();
  }
  
  public String interfaceGetter(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    String _interfaceWithPackage = this.interfaceWithPackage(it);
    _builder.append(_interfaceWithPackage);
    _builder.append(" get");
    String _modelRefToUpper = this.modelRefToUpper(it);
    _builder.append(_modelRefToUpper);
    _builder.append("();");
    return _builder.toString();
  }
  
  public String declaration(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private ");
    String _interfaceWithPackage = this.interfaceWithPackage(it);
    _builder.append(_interfaceWithPackage);
    _builder.append(" ");
    String _modelRefToLower = this.modelRefToLower(it);
    _builder.append(_modelRefToLower);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public String getter(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("public ");
    String _interfaceWithPackage = this.interfaceWithPackage(it);
    _builder.append(_interfaceWithPackage);
    _builder.append(" get");
    String _modelRefToUpper = this.modelRefToUpper(it);
    _builder.append(_modelRefToUpper);
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return this.");
    String _modelRefToLower = this.modelRefToLower(it);
    _builder.append(_modelRefToLower, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    return _builder.toString();
  }
  
  public String setter(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public void set");
    String _modelRefToUpper = this.modelRefToUpper(it);
    _builder.append(_modelRefToUpper);
    _builder.append("(");
    String _interfaceWithPackage = this.interfaceWithPackage(it);
    _builder.append(_interfaceWithPackage);
    _builder.append(" ");
    String _modelRefToLower = this.modelRefToLower(it);
    _builder.append(_modelRefToLower);
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("this.");
    String _modelRefToLower_1 = this.modelRefToLower(it);
    _builder.append(_modelRefToLower_1, "\t");
    _builder.append(" = ");
    String _modelRefToLower_2 = this.modelRefToLower(it);
    _builder.append(_modelRefToLower_2, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    return _builder.toString();
  }
  
  public List<Attribute> allAttributes(final Model it) {
    final ArrayList<Attribute> attrs = new ArrayList<Attribute>();
    this.allAttributesRec(it, attrs);
    return attrs;
  }
  
  public String formDataAttributeName(final Model it) {
    EList<Attribute> _attributes = it.getAttributes();
    for (final Attribute attr : _attributes) {
      String _type = attr.getType();
      boolean _equals = Objects.equal(_type, "FormData");
      if (_equals) {
        return attr.getName();
      }
    }
    return "formData";
  }
  
  public void allAttributesRec(final Model it, final List<Attribute> attrs) {
    EList<Attribute> _attributes = it.getAttributes();
    for (final Attribute attribute : _attributes) {
      boolean _containsAttribute = this.containsAttribute(attrs, attribute);
      boolean _not = (!_containsAttribute);
      if (_not) {
        attrs.add(attribute);
      }
    }
    EList<Model> _superModels = it.getSuperModels();
    for (final Model superModel : _superModels) {
      this.allAttributesRec(superModel, attrs);
    }
  }
  
  public List<Model> allSuperModels(final Model it) {
    final ArrayList<Model> models = new ArrayList<Model>();
    this.allSupperModelsRec(it, models);
    return models;
  }
  
  public void allSupperModelsRec(final Model it, final List<Model> models) {
    boolean _containsModel = this.containsModel(models, it);
    boolean _not = (!_containsModel);
    if (_not) {
      models.add(it);
    }
    EList<Model> _superModels = it.getSuperModels();
    for (final Model superModel : _superModels) {
      this.allSupperModelsRec(superModel, models);
    }
  }
  
  public String modelRefToLower(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstLower = StringExtensions.toFirstLower(it.getName());
    _builder.append(_firstLower);
    return _builder.toString();
  }
  
  public String modelRefToUpper(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    return _builder.toString();
  }
  
  public String dataName(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((it != null)) {
        String _firstUpper = StringExtensions.toFirstUpper(it.getName());
        _builder.append(_firstUpper);
        _builder.append("Data");
      } else {
        _builder.append("IDataContainer");
      }
    }
    return _builder.toString();
  }
  
  public String abstractDataName(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((it != null)) {
        _builder.append("Abstract");
        String _firstUpper = StringExtensions.toFirstUpper(it.getName());
        _builder.append(_firstUpper);
        _builder.append("Data");
      } else {
        _builder.append("IDataContainer");
      }
    }
    return _builder.toString();
  }
  
  public String dataInterfaceName(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((it != null)) {
        _builder.append("I");
        String _firstUpper = StringExtensions.toFirstUpper(it.getName());
        _builder.append(_firstUpper);
        _builder.append("Data");
      } else {
        _builder.append("IDataContainer");
      }
    }
    return _builder.toString();
  }
  
  public String dataNameWithPackage(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((it != null)) {
        EObject _eContainer = it.eContainer();
        String _name = ((HttpServer) _eContainer).getName();
        _builder.append(_name);
        _builder.append(".data.");
        String _dataName = this.dataName(it);
        _builder.append(_dataName);
      }
    }
    return _builder.toString();
  }
  
  public String dataInterfaceNameWithPackage(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    EObject _eContainer = it.eContainer();
    String _name = ((HttpServer) _eContainer).getName();
    _builder.append(_name);
    _builder.append(".data.");
    String _dataInterfaceName = this.dataInterfaceName(it);
    _builder.append(_dataInterfaceName);
    return _builder.toString();
  }
  
  public String dataImport(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((it != null)) {
        _builder.append("import ");
        EObject _eContainer = it.eContainer();
        String _name = ((HttpServer) _eContainer).getName();
        _builder.append(_name);
        _builder.append(".data.");
        String _dataInterfaceName = this.dataInterfaceName(it);
        _builder.append(_dataInterfaceName);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("import de.acegen.IDataContainer;");
        _builder.newLine();
      }
    }
    return _builder.toString();
  }
  
  public String dataClassImport(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((it != null)) {
        _builder.append("import ");
        EObject _eContainer = it.eContainer();
        String _name = ((HttpServer) _eContainer).getName();
        _builder.append(_name);
        _builder.append(".data.");
        String _dataName = this.dataName(it);
        _builder.append(_dataName);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("import de.acegen.IDataContainer;");
        _builder.newLine();
      }
    }
    return _builder.toString();
  }
  
  public String dataParamType(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((it != null)) {
        String _dataInterfaceName = this.dataInterfaceName(it);
        _builder.append(_dataInterfaceName);
      } else {
        _builder.append("IDataContainer");
      }
    }
    return _builder.toString();
  }
  
  public boolean containsAttribute(final List<Attribute> it, final Attribute attribute) {
    int _size = it.size();
    boolean _equals = (_size == 0);
    if (_equals) {
      return false;
    } else {
      for (final Attribute attr : it) {
        if ((((attr.getName() != null) && (attribute.getName() != null)) && attr.getName().equals(attribute.getName()))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean containsModel(final List<Model> it, final Model model) {
    int _size = it.size();
    boolean _equals = (_size == 0);
    if (_equals) {
      return false;
    } else {
      for (final Model m : it) {
        boolean _equals_1 = m.getName().equals(model.getName());
        if (_equals_1) {
          return true;
        }
      }
    }
    return false;
  }
}
