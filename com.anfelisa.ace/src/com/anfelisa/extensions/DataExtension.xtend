package com.anfelisa.extensions

import com.anfelisa.ace.Attribute
import com.anfelisa.ace.Data
import java.util.List
import java.util.ArrayList

class DataExtension {
	def String dataName(Data it) '''«name.toFirstUpper»Data'''
	
	def List<Attribute> allAttributes(Data it) {
		val attrs = new ArrayList<Attribute>();
		for (model : models) {
			for (attribute : model.attributes) {
				if (!contains(attribute, attrs)) {
					attrs.add(attribute)
				}
			}
		}
		return attrs;
	}
	
	private def boolean contains(Attribute attribute, List<Attribute> attributes) {
		if (attributes.size == 0) {
			return false
		} else {
			for (attr : attributes) {
				if (attr.name.equals(attribute.name)) {
					return true
				}
			}
		}
	}
}