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


package de.acegen.templates.java

import de.acegen.aceGen.HttpServer
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.java.AceExtension
import javax.inject.Inject

class DropwizardAppRegistration {

	@Inject
	extension CommonExtension

	@Inject
	extension AceExtension

	@Inject AppRegistration appRegistration;

	def generateAppRegistration(HttpServer it) '''
		«copyright»
		
		package «getName»;
		
		import io.dropwizard.setup.Environment;
		import de.acegen.PersistenceConnection;
		import de.acegen.CustomAppConfiguration;
		import de.acegen.IDaoProvider;
		import de.acegen.ViewProvider;
		
		«IF aceOperations.size > 0»
			import «name».resources.*;
		«ENDIF»

		@SuppressWarnings("all")
		public class AppRegistration {
		
			public static void registerResources(Environment environment, PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
					IDaoProvider daoProvider, ViewProvider viewProvider) {
				«FOR aceOperation : aceOperations»
					environment.jersey().register(new «aceOperation.resourceName»(persistenceConnection, appConfiguration, daoProvider, viewProvider));
				«ENDFOR»
			}
			
			«appRegistration.registerConsumers(it)»
		}
		
		«sdg»
		
	'''

	def generateAppRegistration() '''
		«copyright»
		
		package de.acegen;
		
			import io.dropwizard.setup.Environment;
		
		public class AppRegistration {
		
			public static void registerResources(Environment environment, PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration,
					IDaoProvider daoProvider, ViewProvider viewProvider) {
			}
		
			public static void registerConsumers(ViewProvider viewProvider) {
			}
		}
		
		«sdg»
		
	'''

	
}