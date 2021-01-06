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
import de.acegen.aceGen.Model
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.java.AttributeExtension
import de.acegen.extensions.java.ModelExtension
import javax.inject.Inject

class JDBI3Dao {
	
	@Inject
	extension ModelExtension
	
	@Inject
	extension AttributeExtension
	
	@Inject
	extension CommonExtension
	
	def generateAbstractJdbiDao() '''
		«copyright»
		
		package de.acegen;
		
		import java.util.List;
		import java.util.Map;
		import java.util.Optional;
		
		import org.jdbi.v3.core.mapper.RowMapper;
		import org.jdbi.v3.core.statement.Query;
		import org.jdbi.v3.core.statement.Update;
				
		@SuppressWarnings("all")
		public class AbstractDao {
			protected void update(PersistenceHandle handle, String sql, Map<String, Object> params) {
				Update statement = handle.getHandle().createUpdate(sql);
				for (String paramName : params.keySet()) {
					Object value = params.get(paramName);
					if (value instanceof List) {
						statement.bindList(paramName, (List)value);
					} else {
						statement.bind(paramName, value);
					}
				}
				statement.execute();
			}
		
			protected <T> T selectOne(PersistenceHandle handle, String sql, Map<String, Object> params, RowMapper<T> mapper) {
				Query query = handle.getHandle().createQuery(sql);
				for (String paramName : params.keySet()) {
					query.bind(paramName, params.get(paramName));
				}
				Optional<T> optional = query.map(mapper).findFirst();
				return optional.isPresent() ? optional.get() : null;
			}
			
			protected <T> List<T> selectList(PersistenceHandle handle, String sql, Map<String, Object> params, RowMapper<T> mapper) {
				Query query = handle.getHandle().createQuery(sql);
				for (String paramName : params.keySet()) {
					query.bind(paramName, params.get(paramName));
				}
				return query.map(mapper).list();
			}

		}
		
		«sdg»
		
	'''

	def generateAbstractJdbiDao(Model it, HttpServer httpServer) '''
		«copyright»
		
		package «httpServer.name».models;
		
		import de.acegen.PersistenceHandle;
		import de.acegen.AbstractDao;
		import org.jdbi.v3.core.statement.Update;

		import java.util.List;
		import java.util.Map;
		import java.util.Optional;
		
		@SuppressWarnings("all")
		public class «abstractModelDao» extends AbstractDao {
			
			public void insert(PersistenceHandle handle, «modelName» «modelParam») {
				Update statement = handle.getHandle().createUpdate("INSERT INTO «table» («FOR attribute : attributes SEPARATOR ', '»«attribute.name.toLowerCase»«ENDFOR») VALUES («FOR attribute : attributes SEPARATOR ', '»«modelAttributeSqlValue(attribute)»«ENDFOR»)");
				«FOR attribute : attributes»
					statement.bind("«attribute.name.toLowerCase»", «modelGetAttribute(attribute)»);
				«ENDFOR»
				statement.execute();
			}
			
			
			«FOR attribute : allUniqueAttributes»
				public void updateBy«attribute.name.toFirstUpper»(PersistenceHandle handle, «modelName» «modelParam») {
					Update statement = handle.getHandle().createUpdate("UPDATE «table» SET «FOR attr : attributes SEPARATOR ', '»«attr.name.toLowerCase» = :«attr.name.toLowerCase»«ENDFOR» WHERE «attribute.name.toLowerCase» = :«attribute.name.toLowerCase»");
					«FOR attr : attributes»
						statement.bind("«attr.name.toLowerCase»", «modelGetAttribute(attr)»);
					«ENDFOR»
					statement.bind("«attribute.name.toLowerCase»", «modelGetAttribute(attribute)» );
					statement.execute();
				}

				public void deleteBy«attribute.name.toFirstUpper»(PersistenceHandle handle, «attribute.javaType» «attribute.name») {
					Update statement = handle.getHandle().createUpdate("DELETE FROM «table» WHERE «attribute.name.toLowerCase» = :«attribute.name.toLowerCase»");
					statement.bind("«attribute.name.toLowerCase»", «attribute.name»);
					statement.execute();
				}

				public «modelName» selectBy«attribute.name.toFirstUpper»(PersistenceHandle handle, «attribute.javaType» «attribute.name») {
					Optional<«modelName»> optional = handle.getHandle().createQuery("SELECT «FOR attr : attributes SEPARATOR ', '»«attr.name.toLowerCase»«ENDFOR» FROM «table» WHERE «attribute.name.toLowerCase» = :«attribute.name.toLowerCase»")
						.bind("«attribute.name.toLowerCase»", «attribute.name»)
						.map(new «modelMapper»())
						.findFirst();
					return optional.isPresent() ? optional.get() : null;
				}
			«ENDFOR»
			
			«IF allPrimaryKeyAttributes.length > 0»
				public «modelName» selectByPrimaryKey(PersistenceHandle handle, «FOR attribute : allPrimaryKeyAttributes SEPARATOR ', '»«attribute.javaType» «attribute.name»«ENDFOR») {
					Optional<«modelName»> optional = handle.getHandle().createQuery("SELECT «FOR attr : attributes SEPARATOR ', '»«attr.name.toLowerCase»«ENDFOR» FROM «table» WHERE «FOR attribute : allPrimaryKeyAttributes SEPARATOR ' AND '»«attribute.name.toLowerCase» = :«attribute.name.toLowerCase»«ENDFOR»")
						«FOR attribute : allPrimaryKeyAttributes»
							.bind("«attribute.name.toLowerCase»", «attribute.name»)
						«ENDFOR»
						.map(new «modelMapper»())
						.findFirst();
					return optional.isPresent() ? optional.get() : null;
				}
			«ENDIF»
			
			public int filterAndCountBy(PersistenceHandle handle, Map<String, String> filterMap) {
				String sql = "SELECT count(*) FROM «table»";
				if (filterMap != null) {
					int i = 0;
					for(String key : filterMap.keySet()) {
						if (i == 0) {
							sql += " WHERE " + key + " = '" + filterMap.get(key) + "'";
						} else {
							sql += " AND " + key + " = '" + filterMap.get(key) + "'";
						}
						i++;
					}
				}
				return handle.getHandle().createQuery(sql).mapTo(Integer.class).first();
			}

			public List<«modelName»> selectAll(PersistenceHandle handle) {
				return handle.getHandle().createQuery("SELECT «FOR attr : attributes SEPARATOR ', '»«attr.name.toLowerCase»«ENDFOR» FROM «table»")
					.map(new «modelMapper»())
					.list();
			}

			public void truncate(PersistenceHandle handle) {
				Update statement = handle.getHandle().createUpdate("TRUNCATE TABLE «table» CASCADE");
				statement.execute();
			}

		}
		
		«sdg»
		
	'''

	def generateJdbiDao(Model it, HttpServer httpServer) '''
		«copyright»
		
		package «httpServer.getName».models;
		
		public class «modelDao» extends «abstractModelDao» {
			
		}
		
		«sdg»
		
	'''
	
	
	
}