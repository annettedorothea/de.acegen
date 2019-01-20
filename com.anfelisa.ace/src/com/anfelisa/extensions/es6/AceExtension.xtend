package com.anfelisa.extensions.es6

import com.anfelisa.ace.ES6
import com.anfelisa.ace.ES6_ACE
import com.anfelisa.ace.ES6_Outcome
import java.util.ArrayList
import java.util.List

class AceExtension {
	def String abstractActionName(ES6_ACE it) '''Abstract«name.toFirstUpper»Action'''

	def String actionName(ES6_ACE it) '''«name.toFirstUpper»Action'''

	def String abstractName(ES6_ACE it) '''Abstract«name.toFirstUpper»'''

	def String nameUppercase(ES6_ACE it) '''«name.toFirstUpper»'''

	def String resourceName(ES6_ACE it) '''«name.toFirstUpper»Resource'''

	def String actionNameWithPackage(ES6_ACE it) '''«(eContainer as ES6).name».actions.«actionName»'''

	def String abstractCommandName(ES6_ACE it) '''Abstract«name.toFirstUpper»Command'''

	def String commandName(ES6_ACE it) '''«name.toFirstUpper»Command'''

	def List<ES6_ACE> triggeredAceOperations(ES6_ACE it) {
		var list = new ArrayList<ES6_ACE>();
		for (outcome : outcomes) {
			for (aceOperation : outcome.aceOperations) {
				if (!list.contains(aceOperation)) {
					list.add(aceOperation);
				}
			}
		}
		return list;
	}

	def String eventName(ES6_ACE it, ES6_Outcome outcome) '''«name.toFirstUpper»«outcome.name.toFirstUpper»Event'''

	def String eventNameWithPackage(ES6_ACE it,
		ES6_Outcome outcome) '''«(eContainer as ES6).name».events.«eventName(outcome)»'''

	def String httpCall(ES6_ACE it) '''«IF serverCall.type == "DELETE"»httpDelete«ELSEIF serverCall.type == "POST"»httpPost«ELSEIF serverCall.type == "PUT"»httpPut«ELSE»httpGet«ENDIF»'''

	def String httpUrl(ES6_ACE it) {
		var url = serverCall.url;
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
		return "/api" + urlWithPathParam;
	}

}
