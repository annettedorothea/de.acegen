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
import javax.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class DropwizardConfiguration {
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  public CharSequence generateCustomAppConfiguration() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class CustomAppConfiguration extends AppConfiguration {");
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
  
  public CharSequence generateAppConfiguration() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import javax.validation.Valid;");
    _builder.newLine();
    _builder.append("import javax.validation.constraints.NotNull;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.annotation.JsonProperty;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import io.dropwizard.Configuration;");
    _builder.newLine();
    _builder.append("import io.dropwizard.db.DataSourceFactory;");
    _builder.newLine();
    _builder.append("import io.dropwizard.server.DefaultServerFactory;");
    _builder.newLine();
    _builder.append("import io.dropwizard.server.ServerFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class AppConfiguration extends Configuration {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("@Valid");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("@NotNull");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("private ServerFactory server = new DefaultServerFactory();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("@JsonProperty(\"server\")");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public ServerFactory getServerFactory() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return server;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("@JsonProperty(\"server\")");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public void setServerFactory(ServerFactory factory) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("this.server = factory;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("@Valid");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@NotNull");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private DataSourceFactory database = new DataSourceFactory();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty(\"database\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public DataSourceFactory getDataSourceFactory() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return database;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty(\"database\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.database = dataSourceFactory;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Valid");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@NotNull");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private Config config = new Config();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty(\"config\")");
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
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty(\"config\")");
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
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateConfig() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import com.fasterxml.jackson.annotation.JsonProperty;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public class Config {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public static final String LIVE = \"LIVE\";");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public static final String DEV = \"DEV\";");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public static final String ALWAYS = \"ALWAYS\";");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public static final String ON_ERROR = \"ON_ERROR\";");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public static final String NEVER = \"NEVER\";");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("private String mode = LIVE;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("private String writeTimeline = ON_ERROR;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("@JsonProperty(\"mode\")");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public String getMode() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return mode;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("@JsonProperty(\"mode\")");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public void setMode(String mode) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("this.mode = mode;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("@JsonProperty(\"writeTimeline\")");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public String getWriteTimeline() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return writeTimeline;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("@JsonProperty(\"writeTimeline\")");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public void setWriteTimeline(String writeTimeline) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("this.writeTimeline = writeTimeline;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public boolean writeTimeline() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return !NEVER.equals(writeTimeline);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public boolean writeError() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return ON_ERROR.equals(writeTimeline) || ALWAYS.equals(writeTimeline);");
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
}
