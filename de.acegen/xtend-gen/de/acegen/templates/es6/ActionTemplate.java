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
package de.acegen.templates.es6;

import de.acegen.aceGen.HttpClient;
import de.acegen.aceGen.HttpClientAce;
import de.acegen.aceGen.Input;
import de.acegen.aceGen.SingleClientAttribute;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.es6.AceExtension;
import de.acegen.extensions.es6.Es6Extension;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ActionTemplate {
  @Inject
  @Extension
  private AceExtension _aceExtension;
  
  @Inject
  @Extension
  private Es6Extension _es6Extension;
  
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  public CharSequence generateAbstractActionFile(final HttpClientAce it, final HttpClient es6) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import Action from \"../../ace/");
    {
      if ((it.isAsync() || (it.getServerCall() != null))) {
        _builder.append("AsynchronousAction");
      } else {
        _builder.append("SynchronousAction");
      }
    }
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    {
      int _size = it.getOutcomes().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _builder.append("import ");
        String _commandName = this._aceExtension.commandName(it);
        _builder.append(_commandName);
        _builder.append(" from \"../../../src/");
        String _name = es6.getName();
        _builder.append(_name);
        _builder.append("/commands/");
        String _commandName_1 = this._aceExtension.commandName(it);
        _builder.append(_commandName_1);
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      SingleClientAttribute _loadingFlag = it.getLoadingFlag();
      boolean _tripleNotEquals = (_loadingFlag != null);
      if (_tripleNotEquals) {
        _builder.append("import * as AppState from \"../../ace/AppState\";");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("export default class ");
    String _abstractActionName = this._aceExtension.abstractActionName(it);
    _builder.append(_abstractActionName);
    _builder.append(" extends Action {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("constructor(");
    {
      EList<Input> _input = it.getInput();
      boolean _hasElements = false;
      for(final Input inputParam : _input) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "    ");
        }
        _builder.append(" ");
        String _name_1 = inputParam.getName();
        _builder.append(_name_1, "    ");
      }
    }
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("super({");
    {
      EList<Input> _input_1 = it.getInput();
      boolean _hasElements_1 = false;
      for(final Input inputParam_1 : _input_1) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          _builder.appendImmediate(", ", "        ");
        }
        String _name_2 = inputParam_1.getName();
        _builder.append(_name_2, "        ");
      }
    }
    _builder.append("}, \'");
    String _name_3 = es6.getName();
    _builder.append(_name_3, "        ");
    _builder.append(".");
    String _actionName = this._aceExtension.actionName(it);
    _builder.append(_actionName, "        ");
    _builder.append("\');");
    _builder.newLineIfNotEmpty();
    {
      SingleClientAttribute _loadingFlag_1 = it.getLoadingFlag();
      boolean _tripleNotEquals_1 = (_loadingFlag_1 != null);
      if (_tripleNotEquals_1) {
        _builder.append("\t\t");
        _builder.append("this.postCall = this.postCall.bind(this);");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    {
      int _size_1 = it.getOutcomes().size();
      boolean _greaterThan_1 = (_size_1 > 0);
      if (_greaterThan_1) {
        _builder.append("\t");
        _builder.append("getCommand() {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return new ");
        String _commandName_2 = this._aceExtension.commandName(it);
        _builder.append(_commandName_2, "\t\t");
        _builder.append("(this.actionData);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    {
      SingleClientAttribute _loadingFlag_2 = it.getLoadingFlag();
      boolean _tripleNotEquals_2 = (_loadingFlag_2 != null);
      if (_tripleNotEquals_2) {
        _builder.append("\t");
        _builder.append("preCall() {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("AppState.set_");
        String _functionName = this._es6Extension.functionName(it.getLoadingFlag());
        _builder.append(_functionName, "\t\t");
        _builder.append("({");
        String _name_4 = it.getLoadingFlag().getName();
        _builder.append(_name_4, "\t\t");
        _builder.append(": true});");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("postCall() {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("AppState.set_");
        String _functionName_1 = this._es6Extension.functionName(it.getLoadingFlag());
        _builder.append(_functionName_1, "\t\t");
        _builder.append("({");
        String _name_5 = it.getLoadingFlag().getName();
        _builder.append(_name_5, "\t\t");
        _builder.append(": false});");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
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
  
  public CharSequence generateInitialActionFile(final HttpClientAce it, final HttpClient es6) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import ");
    String _abstractActionName = this._aceExtension.abstractActionName(it);
    _builder.append(_abstractActionName);
    _builder.append(" from \"../../../gen/");
    String _name = es6.getName();
    _builder.append(_name);
    _builder.append("/actions/");
    String _abstractActionName_1 = this._aceExtension.abstractActionName(it);
    _builder.append(_abstractActionName_1);
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("export default class ");
    String _actionName = this._aceExtension.actionName(it);
    _builder.append(_actionName);
    _builder.append(" extends ");
    String _abstractActionName_2 = this._aceExtension.abstractActionName(it);
    _builder.append(_abstractActionName_2);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("initActionData() {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("//add not replayable data to action data in order to freeze for replay (e.g. time or date)");
    _builder.newLine();
    _builder.append("    ");
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
  
  public CharSequence generateActionFunctionExports(final HttpClient it) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      EList<HttpClientAce> _aceOperations = it.getAceOperations();
      for(final HttpClientAce aceOperation : _aceOperations) {
        _builder.append("import ");
        String _actionName = this._aceExtension.actionName(aceOperation);
        _builder.append(_actionName);
        _builder.append(" from \"../../src/");
        String _name = it.getName();
        _builder.append(_name);
        _builder.append("/actions/");
        String _actionName_1 = this._aceExtension.actionName(aceOperation);
        _builder.append(_actionName_1);
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    {
      EList<HttpClientAce> _aceOperations_1 = it.getAceOperations();
      for(final HttpClientAce aceOperation_1 : _aceOperations_1) {
        _builder.append("export function ");
        String _firstLower = StringExtensions.toFirstLower(aceOperation_1.getName());
        _builder.append(_firstLower);
        _builder.append("(");
        {
          EList<Input> _input = aceOperation_1.getInput();
          boolean _hasElements = false;
          for(final Input attr : _input) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(", ", "");
            }
            String _name_1 = attr.getName();
            _builder.append(_name_1);
          }
        }
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("new ");
        String _actionName_2 = this._aceExtension.actionName(aceOperation_1);
        _builder.append(_actionName_2, "    ");
        _builder.append("(");
        {
          EList<Input> _input_1 = aceOperation_1.getInput();
          boolean _hasElements_1 = false;
          for(final Input attr_1 : _input_1) {
            if (!_hasElements_1) {
              _hasElements_1 = true;
            } else {
              _builder.appendImmediate(", ", "    ");
            }
            String _name_2 = attr_1.getName();
            _builder.append(_name_2, "    ");
          }
        }
        _builder.append(").apply();");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateActionIds(final HttpClient it) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("module.exports = {");
    _builder.newLine();
    {
      EList<HttpClientAce> _aceOperations = it.getAceOperations();
      boolean _hasElements = false;
      for(final HttpClientAce aceOperation : _aceOperations) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "\t");
        }
        _builder.append("\t");
        String _firstLower = StringExtensions.toFirstLower(aceOperation.getName());
        _builder.append(_firstLower, "\t");
        _builder.append(" : \"");
        String _packageFolder = this._es6Extension.packageFolder(it);
        _builder.append(_packageFolder, "\t");
        _builder.append("_");
        String _firstLower_1 = StringExtensions.toFirstLower(aceOperation.getName());
        _builder.append(_firstLower_1, "\t");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
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
  
  public CharSequence generateAction() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import ACEController from \"./ACEController\";");
    _builder.newLine();
    _builder.append("import AppUtils from \"../../src/app/AppUtils\";");
    _builder.newLine();
    _builder.append("import Utils from \"./Utils\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export default class Action {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("constructor(actionData, actionName) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("this.actionName = actionName;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (actionData === undefined) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("actionData = {};");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("this.actionData = AppUtils.deepCopy(actionData);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (Utils.settings.mode === \"dev\") {");
    _builder.newLine();
    _builder.append("        \t");
    _builder.append("let nonDeterministicValues = JSON.parse(localStorage.getItem(\"nonDeterministicValues\"));");
    _builder.newLine();
    _builder.append("        \t");
    _builder.append("if (nonDeterministicValues) {");
    _builder.newLine();
    _builder.append("        \t\t");
    _builder.append("const nonDeterministicValue = nonDeterministicValues.shift();");
    _builder.newLine();
    _builder.append("        \t\t");
    _builder.append("if (nonDeterministicValue) {");
    _builder.newLine();
    _builder.append("\t        \t\t");
    _builder.append("this.actionData.uuid = nonDeterministicValue.uuid;");
    _builder.newLine();
    _builder.append("\t        \t\t");
    _builder.append("this.actionData.clientSystemTime = nonDeterministicValue.clientSystemTime;");
    _builder.newLine();
    _builder.append("\t        \t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        \t\t");
    _builder.append("localStorage.setItem(\'nonDeterministicValues\', JSON.stringify(nonDeterministicValues));");
    _builder.newLine();
    _builder.append("        \t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        \t");
    _builder.append("if (this.actionData.uuid === null) {");
    _builder.newLine();
    _builder.append("        \t\t");
    _builder.append("this.actionData.uuid = AppUtils.createUUID();");
    _builder.newLine();
    _builder.append("        \t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        \t");
    _builder.append("if (this.actionData.clientSystemTime === null) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("this.actionData.clientSystemTime = new Date();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("this.actionData.uuid = AppUtils.createUUID();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("this.actionData.clientSystemTime = new Date();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("initActionData() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("getCommand() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("throw \"no command defined for \" + this.actionName;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("apply() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("ACEController.addActionToQueue(this);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
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
  
  public CharSequence generateAsynchronousAction() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import ACEController from \"./ACEController\";");
    _builder.newLine();
    _builder.append("import Action from \"./Action\";");
    _builder.newLine();
    _builder.append("import AppUtils from \"../../src/app/AppUtils\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export default class AsynchronousAction extends Action {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("constructor(actionData, actionName) {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("super(actionData, actionName);");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("this.asynchronous = true;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("applyAction() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return new Promise((resolve, reject) => {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("ACEController.addItemToTimeLine({action: this});");
    _builder.newLine();
    _builder.append("        \t");
    _builder.append("this.preCall();");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("this.initActionData();");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("let command = this.getCommand();");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("command.executeCommand().then(() => {");
    _builder.newLine();
    _builder.append("\t\t\t    ");
    _builder.append("this.postCall();");
    _builder.newLine();
    _builder.append("\t\t\t    ");
    _builder.append("resolve();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}, (error) => {");
    _builder.newLine();
    _builder.append("\t\t\t    ");
    _builder.append("this.postCall();");
    _builder.newLine();
    _builder.append("\t\t\t    ");
    _builder.append("reject(error);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("});");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("preCall() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("postCall() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("}");
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
  
  public CharSequence generateSynchronousAction() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import ACEController from \"./ACEController\";");
    _builder.newLine();
    _builder.append("import Action from \"./Action\";");
    _builder.newLine();
    _builder.append("import AppUtils from \"../../src/app/AppUtils\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export default class SynchronousAction extends Action {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("constructor(actionData, actionName) {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("super(actionData, actionName);");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("this.asynchronous = false;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("applyAction() {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("ACEController.addItemToTimeLine({action: this});");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("this.initActionData();");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("let command = this.getCommand();");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("command.executeCommand();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
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
