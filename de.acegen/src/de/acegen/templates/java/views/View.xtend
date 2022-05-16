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


package de.acegen.templates.java.views

import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerView
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.java.ModelExtension
import de.acegen.extensions.java.ViewExtension
import javax.inject.Inject

class View {
	
	@Inject
	extension ViewExtension

	@Inject
	extension ModelExtension

	@Inject
	extension CommonExtension
	
	def generateView(HttpServerView it, HttpServer java) '''
		«copyright»
		
		package «java.getName».views;
		
		import de.acegen.IDaoProvider;
		
		import de.acegen.IDataContainer;
		import de.acegen.PersistenceHandle;
		«FOR renderFunction : renderFunctions»
			«renderFunction.getModel.dataImport»
		«ENDFOR»
		
		public class «viewName» implements «viewInterfaceName» {
		
			private IDaoProvider daoProvider;
			
			public «viewName»(IDaoProvider daoProvider) {
				super();
				this.daoProvider = daoProvider;
			}
		
			«FOR renderFunction : renderFunctions»
				public void «renderFunction.getName»(«renderFunction.getModel.dataInterfaceName» data, PersistenceHandle handle) {
				}
			«ENDFOR»
		
		}
		
		
		«sdg»
		
	'''

	def generateViewInterface(HttpServerView it, HttpServer java) '''
		«copyright»
		
		package «java.getName».views;
		
		
		import de.acegen.IDataContainer;
		import de.acegen.PersistenceHandle;
		«FOR renderFunction : renderFunctions»
			«renderFunction.getModel.dataImport»
		«ENDFOR»
		
		@SuppressWarnings("all")
		public interface «viewInterfaceName» {
		
			«FOR renderFunction : renderFunctions»
				void «renderFunction.getName»(«renderFunction.getModel.dataInterfaceName» data, PersistenceHandle handle);
			«ENDFOR»
		
		}
		
		
		«sdg»
		
	'''

	
}