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
public class DropwizardEventReplayCommand {
  @Inject
  @Extension
  private CommonExtension _commonExtension;

  public CharSequence generateEventReplayCommand() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import java.util.Scanner;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.Jdbi;");
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import io.dropwizard.Application;");
    _builder.newLine();
    _builder.append("import io.dropwizard.cli.EnvironmentCommand;");
    _builder.newLine();
    _builder.append("import io.dropwizard.jdbi3.JdbiFactory;");
    _builder.newLine();
    _builder.append("import io.dropwizard.setup.Environment;");
    _builder.newLine();
    _builder.append("import net.sourceforge.argparse4j.inf.Namespace;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class EventReplayCommand extends EnvironmentCommand<CustomAppConfiguration> {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(EventReplayCommand.class);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected EventReplayCommand(Application<CustomAppConfiguration> application) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super(application, \"replay\", \"truncates views and replays events\");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void run(Environment environment, Namespace namespace, CustomAppConfiguration configuration)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throws Exception {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Scanner scanner = new Scanner(System.in);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("System.out.print(\"The database is going to be cleared before replaying events. Continue? Confirm with yes: \");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String input = scanner.nextLine();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("scanner.close();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (!input.equals(\"yes\")) {");
    _builder.newLine();
    _builder.append("        \t");
    _builder.append("System.out.print(\"Event replay aborted.\");");
    _builder.newLine();
    _builder.append("        \t");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("IDaoProvider daoProvider = DaoProvider.create();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ViewProvider viewProvider = ViewProvider.create(daoProvider, configuration);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("final JdbiFactory factory = new JdbiFactory();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), \"data-source-name\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("DatabaseHandle databaseHandle = new DatabaseHandle(jdbi, configuration);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("AppRegistration.registerConsumers(viewProvider);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("databaseHandle.beginTransaction();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("PersistenceHandle handle = databaseHandle.getHandle();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("daoProvider.truncateAllViews(handle);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("List<ITimelineItem> timeline = daoProvider.getAceDao().selectReplayTimeline(handle);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("LOG.info(\"START EVENT REPLAY: found {} events\", timeline.size());");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("int i = 0;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("for (ITimelineItem nextEvent : timeline) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("EventReplayService.replayEvent(nextEvent.getName(), nextEvent.getData(), handle, viewProvider);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("i++;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (i%1000 == 0) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("LOG.info(\"published \" + i + \" events\");");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("LOG.info(\"published \" + nextEvent.getUuid() + \" - \" + nextEvent.getName());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("databaseHandle.commitTransaction();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("LOG.info(\"EVENT REPLAY FINISHED: successfully replayed \" + i + \" events\");");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} catch (Exception e) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("databaseHandle.rollbackTransaction();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("LOG.info(\"EVENT REPLAY ABORTED \" + e.getMessage());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw e;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} finally {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("databaseHandle.close();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
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
}
