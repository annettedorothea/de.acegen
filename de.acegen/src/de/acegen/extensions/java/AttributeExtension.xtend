/* 
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 * 
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */


package de.acegen.extensions.java

import de.acegen.aceGen.Attribute
import de.acegen.aceGen.AttributeDefinition
import de.acegen.aceGen.Model
import java.util.ArrayList
import java.util.List
import javax.inject.Inject

class AttributeExtension {

	@Inject
	extension ModelExtension

	def String resourceParamType(Attribute it) '''«IF type.equals('DateTime')»String«ELSE»«type»«ENDIF»'''

	def String resourceParam(
		Attribute it) '''«IF type.equals('DateTime')»new DateTime(«name»).withZone(DateTimeZone.UTC)«ELSE»«name»«ENDIF»'''

	def String getterCall(Attribute it) {
		return '''get«name.toFirstUpper»()''';
	}

	def String javaType(Attribute it) {
		if (type !== null) {
			return '''«IF list»java.util.List<«ENDIF»«IF type.equals('DateTime')»org.joda.time.DateTime«ELSE»«type»«ENDIF»«IF list»>«ENDIF»''';
		}
		if (model !== null) {
			return '''«IF list»java.util.List<«ENDIF»«model.interfaceWithPackage»«IF list»>«ENDIF»'''
		}
	}
	
	def List<Integer> timesIterator(int length) {
		var list = new ArrayList();
		for(var i=0; i<length; i++) {
			list.add(i);
		}
		return list;
	}

	def String mapperInit(Attribute it) {
		if (type !== null) {
			return '''«IF isList»null«ELSEIF type.equals("DateTime")»r.getTimestamp("«name»") != null ? new org.joda.time.DateTime(r.getTimestamp("«name»")).withZone(org.joda.time.DateTimeZone.UTC) : null«ELSEIF type.equals("Integer")»r.getObject("«name»") != null ? r.getInt("«name»") : null«ELSEIF type.equals("Serial")»r.getInt("«name»")«ELSE»r.get«javaType»("«name»")«ENDIF»'''
		}
		if (model !== null) {
			return '''null''';
		}
	}

	def String sqlType(Attribute it) {
		if (type !== null) {
			switch type {
				case 'Integer': "integer"
				case 'Long': "bigint"
				case 'String': "character varying"
				case 'Float': "numeric"
				case 'Boolean': "boolean"
				case 'DateTime': "timestamp with time zone"
			}
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
			return '''
				private «javaType» «name»;
			'''
		}
	}

	def String param(Attribute it,
		boolean jsonProperty) '''«IF jsonProperty»@JsonProperty("«name»") «ENDIF»«javaType» «name»'''

	def String interfaceGetter(Attribute it) '''«javaType» get«name.toFirstUpper»();'''

	def String interfaceSetter(Attribute it) '''void set«name.toFirstUpper»(«javaType» «name.toFirstLower»);'''

	def String assign(Attribute it) '''this.«name» = «name»;'''

	def String getter(Attribute it, boolean jsonProperty) '''
		«IF jsonProperty»
			@JsonProperty
			«IF type !== null && type.equals('DateTime')»@JsonSerialize(converter = DateTimeToStringConverter.class)«ENDIF»
		«ENDIF»
		public «javaType» get«name.toFirstUpper»() {
			return this.«name»;
		}
	'''

	def String with(Attribute it, Model model) '''
		public «model.dataInterfaceName» with«name.toFirstUpper»(«javaType» «name») {
			this.«name» = «name»;
			return this;
		}
	'''

	def String setter(Attribute it) '''
		public void set«name.toFirstUpper»(«javaType» «name») {
			this.«name» = «name»;
		}
	'''

	def String setterCall(Attribute it, String param) '''set«name.toFirstUpper»(«param»)'''

	def boolean isPrimitive(Attribute it) {
		return !list && model === null;
	}

	def String dateTimeParse(String date, String pattern) '''DateTime.parse("«date»", DateTimeFormat.forPattern("«pattern»")).withZone(DateTimeZone.UTC)'''
	def String testDateTimeParse(String date, String pattern) '''DateTime.parse("«date»", DateTimeFormat.forPattern("«pattern»")).withZone(DateTimeZone.UTC).toString()'''

	def String valueFrom(AttributeDefinition it, Integer index) {
		if (value.stringValue !== null) {
			if (attribute.type == "Integer") {
				return '''Integer.parseInt("«value.stringValue»")'''
			}
			if (attribute.type == "Float") {
				return '''Float.parseFloat("«value.stringValue»")'''
			}
			if (attribute.type == "Boolean") {
				return '''new Boolean("«value.stringValue»")'''
			}
			if (attribute.type == "Long") {
				return '''Long.parseLong("«value.stringValue»")'''
			}
			return '''this.templateStringValue("«value.stringValue»", «IF index !== null»«index»«ELSE»null«ENDIF»)'''
		}
		if (attribute.type == "DateTime") {
			return dateTimeParse(value.dateValue, value.pattern)
		}
		if (value.attributeDefinitionList !== null || value.listAttributeDefinitionList !== null) {
			return "null"
		}
		return '''«value.intValue»'''
	}
	
	def String testValueFrom(AttributeDefinition it, Integer index) {
		if (value.stringValue !== null) {
			if (attribute.type == "Integer") {
				return '''Integer.parseInt("«value.stringValue»")'''
			}
			if (attribute.type == "Float") {
				return '''Float.parseFloat("«value.stringValue»")'''
			}
			if (attribute.type == "Boolean") {
				return '''new Boolean("«value.stringValue»")'''
			}
			if (attribute.type == "Long") {
				return '''Long.parseLong("«value.stringValue»")'''
			}
			return '''this.templateStringValue("«value.stringValue»", «IF index !== null»«index»«ELSE»null«ENDIF»)'''
		}
		if (attribute.type == "DateTime") {
			return testDateTimeParse(value.dateValue, value.pattern)
		}
		if (value.attributeDefinitionList !== null || value.listAttributeDefinitionList !== null) {
			return "null"
		}
		return '''«value.intValue»'''
	}
	
}
/******* S.D.G. *******/
