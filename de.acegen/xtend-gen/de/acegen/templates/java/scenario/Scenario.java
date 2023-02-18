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
package de.acegen.templates.java.scenario;

import com.google.common.base.Objects;
import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.AttributeAndValue;
import de.acegen.aceGen.AttributeParamRef;
import de.acegen.aceGen.BooleanType;
import de.acegen.aceGen.Count;
import de.acegen.aceGen.CustomCall;
import de.acegen.aceGen.DataDefinition;
import de.acegen.aceGen.Extraction;
import de.acegen.aceGen.Given;
import de.acegen.aceGen.GivenRef;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.JsonArray;
import de.acegen.aceGen.JsonDateTime;
import de.acegen.aceGen.JsonMember;
import de.acegen.aceGen.JsonObject;
import de.acegen.aceGen.JsonObjectAce;
import de.acegen.aceGen.JsonValue;
import de.acegen.aceGen.LongType;
import de.acegen.aceGen.Model;
import de.acegen.aceGen.NullType;
import de.acegen.aceGen.PersistenceVerification;
import de.acegen.aceGen.PersistenceVerificationExpression;
import de.acegen.aceGen.PrimitiveValue;
import de.acegen.aceGen.SelectByPrimaryKeys;
import de.acegen.aceGen.SelectByUniqueAttribute;
import de.acegen.aceGen.StringType;
import de.acegen.aceGen.Verification;
import de.acegen.aceGen.WhenBlock;
import de.acegen.aceGen.WhenThen;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.java.AttributeExtension;
import de.acegen.extensions.java.TypeExtension;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class Scenario {
  @Inject
  @Extension
  private TypeExtension _typeExtension;

  @Inject
  @Extension
  private AttributeExtension _attributeExtension;

  @Inject
  @Extension
  private CommonExtension _commonExtension;

  private int index;

  private void resetIndex() {
    this.index = 0;
  }

  private void incIndex() {
    int _index = this.index;
    this.index = (_index + 1);
  }

  private String stringLineBreak = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(",\" + ");
      _builder.newLine();
      _builder.append("\"");
      return _builder.toString();
    }
  }.apply();

  public CharSequence generateScenario(final de.acegen.aceGen.Scenario it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    this.resetIndex();
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = java.getName();
    _builder.append(_name);
    _builder.append(".scenarios;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      EList<WhenThen> _whenThen = it.getWhenThen();
      for(final WhenThen whenThenItem : _whenThen) {
        _builder.append("import ");
        String _responseDataNameWithPackage = this._typeExtension.responseDataNameWithPackage(whenThenItem.getWhenBlock().getAction());
        _builder.append(_responseDataNameWithPackage);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("//@SuppressWarnings(\"unused\")");
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
    {
      EList<WhenThen> _whenThen_1 = it.getWhenThen();
      for(final WhenThen whenThenItem_1 : _whenThen_1) {
        {
          EList<Verification> _verifications = whenThenItem_1.getThenBlock().getVerifications();
          for(final Verification verification : _verifications) {
            _builder.append("\t");
            _builder.append("@Override");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("protected void ");
            String _name_3 = verification.getName();
            _builder.append(_name_3, "\t");
            _builder.append("(");
            {
              int _size = whenThenItem_1.getWhenBlock().getAction().getResponse().size();
              boolean _greaterThan = (_size > 0);
              if (_greaterThan) {
                String _responseDataNameWithPackage_1 = this._typeExtension.responseDataNameWithPackage(whenThenItem_1.getWhenBlock().getAction());
                _builder.append(_responseDataNameWithPackage_1, "\t");
                _builder.append(" response");
              }
            }
            _builder.append(") {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("assertFail(\"");
            String _name_4 = verification.getName();
            _builder.append(_name_4, "\t\t");
            _builder.append(" not implemented\");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("LOG.info(\"THEN: ");
            String _name_5 = verification.getName();
            _builder.append(_name_5, "\t\t");
            _builder.append(" passed\");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("\t");
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

  public CharSequence generateAbstractScenario(final de.acegen.aceGen.Scenario it, final HttpServer java) {
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
    _builder.append("import java.util.Map;");
    _builder.newLine();
    _builder.append("import java.util.HashMap;");
    _builder.newLine();
    _builder.append("import java.net.URLEncoder;");
    _builder.newLine();
    _builder.append("import java.nio.charset.StandardCharsets;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.time.LocalDateTime;");
    _builder.newLine();
    _builder.append("import java.time.format.DateTimeFormatter;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import de.acegen.BaseScenario;");
    _builder.newLine();
    _builder.append("import de.acegen.HttpResponse;");
    _builder.newLine();
    _builder.append("import de.acegen.Data;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.core.type.TypeReference;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"unused\")");
    _builder.newLine();
    _builder.append("public abstract class Abstract");
    String _name_1 = it.getName();
    _builder.append(_name_1);
    _builder.append("Scenario extends BaseScenario {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(Abstract");
    String _name_2 = it.getName();
    _builder.append(_name_2, "\t");
    _builder.append("Scenario.class);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private void given() throws Exception {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String uuid;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    this.resetIndex();
    _builder.newLineIfNotEmpty();
    {
      ArrayList<Given> _allGivenItems = this.allGivenItems(it);
      for(final Given given : _allGivenItems) {
        _builder.append("\t\t");
        CharSequence _givenItem = this.givenItem(given, java);
        _builder.append(_givenItem, "\t\t");
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
    int index = 0;
    _builder.newLineIfNotEmpty();
    {
      EList<WhenThen> _whenThen = it.getWhenThen();
      for(final WhenThen whenThenItem : _whenThen) {
        _builder.append("\t");
        int _plusPlus = index++;
        CharSequence _whenThenBlock = this.whenThenBlock(whenThenItem, _plusPlus, java);
        _builder.append(_whenThenBlock, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void runTest() throws Exception {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("given();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (prerequisite(\"");
    String _name_3 = it.getName();
    _builder.append(_name_3, "\t\t");
    _builder.append("\")) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    int testIndex = 0;
    _builder.newLineIfNotEmpty();
    {
      EList<WhenThen> _whenThen_1 = it.getWhenThen();
      for(final WhenThen whenThenItem_1 : _whenThen_1) {
        _builder.append("\t\t\t");
        int _plusPlus_1 = testIndex++;
        CharSequence _whenThenTestBlock = this.whenThenTestBlock(whenThenItem_1, it, java, _plusPlus_1);
        _builder.append(_whenThenTestBlock, "\t\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("LOG.info(\"WHEN: prerequisite for ");
    String _name_4 = it.getName();
    _builder.append(_name_4, "\t\t\t");
    _builder.append(" not met\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<WhenThen> _whenThen_2 = it.getWhenThen();
      for(final WhenThen whenThenItem_2 : _whenThen_2) {
        {
          EList<Verification> _verifications = whenThenItem_2.getThenBlock().getVerifications();
          for(final Verification verification : _verifications) {
            _builder.append("\t");
            _builder.append("protected abstract void ");
            String _name_5 = verification.getName();
            _builder.append(_name_5, "\t");
            _builder.append("(");
            {
              int _size = whenThenItem_2.getWhenBlock().getAction().getResponse().size();
              boolean _greaterThan = (_size > 0);
              if (_greaterThan) {
                String _responseDataNameWithPackage = this._typeExtension.responseDataNameWithPackage(whenThenItem_2.getWhenBlock().getAction());
                _builder.append(_responseDataNameWithPackage, "\t");
                _builder.append(" response");
              }
            }
            _builder.append(");");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.newLine();
        {
          EList<PersistenceVerification> _persistenceVerifications = whenThenItem_2.getThenBlock().getPersistenceVerifications();
          for(final PersistenceVerification persistenceVerification : _persistenceVerifications) {
            _builder.append("\t");
            _builder.append("private void ");
            String _name_6 = persistenceVerification.getName();
            _builder.append(_name_6, "\t");
            _builder.append("() throws Exception {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            CharSequence _persistenceVerification = this.persistenceVerification(persistenceVerification.getExpression(), persistenceVerification.getModel());
            _builder.append(_persistenceVerification, "\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("LOG.info(\"THEN: ");
            String _name_7 = persistenceVerification.getName();
            _builder.append(_name_7, "\t\t");
            _builder.append(" passed\");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected String scenarioName() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return \"");
    String _name_8 = it.getName();
    _builder.append(_name_8, "\t\t");
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
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

  private CharSequence whenThenTestBlock(final WhenThen it, final de.acegen.aceGen.Scenario scenario, final HttpServer java, final int index) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("HttpResponse<");
    {
      int _size = it.getWhenBlock().getAction().getResponse().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        String _responseDataNameWithPackage = this._typeExtension.responseDataNameWithPackage(it.getWhenBlock().getAction());
        _builder.append(_responseDataNameWithPackage, "\t");
      } else {
        _builder.append("Object");
      }
    }
    _builder.append("> response_");
    _builder.append(index, "\t");
    _builder.append(" = when_");
    _builder.append(index, "\t");
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    {
      int _size_1 = it.getWhenBlock().getAction().getResponse().size();
      boolean _greaterThan_1 = (_size_1 > 0);
      if (_greaterThan_1) {
        String _responseDataNameWithPackage_1 = this._typeExtension.responseDataNameWithPackage(it.getWhenBlock().getAction());
        _builder.append(_responseDataNameWithPackage_1, "\t");
        _builder.append(" actualResponse_");
        _builder.append(index, "\t");
        _builder.append(" = ");
      }
    }
    _builder.append("then_");
    _builder.append(index, "\t");
    _builder.append("(response_");
    _builder.append(index, "\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    {
      EList<PersistenceVerification> _persistenceVerifications = it.getThenBlock().getPersistenceVerifications();
      for(final PersistenceVerification persistenceVerification : _persistenceVerifications) {
        _builder.append("\t");
        _builder.append("this.");
        String _name = persistenceVerification.getName();
        _builder.append(_name, "\t");
        _builder.append("();");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Verification> _verifications = it.getThenBlock().getVerifications();
      for(final Verification verification : _verifications) {
        _builder.append("\t");
        String _name_1 = verification.getName();
        _builder.append(_name_1, "\t");
        _builder.append("(");
        {
          int _size_2 = it.getWhenBlock().getAction().getResponse().size();
          boolean _greaterThan_2 = (_size_2 > 0);
          if (_greaterThan_2) {
            _builder.append("actualResponse_");
            _builder.append(index, "\t");
          }
        }
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    return _builder;
  }

  private CharSequence whenThenBlock(final WhenThen it, final int index, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private HttpResponse<");
    {
      int _size = it.getWhenBlock().getAction().getResponse().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        String _responseDataNameWithPackage = this._typeExtension.responseDataNameWithPackage(it.getWhenBlock().getAction());
        _builder.append(_responseDataNameWithPackage);
      } else {
        _builder.append("Object");
      }
    }
    _builder.append("> when_");
    _builder.append(index);
    _builder.append("() throws Exception {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    this.resetIndex();
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("String uuid = ");
    {
      String _uuid = it.getWhenBlock().getDataDefinition().getUuid();
      boolean _tripleNotEquals = (_uuid != null);
      if (_tripleNotEquals) {
        _builder.append("\"");
        CharSequence _valueFromString = this.valueFromString(it.getWhenBlock().getDataDefinition().getUuid());
        _builder.append(_valueFromString, "\t");
        _builder.append("\"");
      } else {
        _builder.append("this.randomUUID()");
      }
    }
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _generatePrepare = this.generatePrepare(it.getWhenBlock());
    _builder.append(_generatePrepare, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _generateDataCreation = this.generateDataCreation(it.getWhenBlock());
    _builder.append(_generateDataCreation, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("HttpResponse<");
    {
      int _size_1 = it.getWhenBlock().getAction().getResponse().size();
      boolean _greaterThan_1 = (_size_1 > 0);
      if (_greaterThan_1) {
        String _responseDataNameWithPackage_1 = this._typeExtension.responseDataNameWithPackage(it.getWhenBlock().getAction());
        _builder.append(_responseDataNameWithPackage_1, "\t");
      } else {
        _builder.append("Object");
      }
    }
    _builder.append("> response = ");
    CharSequence _generateActionCalls = this.generateActionCalls(it.getWhenBlock(), java);
    _builder.append(_generateActionCalls, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("LOG.info(\"WHEN: ");
    String _name = it.getWhenBlock().getAction().getName();
    _builder.append(_name, "\t");
    _builder.append(" finished in {} ms\", response.getDuration());");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("addToMetrics(\"");
    String _name_1 = it.getWhenBlock().getAction().getName();
    _builder.append(_name_1, "\t\t");
    _builder.append("\", response.getDuration());");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return response;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("private ");
    {
      int _size_2 = it.getWhenBlock().getAction().getResponse().size();
      boolean _greaterThan_2 = (_size_2 > 0);
      if (_greaterThan_2) {
        String _responseDataNameWithPackage_2 = this._typeExtension.responseDataNameWithPackage(it.getWhenBlock().getAction());
        _builder.append(_responseDataNameWithPackage_2);
      } else {
        _builder.append("void");
      }
    }
    _builder.append(" then_");
    _builder.append(index);
    _builder.append("(HttpResponse<");
    {
      int _size_3 = it.getWhenBlock().getAction().getResponse().size();
      boolean _greaterThan_3 = (_size_3 > 0);
      if (_greaterThan_3) {
        String _responseDataNameWithPackage_3 = this._typeExtension.responseDataNameWithPackage(it.getWhenBlock().getAction());
        _builder.append(_responseDataNameWithPackage_3);
      } else {
        _builder.append("Object");
      }
    }
    _builder.append("> response) throws Exception {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("if (response.getStatusCode() == 500) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String statusMessage = response.getStatusMessage() != null ? response.getStatusMessage() : \"\";");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String errorMessage = \"status \" + response.getStatusCode() + \" failed: \" + statusMessage;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("LOG.error(\"THEN: \" + errorMessage);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("assertFail(errorMessage);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    {
      int _statusCode = it.getThenBlock().getStatusCode();
      boolean _tripleNotEquals_1 = (_statusCode != 0);
      if (_tripleNotEquals_1) {
        _builder.append("\t");
        _builder.append("if (response.getStatusCode() != ");
        int _statusCode_1 = it.getThenBlock().getStatusCode();
        _builder.append(_statusCode_1, "\t");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("String statusMessage = response.getStatusMessage() != null ? response.getStatusMessage() : \"\";");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("String errorMessage = \"status \" + response.getStatusCode() + \" failed, expected ");
        int _statusCode_2 = it.getThenBlock().getStatusCode();
        _builder.append(_statusCode_2, "\t\t");
        _builder.append(": \" + statusMessage;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("LOG.error(\"THEN: \" + errorMessage);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("assertFail(errorMessage);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("} else {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("LOG.info(\"THEN: status ");
        int _statusCode_3 = it.getThenBlock().getStatusCode();
        _builder.append(_statusCode_3, "\t\t");
        _builder.append(" passed\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      int _size_4 = it.getWhenBlock().getAction().getResponse().size();
      boolean _greaterThan_4 = (_size_4 > 0);
      if (_greaterThan_4) {
        _builder.append("\t");
        String _responseDataNameWithPackage_4 = this._typeExtension.responseDataNameWithPackage(it.getWhenBlock().getAction());
        _builder.append(_responseDataNameWithPackage_4, "\t");
        _builder.append(" actual = null;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("if (response.getStatusCode() < 400) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("try {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("actual = response.getEntity();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.newLine();
        {
          int _size_5 = it.getWhenBlock().getExtractions().size();
          boolean _greaterThan_5 = (_size_5 > 0);
          if (_greaterThan_5) {
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("try {");
            _builder.newLine();
            {
              EList<Extraction> _extractions = it.getWhenBlock().getExtractions();
              for(final Extraction extraction : _extractions) {
                _builder.append("\t");
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("Object ");
                String _name_2 = extraction.getName();
                _builder.append(_name_2, "\t\t\t\t");
                _builder.append(" = this.extract");
                String _firstUpper = StringExtensions.toFirstUpper(extraction.getName());
                _builder.append(_firstUpper, "\t\t\t\t");
                _builder.append("(actual);");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("extractedValues.put(\"");
                String _name_3 = extraction.getName();
                _builder.append(_name_3, "\t\t\t\t");
                _builder.append("\", ");
                String _name_4 = extraction.getName();
                _builder.append(_name_4, "\t\t\t\t");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("LOG.info(\"THEN: extracted \" + ");
                String _name_5 = extraction.getName();
                _builder.append(_name_5, "\t\t\t\t");
                _builder.append(".toString()  + \" as ");
                String _name_6 = extraction.getName();
                _builder.append(_name_6, "\t\t\t\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("} catch (Exception x) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("LOG.info(\"THEN: failed to extract values from response \", x);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("} catch (Exception x) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("LOG.error(\"THEN: failed to read response\", x);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("assertFail(x.getMessage());");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        {
          DataDefinition _response = it.getThenBlock().getResponse();
          boolean _tripleNotEquals_2 = (_response != null);
          if (_tripleNotEquals_2) {
            _builder.append("\t");
            _builder.append("\t");
            String _modelClassNameWithPackage = this._typeExtension.modelClassNameWithPackage(it.getWhenBlock().getAction().getModel());
            _builder.append(_modelClassNameWithPackage, "\t\t");
            _builder.append(" expectedData = ");
            CharSequence _objectMapperCallExpectedData = this.objectMapperCallExpectedData(it.getThenBlock().getResponse().getData(), it.getWhenBlock().getAction().getModel());
            _builder.append(_objectMapperCallExpectedData, "\t\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            String _responseDataNameWithPackage_5 = this._typeExtension.responseDataNameWithPackage(it.getWhenBlock().getAction());
            _builder.append(_responseDataNameWithPackage_5, "\t\t");
            _builder.append(" expected = new ");
            String _responseDataNameWithPackage_6 = this._typeExtension.responseDataNameWithPackage(it.getWhenBlock().getAction());
            _builder.append(_responseDataNameWithPackage_6, "\t\t");
            _builder.append("(expectedData);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("assertThat(actual, expected);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("LOG.info(\"THEN: response passed\");");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("return actual;");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  private CharSequence _givenItem(final GivenRef it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    {
      int _times = it.getTimes();
      boolean _greaterThan = (_times > 0);
      if (_greaterThan) {
        _builder.append("for (int i=0; i<");
        int _times_1 = it.getTimes();
        _builder.append(_times_1);
        _builder.append("; i++) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        CharSequence _givenBlock = this.givenBlock(it, java, true);
        _builder.append(_givenBlock, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        this.incIndex();
        _builder.newLineIfNotEmpty();
      } else {
        CharSequence _givenBlock_1 = this.givenBlock(it, java, false);
        _builder.append(_givenBlock_1);
        _builder.newLineIfNotEmpty();
        this.incIndex();
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  private CharSequence _givenItem(final CustomCall it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    {
      int _times = it.getTimes();
      boolean _greaterThan = (_times > 0);
      if (_greaterThan) {
        _builder.append("for (int i=0; i<");
        int _times_1 = it.getTimes();
        _builder.append(_times_1);
        _builder.append("; i++) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("this.");
        String _customCallName = it.getCustomCallName();
        _builder.append(_customCallName, "\t");
        _builder.append("(");
        {
          EList<PrimitiveValue> _values = it.getValues();
          boolean _hasElements = false;
          for(final PrimitiveValue value : _values) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(", ", "\t");
            }
            Object _primitiveValueFrom = this.primitiveValueFrom(value);
            _builder.append(_primitiveValueFrom, "\t");
          }
        }
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        this.incIndex();
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("this.");
        String _customCallName_1 = it.getCustomCallName();
        _builder.append(_customCallName_1);
        _builder.append("(");
        {
          EList<PrimitiveValue> _values_1 = it.getValues();
          boolean _hasElements_1 = false;
          for(final PrimitiveValue value_1 : _values_1) {
            if (!_hasElements_1) {
              _hasElements_1 = true;
            } else {
              _builder.appendImmediate(", ", "");
            }
            Object _primitiveValueFrom_1 = this.primitiveValueFrom(value_1);
            _builder.append(_primitiveValueFrom_1);
          }
        }
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        this.incIndex();
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  private CharSequence givenBlock(final GivenRef givenRef, final HttpServer java, final boolean forLoop) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<WhenThen> _whenThen = givenRef.getScenario().getWhenThen();
      for(final WhenThen whenThenItem : _whenThen) {
        _builder.append("if (prerequisite(\"");
        String _name = givenRef.getScenario().getName();
        _builder.append(_name);
        _builder.append("\")) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("uuid = ");
        {
          String _uuid = whenThenItem.getWhenBlock().getDataDefinition().getUuid();
          boolean _tripleNotEquals = (_uuid != null);
          if (_tripleNotEquals) {
            _builder.append("\"");
            CharSequence _valueFromString = this.valueFromString(whenThenItem.getWhenBlock().getDataDefinition().getUuid());
            _builder.append(_valueFromString, "\t");
            _builder.append("\"");
          } else {
            _builder.append("this.randomUUID()");
          }
        }
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        CharSequence _generatePrepare = this.generatePrepare(whenThenItem.getWhenBlock());
        _builder.append(_generatePrepare, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        CharSequence _generateDataCreation = this.generateDataCreation(whenThenItem.getWhenBlock());
        _builder.append(_generateDataCreation, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("HttpResponse<");
        {
          int _size = whenThenItem.getWhenBlock().getAction().getResponse().size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            String _responseDataNameWithPackage = this._typeExtension.responseDataNameWithPackage(whenThenItem.getWhenBlock().getAction());
            _builder.append(_responseDataNameWithPackage, "\t");
          } else {
            _builder.append("Object");
          }
        }
        _builder.append("> response_");
        _builder.append(this.index, "\t");
        _builder.append(" = ");
        CharSequence _generateActionCalls = this.generateActionCalls(whenThenItem.getWhenBlock(), java);
        _builder.append(_generateActionCalls, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("if (response_");
        _builder.append(this.index, "\t");
        _builder.append(".getStatusCode() >= 400) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("String statusMessage = response_");
        _builder.append(this.index, "\t\t");
        _builder.append(".getStatusMessage() != null ? response_");
        _builder.append(this.index, "\t\t");
        _builder.append(".getStatusMessage() : \"\";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("String message = \"GIVEN ");
        String _name_1 = givenRef.getScenario().getName();
        _builder.append(_name_1, "\t\t");
        _builder.append(" fails\\n\" + statusMessage;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("LOG.error(\"GIVEN: ");
        String _name_2 = givenRef.getScenario().getName();
        _builder.append(_name_2, "\t\t");
        _builder.append(" fails due to {} in {} ms\", message, response_");
        _builder.append(this.index, "\t\t");
        _builder.append(".getDuration());");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("assertFail(message);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("LOG.info(\"GIVEN: ");
        String _name_3 = givenRef.getScenario().getName();
        _builder.append(_name_3, "\t");
        _builder.append(" success in {} ms\", response_");
        _builder.append(this.index, "\t");
        _builder.append(".getDuration());");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("addToMetrics(\"");
        String _name_4 = whenThenItem.getWhenBlock().getAction().getName();
        _builder.append(_name_4, "\t");
        _builder.append("\", response_");
        _builder.append(this.index, "\t");
        _builder.append(".getDuration());");
        _builder.newLineIfNotEmpty();
        {
          if (((whenThenItem.getWhenBlock().getExtractions().size() > 0) && (whenThenItem.getWhenBlock().getAction().getResponse().size() > 0))) {
            _builder.append("\t");
            String _responseDataNameWithPackage_1 = this._typeExtension.responseDataNameWithPackage(whenThenItem.getWhenBlock().getAction());
            _builder.append(_responseDataNameWithPackage_1, "\t");
            _builder.append(" responseEntity_");
            _builder.append(this.index, "\t");
            _builder.append(" = null;");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("try {");
            _builder.newLine();
            {
              EList<Extraction> _extractions = whenThenItem.getWhenBlock().getExtractions();
              for(final Extraction extraction : _extractions) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("Object ");
                String _name_5 = extraction.getName();
                _builder.append(_name_5, "\t\t");
                _builder.append(" = this.extract");
                String _firstUpper = StringExtensions.toFirstUpper(extraction.getName());
                _builder.append(_firstUpper, "\t\t");
                _builder.append("(response_");
                _builder.append(this.index, "\t\t");
                _builder.append(".getEntity());");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("extractedValues.put(\"");
                String _name_6 = extraction.getName();
                _builder.append(_name_6, "\t\t");
                {
                  if (forLoop) {
                    _builder.append("_\" + i");
                  } else {
                    _builder.append("\"");
                  }
                }
                _builder.append(", ");
                String _name_7 = extraction.getName();
                _builder.append(_name_7, "\t\t");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("LOG.info(\"GIVEN: extracted \" + ");
                String _name_8 = extraction.getName();
                _builder.append(_name_8, "\t\t");
                _builder.append(".toString()  + \" as ");
                String _name_9 = extraction.getName();
                _builder.append(_name_9, "\t\t");
                {
                  if (forLoop) {
                    _builder.append("_\" + i");
                  } else {
                    _builder.append("\"");
                  }
                }
                _builder.append(");");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t");
            _builder.append("} catch (Exception x) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("LOG.error(\"GIVEN: failed to extract values from response \", x);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("} else {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("LOG.info(\"GIVEN: prerequisite for ");
        String _name_10 = givenRef.getScenario().getName();
        _builder.append(_name_10, "\t");
        _builder.append(" not met\");");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }

  private CharSequence _persistenceVerification(final SelectByUniqueAttribute it, final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    String _modelClassNameWithPackage = this._typeExtension.modelClassNameWithPackage(model);
    _builder.append(_modelClassNameWithPackage);
    _builder.append(" actual = daoProvider.get");
    String _modelDao = this._typeExtension.modelDao(model);
    _builder.append(_modelDao);
    _builder.append("().selectBy");
    String _firstUpper = StringExtensions.toFirstUpper(it.getAttributeAndValue().getAttribute().getName());
    _builder.append(_firstUpper);
    _builder.append("(handle, ");
    Object _primitiveValueFrom = this.primitiveValueFrom(it.getAttributeAndValue().getValue());
    _builder.append(_primitiveValueFrom);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      JsonObject _object = it.getExpected().getObject();
      boolean _tripleNotEquals = (_object != null);
      if (_tripleNotEquals) {
        String _modelClassNameWithPackage_1 = this._typeExtension.modelClassNameWithPackage(model);
        _builder.append(_modelClassNameWithPackage_1);
        _builder.append(" expected = ");
        CharSequence _objectMapperCallExpectedPersistenceData = this.objectMapperCallExpectedPersistenceData(it.getExpected().getObject(), model);
        _builder.append(_objectMapperCallExpectedPersistenceData);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("assertThat(actual, expected);");
        _builder.newLine();
      } else {
        boolean _isIsNull = it.getExpected().isIsNull();
        if (_isIsNull) {
          _builder.append("assertIsNull(actual);");
          _builder.newLine();
        } else {
          boolean _isIsNotNull = it.getExpected().isIsNotNull();
          if (_isIsNotNull) {
            _builder.append("assertIsNotNull(actual);");
            _builder.newLine();
          }
        }
      }
    }
    return _builder;
  }

  private CharSequence _persistenceVerification(final SelectByPrimaryKeys it, final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    String _modelClassNameWithPackage = this._typeExtension.modelClassNameWithPackage(model);
    _builder.append(_modelClassNameWithPackage);
    _builder.append(" actual = daoProvider.get");
    String _modelDao = this._typeExtension.modelDao(model);
    _builder.append(_modelDao);
    _builder.append("().selectByPrimaryKey(handle, ");
    {
      List<Attribute> _allPrimaryKeyAttributes = this._commonExtension.allPrimaryKeyAttributes(model);
      boolean _hasElements = false;
      for(final Attribute attribute : _allPrimaryKeyAttributes) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        Object _primitiveValueFrom = this.primitiveValueFrom(this.findForPrimaryKey(attribute, it.getAttributeAndValues()).getValue());
        _builder.append(_primitiveValueFrom);
      }
    }
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      JsonObject _object = it.getExpected().getObject();
      boolean _tripleNotEquals = (_object != null);
      if (_tripleNotEquals) {
        String _modelClassNameWithPackage_1 = this._typeExtension.modelClassNameWithPackage(model);
        _builder.append(_modelClassNameWithPackage_1);
        _builder.append(" expected = ");
        CharSequence _objectMapperCallExpectedPersistenceData = this.objectMapperCallExpectedPersistenceData(it.getExpected().getObject(), model);
        _builder.append(_objectMapperCallExpectedPersistenceData);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("assertThat(actual, expected);");
        _builder.newLine();
      } else {
        boolean _isIsNull = it.getExpected().isIsNull();
        if (_isIsNull) {
          _builder.append("assertIsNull(actual);");
          _builder.newLine();
        } else {
          boolean _isIsNotNull = it.getExpected().isIsNotNull();
          if (_isIsNotNull) {
            _builder.append("assertIsNotNull(actual);");
            _builder.newLine();
          }
        }
      }
    }
    return _builder;
  }

  private CharSequence _persistenceVerification(final Count it, final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Map<String, String> filterMap = new HashMap<String, String>();");
    _builder.newLine();
    {
      EList<AttributeAndValue> _attributeAndValues = it.getAttributeAndValues();
      for(final AttributeAndValue attributeValue : _attributeAndValues) {
        _builder.append("filterMap.put(\"");
        String _name = attributeValue.getAttribute().getName();
        _builder.append(_name);
        _builder.append("\", ");
        Object _primitiveValueFrom = this.primitiveValueFrom(attributeValue.getValue());
        _builder.append(_primitiveValueFrom);
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("int actual = daoProvider.get");
    String _modelDao = this._typeExtension.modelDao(model);
    _builder.append(_modelDao);
    _builder.append("().filterAndCountBy(handle, filterMap);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("assertThat(actual, ");
    int _expected = it.getExpected();
    _builder.append(_expected);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  private AttributeAndValue findForPrimaryKey(final Attribute it, final List<AttributeAndValue> list) {
    for (final AttributeAndValue attributeAndValue : list) {
      String _name = attributeAndValue.getAttribute().getName();
      String _name_1 = it.getName();
      boolean _equals = Objects.equal(_name, _name_1);
      if (_equals) {
        return attributeAndValue;
      }
    }
    return null;
  }

  private ArrayList<Given> allGivenItems(final de.acegen.aceGen.Scenario it) {
    ArrayList<Given> allWhenBlocks = new ArrayList<Given>();
    EList<Given> _givenItems = it.getGivenItems();
    for (final Given given : _givenItems) {
      if ((given instanceof GivenRef)) {
        boolean _isExcludeGiven = ((GivenRef)given).isExcludeGiven();
        if (_isExcludeGiven) {
          allWhenBlocks.add(given);
        } else {
          this.allGivenItemsRec(given, allWhenBlocks);
        }
      } else {
        if ((given instanceof CustomCall)) {
          allWhenBlocks.add(given);
        }
      }
    }
    return allWhenBlocks;
  }

  private void allGivenItemsRec(final Given it, final List<Given> allWhenBlocks) {
    if ((it instanceof GivenRef)) {
      boolean _isExcludeGiven = ((GivenRef)it).isExcludeGiven();
      boolean _not = (!_isExcludeGiven);
      if (_not) {
        EList<Given> _givenItems = ((GivenRef)it).getScenario().getGivenItems();
        for (final Given given : _givenItems) {
          this.allGivenItemsRec(given, allWhenBlocks);
        }
      }
    }
    allWhenBlocks.add(it);
  }

  private CharSequence generatePrepare(final WhenBlock it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      String _systemtime = it.getDataDefinition().getSystemtime();
      boolean _tripleNotEquals = (_systemtime != null);
      if (_tripleNotEquals) {
        _builder.append("this.callSquishyDataProviderPutSystemTime(uuid, LocalDateTime.parse(\"");
        String _systemtime_1 = it.getDataDefinition().getSystemtime();
        _builder.append(_systemtime_1);
        _builder.append("\", DateTimeFormatter.ofPattern(\"");
        String _pattern = it.getDataDefinition().getPattern();
        _builder.append(_pattern);
        _builder.append("\")));");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      if (((((it.getDataDefinition() != null) && (it.getDataDefinition().getData() != null)) && (it.getDataDefinition().getData() instanceof JsonObjectAce)) && (((JsonObjectAce) it.getDataDefinition().getData()).getMembers() != null))) {
        {
          JsonObject _data = it.getDataDefinition().getData();
          EList<JsonMember> _members = ((JsonObjectAce) _data).getMembers();
          for(final JsonMember attributeDefinition : _members) {
            {
              boolean _isSquishy = attributeDefinition.getAttribute().isSquishy();
              if (_isSquishy) {
                _builder.append("this.callSquishyDataProviderPutValue(uuid, \"");
                String _name = attributeDefinition.getAttribute().getName();
                _builder.append(_name);
                _builder.append("\",\t\"");
                CharSequence _squishyValueFrom = this.squishyValueFrom(attributeDefinition.getValue());
                _builder.append(_squishyValueFrom);
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    return _builder;
  }

  private CharSequence generateDataCreation(final WhenBlock it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      int _size = it.getAction().getPayload().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        String _payloadDataNameWithPackage = this._typeExtension.payloadDataNameWithPackage(it.getAction());
        _builder.append(_payloadDataNameWithPackage);
        _builder.append(" payload_");
        _builder.append(this.index);
        _builder.append(" = ");
        CharSequence _objectMapperCallPayload = this.objectMapperCallPayload(it.getDataDefinition().getData(), it.getAction());
        _builder.append(_objectMapperCallPayload);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    String _modelClassNameWithPackage = this._typeExtension.modelClassNameWithPackage(it.getAction().getModel());
    _builder.append(_modelClassNameWithPackage);
    _builder.append(" model_");
    _builder.append(this.index);
    _builder.append(" = ");
    CharSequence _objectMapperCall = this.objectMapperCall(it.getDataDefinition().getData(), it.getAction().getModel());
    _builder.append(_objectMapperCall);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    String _dataWithGenericModel = this._typeExtension.dataWithGenericModel(it.getAction().getModel());
    _builder.append(_dataWithGenericModel);
    _builder.append(" data_");
    _builder.append(this.index);
    _builder.append(" = new ");
    String _dataWithGenericModel_1 = this._typeExtension.dataWithGenericModel(it.getAction().getModel());
    _builder.append(_dataWithGenericModel_1);
    _builder.append("(uuid);");
    _builder.newLineIfNotEmpty();
    _builder.append("data_");
    _builder.append(this.index);
    _builder.append(".setModel(model_");
    _builder.append(this.index);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  private CharSequence _objectMapperCall(final JsonObjectAce it, final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("objectMapper.readValue(\"");
    {
      if (((it != null) && (it.getMembers() != null))) {
        _builder.append("{\" +");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\"");
        {
          final Function1<JsonMember, Boolean> _function = new Function1<JsonMember, Boolean>() {
            public Boolean apply(final JsonMember it_1) {
              boolean _isSquishy = it_1.getAttribute().isSquishy();
              return Boolean.valueOf((!_isSquishy));
            }
          };
          Iterable<JsonMember> _filter = IterableExtensions.<JsonMember>filter(it.getMembers(), _function);
          boolean _hasElements = false;
          for(final JsonMember member : _filter) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(this.stringLineBreak, "\t");
            }
            _builder.append("\\\"");
            String _name = member.getAttribute().getName();
            _builder.append(_name, "\t");
            _builder.append("\\\" : ");
            CharSequence _valueFrom = this.valueFrom(member.getValue());
            _builder.append(_valueFrom, "\t");
          }
        }
        _builder.append("} ");
      } else {
        _builder.append("{ }");
      }
    }
    _builder.append("\", ");
    String _modelClassNameWithPackage = this._typeExtension.modelClassNameWithPackage(model);
    _builder.append(_modelClassNameWithPackage);
    _builder.append(".class)");
    return _builder;
  }

  private CharSequence _objectMapperCall(final StringType it, final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("objectMapper.readValue(\"");
    CharSequence _valueFrom = this.valueFrom(it.getString());
    _builder.append(_valueFrom);
    _builder.append("\", ");
    String _modelClassNameWithPackage = this._typeExtension.modelClassNameWithPackage(model);
    _builder.append(_modelClassNameWithPackage);
    _builder.append(".class)");
    return _builder;
  }

  private CharSequence _objectMapperCall(final Void it, final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new ");
    String _modelClassNameWithPackage = this._typeExtension.modelClassNameWithPackage(model);
    _builder.append(_modelClassNameWithPackage);
    _builder.append("()");
    return _builder;
  }

  private CharSequence _objectMapperCallPayload(final JsonObjectAce it, final HttpServerAce action) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("objectMapper.readValue(\"");
    {
      if ((((it != null) && (it.getMembers() != null)) && (IterableExtensions.size(IterableExtensions.<JsonMember>filter(it.getMembers(), new Function1<JsonMember, Boolean>() {
        public Boolean apply(final JsonMember it_1) {
          boolean _isSquishy = it_1.getAttribute().isSquishy();
          return Boolean.valueOf((!_isSquishy));
        }
      })) > 0))) {
        _builder.append("{\" +");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\"");
        {
          final Function1<JsonMember, Boolean> _function = new Function1<JsonMember, Boolean>() {
            public Boolean apply(final JsonMember it_1) {
              boolean _isSquishy = it_1.getAttribute().isSquishy();
              return Boolean.valueOf((!_isSquishy));
            }
          };
          Iterable<JsonMember> _filter = IterableExtensions.<JsonMember>filter(it.getMembers(), _function);
          boolean _hasElements = false;
          for(final JsonMember member : _filter) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(this.stringLineBreak, "\t");
            }
            _builder.append("\\\"");
            String _name = member.getAttribute().getName();
            _builder.append(_name, "\t");
            _builder.append("\\\" : ");
            CharSequence _valueFrom = this.valueFrom(member.getValue());
            _builder.append(_valueFrom, "\t");
          }
        }
        _builder.append("} ");
      } else {
        _builder.append("{}");
      }
    }
    _builder.append("\",");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    String _payloadDataNameWithPackage = this._typeExtension.payloadDataNameWithPackage(action);
    _builder.append(_payloadDataNameWithPackage, "\t\t");
    _builder.append(".class)");
    return _builder;
  }

  private CharSequence _objectMapperCallPayload(final StringType it, final HttpServerAce action) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("objectMapper.readValue(\"");
    CharSequence _valueFrom = this.valueFrom(it.getString());
    _builder.append(_valueFrom);
    _builder.append("\",");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    String _payloadDataNameWithPackage = this._typeExtension.payloadDataNameWithPackage(action);
    _builder.append(_payloadDataNameWithPackage, "\t\t");
    _builder.append(".class)");
    return _builder;
  }

  private CharSequence _objectMapperCallPayload(final Void it, final HttpServerAce action) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("objectMapper.readValue(\"{}\",");
    _builder.newLine();
    String _payloadDataNameWithPackage = this._typeExtension.payloadDataNameWithPackage(action);
    _builder.append(_payloadDataNameWithPackage);
    _builder.append(".class)");
    return _builder;
  }

  private CharSequence _objectMapperCallExpectedData(final JsonObjectAce it, final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("objectMapper.readValue(\"");
    {
      if (((it != null) && (it.getMembers() != null))) {
        _builder.append("{\" +");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\"");
        {
          final Function1<JsonMember, Boolean> _function = new Function1<JsonMember, Boolean>() {
            public Boolean apply(final JsonMember it_1) {
              boolean _isSquishy = it_1.getAttribute().isSquishy();
              return Boolean.valueOf((!_isSquishy));
            }
          };
          Iterable<JsonMember> _filter = IterableExtensions.<JsonMember>filter(it.getMembers(), _function);
          boolean _hasElements = false;
          for(final JsonMember member : _filter) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(this.stringLineBreak, "\t");
            }
            _builder.append("\\\"");
            String _name = member.getAttribute().getName();
            _builder.append(_name, "\t");
            _builder.append("\\\" : ");
            CharSequence _valueFrom = this.valueFrom(member.getValue());
            _builder.append(_valueFrom, "\t");
          }
        }
        _builder.append("} ");
      } else {
        _builder.append("{}");
      }
    }
    _builder.append("\", ");
    String _modelClassNameWithPackage = this._typeExtension.modelClassNameWithPackage(model);
    _builder.append(_modelClassNameWithPackage);
    _builder.append(".class)");
    return _builder;
  }

  private CharSequence _objectMapperCallExpectedData(final StringType it, final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("objectMapper.readValue(\"");
    CharSequence _valueFrom = this.valueFrom(it.getString());
    _builder.append(_valueFrom);
    _builder.append("\", new TypeReference<Data<");
    String _modelClassNameWithPackage = this._typeExtension.modelClassNameWithPackage(model);
    _builder.append(_modelClassNameWithPackage);
    _builder.append(">>() {})");
    return _builder;
  }

  private CharSequence _objectMapperCallExpectedPersistenceData(final JsonObjectAce it, final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("objectMapper.readValue(\"");
    {
      if (((it != null) && (it.getMembers() != null))) {
        _builder.append("{\" +");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\"");
        {
          EList<JsonMember> _members = it.getMembers();
          boolean _hasElements = false;
          for(final JsonMember member : _members) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(this.stringLineBreak, "\t");
            }
            _builder.append("\\\"");
            String _name = member.getAttribute().getName();
            _builder.append(_name, "\t");
            _builder.append("\\\" : ");
            CharSequence _valueFrom = this.valueFrom(member.getValue());
            _builder.append(_valueFrom, "\t");
          }
        }
        _builder.append("} ");
      } else {
        _builder.append("{}");
      }
    }
    _builder.append("\",");
    _builder.newLineIfNotEmpty();
    String _modelClassNameWithPackage = this._typeExtension.modelClassNameWithPackage(model);
    _builder.append(_modelClassNameWithPackage);
    _builder.append(".class)");
    return _builder;
  }

  private CharSequence _objectMapperCallExpectedPersistenceData(final StringType it, final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("objectMapper.readValue(\"");
    CharSequence _valueFrom = this.valueFrom(it.getString());
    _builder.append(_valueFrom);
    _builder.append("\",");
    _builder.newLineIfNotEmpty();
    String _modelClassNameWithPackage = this._typeExtension.modelClassNameWithPackage(model);
    _builder.append(_modelClassNameWithPackage);
    _builder.append(".class)");
    return _builder;
  }

  private CharSequence _objectMapperCallExpectedPersistenceData(final Void it, final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("objectMapper.readValue(\"{}\",");
    _builder.newLine();
    String _modelClassNameWithPackage = this._typeExtension.modelClassNameWithPackage(model);
    _builder.append(_modelClassNameWithPackage);
    _builder.append(".class)");
    return _builder;
  }

  private CharSequence generateActionCalls(final WhenBlock it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    {
      String _type = it.getAction().getType();
      boolean _equals = Objects.equal(_type, "POST");
      if (_equals) {
        _builder.append("this.httpPost(");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\"");
        HttpServerAce _action = it.getAction();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("data_");
        _builder_1.append(this.index);
        _builder_1.append(".getModel()");
        String _urlWithPathParams = this.urlWithPathParams(_action, _builder_1.toString(), false);
        _builder.append(_urlWithPathParams, "\t");
        _builder.append("\", ");
        _builder.newLineIfNotEmpty();
        _builder.append(" \t");
        {
          int _size = it.getAction().getPayload().size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            _builder.append("payload_");
            _builder.append(this.index, " \t");
          } else {
            _builder.append("null");
          }
        }
        _builder.append(",");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        {
          if ((it.getAction().isAuthorize() && (it.getAuthorization() != null))) {
            _builder.append("authorization(\"");
            String _username = it.getAuthorization().getUsername();
            _builder.append(_username, "\t");
            _builder.append("\", \"");
            String _password = it.getAuthorization().getPassword();
            _builder.append(_password, "\t");
            _builder.append("\")");
          } else {
            _builder.append("null");
          }
        }
        _builder.append(",");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("uuid,");
        _builder.newLine();
        _builder.append("\t");
        {
          int _size_1 = it.getAction().getResponse().size();
          boolean _greaterThan_1 = (_size_1 > 0);
          if (_greaterThan_1) {
            String _responseDataNameWithPackage = this._typeExtension.responseDataNameWithPackage(it.getAction());
            _builder.append(_responseDataNameWithPackage, "\t");
            _builder.append(".class");
          } else {
            _builder.append("null");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append(");");
        _builder.newLine();
      } else {
        String _type_1 = it.getAction().getType();
        boolean _equals_1 = Objects.equal(_type_1, "PUT");
        if (_equals_1) {
          _builder.append("this.httpPut(");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\"");
          HttpServerAce _action_1 = it.getAction();
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("data_");
          _builder_2.append(this.index);
          _builder_2.append(".getModel()");
          String _urlWithPathParams_1 = this.urlWithPathParams(_action_1, _builder_2.toString(), true);
          _builder.append(_urlWithPathParams_1, "\t");
          _builder.append("\", ");
          _builder.newLineIfNotEmpty();
          _builder.append(" \t");
          {
            int _size_2 = it.getAction().getPayload().size();
            boolean _greaterThan_2 = (_size_2 > 0);
            if (_greaterThan_2) {
              _builder.append("payload_");
              _builder.append(this.index, " \t");
            } else {
              _builder.append("null");
            }
          }
          _builder.append(",");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          {
            if ((it.getAction().isAuthorize() && (it.getAuthorization() != null))) {
              _builder.append("authorization(\"");
              String _username_1 = it.getAuthorization().getUsername();
              _builder.append(_username_1, "\t");
              _builder.append("\", \"");
              String _password_1 = it.getAuthorization().getPassword();
              _builder.append(_password_1, "\t");
              _builder.append("\")");
            } else {
              _builder.append("null");
            }
          }
          _builder.append(",");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("uuid,");
          _builder.newLine();
          _builder.append("\t");
          {
            int _size_3 = it.getAction().getResponse().size();
            boolean _greaterThan_3 = (_size_3 > 0);
            if (_greaterThan_3) {
              String _responseDataNameWithPackage_1 = this._typeExtension.responseDataNameWithPackage(it.getAction());
              _builder.append(_responseDataNameWithPackage_1, "\t");
              _builder.append(".class");
            } else {
              _builder.append("null");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append(");");
          _builder.newLine();
        } else {
          String _type_2 = it.getAction().getType();
          boolean _equals_2 = Objects.equal(_type_2, "DELETE");
          if (_equals_2) {
            _builder.append("this.httpDelete(");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\"");
            HttpServerAce _action_2 = it.getAction();
            StringConcatenation _builder_3 = new StringConcatenation();
            _builder_3.append("data_");
            _builder_3.append(this.index);
            _builder_3.append(".getModel()");
            String _urlWithPathParams_2 = this.urlWithPathParams(_action_2, _builder_3.toString(), true);
            _builder.append(_urlWithPathParams_2, "\t");
            _builder.append("\", ");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            {
              if ((it.getAction().isAuthorize() && (it.getAuthorization() != null))) {
                _builder.append("authorization(\"");
                String _username_2 = it.getAuthorization().getUsername();
                _builder.append(_username_2, "\t");
                _builder.append("\", \"");
                String _password_2 = it.getAuthorization().getPassword();
                _builder.append(_password_2, "\t");
                _builder.append("\")");
              } else {
                _builder.append("null");
              }
            }
            _builder.append(",");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("uuid,");
            _builder.newLine();
            _builder.append("\t");
            {
              int _size_4 = it.getAction().getResponse().size();
              boolean _greaterThan_4 = (_size_4 > 0);
              if (_greaterThan_4) {
                String _responseDataNameWithPackage_2 = this._typeExtension.responseDataNameWithPackage(it.getAction());
                _builder.append(_responseDataNameWithPackage_2, "\t");
                _builder.append(".class");
              } else {
                _builder.append("null");
              }
            }
            _builder.newLineIfNotEmpty();
            _builder.append(");");
            _builder.newLine();
          } else {
            _builder.append("this.httpGet(");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\"");
            HttpServerAce _action_3 = it.getAction();
            StringConcatenation _builder_4 = new StringConcatenation();
            _builder_4.append("data_");
            _builder_4.append(this.index);
            _builder_4.append(".getModel()");
            String _urlWithPathParams_3 = this.urlWithPathParams(_action_3, _builder_4.toString(), true);
            _builder.append(_urlWithPathParams_3, "\t");
            _builder.append("\", ");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            {
              if ((it.getAction().isAuthorize() && (it.getAuthorization() != null))) {
                _builder.append("authorization(\"");
                String _username_3 = it.getAuthorization().getUsername();
                _builder.append(_username_3, "\t");
                _builder.append("\", \"");
                String _password_3 = it.getAuthorization().getPassword();
                _builder.append(_password_3, "\t");
                _builder.append("\")");
              } else {
                _builder.append("null");
              }
            }
            _builder.append(",");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("uuid,");
            _builder.newLine();
            _builder.append("\t");
            {
              int _size_5 = it.getAction().getResponse().size();
              boolean _greaterThan_5 = (_size_5 > 0);
              if (_greaterThan_5) {
                String _responseDataNameWithPackage_3 = this._typeExtension.responseDataNameWithPackage(it.getAction());
                _builder.append(_responseDataNameWithPackage_3, "\t");
                _builder.append(".class");
              } else {
                _builder.append("null");
              }
            }
            _builder.newLineIfNotEmpty();
            _builder.append(");");
            _builder.newLine();
          }
        }
      }
    }
    _builder.newLine();
    return _builder;
  }

  private String urlWithPathParams(final HttpServerAce it, final String dataVarName, final boolean generateQueryParams) {
    int _size = it.getPathParams().size();
    boolean _equals = (_size == 0);
    if (_equals) {
      String _url = it.getUrl();
      StringConcatenation _builder = new StringConcatenation();
      {
        if (generateQueryParams) {
          {
            EList<AttributeParamRef> _queryParams = it.getQueryParams();
            boolean _hasElements = false;
            for(final AttributeParamRef queryParam : _queryParams) {
              if (!_hasElements) {
                _hasElements = true;
                _builder.append("?");
              } else {
                _builder.appendImmediate("&", "");
              }
              String _name = queryParam.getAttribute().getName();
              _builder.append(_name);
              _builder.append("=\" + ");
              {
                String _type = queryParam.getAttribute().getType();
                boolean _equals_1 = Objects.equal(_type, "String");
                if (_equals_1) {
                  StringConcatenation _builder_1 = new StringConcatenation();
                  _builder_1.append(dataVarName);
                  _builder_1.append(".");
                  String _terName = this._attributeExtension.getterName(queryParam.getAttribute());
                  _builder_1.append(_terName);
                  _builder_1.append("()");
                  String _urlEncodedValue = this.urlEncodedValue(_builder_1.toString());
                  _builder.append(_urlEncodedValue);
                } else {
                  _builder.append(dataVarName);
                  _builder.append(".");
                  String _terName_1 = this._attributeExtension.getterName(queryParam.getAttribute());
                  _builder.append(_terName_1);
                  _builder.append("()");
                }
              }
              _builder.append(" + \"");
            }
          }
        }
      }
      String retUrl = (_url + _builder);
      return retUrl;
    }
    final String[] split1 = it.getUrl().split("\\{");
    ArrayList<String> urlElements = new ArrayList<String>();
    for (final String split : split1) {
      {
        final String[] split2 = split.split("\\}");
        CollectionExtensions.<String>addAll(urlElements, split2);
      }
    }
    String urlWithPathParam = "";
    for (int i = 0; (i < urlElements.size()); i++) {
      if (((i % 2) == 0)) {
        String _urlWithPathParam = urlWithPathParam;
        String _get = urlElements.get(i);
        urlWithPathParam = (_urlWithPathParam + _get);
      } else {
        String _urlWithPathParam_1 = urlWithPathParam;
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("\" + ");
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append(dataVarName);
        _builder_3.append(".get");
        String _firstUpper = StringExtensions.toFirstUpper(urlElements.get(i));
        _builder_3.append(_firstUpper);
        _builder_3.append("()");
        String _urlEncodedValue_1 = this.urlEncodedValue(_builder_3.toString());
        _builder_2.append(_urlEncodedValue_1);
        _builder_2.append(" + \"");
        urlWithPathParam = (_urlWithPathParam_1 + _builder_2);
      }
    }
    String _urlWithPathParam = urlWithPathParam;
    StringConcatenation _builder_2 = new StringConcatenation();
    {
      if (generateQueryParams) {
        {
          EList<AttributeParamRef> _queryParams_1 = it.getQueryParams();
          boolean _hasElements_1 = false;
          for(final AttributeParamRef queryParam_1 : _queryParams_1) {
            if (!_hasElements_1) {
              _hasElements_1 = true;
              _builder_2.append("?");
            } else {
              _builder_2.appendImmediate("&", "");
            }
            String _name_1 = queryParam_1.getAttribute().getName();
            _builder_2.append(_name_1);
            _builder_2.append("=\" + ");
            StringConcatenation _builder_3 = new StringConcatenation();
            _builder_3.append(dataVarName);
            _builder_3.append(".");
            String _terName_2 = this._attributeExtension.getterName(queryParam_1.getAttribute());
            _builder_3.append(_terName_2);
            _builder_3.append("()");
            String _urlEncodedValue_1 = this.urlEncodedValue(_builder_3.toString());
            _builder_2.append(_urlEncodedValue_1);
            _builder_2.append(" + \"");
          }
        }
      }
    }
    urlWithPathParam = (_urlWithPathParam + _builder_2);
    return urlWithPathParam;
  }

  private String urlEncodedValue(final String valueVar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    _builder.append(valueVar);
    _builder.append(" != null ? URLEncoder.encode(");
    _builder.append(valueVar);
    _builder.append(", StandardCharsets.UTF_8.toString()) : \"\")");
    return _builder.toString();
  }

  private Object primitiveValueFrom(final PrimitiveValue it) {
    String _string = it.getString();
    boolean _tripleNotEquals = (_string != null);
    if (_tripleNotEquals) {
      String returnString = it.getString();
      boolean _contains = it.getString().contains("${testId}");
      if (_contains) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("\" + this.getTestId() + \"");
        returnString = returnString.replace("${testId}", _builder);
      } else {
        boolean _contains_1 = it.getString().contains("${");
        if (_contains_1) {
          final int beginIndex = it.getString().indexOf("${");
          final int endIndex = it.getString().indexOf("}");
          final String templateString = it.getString().substring(beginIndex, (endIndex + 1));
          final String templateStringName = it.getString().substring((beginIndex + 2), endIndex);
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("\" + this.extractedValues.get(\"");
          _builder_1.append(templateStringName);
          _builder_1.append("\").toString() + \"");
          returnString = returnString.replace(templateString, _builder_1);
        }
      }
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("\"");
      _builder_2.append(returnString);
      _builder_2.append("\"");
      return _builder_2.toString();
    }
    boolean _isMinus = it.isMinus();
    if (_isMinus) {
      int _long = it.getLong();
      return Integer.valueOf((_long * (-1)));
    }
    return Integer.valueOf(it.getLong());
  }

  private LocalDateTime dateTimeParse(final String dateString, final String pattern) {
    try {
      return LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern(pattern));
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }

  private CharSequence _valueFrom(final JsonObjectAce it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((((it != null) && (it.getMembers() != null)) && (it.getMembers().size() > 0))) {
        _builder.append("{ ");
        {
          EList<JsonMember> _members = it.getMembers();
          boolean _hasElements = false;
          for(final JsonMember member : _members) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(this.stringLineBreak, "");
            }
            _builder.append("\\\"");
            String _name = member.getAttribute().getName();
            _builder.append(_name);
            _builder.append("\\\" : ");
            CharSequence _valueFrom = this.valueFrom(member.getValue());
            _builder.append(_valueFrom);
          }
        }
        _builder.append("}");
      } else {
        _builder.append("{}");
      }
    }
    return _builder;
  }

  private CharSequence _valueFrom(final String it) {
    return this.valueFromString(it);
  }

  private CharSequence _valueFrom(final JsonValue it) {
    if ((it instanceof StringType)) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\\\"");
      CharSequence _valueFromString = this.valueFromString(((StringType)it).getString());
      _builder.append(_valueFromString);
      _builder.append("\\\"");
      return _builder;
    } else {
      if ((it instanceof BooleanType)) {
        return ((BooleanType)it).getBoolean();
      } else {
        if ((it instanceof NullType)) {
          return "null";
        } else {
          if ((it instanceof LongType)) {
            StringConcatenation _builder_1 = new StringConcatenation();
            {
              boolean _isMinus = ((LongType)it).isMinus();
              if (_isMinus) {
                _builder_1.append("-");
              }
            }
            int _long = ((LongType)it).getLong();
            _builder_1.append(_long);
            return _builder_1;
          }
        }
      }
    }
    return null;
  }

  private CharSequence _squishyValueFrom(final JsonObjectAce it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("null");
    return _builder;
  }

  private CharSequence _squishyValueFrom(final String it) {
    return this.valueFromString(it);
  }

  private CharSequence _squishyValueFrom(final JsonValue it) {
    if ((it instanceof StringType)) {
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _valueFromString = this.valueFromString(((StringType)it).getString());
      _builder.append(_valueFromString);
      return _builder;
    } else {
      if ((it instanceof BooleanType)) {
        return ((BooleanType)it).getBoolean();
      } else {
        if ((it instanceof NullType)) {
          return "null";
        } else {
          if ((it instanceof LongType)) {
            StringConcatenation _builder_1 = new StringConcatenation();
            int _long = ((LongType)it).getLong();
            _builder_1.append(_long);
            return _builder_1;
          }
        }
      }
    }
    return null;
  }

  private CharSequence valueFromString(final String it) {
    String returnString = it;
    boolean _contains = it.contains("${random}");
    if (_contains) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\" + this.randomString() + \"");
      returnString = returnString.replace("${random}", _builder);
    }
    boolean _contains_1 = it.contains("${testId}");
    if (_contains_1) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("\" + this.getTestId() + \"");
      returnString = returnString.replace("${testId}", _builder_1);
    }
    while (returnString.contains("${")) {
      {
        final int beginIndex = returnString.indexOf("${");
        final int endIndex = returnString.indexOf("}");
        final String templateString = returnString.substring(beginIndex, (endIndex + 1));
        final String templateStringName = returnString.substring((beginIndex + 2), endIndex);
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("\" + this.extractedValues.get(\"");
        _builder_2.append(templateStringName);
        _builder_2.append("\").toString() + \"");
        returnString = returnString.replace(templateString, _builder_2);
      }
    }
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append(returnString);
    return _builder_2;
  }

  private CharSequence _valueFrom(final JsonArray it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((((it != null) && (it.getValues() != null)) && (it.getValues().size() > 0))) {
        _builder.append("[ ");
        {
          EList<JsonValue> _values = it.getValues();
          boolean _hasElements = false;
          for(final JsonValue value : _values) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(this.stringLineBreak, "");
            }
            CharSequence _valueFrom = this.valueFrom(value);
            _builder.append(_valueFrom);
          }
        }
        _builder.append("]");
      } else {
        _builder.append("[]");
      }
    }
    return _builder;
  }

  private CharSequence _valueFrom(final JsonDateTime it) {
    boolean _contains = it.getDateTime().contains("${");
    if (_contains) {
      final int beginIndex = it.getDateTime().indexOf("${");
      final int endIndex = it.getDateTime().indexOf("}");
      final String templateStringName = it.getDateTime().substring((beginIndex + 2), endIndex);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\\\"\" + LocalDateTime.parse(this.extractedValues.get(\"");
      _builder.append(templateStringName);
      _builder.append("\").toString(), DateTimeFormatter.ofPattern(\"");
      String _pattern = it.getPattern();
      _builder.append(_pattern);
      _builder.append("\"))  + \"\\\"");
      return _builder;
    }
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("\\\"");
    LocalDateTime _dateTimeParse = this.dateTimeParse(it.getDateTime(), it.getPattern());
    _builder_1.append(_dateTimeParse);
    _builder_1.append("\\\"");
    return _builder_1;
  }

  private CharSequence givenItem(final Given it, final HttpServer java) {
    if (it instanceof CustomCall) {
      return _givenItem((CustomCall)it, java);
    } else if (it instanceof GivenRef) {
      return _givenItem((GivenRef)it, java);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, java).toString());
    }
  }

  private CharSequence persistenceVerification(final PersistenceVerificationExpression it, final Model model) {
    if (it instanceof Count) {
      return _persistenceVerification((Count)it, model);
    } else if (it instanceof SelectByPrimaryKeys) {
      return _persistenceVerification((SelectByPrimaryKeys)it, model);
    } else if (it instanceof SelectByUniqueAttribute) {
      return _persistenceVerification((SelectByUniqueAttribute)it, model);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, model).toString());
    }
  }

  private CharSequence objectMapperCall(final JsonObject it, final Model model) {
    if (it instanceof JsonObjectAce) {
      return _objectMapperCall((JsonObjectAce)it, model);
    } else if (it instanceof StringType) {
      return _objectMapperCall((StringType)it, model);
    } else if (it == null) {
      return _objectMapperCall((Void)null, model);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, model).toString());
    }
  }

  private CharSequence objectMapperCallPayload(final JsonObject it, final HttpServerAce action) {
    if (it instanceof JsonObjectAce) {
      return _objectMapperCallPayload((JsonObjectAce)it, action);
    } else if (it instanceof StringType) {
      return _objectMapperCallPayload((StringType)it, action);
    } else if (it == null) {
      return _objectMapperCallPayload((Void)null, action);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, action).toString());
    }
  }

  private CharSequence objectMapperCallExpectedData(final JsonObject it, final Model model) {
    if (it instanceof JsonObjectAce) {
      return _objectMapperCallExpectedData((JsonObjectAce)it, model);
    } else if (it instanceof StringType) {
      return _objectMapperCallExpectedData((StringType)it, model);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, model).toString());
    }
  }

  private CharSequence objectMapperCallExpectedPersistenceData(final JsonObject it, final Model model) {
    if (it instanceof JsonObjectAce) {
      return _objectMapperCallExpectedPersistenceData((JsonObjectAce)it, model);
    } else if (it instanceof StringType) {
      return _objectMapperCallExpectedPersistenceData((StringType)it, model);
    } else if (it == null) {
      return _objectMapperCallExpectedPersistenceData((Void)null, model);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, model).toString());
    }
  }

  private CharSequence valueFrom(final Object it) {
    if (it instanceof JsonObjectAce) {
      return _valueFrom((JsonObjectAce)it);
    } else if (it instanceof JsonArray) {
      return _valueFrom((JsonArray)it);
    } else if (it instanceof JsonDateTime) {
      return _valueFrom((JsonDateTime)it);
    } else if (it instanceof JsonValue) {
      return _valueFrom((JsonValue)it);
    } else if (it instanceof String) {
      return _valueFrom((String)it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }

  private CharSequence squishyValueFrom(final Object it) {
    if (it instanceof JsonObjectAce) {
      return _squishyValueFrom((JsonObjectAce)it);
    } else if (it instanceof JsonValue) {
      return _squishyValueFrom((JsonValue)it);
    } else if (it instanceof String) {
      return _squishyValueFrom((String)it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
