package com.anfelisa.extensions;

import com.anfelisa.ace.Attribute;
import com.anfelisa.ace.Data;
import com.anfelisa.ace.Model;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class DataExtension {
  public String dataName(final Data it) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = it.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append("Data");
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
}
