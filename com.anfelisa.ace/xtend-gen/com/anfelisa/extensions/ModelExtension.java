package com.anfelisa.extensions;

import com.anfelisa.ace.Attribute;
import com.anfelisa.ace.Model;
import com.anfelisa.ace.Project;
import com.anfelisa.extensions.AttributeExtension;
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
    String _name = it.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append("Model");
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
    EObject _eContainer = it.eContainer();
    String _name = ((Project) _eContainer).getName();
    _builder.append(_name, "");
    _builder.append(".models.");
    String _modelName = this.modelName(it);
    _builder.append(_modelName, "");
    _builder.append(";");
    return _builder.toString();
  }
  
  public Attribute findSerialAttribute(final Model it) {
    EList<Attribute> _attributes = it.getAttributes();
    for (final Attribute attribute : _attributes) {
      boolean _primaryKey = this._attributeExtension.primaryKey(attribute);
      if (_primaryKey) {
        return attribute;
      }
    }
    return null;
  }
}
