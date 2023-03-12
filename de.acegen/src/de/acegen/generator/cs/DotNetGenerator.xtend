package de.acegen.generator.cs

import de.acegen.aceGen.HttpServer
import de.acegen.templates.cs.Controller
import javax.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess2
import de.acegen.extensions.cs.TypeExtension
import de.acegen.generator.ACEOutputConfigurationProvider

class DotNetGenerator {

	@Inject
	Controller controller;

	@Inject
	extension TypeExtension


	def void doGenerate(HttpServer httpServer, IFileSystemAccess2 fsa) {
		var authUser = httpServer.getAuthUser
		if (authUser === null) {
			authUser = httpServer.getAuthUserRef
		}
		fsa.generateFile(httpServer.controllerDirectory + "/" + httpServer.controllerName + ".cs",
			ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, controller.generate(httpServer, authUser));
		controller.generate(httpServer, authUser)
	}
}
