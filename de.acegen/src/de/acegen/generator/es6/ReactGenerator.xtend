package de.acegen.generator.es6

import de.acegen.aceGen.GroupedClientAttribute
import de.acegen.aceGen.HttpClient
import de.acegen.aceGen.SingleClientAttribute
import de.acegen.extensions.es6.Es6Extension
import de.acegen.generator.ACEOutputConfigurationProvider
import de.acegen.templates.es6.ReactTemplate
import java.util.ArrayList
import java.util.List
import javax.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess2

class ReactGenerator {

	@Inject
	ReactTemplate reactTemplate;

	@Inject
	extension Es6Extension
	
	def void doGenerate(HttpClient httpClient, IFileSystemAccess2 fsa) {
		if (httpClient.container !== null) {
			fsa.generateFile('''components/ReactHelper.js''', IFileSystemAccess2.DEFAULT_OUTPUT,
				reactTemplate.generateReactHelper(httpClient));
			doGenerate(httpClient.container, fsa, "", false, new ArrayList);
		}
	}

	def dispatch void doGenerate(SingleClientAttribute it, IFileSystemAccess2 fsa, String subFolder, boolean isGroupedChild, List<SingleClientAttribute> passOnAttributes) {
		if (attributes.size > 0 || isGroupedChild) {
			fsa.generateFile('''components«subFolder»/«reactComponentName».js''', IFileSystemAccess2.DEFAULT_OUTPUT,
				reactTemplate.generateComponent(it, subFolder, folderPrefix(subFolder)));
			fsa.generateFile('''components«subFolder»/«componentName».js''', ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE,
				reactTemplate.generateComponentStruct(it, folderPrefix(subFolder), passOnAttributes));
			val nextSubFolder = '''«subFolder»/«name.toFirstLower»'''
			for (attribute : attributes) {
				doGenerate(attribute, fsa, nextSubFolder, false, passOnAttributes);
			}
		}
	}

	def dispatch void doGenerate(GroupedClientAttribute it, IFileSystemAccess2 fsa, String subFolder, boolean isGroupedChild, List<SingleClientAttribute> passOnAttributes) {
		fsa.generateFile('''components«subFolder»/«reactComponentName».js''', IFileSystemAccess2.DEFAULT_OUTPUT,
			reactTemplate.generateComponent(it, subFolder, folderPrefix(subFolder)));
		fsa.generateFile('''components«subFolder»/«componentName».js''', ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE,
			reactTemplate.generateComponentStruct(it, folderPrefix(subFolder), passOnAttributes));
		val nextSubFolder = '''«subFolder»/«name.toFirstLower»'''
		for (attribute : attributeGroup) {
			doGenerate(attribute, fsa, nextSubFolder, true, passOnAttributes);
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
