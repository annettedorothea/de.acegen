package de.acegen.generator.es6

import de.acegen.aceGen.ClientAttribute
import de.acegen.aceGen.HttpClient
import de.acegen.extensions.es6.Es6Extension
import de.acegen.generator.ACEOutputConfigurationProvider
import de.acegen.templates.es6.JsxTemplate
import javax.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess2

class ReactGenerator {

	@Inject
	JsxTemplate reactTemplate;

	@Inject
	extension Es6Extension

	def void doGenerate(HttpClient httpClient, IFileSystemAccess2 fsa) {
		if (httpClient.container !== null) {
			doGenerate(httpClient.container, fsa, "", false);
		}
	}

	def void doGenerate(ClientAttribute it, IFileSystemAccess2 fsa, String subFolder,
		boolean isGroupedChild) {
		if (!noComponent && (attributes.size > 0 || isGroupedChild)) {
			fsa.generateFile('''components«subFolder»/«componentName».js''',
				ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE,
				reactTemplate.generateComponentStruct(it, folderPrefix(subFolder)));
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
