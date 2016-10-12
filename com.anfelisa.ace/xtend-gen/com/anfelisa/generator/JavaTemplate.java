package com.anfelisa.generator;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.Command;
import com.anfelisa.ace.Event;
import com.anfelisa.ace.EventOnOutcome;
import com.anfelisa.ace.Project;
import com.anfelisa.ace.View;
import com.anfelisa.ace.ViewFunction;
import com.anfelisa.extensions.ActionExtension;
import com.anfelisa.extensions.CommandExtension;
import com.anfelisa.extensions.EventExtension;
import com.anfelisa.extensions.ViewExtension;
import com.google.common.base.Objects;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class JavaTemplate {
  @Inject
  @Extension
  private ActionExtension _actionExtension;
  
  @Inject
  @Extension
  private CommandExtension _commandExtension;
  
  @Inject
  @Extension
  private EventExtension _eventExtension;
  
  @Inject
  @Extension
  private ViewExtension _viewExtension;
  
  public CharSequence generateAbstractActionFile(final Action it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = project.getName();
    _builder.append(_name, "");
    _builder.append(".actions;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.Action;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.DatabaseHandle;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.HttpMethod;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.ICommand;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.IDataContainer;");
    _builder.newLine();
    _builder.newLine();
    {
      Command _command = it.getCommand();
      boolean _notEquals = (!Objects.equal(_command, null));
      if (_notEquals) {
        _builder.append("import ");
        String _name_1 = project.getName();
        _builder.append(_name_1, "");
        _builder.append(".commands.");
        Command _command_1 = it.getCommand();
        String _commandName = this._commandExtension.commandName(_command_1);
        _builder.append(_commandName, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("public abstract class ");
    String _abstractActionName = this._actionExtension.abstractActionName(it);
    _builder.append(_abstractActionName, "");
    _builder.append(" extends Action {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _abstractActionName_1 = this._actionExtension.abstractActionName(it);
    _builder.append(_abstractActionName_1, "\t");
    _builder.append("(IDataContainer actionParam, DatabaseHandle databaseHandle) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(\"");
    String _actionName = this._actionExtension.actionName(it);
    _builder.append(_actionName, "\t\t");
    _builder.append("\", HttpMethod.");
    String _type = it.getType();
    _builder.append(_type, "\t\t");
    _builder.append(", actionParam, databaseHandle);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ICommand getCommand() {");
    _builder.newLine();
    {
      Command _command_2 = it.getCommand();
      boolean _notEquals_1 = (!Objects.equal(_command_2, null));
      if (_notEquals_1) {
        _builder.append("\t\t");
        _builder.append("return new ");
        Command _command_3 = it.getCommand();
        String _commandName_1 = this._commandExtension.commandName(_command_3);
        _builder.append(_commandName_1, "\t\t");
        _builder.append("(this.actionData.copy(), databaseHandle);");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("\t\t");
        _builder.append("return null;");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateAbstractCommandFile(final Command it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = project.getName();
    _builder.append(_name, "");
    _builder.append(".commands;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import javax.ws.rs.WebApplicationException;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.Command;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.DatabaseHandle;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.IDataContainer;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import ");
    String _name_1 = project.getName();
    _builder.append(_name_1, "");
    _builder.append(".events.*;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public abstract class ");
    String _abstractCommandName = this._commandExtension.abstractCommandName(it);
    _builder.append(_abstractCommandName, "");
    _builder.append(" extends Command {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      EList<EventOnOutcome> _eventsOnOutcome = it.getEventsOnOutcome();
      for(final EventOnOutcome eventOnOutcome : _eventsOnOutcome) {
        _builder.append("\t");
        _builder.append("protected static final String ");
        String _outcome = eventOnOutcome.getOutcome();
        _builder.append(_outcome, "\t");
        _builder.append(" = \"");
        String _outcome_1 = eventOnOutcome.getOutcome();
        _builder.append(_outcome_1, "\t");
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _abstractCommandName_1 = this._commandExtension.abstractCommandName(it);
    _builder.append(_abstractCommandName_1, "\t");
    _builder.append("(IDataContainer commandParam, DatabaseHandle databaseHandle) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(\"");
    String _commandName = this._commandExtension.commandName(it);
    _builder.append(_commandName, "\t\t");
    _builder.append("\", commandParam, databaseHandle);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void publishEvents() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("switch (this.outcome) {");
    _builder.newLine();
    {
      EList<EventOnOutcome> _eventsOnOutcome_1 = it.getEventsOnOutcome();
      for(final EventOnOutcome eventOnOutcome_1 : _eventsOnOutcome_1) {
        _builder.append("\t\t");
        _builder.append("case ");
        String _outcome_2 = eventOnOutcome_1.getOutcome();
        _builder.append(_outcome_2, "\t\t");
        _builder.append(":");
        _builder.newLineIfNotEmpty();
        {
          EList<Event> _events = eventOnOutcome_1.getEvents();
          for(final Event event : _events) {
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("new ");
            String _eventName = this._eventExtension.eventName(event);
            _builder.append(_eventName, "\t\t\t");
            _builder.append("(this.commandData.copy(), databaseHandle).publish();");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("break;");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.append("default:");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw new WebApplicationException(\"unhandled outcome \" + outcome);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateAbstractEventFile(final Event it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = project.getName();
    _builder.append(_name, "");
    _builder.append(".events;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.DatabaseHandle;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.Event;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.IDataContainer;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public abstract class ");
    String _abstractEventName = this._eventExtension.abstractEventName(it);
    _builder.append(_abstractEventName, "");
    _builder.append(" extends Event {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _abstractEventName_1 = this._eventExtension.abstractEventName(it);
    _builder.append(_abstractEventName_1, "\t");
    _builder.append("(IDataContainer eventParam, DatabaseHandle databaseHandle) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(\"");
    String _eventName = this._eventExtension.eventName(it);
    _builder.append(_eventName, "\t\t");
    _builder.append("\", eventParam, databaseHandle);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateInitialActionFile(final Action it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = project.getName();
    _builder.append(_name, "");
    _builder.append(".actions;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.DatabaseHandle;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.IDataContainer;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _actionName = this._actionExtension.actionName(it);
    _builder.append(_actionName, "");
    _builder.append(" extends ");
    String _abstractActionName = this._actionExtension.abstractActionName(it);
    _builder.append(_abstractActionName, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(");
    String _actionName_1 = this._actionExtension.actionName(it);
    _builder.append(_actionName_1, "\t");
    _builder.append(".class);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _actionName_2 = this._actionExtension.actionName(it);
    _builder.append(_actionName_2, "\t");
    _builder.append("(IDataContainer actionParam, DatabaseHandle databaseHandle) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(actionParam, databaseHandle);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void captureActionParam() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// capture all stuff that we need to replay this action (e.g. system time)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void applyAction() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// init actionData maybe like so:");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.actionData = this.actionParam.copy();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateInitialCommandFile(final Command it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = project.getName();
    _builder.append(_name, "");
    _builder.append(".commands;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.DatabaseHandle;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.IDataContainer;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _commandName = this._commandExtension.commandName(it);
    _builder.append(_commandName, "");
    _builder.append(" extends ");
    String _abstractCommandName = this._commandExtension.abstractCommandName(it);
    _builder.append(_abstractCommandName, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(");
    String _commandName_1 = this._commandExtension.commandName(it);
    _builder.append(_commandName_1, "\t");
    _builder.append(".class);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _commandName_2 = this._commandExtension.commandName(it);
    _builder.append(_commandName_2, "\t");
    _builder.append("(IDataContainer commandParam, DatabaseHandle databaseHandle) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(commandParam, databaseHandle);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void executeCommand() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// execute command and set outcome");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateInitialEventFile(final Event it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = project.getName();
    _builder.append(_name, "");
    _builder.append(".events;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.DatabaseHandle;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.IDataContainer;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _eventName = this._eventExtension.eventName(it);
    _builder.append(_eventName, "");
    _builder.append(" extends ");
    String _abstractEventName = this._eventExtension.abstractEventName(it);
    _builder.append(_abstractEventName, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(");
    String _eventName_1 = this._eventExtension.eventName(it);
    _builder.append(_eventName_1, "\t");
    _builder.append(".class);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _eventName_2 = this._eventExtension.eventName(it);
    _builder.append(_eventName_2, "\t");
    _builder.append("(IDataContainer eventParam, DatabaseHandle databaseHandle) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(eventParam, databaseHandle);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void prepareDataForView() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// prepare data for view, at least copy it");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.eventData = this.eventParam.copy();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateInitialResourceFile(final Action it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = project.getName();
    _builder.append(_name, "");
    _builder.append(".resources;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import javax.annotation.security.PermitAll;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.Consumes;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.POST;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.PUT;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.DELETE;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.GET;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.Path;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.Produces;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.core.MediaType;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.core.Response;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.DatabaseService;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.IDataContainer;");
    _builder.newLine();
    _builder.append("import com.codahale.metrics.annotation.Timed;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.core.JsonProcessingException;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import ");
    String _name_1 = project.getName();
    _builder.append(_name_1, "");
    _builder.append(".actions.");
    String _actionName = this._actionExtension.actionName(it);
    _builder.append(_actionName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("@Path(\"/path\")");
    _builder.newLine();
    _builder.append("@Produces(MediaType.APPLICATION_JSON)");
    _builder.newLine();
    _builder.append("@Consumes(MediaType.APPLICATION_JSON)");
    _builder.newLine();
    _builder.append("public class ");
    String _resourceName = this._actionExtension.resourceName(it);
    _builder.append(_resourceName, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(CreateMandatorResource.class);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@");
    String _type = it.getType();
    _builder.append(_type, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("@Timed");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Path(\"/path\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@PermitAll // set permission");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Response ");
    String _type_1 = it.getType();
    String _lowerCase = _type_1.toLowerCase();
    _builder.append(_lowerCase, "\t");
    _builder.append("(/* params here */) throws JsonProcessingException {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("IDataContainer actionParam = null;  // init actionParam");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return new ");
    String _actionName_1 = this._actionExtension.actionName(it);
    _builder.append(_actionName_1, "\t\t");
    _builder.append("(actionParam, DatabaseService.getDatabaseHandle()).apply();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateView(final View it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = project.getName();
    _builder.append(_name, "");
    _builder.append(".views;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.function.BiConsumer;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.skife.jdbi.v2.Handle;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.IDataContainer;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _viewName = this._viewExtension.viewName(it);
    _builder.append(_viewName, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      EList<ViewFunction> _renderFunctions = it.getRenderFunctions();
      for(final ViewFunction renderFunction : _renderFunctions) {
        _builder.append("\t");
        _builder.append("public BiConsumer<IDataContainer, Handle> ");
        String _name_1 = renderFunction.getName();
        _builder.append(_name_1, "\t");
        _builder.append(" = (dataContainer, handle) -> {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("// update view");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("};");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*                    S.D.G.                    */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateAppRegistration(final Project it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = it.getName();
    _builder.append(_name, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import io.dropwizard.setup.Environment;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.AceController;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import ");
    String _name_1 = it.getName();
    _builder.append(_name_1, "");
    _builder.append(".views.*;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    String _name_2 = it.getName();
    _builder.append(_name_2, "");
    _builder.append(".resources.*;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class AppRegistration {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void registerResources(Environment environment) {");
    _builder.newLine();
    {
      EList<Action> _actions = it.getActions();
      for(final Action action : _actions) {
        _builder.append("\t\t");
        _builder.append("environment.jersey().register(new ");
        String _resourceName = this._actionExtension.resourceName(action);
        _builder.append(_resourceName, "\t\t");
        _builder.append("());");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void registerConsumers() {");
    _builder.newLine();
    {
      EList<View> _views = it.getViews();
      for(final View view : _views) {
        _builder.append("\t\t");
        String _viewName = this._viewExtension.viewName(view);
        _builder.append(_viewName, "\t\t");
        _builder.append(" ");
        String _viewNameAsVariable = this._viewExtension.viewNameAsVariable(view);
        _builder.append(_viewNameAsVariable, "\t\t");
        _builder.append(" = new ");
        String _viewName_1 = this._viewExtension.viewName(view);
        _builder.append(_viewName_1, "\t\t");
        _builder.append("();");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    {
      EList<Event> _events = it.getEvents();
      for(final Event event : _events) {
        {
          EList<ViewFunction> _listeners = event.getListeners();
          for(final ViewFunction renderFunction : _listeners) {
            _builder.append("\t\t");
            _builder.append("AceController.addConsumer(\"");
            String _eventName = this._eventExtension.eventName(event);
            _builder.append(_eventName, "\t\t");
            _builder.append("\", ");
            String _viewFunctionWithViewNameAsVariable = this._viewExtension.viewFunctionWithViewNameAsVariable(renderFunction);
            _builder.append(_viewFunctionWithViewNameAsVariable, "\t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*                    S.D.G.                    */");
    _builder.newLine();
    return _builder;
  }
}
