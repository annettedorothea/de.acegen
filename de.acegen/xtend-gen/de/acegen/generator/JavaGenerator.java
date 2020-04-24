/**
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 * 
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */
package de.acegen.generator;

import de.acegen.aceGen.AuthUser;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.HttpServerAceWrite;
import de.acegen.aceGen.HttpServerOutcome;
import de.acegen.aceGen.HttpServerView;
import de.acegen.aceGen.Model;
import de.acegen.aceGen.Scenario;
import de.acegen.extensions.java.AceExtension;
import de.acegen.extensions.java.JavaExtension;
import de.acegen.extensions.java.ModelExtension;
import de.acegen.extensions.java.ViewExtension;
import de.acegen.generator.ACEOutputConfigurationProvider;
import de.acegen.templates.java.AceTemplate;
import de.acegen.templates.java.ActionTemplate;
import de.acegen.templates.java.CommandTemplate;
import de.acegen.templates.java.EventTemplate;
import de.acegen.templates.java.ModelTemplate;
import de.acegen.templates.java.ScenarioTemplate;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class JavaGenerator {
  @Inject
  private ActionTemplate actionTemplate;
  
  @Inject
  private CommandTemplate commandTemplate;
  
  @Inject
  private EventTemplate eventTemplate;
  
  @Inject
  private AceTemplate aceTemplate;
  
  @Inject
  private ModelTemplate modelTemplate;
  
  @Inject
  private ScenarioTemplate scenarioTemplate;
  
  @Inject
  @Extension
  private ViewExtension _viewExtension;
  
  @Inject
  @Extension
  private JavaExtension _javaExtension;
  
  @Inject
  @Extension
  private ModelExtension _modelExtension;
  
  @Inject
  @Extension
  private AceExtension _aceExtension;
  
  public void doGenerate(final HttpServer java, final IFileSystemAccess2 fsa) {
    AuthUser authUser = java.getAuthUser();
    if ((authUser == null)) {
      authUser = java.getAuthUserRef();
    }
    EList<Model> _models = java.getModels();
    for (final Model model : _models) {
      {
        String _packageFolder = this._javaExtension.packageFolder(java);
        String _plus = (_packageFolder + "/models/");
        String _modelName = this._modelExtension.modelName(model);
        String _plus_1 = (_plus + _modelName);
        String _plus_2 = (_plus_1 + ".java");
        fsa.generateFile(_plus_2, 
          ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.modelTemplate.generateModel(model, java));
        String _packageFolder_1 = this._javaExtension.packageFolder(java);
        String _plus_3 = (_packageFolder_1 + "/models/");
        String _modelClassName = this._modelExtension.modelClassName(model);
        String _plus_4 = (_plus_3 + _modelClassName);
        String _plus_5 = (_plus_4 + ".java");
        fsa.generateFile(_plus_5, 
          ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.modelTemplate.generateModelClass(model, java));
        String _packageFolder_2 = this._javaExtension.packageFolder(java);
        String _plus_6 = (_packageFolder_2 + "/models/");
        String _modelMapper = this._modelExtension.modelMapper(model);
        String _plus_7 = (_plus_6 + _modelMapper);
        String _plus_8 = (_plus_7 + ".java");
        fsa.generateFile(_plus_8, 
          ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.modelTemplate.generateMapper(model, java));
        boolean _isPersistent = model.isPersistent();
        if (_isPersistent) {
          String _packageFolder_3 = this._javaExtension.packageFolder(java);
          String _plus_9 = (_packageFolder_3 + "/models/");
          String _abstractModelDao = this._modelExtension.abstractModelDao(model);
          String _plus_10 = (_plus_9 + _abstractModelDao);
          String _plus_11 = (_plus_10 + ".java");
          fsa.generateFile(_plus_11, 
            ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.modelTemplate.generateAbstractDao(model, java));
          String _packageFolder_4 = this._javaExtension.packageFolder(java);
          String _plus_12 = (_packageFolder_4 + "/models/");
          String _modelDao = this._modelExtension.modelDao(model);
          String _plus_13 = (_plus_12 + _modelDao);
          String _plus_14 = (_plus_13 + ".java");
          fsa.generateFile(_plus_14, 
            ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, this.modelTemplate.generateDao(model, java));
          String _packageFolder_5 = this._javaExtension.packageFolder(java);
          String _plus_15 = (_packageFolder_5 + "/");
          String _name = model.getName();
          String _plus_16 = (_plus_15 + _name);
          String _plus_17 = (_plus_16 + "_creation.xml");
          fsa.generateFile(_plus_17, 
            ACEOutputConfigurationProvider.DEFAULT_RESOURCE_OUTPUT, 
            this.modelTemplate.generateMigration(model, java));
        }
        String _packageFolder_6 = this._javaExtension.packageFolder(java);
        String _plus_18 = (_packageFolder_6 + "/data/");
        String _dataInterfaceName = this._modelExtension.dataInterfaceName(model);
        String _plus_19 = (_plus_18 + _dataInterfaceName);
        String _plus_20 = (_plus_19 + ".java");
        fsa.generateFile(_plus_20, 
          ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.modelTemplate.generateDataInterface(model, java));
        String _packageFolder_7 = this._javaExtension.packageFolder(java);
        String _plus_21 = (_packageFolder_7 + "/data/");
        String _abstractDataName = this._modelExtension.abstractDataName(model);
        String _plus_22 = (_plus_21 + _abstractDataName);
        String _plus_23 = (_plus_22 + ".java");
        fsa.generateFile(_plus_23, 
          ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.modelTemplate.generateAbstractData(model, java));
        String _packageFolder_8 = this._javaExtension.packageFolder(java);
        String _plus_24 = (_packageFolder_8 + "/data/");
        String _dataName = this._modelExtension.dataName(model);
        String _plus_25 = (_plus_24 + _dataName);
        String _plus_26 = (_plus_25 + ".java");
        fsa.generateFile(_plus_26, 
          ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, this.modelTemplate.generateData(model, java));
      }
    }
    EList<HttpServerAce> _aceOperations = java.getAceOperations();
    for (final HttpServerAce ace : _aceOperations) {
      {
        String _packageFolder = this._javaExtension.packageFolder(java);
        String _plus = (_packageFolder + "/actions/");
        String _abstractActionName = this._aceExtension.abstractActionName(ace);
        String _plus_1 = (_plus + _abstractActionName);
        String _plus_2 = (_plus_1 + ".java");
        fsa.generateFile(_plus_2, 
          ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
          this.actionTemplate.generateAbstractActionFile(ace, java, authUser));
        String _packageFolder_1 = this._javaExtension.packageFolder(java);
        String _plus_3 = (_packageFolder_1 + "/actions/");
        String _actionName = this._aceExtension.actionName(ace);
        String _plus_4 = (_plus_3 + _actionName);
        String _plus_5 = (_plus_4 + ".java");
        fsa.generateFile(_plus_5, 
          ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, 
          this.actionTemplate.generateInitialActionFile(ace, java));
        boolean _equals = "GET".equals(ace.getType());
        boolean _not = (!_equals);
        if (_not) {
          String _packageFolder_2 = this._javaExtension.packageFolder(java);
          String _plus_6 = (_packageFolder_2 + "/commands/");
          String _abstractCommandName = this._aceExtension.abstractCommandName(ace);
          String _plus_7 = (_plus_6 + _abstractCommandName);
          String _plus_8 = (_plus_7 + ".java");
          fsa.generateFile(_plus_8, 
            ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
            this.commandTemplate.generateAbstractCommandFile(((HttpServerAceWrite) ace), java));
          String _packageFolder_3 = this._javaExtension.packageFolder(java);
          String _plus_9 = (_packageFolder_3 + "/commands/");
          String _commandName = this._aceExtension.commandName(ace);
          String _plus_10 = (_plus_9 + _commandName);
          String _plus_11 = (_plus_10 + ".java");
          fsa.generateFile(_plus_11, 
            ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, 
            this.commandTemplate.generateInitialCommandFile(((HttpServerAceWrite) ace), java));
          final HttpServerAceWrite aceWrite = ((HttpServerAceWrite) ace);
          EList<HttpServerOutcome> _outcomes = aceWrite.getOutcomes();
          for (final HttpServerOutcome outcome : _outcomes) {
            String _packageFolder_4 = this._javaExtension.packageFolder(java);
            String _plus_12 = (_packageFolder_4 + "/events/");
            String _eventName = this._aceExtension.eventName(ace, outcome);
            String _plus_13 = (_plus_12 + _eventName);
            String _plus_14 = (_plus_13 + ".java");
            fsa.generateFile(_plus_14, 
              ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
              this.eventTemplate.generateAbstractEventFile(ace, outcome, java));
          }
        }
        int _size = ace.getResponse().size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          String _packageFolder_5 = this._javaExtension.packageFolder(java);
          String _plus_15 = (_packageFolder_5 + "/data/");
          String _responseDataName = this._aceExtension.responseDataName(ace);
          String _plus_16 = (_plus_15 + _responseDataName);
          String _plus_17 = (_plus_16 + ".java");
          fsa.generateFile(_plus_17, 
            ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
            this.modelTemplate.generateResponseData(ace, java));
          String _packageFolder_6 = this._javaExtension.packageFolder(java);
          String _plus_18 = (_packageFolder_6 + "/data/");
          String _responseDataInterfaceName = this._aceExtension.responseDataInterfaceName(ace);
          String _plus_19 = (_plus_18 + _responseDataInterfaceName);
          String _plus_20 = (_plus_19 + ".java");
          fsa.generateFile(_plus_20, 
            ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
            this.modelTemplate.generateReponseDataInterface(ace, java));
        }
      }
    }
    EList<HttpServerView> _views = java.getViews();
    for (final HttpServerView view : _views) {
      {
        String _packageFolder = this._javaExtension.packageFolder(java);
        String _plus = (_packageFolder + "/views/");
        String _viewName = this._viewExtension.viewName(view);
        String _plus_1 = (_plus + _viewName);
        String _plus_2 = (_plus_1 + ".java");
        fsa.generateFile(_plus_2, 
          ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, this.eventTemplate.generateView(view, java));
        String _packageFolder_1 = this._javaExtension.packageFolder(java);
        String _plus_3 = (_packageFolder_1 + "/views/");
        String _viewInterfaceName = this._viewExtension.viewInterfaceName(view);
        String _plus_4 = (_plus_3 + _viewInterfaceName);
        String _plus_5 = (_plus_4 + ".java");
        fsa.generateFile(_plus_5, 
          ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.eventTemplate.generateViewInterface(view, java));
      }
    }
    String _packageFolder = this._javaExtension.packageFolder(java);
    String _plus = (_packageFolder + "/ActionCalls.java");
    fsa.generateFile(_plus, 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT, this.actionTemplate.generateActionCalls(java));
    int _size = java.getAceOperations().size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      String _packageFolder_1 = this._javaExtension.packageFolder(java);
      String _plus_1 = (_packageFolder_1 + "/events/EventFactory.java");
      fsa.generateFile(_plus_1, 
        ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.eventTemplate.generateEventFactory(java));
    }
    int _size_1 = java.getAceOperations().size();
    boolean _greaterThan_1 = (_size_1 > 0);
    if (_greaterThan_1) {
      String _packageFolder_2 = this._javaExtension.packageFolder(java);
      String _plus_2 = (_packageFolder_2 + "/actions/AceDataFactory.java");
      fsa.generateFile(_plus_2, 
        ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.actionTemplate.generateAceDataFactory(java));
    }
    fsa.generateFile("de/acegen/EventFactory.java", 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, this.eventTemplate.generateEventFactory());
    String _packageFolder_3 = this._javaExtension.packageFolder(java);
    String _plus_3 = (_packageFolder_3 + "/AppRegistration.java");
    fsa.generateFile(_plus_3, 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.actionTemplate.generateAppRegistration(java));
    fsa.generateFile(("de/acegen" + "/App.java"), ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, 
      this.aceTemplate.generateApp());
    fsa.generateFile(("de/acegen" + "/AppRegistration.java"), ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, 
      this.aceTemplate.generateAppRegistration());
    fsa.generateFile(("de/acegen" + "/AppConfiguration.java"), 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.aceTemplate.generateAppConfiguration());
    fsa.generateFile(("de/acegen" + "/CustomAppConfiguration.java"), 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, this.aceTemplate.generateCustomAppConfiguration());
    fsa.generateFile(("de/acegen" + "/E2E.java"), ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.aceTemplate.generateE2E());
    fsa.generateFile(("de/acegen" + "/ServerConfiguration.java"), 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.aceTemplate.generateServerConfiguration());
    fsa.generateFile(("de/acegen" + "/StartE2ESessionResource.java"), 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.aceTemplate.generateStartE2ESessionResource());
    fsa.generateFile(("de/acegen" + "/StopE2ESessionResource.java"), 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.aceTemplate.generateStopE2ESessionResource());
    fsa.generateFile(("de/acegen" + "/AceOperation.java"), 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.aceTemplate.generateAceOperation());
    fsa.generateFile(("de/acegen" + "/PrepareE2EResource.java"), 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.aceTemplate.generatePrepareE2EResource());
    fsa.generateFile(("de/acegen" + "/GetServerTimelineResource.java"), 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.aceTemplate.generateGetServerTimelineResource());
    fsa.generateFile(("de/acegen" + "/ServerInfo.java"), ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.aceTemplate.generateServerInfo());
    fsa.generateFile(("de/acegen" + "/GetServerInfoResource.java"), 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.aceTemplate.generateGetServerInfoResource());
    fsa.generateFile(("de/acegen" + "/EventReplayCommand.java"), 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.aceTemplate.generateEventReplayCommand());
    fsa.generateFile(("de/acegen" + "/NotReplayableDataProvider.java"), 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.aceTemplate.generateNotReplayableDataProvider());
    fsa.generateFile(("de/acegen" + "/AceDao.java"), ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.aceTemplate.generateAceDao());
    fsa.generateFile(("de/acegen" + "/Action.java"), ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.actionTemplate.generateAction());
    fsa.generateFile(("de/acegen" + "/Command.java"), ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.commandTemplate.generateCommand());
    fsa.generateFile(("de/acegen" + "/DatabaseHandle.java"), 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.modelTemplate.generateDatabaseHandle());
    fsa.generateFile(("de/acegen" + "/Event.java"), ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.eventTemplate.generateEvent());
    fsa.generateFile(("de/acegen" + "/HttpMethod.java"), ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.actionTemplate.generateHttpMethod());
    fsa.generateFile(("de/acegen" + "/IAction.java"), ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.actionTemplate.generateIAction());
    fsa.generateFile(("de/acegen" + "/ICommand.java"), ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.commandTemplate.generateICommand());
    fsa.generateFile(("de/acegen" + "/IDataContainer.java"), 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.modelTemplate.generateIDataContainer());
    fsa.generateFile(("de/acegen" + "/IEvent.java"), ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.eventTemplate.generateIEvent());
    fsa.generateFile(("de/acegen" + "/ITimelineItem.java"), ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.aceTemplate.generateITimelineItem());
    fsa.generateFile(("de/acegen" + "/JodaObjectMapper.java"), 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.aceTemplate.generateJodaObjectMapper());
    fsa.generateFile(("de/acegen" + "/TimelineItem.java"), ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.aceTemplate.generateTimelineItem());
    fsa.generateFile(("de/acegen" + "/TimelineItemMapper.java"), 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.aceTemplate.generateTimelineItemMapper());
    fsa.generateFile(("de/acegen" + "/AbstractData.java"), ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.modelTemplate.generateAbstractData());
    fsa.generateFile(("de/acegen" + "/AbstractDaoProvider.java"), 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.aceTemplate.generateAbstractDaoProvider());
    fsa.generateFile(("de/acegen" + "/DaoProvider.java"), 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, this.aceTemplate.generateDaoProvider());
    fsa.generateFile(("de/acegen" + "/IDaoProvider.java"), 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, this.aceTemplate.generateIDaoProvider());
    fsa.generateFile(("de/acegen" + "/ViewProvider.java"), 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, this.aceTemplate.generateViewProvider());
    fsa.generateFile(("de/acegen" + "/AbstractViewProvider.java"), 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.aceTemplate.generateAbstractViewProvider());
    fsa.generateFile(("de/acegen" + "/EventConsumer.java"), 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.eventTemplate.generateEventconsumer());
    fsa.generateFile(("de/acegen" + "/DateTimeToStringConverter.java"), 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.aceTemplate.generateDateTimeToStringConverter());
    fsa.generateFile(("de/acegen" + "/StringToDateTimeConverter.java"), 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.aceTemplate.generateStringToDateTimeConverter());
    fsa.generateFile(("de/acegen" + "/PersistenceConnection.java"), 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.aceTemplate.generatePersistenceConnection());
    fsa.generateFile(("de/acegen" + "/PersistenceHandle.java"), 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.aceTemplate.generatePersistenceHandle());
    fsa.generateFile("ace_creation.xml", ACEOutputConfigurationProvider.DEFAULT_RESOURCE_OUTPUT, 
      this.aceTemplate.generateAceMigration());
    if ((authUser != null)) {
      String _firstUpper = StringExtensions.toFirstUpper(authUser.getName());
      String _plus_4 = ("de/acegen/auth/" + _firstUpper);
      String _plus_5 = (_plus_4 + ".java");
      fsa.generateFile(_plus_5, ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
        this.aceTemplate.generateAuthUser(authUser));
    }
    fsa.generateFile("de/acegen/AbstractBaseScenario.java", 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT, this.scenarioTemplate.generateAbstractBaseScenario());
    fsa.generateFile("de/acegen/BaseScenario.java", 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT_ONCE, this.scenarioTemplate.generateBaseScenario());
    EList<Scenario> _scenarios = java.getScenarios();
    for (final Scenario scenario : _scenarios) {
      {
        String _packageFolder_4 = this._javaExtension.packageFolder(java);
        String _plus_6 = (_packageFolder_4 + "/scenarios/Abstract");
        String _name = scenario.getName();
        String _plus_7 = (_plus_6 + _name);
        String _plus_8 = (_plus_7 + "Scenario.java");
        fsa.generateFile(_plus_8, 
          ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT, this.scenarioTemplate.generateAbstractScenario(scenario, java));
        String _packageFolder_5 = this._javaExtension.packageFolder(java);
        String _plus_9 = (_packageFolder_5 + "/scenarios/");
        String _name_1 = scenario.getName();
        String _plus_10 = (_plus_9 + _name_1);
        String _plus_11 = (_plus_10 + "Scenario.java");
        fsa.generateFile(_plus_11, 
          ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT_ONCE, this.scenarioTemplate.generateScenario(scenario, java));
      }
    }
  }
}
