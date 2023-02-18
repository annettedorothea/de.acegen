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

import com.google.common.base.Objects;
import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.AttributeParamRef;
import de.acegen.aceGen.FromAppStateRef;
import de.acegen.aceGen.HttpClient;
import de.acegen.aceGen.HttpClientAce;
import de.acegen.aceGen.HttpClientOutcome;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.Input;
import de.acegen.aceGen.TriggerdAceOperation;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.es6.AceExtension;
import de.acegen.extensions.es6.Es6Extension;
import de.acegen.extensions.java.AttributeExtension;
import de.acegen.extensions.java.EcoreExtension;
import java.util.List;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class CommandTemplate {
  @Inject
  @Extension
  private AceExtension _aceExtension;

  @Inject
  @Extension
  private CommonExtension _commonExtension;

  @Inject
  @Extension
  private Es6Extension _es6Extension;

  @Inject
  @Extension
  private EcoreExtension _ecoreExtension;

  @Inject
  @Extension
  private AttributeExtension _attributeExtension;

  public boolean hasEventOutcome(final HttpClientAce it) {
    EList<HttpClientOutcome> _outcomes = it.getOutcomes();
    for (final HttpClientOutcome outcome : _outcomes) {
      int _size = outcome.getListeners().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        return true;
      }
    }
    return false;
  }

  public CharSequence generateAsynchronousAbstractCommandFile(final HttpClientAce it, final HttpClient es6) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import AsynchronousCommand from \"../../ace/AsynchronousCommand\";");
    _builder.newLine();
    _builder.append("import Event from \"../../ace/Event\";");
    _builder.newLine();
    _builder.append("import * as AppUtils from \"../../../src/AppUtils\";");
    _builder.newLine();
    _builder.append("import * as AppState from \"../../../src/AppState\";");
    _builder.newLine();
    {
      List<HttpClientAce> _aggregatedTriggeredAceOperations = this._aceExtension.aggregatedTriggeredAceOperations(it);
      for(final HttpClientAce aceOperation : _aggregatedTriggeredAceOperations) {
        _builder.append("import ");
        String _actionName = this._aceExtension.actionName(aceOperation);
        _builder.append(_actionName);
        _builder.append(" from \"../../../src/");
        EObject _eContainer = aceOperation.eContainer();
        String _name = ((HttpClient) _eContainer).getName();
        _builder.append(_name);
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
    _builder.append(" extends AsynchronousCommand {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("constructor() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("super(\"");
    String _name_1 = es6.getName();
    _builder.append(_name_1, "        ");
    _builder.append(".");
    String _commandName = this._aceExtension.commandName(it);
    _builder.append(_commandName, "        ");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("initCommandData(data) {");
    _builder.newLine();
    {
      EList<FromAppStateRef> _refs = it.getRefs();
      for(final FromAppStateRef ref : _refs) {
        _builder.append("        ");
        _builder.append("data.");
        String _xifexpression = null;
        String _varName = ref.getVarName();
        boolean _tripleNotEquals = (_varName != null);
        if (_tripleNotEquals) {
          _xifexpression = ref.getVarName();
        } else {
          _xifexpression = ref.getStateElement().getName();
        }
        _builder.append(_xifexpression, "        ");
        _builder.append(" = ");
        CharSequence _stateFunctionCall = this._es6Extension.stateFunctionCall(ref.getStateElement(), "get", "data");
        _builder.append(_stateFunctionCall, "        ");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("        ");
    _builder.append("data.outcomes = [];");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<HttpClientOutcome> _outcomes = it.getOutcomes();
      for(final HttpClientOutcome outcome : _outcomes) {
        _builder.append("\t");
        _builder.append("add");
        String _firstUpper = StringExtensions.toFirstUpper(outcome.getName());
        _builder.append(_firstUpper, "\t");
        _builder.append("Outcome(data) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("data.outcomes.push(\"");
        String _name_2 = outcome.getName();
        _builder.append(_name_2, "\t\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("allMandatoryValuesAreSet(data) {");
    _builder.newLine();
    {
      HttpServerAce _serverCall = it.getServerCall();
      boolean _tripleNotEquals_1 = (_serverCall != null);
      if (_tripleNotEquals_1) {
        {
          EList<AttributeParamRef> _payload = it.getServerCall().getPayload();
          for(final AttributeParamRef payload : _payload) {
            {
              boolean _isNotNull = payload.isNotNull();
              if (_isNotNull) {
                _builder.append("\t\t");
                _builder.append("if (data.");
                String _name_3 = payload.getAttribute().getName();
                _builder.append(_name_3, "\t\t");
                _builder.append(" === undefined || data.");
                String _name_4 = payload.getAttribute().getName();
                _builder.append(_name_4, "\t\t");
                _builder.append(" === null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("console.warn(\"");
                String _abstractCommandName_1 = this._aceExtension.abstractCommandName(it);
                _builder.append(_abstractCommandName_1, "\t\t\t");
                _builder.append(": ");
                String _name_5 = payload.getAttribute().getName();
                _builder.append(_name_5, "\t\t\t");
                _builder.append(" is mandatory but is not set\", data);");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("return false;");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
          }
        }
        {
          EList<AttributeParamRef> _queryParams = it.getServerCall().getQueryParams();
          for(final AttributeParamRef queryParam : _queryParams) {
            {
              boolean _isNotNull_1 = queryParam.isNotNull();
              if (_isNotNull_1) {
                _builder.append("\t\t");
                _builder.append("if (data.");
                String _name_6 = queryParam.getAttribute().getName();
                _builder.append(_name_6, "\t\t");
                _builder.append(" === undefined || data.");
                String _name_7 = queryParam.getAttribute().getName();
                _builder.append(_name_7, "\t\t");
                _builder.append(" === null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("console.warn(\"");
                String _abstractCommandName_2 = this._aceExtension.abstractCommandName(it);
                _builder.append(_abstractCommandName_2, "\t\t\t");
                _builder.append(": ");
                String _name_8 = queryParam.getAttribute().getName();
                _builder.append(_name_8, "\t\t\t");
                _builder.append(" is mandatory but is not set\", data);");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("return false;");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
          }
        }
        {
          EList<AttributeParamRef> _pathParams = it.getServerCall().getPathParams();
          for(final AttributeParamRef pathParam : _pathParams) {
            {
              boolean _isNotNull_2 = pathParam.isNotNull();
              if (_isNotNull_2) {
                _builder.append("\t\t");
                _builder.append("if (data.");
                String _name_9 = pathParam.getAttribute().getName();
                _builder.append(_name_9, "\t\t");
                _builder.append(" === undefined || data.");
                String _name_10 = pathParam.getAttribute().getName();
                _builder.append(_name_10, "\t\t");
                _builder.append(" === null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("console.warn(\"");
                String _abstractCommandName_3 = this._aceExtension.abstractCommandName(it);
                _builder.append(_abstractCommandName_3, "\t\t\t");
                _builder.append(": ");
                String _name_11 = pathParam.getAttribute().getName();
                _builder.append(_name_11, "\t\t\t");
                _builder.append(" is mandatory but is not set\", data);");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("return false;");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    _builder.append("\t\t");
    _builder.append("return true;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      HttpServerAce _serverCall_1 = it.getServerCall();
      boolean _tripleNotEquals_2 = (_serverCall_1 != null);
      if (_tripleNotEquals_2) {
        _builder.append("\t");
        _builder.append("execute(data) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("    ");
        _builder.append("return new Promise((resolve, reject) => {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("    \t");
        _builder.append("if (this.allMandatoryValuesAreSet(data)) {");
        _builder.newLine();
        {
          if ((((Objects.equal(it.getServerCall().getType(), "POST") || Objects.equal(it.getServerCall().getType(), "PUT")) && (it.getServerCall().getPayload().size() > 0)) && (!(this._ecoreExtension.isMulitpartFormData(it.getServerCall())).booleanValue()))) {
            _builder.append("\t");
            _builder.append("\t    \t");
            _builder.append("let payload = {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t    \t");
            _builder.append("\t");
            {
              EList<AttributeParamRef> _payload_1 = it.getServerCall().getPayload();
              boolean _hasElements = false;
              for(final AttributeParamRef payload_1 : _payload_1) {
                if (!_hasElements) {
                  _hasElements = true;
                } else {
                  _builder.appendImmediate(",\n", "\t\t    \t\t");
                }
                String _name_12 = payload_1.getAttribute().getName();
                _builder.append(_name_12, "\t\t    \t\t");
                _builder.append(" : data.");
                String _name_13 = payload_1.getAttribute().getName();
                _builder.append(_name_13, "\t\t    \t\t");
              }
            }
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t    \t");
            _builder.append("};");
            _builder.newLine();
          } else {
            if (((Objects.equal(it.getServerCall().getType(), "POST") || Objects.equal(it.getServerCall().getType(), "PUT")) && (this._ecoreExtension.isMulitpartFormData(it.getServerCall())).booleanValue())) {
              _builder.append("\t");
              _builder.append("\t    \t");
              _builder.append("const formData = data.");
              String _formDataAttributeName = this._attributeExtension.formDataAttributeName(it.getServerCall().getModel());
              _builder.append(_formDataAttributeName, "\t\t    \t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            }
          }
        }
        _builder.append("\t");
        _builder.append("\t\t\t");
        _builder.append("AppUtils.");
        String _httpCall = this._aceExtension.httpCall(it);
        _builder.append(_httpCall, "\t\t\t\t");
        _builder.append("(");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t\t\t\t\t");
        _builder.append("`");
        String _httpUrl = this._aceExtension.httpUrl(it);
        _builder.append(_httpUrl, "\t\t\t\t\t\t");
        {
          EList<AttributeParamRef> _queryParams_1 = it.getServerCall().getQueryParams();
          boolean _hasElements_1 = false;
          for(final AttributeParamRef queryParam_1 : _queryParams_1) {
            if (!_hasElements_1) {
              _hasElements_1 = true;
              _builder.append("?", "\t\t\t\t\t\t");
            } else {
              _builder.appendImmediate("&", "\t\t\t\t\t\t");
            }
            _builder.append("${data.");
            String _name_14 = queryParam_1.getAttribute().getName();
            _builder.append(_name_14, "\t\t\t\t\t\t");
            _builder.append(" ? `");
            String _name_15 = queryParam_1.getAttribute().getName();
            _builder.append(_name_15, "\t\t\t\t\t\t");
            _builder.append("=${data.");
            String _name_16 = queryParam_1.getAttribute().getName();
            _builder.append(_name_16, "\t\t\t\t\t\t");
            _builder.append("}` : \"\"}");
          }
        }
        _builder.append("`, ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t\t\t\t\t");
        _builder.append("data.uuid, ");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t\t\t");
        {
          boolean _isAuthorize = it.getServerCall().isAuthorize();
          if (_isAuthorize) {
            _builder.append("true");
          } else {
            _builder.append("false");
          }
        }
        {
          if ((Objects.equal(it.getServerCall().getType(), "POST") || Objects.equal(it.getServerCall().getType(), "PUT"))) {
            {
              Boolean _isMulitpartFormData = this._ecoreExtension.isMulitpartFormData(it.getServerCall());
              if ((_isMulitpartFormData).booleanValue()) {
                _builder.append(",");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t\t\t\t\t");
                _builder.append(" ");
                _builder.append("formData, \"");
                String _formDataAttributeName_1 = this._attributeExtension.formDataAttributeName(it.getServerCall().getModel());
                _builder.append(_formDataAttributeName_1, "\t\t\t\t\t\t ");
                _builder.append("\"");
              } else {
                int _size = it.getServerCall().getPayload().size();
                boolean _greaterThan = (_size > 0);
                if (_greaterThan) {
                  _builder.append(",");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t\t\t\t\t");
                  _builder.append(" ");
                  _builder.append("payload");
                }
              }
            }
          }
        }
        _builder.append(")");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t\t\t\t");
        _builder.append(".then((");
        {
          int _size_1 = it.getServerCall().getResponse().size();
          boolean _greaterThan_1 = (_size_1 > 0);
          if (_greaterThan_1) {
            _builder.append("response");
          }
        }
        _builder.append(") => {");
        _builder.newLineIfNotEmpty();
        {
          EList<Attribute> _response = it.getServerCall().getResponse();
          for(final Attribute attribute : _response) {
            _builder.append("\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("data.");
            String _name_17 = attribute.getName();
            _builder.append(_name_17, "\t\t\t\t\t\t");
            _builder.append(" = response.");
            String _name_18 = attribute.getName();
            _builder.append(_name_18, "\t\t\t\t\t\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("\t\t\t\t\t");
        _builder.append("this.handleResponse(data, resolve, reject);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t\t");
        _builder.append("}, (error) => {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t\t\t");
        _builder.append("data.error = error;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t\t\t");
        _builder.append("this.handleError(data, resolve, reject);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t\t");
        _builder.append("})");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t\t");
        _builder.append(".catch(x => reject(x));");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("} else {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t");
        _builder.append("resolve(data);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("}");
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
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("publishEvents(data) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return new Promise((resolve) => {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("const events = [];");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("const actionsToBeTriggered = [];");
    _builder.newLine();
    {
      EList<HttpClientOutcome> _outcomes_1 = it.getOutcomes();
      for(final HttpClientOutcome outcome_1 : _outcomes_1) {
        {
          if (((outcome_1.getListeners().size() > 0) || (outcome_1.getTriggerdAceOperations().size() > 0))) {
            _builder.append("\t\t\t");
            _builder.append("if (data.outcomes.includes(\"");
            String _name_19 = outcome_1.getName();
            _builder.append(_name_19, "\t\t\t");
            _builder.append("\")) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("events.push(new Event(\'");
            String _name_20 = es6.getName();
            _builder.append(_name_20, "\t\t\t\t");
            _builder.append(".");
            String _eventName = this._aceExtension.eventName(it, outcome_1);
            _builder.append(_eventName, "\t\t\t\t");
            _builder.append("\'));");
            _builder.newLineIfNotEmpty();
            {
              EList<TriggerdAceOperation> _triggerdAceOperations = outcome_1.getTriggerdAceOperations();
              for(final TriggerdAceOperation triggerdAceOperation : _triggerdAceOperations) {
                {
                  int _delay = triggerdAceOperation.getDelay();
                  boolean _equals = (_delay == 0);
                  if (_equals) {
                    _builder.append("\t\t\t");
                    _builder.append("\t");
                    _builder.append("actionsToBeTriggered.push(");
                    _builder.newLine();
                    _builder.append("\t\t\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("{");
                    _builder.newLine();
                    _builder.append("\t\t\t");
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("action: new ");
                    String _actionName_2 = this._aceExtension.actionName(triggerdAceOperation.getAceOperation());
                    _builder.append(_actionName_2, "\t\t\t\t\t\t");
                    _builder.append("(), ");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t\t");
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("data: {");
                    _builder.newLine();
                    {
                      EList<Input> _input = triggerdAceOperation.getAceOperation().getInput();
                      boolean _hasElements_2 = false;
                      for(final Input inputParam : _input) {
                        if (!_hasElements_2) {
                          _hasElements_2 = true;
                        } else {
                          _builder.appendImmediate(", ", "\t\t\t\t\t\t\t");
                        }
                        _builder.append("\t\t\t");
                        _builder.append("\t");
                        _builder.append("\t\t\t");
                        String _name_21 = inputParam.getName();
                        _builder.append(_name_21, "\t\t\t\t\t\t\t");
                        _builder.append(": data.");
                        String _name_22 = inputParam.getName();
                        _builder.append(_name_22, "\t\t\t\t\t\t\t");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    _builder.append("\t\t\t");
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t\t\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t\t\t");
                    _builder.append("\t");
                    _builder.append(");");
                    _builder.newLine();
                  } else {
                    {
                      boolean _isTakeLatest = triggerdAceOperation.isTakeLatest();
                      if (_isTakeLatest) {
                        _builder.append("\t\t\t");
                        _builder.append("\t");
                        _builder.append("this.triggerWithDelayTakeLatest(new ");
                        String _actionName_3 = this._aceExtension.actionName(triggerdAceOperation.getAceOperation());
                        _builder.append(_actionName_3, "\t\t\t\t");
                        _builder.append("(), ");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("{");
                        _builder.newLine();
                        {
                          EList<Input> _input_1 = triggerdAceOperation.getAceOperation().getInput();
                          boolean _hasElements_3 = false;
                          for(final Input inputParam_1 : _input_1) {
                            if (!_hasElements_3) {
                              _hasElements_3 = true;
                            } else {
                              _builder.appendImmediate(", ", "\t\t\t\t\t\t");
                            }
                            _builder.append("\t\t\t");
                            _builder.append("\t");
                            _builder.append("\t\t");
                            String _name_23 = inputParam_1.getName();
                            _builder.append(_name_23, "\t\t\t\t\t\t");
                            _builder.append(": data.");
                            String _name_24 = inputParam_1.getName();
                            _builder.append(_name_24, "\t\t\t\t\t\t");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        _builder.append("\t\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("},");
                        _builder.newLine();
                        _builder.append("\t\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        int _delay_1 = triggerdAceOperation.getDelay();
                        _builder.append(_delay_1, "\t\t\t\t\t");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t\t");
                        _builder.append("\t");
                        _builder.append(");");
                        _builder.newLine();
                      } else {
                        _builder.append("\t\t\t");
                        _builder.append("\t");
                        _builder.append("this.triggerWithDelay(new ");
                        String _actionName_4 = this._aceExtension.actionName(triggerdAceOperation.getAceOperation());
                        _builder.append(_actionName_4, "\t\t\t\t");
                        _builder.append("(), ");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("{");
                        _builder.newLine();
                        {
                          EList<Input> _input_2 = triggerdAceOperation.getAceOperation().getInput();
                          boolean _hasElements_4 = false;
                          for(final Input inputParam_2 : _input_2) {
                            if (!_hasElements_4) {
                              _hasElements_4 = true;
                            } else {
                              _builder.appendImmediate(", ", "\t\t\t\t\t\t");
                            }
                            _builder.append("\t\t\t");
                            _builder.append("\t");
                            _builder.append("\t\t");
                            String _name_25 = inputParam_2.getName();
                            _builder.append(_name_25, "\t\t\t\t\t\t");
                            _builder.append(": data.");
                            String _name_26 = inputParam_2.getName();
                            _builder.append(_name_26, "\t\t\t\t\t\t");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        _builder.append("\t\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("},");
                        _builder.newLine();
                        _builder.append("\t\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        int _delay_2 = triggerdAceOperation.getDelay();
                        _builder.append(_delay_2, "\t\t\t\t\t");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t\t");
                        _builder.append("\t");
                        _builder.append(");");
                        _builder.newLine();
                      }
                    }
                  }
                }
              }
            }
            _builder.append("\t\t\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("this.publish(events, data).then(() => {");
    _builder.newLine();
    _builder.append("\t\t  \t\t");
    _builder.append("AppState.stateUpdated();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("this.trigger(actionsToBeTriggered).then(resolve);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("});");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("})");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
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
    _builder.append("\t");
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import SynchronousCommand from \"../../ace/SynchronousCommand\";");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import Event from \"../../ace/Event\";");
    _builder.newLine();
    {
      List<HttpClientAce> _aggregatedTriggeredAceOperations = this._aceExtension.aggregatedTriggeredAceOperations(it);
      for(final HttpClientAce aceOperation : _aggregatedTriggeredAceOperations) {
        _builder.append("\t");
        _builder.append("import ");
        String _actionName = this._aceExtension.actionName(aceOperation);
        _builder.append(_actionName, "\t");
        _builder.append(" from \"../../../src/");
        EObject _eContainer = aceOperation.eContainer();
        String _name = ((HttpClient) _eContainer).getName();
        _builder.append(_name, "\t");
        _builder.append("/actions/");
        String _actionName_1 = this._aceExtension.actionName(aceOperation);
        _builder.append(_actionName_1, "\t");
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("import * as AppUtils from \"../../../src/AppUtils\";");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import * as AppState from \"../../../src/AppState\";");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("export default class ");
    String _abstractCommandName = this._aceExtension.abstractCommandName(it);
    _builder.append(_abstractCommandName, "\t");
    _builder.append(" extends SynchronousCommand {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t    ");
    _builder.append("constructor() {");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("super(\"");
    String _name_1 = es6.getName();
    _builder.append(_name_1, "\t        ");
    _builder.append(".");
    String _commandName = this._aceExtension.commandName(it);
    _builder.append(_commandName, "\t        ");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("initCommandData(data) {");
    _builder.newLine();
    {
      EList<FromAppStateRef> _refs = it.getRefs();
      for(final FromAppStateRef ref : _refs) {
        _builder.append("\t        ");
        _builder.append("data.");
        String _xifexpression = null;
        String _varName = ref.getVarName();
        boolean _tripleNotEquals = (_varName != null);
        if (_tripleNotEquals) {
          _xifexpression = ref.getVarName();
        } else {
          _xifexpression = ref.getStateElement().getName();
        }
        _builder.append(_xifexpression, "\t        ");
        _builder.append(" = ");
        CharSequence _stateFunctionCall = this._es6Extension.stateFunctionCall(ref.getStateElement(), "get", "data");
        _builder.append(_stateFunctionCall, "\t        ");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t        ");
    _builder.append("data.outcomes = [];");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<HttpClientOutcome> _outcomes = it.getOutcomes();
      for(final HttpClientOutcome outcome : _outcomes) {
        _builder.append("\t\t");
        _builder.append("add");
        String _firstUpper = StringExtensions.toFirstUpper(outcome.getName());
        _builder.append(_firstUpper, "\t\t");
        _builder.append("Outcome(data) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("data.outcomes.push(\"");
        String _name_2 = outcome.getName();
        _builder.append(_name_2, "\t\t\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("publishEvents(data) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("const events = [];");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("const actionsToBeTriggered = [];");
    _builder.newLine();
    {
      EList<HttpClientOutcome> _outcomes_1 = it.getOutcomes();
      for(final HttpClientOutcome outcome_1 : _outcomes_1) {
        {
          if (((outcome_1.getListeners().size() > 0) || (outcome_1.getTriggerdAceOperations().size() > 0))) {
            _builder.append("\t\t\t");
            _builder.append("if (data.outcomes.includes(\"");
            String _name_3 = outcome_1.getName();
            _builder.append(_name_3, "\t\t\t");
            _builder.append("\")) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("events.push(new Event(\'");
            String _name_4 = es6.getName();
            _builder.append(_name_4, "\t\t\t\t");
            _builder.append(".");
            String _eventName = this._aceExtension.eventName(it, outcome_1);
            _builder.append(_eventName, "\t\t\t\t");
            _builder.append("\'));");
            _builder.newLineIfNotEmpty();
            {
              EList<TriggerdAceOperation> _triggerdAceOperations = outcome_1.getTriggerdAceOperations();
              for(final TriggerdAceOperation triggerdAceOperation : _triggerdAceOperations) {
                {
                  int _delay = triggerdAceOperation.getDelay();
                  boolean _equals = (_delay == 0);
                  if (_equals) {
                    _builder.append("\t\t\t");
                    _builder.append("\t");
                    _builder.append("actionsToBeTriggered.push(");
                    _builder.newLine();
                    _builder.append("\t\t\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("{");
                    _builder.newLine();
                    _builder.append("\t\t\t");
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("action: new ");
                    String _actionName_2 = this._aceExtension.actionName(triggerdAceOperation.getAceOperation());
                    _builder.append(_actionName_2, "\t\t\t\t\t\t");
                    _builder.append("(), ");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t\t");
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("data: {");
                    _builder.newLine();
                    {
                      EList<Input> _input = triggerdAceOperation.getAceOperation().getInput();
                      boolean _hasElements = false;
                      for(final Input inputParam : _input) {
                        if (!_hasElements) {
                          _hasElements = true;
                        } else {
                          _builder.appendImmediate(", ", "\t\t\t\t\t\t\t");
                        }
                        _builder.append("\t\t\t");
                        _builder.append("\t");
                        _builder.append("\t\t\t");
                        String _name_5 = inputParam.getName();
                        _builder.append(_name_5, "\t\t\t\t\t\t\t");
                        _builder.append(": data.");
                        String _name_6 = inputParam.getName();
                        _builder.append(_name_6, "\t\t\t\t\t\t\t");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    _builder.append("\t\t\t");
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t\t\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t\t\t");
                    _builder.append("\t");
                    _builder.append(");");
                    _builder.newLine();
                  } else {
                    {
                      boolean _isTakeLatest = triggerdAceOperation.isTakeLatest();
                      if (_isTakeLatest) {
                        _builder.append("\t\t\t");
                        _builder.append("\t");
                        _builder.append("this.triggerWithDelayTakeLatest(new ");
                        String _actionName_3 = this._aceExtension.actionName(triggerdAceOperation.getAceOperation());
                        _builder.append(_actionName_3, "\t\t\t\t");
                        _builder.append("(), ");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("{");
                        _builder.newLine();
                        {
                          EList<Input> _input_1 = triggerdAceOperation.getAceOperation().getInput();
                          boolean _hasElements_1 = false;
                          for(final Input inputParam_1 : _input_1) {
                            if (!_hasElements_1) {
                              _hasElements_1 = true;
                            } else {
                              _builder.appendImmediate(", ", "\t\t\t\t\t\t");
                            }
                            _builder.append("\t\t\t");
                            _builder.append("\t");
                            _builder.append("\t\t");
                            String _name_7 = inputParam_1.getName();
                            _builder.append(_name_7, "\t\t\t\t\t\t");
                            _builder.append(": data.");
                            String _name_8 = inputParam_1.getName();
                            _builder.append(_name_8, "\t\t\t\t\t\t");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        _builder.append("\t\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("},");
                        _builder.newLine();
                        _builder.append("\t\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        int _delay_1 = triggerdAceOperation.getDelay();
                        _builder.append(_delay_1, "\t\t\t\t\t");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t\t");
                        _builder.append("\t");
                        _builder.append(");");
                        _builder.newLine();
                      } else {
                        _builder.append("\t\t\t");
                        _builder.append("\t");
                        _builder.append("this.triggerWithDelay(new ");
                        String _actionName_4 = this._aceExtension.actionName(triggerdAceOperation.getAceOperation());
                        _builder.append(_actionName_4, "\t\t\t\t");
                        _builder.append("(), ");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("{");
                        _builder.newLine();
                        {
                          EList<Input> _input_2 = triggerdAceOperation.getAceOperation().getInput();
                          boolean _hasElements_2 = false;
                          for(final Input inputParam_2 : _input_2) {
                            if (!_hasElements_2) {
                              _hasElements_2 = true;
                            } else {
                              _builder.appendImmediate(", ", "\t\t\t\t\t\t");
                            }
                            _builder.append("\t\t\t");
                            _builder.append("\t");
                            _builder.append("\t\t");
                            String _name_9 = inputParam_2.getName();
                            _builder.append(_name_9, "\t\t\t\t\t\t");
                            _builder.append(": data.");
                            String _name_10 = inputParam_2.getName();
                            _builder.append(_name_10, "\t\t\t\t\t\t");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        _builder.append("\t\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("},");
                        _builder.newLine();
                        _builder.append("\t\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        int _delay_2 = triggerdAceOperation.getDelay();
                        _builder.append(_delay_2, "\t\t\t\t\t");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t\t");
                        _builder.append("\t");
                        _builder.append(");");
                        _builder.newLine();
                      }
                    }
                  }
                }
              }
            }
            _builder.append("\t\t\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("this.publish(events, data);");
    _builder.newLine();
    _builder.append("\t\t  \t");
    _builder.append("AppState.stateUpdated();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("this.trigger(actionsToBeTriggered);");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
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
        _builder.append("validateCommandData(data) {");
        _builder.newLine();
        {
          EList<AttributeParamRef> _queryParams = it.getServerCall().getQueryParams();
          for(final AttributeParamRef param : _queryParams) {
            _builder.append("    \t");
            {
              boolean _isNotNull = param.isNotNull();
              if (_isNotNull) {
                _builder.append("//data.");
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
                _builder.append("//data.");
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
                _builder.append("//data.");
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
        _builder.append("handleResponse(data, resolve, reject) {");
        _builder.newLine();
        _builder.append("    \t");
        {
          int _size = it.getOutcomes().size();
          boolean _equals = (_size == 1);
          if (_equals) {
            _builder.append("this.add");
            String _firstUpper = StringExtensions.toFirstUpper(it.getOutcomes().get(0).getName());
            _builder.append(_firstUpper, "    \t");
            _builder.append("Outcome(data);");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("    \t");
        _builder.append("resolve(data);");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("handleError(data, resolve, reject) {");
        _builder.newLine();
        _builder.append("    \t");
        _builder.append("reject(data.error);");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
      } else {
        _builder.append("execute(data) {");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("return new Promise((resolve, reject) => {");
        _builder.newLine();
        _builder.append("\t    ");
        _builder.append("resolve(data);");
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
    _builder.append("execute(data) {");
    _builder.newLine();
    _builder.append("    \t");
    {
      int _size = it.getOutcomes().size();
      boolean _equals = (_size == 1);
      if (_equals) {
        _builder.append("this.add");
        String _firstUpper = StringExtensions.toFirstUpper(it.getOutcomes().get(0).getName());
        _builder.append(_firstUpper, "    \t");
        _builder.append("Outcome(data);");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("    \t");
    _builder.append("return data;");
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

  public CharSequence generateCommand() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    _builder.append("let delayedActions = {};");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export default class Command {");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("constructor(commandName) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("this.commandName = commandName;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("triggerWithDelay(action, data, delayInMillis) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("setTimeout(() => {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("action.apply(data);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}, delayInMillis);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("triggerWithDelayTakeLatest(action, data, delayInMillis) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("const existingTimeout = delayedActions[action.actionName];");
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
    _builder.append("delayedActions[action.actionName] = setTimeout(() => {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("delayedActions[action.actionName] = undefined;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("action.apply(data);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}, delayInMillis);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
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
    _builder.newLine();
    _builder.append("import * as ACEController from \"./ACEController\";");
    _builder.newLine();
    _builder.append("import Command from \"./Command\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export default class AsynchronousCommand extends Command {");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("executeCommand(data, postCall) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.initCommandData(data);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("ACEController.addItemToTimeLine({");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("command: {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("commandName: this.commandName,");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("data");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return new Promise((resolve, reject) => {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (this.validateCommandData(data)) {");
    _builder.newLine();
    _builder.append("\t\t\t    ");
    _builder.append("this.execute(data).then((data) => {");
    _builder.newLine();
    _builder.append("\t\t\t    \t");
    _builder.append("postCall();");
    _builder.newLine();
    _builder.append("\t\t\t        ");
    _builder.append("this.publishEvents(data).then(resolve);");
    _builder.newLine();
    _builder.append("\t\t\t    ");
    _builder.append("}, (error) => {");
    _builder.newLine();
    _builder.append("\t\t\t        ");
    _builder.append("reject(error);");
    _builder.newLine();
    _builder.append("\t\t\t    ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t    ");
    _builder.append("this.publishEvents(data).then(resolve);");
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
    _builder.append("validateCommandData() {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return true;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("createEventPromise(event, data) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return new Promise(resolve => {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("event.publish(data);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("resolve();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("})");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("publish(events, data) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (events.length === 0) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return new Promise(resolve => resolve());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return this.createEventPromise(events.shift(), data)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append(".then(event => events.length === 0 ? event : this.publish(events, data));");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("createActionPromise(actionToBeTriggered) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return new Promise(resolve => {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (actionToBeTriggered.action.asynchronous) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("actionToBeTriggered.action.apply(actionToBeTriggered.data).then(resolve);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("actionToBeTriggered.action.apply(actionToBeTriggered.data);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("resolve();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("})");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("trigger(actionsToBeTriggered) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (actionsToBeTriggered.length === 0) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return new Promise(resolve => resolve());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return this.createActionPromise(actionsToBeTriggered.shift())");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append(".then(actionToBeTriggered => actionsToBeTriggered.length === 0 ? actionToBeTriggered : this.trigger(actionsToBeTriggered));");
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
    _builder.newLine();
    return _builder;
  }

  public CharSequence generateSynchronousCommand() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import * as ACEController from \"./ACEController\";");
    _builder.newLine();
    _builder.append("import Command from \"./Command\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export default class SynchronousCommand extends Command {");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("executeCommand(data) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.initCommandData(data);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("ACEController.addItemToTimeLine({");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("command: {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("commandName: this.commandName,");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("data");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("data = this.execute(data);");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("this.publishEvents(data)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("publish(events, data) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("events.forEach(");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("event => event.publish(data)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append(")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("trigger(actionsToBeTriggered) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("actionsToBeTriggered.forEach(");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("actionToBeTriggered => this.triggerWithDelay(actionToBeTriggered.action, actionToBeTriggered.data, 1)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append(")");
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
    _builder.newLine();
    return _builder;
  }
}
