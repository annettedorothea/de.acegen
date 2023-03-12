package de.acegen.templates.cs.data

import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerAce
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.cs.TypeExtension
import javax.inject.Inject
import de.acegen.extensions.cs.AttributeExtension

class Data {
	
	@Inject
	extension AttributeExtension

	@Inject
	extension CommonExtension

	@Inject
	extension TypeExtension

	def generateResponseData(HttpServerAce it, HttpServer httpServer) '''
		«copyright»
		
		namespace «httpServer.dataNamespace»;
		
		public class «responseDataName» {
			
			«FOR attribute : response»
				«attribute.declaration»
				
			«ENDFOR»
			
			public «responseDataName»(«model.modelClassNameWithPackage» model) {
				«FOR attribute : response»
					«attribute.propertyName» = model.«attribute.propertyName»;
				«ENDFOR»
			}
			
		}
		
		«sdg»
		
	'''

	def generatePayloadData(HttpServerAce it, HttpServer httpServer) '''
		«copyright»
		
		namespace «httpServer.dataNamespace»;
		
		public class «payloadDataName» {
			
			«FOR attributeRef : payload»
				«attributeRef.attribute.declaration»
				
			«ENDFOR»
			
		}
		
		«sdg»
		
	'''
}
