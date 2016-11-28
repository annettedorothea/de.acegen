package com.anfelisa.extensions

import com.anfelisa.ace.Attribute
import com.anfelisa.ace.Model
import com.google.inject.Inject

class AttributeExtension {

	@Inject
	extension ModelExtension
	
	
	def String declaration(Attribute it) '''
		«IF constraint != null»
			@«constraint»
		«ENDIF»
		private «javaType» «name»;
	'''
	
	def String javaType(Attribute it) '''«IF type.equals('Serial')»Integer«ELSEIF type.equals('DateTime')»org.joda.time.DateTime«ELSE»«type»«ENDIF»'''

	def String sqlType(Attribute it) {
		switch type {
      		case 'Serial' : "serial"
      		case 'Integer' : "integer"
      		case 'Long' : "bigint"
      		case 'String' : "character varying"
      		case 'Float' : "numeric"
      		case 'Boolean' : "boolean"
      		case 'DateTime' : "timestamp with time zone"
    	}
	}
	
	def String mapperInit(Attribute it) '''«IF type.equals("DateTime")»new DateTime(r.getDate("«name»"))«ELSEIF type.equals("Integer")»r.getInt("«name»")«ELSEIF type.equals("Serial")»r.getInt("«name»")«ELSE»r.get«javaType»("«name»")«ENDIF»'''

	def String param(Attribute it) '''@JsonProperty("«name»") «javaType» «name»'''
	
	def String bind(Attribute it, String modelName) '''
		statement.bind("«name»", «modelName».get«name.toFirstUpper»());
	'''
	
	def String tableName(Attribute it) '''«(eContainer as Model).table»'''
	
	def String tableDefinition(Attribute it) '''«name» «sqlType» «IF constraint != null && constraint.equals('NotNull')»NOT NULL «ENDIF»'''
	
	def String primaryKey(Attribute it, String tableName) '''«IF isPrimaryKey», CONSTRAINT «tableName»_pkey PRIMARY KEY («name»)«ENDIF»'''
	
	def String foreignKey(Attribute it, String tableName) '''«IF foreignKey != null», CONSTRAINT «tableName»_«name»_fkey FOREIGN KEY («name») REFERENCES " + schema + ".«foreignKey.tableName» ( «foreignKey.name» ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE«ENDIF»'''
	
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