package de.acegen.templates.java.events

import de.acegen.extensions.CommonExtension
import javax.inject.Inject

class EventConsumer {

	@Inject
	extension CommonExtension
	
	def generateEventconsumer() '''
		«copyright»
		
		package de.acegen;
		
		@FunctionalInterface
		public interface EventConsumer {
			public void consumeEvent(IDataContainer data, PersistenceHandle handle);
		}
		
		«sdg»
		
	'''

	
}