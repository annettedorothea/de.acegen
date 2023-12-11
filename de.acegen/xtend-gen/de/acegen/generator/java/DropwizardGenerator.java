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
import de.acegen.extensions.java.TypeExtension;
import de.acegen.generator.ACEOutputConfigurationProvider;
import de.acegen.templates.java.DropwizardApp;
import de.acegen.templates.java.DropwizardAppRegistration;
import de.acegen.templates.java.DropwizardConfiguration;
import de.acegen.templates.java.DropwizardResource;
import de.acegen.templates.java.FormData;
import de.acegen.templates.java.resources.GetServerInfoResource;
import de.acegen.templates.java.resources.Resource;
import de.acegen.templates.java.resources.SquishyDataProviderResource;
import de.acegen.templates.java.views.QueuedView;
import jakarta.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class DropwizardGenerator {
  @Inject
  private GetServerInfoResource getServerInfoResource;

  @Inject
  private Resource resource;

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
  private FormData formData;

  @Inject
  private QueuedView queuedView;

  @Extension
  private TypeExtension _typeExtension;

  public void doGenerate(final HttpServer httpServer, final IFileSystemAccess2 fsa) {
    AuthUser authUser = httpServer.getAuthUser();
    if ((authUser == null)) {
      authUser = httpServer.getAuthUserRef();
    }
    EList<HttpServerAce> _aceOperations = httpServer.getAceOperations();
    for (final HttpServerAce ace : _aceOperations) {
      String _packageFolder = this._typeExtension.packageFolder(httpServer);
      String _plus = (_packageFolder + "/resources/");
      String _resourceName = this._typeExtension.resourceName(ace);
      String _plus_1 = (_plus + _resourceName);
      String _plus_2 = (_plus_1 + ".java");
      fsa.generateFile(_plus_2, 
        ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.resource.generate(ace, httpServer, authUser));
    }
    fsa.generateFile("de/acegen/resources/GetServerInfoResource.java", 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.getServerInfoResource.generate());
    fsa.generateFile("de/acegen/resources/SquishyDataProviderResource.java", 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.squishyDataProviderResource.generate());
    fsa.generateFile("de/acegen/App.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, 
      this.dropwizardApp.generate(authUser));
    fsa.generateFile("de/acegen/CustomAppConfiguration.java", 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, this.dropwizardConfiguration.generateCustomAppConfiguration());
    fsa.generateFile("de/acegen/AppConfiguration.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.dropwizardConfiguration.generateAppConfiguration());
    fsa.generateFile("de/acegen/Config.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.dropwizardConfiguration.generateConfig());
    fsa.generateFile("de/acegen/Resource.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.dropwizardResource.generateDropwizardResource());
    String _packageFolder_1 = this._typeExtension.packageFolder(httpServer);
    String _plus_3 = (_packageFolder_1 + "/AppRegistration.java");
    fsa.generateFile(_plus_3, 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.dropwizardAppRegistration.generateAppRegistration(httpServer));
    fsa.generateFile(("de/acegen" + "/AppRegistration.java"), ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, 
      this.dropwizardAppRegistration.generateAppRegistration());
    fsa.generateFile("de/acegen/FormData.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.formData.generate());
    fsa.generateFile("de/acegen/QueuedView.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
      this.queuedView.generate());
  }
}
