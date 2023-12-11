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
package de.acegen.templates.java.resources;

import de.acegen.extensions.CommonExtension;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class SquishyDataProviderResource {
  @Extension
  private CommonExtension _commonExtension;

  public CharSequence generate() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen.resources;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import javax.ws.rs.Consumes;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.PUT;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.Path;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.Produces;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.QueryParam;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.core.MediaType;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.core.Response;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.time.LocalDateTime;");
    _builder.newLine();
    _builder.append("import java.time.format.DateTimeFormatter;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import de.acegen.SquishyDataProvider;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Path(\"/test/squishy\")");
    _builder.newLine();
    _builder.append("@Produces(MediaType.APPLICATION_JSON)");
    _builder.newLine();
    _builder.append("@Consumes(MediaType.APPLICATION_JSON)");
    _builder.newLine();
    _builder.append("public class SquishyDataProviderResource {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(SquishyDataProviderResource.class);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public SquishyDataProviderResource() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@PUT");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Path(\"/value\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Response putValue(@QueryParam(\"uuid\") String uuid, @QueryParam(\"key\") String key,  @QueryParam(\"value\") String value) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("SquishyDataProvider.put(uuid, key, value);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return Response.ok().build();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@PUT");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Path(\"/system-time\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Response putSystemTime(@QueryParam(\"uuid\") String uuid, @QueryParam(\"system-time\") String systemTime) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("SquishyDataProvider.putSystemTime(uuid, LocalDateTime.parse(systemTime, DateTimeFormatter.ISO_DATE_TIME));");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return Response.ok().build();");
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
    return _builder;
  }
}
