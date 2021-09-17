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
    _builder.append("import * as AppState from \"../../gen/ace/AppState\";");
    _builder.newLine();
    _builder.append("import * as Utils from \"../../gen/ace/Utils\";");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("export let settings;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("function loadSettings() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return httpGet(\"settings.json\").then((loadedSettings) => {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("settings = loadedSettings;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (!settings.clientVersion) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("settings.clientVersion = \"\";");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (!settings.aceScenariosApiKey) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("settings.aceScenariosApiKey = \"\";");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (!settings.aceScenariosBaseUrl) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("settings.aceScenariosBaseUrl = \"\";");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (!settings.rootPath) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("settings.rootPath = \"\";");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (!settings.timelineSize) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("settings.timelineSize = 0;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (!settings.mode) {");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("settings.mode = \"live\";");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (settings.rootPath.startsWith(\"/\")) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("settings.rootPath = settings.rootPath.substring(1);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (settings.rootPath.endsWith(\"/\")) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("settings.rootPath = settings.rootPath.substring(0, settings.rootPath.length - 1);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export function initEventListeners() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("//EventListenerRegistration.init();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export function startApp() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("loadSettings().then(() => {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export function startReplay() {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export function createInitialAppState() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("const initialAppState = {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("};");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("AppState.setInitialAppState(initialAppState);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("function createHeaders(authorize) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("const headers = new Headers();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("headers.append(\"Content-Type\", \"application/json\");");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("headers.append(\"Accept\", \"application/json\");");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if (authorize === true) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("let authorization = basicAuth();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (authorization !== undefined) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("headers.append(\"Authorization\", authorization);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return headers;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("function addUuidToUrl(url, uuid) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if (uuid) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (url.indexOf(\"?\") < 0) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("url += \"?uuid=\" + uuid;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("url += \"&uuid=\" + uuid;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return url;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("function httpRequest(methodType, url, uuid, authorize, data) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return new Promise((resolve, reject) => {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("const options = {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("method: methodType,");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("headers: createHeaders(authorize),");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("mode: \'cors\',");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("cache: \'no-cache\'");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("};");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (data && methodType !== \"GET\") {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("options.body = JSON.stringify(data);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("url = addUuidToUrl(url, uuid);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("const request = new Request(url, options);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("fetch(request).then(function (response) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("response.text().then((text) => {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("if (response.status >= 300) {");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("const error = {");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("code: response.status,");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("text: response.statusText,");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("key: text");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("};");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("reject(error);");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("let data = {};");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("if (text.length > 0) {");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("data = JSON.parse(text);");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("resolve(data);");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}).catch(function (error) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("const status = {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("code: error.name,");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("text: error.message");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("};");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("reject(status);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export function httpGet(url, uuid, authorize) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return httpRequest(\"GET\", url, uuid, authorize, null);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export function httpPost(url, uuid, authorize, data) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return httpRequest(\"POST\", url, uuid, authorize, data);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export function httpPut(url, uuid, authorize, data) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return httpRequest(\"PUT\", url, uuid, authorize, data);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export function httpDelete(url, uuid, authorize, data) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return httpRequest(\"DELETE\", url, uuid, authorize, data);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("function basicAuth() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return \"<your authorization>\";");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export function createUUID() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("let d = new Date().getTime();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return \'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx\'.replace(/[xy]/g, function (c) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("let r = (d + Math.random() * 16) % 16 | 0;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("d = Math.floor(d / 16);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return (c === \'x\' ? r : (r & 0x3 | 0x8)).toString(16);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export function displayUnexpectedError(error) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("console.error(\"unexpected error \", error);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export function deepCopy(object) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return JSON.parse(JSON.stringify(object));");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export function stateUpdated() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("// re-render app");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export function renderApp() {");
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
  
  public CharSequence generateApp(final HttpClient httpClient) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import * as AppUtils from \"./app/AppUtils\";");
    _builder.newLine();
    _builder.append("import * as AppState from \"../gen/ace/AppState\";");
    _builder.newLine();
    _builder.append("import * as ACEController from \"../gen/ace/ACEController\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export * from \"../gen/ace/Timeline\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export function dumpAppState() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("console.info(AppState.getAppState());");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("AppUtils.createInitialAppState();");
    _builder.newLine();
    _builder.append("ACEController.addItemToTimeLine({");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("appState: AppState.getAppState()");
    _builder.newLine();
    _builder.append("});");
    _builder.newLine();
    _builder.append("AppUtils.initEventListeners();");
    _builder.newLine();
    _builder.append("AppUtils.startApp();");
    _builder.newLine();
    _builder.append("AppUtils.renderApp();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("// for Selenium tests");
    _builder.newLine();
    _builder.append("export function getAppState() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return AppState.getAppState();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export function addSquishyValueClient(value) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("let squishyValues = JSON.parse(localStorage.getItem(\'squishyValues\'));");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if (!squishyValues) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("squishyValues = [];");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("squishyValues.push(value);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("localStorage.setItem(\'squishyValues\', JSON.stringify(squishyValues));");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export function addSquishyValueServer(uuid, key, value) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return new Promise((resolve, reject) => {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("let url = \"\";");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (key === \"system-time\") {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("url =`/api/test/squishy/system-time?uuid=${uuid}&system-time=${value}`;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("url =`/api/test/squishy/value?uuid=${uuid}&key=${key}&value=${value}`");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return new Promise((resolve, reject) => {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("AppUtils.httpPut(url).then(() => {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("resolve();");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}, (error) => {");
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
    _builder.append("})");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export function getValueFromLocalStorage(key) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return localStorage.getItem(key);");
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
  
  public CharSequence generateACEController() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import * as AppUtils from \"../../src/app/AppUtils\";");
    _builder.newLine();
    _builder.append("import * as AppState from \"./AppState\";");
    _builder.newLine();
    _builder.append("import Event from \"./Event\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export let timeline = [];");
    _builder.newLine();
    _builder.append("export let listeners = {};");
    _builder.newLine();
    _builder.append("export let delayedActions = {};");
    _builder.newLine();
    _builder.newLine();
    _builder.append("let actionQueue = [];");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export function registerListener(eventName, listener) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if (!eventName.trim()) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("throw new Error(\'cannot register listener for empty eventName\');");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if (!listener) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("throw new Error(\'cannot register undefined listener for event \' + eventName);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("let listenersForEventName;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if (listeners[eventName] === undefined) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("listeners[eventName] = [];");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("listenersForEventName = listeners[eventName];");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("listenersForEventName.push(listener);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export function addItemToTimeLine(item) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (AppUtils.settings && AppUtils.settings.timelineSize > 0) {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("timeline.push(AppUtils.deepCopy(item));");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (timeline.length > AppUtils.settings.timelineSize) {");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("timeline.shift();");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("while (timeline.length > 0 && timeline.length > 0 && !timeline[0].appState) {");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("timeline.shift();");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export function addActionToQueue(action) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("actionQueue.push(action);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("applyNextActions();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("function applyNextActions() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("let nextAction = actionQueue.shift();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if (nextAction) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (nextAction.action.asynchronous) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("nextAction.action.applyAction(nextAction.data).then(() => {");
    _builder.newLine();
    _builder.append("\t\t    \t");
    _builder.append("applyNextActions();");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("}, (error) => {");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("AppUtils.displayUnexpectedError(error);");
    _builder.newLine();
    _builder.append("\t\t    \t");
    _builder.append("applyNextActions();");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("nextAction.action.applyAction(nextAction.data);");
    _builder.newLine();
    _builder.append("\t\t    \t");
    _builder.append("applyNextActions();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("} catch(error) {");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("AppUtils.displayUnexpectedError(error);");
    _builder.newLine();
    _builder.append("\t\t    \t");
    _builder.append("applyNextActions();");
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
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export function startReplay(timeline, pauseInMillis) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("AppUtils.startReplay();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("let events = [];");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("let appStateWasSet = false;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("for (let i = 0; i < timeline.length; i++) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("let item = timeline[i];");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (item.event && appStateWasSet && item.event.eventName !== \"TriggerAction\") {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("events.push({");
    _builder.newLine();
    _builder.append("            \t");
    _builder.append("event: new Event(item.event.eventName),");
    _builder.newLine();
    _builder.append("            \t");
    _builder.append("data: item.event.data");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (item.appState && !appStateWasSet) {");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("AppState.setInitialAppState(item.appState);");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("appStateWasSet = true;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("setTimeout(() => replayNextEvent(events, pauseInMillis), pauseInMillis);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("function replayNextEvent(events, pauseInMillis) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("let nextEvent = events.shift();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if (nextEvent) {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("nextEvent.event.replay(nextEvent.data);");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("setTimeout(() => replayNextEvent(events, pauseInMillis), pauseInMillis);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("setTimeout(() => finishReplay(), pauseInMillis);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("function finishReplay() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("console.info(\"replay finished\");");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("timeline = [];");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("actionQueue = [];");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("AppUtils.createInitialAppState();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("AppUtils.startApp();");
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
  
  public CharSequence generateTimeline() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import * as AppUtils from \"../../src/app/AppUtils\";");
    _builder.newLine();
    _builder.append("import * as ACEController from \"./ACEController\";");
    _builder.newLine();
    _builder.append("import * as Utils from \"./Utils\";");
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
    _builder.append("console.info(`saved timeline with id ${id}`);");
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
    _builder.append("console.info(ACEController.timeline);");
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
    _builder.append("import * as AppUtils from \"../../src/app/AppUtils\";");
    _builder.newLine();
    _builder.append("import * as ACEController from \"./ACEController\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("function getServerInfo() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return AppUtils.httpGet(AppUtils.settings.rootPath + \'/server/info\');");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export function saveTimeline(description, creator) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return getServerInfo().then((serverInfo) => {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("const browser = getBrowserInfo();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("const uuid = AppUtils.createUUID();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("const data = {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("description,");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("timeline: JSON.stringify(ACEController.timeline),");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("creator,");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("clientVersion: AppUtils.settings.clientVersion,");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("device: browser.name + \" \" + browser.version,");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("apiKey: AppUtils.settings.aceScenariosApiKey,");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("serverVersion: serverInfo.serverVersion");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("};");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return AppUtils.httpPost(AppUtils.settings.aceScenariosBaseUrl + \'api/client-timeline/create\', uuid, false, data).then(() => {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("return new Promise((resolve) => {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("resolve(uuid);");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export function loadTimeline(id) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return AppUtils.httpGet(AppUtils.settings.aceScenariosBaseUrl + `api/timeline?id=${id}&apiKey=${AppUtils.settings.aceScenariosApiKey}`, AppUtils.createUUID(), false);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("function getBrowserInfo() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("let ua = navigator.userAgent, tem,");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("M = ua.match(/(opera|chrome|safari|firefox|msie|trident(?=\\/))\\/?\\s*(\\d+)/i) || [];");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if (/trident/i.test(M[1])) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("tem = /\\brv[ :]+(\\d+)/g.exec(ua) || [];");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return {name: \'IE \', version: (tem[1] || \'\')};");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if (M[1] === \'Chrome\') {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("tem = ua.match(/\\bOPR\\/(\\d+)/);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (tem != null) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("return {name: \'Opera\', version: tem[1]};");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("M = M[2] ? [M[1], M[2]] : [navigator.appName, navigator.appVersion, \'-?\'];");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if ((tem = ua.match(/version\\/(\\d+)/i)) != null) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("M.splice(1, 1, tem[1]);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("name: M[0],");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("version: M[1]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("};");
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
  
  public String generateAppState(final List<ClientAttribute> attributes, final String prefix, final HttpClient httpClient) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import * as AppUtils from \"../../src/app/AppUtils\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("let appState;");
    _builder.newLine();
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
      for(final ClientAttribute attribute : attributes) {
        String _generateAppStateRec = this.generateAppStateRec(attribute, httpClient);
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
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence stateObjectCreation(final ClientAttribute it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (((it.eContainer() != null) && (it.eContainer() instanceof GroupedClientAttribute))) {
        _builder.append("if (");
        String _elementPath = this._es6Extension.elementPath(it);
        _builder.append(_elementPath);
        _builder.append(" && !");
        String _elementPath_1 = this._es6Extension.elementPath(it);
        _builder.append(_elementPath_1);
        _builder.append(".is");
        String _firstUpper = StringExtensions.toFirstUpper(it.getName());
        _builder.append(_firstUpper);
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("return;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("if (!");
        String _elementPath_2 = this._es6Extension.elementPath(it);
        _builder.append(_elementPath_2);
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _elementPath_3 = this._es6Extension.elementPath(it);
        _builder.append(_elementPath_3, "\t");
        _builder.append(" = {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("is");
        String _firstUpper_1 = StringExtensions.toFirstUpper(it.getName());
        _builder.append(_firstUpper_1, "\t\t");
        _builder.append(" : true");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("};");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      } else {
        _builder.append("if (!");
        String _elementPath_4 = this._es6Extension.elementPath(it);
        _builder.append(_elementPath_4);
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _elementPath_5 = this._es6Extension.elementPath(it);
        _builder.append(_elementPath_5, "\t");
        _builder.append(" = {};");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  private CharSequence mergeStateFunction(final SingleClientAttribute it, final HttpClient httpClient) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (((it.isHash() || it.isStorage()) || it.isList())) {
      } else {
        if (((it.getAttributes() != null) && (((Object[])Conversions.unwrapArray(it.getAttributes(), Object.class)).length > 0))) {
          _builder.append("export function merge_");
          String _functionName = this._es6Extension.functionName(it);
          _builder.append(_functionName);
          _builder.append("(eventData) {");
          _builder.newLineIfNotEmpty();
          {
            List<ClientAttribute> _allParentAttributes = this._es6Extension.allParentAttributes(it);
            for(final ClientAttribute attr : _allParentAttributes) {
              _builder.append("\t");
              CharSequence _stateObjectCreation = this.stateObjectCreation(attr);
              _builder.append(_stateObjectCreation, "\t");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          CharSequence _stateObjectCreation_1 = this.stateObjectCreation(it);
          _builder.append(_stateObjectCreation_1, "\t");
          _builder.newLineIfNotEmpty();
          {
            EList<ClientAttribute> _attributes = it.getAttributes();
            for(final ClientAttribute attribute : _attributes) {
              {
                if ((attribute instanceof SingleClientAttribute)) {
                  _builder.append("\t");
                  _builder.append("if (eventData.");
                  String _name = it.getName();
                  _builder.append(_name, "\t");
                  _builder.append(" && eventData.");
                  String _name_1 = it.getName();
                  _builder.append(_name_1, "\t");
                  _builder.append(".");
                  String _name_2 = ((SingleClientAttribute)attribute).getName();
                  _builder.append(_name_2, "\t");
                  _builder.append(" !== undefined) {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  String _elementPath = this._es6Extension.elementPath(attribute);
                  _builder.append(_elementPath, "\t\t");
                  _builder.append(" = eventData.");
                  String _name_3 = it.getName();
                  _builder.append(_name_3, "\t\t");
                  _builder.append(".");
                  String _name_4 = ((SingleClientAttribute)attribute).getName();
                  _builder.append(_name_4, "\t\t");
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("}");
                  _builder.newLine();
                }
              }
            }
          }
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
        } else {
          _builder.append("export function merge_");
          String _functionName_1 = this._es6Extension.functionName(it);
          _builder.append(_functionName_1);
          _builder.append("(eventData) {");
          _builder.newLineIfNotEmpty();
          {
            List<ClientAttribute> _allParentAttributes_1 = this._es6Extension.allParentAttributes(it);
            for(final ClientAttribute attr_1 : _allParentAttributes_1) {
              _builder.append("\t");
              CharSequence _stateObjectCreation_2 = this.stateObjectCreation(attr_1);
              _builder.append(_stateObjectCreation_2, "\t");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          String _elementPath_1 = this._es6Extension.elementPath(it);
          _builder.append(_elementPath_1, "\t");
          _builder.append(" = eventData.");
          String _name_5 = it.getName();
          _builder.append(_name_5, "\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
        }
      }
    }
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
}
