package de.acegen.generator.java

import de.acegen.aceGen.HttpServer
import de.acegen.extensions.java.AceExtension
import de.acegen.extensions.java.JavaExtension
import de.acegen.generator.ACEOutputConfigurationProvider
import de.acegen.templates.java.models.Liquibase
import javax.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess2

class LiquibaseGenerator {

	@Inject
	extension JavaExtension

	@Inject
	extension AceExtension

	@Inject
	Liquibase liquibase;

	def void doGenerate(HttpServer httpServer, IFileSystemAccess2 fsa) {
		for (modelAce : httpServer.models) {
			if (modelAce.persistent) {
				if (httpServer.liquibase) {
					fsa.generateFile(httpServer.packageFolder + '/' + modelAce.name + '_creation.xml',
						ACEOutputConfigurationProvider.DEFAULT_RESOURCE_OUTPUT,
						liquibase.generateMigration(modelAce, httpServer));
				}
			}
		}
		fsa.generateFile("ace_creation.xml", ACEOutputConfigurationProvider.DEFAULT_RESOURCE_OUTPUT,
			liquibase.generateAceMigration());
		
	}
	
}
