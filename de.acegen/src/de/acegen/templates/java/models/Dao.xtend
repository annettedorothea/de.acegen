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
		import java.time.LocalDateTime;
		
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
		
			private void insertIntoTimeline(PersistenceHandle handle, String type, String name, String data, String uuid, LocalDateTime timestamp) {
				Update statement = handle.getHandle().createUpdate("INSERT INTO timeline (type, name, time, data, uuid) " + "VALUES (:type, :name, :timestamp, :data, :uuid);");
				statement.bind("type", type);
				statement.bind("name", name);
				statement.bind("data", data);
				statement.bind("uuid", uuid);
				statement.bind("timestamp", timestamp);
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
			
			public void addActionToTimeline(String actionName, IDataContainer data, PersistenceHandle timelineHandle) {
				addItemToTimeline("action", actionName, data, timelineHandle);
			}
		
			public void addCommandToTimeline(String commandName, IDataContainer data, PersistenceHandle timelineHandle) {
				addItemToTimeline("command", commandName, data, timelineHandle);
			}
		
			public void addEventToTimeline(String eventName, IDataContainer data, PersistenceHandle timelineHandle) {
				addItemToTimeline("event", eventName, data, timelineHandle);
			}
		
			public void addPreparingEventToTimeline(String eventName, IDataContainer data, PersistenceHandle timelineHandle) {
				try {
					String json = mapper.writeValueAsString(data);
					this.insertIntoTimeline(timelineHandle, "preparing event", eventName, json, data.getUuid(), LocalDateTime.now());
				} catch (JsonProcessingException e) {
					throw new RuntimeException(e);
				}
			}
		
			public void addExceptionToTimeline(String uuid, Throwable x, PersistenceHandle timelineHandle) {
				this.insertIntoTimeline(timelineHandle, "exception", x.getClass().getName(),
						x.getMessage() != null ? x.getMessage() : "", uuid, LocalDateTime.now());
			}
		
			private void addItemToTimeline(String type, String name, IDataContainer data, 
					PersistenceHandle timelineHandle) {
				try {
					String json = mapper.writeValueAsString(data);
					this.insertIntoTimeline(timelineHandle, type, name, json, data.getUuid(), data.getSystemTime());
				} catch (JsonProcessingException e) {
					throw new RuntimeException(e);
				}
			}
		
		}
		
		«sdg»
		
	'''

	
}