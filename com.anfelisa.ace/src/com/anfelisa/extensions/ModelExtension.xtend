package com.anfelisa.extensions

import com.anfelisa.ace.Attribute
import com.anfelisa.ace.Model
import com.anfelisa.ace.ModelRef
import com.anfelisa.ace.Project
import java.util.ArrayList
import java.util.List
import javax.inject.Inject

class ModelExtension {

	@Inject
	extension AttributeExtension
		
	def String modelName(Model it) '''I«name.toFirstUpper»Model'''

	def String modelListAttributeName(Model it) '''«name»List'''
	
	def String modelClassName(Model it) '''«name.toFirstUpper»Model'''
	
	def String modelParam(Model it) '''«name.toFirstLower»Model'''
	
	def String modelDao(Model it) '''«name.toFirstUpper»Dao'''
	
	def String modelMapper(Model it) '''«name.toFirstUpper»Mapper'''
	
	def String table(Model it) '''«name.toLowerCase»'''
	
	def String importModel(Model it) '''import «modelInterfaceWithPackage»;'''
	
	def String modelInterfaceWithPackage(Model it) '''«(eContainer as Project).name».models.«modelName»'''
	
	def String modelGetAttribute(Model it, Attribute attribute) 
	'''«IF attribute.type.equals("Encrypted")»EncryptionService.encrypt(«ENDIF» «modelParam».«attribute.getterCall» «IF attribute.type.equals("Encrypted")»)«ENDIF»'''
	
	def String modelAttributeSqlValue(Model it, Project project, Attribute attribute) 
	'''«IF attribute.type.equals("Serial")» (SELECT COALESCE(MAX(«attribute.name.toLowerCase»),0) + 1 FROM «project.schema».«table»)«ELSE»:«attribute.name.toLowerCase»«ENDIF»'''
	
	def Attribute findPrimaryKeyAttribute(Model it) {
		var primaryKeys = attributes.filter[a | a.primaryKey];
		if (primaryKeys.size == 1) {
			return primaryKeys.get(0);
		}
		return null;
	}
	
	def Attribute findSerialAttribute(Model it) {
		for (attribute : attributes) {
			if (attribute.type == 'Serial') {
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
			if (!'Serial'.equals(attribute.type)) {
				list.add(attribute);
			}
		}
		return list;
	}
	
	def String listGetter(Model it) '''
		@JsonProperty
		public java.util.List<«modelName»> get«modelListAttributeName.toFirstUpper»() {
			return this.«modelListAttributeName»;
		}'''
	
	def String listSetter(Model it) '''
		public void set«modelListAttributeName.toFirstUpper»(java.util.List<«modelName»> «modelListAttributeName») {
			this.«modelListAttributeName» = «modelListAttributeName»;
		}'''
	
	def String interfaceGetter(ModelRef it) '''«interfaceWithPackage» get«modelRefToUpper»();'''
	
	def String declaration(ModelRef it) '''
		private «interfaceWithPackage» «modelRefToLower»;
	'''
	
	def String interfaceWithPackage(ModelRef it) '''«model.modelInterfaceWithPackage»'''
	
	def String getter(ModelRef it) '''
		@JsonProperty
		public «interfaceWithPackage» get«modelRefToUpper»() {
			return this.«modelRefToLower»;
		}'''
	
	def String setter(ModelRef it) '''
		public void set«modelRefToUpper»(«interfaceWithPackage» «modelRefToLower») {
			this.«modelRefToLower» = «modelRefToLower»;
		}'''
	
	def String modelRefToLower(ModelRef it) '''«model.name.toFirstLower»'''
	
	def String modelRefToUpper(ModelRef it) '''«model.name.toFirstUpper»'''
	
}