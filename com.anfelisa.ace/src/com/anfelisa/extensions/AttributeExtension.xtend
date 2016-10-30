package com.anfelisa.extensions

import com.anfelisa.ace.Attribute

class AttributeExtension {
	
	def String declaration(Attribute it) '''
		«IF constraint != null»
			@«constraint»
		«ENDIF»
		private «javaType» «name»;
	'''
	
	def String javaType(Attribute it) '''«IF type.equals('Serial')»Long«ELSE»«type»«ENDIF»'''

	def String sqlType(Attribute it) {
		switch type {
      		case 'Serial' : "serial"
      		case 'Integer' : "integer"
      		case 'String' : "character varying"
      		case 'Float' : "numeric"
      		case 'Boolean' : "boolean"
      		case 'DateTime' : "timestamp with time zone"
    	}
	}
	
	def String mapperInit(Attribute it) '''r.get«javaType»("«name»")'''

	def String param(Attribute it) '''@JsonProperty("«name»") «javaType» «name»'''
	
	def String bind(Attribute it, String modelName) '''
		statement.bind("«name»", «modelName».get«name.toFirstUpper»());
	'''
	
	def String tableDefinition(Attribute it) '''«name» «sqlType» «IF unique.equals('NotNull') || unique.equals('NotEmpty')»NOT NULL «ENDIF»'''
	
	def String primaryKey(Attribute it, String tableName) '''«IF type.equals('Serial')», CONSTRAINT «tableName»_pkey PRIMARY KEY («name»)«ENDIF»'''
	
	def boolean primaryKey(Attribute it) {
		return type.equals('Serial');
	}
	
	def String uniqueConstraint(Attribute it, String tableName) '''«IF unique», CONSTRAINT «tableName»_«name»_unique UNIQUE («name»)«ENDIF»'''

	def String interfaceGetter(Attribute it) '''«javaType» get«name.toFirstUpper»();'''
	
	def String getter(Attribute it) '''
		@JsonProperty
		public «javaType» get«name.toFirstUpper»() {
			return this.«name»;
		}'''
	
	def String getterCall(Attribute it) '''get«name.toFirstUpper»()'''
	
	def String setter(Attribute it) '''
		public void set«name.toFirstUpper»(«javaType» «name») {
			this.«name» = «name»;
		}'''
	
	def String assign(Attribute it) '''this.«name» = «name»;'''
	
}