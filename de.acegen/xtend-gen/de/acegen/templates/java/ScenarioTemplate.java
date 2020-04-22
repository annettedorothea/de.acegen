package de.acegen.templates.java;

import com.google.common.base.Objects;
import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.AttributeDefinition;
import de.acegen.aceGen.AttributeDefinitionList;
import de.acegen.aceGen.AttributeDefinitionListForList;
import de.acegen.aceGen.Authorization;
import de.acegen.aceGen.DataDefinition;
import de.acegen.aceGen.GivenRef;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.ListAttributeDefinitionList;
import de.acegen.aceGen.Model;
import de.acegen.aceGen.PrimitiveValueDefinitionForList;
import de.acegen.aceGen.Scenario;
import de.acegen.aceGen.ValueDefinitionList;
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
  
  private int varIndex = 0;
  
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
    int index = 0;
    _builder.newLineIfNotEmpty();
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
                WhenBlock _whenBlock = givenRef.getScenario().getWhenBlock();
                int _plusPlus = index++;
                CharSequence _generateActionCall = this.generateActionCall(_whenBlock, java, _plusPlus, false);
                _builder.append(_generateActionCall, "\t\t");
                _builder.newLineIfNotEmpty();
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
            WhenBlock _whenBlock_1 = givenRef.getScenario().getWhenBlock();
            int _plusPlus_1 = index++;
            CharSequence _generateActionCall_1 = this.generateActionCall(_whenBlock_1, java, _plusPlus_1, false);
            _builder.append(_generateActionCall_1, "\t\t");
            _builder.newLineIfNotEmpty();
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
    CharSequence _generateActionCall_2 = this.generateActionCall(it.getWhenBlock(), java, 0, true);
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
        CharSequence _generateDataCreation = this.generateDataCreation(it.getThenBlock().getResponse(), it.getWhenBlock().getAction().getModel(), "expectedData", null);
        _builder.append(_generateDataCreation, "\t\t");
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
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("protected abstract void verifications(");
    {
      boolean _isRead_5 = this._aceExtension.isRead(it.getWhenBlock().getAction());
      if (_isRead_5) {
        EObject _eContainer_6 = it.getWhenBlock().getAction().eContainer();
        String _responseDataNameWithPackage_6 = this._aceExtension.responseDataNameWithPackage(it.getWhenBlock().getAction(), ((HttpServer) _eContainer_6));
        _builder.append(_responseDataNameWithPackage_6, "\t\t\t");
        _builder.append(" response");
      }
    }
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
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
    EList<GivenRef> _givenRefs = it.getScenario().getGivenRefs();
    for (final GivenRef scenario : _givenRefs) {
      this.allGivenRefsRec(scenario, allWhenBlocks);
    }
    boolean _contains = allWhenBlocks.contains(it);
    boolean _not = (!_contains);
    if (_not) {
      allWhenBlocks.add(it);
    }
  }
  
  private CharSequence generatePrepare(final WhenBlock it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      String _systemtime = it.getDataDefinition().getSystemtime();
      boolean _tripleNotEquals = (_systemtime != null);
      if (_tripleNotEquals) {
        _builder.append("NotReplayableDataProvider.setSystemTime(");
        String _dateTimeParse = this._attributeExtension.dateTimeParse(it.getDataDefinition().getSystemtime(), it.getDataDefinition().getPattern());
        _builder.append(_dateTimeParse);
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
                String _valueFrom = this._attributeExtension.valueFrom(attributeDefinition, null);
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
  
  private CharSequence generateActionCall(final WhenBlock it, final HttpServer java, final int index, final boolean returnResponse) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generateActionCalls = this.generateActionCalls(it.getAction(), it.getDataDefinition(), it.getAuthorization(), java, index, returnResponse);
    _builder.append(_generateActionCalls);
    return _builder;
  }
  
  private CharSequence generateDataCreation(final DataDefinition it, final Model model, final String varName, final Integer index) {
    StringConcatenation _builder = new StringConcatenation();
    this.resetVarIndex();
    _builder.newLineIfNotEmpty();
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
      if (((it.getData() != null) && (it.getData().getAttributeDefinitions() != null))) {
        {
          EList<AttributeDefinition> _attributeDefinitions = it.getData().getAttributeDefinitions();
          for(final AttributeDefinition attributeDefinition : _attributeDefinitions) {
            {
              AttributeDefinitionList _attributeDefinitionList = attributeDefinition.getValue().getAttributeDefinitionList();
              boolean _tripleNotEquals_1 = (_attributeDefinitionList != null);
              if (_tripleNotEquals_1) {
                String _firstUpper = StringExtensions.toFirstUpper(attributeDefinition.getAttribute().getName());
                String _plus = (varName + _firstUpper);
                CharSequence _generateModelCreation = this.generateModelCreation(attributeDefinition, _plus, index);
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
                boolean _tripleNotEquals_2 = (_listAttributeDefinitionList != null);
                if (_tripleNotEquals_2) {
                  String _firstUpper_2 = StringExtensions.toFirstUpper(attributeDefinition.getAttribute().getName());
                  String _plus_2 = (varName + _firstUpper_2);
                  String _generateModelListCreation = this.generateModelListCreation(attributeDefinition, _plus_2, index);
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
                  String _setterCall_2 = this._attributeExtension.setterCall(attributeDefinition.getAttribute(), this._attributeExtension.valueFrom(attributeDefinition, index));
                  _builder.append(_setterCall_2);
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
        }
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  private CharSequence generateModelCreation(final AttributeDefinition it, final String varName, final Integer index) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("\t");
    String _interfaceWithPackage = this._modelExtension.interfaceWithPackage(it.getAttribute().getModel());
    _builder.append(_interfaceWithPackage, "\t");
    _builder.append(" ");
    _builder.append(varName, "\t");
    _builder.append(" = new ");
    String _modelClassNameWithPackage = this._modelExtension.modelClassNameWithPackage(it.getAttribute().getModel());
    _builder.append(_modelClassNameWithPackage, "\t");
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    {
      EList<AttributeDefinition> _attributeDefinitions = it.getValue().getAttributeDefinitionList().getAttributeDefinitions();
      for(final AttributeDefinition attributeDefinition : _attributeDefinitions) {
        {
          boolean _isList = attributeDefinition.getAttribute().isList();
          if (_isList) {
            _builder.append("\t");
            final String listVarName = this.newVarName("list");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            String _generateModelListCreation = this.generateModelListCreation(attributeDefinition, listVarName, index);
            _builder.append(_generateModelListCreation, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append(varName, "\t");
            _builder.append(".");
            String _setterCall = this._attributeExtension.setterCall(attributeDefinition.getAttribute(), listVarName);
            _builder.append(_setterCall, "\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("\t");
            _builder.append(varName, "\t");
            _builder.append(".");
            String _setterCall_1 = this._attributeExtension.setterCall(attributeDefinition.getAttribute(), this._attributeExtension.valueFrom(attributeDefinition, index));
            _builder.append(_setterCall_1, "\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.newLine();
    return _builder;
  }
  
  private String generateModelListCreation(final AttributeDefinition it, final String varName, final Integer index) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    {
      ListAttributeDefinitionList _listAttributeDefinitionList = it.getValue().getListAttributeDefinitionList();
      if ((_listAttributeDefinitionList instanceof AttributeDefinitionListForList)) {
        _builder.append("\t");
        _builder.append("List<");
        String _interfaceWithPackage = this._modelExtension.interfaceWithPackage(it.getAttribute().getModel());
        _builder.append(_interfaceWithPackage, "\t");
        _builder.append("> ");
        _builder.append(varName, "\t");
        _builder.append(" = new ArrayList<");
        String _interfaceWithPackage_1 = this._modelExtension.interfaceWithPackage(it.getAttribute().getModel());
        _builder.append(_interfaceWithPackage_1, "\t");
        _builder.append(">();");
        _builder.newLineIfNotEmpty();
        {
          ListAttributeDefinitionList _listAttributeDefinitionList_1 = it.getValue().getListAttributeDefinitionList();
          EList<AttributeDefinitionList> _attributeDefinitionList = ((AttributeDefinitionListForList) _listAttributeDefinitionList_1).getAttributeDefinitionList();
          for(final AttributeDefinitionList attributeDefinitionList : _attributeDefinitionList) {
            _builder.append("\t");
            final String itemVarName = this.newVarName("item");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            String _interfaceWithPackage_2 = this._modelExtension.interfaceWithPackage(it.getAttribute().getModel());
            _builder.append(_interfaceWithPackage_2, "\t");
            _builder.append(" ");
            _builder.append(itemVarName, "\t");
            _builder.append(" = new ");
            String _modelClassNameWithPackage = this._modelExtension.modelClassNameWithPackage(it.getAttribute().getModel());
            _builder.append(_modelClassNameWithPackage, "\t");
            _builder.append("();");
            _builder.newLineIfNotEmpty();
            {
              EList<AttributeDefinition> _attributeDefinitions = attributeDefinitionList.getAttributeDefinitions();
              for(final AttributeDefinition attributeDefinition : _attributeDefinitions) {
                {
                  boolean _isList = attributeDefinition.getAttribute().isList();
                  if (_isList) {
                    _builder.append("\t");
                    final String listVarName = this.newVarName("list");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    String _generateModelListCreation = this.generateModelListCreation(attributeDefinition, listVarName, index);
                    _builder.append(_generateModelListCreation, "\t");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append(itemVarName, "\t");
                    _builder.append(".");
                    String _setterCall = this._attributeExtension.setterCall(attributeDefinition.getAttribute(), listVarName);
                    _builder.append(_setterCall, "\t");
                    _builder.append(";");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("\t");
                    _builder.append(itemVarName, "\t");
                    _builder.append(".");
                    String _setterCall_1 = this._attributeExtension.setterCall(attributeDefinition.getAttribute(), this._attributeExtension.valueFrom(attributeDefinition, index));
                    _builder.append(_setterCall_1, "\t");
                    _builder.append(";");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
            _builder.append("\t");
            _builder.append(varName, "\t");
            _builder.append(".add(");
            _builder.append(itemVarName, "\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.newLine();
          }
        }
      } else {
        _builder.append("\t");
        _builder.append("List<");
        String _type = it.getAttribute().getType();
        _builder.append(_type, "\t");
        _builder.append("> ");
        _builder.append(varName, "\t");
        _builder.append(" = new ArrayList<");
        String _type_1 = it.getAttribute().getType();
        _builder.append(_type_1, "\t");
        _builder.append(">();");
        _builder.newLineIfNotEmpty();
        {
          ListAttributeDefinitionList _listAttributeDefinitionList_2 = it.getValue().getListAttributeDefinitionList();
          EList<ValueDefinitionList> _valueDefinitionList = ((PrimitiveValueDefinitionForList) _listAttributeDefinitionList_2).getValueDefinitionList();
          for(final ValueDefinitionList primitiveValueDefinitionList : _valueDefinitionList) {
            _builder.append("\t");
            _builder.append(varName, "\t");
            _builder.append(".add(");
            {
              String _stringValue = primitiveValueDefinitionList.getPrimitiveValue().getStringValue();
              boolean _tripleNotEquals = (_stringValue != null);
              if (_tripleNotEquals) {
                _builder.append("\"");
                String _stringValue_1 = primitiveValueDefinitionList.getPrimitiveValue().getStringValue();
                _builder.append(_stringValue_1, "\t");
                _builder.append("\"");
              } else {
                int _intValue = primitiveValueDefinitionList.getPrimitiveValue().getIntValue();
                _builder.append(_intValue, "\t");
              }
            }
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.newLine();
    return _builder.toString();
  }
  
  private String newVarName(final String prefix) {
    this.varIndex++;
    return (prefix + Integer.valueOf(this.varIndex));
  }
  
  private void resetVarIndex() {
    this.varIndex = 0;
  }
  
  private CharSequence generateActionCalls(final HttpServerAce it, final DataDefinition dataDefinition, final Authorization authorization, final HttpServer java, final int index, final boolean returnResponse) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Model _model = it.getModel();
      boolean _tripleNotEquals = (_model != null);
      if (_tripleNotEquals) {
        Model _model_1 = it.getModel();
        StringConcatenation _builder_1 = new StringConcatenation();
        String _firstLower = StringExtensions.toFirstLower(it.getName());
        _builder_1.append(_firstLower);
        _builder_1.append(index);
        CharSequence _generateDataCreation = this.generateDataCreation(dataDefinition, _model_1, _builder_1.toString(), Integer.valueOf(index));
        _builder.append(_generateDataCreation);
        _builder.newLineIfNotEmpty();
      }
    }
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
        String _firstLower_1 = StringExtensions.toFirstLower(it.getName());
        _builder.append(_firstLower_1);
        _builder.append(index);
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
          String _firstLower_2 = StringExtensions.toFirstLower(it.getName());
          _builder.append(_firstLower_2);
          _builder.append(index);
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
            String _firstLower_3 = StringExtensions.toFirstLower(it.getName());
            _builder.append(_firstLower_3);
            _builder.append(index);
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
            String _firstLower_4 = StringExtensions.toFirstLower(it.getName());
            _builder.append(_firstLower_4);
            _builder.append(index);
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
    _builder.append("import java.util.UUID;");
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
    _builder.append("protected String templateStringValue(String value, Integer index) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String returnString = value;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (index != null && value.contains(\"${index}\")) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("returnString = returnString.replace(\"${index}\", index.toString());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (value.contains(\"${random}\")) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("returnString = returnString.replace(\"${random}\", UUID.randomUUID().toString().substring(0, 8));");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return returnString;");
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
