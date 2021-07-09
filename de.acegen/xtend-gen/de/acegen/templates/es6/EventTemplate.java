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
import de.acegen.aceGen.HttpClientOutcome;
import de.acegen.aceGen.HttpClientStateFunction;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.es6.AceExtension;
import de.acegen.extensions.es6.Es6Extension;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class EventTemplate {
  @Inject
  @Extension
  private AceExtension _aceExtension;
  
  @Inject
  @Extension
  private Es6Extension _es6Extension;
  
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  public CharSequence generateEventListenerRegistration(final HttpClient it) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import * as ACEController from \"../ace/ACEController\";");
    _builder.newLine();
    _builder.append("import * as AppState from \"../ace/AppState\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export default class EventListenerRegistration");
    String _projectName = this._es6Extension.projectName(it);
    _builder.append(_projectName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static init() {");
    _builder.newLine();
    {
      EList<HttpClientAce> _aceOperations = it.getAceOperations();
      for(final HttpClientAce aceOperation : _aceOperations) {
        {
          EList<HttpClientOutcome> _outcomes = aceOperation.getOutcomes();
          for(final HttpClientOutcome outcome : _outcomes) {
            {
              EList<HttpClientStateFunction> _listeners = outcome.getListeners();
              for(final HttpClientStateFunction listener : _listeners) {
                _builder.append("\t\t");
                _builder.append("ACEController.registerListener(\'");
                String _name = it.getName();
                _builder.append(_name, "\t\t");
                _builder.append(".");
                String _eventName = this._aceExtension.eventName(aceOperation, outcome);
                _builder.append(_eventName, "\t\t");
                _builder.append("\', ");
                String _appStateFunction = this._es6Extension.appStateFunction(listener);
                _builder.append(_appStateFunction, "\t\t");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
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
  
  public CharSequence generateEvent() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import * as ACEController from \"./ACEController\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export default class Event {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("constructor(eventName) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("this.eventName = eventName;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("publish(data) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ACEController.addItemToTimeLine({");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("event: {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("eventName: this.eventName,");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("data");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}});");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("this.notifyListeners(data);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("replay(data) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("this.notifyListeners(data);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("notifyListeners(data) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("let i, listener;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (this.eventName !== undefined) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("const listenersForEvent = ACEController.listeners[this.eventName];");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("if (listenersForEvent !== undefined) {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("for (i = 0; i < listenersForEvent.length; i += 1) {");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("listener = listenersForEvent[i];");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("listener(data);");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
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
  
  public CharSequence generateTriggerAction() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import * as ACEController from \"./ACEController\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export default class TriggerAction {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("publish(action, data) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ACEController.addItemToTimeLine({");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("event: {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("eventName: \'TriggerAction\',");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("action: {");
    _builder.newLine();
    _builder.append("                \t");
    _builder.append("actionName: action.actionName,");
    _builder.newLine();
    _builder.append("                \t");
    _builder.append("data");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}});");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("action.apply(data);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("publishWithDelay(action, data, delayInMillis) {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("setTimeout(() => {");
    _builder.newLine();
    _builder.append("    \t\t");
    _builder.append("this.publish(action, data);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}, delayInMillis);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("publishWithDelayTakeLatest(action, data, delayInMillis) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("const existingTimeout = ACEController.delayedActions[action.actionName];");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (existingTimeout) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("clearTimeout(existingTimeout);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ACEController.delayedActions[action.actionName] = setTimeout(() => {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("ACEController.delayedActions[action.actionName] = undefined;");
    _builder.newLine();
    _builder.append("    \t\t");
    _builder.append("this.publish(action, data);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}, delayInMillis);");
    _builder.newLine();
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
    _builder.newLine();
    return _builder;
  }
}
