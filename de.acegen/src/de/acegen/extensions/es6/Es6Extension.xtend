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
import de.acegen.aceGen.HttpClientAce
import de.acegen.aceGen.HttpClientStateFunction
import de.acegen.aceGen.JsonArrayClient
import de.acegen.aceGen.JsonObjectClient
import de.acegen.aceGen.JsonValueClient
import de.acegen.aceGen.LongType
import de.acegen.aceGen.NullType
import de.acegen.aceGen.PrimitiveValue
import de.acegen.aceGen.SingleClientAttribute
import de.acegen.aceGen.StringType
import java.util.ArrayList
import java.util.List

class Es6Extension {
	def String packageFolder(HttpClient it) '''«getName.replace('.', '/')»'''

	def String projectName(HttpClient it) '''«getName.toFirstUpper»'''

	def String appStateFunction(
		HttpClientStateFunction it) '''AppState.«getStateFunctionType»_«stateElement.functionName»'''

	def String functionName(SingleClientAttribute it) '''«functionNameRec("")»'''

	def String functionNameRec(ClientAttribute it, String suffix) {
		val parent = findNextSingleClientAttributeParent
		if (parent !== null) {
			return parent.functionNameRec(name) + '''«IF suffix.length > 0»_«suffix»«ENDIF»'''
		} else {
			return getName + '''«IF suffix.length > 0»_«suffix»«ENDIF»''';
		}
	}

	def String elementPath(ClientAttribute it) '''appState.«elementPathRec("")»'''

	def String elementPathRec(ClientAttribute attr, String suffix) {
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

	def SingleClientAttribute findNextSingleClientAttributeParent(ClientAttribute it) {
		var parent = eContainer;
		while (parent !== null) {
			if (parent instanceof SingleClientAttribute) {
				return parent as SingleClientAttribute
			}
			parent = parent.eContainer;
		}
		return null;
	}

	def SingleClientAttribute findNextNonListSingleClientAttributeParent(ClientAttribute it) {
		var parentList = new ArrayList();
		if (it instanceof SingleClientAttribute) {
			val me = it as SingleClientAttribute
			if (me.attributes.size > 0) {
				parentList.add(me)
			}
		}
		var parent = eContainer;
		while (parent !== null) {
			if (parent instanceof SingleClientAttribute) {
				parentList.add(parent as SingleClientAttribute)
			}
			parent = parent.eContainer;
		}
		if (parentList.size === 0) {
			return null;
		}
		var i = parentList.size-1;
		while(i >= 0) {
			if (parentList.get(i).isList) {
				if (i+1 <= parentList.size-1) {
					return parentList.get(i+1)
				} else {
					return null;
				}
			}
			i--;
		} 
		if (parentList.get(0).isList) {
			return null
		} else {
			parentList.get(0)
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

	def List<ClientAttribute> allParentAttributes(ClientAttribute it) {
		var attributes = new ArrayList<ClientAttribute>();
		var parent = eContainer;
		while (parent !== null) {
			val grandParent = parent.eContainer
			if (parent instanceof SingleClientAttribute) {
				attributes.add(0, parent as SingleClientAttribute)
			}
			parent = grandParent;
		}
		return attributes
	}
	
	def List<HttpClient> allReferencedHttpClients(ClientScenario it) {
		var list = new ArrayList<HttpClient>();
		allReferencedHttpClientsRec(list);
		return list;
	}
	
	def void allReferencedHttpClientsRec(ClientScenario it, ArrayList<HttpClient> list) {
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
		} else if (it instanceof JsonArrayClient) {
			return 
				'''
					[
						«FOR value: (it as JsonArrayClient).values SEPARATOR ","»«value.valueFrom»«ENDFOR»
					]
				''';
		}
	}
	
	def int numberOfAsyncCalls(HttpClientAce it) {
		var number = 0;
		if (async || serverCall !== null) {
			number = 1
		}
		for (outcome : outcomes) {
			if (outcome.triggerdAceOperations.size > 0) {
				for (triggered : outcome.triggerdAceOperations) {
					if (triggered.aceOperation.async || triggered.aceOperation.serverCall !== null) {
						number = 2
					}
				}
			}
		}
		return number;
	}

	def int numberOfSyncCalls(HttpClientAce it) {
		var number = 0;
		if (!async && serverCall === null) {
			number = 1
		}
		for (outcome : outcomes) {
			if (outcome.triggerdAceOperations.size > 0) {
				for (triggered : outcome.triggerdAceOperations) {
					if (!triggered.aceOperation.async && triggered.aceOperation.serverCall === null) {
						number = 2
					}
				}
			}
		}
		return number;
	}
	
	dispatch def String reactComponentName(SingleClientAttribute it) {
		if (isList) {
			return '''«name.toFirstUpper»ItemComponent'''
		}
		return '''«name.toFirstUpper»Component'''
	}

	dispatch def String reactComponentName(GroupedClientAttribute it) {
		return '''«name.toFirstUpper»Component'''
	}

	dispatch def String reactTagName(SingleClientAttribute it) {
		if (isList) {
			return '''«name.toFirstLower»Item'''
		}
		return '''«name.toFirstLower»'''
	}

	dispatch def String reactTagName(GroupedClientAttribute it) {
		return '''«name.toFirstLower»'''
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

	dispatch def String stateRefPath(GroupedClientAttribute it) {
		return elementPathRec("")
	}

	dispatch def String stateRefPath(SingleClientAttribute it) {
		return elementPathRec("")
	}


}
/******* S.D.G. *******/
