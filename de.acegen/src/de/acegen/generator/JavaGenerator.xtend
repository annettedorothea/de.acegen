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
	extension ViewExtension

	@Inject
	extension JavaExtension

	@Inject
	extension ModelExtension

	@Inject
	extension AceExtension

	def void doGenerate(HttpServer java, IFileSystemAccess2 fsa) {
		var authUser = java.getAuthUser
		if (authUser === null) {
			authUser = java.getAuthUserRef
		}
		for (model : java.models) {
			fsa.generateFile(java.packageFolder + '/models/' + model.modelName + '.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, modelTemplate.generateModel(model, java));
			fsa.generateFile(java.packageFolder + '/models/' + model.modelClassName + '.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, modelTemplate.generateModelClass(model, java));
			fsa.generateFile(java.packageFolder + '/models/' + model.modelMapper + '.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, modelTemplate.generateMapper(model, java));
			if (model.persistent) {
				fsa.generateFile(java.packageFolder + '/models/' + model.abstractModelDao + '.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, modelTemplate.generateAbstractDao(model, java));
				fsa.generateFile(java.packageFolder + '/models/' + model.modelDao + '.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, modelTemplate.generateDao(model, java));
				fsa.generateFile(java.packageFolder + '/' + model.name + '_creation.xml',
					ACEOutputConfigurationProvider.DEFAULT_RESOURCE_OUTPUT,
					modelTemplate.generateMigration(model, java));
			}
			fsa.generateFile(java.packageFolder + '/data/' + model.dataInterfaceName + '.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, modelTemplate.generateDataInterface(model, java));
			fsa.generateFile(java.packageFolder + '/data/' + model.abstractDataName + '.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, modelTemplate.generateAbstractData(model, java));
			fsa.generateFile(java.packageFolder + '/data/' + model.dataName + '.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, modelTemplate.generateData(model, java));
		}
		for (ace : java.aceOperations) {
			fsa.generateFile(java.packageFolder + '/actions/' + ace.abstractActionName + '.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
				actionTemplate.generateAbstractActionFile(ace, java, authUser));
			fsa.generateFile(java.packageFolder + '/actions/' + ace.actionName + '.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE,
				actionTemplate.generateInitialActionFile(ace, java));
			if (!'GET'.equals(ace.getType)) {
				fsa.generateFile(java.packageFolder + '/commands/' + ace.abstractCommandName + '.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
					commandTemplate.generateAbstractCommandFile(ace as HttpServerAceWrite, java));
				fsa.generateFile(java.packageFolder + '/commands/' + ace.commandName + '.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE,
					commandTemplate.generateInitialCommandFile(ace as HttpServerAceWrite, java));
				val aceWrite = ace as HttpServerAceWrite
				for (outcome : aceWrite.outcomes) {
					fsa.generateFile(java.packageFolder + '/events/' + ace.eventName(outcome) + '.java',
						ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
						eventTemplate.generateAbstractEventFile(ace, outcome, java));
				}
			} 
			if (ace.response.size > 0) {
				fsa.generateFile(java.packageFolder + '/data/' + ace.responseDataName + '.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
					modelTemplate.generateResponseData(ace, java));
				fsa.generateFile(java.packageFolder + '/data/' + ace.responseDataInterfaceName + '.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
					modelTemplate.generateReponseDataInterface(ace, java));
			}
		}
		for (view : java.views) {
			fsa.generateFile(java.packageFolder + '/views/' + view.viewName + '.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, eventTemplate.generateView(view, java));
			fsa.generateFile(java.packageFolder + '/views/' + view.viewInterfaceName + '.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, eventTemplate.generateViewInterface(view, java));
		}

		fsa.generateFile(java.packageFolder + '/ActionCalls.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT, actionTemplate.generateActionCalls(java));

		if (java.aceOperations.size > 0) {
			fsa.generateFile(java.packageFolder + '/events/EventFactory.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, eventTemplate.generateEventFactory(java));
		}

		if (java.aceOperations.size > 0) {
			fsa.generateFile(java.packageFolder + '/actions/AceDataFactory.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, actionTemplate.generateAceDataFactory(java));
		}

		fsa.generateFile('de/acegen/EventFactory.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, eventTemplate.generateEventFactory());

		fsa.generateFile(java.packageFolder + '/AppRegistration.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, actionTemplate.generateAppRegistration(java));

		fsa.generateFile("de/acegen" + '/App.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE,
			aceTemplate.generateApp());
		fsa.generateFile("de/acegen" + '/AppRegistration.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE,
			aceTemplate.generateAppRegistration());
		fsa.generateFile("de/acegen" + '/AppConfiguration.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateAppConfiguration());
		fsa.generateFile("de/acegen" + '/CustomAppConfiguration.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, aceTemplate.generateCustomAppConfiguration());
		fsa.generateFile("de/acegen" + '/E2E.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			aceTemplate.generateE2E());
		fsa.generateFile("de/acegen" + '/ServerConfiguration.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateServerConfiguration());
		fsa.generateFile("de/acegen" + '/StartE2ESessionResource.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateStartE2ESessionResource());
		fsa.generateFile("de/acegen" + '/StopE2ESessionResource.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateStopE2ESessionResource());
		fsa.generateFile("de/acegen" + '/AceOperation.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateAceOperation());
		fsa.generateFile("de/acegen" + '/PrepareE2EResource.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generatePrepareE2EResource());
		fsa.generateFile("de/acegen" + '/GetServerTimelineResource.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateGetServerTimelineResource());
		fsa.generateFile("de/acegen" + '/ServerInfo.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			aceTemplate.generateServerInfo());
		fsa.generateFile("de/acegen" + '/GetServerInfoResource.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateGetServerInfoResource());
		fsa.generateFile("de/acegen" + '/EventReplayCommand.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateEventReplayCommand());
		fsa.generateFile("de/acegen" + '/NotReplayableDataProvider.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateNotReplayableDataProvider());

		fsa.generateFile("de/acegen" + '/AceDao.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			aceTemplate.generateAceDao());
		fsa.generateFile("de/acegen" + '/Action.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			actionTemplate.generateAction());
		fsa.generateFile("de/acegen" + '/ReadAction.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			actionTemplate.generateReadAction());
		fsa.generateFile("de/acegen" + '/Command.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			commandTemplate.generateCommand());
		fsa.generateFile("de/acegen" + '/DatabaseHandle.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, modelTemplate.generateDatabaseHandle());
		fsa.generateFile("de/acegen" + '/Event.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			eventTemplate.generateEvent());
		fsa.generateFile("de/acegen" + '/HttpMethod.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			actionTemplate.generateHttpMethod());
		fsa.generateFile("de/acegen" + '/IAction.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			actionTemplate.generateIAction());
		fsa.generateFile("de/acegen" + '/ICommand.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			commandTemplate.generateICommand());
		fsa.generateFile("de/acegen" + '/IDataContainer.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, modelTemplate.generateIDataContainer());
		fsa.generateFile("de/acegen" + '/IEvent.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			eventTemplate.generateIEvent());
		fsa.generateFile("de/acegen" + '/ITimelineItem.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			aceTemplate.generateITimelineItem());
		fsa.generateFile("de/acegen" + '/JodaObjectMapper.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateJodaObjectMapper());
		fsa.generateFile("de/acegen" + '/TimelineItem.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			aceTemplate.generateTimelineItem());
		fsa.generateFile("de/acegen" + '/TimelineItemMapper.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateTimelineItemMapper());
		fsa.generateFile("de/acegen" + '/AbstractData.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			modelTemplate.generateAbstractData());

		fsa.generateFile("de/acegen" + '/AbstractDaoProvider.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateAbstractDaoProvider());
		fsa.generateFile("de/acegen" + '/DaoProvider.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, aceTemplate.generateDaoProvider());
		fsa.generateFile("de/acegen" + '/IDaoProvider.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, aceTemplate.generateIDaoProvider());
		fsa.generateFile("de/acegen" + '/ViewProvider.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, aceTemplate.generateViewProvider());
		fsa.generateFile("de/acegen" + '/AbstractViewProvider.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateAbstractViewProvider());
			
		fsa.generateFile("de/acegen" + '/EventConsumer.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, eventTemplate.generateEventconsumer());	

		fsa.generateFile("de/acegen" + '/DateTimeToStringConverter.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateDateTimeToStringConverter());	

		fsa.generateFile("de/acegen" + '/StringToDateTimeConverter.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateStringToDateTimeConverter());	

		fsa.generateFile("de/acegen" + '/PersistenceConnection.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generatePersistenceConnection());	
		fsa.generateFile("de/acegen" + '/PersistenceHandle.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generatePersistenceHandle());	
	
		fsa.generateFile('ace_creation.xml', ACEOutputConfigurationProvider.DEFAULT_RESOURCE_OUTPUT,
			aceTemplate.generateAceMigration());

		if (authUser !== null) {
			fsa.generateFile('de/acegen/auth/' + authUser.name.toFirstUpper + '.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
				aceTemplate.generateAuthUser(authUser));
		}
		
		fsa.generateFile('de/acegen/AbstractBaseScenario.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT, scenarioTemplate.generateAbstractBaseScenario());

		fsa.generateFile('de/acegen/BaseScenario.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT_ONCE, scenarioTemplate.generateBaseScenario());

		for (scenario : java.scenarios) {
			fsa.generateFile(java.packageFolder + '/scenarios/Abstract' + scenario.name + 'Scenario.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT, scenarioTemplate.generateAbstractScenario(scenario, java));

			fsa.generateFile(java.packageFolder + '/scenarios/' + scenario.name + 'Scenario.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_TEST_OUTPUT_ONCE, scenarioTemplate.generateScenario(scenario, java));
		}

	}

}
	
	
	
/******* S.D.G. *******/
	
	
	