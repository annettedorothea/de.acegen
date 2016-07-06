package com.anfelisa.generator;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.Command;
import com.anfelisa.ace.Event;
import com.anfelisa.ace.EventOnOutcome;
import com.anfelisa.ace.Project;
import com.anfelisa.ace.RenderFunction;
import com.anfelisa.ace.View;
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
public class Template {
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
  
  public CharSequence generateAbstractActionFile(final Action it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\'use strict\';");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class ");
    String _abstractActionName = this._actionExtension.abstractActionName(it);
    _builder.append(_abstractActionName, "");
    _builder.append(" extends Action {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("constructor(actionParam) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("super(actionParam, \'");
    String _actionName = this._actionExtension.actionName(it);
    _builder.append(_actionName, "        ");
    _builder.append("\');");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      Command _command = it.getCommand();
      boolean _notEquals = (!Objects.equal(_command, null));
      if (_notEquals) {
        _builder.append("\t");
        _builder.append("getCommand() {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("    ");
        _builder.append("return new ");
        Command _command_1 = it.getCommand();
        String _commandName = this._commandExtension.commandName(_command_1);
        _builder.append(_commandName, "\t    ");
        _builder.append("(this.actionData);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("    ");
    _builder.append("replay() {");
    _builder.newLine();
    _builder.append("    ");
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
  
  public CharSequence generateInitialActionFile(final Action it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\'use strict\';");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class ");
    String _actionName = this._actionExtension.actionName(it);
    _builder.append(_actionName, "");
    _builder.append(" extends ");
    String _abstractActionName = this._actionExtension.abstractActionName(it);
    _builder.append(_abstractActionName, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("initActionDataFromView() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return new Promise((resolve) => {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("resolve();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("replay() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateAbstractCommandFile(final Command it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\'use strict\';");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class ");
    String _abstractCommandName = this._commandExtension.abstractCommandName(it);
    _builder.append(_abstractCommandName, "");
    _builder.append(" extends Command {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("constructor(commandParam) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("super(commandParam, \"");
    String _commandName = this._commandExtension.commandName(it);
    _builder.append(_commandName, "        ");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    {
      EList<EventOnOutcome> _eventsOnOutcome = it.getEventsOnOutcome();
      for(final EventOnOutcome eventOnOutcome : _eventsOnOutcome) {
        _builder.append("        ");
        _builder.append("this.");
        String _outcome = eventOnOutcome.getOutcome();
        _builder.append(_outcome, "        ");
        _builder.append(" = \"");
        String _outcome_1 = eventOnOutcome.getOutcome();
        _builder.append(_outcome_1, "        ");
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("publishEvents() {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("let promises = [];");
    _builder.newLine();
    _builder.append("    \t");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("switch (this.commandData.outcome) {");
    _builder.newLine();
    {
      EList<EventOnOutcome> _eventsOnOutcome_1 = it.getEventsOnOutcome();
      for(final EventOnOutcome eventOnOutcome_1 : _eventsOnOutcome_1) {
        _builder.append("        ");
        _builder.append("case this.");
        String _outcome_2 = eventOnOutcome_1.getOutcome();
        _builder.append(_outcome_2, "        ");
        _builder.append(":");
        _builder.newLineIfNotEmpty();
        {
          EList<Event> _events = eventOnOutcome_1.getEvents();
          for(final Event event : _events) {
            _builder.append("        ");
            _builder.append("\t");
            _builder.append("promises.push(new ");
            String _eventName = this._eventExtension.eventName(event);
            _builder.append(_eventName, "        \t");
            _builder.append("(this.commandData).publish());");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          EList<Action> _actions = eventOnOutcome_1.getActions();
          for(final Action action : _actions) {
            _builder.append("        ");
            _builder.append("\t");
            _builder.append("promises.push(new TriggerAction(new ");
            String _actionName = this._actionExtension.actionName(action);
            _builder.append(_actionName, "        \t");
            _builder.append("(this.commandData)).publish());");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("        ");
        _builder.append("\t");
        _builder.append("break;");
        _builder.newLine();
      }
    }
    _builder.append("    \t");
    _builder.append("default:");
    _builder.newLine();
    _builder.append("    \t\t");
    _builder.append("throw \'unhandled outcome: \' + this.commandData.outcome;");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return Promise.all(promises);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateInitialCommandFile(final Command it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\'use strict\';");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class ");
    String _commandName = this._commandExtension.commandName(it);
    _builder.append(_commandName, "");
    _builder.append(" extends ");
    String _abstractCommandName = this._commandExtension.abstractCommandName(it);
    _builder.append(_abstractCommandName, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("execute() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return new Promise((resolve) => {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("resolve();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateEventFile(final Event it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\'use strict\';");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class ");
    String _eventName = this._eventExtension.eventName(it);
    _builder.append(_eventName, "");
    _builder.append(" extends Event {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("constructor(eventParam) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("super(eventParam, ");
    String _eventName_1 = this._eventExtension.eventName(it);
    _builder.append(_eventName_1, "        ");
    _builder.append(".getName());");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("static getName() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return \'");
    String _eventName_2 = this._eventExtension.eventName(it);
    _builder.append(_eventName_2, "        ");
    _builder.append("\';");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateEventListenerRegistration(final Project it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\'use strict\';");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class EventListenerRegistration {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static init() {");
    _builder.newLine();
    {
      EList<Event> _events = it.getEvents();
      for(final Event event : _events) {
        {
          EList<RenderFunction> _listeners = event.getListeners();
          for(final RenderFunction renderFunction : _listeners) {
            _builder.append("    \t");
            _builder.append("MainController.registerListener(");
            String _eventName = this._eventExtension.eventName(event);
            _builder.append(_eventName, "    \t");
            _builder.append(".getName(), ");
            String _renderFunctionWithViewName = this._viewExtension.renderFunctionWithViewName(renderFunction);
            _builder.append(_renderFunctionWithViewName, "    \t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
          }
        }
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
  
  public CharSequence generateView(final View it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\'use strict\';");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class ");
    String _viewName = this._viewExtension.viewName(it);
    _builder.append(_viewName, "");
    _builder.append(" extends View {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("constructor() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("super(\'");
    String _viewName_1 = this._viewExtension.viewName(it);
    _builder.append(_viewName_1, "        ");
    _builder.append("\');");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("reset() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return new Promise(() => {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("//MainController.addActionToQueue(new InitAppAction());");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    {
      EList<RenderFunction> _renderFunctions = it.getRenderFunctions();
      for(final RenderFunction renderFunction : _renderFunctions) {
        _builder.append("    ");
        _builder.append("static ");
        String _name = renderFunction.getName();
        _builder.append(_name, "    ");
        _builder.append("(data) {");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("};");
        _builder.newLine();
        _builder.append("    ");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*                    S.D.G.                    */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateHtmlDevSnippet(final Project it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Action> _actions = it.getActions();
      for(final Action action : _actions) {
        _builder.append("<script type=\"text/javascript\" src=\"es6/gen/");
        String _name = it.getName();
        _builder.append(_name, "");
        _builder.append("/actions/");
        String _abstractActionName = this._actionExtension.abstractActionName(action);
        _builder.append(_abstractActionName, "");
        _builder.append(".es6\"></script>");
        _builder.newLineIfNotEmpty();
        _builder.append("<script type=\"text/javascript\" src=\"es6/src/");
        String _name_1 = it.getName();
        _builder.append(_name_1, "");
        _builder.append("/actions/");
        String _actionName = this._actionExtension.actionName(action);
        _builder.append(_actionName, "");
        _builder.append(".es6\"></script>");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Command> _commands = it.getCommands();
      for(final Command command : _commands) {
        _builder.append("<script type=\"text/javascript\" src=\"es6/gen/");
        String _name_2 = it.getName();
        _builder.append(_name_2, "");
        _builder.append("/commands/");
        String _abstractCommandName = this._commandExtension.abstractCommandName(command);
        _builder.append(_abstractCommandName, "");
        _builder.append(".es6\"></script>");
        _builder.newLineIfNotEmpty();
        _builder.append("<script type=\"text/javascript\" src=\"es6/src/");
        String _name_3 = it.getName();
        _builder.append(_name_3, "");
        _builder.append("/commands/");
        String _commandName = this._commandExtension.commandName(command);
        _builder.append(_commandName, "");
        _builder.append(".es6\"></script>");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Event> _events = it.getEvents();
      for(final Event event : _events) {
        _builder.append("<script type=\"text/javascript\" src=\"es6/gen/");
        String _name_4 = it.getName();
        _builder.append(_name_4, "");
        _builder.append("/events/");
        String _eventName = this._eventExtension.eventName(event);
        _builder.append(_eventName, "");
        _builder.append(".es6\"></script>");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("<script type=\"text/javascript\" src=\"es6/gen/");
    String _name_5 = it.getName();
    _builder.append(_name_5, "");
    _builder.append("/EventListenerRegistration.es6\"></script>");
    _builder.newLineIfNotEmpty();
    {
      EList<View> _views = it.getViews();
      for(final View view : _views) {
        _builder.append("<script type=\"text/javascript\" src=\"es6/src/");
        String _name_6 = it.getName();
        _builder.append(_name_6, "");
        _builder.append("/");
        String _viewName = this._viewExtension.viewName(view);
        _builder.append(_viewName, "");
        _builder.append(".es6\"></script>");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
}
