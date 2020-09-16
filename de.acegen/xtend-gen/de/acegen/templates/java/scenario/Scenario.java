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
import de.acegen.aceGen.Count;
import de.acegen.aceGen.CustomCall;
import de.acegen.aceGen.DataDefinition;
import de.acegen.aceGen.Extraction;
import de.acegen.aceGen.Given;
import de.acegen.aceGen.GivenRef;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.JsonMember;
import de.acegen.aceGen.JsonObject;
import de.acegen.aceGen.Model;
import de.acegen.aceGen.PersistenceVerification;
import de.acegen.aceGen.PersistenceVerificationExpression;
import de.acegen.aceGen.PrimitiveValue;
import de.acegen.aceGen.SelectByPrimaryKeys;
import de.acegen.aceGen.SelectByUniqueAttribute;
import de.acegen.aceGen.Verification;
import de.acegen.aceGen.WhenBlock;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.java.AceExtension;
import de.acegen.extensions.java.AttributeExtension;
import de.acegen.extensions.java.ModelExtension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class Scenario {
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
  
  private int index;
  
  private void resetIndex() {
    this.index = 0;
  }
  
  private void incIndex() {
    int _index = this.index;
    this.index = (_index + 1);
  }
  
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
    _builder.append("import ");
    EObject _eContainer = it.getWhenBlock().getAction().eContainer();
    String _responseDataNameWithPackage = this._aceExtension.responseDataNameWithPackage(it.getWhenBlock().getAction(), ((HttpServer) _eContainer));
    _builder.append(_responseDataNameWithPackage);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
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
    {
      EList<Verification> _verifications = it.getThenBlock().getVerifications();
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
          int _size = it.getWhenBlock().getAction().getResponse().size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            EObject _eContainer_1 = it.getWhenBlock().getAction().eContainer();
            String _responseDataNameWithPackage_1 = this._aceExtension.responseDataNameWithPackage(it.getWhenBlock().getAction(), ((HttpServer) _eContainer_1));
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
    _builder.append("import java.util.ArrayList;");
    _builder.newLine();
    _builder.append("import java.util.Arrays;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import java.util.Map;");
    _builder.newLine();
    _builder.append("import java.util.HashMap;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import javax.ws.rs.core.Response;");
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
    _builder.append("import de.acegen.ITimelineItem;");
    _builder.newLine();
    _builder.append("import de.acegen.NotReplayableDataProvider;");
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
    _builder.append("private Map<String, Object> extractedValues = new HashMap<String, Object>();");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private void given() throws Exception {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Response response;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String uuid;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("long timeBeforeRequest;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("long timeAfterRequest;");
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
    _builder.append("private Response when() throws Exception {");
    _builder.newLine();
    _builder.append("\t\t");
    this.resetIndex();
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("String uuid = ");
    {
      String _uuid = it.getWhenBlock().getDataDefinition().getUuid();
      boolean _tripleNotEquals = (_uuid != null);
      if (_tripleNotEquals) {
        _builder.append("\"");
        CharSequence _valueFromString = this._attributeExtension.valueFromString(it.getWhenBlock().getDataDefinition().getUuid());
        _builder.append(_valueFromString, "\t\t");
        _builder.append("\"");
      } else {
        _builder.append("this.randomUUID()");
      }
    }
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    CharSequence _generatePrepare = this.generatePrepare(it.getWhenBlock());
    _builder.append(_generatePrepare, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    CharSequence _generateDataCreation = this.generateDataCreation(it.getWhenBlock(), java);
    _builder.append(_generateDataCreation, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("long timeBeforeRequest = System.currentTimeMillis();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Response response = ");
    CharSequence _generateActionCalls = this.generateActionCalls(it.getWhenBlock(), java);
    _builder.append(_generateActionCalls, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("long timeAfterRequest = System.currentTimeMillis();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("LOG.info(\"WHEN: ");
    String _name_3 = it.getWhenBlock().getAction().getName();
    _builder.append(_name_3, "\t\t");
    _builder.append(" finished in {} ms\", (timeAfterRequest-timeBeforeRequest));");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("addToMetrics(\"");
    String _name_4 = it.getWhenBlock().getAction().getName();
    _builder.append(_name_4, "\t\t");
    _builder.append("\", (timeAfterRequest-timeBeforeRequest));");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("return response;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private ");
    {
      int _size = it.getWhenBlock().getAction().getResponse().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        EObject _eContainer = it.getWhenBlock().getAction().eContainer();
        String _responseDataNameWithPackage = this._aceExtension.responseDataNameWithPackage(it.getWhenBlock().getAction(), ((HttpServer) _eContainer));
        _builder.append(_responseDataNameWithPackage, "\t");
      } else {
        _builder.append("void");
      }
    }
    _builder.append(" then(Response response) throws Exception {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("if (response.getStatus() == 500) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("String message = response.readEntity(String.class);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("assertFail(message);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    {
      int _statusCode = it.getThenBlock().getStatusCode();
      boolean _tripleNotEquals_1 = (_statusCode != 0);
      if (_tripleNotEquals_1) {
        _builder.append("\t\t");
        _builder.append("if (response.getStatus() != ");
        int _statusCode_1 = it.getThenBlock().getStatusCode();
        _builder.append(_statusCode_1, "\t\t");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("String message = response.readEntity(String.class);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("assertFail(message);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("} else {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("LOG.info(\"THEN: status ");
        int _statusCode_2 = it.getThenBlock().getStatusCode();
        _builder.append(_statusCode_2, "\t\t\t");
        _builder.append(" passed\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    {
      int _size_1 = it.getWhenBlock().getAction().getResponse().size();
      boolean _greaterThan_1 = (_size_1 > 0);
      if (_greaterThan_1) {
        _builder.append("\t\t\t\t");
        EObject _eContainer_1 = it.getWhenBlock().getAction().eContainer();
        String _responseDataNameWithPackage_1 = this._aceExtension.responseDataNameWithPackage(it.getWhenBlock().getAction(), ((HttpServer) _eContainer_1));
        _builder.append(_responseDataNameWithPackage_1, "\t\t\t\t");
        _builder.append(" actual = null;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t\t");
        _builder.append("if (response.getStatus() < 400) {");
        _builder.newLine();
        _builder.append("\t\t\t\t\t");
        _builder.append("try {");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t");
        _builder.append("actual = response.readEntity(");
        EObject _eContainer_2 = it.getWhenBlock().getAction().eContainer();
        String _responseDataNameWithPackage_2 = this._aceExtension.responseDataNameWithPackage(it.getWhenBlock().getAction(), ((HttpServer) _eContainer_2));
        _builder.append(_responseDataNameWithPackage_2, "\t\t\t\t\t\t");
        _builder.append(".class);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t\t\t\t");
        _builder.newLine();
        {
          int _size_2 = it.getWhenBlock().getExtractions().size();
          boolean _greaterThan_2 = (_size_2 > 0);
          if (_greaterThan_2) {
            _builder.append("\t\t\t\t\t\t");
            _builder.append("try {");
            _builder.newLine();
            {
              EList<Extraction> _extractions = it.getWhenBlock().getExtractions();
              for(final Extraction extraction : _extractions) {
                _builder.append("\t\t\t\t\t\t");
                _builder.append("\t");
                _builder.newLine();
                _builder.append("\t\t\t\t\t\t");
                _builder.append("\t");
                _builder.append("Object ");
                String _name_5 = extraction.getName();
                _builder.append(_name_5, "\t\t\t\t\t\t\t");
                _builder.append(" = this.extract");
                String _firstUpper = StringExtensions.toFirstUpper(extraction.getName());
                _builder.append(_firstUpper, "\t\t\t\t\t\t\t");
                _builder.append("(actual);");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t\t\t\t");
                _builder.append("\t");
                _builder.append("extractedValues.put(\"");
                String _name_6 = extraction.getName();
                _builder.append(_name_6, "\t\t\t\t\t\t\t");
                _builder.append("\", ");
                String _name_7 = extraction.getName();
                _builder.append(_name_7, "\t\t\t\t\t\t\t");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t\t\t\t");
                _builder.append("\t");
                _builder.append("LOG.info(\"THEN: extracted \" + ");
                String _name_8 = extraction.getName();
                _builder.append(_name_8, "\t\t\t\t\t\t\t");
                _builder.append(".toString()  + \" as ");
                String _name_9 = extraction.getName();
                _builder.append(_name_9, "\t\t\t\t\t\t\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t\t\t\t\t\t");
            _builder.append("} catch (Exception x) {");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t");
            _builder.append("\t");
            _builder.append("LOG.info(\"THEN: failed to extract values from response \", x);");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("\t\t\t\t\t");
        _builder.append("} catch (Exception x) {");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t");
        _builder.append("LOG.error(\"THEN: failed to read response\", x);");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t");
        _builder.append("assertFail(x.getMessage());");
        _builder.newLine();
        _builder.append("\t\t\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        {
          DataDefinition _response = it.getThenBlock().getResponse();
          boolean _tripleNotEquals_2 = (_response != null);
          if (_tripleNotEquals_2) {
            _builder.append("\t\t\t\t\t");
            String _dataNameWithPackage = this._modelExtension.dataNameWithPackage(it.getWhenBlock().getAction().getModel());
            _builder.append(_dataNameWithPackage, "\t\t\t\t\t");
            _builder.append(" expectedData = ");
            CharSequence _objectMapperCallExpectedData = this.objectMapperCallExpectedData(it.getThenBlock().getResponse(), it.getWhenBlock().getAction().getModel());
            _builder.append(_objectMapperCallExpectedData, "\t\t\t\t\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t\t\t");
            _builder.newLine();
            _builder.append("\t\t\t\t\t");
            EObject _eContainer_3 = it.getWhenBlock().getAction().eContainer();
            String _responseDataNameWithPackage_3 = this._aceExtension.responseDataNameWithPackage(it.getWhenBlock().getAction(), ((HttpServer) _eContainer_3));
            _builder.append(_responseDataNameWithPackage_3, "\t\t\t\t\t");
            _builder.append(" expected = new ");
            EObject _eContainer_4 = it.getWhenBlock().getAction().eContainer();
            String _responseDataNameWithPackage_4 = this._aceExtension.responseDataNameWithPackage(it.getWhenBlock().getAction(), ((HttpServer) _eContainer_4));
            _builder.append(_responseDataNameWithPackage_4, "\t\t\t\t\t");
            _builder.append("(expectedData);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t\t\t");
            _builder.newLine();
            _builder.append("\t\t\t\t\t");
            _builder.append("assertThat(actual, expected);");
            _builder.newLine();
            _builder.append("\t\t\t\t\t");
            _builder.newLine();
            _builder.append("\t\t\t\t\t");
            _builder.append("LOG.info(\"THEN: response passed\");");
            _builder.newLine();
          }
        }
        _builder.append("\t\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("return actual;");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
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
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (prerequisite(\"");
    String _name_10 = it.getName();
    _builder.append(_name_10, "\t\t");
    _builder.append("\")) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("Response response = when();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    {
      int _size_3 = it.getWhenBlock().getAction().getResponse().size();
      boolean _greaterThan_3 = (_size_3 > 0);
      if (_greaterThan_3) {
        EObject _eContainer_5 = it.getWhenBlock().getAction().eContainer();
        String _responseDataNameWithPackage_5 = this._aceExtension.responseDataNameWithPackage(it.getWhenBlock().getAction(), ((HttpServer) _eContainer_5));
        _builder.append(_responseDataNameWithPackage_5, "\t\t\t");
        _builder.append(" actualResponse = ");
      }
    }
    _builder.append("then(response);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.newLine();
    {
      EList<PersistenceVerification> _persistenceVerifications = it.getThenBlock().getPersistenceVerifications();
      for(final PersistenceVerification persistenceVerification : _persistenceVerifications) {
        _builder.append("\t\t\t");
        _builder.append("this.");
        String _name_11 = persistenceVerification.getName();
        _builder.append(_name_11, "\t\t\t");
        _builder.append("();");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      EList<Verification> _verifications = it.getThenBlock().getVerifications();
      for(final Verification verification : _verifications) {
        _builder.append("\t\t\t");
        String _name_12 = verification.getName();
        _builder.append(_name_12, "\t\t\t");
        _builder.append("(actualResponse);");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("LOG.info(\"WHEN: prerequisite for ");
    String _name_13 = it.getName();
    _builder.append(_name_13, "\t\t\t");
    _builder.append(" not met\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<Verification> _verifications_1 = it.getThenBlock().getVerifications();
      for(final Verification verification_1 : _verifications_1) {
        _builder.append("\t");
        _builder.append("protected abstract void ");
        String _name_14 = verification_1.getName();
        _builder.append(_name_14, "\t");
        _builder.append("(");
        EObject _eContainer_6 = it.getWhenBlock().getAction().eContainer();
        String _responseDataNameWithPackage_6 = this._aceExtension.responseDataNameWithPackage(it.getWhenBlock().getAction(), ((HttpServer) _eContainer_6));
        _builder.append(_responseDataNameWithPackage_6, "\t");
        _builder.append(" response);");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      EList<PersistenceVerification> _persistenceVerifications_1 = it.getThenBlock().getPersistenceVerifications();
      for(final PersistenceVerification persistenceVerification_1 : _persistenceVerifications_1) {
        _builder.append("\t");
        _builder.append("private void ");
        String _name_15 = persistenceVerification_1.getName();
        _builder.append(_name_15, "\t");
        _builder.append("() throws Exception {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        CharSequence _persistenceVerification = this.persistenceVerification(persistenceVerification_1.getExpression(), persistenceVerification_1.getModel());
        _builder.append(_persistenceVerification, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("LOG.info(\"THEN: ");
        String _name_16 = persistenceVerification_1.getName();
        _builder.append(_name_16, "\t\t");
        _builder.append(" passed\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
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
    String _name_17 = it.getName();
    _builder.append(_name_17, "\t\t");
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
    _builder.append("this.");
    String _customCallName = it.getCustomCallName();
    _builder.append(_customCallName);
    _builder.append("(");
    {
      EList<PrimitiveValue> _values = it.getValues();
      boolean _hasElements = false;
      for(final PrimitiveValue value : _values) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        Object _primitiveValueFrom = this._attributeExtension.primitiveValueFrom(value);
        _builder.append(_primitiveValueFrom);
      }
    }
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence givenBlock(final GivenRef givenRef, final HttpServer java, final boolean forLoop) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (prerequisite(\"");
    String _name = givenRef.getScenario().getName();
    _builder.append(_name);
    _builder.append("\")) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("uuid = ");
    {
      String _uuid = givenRef.getScenario().getWhenBlock().getDataDefinition().getUuid();
      boolean _tripleNotEquals = (_uuid != null);
      if (_tripleNotEquals) {
        _builder.append("\"");
        CharSequence _valueFromString = this._attributeExtension.valueFromString(givenRef.getScenario().getWhenBlock().getDataDefinition().getUuid());
        _builder.append(_valueFromString, "\t");
        _builder.append("\"");
      } else {
        _builder.append("this.randomUUID()");
      }
    }
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _generatePrepare = this.generatePrepare(givenRef.getScenario().getWhenBlock());
    _builder.append(_generatePrepare, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _generateDataCreation = this.generateDataCreation(givenRef.getScenario().getWhenBlock(), java);
    _builder.append(_generateDataCreation, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("timeBeforeRequest = System.currentTimeMillis();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("response = ");
    CharSequence _generateActionCalls = this.generateActionCalls(givenRef.getScenario().getWhenBlock(), java);
    _builder.append(_generateActionCalls, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("timeAfterRequest = System.currentTimeMillis();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (response.getStatus() >= 400) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String message = \"GIVEN ");
    String _name_1 = givenRef.getScenario().getName();
    _builder.append(_name_1, "\t\t");
    _builder.append(" fails\\n\" + response.readEntity(String.class);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("LOG.info(\"GIVEN: ");
    String _name_2 = givenRef.getScenario().getName();
    _builder.append(_name_2, "\t\t");
    _builder.append(" fails due to {} in {} ms\", message, (timeAfterRequest-timeBeforeRequest));");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("addToMetrics(\"");
    String _name_3 = givenRef.getScenario().getWhenBlock().getAction().getName();
    _builder.append(_name_3, "\t\t");
    _builder.append("\", (timeAfterRequest-timeBeforeRequest));");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("assertFail(message);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("LOG.info(\"GIVEN: ");
    String _name_4 = givenRef.getScenario().getName();
    _builder.append(_name_4, "\t");
    _builder.append(" success in {} ms\", (timeAfterRequest-timeBeforeRequest));");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("addToMetrics(\"");
    String _name_5 = givenRef.getScenario().getWhenBlock().getAction().getName();
    _builder.append(_name_5, "\t");
    _builder.append("\", (timeAfterRequest-timeBeforeRequest));");
    _builder.newLineIfNotEmpty();
    {
      if (((givenRef.getScenario().getWhenBlock().getExtractions().size() > 0) && (givenRef.getScenario().getWhenBlock().getAction().getResponse().size() > 0))) {
        _builder.append("\t");
        EObject _eContainer = givenRef.getScenario().getWhenBlock().getAction().eContainer();
        String _responseDataNameWithPackage = this._aceExtension.responseDataNameWithPackage(givenRef.getScenario().getWhenBlock().getAction(), ((HttpServer) _eContainer));
        _builder.append(_responseDataNameWithPackage, "\t");
        _builder.append(" responseEntity_");
        _builder.append(this.index, "\t");
        _builder.append(" = null;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("try {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("responseEntity_");
        _builder.append(this.index, "\t\t");
        _builder.append(" = response.readEntity(");
        EObject _eContainer_1 = givenRef.getScenario().getWhenBlock().getAction().eContainer();
        String _responseDataNameWithPackage_1 = this._aceExtension.responseDataNameWithPackage(givenRef.getScenario().getWhenBlock().getAction(), ((HttpServer) _eContainer_1));
        _builder.append(_responseDataNameWithPackage_1, "\t\t");
        _builder.append(".class);");
        _builder.newLineIfNotEmpty();
        {
          EList<Extraction> _extractions = givenRef.getScenario().getWhenBlock().getExtractions();
          for(final Extraction extraction : _extractions) {
            _builder.append("\t");
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("Object ");
            String _name_6 = extraction.getName();
            _builder.append(_name_6, "\t\t");
            _builder.append(" = this.extract");
            String _firstUpper = StringExtensions.toFirstUpper(extraction.getName());
            _builder.append(_firstUpper, "\t\t");
            _builder.append("(responseEntity_");
            _builder.append(this.index, "\t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("extractedValues.put(\"");
            String _name_7 = extraction.getName();
            _builder.append(_name_7, "\t\t");
            {
              if (forLoop) {
                _builder.append("_\" + i");
              } else {
                _builder.append("\"");
              }
            }
            _builder.append(", ");
            String _name_8 = extraction.getName();
            _builder.append(_name_8, "\t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("LOG.info(\"GIVEN: extracted \" + ");
            String _name_9 = extraction.getName();
            _builder.append(_name_9, "\t\t");
            _builder.append(".toString()  + \" as ");
            String _name_10 = extraction.getName();
            _builder.append(_name_10, "\t\t");
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
        _builder.append("LOG.info(\"GIVEN: failed to extract values from response \", x);");
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
    String _name_11 = givenRef.getScenario().getName();
    _builder.append(_name_11, "\t");
    _builder.append(" not met\");");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence _persistenceVerification(final SelectByUniqueAttribute it, final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    String _interfaceWithPackage = this._modelExtension.interfaceWithPackage(model);
    _builder.append(_interfaceWithPackage);
    _builder.append(" actual = daoProvider.get");
    String _modelDao = this._modelExtension.modelDao(model);
    _builder.append(_modelDao);
    _builder.append("().selectBy");
    String _firstUpper = StringExtensions.toFirstUpper(it.getAttributeAndValue().getAttribute().getName());
    _builder.append(_firstUpper);
    _builder.append("(handle, ");
    Object _primitiveValueFrom = this._attributeExtension.primitiveValueFrom(it.getAttributeAndValue().getValue());
    _builder.append(_primitiveValueFrom);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      JsonObject _object = it.getExpected().getObject();
      boolean _tripleNotEquals = (_object != null);
      if (_tripleNotEquals) {
        String _interfaceWithPackage_1 = this._modelExtension.interfaceWithPackage(model);
        _builder.append(_interfaceWithPackage_1);
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
    String _interfaceWithPackage = this._modelExtension.interfaceWithPackage(model);
    _builder.append(_interfaceWithPackage);
    _builder.append(" actual = daoProvider.get");
    String _modelDao = this._modelExtension.modelDao(model);
    _builder.append(_modelDao);
    _builder.append("().selectByPrimaryKey(handle, ");
    {
      List<Attribute> _allPrimaryKeyAttributes = this._modelExtension.allPrimaryKeyAttributes(model);
      boolean _hasElements = false;
      for(final Attribute attribute : _allPrimaryKeyAttributes) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        Object _primitiveValueFrom = this._attributeExtension.primitiveValueFrom(this.findForPrimaryKey(attribute, it.getAttributeAndValues()).getValue());
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
        String _interfaceWithPackage_1 = this._modelExtension.interfaceWithPackage(model);
        _builder.append(_interfaceWithPackage_1);
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
        Object _primitiveValueFrom = this._attributeExtension.primitiveValueFrom(attributeValue.getValue());
        _builder.append(_primitiveValueFrom);
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("int actual = daoProvider.get");
    String _modelDao = this._modelExtension.modelDao(model);
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
        _builder.append("this.callNotReplayableDataProviderPutSystemTime(uuid, LocalDateTime.parse(\"");
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
      if ((((it.getDataDefinition() != null) && (it.getDataDefinition().getData() != null)) && (it.getDataDefinition().getData().getMembers() != null))) {
        {
          EList<JsonMember> _members = it.getDataDefinition().getData().getMembers();
          for(final JsonMember attributeDefinition : _members) {
            {
              boolean _isNotReplayable = attributeDefinition.getAttribute().isNotReplayable();
              if (_isNotReplayable) {
                _builder.append("this.callNotReplayableDataProviderPutValue(uuid, \"");
                String _name = attributeDefinition.getAttribute().getName();
                _builder.append(_name);
                _builder.append("\", ");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("objectMapper.readValue(\"");
                CharSequence _valueFrom = this._attributeExtension.valueFrom(attributeDefinition.getValue());
                _builder.append(_valueFrom, "\t\t\t");
                _builder.append("\", ");
                {
                  Model _model = attributeDefinition.getAttribute().getModel();
                  boolean _tripleNotEquals_1 = (_model != null);
                  if (_tripleNotEquals_1) {
                    _builder.append(" ");
                    String _dataNameWithPackage = this._modelExtension.dataNameWithPackage(attributeDefinition.getAttribute().getModel());
                    _builder.append(_dataNameWithPackage, "\t\t\t");
                    _builder.append(".class)");
                  } else {
                    String _type = attributeDefinition.getAttribute().getType();
                    boolean _tripleNotEquals_2 = (_type != null);
                    if (_tripleNotEquals_2) {
                      _builder.append(" ");
                      String _javaType = this._attributeExtension.javaType(attributeDefinition.getAttribute());
                      _builder.append(_javaType, "\t\t\t");
                      _builder.append(".class)");
                    }
                  }
                }
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
  
  private CharSequence generateDataCreation(final WhenBlock it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    {
      int _size = it.getAction().getPayload().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        String _payloadDataNameWithPackage = this._aceExtension.payloadDataNameWithPackage(it.getAction(), java);
        _builder.append(_payloadDataNameWithPackage);
        _builder.append(" payload_");
        _builder.append(this.index);
        _builder.append(" = ");
        CharSequence _objectMapperCallPayload = this.objectMapperCallPayload(it.getDataDefinition(), it.getAction(), java);
        _builder.append(_objectMapperCallPayload);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    String _dataNameWithPackage = this._modelExtension.dataNameWithPackage(it.getAction().getModel());
    _builder.append(_dataNameWithPackage);
    _builder.append(" data_");
    _builder.append(this.index);
    _builder.append(" = ");
    CharSequence _objectMapperCall = this.objectMapperCall(it.getDataDefinition(), it.getAction().getModel());
    _builder.append(_objectMapperCall);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence objectMapperCall(final DataDefinition it, final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("objectMapper.readValue(\"");
    {
      if (((it.getData() != null) && (it.getData().getMembers() != null))) {
        _builder.append("{\" +");
        _builder.newLineIfNotEmpty();
        _builder.append("\"\\\"uuid\\\" : \\\"\" + uuid + \"\\\"");
        {
          final Function1<JsonMember, Boolean> _function = (JsonMember it_1) -> {
            boolean _isNotReplayable = it_1.getAttribute().isNotReplayable();
            return Boolean.valueOf((!_isNotReplayable));
          };
          Iterable<JsonMember> _filter = IterableExtensions.<JsonMember>filter(it.getData().getMembers(), _function);
          boolean _hasElements = false;
          for(final JsonMember member : _filter) {
            if (!_hasElements) {
              _hasElements = true;
              _builder.append(this._attributeExtension.stringLineBreak);
            } else {
              _builder.appendImmediate(this._attributeExtension.stringLineBreak, "");
            }
            _builder.append("\\\"");
            String _name = member.getAttribute().getName();
            _builder.append(_name);
            _builder.append("\\\" : ");
            CharSequence _valueFrom = this._attributeExtension.valueFrom(member.getValue());
            _builder.append(_valueFrom);
          }
        }
        _builder.append("} ");
      } else {
        _builder.append("{ \\\"uuid\\\" : \\\"\" + uuid + \"\\\"}");
      }
    }
    _builder.append("\",");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    String _dataNameWithPackage = this._modelExtension.dataNameWithPackage(model);
    _builder.append(_dataNameWithPackage, "\t\t");
    _builder.append(".class)");
    return _builder;
  }
  
  private CharSequence objectMapperCallPayload(final DataDefinition it, final HttpServerAce action, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("objectMapper.readValue(\"");
    {
      if (((it.getData() != null) && (it.getData().getMembers() != null))) {
        _builder.append("{\" +");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        {
          final Function1<JsonMember, Boolean> _function = (JsonMember it_1) -> {
            boolean _isNotReplayable = it_1.getAttribute().isNotReplayable();
            return Boolean.valueOf((!_isNotReplayable));
          };
          Iterable<JsonMember> _filter = IterableExtensions.<JsonMember>filter(it.getData().getMembers(), _function);
          boolean _hasElements = false;
          for(final JsonMember member : _filter) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(this._attributeExtension.stringLineBreak, "\t");
            }
            _builder.append("\"\\\"");
            String _name = member.getAttribute().getName();
            _builder.append(_name, "\t");
            _builder.append("\\\" : ");
            CharSequence _valueFrom = this._attributeExtension.valueFrom(member.getValue());
            _builder.append(_valueFrom, "\t");
          }
        }
        _builder.append("} ");
      } else {
        _builder.append("{ \\\"uuid\\\" : \\\"\" + uuid + \"\\\"}");
      }
    }
    _builder.append("\",");
    _builder.newLineIfNotEmpty();
    String _payloadDataNameWithPackage = this._aceExtension.payloadDataNameWithPackage(action, java);
    _builder.append(_payloadDataNameWithPackage);
    _builder.append(".class)");
    return _builder;
  }
  
  private CharSequence objectMapperCallExpectedData(final DataDefinition it, final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("objectMapper.readValue(\"");
    {
      if (((it.getData() != null) && (it.getData().getMembers() != null))) {
        _builder.append("{\" +");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\"\\\"uuid\\\" : \\\"");
        String _uuid = it.getUuid();
        _builder.append(_uuid, "\t");
        _builder.append("\\\"");
        {
          final Function1<JsonMember, Boolean> _function = (JsonMember it_1) -> {
            boolean _isNotReplayable = it_1.getAttribute().isNotReplayable();
            return Boolean.valueOf((!_isNotReplayable));
          };
          Iterable<JsonMember> _filter = IterableExtensions.<JsonMember>filter(it.getData().getMembers(), _function);
          boolean _hasElements = false;
          for(final JsonMember member : _filter) {
            if (!_hasElements) {
              _hasElements = true;
              _builder.append(this._attributeExtension.stringLineBreak, "\t");
            } else {
              _builder.appendImmediate(this._attributeExtension.stringLineBreak, "\t");
            }
            _builder.append("\\\"");
            String _name = member.getAttribute().getName();
            _builder.append(_name, "\t");
            _builder.append("\\\" : ");
            CharSequence _valueFrom = this._attributeExtension.valueFrom(member.getValue());
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
    String _dataNameWithPackage = this._modelExtension.dataNameWithPackage(model);
    _builder.append(_dataNameWithPackage);
    _builder.append(".class)");
    return _builder;
  }
  
  private CharSequence objectMapperCallExpectedPersistenceData(final JsonObject it, final Model model) {
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
              _builder.appendImmediate(this._attributeExtension.stringLineBreak, "\t");
            }
            _builder.append("\\\"");
            String _name = member.getAttribute().getName();
            _builder.append(_name, "\t");
            _builder.append("\\\" : ");
            CharSequence _valueFrom = this._attributeExtension.valueFrom(member.getValue());
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
    String _modelClassNameWithPackage = this._modelExtension.modelClassNameWithPackage(model);
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
        String _urlWithPathParams = this._aceExtension.urlWithPathParams(_action, _builder_1.toString(), false);
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
        _builder.append("uuid");
        _builder.newLine();
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
          String _urlWithPathParams_1 = this._aceExtension.urlWithPathParams(_action_1, _builder_2.toString(), true);
          _builder.append(_urlWithPathParams_1, "\t");
          _builder.append("\", ");
          _builder.newLineIfNotEmpty();
          _builder.append(" \t");
          {
            int _size_1 = it.getAction().getPayload().size();
            boolean _greaterThan_1 = (_size_1 > 0);
            if (_greaterThan_1) {
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
          _builder.append("uuid");
          _builder.newLine();
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
            String _urlWithPathParams_2 = this._aceExtension.urlWithPathParams(_action_2, _builder_3.toString(), true);
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
            _builder.append("uuid");
            _builder.newLine();
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
            String _urlWithPathParams_3 = this._aceExtension.urlWithPathParams(_action_3, _builder_4.toString(), true);
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
            _builder.append("uuid");
            _builder.newLine();
            _builder.append(");");
            _builder.newLine();
          }
        }
      }
    }
    _builder.newLine();
    return _builder;
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
}
