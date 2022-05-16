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
import de.acegen.extensions.java.JavaHttpServerExtension
import de.acegen.extensions.java.ModelExtension
import de.acegen.extensions.java.ViewExtension
import javax.inject.Inject

class AppRegistration {

	@Inject
	extension ModelExtension

	@Inject
	extension JavaHttpServerExtension

	@Inject
	extension ViewExtension

	@Inject
	extension CommonExtension
	
	def generateAppRegistration(HttpServer it) '''
		«copyright»
		
		package «getName»;
		
		import de.acegen.ViewProvider;
		
		@SuppressWarnings("all")
		public class AppRegistration {
		
			«registerConsumers»
	
		}
		
		
		«sdg»
		
	'''
	
	def generateAppRegistration() '''
		«copyright»
		
		package de.acegen;
		
		public class AppRegistration {
		
			public static void registerConsumers(ViewProvider viewProvider) {
			}
		}
		
		«sdg»
		
	'''

	def registerConsumers(HttpServer it) '''
		public static void registerConsumers(ViewProvider viewProvider) {
			«FOR aceOperation : aceOperations»
				«registerConsumer(aceOperation, it)»
			«ENDFOR»
		}
	'''
	
	private def dispatch registerConsumer(HttpServerAceWrite it, HttpServer httpServer) '''
		«FOR outcome : outcomes»
			«FOR listener : outcome.listeners»
				«IF (listener.eContainer as HttpServerView).afterCommit»
					«addAfterCommitConsumers(httpServer, it, outcome, listener)»
				«ELSE»
					«addConsumers(httpServer, it, outcome, listener)»
				«ENDIF»
			«ENDFOR»
		«ENDFOR»
	'''
	
	private def dispatch registerConsumer(HttpServerAceRead it, HttpServer httpServer) ''''''
	
	private def addConsumers(HttpServer java, HttpServerAce aceOperation, HttpServerOutcome outcome, HttpServerViewFunction listener) '''
		viewProvider.addConsumer("«java.getName».events.«aceOperation.eventName(outcome)»", (dataContainer, handle) -> {
			viewProvider.«listener.viewFunctionWithViewNameAsVariable»((«listener.getModel.dataNameWithPackage») dataContainer, handle);
		});
		
	'''

	private def addAfterCommitConsumers(HttpServer java, HttpServerAce aceOperation, HttpServerOutcome outcome, HttpServerViewFunction listener) '''
		viewProvider.addAfterCommitConsumer("«java.getName».events.«aceOperation.eventName(outcome)»", (dataContainer, handle) -> {
			viewProvider.«listener.viewFunctionWithViewNameAsVariable»((«listener.getModel.dataNameWithPackage») dataContainer, handle);
		});
		
	'''

	
}