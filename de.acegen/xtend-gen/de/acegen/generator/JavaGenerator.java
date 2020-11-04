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
package de.acegen.generator;

import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.HttpServerAceWrite;
import de.acegen.aceGen.HttpServerOutcome;
import de.acegen.aceGen.HttpServerView;
import de.acegen.extensions.java.AceExtension;
import de.acegen.extensions.java.JavaExtension;
import de.acegen.extensions.java.ModelExtension;
import de.acegen.extensions.java.ViewExtension;
import de.acegen.generator.ACEOutputConfigurationProvider;
import de.acegen.generator.java.AppRegistrationGenerator;
import de.acegen.generator.java.DaoGenerator;
import de.acegen.generator.java.DropwizardGenerator;
import de.acegen.generator.java.JDBI3Generator;
import de.acegen.generator.java.LiquibaseGenerator;
import de.acegen.templates.java.AceOperation;
import de.acegen.templates.java.Converter;
import de.acegen.templates.java.DatabaseHandle;
import de.acegen.templates.java.NonDeterministicDataProvider;
import de.acegen.templates.java.Persistence;
import de.acegen.templates.java.ServerInfo;
import de.acegen.templates.java.TimelineItem;
import de.acegen.templates.java.actions.AceDataFactory;
import de.acegen.templates.java.actions.Action;
import de.acegen.templates.java.auth.AuthUser;
import de.acegen.templates.java.commands.Command;
import de.acegen.templates.java.data.Data;
import de.acegen.templates.java.events.Event;
import de.acegen.templates.java.events.EventConsumer;
import de.acegen.templates.java.events.EventFactory;
import de.acegen.templates.java.models.Dao;
import de.acegen.templates.java.models.DaoProvider;
import de.acegen.templates.java.models.Model;
import de.acegen.templates.java.scenario.BaseScenario;
import de.acegen.templates.java.scenario.Scenario;
import de.acegen.templates.java.scenario.YamlConfiguration;
import de.acegen.templates.java.views.View;
import de.acegen.templates.java.views.ViewProvider;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class JavaGenerator {
  @Inject
  private JDBI3Generator jdbi3Generator;
  
  @Inject
  private DaoGenerator daoGenerator;
  
  @Inject
  private DropwizardGenerator dropwizardGenerator;
  
  @Inject
  private AppRegistrationGenerator appRegistrationGenerator;
  
  @Inject
  private LiquibaseGenerator liquibaseGenerator;
  
  @Inject
  private EventConsumer eventConsumer;
  
  @Inject
  private Model model;
  
  @Inject
  private Data data;
  
  @Inject
  private Dao dao;
  
  @Inject
  private DaoProvider daoProvider;
  
  @Inject
  private Action action;
  
  @Inject
  private AceDataFactory aceDataFactory;
  
  @Inject
  private Command command;
  
  @Inject
  private Event event;
  
  @Inject
  private EventFactory eventFactory;
  
  @Inject
  private View view;
  
  @Inject
  private ViewProvider viewProvider;
  
  @Inject
  private ServerInfo serverInfo;
  
  @Inject
  private AceOperation aceOperation;
  
  @Inject
  private Scenario scenario;
  
  @Inject
  private BaseScenario baseScenario;
  
  @Inject
  private YamlConfiguration yamlConfiguration;
  
  @Inject
  private NonDeterministicDataProvider notReplayableDataProvider;
  
  @Inject
  private DatabaseHandle databaseHandle;
  
  @Inject
  private TimelineItem timelineItem;
  
  @Inject
  private Converter converter;
  
  @Inject
  private Persistence persistence;
  
  @Inject
  private AuthUser authUser;
  
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
  
  public void doGenerate(final HttpServer httpServer, final IFileSystemAccess2 fsa) {
    boolean _isJDBI3 = this._aceExtension.isJDBI3(httpServer);
    if (_isJDBI3) {
      this.jdbi3Generator.doGenerate(httpServer, fsa);
    } else {
      this.daoGenerator.doGenerate(httpServer, fsa);
    }
    boolean _isDropwizard = this._aceExtension.isDropwizard(httpServer);
    if (_isDropwizard) {
      this.dropwizardGenerator.doGenerate(httpServer, fsa);
    } else {
      this.appRegistrationGenerator.doGenerate(httpServer, fsa);
    }
    boolean _isLiquibase = this._aceExtension.isLiquibase(httpServer);
    if (_isLiquibase) {
      this.liquibaseGenerator.doGenerate(httpServer, fsa);
    }
    EList<de.acegen.aceGen.Model> _models = httpServer.getModels();
    for (final de.acegen.aceGen.Model modelAce : _models) {
      {
        String _packageFolder = this._javaExtension.packageFolder(httpServer);
        String _plus = (_packageFolder + "/models/");
        String _modelName = this._modelExtension.modelName(modelAce);
        String _plus_1 = (_plus + _modelName);
        String _plus_2 = (_plus_1 + ".java");
        fsa.generateFile(_plus_2, 
          ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.model.generateInterface(modelAce, httpServer));
        String _packageFolder_1 = this._javaExtension.packageFolder(httpServer);
        String _plus_3 = (_packageFolder_1 + "/models/");
        String _modelClassName = this._modelExtension.modelClassName(modelAce);
        String _plus_4 = (_plus_3 + _modelClassName);
        String _plus_5 = (_plus_4 + ".java");
        fsa.generateFile(_plus_5, 
          ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.model.generateClass(modelAce, httpServer));
        String _packageFolder_2 = this._javaExtension.packageFolder(httpServer);
        String _plus_6 = (_packageFolder_2 + "/data/");
        String _dataInterfaceName = this._modelExtension.dataInterfaceName(modelAce);
        String _plus_7 = (_plus_6 + _dataInterfaceName);
        String _plus_8 = (_plus_7 + ".java");
        fsa.generateFile(_plus_8, 
          ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.data.generateDataInterface(modelAce, httpServer));
        String _packageFolder_3 = this._javaExtension.packageFolder(httpServer);
        String _plus_9 = (_packageFolder_3 + "/data/");
        String _abstractDataName = this._modelExtension.abstractDataName(modelAce);
        String _plus_10 = (_plus_9 + _abstractDataName);
        String _plus_11 = (_plus_10 + ".java");
        fsa.generateFile(_plus_11, 
          ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.data.generateAbstractData(modelAce, httpServer));
        String _packageFolder_4 = this._javaExtension.packageFolder(httpServer);
        String _plus_12 = (_packageFolder_4 + "/data/");
        String _dataName = this._modelExtension.dataName(modelAce);
        String _plus_13 = (_plus_12 + _dataName);
        String _plus_14 = (_plus_13 + ".java");
        fsa.generateFile(_plus_14, 
          ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, this.data.generateData(modelAce, httpServer));
      }
    }
    EList<HttpServerAce> _aceOperations = httpServer.getAceOperations();
    for (final HttpServerAce ace : _aceOperations) {
      {
        String _packageFolder = this._javaExtension.packageFolder(httpServer);
        String _plus = (_packageFolder + "/actions/");
        String _abstractActionName = this._aceExtension.abstractActionName(ace);
        String _plus_1 = (_plus + _abstractActionName);
        String _plus_2 = (_plus_1 + ".java");
        fsa.generateFile(_plus_2, 
          ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.action.generateAbstractActionFile(ace, httpServer));
        String _packageFolder_1 = this._javaExtension.packageFolder(httpServer);
        String _plus_3 = (_packageFolder_1 + "/actions/");
        String _actionName = this._aceExtension.actionName(ace);
        String _plus_4 = (_plus_3 + _actionName);
        String _plus_5 = (_plus_4 + ".java");
        fsa.generateFile(_plus_5, 
          ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, 
          this.action.generateInitialActionFile(ace, httpServer));
        boolean _equals = "GET".equals(ace.getType());
        boolean _not = (!_equals);
        if (_not) {
          String _packageFolder_2 = this._javaExtension.packageFolder(httpServer);
          String _plus_6 = (_packageFolder_2 + "/commands/");
          String _abstractCommandName = this._aceExtension.abstractCommandName(ace);
          String _plus_7 = (_plus_6 + _abstractCommandName);
          String _plus_8 = (_plus_7 + ".java");
          fsa.generateFile(_plus_8, 
            ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
            this.command.generateAbstractCommandFile(((HttpServerAceWrite) ace), httpServer));
          String _packageFolder_3 = this._javaExtension.packageFolder(httpServer);
          String _plus_9 = (_packageFolder_3 + "/commands/");
          String _commandName = this._aceExtension.commandName(ace);
          String _plus_10 = (_plus_9 + _commandName);
          String _plus_11 = (_plus_10 + ".java");
          fsa.generateFile(_plus_11, 
            ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, 
            this.command.generateInitialCommandFile(((HttpServerAceWrite) ace), httpServer));
          final HttpServerAceWrite aceWrite = ((HttpServerAceWrite) ace);
          EList<HttpServerOutcome> _outcomes = aceWrite.getOutcomes();
          for (final HttpServerOutcome outcome : _outcomes) {
            String _packageFolder_4 = this._javaExtension.packageFolder(httpServer);
            String _plus_12 = (_packageFolder_4 + "/events/");
            String _eventName = this._aceExtension.eventName(ace, outcome);
            String _plus_13 = (_plus_12 + _eventName);
            String _plus_14 = (_plus_13 + ".java");
            fsa.generateFile(_plus_14, 
              ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
              this.event.generateEventFile(ace, outcome, httpServer));
          }
        }
        String _packageFolder_5 = this._javaExtension.packageFolder(httpServer);
        String _plus_15 = (_packageFolder_5 + "/data/");
        String _responseDataName = this._aceExtension.responseDataName(ace);
        String _plus_16 = (_plus_15 + _responseDataName);
        String _plus_17 = (_plus_16 + ".java");
        fsa.generateFile(_plus_17, 
          ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.data.generateResponseData(ace, httpServer));
        String _packageFolder_6 = this._javaExtension.packageFolder(httpServer);
        String _plus_18 = (_packageFolder_6 + "/data/");
        String _responseDataInterfaceName = this._aceExtension.responseDataInterfaceName(ace);
        String _plus_19 = (_plus_18 + _responseDataInterfaceName);
        String _plus_20 = (_plus_19 + ".java");
        fsa.generateFile(_plus_20, 
          ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.data.generateReponseDataInterface(ace, httpServer));
        int _size = ace.getPayload().size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          String _packageFolder_7 = this._javaExtension.packageFolder(httpServer);
          String _plus_21 = (_packageFolder_7 + "/data/");
          String _payloadDataName = this._aceExtension.payloadDataName(ace);
          String _plus_22 = (_plus_21 + _payloadDataName);
          String _plus_23 = (_plus_22 + ".java");
          fsa.generateFile(_plus_23, 
            ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.data.generatePayloadData(ace, httpServer));
          String _packageFolder_8 = this._javaExtension.packageFolder(httpServer);
          String _plus_24 = (_packageFolder_8 + "/data/");
          String _payloadDataInterfaceName = this._aceExtension.payloadDataInterfaceName(ace);
          String _plus_25 = (_plus_24 + _payloadDataInterfaceName);
          String _plus_26 = (_plus_25 + ".java");
          fsa.generateFile(_plus_26, 
            ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.data.generatePayloadDataInterface(ace, httpServer));
        }
      }
    }
    EList<HttpServerView> _views = httpServer.getViews();
    for (final HttpServerView viewAce : _views) {
      {
        String _packageFolder = this._javaExtension.packageFolder(httpServer);
        String _plus = (_packageFolder + "/views/");
        String _viewName = this._viewExtension.viewName(viewAce);
        String _plus_1 = (_plus + _viewName);
        String _plus_2 = (_plus_1 + ".java");
        fsa.generateFile(_plus_2, 
          ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, this.view.generateView(viewAce, httpServer));
        String _packageFolder_1 = this._javaExtension.packageFolder(httpServer);
        String _plus_3 = (_packageFolder_1 + "/views/");
        String _viewInterfaceName = this._viewExtension.viewInterfaceName(viewAce);
        String _plus_4 = (_plus_3 + _viewInterfaceName);
        String _plus_5 = (_plus_4 + ".java");
        fsa.generateFile(_plus_5, 
          ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.view.generateViewInterface(viewAce, httpServer));
      }
    }
    int _size = httpServer.getAceOperations().size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      String _packageFolder = this._javaExtension.packageFolder(httpServer);
      String _plus = (_packageFolder + "/events/EventFactory.java");
      fsa.generateFile(_plus, 
        ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.eventFactory.generateEventFactory(httpServer));
    }
    int _size_1 = httpServer.getAceOperations().size();
    boolean _greaterThan_1 = (_size_1 > 0);
    if (_greaterThan_1) {
      String _packageFolder_1 = this._javaExtension.packageFolder(httpServer);
      String _plus_1 = (_packageFolder_1 + "/actions/AceDataFactory.java");
      fsa.generateFile(_plus_1, 
        ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.aceDataFactory.generateAceDataFactory(httpServer));
    }
    fsa.generateFile("de/acegen/EventFactory.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, 
      this.eventFactory.generateEventFactory());
    fsa.generateFile("de/acegen/AceOperation.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.aceOperation.generate());
    fsa.generateFile("de/acegen/ServerInfo.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.serverInfo.generate());
    fsa.generateFile("de/acegen/NonDeterministicDataProvider.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.notReplayableDataProvider.generateNonDeterministicDataProvider());
    fsa.generateFile("de/acegen/AceDao.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.dao.generateAceDao());
    fsa.generateFile("de/acegen/Action.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.action.generateAction());
    fsa.generateFile("de/acegen/ReadAction.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.action.generateReadAction());
    fsa.generateFile("de/acegen/WriteAction.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.action.generateWriteAction());
    fsa.generateFile("de/acegen/HttpMethod.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.action.generateHttpMethod());
    fsa.generateFile("de/acegen/IAction.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.action.generateIAction());
    fsa.generateFile("de/acegen/Command.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.command.generateCommand());
    fsa.generateFile("de/acegen/ICommand.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.command.generateICommand());
    fsa.generateFile("de/acegen/Event.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.event.generateEvent());
    fsa.generateFile("de/acegen/IEvent.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.event.generateIEvent());
    fsa.generateFile("de/acegen/DatabaseHandle.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, 
      this.databaseHandle.generateDatabaseHandle());
    fsa.generateFile("de/acegen/IDataContainer.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.data.generateIDataContainer());
    fsa.generateFile("de/acegen/ITimelineItem.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.timelineItem.generateITimelineItem());
    fsa.generateFile("de/acegen/TimelineItem.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.timelineItem.generateTimelineItem());
    fsa.generateFile("de/acegen/TimelineItemMapper.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.timelineItem.generateTimelineItemMapper());
    fsa.generateFile("de/acegen/AbstractData.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.data.generateAbstractData());
    fsa.generateFile("de/acegen/AbstractDaoProvider.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.daoProvider.generateAbstractDaoProvider());
    fsa.generateFile("de/acegen/DaoProvider.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, 
      this.daoProvider.generateDaoProvider());
    fsa.generateFile("de/acegen/IDaoProvider.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, 
      this.daoProvider.generateIDaoProvider());
    fsa.generateFile("de/acegen/ViewProvider.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, 
      this.viewProvider.generateViewProvider());
    fsa.generateFile("de/acegen/AbstractViewProvider.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.viewProvider.generateAbstractViewProvider());
    fsa.generateFile("de/acegen/EventConsumer.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.eventConsumer.generateEventconsumer());
    fsa.generateFile("de/acegen/DateTimeToStringConverter.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.converter.generateDateTimeToStringConverter());
    fsa.generateFile("de/acegen/StringToDateTimeConverter.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.converter.generateStringToDateTimeConverter());
    fsa.generateFile("de/acegen/PersistenceConnection.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.persistence.generatePersistenceConnection());
    fsa.generateFile("de/acegen/PersistenceHandle.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.persistence.generatePersistenceHandle());
    de.acegen.aceGen.AuthUser authUserAce = httpServer.getAuthUser();
    if ((authUserAce == null)) {
      authUserAce = httpServer.getAuthUserRef();
    }
    if ((authUserAce != null)) {
      String _firstUpper = StringExtensions.toFirstUpper(authUserAce.getName());
      String _plus_2 = ("de/acegen/auth/" + _firstUpper);
      String _plus_3 = (_plus_2 + ".java");
      fsa.generateFile(_plus_3, 
        ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.authUser.generateAuthUser(authUserAce));
    }
    fsa.generateFile("de/acegen/AbstractBaseScenario.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT, 
      this.baseScenario.generateAbstractBaseScenario());
    fsa.generateFile("de/acegen/TestLogger.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT, 
      this.baseScenario.generateTestLogger());
    fsa.generateFile("de/acegen/HttpResponse.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT, 
      this.baseScenario.generateHttpResponse());
    fsa.generateFile("de/acegen/BaseScenario.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT_ONCE, 
      this.baseScenario.generateBaseScenario());
    fsa.generateFile("de/acegen/YamlConfiguration.java", 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT_ONCE, 
      this.yamlConfiguration.generateYamlConfiguration());
    fsa.generateFile("de/acegen/Database.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT_ONCE, 
      this.yamlConfiguration.generateDatabase());
    fsa.generateFile("de/acegen/Server.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT_ONCE, 
      this.yamlConfiguration.generateServer());
    fsa.generateFile("de/acegen/Connectors.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT_ONCE, 
      this.yamlConfiguration.generateConnectors());
    EList<de.acegen.aceGen.Scenario> _scenarios = httpServer.getScenarios();
    for (final de.acegen.aceGen.Scenario scenarioAce : _scenarios) {
      {
        String _packageFolder_2 = this._javaExtension.packageFolder(httpServer);
        String _plus_4 = (_packageFolder_2 + "/scenarios/Abstract");
        String _name = scenarioAce.getName();
        String _plus_5 = (_plus_4 + _name);
        String _plus_6 = (_plus_5 + "Scenario.java");
        fsa.generateFile(_plus_6, 
          ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT, 
          this.scenario.generateAbstractScenario(scenarioAce, httpServer));
        String _packageFolder_3 = this._javaExtension.packageFolder(httpServer);
        String _plus_7 = (_packageFolder_3 + "/scenarios/");
        String _name_1 = scenarioAce.getName();
        String _plus_8 = (_plus_7 + _name_1);
        String _plus_9 = (_plus_8 + "Scenario.java");
        fsa.generateFile(_plus_9, 
          ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT_ONCE, 
          this.scenario.generateScenario(scenarioAce, httpServer));
      }
    }
  }
}
