/********************************************************************************
 * Copyright (c) 2020 Annette Pohl
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 * 
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 ********************************************************************************/




package de.acegen.extensions.es6

import de.acegen.aceGen.BooleanType
import de.acegen.aceGen.ClientAttribute
import de.acegen.aceGen.ClientGivenRef
import de.acegen.aceGen.ClientScenario
import de.acegen.aceGen.CustomVerification
import de.acegen.aceGen.HttpClient
import de.acegen.aceGen.HttpClientStateFunction
import de.acegen.aceGen.JsonArrayClient
import de.acegen.aceGen.JsonObjectClient
import de.acegen.aceGen.JsonValueClient
import de.acegen.aceGen.LongType
import de.acegen.aceGen.NullType
import de.acegen.aceGen.PrimitiveValue
import de.acegen.aceGen.StringType
import de.acegen.aceGen.UndefinedType
import java.util.ArrayList
import java.util.List

class Es6Extension {
	
	def String packageFolder(HttpClient it) '''«getName.replace('.', '/')»'''

	def String projectName(HttpClient it) '''«getName.toFirstUpper»'''

	def String appStateFunction(HttpClientStateFunction it) '''(data) => {
		«stateElement.stateFunctionCall('''«stateFunctionType»''', "data")»
	}'''

	def stateFunctionCall(ClientAttribute it, String functionName, String data) '''
		AppState.«stateFunctionName(functionName)»(
			«IF functionName != "get"»«data», «ENDIF»
			«paramList.path»«IF functionName != "get" && attributes.size > 0 && !isList», 
			[«FOR attribute: attributes SEPARATOR ", "»"«attribute.name»"«ENDFOR»]«ENDIF»
		)
	'''

	private def List<String> paramList(ClientAttribute it) {
		var paramList = new ArrayList<String>()
		for (item : allParentAttributesInclusiveItem) {
			paramList.add('''"«item.name»"''')
		}
		return paramList
	}

	private def String path(List<String> paramList) '''[«FOR param : paramList SEPARATOR ", "»«param»«ENDFOR»]'''

	private def String stateFunctionName(ClientAttribute it, String functionName) {
		if (isLocation) {
			return functionName + "Location"
		}
		if (isStorage) {
			return functionName + "Storage"
		}
		return functionName
	}

	private def List<ClientAttribute> allParentAttributesInclusiveItem(ClientAttribute it) {
		var attributes = new ArrayList<ClientAttribute>();
		attributes.add(it);
		var parent = eContainer;
		while (parent !== null) {
			if (parent instanceof ClientAttribute) {
				attributes.add(0, parent as ClientAttribute)
			}
			parent = parent.eContainer;
		}
		return attributes
	}

	def List<HttpClient> allReferencedHttpClients(ClientScenario it) {
		var list = new ArrayList<HttpClient>();
		allReferencedHttpClientsRec(list);
		return list;
	}

	private def void allReferencedHttpClientsRec(ClientScenario it, ArrayList<HttpClient> list) {
		for (whenThenItem : clientWhenThen) {
			if (whenThenItem.whenBlock !== null) {
				var httpClient = whenThenItem.whenBlock.action.eContainer as HttpClient
				if (!list.contains(httpClient)) {
					list.add(httpClient)
				}
			}
			for (ClientGivenRef givenRef : givenRefs) {
				givenRef.scenario.allReferencedHttpClientsRec(list);
			}
		}
	}

	def actionIdName(HttpClient it) '''«name.toFirstUpper»ActionIds'''

	def primitiveValueFrom(PrimitiveValue it) {
		if (string !== null) {
			return '''`«string»`''';
		}
		return getLong()
	}

	def primitiveParamFrom(PrimitiveValue it) {
		if (string !== null) {
			return '''«string»''';
		}
		return getLong()
	}

	def dispatch CharSequence valueFrom(JsonObjectClient it) '''
		«IF it !== null && members !== null && members.size > 0»
			{ 
				«FOR member : members SEPARATOR ",\n"»«member.attribute.name» : «member.value.valueFrom()»«ENDFOR»
			}«ELSE»{}«ENDIF»
	'''

	def dispatch CharSequence valueFrom(JsonValueClient it) {
		if (it instanceof StringType) {
			return '''`«string»`''';
		} else if (it instanceof BooleanType) {
			return boolean;
		} else if (it instanceof NullType) {
			return "null";
		} else if (it instanceof LongType) {
			return '''«long»''';
		} else if (it instanceof UndefinedType) {
			return '''undefined''';
		} else if (it instanceof JsonArrayClient) {
			return '''
				[
					«FOR value : (it as JsonArrayClient).values SEPARATOR ","»«value.valueFrom»«ENDFOR»
				]
			''';
		}
	}

	def String componentName(ClientAttribute it) {
		if (isList) {
			return '''«name.toFirstUpper»Item'''
		}
		return '''«name.toFirstUpper»'''
	}

	def String componentContainerName(ClientAttribute it) {
		if (isList) {
			return '''«name.toFirstUpper»ItemContainer'''
		}
		return '''«name.toFirstUpper»Container'''
	}

	def String importComponentContainer(ClientAttribute it, String subFolder) '''
		«IF attributes.size > 0 && !noComponent»
			import { «componentContainerName» } from ".«subFolder»/«componentContainerName»";
		«ENDIF»
	'''

	def String importComponent(ClientAttribute it, String subFolder) '''
		«IF isList»
			import { «componentName» } from "./«subFolder»/«componentName»";
		«ENDIF»
	'''

	def boolean hasComplexAttribute(ClientAttribute it) {
		for (attribute : attributes) {
			if (attribute.attributes.size > 0) {
				return true;
			}
		}
		return false
	}

	def boolean childrenContain(ClientAttribute it, String value) {
		for (attribute : attributes) {
			if (attribute.name == value) {
				return true;
			}
		}
		return false
	}

	def boolean oneChildIsLocationOrStorage(ClientAttribute it) {
		for (attribute : attributes) {
			if (attribute.location || attribute.storage) {
				return true;
			}
			for (childAttribute : attribute.attributes) {
				if (childAttribute.location || childAttribute.storage) {
					return true;
				}
			}
		}
		return false
	}

	def boolean attributesContain(List<ClientAttribute> it, ClientAttribute attribute) {
		for (parentAttribute : it) {
			if (parentAttribute.name == attribute.name) {
				return true;
			}
		}
		return false
	}

	def String depth(ClientAttribute it) {
		return depthRec("../../")
	}

	def String depthRec(ClientAttribute attr, String prefix) {
		var clientAttribute = attr
		val parent = clientAttribute.findNextClientAttributeParent
		if (parent !== null) {
			return parent.depthRec(prefix + "../")
		} else {
			return prefix;
		}
	}

	def String path(ClientAttribute it) {
		return pathRec("")
	}

	def String pathRec(ClientAttribute attr, String suffix) {
		var clientAttribute = attr
		val parent = clientAttribute.findNextClientAttributeParent
		if (parent !== null) {
			return parent.pathRec(parent.name.toFirstLower + "/" + suffix)
		} else {
			return suffix;
		}
	}

	def String stateRefPath(ClientAttribute it) {
		return elementPathRec("")
	}

	def Boolean isTag(ClientAttribute it) {
		if (uiElement == "TextInput" || uiElement == "PasswordInput" || uiElement == "CheckBox" ||
			uiElement == "Select" || uiElement == "Button" || uiElement == "Radio") {
			return true
		}
		return false
	}
	
	def Boolean isInput(ClientAttribute it) {
		if (uiElement == "TextInput" || uiElement == "PasswordInput" || uiElement == "CheckBox" || uiElement == "Radio") {
			return true
		}
		return false
	}
	
	def Boolean isValueInput(ClientAttribute it) {
		if (uiElement == "TextInput" || uiElement == "PasswordInput") {
			return true
		}
		return false
	}
	
	def Boolean isCheckedInput(ClientAttribute it) {
		if (uiElement == "CheckBox" || uiElement == "Radio") {
			return true
		}
		return false
	}
	
	def String inputType(ClientAttribute it) {
		if (uiElement == "TextInput") {
			return "text"
		}
		if (uiElement == "PasswordInput") {
			return "password"
		}
		if (uiElement == "CheckBox") {
			return "checkbox"
		}
		if (uiElement == "Radio") {
			return "radio"
		}
	}
	
	def Boolean isSelect(ClientAttribute it) {
		if (uiElement == "Select") {
			return true
		}
		return false
	}
	
	def Boolean isButton(ClientAttribute it) {
		if (uiElement == "Button") {
			return true
		}
		return false
	}
	
	def Boolean isComponent(ClientAttribute it) {
		return !noComponent && ((attributes.size > 0) || actions.size > 0)
	}

	private def String elementPathRec(ClientAttribute attr, String suffix) {
		var clientAttribute = attr
		val parent = clientAttribute.findNextClientAttributeParent
		if (parent !== null) {
			return parent.elementPathRec(clientAttribute.name) + '''«IF suffix.length > 0».«suffix»«ENDIF»'''
		} else {
			return clientAttribute.getName + '''«IF suffix.length > 0».«suffix»«ENDIF»''';
		}
	}

	private def ClientAttribute findNextClientAttributeParent(ClientAttribute it) {
		var parent = eContainer;
		while (parent !== null) {
			val grandParent = parent.eContainer
			if (parent instanceof ClientAttribute) {
				return parent as ClientAttribute
			}
			parent = grandParent;
		}
		return null;
	}

	def List<CustomVerification> allVerifications(ClientScenario it) {
		val verifications = new ArrayList<CustomVerification>()
		for (clientWhenThenItem : clientWhenThen) {
			if (clientWhenThenItem !== null && clientWhenThenItem.thenBlock !== null && clientWhenThenItem.thenBlock.verifications !== null) {
				verifications.addAll(clientWhenThenItem.thenBlock.verifications)
			}
		}
		return verifications;
	}

}
/******* S.D.G. *******/
