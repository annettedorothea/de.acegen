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
package de.acegen.templates.java.scenario;

import de.acegen.extensions.CommonExtension;
import jakarta.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class YamlConfiguration {
  @Inject
  @Extension
  private CommonExtension _commonExtension;

  public CharSequence generateYamlConfiguration() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class YamlConfiguration {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private Database database;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private Server server;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private Config config;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Database getDatabase() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return database;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void setDatabase(Database database) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.database = database;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Server getServer() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return server;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void setServer(Server server) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.server = server;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Config getConfig() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return config;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void setConfig(Config config) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.config = config;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
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

  public CharSequence generateDatabase() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class Database {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private String url;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String getUrl() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return url;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void setUrl(String url) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.url = url;");
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
    return _builder;
  }

  public CharSequence generateServer() {
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
    _builder.append("public class Server {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private String rootPath;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private Connectors[] applicationConnectors;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty(\"rootPath\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String getRootPath() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return rootPath;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty(\"rootPath\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void setRootPath(String rootPath) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.rootPath = rootPath;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty(\"applicationConnectors\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Connectors[] getApplicationConnectors() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return applicationConnectors;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty(\"applicationConnectors\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void setApplicationConnectors(Connectors[] applicationConnectors) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.applicationConnectors = applicationConnectors;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
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

  public CharSequence generateConnectors() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class Connectors {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private String type;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private String port;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String getType() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return type;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void setType(String type) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.type = type;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String getPort() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return port;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void setPort(String port) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.port = port;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
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
}
