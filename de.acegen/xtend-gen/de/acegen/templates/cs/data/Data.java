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
package de.acegen.templates.cs.data;

import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.AttributeParamRef;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.Model;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.cs.AttributeExtension;
import de.acegen.extensions.cs.CsHttpServerExtension;
import de.acegen.extensions.cs.ModelExtension;
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
  private CsHttpServerExtension _csHttpServerExtension;
  
  public CharSequence generateDataInterface(final Model it, final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("namespace ");
    String _namespace = this._csHttpServerExtension.namespace(httpServer);
    _builder.append(_namespace);
    _builder.append(".Data;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    String _importModel = this._modelExtension.importModel(it);
    _builder.append(_importModel);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public interface ");
    String _dataInterfaceName = this._modelExtension.dataInterfaceName(it);
    _builder.append(_dataInterfaceName);
    _builder.append(" : ");
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
    _builder.append("namespace ");
    String _namespace = this._csHttpServerExtension.namespace(httpServer);
    _builder.append(_namespace);
    _builder.append(".Data;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public abstract class ");
    String _abstractDataName = this._modelExtension.abstractDataName(it);
    _builder.append(_abstractDataName);
    _builder.append(" : AbstractData, ");
    String _dataInterfaceName = this._modelExtension.dataInterfaceName(it);
    _builder.append(_dataInterfaceName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      List<Attribute> _allAttributes = this._modelExtension.allAttributes(it);
      for(final Attribute attribute : _allAttributes) {
        _builder.append("\t");
        _builder.append("public ");
        String _set = this._attributeExtension.getSet(attribute);
        _builder.append(_set, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _abstractDataName_1 = this._modelExtension.abstractDataName(it);
    _builder.append(_abstractDataName_1, "\t");
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
        String _param = this._attributeExtension.param(attribute_1);
        _builder.append(_param, "\t\t");
        _builder.newLineIfNotEmpty();
      }
      if (_hasElements) {
        _builder.append(",", "\t\t");
      }
    }
    _builder.append("\t\t");
    _builder.append("string uuid");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(") : base(uuid) {");
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
        String _abstractDataName_2 = this._modelExtension.abstractDataName(it);
        _builder.append(_abstractDataName_2, "\t");
        _builder.append("( string uuid ) : base(uuid) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
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
          List<Attribute> _allAttributes_3 = this._modelExtension.allAttributes(superModel_1);
          for(final Attribute attribute_3 : _allAttributes_3) {
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("this.");
            String _name = attribute_3.getName();
            _builder.append(_name, "\t\t");
            _builder.append(" = model.");
            String _terCall = this._attributeExtension.getterCall(attribute_3);
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
    _builder.append("namespace ");
    String _namespace = this._csHttpServerExtension.namespace(httpServer);
    _builder.append(_namespace);
    _builder.append(".Data;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _dataName = this._modelExtension.dataName(it);
    _builder.append(_dataName);
    _builder.append(" : ");
    String _abstractDataName = this._modelExtension.abstractDataName(it);
    _builder.append(_abstractDataName);
    _builder.append(", ");
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
        String _param = this._attributeExtension.param(attribute);
        _builder.append(_param, "\t\t");
        _builder.append(", ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("string uuid");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(") : base(");
    {
      List<Attribute> _allAttributes_1 = this._modelExtension.allAttributes(it);
      for(final Attribute attribute_1 : _allAttributes_1) {
        String _name = attribute_1.getName();
        _builder.append(_name, "\t");
        _builder.append(", ");
      }
    }
    _builder.append("uuid) {");
    _builder.newLineIfNotEmpty();
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
        _builder.append("( string uuid ) : base(uuid) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("override public void MigrateLegacyData(String json) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static ");
    String _dataInterfaceName_1 = this._modelExtension.dataInterfaceName(it);
    _builder.append(_dataInterfaceName_1, "\t");
    _builder.append(" GenerateTestData() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("Random random = new Random();");
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
    String _dataInterfaceName_2 = this._modelExtension.dataInterfaceName(it);
    _builder.append(_dataInterfaceName_2, "\t\t");
    _builder.append(" testData = (");
    String _dataInterfaceName_3 = this._modelExtension.dataInterfaceName(it);
    _builder.append(_dataInterfaceName_3, "\t\t");
    _builder.append(") new ");
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
                _builder.append("List<");
                String _interfaceWithPackage = this._modelExtension.interfaceWithPackage(attribute_2.getModel());
                _builder.append(_interfaceWithPackage, "\t\t");
                _builder.append("> ");
                String _firstLower = StringExtensions.toFirstLower(attribute_2.getName());
                _builder.append(_firstLower, "\t\t");
                _builder.append("List = new List<");
                String _dataInterfaceName_4 = this._modelExtension.dataInterfaceName(attribute_2.getModel());
                _builder.append(_dataInterfaceName_4, "\t\t");
                _builder.append(">();");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("n = random.Next(20) + 1;");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("for ( int i = 0; i < n; i++ ) {");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t");
                String _firstLower_1 = StringExtensions.toFirstLower(attribute_2.getName());
                _builder.append(_firstLower_1, "\t\t\t");
                _builder.append("List.Add(");
                String _dataNameWithPackage = this._modelExtension.dataNameWithPackage(attribute_2.getModel());
                _builder.append(_dataNameWithPackage, "\t\t\t");
                _builder.append(".GenerateTestData());");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("testData.");
                String _firstUpper = StringExtensions.toFirstUpper(attribute_2.getName());
                _builder.append(_firstUpper, "\t\t");
                _builder.append(" = ");
                String _firstLower_2 = StringExtensions.toFirstLower(attribute_2.getName());
                _builder.append(_firstLower_2, "\t\t");
                _builder.append("List;");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t\t");
                _builder.append("testData.");
                String _firstUpper_1 = StringExtensions.toFirstUpper(attribute_2.getName());
                _builder.append(_firstUpper_1, "\t\t");
                _builder.append(" = ");
                String _dataNameWithPackage_1 = this._modelExtension.dataNameWithPackage(attribute_2.getModel());
                _builder.append(_dataNameWithPackage_1, "\t\t");
                _builder.append(".GenerateTestData();");
                _builder.newLineIfNotEmpty();
              }
            }
          } else {
            {
              boolean _isList_1 = attribute_2.isList();
              if (_isList_1) {
                _builder.append("\t\t");
                String _csType = this._attributeExtension.csType(attribute_2);
                _builder.append(_csType, "\t\t");
                _builder.append(" ");
                String _firstLower_3 = StringExtensions.toFirstLower(attribute_2.getName());
                _builder.append(_firstLower_3, "\t\t");
                _builder.append("List = new ");
                String _csTypeNew = this._attributeExtension.csTypeNew(attribute_2);
                _builder.append(_csTypeNew, "\t\t");
                _builder.append("();");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("n = random.Next(20) + 1;");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("for ( int i = 0; i < n; i++ ) {");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t");
                String _firstLower_4 = StringExtensions.toFirstLower(attribute_2.getName());
                _builder.append(_firstLower_4, "\t\t\t");
                _builder.append("List.Add(");
                String _randomValue = this._attributeExtension.randomValue(attribute_2);
                _builder.append(_randomValue, "\t\t\t");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("testData.");
                String _firstUpper_2 = StringExtensions.toFirstUpper(attribute_2.getName());
                _builder.append(_firstUpper_2, "\t\t");
                _builder.append(" = ");
                String _firstLower_5 = StringExtensions.toFirstLower(attribute_2.getName());
                _builder.append(_firstLower_5, "\t\t");
                _builder.append("List;");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t\t");
                _builder.append("testData.");
                String _firstUpper_3 = StringExtensions.toFirstUpper(attribute_2.getName());
                _builder.append(_firstUpper_3, "\t\t");
                _builder.append(" = ");
                String _randomValue_1 = this._attributeExtension.randomValue(attribute_2);
                _builder.append(_randomValue_1, "\t\t");
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
    _builder.append("private static String RandomString(Random random) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String chars = \"aaaaaaabcdeeeeeeeffffghiiiiiiijkllllllmmmmnnnnnnnooooooooopqrstttuuuuuuuvxyz\";");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("int length = random.Next(20) + 5;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return new string(Enumerable.Repeat(chars, length).Select(s => s[random.Next(s.Length)]).ToArray());");
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
    _builder.append("namespace ");
    String _namespace = this._csHttpServerExtension.namespace(httpServer);
    _builder.append(_namespace);
    _builder.append(".Data;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _responseDataName = this._csHttpServerExtension.responseDataName(it);
    _builder.append(_responseDataName);
    _builder.append(" : ");
    String _responseDataInterfaceName = this._csHttpServerExtension.responseDataInterfaceName(it);
    _builder.append(_responseDataInterfaceName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<Attribute> _response = it.getResponse();
      for(final Attribute attribute : _response) {
        _builder.append("\t");
        _builder.append("public ");
        String _get = this._attributeExtension.get(attribute);
        _builder.append(_get, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _responseDataName_1 = this._csHttpServerExtension.responseDataName(it);
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
    String _responseDataName_2 = this._csHttpServerExtension.responseDataName(it);
    _builder.append(_responseDataName_2, "\t");
    _builder.append("(");
    String _modelName = this._modelExtension.modelName(it.getModel());
    _builder.append(_modelName, "\t");
    _builder.append(" data) {");
    _builder.newLineIfNotEmpty();
    {
      EList<Attribute> _response_1 = it.getResponse();
      for(final Attribute attribute_1 : _response_1) {
        _builder.append("\t\t");
        String _firstUpper = StringExtensions.toFirstUpper(attribute_1.getName());
        _builder.append(_firstUpper, "\t\t");
        _builder.append(" = data.");
        String _firstUpper_1 = StringExtensions.toFirstUpper(attribute_1.getName());
        _builder.append(_firstUpper_1, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
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
  
  public CharSequence generateReponseDataInterface(final HttpServerAce it, final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("namespace ");
    String _namespace = this._csHttpServerExtension.namespace(httpServer);
    _builder.append(_namespace);
    _builder.append(".Data;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public interface ");
    String _responseDataInterfaceName = this._csHttpServerExtension.responseDataInterfaceName(it);
    _builder.append(_responseDataInterfaceName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    {
      EList<Attribute> _response = it.getResponse();
      for(final Attribute attribute : _response) {
        _builder.append("\t");
        String _get = this._attributeExtension.get(attribute);
        _builder.append(_get, "\t");
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
    _builder.append("namespace ");
    String _namespace = this._csHttpServerExtension.namespace(httpServer);
    _builder.append(_namespace);
    _builder.append(".Data;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _payloadDataName = this._csHttpServerExtension.payloadDataName(it);
    _builder.append(_payloadDataName);
    _builder.append(" : ");
    String _payloadDataInterfaceName = this._csHttpServerExtension.payloadDataInterfaceName(it);
    _builder.append(_payloadDataInterfaceName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<AttributeParamRef> _payload = it.getPayload();
      for(final AttributeParamRef attributeRef : _payload) {
        _builder.append("\t");
        _builder.append("public ");
        String _get = this._attributeExtension.get(attributeRef.getAttribute());
        _builder.append(_get, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _payloadDataName_1 = this._csHttpServerExtension.payloadDataName(it);
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
    String _payloadDataName_2 = this._csHttpServerExtension.payloadDataName(it);
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
        String _firstUpper = StringExtensions.toFirstUpper(attributeRef_1.getAttribute().getName());
        _builder.append(_firstUpper, "\t\t");
        _builder.append(" = data.");
        String _firstUpper_1 = StringExtensions.toFirstUpper(attributeRef_1.getAttribute().getName());
        _builder.append(_firstUpper_1, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
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
  
  public CharSequence generatePayloadDataInterface(final HttpServerAce it, final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("namespace ");
    String _namespace = this._csHttpServerExtension.namespace(httpServer);
    _builder.append(_namespace);
    _builder.append(".Data;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public interface ");
    String _payloadDataInterfaceName = this._csHttpServerExtension.payloadDataInterfaceName(it);
    _builder.append(_payloadDataInterfaceName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    {
      EList<AttributeParamRef> _payload = it.getPayload();
      for(final AttributeParamRef attributeRef : _payload) {
        _builder.append("\t");
        String _get = this._attributeExtension.get(attributeRef.getAttribute());
        _builder.append(_get, "\t");
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
    _builder.append("namespace AceGen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public interface IDataContainer");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("string Uuid { get; }");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("bool HasOutcome(string outcome);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("List<string> Outcomes { get; }");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("void AddOutcome(string outcome);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("DateTime SystemTime {get; set;}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("void MigrateLegacyData(string json);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("}\t\t");
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
    _builder.append("namespace AceGen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public abstract class AbstractData : IDataContainer {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public string Uuid { get; }");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public DateTime SystemTime {get; set;}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public List<string> Outcomes { get; }");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public AbstractData( string uuid ) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.Uuid = uuid;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Outcomes = new List<string>();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public bool HasOutcome(string outcome) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return Outcomes.Contains(outcome);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void AddOutcome(string outcome) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Outcomes.Add(outcome);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public abstract void MigrateLegacyData(string json);");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}\t\t");
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
}
