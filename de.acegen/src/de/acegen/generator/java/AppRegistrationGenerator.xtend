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


package de.acegen.generator.java

import de.acegen.aceGen.HttpServer
import de.acegen.extensions.java.TypeExtension
import de.acegen.generator.ACEOutputConfigurationProvider
import de.acegen.templates.java.AppRegistration
import jakarta.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess2

class AppRegistrationGenerator {

	@Inject
	AppRegistration appRegistration;

	@Inject
	extension TypeExtension

	def void doGenerate(HttpServer httpServer, IFileSystemAccess2 fsa) {
		if (httpServer.aceOperations.size > 0) {
			fsa.generateFile(httpServer.packageFolder + "/AppRegistration.java",
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
				appRegistration.generateAppRegistration(httpServer));
		}
		fsa.generateFile("de/acegen/AppRegistration.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE,
			appRegistration.generateAppRegistration());

	}

}
