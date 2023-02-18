package de.acegen.extensions.java

import de.acegen.aceGen.Attribute
import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerAce
import de.acegen.aceGen.HttpServerOutcome
import de.acegen.aceGen.Model
import javax.inject.Inject

class TypeExtension {

	@Inject
	extension EcoreExtension;

	def String dataPackageName(HttpServer it) '''«name».data'''
	
	def String dataWithGenericModel(Model it) '''Data<«modelClassNameWithPackage»>'''
	

	def String payloadDataName(HttpServerAce it) '''«name.toFirstUpper»Payload'''
	
	def String payloadDataNameWithPackage(HttpServerAce it) '''«parent.dataPackageName».«payloadDataName»'''
	
	def String responseDataName(HttpServerAce it) '''«name.toFirstUpper»Response'''

	def String responseDataNameWithPackage(	HttpServerAce it) '''«parent.dataPackageName».«responseDataName»'''
	

	def String javaType(Attribute it) {
		if (type !== null) {
			return '''«IF list»java.util.List<«ENDIF»«IF type.equals('DateTime')»java.time.LocalDateTime«ELSEIF type.equals('FormData')»de.acegen.FormData«ELSE»«type»«ENDIF»«IF list»>«ENDIF»''';
		}
		if (model !== null) {
			return '''«IF list»java.util.List<«ENDIF»«model.modelClassNameWithPackage»«IF list»>«ENDIF»'''
		}
	}
	
	def String javaTypeNew(Attribute it) {
		if (type !== null) {
			return '''«IF list»java.util.ArrayList<«ENDIF»«IF type.equals('DateTime')»java.time.LocalDateTime«ELSE»«type»«ENDIF»«IF list»>«ENDIF»''';
		}
		if (model !== null) {
			return '''«IF list»java.util.ArrayList<«ENDIF»«model.modelClassNameWithPackage»«IF list»>«ENDIF»'''
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
	
	

	def String modelPackageName(HttpServer it) '''«name».models'''
	
	def String modelPackageName(Model it) '''«(parent).name».models'''


	def String modelClassName(Model it) '''«name.toFirstUpper»Model'''

	def String modelClassNameWithPackage(Model it) '''«modelPackageName».«modelClassName»'''
	
	def String modelParamName(Model it) '''«name.toFirstLower»Model'''
	
	def String modelDao(Model it) '''«name.toFirstUpper»Dao'''

	def String modelDaoWithPackage(Model it) '''«(eContainer as HttpServer).getName».models.«modelDao»'''
	
	def String abstractModelDao(Model it) '''Abstract«name.toFirstUpper»Dao'''

	def String tableName(Model it) '''\"«name.toLowerCase»\"'''

	def String resourcePackageName(HttpServer it) '''«name».resources'''
	
	def String resourceName(HttpServerAce it) '''«name.toFirstUpper»Resource'''
	
	def String actionPackageName(HttpServer it) '''«name».actions'''

	def String actionName(HttpServerAce it) '''«name.toFirstUpper»Action'''

	def String abstractActionName(HttpServerAce it) '''Abstract«actionName»'''

	def String actionNameWithPackage(HttpServerAce it) '''«parent.actionPackageName».«actionName»'''

	def String commandPackage(HttpServer it) '''«name».commands'''
	
	def String commandName(HttpServerAce it) '''«name.toFirstUpper»Command'''
	
	def String abstractCommandName(HttpServerAce it) '''Abstract«commandName»'''
	
	def String commandNameWithPackage(HttpServerAce it) '''«parent.commandPackage».«commandName»'''
	
	def String eventName(HttpServerAce it, HttpServerOutcome outcome) '''«parent.name».events.«name.toFirstUpper»«outcome.name.toFirstUpper»Event'''
	
	def String fileExtension() '''.java'''

	def String packageFolder(HttpServer it) '''«name.replace('.', '/')»'''

	def String modelMapper(Model it) '''«name.toFirstUpper»Mapper'''

}
