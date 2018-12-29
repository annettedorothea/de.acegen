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
		
		import com.anfelisa.ace.DatabaseHandle;
		import com.anfelisa.ace.Event;
		import com.anfelisa.ace.IDaoProvider;
		import com.anfelisa.ace.ViewProvider;
		
		«model.dataImport»
		
		public class «eventName(outcome)» extends Event<«model.dataParamType»> {
		
			public «eventName(outcome)»(«model.dataParamType» eventData, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
				super("«java.name».events.«eventName(outcome)»", eventData, databaseHandle, daoProvider, viewProvider);
			}
		
		}
		
		/*       S.D.G.       */
	'''

	def generateView(JAVA_View it, JAVA java) '''
		package «java.name».views;
		
		import java.util.function.BiConsumer;
		import com.anfelisa.ace.IDaoProvider;
		
		import org.jdbi.v3.core.Handle;
		
		import com.anfelisa.ace.IDataContainer;
		«FOR renderFunction : renderFunctions»
			«renderFunction.model.dataImport»
		«ENDFOR»
		
		@SuppressWarnings("all")
		public class «viewName» implements I«viewName» {
		
			private IDaoProvider daoProvider;
			
			public «viewName»(IDaoProvider daoProvider) {
				super();
				this.daoProvider = daoProvider;
			}
		
			«FOR renderFunction : renderFunctions»
				public BiConsumer<«renderFunction.model.dataName», Handle> «renderFunction.name» = (dataContainer, handle) -> {
				};
			«ENDFOR»
		
		}
		
		/*                    S.D.G.                    */
	'''

	def generateEvent() '''
		package com.anfelisa.ace;
		
		import java.util.List;
		import java.util.function.BiConsumer;
		
		import org.jdbi.v3.core.Handle;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		public abstract class Event<T extends IDataContainer> implements IEvent {
		
			static final Logger LOG = LoggerFactory.getLogger(Event.class);
		
			protected T eventData;
			private String eventName;
			protected DatabaseHandle databaseHandle;
			protected IDaoProvider daoProvider;
			private ViewProvider viewProvider;
		
			public Event(String eventName, T eventData, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
				super();
				this.eventData = eventData;
				this.eventName = eventName;
				this.databaseHandle = databaseHandle;
				this.daoProvider = daoProvider;
				this.viewProvider = viewProvider;
			}
		
			@SuppressWarnings("unchecked")
			public void notifyListeners() {
			List<BiConsumer<? extends IDataContainer, Handle>> consumerList = viewProvider.getConsumerForEvent(eventName);
			if (consumerList != null) {
				for (BiConsumer<? extends IDataContainer, Handle> consumer : consumerList) {
					((BiConsumer<T, Handle>)consumer).accept(this.eventData, databaseHandle.getHandle());
				}
			}
			}
		
			public IDataContainer getEventData() {
				return eventData;
			}
		
			public String getEventName() {
				return eventName;
			}
		
			public DatabaseHandle getDatabaseHandle() {
				return databaseHandle;
			}
		
			public void publish() {
				daoProvider.addEventToTimeline(this);
				this.notifyListeners();
			}
		
		}
		
	'''

	def generateIEvent() '''
		package com.anfelisa.ace;
		
		public interface IEvent {
		
			String getEventName();
			
			IDataContainer getEventData();
			
			DatabaseHandle getDatabaseHandle();
			
			void publish();
			
			void notifyListeners();
		
		}
		
	'''
	
	def generateEventFactory(JAVA it) '''
		package «name».events;
		
		import com.anfelisa.ace.DatabaseHandle;
		import com.anfelisa.ace.IDaoProvider;
		import com.anfelisa.ace.IEvent;
		import com.anfelisa.ace.ViewProvider;
		import «name».data.*;
		import com.anfelisa.ace.JodaObjectMapper;
		import com.fasterxml.jackson.databind.DeserializationFeature;
		
		import java.io.IOException;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		public class EventFactory {
			
			private static JodaObjectMapper mapper = new JodaObjectMapper();
			private static final Logger LOG = LoggerFactory.getLogger(EventFactory.class);
		
			static {
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			}
		
			public static IEvent createEvent(String eventClass, String json, DatabaseHandle databaseHandle,
				IDaoProvider daoProvider, ViewProvider viewProvider) {
				try {
					«FOR ace : aceOperations»
						«FOR outcome : ace.outcomes»
							«IF outcome.listeners.size > 0»
								if (eventClass.equals("«name».events.«ace.eventName(outcome)»")) {
									«ace.model.dataName» data = mapper.readValue(json, «ace.model.dataName».class);
									data.migrateLegacyData(json);
									«ace.eventName(outcome)» event = new «ace.eventName(outcome)»(data, databaseHandle, daoProvider, viewProvider);
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
		}
		
	'''
	
	def generateEventFactory() '''
		package com.anfelisa.ace;
		
		public class EventFactory {
			public static IEvent createEvent(String eventClass, String json, DatabaseHandle databaseHandle,
					IDaoProvider daoProvider, ViewProvider viewProvider) {
				//delegate to package EventFactory
				return null;
			}
		}
		
	'''
	
}
