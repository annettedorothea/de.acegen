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

import com.google.common.base.Objects;
import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.AttributeParamRef;
import de.acegen.aceGen.HttpClient;
import de.acegen.aceGen.HttpClientAce;
import de.acegen.aceGen.HttpClientOutcome;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.HttpServerAceRead;
import de.acegen.aceGen.Input;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.es6.AceExtension;
import java.util.List;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class CommandTemplate {
  @Inject
  @Extension
  private AceExtension _aceExtension;
  
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  public CharSequence generateAsynchronousAbstractCommandFile(final HttpClientAce it, final HttpClient es6) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import Command from \"../../../gen/ace/AsynchronousCommand\";");
    _builder.newLine();
    _builder.append("import TriggerAction from \"../../../gen/ace/TriggerAction\";");
    _builder.newLine();
    _builder.append("import Utils from \"../../ace/Utils\";");
    _builder.newLine();
    _builder.append("import ACEController from \"../../ace/ACEController\";");
    _builder.newLine();
    {
      EList<HttpClientOutcome> _outcomes = it.getOutcomes();
      for(final HttpClientOutcome outcome : _outcomes) {
        {
          int _size = outcome.getListeners().size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            _builder.append("import ");
            String _eventName = this._aceExtension.eventName(it, outcome);
            _builder.append(_eventName);
            _builder.append(" from \"../../../gen/");
            String _name = es6.getName();
            _builder.append(_name);
            _builder.append("/events/");
            String _eventName_1 = this._aceExtension.eventName(it, outcome);
            _builder.append(_eventName_1);
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      List<HttpClientAce> _triggeredAceOperations = this._aceExtension.triggeredAceOperations(it);
      for(final HttpClientAce aceOperation : _triggeredAceOperations) {
        _builder.append("import ");
        String _actionName = this._aceExtension.actionName(aceOperation);
        _builder.append(_actionName);
        _builder.append(" from \"../../../src/");
        EObject _eContainer = aceOperation.eContainer();
        String _name_1 = ((HttpClient) _eContainer).getName();
        _builder.append(_name_1);
        _builder.append("/actions/");
        String _actionName_1 = this._aceExtension.actionName(aceOperation);
        _builder.append(_actionName_1);
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("export default class ");
    String _abstractCommandName = this._aceExtension.abstractCommandName(it);
    _builder.append(_abstractCommandName);
    _builder.append(" extends Command {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("constructor(commandData) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("super(commandData, \"");
    String _name_2 = es6.getName();
    _builder.append(_name_2, "        ");
    _builder.append(".");
    String _commandName = this._aceExtension.commandName(it);
    _builder.append(_commandName, "        ");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    {
      EList<HttpClientOutcome> _outcomes_1 = it.getOutcomes();
      for(final HttpClientOutcome outcome_1 : _outcomes_1) {
        _builder.append("        ");
        _builder.append("this.");
        String _name_3 = outcome_1.getName();
        _builder.append(_name_3, "        ");
        _builder.append(" = \"");
        String _name_4 = outcome_1.getName();
        _builder.append(_name_4, "        ");
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("publishEvents() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("let promises = [];");
    _builder.newLine();
    _builder.append("\t    \t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("switch (this.commandData.outcome) {");
    _builder.newLine();
    {
      EList<HttpClientOutcome> _outcomes_2 = it.getOutcomes();
      for(final HttpClientOutcome outcome_2 : _outcomes_2) {
        _builder.append("\t\t");
        _builder.append("case this.");
        String _name_5 = outcome_2.getName();
        _builder.append(_name_5, "\t\t");
        _builder.append(":");
        _builder.newLineIfNotEmpty();
        {
          int _size_1 = outcome_2.getListeners().size();
          boolean _greaterThan_1 = (_size_1 > 0);
          if (_greaterThan_1) {
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("promises.push(new ");
            String _eventName_2 = this._aceExtension.eventName(it, outcome_2);
            _builder.append(_eventName_2, "\t\t\t");
            _builder.append("(this.commandData).publish());");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          EList<HttpClientAce> _aceOperations = outcome_2.getAceOperations();
          for(final HttpClientAce aceOperation_1 : _aceOperations) {
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("promises.push(new TriggerAction(new ");
            String _actionName_2 = this._aceExtension.actionName(aceOperation_1);
            _builder.append(_actionName_2, "\t\t\t");
            _builder.append("(");
            {
              EList<Input> _input = aceOperation_1.getInput();
              boolean _hasElements = false;
              for(final Input inputParam : _input) {
                if (!_hasElements) {
                  _hasElements = true;
                } else {
                  _builder.appendImmediate(", ", "\t\t\t");
                }
                _builder.append("this.commandData.");
                String _name_6 = inputParam.getName();
                _builder.append(_name_6, "\t\t\t");
              }
            }
            _builder.append(")).publish());");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("break;");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.append("default:");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return new Promise((resolve, reject) => {reject(\'");
    String _commandName_1 = this._aceExtension.commandName(it);
    _builder.append(_commandName_1, "\t\t\t");
    _builder.append(" unhandled outcome: \' + this.commandData.outcome)});");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return Promise.all(promises);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    {
      HttpServerAce _serverCall = it.getServerCall();
      boolean _tripleNotEquals = (_serverCall != null);
      if (_tripleNotEquals) {
        _builder.append("\t");
        _builder.append("execute() {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("    ");
        _builder.append("return new Promise((resolve, reject) => {");
        _builder.newLine();
        {
          String _type = it.getServerCall().getType();
          boolean _notEquals = (!Objects.equal(_type, "GET"));
          if (_notEquals) {
            _builder.append("\t");
            _builder.append("    \t");
            _builder.append("let payload = {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("    \t");
            _builder.append("\t");
            _builder.append("uuid : this.commandData.uuid");
            {
              EList<AttributeParamRef> _payload = it.getServerCall().getPayload();
              boolean _hasElements_1 = false;
              for(final AttributeParamRef payload : _payload) {
                if (!_hasElements_1) {
                  _hasElements_1 = true;
                  _builder.append(",\n", "\t    \t\t");
                } else {
                  _builder.appendImmediate(",\n", "\t    \t\t");
                }
                String _name_7 = payload.getAttribute().getName();
                _builder.append(_name_7, "\t    \t\t");
                _builder.append(" : this.commandData.");
                String _name_8 = payload.getAttribute().getName();
                _builder.append(_name_8, "\t    \t\t");
              }
            }
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("    \t");
            _builder.append("};");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("this.");
        String _httpCall = this._aceExtension.httpCall(it);
        _builder.append(_httpCall, "\t\t\t");
        _builder.append("(`");
        String _httpUrl = this._aceExtension.httpUrl(it);
        _builder.append(_httpUrl, "\t\t\t");
        _builder.append("?uuid=${this.commandData.uuid}");
        {
          EList<AttributeParamRef> _queryParams = it.getServerCall().getQueryParams();
          for(final AttributeParamRef queryParam : _queryParams) {
            _builder.append("&");
            String _name_9 = queryParam.getAttribute().getName();
            _builder.append(_name_9, "\t\t\t");
            _builder.append("=${this.commandData.");
            String _name_10 = queryParam.getAttribute().getName();
            _builder.append(_name_10, "\t\t\t");
            _builder.append("}");
          }
        }
        _builder.append("`, ");
        {
          boolean _isAuthorize = it.getServerCall().isAuthorize();
          if (_isAuthorize) {
            _builder.append("true");
          } else {
            _builder.append("false");
          }
        }
        {
          if (((Objects.equal(it.getServerCall().getType(), "POST") || Objects.equal(it.getServerCall().getType(), "PUT")) && (it.getServerCall().getPayload().size() > 0))) {
            _builder.append(", payload");
          }
        }
        _builder.append(").then((data) => {");
        _builder.newLineIfNotEmpty();
        {
          HttpServerAce _serverCall_1 = it.getServerCall();
          if ((_serverCall_1 instanceof HttpServerAceRead)) {
            {
              HttpServerAce _serverCall_2 = it.getServerCall();
              EList<Attribute> _response = ((HttpServerAceRead) _serverCall_2).getResponse();
              for(final Attribute attribute : _response) {
                _builder.append("\t");
                _builder.append("\t\t\t");
                _builder.append("this.commandData.");
                String _name_11 = attribute.getName();
                _builder.append(_name_11, "\t\t\t\t");
                _builder.append(" = data.");
                String _name_12 = attribute.getName();
                _builder.append(_name_12, "\t\t\t\t");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.append("\t");
        _builder.append("\t\t\t");
        _builder.append("this.handleResponse(resolve, reject);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("}, (error) => {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t");
        _builder.append("this.commandData.error = error;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t");
        _builder.append("this.handleError(resolve, reject);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("});");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("    ");
        _builder.append("});");
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
  
  public CharSequence generateSynchronousAbstractCommandFile(final HttpClientAce it, final HttpClient es6) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import Command from \"../../../gen/ace/SynchronousCommand\";");
    _builder.newLine();
    _builder.append("import TriggerAction from \"../../../gen/ace/TriggerAction\";");
    _builder.newLine();
    {
      EList<HttpClientOutcome> _outcomes = it.getOutcomes();
      for(final HttpClientOutcome outcome : _outcomes) {
        {
          int _size = outcome.getListeners().size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            _builder.append("import ");
            String _eventName = this._aceExtension.eventName(it, outcome);
            _builder.append(_eventName);
            _builder.append(" from \"../../../gen/");
            String _name = es6.getName();
            _builder.append(_name);
            _builder.append("/events/");
            String _eventName_1 = this._aceExtension.eventName(it, outcome);
            _builder.append(_eventName_1);
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      List<HttpClientAce> _triggeredAceOperations = this._aceExtension.triggeredAceOperations(it);
      for(final HttpClientAce aceOperation : _triggeredAceOperations) {
        _builder.append("import ");
        String _actionName = this._aceExtension.actionName(aceOperation);
        _builder.append(_actionName);
        _builder.append(" from \"../../../src/");
        EObject _eContainer = aceOperation.eContainer();
        String _name_1 = ((HttpClient) _eContainer).getName();
        _builder.append(_name_1);
        _builder.append("/actions/");
        String _actionName_1 = this._aceExtension.actionName(aceOperation);
        _builder.append(_actionName_1);
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("export default class ");
    String _abstractCommandName = this._aceExtension.abstractCommandName(it);
    _builder.append(_abstractCommandName);
    _builder.append(" extends Command {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("constructor(commandData) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("super(commandData, \"");
    String _name_2 = es6.getName();
    _builder.append(_name_2, "        ");
    _builder.append(".");
    String _commandName = this._aceExtension.commandName(it);
    _builder.append(_commandName, "        ");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    {
      EList<HttpClientOutcome> _outcomes_1 = it.getOutcomes();
      for(final HttpClientOutcome outcome_1 : _outcomes_1) {
        _builder.append("        ");
        _builder.append("this.");
        String _name_3 = outcome_1.getName();
        _builder.append(_name_3, "        ");
        _builder.append(" = \"");
        String _name_4 = outcome_1.getName();
        _builder.append(_name_4, "        ");
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("publishEvents() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("switch (this.commandData.outcome) {");
    _builder.newLine();
    {
      EList<HttpClientOutcome> _outcomes_2 = it.getOutcomes();
      for(final HttpClientOutcome outcome_2 : _outcomes_2) {
        _builder.append("\t\t");
        _builder.append("case this.");
        String _name_5 = outcome_2.getName();
        _builder.append(_name_5, "\t\t");
        _builder.append(":");
        _builder.newLineIfNotEmpty();
        {
          int _size_1 = outcome_2.getListeners().size();
          boolean _greaterThan_1 = (_size_1 > 0);
          if (_greaterThan_1) {
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("new ");
            String _eventName_2 = this._aceExtension.eventName(it, outcome_2);
            _builder.append(_eventName_2, "\t\t\t");
            _builder.append("(this.commandData).publish();");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          EList<HttpClientAce> _aceOperations = outcome_2.getAceOperations();
          for(final HttpClientAce aceOperation_1 : _aceOperations) {
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("new TriggerAction(new ");
            String _actionName_2 = this._aceExtension.actionName(aceOperation_1);
            _builder.append(_actionName_2, "\t\t\t");
            _builder.append("(");
            {
              EList<Input> _input = aceOperation_1.getInput();
              boolean _hasElements = false;
              for(final Input inputParam : _input) {
                if (!_hasElements) {
                  _hasElements = true;
                } else {
                  _builder.appendImmediate(", ", "\t\t\t");
                }
                _builder.append("this.commandData.");
                _builder.append(inputParam, "\t\t\t");
              }
            }
            _builder.append(")).publish();");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("break;");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.append("default:");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw \'");
    String _commandName_1 = this._aceExtension.commandName(it);
    _builder.append(_commandName_1, "\t\t\t");
    _builder.append(" unhandled outcome: \' + this.commandData.outcome;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("}");
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
    return _builder;
  }
  
  public CharSequence generateAsynchronousInitialCommandFile(final HttpClientAce it, final HttpClient es6) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import ");
    String _abstractCommandName = this._aceExtension.abstractCommandName(it);
    _builder.append(_abstractCommandName);
    _builder.append(" from \"../../../gen/");
    String _name = es6.getName();
    _builder.append(_name);
    _builder.append("/commands/");
    String _abstractCommandName_1 = this._aceExtension.abstractCommandName(it);
    _builder.append(_abstractCommandName_1);
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    _builder.append("import * as AppState from \"../../../gen/ace/ReadAppState\";");
    _builder.newLine();
    _builder.append("//please do not import \"../../../gen/ace/WriteAppState\" for you should not write the state in a command");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export default class ");
    String _commandName = this._aceExtension.commandName(it);
    _builder.append(_commandName);
    _builder.append(" extends ");
    String _abstractCommandName_2 = this._aceExtension.abstractCommandName(it);
    _builder.append(_abstractCommandName_2);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      HttpServerAce _serverCall = it.getServerCall();
      boolean _tripleNotEquals = (_serverCall != null);
      if (_tripleNotEquals) {
        _builder.append("    ");
        _builder.append("initCommandData() {");
        _builder.newLine();
        _builder.append("    \t");
        _builder.append("//add from appState to commandData");
        _builder.newLine();
        {
          EList<AttributeParamRef> _queryParams = it.getServerCall().getQueryParams();
          for(final AttributeParamRef param : _queryParams) {
            _builder.append("    \t");
            {
              boolean _isNotNull = param.isNotNull();
              if (_isNotNull) {
                _builder.append("//this.commandData.");
                String _name_1 = param.getAttribute().getName();
                _builder.append(_name_1, "    \t");
                _builder.append(" is mandatory ");
                String _type = param.getAttribute().getType();
                _builder.append(_type, "    \t");
              }
            }
            _builder.newLineIfNotEmpty();
          }
        }
        {
          EList<AttributeParamRef> _pathParams = it.getServerCall().getPathParams();
          for(final AttributeParamRef param_1 : _pathParams) {
            _builder.append("    \t");
            {
              boolean _isNotNull_1 = param_1.isNotNull();
              if (_isNotNull_1) {
                _builder.append("//this.commandData.");
                String _name_2 = param_1.getAttribute().getName();
                _builder.append(_name_2, "    \t");
                _builder.append(" is mandatory ");
                String _type_1 = param_1.getAttribute().getType();
                _builder.append(_type_1, "    \t");
              }
            }
            _builder.newLineIfNotEmpty();
          }
        }
        {
          EList<AttributeParamRef> _payload = it.getServerCall().getPayload();
          for(final AttributeParamRef param_2 : _payload) {
            _builder.append("    \t");
            {
              boolean _isNotNull_2 = param_2.isNotNull();
              if (_isNotNull_2) {
                _builder.append("//this.commandData.");
                String _name_3 = param_2.getAttribute().getName();
                _builder.append(_name_3, "    \t");
                _builder.append(" is mandatory ");
                String _type_2 = param_2.getAttribute().getType();
                _builder.append(_type_2, "    \t");
              }
            }
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("    \t");
        _builder.append("return true;");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("    ");
        _builder.append("handleResponse(resolve, reject) {");
        _builder.newLine();
        _builder.append("    \t");
        {
          int _size = it.getOutcomes().size();
          boolean _equals = (_size == 1);
          if (_equals) {
            _builder.append("this.commandData.outcome = this.");
            String _name_4 = it.getOutcomes().get(0).getName();
            _builder.append(_name_4, "    \t");
            _builder.append(";");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("    \t");
        _builder.append("resolve();");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("handleError(resolve, reject) {");
        _builder.newLine();
        _builder.append("    \t");
        _builder.append("reject(this.commandData.error);");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
      } else {
        _builder.append("execute() {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("return new Promise((resolve, reject) => {");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("});\t\t\t    ");
        _builder.newLine();
        _builder.append("}");
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
  
  public CharSequence generateSynchronousInitialCommandFile(final HttpClientAce it, final HttpClient es6) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import ");
    String _abstractCommandName = this._aceExtension.abstractCommandName(it);
    _builder.append(_abstractCommandName);
    _builder.append(" from \"../../../gen/");
    String _name = es6.getName();
    _builder.append(_name);
    _builder.append("/commands/");
    String _abstractCommandName_1 = this._aceExtension.abstractCommandName(it);
    _builder.append(_abstractCommandName_1);
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    _builder.append("import * as AppState from \"../../../gen/ace/ReadAppState\";");
    _builder.newLine();
    _builder.append("//please do not import \"../../../gen/ace/WriteAppState\" for you should not write the state in a command");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export default class ");
    String _commandName = this._aceExtension.commandName(it);
    _builder.append(_commandName);
    _builder.append(" extends ");
    String _abstractCommandName_2 = this._aceExtension.abstractCommandName(it);
    _builder.append(_abstractCommandName_2);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("execute() {");
    _builder.newLine();
    _builder.append("    \t");
    {
      int _size = it.getOutcomes().size();
      boolean _equals = (_size == 1);
      if (_equals) {
        _builder.append("this.commandData.outcome = this.");
        String _name_1 = it.getOutcomes().get(0).getName();
        _builder.append(_name_1, "    \t");
        _builder.append(";");
      }
    }
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
  
  public CharSequence generateCommand() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import AppUtils from \"../../src/app/AppUtils\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export default class Command {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("constructor(commandData, commandName) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("this.commandName = commandName;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("this.commandData = AppUtils.deepCopy(commandData);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("execute() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("throw \"no execute method defined for \" + this.commandName;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("publishEvents() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("throw \"no publishEvents method defined for \" + this.commandName;");
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
  
  public CharSequence generateAsynchronousCommand() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import ACEController from \"./ACEController\";");
    _builder.newLine();
    _builder.append("import Command from \"./Command\";");
    _builder.newLine();
    _builder.append("import AppUtils from \"../../src/app/AppUtils\";");
    _builder.newLine();
    _builder.append("import Utils from \"./Utils\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export default class AsynchronousCommand extends Command {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("executeCommand() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return new Promise((resolve, reject) => {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (ACEController.execution !== ACEController.REPLAY) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (this.initCommandData()) {");
    _builder.newLine();
    _builder.append("\t\t\t\t    ");
    _builder.append("this.execute().then(() => {");
    _builder.newLine();
    _builder.append("\t\t\t\t        ");
    _builder.append("ACEController.addItemToTimeLine({command: this});");
    _builder.newLine();
    _builder.append("\t\t\t\t        ");
    _builder.append("this.publishEvents();");
    _builder.newLine();
    _builder.append("\t\t\t\t        ");
    _builder.append("resolve();");
    _builder.newLine();
    _builder.append("\t\t\t\t    ");
    _builder.append("}, (error) => {");
    _builder.newLine();
    _builder.append("\t\t\t\t    \t");
    _builder.append("ACEController.addItemToTimeLine({command: this});");
    _builder.newLine();
    _builder.append("\t\t\t\t        ");
    _builder.append("reject(error);");
    _builder.newLine();
    _builder.append("\t\t\t\t    ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t        ");
    _builder.append("ACEController.addItemToTimeLine({command: this});");
    _builder.newLine();
    _builder.append("\t\t\t        ");
    _builder.append("this.publishEvents();");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("resolve();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("const timelineCommand = ACEController.getCommandByUuid(this.commandData.uuid);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (timelineCommand) {");
    _builder.newLine();
    _builder.append("\t\t\t\t    ");
    _builder.append("if (timelineCommand.commandData.error) {");
    _builder.newLine();
    _builder.append("\t\t\t\t        ");
    _builder.append("reject(timelineCommand.commandData.error);");
    _builder.newLine();
    _builder.append("\t\t\t\t    ");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t\t        ");
    _builder.append("this.commandData = timelineCommand.commandData;");
    _builder.newLine();
    _builder.append("\t\t\t\t        ");
    _builder.append("ACEController.addItemToTimeLine({command: this});");
    _builder.newLine();
    _builder.append("\t\t\t\t        ");
    _builder.append("this.publishEvents();");
    _builder.newLine();
    _builder.append("\t\t\t\t        ");
    _builder.append("resolve();");
    _builder.newLine();
    _builder.append("\t\t\t\t    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t\t    ");
    _builder.append("resolve();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("initCommandData() {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return true;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("httpGet(url, authorize) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return Utils.prepareAction(this.commandData.uuid).then(() => {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("return AppUtils.httpGet(url, authorize);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}, (error) => {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("throw error;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("httpPost(url, authorize, data) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return Utils.prepareAction(this.commandData.uuid).then(() => {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("return AppUtils.httpPost(url, authorize, data);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}, (error) => {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("throw error;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("httpPut(url, authorize, data) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return Utils.prepareAction(this.commandData.uuid).then(() => {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("return AppUtils.httpPut(url, authorize, data);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}, (error) => {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("throw error;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("httpDelete(url, authorize, data) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return Utils.prepareAction(this.commandData.uuid).then(() => {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("return AppUtils.httpDelete(url, authorize, data);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}, (error) => {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("throw error;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("});");
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
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateSynchronousCommand() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import ACEController from \"./ACEController\";");
    _builder.newLine();
    _builder.append("import Command from \"./Command\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export default class SynchronousCommand extends Command {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("executeCommand() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (ACEController.execution !== ACEController.REPLAY) {");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("this.execute();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("const timelineCommand = ACEController.getCommandByUuid(this.commandData.uuid);");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("this.commandData = timelineCommand.commandData;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ACEController.addItemToTimeLine({command: this});");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.publishEvents();");
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
    _builder.newLine();
    return _builder;
  }
}
