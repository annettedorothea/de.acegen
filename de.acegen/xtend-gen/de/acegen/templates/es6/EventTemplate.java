/**
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 * 
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
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
    _builder.append("\t\t");
    _builder.append("ACEController.addItemToTimeLine({event: this});");
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
}
