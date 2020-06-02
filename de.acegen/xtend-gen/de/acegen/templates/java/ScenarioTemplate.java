package de.acegen.templates.java;

import com.google.common.base.Objects;
import de.acegen.aceGen.Authorization;
import de.acegen.aceGen.DataDefinition;
import de.acegen.aceGen.GivenRef;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.JsonMember;
import de.acegen.aceGen.JsonObject;
import de.acegen.aceGen.Model;
import de.acegen.aceGen.PersistenceVerification;
import de.acegen.aceGen.Scenario;
import de.acegen.aceGen.WhenBlock;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.java.AceExtension;
import de.acegen.extensions.java.AttributeExtension;
import de.acegen.extensions.java.ModelExtension;
import java.util.ArrayList;
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
  
  private int index;
  
  private void resetIndex() {
    this.index = 0;
  }
  
  private void incIndex() {
    int _index = this.index;
    this.index = (_index + 1);
  }
  
  public CharSequence generateScenario(final Scenario it, final HttpServer java) {
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
    _builder.append("protected void verifications(");
    {
      boolean _isRead = this._aceExtension.isRead(it.getWhenBlock().getAction());
      if (_isRead) {
        EObject _eContainer = it.getWhenBlock().getAction().eContainer();
        String _responseDataNameWithPackage = this._aceExtension.responseDataNameWithPackage(it.getWhenBlock().getAction(), ((HttpServer) _eContainer));
        _builder.append(_responseDataNameWithPackage, "\t");
        _builder.append(" response ");
      }
    }
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<String> _verifications = it.getThenBlock().getVerifications();
      for(final String verification : _verifications) {
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected void ");
        _builder.append(verification, "\t");
        _builder.append("(");
        {
          boolean _isRead_1 = this._aceExtension.isRead(it.getWhenBlock().getAction());
          if (_isRead_1) {
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
        _builder.append(verification, "\t\t");
        _builder.append(" not implemented\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("LOG.info(\"THEN: ");
        _builder.append(verification, "\t\t");
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
    _builder.append("import java.util.Arrays;");
    _builder.newLine();
    _builder.append("import java.util.List;");
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
    _builder.append("private void given() throws Exception {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Response response;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String uuid;");
    _builder.newLine();
    _builder.append("\t\t");
    this.resetIndex();
    _builder.newLineIfNotEmpty();
    {
      ArrayList<GivenRef> _allGivenRefs = this.allGivenRefs(it);
      for(final GivenRef givenRef : _allGivenRefs) {
        {
          int _times = givenRef.getTimes();
          boolean _greaterThan = (_times > 0);
          if (_greaterThan) {
            _builder.append("\t\t");
            _builder.append("for (int i=0; i<");
            int _times_1 = givenRef.getTimes();
            _builder.append(_times_1, "\t\t");
            _builder.append("; i++) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("if (prerequisite(\"");
            String _name_3 = givenRef.getScenario().getName();
            _builder.append(_name_3, "\t\t\t");
            _builder.append("\")) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("uuid = ");
            {
              String _uuid = givenRef.getScenario().getWhenBlock().getDataDefinition().getUuid();
              boolean _tripleNotEquals = (_uuid != null);
              if (_tripleNotEquals) {
                _builder.append("\"");
                String _uuid_1 = givenRef.getScenario().getWhenBlock().getDataDefinition().getUuid();
                _builder.append(_uuid_1, "\t\t\t\t");
                _builder.append("\".replace(\"${testId}\", this.getTestId())");
              } else {
                _builder.append("this.randomUUID()");
              }
            }
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t");
            CharSequence _generatePrepare = this.generatePrepare(givenRef.getScenario().getWhenBlock());
            _builder.append(_generatePrepare, "\t\t\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t");
            CharSequence _generateDataCreation = this.generateDataCreation(givenRef.getScenario().getWhenBlock());
            _builder.append(_generateDataCreation, "\t\t\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("response = ");
            CharSequence _generateActionCall = this.generateActionCall(givenRef.getScenario().getWhenBlock(), java, false);
            _builder.append(_generateActionCall, "\t\t\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("if (response.getStatus() >= 400) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t");
            _builder.append("String message = \"GIVEN ");
            String _name_4 = givenRef.getScenario().getName();
            _builder.append(_name_4, "\t\t\t\t\t");
            _builder.append(" fails\\n\" + response.readEntity(String.class);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t\t");
            _builder.append("LOG.info(\"GIVEN: ");
            String _name_5 = givenRef.getScenario().getName();
            _builder.append(_name_5, "\t\t\t\t\t");
            _builder.append(" fails due to \" + message);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t\t");
            _builder.append("assertFail(message);");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("LOG.info(\"GIVEN: ");
            String _name_6 = givenRef.getScenario().getName();
            _builder.append(_name_6, "\t\t\t\t");
            _builder.append(" success\");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("} else {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("LOG.info(\"GIVEN: prerequisite for ");
            String _name_7 = givenRef.getScenario().getName();
            _builder.append(_name_7, "\t\t\t\t");
            _builder.append(" not met\");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            this.incIndex();
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.newLine();
          } else {
            _builder.append("\t\t");
            this.incIndex();
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("if (prerequisite(\"");
            String _name_8 = givenRef.getScenario().getName();
            _builder.append(_name_8, "\t\t");
            _builder.append("\")) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("uuid = ");
            {
              String _uuid_2 = givenRef.getScenario().getWhenBlock().getDataDefinition().getUuid();
              boolean _tripleNotEquals_1 = (_uuid_2 != null);
              if (_tripleNotEquals_1) {
                _builder.append("\"");
                String _uuid_3 = givenRef.getScenario().getWhenBlock().getDataDefinition().getUuid();
                _builder.append(_uuid_3, "\t\t\t");
                _builder.append("\".replace(\"${testId}\", this.getTestId())");
              } else {
                _builder.append("this.randomUUID()");
              }
            }
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            CharSequence _generatePrepare_1 = this.generatePrepare(givenRef.getScenario().getWhenBlock());
            _builder.append(_generatePrepare_1, "\t\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            CharSequence _generateDataCreation_1 = this.generateDataCreation(givenRef.getScenario().getWhenBlock());
            _builder.append(_generateDataCreation_1, "\t\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("response = ");
            CharSequence _generateActionCall_1 = this.generateActionCall(givenRef.getScenario().getWhenBlock(), java, false);
            _builder.append(_generateActionCall_1, "\t\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("if (response.getStatus() >= 400) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("String message = \"GIVEN ");
            String _name_9 = givenRef.getScenario().getName();
            _builder.append(_name_9, "\t\t\t\t");
            _builder.append(" fails\\n\" + response.readEntity(String.class);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("LOG.info(\"GIVEN: ");
            String _name_10 = givenRef.getScenario().getName();
            _builder.append(_name_10, "\t\t\t\t");
            _builder.append(" fails due to \" + message);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("assertFail(message);");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("LOG.info(\"GIVEN: ");
            String _name_11 = givenRef.getScenario().getName();
            _builder.append(_name_11, "\t\t\t");
            _builder.append(" success\");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("} else {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("LOG.info(\"GIVEN: prerequisite for ");
            String _name_12 = givenRef.getScenario().getName();
            _builder.append(_name_12, "\t\t\t");
            _builder.append(" not met\");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.newLine();
          }
        }
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
      String _uuid_4 = it.getWhenBlock().getDataDefinition().getUuid();
      boolean _tripleNotEquals_2 = (_uuid_4 != null);
      if (_tripleNotEquals_2) {
        _builder.append("\"");
        String _uuid_5 = it.getWhenBlock().getDataDefinition().getUuid();
        _builder.append(_uuid_5, "\t\t");
        _builder.append("\".replace(\"${testId}\", this.getTestId())");
      } else {
        _builder.append("this.randomUUID()");
      }
    }
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    CharSequence _generatePrepare_2 = this.generatePrepare(it.getWhenBlock());
    _builder.append(_generatePrepare_2, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    CharSequence _generateDataCreation_2 = this.generateDataCreation(it.getWhenBlock());
    _builder.append(_generateDataCreation_2, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    CharSequence _generateActionCall_2 = this.generateActionCall(it.getWhenBlock(), java, true);
    _builder.append(_generateActionCall_2, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private ");
    {
      boolean _isRead = this._aceExtension.isRead(it.getWhenBlock().getAction());
      if (_isRead) {
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
      boolean _tripleNotEquals_3 = (_statusCode != 0);
      if (_tripleNotEquals_3) {
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
      boolean _isRead_1 = this._aceExtension.isRead(it.getWhenBlock().getAction());
      if (_isRead_1) {
        _builder.append("\t\t");
        EObject _eContainer_1 = it.getWhenBlock().getAction().eContainer();
        String _responseDataNameWithPackage_1 = this._aceExtension.responseDataNameWithPackage(it.getWhenBlock().getAction(), ((HttpServer) _eContainer_1));
        _builder.append(_responseDataNameWithPackage_1, "\t\t");
        _builder.append(" actual = null;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("try {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("actual = response.readEntity(");
        EObject _eContainer_2 = it.getWhenBlock().getAction().eContainer();
        String _responseDataNameWithPackage_2 = this._aceExtension.responseDataNameWithPackage(it.getWhenBlock().getAction(), ((HttpServer) _eContainer_2));
        _builder.append(_responseDataNameWithPackage_2, "\t\t\t");
        _builder.append(".class);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("} catch (Exception x) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    {
      DataDefinition _response = it.getThenBlock().getResponse();
      boolean _tripleNotEquals_4 = (_response != null);
      if (_tripleNotEquals_4) {
        _builder.append("\t\t");
        String _dataNameWithPackage = this._modelExtension.dataNameWithPackage(it.getWhenBlock().getAction().getModel());
        _builder.append(_dataNameWithPackage, "\t\t");
        _builder.append(" expectedData = ");
        CharSequence _objectMapperCallExpectedData = this.objectMapperCallExpectedData(it.getThenBlock().getResponse(), it.getWhenBlock().getAction().getModel());
        _builder.append(_objectMapperCallExpectedData, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        EObject _eContainer_3 = it.getWhenBlock().getAction().eContainer();
        String _responseDataNameWithPackage_3 = this._aceExtension.responseDataNameWithPackage(it.getWhenBlock().getAction(), ((HttpServer) _eContainer_3));
        _builder.append(_responseDataNameWithPackage_3, "\t\t");
        _builder.append(" expected = new ");
        EObject _eContainer_4 = it.getWhenBlock().getAction().eContainer();
        String _responseDataNameWithPackage_4 = this._aceExtension.responseDataNameWithPackage(it.getWhenBlock().getAction(), ((HttpServer) _eContainer_4));
        _builder.append(_responseDataNameWithPackage_4, "\t\t");
        _builder.append("(expectedData);");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("assertThat(actual, expected);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("LOG.info(\"THEN: response passed\");");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    {
      boolean _isRead_2 = this._aceExtension.isRead(it.getWhenBlock().getAction());
      if (_isRead_2) {
        _builder.append("\t\t");
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
    String _name_13 = it.getName();
    _builder.append(_name_13, "\t\t");
    _builder.append("\")) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("Response response = when();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("LOG.info(\"WHEN: ");
    String _name_14 = it.getWhenBlock().getAction().getName();
    _builder.append(_name_14, "\t\t\t");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    {
      boolean _isRead_3 = this._aceExtension.isRead(it.getWhenBlock().getAction());
      if (_isRead_3) {
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
        String _name_15 = persistenceVerification.getName();
        _builder.append(_name_15, "\t\t\t");
        _builder.append("();");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("verifications(");
    {
      boolean _isRead_4 = this._aceExtension.isRead(it.getWhenBlock().getAction());
      if (_isRead_4) {
        _builder.append("actualResponse");
      }
    }
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    {
      EList<String> _verifications = it.getThenBlock().getVerifications();
      for(final String verification : _verifications) {
        _builder.append("\t\t\t");
        _builder.append(verification, "\t\t\t");
        _builder.append("(");
        {
          boolean _isRead_5 = this._aceExtension.isRead(it.getWhenBlock().getAction());
          if (_isRead_5) {
            _builder.append("actualResponse");
          }
        }
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("LOG.info(\"WHEN: prerequisite for ");
    String _name_16 = it.getName();
    _builder.append(_name_16, "\t\t\t");
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
    _builder.append("\t");
    _builder.append("protected abstract void verifications(");
    {
      boolean _isRead_6 = this._aceExtension.isRead(it.getWhenBlock().getAction());
      if (_isRead_6) {
        EObject _eContainer_6 = it.getWhenBlock().getAction().eContainer();
        String _responseDataNameWithPackage_6 = this._aceExtension.responseDataNameWithPackage(it.getWhenBlock().getAction(), ((HttpServer) _eContainer_6));
        _builder.append(_responseDataNameWithPackage_6, "\t");
        _builder.append(" response");
      }
    }
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<String> _verifications_1 = it.getThenBlock().getVerifications();
      for(final String verification_1 : _verifications_1) {
        _builder.append("\t");
        _builder.append("protected abstract void ");
        _builder.append(verification_1, "\t");
        _builder.append("(");
        {
          boolean _isRead_7 = this._aceExtension.isRead(it.getWhenBlock().getAction());
          if (_isRead_7) {
            EObject _eContainer_7 = it.getWhenBlock().getAction().eContainer();
            String _responseDataNameWithPackage_7 = this._aceExtension.responseDataNameWithPackage(it.getWhenBlock().getAction(), ((HttpServer) _eContainer_7));
            _builder.append(_responseDataNameWithPackage_7, "\t");
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
      EList<PersistenceVerification> _persistenceVerifications_1 = it.getThenBlock().getPersistenceVerifications();
      for(final PersistenceVerification persistenceVerification_1 : _persistenceVerifications_1) {
        _builder.append("\t");
        _builder.append("private void ");
        String _name_17 = persistenceVerification_1.getName();
        _builder.append(_name_17, "\t");
        _builder.append("() throws Exception {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        String _interfaceWithPackage = this._modelExtension.interfaceWithPackage(persistenceVerification_1.getModel());
        _builder.append(_interfaceWithPackage, "\t\t");
        _builder.append(" actual = daoProvider.get");
        String _modelDao = this._modelExtension.modelDao(persistenceVerification_1.getModel());
        _builder.append(_modelDao, "\t\t");
        _builder.append("().selectBy");
        String _firstUpper = StringExtensions.toFirstUpper(persistenceVerification_1.getAttribute().getName());
        _builder.append(_firstUpper, "\t\t");
        _builder.append("(handle, ");
        Object _primitiveValueFrom = this._attributeExtension.primitiveValueFrom(persistenceVerification_1.getValue());
        _builder.append(_primitiveValueFrom, "\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        String _interfaceWithPackage_1 = this._modelExtension.interfaceWithPackage(persistenceVerification_1.getModel());
        _builder.append(_interfaceWithPackage_1, "\t\t");
        _builder.append(" expected = ");
        CharSequence _objectMapperCallExpectedPersistenceData = this.objectMapperCallExpectedPersistenceData(persistenceVerification_1.getExpected(), persistenceVerification_1.getModel());
        _builder.append(_objectMapperCallExpectedPersistenceData, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("assertThat(actual, expected);");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("LOG.info(\"THEN: ");
        String _name_18 = persistenceVerification_1.getName();
        _builder.append(_name_18, "\t\t");
        _builder.append(" passed\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected String scenarioName() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return \"");
    String _name_19 = it.getName();
    _builder.append(_name_19, "\t\t");
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
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
    _builder.append("\t\t\t");
    _builder.newLine();
    return _builder;
  }
  
  private ArrayList<GivenRef> allGivenRefs(final Scenario it) {
    ArrayList<GivenRef> allWhenBlocks = new ArrayList<GivenRef>();
    EList<GivenRef> _givenRefs = it.getGivenRefs();
    for (final GivenRef givenRef : _givenRefs) {
      boolean _isExcludeGiven = givenRef.isExcludeGiven();
      if (_isExcludeGiven) {
        allWhenBlocks.add(givenRef);
      } else {
        this.allGivenRefsRec(givenRef, allWhenBlocks);
      }
    }
    return allWhenBlocks;
  }
  
  private void allGivenRefsRec(final GivenRef it, final List<GivenRef> allWhenBlocks) {
    boolean _isExcludeGiven = it.isExcludeGiven();
    boolean _not = (!_isExcludeGiven);
    if (_not) {
      EList<GivenRef> _givenRefs = it.getScenario().getGivenRefs();
      for (final GivenRef scenario : _givenRefs) {
        this.allGivenRefsRec(scenario, allWhenBlocks);
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
  
  private CharSequence generateActionCall(final WhenBlock it, final HttpServer java, final boolean returnResponse) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generateActionCalls = this.generateActionCalls(it.getAction(), it.getDataDefinition(), it.getAuthorization(), java, returnResponse);
    _builder.append(_generateActionCalls);
    return _builder;
  }
  
  private CharSequence generateDataCreation(final WhenBlock it) {
    StringConcatenation _builder = new StringConcatenation();
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
        _builder.append("\t");
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
        _builder.append("{ \\\"uuid\\\" : \\\"\" + uuid + \"\\\"}");
      }
    }
    _builder.append("\",");
    _builder.newLineIfNotEmpty();
    String _dataNameWithPackage = this._modelExtension.dataNameWithPackage(model);
    _builder.append(_dataNameWithPackage);
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
          final Function1<JsonMember, Boolean> _function = (JsonMember it_1) -> {
            boolean _isNotReplayable = it_1.getAttribute().isNotReplayable();
            return Boolean.valueOf((!_isNotReplayable));
          };
          Iterable<JsonMember> _filter = IterableExtensions.<JsonMember>filter(it.getMembers(), _function);
          boolean _hasElements = false;
          for(final JsonMember member : _filter) {
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
  
  private CharSequence generateActionCalls(final HttpServerAce it, final DataDefinition dataDefinition, final Authorization authorization, final HttpServer java, final boolean returnResponse) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    {
      if (returnResponse) {
        _builder.append("return ");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      String _type = it.getType();
      boolean _equals = Objects.equal(_type, "POST");
      if (_equals) {
        _builder.append("this.httpPost(");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\"");
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("data_");
        _builder_1.append(this.index);
        String _urlWithPathParams = this._aceExtension.urlWithPathParams(it, _builder_1.toString(), false);
        _builder.append(_urlWithPathParams, "\t");
        _builder.append("\", ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("data_");
        _builder.append(this.index, "\t");
        _builder.append(",");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        {
          if ((it.isAuthorize() && (authorization != null))) {
            _builder.append("authorization(\"");
            String _username = authorization.getUsername();
            _builder.append(_username, "\t");
            _builder.append("\", \"");
            String _password = authorization.getPassword();
            _builder.append(_password, "\t");
            _builder.append("\")");
          } else {
            _builder.append("null");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append(");");
        _builder.newLine();
      } else {
        String _type_1 = it.getType();
        boolean _equals_1 = Objects.equal(_type_1, "PUT");
        if (_equals_1) {
          _builder.append("this.httpPut(");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\"");
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("data_");
          _builder_2.append(this.index);
          String _urlWithPathParams_1 = this._aceExtension.urlWithPathParams(it, _builder_2.toString(), true);
          _builder.append(_urlWithPathParams_1, "\t");
          _builder.append("\", ");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("data_");
          _builder.append(this.index, "\t");
          _builder.append(",");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          {
            if ((it.isAuthorize() && (authorization != null))) {
              _builder.append("authorization(\"");
              String _username_1 = authorization.getUsername();
              _builder.append(_username_1, "\t");
              _builder.append("\", \"");
              String _password_1 = authorization.getPassword();
              _builder.append(_password_1, "\t");
              _builder.append("\")");
            } else {
              _builder.append("null");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append(");");
          _builder.newLine();
        } else {
          String _type_2 = it.getType();
          boolean _equals_2 = Objects.equal(_type_2, "DELETE");
          if (_equals_2) {
            _builder.append("this.httpDelete(");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\"");
            StringConcatenation _builder_3 = new StringConcatenation();
            _builder_3.append("data_");
            _builder_3.append(this.index);
            String _urlWithPathParams_2 = this._aceExtension.urlWithPathParams(it, _builder_3.toString(), true);
            _builder.append(_urlWithPathParams_2, "\t");
            _builder.append("\", ");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            {
              if ((it.isAuthorize() && (authorization != null))) {
                _builder.append("authorization(\"");
                String _username_2 = authorization.getUsername();
                _builder.append(_username_2, "\t");
                _builder.append("\", \"");
                String _password_2 = authorization.getPassword();
                _builder.append(_password_2, "\t");
                _builder.append("\")");
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
            StringConcatenation _builder_4 = new StringConcatenation();
            _builder_4.append("data_");
            _builder_4.append(this.index);
            String _urlWithPathParams_3 = this._aceExtension.urlWithPathParams(it, _builder_4.toString(), true);
            _builder.append(_urlWithPathParams_3, "\t");
            _builder.append("\", ");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            {
              if ((it.isAuthorize() && (authorization != null))) {
                _builder.append("authorization(\"");
                String _username_3 = authorization.getUsername();
                _builder.append(_username_3, "\t");
                _builder.append("\", \"");
                String _password_3 = authorization.getPassword();
                _builder.append(_password_3, "\t");
                _builder.append("\")");
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
  
  public CharSequence generateBaseScenario() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import static org.hamcrest.CoreMatchers.is;");
    _builder.newLine();
    _builder.append("import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.io.File;");
    _builder.newLine();
    _builder.append("import java.util.Base64;");
    _builder.newLine();
    _builder.append("import java.util.UUID;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import javax.ws.rs.client.Client;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.client.Entity;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.client.Invocation.Builder;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.core.Response;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.glassfish.jersey.client.JerseyClientBuilder;");
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.Jdbi;");
    _builder.newLine();
    _builder.append("import java.time.LocalDateTime;");
    _builder.newLine();
    _builder.append("import org.junit.jupiter.api.AfterAll;");
    _builder.newLine();
    _builder.append("import org.junit.jupiter.api.AfterEach;");
    _builder.newLine();
    _builder.append("import org.junit.jupiter.api.BeforeAll;");
    _builder.newLine();
    _builder.append("import org.junit.jupiter.api.BeforeEach;");
    _builder.newLine();
    _builder.append("import org.junit.jupiter.api.Test;");
    _builder.newLine();
    _builder.append("import org.junit.platform.runner.JUnitPlatform;");
    _builder.newLine();
    _builder.append("import org.junit.runner.RunWith;");
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.DeserializationFeature;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.ObjectMapper;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@RunWith(JUnitPlatform.class)");
    _builder.newLine();
    _builder.append("public abstract class BaseScenario extends AbstractBaseScenario {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(BaseScenario.class);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static Jdbi jdbi;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static int port;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static String host = \"localhost\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static String protocol;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static String rootPath;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private String testId;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Client client;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@BeforeAll");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void beforeClass() throws Exception {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ObjectMapper mapper = new ObjectMapper(new YAMLFactory())");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append(".configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("YamlConfiguration config = mapper.readValue(new File(\"test.yml\"), YamlConfiguration.class);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("port = Integer.parseInt(config.getServer().getApplicationConnectors()[0].getPort());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("protocol = config.getServer().getApplicationConnectors()[0].getType();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("rootPath = config.getServer().getRootPath();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("jdbi = Jdbi.create(config.getDatabase().getUrl());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@AfterAll");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void afterClass() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@BeforeEach");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void before() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("daoProvider = new DaoProvider();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("handle = new PersistenceHandle(jdbi.open());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("testId = randomString();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("client = new JerseyClientBuilder().build();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("LOG.info(\"testId {}\", testId);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("LOG.info(\"*********************************************************************************\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("LOG.info(\"********   {} test id {}\", this.scenarioName(), testId);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("LOG.info(\"*********************************************************************************\");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@AfterEach");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void after() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("handle.getHandle().close();");
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
    _builder.append("public void test() throws Exception {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.runTest();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private String buidlUrl(String path) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return String.format(\"%s://%s:%d%s%s\", protocol, host, port, rootPath, path);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected Response httpGet(String path, String authorization) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Builder builder = client.target(buidlUrl(path)).request();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (authorization != null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("builder.header(\"Authorization\", authorization);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return builder.get();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected Response httpPost(String path, Object data, String authorization) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Builder builder = client.target(buidlUrl(path)).request();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (authorization != null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("builder.header(\"Authorization\", authorization);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return builder.post(Entity.json(data));");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected Response httpPut(String path, Object data, String authorization) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Builder builder = client.target(buidlUrl(path)).request();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (authorization != null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("builder.header(\"Authorization\", authorization);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return builder.put(Entity.json(data));");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected Response httpDelete(String path, String authorization) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Builder builder = client.target(buidlUrl(path)).request();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (authorization != null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("builder.header(\"Authorization\", authorization);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return builder.delete();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected String randomString() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return randomUUID().replace(\"-\", \"\").substring(0, 8);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected String randomUUID() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return UUID.randomUUID().toString();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected String authorization(String username, String password) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String string = username.replace(\"${testId}\", testId) + \":\" + password;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String hash = Base64.getEncoder().encodeToString(string.getBytes());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return \"basic \" + hash;");
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
    _builder.append("org.hamcrest.MatcherAssert.assertThat(actual, is(expected));");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void assertFail(String message) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.junit.jupiter.api.Assertions.fail(message);");
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
    _builder.append("if (actual == null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("assertIsNull(expected);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.hamcrest.MatcherAssert.assertThat(actual, is(samePropertyValuesAs(expected)));");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void assertIsNull(Object actual) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.junit.jupiter.api.Assertions.assertNull(actual);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void assertIsNotNull(Object actual) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.junit.jupiter.api.Assertions.assertNotNull(actual);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected boolean prerequisite(String scenarioName) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return true;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected String getTestId() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return testId;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected String replaceTestId(String string) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return string.replace(\"${testId}\", testId);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected Response callNotReplayableDataProviderPutValue(");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("String uuid, String key, Object data) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Client client = new JerseyClientBuilder().build();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Builder builder = client");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append(".target(String.format(\"%s://%s:%d%s/test/not-replayable/value?uuid=\" + uuid + \"&key=\" + key, protocol,");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("host, port, rootPath))");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append(".request();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return builder.put(Entity.json(data));");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected Response callNotReplayableDataProviderPutSystemTime(");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("String uuid, LocalDateTime dateTime) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Client client = new JerseyClientBuilder().build();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Builder builder = client");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append(".target(String.format(");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("\"%s://%s:%d%s/test/not-replayable/system-time?uuid=\" + uuid + \"&system-time=\" + dateTime,");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("protocol, host, port, rootPath))");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append(".request();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return builder.put(Entity.json(dateTime));");
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
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateAbstractBaseScenario() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.ObjectMapper;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.core.Response;");
    _builder.newLine();
    _builder.append("import java.time.LocalDateTime;");
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
    _builder.append("protected PersistenceHandle handle;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected ObjectMapper objectMapper;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public AbstractBaseScenario() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("objectMapper = new ObjectMapper();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract void runTest() throws Exception;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract Response httpGet(String path, String authorization);");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract Response httpPost(String path, Object data, String authorization);");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract Response httpPut(String path, Object data, String authorization);");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract Response httpDelete(String path, String authorization);");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract String randomString();");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract String randomUUID();");
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
    _builder.append("\t");
    _builder.append("protected abstract void assertIsNotNull(Object actual);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract void assertFail(String message);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract String scenarioName();");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract String getTestId();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract boolean prerequisite(String scenarioName);");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract Response callNotReplayableDataProviderPutValue(");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("String uuid, String key, Object data);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract Response callNotReplayableDataProviderPutSystemTime(");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("String uuid, LocalDateTime dateTime);");
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
