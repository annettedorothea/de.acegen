package de.acegen.generator.java

import de.acegen.aceGen.HttpServer
import de.acegen.extensions.java.JavaExtension
import de.acegen.generator.ACEOutputConfigurationProvider
import de.acegen.templates.java.AppRegistration
import javax.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess2

class AppRegistrationGenerator {

	@Inject
	AppRegistration appRegistration;

	@Inject
	extension JavaExtension

	def void doGenerate(HttpServer httpServer, IFileSystemAccess2 fsa) {
			fsa.generateFile(httpServer.packageFolder + "/AppRegistration.java",
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, appRegistration.generateAppRegistration(httpServer));
			fsa.generateFile("de/acegen/AppRegistration.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE,
				appRegistration.generateAppRegistration());
		
	}
	
}
