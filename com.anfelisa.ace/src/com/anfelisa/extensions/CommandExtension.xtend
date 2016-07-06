package com.anfelisa.extensions

import com.anfelisa.ace.Command

class CommandExtension {
	def String abstractCommandName(Command it) '''Abstract«name.toFirstUpper»Command'''
	def String commandName(Command it) '''«name.toFirstUpper»Command'''
}