package com.anfelisa.extensions

import com.anfelisa.ace.View
import com.anfelisa.ace.ViewFunction
import com.anfelisa.ace.Project

class ViewExtension {
	def String viewName(View it) '''«name.toFirstUpper»View'''
	def String viewNameWithPackage(View it) '''«(eContainer as Project).name».views.«viewName»'''
	def String viewNameAsVariable(View it) '''«name.toFirstLower»View'''
	def String viewFunctionWithViewName(ViewFunction it) '''«(it.eContainer as View).viewName».«name»'''
	def View view(ViewFunction it) {
		return it.eContainer as View;
	}
}