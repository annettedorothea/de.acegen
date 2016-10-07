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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class PHPTemplate {
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
    _builder.append("<?php");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class ");
    String _abstractActionName = this._actionExtension.abstractActionName(it);
    _builder.append(_abstractActionName, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public $actionName;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public $actionParam;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public $actionData;");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("function __construct($actionParam) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("$this->actionParam = $actionParam;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("$this->actionName = \"");
    String _actionName = this._actionExtension.actionName(it);
    _builder.append(_actionName, "        ");
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("$this->actionData = array();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("function getCommand() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return new ");
    Command _command = it.getCommand();
    String _commandName = this._commandExtension.commandName(_command);
    _builder.append(_commandName, "        ");
    _builder.append("($this->actionData);");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("function apply() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("$actionId = getIdForAction($this->actionParam[\"uuid\"]);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (!$actionId) {");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("$this->initActionDataFromView();");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("saveAction($this, $this->actionParam[\"uuid\"]);");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("$command = $this->getCommand();");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("if ($command != null) {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("$command->execute();");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("$command->publishEvents();");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("if (databaseResetNeeded($actionId)) {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("resetDatabase();");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("replayToAction($actionId);");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("replayAction($actionId);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("function replayAsPrepare() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("$command = $this->getCommand();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if ($command != null) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("$command->execute();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("function replay() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("$command = $this->getCommand();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if ($command != null) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("$command->execute();");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("$command->publishEvents();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("function isRead() {");
    _builder.newLine();
    {
      String _type = it.getType();
      boolean _equals = Objects.equal(_type, "READ");
      if (_equals) {
        _builder.append("    \t");
        _builder.append("return true;");
        _builder.newLine();
      } else {
        _builder.append("    \t");
        _builder.append("return false;");
        _builder.newLine();
      }
    }
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
  
  public CharSequence generateAbstractCommandFile(final Command it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?php");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class ");
    String _abstractCommandName = this._commandExtension.abstractCommandName(it);
    _builder.append(_abstractCommandName, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      EList<EventOnOutcome> _eventsOnOutcome = it.getEventsOnOutcome();
      for(final EventOnOutcome eventOnOutcome : _eventsOnOutcome) {
        _builder.append("\t");
        _builder.append("const ");
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
    _builder.append("protected $commandName;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected $commandParam;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected $commandData;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("function __construct($commandParam) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$this->commandParam = $commandParam;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$this->commandName = \"");
    String _commandName = this._commandExtension.commandName(it);
    _builder.append(_commandName, "\t\t");
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("$this->commandData = array();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("function publishEvents() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("switch ($this->commandData[\"outcome\"]) {");
    _builder.newLine();
    {
      EList<EventOnOutcome> _eventsOnOutcome_1 = it.getEventsOnOutcome();
      for(final EventOnOutcome eventOnOutcome_1 : _eventsOnOutcome_1) {
        _builder.append("\t\t\t");
        _builder.append("case self::");
        String _outcome_2 = eventOnOutcome_1.getOutcome();
        _builder.append(_outcome_2, "\t\t\t");
        _builder.append(":");
        _builder.newLineIfNotEmpty();
        {
          EList<Event> _events = eventOnOutcome_1.getEvents();
          for(final Event event : _events) {
            {
              EList<ViewFunction> _listeners = event.getListeners();
              for(final ViewFunction listenerFunction : _listeners) {
                _builder.append("\t\t\t");
                _builder.append("\t");
                EObject _eContainer = listenerFunction.eContainer();
                String _viewName = this._viewExtension.viewName(((View) _eContainer));
                _builder.append(_viewName, "\t\t\t\t");
                _builder.append("::");
                String _name = listenerFunction.getName();
                _builder.append(_name, "\t\t\t\t");
                _builder.append("(new ");
                String _eventName = this._eventExtension.eventName(event);
                _builder.append(_eventName, "\t\t\t\t");
                _builder.append("($this->commandData));");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.append("\t\t\t");
        _builder.append("\t");
        _builder.append("break;");
        _builder.newLine();
      }
    }
    _builder.append("        ");
    _builder.append("}");
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
  
  public CharSequence generateEventFile(final Event it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?php");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class ");
    String _eventName = this._eventExtension.eventName(it);
    _builder.append(_eventName, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public $eventName;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public $eventData;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("function __construct($eventParam) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$this->eventData = $eventParam;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$this->eventName = \"");
    String _eventName_1 = this._eventExtension.eventName(it);
    _builder.append(_eventName_1, "\t\t");
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}\t\t");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateInitialActionFile(final Action it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?php");
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
    _builder.append("    ");
    _builder.append("function initActionDataFromView() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("$this->actionData = $this->actionParam;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateInitialCommandFile(final Command it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?php");
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
    _builder.newLine();
    _builder.append("    ");
    _builder.append("function execute() {");
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
  
  public CharSequence generateInitialFile(final Action it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?php");
    _builder.newLine();
    _builder.newLine();
    _builder.append("spl_autoload_register(\'abstractActionsLoader\');");
    _builder.newLine();
    _builder.append("spl_autoload_register(\'abstractCommandsLoader\');");
    _builder.newLine();
    _builder.append("spl_autoload_register(\'eventsLoader\');");
    _builder.newLine();
    _builder.append("spl_autoload_register(\'actionsLoader\');");
    _builder.newLine();
    _builder.append("spl_autoload_register(\'commandsLoader\');");
    _builder.newLine();
    _builder.append("spl_autoload_register(\'viewsLoader\');");
    _builder.newLine();
    _builder.newLine();
    _builder.append("include_once \'../../config/dbConfig.php\';");
    _builder.newLine();
    _builder.append("include_once \'../ace/Timeline.php\';");
    _builder.newLine();
    _builder.newLine();
    _builder.append("function abstractActionsLoader($className) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("$path = \'../gen/");
    String _name = project.getName();
    _builder.append(_name, "    ");
    _builder.append("/actions/\';");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("include $path.$className.\'.php\';");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("function abstractCommandsLoader($className) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("$path = \'../gen/");
    String _name_1 = project.getName();
    _builder.append(_name_1, "    ");
    _builder.append("/commands/\';");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("include $path.$className.\'.php\';");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("function eventsLoader($className) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("$path = \'../gen/");
    String _name_2 = project.getName();
    _builder.append(_name_2, "    ");
    _builder.append("/events/\';");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("include $path.$className.\'.php\';");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("function actionsLoader($className) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("$path = \'actions/\';");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("include $path.$className.\'.php\';");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("function commandsLoader($className) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("$path = \'commands/\';");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("include $path.$className.\'.php\';");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("function viewsLoader($className) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("$path = \'views/\';");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("include $path.$className.\'.php\';");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("$dbconn = pg_connect ( \"host=\" . getDbServer () . \" dbname=\" . getDbDatabase() . \" user=\" . getDbUser() . \" password=\" . getDbPassword() ) or die ( \'Error connecting to database: \' . pg_last_error () );");
    _builder.newLine();
    _builder.newLine();
    _builder.append("$action = new ");
    String _actionName = this._actionExtension.actionName(it);
    _builder.append(_actionName, "");
    _builder.append("(array_merge($_GET, $_POST));");
    _builder.newLineIfNotEmpty();
    _builder.append("$action->apply();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("pg_close($dbconn);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateView(final View it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?php");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class ");
    String _viewName = this._viewExtension.viewName(it);
    _builder.append(_viewName, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<ViewFunction> _renderFunctions = it.getRenderFunctions();
      for(final ViewFunction renderFunction : _renderFunctions) {
        _builder.append("    ");
        _builder.append("public static function ");
        String _name = renderFunction.getName();
        _builder.append(_name, "    ");
        _builder.append("($event) {");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("    ");
        _builder.newLine();
      }
    }
    _builder.append("}\t");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*                    S.D.G.                    */");
    _builder.newLine();
    return _builder;
  }
}
