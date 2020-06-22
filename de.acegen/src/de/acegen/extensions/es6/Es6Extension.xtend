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
import de.acegen.aceGen.HttpClientStateFunction
import de.acegen.aceGen.Model
import de.acegen.aceGen.HttpClient

class Es6Extension {
	def String packageFolder(HttpClient it) '''«getName.replace('.', '/')»'''

	def String projectName(HttpClient it) '''«getName.toFirstUpper»'''

	def String appStateFunction(HttpClientStateFunction it) '''AppState.«getStateFunctionType»'''
	
	def String functionName(Attribute element) '''«element.functionName("")»'''
	
	def String functionName(Attribute it, String suffix) {
		val parent = eContainer;
		if (parent instanceof Model) {
			//var typeDef = parent as Model;
			return /*(typeDef.eContainer as Attribute).functionName("_" + getName) +*/ '''«IF suffix.length > 0»_«suffix»«ENDIF»''' 		
		} else {
			return getName + '''«IF suffix.length > 0»_«suffix»«ENDIF»''';
		}
	}

	def String elementPath(Attribute element) '''«element.elementPath("")»'''
	
	def String elementPath(Attribute it, String suffix) {
		val parent = eContainer;
		if (parent instanceof Model) {
			//var typeDef = parent as Model;
			return /*(typeDef.eContainer as Attribute).elementPath(getName) +*/ '''«IF suffix.length > 0».«suffix»«ENDIF»''' 		
		} else {
			return getName + '''«IF suffix.length > 0».«suffix»«ENDIF»''';
		}
	}

}
	
	
/******* S.D.G. *******/
	
	
