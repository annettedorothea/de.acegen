/* 
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */
 

package de.acegen.extensions.java

import java.util.ArrayList
import javax.inject.Inject
import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerAce
import de.acegen.aceGen.HttpServerOutcome
import de.acegen.aceGen.HttpServerAceRead

class AceExtension {
	
	@Inject
	extension ModelExtension
	
	@Inject
	extension AttributeExtension
	
	def String abstractActionName(HttpServerAce it) '''Abstract«getName.toFirstUpper»Action'''
	
	def String actionName(HttpServerAce it) '''«getName.toFirstUpper»Action'''

	def String actionNameWithPackage(HttpServerAce it, HttpServer java) '''«java.getName».actions.«actionName»'''
	
	def String abstractName(HttpServerAce it) '''Abstract«getName.toFirstUpper»'''
	
	def String nameUppercase(HttpServerAce it) '''«getName.toFirstUpper»'''
	
	def String resourceName(HttpServerAce it) '''«getName.toFirstUpper»Resource'''

	def String actionNameWithPackage(HttpServerAce it) '''«(eContainer as HttpServer).getName».actions.«actionName»'''
	
	def String newAction(HttpServerAce it) '''final «actionNameWithPackage» action = new «actionNameWithPackage»(«getModel.newFromCommandData», DatabaseService.getDatabaseHandle());'''
	
	def String abstractCommandName(HttpServerAce it) '''Abstract«getName.toFirstUpper»Command'''

	def String commandName(HttpServerAce it) '''«getName.toFirstUpper»Command'''

	def String commandNameWithPackage(HttpServerAce it, HttpServer java) '''«java.getName».commands.«commandName»'''

	def String eventName(HttpServerAce it, HttpServerOutcome outcome) '''«getName.toFirstUpper»«outcome.getName.toFirstUpper»Event'''

	def String eventNameWithPackage(HttpServerAce it, HttpServerOutcome outcome) '''«(eContainer as HttpServer).getName».events.«eventName(outcome)»'''

	def String responseDataName(HttpServerAce it) '''«getName.toFirstUpper»Response'''
	
	def String responseDataNameWithPackage(HttpServerAce it, HttpServer httpServer) '''«httpServer.name».data.«getName.toFirstUpper»Response'''
	
	def String responseDataInterfaceName(HttpServerAce it) '''I«name.toFirstUpper»Response'''

	def boolean isRead(HttpServerAce it) {
		return it instanceof HttpServerAceRead
	}
	
	def String packageFor(HttpServerAce it) {
		val java = eContainer as HttpServer;
		return '''«java.getName»'''
	}
	
	def String urlWithPathParams(HttpServerAce  it, String dataVarName, boolean generateQueryParams) {
		if (pathParams.size == 0) {
			var retUrl = url + '''«IF generateQueryParams»?uuid=" + «dataVarName».getUuid() + "«FOR queryParam : queryParams»&«queryParam.attribute.name»=" + «dataVarName».«queryParam.attribute.getterCall» + "«ENDFOR»«ENDIF»'''
			return retUrl
		}
		val split1 = getUrl.split('\\{')
		var urlElements = new ArrayList();
		for (split : split1) {
			val split2 = split.split('\\}');
			urlElements.addAll(split2)
		}
		var urlWithPathParam = "";
		for (var i=0; i<urlElements.size; i++) {
			if (i%2 == 0) {
				urlWithPathParam += urlElements.get(i)
			} else {
				urlWithPathParam += '''" + «dataVarName».get«urlElements.get(i).toFirstUpper»() + "'''
			}
		}
		urlWithPathParam += '''«IF generateQueryParams»?uuid=" + «dataVarName».getUuid() + "«FOR queryParam : queryParams»&«queryParam.attribute.name»=" + «dataVarName».«queryParam.attribute.getterCall» + "«ENDFOR»«ENDIF»'''
		return urlWithPathParam ;
	}
	
	def boolean isDropwizard(HttpServer it) {
		return it.type == "Dropwizard"
	}
	
	def boolean isJDBI3(HttpServer it) {
		return it.persistenceLayer == "JDBI3"
	}
	
	def boolean isLiquibase(HttpServer it) {
		return it.migrations == "Liquibase"
	}
	
}
	
	
/******* S.D.G. *******/
	
	
