package com.anfelisa.extensions

import com.anfelisa.ace.Action
import com.anfelisa.ace.Project

class ActionExtension {
	def String abstractActionName(Action it) '''Abstract«name.toFirstUpper»Action'''
	def String actionName(Action it) '''«name.toFirstUpper»Action'''
	def String abstractName(Action it) '''Abstract«name.toFirstUpper»'''
	def String nameUppercase(Action it) '''«name.toFirstUpper»'''
	def String resourceName(Action it) '''«name.toFirstUpper»Resource'''
	def String actionNameWithPackage(Action it) '''«(eContainer as Project).name».actions.«actionName»'''
}