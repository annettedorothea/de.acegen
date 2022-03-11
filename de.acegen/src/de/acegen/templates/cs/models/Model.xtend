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


package de.acegen.templates.cs.models

import de.acegen.aceGen.HttpServer
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.cs.CsHttpServerExtension
import de.acegen.extensions.cs.AttributeExtension
import de.acegen.extensions.cs.ModelExtension
import javax.inject.Inject

class Model {

	@Inject
	extension ModelExtension

	@Inject
	extension AttributeExtension

	@Inject
	extension CommonExtension
	
	@Inject
	extension CsHttpServerExtension

	def generateInterface(de.acegen.aceGen.Model it, HttpServer httpServer) '''
		«copyright»
		
		namespace «httpServer.namespace».Models;
		
		public interface «modelName» «IF superModels.size > 0»: «FOR superModel : superModels SEPARATOR ','»«superModel.interfaceWithPackage»«ENDFOR»«ENDIF»{
		
			«FOR attribute : attributes»
				«attribute.getSet»
				
			«ENDFOR»
			
		}
		
		
		«sdg»
		
	'''

	def generateClass(de.acegen.aceGen.Model it, HttpServer httpServer) '''
		«copyright»
		
		namespace «httpServer.namespace».Models;
		
		public class «modelClassName» : «modelName» {
		
			«FOR attribute : allAttributes»
				public «attribute.getSet»
			«ENDFOR»
		
			«IF allAttributes.length > 0»
				public «modelClassName»() {
				}
			«ENDIF»
		
			public «modelClassName»(
				«FOR attribute : allAttributes SEPARATOR ','»
					«attribute.param»
				«ENDFOR»
			) {
				«FOR attribute : allAttributes»
					«attribute.assign»
				«ENDFOR»
			}
		
		}
		
		«sdg»
		
	'''
}
