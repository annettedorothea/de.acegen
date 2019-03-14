package de.acegen.templates.java;

import com.google.common.base.Objects;
import de.acegen.aceGen.AttributeDefinition;
import de.acegen.aceGen.AttributeDefinitionList;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.HttpServerAceRead;
import de.acegen.aceGen.HttpServerAceWrite;
import de.acegen.aceGen.HttpServerOutcome;
import de.acegen.aceGen.ListAttributeDefinitionList;
import de.acegen.aceGen.Scenario;
import de.acegen.aceGen.ScenarioEvent;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.java.AceExtension;
import de.acegen.extensions.java.AttributeExtension;
import de.acegen.extensions.java.ModelExtension;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
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
    _builder.append("import com.anfelisa.todo.TestUtils;");
    _builder.newLine();
    _builder.append("import com.anfelisa.todo.ActionCalls;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import static org.hamcrest.MatcherAssert.assertThat;");
    _builder.newLine();
    _builder.append("import static org.hamcrest.Matchers.is;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _name_1 = it.getName();
    _builder.append(_name_1);
    _builder.append("Scenario extends BaseScenario {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private void given() throws Exception {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("List<ITimelineItem> timeline = new ArrayList<>();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    {
      EList<ScenarioEvent> _events = it.getEvents();
      for(final ScenarioEvent scenarioEvent : _events) {
        _builder.append("\t\t");
        _builder.append("timeline.add(TestUtils.create");
        EObject _eContainer = scenarioEvent.getOutcome().eContainer();
        String _eventName = this._aceExtension.eventName(((HttpServerAceWrite) _eContainer), scenarioEvent.getOutcome());
        _builder.append(_eventName, "\t\t");
        _builder.append("TimelineItem(");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("new ");
        EObject _eContainer_1 = scenarioEvent.getOutcome().eContainer();
        String _dataNameWithPackage = this._modelExtension.dataNameWithPackage(((HttpServerAceWrite) _eContainer_1).getModel());
        _builder.append(_dataNameWithPackage, "\t\t\t");
        _builder.append("(\"");
        String _uuid = scenarioEvent.getDataDefinition().getUuid();
        _builder.append(_uuid, "\t\t\t");
        _builder.append("\")");
        _builder.newLineIfNotEmpty();
        {
          EList<AttributeDefinition> _attributeDefinitions = scenarioEvent.getDataDefinition().getData().getAttributeDefinitions();
          for(final AttributeDefinition attributeDefinition : _attributeDefinitions) {
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append(".with");
            String _firstUpper = StringExtensions.toFirstUpper(attributeDefinition.getAttribute().getName());
            _builder.append(_firstUpper, "\t\t\t");
            _builder.append("(");
            Object _value = this.value(attributeDefinition);
            _builder.append(_value, "\t\t\t");
            _builder.append(")");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t");
        _builder.append("));");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.append("prepare(timeline, DROPWIZARD.getLocalPort());");
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
    _builder.append("public void execute() throws Exception {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("given();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _generateActionCalls = this.generateActionCalls(it.getAction(), it, java);
    _builder.append(_generateActionCalls, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
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
  
  public CharSequence generateActionCalls(final HttpServerAce aceOperation, final Scenario it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    {
      String _type = aceOperation.getType();
      boolean _equals = Objects.equal(_type, "POST");
      if (_equals) {
        _builder.append("Response response = ActionCalls.call");
        String _firstUpper = StringExtensions.toFirstUpper(aceOperation.getName());
        _builder.append(_firstUpper);
        _builder.append("(");
        {
          List<String> _mergeAttributesForPostCall = this._attributeExtension.mergeAttributesForPostCall(aceOperation, it.getDataDefinition());
          boolean _hasElements = false;
          for(final String param : _mergeAttributesForPostCall) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(", ", "");
            }
            _builder.append(param);
          }
        }
        {
          boolean _isAuthorize = aceOperation.isAuthorize();
          if (_isAuthorize) {
            _builder.append(", authorization(");
            String _username = it.getAuthorization().getUsername();
            _builder.append(_username);
            _builder.append(", ");
            String _password = it.getAuthorization().getPassword();
            _builder.append(_password);
            _builder.append(")");
          }
        }
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      } else {
        String _type_1 = aceOperation.getType();
        boolean _equals_1 = Objects.equal(_type_1, "PUT");
        if (_equals_1) {
          _builder.append("Response response = ActionCalls.call");
          String _firstUpper_1 = StringExtensions.toFirstUpper(aceOperation.getName());
          _builder.append(_firstUpper_1);
          _builder.append("(");
          {
            List<String> _mergeAttributesForPutCall = this._attributeExtension.mergeAttributesForPutCall(aceOperation, it.getDataDefinition());
            boolean _hasElements_1 = false;
            for(final String param_1 : _mergeAttributesForPutCall) {
              if (!_hasElements_1) {
                _hasElements_1 = true;
              } else {
                _builder.appendImmediate(", ", "");
              }
              _builder.append(param_1);
            }
          }
          {
            boolean _isAuthorize_1 = aceOperation.isAuthorize();
            if (_isAuthorize_1) {
              _builder.append(", authorization(");
              String _username_1 = it.getAuthorization().getUsername();
              _builder.append(_username_1);
              _builder.append(", ");
              String _password_1 = it.getAuthorization().getPassword();
              _builder.append(_password_1);
              _builder.append(")");
            }
          }
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        } else {
          String _type_2 = aceOperation.getType();
          boolean _equals_2 = Objects.equal(_type_2, "DELETE");
          if (_equals_2) {
            _builder.append("Response response = ActionCalls.call");
            String _firstUpper_2 = StringExtensions.toFirstUpper(aceOperation.getName());
            _builder.append(_firstUpper_2);
            _builder.append("(");
            {
              List<String> _mergeAttributesForDeleteCall = this._attributeExtension.mergeAttributesForDeleteCall(aceOperation, it.getDataDefinition());
              boolean _hasElements_2 = false;
              for(final String param_2 : _mergeAttributesForDeleteCall) {
                if (!_hasElements_2) {
                  _hasElements_2 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                _builder.append(param_2);
              }
            }
            {
              boolean _isAuthorize_2 = aceOperation.isAuthorize();
              if (_isAuthorize_2) {
                _builder.append(", authorization(");
                String _username_2 = it.getAuthorization().getUsername();
                _builder.append(_username_2);
                _builder.append(", ");
                String _password_2 = it.getAuthorization().getPassword();
                _builder.append(_password_2);
                _builder.append(")");
              }
            }
            _builder.append(");");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("Response response = ActionCalls.call");
            String _firstUpper_3 = StringExtensions.toFirstUpper(aceOperation.getName());
            _builder.append(_firstUpper_3);
            _builder.append("(");
            {
              List<String> _mergeAttributesForGetCall = this._attributeExtension.mergeAttributesForGetCall(aceOperation, it.getDataDefinition());
              boolean _hasElements_3 = false;
              for(final String param_3 : _mergeAttributesForGetCall) {
                if (!_hasElements_3) {
                  _hasElements_3 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                _builder.append(param_3);
              }
            }
            {
              boolean _isAuthorize_3 = aceOperation.isAuthorize();
              if (_isAuthorize_3) {
                _builder.append(", authorization(");
                String _username_3 = it.getAuthorization().getUsername();
                _builder.append(_username_3);
                _builder.append(", ");
                String _password_3 = it.getAuthorization().getPassword();
                _builder.append(_password_3);
                _builder.append(")");
              }
            }
            _builder.append(");");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.newLine();
    {
      int _statusCode = it.getStatusCode();
      boolean _tripleNotEquals = (_statusCode != 0);
      if (_tripleNotEquals) {
        _builder.append("assertThat(response.getStatus(), is(");
        int _statusCode_1 = it.getStatusCode();
        _builder.append(_statusCode_1);
        _builder.append("));");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    {
      AttributeDefinitionList _response = it.getResponse();
      boolean _tripleNotEquals_1 = (_response != null);
      if (_tripleNotEquals_1) {
        String _responseDataNameWithPackage = this._aceExtension.responseDataNameWithPackage(aceOperation, java);
        _builder.append(_responseDataNameWithPackage);
        _builder.append(" expected = new ");
        String _responseDataNameWithPackage_1 = this._aceExtension.responseDataNameWithPackage(aceOperation, java);
        _builder.append(_responseDataNameWithPackage_1);
        _builder.append("();");
        _builder.newLineIfNotEmpty();
        String _responseDataNameWithPackage_2 = this._aceExtension.responseDataNameWithPackage(aceOperation, java);
        _builder.append(_responseDataNameWithPackage_2);
        _builder.append(" actual = response.readEntity(");
        String _responseDataNameWithPackage_3 = this._aceExtension.responseDataNameWithPackage(aceOperation, java);
        _builder.append(_responseDataNameWithPackage_3);
        _builder.append(".class);");
        _builder.newLineIfNotEmpty();
        _builder.append("assertThat(actual, is(expected));");
        _builder.newLine();
      }
    }
    _builder.newLine();
    return _builder;
  }
  
  private Object value(final AttributeDefinition it) {
    String _stringValue = it.getValue().getStringValue();
    boolean _tripleNotEquals = (_stringValue != null);
    if (_tripleNotEquals) {
      String _type = it.getAttribute().getType();
      boolean _equals = Objects.equal(_type, "DateTime");
      if (_equals) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("DateTime.parse(\"");
        String _stringValue_1 = it.getValue().getStringValue();
        _builder.append(_stringValue_1);
        _builder.append("\", DateTimeFormat.forPattern(\"dd.MM.yyyy HH:mm:ss\"))");
        return _builder.toString();
      }
      String _type_1 = it.getAttribute().getType();
      boolean _equals_1 = Objects.equal(_type_1, "Integer");
      if (_equals_1) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("Integer.parseInt(\"");
        String _stringValue_2 = it.getValue().getStringValue();
        _builder_1.append(_stringValue_2);
        _builder_1.append("\")");
        return _builder_1.toString();
      }
      String _type_2 = it.getAttribute().getType();
      boolean _equals_2 = Objects.equal(_type_2, "Float");
      if (_equals_2) {
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("Float.parseFloat(\"");
        String _stringValue_3 = it.getValue().getStringValue();
        _builder_2.append(_stringValue_3);
        _builder_2.append("\")");
        return _builder_2.toString();
      }
      String _type_3 = it.getAttribute().getType();
      boolean _equals_3 = Objects.equal(_type_3, "Boolean");
      if (_equals_3) {
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("new Boolean(\"");
        String _stringValue_4 = it.getValue().getStringValue();
        _builder_3.append(_stringValue_4);
        _builder_3.append("\")");
        return _builder_3.toString();
      }
      String _type_4 = it.getAttribute().getType();
      boolean _equals_4 = Objects.equal(_type_4, "Long");
      if (_equals_4) {
        StringConcatenation _builder_4 = new StringConcatenation();
        _builder_4.append("Long.parseLong(\"");
        String _stringValue_5 = it.getValue().getStringValue();
        _builder_4.append(_stringValue_5);
        _builder_4.append("\")");
        return _builder_4.toString();
      }
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("\"");
      String _stringValue_6 = it.getValue().getStringValue();
      _builder_5.append(_stringValue_6);
      _builder_5.append("\"");
      return _builder_5.toString();
    }
    AttributeDefinitionList _attributeDefinitionList = it.getValue().getAttributeDefinitionList();
    boolean _tripleNotEquals_1 = (_attributeDefinitionList != null);
    if (_tripleNotEquals_1) {
      return null;
    }
    ListAttributeDefinitionList _listAttributeDefinitionList = it.getValue().getListAttributeDefinitionList();
    boolean _tripleNotEquals_2 = (_listAttributeDefinitionList != null);
    if (_tripleNotEquals_2) {
      return null;
    }
    return Integer.valueOf(it.getValue().getIntValue());
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
    _builder.append("import org.mockito.MockitoAnnotations;");
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
    _builder.append("\t\t");
    _builder.append("MockitoAnnotations.initMocks(this);");
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
    _builder.append("import java.util.ArrayList;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import java.util.UUID;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import javax.ws.rs.client.Client;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.client.Entity;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.glassfish.jersey.client.JerseyClientBuilder;");
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.Handle;");
    _builder.newLine();
    _builder.append("import org.joda.time.DateTime;");
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
    _builder.append("protected void prepare(List<ITimelineItem> timeline, int port) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Client client = new JerseyClientBuilder().build();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("client.target(String.format(\"http://localhost:%d/api/test/replay-events\", port))");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append(".request().put(Entity.json(timeline));");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void prepare(int port) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("List<ITimelineItem> timeline = new ArrayList<>();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Client client = new JerseyClientBuilder().build();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("client.target(String.format(\"http://localhost:%d/api/test/replay-events\", port))");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append(".request().put(Entity.json(timeline));");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void setSystemTime(DateTime systemTime, int port) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Client client = new JerseyClientBuilder().build();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("client.target(String.format(\"http://localhost:%d/api/test/system-time\", port))");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append(".request().put(Entity.json(systemTime.toString()));");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract String authorization(String username, String password);");
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
  
  public CharSequence generateTestUtils(final HttpServer it) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = it.getName();
    _builder.append(_name);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.JodaObjectMapper;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.TimelineItem;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.core.JsonProcessingException;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class TestUtils {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static final JodaObjectMapper mapper = new JodaObjectMapper();");
    _builder.newLine();
    _builder.newLine();
    {
      EList<HttpServerAce> _aceOperations = it.getAceOperations();
      for(final HttpServerAce aceOperation : _aceOperations) {
        _builder.append("\t");
        CharSequence _createTimelineItem = this.createTimelineItem(aceOperation);
        _builder.append(_createTimelineItem, "\t");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
      }
    }
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
  
  private CharSequence _createTimelineItem(final HttpServerAceWrite it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<HttpServerOutcome> _outcomes = it.getOutcomes();
      for(final HttpServerOutcome outcome : _outcomes) {
        _builder.append("public static TimelineItem create");
        String _eventName = this._aceExtension.eventName(it, outcome);
        _builder.append(_eventName);
        _builder.append("TimelineItem(");
        String _dataInterfaceNameWithPackage = this._modelExtension.dataInterfaceNameWithPackage(it.getModel());
        _builder.append(_dataInterfaceNameWithPackage);
        _builder.append(" data) throws JsonProcessingException {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("String json = mapper.writeValueAsString(data);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("return new TimelineItem(\"prepare\", null, \"");
        String _eventNameWithPackage = this._aceExtension.eventNameWithPackage(it, outcome);
        _builder.append(_eventNameWithPackage, "\t");
        _builder.append("\", null, json, data.getUuid());");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  private CharSequence _createTimelineItem(final HttpServerAceRead it) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  private CharSequence createTimelineItem(final HttpServerAce it) {
    if (it instanceof HttpServerAceRead) {
      return _createTimelineItem((HttpServerAceRead)it);
    } else if (it instanceof HttpServerAceWrite) {
      return _createTimelineItem((HttpServerAceWrite)it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
