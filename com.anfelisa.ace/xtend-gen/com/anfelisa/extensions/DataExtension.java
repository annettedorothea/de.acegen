package com.anfelisa.extensions;

import com.anfelisa.extensions.AttributeExtension;
import com.google.common.base.Objects;
import java.util.List;
import javax.inject.Inject;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class DataExtension {
  @Inject
  @Extension
  private AttributeExtension _attributeExtension;
  
  public String dataName(final Data it) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field name is undefined"
      + "\ntoFirstUpper cannot be resolved");
  }
  
  public String dataNameWithPackage(final Data it) {
    throw new Error("Unresolved compilation problems:"
      + "\nProject cannot be resolved to a type."
      + "\nThe method or field eContainer is undefined"
      + "\nThe method or field name is undefined"
      + "\nname cannot be resolved"
      + "\ntoFirstUpper cannot be resolved");
  }
  
  public String dataImport(final Data it) {
    throw new Error("Unresolved compilation problems:"
      + "\nProject cannot be resolved to a type."
      + "\nThe method or field eContainer is undefined"
      + "\nname cannot be resolved");
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
  
  public /* List<Attribute> */Object allAttributes(final Data it) {
    throw new Error("Unresolved compilation problems:"
      + "\nAttribute cannot be resolved to a type."
      + "\nThe method or field models is undefined"
      + "\nThe method contains(Attribute, List<Attribute>) from the type DataExtension refers to the missing type Attribute"
      + "\nisList cannot be resolved"
      + "\n! cannot be resolved"
      + "\nmodel cannot be resolved"
      + "\nattributes cannot be resolved");
  }
  
  public /* List<Model> */Object allListModels(final Data it) {
    throw new Error("Unresolved compilation problems:"
      + "\nModel cannot be resolved to a type."
      + "\nThe method or field models is undefined"
      + "\nisList cannot be resolved"
      + "\nmodel cannot be resolved");
  }
  
  public /* List<Model> */Object allNonListModels(final Data it) {
    throw new Error("Unresolved compilation problems:"
      + "\nModel cannot be resolved to a type."
      + "\nThe method or field models is undefined"
      + "\nisList cannot be resolved"
      + "\n! cannot be resolved"
      + "\nmodel cannot be resolved");
  }
  
  private boolean contains(final /* Attribute */Object attribute, final /* List<Attribute> */Object attributes) {
    throw new Error("Unresolved compilation problems:"
      + "\nname cannot be resolved"
      + "\nequals cannot be resolved"
      + "\nname cannot be resolved");
  }
  
  public CharSequence newFromCommandData(final Data it) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method allAttributes(Data) from the type DataExtension refers to the missing type Attribute"
      + "\ngetterCall cannot be resolved");
  }
  
  public String listGetter(final Data it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("public List<");
    String _dataNameWithPackage = this.dataNameWithPackage(it);
    _builder.append(_dataNameWithPackage, "");
    _builder.append("> get");
    String _dataName = this.dataName(it);
    String _firstUpper = StringExtensions.toFirstUpper(_dataName);
    _builder.append(_firstUpper, "");
    _builder.append("List() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return this.");
    String _dataName_1 = this.dataName(it);
    String _firstLower = StringExtensions.toFirstLower(_dataName_1);
    _builder.append(_firstLower, "\t");
    _builder.append("List;");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    return _builder.toString();
  }
  
  public String listSetter(final Data it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public void set");
    String _dataName = this.dataName(it);
    String _firstUpper = StringExtensions.toFirstUpper(_dataName);
    _builder.append(_firstUpper, "");
    _builder.append("List(List<");
    String _dataNameWithPackage = this.dataNameWithPackage(it);
    _builder.append(_dataNameWithPackage, "");
    _builder.append("> ");
    String _dataName_1 = this.dataName(it);
    String _firstLower = StringExtensions.toFirstLower(_dataName_1);
    _builder.append(_firstLower, "");
    _builder.append("List) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("this.");
    String _dataName_2 = this.dataName(it);
    String _firstLower_1 = StringExtensions.toFirstLower(_dataName_2);
    _builder.append(_firstLower_1, "\t");
    _builder.append("List = ");
    String _dataName_3 = this.dataName(it);
    String _firstLower_2 = StringExtensions.toFirstLower(_dataName_3);
    _builder.append(_firstLower_2, "\t");
    _builder.append("List;");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    return _builder.toString();
  }
}
