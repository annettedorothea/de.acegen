package de.acegen.templates.java

import de.acegen.extensions.CommonExtension
import javax.inject.Inject

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