/********************************************************************************
 * Copyright (c) 2020 Annette Pohl
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 ********************************************************************************/


package de.acegen.templates.java.events

import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerAceRead
import de.acegen.aceGen.HttpServerAceWrite
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.java.AceExtension
import de.acegen.extensions.java.ModelExtension
import javax.inject.Inject

class EventReplayService {

	@Inject
	extension AceExtension

	@Inject
	extension ModelExtension

	@Inject
	extension CommonExtension
	
	def generateEventReplayService() '''
		«copyright»
		
		package de.acegen;
		
		public class EventReplayService {
			public static void replayEvent(String eventClass, String json, PersistenceHandle handle, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
				//delegate to package EventReplayService
			}
		}
		
		«sdg»
		
	'''

	def generateEventReplayService(HttpServer it) '''
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
		import de.acegen.PersistenceHandle;
		
		import java.io.IOException;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		@SuppressWarnings("all")
		public class EventReplayService {
			
			private static ObjectMapper mapper = new ObjectMapper();
			private static final Logger LOG = LoggerFactory.getLogger(EventReplayService.class);
		
			static {
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			}
		
			public static void replayEvent(String eventClass, String json, PersistenceHandle handle, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
				«IF eventCount > 0»
					try {
						«FOR ace : aceOperations»
							«ace.createEvent(it)»
						«ENDFOR»
					} catch (IOException e) {
						LOG.error("failed to replay event {} with data {}", eventClass, json, e);
					}
				«ENDIF»
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
					«eventName(outcome)» event = new «eventName(outcome)»(daoProvider, viewProvider, appConfiguration);
					event.notifyListeners(data, handle);
					event.notifyAfterCommitListeners(data, handle);
				}
			«ENDIF»
		«ENDFOR»
	'''
	
	private def dispatch createEvent(HttpServerAceRead it, HttpServer java) ''''''
	
	
}