package de.acegen.templates.es6;

import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.ClientGivenRef;
import de.acegen.aceGen.ClientScenario;
import de.acegen.aceGen.ClientWhenBlock;
import de.acegen.aceGen.HttpClient;
import de.acegen.aceGen.InputValue;
import de.acegen.aceGen.NonDeterministicValue;
import de.acegen.aceGen.StateVerification;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.es6.Es6Extension;
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
  private CommonExtension _commonExtension;
  
  @Inject
  @Extension
  private Es6Extension _es6Extension;
  
  public CharSequence generateScenarioUtils() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("export function getCypressFor(action, args) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("throw \"getCypressFor not implemented\";");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export function wait(numberOfSyncCalls, numberOfAsyncCalls) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return cy.wait(numberOfSyncCalls * 5 + numberOfAsyncCalls * 100);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export function testId() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("let d = new Date().getTime();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return \'xxxxxxxx\'.replace(/[xy]/g, function (c) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("let r = (d + Math.random() * 16) % 16 | 0;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("d = Math.floor(d / 16);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return (c === \'x\' ? r : (r & 0x3 | 0x8)).toString(16);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("});");
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
  
  public CharSequence generateScenario(final ClientScenario it, final HttpClient httpClient) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import * as ScenarioUtils from \"../../../acegen/src/ScenarioUtils\";");
    _builder.newLine();
    _builder.append("import AppUtils from \"../../../../es6/src/app/AppUtils\";");
    _builder.newLine();
    {
      List<HttpClient> _allReferencedHttpClients = this._es6Extension.allReferencedHttpClients(it);
      for(final HttpClient referencedHttpClient : _allReferencedHttpClients) {
        _builder.append("import * as ");
        CharSequence _actionIdName = this._es6Extension.actionIdName(referencedHttpClient);
        _builder.append(_actionIdName);
        _builder.append(" from \"../../../acegen/gen/");
        String _name = referencedHttpClient.getName();
        _builder.append(_name);
        _builder.append("/");
        CharSequence _actionIdName_1 = this._es6Extension.actionIdName(referencedHttpClient);
        _builder.append(_actionIdName_1);
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      int _size = it.getThenBlock().getVerifications().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _builder.append("import * as Verifications from \"../../../acegen/src/");
        String _name_1 = httpClient.getName();
        _builder.append(_name_1);
        _builder.append("/");
        String _name_2 = it.getName();
        _builder.append(_name_2);
        _builder.append("Verifications\";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("const testId = ScenarioUtils.testId();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("context(\'");
    String _name_3 = it.getName();
    _builder.append(_name_3);
    _builder.append("\', () => {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("beforeEach(() => {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("let nonDeterministicValues;");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("let nonDeterministicValue;");
    _builder.newLine();
    {
      ArrayList<ClientGivenRef> _allGivenItems = this.allGivenItems(it);
      for(final ClientGivenRef givenRef : _allGivenItems) {
        _builder.append("\t\t");
        CharSequence _initNonDeterministicData = this.initNonDeterministicData(givenRef.getScenario().getWhenBlock());
        _builder.append(_initNonDeterministicData, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("ScenarioUtils.getCypressFor(");
        EObject _eContainer = givenRef.getScenario().getWhenBlock().getAction().eContainer();
        CharSequence _actionIdName_2 = this._es6Extension.actionIdName(((HttpClient) _eContainer));
        _builder.append(_actionIdName_2, "\t\t");
        _builder.append(".");
        String _firstLower = StringExtensions.toFirstLower(givenRef.getScenario().getWhenBlock().getAction().getName());
        _builder.append(_firstLower, "\t\t");
        {
          EList<InputValue> _inputValues = givenRef.getScenario().getWhenBlock().getInputValues();
          boolean _hasElements = false;
          for(final InputValue arg : _inputValues) {
            if (!_hasElements) {
              _hasElements = true;
              _builder.append(", [", "\t\t");
            } else {
              _builder.appendImmediate(",", "\t\t");
            }
            Object _primitiveValueFrom = this._es6Extension.primitiveValueFrom(arg.getValue());
            _builder.append(_primitiveValueFrom, "\t\t");
          }
          if (_hasElements) {
            _builder.append("]", "\t\t");
          }
        }
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        {
          int _delayInMillis = givenRef.getScenario().getDelayInMillis();
          boolean _greaterThan_1 = (_delayInMillis > 0);
          if (_greaterThan_1) {
            _builder.append("\t\t");
            _builder.append("ScenarioUtils.waitInMillis(");
            int _delayInMillis_1 = it.getDelayInMillis();
            _builder.append(_delayInMillis_1, "\t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("    ");
    _builder.append("})");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("it(\'");
    {
      EList<StateVerification> _stateVerifications = it.getThenBlock().getStateVerifications();
      boolean _hasElements_1 = false;
      for(final StateVerification stateVerification : _stateVerifications) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          _builder.appendImmediate(" ", "    ");
        }
        String _name_4 = stateVerification.getName();
        _builder.append(_name_4, "    ");
      }
    }
    _builder.append(" ");
    {
      EList<String> _verifications = it.getThenBlock().getVerifications();
      boolean _hasElements_2 = false;
      for(final String verification : _verifications) {
        if (!_hasElements_2) {
          _hasElements_2 = true;
        } else {
          _builder.appendImmediate(" ", "    ");
        }
        _builder.append(verification, "    ");
      }
    }
    _builder.append("\', () => {");
    _builder.newLineIfNotEmpty();
    {
      ClientWhenBlock _whenBlock = it.getWhenBlock();
      boolean _tripleNotEquals = (_whenBlock != null);
      if (_tripleNotEquals) {
        _builder.append("\t\t");
        {
          if ((((it.getWhenBlock() != null) && (it.getWhenBlock().getNonDeterministicValues() != null)) && (it.getWhenBlock().getNonDeterministicValues().size() > 0))) {
            _builder.append("let nonDeterministicValues;");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("let nonDeterministicValue;");
            _builder.newLine();
          }
        }
        _builder.append("\t\t");
        CharSequence _initNonDeterministicData_1 = this.initNonDeterministicData(it.getWhenBlock());
        _builder.append(_initNonDeterministicData_1, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("ScenarioUtils.getCypressFor(");
        EObject _eContainer_1 = it.getWhenBlock().getAction().eContainer();
        CharSequence _actionIdName_3 = this._es6Extension.actionIdName(((HttpClient) _eContainer_1));
        _builder.append(_actionIdName_3, "\t\t");
        _builder.append(".");
        String _firstLower_1 = StringExtensions.toFirstLower(it.getWhenBlock().getAction().getName());
        _builder.append(_firstLower_1, "\t\t");
        {
          EList<InputValue> _inputValues_1 = it.getWhenBlock().getInputValues();
          boolean _hasElements_3 = false;
          for(final InputValue arg_1 : _inputValues_1) {
            if (!_hasElements_3) {
              _hasElements_3 = true;
              _builder.append(", [", "\t\t");
            } else {
              _builder.appendImmediate(",", "\t\t");
            }
            Object _primitiveValueFrom_1 = this._es6Extension.primitiveValueFrom(arg_1.getValue());
            _builder.append(_primitiveValueFrom_1, "\t\t");
          }
          if (_hasElements_3) {
            _builder.append("]", "\t\t");
          }
        }
        _builder.append(").should(() => {");
        _builder.newLineIfNotEmpty();
        {
          int _delayInMillis_2 = it.getDelayInMillis();
          boolean _greaterThan_2 = (_delayInMillis_2 > 0);
          if (_greaterThan_2) {
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("ScenarioUtils.waitInMillis(");
            int _delayInMillis_3 = it.getDelayInMillis();
            _builder.append(_delayInMillis_3, "\t\t\t");
            _builder.append(").should(() => {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("const appState = JSON.parse(localStorage.getItem(\'appState\'))");
            _builder.newLine();
            {
              EList<StateVerification> _stateVerifications_1 = it.getThenBlock().getStateVerifications();
              for(final StateVerification stateVerification_1 : _stateVerifications_1) {
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("expect(appState.");
                String _stateRefPath = this._es6Extension.stateRefPath(stateVerification_1.getStateRef());
                _builder.append(_stateRefPath, "\t\t\t\t");
                _builder.append(", \"");
                String _name_5 = stateVerification_1.getName();
                _builder.append(_name_5, "\t\t\t\t");
                _builder.append("\").to.eql(");
                CharSequence _valueFrom = this._es6Extension.valueFrom(stateVerification_1.getValue());
                _builder.append(_valueFrom, "\t\t\t\t");
                _builder.append(")");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              EList<String> _verifications_1 = it.getThenBlock().getVerifications();
              for(final String verification_1 : _verifications_1) {
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("Verifications.");
                _builder.append(verification_1, "\t\t\t\t");
                _builder.append("(testId);");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("});");
            _builder.newLine();
          } else {
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("const appState = JSON.parse(localStorage.getItem(\'appState\'))");
            _builder.newLine();
            {
              EList<StateVerification> _stateVerifications_2 = it.getThenBlock().getStateVerifications();
              for(final StateVerification stateVerification_2 : _stateVerifications_2) {
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("expect(appState.");
                String _stateRefPath_1 = this._es6Extension.stateRefPath(stateVerification_2.getStateRef());
                _builder.append(_stateRefPath_1, "\t\t\t");
                _builder.append(", \"");
                String _name_6 = stateVerification_2.getName();
                _builder.append(_name_6, "\t\t\t");
                _builder.append("\").to.eql(");
                CharSequence _valueFrom_1 = this._es6Extension.valueFrom(stateVerification_2.getValue());
                _builder.append(_valueFrom_1, "\t\t\t");
                _builder.append(")");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              EList<String> _verifications_2 = it.getThenBlock().getVerifications();
              for(final String verification_2 : _verifications_2) {
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("Verifications.");
                _builder.append(verification_2, "\t\t\t");
                _builder.append("(testId);");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.append("\t\t");
        _builder.append("});");
        _builder.newLine();
      } else {
        int _delayInMillis_4 = it.getDelayInMillis();
        boolean _greaterThan_3 = (_delayInMillis_4 > 0);
        if (_greaterThan_3) {
          _builder.append("\t\t");
          _builder.append("ScenarioUtils.waitInMillis(");
          int _delayInMillis_5 = it.getDelayInMillis();
          _builder.append(_delayInMillis_5, "\t\t");
          _builder.append(").should(() => {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("const appState = JSON.parse(localStorage.getItem(\'appState\'))");
          _builder.newLine();
          {
            EList<StateVerification> _stateVerifications_3 = it.getThenBlock().getStateVerifications();
            for(final StateVerification stateVerification_3 : _stateVerifications_3) {
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("expect(appState.");
              String _stateRefPath_2 = this._es6Extension.stateRefPath(stateVerification_3.getStateRef());
              _builder.append(_stateRefPath_2, "\t\t\t");
              _builder.append(", \"");
              String _name_7 = stateVerification_3.getName();
              _builder.append(_name_7, "\t\t\t");
              _builder.append("\").to.eql(");
              CharSequence _valueFrom_2 = this._es6Extension.valueFrom(stateVerification_3.getValue());
              _builder.append(_valueFrom_2, "\t\t\t");
              _builder.append(")");
              _builder.newLineIfNotEmpty();
            }
          }
          {
            EList<String> _verifications_3 = it.getThenBlock().getVerifications();
            for(final String verification_3 : _verifications_3) {
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("Verifications.");
              _builder.append(verification_3, "\t\t\t");
              _builder.append("(testId);");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t\t");
          _builder.append("});");
          _builder.newLine();
        }
      }
    }
    _builder.append("    ");
    _builder.append("})");
    _builder.newLine();
    _builder.append("})");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence initNonDeterministicData(final ClientWhenBlock it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (((it.getNonDeterministicValues() != null) && (it.getNonDeterministicValues().size() > 0))) {
        _builder.append("nonDeterministicValues = JSON.parse(localStorage.getItem(\'nonDeterministicValues\'));");
        _builder.newLine();
        _builder.append("if (!nonDeterministicValues) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("nonDeterministicValues = [];");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        {
          EList<NonDeterministicValue> _nonDeterministicValues = it.getNonDeterministicValues();
          for(final NonDeterministicValue nonDeterministicValue : _nonDeterministicValues) {
            _builder.append("nonDeterministicValue = {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("uuid: `");
            String _uuid = nonDeterministicValue.getUuid();
            _builder.append(_uuid, "\t");
            _builder.append("`");
            {
              String _clientSystemTime = nonDeterministicValue.getClientSystemTime();
              boolean _tripleNotEquals = (_clientSystemTime != null);
              if (_tripleNotEquals) {
                _builder.append(",");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("clientSystemTime: `");
                String _clientSystemTime_1 = nonDeterministicValue.getClientSystemTime();
                _builder.append(_clientSystemTime_1, "\t");
                _builder.append("`");
              }
            }
            _builder.newLineIfNotEmpty();
            _builder.append("};");
            _builder.newLine();
            _builder.append("nonDeterministicValues.push(nonDeterministicValue);");
            _builder.newLine();
            {
              String _serverSystemTime = nonDeterministicValue.getServerSystemTime();
              boolean _tripleNotEquals_1 = (_serverSystemTime != null);
              if (_tripleNotEquals_1) {
                _builder.append("AppUtils.httpPut(`/api/test/non-deterministic/system-time?uuid=");
                String _uuid_1 = nonDeterministicValue.getUuid();
                _builder.append(_uuid_1);
                _builder.append("&system-time=${new Date(\'");
                String _serverSystemTime_1 = nonDeterministicValue.getServerSystemTime();
                _builder.append(_serverSystemTime_1);
                _builder.append("\').toISOString()}`)");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              Attribute _attribute = nonDeterministicValue.getAttribute();
              boolean _tripleNotEquals_2 = (_attribute != null);
              if (_tripleNotEquals_2) {
                _builder.append("AppUtils.httpPut(`/api/test/non-deterministic/value?uuid=");
                String _uuid_2 = nonDeterministicValue.getUuid();
                _builder.append(_uuid_2);
                _builder.append("&key=");
                String _firstLower = StringExtensions.toFirstLower(nonDeterministicValue.getAttribute().getName());
                _builder.append(_firstLower);
                _builder.append("&value=");
                Object _primitiveParamFrom = this._es6Extension.primitiveParamFrom(nonDeterministicValue.getValue());
                _builder.append(_primitiveParamFrom);
                _builder.append("`);");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.append("localStorage.setItem(\'nonDeterministicValues\', JSON.stringify(nonDeterministicValues));");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  private ArrayList<ClientGivenRef> allGivenItems(final ClientScenario it) {
    ArrayList<ClientGivenRef> allWhenBlocks = new ArrayList<ClientGivenRef>();
    EList<ClientGivenRef> _givenRefs = it.getGivenRefs();
    for (final ClientGivenRef given : _givenRefs) {
      if ((given instanceof ClientGivenRef)) {
        this.allGivenItemsRec(given, allWhenBlocks);
      }
    }
    return allWhenBlocks;
  }
  
  private void allGivenItemsRec(final ClientGivenRef it, final List<ClientGivenRef> allWhenBlocks) {
    if ((it instanceof ClientGivenRef)) {
      EList<ClientGivenRef> _givenRefs = it.getScenario().getGivenRefs();
      for (final ClientGivenRef given : _givenRefs) {
        this.allGivenItemsRec(given, allWhenBlocks);
      }
    }
    allWhenBlocks.add(it);
  }
  
  public CharSequence generateVerifications(final ClientScenario it) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      EList<String> _verifications = it.getThenBlock().getVerifications();
      for(final String verification : _verifications) {
        _builder.append("export function ");
        _builder.append(verification);
        _builder.append("(testId) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("assert.fail(\"");
        _builder.append(verification, "\t");
        _builder.append(" not implemented\");");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
}
