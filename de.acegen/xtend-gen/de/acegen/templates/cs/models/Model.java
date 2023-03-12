package de.acegen.templates.cs.models;

import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.HttpServer;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.cs.AttributeExtension;
import de.acegen.extensions.cs.TypeExtension;
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
  private AttributeExtension _attributeExtension;

  @Inject
  @Extension
  private CommonExtension _commonExtension;

  @Inject
  @Extension
  private TypeExtension _typeExtension;

  public CharSequence generateAbstractModel(final HttpServer it) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("namespace ");
    CharSequence _acegenNamespace = this._typeExtension.acegenNamespace(it);
    _builder.append(_acegenNamespace);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public abstract class AbstractModel {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public abstract void Freeze();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  public CharSequence generateClass(final de.acegen.aceGen.Model it, final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("using ");
    CharSequence _acegenNamespace = this._typeExtension.acegenNamespace(httpServer);
    _builder.append(_acegenNamespace);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("namespace ");
    CharSequence _modelNamespace = this._typeExtension.modelNamespace(httpServer);
    _builder.append(_modelNamespace);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _modelClassName = this._typeExtension.modelClassName(it);
    _builder.append(_modelClassName);
    _builder.append(" : AbstractModel {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      List<Attribute> _allAttributes = this._commonExtension.allAttributes(it);
      for(final Attribute attribute : _allAttributes) {
        _builder.append("\t");
        String _declaration = this._attributeExtension.declaration(attribute);
        _builder.append(_declaration, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private Boolean frozen = false;");
    _builder.newLine();
    _builder.newLine();
    {
      int _length = ((Object[])Conversions.unwrapArray(this._commonExtension.allAttributes(it), Object.class)).length;
      boolean _greaterThan = (_length > 0);
      if (_greaterThan) {
        _builder.append("\t");
        _builder.append("public ");
        String _modelClassName_1 = this._typeExtension.modelClassName(it);
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
    String _modelClassName_2 = this._typeExtension.modelClassName(it);
    _builder.append(_modelClassName_2, "\t");
    _builder.append("(");
    _builder.newLineIfNotEmpty();
    {
      List<Attribute> _allAttributes_1 = this._commonExtension.allAttributes(it);
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
      List<Attribute> _allAttributes_2 = this._commonExtension.allAttributes(it);
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
    {
      EList<de.acegen.aceGen.Model> _superModels = it.getSuperModels();
      for(final de.acegen.aceGen.Model superModel : _superModels) {
        _builder.append("\t");
        _builder.append("public ");
        String _modelClassNameWithPackage = this._typeExtension.modelClassNameWithPackage(superModel);
        _builder.append(_modelClassNameWithPackage, "\t");
        _builder.append(" MapTo");
        String _modelClassName_3 = this._typeExtension.modelClassName(superModel);
        _builder.append(_modelClassName_3, "\t");
        _builder.append("() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        String _modelClassNameWithPackage_1 = this._typeExtension.modelClassNameWithPackage(superModel);
        _builder.append(_modelClassNameWithPackage_1, "\t\t");
        _builder.append(" model = new ");
        String _modelClassNameWithPackage_2 = this._typeExtension.modelClassNameWithPackage(superModel);
        _builder.append(_modelClassNameWithPackage_2, "\t\t");
        _builder.append("();");
        _builder.newLineIfNotEmpty();
        {
          List<Attribute> _allAttributes_3 = this._commonExtension.allAttributes(superModel);
          for(final Attribute attribute_3 : _allAttributes_3) {
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("model.");
            String _propertyName = this._attributeExtension.propertyName(attribute_3);
            _builder.append(_propertyName, "\t\t");
            _builder.append(" = this.");
            String _propertyName_1 = this._attributeExtension.propertyName(attribute_3);
            _builder.append(_propertyName_1, "\t\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return model;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}\t");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public override void Freeze() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.frozen = true;");
    _builder.newLine();
    {
      List<Attribute> _allAttributes_4 = this._commonExtension.allAttributes(it);
      for(final Attribute attribute_4 : _allAttributes_4) {
        {
          de.acegen.aceGen.Model _model = attribute_4.getModel();
          boolean _tripleNotEquals = (_model != null);
          if (_tripleNotEquals) {
            _builder.append("\t\t");
            _builder.append("if (this.");
            String _propertyName_2 = this._attributeExtension.propertyName(attribute_4);
            _builder.append(_propertyName_2, "\t\t");
            _builder.append(" != null) {");
            _builder.newLineIfNotEmpty();
            {
              boolean _isList = attribute_4.isList();
              if (_isList) {
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("for ( int i = 0; i < ");
                String _propertyName_3 = this._attributeExtension.propertyName(attribute_4);
                _builder.append(_propertyName_3, "\t\t\t");
                _builder.append(".Count(); i++ ) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("\t");
                String _propertyName_4 = this._attributeExtension.propertyName(attribute_4);
                _builder.append(_propertyName_4, "\t\t\t\t");
                _builder.append("[i].Freeze();");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
              } else {
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("this.");
                String _propertyName_5 = this._attributeExtension.propertyName(attribute_4);
                _builder.append(_propertyName_5, "\t\t\t");
                _builder.append(".Freeze();");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
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
