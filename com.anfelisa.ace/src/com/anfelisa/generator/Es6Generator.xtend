package com.anfelisa.generator

import com.anfelisa.ace.ES6
import com.anfelisa.extensions.es6.AceExtension
import com.anfelisa.extensions.es6.ViewExtension
import com.anfelisa.templates.es6.AceTemplate
import com.anfelisa.templates.es6.ActionTemplate
import com.anfelisa.templates.es6.CommandTemplate
import com.anfelisa.templates.es6.EventTemplate
import javax.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IFileSystemAccess2

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

	@Inject
	extension ViewExtension

	def void doGenerate(ES6 es6, IFileSystemAccess2 fsa) {
		for (ace : es6.aceOperations) {
			fsa.generateFile(es6.name + '/actions/' + ace.abstractActionName + '.js', IFileSystemAccess.DEFAULT_OUTPUT,
				actionTemplate.generateAbstractActionFile(ace, es6));
			fsa.generateFile(es6.name + '/actions/' + ace.actionName + '.js',
				ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE,
				actionTemplate.generateInitialActionFile(ace, es6));
			if (ace.serverCall !== null) {
				fsa.generateFile(es6.name + '/commands/' + ace.abstractCommandName + '.js',
					IFileSystemAccess.DEFAULT_OUTPUT,
					commandTemplate.generateAsynchronousAbstractCommandFile(ace, es6));
				fsa.generateFile(es6.name + '/commands/' + ace.commandName + '.js',
					ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE,
					commandTemplate.generateAsynchronousInitialCommandFile(ace, es6));
			} else {
				fsa.generateFile(es6.name + '/commands/' + ace.abstractCommandName + '.js',
					IFileSystemAccess.DEFAULT_OUTPUT, commandTemplate.generateSynchronousAbstractCommandFile(ace, es6));
				fsa.generateFile(es6.name + '/commands/' + ace.commandName + '.js',
					ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE,
					commandTemplate.generateSynchronousInitialCommandFile(ace, es6));
			}
			for (outcome : ace.outcomes) {
				if (outcome.listeners.size > 0) {
					fsa.generateFile(es6.name + '/events/' + ace.eventName(outcome) + '.js',
						IFileSystemAccess.DEFAULT_OUTPUT, eventTemplate.generateAbstractEventFile(ace, outcome, es6));
				}
			}
		}
		fsa.generateFile(es6.name + '/EventListenerRegistration.js', IFileSystemAccess.DEFAULT_OUTPUT,
			eventTemplate.generateEventListenerRegistration(es6));
		fsa.generateFile(es6.name + '/ActionFactoryRegistration.js', IFileSystemAccess.DEFAULT_OUTPUT,
			actionTemplate.generateActionFactoryRegistration(es6));
		fsa.generateFile(es6.name + '/ActionFunctions.js', IFileSystemAccess.DEFAULT_OUTPUT,
			actionTemplate.generateActionFunctionExports(es6));
		for (view : es6.views) {
			fsa.generateFile(es6.name + '/views/' + view.viewName + '.js',
				ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE, eventTemplate.generateView(view, es6));
		}
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
	}
}
