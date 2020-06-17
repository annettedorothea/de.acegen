package de.acegen.templates.cs.models

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
		
		namespace Acegen {

			public class AceDao : IAceDao {
			
				public AceDao() {
				}
			
				public override bool checkUuid(string uuid) {
					return false;
				}
			
				public void truncateTimelineTable(PersistenceHandle handle) {
				}
			
				public bool contains(PersistenceHandle handle, string uuid) {
					return false;
				}
			
				public void insertIntoTimeline(PersistenceHandle handle, string type, string name, string data, string uuid) {
				}
			
				public ITimelineItem selectLastAction(PersistenceHandle handle) {
					return null;
				}
			
				public List<ITimelineItem> selectTimeline(PersistenceHandle handle) {
					return null;
				}
				
				public List<ITimelineItem> selectReplayTimeline(PersistenceHandle handle) {
					return null;
				}
				
				public void addActionToTimeline(IAction<? extends IDataContainer> action, PersistenceHandle timelineHandle) {
				}
			
				public void addCommandToTimeline(ICommand command, PersistenceHandle timelineHandle) {
				}
			
				public void addEventToTimeline(IEvent event, PersistenceHandle timelineHandle) {
				}
			
				public void addPreparingEventToTimeline(IEvent event, string uuid, PersistenceHandle timelineHandle) {
				}
			
				public void addExceptionToTimeline(string uuid, Throwable x, PersistenceHandle timelineHandle) {
				}
			
			}
		}
		
		«sdg»
		
	'''

	
	def generateAceDaoInterface() '''
		«copyright»
		
		namespace Acegen {

			public interface IAceDao {
			
				bool checkUuid(string uuid);
				void truncateTimelineTable(PersistenceHandle handle);
				bool contains(PersistenceHandle handle, string uuid);
				void insertIntoTimeline(PersistenceHandle handle, string type, string name, string data, string uuid);
				ITimelineItem selectLastAction(PersistenceHandle handle);
				List<ITimelineItem> selectTimeline(PersistenceHandle handle);
				List<ITimelineItem> selectReplayTimeline(PersistenceHandle handle);
				void addActionToTimeline(IAction<? extends IDataContainer> action, PersistenceHandle timelineHandle);
				void addCommandToTimeline(ICommand command, PersistenceHandle timelineHandle);
				void addEventToTimeline(IEvent event, PersistenceHandle timelineHandle);
				void addPreparingEventToTimeline(IEvent event, string uuid, PersistenceHandle timelineHandle);
				void addExceptionToTimeline(string uuid, Throwable x, PersistenceHandle timelineHandle);
			
			}
		}
		
		«sdg»
		
	'''

	
}
