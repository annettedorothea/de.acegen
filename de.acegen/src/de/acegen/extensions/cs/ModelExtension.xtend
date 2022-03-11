/********************************************************************************
 * Copyright (c) 2020 Annette Pohl
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 ********************************************************************************/


 

package de.acegen.extensions.cs

import de.acegen.aceGen.Attribute
import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.Model
import java.util.ArrayList
import java.util.List
import javax.inject.Inject

class ModelExtension {

	@Inject
	extension AttributeExtension
		
	def String modelName(Model it) '''I«name.toFirstUpper»Model'''

	def String modelListAttributeName(Model it) '''«name»List'''
	
	def String modelClassName(Model it) '''«name.toFirstUpper»Model'''
	
	def String modelClassNameWithPackage(Model it) '''«(eContainer as HttpServer).getName».Models.«name.toFirstUpper»Model'''
	
	def String modelParam(Model it) '''«name.toFirstLower»Model'''
	
	def String modelDao(Model it) '''«name.toFirstUpper»Dao'''

	def String modelDaoWithPackage(Model it) '''«(eContainer as HttpServer).getName».models.«modelDao»'''
	
	def String abstractModelDao(Model it) '''Abstract«name.toFirstUpper»Dao'''
	
	def String modelMapper(Model it) '''«name.toFirstUpper»Mapper'''
	
	def String table(Model it) '''\"«name.toLowerCase»\"'''
	
	def String tableFkRef(Model it) '''«name.toLowerCase»'''
	
	def String importModel(Model it) '''using «interfacePackage»;'''
	
	def String interfaceWithPackage(Model it) '''«(eContainer as HttpServer).getName».Models.«modelName»'''

	def String interfacePackage(Model it) '''«(eContainer as HttpServer).getName».Models'''
	
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
	
	def List<Attribute> allPrimaryKeyAttributes(Model it) {
		var list = new ArrayList<Attribute>();
		for (attribute : attributes) {
			if (attribute.primaryKey) {
				list.add(attribute);
			}
		}
		return list;
	}
	
	def List<Attribute> allSquishyAttributes(Model it) {
		var list = new ArrayList<Attribute>()
		if (it === null) {
			return list
		} 
		var allAttributes = new ArrayList<Attribute>()
		allAttributesRec(allAttributes)
		for (attribute : allAttributes) {
			if (attribute.squishy) {
				list.add(attribute);
			}
		}
		return list;
	}
	
	def boolean containsPrimitiveAttributes(Model it) {
		for (attribute : attributes) {
			if (attribute.isPrimitive) {
				return true;
			}
		}
		return false;
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
	
	def String formDataAttributeName(Model it) {
		for (attr : attributes) {
			if (attr.type == "FormData") {
				return attr.name
			}
		} 
		return "formData"
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
	
	def List<Model> allSuperModels(Model it) {
		val models = new ArrayList<Model>();
		allSupperModelsRec(models);
		return models;
	}
	
	def void allSupperModelsRec(Model it, List<Model> models) {
		if (!models.containsModel(it)) {
			models.add(it)
		}
		for(superModel : superModels) {
			superModel.allSupperModelsRec(models);
		}
	}
	
	def String modelRefToLower(Model it) '''«name.toFirstLower»'''
	
	def String modelRefToUpper(Model it) '''«name.toFirstUpper»'''
	
	def String dataName(Model it) '''«IF it !== null»«name.toFirstUpper»Data«ELSE»IDataContainer«ENDIF»'''
	
	def String abstractDataName(Model it) '''«IF it !== null»Abstract«name.toFirstUpper»Data«ELSE»IDataContainer«ENDIF»'''
	
	def String dataInterfaceName(Model it) '''«IF it !== null»I«name.toFirstUpper»Data«ELSE»IDataContainer«ENDIF»'''
	
	def String dataNameWithPackage(Model it) '''«IF it !== null»«(eContainer as HttpServer).getName».data.«dataName»«ENDIF»'''
	
	def String dataInterfaceNameWithPackage(Model it) '''«(eContainer as HttpServer).getName».data.«dataInterfaceName»'''
	
	def String dataImport(Model it) '''
		«IF it !== null»
			import «(eContainer as HttpServer).getName».data.«dataInterfaceName»;
		«ELSE»
			import de.acegen.IDataContainer;
		«ENDIF»
	'''
	def String dataClassImport(Model it) '''
		«IF it !== null»
			import «(eContainer as HttpServer).getName».data.«dataName»;
		«ELSE»
			import de.acegen.IDataContainer;
		«ENDIF»
	'''
	
	def String dataParamType(Model it) '''«IF it !== null»«dataInterfaceName»«ELSE»IDataContainer«ENDIF»'''
	
	def boolean containsAttribute(List<Attribute> it, Attribute attribute) {
		if (size == 0) {
			return false
		} else {
			for (attr : it) {
				if (attr.name !== null && attribute.name !== null && attr.name.equals(attribute.name)) {
					return true
				}
			}
		}
		return false;
	}
	
	def boolean containsModel(List<Model> it, Model model) {
		if (size == 0) {
			return false
		} else {
			for (m : it) {
				if (m.name.equals(model.name)) {
					return true
				}
			}
		}
		return false;
	}
	
}
	
	
/******* S.D.G. *******/
	
	
