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
package de.acegen.templates.java.models;

import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.HttpServer;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.java.AttributeExtension;
import de.acegen.extensions.java.TypeExtension;
import jakarta.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

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

  public CharSequence generateAbstractModel() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public abstract class AbstractModel {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public abstract void freeze();");
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
    _builder.append("package ");
    String _modelPackageName = this._typeExtension.modelPackageName(httpServer);
    _builder.append(_modelPackageName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.annotation.JsonProperty;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.annotation.JsonSerialize;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.annotation.JsonDeserialize;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import de.acegen.DateTimeToStringConverter;");
    _builder.newLine();
    _builder.append("import de.acegen.StringToDateTimeConverter;");
    _builder.newLine();
    _builder.append("import de.acegen.AbstractModel;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"unused\")");
    _builder.newLine();
    _builder.append("public class ");
    String _modelClassName = this._typeExtension.modelClassName(it);
    _builder.append(_modelClassName);
    _builder.append(" extends AbstractModel {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      List<Attribute> _allAttributes = this._commonExtension.allAttributes(it);
      for(final Attribute attribute : _allAttributes) {
        _builder.append("\t");
        String _declaration = this._attributeExtension.declaration(attribute);
        _builder.append(_declaration, "\t");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
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
        String _paramAsJsonProperty = this._attributeExtension.paramAsJsonProperty(attribute_1);
        _builder.append(_paramAsJsonProperty, "\t\t");
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
      List<Attribute> _allAttributes_3 = this._commonExtension.allAttributes(it);
      for(final Attribute attribute_3 : _allAttributes_3) {
        _builder.append("\t");
        String _jsonProperty = this._attributeExtension.jsonProperty(attribute_3);
        _builder.append(_jsonProperty, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _ter = this._attributeExtension.getter(attribute_3);
        _builder.append(_ter, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        String _jsonProperty_1 = this._attributeExtension.jsonProperty(attribute_3);
        _builder.append(_jsonProperty_1, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _setterWithFrozen = this._attributeExtension.setterWithFrozen(attribute_3);
        _builder.append(_setterWithFrozen, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      EList<de.acegen.aceGen.Model> _superModels = it.getSuperModels();
      for(final de.acegen.aceGen.Model superModel : _superModels) {
        _builder.append("\t");
        _builder.append("public ");
        String _modelClassNameWithPackage = this._typeExtension.modelClassNameWithPackage(superModel);
        _builder.append(_modelClassNameWithPackage, "\t");
        _builder.append(" mapTo");
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
          List<Attribute> _allAttributes_4 = this._commonExtension.allAttributes(superModel);
          for(final Attribute attribute_4 : _allAttributes_4) {
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("model.");
            String _setterName = this._attributeExtension.setterName(attribute_4);
            _builder.append(_setterName, "\t\t");
            _builder.append("(this.");
            String _terName = this._attributeExtension.getterName(attribute_4);
            _builder.append(_terName, "\t\t");
            _builder.append("());");
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
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void freeze() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.frozen = true;");
    _builder.newLine();
    {
      List<Attribute> _allAttributes_5 = this._commonExtension.allAttributes(it);
      for(final Attribute attribute_5 : _allAttributes_5) {
        {
          de.acegen.aceGen.Model _model = attribute_5.getModel();
          boolean _tripleNotEquals = (_model != null);
          if (_tripleNotEquals) {
            _builder.append("\t\t");
            _builder.append("if (this.");
            String _propertyName = this._attributeExtension.propertyName(attribute_5);
            _builder.append(_propertyName, "\t\t");
            _builder.append(" != null) {");
            _builder.newLineIfNotEmpty();
            {
              boolean _isList = attribute_5.isList();
              if (_isList) {
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("for ( int i = 0; i < ");
                String _propertyName_1 = this._attributeExtension.propertyName(attribute_5);
                _builder.append(_propertyName_1, "\t\t\t");
                _builder.append(".size(); i++ ) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("\t");
                String _propertyName_2 = this._attributeExtension.propertyName(attribute_5);
                _builder.append(_propertyName_2, "\t\t\t\t");
                _builder.append(".get(i).freeze();");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
              } else {
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("this.");
                String _propertyName_3 = this._attributeExtension.propertyName(attribute_5);
                _builder.append(_propertyName_3, "\t\t\t");
                _builder.append(".freeze();");
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
    _builder.append("\t");
    _builder.append("public static ");
    String _modelClassName_4 = this._typeExtension.modelClassName(it);
    _builder.append(_modelClassName_4, "\t");
    _builder.append(" generateTestData() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("java.util.Random random = new java.util.Random();");
    _builder.newLine();
    {
      final Function1<Attribute, Boolean> _function = new Function1<Attribute, Boolean>() {
        public Boolean apply(final Attribute a) {
          return Boolean.valueOf(a.isList());
        }
      };
      int _size = IterableExtensions.size(IterableExtensions.<Attribute>filter(this._commonExtension.allAttributes(it), _function));
      boolean _greaterThan_1 = (_size > 0);
      if (_greaterThan_1) {
        _builder.append("\t\t");
        _builder.append("int n;");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    String _modelClassName_5 = this._typeExtension.modelClassName(it);
    _builder.append(_modelClassName_5, "\t\t");
    _builder.append(" testData = new ");
    String _modelClassName_6 = this._typeExtension.modelClassName(it);
    _builder.append(_modelClassName_6, "\t\t");
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    {
      List<Attribute> _allAttributes_6 = this._commonExtension.allAttributes(it);
      for(final Attribute attribute_6 : _allAttributes_6) {
        {
          de.acegen.aceGen.Model _model_1 = attribute_6.getModel();
          boolean _tripleNotEquals_1 = (_model_1 != null);
          if (_tripleNotEquals_1) {
            {
              boolean _isList_1 = attribute_6.isList();
              if (_isList_1) {
                _builder.append("\t\t");
                _builder.append("java.util.List<");
                String _modelClassNameWithPackage_3 = this._typeExtension.modelClassNameWithPackage(attribute_6.getModel());
                _builder.append(_modelClassNameWithPackage_3, "\t\t");
                _builder.append("> ");
                String _propertyName_4 = this._attributeExtension.propertyName(attribute_6);
                _builder.append(_propertyName_4, "\t\t");
                _builder.append("List = new java.util.ArrayList<");
                String _modelClassNameWithPackage_4 = this._typeExtension.modelClassNameWithPackage(attribute_6.getModel());
                _builder.append(_modelClassNameWithPackage_4, "\t\t");
                _builder.append(">();");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("n = random.nextInt(20) + 1;");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("for ( int i = 0; i < n; i++ ) {");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t");
                String _propertyName_5 = this._attributeExtension.propertyName(attribute_6);
                _builder.append(_propertyName_5, "\t\t\t");
                _builder.append("List.add(");
                String _modelClassNameWithPackage_5 = this._typeExtension.modelClassNameWithPackage(attribute_6.getModel());
                _builder.append(_modelClassNameWithPackage_5, "\t\t\t");
                _builder.append(".generateTestData());");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("testData.");
                String _setterName_1 = this._attributeExtension.setterName(attribute_6);
                _builder.append(_setterName_1, "\t\t");
                _builder.append("(");
                String _firstLower = StringExtensions.toFirstLower(attribute_6.getName());
                _builder.append(_firstLower, "\t\t");
                _builder.append("List);");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t\t");
                _builder.append("testData.");
                String _setterName_2 = this._attributeExtension.setterName(attribute_6);
                _builder.append(_setterName_2, "\t\t");
                _builder.append("(");
                String _modelClassNameWithPackage_6 = this._typeExtension.modelClassNameWithPackage(attribute_6.getModel());
                _builder.append(_modelClassNameWithPackage_6, "\t\t");
                _builder.append(".generateTestData());");
                _builder.newLineIfNotEmpty();
              }
            }
          } else {
            {
              boolean _isList_2 = attribute_6.isList();
              if (_isList_2) {
                _builder.append("\t\t");
                String _javaType = this._typeExtension.javaType(attribute_6);
                _builder.append(_javaType, "\t\t");
                _builder.append(" ");
                String _propertyName_6 = this._attributeExtension.propertyName(attribute_6);
                _builder.append(_propertyName_6, "\t\t");
                _builder.append("List = new ");
                String _javaTypeNew = this._typeExtension.javaTypeNew(attribute_6);
                _builder.append(_javaTypeNew, "\t\t");
                _builder.append("();");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("n = random.nextInt(20) + 1;");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("for ( int i = 0; i < n; i++ ) {");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t");
                String _propertyName_7 = this._attributeExtension.propertyName(attribute_6);
                _builder.append(_propertyName_7, "\t\t\t");
                _builder.append("List.add(");
                String _randomValue = this._attributeExtension.randomValue(attribute_6);
                _builder.append(_randomValue, "\t\t\t");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("testData.");
                String _setterName_3 = this._attributeExtension.setterName(attribute_6);
                _builder.append(_setterName_3, "\t\t");
                _builder.append("(");
                String _firstLower_1 = StringExtensions.toFirstLower(attribute_6.getName());
                _builder.append(_firstLower_1, "\t\t");
                _builder.append("List);");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t\t");
                _builder.append("testData.");
                String _setterName_4 = this._attributeExtension.setterName(attribute_6);
                _builder.append(_setterName_4, "\t\t");
                _builder.append("(");
                String _randomValue_1 = this._attributeExtension.randomValue(attribute_6);
                _builder.append(_randomValue_1, "\t\t");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    _builder.append("\t\t");
    _builder.append("return testData;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static String randomString(java.util.Random random) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String chars = \"aaaaaaabcdeeeeeeeffffghiiiiiiijkllllllmmmmnnnnnnnooooooooopqrstttuuuuuuuvxyz\";");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("int n = random.nextInt(20) + 5;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("StringBuilder sb = new StringBuilder(n);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for (int i = 0; i < n; i++) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("int index = random.nextInt(chars.length());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("sb.append(chars.charAt(index));");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String string  = sb.toString(); ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return string.substring(0,1).toUpperCase() + string.substring(1).toLowerCase();");
    _builder.newLine();
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
