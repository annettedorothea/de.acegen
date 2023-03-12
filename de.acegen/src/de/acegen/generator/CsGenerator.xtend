package de.acegen.generator

import de.acegen.aceGen.HttpServer
import de.acegen.generator.cs.DotNetGenerator
import de.acegen.generator.cs.EntityFrameworkGenerator
import javax.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess2
import de.acegen.extensions.cs.TypeExtension
import de.acegen.templates.cs.data.Data
import de.acegen.templates.cs.models.Model

class CsGenerator {

	@Inject
	EntityFrameworkGenerator entityFrameworkGenerator;

	@Inject
	DotNetGenerator dotNetGenerator;

	@Inject
	extension TypeExtension

	@Inject
	Data data;

	@Inject
	Model model;

	def void doGenerate(HttpServer httpServer, IFileSystemAccess2 fsa) {
		if (httpServer.EF) {
			entityFrameworkGenerator.doGenerate(httpServer, fsa)
		}
		if (httpServer.dotnet) {
			dotNetGenerator.doGenerate(httpServer, fsa)
		}
		for (ace : httpServer.aceOperations) {
			if (ace.response.size > 0) {
				fsa.generateFile(httpServer.dataDirectory + "/" + ace.responseDataName + ".cs",
					ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, data.generateResponseData(ace, httpServer));
			}
			if (ace.payload.size > 0) {
				fsa.generateFile(httpServer.dataDirectory + "/" + ace.payloadDataName + ".cs",
					ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, data.generatePayloadData(ace, httpServer));
			}
		}
		for (modelAce : httpServer.models) {
			fsa.generateFile(httpServer.modelDirectory + "/" + modelAce.modelClassName + ".cs",
				ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, model.generateClass(modelAce, httpServer));
		}

		fsa.generateFile(httpServer.acegenDirectory + "/AbstractModel.cs", ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			model.generateAbstractModel(httpServer));

	}
}
