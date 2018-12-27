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
		
		import javax.ws.rs.WebApplicationException;
		
		import com.anfelisa.ace.DatabaseHandle;
		import com.anfelisa.ace.Event;
		import com.anfelisa.ace.IDaoProvider;
		import com.anfelisa.ace.ViewProvider;
		
		«model.dataImport»
		
		public class «eventName(outcome)» extends Event<«model.dataParamType»> {
		
			public «eventName(outcome)»(«model.dataParamType» eventData, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
				super("«java.name».events.«eventName(outcome)»", eventData, databaseHandle, daoProvider, viewProvider);
			}
			
			public «eventName(outcome)»(DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
				super("«java.name».events.«eventName(outcome)»", null, databaseHandle, daoProvider, viewProvider);
			}
			
			public void initEventData(String json) {
				try {
					this.eventData = mapper.readValue(json, «model.dataParamType».class);
				} catch (Exception e) {
					throw new WebApplicationException(e);
				}
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
		public class «viewName» {
		
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
		
		import com.fasterxml.jackson.annotation.JsonIgnore;
		
		public abstract class Event<T extends IDataContainer> implements IEvent {
		
			static final Logger LOG = LoggerFactory.getLogger(Event.class);
		
			protected T eventData;
			private String eventName;
			@JsonIgnore
			protected DatabaseHandle databaseHandle;
			protected JodaObjectMapper mapper;
			protected IDaoProvider daoProvider;
			private ViewProvider viewProvider;
		
			public Event(String eventName, T eventData, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
				super();
				this.eventData = eventData;
				this.eventName = eventName;
				this.databaseHandle = databaseHandle;
				this.daoProvider = daoProvider;
				mapper = new JodaObjectMapper();
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
		
			@JsonIgnore
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
		
		import com.fasterxml.jackson.annotation.JsonIgnore;
		
		public interface IEvent {
		
			String getEventName();
			
			IDataContainer getEventData();
			
			@JsonIgnore
			DatabaseHandle getDatabaseHandle();
			
			void publish();
			
			void initEventData(String json);
			
			void notifyListeners();
		
		}
		
	'''
	
}
