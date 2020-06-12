package de.acegen.generator.java

import de.acegen.aceGen.HttpServer
import de.acegen.extensions.java.JavaExtension
import de.acegen.extensions.java.ModelExtension
import de.acegen.generator.ACEOutputConfigurationProvider
import de.acegen.templates.java.models.Dao
import javax.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess2

class DaoGenerator {

	@Inject
	Dao dao;

	@Inject
	extension JavaExtension

	@Inject
	extension ModelExtension

	def void doGenerate(HttpServer httpServer, IFileSystemAccess2 fsa) {
		for (modelAce : httpServer.models) {
			if (modelAce.persistent) {
				fsa.generateFile(httpServer.packageFolder + '/models/' + modelAce.abstractModelDao + '.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, dao.generateAbstractDao(modelAce, httpServer));
				fsa.generateFile(httpServer.packageFolder + '/models/' + modelAce.modelDao + '.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, dao.generateDao(modelAce, httpServer));
			}
		}
	}

}
