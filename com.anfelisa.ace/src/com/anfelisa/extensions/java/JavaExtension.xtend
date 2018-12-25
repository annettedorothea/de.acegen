package com.anfelisa.extensions.java

import com.anfelisa.ace.JAVA
import com.anfelisa.ace.JAVA_View
import java.util.ArrayList
import java.util.List

class JavaExtension {
	def String packageFolder(JAVA it) '''«name.replace('.', '/')»'''

	def String projectName(JAVA it) '''«name.toFirstUpper»'''

	def List<JAVA_View> referencedViews(JAVA it) {
		var list = new ArrayList<JAVA_View>();
		for (aceOperation : it.aceOperations) {
			for (outcome : aceOperation.outcomes) {
				for (listener : outcome.listeners) {
					val view = listener.eContainer as JAVA_View;
					if (!list.contains(view)) {
						list.add(view);
					}
				}
			}
		}
		return list;
	}
	
}