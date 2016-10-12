package com.anfelisa.extensions

import com.anfelisa.ace.Project

class ProjectExtension {
	def String packageFolder(Project it) '''«name.replace('.', '/')»'''
	def String projectName(Project it) '''«name.toFirstUpper»'''
}