/**
 * generated by Xtext 2.10.0
 */
package com.anfelisa.generator;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.Command;
import com.anfelisa.ace.Data;
import com.anfelisa.ace.Event;
import com.anfelisa.ace.Model;
import com.anfelisa.ace.Project;
import com.anfelisa.ace.View;
import com.anfelisa.extensions.ActionExtension;
import com.anfelisa.extensions.CommandExtension;
import com.anfelisa.extensions.DataExtension;
import com.anfelisa.extensions.EventExtension;
import com.anfelisa.extensions.ModelExtension;
import com.anfelisa.extensions.ProjectExtension;
import com.anfelisa.extensions.ViewExtension;
import com.anfelisa.generator.ACEOutputConfigurationProvider;
import com.anfelisa.generator.ES6Template;
import com.anfelisa.generator.JavaTemplate;
import com.google.common.base.Objects;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class AceGenerator extends AbstractGenerator {
  @Inject
  private ES6Template es6Template;
  
  @Inject
  private JavaTemplate javaTemplate;
  
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
  
  @Inject
  @Extension
  private ProjectExtension _projectExtension;
  
  @Inject
  @Extension
  private ModelExtension _modelExtension;
  
  @Inject
  @Extension
  private DataExtension _dataExtension;
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    if ((((!Objects.equal(resource, null)) && (!Objects.equal(resource.getContents(), null))) && (resource.getContents().size() > 0))) {
      EList<EObject> _contents = resource.getContents();
      EObject _get = _contents.get(0);
      final Project project = ((Project) _get);
      String _target = project.getTarget();
      boolean _equals = Objects.equal(_target, "ES6");
      if (_equals) {
        EList<Action> _actions = project.getActions();
        for (final Action action : _actions) {
          {
            String _name = project.getName();
            String _plus = ("app/" + _name);
            String _plus_1 = (_plus + "/actions/");
            String _abstractActionName = this._actionExtension.abstractActionName(action);
            String _plus_2 = (_plus_1 + _abstractActionName);
            String _plus_3 = (_plus_2 + ".es6");
            CharSequence _generateAbstractActionFile = this.es6Template.generateAbstractActionFile(action);
            fsa.generateFile(_plus_3, 
              IFileSystemAccess.DEFAULT_OUTPUT, _generateAbstractActionFile);
            String _name_1 = project.getName();
            String _plus_4 = (_name_1 + "/actions/");
            String _actionName = this._actionExtension.actionName(action);
            String _plus_5 = (_plus_4 + _actionName);
            String _plus_6 = (_plus_5 + ".es6");
            CharSequence _generateInitialActionFile = this.es6Template.generateInitialActionFile(action);
            fsa.generateFile(_plus_6, 
              ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE, _generateInitialActionFile);
          }
        }
        EList<Command> _commands = project.getCommands();
        for (final Command command : _commands) {
          {
            String _name = project.getName();
            String _plus = ("app/" + _name);
            String _plus_1 = (_plus + "/commands/");
            String _abstractCommandName = this._commandExtension.abstractCommandName(command);
            String _plus_2 = (_plus_1 + _abstractCommandName);
            String _plus_3 = (_plus_2 + ".es6");
            CharSequence _generateAbstractCommandFile = this.es6Template.generateAbstractCommandFile(command);
            fsa.generateFile(_plus_3, 
              IFileSystemAccess.DEFAULT_OUTPUT, _generateAbstractCommandFile);
            String _name_1 = project.getName();
            String _plus_4 = (_name_1 + "/commands/");
            String _commandName = this._commandExtension.commandName(command);
            String _plus_5 = (_plus_4 + _commandName);
            String _plus_6 = (_plus_5 + ".es6");
            CharSequence _generateInitialCommandFile = this.es6Template.generateInitialCommandFile(command);
            fsa.generateFile(_plus_6, 
              ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE, _generateInitialCommandFile);
          }
        }
        String _name = project.getName();
        String _plus = ("/elr/" + _name);
        String _plus_1 = (_plus + "/EventListenerRegistration.es6");
        CharSequence _generateEventListenerRegistration = this.es6Template.generateEventListenerRegistration(project);
        fsa.generateFile(_plus_1, IFileSystemAccess.DEFAULT_OUTPUT, _generateEventListenerRegistration);
        EList<Event> _events = project.getEvents();
        for (final Event event : _events) {
          {
            String _name_1 = project.getName();
            String _plus_2 = ("app/" + _name_1);
            String _plus_3 = (_plus_2 + "/events/");
            String _abstractEventName = this._eventExtension.abstractEventName(event);
            String _plus_4 = (_plus_3 + _abstractEventName);
            String _plus_5 = (_plus_4 + ".es6");
            CharSequence _generateAbstractEventFile = this.es6Template.generateAbstractEventFile(event);
            fsa.generateFile(_plus_5, 
              IFileSystemAccess.DEFAULT_OUTPUT, _generateAbstractEventFile);
            String _name_2 = project.getName();
            String _plus_6 = (_name_2 + "/events/");
            String _eventName = this._eventExtension.eventName(event);
            String _plus_7 = (_plus_6 + _eventName);
            String _plus_8 = (_plus_7 + ".es6");
            CharSequence _generateInitialEventFile = this.es6Template.generateInitialEventFile(event);
            fsa.generateFile(_plus_8, 
              ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE, _generateInitialEventFile);
          }
        }
        EList<View> _views = project.getViews();
        for (final View view : _views) {
          String _name_1 = project.getName();
          String _plus_2 = (_name_1 + "/");
          String _viewName = this._viewExtension.viewName(view);
          String _plus_3 = (_plus_2 + _viewName);
          String _plus_4 = (_plus_3 + ".es6");
          CharSequence _generateView = this.es6Template.generateView(view);
          fsa.generateFile(_plus_4, 
            ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE, _generateView);
        }
        String _name_2 = project.getName();
        String _plus_5 = (_name_2 + "/htmlDev.snippet");
        CharSequence _generateHtmlDevSnippet = this.es6Template.generateHtmlDevSnippet(project);
        fsa.generateFile(_plus_5, IFileSystemAccess.DEFAULT_OUTPUT, _generateHtmlDevSnippet);
        CharSequence _generateAceHtmlDevSnippet = this.es6Template.generateAceHtmlDevSnippet(project);
        fsa.generateFile("ace/htmlDev.snippet", IFileSystemAccess.DEFAULT_OUTPUT, _generateAceHtmlDevSnippet);
        CharSequence _generateAction = this.es6Template.generateAction();
        fsa.generateFile("ace/Action.es6", IFileSystemAccess.DEFAULT_OUTPUT, _generateAction);
        CharSequence _generateCommand = this.es6Template.generateCommand();
        fsa.generateFile("ace/Command.es6", IFileSystemAccess.DEFAULT_OUTPUT, _generateCommand);
        CharSequence _generateEvent = this.es6Template.generateEvent();
        fsa.generateFile("ace/Event.es6", IFileSystemAccess.DEFAULT_OUTPUT, _generateEvent);
        CharSequence _generateACEController = this.es6Template.generateACEController();
        fsa.generateFile("ace/ACEController.es6", IFileSystemAccess.DEFAULT_OUTPUT, _generateACEController);
        CharSequence _generateTriggerAction = this.es6Template.generateTriggerAction();
        fsa.generateFile("ace/TriggerAction.es6", IFileSystemAccess.DEFAULT_OUTPUT, _generateTriggerAction);
        CharSequence _generateUUID = this.es6Template.generateUUID();
        fsa.generateFile("lib/UUID.js", IFileSystemAccess.DEFAULT_OUTPUT, _generateUUID);
      } else {
        String _target_1 = project.getTarget();
        boolean _equals_1 = Objects.equal(_target_1, "JAVA");
        if (_equals_1) {
          EList<Model> _models = project.getModels();
          for (final Model model : _models) {
            {
              String _packageFolder = this._projectExtension.packageFolder(project);
              String _plus_6 = (_packageFolder + "/models/");
              String _modelName = this._modelExtension.modelName(model);
              String _plus_7 = (_plus_6 + _modelName);
              String _plus_8 = (_plus_7 + ".java");
              CharSequence _generateModel = this.javaTemplate.generateModel(model, project);
              fsa.generateFile(_plus_8, 
                ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, _generateModel);
              String _packageFolder_1 = this._projectExtension.packageFolder(project);
              String _plus_9 = (_packageFolder_1 + "/models/");
              String _modelClassName = this._modelExtension.modelClassName(model);
              String _plus_10 = (_plus_9 + _modelClassName);
              String _plus_11 = (_plus_10 + ".java");
              CharSequence _generateModelClass = this.javaTemplate.generateModelClass(model, project);
              fsa.generateFile(_plus_11, 
                ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, _generateModelClass);
              String _packageFolder_2 = this._projectExtension.packageFolder(project);
              String _plus_12 = (_packageFolder_2 + "/");
              String _name_3 = model.getName();
              String _plus_13 = (_plus_12 + _name_3);
              String _plus_14 = (_plus_13 + ".html");
              CharSequence _generateModelResource = this.javaTemplate.generateModelResource(model);
              fsa.generateFile(_plus_14, 
                ACEOutputConfigurationProvider.DEFAULT_RESOURCE_OUTPUT, _generateModelResource);
              boolean _isPersistent = model.isPersistent();
              if (_isPersistent) {
                String _packageFolder_3 = this._projectExtension.packageFolder(project);
                String _plus_15 = (_packageFolder_3 + "/models/");
                String _modelDao = this._modelExtension.modelDao(model);
                String _plus_16 = (_plus_15 + _modelDao);
                String _plus_17 = (_plus_16 + ".java");
                CharSequence _generateDao = this.javaTemplate.generateDao(model, project);
                fsa.generateFile(_plus_17, 
                  ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, _generateDao);
                String _packageFolder_4 = this._projectExtension.packageFolder(project);
                String _plus_18 = (_packageFolder_4 + "/models/");
                String _modelMapper = this._modelExtension.modelMapper(model);
                String _plus_19 = (_plus_18 + _modelMapper);
                String _plus_20 = (_plus_19 + ".java");
                CharSequence _generateMapper = this.javaTemplate.generateMapper(model, project);
                fsa.generateFile(_plus_20, 
                  ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, _generateMapper);
                String _packageFolder_5 = this._projectExtension.packageFolder(project);
                String _plus_21 = (_packageFolder_5 + "/");
                String _name_4 = model.getName();
                String _plus_22 = (_plus_21 + _name_4);
                String _plus_23 = (_plus_22 + "_creation.xml");
                CharSequence _generateMigration = this.javaTemplate.generateMigration(model, project);
                fsa.generateFile(_plus_23, 
                  ACEOutputConfigurationProvider.DEFAULT_RESOURCE_OUTPUT, _generateMigration);
              }
            }
          }
          EList<Data> _data = project.getData();
          for (final Data data : _data) {
            {
              String _packageFolder = this._projectExtension.packageFolder(project);
              String _plus_6 = (_packageFolder + "/data/");
              String _dataInterfaceName = this._dataExtension.dataInterfaceName(data);
              String _plus_7 = (_plus_6 + _dataInterfaceName);
              String _plus_8 = (_plus_7 + ".java");
              CharSequence _generateDataInterface = this.javaTemplate.generateDataInterface(data, project);
              fsa.generateFile(_plus_8, 
                ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, _generateDataInterface);
              String _packageFolder_1 = this._projectExtension.packageFolder(project);
              String _plus_9 = (_packageFolder_1 + "/data/");
              String _dataName = this._dataExtension.dataName(data);
              String _plus_10 = (_plus_9 + _dataName);
              String _plus_11 = (_plus_10 + ".java");
              CharSequence _generateData = this.javaTemplate.generateData(data, project);
              fsa.generateFile(_plus_11, 
                ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, _generateData);
            }
          }
          EList<Action> _actions_1 = project.getActions();
          for (final Action action_1 : _actions_1) {
            {
              String _packageFolder = this._projectExtension.packageFolder(project);
              String _plus_6 = (_packageFolder + "/actions/");
              String _abstractActionName = this._actionExtension.abstractActionName(action_1);
              String _plus_7 = (_plus_6 + _abstractActionName);
              String _plus_8 = (_plus_7 + ".java");
              CharSequence _generateAbstractActionFile = this.javaTemplate.generateAbstractActionFile(action_1, project);
              fsa.generateFile(_plus_8, 
                ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, _generateAbstractActionFile);
              String _packageFolder_1 = this._projectExtension.packageFolder(project);
              String _plus_9 = (_packageFolder_1 + "/actions/");
              String _actionName = this._actionExtension.actionName(action_1);
              String _plus_10 = (_plus_9 + _actionName);
              String _plus_11 = (_plus_10 + ".java");
              CharSequence _generateInitialActionFile = this.javaTemplate.generateInitialActionFile(action_1, project);
              fsa.generateFile(_plus_11, 
                ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, _generateInitialActionFile);
            }
          }
          EList<Command> _commands_1 = project.getCommands();
          for (final Command command_1 : _commands_1) {
            {
              String _packageFolder = this._projectExtension.packageFolder(project);
              String _plus_6 = (_packageFolder + "/commands/");
              String _abstractCommandName = this._commandExtension.abstractCommandName(command_1);
              String _plus_7 = (_plus_6 + _abstractCommandName);
              String _plus_8 = (_plus_7 + ".java");
              CharSequence _generateAbstractCommandFile = this.javaTemplate.generateAbstractCommandFile(command_1, project);
              fsa.generateFile(_plus_8, 
                ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, _generateAbstractCommandFile);
              String _packageFolder_1 = this._projectExtension.packageFolder(project);
              String _plus_9 = (_packageFolder_1 + "/commands/");
              String _commandName = this._commandExtension.commandName(command_1);
              String _plus_10 = (_plus_9 + _commandName);
              String _plus_11 = (_plus_10 + ".java");
              CharSequence _generateInitialCommandFile = this.javaTemplate.generateInitialCommandFile(command_1, project);
              fsa.generateFile(_plus_11, 
                ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, _generateInitialCommandFile);
            }
          }
          EList<Event> _events_1 = project.getEvents();
          for (final Event event_1 : _events_1) {
            {
              String _packageFolder = this._projectExtension.packageFolder(project);
              String _plus_6 = (_packageFolder + "/events/");
              String _abstractEventName = this._eventExtension.abstractEventName(event_1);
              String _plus_7 = (_plus_6 + _abstractEventName);
              String _plus_8 = (_plus_7 + ".java");
              CharSequence _generateAbstractEventFile = this.javaTemplate.generateAbstractEventFile(event_1, project);
              fsa.generateFile(_plus_8, 
                ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, _generateAbstractEventFile);
              String _packageFolder_1 = this._projectExtension.packageFolder(project);
              String _plus_9 = (_packageFolder_1 + "/events/");
              String _eventName = this._eventExtension.eventName(event_1);
              String _plus_10 = (_plus_9 + _eventName);
              String _plus_11 = (_plus_10 + ".java");
              CharSequence _generateInitialEventFile = this.javaTemplate.generateInitialEventFile(event_1, project);
              fsa.generateFile(_plus_11, 
                ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, _generateInitialEventFile);
            }
          }
          EList<View> _views_1 = project.getViews();
          for (final View view_1 : _views_1) {
            String _packageFolder = this._projectExtension.packageFolder(project);
            String _plus_6 = (_packageFolder + "/views/");
            String _viewName_1 = this._viewExtension.viewName(view_1);
            String _plus_7 = (_plus_6 + _viewName_1);
            String _plus_8 = (_plus_7 + ".java");
            CharSequence _generateView_1 = this.javaTemplate.generateView(view_1, project);
            fsa.generateFile(_plus_8, 
              ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, _generateView_1);
          }
          String _packageFolder_1 = this._projectExtension.packageFolder(project);
          String _plus_9 = (_packageFolder_1 + "/AppRegistration.java");
          CharSequence _generateAppRegistration = this.javaTemplate.generateAppRegistration(project);
          fsa.generateFile(_plus_9, 
            ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, _generateAppRegistration);
        }
      }
    }
  }
}
