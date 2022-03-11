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


package de.acegen.generator.cs

import de.acegen.aceGen.HttpServer
import de.acegen.extensions.cs.CsHttpServerExtension
import de.acegen.generator.ACEOutputConfigurationProvider
import de.acegen.templates.cs.controller.Controller
import de.acegen.templates.java.DropwizardApp
import de.acegen.templates.java.DropwizardAppRegistration
import de.acegen.templates.java.DropwizardConfiguration
import de.acegen.templates.java.DropwizardEventReplayCommand
import de.acegen.templates.java.DropwizardResource
import de.acegen.templates.java.FormData
import de.acegen.templates.java.resources.GetServerInfoResource
import de.acegen.templates.java.resources.SquishyDataProviderResource
import javax.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess2

class DotNetGenerator {

	@Inject
	GetServerInfoResource getServerInfoResource;

	@Inject
	Controller controller;

	@Inject
	DropwizardApp dropwizardApp;

	@Inject
	DropwizardConfiguration dropwizardConfiguration;

	@Inject
	SquishyDataProviderResource squishyDataProviderResource;

	@Inject
	DropwizardResource dropwizardResource;

	@Inject
	DropwizardAppRegistration dropwizardAppRegistration;

	@Inject
	DropwizardEventReplayCommand dropwizardEventReplayCommand;

	@Inject
	FormData formData;

	@Inject
	extension CsHttpServerExtension

	def void doGenerate(HttpServer httpServer, IFileSystemAccess2 fsa) {
		var authUser = httpServer.getAuthUser
		if (authUser === null) {
			authUser = httpServer.getAuthUserRef
		}
		fsa.generateFile(httpServer.controllerNamespace + '/Controller/' + httpServer.controllerName + fileExtension,
			ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, controller.generate(httpServer, authUser));
	/*fsa.generateFile("de/acegen/resources/GetServerInfoResource" + fileExtension,
	 * 	ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, getServerInfoResource.generate());
	 * fsa.generateFile("de/acegen/resources/SquishyDataProviderResource" + fileExtension,
	 * 	ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, squishyDataProviderResource.generate());

	 * fsa.generateFile("de/acegen/App" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT_ONCE,
	 * 	dropwizardApp.generate(authUser));
	 * fsa.generateFile("de/acegen/CustomAppConfiguration" + fileExtension,
	 * 	ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT_ONCE, dropwizardConfiguration.generateCustomAppConfiguration());
	 * fsa.generateFile("de/acegen/AppConfiguration" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
	 * 	dropwizardConfiguration.generateAppConfiguration());
	 * fsa.generateFile("de/acegen/Config" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
	 * 	dropwizardConfiguration.generateConfig());
	 * fsa.generateFile("de/acegen/Resource" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
	 * 	dropwizardResource.generateDropwizardResource());
	 * fsa.generateFile(httpServer.packageFolder + '/AppRegistration.java',
	 * 	ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, dropwizardAppRegistration.generateAppRegistration(httpServer));
	 * fsa.generateFile("de/acegen" + '/AppRegistration.java', ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT_ONCE,
	 * 	dropwizardAppRegistration.generateAppRegistration());
	 * fsa.generateFile("de/acegen/EventReplayCommand" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
	 * 	dropwizardEventReplayCommand.generateEventReplayCommand());
	 * fsa.generateFile("de/acegen/FormData" + fileExtension, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
	 formData.generate());*/
	}

}
