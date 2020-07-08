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


package de.acegen.extensions.es6

import de.acegen.aceGen.ClientAttribute
import de.acegen.aceGen.GroupedClientAttribute
import de.acegen.aceGen.HttpClient
import de.acegen.aceGen.HttpClientStateFunction
import de.acegen.aceGen.SingleClientAttribute
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

	private def SingleClientAttribute findNextSingleClientAttributeParent(ClientAttribute it) {
		var parent = eContainer;
		while (parent !== null) {
			if (parent instanceof SingleClientAttribute) {
				return parent as SingleClientAttribute
			}
			parent = parent.eContainer;
		}
		return null;
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

}
/******* S.D.G. *******/
