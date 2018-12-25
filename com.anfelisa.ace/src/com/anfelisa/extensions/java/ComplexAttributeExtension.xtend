package com.anfelisa.extensions.java

import com.anfelisa.ace.ComplexAttribute
import com.google.inject.Inject

class ComplexAttributeExtension {

	@Inject
	extension ModelExtension
	
	
	def String declaration(ComplexAttribute it) '''
		private «javaType» «name»;
	'''
	
	def String javaType(ComplexAttribute it) '''«IF list»java.util.List<«ENDIF»«model.modelInterfaceWithPackage»«IF list»>«ENDIF»'''

	def String param(ComplexAttribute it) '''@JsonProperty("«name»") «javaType» «name»'''

	def String name(ComplexAttribute it) '''«model.modelName»«IF list»List«ENDIF»'''
	
	def String interfaceGetter(ComplexAttribute it) '''«javaType» get«name.toFirstUpper»();'''
	
	def String getter(ComplexAttribute it) '''
		@JsonProperty
		public «javaType» get«name.toFirstUpper»() {
			return this.«name»;
		}'''
	
	def String getterCall(ComplexAttribute it) '''get«name.toFirstUpper»()'''
	
	def String setter(ComplexAttribute it) '''
		public void set«name.toFirstUpper»(«javaType» «name») {
			this.«name» = «name»;
		}'''
	
	def String initializer(ComplexAttribute it, String className) '''
		public «className» with«name.toFirstUpper»(«javaType» «name») {
			this.«name» = «name»;
			return this;
		}'''
	
	def String assign(ComplexAttribute it) '''this.«name» = «name»;'''

	def String mapperInit(ComplexAttribute it) '''null'''
	
}