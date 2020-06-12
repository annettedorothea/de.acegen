package de.acegen.templates.java.views

import de.acegen.extensions.CommonExtension
import javax.inject.Inject

class ViewProvider {

	@Inject
	extension CommonExtension
	
	def generateViewProvider() '''
		«copyright»
		
		package de.acegen;
		
		public class ViewProvider extends AbstractViewProvider {
		
			public ViewProvider() {
			}
		
			public static ViewProvider create(IDaoProvider daoProvider, CustomAppConfiguration configuration) {
				return new ViewProvider();
			}
		
		}
		
		
		«sdg»
		
	'''

	def generateAbstractViewProvider() '''
		«copyright»
		
		package de.acegen;
		
		import java.util.ArrayList;
		import java.util.HashMap;
		import java.util.List;
		import java.util.Map;
		
		public class AbstractViewProvider {
		
			private final Map<String, List<EventConsumer>> consumerMap;
		
			public AbstractViewProvider() {
				consumerMap = new HashMap<String, List<EventConsumer>>();
			}
			
			public void addConsumer(String eventName, EventConsumer eventConsumer) {
				List<EventConsumer> consumerForEvent = consumerMap.get(eventName);
				if (consumerForEvent == null) {
					consumerForEvent = new ArrayList<EventConsumer>();
					consumerMap.put(eventName, consumerForEvent);
				}
				consumerForEvent.add(eventConsumer);
			}
		
			public List<EventConsumer> getConsumerForEvent(String eventName) {
				return consumerMap.get(eventName);
			}
		
		}
		
		
		«sdg»
		
	'''

	
}