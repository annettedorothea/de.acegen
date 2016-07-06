package com.anfelisa.extensions

import com.anfelisa.ace.View
import com.anfelisa.ace.RenderFunction

class ViewExtension {
	def String viewName(View it) '''«name.toFirstUpper»View'''
	def String renderFunctionWithViewName(RenderFunction it) '''«(it.eContainer as View).viewName».«name»'''
}