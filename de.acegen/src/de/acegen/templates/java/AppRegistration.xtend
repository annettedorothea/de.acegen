package de.acegen.templates.java

import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerAce
import de.acegen.aceGen.HttpServerAceRead
import de.acegen.aceGen.HttpServerAceWrite
import de.acegen.aceGen.HttpServerOutcome
import de.acegen.aceGen.HttpServerViewFunction
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.java.AceExtension
import de.acegen.extensions.java.ModelExtension
import de.acegen.extensions.java.ViewExtension
import javax.inject.Inject

class AppRegistration {

	@Inject
	extension ModelExtension

	@Inject
	extension AceExtension

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
		
			public static void registerConsumers(ViewProvider viewProvider, String mode) {
			}
		}
		
		«sdg»
		
	'''

	def registerConsumers(HttpServer it) '''
		public static void registerConsumers(ViewProvider viewProvider, String mode) {
			«FOR aceOperation : aceOperations»
				«registerConsumer(aceOperation, it)»
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
		viewProvider.addConsumer("«java.getName».events.«aceOperation.eventName(outcome)»", (dataContainer, handle) -> {
			viewProvider.«listener.viewFunctionWithViewNameAsVariable»((«listener.getModel.dataNameWithPackage») dataContainer, handle);
		});
		
	'''

	
}