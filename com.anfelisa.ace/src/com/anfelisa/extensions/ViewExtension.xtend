package com.anfelisa.extensions

import com.anfelisa.ace.View
import com.anfelisa.ace.ViewFunction

class ViewExtension {
	def String viewName(View it) '''«name.toFirstUpper»View'''
	def String viewNameAsVariable(View it) '''«name.toFirstLower»View'''
	def String viewFunctionWithViewName(ViewFunction it) '''«(it.eContainer as View).viewName».«name»'''
	def String viewFunctionWithViewNameAsVariable(ViewFunction it) '''«(it.eContainer as View).viewName.toFirstLower».«name»'''
}