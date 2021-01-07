package de.acegen.generator.es6

import de.acegen.aceGen.GroupedClientAttribute
import de.acegen.aceGen.HttpClient
import de.acegen.aceGen.SingleClientAttribute
import de.acegen.extensions.es6.Es6Extension
import de.acegen.generator.ACEOutputConfigurationProvider
import de.acegen.templates.es6.ReactTemplate
import javax.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess2

class ReactGenerator {

	@Inject
	ReactTemplate reactTemplate;

	@Inject
	extension Es6Extension
	
	def void doGenerate(HttpClient httpClient, IFileSystemAccess2 fsa) {
		if (httpClient.uiPresent && httpClient.getUi !== null && httpClient.getUi.size > 0) {
			fsa.generateFile('''components/ReactHelper.js''', IFileSystemAccess2.DEFAULT_OUTPUT,
				reactTemplate.generateReactHelper(httpClient));
			fsa.generateFile('''components/ContainerComponent.js''', IFileSystemAccess2.DEFAULT_OUTPUT,
				reactTemplate.generateContainer());
			fsa.generateFile('''components/Container.js''', ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE,
				reactTemplate.generateComponentStruct(null, ""));
			for (attribute : httpClient.getUi) {
				doGenerate(attribute, fsa, "");
			}
		}
	}

	def dispatch void doGenerate(SingleClientAttribute it, IFileSystemAccess2 fsa, String subFolder) {
		if (attributes.size > 0) {
			fsa.generateFile('''components«subFolder»/«reactComponentName».js''', IFileSystemAccess2.DEFAULT_OUTPUT,
				reactTemplate.generateComponent(it, subFolder, folderPrefix(subFolder)));
			fsa.generateFile('''components«subFolder»/«componentName».js''', ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE,
				reactTemplate.generateComponentStruct(it, folderPrefix(subFolder)));
			val nextSubFolder = '''«subFolder»/«name.toFirstLower»'''
			for (attribute : attributes) {
				doGenerate(attribute, fsa, nextSubFolder);
			}
		}
	}

	def dispatch void doGenerate(GroupedClientAttribute it, IFileSystemAccess2 fsa, String subFolder) {
		fsa.generateFile('''components«subFolder»/«reactComponentName».js''', IFileSystemAccess2.DEFAULT_OUTPUT,
			reactTemplate.generateComponent(it, subFolder, folderPrefix(subFolder)));
		fsa.generateFile('''components«subFolder»/«componentName».js''', ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE,
			reactTemplate.generateComponentStruct(it, folderPrefix(subFolder)));
		val nextSubFolder = '''«subFolder»/«name.toFirstLower»'''
		if (attributeGroup.size > 0) {
			for (attribute : attributeGroup) {
				doGenerate(attribute, fsa, nextSubFolder);
			}
		}
	}
	
	def private String folderPrefix(String subFolder) {
		val count = subFolder.split("/").length - 1;
		var folderPrefix = "";
		for (var i=0; i<count; i++) {
			folderPrefix += "../";
		}
		return folderPrefix;
	}
}
