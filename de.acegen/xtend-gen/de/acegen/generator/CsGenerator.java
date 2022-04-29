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
import de.acegen.extensions.HttpServerExtension;
import de.acegen.extensions.cs.CsHttpServerExtension;
import de.acegen.extensions.cs.ModelExtension;
import de.acegen.extensions.cs.ViewExtension;
import de.acegen.generator.cs.DaoGenerator;
import de.acegen.generator.cs.DotNetGenerator;
import de.acegen.templates.cs.actions.Action;
import de.acegen.templates.cs.commands.Command;
import de.acegen.templates.cs.data.Data;
import de.acegen.templates.cs.events.Event;
import de.acegen.templates.cs.models.Dao;
import de.acegen.templates.cs.models.DaoProvider;
import de.acegen.templates.cs.models.Model;
import de.acegen.templates.cs.views.ViewProvider;
import de.acegen.templates.java.AceOperation;
import de.acegen.templates.java.Converter;
import de.acegen.templates.java.DatabaseHandle;
import de.acegen.templates.java.Persistence;
import de.acegen.templates.java.ServerInfo;
import de.acegen.templates.java.SquishyDataProvider;
import de.acegen.templates.java.TimelineItem;
import de.acegen.templates.java.actions.AceDataFactory;
import de.acegen.templates.java.auth.AuthUser;
import de.acegen.templates.java.events.EventConsumer;
import de.acegen.templates.java.events.EventReplayService;
import de.acegen.templates.java.scenario.BaseScenario;
import de.acegen.templates.java.scenario.Scenario;
import de.acegen.templates.java.scenario.YamlConfiguration;
import de.acegen.templates.java.views.View;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class CsGenerator {
  @Inject
  private DaoGenerator daoGenerator;
  
  @Inject
  private DotNetGenerator dotNetGenerator;
  
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
  private EventReplayService eventReplayService;
  
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
  private ModelExtension _modelExtension;
  
  @Inject
  @Extension
  private HttpServerExtension _httpServerExtension;
  
  @Inject
  @Extension
  private CsHttpServerExtension _csHttpServerExtension;
  
  public void doGenerate(final HttpServer httpServer, final IFileSystemAccess2 fsa) {
    boolean _isEF = httpServer.isEF();
    if (_isEF) {
    }
    boolean _isDotnet = httpServer.isDotnet();
    if (_isDotnet) {
      this.dotNetGenerator.doGenerate(httpServer, fsa);
    }
    EList<de.acegen.aceGen.Model> _models = httpServer.getModels();
    for (final de.acegen.aceGen.Model modelAce : _models) {
      {
        String _namespaceFolder = this._csHttpServerExtension.namespaceFolder(httpServer);
        String _plus = (_namespaceFolder + "/Models/");
        String _modelName = this._modelExtension.modelName(modelAce);
        String _plus_1 = (_plus + _modelName);
        String _fileExtension = this._csHttpServerExtension.fileExtension();
        String _plus_2 = (_plus_1 + _fileExtension);
        fsa.generateFile(_plus_2, 
          ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, this.model.generateInterface(modelAce, httpServer));
        String _namespaceFolder_1 = this._csHttpServerExtension.namespaceFolder(httpServer);
        String _plus_3 = (_namespaceFolder_1 + "/Models/");
        String _modelClassName = this._modelExtension.modelClassName(modelAce);
        String _plus_4 = (_plus_3 + _modelClassName);
        String _fileExtension_1 = this._csHttpServerExtension.fileExtension();
        String _plus_5 = (_plus_4 + _fileExtension_1);
        fsa.generateFile(_plus_5, 
          ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, this.model.generateClass(modelAce, httpServer));
        String _namespaceFolder_2 = this._csHttpServerExtension.namespaceFolder(httpServer);
        String _plus_6 = (_namespaceFolder_2 + "/Data/");
        String _dataInterfaceName = this._modelExtension.dataInterfaceName(modelAce);
        String _plus_7 = (_plus_6 + _dataInterfaceName);
        String _fileExtension_2 = this._csHttpServerExtension.fileExtension();
        String _plus_8 = (_plus_7 + _fileExtension_2);
        fsa.generateFile(_plus_8, 
          ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, this.data.generateDataInterface(modelAce, httpServer));
        String _namespaceFolder_3 = this._csHttpServerExtension.namespaceFolder(httpServer);
        String _plus_9 = (_namespaceFolder_3 + "/Data/");
        String _abstractDataName = this._modelExtension.abstractDataName(modelAce);
        String _plus_10 = (_plus_9 + _abstractDataName);
        String _fileExtension_3 = this._csHttpServerExtension.fileExtension();
        String _plus_11 = (_plus_10 + _fileExtension_3);
        fsa.generateFile(_plus_11, 
          ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, this.data.generateAbstractData(modelAce, httpServer));
        String _namespaceFolder_4 = this._csHttpServerExtension.namespaceFolder(httpServer);
        String _plus_12 = (_namespaceFolder_4 + "/Data/");
        String _dataName = this._modelExtension.dataName(modelAce);
        String _plus_13 = (_plus_12 + _dataName);
        String _fileExtension_4 = this._csHttpServerExtension.fileExtension();
        String _plus_14 = (_plus_13 + _fileExtension_4);
        fsa.generateFile(_plus_14, 
          ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT_ONCE, this.data.generateData(modelAce, httpServer));
      }
    }
    EList<HttpServerAce> _aceOperations = httpServer.getAceOperations();
    for (final HttpServerAce ace : _aceOperations) {
      int _size = ace.getPayload().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        String _namespaceFolder = this._csHttpServerExtension.namespaceFolder(httpServer);
        String _plus = (_namespaceFolder + "/Data/");
        String _payloadDataName = this._csHttpServerExtension.payloadDataName(ace);
        String _plus_1 = (_plus + _payloadDataName);
        String _fileExtension = this._csHttpServerExtension.fileExtension();
        String _plus_2 = (_plus_1 + _fileExtension);
        fsa.generateFile(_plus_2, 
          ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, this.data.generatePayloadData(ace, httpServer));
        String _namespaceFolder_1 = this._csHttpServerExtension.namespaceFolder(httpServer);
        String _plus_3 = (_namespaceFolder_1 + "/Data/");
        String _payloadDataInterfaceName = this._csHttpServerExtension.payloadDataInterfaceName(ace);
        String _plus_4 = (_plus_3 + _payloadDataInterfaceName);
        String _fileExtension_1 = this._csHttpServerExtension.fileExtension();
        String _plus_5 = (_plus_4 + _fileExtension_1);
        fsa.generateFile(_plus_5, 
          ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, this.data.generatePayloadDataInterface(ace, httpServer));
      }
    }
    String _fileExtension_2 = this._csHttpServerExtension.fileExtension();
    String _plus_6 = ("AceGen/AceDao" + _fileExtension_2);
    fsa.generateFile(_plus_6, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, 
      this.dao.generateAceDao());
    String _fileExtension_3 = this._csHttpServerExtension.fileExtension();
    String _plus_7 = ("AceGen/Action" + _fileExtension_3);
    fsa.generateFile(_plus_7, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, 
      this.action.generateAction());
    String _fileExtension_4 = this._csHttpServerExtension.fileExtension();
    String _plus_8 = ("AceGen/ReadAction" + _fileExtension_4);
    fsa.generateFile(_plus_8, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, 
      this.action.generateReadAction());
    String _fileExtension_5 = this._csHttpServerExtension.fileExtension();
    String _plus_9 = ("AceGen/WriteAction" + _fileExtension_5);
    fsa.generateFile(_plus_9, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, 
      this.action.generateWriteAction());
    String _fileExtension_6 = this._csHttpServerExtension.fileExtension();
    String _plus_10 = ("AceGen/IAction" + _fileExtension_6);
    fsa.generateFile(_plus_10, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, 
      this.action.generateIAction());
    String _fileExtension_7 = this._csHttpServerExtension.fileExtension();
    String _plus_11 = ("AceGen/Command" + _fileExtension_7);
    fsa.generateFile(_plus_11, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, 
      this.command.generateCommand());
    String _fileExtension_8 = this._csHttpServerExtension.fileExtension();
    String _plus_12 = ("AceGen/ICommand" + _fileExtension_8);
    fsa.generateFile(_plus_12, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, 
      this.command.generateICommand());
    String _fileExtension_9 = this._csHttpServerExtension.fileExtension();
    String _plus_13 = ("AceGen/Event" + _fileExtension_9);
    fsa.generateFile(_plus_13, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, 
      this.event.generateEvent());
    String _fileExtension_10 = this._csHttpServerExtension.fileExtension();
    String _plus_14 = ("AceGen/IEvent" + _fileExtension_10);
    fsa.generateFile(_plus_14, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, 
      this.event.generateIEvent());
    String _fileExtension_11 = this._csHttpServerExtension.fileExtension();
    String _plus_15 = ("AceGen/IDataContainer" + _fileExtension_11);
    fsa.generateFile(_plus_15, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, 
      this.data.generateIDataContainer());
    String _fileExtension_12 = this._csHttpServerExtension.fileExtension();
    String _plus_16 = ("AceGen/AbstractData" + _fileExtension_12);
    fsa.generateFile(_plus_16, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, 
      this.data.generateAbstractData());
    String _fileExtension_13 = this._csHttpServerExtension.fileExtension();
    String _plus_17 = ("AceGen/ViewProvider" + _fileExtension_13);
    fsa.generateFile(_plus_17, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, 
      this.viewProvider.generateViewProvider());
  }
}
