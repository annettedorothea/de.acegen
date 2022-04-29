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


package de.acegen.templates.cs.views

import de.acegen.extensions.CommonExtension
import javax.inject.Inject

class ViewProvider {

	@Inject
	extension CommonExtension
	
	def generateViewProvider() '''
		«copyright»
		
		namespace AceGen
		{
		    public class ViewProvider
		    {
		        private Dictionary<string, List<System.Action<IDataContainer>>> ConsumerMap;
		        private Dictionary<string, List<System.Action<IDataContainer>>> AfterCommitConsumerMap;
		
		        public ViewProvider()
		        {
		            ConsumerMap = new Dictionary<string, List<System.Action<IDataContainer>>>();
		            AfterCommitConsumerMap = new Dictionary<string, List<System.Action<IDataContainer>>>();
		        }
		
		        public void AddConsumer(string name, System.Action<IDataContainer> eventConsumer) {
		            var consumerForEvent = ConsumerMap.FirstOrDefault(e => e.Key == name).Value;
		            if (consumerForEvent == null) {
		                consumerForEvent = new List<System.Action<IDataContainer>>();
		                ConsumerMap[name] = (consumerForEvent);
		            }
		            consumerForEvent.Add(eventConsumer);
		        }
		
		        public void AddAfterCommitConsumer(string name, System.Action<IDataContainer> eventConsumer) {
		            var consumerForEvent = AfterCommitConsumerMap.FirstOrDefault(e => e.Key == name).Value;
		            if (consumerForEvent == null) {
		                consumerForEvent = new List<System.Action<IDataContainer>>();
		                AfterCommitConsumerMap[name] = (consumerForEvent);
		            }
		            consumerForEvent.Add(eventConsumer);
		        }
		
		        public List<System.Action<IDataContainer>> GetConsumerForEvent(string name) {
		            return ConsumerMap.FirstOrDefault(e => e.Key == name).Value;
		        }
		
		        public List<System.Action<IDataContainer>> GetAfterCommitConsumerForEvent(string name) {
		            return AfterCommitConsumerMap.FirstOrDefault(e => e.Key == name).Value;
		        }
		    }
		}
		
		«sdg»
		
	'''

	
}