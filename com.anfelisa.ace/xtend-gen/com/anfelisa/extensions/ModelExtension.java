package com.anfelisa.extensions;

import com.anfelisa.ace.Attribute;
import com.anfelisa.ace.Model;
import com.anfelisa.ace.ModelRef;
import com.anfelisa.ace.Project;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ModelExtension {
  public String modelName(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("I");
    String _name = it.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append("Model");
    return _builder.toString();
  }
  
  public String modelListAttributeName(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = it.getName();
    _builder.append(_name, "");
    _builder.append("List");
    return _builder.toString();
  }
  
  public String modelClassName(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = it.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append("Model");
    return _builder.toString();
  }
  
  public String modelParam(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = it.getName();
    String _firstLower = StringExtensions.toFirstLower(_name);
    _builder.append(_firstLower, "");
    _builder.append("Model");
    return _builder.toString();
  }
  
  public String modelDao(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = it.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append("Dao");
    return _builder.toString();
  }
  
  public String modelMapper(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = it.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append("Mapper");
    return _builder.toString();
  }
  
  public String table(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = it.getName();
    String _lowerCase = _name.toLowerCase();
    _builder.append(_lowerCase, "");
    return _builder.toString();
  }
  
  public String importModel(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import ");
    String _modelInterfaceWithPackage = this.modelInterfaceWithPackage(it);
    _builder.append(_modelInterfaceWithPackage, "");
    _builder.append(";");
    return _builder.toString();
  }
  
  public String modelInterfaceWithPackage(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    EObject _eContainer = it.eContainer();
    String _name = ((Project) _eContainer).getName();
    _builder.append(_name, "");
    _builder.append(".models.");
    String _modelName = this.modelName(it);
    _builder.append(_modelName, "");
    return _builder.toString();
  }
  
  public Attribute findSerialAttribute(final Model it) {
    EList<Attribute> _attributes = it.getAttributes();
    for (final Attribute attribute : _attributes) {
      boolean _isPrimaryKey = attribute.isPrimaryKey();
      if (_isPrimaryKey) {
        return attribute;
      }
    }
    return null;
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
  
  public List<Attribute> allNonSerialAttributes(final Model it) {
    ArrayList<Attribute> list = new ArrayList<Attribute>();
    EList<Attribute> _attributes = it.getAttributes();
    for (final Attribute attribute : _attributes) {
      boolean _isPrimaryKey = attribute.isPrimaryKey();
      boolean _not = (!_isPrimaryKey);
      if (_not) {
        list.add(attribute);
      }
    }
    return list;
  }
  
  public String listGetter(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("public java.util.List<");
    String _modelName = this.modelName(it);
    _builder.append(_modelName, "");
    _builder.append("> get");
    String _modelListAttributeName = this.modelListAttributeName(it);
    String _firstUpper = StringExtensions.toFirstUpper(_modelListAttributeName);
    _builder.append(_firstUpper, "");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return this.");
    String _modelListAttributeName_1 = this.modelListAttributeName(it);
    _builder.append(_modelListAttributeName_1, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    return _builder.toString();
  }
  
  public String listSetter(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public void set");
    String _modelListAttributeName = this.modelListAttributeName(it);
    String _firstUpper = StringExtensions.toFirstUpper(_modelListAttributeName);
    _builder.append(_firstUpper, "");
    _builder.append("(java.util.List<");
    String _modelName = this.modelName(it);
    _builder.append(_modelName, "");
    _builder.append("> ");
    String _modelListAttributeName_1 = this.modelListAttributeName(it);
    _builder.append(_modelListAttributeName_1, "");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("this.");
    String _modelListAttributeName_2 = this.modelListAttributeName(it);
    _builder.append(_modelListAttributeName_2, "\t");
    _builder.append(" = ");
    String _modelListAttributeName_3 = this.modelListAttributeName(it);
    _builder.append(_modelListAttributeName_3, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    return _builder.toString();
  }
  
  public String interfaceGetter(final ModelRef it) {
    StringConcatenation _builder = new StringConcatenation();
    String _interfaceWithPackage = this.interfaceWithPackage(it);
    _builder.append(_interfaceWithPackage, "");
    _builder.append(" get");
    String _modelRefToUpper = this.modelRefToUpper(it);
    _builder.append(_modelRefToUpper, "");
    _builder.append("();");
    return _builder.toString();
  }
  
  public String declaration(final ModelRef it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private ");
    String _interfaceWithPackage = this.interfaceWithPackage(it);
    _builder.append(_interfaceWithPackage, "");
    _builder.append(" ");
    String _modelRefToLower = this.modelRefToLower(it);
    _builder.append(_modelRefToLower, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public String interfaceWithPackage(final ModelRef it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isList = it.isList();
      if (_isList) {
        _builder.append("java.util.List<");
      }
    }
    Model _model = it.getModel();
    String _modelInterfaceWithPackage = this.modelInterfaceWithPackage(_model);
    _builder.append(_modelInterfaceWithPackage, "");
    {
      boolean _isList_1 = it.isList();
      if (_isList_1) {
        _builder.append(">");
      }
    }
    return _builder.toString();
  }
  
  public String getter(final ModelRef it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("public ");
    String _interfaceWithPackage = this.interfaceWithPackage(it);
    _builder.append(_interfaceWithPackage, "");
    _builder.append(" get");
    String _modelRefToUpper = this.modelRefToUpper(it);
    _builder.append(_modelRefToUpper, "");
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
  
  public String setter(final ModelRef it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public void set");
    String _modelRefToUpper = this.modelRefToUpper(it);
    _builder.append(_modelRefToUpper, "");
    _builder.append("(");
    String _interfaceWithPackage = this.interfaceWithPackage(it);
    _builder.append(_interfaceWithPackage, "");
    _builder.append(" ");
    String _modelRefToLower = this.modelRefToLower(it);
    _builder.append(_modelRefToLower, "");
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
  
  public String modelRefToLower(final ModelRef it) {
    StringConcatenation _builder = new StringConcatenation();
    Model _model = it.getModel();
    String _name = _model.getName();
    String _firstLower = StringExtensions.toFirstLower(_name);
    _builder.append(_firstLower, "");
    {
      boolean _isList = it.isList();
      if (_isList) {
        _builder.append("List");
      }
    }
    return _builder.toString();
  }
  
  public String modelRefToUpper(final ModelRef it) {
    StringConcatenation _builder = new StringConcatenation();
    Model _model = it.getModel();
    String _modelName = this.modelName(_model);
    String _firstUpper = StringExtensions.toFirstUpper(_modelName);
    _builder.append(_firstUpper, "");
    {
      boolean _isList = it.isList();
      if (_isList) {
        _builder.append("List");
      }
    }
    return _builder.toString();
  }
}
