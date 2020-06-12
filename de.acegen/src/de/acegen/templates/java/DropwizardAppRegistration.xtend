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
		import de.acegen.E2E;
		import de.acegen.ViewProvider;
		
		«IF aceOperations.size > 0»
			import «name».resources.*;
		«ENDIF»

		@SuppressWarnings("all")
		public class AppRegistration {
		
			public static void registerResources(Environment environment, PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
					IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
				«FOR aceOperation : aceOperations»
					environment.jersey().register(new «aceOperation.resourceName»(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e));
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
					IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
			}
		
			public static void registerConsumers(ViewProvider viewProvider, String mode) {
			}
		}
		
		«sdg»
		
	'''

	
}