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

import de.acegen.extensions.CommonExtension
import javax.inject.Inject

class Event {

	@Inject
	extension CommonExtension
	
	def generateEvent() '''
		«copyright»
		
		package de.acegen;
		
		import java.util.List;
		
		public class Event<T extends IDataContainer> implements IEvent<T> {
		
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
				} else if (viewProvider.getAfterCommitConsumerForEvent(eventName) == null) {
					System.out.println("No listeners for " + eventName + " found. Did you forget to register them?");
				}
			}
		
			public void notifyAfterCommitListeners(T data, PersistenceHandle handle) {
				List<EventConsumer> consumerList = viewProvider.getAfterCommitConsumerForEvent(eventName);
				if (consumerList != null) {
					for (EventConsumer consumer : consumerList) {
						consumer.consumeEvent(data, handle);
					}
				} else if(viewProvider.getConsumerForEvent(eventName) == null) {
					System.out.println("No listeners for " + eventName + " found. Did you forget to register them?");
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