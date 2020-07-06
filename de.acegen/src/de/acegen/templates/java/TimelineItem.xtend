package de.acegen.templates.java

import de.acegen.extensions.CommonExtension
import javax.inject.Inject

class TimelineItem {
	
	@Inject
	extension CommonExtension
	
	def generateITimelineItem() '''
		«copyright»
		
		package de.acegen;
		
		import java.time.LocalDateTime;
		import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
		
		@JsonDeserialize(as=TimelineItem.class)
		public interface ITimelineItem {
		
			String getType();
			
			String getName();
			
			LocalDateTime getTimestamp();
			
			String getData();
			
			String getUuid();
		}
		
		«sdg»
		
	'''

	def generateTimelineItem() '''
		«copyright»
		
		package de.acegen;
		
		import java.time.LocalDateTime;
		import com.fasterxml.jackson.annotation.JsonProperty;
		
		public class TimelineItem implements ITimelineItem {
		
			private String type;
			
			private String name;
			
			private LocalDateTime timestamp;
			
			private String data;
			
			private String uuid;
		
			
			public TimelineItem(
				@JsonProperty("type") String type, 
				@JsonProperty("name") String name, 
				@JsonProperty("timestamp") LocalDateTime timestamp, 
				@JsonProperty("data") String data,
				@JsonProperty("uuid") String uuid
			) {
				super();
				this.type = type;
				this.name = name;
				this.timestamp = timestamp;
				this.data = data;
				this.uuid = uuid;
			}
		
			@JsonProperty
			public String getType() {
				return type;
			}
		
			@JsonProperty
			public String getName() {
				return name;
			}
		
			@JsonProperty
			public LocalDateTime getTimestamp() {
				return timestamp;
			}
		
			@JsonProperty
			public String getData() {
				return data;
			}
		
			@JsonProperty
			public String getUuid() {
				return uuid;
			}
			
			@Override
			public String toString() {
				return "TimelineItem [type=" + type + ", name=" + name + ", timestamp="
						+ timestamp + ", uuid=" + uuid + "]";
			}
		
		}
		
		
		«sdg»
		
	'''

	def generateTimelineItemMapper() '''
		«copyright»

		package de.acegen;
		
		import java.sql.ResultSet;
		import java.sql.SQLException;
		
		import org.jdbi.v3.core.mapper.RowMapper;
		import org.jdbi.v3.core.statement.StatementContext;
		
		public class TimelineItemMapper implements RowMapper<ITimelineItem> {
			
			public ITimelineItem map(ResultSet r, StatementContext ctx) throws SQLException {
				return new TimelineItem(
					r.getString("type"),
					r.getString("name"),
					r.getTimestamp("time") != null ? r.getTimestamp("time").toLocalDateTime() : null,
					r.getString("data"),
					r.getString("uuid")
				);
			}
		}
		
		
		«sdg»
		
	'''

	
	
}