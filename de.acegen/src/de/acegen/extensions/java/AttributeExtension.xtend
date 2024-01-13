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




package de.acegen.extensions.java

import de.acegen.aceGen.Attribute
import de.acegen.aceGen.Model
import jakarta.inject.Inject

class AttributeExtension {

	@Inject
	extension TypeExtension;
	
	def String propertyName(Attribute it) {return name.toFirstLower} 

	def String declaration(Attribute it) '''
			private «javaType» «propertyName»;
		'''
		
	def String getterName(Attribute it) '''get«name.toFirstUpper»'''
	
	def String setterName(Attribute it) '''set«name.toFirstUpper»'''

	def String getter(Attribute it) '''
		public «javaType» «getterName»() {
			return this.«propertyName»;
		}
	'''
	
	def String setter(Attribute it) '''
		public void «setterName»(«javaType» «propertyName») {
			this.«propertyName» = «propertyName»;
		}
	'''
	
	def String setterWithFrozen(Attribute it) '''
		public void «setterName»(«javaType» «propertyName») {
			if (this.frozen) {
				throw new RuntimeException("«propertyName» is frozen");
			}
			this.«propertyName» = «propertyName»;
		}
	'''
	

	def String jsonProperty(Attribute it) '''
		@JsonProperty
		«IF type !== null && type.equals('DateTime')»@JsonSerialize(converter = DateTimeToStringConverter.class)
		@JsonDeserialize(converter = StringToDateTimeConverter.class)«ENDIF»
	'''
	
	def String randomValue(Attribute it) {
		if (type !== null) {
			switch type {
				case 'Integer': "random.nextInt(50)"
				case 'Long': "random.nextLong()"
				case 'String': "randomString(random)"
				case 'Float': "random.nextFloat()"
				case 'Boolean': "random.nextBoolean()"
				case 'DateTime': "random.nextBoolean() ? java.time.LocalDateTime.now().plusMinutes(random.nextInt(60)) : java.time.LocalDateTime.now().minusMinutes(random.nextInt(60)) "
				case 'FormData': "null"
			}
		}
	}

	def String paramAsJsonProperty(Attribute it) '''@JsonProperty("«name»") «param»'''

	def String assign(Attribute it) '''this.«propertyName» = «propertyName»;'''

	def String param(Attribute it) '''«javaType» «propertyName»'''
	
	def String formDataAttributeName(Model it) {
		for (attr : attributes) {
			if (attr.type == "FormData") {
				return attr.name
			}
		} 
		return "formData"
	}
	
	

}
/******* S.D.G. *******/
