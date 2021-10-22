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

import de.acegen.aceGen.ClientAttribute;
import de.acegen.aceGen.HttpClient;
import de.acegen.aceGen.HttpClientAce;
import de.acegen.aceGen.Input;
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
      ClientAttribute _loadingFlag = it.getLoadingFlag();
      boolean _tripleNotEquals = (_loadingFlag != null);
      if (_tripleNotEquals) {
        _builder.append("import * as AppState from \"../../../src/AppState\";");
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
    _builder.append("constructor() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("super(\'");
    String _name_1 = es6.getName();
    _builder.append(_name_1, "        ");
    _builder.append(".");
    String _actionName = this._aceExtension.actionName(it);
    _builder.append(_actionName, "        ");
    _builder.append("\');");
    _builder.newLineIfNotEmpty();
    {
      ClientAttribute _loadingFlag_1 = it.getLoadingFlag();
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
        _builder.append("();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    {
      ClientAttribute _loadingFlag_2 = it.getLoadingFlag();
      boolean _tripleNotEquals_2 = (_loadingFlag_2 != null);
      if (_tripleNotEquals_2) {
        _builder.append("\t");
        _builder.append("preCall() {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        ClientAttribute _loadingFlag_3 = it.getLoadingFlag();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("{");
        String _name_2 = it.getLoadingFlag().getName();
        _builder_1.append(_name_2);
        _builder_1.append(": true}");
        CharSequence _stateFunctionCall = this._es6Extension.stateFunctionCall(_loadingFlag_3, "set", _builder_1.toString());
        _builder.append(_stateFunctionCall, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("AppState.stateUpdated();");
        _builder.newLine();
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
        ClientAttribute _loadingFlag_4 = it.getLoadingFlag();
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("{");
        String _name_3 = it.getLoadingFlag().getName();
        _builder_2.append(_name_3);
        _builder_2.append(": false}");
        CharSequence _stateFunctionCall_1 = this._es6Extension.stateFunctionCall(_loadingFlag_4, "set", _builder_2.toString());
        _builder.append(_stateFunctionCall_1, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("AppState.stateUpdated();");
        _builder.newLine();
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
    _builder.append("initActionData(data) {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return data;");
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
        _builder.append("return new ");
        String _actionName_2 = this._aceExtension.actionName(aceOperation_1);
        _builder.append(_actionName_2, "    ");
        _builder.append("().apply({");
        {
          EList<Input> _input_1 = aceOperation_1.getInput();
          boolean _hasElements_1 = false;
          for(final Input inputParam : _input_1) {
            if (!_hasElements_1) {
              _hasElements_1 = true;
            } else {
              _builder.appendImmediate(", ", "    ");
            }
            String _name_2 = inputParam.getName();
            _builder.append(_name_2, "    ");
          }
        }
        _builder.append("});");
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
    _builder.newLine();
    _builder.append("import * as ACEController from \"./ACEController\";");
    _builder.newLine();
    _builder.append("import * as AppUtils from \"../../src/AppUtils\";");
    _builder.newLine();
    _builder.append("import * as AppState from \"../../src/AppState\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export default class Action {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("constructor(actionName) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("this.actionName = actionName;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("apply(data) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return new Promise((resolve) => {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("ACEController.addItemToTimeLine({");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("appState: AppState.get([])");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("ACEController.addItemToTimeLine({");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("action: {");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("actionName: this.actionName,");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("data");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("if (AppUtils.settings.mode === \"dev\" && typeof window !== \"undefined\") {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("let squishyValues = JSON.parse(localStorage.getItem(\"squishyValues\"));");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("if (squishyValues && squishyValues.length > 0) {");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("const squishyValue = JSON.parse(squishyValues.shift());");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("if (squishyValue) {");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("data.uuid = squishyValue.uuid;");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("data.clientSystemTime = squishyValue.clientSystemTime;");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("localStorage.setItem(\'squishyValues\', JSON.stringify(squishyValues));");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("if (!data.uuid) {");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("data.uuid = AppUtils.createUUID();");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("if (!data.clientSystemTime) {");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("data.clientSystemTime = new Date();");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("data.uuid = AppUtils.createUUID();");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("data.clientSystemTime = new Date();");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("this.applyAction(data).then(");
    _builder.newLine();
    _builder.append("\t\t\t    ");
    _builder.append("resolve,");
    _builder.newLine();
    _builder.append("\t\t\t    ");
    _builder.append("(error) => {");
    _builder.newLine();
    _builder.append("\t\t\t        ");
    _builder.append("AppUtils.displayUnexpectedError(error);");
    _builder.newLine();
    _builder.append("\t\t\t    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append(");");
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
    _builder.append("applyAction(data) {");
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
    _builder.newLine();
    _builder.append("import Action from \"./Action\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export default class AsynchronousAction extends Action {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("constructor(actionName, callback) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("super(actionName, callback);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("this.asynchronous = true;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("applyAction(data) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return new Promise((resolve, reject) => {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("this.preCall();");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("data = this.initActionData(data);");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("let command = this.getCommand();");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("command.executeCommand(data).then(() => {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("this.postCall();");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("resolve();");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}, (error) => {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("this.postCall();");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("reject(error);");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("preCall() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("postCall() {");
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
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateSynchronousAction() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import Action from \"./Action\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export default class SynchronousAction extends Action {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("constructor(actionName, callback) {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("super(actionName, callback);");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("this.asynchronous = false;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("applyAction(data) {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return new Promise((resolve) => {");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("data = this.initActionData(data);");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("let command = this.getCommand();");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("command.executeCommand(data).then(resolve);");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("});");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
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
}
