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

import de.acegen.aceGen.Attribute
import de.acegen.aceGen.HttpClient
import de.acegen.aceGen.HttpClientStateFunction
import java.util.ArrayList
import java.util.List
import org.eclipse.emf.ecore.EObject

class Es6Extension {
	def String packageFolder(HttpClient it) '''«getName.replace('.', '/')»'''

	def String projectName(HttpClient it) '''«getName.toFirstUpper»'''

	def String appStateFunction(HttpClientStateFunction it) '''AppState.«getStateFunctionType»_«stateElement.functionName(stateElement.eContainer)»'''
	
	def String functionName(Attribute it, EObject parent) '''«functionNameRec(parent, "")»'''
	
	def String functionNameRec(Attribute it, EObject parent, String suffix) {
		if (parent !== null && parent instanceof Attribute) {
			return (parent as Attribute).functionNameRec(parent.eContainer, name) + '''«IF suffix.length > 0»_«suffix»«ENDIF»''' 		
		} else {
			return getName + '''«IF suffix.length > 0»_«suffix»«ENDIF»''';
		}
	}

	def String elementPath(Attribute it, EObject parent) '''appState.«elementPathRec(parent, "")»'''
	
	def String elementPathRec(Attribute it, EObject parent, String suffix) {
		if (parent !== null && parent instanceof Attribute) {
			return (parent as Attribute).elementPathRec(parent.eContainer, name) + '''«IF suffix.length > 0».«suffix»«ENDIF»''' 		
		} else {
			return getName + '''«IF suffix.length > 0».«suffix»«ENDIF»''';
		}
	}

	def List<Attribute> allParentAttributes(Attribute it) {
		var attributes = new ArrayList<Attribute>();
		var parent = eContainer;
		while (parent instanceof Attribute) {
			attributes.add(0, parent as Attribute)
			parent = parent.eContainer;
		}
		return attributes
	}

}
	
	
/******* S.D.G. *******/
	
	
