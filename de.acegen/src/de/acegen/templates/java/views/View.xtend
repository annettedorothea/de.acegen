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