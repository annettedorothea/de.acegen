/* 
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */
 

package de.acegen.templates.java

import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerAce
import de.acegen.aceGen.Model
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.java.AceExtension
import de.acegen.extensions.java.AttributeExtension
import de.acegen.extensions.java.ModelExtension
import javax.inject.Inject

class ModelTemplate {
	
	@Inject
	extension ModelExtension
	
	@Inject
	extension AttributeExtension
	
	@Inject
	extension AceExtension
	
	@Inject
	extension CommonExtension
	
	def generateModel(Model it, HttpServer java) '''
		«copyright»
		
		package «java.getName».models;
		
		import java.util.List;
		import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
		
		@SuppressWarnings("unused")
		@JsonDeserialize(as=«modelClassName».class)
		public interface «modelName» «IF superModels.size > 0»extends «FOR superModel : superModels SEPARATOR ','»«superModel.interfaceWithPackage»«ENDFOR»«ENDIF»{
		
			«FOR attribute : attributes»
				«attribute.interfaceGetter»
				«attribute.interfaceSetter»
				
			«ENDFOR»
			
		}
		
		
		«sdg»
		
	'''
	
	def generateModelClass(Model it, HttpServer java) '''
		«copyright»
		
		package «java.getName».models;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		import com.fasterxml.jackson.databind.annotation.JsonSerialize;
		import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

		import javax.validation.constraints.NotNull;
		import org.hibernate.validator.constraints.NotEmpty;
		import java.util.List;
		import java.util.ArrayList;

		import de.acegen.DateTimeToStringConverter;
		import de.acegen.StringToDateTimeConverter;

		@SuppressWarnings("all")
		public class «modelClassName» implements «modelName» {
		
			«FOR attribute : allAttributes»
				«attribute.declaration»
				
			«ENDFOR»
		
			«IF attributes.length > 0»
				public «modelClassName»() {
				}
			«ENDIF»
		
			public «modelClassName»(
				«FOR attribute : allAttributes SEPARATOR ','»
					«attribute.param(true)»
				«ENDFOR»
			) {
				«FOR attribute : allAttributes»
					«attribute.assign»
				«ENDFOR»
			}
		
			«FOR attribute : allAttributes»
				«attribute.getter(true)»
				«attribute.setter»
				
			«ENDFOR»
			
		}
		
		
		«sdg»
		
	'''
	
	def generateDataInterface(Model it, HttpServer java) '''
		«copyright»
		
		package «java.getName».data;
		
		import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
		
		import de.acegen.IDataContainer;
		
		«importModel»
		
		@JsonDeserialize(as=«dataName».class)
		public interface «dataInterfaceName» extends «modelName», IDataContainer {
			«FOR superModel : superModels»
				void mapFrom(«superModel.interfaceWithPackage» model);
			«ENDFOR»
			
			«FOR attribute : allAttributes»
				«dataInterfaceName» with«attribute.name.toFirstUpper»(«attribute.javaType» «attribute.name»);
				
			«ENDFOR»
			
		}
		
		
		«sdg»
		
	'''
	
	def generateAbstractData(Model it, HttpServer java) '''
		«copyright»
		
		package «java.getName».data;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		import com.fasterxml.jackson.databind.annotation.JsonSerialize;
		import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
		
		import javax.validation.constraints.NotNull;
		import org.hibernate.validator.constraints.NotEmpty;
		import org.joda.time.DateTime;
		import java.util.List;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		import java.util.ArrayList;
		«importModel»
		«FOR superModel : superModels»
			«superModel.importModel»
		«ENDFOR»
		
		import de.acegen.AbstractData;
		import de.acegen.IDataContainer;
		import de.acegen.DateTimeToStringConverter;
		import de.acegen.StringToDateTimeConverter;
		
		@SuppressWarnings("unused")
		public abstract class «abstractDataName» extends AbstractData implements «dataInterfaceName» {
			
			static final Logger LOG = LoggerFactory.getLogger(«abstractDataName».class);
			
			«FOR attribute : allAttributes»
				«attribute.declaration»
				
			«ENDFOR»
		
			public «abstractDataName»(
				«FOR attribute : allAttributes SEPARATOR ',' AFTER ','»
					«attribute.param(true)»
				«ENDFOR»
				@JsonProperty("uuid") String uuid
			) {
				super(uuid);
				«FOR attribute : allAttributes»
					«attribute.assign»
				«ENDFOR»
			}
		
			«IF allAttributes.length > 0»
				public «abstractDataName»( String uuid ) {
					super(uuid);
				}
			«ENDIF»
		
			«FOR attribute : allAttributes»
				«attribute.getter(true)»
				«attribute.setter»
				«attribute.with(it)»
				
			«ENDFOR»
			
			«FOR superModel : superModels»
				public void mapFrom(«superModel.interfaceWithPackage» model) {
					«FOR attribute: superModel.allAttributes»
						this.«attribute.name» = model.«attribute.getterCall»;
					«ENDFOR»
				}
			«ENDFOR»
			
		}
		
		
		«sdg»
		
	'''
	
	def generateData(Model it, HttpServer java) '''
		«copyright»
		
		package «java.getName».data;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		
		import org.joda.time.DateTime;
		import java.util.List;
		
		import de.acegen.AbstractData;
		
		public class «dataName» extends «abstractDataName» implements «dataInterfaceName» {
			
			public «dataName»(
				«FOR attribute : allAttributes»
					«attribute.param(true)», 
				«ENDFOR»
				@JsonProperty("uuid") String uuid
			) {
				super(
					«FOR attribute : allAttributes»
						«attribute.name»,
					«ENDFOR»
					uuid
				);
			}

			«IF allAttributes.length > 0»
				public «dataName»( String uuid ) {
					super(uuid);
				}

			«ENDIF»
			public void migrateLegacyData(String json) {
			}
		
		}
		
		
		«sdg»
		
	'''
	
	def generateAbstractData() '''
		«copyright»
		
		package de.acegen;
		
		import org.joda.time.DateTime;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		
		public abstract class AbstractData implements IDataContainer {
		
			private String uuid;
			
			private String outcome;
			
			private DateTime systemTime;
			
			public AbstractData( String uuid ) {
				this.uuid = uuid;
			}
		
			@JsonProperty
			public String getUuid() {
				return this.uuid;
			}
		
			@JsonProperty
			public void setUuid(String uuid) {
				this.uuid = uuid;
			}
		
			@JsonProperty
			public DateTime getSystemTime() {
				return systemTime;
			}
		
			@JsonProperty
			public void setSystemTime(DateTime systemTime) {
				this.systemTime = systemTime;
			}
		
			@JsonProperty
			public String getOutcome() {
				return outcome;
			}
		
			@JsonProperty
			public void setOutcome(String outcome) {
				this.outcome = outcome;
			}
			
		}
		
		
		«sdg»
		
	'''
	
	def generateResponseData(HttpServerAce it, HttpServer java) '''
		«copyright»
		
		package «java.getName».data;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		import com.fasterxml.jackson.annotation.JsonIgnore;
		import com.fasterxml.jackson.databind.annotation.JsonSerialize;
		import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
		
		import javax.validation.constraints.NotNull;
		import org.hibernate.validator.constraints.NotEmpty;
		import org.joda.time.DateTime;
		import java.util.List;
		
		import de.acegen.IDataContainer;
		import de.acegen.DateTimeToStringConverter;
		import de.acegen.StringToDateTimeConverter;
		
		@SuppressWarnings("all")
		public class «responseDataName» implements «responseDataInterfaceName» {
			
			«FOR attribute : response»
				«attribute.declaration»
				
			«ENDFOR»
			public «responseDataName»() {
			}
			
			public «responseDataName»(«getModel.interfaceWithPackage» data) {
				«FOR attribute : response»
					«attribute.name» = data.«attribute.getterCall»;
				«ENDFOR»
			}
			
			«FOR attribute : response»
				«attribute.getter(true)»
				
			«ENDFOR»
		}
		
		
		«sdg»
		
	'''
	
	def generateReponseDataInterface(HttpServerAce it, HttpServer java) '''
		«copyright»
		
		package «java.getName».data;
		
		public interface «responseDataInterfaceName» {
			«FOR attribute : response»
				«attribute.interfaceGetter»
				
			«ENDFOR»
		
		}
		
		
		«sdg»
		
	'''
	
	def generateAbstractDao(Model it, HttpServer java) '''
		«copyright»
		
		package «java.getName».models;
		
		import de.acegen.PersistenceHandle;
		import org.jdbi.v3.core.statement.Update;

		import java.util.List;
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
	
	def generateDao(Model it, HttpServer java) '''
		«copyright»
		
		package «java.getName».models;
		
		public class «modelDao» extends «abstractModelDao» {
			
		}
		
		
		«sdg»
		
	'''
	
	def generateMigration(Model it, HttpServer java) '''
		<createTable tableName="«name.toLowerCase»">
			«FOR attribute : attributes»
				<column name="«attribute.name.toLowerCase»" type="«attribute.sqlType»">
					<constraints «IF attribute.isPrimaryKey»primaryKey="true"«ENDIF» «IF attribute.constraint !== null && attribute.constraint.equals('NotNull')»nullable="false"«ENDIF» «IF attribute.foreignKey !== null»	references="«attribute.foreignKey.tableName»(«attribute.foreignKey.name.toLowerCase»)" deleteCascade="true" foreignKeyName="fk_«table»_«attribute.foreignKey.name.toLowerCase»"«ENDIF» />
				</column>
			«ENDFOR»
		</createTable>
	'''
	
	def generateMapper(Model it, HttpServer java) '''
		«copyright»
		
		package «java.getName».models;
		
		import java.sql.ResultSet;
		import java.sql.SQLException;
		
		import org.jdbi.v3.core.mapper.RowMapper;
		import org.jdbi.v3.core.statement.StatementContext;
		
		public class «modelMapper» implements RowMapper<«modelName»> {
			
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
				this.writeHandle = new PersistenceHandle(jdbi.open());
				this.readonlyHandle = new PersistenceHandle(jdbi.open());
				if (appConfiguration.getServerConfiguration().writeTimeline()) {
					this.timelineHandle = new PersistenceHandle(jdbi.open());
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
	
	def generateIDataContainer() '''
		«copyright»
		
		package de.acegen;
		
		import org.joda.time.DateTime;
		
		public interface IDataContainer {
		
			String getUuid();
			
			void setUuid(String uuid);

			String getOutcome();

			void setOutcome(String outcome);
		
			DateTime getSystemTime();
		
			void setSystemTime(DateTime systemTime);
		
			void migrateLegacyData(String json);

		}
		
		
		«sdg»
		
	'''
	

	
}
	
	
/******* S.D.G. *******/
	
	
