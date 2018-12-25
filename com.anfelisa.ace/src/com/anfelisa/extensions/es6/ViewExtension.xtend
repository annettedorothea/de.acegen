package com.anfelisa.extensions.es6

import com.anfelisa.ace.ES6
import com.anfelisa.ace.ES6_View
import com.anfelisa.ace.ES6_ViewFunction

class ViewExtension {
	def String viewName(ES6_View it) '''«name.toFirstUpper»View'''

	def String viewNameWithPackage(ES6_View it) '''«(eContainer as ES6).name».views.«viewName»'''

	def String viewNameAsVariable(ES6_View it) '''«name.toFirstLower»View'''

	def String viewFunctionWithViewName(ES6_ViewFunction it) '''«(it.eContainer as ES6_View).viewName».«name»'''

	def String viewFunctionWithViewNameAsVariable(
		ES6_ViewFunction it) '''«(it.eContainer as ES6_View).viewNameAsVariable».«name»'''

	def ES6_View view(ES6_ViewFunction it) {
		return it.eContainer as ES6_View;
	}

}
