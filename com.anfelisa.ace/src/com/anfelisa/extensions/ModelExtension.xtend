package com.anfelisa.extensions

import com.anfelisa.ace.Attribute
import com.anfelisa.ace.Model
import com.anfelisa.ace.Project
import java.util.ArrayList
import java.util.List
import javax.inject.Inject

class ModelExtension {
	@Inject
	extension AttributeExtension
	
	
	def String modelName(Model it) '''I«name.toFirstUpper»Model'''
	def String modelClassName(Model it) '''«name.toFirstUpper»Model'''
	def String modelParam(Model it) '''«name.toFirstLower»Model'''
	def String modelDao(Model it) '''«name.toFirstUpper»Dao'''
	def String modelMapper(Model it) '''«name.toFirstUpper»Mapper'''
	def String table(Model it) '''«name.toLowerCase»'''
	def String importModel(Model it) '''import «(eContainer as Project).name».models.«modelName»;'''
	def Attribute findSerialAttribute(Model it) {
		for (attribute : attributes) {
			if (attribute.primaryKey) {
				return attribute;
			}
		}
	}
	def List<Attribute> allUniqueAttributes(Model it) {
		var list = new ArrayList<Attribute>();
		for (attribute : attributes) {
			if (attribute.unique) {
				list.add(attribute);
			}
		}
		return list;
	}
	def List<Attribute> allNonSerialAttributes(Model it) {
		var list = new ArrayList<Attribute>();
		for (attribute : attributes) {
			if (!attribute.primaryKey) {
				list.add(attribute);
			}
		}
		return list;
	}
}