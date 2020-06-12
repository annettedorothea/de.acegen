package de.acegen.templates.java.models

import de.acegen.aceGen.HttpServer
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.java.AttributeExtension
import de.acegen.extensions.java.ModelExtension
import javax.inject.Inject

class Dao {
	
	@Inject
	extension ModelExtension
	
	@Inject
	extension AttributeExtension
	
	@Inject
	extension CommonExtension
	
	def generateAbstractDao(de.acegen.aceGen.Model it, HttpServer httpServer) '''
		«copyright»
		
		package «httpServer.getName».models;
		
		import de.acegen.PersistenceHandle;

		import java.util.List;
		import java.util.Map;
		
		public abstract class «abstractModelDao» {
			
			public abstract void insert(PersistenceHandle handle, «modelName» «modelParam»);
			
			«FOR attribute : allUniqueAttributes»
				public abstract void updateBy«attribute.name.toFirstUpper»(PersistenceHandle handle, «modelName» «modelParam»);

				public abstract void deleteBy«attribute.name.toFirstUpper»(PersistenceHandle handle, «attribute.javaType» «attribute.name»);

				public abstract «modelName» selectBy«attribute.name.toFirstUpper»(PersistenceHandle handle, «attribute.javaType» «attribute.name»);
			«ENDFOR»
			
			«IF allPrimaryKeyAttributes.length > 0»
				public abstract «modelName» selectByPrimaryKey(PersistenceHandle handle, «FOR attribute : allPrimaryKeyAttributes SEPARATOR ', '»«attribute.javaType» «attribute.name»«ENDFOR»);
			«ENDIF»
			
			public abstract int filterAndCountBy(PersistenceHandle handle, Map<String, String> filterMap);

			public abstract List<«modelName»> selectAll(PersistenceHandle handle);

			public abstract void truncate(PersistenceHandle handle);

		}
		
		«sdg»
		
	'''
	
	def generateDao(de.acegen.aceGen.Model it, HttpServer httpServer) '''
		«copyright»
		
		package «httpServer.getName».models;
		
		import de.acegen.PersistenceHandle;

		import java.util.List;
		import java.util.Map;

		public class «modelDao» extends «abstractModelDao» {

			public void insert(PersistenceHandle handle, «modelName» «modelParam») {
				throw new RuntimeException("«modelDao».insert not implemented");
			}
			
			«FOR attribute : allUniqueAttributes»
				public void updateBy«attribute.name.toFirstUpper»(PersistenceHandle handle, «modelName» «modelParam») {
					throw new RuntimeException("«modelDao».updateBy«attribute.name.toFirstUpper» not implemented");
				}

				public void deleteBy«attribute.name.toFirstUpper»(PersistenceHandle handle, «attribute.javaType» «attribute.name») {
					throw new RuntimeException("«modelDao».deleteBy«attribute.name.toFirstUpper» not implemented");
				}

				public «modelName» selectBy«attribute.name.toFirstUpper»(PersistenceHandle handle, «attribute.javaType» «attribute.name») {
					throw new RuntimeException("«modelDao».selectBy«attribute.name.toFirstUpper» not implemented");
				}
			«ENDFOR»
			
			«IF allPrimaryKeyAttributes.length > 0»
				public «modelName» selectByPrimaryKey(PersistenceHandle handle, «FOR attribute : allPrimaryKeyAttributes SEPARATOR ', '»«attribute.javaType» «attribute.name»«ENDFOR») {
					throw new RuntimeException("«modelDao».selectByPrimaryKey not implemented");
				}
			«ENDIF»
			
			public int filterAndCountBy(PersistenceHandle handle, Map<String, String> filterMap) {
				throw new RuntimeException("«modelDao».filterAndCountBy not implemented");
			}

			public List<«modelName»> selectAll(PersistenceHandle handle) {
				throw new RuntimeException("«modelDao».selectAll not implemented");
			}

			public void truncate(PersistenceHandle handle) {
				throw new RuntimeException("«modelDao».truncate not implemented");
			}

		}
		
		«sdg»
		
	'''
	
	def generateAceDao() '''
		«copyright»
		
		package de.acegen;

		import java.util.List;
		import java.util.Optional;
		import java.util.concurrent.ConcurrentLinkedQueue;
		
		import org.jdbi.v3.core.statement.Update;
		
		import com.fasterxml.jackson.core.JsonProcessingException;
		import com.fasterxml.jackson.databind.ObjectMapper;
		
		public class AceDao {
		
			private ObjectMapper mapper;
		
			private ConcurrentLinkedQueue<String> lastUuids;
		
			public AceDao() {
				mapper = new ObjectMapper();
				lastUuids = new ConcurrentLinkedQueue<>();
			}

			public boolean checkUuid(String uuid) {
				boolean alreadyUsed = lastUuids.contains(uuid);
				if (alreadyUsed) {
					return false;
				}
				lastUuids.add(uuid);
				if (lastUuids.size() > 1000) {
					lastUuids.remove();
				}
				return true;
			}

			public void truncateTimelineTable(PersistenceHandle handle) {
				handle.getHandle().execute("TRUNCATE TABLE timeline");
			}
		
			public boolean contains(PersistenceHandle handle, String uuid) {
				Optional<Integer> optional = handle.getHandle()
						.createQuery("SELECT count(uuid) " + "FROM timeline "
								+ "where uuid = :uuid")
						.bind("uuid", uuid)
						.mapTo((Integer.class)).findFirst();
				Integer count = optional.isPresent() ? optional.get() : 0;
				return count > 0;
			}
		
			public void insertIntoTimeline(PersistenceHandle handle, String type, String name, String data, String uuid) {
				Update statement = handle.getHandle().createUpdate("INSERT INTO timeline (type, name, time, data, uuid) " + "VALUES (:type, :name, NOW(), :data, :uuid);");
				statement.bind("type", type);
				statement.bind("name", name);
				statement.bind("data", data);
				statement.bind("uuid", uuid);
				statement.execute();
			}
		
			public ITimelineItem selectLastAction(PersistenceHandle handle) {
				Optional<ITimelineItem> optional = handle.getHandle()
						.createQuery("SELECT type, name, time, data, uuid FROM timeline order by time desc limit 1")
						.map(new TimelineItemMapper())
						.findFirst();
				return optional.isPresent() ? optional.get() : null;
			}
		
			public List<ITimelineItem> selectTimeline(PersistenceHandle handle) {
				return handle.getHandle()
						.createQuery("SELECT type, name, time, data, uuid FROM timeline order by time asc")
						.map(new TimelineItemMapper()).list();
			}
			
			public List<ITimelineItem> selectReplayTimeline(PersistenceHandle handle) {
				return handle.getHandle()
						.createQuery("SELECT type, name, time, data, uuid FROM timeline where type = 'event' order by time asc ")
						.map(new TimelineItemMapper()).list();
			}
			
			public void addActionToTimeline(IAction<? extends IDataContainer> action, PersistenceHandle timelineHandle) {
				try {
					String json = mapper.writeValueAsString(action.getActionData());
					addItemToTimeline("action", action.getActionName(), json,
							action.getActionData().getUuid(), timelineHandle);
				} catch (JsonProcessingException e) {
					throw new RuntimeException(e);
				}
			}
		
			public void addCommandToTimeline(ICommand command, PersistenceHandle timelineHandle) {
				try {
					addItemToTimeline("command", command.getCommandName(),
							mapper.writeValueAsString(command.getCommandData()), command.getCommandData().getUuid(),
							timelineHandle);
				} catch (JsonProcessingException e) {
					throw new RuntimeException(e);
				}
			}
		
			public void addEventToTimeline(IEvent event, PersistenceHandle timelineHandle) {
				try {
					addItemToTimeline("event", event.getEventName(), mapper.writeValueAsString(event.getEventData()),
							event.getEventData().getUuid(), timelineHandle);
				} catch (JsonProcessingException e) {
					throw new RuntimeException(e);
				}
			}
		
			public void addPreparingEventToTimeline(IEvent event, String uuid, PersistenceHandle timelineHandle) {
				try {
					addItemToTimeline("preparing event", event.getEventName(),
							mapper.writeValueAsString(event.getEventData()), uuid, timelineHandle);
				} catch (JsonProcessingException e) {
					throw new RuntimeException(e);
				}
			}
		
			public void addExceptionToTimeline(String uuid, Throwable x, PersistenceHandle timelineHandle) {
				this.insertIntoTimeline(timelineHandle, "exception", x.getClass().getName(),
						x.getMessage() != null ? x.getMessage() : "", uuid);
			}
		
			private void addItemToTimeline(String type, String name, String json, String uuid,
					PersistenceHandle timelineHandle) {
				this.insertIntoTimeline(timelineHandle, type, name, json, uuid);
			}
		
		}
		
		«sdg»
		
	'''

	
}