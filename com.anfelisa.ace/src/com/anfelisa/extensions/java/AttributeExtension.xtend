package com.anfelisa.extensions.java

import com.anfelisa.ace.Attribute
import javax.inject.Inject
import com.anfelisa.ace.Model

class AttributeExtension {

	@Inject
	extension ModelExtension
	
	def String resourceParamType(Attribute it) '''«IF type.equals('DateTime')»String«ELSE»«type»«ENDIF»'''

	def String resourceParam(Attribute it) '''«IF type.equals('DateTime')»new DateTime(«name»).withZone(DateTimeZone.UTC)«ELSE»«name»«ENDIF»'''

	def String getterCall(Attribute it) {
		return '''get«name.toFirstUpper»()''';
	}
	
	def String type(Attribute it) {
		if (type !== null) {
			return type;
		}	
	}
	
	def String javaType(Attribute it) {
		if (type !== null) {
			return '''«IF list»java.util.List<«ENDIF»«IF type.equals('DateTime')»org.joda.time.DateTime«ELSE»«type»«ENDIF»«IF list»>«ENDIF»''';
		}	
		if (model !== null) {
			return '''«IF list»java.util.List<«ENDIF»«model.interfaceWithPackage»«IF list»>«ENDIF»'''
		}	
	}
	
	def String mapperInit(Attribute it) {
		if (type !== null) {
			return '''«IF isList»null«ELSEIF type.equals("DateTime")»r.getTimestamp("«name»") != null ? new org.joda.time.DateTime(r.getTimestamp("«name»")) : null«ELSEIF type.equals("Integer")»r.getObject("«name»") != null ? r.getInt("«name»") : null«ELSEIF type.equals("Serial")»r.getInt("«name»")«ELSE»r.get«javaType»("«name»")«ENDIF»'''
		}	
		if (model !== null) {
			return '''null''';
		}	
	}
	
	def String sqlType(Attribute it) {
		if (type !== null) {
			switch type {
	      		case 'Integer' : "integer"
	      		case 'Long' : "bigint"
	      		case 'String' : "character varying"
	      		case 'Float' : "numeric"
	      		case 'Boolean' : "boolean"
	      		case 'DateTime' : "timestamp with time zone"
	    	}
		}	
	}
	
	def String constraint(Attribute it) {
		if (type !== null) {
			return constraint;
		}	
	}
	
	def String tableName(Attribute it) {
		if (type !== null) {
			'''«(eContainer as Model).table»'''
		}	
	}
	
	def String declaration(Attribute it) {
		if (type !== null) {
			return '''
				«IF constraint !== null»
					@«constraint»
				«ENDIF»
				private «javaType» «name.toFirstLower»«IF type.equals('Boolean')» = false«ENDIF»;
		'''
		}	
		if (model !== null) {
			return 
			'''
				private «javaType» «name»;
			'''
		}	
	}
	
	def String param(Attribute it, boolean jsonProperty) '''«IF jsonProperty»@JsonProperty("«name»") «ENDIF»«javaType» «name»'''
	
	def String interfaceGetter(Attribute it) '''«javaType» get«name.toFirstUpper»();'''
	
	def String interfaceSetter(Attribute it) '''void set«name.toFirstUpper»(«javaType» «name.toFirstLower»);'''
	
	def String assign(Attribute it) '''this.«name» = «name»;'''
	
	def String getter(Attribute it, boolean jsonProperty) '''
		«IF jsonProperty»@JsonProperty«ENDIF»
		public «javaType» get«name.toFirstUpper»() {
			return this.«name»;
		}'''
	
	def String with(Attribute it, Model model) '''
		public «model.dataInterfaceName» with«name.toFirstUpper»(«javaType» «name») {
			this.«name» = «name»;
			return this;
		}'''
	
	def String setter(Attribute it) '''
		public void set«name.toFirstUpper»(«javaType» «name») {
			this.«name» = «name»;
		}'''
	
	def String setterCall(Attribute it, String param) '''set«name.toFirstUpper»(«param»)'''
	
	def Attribute foreignKey(Attribute it) {
		if (type !== null) {
			return foreignKey;
		}	
	}
	
	def boolean isPrimaryKey(Attribute it) {
		if (type !== null) {
			return primaryKey;
		}
		return false;
	}
	
	def boolean isUnique(Attribute it) {
		if (type !== null) {
			return unique;
		}
		return false;
	}
	
}