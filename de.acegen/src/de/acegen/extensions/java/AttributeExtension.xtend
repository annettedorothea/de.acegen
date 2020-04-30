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
import de.acegen.aceGen.JsonArray
import de.acegen.aceGen.JsonDateTime
import de.acegen.aceGen.JsonObject
import de.acegen.aceGen.JsonValue
import de.acegen.aceGen.Model
import java.util.ArrayList
import java.util.List
import javax.inject.Inject
import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import org.joda.time.format.DateTimeFormat

class AttributeExtension {

	@Inject
	extension ModelExtension
	
	int index = 0;
	
	public String stringLineBreak = '''," + 
	"'''

	def void resetIndex() {
		index = 0;
	}

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
		for (var i = 0; i < length; i++) {
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
			«IF type !== null && type.equals('DateTime')»@JsonSerialize(converter = DateTimeToStringConverter.class)
			@JsonDeserialize(converter = StringToDateTimeConverter.class)«ENDIF»
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

	def dateTimeParse(String dateString, String pattern) {
		try {
			return DateTime.parse(dateString, DateTimeFormat.forPattern(pattern)).withZone(DateTimeZone.UTC);
		} catch (Exception x) {
			return null;
		}
	}

	def dispatch CharSequence valueFrom(JsonObject it) '''«IF it !== null && members !== null && members.size > 0»{ «FOR member : members SEPARATOR stringLineBreak»\"«member.attribute.name»\" : «member.value.valueFrom()»«ENDFOR»}«ELSE»{}«ENDIF»'''

	def dispatch CharSequence valueFrom(JsonValue it) {
		if (string !== null) {
			var returnString = string;
			if (string.contains("${index}")) {
				returnString = returnString.replace("${index}", index.toString());
				index++;
			}
			if (string.contains("${random}")) {
				returnString = returnString.replace("${random}",  '''" + this.randomString() + "''');
			}
			return '''\"«returnString»\"''';
		} else if (boolean !== null) {
			return boolean;
		} else if (it.^null !== null) {
			return "null";
		} else {
			return '''«long»''';
		}
	}

	def dispatch CharSequence valueFrom(JsonArray it) '''«IF it !== null && values !== null && values.size > 0»[ «FOR value : values SEPARATOR stringLineBreak»«value.valueFrom»«ENDFOR»]«ELSE»[]«ENDIF»'''

	def dispatch CharSequence valueFrom(JsonDateTime it) '''\"«dateTimeParse(dateTime, pattern)»\"'''

}
/******* S.D.G. *******/
