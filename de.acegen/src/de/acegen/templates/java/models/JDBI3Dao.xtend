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
	
	def generateAbstractJdbiDao(Model it, HttpServer httpServer) '''
		«copyright»
		
		package «httpServer.name».models;
		
		import de.acegen.PersistenceHandle;
		import org.jdbi.v3.core.statement.Update;

		import java.util.List;
		import java.util.Map;
		import java.util.Optional;
		
		@SuppressWarnings("all")
		public class «abstractModelDao» {
			
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