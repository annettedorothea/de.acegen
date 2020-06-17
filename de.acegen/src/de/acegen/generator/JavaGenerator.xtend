/* 
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 * 
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */


package de.acegen.generator

import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerAceWrite
import de.acegen.extensions.java.AceExtension
import de.acegen.extensions.java.JavaExtension
import de.acegen.extensions.java.ModelExtension
import de.acegen.extensions.java.ViewExtension
import de.acegen.generator.java.AppRegistrationGenerator
import de.acegen.generator.java.DaoGenerator
import de.acegen.generator.java.DropwizardGenerator
import de.acegen.generator.java.JDBI3Generator
import de.acegen.generator.java.LiquibaseGenerator
import de.acegen.templates.java.AceOperation
import de.acegen.templates.java.Converter
import de.acegen.templates.java.DatabaseHandle
import de.acegen.templates.java.E2E
import de.acegen.templates.java.NotReplayableDataProvider
import de.acegen.templates.java.Persistence
import de.acegen.templates.java.ServerInfo
import de.acegen.templates.java.TimelineItem
import de.acegen.templates.java.actions.AceDataFactory
import de.acegen.templates.java.actions.Action
import de.acegen.templates.java.auth.AuthUser
import de.acegen.templates.java.commands.Command
import de.acegen.templates.java.data.Data
import de.acegen.templates.java.events.Event
import de.acegen.templates.java.events.EventConsumer
import de.acegen.templates.java.events.EventFactory
import de.acegen.templates.java.models.Dao
import de.acegen.templates.java.models.DaoProvider
import de.acegen.templates.java.models.Model
import de.acegen.templates.java.scenario.BaseScenario
import de.acegen.templates.java.scenario.Scenario
import de.acegen.templates.java.views.View
import de.acegen.templates.java.views.ViewProvider
import javax.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess2

class JavaGenerator {

	@Inject
	JDBI3Generator jdbi3Generator;

	@Inject
	DaoGenerator daoGenerator;

	@Inject
	DropwizardGenerator dropwizardGenerator;

	@Inject
	AppRegistrationGenerator appRegistrationGenerator;

	@Inject
	LiquibaseGenerator liquibaseGenerator;

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
	EventFactory eventFactory;

	@Inject
	View view;

	@Inject
	ViewProvider viewProvider;

	@Inject
	ServerInfo serverInfo;

	@Inject
	E2E e2e;

	@Inject
	AceOperation aceOperation;

	@Inject
	Scenario scenario;

	@Inject
	BaseScenario baseScenario;

	@Inject
	NotReplayableDataProvider notReplayableDataProvider;

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
	extension JavaExtension

	@Inject
	extension ModelExtension

	@Inject
	extension AceExtension

	def void doGenerate(HttpServer httpServer, IFileSystemAccess2 fsa) {
		if (httpServer.JDBI3) {
			jdbi3Generator.doGenerate(httpServer, fsa)
		} else {
			daoGenerator.doGenerate(httpServer, fsa)
		}
		if (httpServer.dropwizard) {
			dropwizardGenerator.doGenerate(httpServer, fsa)
		} else {
			appRegistrationGenerator.doGenerate(httpServer, fsa)
		}
		if (httpServer.liquibase) {
			liquibaseGenerator.doGenerate(httpServer, fsa)
		}
		for (modelAce : httpServer.models) {
			fsa.generateFile(httpServer.packageFolder + "/models/" + modelAce.modelName + ".java",
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, model.generateInterface(modelAce, httpServer));
			fsa.generateFile(httpServer.packageFolder + "/models/" + modelAce.modelClassName + ".java",
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, model.generateClass(modelAce, httpServer));
			fsa.generateFile(httpServer.packageFolder + "/data/" + modelAce.dataInterfaceName + ".java",
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, data.generateDataInterface(modelAce, httpServer));
			fsa.generateFile(httpServer.packageFolder + "/data/" + modelAce.abstractDataName + ".java",
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, data.generateAbstractData(modelAce, httpServer));
			fsa.generateFile(httpServer.packageFolder + "/data/" + modelAce.dataName + ".java",
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, data.generateData(modelAce, httpServer));
		}
		for (ace : httpServer.aceOperations) {
			fsa.generateFile(httpServer.packageFolder + "/actions/" + ace.abstractActionName + ".java",
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, action.generateAbstractActionFile(ace, httpServer));
			fsa.generateFile(httpServer.packageFolder + "/actions/" + ace.actionName + ".java",
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE,
				action.generateInitialActionFile(ace, httpServer));
			if (!"GET".equals(ace.getType)) {
				fsa.generateFile(httpServer.packageFolder + "/commands/" + ace.abstractCommandName + ".java",
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
					command.generateAbstractCommandFile(ace as HttpServerAceWrite, httpServer));
				fsa.generateFile(httpServer.packageFolder + "/commands/" + ace.commandName + ".java",
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE,
					command.generateInitialCommandFile(ace as HttpServerAceWrite, httpServer));
				val aceWrite = ace as HttpServerAceWrite
				for (outcome : aceWrite.outcomes) {
					fsa.generateFile(httpServer.packageFolder + "/events/" + ace.eventName(outcome) + ".java",
						ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
						event.generateEventFile(ace, outcome, httpServer));
				}
			}
			if (ace.response.size > 0) {
				fsa.generateFile(httpServer.packageFolder + "/data/" + ace.responseDataName + ".java",
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, data.generateResponseData(ace, httpServer));
				fsa.generateFile(httpServer.packageFolder + "/data/" + ace.responseDataInterfaceName + ".java",
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
					data.generateReponseDataInterface(ace, httpServer));
			}
		}
		for (viewAce : httpServer.views) {
			fsa.generateFile(httpServer.packageFolder + "/views/" + viewAce.viewName + ".java",
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, view.generateView(viewAce, httpServer));
			fsa.generateFile(httpServer.packageFolder + "/views/" + viewAce.viewInterfaceName + ".java",
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, view.generateViewInterface(viewAce, httpServer));
		}

		if (httpServer.aceOperations.size > 0) {
			fsa.generateFile(httpServer.packageFolder + "/events/EventFactory.java",
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, eventFactory.generateEventFactory(httpServer));
		}

		if (httpServer.aceOperations.size > 0) {
			fsa.generateFile(httpServer.packageFolder + "/actions/AceDataFactory.java",
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceDataFactory.generateAceDataFactory(httpServer));
		}

		fsa.generateFile("de/acegen/EventFactory.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE,
			eventFactory.generateEventFactory());

		fsa.generateFile("de/acegen/E2E.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, e2e.generate());
		fsa.generateFile("de/acegen/AceOperation.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			aceOperation.generate());
		fsa.generateFile("de/acegen/ServerInfo.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			serverInfo.generate());
		fsa.generateFile("de/acegen/NotReplayableDataProvider.java",
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, notReplayableDataProvider.generateNotReplayableDataProvider());

		fsa.generateFile("de/acegen/AceDao.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			dao.generateAceDao());
		
		fsa.generateFile("de/acegen/Action.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			action.generateAction());
		fsa.generateFile("de/acegen/ReadAction.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			action.generateReadAction(false));
		fsa.generateFile("de/acegen/ProxyReadAction.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			action.generateReadAction(true));
		fsa.generateFile("de/acegen/WriteAction.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			action.generateWriteAction(false));
		fsa.generateFile("de/acegen/ProxyWriteAction.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			action.generateWriteAction(true));
		fsa.generateFile("de/acegen/HttpMethod.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			action.generateHttpMethod());
		fsa.generateFile("de/acegen/IAction.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			action.generateIAction());

		fsa.generateFile("de/acegen/Command.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			command.generateCommand());
		fsa.generateFile("de/acegen/ICommand.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			command.generateICommand());
		
		fsa.generateFile("de/acegen/Event.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			event.generateEvent());
		fsa.generateFile("de/acegen/IEvent.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			event.generateIEvent());

		fsa.generateFile("de/acegen/DatabaseHandle.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			databaseHandle.generateDatabaseHandle());
		fsa.generateFile("de/acegen/IDataContainer.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			data.generateIDataContainer());
		fsa.generateFile("de/acegen/ITimelineItem.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			timelineItem.generateITimelineItem());
		fsa.generateFile("de/acegen/TimelineItem.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			timelineItem.generateTimelineItem());
		fsa.generateFile("de/acegen/TimelineItemMapper.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			timelineItem.generateTimelineItemMapper());
		fsa.generateFile("de/acegen/AbstractData.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			data.generateAbstractData());

		fsa.generateFile("de/acegen/AbstractDaoProvider.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			daoProvider.generateAbstractDaoProvider());
		fsa.generateFile("de/acegen/DaoProvider.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE,
			daoProvider.generateDaoProvider());
		fsa.generateFile("de/acegen/IDaoProvider.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE,
			daoProvider.generateIDaoProvider());
		
		fsa.generateFile("de/acegen/ViewProvider.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE,
			viewProvider.generateViewProvider());
		fsa.generateFile("de/acegen/AbstractViewProvider.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			viewProvider.generateAbstractViewProvider());

		fsa.generateFile("de/acegen/EventConsumer.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			eventConsumer.generateEventconsumer());

		fsa.generateFile("de/acegen/DateTimeToStringConverter.java",
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, converter.generateDateTimeToStringConverter());
		fsa.generateFile("de/acegen/StringToDateTimeConverter.java",
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, converter.generateStringToDateTimeConverter());

		fsa.generateFile("de/acegen/PersistenceConnection.java",
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, persistence.generatePersistenceConnection());
		fsa.generateFile("de/acegen/PersistenceHandle.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			persistence.generatePersistenceHandle());

		var authUserAce = httpServer.getAuthUser
		if (authUserAce === null) {
			authUserAce = httpServer.getAuthUserRef
		}
		if (authUserAce !== null) {
			fsa.generateFile("de/acegen/auth/" + authUserAce.name.toFirstUpper + ".java",
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, authUser.generateAuthUser(authUserAce));
		}

		fsa.generateFile("de/acegen/AbstractBaseScenario.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT,
			baseScenario.generateAbstractBaseScenario());

		fsa.generateFile("de/acegen/BaseScenario.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT_ONCE,
			baseScenario.generateBaseScenario());

		for (scenarioAce : httpServer.scenarios) {
			fsa.generateFile(httpServer.packageFolder + "/scenarios/Abstract" + scenarioAce.name + "Scenario.java",
				ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT,
				scenario.generateAbstractScenario(scenarioAce, httpServer));

			fsa.generateFile(httpServer.packageFolder + "/scenarios/" + scenarioAce.name + "Scenario.java",
				ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT_ONCE,
				scenario.generateScenario(scenarioAce, httpServer));
		}

	}

}
/******* S.D.G. *******/
