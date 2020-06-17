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

import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.HttpServerAceWrite;
import de.acegen.aceGen.HttpServerOutcome;
import de.acegen.extensions.cs.AceExtension;
import de.acegen.extensions.cs.CSExtension;
import de.acegen.generator.ACEOutputConfigurationProvider;
import de.acegen.templates.cs.actions.Action;
import de.acegen.templates.cs.commands.Command;
import de.acegen.templates.cs.data.Data;
import de.acegen.templates.cs.events.Event;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class CSGenerator {
  @Inject
  private Action action;
  
  @Inject
  private Command command;
  
  @Inject
  private Event event;
  
  @Inject
  private Data data;
  
  @Inject
  @Extension
  private CSExtension _cSExtension;
  
  @Inject
  @Extension
  private AceExtension _aceExtension;
  
  public void doGenerate(final HttpServer httpServer, final IFileSystemAccess2 fsa) {
    EList<HttpServerAce> _aceOperations = httpServer.getAceOperations();
    for (final HttpServerAce ace : _aceOperations) {
      {
        String _packageFolder = this._cSExtension.packageFolder(httpServer);
        String _plus = (_packageFolder + "/Actions/");
        String _abstractActionName = this._aceExtension.abstractActionName(ace);
        String _plus_1 = (_plus + _abstractActionName);
        String _plus_2 = (_plus_1 + ".cs");
        fsa.generateFile(_plus_2, 
          ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, this.action.generateAbstractActionFile(ace, httpServer));
        String _packageFolder_1 = this._cSExtension.packageFolder(httpServer);
        String _plus_3 = (_packageFolder_1 + "/Actions/");
        String _actionName = this._aceExtension.actionName(ace);
        String _plus_4 = (_plus_3 + _actionName);
        String _plus_5 = (_plus_4 + ".cs");
        fsa.generateFile(_plus_5, 
          ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT_ONCE, 
          this.action.generateInitialActionFile(ace, httpServer));
        boolean _equals = "GET".equals(ace.getType());
        boolean _not = (!_equals);
        if (_not) {
          String _packageFolder_2 = this._cSExtension.packageFolder(httpServer);
          String _plus_6 = (_packageFolder_2 + "/Commands/");
          String _abstractCommandName = this._aceExtension.abstractCommandName(ace);
          String _plus_7 = (_plus_6 + _abstractCommandName);
          String _plus_8 = (_plus_7 + ".cs");
          fsa.generateFile(_plus_8, 
            ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, 
            this.command.generateAbstractCommandFile(((HttpServerAceWrite) ace), httpServer));
          String _packageFolder_3 = this._cSExtension.packageFolder(httpServer);
          String _plus_9 = (_packageFolder_3 + "/Commands/");
          String _commandName = this._aceExtension.commandName(ace);
          String _plus_10 = (_plus_9 + _commandName);
          String _plus_11 = (_plus_10 + ".cs");
          fsa.generateFile(_plus_11, 
            ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT_ONCE, 
            this.command.generateInitialCommandFile(((HttpServerAceWrite) ace), httpServer));
          final HttpServerAceWrite aceWrite = ((HttpServerAceWrite) ace);
          EList<HttpServerOutcome> _outcomes = aceWrite.getOutcomes();
          for (final HttpServerOutcome outcome : _outcomes) {
            String _packageFolder_4 = this._cSExtension.packageFolder(httpServer);
            String _plus_12 = (_packageFolder_4 + "/Events/");
            String _eventName = this._aceExtension.eventName(ace, outcome);
            String _plus_13 = (_plus_12 + _eventName);
            String _plus_14 = (_plus_13 + ".cs");
            fsa.generateFile(_plus_14, 
              ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, 
              this.event.generateEventFile(ace, outcome, httpServer));
          }
        }
        int _size = ace.getResponse().size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          String _packageFolder_5 = this._cSExtension.packageFolder(httpServer);
          String _plus_15 = (_packageFolder_5 + "/Data/");
          String _responseDataName = this._aceExtension.responseDataName(ace);
          String _plus_16 = (_plus_15 + _responseDataName);
          String _plus_17 = (_plus_16 + ".cs");
          fsa.generateFile(_plus_17, 
            ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, this.data.generateResponseData(ace, httpServer));
          String _packageFolder_6 = this._cSExtension.packageFolder(httpServer);
          String _plus_18 = (_packageFolder_6 + "/Data/");
          String _responseDataInterfaceName = this._aceExtension.responseDataInterfaceName(ace);
          String _plus_19 = (_plus_18 + _responseDataInterfaceName);
          String _plus_20 = (_plus_19 + ".cs");
          fsa.generateFile(_plus_20, 
            ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, 
            this.data.generateReponseDataInterface(ace, httpServer));
        }
      }
    }
    fsa.generateFile("Acegen/Action.cs", ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, 
      this.action.generateAction());
    fsa.generateFile("Acegen/ReadAction.cs", ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, 
      this.action.generateReadAction(false));
    fsa.generateFile("Acegen/ProxyReadAction.cs", ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, 
      this.action.generateReadAction(true));
    fsa.generateFile("Acegen/WriteAction.cs", ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, 
      this.action.generateWriteAction(false));
    fsa.generateFile("Acegen/ProxyWriteAction.cs", ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, 
      this.action.generateWriteAction(true));
    fsa.generateFile("Acegen/HttpMethod.cs", ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, 
      this.action.generateHttpMethod());
    fsa.generateFile("Acegen/IAction.cs", ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, 
      this.action.generateIAction());
    fsa.generateFile("Acegen/IDataContainer.cs", ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, 
      this.data.generateIDataContainer());
  }
}
