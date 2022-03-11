/********************************************************************************
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
 ********************************************************************************/




package de.acegen.generator

import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerAceWrite
import de.acegen.extensions.HttpServerExtension
import de.acegen.extensions.cs.CsHttpServerExtension
import de.acegen.extensions.cs.ModelExtension
import de.acegen.extensions.cs.ViewExtension
import de.acegen.generator.cs.DaoGenerator
import de.acegen.generator.cs.DotNetGenerator
import de.acegen.templates.java.AceOperation
import de.acegen.templates.java.Converter
import de.acegen.templates.java.DatabaseHandle
import de.acegen.templates.java.Persistence
import de.acegen.templates.java.ServerInfo
import de.acegen.templates.java.SquishyDataProvider
import de.acegen.templates.java.TimelineItem
import de.acegen.templates.java.actions.AceDataFactory
import de.acegen.templates.java.actions.Action
import de.acegen.templates.java.auth.AuthUser
import de.acegen.templates.java.commands.Command
import de.acegen.templates.cs.data.Data
import de.acegen.templates.java.events.Event
import de.acegen.templates.java.events.EventConsumer
import de.acegen.templates.java.events.EventReplayService
import de.acegen.templates.cs.models.Dao
import de.acegen.templates.cs.models.DaoProvider
import de.acegen.templates.cs.models.Model
import de.acegen.templates.java.scenario.BaseScenario
import de.acegen.templates.java.scenario.Scenario
import de.acegen.templates.java.scenario.YamlConfiguration
import de.acegen.templates.java.views.View
import de.acegen.templates.java.views.ViewProvider
import javax.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess2

class CsGenerator {

	@Inject
	DaoGenerator daoGenerator;

	@Inject
	DotNetGenerator dotNetGenerator;

	@Inject
	EventConsumer eventConsumer;

	@Inject
	Model model;

	@Inject
	Data data;

	@Inject
	Dao dao;

	@Inject
	DaoProvider daoProvider;

	@Inject
	Action action;

	@Inject
	AceDataFactory aceDataFactory;

	@Inject
	Command command;

	@Inject
	Event event;

	@Inject
	EventReplayService eventReplayService;

	@Inject
	View view;

	@Inject
	ViewProvider viewProvider;

	@Inject
	ServerInfo serverInfo;

	@Inject
	AceOperation aceOperation;

	@Inject
	Scenario scenario;

	@Inject
	BaseScenario baseScenario;

	@Inject
	YamlConfiguration yamlConfiguration;

	@Inject
	SquishyDataProvider squishyDataProvider;

	@Inject
	DatabaseHandle databaseHandle;

	@Inject
	TimelineItem timelineItem;

	@Inject
	Converter converter;

	@Inject
	Persistence persistence;

	@Inject
	AuthUser authUser;

	@Inject
	extension ViewExtension

	@Inject
	extension ModelExtension

	@Inject
	extension HttpServerExtension

	@Inject
	extension CsHttpServerExtension

	def void doGenerate(HttpServer httpServer, IFileSystemAccess2 fsa) {
		if (httpServer.EF) {
			//daoGenerator.doGenerate(httpServer, fsa)
		}
		if (httpServer.dotnet) {
			dotNetGenerator.doGenerate(httpServer, fsa)
		}
		for (modelAce : httpServer.models) {
			fsa.generateFile(httpServer.namespaceFolder + "/Models/" + modelAce.modelName + fileExtension,
				ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, model.generateInterface(modelAce, httpServer));
			fsa.generateFile(httpServer.namespaceFolder + "/Models/" + modelAce.modelClassName + fileExtension,
				ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, model.generateClass(modelAce, httpServer));
			fsa.generateFile(httpServer.namespaceFolder + "/Data/" + modelAce.dataInterfaceName + fileExtension,
				ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, data.generateDataInterface(modelAce, httpServer));
			fsa.generateFile(httpServer.namespaceFolder + "/Data/" + modelAce.abstractDataName + fileExtension,
				ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, data.generateAbstractData(modelAce, httpServer));
			fsa.generateFile(httpServer.namespaceFolder + "/Data/" + modelAce.dataName + fileExtension,
				ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT_ONCE, data.generateData(modelAce, httpServer));
		}
		for (ace : httpServer.aceOperations) {
			/*fsa.generateFile(httpServer.namespaceFolder + "/actions/" + ace.abstractActionName + fileExtension,
				ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, action.generateAbstractActionFile(ace, httpServer));
			fsa.generateFile(httpServer.namespaceFolder + "/actions/" + ace.actionName + fileExtension,
				ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT_ONCE,
				action.generateInitialActionFile(ace, httpServer));
			if (!"GET".equals(ace.getType)) {
				fsa.generateFile(httpServer.namespaceFolder + "/commands/" + ace.abstractCommandName + fileExtension,
					ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
					command.generateAbstractCommandFile(ace as HttpServerAceWrite, httpServer));
				fsa.generateFile(httpServer.namespaceFolder + "/commands/" + ace.commandName + fileExtension,
					ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT_ONCE,
					command.generateInitialCommandFile(ace as HttpServerAceWrite, httpServer));
			}
			fsa.generateFile(httpServer.namespaceFolder + "/data/" + ace.responseDataName + fileExtension,
				ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, data.generateResponseData(ace, httpServer));
			fsa.generateFile(httpServer.namespaceFolder + "/data/" + ace.responseDataInterfaceName + fileExtension,
				ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, data.generateReponseDataInterface(ace, httpServer));*/
			if (ace.payload.size > 0) {
				fsa.generateFile(httpServer.namespaceFolder + "/Data/" + ace.payloadDataName + fileExtension,
					ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, data.generatePayloadData(ace, httpServer));
				fsa.generateFile(httpServer.namespaceFolder + "/Data/" + ace.payloadDataInterfaceName + fileExtension,
					ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, data.generatePayloadDataInterface(ace, httpServer));
			}
		}
		/*for (viewAce : httpServer.views) {
			fsa.generateFile(httpServer.namespaceFolder + "/views/" + viewAce.viewName + fileExtension,
				ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT_ONCE, view.generateView(viewAce, httpServer));
			fsa.generateFile(httpServer.namespaceFolder + "/views/" + viewAce.viewInterfaceName + fileExtension,
				ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, view.generateViewInterface(viewAce, httpServer));
		}

		if (httpServer.aceOperations.size > 0) {
			fsa.generateFile(httpServer.namespaceFolder + "/events/EventReplayService" + fileExtension,
				ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, eventReplayService.generateEventReplayService(httpServer));
		}

		if (httpServer.aceOperations.size > 0) {
			fsa.generateFile(httpServer.namespaceFolder + "/actions/AceDataFactory" + fileExtension,
				ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, aceDataFactory.generateAceDataFactory(httpServer));
		}

		fsa.generateFile("de/acegen/EventReplayService" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT_ONCE,
			eventReplayService.generateEventReplayService());

		fsa.generateFile("de/acegen/AceOperation" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			aceOperation.generate());
		fsa.generateFile("de/acegen/ServerInfo" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			serverInfo.generate());
		fsa.generateFile("de/acegen/SquishyDataProvider" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			squishyDataProvider.generate());

		fsa.generateFile("de/acegen/AceDao" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			dao.generateAceDao());
		fsa.generateFile("de/acegen/Action" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			action.generateAction());
		fsa.generateFile("de/acegen/ReadAction" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			action.generateReadAction());
		fsa.generateFile("de/acegen/WriteAction" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			action.generateWriteAction());
		fsa.generateFile("de/acegen/HttpMethod" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			action.generateHttpMethod());
		fsa.generateFile("de/acegen/IAction" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			action.generateIAction());

		fsa.generateFile("de/acegen/Command" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			command.generateCommand());
		fsa.generateFile("de/acegen/ICommand" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			command.generateICommand());

		fsa.generateFile("de/acegen/Event" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			event.generateEvent());
		fsa.generateFile("de/acegen/IEvent" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			event.generateIEvent());

		fsa.generateFile("de/acegen/DatabaseHandle" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT_ONCE,
			databaseHandle.generateDatabaseHandle());
		fsa.generateFile("de/acegen/ITimelineItem" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			timelineItem.generateITimelineItem());
		fsa.generateFile("de/acegen/TimelineItem" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			timelineItem.generateTimelineItem());
		fsa.generateFile("de/acegen/TimelineItemMapper" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			timelineItem.generateTimelineItemMapper());*/
			
		fsa.generateFile("AceGen/IDataContainer" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			data.generateIDataContainer());
		fsa.generateFile("AceGen/AbstractData" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			data.generateAbstractData());

		/*fsa.generateFile("de/acegen/AbstractDaoProvider" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			daoProvider.generateAbstractDaoProvider());
		fsa.generateFile("de/acegen/DaoProvider" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT_ONCE,
			daoProvider.generateDaoProvider());
		fsa.generateFile("de/acegen/IDaoProvider" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT_ONCE,
			daoProvider.generateIDaoProvider());

		fsa.generateFile("de/acegen/ViewProvider" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT_ONCE,
			viewProvider.generateViewProvider());
		fsa.generateFile("de/acegen/AbstractViewProvider" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			viewProvider.generateAbstractViewProvider());

		fsa.generateFile("de/acegen/EventConsumer" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			eventConsumer.generateEventconsumer());

		fsa.generateFile("de/acegen/DateTimeToStringConverter" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			converter.generateDateTimeToStringConverter());
		fsa.generateFile("de/acegen/StringToDateTimeConverter" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			converter.generateStringToDateTimeConverter());

		fsa.generateFile("de/acegen/PersistenceConnection" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			persistence.generatePersistenceConnection());
		fsa.generateFile("de/acegen/PersistenceHandle" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			persistence.generatePersistenceHandle());

		var authUserAce = httpServer.getAuthUser
		if (authUserAce === null) {
			authUserAce = httpServer.getAuthUserRef
		}
		if (authUserAce !== null) {
			fsa.generateFile("de/acegen/auth/" + authUserAce.name.toFirstUpper + fileExtension,
				ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, authUser.generateAuthUser(authUserAce));
		}

		fsa.generateFile("de/acegen/AbstractBaseScenario" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT,
			baseScenario.generateAbstractBaseScenario());
		fsa.generateFile("de/acegen/TestLogger" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT,
			baseScenario.generateTestLogger());
		fsa.generateFile("de/acegen/HttpResponse" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT,
			baseScenario.generateHttpResponse());

		fsa.generateFile("de/acegen/BaseScenario" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT_ONCE,
			baseScenario.generateBaseScenario());

		fsa.generateFile("de/acegen/YamlConfiguration" + fileExtension,
			ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT_ONCE,
			yamlConfiguration.generateYamlConfiguration());
		fsa.generateFile("de/acegen/Database" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT_ONCE,
			yamlConfiguration.generateDatabase());
		fsa.generateFile("de/acegen/Server" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT_ONCE,
			yamlConfiguration.generateServer());
		fsa.generateFile("de/acegen/Connectors" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT_ONCE,
			yamlConfiguration.generateConnectors());

		for (scenarioAce : httpServer.scenarios) {
			fsa.generateFile(httpServer.namespaceFolder + "/scenarios/Abstract" + scenarioAce.name + "Scenario" + fileExtension,
				ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT,
				scenario.generateAbstractScenario(scenarioAce, httpServer));

			fsa.generateFile(httpServer.namespaceFolder + "/scenarios/" + scenarioAce.name + "Scenario" + fileExtension,
				ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT_ONCE,
				scenario.generateScenario(scenarioAce, httpServer));
		}*/

	}

}
/******* S.D.G. *******/
