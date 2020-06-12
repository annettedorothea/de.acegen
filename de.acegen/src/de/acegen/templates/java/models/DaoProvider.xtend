package de.acegen.templates.java.models

import de.acegen.extensions.CommonExtension
import javax.inject.Inject

class DaoProvider {

	@Inject
	extension CommonExtension
	
	def generateAbstractDaoProvider() '''
		«copyright»
		
		package de.acegen;
		
		public abstract class AbstractDaoProvider implements IDaoProvider {
		
			protected final AceDao aceDao = new AceDao();
		
			@Override
			public AceDao getAceDao() {
				return this.aceDao;
			}
			
		}
		
		
		«sdg»
		
	'''

	def generateDaoProvider() '''
		«copyright»
		
		package de.acegen;
		
		public class DaoProvider extends AbstractDaoProvider implements IDaoProvider {
			
			public static IDaoProvider create() {
				return new DaoProvider();
			}
			
			@Override
			public void truncateAllViews(PersistenceHandle handle) {
			}
			
		}
		
		
		«sdg»
		
	'''

	def generateIDaoProvider() '''
		«copyright»
		
		package de.acegen;
		
		public interface IDaoProvider {
			
			void truncateAllViews(PersistenceHandle handle);
			
			AceDao getAceDao();
		
		}
		
		
		«sdg»
		
	'''

	
}