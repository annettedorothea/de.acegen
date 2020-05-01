package de.acegen.templates.java;

import com.google.common.base.Objects;
import de.acegen.aceGen.Authorization;
import de.acegen.aceGen.DataDefinition;
import de.acegen.aceGen.GivenRef;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.JsonMember;
import de.acegen.aceGen.Model;
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
  
  public CharSequence generateScenario(final Scenario it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    this._attributeExtension.resetIndex();
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
    _builder.append("import org.joda.time.DateTime;");
    _builder.newLine();
    _builder.append("import org.joda.time.DateTimeZone;");
    _builder.newLine();
    _builder.append("import org.joda.time.format.DateTimeFormat;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.junit.Test;");
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
    _builder.append("private void given() throws Exception {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Response response;");
    _builder.newLine();
    {
      ArrayList<GivenRef> _allGivenRefs = this.allGivenRefs(it);
      for(final GivenRef givenRef : _allGivenRefs) {
        {
          int _times = givenRef.getTimes();
          boolean _greaterThan = (_times > 0);
          if (_greaterThan) {
            {
              List<Integer> _timesIterator = this._attributeExtension.timesIterator(givenRef.getTimes());
              for(final Integer i : _timesIterator) {
                _builder.append("\t\t");
                CharSequence _generatePrepare = this.generatePrepare(givenRef.getScenario().getWhenBlock());
                _builder.append(_generatePrepare, "\t\t");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("response = ");
                CharSequence _generateActionCall = this.generateActionCall(givenRef.getScenario().getWhenBlock(), java, false);
                _builder.append(_generateActionCall, "\t\t");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("if (response.getStatus() == 500) {");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("String message = \"GIVEN ");
                String _name_2 = givenRef.getScenario().getWhenBlock().getAction().getName();
                _builder.append(_name_2, "\t\t\t");
                _builder.append(" fails\\n\" + response.readEntity(String.class);");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("assertFail(message);");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.newLine();
              }
            }
          } else {
            _builder.append("\t\t");
            CharSequence _generatePrepare_1 = this.generatePrepare(givenRef.getScenario().getWhenBlock());
            _builder.append(_generatePrepare_1, "\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("response = ");
            CharSequence _generateActionCall_1 = this.generateActionCall(givenRef.getScenario().getWhenBlock(), java, false);
            _builder.append(_generateActionCall_1, "\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("if (response.getStatus() == 500) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("String message = \"GIVEN ");
            String _name_3 = givenRef.getScenario().getWhenBlock().getAction().getName();
            _builder.append(_name_3, "\t\t\t");
            _builder.append(" fails\\n\" + response.readEntity(String.class);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("assertFail(message);");
            _builder.newLine();
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
    CharSequence _generatePrepare_2 = this.generatePrepare(it.getWhenBlock());
    _builder.append(_generatePrepare_2, "\t\t");
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
      boolean _tripleNotEquals_1 = (_response != null);
      if (_tripleNotEquals_1) {
        _builder.append("\t\t");
        String _dataNameWithPackage = this._modelExtension.dataNameWithPackage(it.getWhenBlock().getAction().getModel());
        _builder.append(_dataNameWithPackage, "\t\t");
        _builder.append(" expectedData = ");
        CharSequence _objectMapperCall = this.objectMapperCall(it.getThenBlock().getResponse(), it.getWhenBlock().getAction().getModel());
        _builder.append(_objectMapperCall, "\t\t");
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
      }
    }
    _builder.append("\t\t\t");
    _builder.newLine();
    {
      boolean _isRead_2 = this._aceExtension.isRead(it.getWhenBlock().getAction());
      if (_isRead_2) {
        _builder.append("\t\t\t");
        _builder.append("return actual;");
        _builder.newLine();
      }
    }
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("@Test");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("public void ");
    String _firstLower = StringExtensions.toFirstLower(it.getName());
    _builder.append(_firstLower, "\t\t\t\t");
    _builder.append("() throws Exception {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t");
    _builder.append("given();");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("Response response = when();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    {
      boolean _isRead_3 = this._aceExtension.isRead(it.getWhenBlock().getAction());
      if (_isRead_3) {
        EObject _eContainer_5 = it.getWhenBlock().getAction().eContainer();
        String _responseDataNameWithPackage_5 = this._aceExtension.responseDataNameWithPackage(it.getWhenBlock().getAction(), ((HttpServer) _eContainer_5));
        _builder.append(_responseDataNameWithPackage_5, "\t\t\t\t\t");
        _builder.append(" actualResponse = ");
      }
    }
    _builder.append("then(response);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("verifications(");
    {
      boolean _isRead_4 = this._aceExtension.isRead(it.getWhenBlock().getAction());
      if (_isRead_4) {
        _builder.append("actualResponse");
      }
    }
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("protected abstract void verifications(");
    {
      boolean _isRead_5 = this._aceExtension.isRead(it.getWhenBlock().getAction());
      if (_isRead_5) {
        EObject _eContainer_6 = it.getWhenBlock().getAction().eContainer();
        String _responseDataNameWithPackage_6 = this._aceExtension.responseDataNameWithPackage(it.getWhenBlock().getAction(), ((HttpServer) _eContainer_6));
        _builder.append(_responseDataNameWithPackage_6, "\t\t\t\t");
        _builder.append(" response");
      }
    }
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("protected String scenarioName() {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("return \"");
    String _name_4 = it.getName();
    _builder.append(_name_4, "\t\t\t\t\t");
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg, "\t\t\t");
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
        _builder.append("NotReplayableDataProvider.setSystemTime(DateTime.parse(\"");
        String _systemtime_1 = it.getDataDefinition().getSystemtime();
        _builder.append(_systemtime_1);
        _builder.append("\", DateTimeFormat.forPattern(\"");
        String _pattern = it.getDataDefinition().getPattern();
        _builder.append(_pattern);
        _builder.append("\")).withZone(DateTimeZone.UTC));");
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
                _builder.append("NotReplayableDataProvider.put(\"");
                String _name = attributeDefinition.getAttribute().getName();
                _builder.append(_name);
                _builder.append("\", objectMapper.readValue(\"");
                CharSequence _valueFrom = this._attributeExtension.valueFrom(attributeDefinition.getValue());
                _builder.append(_valueFrom);
                _builder.append("\",");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                {
                  Model _model = attributeDefinition.getAttribute().getModel();
                  boolean _tripleNotEquals_1 = (_model != null);
                  if (_tripleNotEquals_1) {
                    _builder.append(" ");
                    String _dataNameWithPackage = this._modelExtension.dataNameWithPackage(attributeDefinition.getAttribute().getModel());
                    _builder.append(_dataNameWithPackage, "\t\t");
                    _builder.append(".class));");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                  } else {
                    String _type = attributeDefinition.getAttribute().getType();
                    boolean _tripleNotEquals_2 = (_type != null);
                    if (_tripleNotEquals_2) {
                      _builder.append(" ");
                      String _javaType = this._attributeExtension.javaType(attributeDefinition.getAttribute());
                      _builder.append(_javaType, "\t\t");
                      _builder.append(".class));");
                    }
                  }
                }
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
  
  private CharSequence objectMapperCall(final DataDefinition it, final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("objectMapper.readValue(\"");
    {
      if (((it.getData() != null) && (it.getData().getMembers() != null))) {
        _builder.append("{\" +");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\"\\\"uuid\\\" : \\\"");
        {
          String _uuid = it.getUuid();
          boolean _tripleNotEquals = (_uuid != null);
          if (_tripleNotEquals) {
            String _uuid_1 = it.getUuid();
            _builder.append(_uuid_1, "\t");
          } else {
            _builder.append("\" + this.randomUUID() + \"");
          }
        }
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
    _builder.newLineIfNotEmpty();
    _builder.newLine();
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
        String _packageFor = this._aceExtension.packageFor(it);
        _builder.append(_packageFor);
        _builder.append(".ActionCalls.call");
        String _firstUpper = StringExtensions.toFirstUpper(it.getName());
        _builder.append(_firstUpper);
        _builder.append("(");
        CharSequence _objectMapperCall = this.objectMapperCall(dataDefinition, it.getModel());
        _builder.append(_objectMapperCall);
        _builder.append(", DROPWIZARD.getLocalPort()");
        {
          if ((it.isAuthorize() && (authorization != null))) {
            _builder.append(", authorization(\"");
            String _username = authorization.getUsername();
            _builder.append(_username);
            _builder.append("\", \"");
            String _password = authorization.getPassword();
            _builder.append(_password);
            _builder.append("\")");
          } else {
            boolean _isAuthorize = it.isAuthorize();
            if (_isAuthorize) {
              _builder.append(", null");
            }
          }
        }
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      } else {
        String _type_1 = it.getType();
        boolean _equals_1 = Objects.equal(_type_1, "PUT");
        if (_equals_1) {
          String _packageFor_1 = this._aceExtension.packageFor(it);
          _builder.append(_packageFor_1);
          _builder.append(".ActionCalls.call");
          String _firstUpper_1 = StringExtensions.toFirstUpper(it.getName());
          _builder.append(_firstUpper_1);
          _builder.append("(");
          CharSequence _objectMapperCall_1 = this.objectMapperCall(dataDefinition, it.getModel());
          _builder.append(_objectMapperCall_1);
          _builder.append(", DROPWIZARD.getLocalPort()");
          {
            if ((it.isAuthorize() && (authorization != null))) {
              _builder.append(", authorization(\"");
              String _username_1 = authorization.getUsername();
              _builder.append(_username_1);
              _builder.append("\", \"");
              String _password_1 = authorization.getPassword();
              _builder.append(_password_1);
              _builder.append("\")");
            } else {
              boolean _isAuthorize_1 = it.isAuthorize();
              if (_isAuthorize_1) {
                _builder.append(", null");
              }
            }
          }
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        } else {
          String _type_2 = it.getType();
          boolean _equals_2 = Objects.equal(_type_2, "DELETE");
          if (_equals_2) {
            String _packageFor_2 = this._aceExtension.packageFor(it);
            _builder.append(_packageFor_2);
            _builder.append(".ActionCalls.call");
            String _firstUpper_2 = StringExtensions.toFirstUpper(it.getName());
            _builder.append(_firstUpper_2);
            _builder.append("(");
            CharSequence _objectMapperCall_2 = this.objectMapperCall(dataDefinition, it.getModel());
            _builder.append(_objectMapperCall_2);
            _builder.append(", DROPWIZARD.getLocalPort()");
            {
              if ((it.isAuthorize() && (authorization != null))) {
                _builder.append(", authorization(\"");
                String _username_2 = authorization.getUsername();
                _builder.append(_username_2);
                _builder.append("\", \"");
                String _password_2 = authorization.getPassword();
                _builder.append(_password_2);
                _builder.append("\")");
              } else {
                boolean _isAuthorize_2 = it.isAuthorize();
                if (_isAuthorize_2) {
                  _builder.append(", null");
                }
              }
            }
            _builder.append(");");
            _builder.newLineIfNotEmpty();
          } else {
            String _packageFor_3 = this._aceExtension.packageFor(it);
            _builder.append(_packageFor_3);
            _builder.append(".ActionCalls.call");
            String _firstUpper_3 = StringExtensions.toFirstUpper(it.getName());
            _builder.append(_firstUpper_3);
            _builder.append("(");
            CharSequence _objectMapperCall_3 = this.objectMapperCall(dataDefinition, it.getModel());
            _builder.append(_objectMapperCall_3);
            _builder.append(", DROPWIZARD.getLocalPort()");
            {
              if ((it.isAuthorize() && (authorization != null))) {
                _builder.append(", authorization(\"");
                String _username_3 = authorization.getUsername();
                _builder.append(_username_3);
                _builder.append("\", \"");
                String _password_3 = authorization.getPassword();
                _builder.append(_password_3);
                _builder.append("\")");
              } else {
                boolean _isAuthorize_3 = it.isAuthorize();
                if (_isAuthorize_3) {
                  _builder.append(", null");
                }
              }
            }
            _builder.append(");");
            _builder.newLineIfNotEmpty();
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
    _builder.append("import de.acegen.AbstractBaseScenario;");
    _builder.newLine();
    _builder.append("import de.acegen.App;");
    _builder.newLine();
    _builder.append("import de.acegen.CustomAppConfiguration;");
    _builder.newLine();
    _builder.append("import de.acegen.DaoProvider;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import io.dropwizard.jdbi3.JdbiFactory;");
    _builder.newLine();
    _builder.append("import io.dropwizard.testing.DropwizardTestSupport;");
    _builder.newLine();
    _builder.append("import java.util.UUID;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public abstract class BaseScenario extends AbstractBaseScenario {");
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
    _builder.append("LOG.info(\"*********************************************************************************\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("LOG.info(\"********   \" + this.scenarioName());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("LOG.info(\"*********************************************************************************\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("handle = new PersistenceHandle(jdbi.open());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("daoProvider = new DaoProvider();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("daoProvider.truncateAllViews(handle);");
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
    _builder.append("handle.getHandle().close();");
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
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected String randomString() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return UUID.randomUUID().toString().substring(0, 8);");
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
    _builder.append("\t");
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
    _builder.append("protected void assertIsNull(Object actual) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throw new RuntimeException(\"BaseScenario.assertIsNull not implemented\");");
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
    _builder.append("throw new RuntimeException(\"BaseScenario.assertIsNotNull not implemented\");");
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
    _builder.append("org.junit.Assert.fail(message);");
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
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.ObjectMapper;");
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
