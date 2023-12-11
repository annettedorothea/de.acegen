package de.acegen.templates.es6

import de.acegen.aceGen.ClientModel
import de.acegen.aceGen.HttpClient
import de.acegen.extensions.CommonExtension

class TypescriptTemplate {

	extension CommonExtension

	def generateModel(ClientModel it, HttpClient es6) '''
		«copyright»
		
		export default class «name» {
			
			}
			
			
			«sdg»
			
	'''

}
