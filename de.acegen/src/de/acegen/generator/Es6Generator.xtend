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

import de.acegen.extensions.es6.AceExtension
import de.acegen.templates.es6.AceTemplate
import de.acegen.templates.es6.ActionTemplate
import de.acegen.templates.es6.CommandTemplate
import de.acegen.templates.es6.EventTemplate
import javax.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IFileSystemAccess2
import de.acegen.aceGen.HttpClient

class Es6Generator {
	@Inject
	ActionTemplate actionTemplate;

	@Inject
	CommandTemplate commandTemplate;

	@Inject
	EventTemplate eventTemplate;

	@Inject
	AceTemplate aceTemplate;

	@Inject
	extension AceExtension

	def void doGenerate(HttpClient httpClient, IFileSystemAccess2 fsa) {
		for (ace : httpClient.aceOperations) {
			fsa.generateFile(httpClient.getName + '/actions/' + ace.abstractActionName + '.js', IFileSystemAccess.DEFAULT_OUTPUT,
				actionTemplate.generateAbstractActionFile(ace, httpClient));
			fsa.generateFile(httpClient.getName + '/actions/' + ace.actionName + '.js',
				ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE,
				actionTemplate.generateInitialActionFile(ace, httpClient));
			if (ace.getServerCall !== null || ace.isAsync) {
				fsa.generateFile(httpClient.getName + '/commands/' + ace.abstractCommandName + '.js',
					IFileSystemAccess.DEFAULT_OUTPUT,
					commandTemplate.generateAsynchronousAbstractCommandFile(ace, httpClient));
				fsa.generateFile(httpClient.getName + '/commands/' + ace.commandName + '.js',
					ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE,
					commandTemplate.generateAsynchronousInitialCommandFile(ace, httpClient));
			} else {
				fsa.generateFile(httpClient.getName + '/commands/' + ace.abstractCommandName + '.js',
					IFileSystemAccess.DEFAULT_OUTPUT, commandTemplate.generateSynchronousAbstractCommandFile(ace, httpClient));
				fsa.generateFile(httpClient.getName + '/commands/' + ace.commandName + '.js',
					ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE,
					commandTemplate.generateSynchronousInitialCommandFile(ace, httpClient));
			}
			for (outcome : ace.outcomes) {
				if (outcome.listeners.size > 0) {
					fsa.generateFile(httpClient.getName + '/events/' + ace.eventName(outcome) + '.js',
						IFileSystemAccess.DEFAULT_OUTPUT, eventTemplate.generateAbstractEventFile(ace, outcome, httpClient));
				}
			}
		}
		fsa.generateFile(httpClient.getName + '/EventListenerRegistration.js', IFileSystemAccess.DEFAULT_OUTPUT,
			eventTemplate.generateEventListenerRegistration(httpClient));
		fsa.generateFile(httpClient.getName + '/ActionFactoryRegistration.js', IFileSystemAccess.DEFAULT_OUTPUT,
			actionTemplate.generateActionFactoryRegistration(httpClient));
		fsa.generateFile(httpClient.getName + '/ActionFunctions.js', IFileSystemAccess.DEFAULT_OUTPUT,
			actionTemplate.generateActionFunctionExports(httpClient));
		fsa.generateFile('app/App.js', ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE,
			aceTemplate.generateAppStub());
		fsa.generateFile('app/AppUtils.js', ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE,
			aceTemplate.generateAppUtilsStub());
		fsa.generateFile('app/ReplayUtils.js', ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE,
			aceTemplate.generateReplayUtilsStub());
		fsa.generateFile('ace/Action.js', IFileSystemAccess.DEFAULT_OUTPUT, actionTemplate.generateAction());
		fsa.generateFile('ace/AsynchronousAction.js', IFileSystemAccess.DEFAULT_OUTPUT,
			actionTemplate.generateAsynchronousAction());
		fsa.generateFile('ace/SynchronousAction.js', IFileSystemAccess.DEFAULT_OUTPUT,
			actionTemplate.generateSynchronousAction());
		fsa.generateFile('ace/Command.js', IFileSystemAccess.DEFAULT_OUTPUT, commandTemplate.generateCommand());
		fsa.generateFile('ace/AbstractAsynchronousCommand.js', IFileSystemAccess.DEFAULT_OUTPUT,
			commandTemplate.generateAbstractAsynchronousCommand());
		fsa.generateFile('ace/AsynchronousCommand.js', ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE,
			commandTemplate.generateAsynchronousCommand());
		fsa.generateFile('ace/AbstractSynchronousCommand.js', IFileSystemAccess.DEFAULT_OUTPUT,
			commandTemplate.generateAbstractSynchronousCommand());
		fsa.generateFile('ace/Event.js', IFileSystemAccess.DEFAULT_OUTPUT, eventTemplate.generateEvent());
		fsa.generateFile('ace/ACEController.js', IFileSystemAccess.DEFAULT_OUTPUT, aceTemplate.generateACEController());
		fsa.generateFile('ace/TriggerAction.js', IFileSystemAccess.DEFAULT_OUTPUT, aceTemplate.generateTriggerAction());
		fsa.generateFile('ace/Scenario.js', IFileSystemAccess.DEFAULT_OUTPUT, aceTemplate.generateScenario());
		fsa.generateFile('ace/Bug.js', IFileSystemAccess.DEFAULT_OUTPUT, aceTemplate.generateBug());
		fsa.generateFile('ace/Utils.js', IFileSystemAccess.DEFAULT_OUTPUT, aceTemplate.generateUtils());
		if (httpClient.appStatePresent && httpClient.getAppState !== null && httpClient.getAppState.size > 0) {
			fsa.generateFile('ace/AppState.js', IFileSystemAccess.DEFAULT_OUTPUT,
				aceTemplate.generateAppState(httpClient.getAppState, ""));
		}
		
	}
}
	
	
/******* S.D.G. *******/
	
	
