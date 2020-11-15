package de.acegen.templates.es6;

import de.acegen.aceGen.ClientGivenRef;
import de.acegen.aceGen.ClientScenario;
import de.acegen.aceGen.HttpClient;
import de.acegen.aceGen.InputValue;
import de.acegen.aceGen.StateVerification;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.es6.Es6Extension;
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
    _builder.append("import * as ScenarioUtils from \"../../src/ScenarioUtils\";");
    _builder.newLine();
    {
      List<HttpClient> _allReferencedHttpClients = this._es6Extension.allReferencedHttpClients(it);
      for(final HttpClient httpClient : _allReferencedHttpClients) {
        _builder.append("import * as ");
        CharSequence _actionIdName = this._es6Extension.actionIdName(httpClient);
        _builder.append(_actionIdName);
        _builder.append(" from \"../");
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
      EList<ClientGivenRef> _givenRefs = it.getGivenRefs();
      for(final ClientGivenRef givenRef : _givenRefs) {
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
      }
    }
    _builder.append("    \t");
    _builder.newLine();
    {
      String _uuid = it.getWhenBlock().getUuid();
      boolean _tripleNotEquals = (_uuid != null);
      if (_tripleNotEquals) {
        _builder.append("    \t");
        _builder.append("localStorage.setItem(\"uuid\", \"whenBlock.uuid\")");
        _builder.newLine();
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
    _builder.append("ScenarioUtils.wait(500).should(() => {");
    _builder.newLine();
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
}
