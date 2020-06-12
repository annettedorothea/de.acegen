package de.acegen.templates.java

import de.acegen.extensions.CommonExtension
import javax.inject.Inject

class AceOperation {
	
	@Inject
	extension CommonExtension
	
	def generate() '''
		«copyright»
		
		package de.acegen;
		
		public class AceOperation {
		
			private ITimelineItem action;
			private ITimelineItem command;
			private ITimelineItem event;
			private String uuid;
		
			public AceOperation(String uuid) {
				super();
				this.uuid = uuid;
			}
			public ITimelineItem getAction() {
				return action;
			}
			public ITimelineItem getCommand() {
				return command;
			}
			public ITimelineItem getEvent() {
				return event;
			}
			public void setAction(ITimelineItem action) {
				this.action = action;
			}
			public void setCommand(ITimelineItem command) {
				this.command = command;
			}
			public void setEvent(ITimelineItem event) {
				this.event = event;
			}
			public String getUuid() {
				return uuid;
			}
			
		}
		
		«sdg»
		
	'''

}