package com.anfelisa.generator

import com.anfelisa.ace.Action
import com.anfelisa.ace.Command
import com.anfelisa.ace.Data
import com.anfelisa.ace.Event
import com.anfelisa.ace.Model
import com.anfelisa.ace.Project
import com.anfelisa.ace.View
import com.anfelisa.extensions.ActionExtension
import com.anfelisa.extensions.AttributeExtension
import com.anfelisa.extensions.CommandExtension
import com.anfelisa.extensions.ComplexAttributeExtension
import com.anfelisa.extensions.DataExtension
import com.anfelisa.extensions.EventExtension
import com.anfelisa.extensions.ModelExtension
import com.anfelisa.extensions.ViewExtension
import javax.inject.Inject

class JavaTemplate {
	
	@Inject
	extension ActionExtension

	@Inject
	extension CommandExtension

	@Inject
	extension EventExtension
	
	@Inject
	extension ViewExtension
	
	@Inject
	extension ModelExtension
	
	@Inject
	extension DataExtension
	
	@Inject
	extension AttributeExtension
	
	@Inject
	extension ComplexAttributeExtension
	
	def generateModel(Model it, Project project) '''
		package «project.name».models;
		
		import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
		
		@JsonDeserialize(as=«modelClassName».class)
		public interface «modelName» {
		
			«FOR attribute : attributes»
				«attribute.interfaceGetter»
			«ENDFOR»

			«FOR complexAttribute : models»
				«complexAttribute.interfaceGetter»
			«ENDFOR»

		}
		
		/*       S.D.G.       */
	'''
	
	def generateModelResource(Model it) '''
		<form class="form-horizontal">

		    <div class="form-group">
		        <label class="col-sm-3 control-label"></label>
		        <div class="col-sm-9">
		            <h4>{{texts.«name.toFirstLower»}}</h4>
		        </div>
		    </div>

			«FOR attribute : attributes»
			    <div class="form-group" id="«attribute.name»Div">
			        <label for="«attribute.name»" class="col-sm-3 control-label">«IF attribute.constraint != null»* «ENDIF»{{texts.«attribute.name»}}</label>
			        <div class="col-sm-9">
			            <input type="text" class="form-control" id="«attribute.name»" placeholder="{{texts.«attribute.name»}}" value="{{«attribute.name»}}"«IF attribute.constraint != null» onblur="new ValidateRequiredFieldAction({id : '«attribute.name»'}).apply()"«ENDIF»>
			            «IF attribute.constraint != null»<span class="help-block notEmpty" style="display: none">{{texts.«attribute.name»NotEmpty}}</span>«ENDIF»
			        </div>
			    </div>
			    
			«ENDFOR»
			«FOR modelRef : models»
				«IF modelRef.list»
					{{#«modelRef.name»}}
					<div class="panel panel-default">
					    <div class="panel-heading">
							«FOR attribute : modelRef.model.attributes»
								<h4 class="panel-title">{{texts.«attribute.name»}}: {{«attribute.name»}}</h4>
							«ENDFOR»
					    </div>
					    <div class="panel-body">
							«FOR attribute : modelRef.model.attributes»
								{{texts.«attribute.name»}}: {{«attribute.name»}}<br>
							«ENDFOR»
					    </div>
					</div>
					{{/«modelRef.name»}}
					{{^«modelRef.name»}}
					<div class="panel panel-default">
					    <div class="panel-heading">
					        <h3 class="panel-title">{{texts.empty«modelRef.name.toFirstUpper»}}</h3>
					    </div>
					</div>
					{{/«modelRef.name»}}
					
					<div class="table-responsive">
					    <table class="table table-bordered table-hover table-responsive">
					        <tr>
								«FOR attribute : modelRef.model.attributes»
									<th>{{texts.«attribute.name»}}</th>
								«ENDFOR»
					        </tr>
					        {{#«modelRef.name»}}
					        <tr>
								«FOR attribute : modelRef.model.attributes»
									<td>{{«attribute.name»}}</td>
								«ENDFOR»
					        </tr>
					        {{/«modelRef.name»}}
					        {{^«modelRef.name»}}
					        <tr>
					            <td colspan="«modelRef.model.attributes.size»">{{texts.empty«modelRef.name.toFirstUpper»}}</td>
					        </tr>
					        {{/«modelRef.name»}}
					    </table>
					</div>
					
				«ENDIF»
				
			«ENDFOR»
			
		</form>
	'''
	
	def generateModelClass(Model it, Project project) '''
		package «project.name».models;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		import javax.validation.constraints.NotNull;
		import org.hibernate.validator.constraints.NotEmpty;

		@SuppressWarnings("all")
		public class «modelClassName» implements «modelName» {
		
			«FOR attribute : attributes»
				«attribute.declaration»
				
			«ENDFOR»
		
			«FOR modelRef : models»
				«modelRef.declaration»
				
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
		
			«FOR modelRef : models»
				«modelRef.getter»
				«modelRef.setter»
				
			«ENDFOR»
				
		}
		
		/*       S.D.G.       */
	'''
	
	def generateDataInterface(Data it, Project project) '''
		package «project.name».data;
		
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
	
	def generateData(Data it, Project project) '''
		package «project.name».data;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		import com.fasterxml.jackson.annotation.JsonIgnore;
		
		import javax.validation.constraints.NotNull;
		import org.hibernate.validator.constraints.NotEmpty;
		import org.joda.time.DateTime;
		import java.util.List;
		
		import com.anfelisa.ace.IDataContainer;
		
		«FOR model : models»
			«model.model.importModel»
		«ENDFOR»
		
		@SuppressWarnings("unused")
		public class «dataName» implements «dataInterfaceName» {
			
			private String uuid;
			
			private String createdId;
			
			«FOR attribute : allAttributes»
				«attribute.declaration»
				
			«ENDFOR»
		
			«FOR modelRef : models»
				«FOR modelModelRef : modelRef.model.models»
					«modelModelRef.declaration»
				«ENDFOR»
				
			«ENDFOR»
			private org.joda.time.DateTime systemTime;
			
			public «dataName»(
				«FOR attribute : allAttributes SEPARATOR ',' AFTER ','»
					«attribute.param»
				«ENDFOR»
				@JsonProperty("uuid") String uuid
			) {
				«FOR attribute : allAttributes»
					«attribute.assign»
				«ENDFOR»
				this.uuid = uuid;
			}
		
			«IF allAttributes.length > 0»
				public «dataName»( String uuid ) {
					this.uuid = uuid;
				}
			«ENDIF»
		
			«FOR attribute : allAttributes»
				«attribute.getter»
				«attribute.setter»
				«attribute.initializer(dataName)»
				
			«ENDFOR»
			«FOR modelRef : models»
				«FOR modelModelRef : modelRef.model.models»
					«modelModelRef.getter»
					«modelModelRef.setter»
				«ENDFOR»
				
			«ENDFOR»
		
			@JsonProperty
			public String getUuid() {
				return this.uuid;
			}
		
			@JsonIgnore
			public String getCreatedId() {
				return createdId;
			}
		
			public void setCreatedId(String createdId) {
				this.createdId = createdId;
			}
		
			@JsonProperty
			public org.joda.time.DateTime getSystemTime() {
				return systemTime;
			}
		
			@JsonProperty
			public void setSystemTime(org.joda.time.DateTime systemTime) {
				this.systemTime = systemTime;
			}
		
		}
		
		/*       S.D.G.       */
	'''
	
	def generateDao(Model it, Project project) '''
		package «project.name».models;
		
		import org.skife.jdbi.v2.Handle;
		import org.skife.jdbi.v2.Query;
		import org.skife.jdbi.v2.Update;
		
		import java.util.List;
		import java.util.Map;
		
		import com.fasterxml.jackson.annotation.JsonIgnoreType;

		@SuppressWarnings("all")
		@JsonIgnoreType
		public class «modelDao» {
			
			public void create(Handle handle) {
				handle.execute("CREATE TABLE IF NOT EXISTS «project.schema».«table» («FOR attribute : attributes SEPARATOR ', '»«attribute.tableDefinition(table)»«ENDFOR»«FOR attribute : attributes»«attribute.primaryKey(table)»«ENDFOR»«FOR attribute : attributes»«attribute.foreignKey(table, project.schema)»«ENDFOR»«FOR attribute : attributes»«attribute.uniqueConstraint(table)»«ENDFOR»)");
			}
			
			public «IF findPrimaryKeyAttribute != null»«findPrimaryKeyAttribute.javaType»«ELSE»void«ENDIF» insert(Handle handle, «modelName» «modelParam») {
				«IF findPrimaryKeyAttribute != null»
					if («modelParam».«findPrimaryKeyAttribute.getterCall» != null) {
						Update statement = handle.createStatement("INSERT INTO «project.schema».«table» («FOR attribute : attributes SEPARATOR ', '»«attribute.name»«ENDFOR») VALUES («FOR attribute : attributes SEPARATOR ', '»:«attribute.name»«ENDFOR»)");
						«FOR attribute : attributes»
							statement.bind("«attribute.name»", «modelParam».«attribute.getterCall»);
						«ENDFOR»
						statement.execute();
						«IF findSerialAttribute != null»handle.createStatement("SELECT setval('«project.schema».«table»_«findSerialAttribute.name»_seq', (SELECT MAX(«findSerialAttribute.name») FROM «project.schema».«table»));").execute();«ENDIF»
						return «modelParam».«findPrimaryKeyAttribute.getterCall»;
					} else {
						Query<Map<String, Object>> statement = handle.createQuery("INSERT INTO «project.schema».«table» («FOR attribute : allNonSerialAttributes SEPARATOR ', '»«attribute.name»«ENDFOR») VALUES («FOR attribute : allNonSerialAttributes SEPARATOR ', '»:«attribute.name»«ENDFOR») RETURNING «findPrimaryKeyAttribute.name»");
						«FOR attribute : allNonSerialAttributes»
							statement.bind("«attribute.name»", «modelParam».«attribute.getterCall»);
						«ENDFOR»
						Map<String, Object> first = statement.first();
						return («findPrimaryKeyAttribute.javaType») first.get("«findPrimaryKeyAttribute.name»");
					}
				«ELSE»
					Update statement = handle.createStatement("INSERT INTO «project.schema».«table» («FOR attribute : allNonSerialAttributes SEPARATOR ', '»«attribute.name»«ENDFOR») VALUES («FOR attribute : allNonSerialAttributes SEPARATOR ', '»:«attribute.name»«ENDFOR»)");
					«FOR attribute : allNonSerialAttributes»
						statement.bind("«attribute.name»", «modelParam».«attribute.getterCall»);
					«ENDFOR»
					statement.execute();
				«ENDIF»
			}
			
			
			«FOR attribute : allUniqueAttributes»
				public void updateBy«attribute.name.toFirstUpper»(Handle handle, «modelName» «modelParam») {
					Update statement = handle.createStatement("UPDATE «project.schema».«table» SET «FOR attr : attributes SEPARATOR ', '»«attr.name» = :«attr.name»«ENDFOR» WHERE «attribute.name» = :«attribute.name»");
					«FOR attr : attributes»
						statement.bind("«attr.name»", «modelParam».«attr.getterCall»);
					«ENDFOR»
					statement.execute();
				}

				public void deleteBy«attribute.name.toFirstUpper»(Handle handle, «attribute.javaType» «attribute.name») {
					Update statement = handle.createStatement("DELETE FROM «project.schema».«table» WHERE «attribute.name» = :«attribute.name»");
					statement.bind("«attribute.name»", «attribute.name»);
					statement.execute();
				}

				public «modelName» selectBy«attribute.name.toFirstUpper»(Handle handle, «attribute.javaType» «attribute.name») {
					return handle.createQuery("SELECT * FROM «project.schema».«table» WHERE «attribute.name» = :«attribute.name»")
						.bind("«attribute.name»", «attribute.name»)
						.map(new «modelMapper»())
						.first();
				}
			«ENDFOR»
			
			public List<«modelName»> selectAll(Handle handle) {
				return handle.createQuery("SELECT * FROM «project.schema».«table»")
					.map(new «modelMapper»())
					.list();
			}
		}
		
		/*       S.D.G.       */
	'''
	
	def generateMigration(Model it, Project project) '''
		        <createTable tableName="«table»">
		        	«FOR attribute : attributes»
		        		<column name="«attribute.name»" type="«attribute.sqlType»">
		        			<constraints «IF attribute.isPrimaryKey»primaryKey="true"«ENDIF» «IF attribute.constraint != null && attribute.constraint.equals('NotNull')»nullable="false"«ENDIF»/>
		        		</column>
		        	«ENDFOR»
		        </createTable>
	'''
	
	def generateMapper(Model it, Project project) '''
		package «project.name».models;
		
		import java.sql.ResultSet;
		import java.sql.SQLException;
		
		import org.skife.jdbi.v2.StatementContext;
		import org.skife.jdbi.v2.tweak.ResultSetMapper;
		
		public class «modelMapper» implements ResultSetMapper<«modelName»> {
			
			public «modelName» map(int index, ResultSet r, StatementContext ctx) throws SQLException {
				return new «modelClassName»(
					«FOR attribute : attributes SEPARATOR ','»
						«attribute.mapperInit»
					«ENDFOR»
				);
			}
		}
		
		/*       S.D.G.       */
	'''
	
	def generateAbstractActionFile(Action it, Project project) '''
		package «project.name».actions;
		
		import org.skife.jdbi.v2.DBI;
		import javax.ws.rs.WebApplicationException;
		import javax.ws.rs.core.Response;

		import com.anfelisa.ace.Action;
		import com.anfelisa.ace.HttpMethod;
		import com.anfelisa.ace.ICommand;
		«data.dataImport»
		
		«IF command != null»
			import «project.name».commands.«command.commandName»;
		«ENDIF»
		
		public abstract class «abstractActionName» extends Action<«data.dataParamType»> {
		
			public «abstractActionName»(DBI jdbi) {
				super("«actionName»", HttpMethod.«type», jdbi);
			}
		
			@Override
			public ICommand getCommand() {
				«IF command != null»
					return new «command.commandName»(this.actionData, databaseHandle);
				«ELSE»
					return null;
				«ENDIF»
			}
		
			«IF !type.equals("GET")»
				protected final void loadDataForGetRequest() {
				}
			«ENDIF»
		
			protected void throwUnauthorized() {
				throw new WebApplicationException(Response.Status.UNAUTHORIZED);
			}
		
			protected void throwBadRequest() {
				throw new WebApplicationException(Response.Status.BAD_REQUEST);
			}
		
		}
		
		/*       S.D.G.       */
	'''

	def generateAbstractCommandFile(Command it, Project project) '''
		package «project.name».commands;
		
		import javax.ws.rs.WebApplicationException;
		import javax.ws.rs.core.Response;
		
		import com.anfelisa.ace.Command;
		import com.anfelisa.ace.DatabaseHandle;

		«data.dataImport»

		public abstract class «abstractCommandName» extends Command<«data.dataParamType»> {
		
			«FOR eventOnOutcome : eventsOnOutcome»
				protected static final String «eventOnOutcome.outcome» = "«eventOnOutcome.outcome»";
			«ENDFOR»
		
			public «abstractCommandName»(«data.dataParamType» commandParam, DatabaseHandle databaseHandle) {
				super("«commandName»", commandParam, databaseHandle);
			}
		
			@Override
			protected void publishEvents() {
				switch (this.outcome) {
				«FOR eventOnOutcome : eventsOnOutcome»
					case «eventOnOutcome.outcome»:
						«FOR event : eventOnOutcome.events»
							new «event.eventNameWithPackage»(this.commandData, databaseHandle).publish();
						«ENDFOR»
						«FOR action : eventOnOutcome.actions»
							«action.newAction»
							Thread actionThread = new Thread(new Runnable() {
								public void run() {
									action.apply();
								}
							});
							actionThread.start();
							
						«ENDFOR»
						break;
				«ENDFOR»
				default:
					throw new WebApplicationException("unhandled outcome " + outcome);
				}
			}
			
			protected void throwUnauthorized() {
				throw new WebApplicationException(Response.Status.UNAUTHORIZED);
			}

			protected void throwBadRequest() {
				throw new WebApplicationException(Response.Status.BAD_REQUEST);
			}
		
		}
		
		/*       S.D.G.       */
	'''

	def generateAbstractEventFile(Event it, Project project) '''
		package «project.name».events;
		
		import com.anfelisa.ace.DatabaseHandle;
		import com.anfelisa.ace.Event;
		
		«data.dataImport»
		
		public abstract class «abstractEventName» extends Event<«data.dataParamType»> {
		
			public «abstractEventName»(«data.dataParamType» eventParam, DatabaseHandle databaseHandle) {
				super("«eventName»", eventParam, databaseHandle);
			}
		
		}
		
		/*       S.D.G.       */
	'''

	def generateInitialActionFile(Action it, Project project) '''
		package «project.name».actions;
		
		import javax.annotation.security.PermitAll;
		import javax.ws.rs.Consumes;
		import javax.ws.rs.POST;
		import javax.ws.rs.PUT;
		import javax.ws.rs.DELETE;
		import javax.ws.rs.GET;
		import javax.ws.rs.Path;
		import javax.ws.rs.Produces;
		import javax.ws.rs.core.MediaType;
		import javax.ws.rs.core.Response;
		
		import com.anfelisa.ace.DatabaseHandle;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;

		import com.codahale.metrics.annotation.Timed;
		import com.fasterxml.jackson.core.JsonProcessingException;
		import org.skife.jdbi.v2.DBI;
		
		«data.dataImport»
		
		@Path("/«data.name»")
		«IF type != null && type == "POST"»@Produces(MediaType.TEXT_PLAIN)«ELSE»@Produces(MediaType.APPLICATION_JSON)«ENDIF»
		@Consumes(MediaType.APPLICATION_JSON)
			public class «actionName» extends «abstractActionName» {
		
			static final Logger LOG = LoggerFactory.getLogger(«actionName».class);

			public «actionName»(DBI jdbi) {
				super(jdbi);
			}
		
			«IF type != null»@«type»«ENDIF»
			@Timed
			@Path("/«IF type != null»«type.toLowerCase»«ELSE»«resourceName.toLowerCase»«ENDIF»")
			@PermitAll
			public Response «IF type != null»«type.toLowerCase»«ELSE»«resourceName.toFirstLower»«ENDIF»() throws JsonProcessingException {
				this.actionData = null;
				return this.apply();
			}
		
			«IF type.equals("GET")»
				protected final void loadDataForGetRequest() {
				}
			«ENDIF»
		
		}
		
		/*       S.D.G.       */
	'''
	
	def generateInitialCommandFile(Command it, Project project) '''
		package «project.name».commands;
		
		import com.anfelisa.ace.DatabaseHandle;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		«data.dataImport»
		
		public class «commandName» extends «abstractCommandName» {
		
			static final Logger LOG = LoggerFactory.getLogger(«commandName».class);

			public «commandName»(«data.dataParamType» commandParam, DatabaseHandle databaseHandle) {
				super(commandParam, databaseHandle);
			}
		
			@Override
			protected void executeCommand() {
				«IF eventsOnOutcome.size > 0»
					this.outcome = «eventsOnOutcome.get(0).outcome»;
				«ENDIF»
			}
		
		}
		
		/*       S.D.G.       */
	'''
	
	def generateInitialEventFile(Event it, Project project) '''
		package «project.name».events;
		
		import com.anfelisa.ace.DatabaseHandle;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		«data.dataImport»
		
		public class «eventName» extends «abstractEventName» {
		
			static final Logger LOG = LoggerFactory.getLogger(«eventName».class);

			public «eventName»(«data.dataParamType» eventParam, DatabaseHandle databaseHandle) {
				super(eventParam, databaseHandle);
			}
		
			@Override
			protected void prepareDataForView() {
				this.eventData = this.eventParam;
			}
		
		}
		
		/*       S.D.G.       */
	'''
	
	def generateView(View it, Project project) '''
		package «project.name».views;
		
		import java.util.function.BiConsumer;
		
		import org.skife.jdbi.v2.Handle;
		
		import com.anfelisa.ace.IDataContainer;
		«FOR renderFunction : renderFunctions»
			«renderFunction.data.dataImport»
		«ENDFOR»
		
		public class «viewName» {
		
			«FOR renderFunction : renderFunctions»
			    public BiConsumer<«renderFunction.data.dataName», Handle> «renderFunction.name» = (dataContainer, handle) -> {
			    };
			«ENDFOR»
		
		}
		
		/*                    S.D.G.                    */
	'''

	def generateAppRegistration(Project it) '''
		package «name»;
		
		import io.dropwizard.setup.Environment;
		import com.anfelisa.ace.AceController;
		
		import org.skife.jdbi.v2.DBI;
		
		«IF views.size > 0»
			import «name».views.*;
		«ENDIF»
		«IF actions.size > 0»
			import «name».actions.*;
		«ENDIF»

		public class AppRegistration {
		
			public static void registerResources(Environment environment, DBI jdbi) {
				«FOR action : actions»
					environment.jersey().register(new «action.actionName»(jdbi));
				«ENDFOR»
			}
		
			public static void registerConsumers() {
				«FOR view : views»
					«view.viewName» «view.viewNameAsVariable» = new «view.viewName»();
				«ENDFOR»
				
				«FOR event : events»
					«FOR renderFunction : event.listeners»
						AceController.addConsumer("«event.eventName»", «renderFunction.viewFunctionWithViewNameAsVariable»);
			    	«ENDFOR»
		    	«ENDFOR»
		    }
		}
		
		/*                    S.D.G.                    */
	'''

	
}