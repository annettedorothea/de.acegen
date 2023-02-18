package de.acegen.extensions.java

import de.acegen.aceGen.Attribute
import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerAce
import de.acegen.aceGen.HttpServerAceWrite
import de.acegen.aceGen.Model

class EcoreExtension {
	
	def HttpServer parent(Model it) {return eContainer as HttpServer}
	
	def Model parent(Attribute it) {return eContainer as Model}

	def HttpServer parent(HttpServerAce it) {return eContainer as HttpServer}
	
	def Boolean isMulitpartFormData(HttpServerAce it) {
		return (it instanceof HttpServerAceWrite && (it as HttpServerAceWrite).isMultipartFormData)
	}

	
}