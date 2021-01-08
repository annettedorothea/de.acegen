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
import de.acegen.aceGen.GroupedClientAttribute;
import de.acegen.aceGen.HttpClient;
import de.acegen.aceGen.SingleClientAttribute;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.es6.Es6Extension;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class AceTemplate {
  @Inject
  @Extension
  private Es6Extension _es6Extension;
  
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  public CharSequence generateAppUtilsStub() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    _builder.append("import * as App from \"./App\";");
    _builder.newLine();
    _builder.append("import * as AppState from \"../../gen/ace/AppState\";");
    _builder.newLine();
    _builder.append("import Utils from \"../../gen/ace/Utils\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export function dumpAppState() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("console.log(AppState.getAppState());");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export default class AppUtils {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("static initEventListenersAndActionFactories() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("//EventListenerRegistration.init();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("//EventFactoryRegistration.init();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("static startApp() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("Utils.loadSettings().then(() => {");
    _builder.newLine();
    _builder.append("        \t");
    _builder.append("// call init action");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("static startReplay() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("static createInitialAppState() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("const initialAppState = {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("};");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("AppState.setInitialAppState(initialAppState);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("static renderNewState() {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("// render AppState.getAppState()");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("static createHeaders(authorize) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("const headers = new Headers();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("headers.append(\"Content-Type\", \"application/json\");");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("headers.append(\"Accept\", \"application/json\");");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (authorize === true) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("let authorization = AppUtils.basicAuth();");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("if (authorization !== undefined) {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("headers.append(\"Authorization\", authorization);");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return headers;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("static addUuidToUrl(url, uuid) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (uuid) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("if (url.indexOf(\"?\") < 0) {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("url += \"?uuid=\" + uuid;");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("url += \"&uuid=\" + uuid;");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return url;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("static httpRequest(methodType, url, uuid, authorize, data) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return new Promise((resolve, reject) => {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("const options = {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("method: methodType,");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("headers: AppUtils.createHeaders(authorize),");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("mode: \'cors\',");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("cache: \'no-cache\'");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("};");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("if (data && methodType !== \"GET\") {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("options.body = JSON.stringify(data);");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("url = AppUtils.addUuidToUrl(url, uuid);");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("const request = new Request(url, options);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("            ");
    _builder.append("fetch(request).then(function (response) {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("response.text().then((text) => {");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("if (response.status >= 300) {");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("const error = {");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("code: response.status,");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("text: response.statusText,");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("key: text");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("};");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("reject(error);");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("let data = {};");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("if (text.length > 0) {");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("data = JSON.parse(text);");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("resolve(data);");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}).catch(function (error) {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("const status = {");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("code: error.name,");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("text: error.message");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("};");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("reject(status);");
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
    _builder.append("static httpGet(url, uuid, authorize) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return AppUtils.httpRequest(\"GET\", url, uuid, authorize, null);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("static httpPost(url, uuid, authorize, data) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return AppUtils.httpRequest(\"POST\", url, uuid, authorize, data);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("static httpPut(url, uuid, authorize, data) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return AppUtils.httpRequest(\"PUT\", url, uuid, authorize, data);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("static httpDelete(url, uuid, authorize, data) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return AppUtils.httpRequest(\"DELETE\", url, uuid, authorize, data);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("static basicAuth() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return \"<your authorization>\";");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("static createUUID() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("let d = new Date().getTime();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return \'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx\'.replace(/[xy]/g, function (c) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("let r = (d + Math.random() * 16) % 16 | 0;");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("d = Math.floor(d / 16);");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("return (c === \'x\' ? r : (r & 0x3 | 0x8)).toString(16);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("static displayUnexpectedError(error) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("console.error(\"unexpected error \", error);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("static deepCopy(object) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return JSON.parse(JSON.stringify(object));");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("static stateUpdated(appState) {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("if (Utils.settings && Utils.settings.mode === \"dev\") {");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("localStorage.setItem(\"appState\", JSON.stringify(appState));");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
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
  
  public CharSequence generateAppStub(final HttpClient httpClient) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    _builder.append("import AppUtils from \"./AppUtils\";");
    _builder.newLine();
    _builder.newLine();
    {
      boolean _isReact16_8 = httpClient.isReact16_8();
      if (_isReact16_8) {
        _builder.append("import {ContainerComponent} from \"../../gen/components/ContainerComponent\";");
        _builder.newLine();
        _builder.append("import React from \"react\";");
        _builder.newLine();
        _builder.append("import ReactDOM from \"react-dom\";");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("export * from \"../../gen/ace/Timeline\";");
    _builder.newLine();
    _builder.append("export { dumpAppState } from \"./AppUtils\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("AppUtils.createInitialAppState();");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    {
      boolean _isReact16_8_1 = httpClient.isReact16_8();
      if (_isReact16_8_1) {
        _builder.append("ReactDOM.render(");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("<ContainerComponent />,");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("document.getElementById(\'root\')");
        _builder.newLine();
        _builder.append(");");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("window.onhashchange = () => {");
    _builder.newLine();
    _builder.append("};");
    _builder.newLine();
    _builder.newLine();
    _builder.append("AppUtils.initEventListenersAndEventFactories();");
    _builder.newLine();
    _builder.append("AppUtils.startApp();");
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
  
  public CharSequence generateACEController() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import AppUtils from \"../../src/app/AppUtils\";");
    _builder.newLine();
    _builder.append("import Utils from \"./Utils\";");
    _builder.newLine();
    _builder.append("import * as AppState from \"./AppState\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export default class ACEController {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("static init() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("ACEController.timeline = [];");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("ACEController.listeners = {};");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("ACEController.factories = {};");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("ACEController.registerListener(\'TriggerAction\', ACEController.triggerAction);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("ACEController.actionQueue = [];");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("static registerListener(eventName, listener) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (!eventName.trim()) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("throw new Error(\'cannot register listener for empty eventName\');");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (!listener) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("throw new Error(\'cannot register undefined listener for event \' + eventName);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("let listenersForEventName;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (ACEController.listeners[eventName] === undefined) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("ACEController.listeners[eventName] = [];");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("listenersForEventName = ACEController.listeners[eventName];");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("listenersForEventName.push(listener);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("static registerFactory(eventName, factory) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (!eventName.trim()) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("throw new Error(\'cannot register factory for empty eventName\');");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (!factory) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("throw new Error(\'cannot register undefined factory for event \' + eventName);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("ACEController.factories[eventName] = factory;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("static addItemToTimeLine(item) {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("if (Utils.settings && Utils.settings.timelineSize > 0) {");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("ACEController.timeline.push(AppUtils.deepCopy(item));");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (ACEController.timeline.length > Utils.settings.timelineSize) {");
    _builder.newLine();
    _builder.append("\t\t\t    ");
    _builder.append("ACEController.timeline.shift();");
    _builder.newLine();
    _builder.append("\t\t\t    ");
    _builder.append("while (ACEController.timeline.length > 0 && ACEController.timeline.length > 0 && !ACEController.timeline[0].appState) {");
    _builder.newLine();
    _builder.append("\t\t\t        ");
    _builder.append("ACEController.timeline.shift();");
    _builder.newLine();
    _builder.append("\t\t\t    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("static addActionToQueue(action) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ACEController.actionQueue.push(action);");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("ACEController.applyNextActions();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("static applyNextActions() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("let action = ACEController.actionQueue.shift();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (action) {");
    _builder.newLine();
    _builder.append("\t    \t");
    _builder.append("ACEController.addItemToTimeLine({appState: AppState.getAppState()});");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (action.asynchronous) {");
    _builder.newLine();
    _builder.append("\t\t\t    ");
    _builder.append("action.applyAction().then(() => {");
    _builder.newLine();
    _builder.append("\t\t\t    \t");
    _builder.append("ACEController.callApplyNextActions();");
    _builder.newLine();
    _builder.append("\t\t\t    ");
    _builder.append("}, (error) => {");
    _builder.newLine();
    _builder.append("\t\t\t        ");
    _builder.append("AppUtils.displayUnexpectedError(error);");
    _builder.newLine();
    _builder.append("\t\t\t    \t");
    _builder.append("ACEController.callApplyNextActions();");
    _builder.newLine();
    _builder.append("\t\t\t    ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("action.applyAction();");
    _builder.newLine();
    _builder.append("\t\t\t    \t");
    _builder.append("ACEController.callApplyNextActions();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("} catch(error) {");
    _builder.newLine();
    _builder.append("\t\t\t        ");
    _builder.append("AppUtils.displayUnexpectedError(error);");
    _builder.newLine();
    _builder.append("\t\t\t    \t");
    _builder.append("ACEController.callApplyNextActions();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("static callApplyNextActions() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ACEController.applyNextActions();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("static triggerAction(action) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("ACEController.addActionToQueue(action);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("static startReplay(timeline, pauseInMillis) {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("AppUtils.startReplay();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("let events = [];");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("let appStateWasSet = false;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("for (let i = 0; i < timeline.length; i++) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("let item = timeline[i];");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("if (item.event && appStateWasSet && item.event.eventName !== \"TriggerAction\") {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("const eventData = item.event.eventData;");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("let event = ACEController.factories[item.event.eventName](eventData);");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("events.push(event);");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (item.appState && !appStateWasSet) {");
    _builder.newLine();
    _builder.append("\t\t\t    ");
    _builder.append("AppState.setInitialAppState(item.appState);");
    _builder.newLine();
    _builder.append("\t\t\t    ");
    _builder.append("appStateWasSet = true;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("            ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("setTimeout(() => ACEController.replayNextEvent(events, pauseInMillis), pauseInMillis);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("static replayNextEvent(events, pauseInMillis) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("let event = events.shift();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (event) {");
    _builder.newLine();
    _builder.append("        \t");
    _builder.append("event.replay();");
    _builder.newLine();
    _builder.append("        \t");
    _builder.append("setTimeout(() => ACEController.replayNextEvent(events, pauseInMillis), pauseInMillis);");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("setTimeout(() => ACEController.finishReplay(), pauseInMillis);");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static finishReplay() {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("console.log(\"replay finished\");");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("ACEController.timeline = [];");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("ACEController.actionQueue = [];");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("AppUtils.createInitialAppState();");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("AppUtils.startApp();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("ACEController.init();");
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
  
  public CharSequence generateTimeline() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import AppUtils from \"../../src/app/AppUtils\";");
    _builder.newLine();
    _builder.append("import ACEController from \"./ACEController\";");
    _builder.newLine();
    _builder.append("import Utils from \"./Utils\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export function replayTimeline(timelineId, pauseInMillis = 100) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (pauseInMillis < 100) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("pauseInMillis = 100;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("Utils.loadTimeline(timelineId).then((scenario) => {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("AppUtils.createInitialAppState();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("ACEController.startReplay(JSON.parse(scenario.timeline), pauseInMillis)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export function saveTimeline(description, creator) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("Utils.saveTimeline(description, creator).then((id) => {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("console.log(`saved timeline with id ${id}`);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export function dumpTimeline() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("console.log(ACEController.timeline);");
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
  
  public CharSequence generateUtils() {
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
    _builder.append("export default class Utils {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("static getServerInfo() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return AppUtils.httpGet(Utils.settings.rootPath + \'/server/info\');");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static loadSettings() {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("return AppUtils.httpRequest(\"GET\", \"settings.json\").then((settings) => {");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("Utils.settings = settings;");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("if (!Utils.settings.clientVersion) {");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.append("Utils.settings.clientVersion = \"\";");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("if (!Utils.settings.aceScenariosApiKey) {");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.append("Utils.settings.aceScenariosApiKey = \"\";");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("if (!Utils.settings.aceScenariosBaseUrl) {");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.append("Utils.settings.aceScenariosBaseUrl = \"\";");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("if (!Utils.settings.rootPath) {");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.append("Utils.settings.rootPath = \"\";");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("if (!Utils.settings.timelineSize) {");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.append("Utils.settings.timelineSize = 0;");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (!Utils.settings.mode) {");
    _builder.newLine();
    _builder.append("\t\t\t    ");
    _builder.append("Utils.settings.mode = \"live\";");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("if (Utils.settings.rootPath.startsWith(\"/\")) {");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.append("Utils.settings.rootPath = Utils.settings.rootPath.substring(1);");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("if (Utils.settings.rootPath.endsWith(\"/\")) {");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.append("Utils.settings.rootPath = Utils.settings.rootPath.substring(0, Utils.settings.rootPath.length - 1);");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("static saveTimeline(description, creator) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return Utils.getServerInfo().then((serverInfo) => {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("const browser = Utils.getBrowserInfo();");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("const uuid = AppUtils.createUUID();");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("const data = {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("description,");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("timeline: JSON.stringify(ACEController.timeline),");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("creator,");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("clientVersion: Utils.settings.clientVersion,");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("device: browser.name + \" \" + browser.version,");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("apiKey: Utils.settings.aceScenariosApiKey,");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("serverVersion: serverInfo.serverVersion");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("};");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("return AppUtils.httpPost(Utils.settings.aceScenariosBaseUrl + \'api/client-timeline/create\', uuid, false, data).then(() => {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("return new Promise((resolve) => {");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("resolve(uuid);");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("});");
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
    _builder.append("static loadTimeline(id) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return AppUtils.httpGet(Utils.settings.aceScenariosBaseUrl + `api/timeline?id=${id}&apiKey=${Utils.settings.aceScenariosApiKey}`, AppUtils.createUUID(), false);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("static getBrowserInfo() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("let ua = navigator.userAgent, tem,");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("M = ua.match(/(opera|chrome|safari|firefox|msie|trident(?=\\/))\\/?\\s*(\\d+)/i) || [];");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (/trident/i.test(M[1])) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("tem = /\\brv[ :]+(\\d+)/g.exec(ua) || [];");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("return {name: \'IE \', version: (tem[1] || \'\')};");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (M[1] === \'Chrome\') {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("tem = ua.match(/\\bOPR\\/(\\d+)/);");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("if (tem != null) {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("return {name: \'Opera\', version: tem[1]};");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("M = M[2] ? [M[1], M[2]] : [navigator.appName, navigator.appVersion, \'-?\'];");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if ((tem = ua.match(/version\\/(\\d+)/i)) != null) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("M.splice(1, 1, tem[1]);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("name: M[0],");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("version: M[1]");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("};");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("}");
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
  
  public String generateAppState(final List<ClientAttribute> attributes, final String prefix, final HttpClient httpClient) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import AppUtils from \"../../src/app/AppUtils\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export let appState;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import {setContainerState} from \"../components/ContainerComponent\";");
    _builder.newLine();
    {
      for(final ClientAttribute attribute : attributes) {
        String _generateAppStateImportsRec = this.generateAppStateImportsRec(attribute, "", httpClient);
        _builder.append(_generateAppStateImportsRec);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("export function getAppState() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return AppUtils.deepCopy(appState);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export function setInitialAppState(initialAppState) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("appState = AppUtils.deepCopy(initialAppState);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      for(final ClientAttribute attribute_1 : attributes) {
        String _generateAppStateRec = this.generateAppStateRec(attribute_1, httpClient);
        _builder.append(_generateAppStateRec);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  private CharSequence getStateFunction(final SingleClientAttribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("export function get_");
    String _functionName = this._es6Extension.functionName(it);
    _builder.append(_functionName);
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    {
      boolean _isHash = it.isHash();
      if (_isHash) {
        _builder.append("\t");
        _builder.append("return location.hash;");
        _builder.newLine();
      } else {
        boolean _isStorage = it.isStorage();
        if (_isStorage) {
          _builder.append("\t");
          _builder.append("return localStorage.getItem(\"");
          String _name = it.getName();
          _builder.append(_name, "\t");
          _builder.append("\");");
          _builder.newLineIfNotEmpty();
        } else {
          {
            List<ClientAttribute> _allParentAttributes = this._es6Extension.allParentAttributes(it);
            for(final ClientAttribute attribute : _allParentAttributes) {
              _builder.append("\t");
              _builder.append("if (!");
              String _elementPath = this._es6Extension.elementPath(attribute);
              _builder.append(_elementPath, "\t");
              _builder.append(") {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("return undefined;");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
              {
                EObject _eContainer = attribute.eContainer();
                if ((_eContainer instanceof GroupedClientAttribute)) {
                  _builder.append("\t");
                  _builder.append("if (");
                  String _elementPath_1 = this._es6Extension.elementPath(attribute);
                  _builder.append(_elementPath_1, "\t");
                  _builder.append(".is");
                  String _firstUpper = StringExtensions.toFirstUpper(attribute.getName());
                  _builder.append(_firstUpper, "\t");
                  _builder.append(" !== true) {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("return undefined;");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("}");
                  _builder.newLine();
                }
              }
            }
          }
          {
            if (((it.getAttributes() == null) || (((Object[])Conversions.unwrapArray(it.getAttributes(), Object.class)).length == 0))) {
              _builder.append("\t");
              _builder.append("return ");
              String _elementPath_2 = this._es6Extension.elementPath(it);
              _builder.append(_elementPath_2, "\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            } else {
              {
                EObject _eContainer_1 = it.eContainer();
                if ((_eContainer_1 instanceof GroupedClientAttribute)) {
                  _builder.append("\t");
                  _builder.append("if (");
                  String _elementPath_3 = this._es6Extension.elementPath(it);
                  _builder.append(_elementPath_3, "\t");
                  _builder.append(" && ");
                  String _elementPath_4 = this._es6Extension.elementPath(it);
                  _builder.append(_elementPath_4, "\t");
                  _builder.append(".is");
                  String _firstUpper_1 = StringExtensions.toFirstUpper(it.getName());
                  _builder.append(_firstUpper_1, "\t");
                  _builder.append(" === true) {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("return AppUtils.deepCopy(");
                  String _elementPath_5 = this._es6Extension.elementPath(it);
                  _builder.append(_elementPath_5, "\t\t");
                  _builder.append(");");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("}");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("return undefined;");
                  _builder.newLine();
                } else {
                  _builder.append("\t");
                  _builder.append("if (!");
                  String _elementPath_6 = this._es6Extension.elementPath(it);
                  _builder.append(_elementPath_6, "\t");
                  _builder.append(") {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("return undefined;");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("}");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("return AppUtils.deepCopy(");
                  String _elementPath_7 = this._es6Extension.elementPath(it);
                  _builder.append(_elementPath_7, "\t");
                  _builder.append(");");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
        }
      }
    }
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence setStateFunction(final SingleClientAttribute it, final HttpClient httpClient) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("export function set_");
    String _functionName = this._es6Extension.functionName(it);
    _builder.append(_functionName);
    _builder.append("(eventData) {");
    _builder.newLineIfNotEmpty();
    {
      boolean _isHash = it.isHash();
      if (_isHash) {
        _builder.append("\t");
        _builder.append("location.hash = eventData.");
        String _name = it.getName();
        _builder.append(_name, "\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      } else {
        boolean _isStorage = it.isStorage();
        if (_isStorage) {
          _builder.append("\t");
          _builder.append("if (eventData.");
          String _name_1 = it.getName();
          _builder.append(_name_1, "\t");
          _builder.append(") {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("localStorage.setItem(\"");
          String _name_2 = it.getName();
          _builder.append(_name_2, "\t\t");
          _builder.append("\", eventData.");
          String _name_3 = it.getName();
          _builder.append(_name_3, "\t\t");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("} else {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("localStorage.removeItem(\"");
          String _name_4 = it.getName();
          _builder.append(_name_4, "\t\t");
          _builder.append("\");");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        } else {
          {
            List<ClientAttribute> _allParentAttributes = this._es6Extension.allParentAttributes(it);
            for(final ClientAttribute attribute : _allParentAttributes) {
              {
                EObject _eContainer = attribute.eContainer();
                if ((_eContainer instanceof GroupedClientAttribute)) {
                  _builder.append("\t");
                  _builder.append("if (!");
                  String _elementPath = this._es6Extension.elementPath(attribute);
                  _builder.append(_elementPath, "\t");
                  _builder.append(" || ");
                  String _elementPath_1 = this._es6Extension.elementPath(attribute);
                  _builder.append(_elementPath_1, "\t");
                  _builder.append(".is");
                  String _firstUpper = StringExtensions.toFirstUpper(attribute.getName());
                  _builder.append(_firstUpper, "\t");
                  _builder.append(" !== true) {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  String _elementPath_2 = this._es6Extension.elementPath(attribute);
                  _builder.append(_elementPath_2, "\t\t");
                  _builder.append(" = {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t\t");
                  _builder.append("is");
                  String _firstUpper_1 = StringExtensions.toFirstUpper(attribute.getName());
                  _builder.append(_firstUpper_1, "\t\t\t");
                  _builder.append(" : true");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("};");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("}");
                  _builder.newLine();
                } else {
                  _builder.append("\t");
                  _builder.append("if (!");
                  String _elementPath_3 = this._es6Extension.elementPath(attribute);
                  _builder.append(_elementPath_3, "\t");
                  _builder.append(") {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  String _elementPath_4 = this._es6Extension.elementPath(attribute);
                  _builder.append(_elementPath_4, "\t\t");
                  _builder.append(" = {};");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("}");
                  _builder.newLine();
                }
              }
            }
          }
          {
            EObject _eContainer_1 = it.eContainer();
            if ((_eContainer_1 instanceof GroupedClientAttribute)) {
              _builder.append("\t");
              _builder.append("if (!!eventData.");
              String _name_5 = it.getName();
              _builder.append(_name_5, "\t");
              _builder.append(") {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("\t");
              String _elementPath_5 = this._es6Extension.elementPath(it);
              _builder.append(_elementPath_5, "\t\t");
              _builder.append(" = eventData.");
              String _name_6 = it.getName();
              _builder.append(_name_6, "\t\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("\t");
              String _elementPath_6 = this._es6Extension.elementPath(it);
              _builder.append(_elementPath_6, "\t\t");
              _builder.append(".is");
              String _firstUpper_2 = StringExtensions.toFirstUpper(it.getName());
              _builder.append(_firstUpper_2, "\t\t");
              _builder.append(" = true;");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("} else {");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              String _elementPath_7 = this._es6Extension.elementPath(it);
              _builder.append(_elementPath_7, "\t\t");
              _builder.append(" = {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("\t\t");
              _builder.append("is");
              String _firstUpper_3 = StringExtensions.toFirstUpper(it.getName());
              _builder.append(_firstUpper_3, "\t\t\t");
              _builder.append(" : true");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("};");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
            } else {
              _builder.append("\t");
              String _elementPath_8 = this._es6Extension.elementPath(it);
              _builder.append(_elementPath_8, "\t");
              _builder.append(" = eventData.");
              String _name_7 = it.getName();
              _builder.append(_name_7, "\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
    }
    _builder.append("\t");
    CharSequence _setState = this.setState(it, httpClient);
    _builder.append(_setState, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence mergeStateFunction(final SingleClientAttribute it, final HttpClient httpClient) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((((((it.getAttributes() != null) && (((Object[])Conversions.unwrapArray(it.getAttributes(), Object.class)).length > 0)) && (!it.isHash())) && (!it.isStorage())) && (!it.isList()))) {
        _builder.append("export function merge_");
        String _functionName = this._es6Extension.functionName(it);
        _builder.append(_functionName);
        _builder.append("(eventData) {");
        _builder.newLineIfNotEmpty();
        {
          List<ClientAttribute> _allParentAttributes = this._es6Extension.allParentAttributes(it);
          for(final ClientAttribute attr : _allParentAttributes) {
            _builder.append("\t");
            _builder.append("if (!");
            String _elementPath = this._es6Extension.elementPath(attr);
            _builder.append(_elementPath, "\t");
            _builder.append(") {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            String _elementPath_1 = this._es6Extension.elementPath(attr);
            _builder.append(_elementPath_1, "\t\t");
            _builder.append(" = {};");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("if (!");
        String _elementPath_2 = this._es6Extension.elementPath(it);
        _builder.append(_elementPath_2, "\t");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        {
          EObject _eContainer = it.eContainer();
          if ((_eContainer instanceof GroupedClientAttribute)) {
            _builder.append("\t\t");
            String _elementPath_3 = this._es6Extension.elementPath(it);
            _builder.append(_elementPath_3, "\t\t");
            _builder.append(" = {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("is");
            String _firstUpper = StringExtensions.toFirstUpper(it.getName());
            _builder.append(_firstUpper, "\t\t\t");
            _builder.append(" : true");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("};");
            _builder.newLine();
          } else {
            _builder.append("\t\t");
            String _elementPath_4 = this._es6Extension.elementPath(it);
            _builder.append(_elementPath_4, "\t\t");
            _builder.append(" = {};");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        {
          EList<ClientAttribute> _attributes = it.getAttributes();
          for(final ClientAttribute attribute : _attributes) {
            {
              if ((attribute instanceof SingleClientAttribute)) {
                _builder.append("\t");
                _builder.append("if (eventData.");
                String _name = ((SingleClientAttribute)attribute).getName();
                _builder.append(_name, "\t");
                _builder.append(" !== undefined) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                String _elementPath_5 = this._es6Extension.elementPath(attribute);
                _builder.append(_elementPath_5, "\t\t");
                _builder.append(" = eventData.");
                String _name_1 = ((SingleClientAttribute)attribute).getName();
                _builder.append(_name_1, "\t\t");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
          }
        }
        _builder.append("\t");
        CharSequence _setState = this.setState(it, httpClient);
        _builder.append(_setState, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  private CharSequence setState(final SingleClientAttribute it, final HttpClient httpClient) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("const newAppState = getAppState();");
    _builder.newLine();
    {
      boolean _isReact16_8 = httpClient.isReact16_8();
      if (_isReact16_8) {
        SingleClientAttribute parent = this._es6Extension.findNextNonListSingleClientAttributeParent(it);
        _builder.newLineIfNotEmpty();
        {
          if ((parent == null)) {
            _builder.append("setContainerState(newAppState);");
            _builder.newLine();
          } else {
            _builder.append("set");
            String _componentName = this._es6Extension.componentName(parent);
            _builder.append(_componentName);
            _builder.append("State(AppUtils.deepCopy(");
            String _elementPath = this._es6Extension.elementPath(parent);
            _builder.append(_elementPath);
            _builder.append("));");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("AppUtils.stateUpdated(newAppState);");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence childAttributes(final SingleClientAttribute it, final HttpClient httpClient) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (((((it.getAttributes() != null) && (!it.isList())) && (!it.isHash())) && (!it.isStorage()))) {
        {
          EList<ClientAttribute> _attributes = it.getAttributes();
          for(final ClientAttribute attribute : _attributes) {
            String _generateAppStateRec = this.generateAppStateRec(attribute, httpClient);
            _builder.append(_generateAppStateRec);
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  protected String _generateAppStateRec(final SingleClientAttribute it, final HttpClient httpClient) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _stateFunction = this.getStateFunction(it);
    _builder.append(_stateFunction);
    _builder.newLineIfNotEmpty();
    CharSequence _setStateFunction = this.setStateFunction(it, httpClient);
    _builder.append(_setStateFunction);
    _builder.newLineIfNotEmpty();
    CharSequence _mergeStateFunction = this.mergeStateFunction(it, httpClient);
    _builder.append(_mergeStateFunction);
    _builder.newLineIfNotEmpty();
    CharSequence _childAttributes = this.childAttributes(it, httpClient);
    _builder.append(_childAttributes);
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  protected String _generateAppStateRec(final GroupedClientAttribute it, final HttpClient httpClient) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (((it.getAttributeGroup() == null) || (((Object[])Conversions.unwrapArray(it.getAttributeGroup(), Object.class)).length > 0))) {
        {
          EList<ClientAttribute> _attributeGroup = it.getAttributeGroup();
          for(final ClientAttribute attribute : _attributeGroup) {
            {
              if ((attribute instanceof SingleClientAttribute)) {
                CharSequence _stateFunction = this.getStateFunction(((SingleClientAttribute)attribute));
                _builder.append(_stateFunction);
                _builder.newLineIfNotEmpty();
                CharSequence _setStateFunction = this.setStateFunction(((SingleClientAttribute)attribute), httpClient);
                _builder.append(_setStateFunction);
                _builder.newLineIfNotEmpty();
                CharSequence _mergeStateFunction = this.mergeStateFunction(((SingleClientAttribute)attribute), httpClient);
                _builder.append(_mergeStateFunction);
                _builder.newLineIfNotEmpty();
                CharSequence _childAttributes = this.childAttributes(((SingleClientAttribute)attribute), httpClient);
                _builder.append(_childAttributes);
                _builder.newLineIfNotEmpty();
              } else {
                String _generateAppStateRec = this.generateAppStateRec(attribute, httpClient);
                _builder.append(_generateAppStateRec);
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    return _builder.toString();
  }
  
  protected String _generateAppStateImportsRec(final SingleClientAttribute it, final String subFolder, final HttpClient httpClient) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isReact16_8 = httpClient.isReact16_8();
      if (_isReact16_8) {
        CharSequence _imports = this.imports(it, subFolder);
        _builder.append(_imports);
        _builder.newLineIfNotEmpty();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append(subFolder);
        _builder_1.append("/");
        String _firstLower = StringExtensions.toFirstLower(it.getName());
        _builder_1.append(_firstLower);
        CharSequence _childImports = this.childImports(it, _builder_1.toString(), httpClient);
        _builder.append(_childImports);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  protected String _generateAppStateImportsRec(final GroupedClientAttribute it, final String subFolder, final HttpClient httpClient) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (((it.getAttributeGroup() == null) || (((Object[])Conversions.unwrapArray(it.getAttributeGroup(), Object.class)).length > 0))) {
        {
          EList<ClientAttribute> _attributeGroup = it.getAttributeGroup();
          for(final ClientAttribute attribute : _attributeGroup) {
            {
              if ((attribute instanceof SingleClientAttribute)) {
                CharSequence _imports = this.imports(((SingleClientAttribute)attribute), subFolder);
                _builder.append(_imports);
                _builder.newLineIfNotEmpty();
                CharSequence _childImports = this.childImports(((SingleClientAttribute)attribute), subFolder, httpClient);
                _builder.append(_childImports);
                _builder.newLineIfNotEmpty();
              } else {
                String _generateAppStateImportsRec = this.generateAppStateImportsRec(attribute, subFolder, httpClient);
                _builder.append(_generateAppStateImportsRec);
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    return _builder.toString();
  }
  
  private CharSequence imports(final SingleClientAttribute it, final String subFolder) {
    StringConcatenation _builder = new StringConcatenation();
    {
      int _size = it.getAttributes().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _builder.append("import {set");
        String _componentName = this._es6Extension.componentName(it);
        _builder.append(_componentName);
        _builder.append("State} from \"../components");
        _builder.append(subFolder);
        _builder.append("/");
        String _reactComponentName = this._es6Extension.reactComponentName(it);
        _builder.append(_reactComponentName);
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  private CharSequence childImports(final SingleClientAttribute it, final String subFolder, final HttpClient httpClient) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (((((it.getAttributes() != null) && (!it.isList())) && (!it.isHash())) && (!it.isStorage()))) {
        {
          EList<ClientAttribute> _attributes = it.getAttributes();
          for(final ClientAttribute attribute : _attributes) {
            String _generateAppStateImportsRec = this.generateAppStateImportsRec(attribute, subFolder, httpClient);
            _builder.append(_generateAppStateImportsRec);
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  public String generateAppStateRec(final ClientAttribute it, final HttpClient httpClient) {
    if (it instanceof GroupedClientAttribute) {
      return _generateAppStateRec((GroupedClientAttribute)it, httpClient);
    } else if (it instanceof SingleClientAttribute) {
      return _generateAppStateRec((SingleClientAttribute)it, httpClient);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, httpClient).toString());
    }
  }
  
  public String generateAppStateImportsRec(final ClientAttribute it, final String subFolder, final HttpClient httpClient) {
    if (it instanceof GroupedClientAttribute) {
      return _generateAppStateImportsRec((GroupedClientAttribute)it, subFolder, httpClient);
    } else if (it instanceof SingleClientAttribute) {
      return _generateAppStateImportsRec((SingleClientAttribute)it, subFolder, httpClient);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, subFolder, httpClient).toString());
    }
  }
}
