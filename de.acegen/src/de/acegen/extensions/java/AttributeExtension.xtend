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
import de.acegen.aceGen.DataDefinition
import de.acegen.aceGen.HttpServerAce
import de.acegen.aceGen.Model
import de.acegen.aceGen.PrimitiveValueDefinitionForList
import de.acegen.aceGen.ValueDefinitionList
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
	
	def List<Integer> timesIterator(int length) {
		var list = new ArrayList();
		for(var i=0; i<length; i++) {
			list.add(i);
		}
		return list;
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
				case 'Integer': "integer"
				case 'Long': "bigint"
				case 'String': "character varying"
				case 'Float': "numeric"
				case 'Boolean': "boolean"
				case 'DateTime': "timestamp with time zone"
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
			return '''
				private «javaType» «name»;
			'''
		}
	}

	def String typeWithParam(Attribute it) {
		if (type !== null) {
			return '''«javaType» «name.toFirstLower»'''
		}
		if (model !== null) {
			return '''«javaType» «name»'''
		}
	}

	def String param(Attribute it,
		boolean jsonProperty) '''«IF jsonProperty»@JsonProperty("«name»") «ENDIF»«javaType» «name»'''

	def String interfaceGetter(Attribute it) '''«javaType» get«name.toFirstUpper»();'''

	def String interfaceSetter(Attribute it) '''void set«name.toFirstUpper»(«javaType» «name.toFirstLower»);'''

	def String assign(Attribute it) '''this.«name» = «name»;'''

	def String getter(Attribute it, boolean jsonProperty) '''
		«IF jsonProperty»@JsonProperty«ENDIF»
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

	def String withCall(Attribute it, String param) '''with«name.toFirstUpper»(«param»)'''

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

	def boolean isPrimitive(Attribute it) {
		return !list && model === null;
	}

	def List<String> mergeAttributesForGet(HttpServerAce it) {
		var attributeList = new ArrayList<String>();
		attributeList.add("String uuid");
		for (queryParam : queryParams) {
			val typeWithParam = queryParam.typeWithParam;
			if (!attributeList.contains(typeWithParam)) {
				attributeList.add(typeWithParam);
			}
		}
		for (pathParam : pathParams) {
			val typeWithParam = pathParam.typeWithParam;
			if (!attributeList.contains(typeWithParam)) {
				attributeList.add(typeWithParam);
			}
		}
		attributeList.add("int port");
		return attributeList;
	}

	def List<String> mergeAttributesForGetCall(HttpServerAce it, DataDefinition dataDefinition, Integer... index) {
		var attributeList = new ArrayList<String>();
		attributeList.add("String uuid");
		var valueList = new ArrayList<String>();
		valueList.add(uuidForCall(dataDefinition));
		for (queryParam : queryParams) {
			val typeWithParam = queryParam.typeWithParam;
			if (!attributeList.contains(typeWithParam)) {
				attributeList.add(typeWithParam);
				valueList.add(valueFor(queryParam, dataDefinition, index));
			}
		}
		for (pathParam : pathParams) {
			val typeWithParam = pathParam.typeWithParam;
			if (!attributeList.contains(typeWithParam)) {
				attributeList.add(typeWithParam);
				valueList.add(valueFor(pathParam, dataDefinition, index));
			}
		}
		valueList.add("DROPWIZARD.getLocalPort()");
		return valueList;
	}

	def String dateTimeParse(String date, String pattern) '''DateTime.parse("«date»", DateTimeFormat.forPattern("«pattern»"))'''

	def String valueFrom(AttributeDefinition it, Integer... index) {
		if (value.stringValue !== null) {
			if (attribute.type == "DateTime") {
				return dateTimeParse(value.stringValue, value.pattern)
			}
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
			return '''this.templateStringValue("«value.stringValue»", «IF index.length > 0»«index.get(0)»«ELSE»null«ENDIF»)'''
		}
		if (value.attributeDefinitionList !== null) {
			return "null"
		}
		if (value.listAttributeDefinitionList !== null) {
			if (value.listAttributeDefinitionList instanceof PrimitiveValueDefinitionForList) {
				val values = (value.listAttributeDefinitionList as PrimitiveValueDefinitionForList).valueDefinitionList;
				return values.arrayValues(attribute.type).toString;
			} else {
				return "null"
			}
		}
		return '''«value.intValue»'''
	}
	
	private def arrayValues(List<ValueDefinitionList> it, String type) '''
		new ArrayList<>(Arrays.asList(new «type»[] { «FOR value: it SEPARATOR ", "»«IF type == "String"»"«value.primitiveValue.stringValue»"«ELSE»«value.primitiveValue.intValue»«ENDIF»«ENDFOR» }))
	'''
	
	private def String valueFor(Attribute attribute, DataDefinition dataDefinition, Integer... index) {
		if (dataDefinition.data !== null && dataDefinition.data.attributeDefinitions !== null) {
			for (attributeDefinition : dataDefinition.data.attributeDefinitions) {
				if (attributeDefinition.attribute.equals(attribute)) {
					return attributeDefinition.valueFrom(index)
				}
			}
		}
		return null;
	}

	def List<String> mergeAttributesForPut(HttpServerAce it) {
		var attributeList = new ArrayList<String>();
		attributeList.add("String uuid");
		for (queryParam : queryParams) {
			val typeWithParam = queryParam.typeWithParam;
			if (!attributeList.contains(typeWithParam)) {
				attributeList.add(typeWithParam);
			}
		}
		for (pathParam : pathParams) {
			val typeWithParam = pathParam.typeWithParam;
			if (!attributeList.contains(typeWithParam)) {
				attributeList.add(typeWithParam);
			}
		}
		for (attr : payload) {
			val typeWithParam = attr.typeWithParam;
			if (!attributeList.contains(typeWithParam)) {
				attributeList.add(typeWithParam);
			}
		}
		attributeList.add("int port");
		return attributeList;
	}

	def List<String> mergeAttributesForPutCall(HttpServerAce it, DataDefinition dataDefinition, Integer... index) {
		var attributeList = new ArrayList<String>();
		attributeList.add("String uuid");
		var valueList = new ArrayList<String>();
		valueList.add(uuidForCall(dataDefinition));
		for (queryParam : queryParams) {
			val typeWithParam = queryParam.typeWithParam;
			if (!attributeList.contains(typeWithParam)) {
				attributeList.add(typeWithParam);
				valueList.add(valueFor(queryParam, dataDefinition, index));
			}
		}
		for (pathParam : pathParams) {
			val typeWithParam = pathParam.typeWithParam;
			if (!attributeList.contains(typeWithParam)) {
				attributeList.add(typeWithParam);
				valueList.add(valueFor(pathParam, dataDefinition, index));
			}
		}
		for (attr : payload) {
			val typeWithParam = attr.typeWithParam;
			if (!attributeList.contains(typeWithParam)) {
				attributeList.add(typeWithParam);
				valueList.add(valueFor(attr, dataDefinition, index));
			}
		}
		valueList.add("DROPWIZARD.getLocalPort()");
		return valueList;
	}

	def List<String> mergeAttributesForPost(HttpServerAce it) {
		var attributeList = new ArrayList<String>();
		attributeList.add("String uuid");
		for (queryParam : queryParams) {
			val typeWithParam = queryParam.typeWithParam;
			if (!attributeList.contains(typeWithParam)) {
				attributeList.add(typeWithParam);
			}
		}
		for (pathParam : pathParams) {
			val typeWithParam = pathParam.typeWithParam;
			if (!attributeList.contains(typeWithParam)) {
				attributeList.add(typeWithParam);
			}
		}
		for (attr : payload) {
			val typeWithParam = attr.typeWithParam;
			if (!attributeList.contains(typeWithParam)) {
				attributeList.add(typeWithParam);
			}
		}
		attributeList.add("int port");
		return attributeList;
	}

	def List<String> mergeAttributesForPostCall(HttpServerAce it, DataDefinition dataDefinition, Integer... index) {
		var attributeList = new ArrayList<String>();
		attributeList.add("String uuid");
		var valueList = new ArrayList<String>();
		valueList.add(uuidForCall(dataDefinition));
		for (queryParam : queryParams) {
			val typeWithParam = queryParam.typeWithParam;
			if (!attributeList.contains(typeWithParam)) {
				attributeList.add(typeWithParam);
				valueList.add(valueFor(queryParam, dataDefinition, index));
			}
		}
		for (pathParam : pathParams) {
			val typeWithParam = pathParam.typeWithParam;
			if (!attributeList.contains(typeWithParam)) {
				attributeList.add(typeWithParam);
				valueList.add(valueFor(pathParam, dataDefinition, index));
			}
		}
		for (attr : payload) {
			val typeWithParam = attr.typeWithParam;
			if (!attributeList.contains(typeWithParam)) {
				attributeList.add(typeWithParam);
				valueList.add(valueFor(attr, dataDefinition, index));
			}
		}
		valueList.add("DROPWIZARD.getLocalPort()");
		return valueList;
	}

	def List<String> mergeAttributesForDelete(HttpServerAce it) {
		var attributeList = new ArrayList<String>();
		attributeList.add("String uuid");
		for (queryParam : queryParams) {
			val typeWithParam = queryParam.typeWithParam;
			if (!attributeList.contains(typeWithParam)) {
				attributeList.add(typeWithParam);
			}
		}
		for (pathParam : pathParams) {
			val typeWithParam = pathParam.typeWithParam;
			if (!attributeList.contains(typeWithParam)) {
				attributeList.add(typeWithParam);
			}
		}
		attributeList.add("int port");
		return attributeList;
	}
	
	private def String uuidForCall(DataDefinition it) {
		if (uuid !== null) {
			return '''"«uuid»"'''
		} else {
			return "randomUUID()"
		}
	}

	def List<String> mergeAttributesForDeleteCall(HttpServerAce it, DataDefinition dataDefinition, Integer... index) {
		var attributeList = new ArrayList<String>();
		attributeList.add("String uuid");
		var valueList = new ArrayList<String>();
		valueList.add(uuidForCall(dataDefinition));
		for (queryParam : queryParams) {
			val typeWithParam = queryParam.typeWithParam;
			if (!attributeList.contains(typeWithParam)) {
				attributeList.add(typeWithParam);
				valueList.add(valueFor(queryParam, dataDefinition, index));
			}
		}
		for (pathParam : pathParams) {
			val typeWithParam = pathParam.typeWithParam;
			if (!attributeList.contains(typeWithParam)) {
				attributeList.add(typeWithParam);
				valueList.add(valueFor(pathParam, dataDefinition, index));
			}
		}
		valueList.add("DROPWIZARD.getLocalPort()");
		return valueList;
	}

	def List<String> mergeAttributes(HttpServerAce it) {
		var attributeList = new ArrayList<String>();
		attributeList.add("UUID.randomUUID().toString()");
		if (getType == 'PUT' || getType == 'POST') {
			for (queryParam : queryParams) {
				val getter = queryParam.getterCall;
				if (!attributeList.contains(getter)) {
					attributeList.add('''((«getModel.dataParamType»)command.getCommandData()).«getter»''');
				}
			}
			for (pathParam : pathParams) {
				val getter = pathParam.getterCall;
				if (!attributeList.contains(getter)) {
					attributeList.add('''((«getModel.dataParamType»)command.getCommandData()).«getter»''');
				}
			}
			for (attr : payload) {
				val getter = attr.getterCall;
				if (!attributeList.contains(getter)) {
					attributeList.add('''((«getModel.dataParamType»)command.getCommandData()).«getter»''');
				}
			}
		} else if (getType == 'DELETE') {
			for (queryParam : queryParams) {
				val getter = queryParam.getterCall;
				if (!attributeList.contains(getter)) {
					attributeList.add('''((«getModel.dataParamType»)command.getCommandData()).«getter»''');
				}
			}
			for (pathParam : pathParams) {
				val getter = pathParam.getterCall;
				if (!attributeList.contains(getter)) {
					attributeList.add('''((«getModel.dataParamType»)command.getCommandData()).«getter»''');
				}
			}
		}
		attributeList.add("appConfiguration.getPort()");
		if (isAuthorize) {
			attributeList.add("authorization");
		}
		return attributeList;
	}

}
/******* S.D.G. *******/
