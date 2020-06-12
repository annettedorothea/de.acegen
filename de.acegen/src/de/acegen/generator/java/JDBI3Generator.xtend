package de.acegen.generator.java

import de.acegen.aceGen.HttpServer
import de.acegen.extensions.java.JavaExtension
import de.acegen.extensions.java.ModelExtension
import de.acegen.generator.ACEOutputConfigurationProvider
import de.acegen.templates.java.models.JDBI3Dao
import de.acegen.templates.java.models.JDBI3Mapper
import javax.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess2

class JDBI3Generator {

	@Inject
	JDBI3Dao jdbi3Dao;

	@Inject
	JDBI3Mapper jdbi3Mapper;

	@Inject
	extension JavaExtension

	@Inject
	extension ModelExtension

	def void doGenerate(HttpServer httpServer, IFileSystemAccess2 fsa) {
		for (modelAce : httpServer.models) {
			fsa.generateFile(httpServer.packageFolder + '/models/' + modelAce.modelMapper + '.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, jdbi3Mapper.generate(modelAce, httpServer));
			if (modelAce.persistent) {
				fsa.generateFile(httpServer.packageFolder + '/models/' + modelAce.abstractModelDao + '.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
					jdbi3Dao.generateAbstractJdbiDao(modelAce, httpServer));
				fsa.generateFile(httpServer.packageFolder + '/models/' + modelAce.modelDao + '.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE,
					jdbi3Dao.generateJdbiDao(modelAce, httpServer));
			}
		}

	}

}
