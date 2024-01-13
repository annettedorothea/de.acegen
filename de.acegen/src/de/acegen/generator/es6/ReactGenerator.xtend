package de.acegen.generator.es6

import de.acegen.aceGen.ClientAttribute
import de.acegen.aceGen.HttpClient
import de.acegen.extensions.es6.Es6Extension
import de.acegen.generator.ACEOutputConfigurationProvider
import de.acegen.templates.es6.JsxTemplate
import jakarta.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IFileSystemAccess

class ReactGenerator {

	@Inject
	JsxTemplate reactTemplate;

	@Inject
	extension Es6Extension

	def void doGenerate(HttpClient httpClient, IFileSystemAccess2 fsa) {
		if (httpClient.container !== null) {
			doGenerate(httpClient.container, fsa, "", true);
		}
	}

	def void doGenerate(ClientAttribute it, IFileSystemAccess2 fsa, String subFolder, boolean isRoot) {
		if (isComponent) {
			fsa.generateFile('''components«subFolder»/«componentName».js''',
				ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE,
				reactTemplate.generateComponent(it, folderPrefix(subFolder)));
			if (!isTag) {
				if (isRoot) {
					fsa.generateFile('''components«subFolder»/«componentContainerName».js''',
						IFileSystemAccess.DEFAULT_OUTPUT,
						reactTemplate.generateComponentContainer(it, folderPrefix(subFolder), true));
				} else {
					fsa.generateFile('''components«subFolder»/«componentContainerName».js''',
						IFileSystemAccess.DEFAULT_OUTPUT,
						reactTemplate.generateComponentContainer(it, folderPrefix(subFolder), false));
				}
			}
			val nextSubFolder = '''«subFolder»/«name.toFirstLower»'''
			for (attribute : attributes) {
				doGenerate(attribute, fsa, nextSubFolder, false);
			}
		}
	}

	def private String folderPrefix(String subFolder) {
		val count = subFolder.split("/").length - 1;
		var folderPrefix = "";
		for (var i = 0; i < count; i++) {
			folderPrefix += "../";
		}
		return folderPrefix;
	}
}
