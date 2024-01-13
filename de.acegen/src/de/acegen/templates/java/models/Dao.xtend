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

import de.acegen.extensions.CommonExtension
import jakarta.inject.Inject

class Dao {
	
	@Inject
	extension CommonExtension
	
	def generateAceDao() '''
		«copyright»
		
		package de.acegen;
		
		import java.time.LocalDateTime;
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
		
			private void insertIntoTimeline(PersistenceHandle handle, String type, String name, String data, String uuid, LocalDateTime timestamp) {
				Update statement = handle.getHandle().createUpdate("INSERT INTO timeline (type, name, time, data, uuid) " + "VALUES (:type, :name, :timestamp, :data, :uuid);");
				statement.bind("type", type);
				statement.bind("name", name);
				statement.bind("data", data);
				statement.bind("uuid", uuid);
				statement.bind("timestamp", LocalDateTime.now());
				statement.execute();
			}
		
			public <T extends AbstractModel> void addActionToTimeline(String actionName, Data<T> data, PersistenceHandle timelineHandle) {
				addItemToTimeline("action", actionName, data, timelineHandle);
			}
		
			public <T extends AbstractModel> void addCommandToTimeline(String commandName, Data<T> data, PersistenceHandle timelineHandle) {
				addItemToTimeline("command", commandName, data, timelineHandle);
			}
		
			public <T extends AbstractModel> void addEventToTimeline(String eventName, Data<T> data, PersistenceHandle timelineHandle) {
				addItemToTimeline("event", eventName, data, timelineHandle);
			}
		
			public <T extends AbstractModel> void addExceptionToTimeline(String uuid, Throwable x, PersistenceHandle timelineHandle) {
				this.insertIntoTimeline(timelineHandle, "exception", x.getClass().getName(),
						x.getMessage() != null ? x.getMessage() : "", uuid, LocalDateTime.now());
			}
		
			private <T extends AbstractModel> void addItemToTimeline(String type, String name, Data<T> data, 
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