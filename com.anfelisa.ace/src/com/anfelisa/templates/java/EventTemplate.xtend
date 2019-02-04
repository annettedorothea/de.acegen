package com.anfelisa.templates.java

import com.anfelisa.ace.JAVA
import com.anfelisa.ace.JAVA_ACE
import com.anfelisa.ace.JAVA_Outcome
import com.anfelisa.ace.JAVA_View
import com.anfelisa.extensions.java.AceExtension
import com.anfelisa.extensions.java.ModelExtension
import com.anfelisa.extensions.java.ViewExtension
import javax.inject.Inject

class EventTemplate {
	@Inject
	extension AceExtension

	@Inject
	extension ViewExtension

	@Inject
	extension ModelExtension

	def generateAbstractEventFile(JAVA_ACE it, JAVA_Outcome outcome, JAVA java) '''
		package «java.name».events;
		
		import com.anfelisa.ace.Event;
		import com.anfelisa.ace.IDaoProvider;
		import com.anfelisa.ace.ViewProvider;
		
		«model.dataImport»
		
		public class «eventName(outcome)» extends Event<«model.dataParamType»> {
		
			public «eventName(outcome)»(«model.dataParamType» eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {
				super("«java.name».events.«eventName(outcome)»", eventData, daoProvider, viewProvider);
			}
		
		}
		
		/*       S.D.G.       */
	'''

	def generateView(JAVA_View it, JAVA java) '''
		package «java.name».views;
		
		import com.anfelisa.ace.IDaoProvider;
		
		import org.jdbi.v3.core.Handle;
		
		import com.anfelisa.ace.IDataContainer;
		«FOR renderFunction : renderFunctions»
			«renderFunction.model.dataImport»
		«ENDFOR»
		
		public class «viewName» implements «viewInterfaceName» {
		
			private IDaoProvider daoProvider;
			
			public «viewName»(IDaoProvider daoProvider) {
				super();
				this.daoProvider = daoProvider;
			}
		
			«FOR renderFunction : renderFunctions»
				public void «renderFunction.name»(«renderFunction.model.dataInterfaceName» data, Handle handle) {
				}
			«ENDFOR»
		
		}
		
		/*                    S.D.G.                    */
	'''

	def generateViewInterface(JAVA_View it, JAVA java) '''
		package «java.name».views;
		
		import org.jdbi.v3.core.Handle;
		
		import com.anfelisa.ace.IDataContainer;
		«FOR renderFunction : renderFunctions»
			«renderFunction.model.dataImport»
		«ENDFOR»
		
		@SuppressWarnings("all")
		public interface «viewInterfaceName» {
		
			«FOR renderFunction : renderFunctions»
				void «renderFunction.name»(«renderFunction.model.dataInterfaceName» data, Handle handle);
			«ENDFOR»
		
		}
		
		/*                    S.D.G.                    */
	'''

	def generateEvent() '''
		package com.anfelisa.ace;
		
		import java.util.List;
		
		import org.jdbi.v3.core.Handle;
		
		public abstract class Event<T extends IDataContainer> implements IEvent {
		
			protected T eventData;
			private String eventName;
			protected IDaoProvider daoProvider;
			private ViewProvider viewProvider;
		
			public Event(String eventName, T eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {
				super();
				this.eventData = eventData;
				this.eventName = eventName;
				this.daoProvider = daoProvider;
				this.viewProvider = viewProvider;
			}
		
			public void notifyListeners(Handle handle) {
				List<EventConsumer> consumerList = viewProvider.getConsumerForEvent(eventName);
				if (consumerList != null) {
					for (EventConsumer consumer : consumerList) {
						consumer.consumeEvent(this.eventData, handle);
					}
				}
			}
		
			public IDataContainer getEventData() {
				return eventData;
			}
		
			public String getEventName() {
				return eventName;
			}
		
			public void publish(Handle handle, Handle timelineHandle) {
				daoProvider.getAceDao().addEventToTimeline(this, timelineHandle);
				this.notifyListeners(handle);
			}
		
		}
		
	'''

	def generateIEvent() '''
		package com.anfelisa.ace;
		
		import org.jdbi.v3.core.Handle;
		
		public interface IEvent {
		
			String getEventName();
			
			IDataContainer getEventData();
			
			void publish(Handle handle, Handle timelineHandle);
			
			void notifyListeners(Handle handle);
		
		}
		
	'''
	
	def generateEventFactory(JAVA it) '''
		package «name».events;
		
		import com.anfelisa.ace.IDaoProvider;
		import com.anfelisa.ace.IEvent;
		import com.anfelisa.ace.ViewProvider;
		import «name».data.*;
		import com.anfelisa.ace.JodaObjectMapper;
		import com.fasterxml.jackson.databind.DeserializationFeature;
		import com.anfelisa.ace.IDataContainer;
		
		import java.io.IOException;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		public class EventFactory {
			
			private static JodaObjectMapper mapper = new JodaObjectMapper();
			private static final Logger LOG = LoggerFactory.getLogger(EventFactory.class);
		
			static {
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			}
		
			public static IEvent createEvent(String eventClass, String json, IDaoProvider daoProvider, ViewProvider viewProvider) {
				try {
					«FOR ace : aceOperations»
						«FOR outcome : ace.outcomes»
							«IF outcome.listeners.size > 0»
								if (eventClass.equals("«name».events.«ace.eventName(outcome)»")) {
									«ace.model.dataName» data = mapper.readValue(json, «ace.model.dataName».class);
									data.migrateLegacyData(json);
									«ace.eventName(outcome)» event = new «ace.eventName(outcome)»(data, daoProvider, viewProvider);
									return event;
								}
							«ENDIF»
						«ENDFOR»
					«ENDFOR»
				} catch (IOException e) {
					LOG.error("failed to create event {} with data {}", eventClass, json, e);
				}
		
				return null;
			}
		
			public static IEvent createEvent(String eventClass, IDataContainer data, IDaoProvider daoProvider, ViewProvider viewProvider) {
				«FOR ace : aceOperations»
					«FOR outcome : ace.outcomes»
						«IF outcome.listeners.size > 0»
							if (eventClass.equals("«name».events.«ace.eventName(outcome)»")) {
								return new «ace.eventName(outcome)»((«ace.model.dataName»)data, daoProvider, viewProvider);
							}
						«ENDIF»
					«ENDFOR»
				«ENDFOR»
		
				return null;
			}
		}
		
	'''
	
	def generateEventFactory() '''
		package com.anfelisa.ace;
		
		public class EventFactory {
			public static IEvent createEvent(String eventClass, String json, IDaoProvider daoProvider, ViewProvider viewProvider) {
				//delegate to package EventFactory
				return null;
			}
			public static IEvent createEvent(String eventClass, IDataContainer data, IDaoProvider daoProvider, ViewProvider viewProvider) {
				//delegate to package EventFactory
				return null;
			}
		}
		
	'''
	
}
