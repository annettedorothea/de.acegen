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

class JDBI3Mapper {

	@Inject
	extension ModelExtension
	
	@Inject
	extension AttributeExtension
	
	@Inject
	extension CommonExtension
	

	def generate(Model it, HttpServer httpServer) '''
		«copyright»
		
		package «httpServer.name».models;
		
		import java.sql.ResultSet;
		import java.sql.SQLException;
		
		import org.jdbi.v3.core.statement.StatementContext;
		
		import de.acegen.AbstractMapper;
		
		public class «modelMapper» extends AbstractMapper<«modelName»> {
			
			public «modelName» map(ResultSet r, StatementContext ctx) throws SQLException {
				return new «modelClassName»(
					«FOR attribute : allAttributes SEPARATOR ','»
						«attribute.mapperInit»
					«ENDFOR»
				);
			}
		}
		
		«sdg»
		
	'''
	
	def generateAbstractMapper(HttpServer httpServer) '''
		«copyright»
		
		package de.acegen;
		

		import java.sql.ResultSet;
		import java.sql.SQLException;
		import java.time.LocalDateTime;
		
		import org.jdbi.v3.core.mapper.RowMapper;
		
		
		public abstract class AbstractMapper<T> implements RowMapper<T> {
			
			protected Integer mapToInteger(ResultSet r, String key) throws SQLException {
				return r.getObject(key) != null ? r.getInt(key) : null;
			}
			
			protected Long mapToLong(ResultSet r, String key) throws SQLException {
				return r.getObject(key) != null ? r.getLong(key) : null;
			}
			
			protected String mapToString(ResultSet r, String key) throws SQLException {
				return r.getString(key);
			}
			
			protected Float mapToFloat(ResultSet r, String key) throws SQLException {
				return r.getObject(key) != null ? r.getFloat(key) : null;
			}
			
			protected Boolean mapToBoolean(ResultSet r, String key) throws SQLException {
				return r.getObject(key) != null ? r.getBoolean(key) : null;
				// SQLite: return r.getObject(key) != null ? (r.getInt(key) == 1 ? true : false) : null;
			}
			
			protected LocalDateTime mapToDateTime(ResultSet r, String key) throws SQLException {
				return r.getTimestamp(key) != null ? r.getTimestamp(key).toLocalDateTime() : null;
				// SQLite: return r.getString(key) != null ? Instant.ofEpochMilli(Long.parseLong(r.getString(key))).atZone(ZoneId.systemDefault()).toLocalDateTime() : null;
			}
		}
		
		«sdg»
		
	'''
	
	
}