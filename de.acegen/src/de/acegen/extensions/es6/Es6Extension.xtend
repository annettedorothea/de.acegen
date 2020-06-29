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
import de.acegen.aceGen.HttpClient
import de.acegen.aceGen.HttpClientStateFunction
import de.acegen.aceGen.SingleClientAttribute
import java.util.ArrayList
import java.util.List

class Es6Extension {
	def String packageFolder(HttpClient it) '''«getName.replace('.', '/')»'''

	def String projectName(HttpClient it) '''«getName.toFirstUpper»'''

	def String appStateFunction(HttpClientStateFunction it) '''AppState.«getStateFunctionType»_«stateElement.functionName»'''
	
	def String functionName(SingleClientAttribute it) '''«functionNameRec("")»'''
	
	def String functionNameRec(SingleClientAttribute it, String suffix) {
		val parent = findNextSingleClientAttributeParent
		if (parent !== null) {
			return parent.functionNameRec(name) + '''«IF suffix.length > 0»_«suffix»«ENDIF»''' 		
		} else {
			return getName + '''«IF suffix.length > 0»_«suffix»«ENDIF»''';
		}
	}

	def String elementPath(SingleClientAttribute it) '''appState.«elementPathRec("")»'''
	
	def String elementPathRec(SingleClientAttribute it, String suffix) {
		val parent = findNextSingleClientAttributeParent
		if (parent !== null) {
			return parent.elementPathRec( name) + '''«IF suffix.length > 0».«suffix»«ENDIF»''' 		
		} else {
			return getName + '''«IF suffix.length > 0».«suffix»«ENDIF»''';
		}
	}
	
	private def findNextSingleClientAttributeParent(ClientAttribute it) {
		var parent = eContainer;
		while (parent !== null) {
			if (parent instanceof SingleClientAttribute){
				return parent
			}
			parent = parent.eContainer;
		}
		return null;
	}

	def List<SingleClientAttribute> allParentAttributes(ClientAttribute it) {
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

}
	
	
/******* S.D.G. *******/
	
	
