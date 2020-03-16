/* 
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */
 

package de.acegen.templates.java

import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerAce
import de.acegen.aceGen.HttpServerAceRead
import de.acegen.aceGen.HttpServerAceWrite
import de.acegen.aceGen.HttpServerOutcome
import de.acegen.aceGen.HttpServerView
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.java.AceExtension
import de.acegen.extensions.java.ModelExtension
import de.acegen.extensions.java.ViewExtension
import javax.inject.Inject

class EventTemplate {
	@Inject
	extension AceExtension

	@Inject
	extension ViewExtension

	@Inject
	extension ModelExtension

	@Inject
	extension CommonExtension
	
	def generateAbstractEventFile(HttpServerAce it, HttpServerOutcome outcome, HttpServer java) '''
		«copyright»
		
		package «java.getName».events;
		
		import com.anfelisa.ace.Event;
		import com.anfelisa.ace.IDaoProvider;
		import com.anfelisa.ace.ViewProvider;
		import com.anfelisa.ace.CustomAppConfiguration;
		
		«getModel.dataImport»
		
		public class «eventName(outcome)» extends Event<«getModel.dataParamType»> {
		
			public «eventName(outcome)»(«getModel.dataParamType» eventData, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
				super("«java.getName».events.«eventName(outcome)»", eventData, daoProvider, viewProvider, appConfiguration);
			}
		
		}
		
		
		«sdg»
		
	'''

	def generateView(HttpServerView it, HttpServer java) '''
		«copyright»
		
		package «java.getName».views;
		
		import com.anfelisa.ace.IDaoProvider;
		
		import com.anfelisa.ace.IDataContainer;
		import com.anfelisa.ace.PersistenceHandle;
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
		
		
		import com.anfelisa.ace.IDataContainer;
		import com.anfelisa.ace.PersistenceHandle;
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

	def generateEvent() '''
		«copyright»
		
		package com.anfelisa.ace;
		
		import java.util.List;
		
		public abstract class Event<T extends IDataContainer> implements IEvent {
		
			protected T eventData;
			private String eventName;
			protected IDaoProvider daoProvider;
			private ViewProvider viewProvider;
			private CustomAppConfiguration appConfiguration;
		
			public Event(String eventName, T eventData, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
				super();
				this.eventData = eventData;
				this.eventName = eventName;
				this.daoProvider = daoProvider;
				this.viewProvider = viewProvider;
				this.appConfiguration = appConfiguration;
			}
		
			public void notifyListeners(PersistenceHandle handle) {
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
		
			public void publish(PersistenceHandle handle, PersistenceHandle timelineHandle) {
				if (appConfiguration.getServerConfiguration().writeTimeline()) {
					daoProvider.getAceDao().addEventToTimeline(this, timelineHandle);
				}
				this.notifyListeners(handle);
			}
		
		}
		
		
		«sdg»
		
	'''

	def generateIEvent() '''
		«copyright»
		
		package com.anfelisa.ace;
		
		public interface IEvent {
		
			String getEventName();
			
			IDataContainer getEventData();
			
			void publish(PersistenceHandle handle, PersistenceHandle timelineHandle);
			
			void notifyListeners(PersistenceHandle handle);
		
		}
		
		
		«sdg»
		
	'''
	
	def generateEventFactory(HttpServer it) '''
		«copyright»
		
		package «getName».events;
		
		import com.anfelisa.ace.IDaoProvider;
		import com.anfelisa.ace.IEvent;
		import com.anfelisa.ace.ViewProvider;
		import «getName».data.*;
		import com.anfelisa.ace.JodaObjectMapper;
		import com.fasterxml.jackson.databind.DeserializationFeature;
		import com.anfelisa.ace.IDataContainer;
		import com.anfelisa.ace.CustomAppConfiguration;
		
		import java.io.IOException;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		public class EventFactory {
			
			private static JodaObjectMapper mapper = new JodaObjectMapper();
			private static final Logger LOG = LoggerFactory.getLogger(EventFactory.class);
		
			static {
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			}
		
			public static IEvent createEvent(String eventClass, String json, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
				try {
					«FOR ace : aceOperations»
						«ace.createEvent(it)»
					«ENDFOR»
				} catch (IOException e) {
					LOG.error("failed to create event {} with data {}", eventClass, json, e);
				}
		
				return null;
			}
		
			public static IEvent createEvent(String eventClass, IDataContainer data, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
				«FOR ace : aceOperations»
					«ace.createEventFromData(it)»

				«ENDFOR»
		
				return null;
			}
		}
		
		
		«sdg»
		
	'''
	
	private def dispatch createEvent(HttpServerAceWrite it, HttpServer java) '''
		«FOR outcome : outcomes»
			«IF outcome.listeners.size > 0»
				if (eventClass.equals("«java.getName».events.«eventName(outcome)»")) {
					«getModel.dataName» data = mapper.readValue(json, «getModel.dataName».class);
					data.migrateLegacyData(json);
					«eventName(outcome)» event = new «eventName(outcome)»(data, daoProvider, viewProvider, appConfiguration);
					return event;
				}
			«ENDIF»
		«ENDFOR»
	'''
	
	private def dispatch createEvent(HttpServerAceRead it, HttpServer java) ''''''
	
	private def dispatch createEventFromData(HttpServerAceWrite it, HttpServer java) '''
		«FOR outcome : outcomes»
			«IF outcome.listeners.size > 0»
				if (eventClass.equals("«java.getName».events.«eventName(outcome)»")) {
					return new «eventName(outcome)»((«getModel.dataName»)data, daoProvider, viewProvider, appConfiguration);
				}
			«ENDIF»
		«ENDFOR»
	'''
	
	private def dispatch createEventFromData(HttpServerAceRead it, HttpServer java) ''''''
	
	def generateEventFactory() '''
		«copyright»
		
		package com.anfelisa.ace;
		
		public class EventFactory {
			public static IEvent createEvent(String eventClass, String json, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
				//delegate to package EventFactory
				return null;
			}
			public static IEvent createEvent(String eventClass, IDataContainer data, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
				//delegate to package EventFactory
				return null;
			}
		}
		
		
		«sdg»
		
	'''
	
}
	
	
/******* S.D.G. *******/
	
	
