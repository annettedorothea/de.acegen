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
import de.acegen.templates.java.AceTemplate
import de.acegen.templates.java.ActionTemplate
import de.acegen.templates.java.CommandTemplate
import de.acegen.templates.java.EventTemplate
import de.acegen.templates.java.ModelTemplate
import de.acegen.templates.java.ScenarioTemplate
import javax.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess2
import de.acegen.templates.java.ResourceTemplate

class JavaGenerator {
	@Inject
	ActionTemplate actionTemplate;

	@Inject
	CommandTemplate commandTemplate;

	@Inject
	EventTemplate eventTemplate;

	@Inject
	AceTemplate aceTemplate;

	@Inject
	ModelTemplate modelTemplate;

	@Inject
	ScenarioTemplate scenarioTemplate;

	@Inject
	ResourceTemplate resourceTemplate;

	@Inject
	extension ViewExtension

	@Inject
	extension JavaExtension

	@Inject
	extension ModelExtension

	@Inject
	extension AceExtension

	def void doGenerate(HttpServer httpServer, IFileSystemAccess2 fsa) {
		var authUser = httpServer.getAuthUser
		if (authUser === null) {
			authUser = httpServer.getAuthUserRef
		}
		for (model : httpServer.models) {
			fsa.generateFile(httpServer.packageFolder + '/models/' + model.modelName + '.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, modelTemplate.generateModel(model, httpServer));
			fsa.generateFile(httpServer.packageFolder + '/models/' + model.modelClassName + '.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, modelTemplate.generateModelClass(model, httpServer));
			if (httpServer.JDBI3) {
				fsa.generateFile(httpServer.packageFolder + '/models/' + model.modelMapper + '.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, modelTemplate.generateMapper(model, httpServer));
			}
			if (model.persistent) {
				if (httpServer.JDBI3) {
					fsa.generateFile(httpServer.packageFolder + '/models/' + model.abstractModelDao + '.java',
						ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, modelTemplate.generateAbstractJdbiDao(model, httpServer));
					fsa.generateFile(httpServer.packageFolder + '/models/' + model.modelDao + '.java',
						ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, modelTemplate.generateJdbiDao(model, httpServer));
				} else {
					fsa.generateFile(httpServer.packageFolder + '/models/' + model.abstractModelDao + '.java',
						ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, modelTemplate.generateAbstractDao(model, httpServer));
					fsa.generateFile(httpServer.packageFolder + '/models/' + model.modelDao + '.java',
						ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, modelTemplate.generateDao(model, httpServer));
				}
				if (httpServer.liquibase) {
					fsa.generateFile(httpServer.packageFolder + '/' + model.name + '_creation.xml',
						ACEOutputConfigurationProvider.DEFAULT_RESOURCE_OUTPUT,
						modelTemplate.generateMigration(model, httpServer));
				}
			}
			fsa.generateFile(httpServer.packageFolder + '/data/' + model.dataInterfaceName + '.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, modelTemplate.generateDataInterface(model, httpServer));
			fsa.generateFile(httpServer.packageFolder + '/data/' + model.abstractDataName + '.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, modelTemplate.generateAbstractData(model, httpServer));
			fsa.generateFile(httpServer.packageFolder + '/data/' + model.dataName + '.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, modelTemplate.generateData(model, httpServer));
		}
		for (ace : httpServer.aceOperations) {
			if (httpServer.dropwizard) {
				fsa.generateFile(httpServer.packageFolder + '/resources/' + ace.resourceName + '.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
					resourceTemplate.generateResourceFile(ace, httpServer, authUser));
			}
			fsa.generateFile(httpServer.packageFolder + '/actions/' + ace.abstractActionName + '.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
				actionTemplate.generateAbstractActionFile(ace, httpServer));
			fsa.generateFile(httpServer.packageFolder + '/actions/' + ace.actionName + '.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE,
				actionTemplate.generateInitialActionFile(ace, httpServer));
			if (!'GET'.equals(ace.getType)) {
				fsa.generateFile(httpServer.packageFolder + '/commands/' + ace.abstractCommandName + '.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
					commandTemplate.generateAbstractCommandFile(ace as HttpServerAceWrite, httpServer));
				fsa.generateFile(httpServer.packageFolder + '/commands/' + ace.commandName + '.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE,
					commandTemplate.generateInitialCommandFile(ace as HttpServerAceWrite, httpServer));
				val aceWrite = ace as HttpServerAceWrite
				for (outcome : aceWrite.outcomes) {
					fsa.generateFile(httpServer.packageFolder + '/events/' + ace.eventName(outcome) + '.java',
						ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
						eventTemplate.generateAbstractEventFile(ace, outcome, httpServer));
				}
			}
			if (ace.response.size > 0) {
				fsa.generateFile(httpServer.packageFolder + '/data/' + ace.responseDataName + '.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, modelTemplate.generateResponseData(ace, httpServer));
				fsa.generateFile(httpServer.packageFolder + '/data/' + ace.responseDataInterfaceName + '.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
					modelTemplate.generateReponseDataInterface(ace, httpServer));
			}
		}
		for (view : httpServer.views) {
			fsa.generateFile(httpServer.packageFolder + '/views/' + view.viewName + '.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, eventTemplate.generateView(view, httpServer));
			fsa.generateFile(httpServer.packageFolder + '/views/' + view.viewInterfaceName + '.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, eventTemplate.generateViewInterface(view, httpServer));
		}

		if (httpServer.aceOperations.size > 0) {
			fsa.generateFile(httpServer.packageFolder + '/events/EventFactory.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, eventTemplate.generateEventFactory(httpServer));
		}

		if (httpServer.aceOperations.size > 0) {
			fsa.generateFile(httpServer.packageFolder + '/actions/AceDataFactory.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, actionTemplate.generateAceDataFactory(httpServer));
		}

		fsa.generateFile('de/acegen/EventFactory.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE,
			eventTemplate.generateEventFactory());

		fsa.generateFile("de/acegen" + '/CustomAppConfiguration.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, aceTemplate.generateCustomAppConfiguration());
		fsa.generateFile("de/acegen" + '/E2E.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			aceTemplate.generateE2E());
		fsa.generateFile("de/acegen" + '/Config.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			aceTemplate.generateConfig());
		fsa.generateFile("de/acegen" + '/AceOperation.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			aceTemplate.generateAceOperation());
		if (httpServer.dropwizard) {
			fsa.generateFile("de/acegen" + '/StartE2ESessionResource.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateStartE2ESessionResource());
			fsa.generateFile("de/acegen" + '/StopE2ESessionResource.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateStopE2ESessionResource());
			fsa.generateFile("de/acegen" + '/PrepareE2EResource.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generatePrepareE2EResource());
			fsa.generateFile("de/acegen" + '/GetServerTimelineResource.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateGetServerTimelineResource());
			fsa.generateFile("de/acegen" + '/ServerInfo.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
				aceTemplate.generateServerInfo());
			fsa.generateFile("de/acegen" + '/App.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE,
				aceTemplate.generateApp());
			fsa.generateFile("de/acegen" + '/AppConfiguration.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
				aceTemplate.generateAppConfiguration());
			fsa.generateFile("de/acegen" + '/EventReplayCommand.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateEventReplayCommand());
			fsa.generateFile("de/acegen" + '/GetServerInfoResource.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateGetServerInfoResource());
			fsa.generateFile("de/acegen" + '/NotReplayableDataProviderResource.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
				aceTemplate.generateNotReplayableDataProviderResource());
			fsa.generateFile("de/acegen" + '/Resource.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
				resourceTemplate.generateDropwizardResource());
		}
		fsa.generateFile(httpServer.packageFolder + '/AppRegistration.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, actionTemplate.generateAppRegistration(httpServer));
		fsa.generateFile("de/acegen" + '/AppRegistration.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE,
			aceTemplate.generateAppRegistration(httpServer));
		fsa.generateFile("de/acegen" + '/NotReplayableDataProvider.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateNotReplayableDataProvider());

		fsa.generateFile("de/acegen" + '/AceDao.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			aceTemplate.generateAceDao());
		fsa.generateFile("de/acegen" + '/Action.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			actionTemplate.generateAction());
		fsa.generateFile("de/acegen" + '/ReadAction.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			actionTemplate.generateReadAction());
		fsa.generateFile("de/acegen" + '/WriteAction.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			actionTemplate.generateWriteAction(false));
		fsa.generateFile("de/acegen" + '/ProxyWriteAction.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			actionTemplate.generateWriteAction(true));
		fsa.generateFile("de/acegen" + '/Command.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			commandTemplate.generateCommand());
		fsa.generateFile("de/acegen" + '/DatabaseHandle.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			modelTemplate.generateDatabaseHandle());
		fsa.generateFile("de/acegen" + '/Event.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			eventTemplate.generateEvent());
		fsa.generateFile("de/acegen" + '/HttpMethod.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			actionTemplate.generateHttpMethod());
		fsa.generateFile("de/acegen" + '/IAction.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			actionTemplate.generateIAction());
		fsa.generateFile("de/acegen" + '/ICommand.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			commandTemplate.generateICommand());
		fsa.generateFile("de/acegen" + '/IDataContainer.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			modelTemplate.generateIDataContainer());
		fsa.generateFile("de/acegen" + '/IEvent.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			eventTemplate.generateIEvent());
		fsa.generateFile("de/acegen" + '/ITimelineItem.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			aceTemplate.generateITimelineItem());
		fsa.generateFile("de/acegen" + '/JodaObjectMapper.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			aceTemplate.generateJodaObjectMapper());
		fsa.generateFile("de/acegen" + '/TimelineItem.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			aceTemplate.generateTimelineItem());
		fsa.generateFile("de/acegen" + '/TimelineItemMapper.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			aceTemplate.generateTimelineItemMapper());
		fsa.generateFile("de/acegen" + '/AbstractData.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			modelTemplate.generateAbstractData());

		fsa.generateFile("de/acegen" + '/AbstractDaoProvider.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			aceTemplate.generateAbstractDaoProvider());
		fsa.generateFile("de/acegen" + '/DaoProvider.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE,
			aceTemplate.generateDaoProvider());
		fsa.generateFile("de/acegen" + '/IDaoProvider.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE,
			aceTemplate.generateIDaoProvider());
		fsa.generateFile("de/acegen" + '/ViewProvider.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE,
			aceTemplate.generateViewProvider());
		fsa.generateFile("de/acegen" + '/AbstractViewProvider.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			aceTemplate.generateAbstractViewProvider());

		fsa.generateFile("de/acegen" + '/EventConsumer.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			eventTemplate.generateEventconsumer());

		fsa.generateFile("de/acegen" + '/DateTimeToStringConverter.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateDateTimeToStringConverter());

		fsa.generateFile("de/acegen" + '/StringToDateTimeConverter.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateStringToDateTimeConverter());

		fsa.generateFile("de/acegen" + '/PersistenceConnection.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generatePersistenceConnection());
		fsa.generateFile("de/acegen" + '/PersistenceHandle.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			aceTemplate.generatePersistenceHandle());

		fsa.generateFile('ace_creation.xml', ACEOutputConfigurationProvider.DEFAULT_RESOURCE_OUTPUT,
			aceTemplate.generateAceMigration());

		if (authUser !== null) {
			fsa.generateFile('de/acegen/auth/' + authUser.name.toFirstUpper + '.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateAuthUser(authUser));
		}

		fsa.generateFile('de/acegen/AbstractBaseScenario.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT,
			scenarioTemplate.generateAbstractBaseScenario());

		fsa.generateFile('de/acegen/BaseScenario.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT_ONCE,
			scenarioTemplate.generateBaseScenario());

		for (scenario : httpServer.scenarios) {
			fsa.generateFile(httpServer.packageFolder + '/scenarios/Abstract' + scenario.name + 'Scenario.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT,
				scenarioTemplate.generateAbstractScenario(scenario, httpServer));

			fsa.generateFile(httpServer.packageFolder + '/scenarios/' + scenario.name + 'Scenario.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT_ONCE,
				scenarioTemplate.generateScenario(scenario, httpServer));
		}

	}

}
/******* S.D.G. *******/
