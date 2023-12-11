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
package de.acegen.templates.java;

import de.acegen.extensions.CommonExtension;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class DatabaseHandle {
  @Extension
  private CommonExtension _commonExtension;

  public CharSequence generateDatabaseHandle() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.Jdbi;");
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class DatabaseHandle {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(DatabaseHandle.class);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private PersistenceHandle writeHandle;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private PersistenceHandle readonlyHandle;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private PersistenceHandle timelineHandle;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public DatabaseHandle(Jdbi jdbi, CustomAppConfiguration appConfiguration) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.writeHandle = new PersistenceHandle(jdbi.open().setReadOnly(false));");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.readonlyHandle = new PersistenceHandle(jdbi.open().setReadOnly(true));");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (appConfiguration.getConfig().writeTimeline()) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("this.timelineHandle = new PersistenceHandle(jdbi.open().setReadOnly(false));");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("synchronized public void beginTransaction() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("writeHandle.getHandle().begin();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("readonlyHandle.getHandle().begin();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (timelineHandle != null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("timelineHandle.getHandle().begin();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("synchronized public void commitTransaction() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("writeHandle.getHandle().commit();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("readonlyHandle.getHandle().rollback();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (timelineHandle != null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("timelineHandle.getHandle().commit();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("synchronized public void rollbackTransaction() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("writeHandle.getHandle().rollback();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("readonlyHandle.getHandle().rollback();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (timelineHandle != null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("timelineHandle.getHandle().commit();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("synchronized public void close() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("writeHandle.getHandle().close();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("readonlyHandle.getHandle().close();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (timelineHandle != null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("timelineHandle.getHandle().close();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public PersistenceHandle getHandle() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return writeHandle;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public PersistenceHandle getReadonlyHandle() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return readonlyHandle;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public PersistenceHandle getTimelineHandle() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return timelineHandle;");
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
