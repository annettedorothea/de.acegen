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


package de.acegen.templates.java

import de.acegen.extensions.CommonExtension
import jakarta.inject.Inject

class DatabaseHandle {
	
	@Inject
	extension CommonExtension
	
	def generateDatabaseHandle() '''
		«copyright»
		
		package de.acegen;
		
		import org.jdbi.v3.core.Jdbi;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		public class DatabaseHandle {
		
			static final Logger LOG = LoggerFactory.getLogger(DatabaseHandle.class);
		
			private PersistenceHandle writeHandle;
			private PersistenceHandle readonlyHandle;
			private PersistenceHandle timelineHandle;

			public DatabaseHandle(Jdbi jdbi, CustomAppConfiguration appConfiguration) {
				super();
				this.writeHandle = new PersistenceHandle(jdbi.open().setReadOnly(false));
				this.readonlyHandle = new PersistenceHandle(jdbi.open().setReadOnly(true));
				if (appConfiguration.getConfig().writeTimeline()) {
					this.timelineHandle = new PersistenceHandle(jdbi.open().setReadOnly(false));
				}
			}
		
			synchronized public void beginTransaction() {
				writeHandle.getHandle().begin();
				readonlyHandle.getHandle().begin();
				if (timelineHandle != null) {
					timelineHandle.getHandle().begin();
				}
			}
		
			synchronized public void commitTransaction() {
				writeHandle.getHandle().commit();
				readonlyHandle.getHandle().rollback();
				if (timelineHandle != null) {
					timelineHandle.getHandle().commit();
				}
			}
		
			synchronized public void rollbackTransaction() {
				writeHandle.getHandle().rollback();
				readonlyHandle.getHandle().rollback();
				if (timelineHandle != null) {
					timelineHandle.getHandle().commit();
				}
			}
		
			synchronized public void close() {
				writeHandle.getHandle().close();
				readonlyHandle.getHandle().close();
				if (timelineHandle != null) {
					timelineHandle.getHandle().close();
				}
			}
		
			public PersistenceHandle getHandle() {
				return writeHandle;
			}
		
			public PersistenceHandle getReadonlyHandle() {
				return readonlyHandle;
			}
		
			public PersistenceHandle getTimelineHandle() {
				return timelineHandle;
			}
		
		}
		
		«sdg»
		
	'''
	
	
}