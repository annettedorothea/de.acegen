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
import de.acegen.aceGen.HttpServerView;
import de.acegen.extensions.java.TypeExtension;
import de.acegen.extensions.java.ViewExtension;
import de.acegen.generator.java.AppRegistrationGenerator;
import de.acegen.generator.java.DropwizardGenerator;
import de.acegen.generator.java.JDBI3Generator;
import de.acegen.generator.java.LiquibaseGenerator;
import de.acegen.templates.java.AceOperation;
import de.acegen.templates.java.Converter;
import de.acegen.templates.java.DatabaseHandle;
import de.acegen.templates.java.Persistence;
import de.acegen.templates.java.ServerInfo;
import de.acegen.templates.java.SquishyDataProvider;
import de.acegen.templates.java.TimelineItem;
import de.acegen.templates.java.actions.Action;
import de.acegen.templates.java.auth.AuthUser;
import de.acegen.templates.java.commands.Command;
import de.acegen.templates.java.data.Data;
import de.acegen.templates.java.events.Event;
import de.acegen.templates.java.events.EventConsumer;
import de.acegen.templates.java.models.Dao;
import de.acegen.templates.java.models.DaoProvider;
import de.acegen.templates.java.models.Model;
import de.acegen.templates.java.scenario.BaseScenario;
import de.acegen.templates.java.scenario.Scenario;
import de.acegen.templates.java.scenario.YamlConfiguration;
import de.acegen.templates.java.views.View;
import de.acegen.templates.java.views.ViewProvider;
import jakarta.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class JavaGenerator {
  @Inject
  private JDBI3Generator jdbi3Generator;

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
  private Command command;

  @Inject
  private Event event;

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
  private SquishyDataProvider squishyDataProvider;

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
  private TypeExtension _typeExtension;

  public void doGenerate(final HttpServer httpServer, final IFileSystemAccess2 fsa) {
    boolean _isJDBI3 = httpServer.isJDBI3();
    if (_isJDBI3) {
      this.jdbi3Generator.doGenerate(httpServer, fsa);
    }
    boolean _isDropwizard = httpServer.isDropwizard();
    if (_isDropwizard) {
      this.dropwizardGenerator.doGenerate(httpServer, fsa);
    } else {
      this.appRegistrationGenerator.doGenerate(httpServer, fsa);
    }
    boolean _isLiquibase = httpServer.isLiquibase();
    if (_isLiquibase) {
      this.liquibaseGenerator.doGenerate(httpServer, fsa);
    }
    EList<de.acegen.aceGen.Model> _models = httpServer.getModels();
    for (final de.acegen.aceGen.Model modelAce : _models) {
      String _packageFolder = this._typeExtension.packageFolder(httpServer);
      String _plus = (_packageFolder + "/models/");
      String _modelClassName = this._typeExtension.modelClassName(modelAce);
      String _plus_1 = (_plus + _modelClassName);
      String _fileExtension = this._typeExtension.fileExtension();
      String _plus_2 = (_plus_1 + _fileExtension);
      fsa.generateFile(_plus_2, 
        ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.model.generateClass(modelAce, httpServer));
    }
    EList<HttpServerAce> _aceOperations = httpServer.getAceOperations();
    for (final HttpServerAce ace : _aceOperations) {
      {
        String _packageFolder_1 = this._typeExtension.packageFolder(httpServer);
        String _plus_3 = (_packageFolder_1 + "/actions/");
        String _abstractActionName = this._typeExtension.abstractActionName(ace);
        String _plus_4 = (_plus_3 + _abstractActionName);
        String _fileExtension_1 = this._typeExtension.fileExtension();
        String _plus_5 = (_plus_4 + _fileExtension_1);
        fsa.generateFile(_plus_5, 
          ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.action.generateAbstractActionFile(ace, httpServer));
        String _packageFolder_2 = this._typeExtension.packageFolder(httpServer);
        String _plus_6 = (_packageFolder_2 + "/actions/");
        String _actionName = this._typeExtension.actionName(ace);
        String _plus_7 = (_plus_6 + _actionName);
        String _fileExtension_2 = this._typeExtension.fileExtension();
        String _plus_8 = (_plus_7 + _fileExtension_2);
        fsa.generateFile(_plus_8, 
          ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, 
          this.action.generateInitialActionFile(ace, httpServer));
        boolean _equals = "GET".equals(ace.getType());
        boolean _not = (!_equals);
        if (_not) {
          String _packageFolder_3 = this._typeExtension.packageFolder(httpServer);
          String _plus_9 = (_packageFolder_3 + "/commands/");
          String _abstractCommandName = this._typeExtension.abstractCommandName(ace);
          String _plus_10 = (_plus_9 + _abstractCommandName);
          String _fileExtension_3 = this._typeExtension.fileExtension();
          String _plus_11 = (_plus_10 + _fileExtension_3);
          fsa.generateFile(_plus_11, 
            ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
            this.command.generateAbstractCommandFile(((HttpServerAceWrite) ace), httpServer));
          String _packageFolder_4 = this._typeExtension.packageFolder(httpServer);
          String _plus_12 = (_packageFolder_4 + "/commands/");
          String _commandName = this._typeExtension.commandName(ace);
          String _plus_13 = (_plus_12 + _commandName);
          String _fileExtension_4 = this._typeExtension.fileExtension();
          String _plus_14 = (_plus_13 + _fileExtension_4);
          fsa.generateFile(_plus_14, 
            ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, 
            this.command.generateInitialCommandFile(((HttpServerAceWrite) ace), httpServer));
        }
        int _size = ace.getResponse().size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          String _packageFolder_5 = this._typeExtension.packageFolder(httpServer);
          String _plus_15 = (_packageFolder_5 + "/data/");
          String _responseDataName = this._typeExtension.responseDataName(ace);
          String _plus_16 = (_plus_15 + _responseDataName);
          String _fileExtension_5 = this._typeExtension.fileExtension();
          String _plus_17 = (_plus_16 + _fileExtension_5);
          fsa.generateFile(_plus_17, 
            ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.data.generateResponseData(ace, httpServer));
        }
        int _size_1 = ace.getPayload().size();
        boolean _greaterThan_1 = (_size_1 > 0);
        if (_greaterThan_1) {
          String _packageFolder_6 = this._typeExtension.packageFolder(httpServer);
          String _plus_18 = (_packageFolder_6 + "/data/");
          String _payloadDataName = this._typeExtension.payloadDataName(ace);
          String _plus_19 = (_plus_18 + _payloadDataName);
          String _fileExtension_6 = this._typeExtension.fileExtension();
          String _plus_20 = (_plus_19 + _fileExtension_6);
          fsa.generateFile(_plus_20, 
            ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.data.generatePayloadData(ace, httpServer));
        }
      }
    }
    EList<HttpServerView> _views = httpServer.getViews();
    for (final HttpServerView viewAce : _views) {
      {
        String _packageFolder_1 = this._typeExtension.packageFolder(httpServer);
        String _plus_3 = (_packageFolder_1 + "/views/");
        String _viewName = this._viewExtension.viewName(viewAce);
        String _plus_4 = (_plus_3 + _viewName);
        String _fileExtension_1 = this._typeExtension.fileExtension();
        String _plus_5 = (_plus_4 + _fileExtension_1);
        fsa.generateFile(_plus_5, 
          ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, this.view.generateView(viewAce, httpServer));
        String _packageFolder_2 = this._typeExtension.packageFolder(httpServer);
        String _plus_6 = (_packageFolder_2 + "/views/");
        String _viewInterfaceName = this._viewExtension.viewInterfaceName(viewAce);
        String _plus_7 = (_plus_6 + _viewInterfaceName);
        String _fileExtension_2 = this._typeExtension.fileExtension();
        String _plus_8 = (_plus_7 + _fileExtension_2);
        fsa.generateFile(_plus_8, 
          ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.view.generateViewInterface(viewAce, httpServer));
      }
    }
    fsa.generateFile("de/acegen/AceOperation.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.aceOperation.generate());
    fsa.generateFile("de/acegen/ServerInfo.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.serverInfo.generate());
    fsa.generateFile("de/acegen/SquishyDataProvider.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.squishyDataProvider.generate());
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
    fsa.generateFile("de/acegen/DatabaseHandle.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, 
      this.databaseHandle.generateDatabaseHandle());
    fsa.generateFile("de/acegen/ITimelineItem.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.timelineItem.generateITimelineItem());
    fsa.generateFile("de/acegen/TimelineItem.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.timelineItem.generateTimelineItem());
    fsa.generateFile("de/acegen/TimelineItemMapper.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.timelineItem.generateTimelineItemMapper());
    fsa.generateFile("de/acegen/Data.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.data.generateAbstractData());
    fsa.generateFile("de/acegen/AbstractModel.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.model.generateAbstractModel());
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
      String _plus_3 = ("de/acegen/auth/" + _firstUpper);
      String _fileExtension_1 = this._typeExtension.fileExtension();
      String _plus_4 = (_plus_3 + _fileExtension_1);
      fsa.generateFile(_plus_4, 
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
        String _packageFolder_1 = this._typeExtension.packageFolder(httpServer);
        String _plus_5 = (_packageFolder_1 + "/scenarios/Abstract");
        String _name = scenarioAce.getName();
        String _plus_6 = (_plus_5 + _name);
        String _plus_7 = (_plus_6 + "Scenario.java");
        fsa.generateFile(_plus_7, 
          ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT, 
          this.scenario.generateAbstractScenario(scenarioAce, httpServer));
        String _packageFolder_2 = this._typeExtension.packageFolder(httpServer);
        String _plus_8 = (_packageFolder_2 + "/scenarios/");
        String _name_1 = scenarioAce.getName();
        String _plus_9 = (_plus_8 + _name_1);
        String _plus_10 = (_plus_9 + "Scenario.java");
        fsa.generateFile(_plus_10, 
          ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT_ONCE, 
          this.scenario.generateScenario(scenarioAce, httpServer));
      }
    }
  }
}
