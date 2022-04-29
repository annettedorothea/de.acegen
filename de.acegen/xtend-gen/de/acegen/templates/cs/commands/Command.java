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
package de.acegen.templates.cs.commands;

import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAceWrite;
import de.acegen.aceGen.HttpServerOutcome;
import de.acegen.aceGen.HttpServerView;
import de.acegen.aceGen.HttpServerViewFunction;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.java.JavaHttpServerExtension;
import de.acegen.extensions.java.ModelExtension;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class Command {
  @Inject
  @Extension
  private JavaHttpServerExtension _javaHttpServerExtension;
  
  @Inject
  @Extension
  private ModelExtension _modelExtension;
  
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  public CharSequence generateAbstractCommandFile(final HttpServerAceWrite it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = java.getName();
    _builder.append(_name);
    _builder.append(".commands;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import de.acegen.Command;");
    _builder.newLine();
    _builder.append("import de.acegen.CustomAppConfiguration;");
    _builder.newLine();
    _builder.append("import de.acegen.IDaoProvider;");
    _builder.newLine();
    _builder.append("import de.acegen.ViewProvider;");
    _builder.newLine();
    _builder.append("import de.acegen.PersistenceHandle;");
    _builder.newLine();
    _builder.append("import de.acegen.Event;");
    _builder.newLine();
    _builder.newLine();
    String _dataImport = this._modelExtension.dataImport(it.getModel());
    _builder.append(_dataImport);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"unused\")");
    _builder.newLine();
    _builder.append("public abstract class ");
    String _abstractCommandName = this._javaHttpServerExtension.abstractCommandName(it);
    _builder.append(_abstractCommandName);
    _builder.append(" extends Command<");
    String _dataParamType = this._modelExtension.dataParamType(it.getModel());
    _builder.append(_dataParamType);
    _builder.append("> {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _abstractCommandName_1 = this._javaHttpServerExtension.abstractCommandName(it);
    _builder.append(_abstractCommandName_1, "\t");
    _builder.append("(IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(\"");
    String _name_1 = java.getName();
    _builder.append(_name_1, "\t\t");
    _builder.append(".commands.");
    String _commandName = this._javaHttpServerExtension.commandName(it);
    _builder.append(_commandName, "\t\t");
    _builder.append("\", daoProvider, viewProvider, appConfiguration);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<HttpServerOutcome> _outcomes = it.getOutcomes();
      for(final HttpServerOutcome outcome : _outcomes) {
        _builder.append("\t");
        _builder.append("protected void add");
        String _firstUpper = StringExtensions.toFirstUpper(outcome.getName());
        _builder.append(_firstUpper, "\t");
        _builder.append("Outcome(");
        String _dataParamType_1 = this._modelExtension.dataParamType(it.getModel());
        _builder.append(_dataParamType_1, "\t");
        _builder.append(" data) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("data.addOutcome(\"");
        String _name_2 = outcome.getName();
        _builder.append(_name_2, "\t\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void addEventsToTimeline(");
    String _dataParamType_2 = this._modelExtension.dataParamType(it.getModel());
    _builder.append(_dataParamType_2, "\t");
    _builder.append(" data, PersistenceHandle timelineHandle) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("if (appConfiguration.getConfig().writeTimeline()) {");
    _builder.newLine();
    {
      EList<HttpServerOutcome> _outcomes_1 = it.getOutcomes();
      for(final HttpServerOutcome outcome_1 : _outcomes_1) {
        {
          int _size = outcome_1.getListeners().size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            _builder.append("\t\t\t");
            _builder.append("if (data.hasOutcome(\"");
            String _name_3 = outcome_1.getName();
            _builder.append(_name_3, "\t\t\t");
            _builder.append("\")){");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("daoProvider.getAceDao().addEventToTimeline(\"");
            String _eventNameWithPackage = this._javaHttpServerExtension.eventNameWithPackage(it, outcome_1);
            _builder.append(_eventNameWithPackage, "\t\t\t\t");
            _builder.append("\", data, timelineHandle);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void publishEvents(");
    String _dataParamType_3 = this._modelExtension.dataParamType(it.getModel());
    _builder.append(_dataParamType_3, "\t");
    _builder.append(" data, PersistenceHandle handle, PersistenceHandle timelineHandle) {");
    _builder.newLineIfNotEmpty();
    {
      EList<HttpServerOutcome> _outcomes_2 = it.getOutcomes();
      for(final HttpServerOutcome outcome_2 : _outcomes_2) {
        {
          final Function1<HttpServerViewFunction, Boolean> _function = (HttpServerViewFunction listenerFunction) -> {
            EObject _eContainer = listenerFunction.eContainer();
            boolean _isAfterCommit = ((HttpServerView) _eContainer).isAfterCommit();
            return Boolean.valueOf((!_isAfterCommit));
          };
          int _size_1 = IterableExtensions.size(IterableExtensions.<HttpServerViewFunction>filter(outcome_2.getListeners(), _function));
          boolean _greaterThan_1 = (_size_1 > 0);
          if (_greaterThan_1) {
            _builder.append("\t\t");
            _builder.append("if (data.hasOutcome(\"");
            String _name_4 = outcome_2.getName();
            _builder.append(_name_4, "\t\t");
            _builder.append("\")){");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("new Event<");
            String _dataParamType_4 = this._modelExtension.dataParamType(it.getModel());
            _builder.append(_dataParamType_4, "\t\t\t");
            _builder.append(">(\"");
            String _eventNameWithPackage_1 = this._javaHttpServerExtension.eventNameWithPackage(it, outcome_2);
            _builder.append(_eventNameWithPackage_1, "\t\t\t");
            _builder.append("\", viewProvider).publish(data.deepCopy(), handle, timelineHandle);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void publishAfterCommitEvents(");
    String _dataParamType_5 = this._modelExtension.dataParamType(it.getModel());
    _builder.append(_dataParamType_5, "\t");
    _builder.append(" data, PersistenceHandle handle, PersistenceHandle timelineHandle) {");
    _builder.newLineIfNotEmpty();
    {
      EList<HttpServerOutcome> _outcomes_3 = it.getOutcomes();
      for(final HttpServerOutcome outcome_3 : _outcomes_3) {
        {
          final Function1<HttpServerViewFunction, Boolean> _function_1 = (HttpServerViewFunction listenerFunction) -> {
            EObject _eContainer = listenerFunction.eContainer();
            return Boolean.valueOf(((HttpServerView) _eContainer).isAfterCommit());
          };
          int _size_2 = IterableExtensions.size(IterableExtensions.<HttpServerViewFunction>filter(outcome_3.getListeners(), _function_1));
          boolean _greaterThan_2 = (_size_2 > 0);
          if (_greaterThan_2) {
            _builder.append("\t\t");
            _builder.append("if (data.hasOutcome(\"");
            String _name_5 = outcome_3.getName();
            _builder.append(_name_5, "\t\t");
            _builder.append("\")){");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("new Event<");
            String _dataParamType_6 = this._modelExtension.dataParamType(it.getModel());
            _builder.append(_dataParamType_6, "\t\t\t");
            _builder.append(">(\"");
            String _eventNameWithPackage_2 = this._javaHttpServerExtension.eventNameWithPackage(it, outcome_3);
            _builder.append(_eventNameWithPackage_2, "\t\t\t");
            _builder.append("\", viewProvider).publishAfterCommit(data.deepCopy(), handle, timelineHandle);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
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
  
  public CharSequence generateInitialCommandFile(final HttpServerAceWrite it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = java.getName();
    _builder.append(_name);
    _builder.append(".commands;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import de.acegen.ViewProvider;");
    _builder.newLine();
    _builder.append("import de.acegen.IDaoProvider;");
    _builder.newLine();
    _builder.append("import de.acegen.CustomAppConfiguration;");
    _builder.newLine();
    _builder.append("import de.acegen.PersistenceHandle;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    String _dataImport = this._modelExtension.dataImport(it.getModel());
    _builder.append(_dataImport);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _commandName = this._javaHttpServerExtension.commandName(it);
    _builder.append(_commandName);
    _builder.append(" extends ");
    String _abstractCommandName = this._javaHttpServerExtension.abstractCommandName(it);
    _builder.append(_abstractCommandName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(");
    String _commandName_1 = this._javaHttpServerExtension.commandName(it);
    _builder.append(_commandName_1, "\t");
    _builder.append(".class);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _commandName_2 = this._javaHttpServerExtension.commandName(it);
    _builder.append(_commandName_2, "\t");
    _builder.append("(IDaoProvider daoProvider, ViewProvider viewProvider, ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("CustomAppConfiguration appConfiguration) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super(daoProvider, viewProvider, appConfiguration);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected ");
    String _dataParamType = this._modelExtension.dataParamType(it.getModel());
    _builder.append(_dataParamType, "\t");
    _builder.append(" executeCommand(");
    String _dataParamType_1 = this._modelExtension.dataParamType(it.getModel());
    _builder.append(_dataParamType_1, "\t");
    _builder.append(" data, PersistenceHandle readonlyHandle) {");
    _builder.newLineIfNotEmpty();
    {
      int _size = it.getOutcomes().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _builder.append("\t\t");
        _builder.append("this.add");
        String _firstUpper = StringExtensions.toFirstUpper(it.getOutcomes().get(0).getName());
        _builder.append(_firstUpper, "\t\t");
        _builder.append("Outcome(data);");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("return data;");
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
  
  public CharSequence generateCommand() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("namespace AceGen");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public abstract class Command<T> : ICommand<T> where T : IDataContainer");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("{");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("public abstract string CommandName { get; }");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("private readonly AppConfiguration appConfiguration;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("private readonly IAceDao aceDao;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("protected Command(AppConfiguration appConfiguration, IAceDao aceDao)");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("this.appConfiguration = appConfiguration;");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("this.aceDao = aceDao;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("public abstract void addEventsToTimeline(T data);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("protected abstract T executeCommand(T data);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("public T execute(T data)");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("if (appConfiguration.WriteTimeline)");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("aceDao.addCommandToTimeLine(this.CommandName, data);");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("return this.executeCommand(data);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("public abstract void publishAfterCommitEvents(T data);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("public abstract void publishEvents(T data);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("protected void throwSecurityException()");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("throw new UnauthorizedAccessException();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("protected void throwIllegalArgumentException(String error)");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("throw new BadHttpRequestException(error);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
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
  
  public CharSequence generateICommand() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("namespace AceGen");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public interface ICommand<T> where T : IDataContainer");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("string CommandName { get; }");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("T execute(T data);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("void addEventsToTimeline(T data);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("void publishEvents(T data);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("void publishAfterCommitEvents(T data);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
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
