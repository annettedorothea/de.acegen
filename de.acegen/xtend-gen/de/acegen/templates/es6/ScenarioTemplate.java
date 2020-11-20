package de.acegen.templates.es6;

import de.acegen.aceGen.ClientGivenRef;
import de.acegen.aceGen.ClientScenario;
import de.acegen.aceGen.ClientWhenBlock;
import de.acegen.aceGen.HttpClient;
import de.acegen.aceGen.InputValue;
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
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateScenario(final ClientScenario it) {
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
      for(final HttpClient httpClient : _allReferencedHttpClients) {
        _builder.append("import * as ");
        CharSequence _actionIdName = this._es6Extension.actionIdName(httpClient);
        _builder.append(_actionIdName);
        _builder.append(" from \"../../../acegen/gen/");
        String _name = httpClient.getName();
        _builder.append(_name);
        _builder.append("/");
        CharSequence _actionIdName_1 = this._es6Extension.actionIdName(httpClient);
        _builder.append(_actionIdName_1);
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("const testId = ScenarioUtils.testId();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("context(\'");
    String _name_1 = it.getName();
    _builder.append(_name_1);
    _builder.append("\', () => {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("beforeEach(() => {");
    _builder.newLine();
    {
      ArrayList<ClientGivenRef> _allGivenItems = this.allGivenItems(it);
      for(final ClientGivenRef givenRef : _allGivenItems) {
        _builder.append("    \t");
        CharSequence _initNonDeterministicData = this.initNonDeterministicData(givenRef.getScenario().getWhenBlock());
        _builder.append(_initNonDeterministicData, "    \t");
        _builder.newLineIfNotEmpty();
        _builder.append("    \t");
        _builder.append("ScenarioUtils.getCypressFor(");
        EObject _eContainer = givenRef.getScenario().getWhenBlock().getAction().eContainer();
        CharSequence _actionIdName_2 = this._es6Extension.actionIdName(((HttpClient) _eContainer));
        _builder.append(_actionIdName_2, "    \t");
        _builder.append(".");
        String _firstLower = StringExtensions.toFirstLower(givenRef.getScenario().getWhenBlock().getAction().getName());
        _builder.append(_firstLower, "    \t");
        _builder.append(", ");
        {
          EList<InputValue> _inputValues = givenRef.getScenario().getWhenBlock().getInputValues();
          boolean _hasElements = false;
          for(final InputValue arg : _inputValues) {
            if (!_hasElements) {
              _hasElements = true;
              _builder.append("[", "    \t");
            } else {
              _builder.appendImmediate(",", "    \t");
            }
            Object _primitiveValueFrom = this._es6Extension.primitiveValueFrom(arg.getValue());
            _builder.append(_primitiveValueFrom, "    \t");
          }
          if (_hasElements) {
            _builder.append("]", "    \t");
          }
        }
        _builder.append(")");
        _builder.newLineIfNotEmpty();
        _builder.append("    \t");
        _builder.append("ScenarioUtils.wait(");
        int _numberOfSyncCalls = this._es6Extension.numberOfSyncCalls(givenRef.getScenario().getWhenBlock().getAction());
        _builder.append(_numberOfSyncCalls, "    \t");
        _builder.append(", ");
        int _numberOfAsyncCalls = this._es6Extension.numberOfAsyncCalls(givenRef.getScenario().getWhenBlock().getAction());
        _builder.append(_numberOfAsyncCalls, "    \t");
        _builder.append(")");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("    ");
    _builder.append("})");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("it(\'should change appState\', () => {");
    _builder.newLine();
    _builder.append("    \t");
    CharSequence _initNonDeterministicData_1 = this.initNonDeterministicData(it.getWhenBlock());
    _builder.append(_initNonDeterministicData_1, "    \t");
    _builder.newLineIfNotEmpty();
    _builder.append("    \t");
    _builder.append("ScenarioUtils.getCypressFor(");
    EObject _eContainer_1 = it.getWhenBlock().getAction().eContainer();
    CharSequence _actionIdName_3 = this._es6Extension.actionIdName(((HttpClient) _eContainer_1));
    _builder.append(_actionIdName_3, "    \t");
    _builder.append(".");
    String _firstLower_1 = StringExtensions.toFirstLower(it.getWhenBlock().getAction().getName());
    _builder.append(_firstLower_1, "    \t");
    _builder.append(", ");
    {
      EList<InputValue> _inputValues_1 = it.getWhenBlock().getInputValues();
      boolean _hasElements_1 = false;
      for(final InputValue arg_1 : _inputValues_1) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
          _builder.append("[", "    \t");
        } else {
          _builder.appendImmediate(",", "    \t");
        }
        Object _primitiveValueFrom_1 = this._es6Extension.primitiveValueFrom(arg_1.getValue());
        _builder.append(_primitiveValueFrom_1, "    \t");
      }
      if (_hasElements_1) {
        _builder.append("]", "    \t");
      }
    }
    _builder.append(").should(() => {");
    _builder.newLineIfNotEmpty();
    _builder.append("    \t\t");
    _builder.append("ScenarioUtils.wait(");
    int _numberOfSyncCalls_1 = this._es6Extension.numberOfSyncCalls(it.getWhenBlock().getAction());
    _builder.append(_numberOfSyncCalls_1, "    \t\t");
    _builder.append(", ");
    int _numberOfAsyncCalls_1 = this._es6Extension.numberOfAsyncCalls(it.getWhenBlock().getAction());
    _builder.append(_numberOfAsyncCalls_1, "    \t\t");
    _builder.append(").should(() => {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t            ");
    _builder.append("const appState = JSON.parse(localStorage.getItem(\'appState\'))");
    _builder.newLine();
    {
      EList<StateVerification> _stateVerifications = it.getThenBlock().getStateVerifications();
      for(final StateVerification stateVerification : _stateVerifications) {
        _builder.append("\t            ");
        _builder.append("expect(appState.");
        String _name_2 = stateVerification.getStateRef().getName();
        _builder.append(_name_2, "\t            ");
        _builder.append(", \"");
        String _name_3 = stateVerification.getName();
        _builder.append(_name_3, "\t            ");
        _builder.append("\").to.eql(");
        CharSequence _valueFrom = this._es6Extension.valueFrom(stateVerification.getValue());
        _builder.append(_valueFrom, "\t            ");
        _builder.append(")");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("    \t\t");
    _builder.append("})");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("})");
    _builder.newLine();
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
      String _uuid = it.getUuid();
      boolean _tripleNotEquals = (_uuid != null);
      if (_tripleNotEquals) {
        _builder.append("localStorage.setItem(\"uuid\", `");
        String _uuid_1 = it.getUuid();
        _builder.append(_uuid_1);
        _builder.append("`)");
        _builder.newLineIfNotEmpty();
        {
          String _serverSystemTime = it.getServerSystemTime();
          boolean _tripleNotEquals_1 = (_serverSystemTime != null);
          if (_tripleNotEquals_1) {
            _builder.append("AppUtils.httpPut(`/api/test/non-deterministic/system-time?uuid=");
            String _uuid_2 = it.getUuid();
            _builder.append(_uuid_2);
            _builder.append("&system-time=${new Date(\'");
            String _serverSystemTime_1 = it.getServerSystemTime();
            _builder.append(_serverSystemTime_1);
            _builder.append("\').toISOString()}`)");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      String _clientSystemTime = it.getClientSystemTime();
      boolean _tripleNotEquals_2 = (_clientSystemTime != null);
      if (_tripleNotEquals_2) {
        _builder.append("localStorage.setItem(\"clientSystemTime\", \"");
        String _clientSystemTime_1 = it.getClientSystemTime();
        _builder.append(_clientSystemTime_1);
        _builder.append("\")");
        _builder.newLineIfNotEmpty();
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
}
