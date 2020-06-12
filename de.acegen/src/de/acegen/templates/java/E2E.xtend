package de.acegen.templates.java

import de.acegen.extensions.CommonExtension
import javax.inject.Inject

class E2E {
	
	@Inject
	extension CommonExtension
	
	def generate() '''
		«copyright»
		
		package de.acegen;
		
		import java.util.ArrayList;
		import java.util.HashMap;
		import java.util.List;
		import java.util.Map;
		
		import java.time.LocalDateTime;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		public class E2E {
		
			private boolean sessionIsRunning;
		
			private LocalDateTime sessionStartedAt;
		
			private Map<String, AceOperation> timeline;
		
			private List<String> uuidList;
		
			private int index;
			
			static final Logger LOG = LoggerFactory.getLogger(E2E.class);
		
			public E2E() {
				this.sessionIsRunning = false;
				this.sessionStartedAt = null;
				this.timeline = null;
				this.index = 0;
			}
			
			public boolean isSessionRunning() {
				return this.sessionIsRunning;
			}
		
			public LocalDateTime getSessionStartedAt() {
				return this.sessionStartedAt;
			}
		
			public void reset() {
				this.sessionIsRunning = false;
				this.sessionStartedAt = null;
				this.timeline = null;
				this.index = 0;
			}

		
			public void init(List<ITimelineItem> initialTimeline) {
				timeline = new HashMap<>();
				uuidList = new ArrayList<>();
				for (ITimelineItem timelineItem : initialTimeline) {
					String uuid = timelineItem.getUuid();
					if (!uuidList.contains(uuid)) {
						uuidList.add(uuid);
					}
					AceOperation aceOperation = timeline.get(uuid);
					if (aceOperation == null) {
						aceOperation = new AceOperation(uuid);
						timeline.put(uuid, aceOperation);
					}
					if ("action".equals(timelineItem.getType())) {
						aceOperation.setAction(timelineItem);
					} else if ("command".equals(timelineItem.getType())) {
						aceOperation.setCommand(timelineItem);
					} else if ("event".equals(timelineItem.getType())) {
						aceOperation.setEvent(timelineItem);
					}
				}
				this.sessionIsRunning = true;
				this.sessionStartedAt = LocalDateTime.ofEpochSecond(System.currentTimeMillis(), 0, null);
				this.index = 0;
			}
		
			public ITimelineItem selectNextAction() {
				if (index < uuidList.size()) {
					String uuid = uuidList.get(index);
					index++;
					return timeline.get(uuid).getAction();
				}
				return null;
			}
		
			public ITimelineItem selectAction(String uuid) {
				return timeline.get(uuid).getAction();
			}
		
			public ITimelineItem selectCommand(String uuid) {
				return timeline.get(uuid).getCommand();
			}
		
			public ITimelineItem selectEvent(String uuid) {
				return timeline.get(uuid).getEvent();
			}
		
		}
		
		«sdg»
		
	'''

	
}