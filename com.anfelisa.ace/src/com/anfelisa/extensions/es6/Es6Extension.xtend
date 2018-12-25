package com.anfelisa.extensions.es6

import com.anfelisa.ace.ES6
import com.anfelisa.ace.ES6_View
import java.util.ArrayList
import java.util.List

class Es6Extension {
	def String packageFolder(ES6 it) '''«name.replace('.', '/')»'''

	def String projectName(ES6 it) '''«name.toFirstUpper»'''

	def List<ES6_View> referencedViews(ES6 it) {
		var list = new ArrayList<ES6_View>();
		for (aceOperation : it.aceOperations) {
			for (outcome : aceOperation.outcomes) {
				for (listener : outcome.listeners) {
					val view = listener.eContainer as ES6_View;
					if (!list.contains(view)) {
						list.add(view);
					}
				}
			}
		}
		return list;
	}
	
}