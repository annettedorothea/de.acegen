package com.anfelisa.extensions.java

import com.anfelisa.ace.Attribute
import com.anfelisa.ace.JAVA
import com.anfelisa.ace.Model
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
	def String abstractModelDao(Model it) '''Abstract«name.toFirstUpper»Dao'''
	
	def String modelMapper(Model it) '''«name.toFirstUpper»Mapper'''
	
	def String table(Model it) '''«name.toLowerCase»'''
	
	def String importModel(Model it) '''import «interfaceWithPackage»;'''
	
	def String interfaceWithPackage(Model it) '''«(eContainer as JAVA).name».models.«modelName»'''
	
	def String modelGetAttribute(Model it, Attribute attribute) 
	''' «modelParam».«attribute.getterCall» '''
	
	def String modelAttributeSqlValue(Model it, Attribute attribute) 
	''':«attribute.name.toLowerCase»'''
	
	def List<Attribute> allUniqueAttributes(Model it) {
		var list = new ArrayList<Attribute>();
		for (attribute : attributes) {
			if (attribute.unique) {
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
	
	def String interfaceGetter(Model it) '''«interfaceWithPackage» get«modelRefToUpper»();'''
	
	def String declaration(Model it) '''
		private «interfaceWithPackage» «modelRefToLower»;
	'''
	
	def String getter(Model it) '''
		@JsonProperty
		public «interfaceWithPackage» get«modelRefToUpper»() {
			return this.«modelRefToLower»;
		}'''
	
	def String setter(Model it) '''
		public void set«modelRefToUpper»(«interfaceWithPackage» «modelRefToLower») {
			this.«modelRefToLower» = «modelRefToLower»;
		}'''
	
	def List<Attribute> allAttributes(Model it) {
		val attrs = new ArrayList<Attribute>();
		allAttributesRec(attrs);
		return attrs;
	}
	
	def void allAttributesRec(Model it, List<Attribute> attrs) {
		for (attribute : attributes) {
			if (!attrs.containsAttribute(attribute)) {
				attrs.add(attribute)
			}
		}
		for(superModel : superModels) {
			superModel.allAttributesRec(attrs);
		}
	}
	
	def String modelRefToLower(Model it) '''«name.toFirstLower»'''
	
	def String modelRefToUpper(Model it) '''«name.toFirstUpper»'''
	
	def String dataName(Model it) '''«IF it !== null»«name.toFirstUpper»Data«ELSE»IDataContainer«ENDIF»'''
	def String abstractDataName(Model it) '''«IF it !== null»Abstract«name.toFirstUpper»Data«ELSE»IDataContainer«ENDIF»'''
	def String dataInterfaceName(Model it) '''«IF it !== null»I«name.toFirstUpper»Data«ELSE»IDataContainer«ENDIF»'''
	def String dataNameWithPackage(Model it) '''«(eContainer as JAVA).name».data.«name.toFirstUpper»Data'''
	def String dataInterfaceNameWithPackage(Model it) '''«(eContainer as JAVA).name».data.«dataInterfaceName»'''
	
	def String dataImport(Model it) '''
		«IF it !== null»
			import «(eContainer as JAVA).name».data.«dataInterfaceName»;
		«ELSE»
			import com.anfelisa.ace.IDataContainer;
		«ENDIF»
	'''
	def String dataClassImport(Model it) '''
		«IF it !== null»
			import «(eContainer as JAVA).name».data.«dataName»;
		«ELSE»
			import com.anfelisa.ace.IDataContainer;
		«ENDIF»
	'''
	
	def String dataParamType(Model it) '''«IF it !== null»«dataInterfaceName»«ELSE»IDataContainer«ENDIF»'''
	
	def boolean containsAttribute(List<Attribute> it, Attribute attribute) {
		if (size == 0) {
			return false
		} else {
			for (attr : it) {
				if (attr.name.equals(attribute.name)) {
					return true
				}
			}
		}
	}
	
	def newFromCommandData(Model it) '''new «dataNameWithPackage»(
			«FOR attribute : allAttributes SEPARATOR ',' AFTER ','»
				this.commandData.«attribute.getterCall»
			«ENDFOR»
			this.commandData.getUuid()
		)'''
	
}