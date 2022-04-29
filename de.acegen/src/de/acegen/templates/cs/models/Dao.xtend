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
		
		namespace AceGen
		{
		    public interface IAceDao {
		        bool checkUuid(string uuid);
		        void addCommandToTimeLine(string commandName, IDataContainer data);
		        void addActionToTimeline(string commandName, IDataContainer data);
		        void addEventToTimeline(string commandName, IDataContainer data);
		        void addExceptionToTimeline(string commandName, Exception data);
		    }
		    public class AceDao : IAceDao
		    {
		        public void addActionToTimeline(string commandName, IDataContainer data) {
		
		        }
		        public void addCommandToTimeLine(string commandName, IDataContainer data) {
		
		        }
		        public void addEventToTimeline(string commandName, IDataContainer data) {
		
		        }
		        public void addExceptionToTimeline(string commandName, Exception data) {
		
		        }
		
		        public bool checkUuid(string uuid)
		        {
		            throw new NotImplementedException();
		        }
		    }
		}
		
		
		«sdg»
		
	'''

	
}