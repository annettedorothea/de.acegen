package com.anfelisa.templates.java

import com.anfelisa.ace.Attribute
import com.anfelisa.ace.Data
import com.anfelisa.ace.JAVA
import com.anfelisa.ace.Model
import com.anfelisa.extensions.java.AttributeExtension
import com.anfelisa.extensions.java.DataExtension
import com.anfelisa.extensions.java.ModelExtension
import javax.inject.Inject

class ModelTemplate {
	
	@Inject
	extension ModelExtension
	
	@Inject
	extension DataExtension
	
	@Inject
	extension AttributeExtension
	
	def generateModel(Model it, JAVA java) '''
		package «java.name».models;
		
		import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
		import com.anfelisa.auth.AuthUser;
		
		@JsonDeserialize(as=«modelClassName».class)
		public interface «modelName» {
		
			«FOR attribute : attributes»
				«attribute.interfaceGetter»
			«ENDFOR»

		}
		
		/*       S.D.G.       */
	'''
	
	def generateModelClass(Model it, JAVA java) '''
		package «java.name».models;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		import javax.validation.constraints.NotNull;
		import org.hibernate.validator.constraints.NotEmpty;
		import com.anfelisa.auth.AuthUser;

		@SuppressWarnings("all")
		public class «modelClassName» implements «modelName» {
		
			«FOR attribute : attributes»
				«attribute.declaration»
				
			«ENDFOR»
		
			public «modelClassName»(
				«FOR attribute : attributes SEPARATOR ','»
					«attribute.param»
				«ENDFOR»
			) {
				«FOR attribute : attributes»
					«attribute.assign»
				«ENDFOR»
			}
		
			«FOR attribute : attributes»
				«attribute.getter»
				«attribute.setter»
				
			«ENDFOR»
		
		}
		
		/*       S.D.G.       */
	'''
	
	def generateDataInterface(Data it, JAVA java) '''
		package «java.name».data;
		
		import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
		
		import com.anfelisa.ace.IDataContainer;
		
		«FOR model : models»
			«model.model.importModel»
		«ENDFOR»
		
		@JsonDeserialize(as=«dataName».class)
		public interface «dataInterfaceName» extends «FOR modelRef : models SEPARATOR ', ' AFTER ','»«modelRef.model.modelName»«ENDFOR» IDataContainer {
		
		}
		
		/*       S.D.G.       */
	'''
	
	def generateData(Data it, JAVA java) '''
		package «java.name».data;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		
		import javax.validation.constraints.NotNull;
		import org.hibernate.validator.constraints.NotEmpty;
		import org.joda.time.DateTime;
		import java.util.List;
		import com.anfelisa.auth.AuthUser;
		
		import com.anfelisa.ace.AbstractData;
		
		public class «dataName» extends AbstractData implements «dataInterfaceName» {
			
			«FOR attribute : allAttributes»
				«attribute.declaration»
				
			«ENDFOR»
		
			public «dataName»(
				«FOR attribute : allAttributes SEPARATOR ',' AFTER ','»
					«attribute.param»
				«ENDFOR»
				@JsonProperty("uuid") String uuid
			) {
				super(uuid);
				«FOR attribute : allAttributes»
					«attribute.assign»
				«ENDFOR»
			}
		
			«IF allAttributes.length > 0»
				public «dataName»( String uuid ) {
					super(uuid);
				}
			«ENDIF»
		
			«FOR attribute : allAttributes»
				«attribute.getter»
				«attribute.setter»
				«attribute.initializer(dataName)»
				
			«ENDFOR»
		
			@Override
			public Object toPresentationalData() {
				return new «presentationalDataName»(
					«FOR attribute : allAttributes SEPARATOR ','»
						this.«attribute.name»
					«ENDFOR»
				);
			}

		}
		
		/*       S.D.G.       */
	'''
	
	def generateAbstractData() '''
		package com.anfelisa.ace;
		
		import org.joda.time.DateTime;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		
		public abstract class AbstractData implements IDataContainer {
		
			private String uuid;
			
			private String outcome;
			
			private org.joda.time.DateTime systemTime;
			
			public AbstractData(String uuid, String outcome, DateTime systemTime) {
				super();
				this.uuid = uuid;
				this.outcome = outcome;
				this.systemTime = systemTime;
			}
		
			public AbstractData( String uuid ) {
				this.uuid = uuid;
			}
		
			@JsonProperty
			public String getUuid() {
				return this.uuid;
			}
		
			@JsonProperty
			public org.joda.time.DateTime getSystemTime() {
				return systemTime;
			}
		
			@JsonProperty
			public void setSystemTime(org.joda.time.DateTime systemTime) {
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
		
		/*       S.D.G.       */
	'''
	
	def generatePresentationalData(Data it, JAVA java) '''
		package «java.name».data;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		import com.fasterxml.jackson.annotation.JsonIgnore;
		
		import javax.validation.constraints.NotNull;
		import org.hibernate.validator.constraints.NotEmpty;
		import org.joda.time.DateTime;
		import java.util.List;
		import com.anfelisa.auth.AuthUser;
		
		import com.anfelisa.ace.IDataContainer;
		
		«FOR model : models»
			«model.model.importModel»
		«ENDFOR»
		
		@SuppressWarnings("all")
		public class «presentationalDataName» implements «presentationalDataInterfaceName» {
			
			«FOR attribute : allAttributes»
				«attribute.declaration»
				
			«ENDFOR»
			
			public «presentationalDataName»(
				«FOR attribute : allAttributes SEPARATOR ','»
					«attribute.param»
				«ENDFOR»
			) {
				«FOR attribute : allAttributes»
					«attribute.assign»
				«ENDFOR»
				
			}
		
			«FOR attribute : allAttributes»
				«attribute.getter»
				«attribute.setter»
				«attribute.initializer(presentationalDataName)»
				
			«ENDFOR»
		}
		
		/*       S.D.G.       */
	'''
	
	def generatePresentationalInterfaceData(Data it, JAVA java) '''
		package «java.name».data;
		
		«FOR model : models»
			«model.model.importModel»
		«ENDFOR»
		
		public interface «presentationalDataInterfaceName» «IF models.size > 0»extends «FOR modelRef : models SEPARATOR ', '»«modelRef.model.modelName»«ENDFOR»«ENDIF» {
		
		}
		
		/*       S.D.G.       */
	'''
	
	def generateDao(Model it, JAVA java) '''
		package «java.name».models;
		
		import org.jdbi.v3.core.Handle;
		import org.jdbi.v3.core.statement.Update;

		import java.util.List;
		import java.util.Map;
		import java.util.Optional;
		
		import com.fasterxml.jackson.annotation.JsonIgnoreType;

		@SuppressWarnings("all")
		@JsonIgnoreType
		public class «modelDao» {
			
			public void insert(Handle handle, «modelName» «modelParam») {
				Update statement = handle.createUpdate("INSERT INTO «java.schema».«table» («FOR attribute : attributes SEPARATOR ', '»«attribute.name.toLowerCase»«ENDFOR») VALUES («FOR attribute : attributes SEPARATOR ', '»«modelAttributeSqlValue(attribute)»«ENDFOR»)");
				«FOR attribute : attributes»
					statement.bind("«attribute.name.toLowerCase»", «modelGetAttribute(attribute)»);
				«ENDFOR»
				statement.execute();
			}
			
			
			«FOR attribute : allUniqueAttributes»
				public void updateBy«attribute.name.toFirstUpper»(Handle handle, «modelName» «modelParam») {
					Update statement = handle.createUpdate("UPDATE «java.schema».«table» SET «FOR attr : attributes SEPARATOR ', '»«attr.name.toLowerCase» = :«attr.name.toLowerCase»«ENDFOR» WHERE «attribute.name.toLowerCase» = :«attribute.name.toLowerCase»");
					«FOR attr : attributes»
						statement.bind("«attr.name.toLowerCase»", «modelGetAttribute(attr)»);
					«ENDFOR»
					statement.bind("«attribute.name.toLowerCase»", «modelGetAttribute(attribute)» );
					statement.execute();
				}

				public void deleteBy«attribute.name.toFirstUpper»(Handle handle, «attribute.javaType» «attribute.name») {
					Update statement = handle.createUpdate("DELETE FROM «java.schema».«table» WHERE «attribute.name.toLowerCase» = :«attribute.name.toLowerCase»");
					statement.bind("«attribute.name.toLowerCase»", «attribute.name»);
					statement.execute();
				}

				public «modelName» selectBy«attribute.name.toFirstUpper»(Handle handle, «attribute.javaType» «attribute.name») {
					Optional<«modelName»> optional = handle.createQuery("SELECT «FOR attr : attributes SEPARATOR ', '»«attr.name.toLowerCase»«ENDFOR» FROM «java.schema».«table» WHERE «attribute.name.toLowerCase» = :«attribute.name.toLowerCase»")
						.bind("«attribute.name.toLowerCase»", «attribute.name»)
						.map(new «modelMapper»())
						.findFirst();
					return optional.isPresent() ? optional.get() : null;
				}
			«ENDFOR»
			
			public List<«modelName»> selectAll(Handle handle) {
				return handle.createQuery("SELECT «FOR attr : attributes SEPARATOR ', '»«attr.name.toLowerCase»«ENDFOR» FROM «java.schema».«table»")
					.map(new «modelMapper»())
					.list();
			}

			public void truncate(Handle handle) {
				Update statement = handle.createUpdate("TRUNCATE «java.schema».«table» CASCADE");
				statement.execute();
			}

		}
		
		/*       S.D.G.       */
	'''
	
	def generateMigration(Model it, JAVA java) '''
		<createTable tableName="«table»">
			«FOR attribute : attributes»
				<column name="«attribute.name.toLowerCase»" type="«attribute.sqlType»">
					<constraints «IF attribute.isPrimaryKey»primaryKey="true"«ENDIF» «IF attribute.constraint !== null && attribute.constraint.equals('NotNull')»nullable="false"«ENDIF» «IF attribute.foreignKey !== null»	references="«(attribute.foreignKey.eContainer as Attribute).tableName»(«attribute.foreignKey.name.toLowerCase»)" deleteCascade="true" foreignKeyName="fk_«table»_«attribute.foreignKey.name.toLowerCase»"«ENDIF» />
				</column>
			«ENDFOR»
		</createTable>
	'''
	
	def generateMapper(Model it, JAVA java) '''
		package «java.name».models;
		
		import java.sql.ResultSet;
		import java.sql.SQLException;
		
		import org.jdbi.v3.core.mapper.RowMapper;
		import org.jdbi.v3.core.statement.StatementContext;
		
		@SuppressWarnings("all")
		public class «modelMapper» implements RowMapper<«modelName»> {
			
			public «modelName» map(ResultSet r, StatementContext ctx) throws SQLException {
				return new «modelClassName»(
					«FOR attribute : attributes SEPARATOR ','»
						«attribute.mapperInit»
					«ENDFOR»
				);
			}
		}
		
		/*       S.D.G.       */
	'''
	
	def generateDatabaseHandle() '''
		package com.anfelisa.ace;
		
		import org.jdbi.v3.core.Handle;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		public class DatabaseHandle {
		
			static final Logger LOG = LoggerFactory.getLogger(DatabaseHandle.class);
		
			private Handle handle;
			private Handle timelineHandle;
		
			public DatabaseHandle(Handle handle, Handle timelineHandle) {
				super();
				try {
					if (handle != null) {
						this.handle = handle;
					}
					if (timelineHandle != null) {
						this.timelineHandle = timelineHandle;
					}
				} catch (Exception e) {
					LOG.error("failed to set auto commit off", e);
				}
			}
		
			public void beginTransaction() {
				if (handle != null) {
					handle.begin();
				}
				if (timelineHandle != null) {
					timelineHandle.begin();
				}
			}
		
			public void commitTransaction() {
				if (handle != null) {
					handle.commit();
				}
				if (timelineHandle != null) {
					timelineHandle.commit();
				}
			}
		
			public void rollbackTransaction() {
				if (handle != null) {
					handle.rollback();
				}
				if (timelineHandle != null) {
					timelineHandle.commit();
				}
			}
		
			public void close() {
				if (handle != null) {
					handle.close();
				}
				if (timelineHandle != null) {
					timelineHandle.close();
				}
			}
		
			public Handle getHandle() {
				return handle;
			}
		
			public Handle getTimelineHandle() {
				return timelineHandle;
			}
		
		}

	'''
	
	def generateIDataContainer() '''
		package com.anfelisa.ace;
		
		import org.joda.time.DateTime;
		
		public interface IDataContainer {
		
			String getUuid();

			String getOutcome();

			void setOutcome(String outcome);
			
			DateTime getSystemTime();
			
			void setSystemTime(DateTime systemTime);
		
			Object toPresentationalData();
		
		}
		
	'''
	
	
}