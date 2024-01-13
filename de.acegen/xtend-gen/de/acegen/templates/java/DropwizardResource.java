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
public class DropwizardResource {
  @Inject
  @Extension
  private CommonExtension _commonExtension;

  public CharSequence generateDropwizardResource() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import javax.ws.rs.core.Response;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public abstract class Resource {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected Response ok() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return Response.status(Response.Status.OK).build();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected Response badRequest(String message) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return Response.status(Response.Status.BAD_REQUEST).entity(message).build();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected Response unauthorized(String message) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return Response.status(Response.Status.UNAUTHORIZED).entity(message).build();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected Response internalServerError(Exception x) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String message = x.getMessage();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("StackTraceElement[] stackTrace = x.getStackTrace();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("int i = 1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for (StackTraceElement stackTraceElement : stackTrace) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("message += \"\\n\" + stackTraceElement.toString();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (i > 3) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("message += \"\\n\" + (stackTrace.length - 4) + \" more...\";");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("break;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("i++;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(message).build();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
}
