package com.anfelisa.extensions.java

import com.anfelisa.ace.JAVA
import com.anfelisa.ace.JAVA_View
import com.anfelisa.ace.JAVA_ViewFunction

class ViewExtension {
	def String viewName(JAVA_View it) '''«name.toFirstUpper»View'''
	def String viewInterfaceName(JAVA_View it) '''I«name.toFirstUpper»View'''
	def String viewNameWithPackage(JAVA_View it) '''«(eContainer as JAVA).name».views.«viewName»'''
	def String viewNameAsVariable(JAVA_View it) '''«name.toFirstLower»View'''
	def String viewFunctionWithViewName(JAVA_ViewFunction it) '''«(it.eContainer as JAVA_View).viewName».«name»'''
	def String viewFunctionWithViewNameAsVariable(JAVA_ViewFunction it) '''«(it.eContainer as JAVA_View).viewNameAsVariable».«name»'''
	def JAVA_View view(JAVA_ViewFunction it) {
		return it.eContainer as JAVA_View;
	}
	
}