package de.acegen.templates.java.events

import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerAceRead
import de.acegen.aceGen.HttpServerAceWrite
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.java.AceExtension
import de.acegen.extensions.java.ModelExtension
import javax.inject.Inject

class EventFactory {

	@Inject
	extension AceExtension

	@Inject
	extension ModelExtension

	@Inject
	extension CommonExtension
	
	def generateEventFactory() '''
		«copyright»
		
		package de.acegen;
		
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

	def generateEventFactory(HttpServer it) '''
		«copyright»
		
		package «name».events;
		
		import de.acegen.IDaoProvider;
		import de.acegen.IEvent;
		import de.acegen.ViewProvider;
		import «getName».data.*;
		import com.fasterxml.jackson.databind.DeserializationFeature;
		import com.fasterxml.jackson.databind.ObjectMapper;
		import de.acegen.IDataContainer;
		import de.acegen.CustomAppConfiguration;
		
		import java.io.IOException;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		@SuppressWarnings("all")
		public class EventFactory {
			
			private static ObjectMapper mapper = new ObjectMapper();
			private static final Logger LOG = LoggerFactory.getLogger(EventFactory.class);
		
			static {
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			}
		
			public static IEvent createEvent(String eventClass, String json, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
				«IF eventCount > 0»
					try {
						«FOR ace : aceOperations»
							«ace.createEvent(it)»
						«ENDFOR»
					} catch (IOException e) {
						LOG.error("failed to create event {} with data {}", eventClass, json, e);
					}
				«ENDIF»
		
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
	
	private def int eventCount(HttpServer it) {
		var count = 0
		for (ace : aceOperations) {
			if (ace instanceof HttpServerAceWrite) {
				val writeOp = ace as HttpServerAceWrite
				for (outcome: writeOp.outcomes) {
					count += outcome.listeners.size
				}
			}
		}
		return count
	}
	
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
	
	
}