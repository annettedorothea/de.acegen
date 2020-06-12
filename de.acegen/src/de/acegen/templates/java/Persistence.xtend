package de.acegen.templates.java

import de.acegen.extensions.CommonExtension
import javax.inject.Inject

class Persistence {

	@Inject
	extension CommonExtension
	
	def generatePersistenceHandle() '''
		«copyright»

		package de.acegen;
		
		import org.jdbi.v3.core.Handle;
		
		public class PersistenceHandle {
			
			private Handle handle;
		
			public PersistenceHandle(Handle handle) {
				super();
				this.handle = handle;
			}
		
			public Handle getHandle() {
				return handle;
			}
		
		}
		
		«sdg»
		
	'''

	def generatePersistenceConnection() '''
		«copyright»

		package de.acegen;
		
		import org.jdbi.v3.core.Jdbi;
		
		public class PersistenceConnection {
		
			private Jdbi jdbi;
		
			public PersistenceConnection(Jdbi jdbi) {
				super();
				this.jdbi = jdbi;
			}
		
			public Jdbi getJdbi() {
				return jdbi;
			}
			
		}
		
		«sdg»
		
	'''

	
}