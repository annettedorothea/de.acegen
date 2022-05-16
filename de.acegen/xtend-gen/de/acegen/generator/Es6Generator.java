/**
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 * 
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */
package de.acegen.generator;

import de.acegen.aceGen.HttpClient;
import de.acegen.aceGen.HttpClientAce;
import de.acegen.aceGen.HttpClientOutcome;
import de.acegen.aceGen.HttpClientStateElement;
import de.acegen.extensions.es6.AceExtension;
import de.acegen.templates.es6.AceTemplate;
import de.acegen.templates.es6.ActionTemplate;
import de.acegen.templates.es6.CommandTemplate;
import de.acegen.templates.es6.EventTemplate;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class Es6Generator {
  @Inject
  private ActionTemplate actionTemplate;
  
  @Inject
  private CommandTemplate commandTemplate;
  
  @Inject
  private EventTemplate eventTemplate;
  
  @Inject
  private AceTemplate aceTemplate;
  
  @Inject
  @Extension
  private AceExtension _aceExtension;
  
  public void doGenerate(final HttpClient httpClient, final IFileSystemAccess2 fsa) {
    EList<HttpClientAce> _aceOperations = httpClient.getAceOperations();
    for (final HttpClientAce ace : _aceOperations) {
      {
        String _name = httpClient.getName();
        String _plus = (_name + "/actions/");
        String _abstractActionName = this._aceExtension.abstractActionName(ace);
        String _plus_1 = (_plus + _abstractActionName);
        String _plus_2 = (_plus_1 + ".js");
        fsa.generateFile(_plus_2, IFileSystemAccess.DEFAULT_OUTPUT, 
          this.actionTemplate.generateAbstractActionFile(ace, httpClient));
        String _name_1 = httpClient.getName();
        String _plus_3 = (_name_1 + "/actions/");
        String _actionName = this._aceExtension.actionName(ace);
        String _plus_4 = (_plus_3 + _actionName);
        String _plus_5 = (_plus_4 + ".js");
        fsa.generateFile(_plus_5, 
          ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE, 
          this.actionTemplate.generateInitialActionFile(ace, httpClient));
        if (((ace.getServerCall() != null) || ace.isAsync())) {
          String _name_2 = httpClient.getName();
          String _plus_6 = (_name_2 + "/commands/");
          String _abstractCommandName = this._aceExtension.abstractCommandName(ace);
          String _plus_7 = (_plus_6 + _abstractCommandName);
          String _plus_8 = (_plus_7 + ".js");
          fsa.generateFile(_plus_8, 
            IFileSystemAccess.DEFAULT_OUTPUT, 
            this.commandTemplate.generateAsynchronousAbstractCommandFile(ace, httpClient));
          String _name_3 = httpClient.getName();
          String _plus_9 = (_name_3 + "/commands/");
          String _commandName = this._aceExtension.commandName(ace);
          String _plus_10 = (_plus_9 + _commandName);
          String _plus_11 = (_plus_10 + ".js");
          fsa.generateFile(_plus_11, 
            ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE, 
            this.commandTemplate.generateAsynchronousInitialCommandFile(ace, httpClient));
        } else {
          String _name_4 = httpClient.getName();
          String _plus_12 = (_name_4 + "/commands/");
          String _abstractCommandName_1 = this._aceExtension.abstractCommandName(ace);
          String _plus_13 = (_plus_12 + _abstractCommandName_1);
          String _plus_14 = (_plus_13 + ".js");
          fsa.generateFile(_plus_14, 
            IFileSystemAccess.DEFAULT_OUTPUT, this.commandTemplate.generateSynchronousAbstractCommandFile(ace, httpClient));
          String _name_5 = httpClient.getName();
          String _plus_15 = (_name_5 + "/commands/");
          String _commandName_1 = this._aceExtension.commandName(ace);
          String _plus_16 = (_plus_15 + _commandName_1);
          String _plus_17 = (_plus_16 + ".js");
          fsa.generateFile(_plus_17, 
            ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE, 
            this.commandTemplate.generateSynchronousInitialCommandFile(ace, httpClient));
        }
        EList<HttpClientOutcome> _outcomes = ace.getOutcomes();
        for (final HttpClientOutcome outcome : _outcomes) {
          int _size = outcome.getListeners().size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            String _name_6 = httpClient.getName();
            String _plus_18 = (_name_6 + "/events/");
            String _eventName = this._aceExtension.eventName(ace, outcome);
            String _plus_19 = (_plus_18 + _eventName);
            String _plus_20 = (_plus_19 + ".js");
            fsa.generateFile(_plus_20, 
              IFileSystemAccess.DEFAULT_OUTPUT, this.eventTemplate.generateAbstractEventFile(ace, outcome, httpClient));
          }
        }
      }
    }
    String _name = httpClient.getName();
    String _plus = (_name + "/EventListenerRegistration.js");
    fsa.generateFile(_plus, IFileSystemAccess.DEFAULT_OUTPUT, 
      this.eventTemplate.generateEventListenerRegistration(httpClient));
    String _name_1 = httpClient.getName();
    String _plus_1 = (_name_1 + "/ActionFactoryRegistration.js");
    fsa.generateFile(_plus_1, IFileSystemAccess.DEFAULT_OUTPUT, 
      this.actionTemplate.generateActionFactoryRegistration(httpClient));
    String _name_2 = httpClient.getName();
    String _plus_2 = (_name_2 + "/ActionFunctions.js");
    fsa.generateFile(_plus_2, IFileSystemAccess.DEFAULT_OUTPUT, 
      this.actionTemplate.generateActionFunctionExports(httpClient));
    fsa.generateFile("app/App.js", ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE, 
      this.aceTemplate.generateAppStub());
    fsa.generateFile("app/AppUtils.js", ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE, 
      this.aceTemplate.generateAppUtilsStub());
    fsa.generateFile("app/ReplayUtils.js", ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE, 
      this.aceTemplate.generateReplayUtilsStub());
    fsa.generateFile("ace/Action.js", IFileSystemAccess.DEFAULT_OUTPUT, this.actionTemplate.generateAction());
    fsa.generateFile("ace/AsynchronousAction.js", IFileSystemAccess.DEFAULT_OUTPUT, 
      this.actionTemplate.generateAsynchronousAction());
    fsa.generateFile("ace/SynchronousAction.js", IFileSystemAccess.DEFAULT_OUTPUT, 
      this.actionTemplate.generateSynchronousAction());
    fsa.generateFile("ace/Command.js", IFileSystemAccess.DEFAULT_OUTPUT, this.commandTemplate.generateCommand());
    fsa.generateFile("ace/AsynchronousCommand.js", IFileSystemAccess.DEFAULT_OUTPUT, 
      this.commandTemplate.generateAsynchronousCommand());
    fsa.generateFile("ace/SynchronousCommand.js", IFileSystemAccess.DEFAULT_OUTPUT, 
      this.commandTemplate.generateSynchronousCommand());
    fsa.generateFile("ace/Event.js", IFileSystemAccess.DEFAULT_OUTPUT, this.eventTemplate.generateEvent());
    fsa.generateFile("ace/ACEController.js", IFileSystemAccess.DEFAULT_OUTPUT, this.aceTemplate.generateACEController());
    fsa.generateFile("ace/TriggerAction.js", IFileSystemAccess.DEFAULT_OUTPUT, this.aceTemplate.generateTriggerAction());
    fsa.generateFile("ace/Scenario.js", IFileSystemAccess.DEFAULT_OUTPUT, this.aceTemplate.generateScenario());
    fsa.generateFile("ace/Bug.js", IFileSystemAccess.DEFAULT_OUTPUT, this.aceTemplate.generateBug());
    fsa.generateFile("ace/Utils.js", IFileSystemAccess.DEFAULT_OUTPUT, this.aceTemplate.generateUtils());
    HttpClientStateElement _appState = httpClient.getAppState();
    boolean _tripleNotEquals = (_appState != null);
    if (_tripleNotEquals) {
      fsa.generateFile("ace/WriteAppState.js", IFileSystemAccess.DEFAULT_OUTPUT, 
        this.aceTemplate.generateWriteAppState(httpClient.getAppState(), ""));
      fsa.generateFile("ace/ReadAppState.js", IFileSystemAccess.DEFAULT_OUTPUT, 
        this.aceTemplate.generateReadAppState(httpClient.getAppState(), ""));
    }
  }
}
