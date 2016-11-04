package com.anfelisa.extensions;

import com.anfelisa.ace.Attribute;
import com.anfelisa.ace.Data;
import com.anfelisa.ace.Model;
import com.anfelisa.ace.Project;
import com.anfelisa.extensions.AttributeExtension;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class DataExtension {
  @Inject
  @Extension
  private AttributeExtension _attributeExtension;
  
  public String dataName(final Data it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _notEquals = (!Objects.equal(it, null));
      if (_notEquals) {
        String _name = it.getName();
        String _firstUpper = StringExtensions.toFirstUpper(_name);
        _builder.append(_firstUpper, "");
        _builder.append("Data");
      } else {
        _builder.append("IDataContainer");
      }
    }
    return _builder.toString();
  }
  
  public String dataNameWithPackage(final Data it) {
    StringConcatenation _builder = new StringConcatenation();
    EObject _eContainer = it.eContainer();
    String _name = ((Project) _eContainer).getName();
    _builder.append(_name, "");
    _builder.append(".data.");
    String _name_1 = it.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name_1);
    _builder.append(_firstUpper, "");
    _builder.append("Data");
    return _builder.toString();
  }
  
  public String dataImport(final Data it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _notEquals = (!Objects.equal(it, null));
      if (_notEquals) {
        _builder.append("import ");
        EObject _eContainer = it.eContainer();
        String _name = ((Project) _eContainer).getName();
        _builder.append(_name, "");
        _builder.append(".data.");
        String _dataName = this.dataName(it);
        _builder.append(_dataName, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("import com.anfelisa.ace.IDataContainer;");
        _builder.newLine();
      }
    }
    return _builder.toString();
  }
  
  public String dataParamType(final Data it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _notEquals = (!Objects.equal(it, null));
      if (_notEquals) {
        String _dataName = this.dataName(it);
        _builder.append(_dataName, "");
      } else {
        _builder.append("IDataContainer");
      }
    }
    return _builder.toString();
  }
  
  public List<Attribute> allAttributes(final Data it) {
    final ArrayList<Attribute> attrs = new ArrayList<Attribute>();
    EList<Model> _models = it.getModels();
    for (final Model model : _models) {
      EList<Attribute> _attributes = model.getAttributes();
      for (final Attribute attribute : _attributes) {
        boolean _contains = this.contains(attribute, attrs);
        boolean _not = (!_contains);
        if (_not) {
          attrs.add(attribute);
        }
      }
    }
    return attrs;
  }
  
  private boolean contains(final Attribute attribute, final List<Attribute> attributes) {
    boolean _xifexpression = false;
    int _size = attributes.size();
    boolean _equals = (_size == 0);
    if (_equals) {
      return false;
    } else {
      for (final Attribute attr : attributes) {
        String _name = attr.getName();
        String _name_1 = attribute.getName();
        boolean _equals_1 = _name.equals(_name_1);
        if (_equals_1) {
          return true;
        }
      }
    }
    return _xifexpression;
  }
  
  public CharSequence newFromCommandData(final Data it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new ");
    String _dataNameWithPackage = this.dataNameWithPackage(it);
    _builder.append(_dataNameWithPackage, "");
    _builder.append("(");
    _builder.newLineIfNotEmpty();
    {
      List<Attribute> _allAttributes = this.allAttributes(it);
      boolean _hasElements = false;
      for(final Attribute attribute : _allAttributes) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "\t\t\t");
        }
        _builder.append("\t\t\t");
        _builder.append("this.commandData.");
        String _terCall = this._attributeExtension.getterCall(attribute);
        _builder.append(_terCall, "\t\t\t");
        _builder.newLineIfNotEmpty();
      }
      if (_hasElements) {
        _builder.append(",", "\t\t\t");
      }
    }
    _builder.append("\t\t\t");
    _builder.append("this.commandData.getUuid()");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append(")");
    return _builder;
  }
}
