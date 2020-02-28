package de.acegen.templates.java;

import com.google.common.base.Objects;
import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.AttributeDefinition;
import de.acegen.aceGen.AttributeDefinitionList;
import de.acegen.aceGen.Authorization;
import de.acegen.aceGen.DataDefinition;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.ListAttributeDefinitionList;
import de.acegen.aceGen.Model;
import de.acegen.aceGen.Scenario;
import de.acegen.aceGen.WhenBlock;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.java.AceExtension;
import de.acegen.extensions.java.AttributeExtension;
import de.acegen.extensions.java.ModelExtension;
import java.util.List;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ScenarioTemplate {
  @Inject
  @Extension
  private ModelExtension _modelExtension;
  
  @Inject
  @Extension
  private AttributeExtension _attributeExtension;
  
  @Inject
  @Extension
  private AceExtension _aceExtension;
  
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  public CharSequence generateScenario(final Scenario it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = java.getName();
    _builder.append(_name);
    _builder.append(".scenarios;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import javax.ws.rs.core.Response;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"unused\")");
    _builder.newLine();
    _builder.append("public class ");
    String _name_1 = it.getName();
    _builder.append(_name_1);
    _builder.append("Scenario extends Abstract");
    String _name_2 = it.getName();
    _builder.append(_name_2);
    _builder.append("Scenario {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void verifications(Response response) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
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
  
  public CharSequence generateAbstractScenario(final Scenario it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = java.getName();
    _builder.append(_name);
    _builder.append(".scenarios;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.ArrayList;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import javax.ws.rs.core.Response;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.joda.time.DateTime;");
    _builder.newLine();
    _builder.append("import org.joda.time.format.DateTimeFormat;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.junit.Test;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.BaseScenario;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.ITimelineItem;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.NotReplayableDataProvider;");
    _builder.newLine();
    _builder.append("import ");
    String _name_1 = java.getName();
    _builder.append(_name_1);
    _builder.append(".ActionCalls;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"unused\")");
    _builder.newLine();
    _builder.append("public abstract class Abstract");
    String _name_2 = it.getName();
    _builder.append(_name_2);
    _builder.append("Scenario extends BaseScenario {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private void given() throws Exception {");
    _builder.newLine();
    {
      EList<Scenario> _scenarios = it.getScenarios();
      for(final Scenario scenario : _scenarios) {
        _builder.append("\t\t");
        CharSequence _generatePrepare = this.generatePrepare(scenario.getWhenBlock());
        _builder.append(_generatePrepare, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        CharSequence _generateActionCall = this.generateActionCall(scenario.getWhenBlock(), java);
        _builder.append(_generateActionCall, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private Response when() throws Exception {");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _generatePrepare_1 = this.generatePrepare(it.getWhenBlock());
    _builder.append(_generatePrepare_1, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("return ");
    CharSequence _generateActionCall_1 = this.generateActionCall(it.getWhenBlock(), java);
    _builder.append(_generateActionCall_1, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private void then(Response response) throws Exception {");
    _builder.newLine();
    {
      int _statusCode = it.getThenBlock().getStatusCode();
      boolean _tripleNotEquals = (_statusCode != 0);
      if (_tripleNotEquals) {
        _builder.append("\t\t");
        _builder.append("assertThat(response.getStatus(), ");
        int _statusCode_1 = it.getThenBlock().getStatusCode();
        _builder.append(_statusCode_1, "\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    {
      DataDefinition _response = it.getThenBlock().getResponse();
      boolean _tripleNotEquals_1 = (_response != null);
      if (_tripleNotEquals_1) {
        _builder.append("\t\t");
        CharSequence _generateDataCreation = this.generateDataCreation(it.getThenBlock().getResponse(), it.getWhenBlock().getAction().getModel(), "expectedData");
        _builder.append(_generateDataCreation, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        String _responseDataNameWithPackage = this._aceExtension.responseDataNameWithPackage(it.getWhenBlock().getAction(), java);
        _builder.append(_responseDataNameWithPackage, "\t\t");
        _builder.append(" expected = new ");
        String _responseDataNameWithPackage_1 = this._aceExtension.responseDataNameWithPackage(it.getWhenBlock().getAction(), java);
        _builder.append(_responseDataNameWithPackage_1, "\t\t");
        _builder.append("(expectedData);");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t\t");
        String _responseDataNameWithPackage_2 = this._aceExtension.responseDataNameWithPackage(it.getWhenBlock().getAction(), java);
        _builder.append(_responseDataNameWithPackage_2, "\t\t");
        _builder.append(" actual = response.readEntity(");
        String _responseDataNameWithPackage_3 = this._aceExtension.responseDataNameWithPackage(it.getWhenBlock().getAction(), java);
        _builder.append(_responseDataNameWithPackage_3, "\t\t");
        _builder.append(".class);");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("assertThat(actual, expected);");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Test");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void ");
    String _firstLower = StringExtensions.toFirstLower(it.getName());
    _builder.append(_firstLower, "\t");
    _builder.append("() throws Exception {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("given();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Response response = when();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("then(response);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("verifications(response);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract void verifications(Response response);");
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
  
  private CharSequence generatePrepare(final WhenBlock it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      String _systemtime = it.getDataDefinition().getSystemtime();
      boolean _tripleNotEquals = (_systemtime != null);
      if (_tripleNotEquals) {
        _builder.append("NotReplayableDataProvider.setSystemTime(");
        String _systemtime_1 = it.getDataDefinition().getSystemtime();
        _builder.append(_systemtime_1);
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      if ((((it.getDataDefinition() != null) && (it.getDataDefinition().getData() != null)) && (it.getDataDefinition().getData().getAttributeDefinitions() != null))) {
        {
          EList<AttributeDefinition> _attributeDefinitions = it.getDataDefinition().getData().getAttributeDefinitions();
          for(final AttributeDefinition attributeDefinition : _attributeDefinitions) {
            {
              boolean _isNotReplayable = attributeDefinition.getAttribute().isNotReplayable();
              if (_isNotReplayable) {
                _builder.append("NotReplayableDataProvider.put(\"");
                String _name = attributeDefinition.getAttribute().getName();
                _builder.append(_name);
                _builder.append("\", ");
                String _valueFrom = this._attributeExtension.valueFrom(attributeDefinition);
                _builder.append(_valueFrom);
                _builder.append(");");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    return _builder;
  }
  
  private CharSequence generateActionCall(final WhenBlock it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generateActionCalls = this.generateActionCalls(it.getAction(), it.getDataDefinition(), it.getAuthorization(), java);
    _builder.append(_generateActionCalls);
    return _builder;
  }
  
  public CharSequence generateDataCreation(final DataDefinition it, final Model model, final String varName) {
    StringConcatenation _builder = new StringConcatenation();
    String _dataNameWithPackage = this._modelExtension.dataNameWithPackage(model);
    _builder.append(_dataNameWithPackage);
    _builder.append(" ");
    _builder.append(varName);
    _builder.append(" = new ");
    String _dataNameWithPackage_1 = this._modelExtension.dataNameWithPackage(model);
    _builder.append(_dataNameWithPackage_1);
    _builder.append("(");
    {
      String _uuid = it.getUuid();
      boolean _tripleNotEquals = (_uuid != null);
      if (_tripleNotEquals) {
        _builder.append("\"");
        String _uuid_1 = it.getUuid();
        _builder.append(_uuid_1);
        _builder.append("\"");
      } else {
        _builder.append("randomUUID()");
      }
    }
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    {
      String _systemtime = it.getSystemtime();
      boolean _tripleNotEquals_1 = (_systemtime != null);
      if (_tripleNotEquals_1) {
        _builder.append(varName);
        _builder.append(".setSystemTime(DateTime.parse(\"");
        String _systemtime_1 = it.getSystemtime();
        _builder.append(_systemtime_1);
        _builder.append("\", DateTimeFormat.forPattern(\"dd.MM.yyyy HH:mm:ss\")));");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<AttributeDefinition> _attributeDefinitions = it.getData().getAttributeDefinitions();
      for(final AttributeDefinition attributeDefinition : _attributeDefinitions) {
        {
          AttributeDefinitionList _attributeDefinitionList = attributeDefinition.getValue().getAttributeDefinitionList();
          boolean _tripleNotEquals_2 = (_attributeDefinitionList != null);
          if (_tripleNotEquals_2) {
            String _firstUpper = StringExtensions.toFirstUpper(attributeDefinition.getAttribute().getName());
            String _plus = (varName + _firstUpper);
            CharSequence _generateModelCreation = this.generateModelCreation(attributeDefinition, _plus);
            _builder.append(_generateModelCreation);
            _builder.newLineIfNotEmpty();
            _builder.append(varName);
            _builder.append(".");
            Attribute _attribute = attributeDefinition.getAttribute();
            String _firstUpper_1 = StringExtensions.toFirstUpper(attributeDefinition.getAttribute().getName());
            String _plus_1 = (varName + _firstUpper_1);
            String _setterCall = this._attributeExtension.setterCall(_attribute, _plus_1);
            _builder.append(_setterCall);
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          } else {
            ListAttributeDefinitionList _listAttributeDefinitionList = attributeDefinition.getValue().getListAttributeDefinitionList();
            boolean _tripleNotEquals_3 = (_listAttributeDefinitionList != null);
            if (_tripleNotEquals_3) {
              String _firstUpper_2 = StringExtensions.toFirstUpper(attributeDefinition.getAttribute().getName());
              String _plus_2 = (varName + _firstUpper_2);
              CharSequence _generateModelListCreation = this.generateModelListCreation(attributeDefinition, _plus_2);
              _builder.append(_generateModelListCreation);
              _builder.newLineIfNotEmpty();
              _builder.append(varName);
              _builder.append(".");
              Attribute _attribute_1 = attributeDefinition.getAttribute();
              String _firstUpper_3 = StringExtensions.toFirstUpper(attributeDefinition.getAttribute().getName());
              String _plus_3 = (varName + _firstUpper_3);
              String _setterCall_1 = this._attributeExtension.setterCall(_attribute_1, _plus_3);
              _builder.append(_setterCall_1);
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            } else {
              _builder.append(varName);
              _builder.append(".");
              String _setterCall_2 = this._attributeExtension.setterCall(attributeDefinition.getAttribute(), this._attributeExtension.valueFrom(attributeDefinition));
              _builder.append(_setterCall_2);
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence generateModelCreation(final AttributeDefinition it, final String varName) {
    StringConcatenation _builder = new StringConcatenation();
    String _interfaceWithPackage = this._modelExtension.interfaceWithPackage(it.getAttribute().getModel());
    _builder.append(_interfaceWithPackage);
    _builder.append(" ");
    _builder.append(varName);
    _builder.append(" = new ");
    String _modelClassNameWithPackage = this._modelExtension.modelClassNameWithPackage(it.getAttribute().getModel());
    _builder.append(_modelClassNameWithPackage);
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    {
      EList<AttributeDefinition> _attributeDefinitions = it.getValue().getAttributeDefinitionList().getAttributeDefinitions();
      for(final AttributeDefinition attributeDefinition : _attributeDefinitions) {
        _builder.append(varName);
        _builder.append(".");
        String _setterCall = this._attributeExtension.setterCall(attributeDefinition.getAttribute(), this._attributeExtension.valueFrom(attributeDefinition));
        _builder.append(_setterCall);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence generateModelListCreation(final AttributeDefinition it, final String varName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("List<");
    String _interfaceWithPackage = this._modelExtension.interfaceWithPackage(it.getAttribute().getModel());
    _builder.append(_interfaceWithPackage);
    _builder.append("> ");
    _builder.append(varName);
    _builder.append(" = new ArrayList<");
    String _interfaceWithPackage_1 = this._modelExtension.interfaceWithPackage(it.getAttribute().getModel());
    _builder.append(_interfaceWithPackage_1);
    _builder.append(">();");
    _builder.newLineIfNotEmpty();
    {
      EList<AttributeDefinitionList> _attributeDefinitionList = it.getValue().getListAttributeDefinitionList().getAttributeDefinitionList();
      for(final AttributeDefinitionList attributeDefinitionList : _attributeDefinitionList) {
        String _interfaceWithPackage_2 = this._modelExtension.interfaceWithPackage(it.getAttribute().getModel());
        _builder.append(_interfaceWithPackage_2);
        _builder.append(" ");
        int _indexOf = it.getValue().getListAttributeDefinitionList().getAttributeDefinitionList().indexOf(attributeDefinitionList);
        String _plus = (varName + Integer.valueOf(_indexOf));
        _builder.append(_plus);
        _builder.append(" = new ");
        String _modelClassNameWithPackage = this._modelExtension.modelClassNameWithPackage(it.getAttribute().getModel());
        _builder.append(_modelClassNameWithPackage);
        _builder.append("();");
        _builder.newLineIfNotEmpty();
        {
          EList<AttributeDefinition> _attributeDefinitions = attributeDefinitionList.getAttributeDefinitions();
          for(final AttributeDefinition attributeDefinition : _attributeDefinitions) {
            _builder.append(varName);
            int _indexOf_1 = it.getValue().getListAttributeDefinitionList().getAttributeDefinitionList().indexOf(attributeDefinitionList);
            _builder.append(_indexOf_1);
            _builder.append(".");
            String _setterCall = this._attributeExtension.setterCall(attributeDefinition.getAttribute(), this._attributeExtension.valueFrom(attributeDefinition));
            _builder.append(_setterCall);
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append(varName);
        _builder.append(".add(");
        int _indexOf_2 = it.getValue().getListAttributeDefinitionList().getAttributeDefinitionList().indexOf(attributeDefinitionList);
        String _plus_1 = (varName + Integer.valueOf(_indexOf_2));
        _builder.append(_plus_1);
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence generateActionCalls(final HttpServerAce aceOperation, final DataDefinition dataDefinition, final Authorization authorization, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    {
      String _type = aceOperation.getType();
      boolean _equals = Objects.equal(_type, "POST");
      if (_equals) {
        _builder.append("ActionCalls.call");
        String _firstUpper = StringExtensions.toFirstUpper(aceOperation.getName());
        _builder.append(_firstUpper);
        _builder.append("(");
        {
          List<String> _mergeAttributesForPostCall = this._attributeExtension.mergeAttributesForPostCall(aceOperation, dataDefinition);
          boolean _hasElements = false;
          for(final String param : _mergeAttributesForPostCall) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(", ", "");
            }
            CharSequence _paramString = this.paramString(param);
            _builder.append(_paramString);
          }
        }
        {
          boolean _isAuthorize = aceOperation.isAuthorize();
          if (_isAuthorize) {
            _builder.append(", authorization(\"");
            String _username = authorization.getUsername();
            _builder.append(_username);
            _builder.append("\", \"");
            String _password = authorization.getPassword();
            _builder.append(_password);
            _builder.append("\")");
          }
        }
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      } else {
        String _type_1 = aceOperation.getType();
        boolean _equals_1 = Objects.equal(_type_1, "PUT");
        if (_equals_1) {
          _builder.append("ActionCalls.call");
          String _firstUpper_1 = StringExtensions.toFirstUpper(aceOperation.getName());
          _builder.append(_firstUpper_1);
          _builder.append("(");
          {
            List<String> _mergeAttributesForPutCall = this._attributeExtension.mergeAttributesForPutCall(aceOperation, dataDefinition);
            boolean _hasElements_1 = false;
            for(final String param_1 : _mergeAttributesForPutCall) {
              if (!_hasElements_1) {
                _hasElements_1 = true;
              } else {
                _builder.appendImmediate(", ", "");
              }
              CharSequence _paramString_1 = this.paramString(param_1);
              _builder.append(_paramString_1);
            }
          }
          {
            boolean _isAuthorize_1 = aceOperation.isAuthorize();
            if (_isAuthorize_1) {
              _builder.append(", authorization(\"");
              String _username_1 = authorization.getUsername();
              _builder.append(_username_1);
              _builder.append("\", \"");
              String _password_1 = authorization.getPassword();
              _builder.append(_password_1);
              _builder.append("\")");
            }
          }
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        } else {
          String _type_2 = aceOperation.getType();
          boolean _equals_2 = Objects.equal(_type_2, "DELETE");
          if (_equals_2) {
            _builder.append("ActionCalls.call");
            String _firstUpper_2 = StringExtensions.toFirstUpper(aceOperation.getName());
            _builder.append(_firstUpper_2);
            _builder.append("(");
            {
              List<String> _mergeAttributesForDeleteCall = this._attributeExtension.mergeAttributesForDeleteCall(aceOperation, dataDefinition);
              boolean _hasElements_2 = false;
              for(final String param_2 : _mergeAttributesForDeleteCall) {
                if (!_hasElements_2) {
                  _hasElements_2 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _paramString_2 = this.paramString(param_2);
                _builder.append(_paramString_2);
              }
            }
            {
              boolean _isAuthorize_2 = aceOperation.isAuthorize();
              if (_isAuthorize_2) {
                _builder.append(", authorization(\"");
                String _username_2 = authorization.getUsername();
                _builder.append(_username_2);
                _builder.append("\", \"");
                String _password_2 = authorization.getPassword();
                _builder.append(_password_2);
                _builder.append("\")");
              }
            }
            _builder.append(");");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("ActionCalls.call");
            String _firstUpper_3 = StringExtensions.toFirstUpper(aceOperation.getName());
            _builder.append(_firstUpper_3);
            _builder.append("(");
            {
              List<String> _mergeAttributesForGetCall = this._attributeExtension.mergeAttributesForGetCall(aceOperation, dataDefinition);
              boolean _hasElements_3 = false;
              for(final String param_3 : _mergeAttributesForGetCall) {
                if (!_hasElements_3) {
                  _hasElements_3 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _paramString_3 = this.paramString(param_3);
                _builder.append(_paramString_3);
              }
            }
            {
              boolean _isAuthorize_3 = aceOperation.isAuthorize();
              if (_isAuthorize_3) {
                _builder.append(", authorization(\"");
                String _username_3 = authorization.getUsername();
                _builder.append(_username_3);
                _builder.append("\", \"");
                String _password_3 = authorization.getPassword();
                _builder.append(_password_3);
                _builder.append("\")");
              }
            }
            _builder.append(");");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  private CharSequence paramString(final String param) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (((param != null) && (param.length() > 0))) {
        _builder.append(param);
      } else {
        _builder.append("null");
      }
    }
    return _builder;
  }
  
  public CharSequence generateBaseScenario() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package com.anfelisa.ace;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.Jdbi;");
    _builder.newLine();
    _builder.append("import org.junit.After;");
    _builder.newLine();
    _builder.append("import org.junit.AfterClass;");
    _builder.newLine();
    _builder.append("import org.junit.Before;");
    _builder.newLine();
    _builder.append("import org.junit.BeforeClass;");
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.AbstractBaseScenario;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.App;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.CustomAppConfiguration;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.DaoProvider;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import io.dropwizard.jdbi3.JdbiFactory;");
    _builder.newLine();
    _builder.append("import io.dropwizard.testing.DropwizardTestSupport;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class BaseScenario extends AbstractBaseScenario {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(BaseScenario.class);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static final DropwizardTestSupport<CustomAppConfiguration> DROPWIZARD = new DropwizardTestSupport<CustomAppConfiguration>(");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("App.class, \"test.yml\");");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static Jdbi jdbi;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@BeforeClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void beforeClass() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("DROPWIZARD.before();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("final JdbiFactory factory = new JdbiFactory();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("jdbi = factory.build(DROPWIZARD.getEnvironment(), DROPWIZARD.getConfiguration().getDataSourceFactory(), \"testdb\");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@AfterClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void afterClass() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("DROPWIZARD.after();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} catch (Exception x) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("LOG.error(\"exception when cleaning up dropwizard\", x);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Before");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void before() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("daoProvider = new DaoProvider();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("handle = jdbi.open();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@After");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void after() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("handle.close();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected String authorization(String username, String password) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return \"\";");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void assertThat(int actual, int expected) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throw new RuntimeException(\"BaseScenario.assertThat not implemented\");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void assertThat(Object actual, Object expected) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throw new RuntimeException(\"BaseScenario.assertThat not implemented\");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract void assertIsNull(Object actual) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throw new RuntimeException(\"BaseScenario.assertIsNull not implemented\");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateAbstractBaseScenario() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package com.anfelisa.ace;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.util.UUID;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.Handle;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public abstract class AbstractBaseScenario {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected final JodaObjectMapper mapper = new JodaObjectMapper();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected DaoProvider daoProvider;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected Handle handle;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static String randomUUID() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return UUID.randomUUID().toString();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract String authorization(String username, String password);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract void assertThat(int actual, int expected);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract void assertThat(Object actual, Object expected);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract void assertIsNull(Object actual);");
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
}
