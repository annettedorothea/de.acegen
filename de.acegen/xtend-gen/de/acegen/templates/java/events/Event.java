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
package de.acegen.templates.java.events;

import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.HttpServerOutcome;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.java.AceExtension;
import de.acegen.extensions.java.ModelExtension;
import javax.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class Event {
  @Inject
  @Extension
  private AceExtension _aceExtension;
  
  @Inject
  @Extension
  private ModelExtension _modelExtension;
  
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  public CharSequence generateEventFile(final HttpServerAce it, final HttpServerOutcome outcome, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = java.getName();
    _builder.append(_name);
    _builder.append(".events;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import de.acegen.Event;");
    _builder.newLine();
    _builder.append("import de.acegen.IDaoProvider;");
    _builder.newLine();
    _builder.append("import de.acegen.ViewProvider;");
    _builder.newLine();
    _builder.append("import de.acegen.CustomAppConfiguration;");
    _builder.newLine();
    _builder.newLine();
    String _dataImport = this._modelExtension.dataImport(it.getModel());
    _builder.append(_dataImport);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _eventName = this._aceExtension.eventName(it, outcome);
    _builder.append(_eventName);
    _builder.append(" extends Event<");
    String _dataParamType = this._modelExtension.dataParamType(it.getModel());
    _builder.append(_dataParamType);
    _builder.append("> {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _eventName_1 = this._aceExtension.eventName(it, outcome);
    _builder.append(_eventName_1, "\t");
    _builder.append("(IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(\"");
    String _name_1 = java.getName();
    _builder.append(_name_1, "\t\t");
    _builder.append(".events.");
    String _eventName_2 = this._aceExtension.eventName(it, outcome);
    _builder.append(_eventName_2, "\t\t");
    _builder.append("\", daoProvider, viewProvider, appConfiguration);");
    _builder.newLineIfNotEmpty();
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
  
  public CharSequence generateEvent() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public abstract class Event<T extends IDataContainer> implements IEvent<T> {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private String eventName;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private IDaoProvider daoProvider;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private ViewProvider viewProvider;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private CustomAppConfiguration appConfiguration;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Event(String eventName, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.eventName = eventName;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.daoProvider = daoProvider;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.viewProvider = viewProvider;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.appConfiguration = appConfiguration;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void notifyListeners(T data, PersistenceHandle handle) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("List<EventConsumer> consumerList = viewProvider.getConsumerForEvent(eventName);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (consumerList != null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("for (EventConsumer consumer : consumerList) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("consumer.consumeEvent(data, handle);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void notifyAfterCommitListeners(T data, PersistenceHandle handle) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("List<EventConsumer> consumerList = viewProvider.getAfterCommitConsumerForEvent(eventName);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (consumerList != null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("for (EventConsumer consumer : consumerList) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("consumer.consumeEvent(data, handle);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String getEventName() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return eventName;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void publish(T data, PersistenceHandle handle, PersistenceHandle timelineHandle) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (appConfiguration.getConfig().writeTimeline()) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("daoProvider.getAceDao().addEventToTimeline(this.getEventName(), data, timelineHandle);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.notifyListeners(data, handle);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void publishAfterCommit(T data, PersistenceHandle handle, PersistenceHandle timelineHandle) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (appConfiguration.getConfig().writeTimeline()) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("daoProvider.getAceDao().addEventToTimeline(this.getEventName(), data, timelineHandle);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.notifyAfterCommitListeners(data, handle);");
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
  
  public CharSequence generateIEvent() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public interface IEvent<T extends IDataContainer> {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String getEventName();");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("void publish(T data, PersistenceHandle handle, PersistenceHandle timelineHandle);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("void publishAfterCommit(T data, PersistenceHandle handle, PersistenceHandle timelineHandle);");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("void notifyListeners(T data, PersistenceHandle handle);");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("void notifyAfterCommitListeners(T data, PersistenceHandle handle);");
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
}
