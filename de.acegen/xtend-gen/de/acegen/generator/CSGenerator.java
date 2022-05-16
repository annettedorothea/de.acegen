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
import de.acegen.extensions.cs.AceExtension;
import de.acegen.extensions.cs.CSExtension;
import de.acegen.templates.cs.Configuration;
import de.acegen.templates.cs.actions.Action;
import de.acegen.templates.cs.commands.Command;
import de.acegen.templates.cs.data.Data;
import de.acegen.templates.cs.events.Event;
import de.acegen.templates.cs.models.Dao;
import javax.inject.Inject;
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
  private Dao dao;
  
  @Inject
  private Configuration configuration;
  
  @Inject
  @Extension
  private CSExtension _cSExtension;
  
  @Inject
  @Extension
  private AceExtension _aceExtension;
  
  public void doGenerate(final HttpServer httpServer, final IFileSystemAccess2 fsa) {
    fsa.generateFile("Acegen/Action.cs", ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, 
      this.action.generateAction());
    fsa.generateFile("Acegen/IAction.cs", ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, 
      this.action.generateIAction());
    fsa.generateFile("Acegen/IDataContainer.cs", ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, 
      this.data.generateIDataContainer());
    fsa.generateFile("Acegen/AbstractData.cs", ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, 
      this.data.generateAbstractData());
    fsa.generateFile("Acegen/CustomAppConfiguration.cs", 
      ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT_ONCE, this.configuration.generateCustomAppConfiguration());
    fsa.generateFile("Acegen/AppConfiguration.cs", ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, 
      this.configuration.generateAppConfiguration());
    fsa.generateFile("Acegen/Config.cs", ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, 
      this.configuration.generateConfig());
  }
}
