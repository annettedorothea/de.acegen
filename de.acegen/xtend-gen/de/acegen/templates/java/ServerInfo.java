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
import jakarta.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class ServerInfo {
  @Inject
  @Extension
  private CommonExtension _commonExtension;

  public CharSequence generate() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.annotation.JsonProperty;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ServerInfo {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private String serverVersion;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ServerInfo(String serverVersion) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.serverVersion = serverVersion;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String getServerVersion() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return serverVersion;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
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
