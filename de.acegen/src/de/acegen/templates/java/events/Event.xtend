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
		
			public «eventName(outcome)»(IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
				super("«java.getName».events.«eventName(outcome)»", daoProvider, viewProvider, appConfiguration);
			}
		
		}
		
		«sdg»
		
	'''

	def generateEvent() '''
		«copyright»
		
		package de.acegen;
		
		import java.util.List;
		
		public abstract class Event<T extends IDataContainer> implements IEvent<T> {
		
			private String eventName;
			private IDaoProvider daoProvider;
			private ViewProvider viewProvider;
			private CustomAppConfiguration appConfiguration;
		
			public Event(String eventName, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
				super();
				this.eventName = eventName;
				this.daoProvider = daoProvider;
				this.viewProvider = viewProvider;
				this.appConfiguration = appConfiguration;
			}
		
			public void notifyListeners(T data, PersistenceHandle handle) {
				List<EventConsumer> consumerList = viewProvider.getConsumerForEvent(eventName);
				if (consumerList != null) {
					for (EventConsumer consumer : consumerList) {
						consumer.consumeEvent(data, handle);
					}
				}
			}
		
			public void notifyAfterCommitListeners(T data, PersistenceHandle handle) {
				List<EventConsumer> consumerList = viewProvider.getAfterCommitConsumerForEvent(eventName);
				if (consumerList != null) {
					for (EventConsumer consumer : consumerList) {
						consumer.consumeEvent(data, handle);
					}
				}
			}
		
			public String getEventName() {
				return eventName;
			}
		
			public void publish(T data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
				if (appConfiguration.getConfig().writeTimeline()) {
					daoProvider.getAceDao().addEventToTimeline(this.getEventName(), data, timelineHandle);
				}
				this.notifyListeners(data, handle);
			}
		
			public void publishAfterCommit(T data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
				if (appConfiguration.getConfig().writeTimeline()) {
					daoProvider.getAceDao().addEventToTimeline(this.getEventName(), data, timelineHandle);
				}
				this.notifyAfterCommitListeners(data, handle);
			}
		
		}
		
		«sdg»
		
	'''

	def generateIEvent() '''
		«copyright»
		
		package de.acegen;
		
		public interface IEvent<T extends IDataContainer> {
		
			String getEventName();
			
			void publish(T data, PersistenceHandle handle, PersistenceHandle timelineHandle);

			void publishAfterCommit(T data, PersistenceHandle handle, PersistenceHandle timelineHandle);
			
			void notifyListeners(T data, PersistenceHandle handle);
			
			void notifyAfterCommitListeners(T data, PersistenceHandle handle);
			
			
		}
		
		«sdg»
		
	'''
	
	
}