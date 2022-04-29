package de.acegen.templates.es6;

import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.ClientAttribute;
import de.acegen.aceGen.ClientGivenRef;
import de.acegen.aceGen.ClientScenario;
import de.acegen.aceGen.ClientWhenBlock;
import de.acegen.aceGen.ClientWhenThen;
import de.acegen.aceGen.CustomVerification;
import de.acegen.aceGen.HttpClient;
import de.acegen.aceGen.InputValue;
import de.acegen.aceGen.SquishyValue;
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
    _builder.append("const { Builder} = require(\'selenium-webdriver\');");
    _builder.newLine();
    _builder.append("const chrome = require(\'selenium-webdriver/chrome\');");
    _builder.newLine();
    _builder.newLine();
    _builder.append("module.exports = {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("tearDown: async function(driver) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("await driver.quit();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("},");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("invokeAction: async function(driver, action, args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throw \"invokeAction not implemented\";");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("},");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("waitInMillis: async function(millis) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return new Promise(function(resolve){");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("setTimeout(resolve,millis);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("});");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("},");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("getAppState: async function(driver) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return await driver.executeScript(\'return appName.getAppState()\');");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("},");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("generateTestId: function() {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("let d = new Date().getTime();");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("return \'xxxxxxxx\'.replace(/[xy]/g, function (c) {");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("let r = (d + Math.random() * 16) % 16 | 0;");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("d = Math.floor(d / 16);");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("return (c === \'x\' ? r : (r & 0x3 | 0x8)).toString(16);");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("},");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("addSquishyValueClient: async function(driver, value) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("const jsonValue = JSON.stringify(value);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("await driver.executeScript(`appName.addSquishyValueClient(\'${jsonValue}\')`);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("},");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("addSquishyValueServer: async function(driver, uuid, key, value) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("await driver.executeScript(`appName.addSquishyValueServer(\"${uuid}\", \"${key}\", \"${value}\")`);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("},");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("defaultTimeout: 30 * 1000,");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("browserName: \"firefox\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("createDriver: function() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return new Builder()");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append(".forBrowser(ScenarioUtils.browserName)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append(".build();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}\t");
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
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateScenario(final ClientScenario it, final HttpClient httpClient) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("const ScenarioUtils = require(\"../../src/ScenarioUtils\");");
    _builder.newLine();
    {
      List<HttpClient> _allReferencedHttpClients = this._es6Extension.allReferencedHttpClients(it);
      for(final HttpClient referencedHttpClient : _allReferencedHttpClients) {
        _builder.append("const ");
        CharSequence _actionIdName = this._es6Extension.actionIdName(referencedHttpClient);
        _builder.append(_actionIdName);
        _builder.append("  = require(\"../../gen/actionIds/");
        String _name = referencedHttpClient.getName();
        _builder.append(_name);
        _builder.append("/");
        CharSequence _actionIdName_1 = this._es6Extension.actionIdName(referencedHttpClient);
        _builder.append(_actionIdName_1);
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      int _size = this._es6Extension.allVerifications(it).size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _builder.append("const Verifications = require(\"../../src/");
        String _name_1 = httpClient.getName();
        _builder.append(_name_1);
        _builder.append("/");
        String _name_2 = it.getName();
        _builder.append(_name_2);
        _builder.append("Verifications\");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("jasmine.DEFAULT_TIMEOUT_INTERVAL = ScenarioUtils.defaultTimeout;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("const testId = ScenarioUtils.generateTestId();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("let driver;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("let appStates = {};");
    _builder.newLine();
    _builder.append("let verifications = {};");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("describe(\"");
    String _name_3 = httpClient.getName();
    _builder.append(_name_3);
    _builder.append(".");
    String _name_4 = it.getName();
    _builder.append(_name_4);
    _builder.append("\", function () {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("beforeAll(async function () {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("driver = ScenarioUtils.createDriver();");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("let appState;");
    _builder.newLine();
    {
      ArrayList<ClientGivenRef> _allGivenItems = this.allGivenItems(it);
      for(final ClientGivenRef givenRef : _allGivenItems) {
        {
          EList<ClientWhenThen> _clientWhenThen = givenRef.getScenario().getClientWhenThen();
          for(final ClientWhenThen whenThenItem : _clientWhenThen) {
            _builder.append("\t\t");
            CharSequence _initSquishyData = this.initSquishyData(whenThenItem.getWhenBlock());
            _builder.append(_initSquishyData, "\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("await ScenarioUtils.invokeAction(driver, ");
            EObject _eContainer = whenThenItem.getWhenBlock().getAction().eContainer();
            CharSequence _actionIdName_2 = this._es6Extension.actionIdName(((HttpClient) _eContainer));
            _builder.append(_actionIdName_2, "\t\t");
            _builder.append(".");
            String _firstLower = StringExtensions.toFirstLower(whenThenItem.getWhenBlock().getAction().getName());
            _builder.append(_firstLower, "\t\t");
            {
              EList<InputValue> _inputValues = whenThenItem.getWhenBlock().getInputValues();
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
              int _delayInMillis = whenThenItem.getDelayInMillis();
              boolean _greaterThan_1 = (_delayInMillis > 0);
              if (_greaterThan_1) {
                _builder.append("\t\t");
                _builder.append("await ScenarioUtils.waitInMillis(");
                int _delayInMillis_1 = whenThenItem.getDelayInMillis();
                _builder.append(_delayInMillis_1, "\t\t");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    _builder.newLine();
    {
      EList<ClientWhenThen> _clientWhenThen_1 = it.getClientWhenThen();
      for(final ClientWhenThen whenThenItem_1 : _clientWhenThen_1) {
        {
          ClientWhenBlock _whenBlock = whenThenItem_1.getWhenBlock();
          boolean _tripleNotEquals = (_whenBlock != null);
          if (_tripleNotEquals) {
            _builder.append("\t\t");
            CharSequence _initSquishyData_1 = this.initSquishyData(whenThenItem_1.getWhenBlock());
            _builder.append(_initSquishyData_1, "\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("await ScenarioUtils.invokeAction(driver, ");
            EObject _eContainer_1 = whenThenItem_1.getWhenBlock().getAction().eContainer();
            CharSequence _actionIdName_3 = this._es6Extension.actionIdName(((HttpClient) _eContainer_1));
            _builder.append(_actionIdName_3, "\t\t");
            _builder.append(".");
            String _firstLower_1 = StringExtensions.toFirstLower(whenThenItem_1.getWhenBlock().getAction().getName());
            _builder.append(_firstLower_1, "\t\t");
            {
              EList<InputValue> _inputValues_1 = whenThenItem_1.getWhenBlock().getInputValues();
              boolean _hasElements_1 = false;
              for(final InputValue arg_1 : _inputValues_1) {
                if (!_hasElements_1) {
                  _hasElements_1 = true;
                  _builder.append(", [", "\t\t");
                } else {
                  _builder.appendImmediate(",", "\t\t");
                }
                Object _primitiveValueFrom_1 = this._es6Extension.primitiveValueFrom(arg_1.getValue());
                _builder.append(_primitiveValueFrom_1, "\t\t");
              }
              if (_hasElements_1) {
                _builder.append("]", "\t\t");
              }
            }
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("await ScenarioUtils.waitInMillis(10);");
            _builder.newLine();
            {
              int _delayInMillis_2 = whenThenItem_1.getDelayInMillis();
              boolean _greaterThan_2 = (_delayInMillis_2 > 0);
              if (_greaterThan_2) {
                _builder.append("\t\t");
                _builder.append("await ScenarioUtils.waitInMillis(");
                int _delayInMillis_3 = whenThenItem_1.getDelayInMillis();
                _builder.append(_delayInMillis_3, "\t\t");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
              }
            }
          } else {
            int _delayInMillis_4 = whenThenItem_1.getDelayInMillis();
            boolean _greaterThan_3 = (_delayInMillis_4 > 0);
            if (_greaterThan_3) {
              _builder.append("\t\t");
              _builder.append("await ScenarioUtils.waitInMillis(");
              int _delayInMillis_5 = whenThenItem_1.getDelayInMillis();
              _builder.append(_delayInMillis_5, "\t\t");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
        }
        _builder.append("\t\t");
        _builder.newLine();
        {
          if (((whenThenItem_1.getThenBlock() != null) && (whenThenItem_1.getThenBlock().getStateVerifications() != null))) {
            _builder.append("\t\t");
            _builder.append("appState = await ScenarioUtils.getAppState(driver);");
            _builder.newLine();
            {
              EList<StateVerification> _stateVerifications = whenThenItem_1.getThenBlock().getStateVerifications();
              for(final StateVerification stateVerification : _stateVerifications) {
                _builder.append("\t\t");
                _builder.append("appStates.");
                String _name_5 = stateVerification.getName();
                _builder.append(_name_5, "\t\t");
                _builder.append(" = appState;");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t\t");
            _builder.newLine();
          }
        }
        {
          if (((whenThenItem_1.getThenBlock() != null) && (whenThenItem_1.getThenBlock().getVerifications() != null))) {
            {
              EList<CustomVerification> _verifications = whenThenItem_1.getThenBlock().getVerifications();
              for(final CustomVerification verification : _verifications) {
                {
                  ClientAttribute _stateRef = verification.getStateRef();
                  boolean _tripleNotEquals_1 = (_stateRef != null);
                  if (_tripleNotEquals_1) {
                    _builder.append("\t\t");
                    _builder.append("verifications.");
                    String _functionName = verification.getFunctionName();
                    _builder.append(_functionName, "\t\t");
                    _builder.append(" = await Verifications.");
                    String _functionName_1 = verification.getFunctionName();
                    _builder.append(_functionName_1, "\t\t");
                    _builder.append("(appState.");
                    String _stateRefPath = this._es6Extension.stateRefPath(verification.getStateRef());
                    _builder.append(_stateRefPath, "\t\t");
                    _builder.append(");");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("\t\t");
                    _builder.append("verifications.");
                    String _functionName_2 = verification.getFunctionName();
                    _builder.append(_functionName_2, "\t\t");
                    _builder.append(" = await Verifications.");
                    String _functionName_3 = verification.getFunctionName();
                    _builder.append(_functionName_3, "\t\t");
                    _builder.append("(driver, testId);");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
            _builder.append("\t\t");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("    ");
    _builder.append("});");
    _builder.newLine();
    _builder.newLine();
    {
      EList<ClientWhenThen> _clientWhenThen_2 = it.getClientWhenThen();
      for(final ClientWhenThen whenThenItem_2 : _clientWhenThen_2) {
        {
          if (((whenThenItem_2.getThenBlock() != null) && (whenThenItem_2.getThenBlock().getStateVerifications() != null))) {
            {
              EList<StateVerification> _stateVerifications_1 = whenThenItem_2.getThenBlock().getStateVerifications();
              for(final StateVerification stateVerification_1 : _stateVerifications_1) {
                _builder.append("\t");
                _builder.append("it(\"");
                String _name_6 = stateVerification_1.getName();
                _builder.append(_name_6, "\t");
                _builder.append("\", async () => {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("expect(appStates.");
                String _name_7 = stateVerification_1.getName();
                _builder.append(_name_7, "\t\t");
                _builder.append(".");
                String _stateRefPath_1 = this._es6Extension.stateRefPath(stateVerification_1.getStateRef());
                _builder.append(_stateRefPath_1, "\t\t");
                _builder.append(", \"");
                String _name_8 = stateVerification_1.getName();
                _builder.append(_name_8, "\t\t");
                _builder.append("\")");
                {
                  boolean _isNot = stateVerification_1.isNot();
                  boolean _equals = (_isNot == true);
                  if (_equals) {
                    _builder.append(".not");
                  }
                }
                _builder.append(".toEqual(");
                CharSequence _valueFrom = this._es6Extension.valueFrom(stateVerification_1.getValue());
                _builder.append(_valueFrom, "\t\t");
                _builder.append(")");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("});");
                _builder.newLine();
              }
            }
          }
        }
        _builder.append("\t");
        _builder.newLine();
        {
          if (((whenThenItem_2.getThenBlock() != null) && (whenThenItem_2.getThenBlock().getVerifications() != null))) {
            {
              EList<CustomVerification> _verifications_1 = whenThenItem_2.getThenBlock().getVerifications();
              for(final CustomVerification verification_1 : _verifications_1) {
                _builder.append("\t");
                _builder.append("it(\"");
                _builder.append(verification_1, "\t");
                _builder.append("\", async () => {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("expect(verifications.");
                String _functionName_4 = verification_1.getFunctionName();
                _builder.append(_functionName_4, "\t\t");
                _builder.append(", \"verifications.");
                String _functionName_5 = verification_1.getFunctionName();
                _builder.append(_functionName_5, "\t\t");
                _builder.append("\").toBeTrue();");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("});");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    _builder.newLine();
    _builder.append("    ");
    _builder.append("afterAll(async function () {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("await ScenarioUtils.tearDown(driver);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("});");
    _builder.newLine();
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
  
  private CharSequence initSquishyData(final ClientWhenBlock it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (((it.getSquishyValues() != null) && (it.getSquishyValues().size() > 0))) {
        {
          EList<SquishyValue> _squishyValues = it.getSquishyValues();
          for(final SquishyValue squishyValue : _squishyValues) {
            _builder.append("await ScenarioUtils.addSquishyValueClient(");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("driver,");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("{");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("uuid: `");
            String _uuid = squishyValue.getUuid();
            _builder.append(_uuid, "\t\t");
            _builder.append("`");
            {
              String _clientSystemTime = squishyValue.getClientSystemTime();
              boolean _tripleNotEquals = (_clientSystemTime != null);
              if (_tripleNotEquals) {
                _builder.append(",");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("clientSystemTime: `");
                String _clientSystemTime_1 = squishyValue.getClientSystemTime();
                _builder.append(_clientSystemTime_1, "\t\t");
                _builder.append("`");
              }
            }
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append(");");
            _builder.newLine();
            {
              String _serverSystemTime = squishyValue.getServerSystemTime();
              boolean _tripleNotEquals_1 = (_serverSystemTime != null);
              if (_tripleNotEquals_1) {
                _builder.append("await ScenarioUtils.addSquishyValueServer(driver, `");
                String _uuid_1 = squishyValue.getUuid();
                _builder.append(_uuid_1);
                _builder.append("`, \"system-time\", new Date(\'");
                String _serverSystemTime_1 = squishyValue.getServerSystemTime();
                _builder.append(_serverSystemTime_1);
                _builder.append("\').toISOString());");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              Attribute _attribute = squishyValue.getAttribute();
              boolean _tripleNotEquals_2 = (_attribute != null);
              if (_tripleNotEquals_2) {
                _builder.append("await ScenarioUtils.addSquishyValueServer(driver, `");
                String _uuid_2 = squishyValue.getUuid();
                _builder.append(_uuid_2);
                _builder.append("`, \"");
                String _firstLower = StringExtensions.toFirstLower(squishyValue.getAttribute().getName());
                _builder.append(_firstLower);
                _builder.append("\", `");
                Object _primitiveParamFrom = this._es6Extension.primitiveParamFrom(squishyValue.getValue());
                _builder.append(_primitiveParamFrom);
                _builder.append("`);");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    return _builder;
  }
  
  private ArrayList<ClientGivenRef> allGivenItems(final ClientScenario it) {
    ArrayList<ClientGivenRef> allWhenBlocks = new ArrayList<ClientGivenRef>();
    EList<ClientGivenRef> _givenRefs = it.getGivenRefs();
    for (final ClientGivenRef given : _givenRefs) {
      boolean _isExcludeGiven = given.isExcludeGiven();
      if (_isExcludeGiven) {
        allWhenBlocks.add(given);
      } else {
        if ((given instanceof ClientGivenRef)) {
          this.allGivenItemsRec(given, allWhenBlocks);
        }
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
    _builder.append("module.exports = {");
    _builder.newLine();
    {
      List<CustomVerification> _allVerifications = this._es6Extension.allVerifications(it);
      boolean _hasElements = false;
      for(final CustomVerification verification : _allVerifications) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "\t");
        }
        {
          ClientAttribute _stateRef = verification.getStateRef();
          boolean _tripleNotEquals = (_stateRef != null);
          if (_tripleNotEquals) {
            _builder.append("\t");
            String _functionName = verification.getFunctionName();
            _builder.append(_functionName, "\t");
            _builder.append(": async function(actual) {");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("\t");
            String _functionName_1 = verification.getFunctionName();
            _builder.append(_functionName_1, "\t");
            _builder.append(": async function(driver, testId) {");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("fail(\"");
        String _functionName_2 = verification.getFunctionName();
        _builder.append(_functionName_2, "\t\t");
        _builder.append(" not implemented\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
}
