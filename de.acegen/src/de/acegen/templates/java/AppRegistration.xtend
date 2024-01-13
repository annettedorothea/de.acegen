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
import de.acegen.aceGen.HttpServerAce
import de.acegen.aceGen.HttpServerAceRead
import de.acegen.aceGen.HttpServerAceWrite
import de.acegen.aceGen.HttpServerOutcome
import de.acegen.aceGen.HttpServerView
import de.acegen.aceGen.HttpServerViewFunction
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.java.TypeExtension
import de.acegen.extensions.java.ViewExtension
import jakarta.inject.Inject

class AppRegistration {

	@Inject
	extension ViewExtension

	@Inject
	extension CommonExtension
	
	@Inject
	extension TypeExtension
	
	def generateAppRegistration(HttpServer it) '''
		«copyright»
		
		package «name»;
		
		import de.acegen.ViewProvider;
		import de.acegen.Data;
		import io.dropwizard.setup.Environment;
		
		@SuppressWarnings("all")
		public class AppRegistration {
		
			«registerConsumers»
	
		}
		
		
		«sdg»
		
	'''
	
	def generateAppRegistration() '''
		«copyright»
		
		package de.acegen;
		
		import io.dropwizard.setup.Environment;
		
		public class AppRegistration {
		
			public static void registerConsumers(Environment environment, ViewProvider viewProvider) {
			}
		}
		
		«sdg»
		
	'''

	def registerConsumers(HttpServer it) '''
		public static void registerConsumers(Environment environment, ViewProvider viewProvider) {
			«FOR aceOperation : aceOperations»
				«registerConsumer(aceOperation, it)»
			«ENDFOR»
			
			«FOR view : it.views»
				«IF view.queued»
					environment.lifecycle().manage(viewProvider.«view.name»);
				«ENDIF»
			«ENDFOR»
		}
	'''
	
	private def dispatch registerConsumer(HttpServerAceWrite it, HttpServer httpServer) '''
		«FOR outcome : outcomes»
			«FOR listener : outcome.listeners»
				«addConsumers(httpServer, it, outcome, listener)»
			«ENDFOR»
		«ENDFOR»
	'''
	
	private def dispatch registerConsumer(HttpServerAceRead it, HttpServer httpServer) ''''''
	
	private def addConsumers(HttpServer java, HttpServerAce aceOperation, HttpServerOutcome outcome, HttpServerViewFunction listener) '''
		«val view = (listener.eContainer as HttpServerView)»
		viewProvider.addConsumer("«aceOperation.eventName(outcome)»", (data, handle) -> {
			«IF view.queued»
				viewProvider.«view.viewNameWithPackage».addToQueue(() -> viewProvider.«listener.viewFunctionWithViewNameAsVariable»((«listener.model.dataWithGenericModel») data, handle));
			«ELSE»
				viewProvider.«listener.viewFunctionWithViewNameAsVariable»((«listener.model.dataWithGenericModel») data, handle);
			«ENDIF»
		});
		
	'''
	
}