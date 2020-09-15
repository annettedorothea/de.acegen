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
import javax.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class StartE2ESessionResource {
  @Inject
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
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import java.time.LocalDateTime;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import javax.validation.constraints.NotNull;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.Consumes;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.PUT;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.Path;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.Produces;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.WebApplicationException;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.core.MediaType;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.core.Response;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.Jdbi;");
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.core.JsonProcessingException;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import de.acegen.Config;");
    _builder.newLine();
    _builder.append("import de.acegen.CustomAppConfiguration;");
    _builder.newLine();
    _builder.append("import de.acegen.DaoProvider;");
    _builder.newLine();
    _builder.append("import de.acegen.E2E;");
    _builder.newLine();
    _builder.append("import de.acegen.IDaoProvider;");
    _builder.newLine();
    _builder.append("import de.acegen.ITimelineItem;");
    _builder.newLine();
    _builder.append("import de.acegen.PersistenceHandle;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Path(\"/e2e\")");
    _builder.newLine();
    _builder.append("@Produces(MediaType.APPLICATION_JSON)");
    _builder.newLine();
    _builder.append("@Consumes(MediaType.APPLICATION_JSON)");
    _builder.newLine();
    _builder.append("public class StartE2ESessionResource {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(StartE2ESessionResource.class);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private Jdbi jdbi;\t\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private CustomAppConfiguration configuration;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private IDaoProvider daoProvider = new DaoProvider();");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private E2E e2e;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public StartE2ESessionResource(Jdbi jdbi, IDaoProvider daoProvider, E2E e2e, CustomAppConfiguration configuration) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.jdbi = jdbi;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.daoProvider = daoProvider;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.e2e = e2e;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.configuration = configuration;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@PUT");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Path(\"/start\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Response put(@NotNull List<ITimelineItem> timeline) throws JsonProcessingException {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (Config.LIVE.equals(configuration.getConfig().getMode())) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw new WebApplicationException(\"start e2e session is not available in a live environment\", Response.Status.FORBIDDEN);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (e2e.isSessionRunning() && e2e.getSessionStartedAt().plusMinutes(1).isAfter(LocalDateTime.now())) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw new WebApplicationException(\"session is already running\", Response.Status.SERVICE_UNAVAILABLE);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("e2e.init(timeline);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("PersistenceHandle handle = new PersistenceHandle(jdbi.open());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("handle.getHandle().begin();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("daoProvider.getAceDao().truncateTimelineTable(handle);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("daoProvider.truncateAllViews(handle);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("handle.getHandle().commit();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return Response.ok().build();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} catch (Exception e) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("handle.getHandle().rollback();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw new WebApplicationException(e);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} finally {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("handle.getHandle().close();");
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
