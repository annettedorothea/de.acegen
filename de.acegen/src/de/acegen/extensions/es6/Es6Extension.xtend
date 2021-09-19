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
import de.acegen.aceGen.GroupedClientAttribute
import de.acegen.aceGen.HttpClient
import de.acegen.aceGen.HttpClientStateFunction
import de.acegen.aceGen.JsonArrayClient
import de.acegen.aceGen.JsonObjectClient
import de.acegen.aceGen.JsonValueClient
import de.acegen.aceGen.LongType
import de.acegen.aceGen.NullType
import de.acegen.aceGen.PrimitiveValue
import de.acegen.aceGen.SingleClientAttribute
import de.acegen.aceGen.StringType
import de.acegen.aceGen.UndefinedType
import java.util.ArrayList
import java.util.List

class Es6Extension {
	def String packageFolder(HttpClient it) '''«getName.replace('.', '/')»'''

	def String projectName(HttpClient it) '''«getName.toFirstUpper»'''

	def String appStateFunction(
		HttpClientStateFunction it) '''(data) => {
	«stateElement.stateFunctionCall('''«stateFunctionType»''', "data")»
}'''
		
	def stateFunctionCall(SingleClientAttribute it, String functionName, String data) '''«IF functionName == "set" && eContainer instanceof GroupedClientAttribute»
if (data.«(eContainer as GroupedClientAttribute).name») {
	data.«(eContainer as GroupedClientAttribute).name».group = "«name»";
} else {
	data.«(eContainer as GroupedClientAttribute).name» = { group: "«name»" };
}«ENDIF»
AppUtils.«stateFunctionName(functionName)»(
	«IF functionName != "get"»«data», «ENDIF»
	«paramList.path»«IF functionName != "get"», 
	[«FOR verification: groupVerifications(functionName) SEPARATOR ", "»«verification»«ENDFOR»]«ENDIF»«IF eContainer instanceof GroupedClientAttribute || attributes.size > 0 && !isList», 
	[«IF eContainer instanceof GroupedClientAttribute»"group", «ENDIF»«FOR attribute: attributes SEPARATOR ", "»"«attribute.name»"«ENDFOR»]«ENDIF»
)'''
	
	private def List<String> paramList(SingleClientAttribute it) {
		var paramList = new ArrayList<String>()
		for (item : allParentAttributesInclusiveItem) {
			if (item.eContainer instanceof GroupedClientAttribute) {
				paramList.add('''"«(item.eContainer as GroupedClientAttribute).name»"''')
			} else {
				paramList.add('''"«item.name»"''')
			}
		}
		return paramList
	}
	
	private def String path(List<String> paramList) '''[«FOR param: paramList SEPARATOR ", "»«param»«ENDFOR»]'''
	
	private def List<String> groupVerifications(SingleClientAttribute it, String functionName) {
		var verifications = new ArrayList<String>()
		val parentAttributes = functionName == "set" ? allParentAttributesExclusiveItem : allParentAttributesInclusiveItem;
		for (item : parentAttributes) {
			if (item.eContainer instanceof GroupedClientAttribute) {
				verifications.add('''{ path: «item.paramList.path», group: "«item.name»" }''')
			}
		}
		return verifications
	}
	
	private def String stateFunctionName(SingleClientAttribute it, String functionName) {
		if (isHash) {
			return functionName + "Hash"
		}
		if (isStorage) {
			return functionName + "Storage"
		}
		return functionName
	}
		
	private def List<SingleClientAttribute> allParentAttributesInclusiveItem(SingleClientAttribute it) {
		var attributes = new ArrayList<SingleClientAttribute>();
		attributes.add(it);
		var parent = eContainer;
		while (parent !== null) {
			if (parent instanceof SingleClientAttribute) {
				attributes.add(0, parent as SingleClientAttribute)
			}
			parent = parent.eContainer;
		}
		return attributes
	}
	
	private def List<SingleClientAttribute> allParentAttributesExclusiveItem(SingleClientAttribute it) {
		var attributes = new ArrayList<SingleClientAttribute>();
		var parent = eContainer;
		while (parent !== null) {
			if (parent instanceof SingleClientAttribute) {
				attributes.add(0, parent as SingleClientAttribute)
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
		if (whenBlock !== null) {
			var httpClient = whenBlock.action.eContainer as HttpClient
			if (!list.contains(httpClient)) {
				list.add(httpClient)
			}
		}
		for(ClientGivenRef givenRef: givenRefs) {
			givenRef.scenario.allReferencedHttpClientsRec(list);
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

	def dispatch CharSequence valueFrom(
		JsonObjectClient it) '''
		«IF it !== null && members !== null && members.size > 0»
			{ 
				«FOR member : members SEPARATOR ",\n"»«member.attribute.name» : «member.value.valueFrom()»«ENDFOR»
			}
		«ELSE»{}
		«ENDIF»
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
			return 
				'''
					[
						«FOR value: (it as JsonArrayClient).values SEPARATOR ","»«value.valueFrom»«ENDFOR»
					]
				''';
		}
	}
	
	dispatch def String componentName(SingleClientAttribute it) {
		if (isList) {
			return '''«name.toFirstUpper»Item'''
		}
		return '''«name.toFirstUpper»'''
	}

	dispatch def String componentName(GroupedClientAttribute it) {
		return '''«name.toFirstUpper»'''
	}

	dispatch def String importComponent(SingleClientAttribute it, String subFolder) '''
		«IF attributes.size > 0 && !noComponent»
			import { «componentName» } from ".«subFolder»/«componentName»";
		«ENDIF»
	'''

	dispatch def String importComponent(GroupedClientAttribute it, String subFolder) '''
		«IF attributeGroup.size > 0»
			import { «componentName» } from ".«subFolder»/«componentName»";
		«ENDIF»
	'''

	dispatch def String stateRefPath(GroupedClientAttribute it) {
		return elementPathRec("")
	}

	dispatch def String stateRefPath(SingleClientAttribute it) {
		return elementPathRec("")
	}
	
	private def String elementPathRec(ClientAttribute attr, String suffix) {
		var clientAttribute = attr
		if (clientAttribute.eContainer instanceof GroupedClientAttribute) {
			clientAttribute = attr.eContainer as ClientAttribute
		}
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
			if (grandParent !== null && grandParent instanceof GroupedClientAttribute) {
				return grandParent as GroupedClientAttribute
			} else if (parent instanceof SingleClientAttribute) {
				return parent as SingleClientAttribute
			}
			parent = grandParent;
		}
		return null;
	}
	


}
/******* S.D.G. *******/
