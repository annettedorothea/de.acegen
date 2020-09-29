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
  
  public CharSequence generateAbstractEventFile(final HttpClientAce it, final HttpClientOutcome outcome, final HttpClient es6) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import Event from \"../../../gen/ace/Event\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export default class ");
    String _eventName = this._aceExtension.eventName(it, outcome);
    _builder.append(_eventName);
    _builder.append(" extends Event {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("constructor(eventData) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("super(eventData, \'");
    String _name = es6.getName();
    _builder.append(_name, "        ");
    _builder.append(".");
    String _eventName_1 = this._aceExtension.eventName(it, outcome);
    _builder.append(_eventName_1, "        ");
    _builder.append("\');");
    _builder.newLineIfNotEmpty();
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
    return _builder;
  }
  
  public CharSequence generateEventListenerRegistration(final HttpClient it) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import ACEController from \"../ace/ACEController\";");
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
    _builder.append("import AppUtils from \"../../src/app/AppUtils\";");
    _builder.newLine();
    _builder.append("import ACEController from \"./ACEController\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export default class Event {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("constructor(eventData, eventName) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("this.eventName = eventName;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("this.eventData = AppUtils.deepCopy(eventData);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("publish() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("this.notifyListeners();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("AppUtils.renderNewState();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ACEController.addItemToTimeLine({event: this});");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("replay() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("this.notifyListeners();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("AppUtils.renderNewState();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("notifyListeners() {");
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
    _builder.append("listener(AppUtils.deepCopy(this.eventData));");
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
    _builder.append("import Event from \"./Event\";");
    _builder.newLine();
    _builder.append("import ACEController from \"./ACEController\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export default class TriggerAction extends Event {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("constructor(action) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("super(action, \'TriggerAction\');");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("this.eventData = action;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("publish() {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("this.notifyListeners();");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("ACEController.addItemToTimeLine({event: this});");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("replay() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
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
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateEventFactoryRegistration(final HttpClient it) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import ACEController from \"../ace/ACEController\";");
    _builder.newLine();
    {
      EList<HttpClientAce> _aceOperations = it.getAceOperations();
      for(final HttpClientAce aceOperation : _aceOperations) {
        {
          EList<HttpClientOutcome> _outcomes = aceOperation.getOutcomes();
          for(final HttpClientOutcome outcome : _outcomes) {
            {
              int _size = outcome.getListeners().size();
              boolean _greaterThan = (_size > 0);
              if (_greaterThan) {
                _builder.append("import ");
                String _eventName = this._aceExtension.eventName(aceOperation, outcome);
                _builder.append(_eventName);
                _builder.append(" from \"./events/");
                String _eventName_1 = this._aceExtension.eventName(aceOperation, outcome);
                _builder.append(_eventName_1);
                _builder.append("\";");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    _builder.newLine();
    _builder.append("export default class EventFactoryRegistration");
    String _projectName = this._es6Extension.projectName(it);
    _builder.append(_projectName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static init() {");
    _builder.newLine();
    {
      EList<HttpClientAce> _aceOperations_1 = it.getAceOperations();
      for(final HttpClientAce aceOperation_1 : _aceOperations_1) {
        {
          EList<HttpClientOutcome> _outcomes_1 = aceOperation_1.getOutcomes();
          for(final HttpClientOutcome outcome_1 : _outcomes_1) {
            {
              int _size_1 = outcome_1.getListeners().size();
              boolean _greaterThan_1 = (_size_1 > 0);
              if (_greaterThan_1) {
                _builder.append("\t\t");
                _builder.append("ACEController.registerFactory(\'");
                String _name = it.getName();
                _builder.append(_name, "\t\t");
                _builder.append(".");
                String _eventName_2 = this._aceExtension.eventName(aceOperation_1, outcome_1);
                _builder.append(_eventName_2, "\t\t");
                _builder.append("\', ");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("(eventData) => new ");
                String _eventName_3 = this._aceExtension.eventName(aceOperation_1, outcome_1);
                _builder.append(_eventName_3, "\t\t\t");
                _builder.append("(eventData));");
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
}
