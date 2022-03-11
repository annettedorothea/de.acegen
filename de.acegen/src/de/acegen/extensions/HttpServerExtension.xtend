package de.acegen.extensions

import de.acegen.aceGen.HttpServerAce
import de.acegen.aceGen.HttpServerAceWrite

class HttpServerExtension {
	
	def Boolean isMulitpartFormData(HttpServerAce it) {
		return (it instanceof HttpServerAceWrite && (it as HttpServerAceWrite).isMultipartFormData)
	}

}
