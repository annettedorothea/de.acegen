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
package de.acegen.templates.java.data;

import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.AttributeParamRef;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.Model;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.java.AceExtension;
import de.acegen.extensions.java.AttributeExtension;
import de.acegen.extensions.java.ModelExtension;
import java.util.List;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class Data {
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
  private AceExtension _aceExtension;
  
  public CharSequence generateDataInterface(final Model it, final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = httpServer.getName();
    _builder.append(_name);
    _builder.append(".data;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.annotation.JsonDeserialize;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import de.acegen.IDataContainer;");
    _builder.newLine();
    _builder.newLine();
    String _importModel = this._modelExtension.importModel(it);
    _builder.append(_importModel);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("@JsonDeserialize(as=");
    String _dataName = this._modelExtension.dataName(it);
    _builder.append(_dataName);
    _builder.append(".class)");
    _builder.newLineIfNotEmpty();
    _builder.append("public interface ");
    String _dataInterfaceName = this._modelExtension.dataInterfaceName(it);
    _builder.append(_dataInterfaceName);
    _builder.append(" extends ");
    String _modelName = this._modelExtension.modelName(it);
    _builder.append(_modelName);
    _builder.append(", IDataContainer {");
    _builder.newLineIfNotEmpty();
    {
      EList<Model> _superModels = it.getSuperModels();
      for(final Model superModel : _superModels) {
        _builder.append("\t");
        _builder.append("void mapFrom(");
        String _interfaceWithPackage = this._modelExtension.interfaceWithPackage(superModel);
        _builder.append(_interfaceWithPackage, "\t");
        _builder.append(" model);");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      List<Attribute> _allAttributes = this._modelExtension.allAttributes(it);
      for(final Attribute attribute : _allAttributes) {
        _builder.append("\t");
        String _dataInterfaceName_1 = this._modelExtension.dataInterfaceName(it);
        _builder.append(_dataInterfaceName_1, "\t");
        _builder.append(" with");
        String _firstUpper = StringExtensions.toFirstUpper(attribute.getName());
        _builder.append(_firstUpper, "\t");
        _builder.append("(");
        String _javaType = this._attributeExtension.javaType(attribute);
        _builder.append(_javaType, "\t");
        _builder.append(" ");
        String _name_1 = attribute.getName();
        _builder.append(_name_1, "\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    String _dataInterfaceName_2 = this._modelExtension.dataInterfaceName(it);
    _builder.append(_dataInterfaceName_2, "\t");
    _builder.append(" deepCopy();");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateAbstractData(final Model it, final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = httpServer.getName();
    _builder.append(_name);
    _builder.append(".data;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.annotation.JsonProperty;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.annotation.JsonSerialize;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.annotation.JsonDeserialize;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.time.LocalDateTime;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.append("import java.util.ArrayList;");
    _builder.newLine();
    String _importModel = this._modelExtension.importModel(it);
    _builder.append(_importModel);
    _builder.newLineIfNotEmpty();
    {
      EList<Model> _superModels = it.getSuperModels();
      for(final Model superModel : _superModels) {
        String _importModel_1 = this._modelExtension.importModel(superModel);
        _builder.append(_importModel_1);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("import de.acegen.AbstractData;");
    _builder.newLine();
    _builder.append("import de.acegen.IDataContainer;");
    _builder.newLine();
    _builder.append("import de.acegen.DateTimeToStringConverter;");
    _builder.newLine();
    _builder.append("import de.acegen.StringToDateTimeConverter;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"unused\")");
    _builder.newLine();
    _builder.append("public abstract class ");
    String _abstractDataName = this._modelExtension.abstractDataName(it);
    _builder.append(_abstractDataName);
    _builder.append(" extends AbstractData implements ");
    String _dataInterfaceName = this._modelExtension.dataInterfaceName(it);
    _builder.append(_dataInterfaceName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(");
    String _abstractDataName_1 = this._modelExtension.abstractDataName(it);
    _builder.append(_abstractDataName_1, "\t");
    _builder.append(".class);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      List<Attribute> _allAttributes = this._modelExtension.allAttributes(it);
      for(final Attribute attribute : _allAttributes) {
        _builder.append("\t");
        String _declaration = this._attributeExtension.declaration(attribute);
        _builder.append(_declaration, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _abstractDataName_2 = this._modelExtension.abstractDataName(it);
    _builder.append(_abstractDataName_2, "\t");
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
        String _paramAsJsonProperty = this._attributeExtension.paramAsJsonProperty(attribute_1);
        _builder.append(_paramAsJsonProperty, "\t\t");
        _builder.newLineIfNotEmpty();
      }
      if (_hasElements) {
        _builder.append(",", "\t\t");
      }
    }
    _builder.append("\t\t");
    _builder.append("@JsonProperty(\"uuid\") String uuid");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(") {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super(uuid);");
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
    {
      int _length = ((Object[])Conversions.unwrapArray(this._modelExtension.allAttributes(it), Object.class)).length;
      boolean _greaterThan = (_length > 0);
      if (_greaterThan) {
        _builder.append("\t");
        _builder.append("public ");
        String _abstractDataName_3 = this._modelExtension.abstractDataName(it);
        _builder.append(_abstractDataName_3, "\t");
        _builder.append("( String uuid ) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("super(uuid);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    {
      List<Attribute> _allAttributes_3 = this._modelExtension.allAttributes(it);
      for(final Attribute attribute_3 : _allAttributes_3) {
        _builder.append("\t");
        String _ter = this._attributeExtension.getter(attribute_3, true);
        _builder.append(_ter, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _setter = this._attributeExtension.setter(attribute_3);
        _builder.append(_setter, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _with = this._attributeExtension.with(attribute_3, it);
        _builder.append(_with, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      EList<Model> _superModels_1 = it.getSuperModels();
      for(final Model superModel_1 : _superModels_1) {
        _builder.append("\t");
        _builder.append("public void mapFrom(");
        String _interfaceWithPackage = this._modelExtension.interfaceWithPackage(superModel_1);
        _builder.append(_interfaceWithPackage, "\t");
        _builder.append(" model) {");
        _builder.newLineIfNotEmpty();
        {
          List<Attribute> _allAttributes_4 = this._modelExtension.allAttributes(superModel_1);
          for(final Attribute attribute_4 : _allAttributes_4) {
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("this.");
            String _name_1 = attribute_4.getName();
            _builder.append(_name_1, "\t\t");
            _builder.append(" = model.");
            String _terCall = this._attributeExtension.getterCall(attribute_4);
            _builder.append(_terCall, "\t\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _dataInterfaceName_1 = this._modelExtension.dataInterfaceName(it);
    _builder.append(_dataInterfaceName_1, "\t");
    _builder.append(" deepCopy() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    String _dataInterfaceName_2 = this._modelExtension.dataInterfaceName(it);
    _builder.append(_dataInterfaceName_2, "\t\t");
    _builder.append(" copy = new ");
    String _dataName = this._modelExtension.dataName(it);
    _builder.append(_dataName, "\t\t");
    _builder.append("(this.getUuid());");
    _builder.newLineIfNotEmpty();
    {
      List<Attribute> _allAttributes_5 = this._modelExtension.allAttributes(it);
      for(final Attribute attribute_5 : _allAttributes_5) {
        _builder.append("\t\t");
        String _deepCopy = this._attributeExtension.deepCopy(attribute_5);
        _builder.append(_deepCopy, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("copy.setSystemTime(this.getSystemTime());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return copy;");
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
  
  public CharSequence generateData(final Model it, final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = httpServer.getName();
    _builder.append(_name);
    _builder.append(".data;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.annotation.JsonProperty;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.time.LocalDateTime;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import de.acegen.AbstractData;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _dataName = this._modelExtension.dataName(it);
    _builder.append(_dataName);
    _builder.append(" extends ");
    String _abstractDataName = this._modelExtension.abstractDataName(it);
    _builder.append(_abstractDataName);
    _builder.append(" implements ");
    String _dataInterfaceName = this._modelExtension.dataInterfaceName(it);
    _builder.append(_dataInterfaceName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _dataName_1 = this._modelExtension.dataName(it);
    _builder.append(_dataName_1, "\t");
    _builder.append("(");
    _builder.newLineIfNotEmpty();
    {
      List<Attribute> _allAttributes = this._modelExtension.allAttributes(it);
      for(final Attribute attribute : _allAttributes) {
        _builder.append("\t\t");
        String _paramAsJsonProperty = this._attributeExtension.paramAsJsonProperty(attribute);
        _builder.append(_paramAsJsonProperty, "\t\t");
        _builder.append(", ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("@JsonProperty(\"uuid\") String uuid");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(") {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super(");
    _builder.newLine();
    {
      List<Attribute> _allAttributes_1 = this._modelExtension.allAttributes(it);
      for(final Attribute attribute_1 : _allAttributes_1) {
        _builder.append("\t\t\t");
        String _name_1 = attribute_1.getName();
        _builder.append(_name_1, "\t\t\t");
        _builder.append(",");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t");
    _builder.append("uuid");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append(");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      int _length = ((Object[])Conversions.unwrapArray(this._modelExtension.allAttributes(it), Object.class)).length;
      boolean _greaterThan = (_length > 0);
      if (_greaterThan) {
        _builder.append("\t");
        _builder.append("public ");
        String _dataName_2 = this._modelExtension.dataName(it);
        _builder.append(_dataName_2, "\t");
        _builder.append("( String uuid ) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("super(uuid);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("public void migrateLegacyData(String json) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static ");
    String _interfaceWithPackage = this._modelExtension.interfaceWithPackage(it);
    _builder.append(_interfaceWithPackage, "\t");
    _builder.append(" generateTestData() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("java.util.Random random = new java.util.Random();");
    _builder.newLine();
    {
      final Function1<Attribute, Boolean> _function = (Attribute a) -> {
        return Boolean.valueOf(a.isList());
      };
      int _size = IterableExtensions.size(IterableExtensions.<Attribute>filter(this._modelExtension.allAttributes(it), _function));
      boolean _greaterThan_1 = (_size > 0);
      if (_greaterThan_1) {
        _builder.append("\t\t");
        _builder.append("int n;");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    String _interfaceWithPackage_1 = this._modelExtension.interfaceWithPackage(it);
    _builder.append(_interfaceWithPackage_1, "\t\t");
    _builder.append(" testData = new ");
    String _modelClassNameWithPackage = this._modelExtension.modelClassNameWithPackage(it);
    _builder.append(_modelClassNameWithPackage, "\t\t");
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    {
      List<Attribute> _allAttributes_2 = this._modelExtension.allAttributes(it);
      for(final Attribute attribute_2 : _allAttributes_2) {
        {
          Model _model = attribute_2.getModel();
          boolean _tripleNotEquals = (_model != null);
          if (_tripleNotEquals) {
            {
              boolean _isList = attribute_2.isList();
              if (_isList) {
                _builder.append("\t\t");
                _builder.append("java.util.List<");
                String _interfaceWithPackage_2 = this._modelExtension.interfaceWithPackage(attribute_2.getModel());
                _builder.append(_interfaceWithPackage_2, "\t\t");
                _builder.append("> ");
                String _firstLower = StringExtensions.toFirstLower(attribute_2.getName());
                _builder.append(_firstLower, "\t\t");
                _builder.append("List = new java.util.ArrayList<");
                String _interfaceWithPackage_3 = this._modelExtension.interfaceWithPackage(attribute_2.getModel());
                _builder.append(_interfaceWithPackage_3, "\t\t");
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
                String _firstLower_1 = StringExtensions.toFirstLower(attribute_2.getName());
                _builder.append(_firstLower_1, "\t\t\t");
                _builder.append("List.add(");
                String _dataNameWithPackage = this._modelExtension.dataNameWithPackage(attribute_2.getModel());
                _builder.append(_dataNameWithPackage, "\t\t\t");
                _builder.append(".generateTestData());");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("testData.");
                StringConcatenation _builder_1 = new StringConcatenation();
                String _firstLower_2 = StringExtensions.toFirstLower(attribute_2.getName());
                _builder_1.append(_firstLower_2);
                _builder_1.append("List");
                String _setterCall = this._attributeExtension.setterCall(attribute_2, _builder_1.toString());
                _builder.append(_setterCall, "\t\t");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t\t");
                _builder.append("testData.");
                StringConcatenation _builder_2 = new StringConcatenation();
                String _dataNameWithPackage_1 = this._modelExtension.dataNameWithPackage(attribute_2.getModel());
                _builder_2.append(_dataNameWithPackage_1);
                _builder_2.append(".generateTestData()");
                String _setterCall_1 = this._attributeExtension.setterCall(attribute_2, _builder_2.toString());
                _builder.append(_setterCall_1, "\t\t");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              }
            }
          } else {
            {
              boolean _isList_1 = attribute_2.isList();
              if (_isList_1) {
                _builder.append("\t\t");
                String _javaType = this._attributeExtension.javaType(attribute_2);
                _builder.append(_javaType, "\t\t");
                _builder.append(" ");
                String _firstLower_3 = StringExtensions.toFirstLower(attribute_2.getName());
                _builder.append(_firstLower_3, "\t\t");
                _builder.append("List = new ");
                String _javaTypeNew = this._attributeExtension.javaTypeNew(attribute_2);
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
                String _firstLower_4 = StringExtensions.toFirstLower(attribute_2.getName());
                _builder.append(_firstLower_4, "\t\t\t");
                _builder.append("List.add(");
                String _randomValue = this._attributeExtension.randomValue(attribute_2);
                _builder.append(_randomValue, "\t\t\t");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("testData.");
                StringConcatenation _builder_3 = new StringConcatenation();
                String _firstLower_5 = StringExtensions.toFirstLower(attribute_2.getName());
                _builder_3.append(_firstLower_5);
                _builder_3.append("List");
                String _setterCall_2 = this._attributeExtension.setterCall(attribute_2, _builder_3.toString());
                _builder.append(_setterCall_2, "\t\t");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t\t");
                _builder.append("testData.");
                StringConcatenation _builder_4 = new StringConcatenation();
                String _randomValue_1 = this._attributeExtension.randomValue(attribute_2);
                _builder_4.append(_randomValue_1);
                String _setterCall_3 = this._attributeExtension.setterCall(attribute_2, _builder_4.toString());
                _builder.append(_setterCall_3, "\t\t");
                _builder.append(";");
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
    _builder.append("\t");
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
  
  public CharSequence generateResponseData(final HttpServerAce it, final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = httpServer.getName();
    _builder.append(_name);
    _builder.append(".data;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.annotation.JsonProperty;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.annotation.JsonIgnore;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.annotation.JsonSerialize;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.annotation.JsonDeserialize;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.time.LocalDateTime;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import de.acegen.IDataContainer;");
    _builder.newLine();
    _builder.append("import de.acegen.DateTimeToStringConverter;");
    _builder.newLine();
    _builder.append("import de.acegen.StringToDateTimeConverter;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"all\")");
    _builder.newLine();
    _builder.append("public class ");
    String _responseDataName = this._aceExtension.responseDataName(it);
    _builder.append(_responseDataName);
    _builder.append(" implements ");
    String _responseDataInterfaceName = this._aceExtension.responseDataInterfaceName(it);
    _builder.append(_responseDataInterfaceName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<Attribute> _response = it.getResponse();
      for(final Attribute attribute : _response) {
        _builder.append("\t");
        String _declaration = this._attributeExtension.declaration(attribute);
        _builder.append(_declaration, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("public ");
    String _responseDataName_1 = this._aceExtension.responseDataName(it);
    _builder.append(_responseDataName_1, "\t");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _responseDataName_2 = this._aceExtension.responseDataName(it);
    _builder.append(_responseDataName_2, "\t");
    _builder.append("(");
    String _interfaceWithPackage = this._modelExtension.interfaceWithPackage(it.getModel());
    _builder.append(_interfaceWithPackage, "\t");
    _builder.append(" data) {");
    _builder.newLineIfNotEmpty();
    {
      EList<Attribute> _response_1 = it.getResponse();
      for(final Attribute attribute_1 : _response_1) {
        _builder.append("\t\t");
        String _name_1 = attribute_1.getName();
        _builder.append(_name_1, "\t\t");
        _builder.append(" = data.");
        String _terCall = this._attributeExtension.getterCall(attribute_1);
        _builder.append(_terCall, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<Attribute> _response_2 = it.getResponse();
      for(final Attribute attribute_2 : _response_2) {
        _builder.append("\t");
        String _ter = this._attributeExtension.getter(attribute_2, true);
        _builder.append(_ter, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateReponseDataInterface(final HttpServerAce it, final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = httpServer.getName();
    _builder.append(_name);
    _builder.append(".data;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public interface ");
    String _responseDataInterfaceName = this._aceExtension.responseDataInterfaceName(it);
    _builder.append(_responseDataInterfaceName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    {
      EList<Attribute> _response = it.getResponse();
      for(final Attribute attribute : _response) {
        _builder.append("\t");
        String _interfaceGetter = this._attributeExtension.interfaceGetter(attribute);
        _builder.append(_interfaceGetter, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
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
  
  public CharSequence generatePayloadData(final HttpServerAce it, final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = httpServer.getName();
    _builder.append(_name);
    _builder.append(".data;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.annotation.JsonProperty;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.annotation.JsonIgnore;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.annotation.JsonSerialize;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.annotation.JsonDeserialize;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.time.LocalDateTime;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import de.acegen.IDataContainer;");
    _builder.newLine();
    _builder.append("import de.acegen.DateTimeToStringConverter;");
    _builder.newLine();
    _builder.append("import de.acegen.StringToDateTimeConverter;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"all\")");
    _builder.newLine();
    _builder.append("public class ");
    String _payloadDataName = this._aceExtension.payloadDataName(it);
    _builder.append(_payloadDataName);
    _builder.append(" implements ");
    String _payloadDataInterfaceName = this._aceExtension.payloadDataInterfaceName(it);
    _builder.append(_payloadDataInterfaceName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<AttributeParamRef> _payload = it.getPayload();
      for(final AttributeParamRef attributeRef : _payload) {
        _builder.append("\t");
        String _declaration = this._attributeExtension.declaration(attributeRef.getAttribute());
        _builder.append(_declaration, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("public ");
    String _payloadDataName_1 = this._aceExtension.payloadDataName(it);
    _builder.append(_payloadDataName_1, "\t");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _payloadDataName_2 = this._aceExtension.payloadDataName(it);
    _builder.append(_payloadDataName_2, "\t");
    _builder.append("(");
    String _interfaceWithPackage = this._modelExtension.interfaceWithPackage(it.getModel());
    _builder.append(_interfaceWithPackage, "\t");
    _builder.append(" data) {");
    _builder.newLineIfNotEmpty();
    {
      EList<AttributeParamRef> _payload_1 = it.getPayload();
      for(final AttributeParamRef attributeRef_1 : _payload_1) {
        _builder.append("\t\t");
        String _name_1 = attributeRef_1.getAttribute().getName();
        _builder.append(_name_1, "\t\t");
        _builder.append(" = data.");
        String _terCall = this._attributeExtension.getterCall(attributeRef_1.getAttribute());
        _builder.append(_terCall, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<AttributeParamRef> _payload_2 = it.getPayload();
      for(final AttributeParamRef attributeRef_2 : _payload_2) {
        _builder.append("\t");
        String _ter = this._attributeExtension.getter(attributeRef_2.getAttribute(), true);
        _builder.append(_ter, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generatePayloadDataInterface(final HttpServerAce it, final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = httpServer.getName();
    _builder.append(_name);
    _builder.append(".data;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public interface ");
    String _payloadDataInterfaceName = this._aceExtension.payloadDataInterfaceName(it);
    _builder.append(_payloadDataInterfaceName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    {
      EList<AttributeParamRef> _payload = it.getPayload();
      for(final AttributeParamRef attributeRef : _payload) {
        _builder.append("\t");
        String _interfaceGetter = this._attributeExtension.interfaceGetter(attributeRef.getAttribute());
        _builder.append(_interfaceGetter, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
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
  
  public CharSequence generateIDataContainer() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.time.LocalDateTime;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public interface IDataContainer {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String getUuid();");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("void setUuid(String uuid);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("boolean hasOutcome(String outcome);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("List<String> getOutcomes();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("void addOutcome(String outcome);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("LocalDateTime getSystemTime();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("void setSystemTime(LocalDateTime systemTime);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("void migrateLegacyData(String json);");
    _builder.newLine();
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
  
  public CharSequence generateAbstractData() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.time.LocalDateTime;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import java.util.ArrayList;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.annotation.JsonProperty;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.annotation.JsonDeserialize;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.annotation.JsonSerialize;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public abstract class AbstractData implements IDataContainer {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private String uuid;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private List<String> outcomes;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private LocalDateTime systemTime;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public AbstractData( String uuid ) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.uuid = uuid;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("outcomes = new ArrayList<String>();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String getUuid() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return this.uuid;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void setUuid(String uuid) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.uuid = uuid;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonSerialize(converter = DateTimeToStringConverter.class)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonDeserialize(converter = StringToDateTimeConverter.class)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public LocalDateTime getSystemTime() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return systemTime;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void setSystemTime(LocalDateTime systemTime) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.systemTime = systemTime;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public List<String> getOutcomes() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return this.outcomes;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public boolean hasOutcome(String outcome) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return outcomes.contains(outcome);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void addOutcome(String outcome) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.outcomes.add(outcome);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
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
}
