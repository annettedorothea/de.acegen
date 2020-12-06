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
import de.acegen.aceGen.HttpServerAce
import de.acegen.aceGen.HttpServerOutcome
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.java.AceExtension
import de.acegen.extensions.java.ModelExtension
import javax.inject.Inject

class Event {

	@Inject
	extension AceExtension

	@Inject
	extension ModelExtension

	@Inject
	extension CommonExtension
	
	def generateEventFile(HttpServerAce it, HttpServerOutcome outcome, HttpServer java) '''
		«copyright»
		
		package «java.getName».events;
		
		import de.acegen.Event;
		import de.acegen.IDaoProvider;
		import de.acegen.ViewProvider;
		import de.acegen.CustomAppConfiguration;
		
		«getModel.dataImport»
		
		public class «eventName(outcome)» extends Event<«getModel.dataParamType»> {
		
			public «eventName(outcome)»(«getModel.dataParamType» eventData, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
				super("«java.getName».events.«eventName(outcome)»", eventData, daoProvider, viewProvider, appConfiguration);
			}
		
		}
		
		«sdg»
		
	'''

	def generateEvent() '''
		«copyright»
		
		package de.acegen;
		
		import java.util.List;
		
		public abstract class Event<T extends IDataContainer> implements IEvent {
		
			private T eventData;
			private String eventName;
			private IDaoProvider daoProvider;
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
		
			public void notifyAfterCommitListeners(PersistenceHandle handle) {
				List<EventConsumer> consumerList = viewProvider.getAfterCommitConsumerForEvent(eventName);
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
				if (appConfiguration.getConfig().writeTimeline()) {
					daoProvider.getAceDao().addEventToTimeline(this, timelineHandle);
				}
				this.notifyListeners(handle);
			}
		
			public void publishAfterCommit(PersistenceHandle handle, PersistenceHandle timelineHandle) {
				if (appConfiguration.getConfig().writeTimeline()) {
					daoProvider.getAceDao().addEventToTimeline(this, timelineHandle);
				}
				this.notifyAfterCommitListeners(handle);
			}
		
		}
		
		«sdg»
		
	'''

	def generateIEvent() '''
		«copyright»
		
		package de.acegen;
		
		public interface IEvent {
		
			String getEventName();
			
			IDataContainer getEventData();
			
			void publish(PersistenceHandle handle, PersistenceHandle timelineHandle);

			void publishAfterCommit(PersistenceHandle handle, PersistenceHandle timelineHandle);
			
			void notifyListeners(PersistenceHandle handle);

			void notifyAfterCommitListeners(PersistenceHandle handle);
		
		}
		
		«sdg»
		
	'''
	
	
}