package com.anfelisa.extensions.es6

import com.anfelisa.ace.ES6
import com.anfelisa.ace.ES6_StateFunction
import com.anfelisa.ace.ES6_StateElement
import com.anfelisa.ace.ES6_TypeDefinition

class Es6Extension {
	def String packageFolder(ES6 it) '''«name.replace('.', '/')»'''

	def String projectName(ES6 it) '''«name.toFirstUpper»'''

	def String appStateFunction(ES6_StateFunction it) '''AppState.«stateFunctionType»_«attribute.functionName("")»'''
	
	def String functionName(ES6_StateElement element) '''«element.functionName("")»'''
	
	def String functionName(ES6_StateElement it, String suffix) {
		val parent = eContainer;
		if (parent instanceof ES6_TypeDefinition) {
			var typeDef = parent as ES6_TypeDefinition;
			return (typeDef.eContainer as ES6_StateElement).functionName(typeDef.name + "_" + name) + '''«IF suffix.length > 0»_«suffix»«ENDIF»''' 		
		} else {
			return name + '''«IF suffix.length > 0»_«suffix»«ENDIF»''';
		}
	}

	def String elementPath(ES6_StateElement element) '''«element.elementPath("")»'''
	
	def String elementPath(ES6_StateElement it, String suffix) {
		val parent = eContainer;
		if (parent instanceof ES6_TypeDefinition) {
			var typeDef = parent as ES6_TypeDefinition;
			return (typeDef.eContainer as ES6_StateElement).elementPath(name) + '''«IF suffix.length > 0».«suffix»«ENDIF»''' 		
		} else {
			return name + '''«IF suffix.length > 0».«suffix»«ENDIF»''';
		}
	}

}