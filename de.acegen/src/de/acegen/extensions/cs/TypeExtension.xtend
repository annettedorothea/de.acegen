package de.acegen.extensions.cs

import de.acegen.aceGen.Attribute
import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerAce
import de.acegen.aceGen.Model
import de.acegen.extensions.java.EcoreExtension
import javax.inject.Inject

class TypeExtension {
	
	@Inject
	extension EcoreExtension;


	def String namespace(HttpServer it) {
		return name.substring(0, name.lastIndexOf("."))
	}
	
	def dataNamespace(HttpServer it) '''«namespace».Data.«module»'''
	def controllerNamespace(HttpServer it) '''«namespace».Controller'''
	def acegenNamespace(HttpServer it) '''«namespace».AceGen'''
	def modelNamespace(HttpServer it) '''«namespace».Model.«module»'''
	
	def module(HttpServer it) {
		val parts = name.split('\\.');
		return parts.get(parts.length-1);
	}
	
	def dataDirectory(HttpServer it) '''Data/«module»'''
	def modelDirectory(HttpServer it) '''Model/«module»'''
	def controllerDirectory(HttpServer it) '''Controller'''
	def acegenDirectory(HttpServer it) '''AceGen'''
	
	def controllerName(HttpServer it) '''«module»'''
	def responseDataName(HttpServerAce it) '''«name.toFirstUpper»Response'''
	def payloadDataName(HttpServerAce it) '''«name.toFirstUpper»Payload'''
	def String modelClassName(Model it) '''«name.toFirstUpper»Model'''
	def String modelClassNameWithPackage(Model it) '''«parent.modelNamespace».«modelClassName»'''

	def String csType(Attribute it) {
		if (type !== null) {
			return '''«IF list»List<«ENDIF»«IF type.equals('DateTime')»DateTime«ELSEIF type.equals('FormData')»de.acegen.FormData«ELSE»«primitiveType»«ENDIF»«IF list»>«ENDIF»''';
		}
		if (model !== null) {
			return '''«IF list»List<«ENDIF»«model.modelClassNameWithPackage»«IF list»>«ENDIF»'''
		}
	}
	
	def primitiveType(Attribute it) {
		if (type == "String") {
			return "string"
		}
		if (type == "Integer") {
			return "int"
		}
		if (type == "Boolean") {
			return "bool"
		}
		if (type == "Float") {
			return "float"
		}
		return type;
	}
	

}
