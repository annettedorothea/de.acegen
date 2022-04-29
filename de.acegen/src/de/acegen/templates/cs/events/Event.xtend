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


package de.acegen.templates.cs.events

import de.acegen.extensions.CommonExtension
import javax.inject.Inject

class Event {

	@Inject
	extension CommonExtension
	
	def generateEvent() '''
		«copyright»
		
		namespace AceGen
		{
		    public class Event<T> : IEvent<T> where T : IDataContainer
		    {
		        public string EventName { get; set; }
		        private ViewProvider viewProvider;
		
		        public Event(string eventName, ViewProvider viewProvider)
		        {
		            this.EventName = eventName;
		            this.viewProvider = viewProvider;
		        }
		
		        public void notifyListeners(T data)
		        {
		            var consumerList = this.viewProvider.GetConsumerForEvent(this.EventName);
		            if (consumerList != null)
		            {
		                foreach (System.Action<IDataContainer> consumer in consumerList)
		                {
		                    consumer(data);
		                }
		            }
		            else if (this.viewProvider.GetAfterCommitConsumerForEvent(this.EventName) == null)
		            {
		                Console.WriteLine($"No listeners for {this.EventName} found. Did you forget to register them?");
		            }
		        }
		
		        public void notifyAfterCommitListeners(T data)
		        {
		            var consumerList = this.viewProvider.GetAfterCommitConsumerForEvent(this.EventName);
		            if (consumerList != null)
		            {
		                foreach (System.Action<IDataContainer> consumer in consumerList)
		                {
		                    consumer(data);
		                }
		            }
		            else if (this.viewProvider.GetConsumerForEvent(this.EventName) == null)
		            {
		
		                Console.WriteLine($"No listeners for {this.EventName} found. Did you forget to register them?");
		            }
		        }
		
		        public void publish(T data)
		        {
					this.notifyListeners(data);
		        }
		
		        public void publishAfterCommit(T data)
		        {
					this.notifyAfterCommitListeners(data);
		        }
		    }
		}
		
		
		
		«sdg»
		
	'''

	def generateIEvent() '''
		«copyright»
		
		namespace AceGen
		{
		    public interface IEvent<T> where T : IDataContainer
		    {
		        string EventName { get; set; }
		        void publish(T data);
		        void publishAfterCommit(T data);
		        void notifyListeners(T data);
		
		        void notifyAfterCommitListeners(T data);
		    }
		}

		
		«sdg»
		
	'''
	
	
}