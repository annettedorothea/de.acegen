package com.anfelisa.templates.java

import com.anfelisa.ace.JAVA
import com.anfelisa.ace.JAVA_ACE
import com.anfelisa.ace.Model
import com.anfelisa.extensions.java.AceExtension
import com.anfelisa.extensions.java.AttributeExtension
import com.anfelisa.extensions.java.ModelExtension
import javax.inject.Inject

class ModelTemplate {
	
	@Inject
	extension ModelExtension
	
	@Inject
	extension AttributeExtension
	
	@Inject
	extension AceExtension
	
	def generateModel(Model it, JAVA java) '''
		package «java.name».models;
		
		import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
		
		@JsonDeserialize(as=«modelClassName».class)
		public interface «modelName» «IF superModels.size > 0»extends «FOR superModel : superModels SEPARATOR ','»«superModel.interfaceWithPackage»«ENDFOR»«ENDIF»{
		
			«FOR attribute : attributes»
				«attribute.interfaceGetter»
				«attribute.interfaceSetter»
				
			«ENDFOR»

		}
		
		/*       S.D.G.       */
	'''
	
	def generateModelClass(Model it, JAVA java) '''
		package «java.name».models;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		import javax.validation.constraints.NotNull;
		import org.hibernate.validator.constraints.NotEmpty;

		@SuppressWarnings("all")
		public class «modelClassName» implements «modelName» {
		
			«FOR attribute : allAttributes»
				«attribute.declaration»
				
			«ENDFOR»
		
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
		
		/*       S.D.G.       */
	'''
	
	def generateDataInterface(Model it, JAVA java) '''
		package «java.name».data;
		
		import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
		
		import com.anfelisa.ace.IDataContainer;
		
		«importModel»
		
		@JsonDeserialize(as=«dataName».class)
		public interface «dataInterfaceName» extends «modelName», IDataContainer {
			«FOR superModel : superModels»
				void mapFrom(«superModel.interfaceWithPackage» model);
			«ENDFOR»
		}
		
		/*       S.D.G.       */
	'''
	
	def generateAbstractData(Model it, JAVA java) '''
		package «java.name».data;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		
		import javax.validation.constraints.NotNull;
		import org.hibernate.validator.constraints.NotEmpty;
		import org.joda.time.DateTime;
		import java.util.List;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import com.anfelisa.ace.AbstractData;
		import com.anfelisa.ace.IDataContainer;
		
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
				
			«ENDFOR»
			
			«FOR superModel : superModels»
				public void mapFrom(«superModel.interfaceWithPackage» model) {
					«FOR attribute: superModel.allAttributes»
						this.«attribute.name» = model.«attribute.getterCall»;
					«ENDFOR»
				}
			«ENDFOR»
		}
		
		/*       S.D.G.       */
	'''
	
	def generateData(Model it, JAVA java) '''
		package «java.name».data;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		
		import org.joda.time.DateTime;
		import java.util.List;
		
		import com.anfelisa.ace.AbstractData;
		import com.anfelisa.ace.IDataContainer;
		
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
		
			public void overwriteNotReplayableData(IDataContainer dataContainer) {
				/*if (dataContainer != null) {
					try {
						«dataInterfaceName» original = («dataInterfaceName»)dataContainer;
						//overwrite values
					} catch (ClassCastException x) {
						LOG.error("cannot cast data to «dataInterfaceName» for overwriting not replayable attributes", x);
					}
				}*/
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
	
	def generateResponseData(JAVA_ACE it, JAVA java) '''
		package «java.name».data;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		import com.fasterxml.jackson.annotation.JsonIgnore;
		
		import javax.validation.constraints.NotNull;
		import org.hibernate.validator.constraints.NotEmpty;
		import org.joda.time.DateTime;
		import java.util.List;
		
		import com.anfelisa.ace.IDataContainer;
		
		@SuppressWarnings("all")
		public class «responseDataName» implements «responseDataInterfaceName» {
			
			«FOR attribute : response»
				«attribute.declaration»
				
			«ENDFOR»
			public «responseDataName»(«model.interfaceWithPackage» data) {
				«FOR attribute : response»
					«attribute.name» = data.«attribute.getterCall»;
				«ENDFOR»
			}
			
			«FOR attribute : response»
				«attribute.getter(true)»
				
			«ENDFOR»
		}
		
		/*       S.D.G.       */
	'''
	
	def generateReponseDataInterface(JAVA_ACE it, JAVA java) '''
		package «java.name».data;
		
		public interface «responseDataInterfaceName» {
			«FOR attribute : response»
				«attribute.interfaceGetter»
				
			«ENDFOR»
		
		}
		
		/*       S.D.G.       */
	'''
	
	def generateAbstractDao(Model it, JAVA java) '''
		package «java.name».models;
		
		import org.jdbi.v3.core.Handle;
		import org.jdbi.v3.core.statement.Update;

		import java.util.List;
		import java.util.Optional;
		
		@SuppressWarnings("all")
		public class «abstractModelDao» {
			
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
	
	def generateDao(Model it, JAVA java) '''
		package «java.name».models;
		
		public class «modelDao» extends «abstractModelDao» {
			
		}
		
		/*       S.D.G.       */
	'''
	
	def generateMigration(Model it, JAVA java) '''
		<createTable tableName="«table»">
			«FOR attribute : attributes»
				<column name="«attribute.name.toLowerCase»" type="«attribute.sqlType»">
					<constraints «IF attribute.isPrimaryKey»primaryKey="true"«ENDIF» «IF attribute.constraint !== null && attribute.constraint.equals('NotNull')»nullable="false"«ENDIF» «IF attribute.foreignKey !== null»	references="«attribute.foreignKey.tableName»(«attribute.foreignKey.name.toLowerCase»)" deleteCascade="true" foreignKeyName="fk_«table»_«attribute.foreignKey.name.toLowerCase»"«ENDIF» />
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
		
		public class «modelMapper» implements RowMapper<«modelName»> {
			
			public «modelName» map(ResultSet r, StatementContext ctx) throws SQLException {
				return new «modelClassName»(
					«FOR attribute : allAttributes SEPARATOR ','»
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
				if (handle != null) {
					this.handle = handle;
				}
				if (timelineHandle != null) {
					this.timelineHandle = timelineHandle;
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
		
			void migrateLegacyData(String json);
		
			void overwriteNotReplayableData(IDataContainer original);
		
		}
		
	'''
	

	
}