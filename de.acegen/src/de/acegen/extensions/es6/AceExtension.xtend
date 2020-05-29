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
 

package de.acegen.extensions.es6

import java.util.ArrayList
import java.util.List
import de.acegen.aceGen.HttpClientAce
import de.acegen.aceGen.HttpClientOutcome
import de.acegen.aceGen.HttpClient

class AceExtension {
	
	def String abstractActionName(HttpClientAce it) '''Abstract«getName.toFirstUpper»Action'''

	def String actionName(HttpClientAce it) '''«getName.toFirstUpper»Action'''

	def String abstractName(HttpClientAce it) '''Abstract«getName.toFirstUpper»'''

	def String nameUppercase(HttpClientAce it) '''«getName.toFirstUpper»'''

	def String resourceName(HttpClientAce it) '''«getName.toFirstUpper»Resource'''

	def String actionNameWithPackage(HttpClientAce it) '''«(eContainer as HttpClient).getName».actions.«actionName»'''

	def String abstractCommandName(HttpClientAce it) '''Abstract«getName.toFirstUpper»Command'''

	def String commandName(HttpClientAce it) '''«getName.toFirstUpper»Command'''

	def List<HttpClientAce> triggeredAceOperations(HttpClientAce it) {
		var list = new ArrayList<HttpClientAce>();
		for (outcome : outcomes) {
			for (aceOperation : outcome.aceOperations) {
				if (!list.contains(aceOperation)) {
					list.add(aceOperation);
				}
			}
		}
		return list;
	}

	def String eventName(HttpClientAce it, HttpClientOutcome outcome) '''«getName.toFirstUpper»«outcome.getName.toFirstUpper»Event'''

	def String eventNameWithPackage(HttpClientAce it,
		HttpClientOutcome outcome) '''«(eContainer as HttpClient).getName».events.«eventName(outcome)»'''

	def String httpCall(HttpClientAce it) '''«IF getServerCall.getType == "DELETE"»httpDelete«ELSEIF getServerCall.getType == "POST"»httpPost«ELSEIF getServerCall.getType == "PUT"»httpPut«ELSE»httpGet«ENDIF»'''

	def String httpUrl(HttpClientAce it) {
		var url = getServerCall.getUrl;
		val split1 = url.split('\\{')
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
				urlWithPathParam += '''${this.commandData.«urlElements.get(i)»}'''
			}
		}
		return "/${Utils.getRootPath()}" + urlWithPathParam;
	}

}

	
	
/******* S.D.G. *******/
	
	
