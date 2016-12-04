package com.anfelisa.extensions;

import com.anfelisa.ace.ComplexAttribute;
import com.anfelisa.ace.Model;
import com.anfelisa.extensions.ModelExtension;
import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ComplexAttributeExtension {
  @Inject
  @Extension
  private ModelExtension _modelExtension;
  
  public String declaration(final ComplexAttribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private ");
    String _javaType = this.javaType(it);
    _builder.append(_javaType, "");
    _builder.append(" ");
    String _name = it.getName();
    _builder.append(_name, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public String javaType(final ComplexAttribute it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isList = it.isList();
      if (_isList) {
        _builder.append("java.util.List<");
      }
    }
    Model _model = it.getModel();
    String _modelInterfaceWithPackage = this._modelExtension.modelInterfaceWithPackage(_model);
    _builder.append(_modelInterfaceWithPackage, "");
    {
      boolean _isList_1 = it.isList();
      if (_isList_1) {
        _builder.append(">");
      }
    }
    return _builder.toString();
  }
  
  public String param(final ComplexAttribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@JsonProperty(\"");
    String _name = it.getName();
    _builder.append(_name, "");
    _builder.append("\") ");
    String _javaType = this.javaType(it);
    _builder.append(_javaType, "");
    _builder.append(" ");
    String _name_1 = it.getName();
    _builder.append(_name_1, "");
    return _builder.toString();
  }
  
  public String name(final ComplexAttribute it) {
    StringConcatenation _builder = new StringConcatenation();
    Model _model = it.getModel();
    String _modelName = this._modelExtension.modelName(_model);
    _builder.append(_modelName, "");
    {
      boolean _isList = it.isList();
      if (_isList) {
        _builder.append("List");
      }
    }
    return _builder.toString();
  }
  
  public String interfaceGetter(final ComplexAttribute it) {
    StringConcatenation _builder = new StringConcatenation();
    String _javaType = this.javaType(it);
    _builder.append(_javaType, "");
    _builder.append(" get");
    String _name = it.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append("();");
    return _builder.toString();
  }
  
  public String getter(final ComplexAttribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("public ");
    String _javaType = this.javaType(it);
    _builder.append(_javaType, "");
    _builder.append(" get");
    String _name = it.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return this.");
    String _name_1 = it.getName();
    _builder.append(_name_1, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    return _builder.toString();
  }
  
  public String getterCall(final ComplexAttribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("get");
    String _name = it.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append("()");
    return _builder.toString();
  }
  
  public String setter(final ComplexAttribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public void set");
    String _name = it.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append("(");
    String _javaType = this.javaType(it);
    _builder.append(_javaType, "");
    _builder.append(" ");
    String _name_1 = it.getName();
    _builder.append(_name_1, "");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("this.");
    String _name_2 = it.getName();
    _builder.append(_name_2, "\t");
    _builder.append(" = ");
    String _name_3 = it.getName();
    _builder.append(_name_3, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    return _builder.toString();
  }
  
  public String initializer(final ComplexAttribute it, final String className) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public ");
    _builder.append(className, "");
    _builder.append(" with");
    String _name = it.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append("(");
    String _javaType = this.javaType(it);
    _builder.append(_javaType, "");
    _builder.append(" ");
    String _name_1 = it.getName();
    _builder.append(_name_1, "");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("this.");
    String _name_2 = it.getName();
    _builder.append(_name_2, "\t");
    _builder.append(" = ");
    String _name_3 = it.getName();
    _builder.append(_name_3, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return this;");
    _builder.newLine();
    _builder.append("}");
    return _builder.toString();
  }
  
  public String assign(final ComplexAttribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("this.");
    String _name = it.getName();
    _builder.append(_name, "");
    _builder.append(" = ");
    String _name_1 = it.getName();
    _builder.append(_name_1, "");
    _builder.append(";");
    return _builder.toString();
  }
}
