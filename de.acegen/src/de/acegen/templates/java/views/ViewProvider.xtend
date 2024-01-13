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


package de.acegen.templates.java.views

import de.acegen.extensions.CommonExtension
import jakarta.inject.Inject

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
			private final Map<String, List<EventConsumer>> afterCommitConsumerMap;
		
			public AbstractViewProvider() {
				consumerMap = new HashMap<String, List<EventConsumer>>();
				afterCommitConsumerMap = new HashMap<String, List<EventConsumer>>();
			}
			
			public void addConsumer(String eventName, EventConsumer eventConsumer) {
				List<EventConsumer> consumerForEvent = consumerMap.get(eventName);
				if (consumerForEvent == null) {
					consumerForEvent = new ArrayList<EventConsumer>();
					consumerMap.put(eventName, consumerForEvent);
				}
				consumerForEvent.add(eventConsumer);
			}
		
			public void addAfterCommitConsumer(String eventName, EventConsumer eventConsumer) {
				List<EventConsumer> consumerForEvent = afterCommitConsumerMap.get(eventName);
				if (consumerForEvent == null) {
					consumerForEvent = new ArrayList<EventConsumer>();
					afterCommitConsumerMap.put(eventName, consumerForEvent);
				}
				consumerForEvent.add(eventConsumer);
			}
		
			public List<EventConsumer> getConsumerForEvent(String eventName) {
				return consumerMap.get(eventName);
			}
		
			public List<EventConsumer> getAfterCommitConsumerForEvent(String eventName) {
				return afterCommitConsumerMap.get(eventName);
			}
		
		}
		
		
		«sdg»
		
	'''

	
}