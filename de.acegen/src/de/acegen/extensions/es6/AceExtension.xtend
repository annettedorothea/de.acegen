/********************************************************************************
 * Copyright (c) 2020 Annette Pohl
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 ********************************************************************************/


 

package de.acegen.extensions.es6

import java.util.ArrayList
import java.util.List
import de.acegen.aceGen.HttpClientAce
import de.acegen.aceGen.HttpClientOutcome
import de.acegen.aceGen.HttpClient
import de.acegen.aceGen.HttpClientStateFunction

class AceExtension {
	
	def String abstractActionName(HttpClientAce it) '''Abstract«getName.toFirstUpper»Action'''

	def String actionName(HttpClientAce it) '''«getName.toFirstUpper»Action'''

	def String abstractName(HttpClientAce it) '''Abstract«getName.toFirstUpper»'''

	def String nameUppercase(HttpClientAce it) '''«getName.toFirstUpper»'''

	def String resourceName(HttpClientAce it) '''«getName.toFirstUpper»Resource'''

	def String actionNameWithPackage(HttpClientAce it) '''«(eContainer as HttpClient).getName».actions.«actionName»'''

	def String abstractCommandName(HttpClientAce it) '''Abstract«getName.toFirstUpper»Command'''

	def String commandName(HttpClientAce it) '''«getName.toFirstUpper»Command'''

	def List<HttpClientAce> aggregatedTriggeredAceOperations(HttpClientAce it) {
		var list = new ArrayList<HttpClientAce>();
		for (outcome : outcomes) {
			for (triggerdAceOperation : outcome.triggerdAceOperations) {
				if (!list.contains(triggerdAceOperation.aceOperation)) {
					list.add(triggerdAceOperation.aceOperation);
				}
			}
		}
		return list;
	}

	def List<HttpClientStateFunction> aggregatedListeners(HttpClientAce it) {
		var list = new ArrayList<HttpClientStateFunction>();
		for (outcome : outcomes) {
			for (listener : outcome.listeners) {
				if (!list.contains(listener)) {
					list.add(listener);
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
		if (url.indexOf('/') != 0) {
			url = "/" + url
		} 
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
				urlWithPathParam += '''${data.«urlElements.get(i)»}'''
			}
		}
		return "${Utils.settings.rootPath}" + urlWithPathParam;
	}

}

	
	
/******* S.D.G. *******/
	
	
