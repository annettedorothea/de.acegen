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
package de.acegen.generator.java;

import de.acegen.aceGen.AuthUser;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.extensions.java.AceExtension;
import de.acegen.extensions.java.JavaExtension;
import de.acegen.generator.ACEOutputConfigurationProvider;
import de.acegen.templates.java.DropwizardApp;
import de.acegen.templates.java.DropwizardAppRegistration;
import de.acegen.templates.java.DropwizardConfiguration;
import de.acegen.templates.java.DropwizardEventReplayCommand;
import de.acegen.templates.java.DropwizardResource;
import de.acegen.templates.java.resources.GetServerInfoResource;
import de.acegen.templates.java.resources.GetServerTimelineResource;
import de.acegen.templates.java.resources.NotReplayableDataProviderResource;
import de.acegen.templates.java.resources.PrepareE2EResource;
import de.acegen.templates.java.resources.Resource;
import de.acegen.templates.java.resources.StartE2ESessionResource;
import de.acegen.templates.java.resources.StopE2ESessionResource;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class DropwizardGenerator {
  @Inject
  private StartE2ESessionResource startE2ESessionResource;
  
  @Inject
  private StopE2ESessionResource stopE2ESessionResource;
  
  @Inject
  private PrepareE2EResource prepareE2EResource;
  
  @Inject
  private GetServerTimelineResource getServerTimelineResource;
  
  @Inject
  private GetServerInfoResource getServerInfoResource;
  
  @Inject
  private Resource resource;
  
  @Inject
  private DropwizardApp dropwizardApp;
  
  @Inject
  private DropwizardConfiguration dropwizardConfiguration;
  
  @Inject
  private NotReplayableDataProviderResource notReplayableDataProviderResource;
  
  @Inject
  private DropwizardEventReplayCommand dropwizardEventReplayCommand;
  
  @Inject
  private DropwizardResource dropwizardResource;
  
  @Inject
  private DropwizardAppRegistration dropwizardAppRegistration;
  
  @Inject
  @Extension
  private JavaExtension _javaExtension;
  
  @Inject
  @Extension
  private AceExtension _aceExtension;
  
  public void doGenerate(final HttpServer httpServer, final IFileSystemAccess2 fsa) {
    AuthUser authUser = httpServer.getAuthUser();
    if ((authUser == null)) {
      authUser = httpServer.getAuthUserRef();
    }
    EList<HttpServerAce> _aceOperations = httpServer.getAceOperations();
    for (final HttpServerAce ace : _aceOperations) {
      String _packageFolder = this._javaExtension.packageFolder(httpServer);
      String _plus = (_packageFolder + "/resources/");
      String _resourceName = this._aceExtension.resourceName(ace);
      String _plus_1 = (_plus + _resourceName);
      String _plus_2 = (_plus_1 + ".java");
      fsa.generateFile(_plus_2, 
        ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.resource.generate(ace, httpServer, authUser));
    }
    fsa.generateFile("de/acegen/resources/StartE2ESessionResource.java", 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.startE2ESessionResource.generate());
    fsa.generateFile("de/acegen/resources/StopE2ESessionResource.java", 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.stopE2ESessionResource.generate());
    fsa.generateFile("de/acegen/resources/PrepareE2EResource.java", 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.prepareE2EResource.generate());
    fsa.generateFile("de/acegen/resources/GetServerTimelineResource.java", 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.getServerTimelineResource.generate());
    fsa.generateFile("de/acegen/resources/GetServerInfoResource.java", 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.getServerInfoResource.generate());
    fsa.generateFile("de/acegen/resources/NotReplayableDataProviderResource.java", 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.notReplayableDataProviderResource.generate());
    fsa.generateFile("de/acegen/App.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, 
      this.dropwizardApp.generate());
    fsa.generateFile("de/acegen/CustomAppConfiguration.java", 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, this.dropwizardConfiguration.generateCustomAppConfiguration());
    fsa.generateFile("de/acegen/AppConfiguration.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.dropwizardConfiguration.generateAppConfiguration());
    fsa.generateFile("de/acegen/Config.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.dropwizardConfiguration.generateConfig());
    fsa.generateFile("de/acegen/EventReplayCommand.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.dropwizardEventReplayCommand.generateEventReplayCommand());
    fsa.generateFile("de/acegen/Resource.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.dropwizardResource.generateDropwizardResource());
    String _packageFolder_1 = this._javaExtension.packageFolder(httpServer);
    String _plus_3 = (_packageFolder_1 + "/AppRegistration.java");
    fsa.generateFile(_plus_3, 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.dropwizardAppRegistration.generateAppRegistration(httpServer));
    fsa.generateFile(("de/acegen" + "/AppRegistration.java"), ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, 
      this.dropwizardAppRegistration.generateAppRegistration());
  }
}
