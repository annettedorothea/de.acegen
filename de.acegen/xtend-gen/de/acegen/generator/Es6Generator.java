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

import de.acegen.aceGen.ClientScenario;
import de.acegen.aceGen.HttpClient;
import de.acegen.aceGen.HttpClientAce;
import de.acegen.extensions.es6.AceExtension;
import de.acegen.extensions.es6.Es6Extension;
import de.acegen.generator.es6.ReactGenerator;
import de.acegen.templates.es6.AceTemplate;
import de.acegen.templates.es6.ActionTemplate;
import de.acegen.templates.es6.CommandTemplate;
import de.acegen.templates.es6.EventTemplate;
import de.acegen.templates.es6.ScenarioTemplate;
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
  private ScenarioTemplate scenarioTemplate;
  
  @Inject
  @Extension
  private AceExtension _aceExtension;
  
  @Inject
  @Extension
  private Es6Extension _es6Extension;
  
  @Inject
  private ReactGenerator reactGenerator;
  
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
      }
    }
    int _size = httpClient.getAceOperations().size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      String _name = httpClient.getName();
      String _plus = (_name + "/EventListenerRegistration.js");
      fsa.generateFile(_plus, IFileSystemAccess.DEFAULT_OUTPUT, 
        this.eventTemplate.generateEventListenerRegistration(httpClient));
      String _name_1 = httpClient.getName();
      String _plus_1 = (_name_1 + "/ActionFunctions.js");
      fsa.generateFile(_plus_1, IFileSystemAccess.DEFAULT_OUTPUT, 
        this.actionTemplate.generateActionFunctionExports(httpClient));
      String _name_2 = httpClient.getName();
      String _plus_2 = ("actionIds/" + _name_2);
      String _plus_3 = (_plus_2 + "/");
      CharSequence _actionIdName = this._es6Extension.actionIdName(httpClient);
      String _plus_4 = (_plus_3 + _actionIdName);
      String _plus_5 = (_plus_4 + ".js");
      fsa.generateFile(_plus_5, ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_TEST_OUTPUT, 
        this.actionTemplate.generateActionIds(httpClient));
    }
    fsa.generateFile("index.js", ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE, 
      this.aceTemplate.generateApp(httpClient));
    fsa.generateFile("app/AppUtils.js", ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE, 
      this.aceTemplate.generateAppUtilsStub());
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
    fsa.generateFile("ace/TriggerAction.js", IFileSystemAccess.DEFAULT_OUTPUT, this.eventTemplate.generateTriggerAction());
    fsa.generateFile("ace/Timeline.js", IFileSystemAccess.DEFAULT_OUTPUT, this.aceTemplate.generateTimeline());
    fsa.generateFile("ace/Utils.js", IFileSystemAccess.DEFAULT_OUTPUT, this.aceTemplate.generateUtils());
    boolean _isJsx = httpClient.isJsx();
    if (_isJsx) {
      this.reactGenerator.doGenerate(httpClient, fsa);
    }
    EList<ClientScenario> _scenarios = httpClient.getScenarios();
    for (final ClientScenario scenario : _scenarios) {
      {
        String _name_3 = httpClient.getName();
        String _plus_6 = (_name_3 + "/");
        String _name_4 = scenario.getName();
        String _plus_7 = (_plus_6 + _name_4);
        String _plus_8 = (_plus_7 + ".scenario.js");
        fsa.generateFile(_plus_8, ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_TEST_OUTPUT, 
          this.scenarioTemplate.generateScenario(scenario, httpClient));
        int _size_1 = scenario.getThenBlock().getVerifications().size();
        boolean _greaterThan_1 = (_size_1 > 0);
        if (_greaterThan_1) {
          String _name_5 = httpClient.getName();
          String _plus_9 = (_name_5 + "/");
          String _name_6 = scenario.getName();
          String _plus_10 = (_plus_9 + _name_6);
          String _plus_11 = (_plus_10 + "Verifications.js");
          fsa.generateFile(_plus_11, ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_TEST_OUTPUT_ONCE, 
            this.scenarioTemplate.generateVerifications(scenario));
        }
      }
    }
    fsa.generateFile("ScenarioUtils.js", ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_TEST_OUTPUT_ONCE, this.scenarioTemplate.generateScenarioUtils());
  }
}
