package com.anfelisa.extensions.es6

import com.anfelisa.ace.ES6
import com.anfelisa.ace.ES6_ACE
import com.anfelisa.ace.ES6_Outcome
import com.anfelisa.ace.ES6_View
import java.util.ArrayList
import java.util.List

class AceExtension {
	def String abstractActionName(ES6_ACE it) '''Abstract«name.toFirstUpper»Action'''

	def String actionName(ES6_ACE it) '''«name.toFirstUpper»Action'''

	def String abstractName(ES6_ACE it) '''Abstract«name.toFirstUpper»'''

	def String nameUppercase(ES6_ACE it) '''«name.toFirstUpper»'''

	def String resourceName(ES6_ACE it) '''«name.toFirstUpper»Resource'''

	def String actionNameWithPackage(ES6_ACE it) '''«(eContainer as ES6).name».actions.«actionName»'''

	def List<ES6_View> preAndPostUpdateUIViews(ES6_ACE it) {
		var list = new ArrayList<ES6_View>();
		for (viewFuction : preCall) {
			val view = viewFuction.eContainer as ES6_View;
			if (!list.contains(view)) {
				list.add(view);
			}
		}
		for (viewFuction : postCall) {
			val view = viewFuction.eContainer as ES6_View;
			if (!list.contains(view)) {
				list.add(view);
			}
		}
		return list;
	}

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
		while (url.contains('{') && url.contains('}')) {
			val before = url.substring(0, url.indexOf('{'));
			val pathParam = url.substring(url.indexOf('{')+1, url.indexOf('}'));
			val after = url.substring(url.indexOf('}')+1, url.length);
			url = '''«before»this.commandData.«pathParam»«after»'''
		}
		return "/api" + url;
	}

	def String initQueryParams(ES6_ACE it) '''
		let queryParams = [];
        «FOR queryParam : serverCall.queryParams»
queryParams.push({
	key: "«queryParam.name»",
	value: this.commandData.«queryParam.name»
});
        «ENDFOR»
	'''

}
