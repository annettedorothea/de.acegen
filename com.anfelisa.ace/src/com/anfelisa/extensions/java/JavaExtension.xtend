package com.anfelisa.extensions.java

import com.anfelisa.ace.JAVA

class JavaExtension {
	def String packageFolder(JAVA it) '''«name.replace('.', '/')»'''

	def String projectName(JAVA it) '''«name.toFirstUpper»'''

}