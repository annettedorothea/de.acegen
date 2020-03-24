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
		fsa.generateFile('ace/AsynchronousCommand.js', IFileSystemAccess.DEFAULT_OUTPUT,
			commandTemplate.generateAsynchronousCommand());
		fsa.generateFile('ace/SynchronousCommand.js', IFileSystemAccess.DEFAULT_OUTPUT,
			commandTemplate.generateSynchronousCommand());
		fsa.generateFile('ace/Event.js', IFileSystemAccess.DEFAULT_OUTPUT, eventTemplate.generateEvent());
		fsa.generateFile('ace/ACEController.js', IFileSystemAccess.DEFAULT_OUTPUT, aceTemplate.generateACEController());
		fsa.generateFile('ace/TriggerAction.js', IFileSystemAccess.DEFAULT_OUTPUT, aceTemplate.generateTriggerAction());
		fsa.generateFile('ace/Scenario.js', IFileSystemAccess.DEFAULT_OUTPUT, aceTemplate.generateScenario());
		fsa.generateFile('ace/Bug.js', IFileSystemAccess.DEFAULT_OUTPUT, aceTemplate.generateBug());
		fsa.generateFile('ace/Utils.js', IFileSystemAccess.DEFAULT_OUTPUT, aceTemplate.generateUtils());
		if (httpClient.getAppState !== null) {
			fsa.generateFile('ace/WriteAppState.js', IFileSystemAccess.DEFAULT_OUTPUT,
				aceTemplate.generateWriteAppState(httpClient.getAppState, ""));
			fsa.generateFile('ace/ReadAppState.js', IFileSystemAccess.DEFAULT_OUTPUT,
				aceTemplate.generateReadAppState(httpClient.getAppState, ""));
		}
		
	}
}
	
	
/******* S.D.G. *******/
	
	
