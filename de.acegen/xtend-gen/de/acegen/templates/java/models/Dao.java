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
package de.acegen.templates.java.models;

import de.acegen.extensions.CommonExtension;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class Dao {
  @Extension
  private CommonExtension _commonExtension;

  public CharSequence generateAceDao() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.time.LocalDateTime;");
    _builder.newLine();
    _builder.append("import java.util.concurrent.ConcurrentLinkedQueue;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.statement.Update;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.core.JsonProcessingException;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.ObjectMapper;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class AceDao {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private ObjectMapper mapper;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private ConcurrentLinkedQueue<String> lastUuids;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public AceDao() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("mapper = new ObjectMapper();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("lastUuids = new ConcurrentLinkedQueue<>();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public boolean checkUuid(String uuid) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("boolean alreadyUsed = lastUuids.contains(uuid);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (alreadyUsed) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return false;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("lastUuids.add(uuid);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (lastUuids.size() > 1000) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("lastUuids.remove();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return true;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private void insertIntoTimeline(PersistenceHandle handle, String type, String name, String data, String uuid, LocalDateTime timestamp) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Update statement = handle.getHandle().createUpdate(\"INSERT INTO timeline (type, name, time, data, uuid) \" + \"VALUES (:type, :name, :timestamp, :data, :uuid);\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("statement.bind(\"type\", type);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("statement.bind(\"name\", name);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("statement.bind(\"data\", data);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("statement.bind(\"uuid\", uuid);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("statement.bind(\"timestamp\", LocalDateTime.now());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("statement.execute();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public <T extends AbstractModel> void addActionToTimeline(String actionName, Data<T> data, PersistenceHandle timelineHandle) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("addItemToTimeline(\"action\", actionName, data, timelineHandle);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public <T extends AbstractModel> void addCommandToTimeline(String commandName, Data<T> data, PersistenceHandle timelineHandle) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("addItemToTimeline(\"command\", commandName, data, timelineHandle);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public <T extends AbstractModel> void addEventToTimeline(String eventName, Data<T> data, PersistenceHandle timelineHandle) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("addItemToTimeline(\"event\", eventName, data, timelineHandle);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public <T extends AbstractModel> void addExceptionToTimeline(String uuid, Throwable x, PersistenceHandle timelineHandle) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.insertIntoTimeline(timelineHandle, \"exception\", x.getClass().getName(),");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("x.getMessage() != null ? x.getMessage() : \"\", uuid, LocalDateTime.now());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private <T extends AbstractModel> void addItemToTimeline(String type, String name, Data<T> data, ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("PersistenceHandle timelineHandle) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("String json = mapper.writeValueAsString(data);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("this.insertIntoTimeline(timelineHandle, type, name, json, data.getUuid(), data.getSystemTime());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} catch (JsonProcessingException e) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw new RuntimeException(e);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
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
}
