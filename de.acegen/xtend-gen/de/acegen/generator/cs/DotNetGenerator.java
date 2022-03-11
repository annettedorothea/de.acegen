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
package de.acegen.generator.cs;

import de.acegen.aceGen.AuthUser;
import de.acegen.aceGen.HttpServer;
import de.acegen.extensions.cs.CsHttpServerExtension;
import de.acegen.generator.ACEOutputConfigurationProvider;
import de.acegen.templates.cs.controller.Controller;
import de.acegen.templates.java.DropwizardApp;
import de.acegen.templates.java.DropwizardAppRegistration;
import de.acegen.templates.java.DropwizardConfiguration;
import de.acegen.templates.java.DropwizardEventReplayCommand;
import de.acegen.templates.java.DropwizardResource;
import de.acegen.templates.java.FormData;
import de.acegen.templates.java.resources.GetServerInfoResource;
import de.acegen.templates.java.resources.SquishyDataProviderResource;
import javax.inject.Inject;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class DotNetGenerator {
  @Inject
  private GetServerInfoResource getServerInfoResource;
  
  @Inject
  private Controller controller;
  
  @Inject
  private DropwizardApp dropwizardApp;
  
  @Inject
  private DropwizardConfiguration dropwizardConfiguration;
  
  @Inject
  private SquishyDataProviderResource squishyDataProviderResource;
  
  @Inject
  private DropwizardResource dropwizardResource;
  
  @Inject
  private DropwizardAppRegistration dropwizardAppRegistration;
  
  @Inject
  private DropwizardEventReplayCommand dropwizardEventReplayCommand;
  
  @Inject
  private FormData formData;
  
  @Inject
  @Extension
  private CsHttpServerExtension _csHttpServerExtension;
  
  public void doGenerate(final HttpServer httpServer, final IFileSystemAccess2 fsa) {
    AuthUser authUser = httpServer.getAuthUser();
    if ((authUser == null)) {
      authUser = httpServer.getAuthUserRef();
    }
    String _controllerNamespace = this._csHttpServerExtension.controllerNamespace(httpServer);
    String _plus = (_controllerNamespace + "/Controller/");
    String _controllerName = this._csHttpServerExtension.controllerName(httpServer);
    String _plus_1 = (_plus + _controllerName);
    String _fileExtension = this._csHttpServerExtension.fileExtension();
    String _plus_2 = (_plus_1 + _fileExtension);
    fsa.generateFile(_plus_2, 
      ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, this.controller.generate(httpServer, authUser));
  }
}
