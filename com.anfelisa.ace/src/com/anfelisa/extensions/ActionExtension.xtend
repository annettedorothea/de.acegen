package com.anfelisa.extensions

import com.anfelisa.ace.Action

class ActionExtension {
	def String abstractActionName(Action it) '''Abstract«name.toFirstUpper»Action'''
	def String actionName(Action it) '''«name.toFirstUpper»Action'''
}