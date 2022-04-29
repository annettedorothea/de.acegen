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
import de.acegen.extensions.cs.CsHttpServerExtension
import de.acegen.extensions.cs.ModelExtension
import de.acegen.generator.cs.DotNetGenerator
import de.acegen.templates.cs.actions.Action
import de.acegen.templates.cs.commands.Command
import de.acegen.templates.cs.data.Data
import de.acegen.templates.cs.events.Event
import de.acegen.templates.cs.models.Dao
import de.acegen.templates.cs.models.Model
import de.acegen.templates.cs.views.ViewProvider
import javax.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess2

class CsGenerator {

	@Inject
	DotNetGenerator dotNetGenerator;

	@Inject
	Model model;

	@Inject
	Data data;

	@Inject
	Dao dao;

	@Inject
	Action action;

	@Inject
	Command command;

	@Inject
	Event event;

	@Inject
	ViewProvider viewProvider;

	@Inject
	extension ModelExtension

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

		fsa.generateFile("AceGen/EventReplayService" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT_ONCE,
			eventReplayService.generateEventReplayService());

		fsa.generateFile("AceGen/AceOperation" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			aceOperation.generate());
		fsa.generateFile("AceGen/ServerInfo" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			serverInfo.generate());
		fsa.generateFile("AceGen/SquishyDataProvider" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			squishyDataProvider.generate());*/

		fsa.generateFile("AceGen/AceDao" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			dao.generateAceDao());
			 
		fsa.generateFile("AceGen/Action" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			action.generateAction());
		fsa.generateFile("AceGen/ReadAction" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			action.generateReadAction());
		fsa.generateFile("AceGen/WriteAction" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			action.generateWriteAction());
		/*fsa.generateFile("AceGen/HttpMethod" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			action.generateHttpMethod());*/
		fsa.generateFile("AceGen/IAction" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			action.generateIAction());

		fsa.generateFile("AceGen/Command" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			command.generateCommand());
		fsa.generateFile("AceGen/ICommand" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			command.generateICommand());

		fsa.generateFile("AceGen/Event" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			event.generateEvent());
		fsa.generateFile("AceGen/IEvent" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			event.generateIEvent());

		/*fsa.generateFile("AceGen/DatabaseHandle" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT_ONCE,
			databaseHandle.generateDatabaseHandle());
		fsa.generateFile("AceGen/ITimelineItem" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			timelineItem.generateITimelineItem());
		fsa.generateFile("AceGen/TimelineItem" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			timelineItem.generateTimelineItem());
		fsa.generateFile("AceGen/TimelineItemMapper" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			timelineItem.generateTimelineItemMapper());*/
			
		fsa.generateFile("AceGen/IDataContainer" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			data.generateIDataContainer());
		fsa.generateFile("AceGen/AbstractData" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			data.generateAbstractData());

		/*fsa.generateFile("AceGen/AbstractDaoProvider" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			daoProvider.generateAbstractDaoProvider());
		fsa.generateFile("AceGen/DaoProvider" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT_ONCE,
			daoProvider.generateDaoProvider());
		fsa.generateFile("AceGen/IDaoProvider" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT_ONCE,
			daoProvider.generateIDaoProvider());*/

		fsa.generateFile("AceGen/ViewProvider" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			viewProvider.generateViewProvider());

		/*fsa.generateFile("AceGen/EventConsumer" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			eventConsumer.generateEventconsumer());

		fsa.generateFile("AceGen/DateTimeToStringConverter" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			converter.generateDateTimeToStringConverter());
		fsa.generateFile("AceGen/StringToDateTimeConverter" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			converter.generateStringToDateTimeConverter());

		fsa.generateFile("AceGen/PersistenceConnection" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			persistence.generatePersistenceConnection());
		fsa.generateFile("AceGen/PersistenceHandle" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			persistence.generatePersistenceHandle());

		var authUserAce = httpServer.getAuthUser
		if (authUserAce === null) {
			authUserAce = httpServer.getAuthUserRef
		}
		if (authUserAce !== null) {
			fsa.generateFile("AceGen/auth/" + authUserAce.name.toFirstUpper + fileExtension,
				ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, authUser.generateAuthUser(authUserAce));
		}

		fsa.generateFile("AceGen/AbstractBaseScenario" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT,
			baseScenario.generateAbstractBaseScenario());
		fsa.generateFile("AceGen/TestLogger" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT,
			baseScenario.generateTestLogger());
		fsa.generateFile("AceGen/HttpResponse" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT,
			baseScenario.generateHttpResponse());

		fsa.generateFile("AceGen/BaseScenario" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT_ONCE,
			baseScenario.generateBaseScenario());

		fsa.generateFile("AceGen/YamlConfiguration" + fileExtension,
			ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT_ONCE,
			yamlConfiguration.generateYamlConfiguration());
		fsa.generateFile("AceGen/Database" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT_ONCE,
			yamlConfiguration.generateDatabase());
		fsa.generateFile("AceGen/Server" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT_ONCE,
			yamlConfiguration.generateServer());
		fsa.generateFile("AceGen/Connectors" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT_ONCE,
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
