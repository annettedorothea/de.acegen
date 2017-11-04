package com.anfelisa.extensions

import com.anfelisa.ace.Project
import java.util.List
import com.anfelisa.ace.View
import java.util.ArrayList

class ProjectExtension {
	def String packageFolder(Project it) '''«name.replace('.', '/')»'''

	def String projectName(Project it) '''«name.toFirstUpper»'''

	def List<View> referencedViews(Project it) {
		var list = new ArrayList<View>();
		for (event : events) {
			for (listener : event.listeners) {
				val view = listener.eContainer as View;
				if (!list.contains(view)) {
					list.add(view);
				}
			}
		}
		return list;
	}

}
