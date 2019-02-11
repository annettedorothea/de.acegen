package com.anfelisa.templates.java

import com.anfelisa.ace.AuthUser
import com.anfelisa.ace.JAVA
import com.anfelisa.ace.JAVA_ACE
import com.anfelisa.ace.JAVA_Outcome
import com.anfelisa.ace.JAVA_ViewFunction
import com.anfelisa.extensions.java.AceExtension
import com.anfelisa.extensions.java.AttributeExtension
import com.anfelisa.extensions.java.ModelExtension
import com.anfelisa.extensions.java.ViewExtension
import javax.inject.Inject
import com.anfelisa.ace.JAVA_ACE_WRITE
import com.anfelisa.ace.JAVA_ACE_READ

class ActionTemplate {

	@Inject
	extension ModelExtension

	@Inject
	extension AceExtension

	@Inject
	extension ViewExtension

	@Inject
	extension AttributeExtension

	def dispatch generateAbstractActionFile(JAVA_ACE_WRITE it, JAVA java, AuthUser authUser) '''
		package «java.name».actions;
		
		import java.util.UUID;
		
		import javax.validation.constraints.NotNull;
		import javax.ws.rs.Consumes;
		import javax.ws.rs.POST;
		import javax.ws.rs.PUT;
		import javax.ws.rs.DELETE;
		import javax.ws.rs.GET;
		import javax.ws.rs.Path;
		import javax.ws.rs.Produces;
		import javax.ws.rs.core.MediaType;
		import javax.ws.rs.core.Response;
		import javax.ws.rs.QueryParam;
		import javax.ws.rs.PathParam;
		import io.dropwizard.auth.Auth;
		import javax.ws.rs.HeaderParam;
		
		import com.anfelisa.ace.CustomAppConfiguration;
		import com.anfelisa.ace.ViewProvider;
		import com.anfelisa.ace.IDaoProvider;
		import com.anfelisa.ace.IDataContainer;
		import com.anfelisa.ace.App;
		import com.anfelisa.ace.DatabaseHandle;
		import com.anfelisa.ace.ServerConfiguration;
		import com.anfelisa.ace.E2E;
		import com.anfelisa.ace.ITimelineItem;
		import com.anfelisa.ace.IAction;
		import com.anfelisa.ace.SetSystemTimeResource;
		import com.anfelisa.ace.JodaObjectMapper;
		
		import com.codahale.metrics.annotation.Timed;
		import com.fasterxml.jackson.core.JsonProcessingException;

		import org.jdbi.v3.core.Jdbi;
		import org.jdbi.v3.core.Handle;
		
		import com.anfelisa.ace.Action;
		import com.anfelisa.ace.HttpMethod;
		import com.anfelisa.ace.ICommand;
		import org.joda.time.DateTime;
		import org.joda.time.DateTimeZone;
		
		import javax.ws.rs.WebApplicationException;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		«IF authorize && authUser !== null»import com.anfelisa.auth.«authUser.name.toFirstUpper»;«ENDIF»
		«model.dataImport»
		«model.dataClassImport»
		«IF outcomes.size > 0»
			import «commandNameWithPackage(java)»;
		«ENDIF»
		
		@Path("«url»")
		@SuppressWarnings("unused")
		public abstract class «abstractActionName» extends Action<«model.dataParamType»> {
		
			static final Logger LOG = LoggerFactory.getLogger(«abstractActionName».class);

			private DatabaseHandle databaseHandle;
			private Jdbi jdbi;
			protected JodaObjectMapper mapper;
			protected CustomAppConfiguration appConfiguration;
			protected IDaoProvider daoProvider;
			private ViewProvider viewProvider;
			private E2E e2e;

			public «abstractActionName»(Jdbi jdbi, CustomAppConfiguration appConfiguration, 
					IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
				super("«actionNameWithPackage(java)»", HttpMethod.«type»);
				this.jdbi = jdbi;
				mapper = new JodaObjectMapper();
				this.appConfiguration = appConfiguration;
				this.daoProvider = daoProvider;
				this.viewProvider = viewProvider;
				this.e2e = e2e;
			}
		
			@Override
			public ICommand getCommand() {
				«IF outcomes.size > 0»
					return new «commandName»(this.actionData, daoProvider, viewProvider, this.appConfiguration);
				«ELSE»
					return null;
				«ENDIF»
			}
			
			public void setActionData(IDataContainer data) {
				this.actionData = («model.dataParamType»)data;
			}
		
			«IF type !== null»@«type»«ENDIF»
			@Timed
			@Produces(MediaType.APPLICATION_JSON)
			@Consumes(MediaType.APPLICATION_JSON)
			public Response «resourceName.toFirstLower»(
					«IF authorize && authUser !== null»@Auth «authUser.name.toFirstUpper» «authUser.name.toFirstLower», «ENDIF»
					«FOR param : queryParams»
						@QueryParam("«param.name»") «param.resourceParamType» «param.name», 
					«ENDFOR»
					«FOR param : pathParams»
						@PathParam("«param.name»") «param.resourceParamType» «param.name», 
					«ENDFOR»
					«IF payload.size > 0»@NotNull «model.dataParamType» payload)«ELSE»@NotNull @QueryParam("uuid") String uuid)«ENDIF» 
					throws JsonProcessingException {
				this.actionData = new «model.dataName»(«IF payload.size > 0»payload.getUuid()«ELSE»uuid«ENDIF»);
				«FOR param : queryParams»
					this.actionData.«param.setterCall(param.resourceParam)»;
				«ENDFOR»
				«FOR param : pathParams»
					this.actionData.«param.setterCall(param.resourceParam)»;
				«ENDFOR»
				«FOR attribute : payload»
					this.actionData.«attribute.setterCall('''payload.«attribute.getterCall»''')»;
				«ENDFOR»
				«IF authorize && authUser !== null»
					«FOR param : model.allAttributes»
						«IF authUser.attributes.containsAttribute(param)»this.actionData.«param.setterCall('''«authUser.name.toFirstLower».«getterCall(param)»''')»;«ENDIF»
					«ENDFOR»
				«ENDIF»
				
				return this.apply();
			}
			
			public Response apply() {
				databaseHandle = new DatabaseHandle(jdbi);
				databaseHandle.beginTransaction();
				try {
					if (ServerConfiguration.DEV.equals(appConfiguration.getServerConfiguration().getMode())
							|| ServerConfiguration.LIVE.equals(appConfiguration.getServerConfiguration().getMode())) {
						if (daoProvider.getAceDao().contains(databaseHandle.getHandle(), this.actionData.getUuid())) {
							databaseHandle.commitTransaction();
							throwBadRequest("uuid already exists - please choose another one");
						}
						this.actionData.setSystemTime(new DateTime());
						«FOR outcome: outcomes»
							«FOR triggeredAction : outcome.aceOperations»
								this.actionData.addUuidForTriggeredAction("«triggeredAction.actionNameWithPackage»", UUID.randomUUID().toString());
							«ENDFOR»
						«ENDFOR»
						this.initActionData();
					} else if (ServerConfiguration.REPLAY.equals(appConfiguration.getServerConfiguration().getMode())) {
						ITimelineItem timelineItem = e2e.selectAction(this.actionData.getUuid());
						IDataContainer originalData = AceDataFactory.createAceData(timelineItem.getName(), timelineItem.getData());
						this.actionData = («model.dataParamType»)originalData;
					} else if (ServerConfiguration.TEST.equals(appConfiguration.getServerConfiguration().getMode())) {
						if (SetSystemTimeResource.systemTime != null) {
							this.actionData.setSystemTime(SetSystemTimeResource.systemTime);
						} else {
							this.actionData.setSystemTime(new DateTime());
						}
						«FOR outcome: outcomes»
							«FOR triggeredAction : outcome.aceOperations»
								this.actionData.addUuidForTriggeredAction("«triggeredAction.actionNameWithPackage»", UUID.randomUUID().toString());
							«ENDFOR»
						«ENDFOR»
					}
					daoProvider.getAceDao().addActionToTimeline(this, this.databaseHandle.getTimelineHandle());
					ICommand command = this.getCommand();
					«IF proxy»
						if (ServerConfiguration.REPLAY.equals(appConfiguration.getServerConfiguration().getMode())) {
							ITimelineItem timelineItem = e2e.selectCommand(this.actionData.getUuid());
							IDataContainer originalData = AceDataFactory.createAceData(timelineItem.getName(), timelineItem.getData());
							command.setCommandData(originalData);
						} else {
							command.execute(this.databaseHandle.getReadonlyHandle(), this.databaseHandle.getTimelineHandle());
						}
					«ELSE»
						command.execute(this.databaseHandle.getReadonlyHandle(), this.databaseHandle.getTimelineHandle());
					«ENDIF»
					command.publishEvents(this.databaseHandle.getHandle(), this.databaseHandle.getTimelineHandle());
					Response response = Response.ok(this.createReponse()).build();
					databaseHandle.commitTransaction();
					
					«FOR outcome : outcomes»
						«FOR triggeredAction : outcome.aceOperations»
							«triggeredAction.name.toFirstUpper»Thread «triggeredAction.name.toFirstLower»Thread = new «triggeredAction.name.toFirstUpper»Thread(
								jdbi, mapper, appConfiguration, daoProvider, viewProvider, e2e, command.getCommandData());
							e2e.addTriggeredThread(«triggeredAction.name.toFirstLower»Thread);
							«triggeredAction.name.toFirstLower»Thread.start();
						«ENDFOR»
						
					«ENDFOR»
					return response;
				} catch (WebApplicationException x) {
					LOG.error(actionName + " failed " + x.getMessage());
					try {
						databaseHandle.rollbackTransaction();
						daoProvider.getAceDao().addExceptionToTimeline(this.actionData.getUuid(), x, this.databaseHandle.getTimelineHandle());
						App.reportException(x);
					} catch (Exception ex) {
						LOG.error("failed to rollback or to save or report exception " + ex.getMessage());
					}
					return Response.status(x.getResponse().getStatusInfo()).entity(x.getMessage()).build();
				} catch (Exception x) {
					LOG.error(actionName + " failed " + x.getMessage());
					try {
						databaseHandle.rollbackTransaction();
						daoProvider.getAceDao().addExceptionToTimeline(this.actionData.getUuid(), x, this.databaseHandle.getTimelineHandle());
						App.reportException(x);
					} catch (Exception ex) {
						LOG.error("failed to rollback or to save or report exception " + ex.getMessage());
					}
					return Response.status(500).entity(x.getMessage()).build();
				} finally {
					databaseHandle.close();
				}
			}
			
			«FOR outcome : outcomes»
				«FOR triggeredAction : outcome.aceOperations»
					public class «triggeredAction.name.toFirstUpper»Thread extends Thread {
						private Jdbi jdbi;
						private JodaObjectMapper mapper;
						private CustomAppConfiguration appConfiguration;
						private IDaoProvider daoProvider;
						private ViewProvider viewProvider;
						private IDataContainer commandData;
						private E2E e2e;

						public «triggeredAction.name.toFirstUpper»Thread(Jdbi jdbi, JodaObjectMapper mapper, CustomAppConfiguration appConfiguration,
								IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e, IDataContainer commandData) {
						   this.jdbi = jdbi;
						   this.mapper = mapper;
						   this.appConfiguration = appConfiguration;
						   this.daoProvider = daoProvider;
						   this.viewProvider = viewProvider;
						   this.e2e = e2e;
						   this.commandData = commandData;
						   this.setName("«triggeredAction.name.toFirstUpper»Thread");
						}
					
						public void run() {
							try {
								LOG.info("trigger «triggeredAction.name»");
								«triggeredAction.actionNameWithPackage()» «triggeredAction.name.toFirstLower» 
									= new «triggeredAction.actionNameWithPackage()»(jdbi, appConfiguration, daoProvider, viewProvider, e2e);
								IDataContainer data = AceDataFactory.createAceData("«triggeredAction.actionNameWithPackage»", mapper.writeValueAsString(commandData));
								data.setUuid(commandData.getUuidForTriggeredAction("«triggeredAction.actionNameWithPackage»"));
								«triggeredAction.name.toFirstLower».setActionData(data);
								«triggeredAction.name.toFirstLower».apply();
								LOG.info("trigger «triggeredAction.name» finished");
							} catch (Exception x) {
								LOG.error("failed to trigger «triggeredAction.name» " + x.getMessage());
							}
						}
					};
				«ENDFOR»
				
			«ENDFOR»
			
		

			«IF response.size > 0»
				protected Object createReponse() {
					return new «responseDataNameWithPackage(java)»(this.actionData);
				}
			«ENDIF»
		}
		
		/*       S.D.G.       */
	'''

	def dispatch generateAbstractActionFile(JAVA_ACE_READ it, JAVA java, AuthUser authUser) '''
		package «java.name».actions;
		
		import javax.validation.constraints.NotNull;
		import javax.ws.rs.Consumes;
		import javax.ws.rs.POST;
		import javax.ws.rs.PUT;
		import javax.ws.rs.DELETE;
		import javax.ws.rs.GET;
		import javax.ws.rs.Path;
		import javax.ws.rs.Produces;
		import javax.ws.rs.core.MediaType;
		import javax.ws.rs.core.Response;
		import javax.ws.rs.QueryParam;
		import javax.ws.rs.PathParam;
		import io.dropwizard.auth.Auth;
		
		import com.anfelisa.ace.CustomAppConfiguration;
		import com.anfelisa.ace.ViewProvider;
		import com.anfelisa.ace.IDaoProvider;
		import com.anfelisa.ace.IDataContainer;
		import com.anfelisa.ace.App;
		import com.anfelisa.ace.DatabaseHandle;
		import com.anfelisa.ace.ServerConfiguration;
		import com.anfelisa.ace.E2E;
		import com.anfelisa.ace.ITimelineItem;
		import com.anfelisa.ace.IAction;
		import com.anfelisa.ace.SetSystemTimeResource;
		import com.anfelisa.ace.JodaObjectMapper;
		
		import com.codahale.metrics.annotation.Timed;
		import com.fasterxml.jackson.core.JsonProcessingException;

		import org.jdbi.v3.core.Jdbi;
		import org.jdbi.v3.core.Handle;
		
		import com.anfelisa.ace.Action;
		import com.anfelisa.ace.HttpMethod;
		import com.anfelisa.ace.ICommand;
		import org.joda.time.DateTime;
		import org.joda.time.DateTimeZone;
		
		import javax.ws.rs.WebApplicationException;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		«IF authorize && authUser !== null»import com.anfelisa.auth.«authUser.name.toFirstUpper»;«ENDIF»
		«model.dataImport»
		«model.dataClassImport»
		
		@Path("«url»")
		@SuppressWarnings("unused")
		public abstract class «abstractActionName» extends Action<«model.dataParamType»> {
		
			static final Logger LOG = LoggerFactory.getLogger(«abstractActionName».class);

			private DatabaseHandle databaseHandle;
			private Jdbi jdbi;
			protected JodaObjectMapper mapper;
			protected CustomAppConfiguration appConfiguration;
			protected IDaoProvider daoProvider;
			private ViewProvider viewProvider;
			private E2E e2e;

			public «abstractActionName»(Jdbi jdbi, CustomAppConfiguration appConfiguration, 
					IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
				super("«actionNameWithPackage(java)»", HttpMethod.«type»);
				this.jdbi = jdbi;
				mapper = new JodaObjectMapper();
				this.appConfiguration = appConfiguration;
				this.daoProvider = daoProvider;
				this.viewProvider = viewProvider;
				this.e2e = e2e;
			}
		
			@Override
			public ICommand getCommand() {
				return null;
			}
			
			public void setActionData(IDataContainer data) {
				this.actionData = («model.dataParamType»)data;
			}
		
			protected abstract void loadDataForGetRequest(Handle readonlyHandle);
		
			«IF type !== null»@«type»«ENDIF»
			@Timed
			@Produces(MediaType.APPLICATION_JSON)
			@Consumes(MediaType.APPLICATION_JSON)
			public Response «resourceName.toFirstLower»(
					«IF authorize && authUser !== null»@Auth «authUser.name.toFirstUpper» «authUser.name.toFirstLower», «ENDIF»
					«FOR param : queryParams»
						@QueryParam("«param.name»") «param.resourceParamType» «param.name», 
					«ENDFOR»
					«FOR param : pathParams»
						@PathParam("«param.name»") «param.resourceParamType» «param.name», 
					«ENDFOR»
					«IF payload.size > 0»@NotNull «model.dataParamType» payload)
					«ELSE»@NotNull @QueryParam("uuid") String uuid)«ENDIF» 
					throws JsonProcessingException {
				this.actionData = new «model.dataName»(«IF payload.size > 0»payload.getUuid()«ELSE»uuid«ENDIF»);
				«FOR param : queryParams»
					this.actionData.«param.setterCall(param.resourceParam)»;
				«ENDFOR»
				«FOR param : pathParams»
					this.actionData.«param.setterCall(param.resourceParam)»;
				«ENDFOR»
				«FOR attribute : payload»
					this.actionData.«attribute.setterCall('''payload.«attribute.getterCall»''')»;
				«ENDFOR»
				«IF authorize && authUser !== null»
					«FOR param : model.allAttributes»
						«IF authUser.attributes.containsAttribute(param)»this.actionData.«param.setterCall('''«authUser.name.toFirstLower».«getterCall(param)»''')»;«ENDIF»
					«ENDFOR»
				«ENDIF»
				return this.apply();
			}

			public Response apply() {
				databaseHandle = new DatabaseHandle(jdbi);
				databaseHandle.beginTransaction();
				try {
					if (ServerConfiguration.DEV.equals(appConfiguration.getServerConfiguration().getMode())
							|| ServerConfiguration.LIVE.equals(appConfiguration.getServerConfiguration().getMode())) {
						if (daoProvider.getAceDao().contains(databaseHandle.getHandle(), this.actionData.getUuid())) {
							databaseHandle.commitTransaction();
							throwBadRequest("uuid already exists - please choose another one");
						}
						this.actionData.setSystemTime(new DateTime());
						this.initActionData();
					} else if (ServerConfiguration.REPLAY.equals(appConfiguration.getServerConfiguration().getMode())) {
						ITimelineItem timelineItem = e2e.selectAction(this.actionData.getUuid());
						IDataContainer originalData = AceDataFactory.createAceData(timelineItem.getName(), timelineItem.getData());
						this.actionData = («model.dataParamType»)originalData;
					} else if (ServerConfiguration.TEST.equals(appConfiguration.getServerConfiguration().getMode())) {
						if (SetSystemTimeResource.systemTime != null) {
							this.actionData.setSystemTime(SetSystemTimeResource.systemTime);
						} else {
							this.actionData.setSystemTime(new DateTime());
						}
					}
					«IF proxy»
						if (!ServerConfiguration.REPLAY.equals(appConfiguration.getServerConfiguration().getMode())) {
							this.loadDataForGetRequest(this.databaseHandle.getReadonlyHandle());
						}
					«ELSE»
						this.loadDataForGetRequest(this.databaseHandle.getReadonlyHandle());
					«ENDIF»
					daoProvider.getAceDao().addActionToTimeline(this, this.databaseHandle.getTimelineHandle());
					Response response = Response.ok(this.createReponse()).build();
					databaseHandle.commitTransaction();
					return response;
				} catch (WebApplicationException x) {
					LOG.error(actionName + " failed " + x.getMessage());
					try {
						databaseHandle.rollbackTransaction();
						daoProvider.getAceDao().addExceptionToTimeline(this.actionData.getUuid(), x, this.databaseHandle.getTimelineHandle());
						App.reportException(x);
					} catch (Exception ex) {
						LOG.error("failed to rollback or to save or report exception " + ex.getMessage());
					}
					return Response.status(x.getResponse().getStatusInfo()).entity(x.getMessage()).build();
				} catch (Exception x) {
					LOG.error(actionName + " failed " + x.getMessage());
					try {
						databaseHandle.rollbackTransaction();
						daoProvider.getAceDao().addExceptionToTimeline(this.actionData.getUuid(), x, this.databaseHandle.getTimelineHandle());
						App.reportException(x);
					} catch (Exception ex) {
						LOG.error("failed to rollback or to save or report exception " + ex.getMessage());
					}
					return Response.status(500).entity(x.getMessage()).build();
				} finally {
					databaseHandle.close();
				}
			}
		

			«IF response.size > 0»
				protected Object createReponse() {
					return new «responseDataNameWithPackage(java)»(this.actionData);
				}
			«ENDIF»
		}
		
		/*       S.D.G.       */
	'''

	def generateInitialActionFile(JAVA_ACE it, JAVA java) '''
		package «java.name».actions;
		
		import com.anfelisa.ace.CustomAppConfiguration;
		import com.anfelisa.ace.ViewProvider;
		import com.anfelisa.ace.IDaoProvider;
		import com.anfelisa.ace.E2E;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;

		import org.jdbi.v3.core.Handle;
		import org.jdbi.v3.core.Jdbi;
		
		public class «actionName» extends «abstractActionName» {
		
			static final Logger LOG = LoggerFactory.getLogger(«actionName».class);
		
			public «actionName»(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, 
					ViewProvider viewProvider, E2E e2e) {
				super(jdbi,appConfiguration, daoProvider, viewProvider, e2e);
			}
		
		
			«IF type.equals("GET")»
				protected void loadDataForGetRequest(Handle readonlyHandle) {
				}
			«ENDIF»
			
			public void initActionData() {
				// init not replayable data here
			}
		
		}
		
		/*       S.D.G.       */
	'''

	def generateAction() '''
		package com.anfelisa.ace;
		
		import javax.ws.rs.WebApplicationException;
		import javax.ws.rs.core.Response;
		
		public abstract class Action<T extends IDataContainer> implements IAction {
		
			protected T actionData;
			protected String actionName;
			private HttpMethod httpMethod;
		
			public Action(String actionName, HttpMethod httpMethod) {
				super();
				this.actionName = actionName;
				this.httpMethod = httpMethod;
			}
		
			public String getActionName() {
				return this.actionName;
			}
		
			public HttpMethod getHttpMethod() {
				return this.httpMethod;
			}
		
			public IDataContainer getActionData() {
				return this.actionData;
			}
		
			protected void throwUnauthorized() {
				throw new WebApplicationException(Response.Status.UNAUTHORIZED);
			}
		
			protected void throwBadRequest() {
				throw new WebApplicationException(Response.Status.BAD_REQUEST);
			}
		
			protected void throwBadRequest(String error) {
				throw new WebApplicationException(error, Response.Status.BAD_REQUEST);
			}
		
			protected void throwForbidden(String error) {
				throw new WebApplicationException(error, Response.Status.FORBIDDEN);
			}
			
			protected void throwServiceUnavailable(String error) {
				throw new WebApplicationException(error, Response.Status.SERVICE_UNAVAILABLE);
			}
		
			protected void throwInternalServerError(Exception x) {
				String message = x.getMessage();
				StackTraceElement[] stackTrace = x.getStackTrace();
				int i = 1;
				for (StackTraceElement stackTraceElement : stackTrace) {
					message += "\n" + stackTraceElement.toString();
					if (i > 3) {
						message += "\n" + (stackTrace.length - 4) + " more...";
						break;
					}
					i++;
				}
				throw new WebApplicationException(message, Response.Status.INTERNAL_SERVER_ERROR);
			}
		
			protected Object createReponse() {
				return this.actionData.getUuid();
			}

		}
	'''

	def generateHttpMethod() '''
		package com.anfelisa.ace;
		
		public enum HttpMethod {
			GET, POST, PUT, DELETE
		}
		
	'''
	
	def generateIAction() '''
		package com.anfelisa.ace;
		
		import javax.ws.rs.core.Response;
		
		public interface IAction {
		
			String getActionName();
			
			HttpMethod getHttpMethod();
			
			IDataContainer getActionData();
			
			void setActionData(IDataContainer data);
			
			ICommand getCommand();
			
		    Response apply();
		    
		    void initActionData();
		    
		}
		
	'''
	
	def generateAppRegistration(JAVA it) '''
		package «name»;
		
		import io.dropwizard.setup.Environment;
		import com.anfelisa.ace.CustomAppConfiguration;
		import com.anfelisa.ace.AceExecutionMode;
		import com.anfelisa.ace.IDaoProvider;
		import com.anfelisa.ace.ViewProvider;
		import com.anfelisa.ace.ServerConfiguration;
		import com.anfelisa.ace.E2E;
		
		import org.jdbi.v3.core.Jdbi;

		
		«IF aceOperations.size > 0»
			import «name».actions.*;
		«ENDIF»

		@SuppressWarnings("all")
		public class AppRegistration {
		
			public static void registerResources(Environment environment, Jdbi jdbi, CustomAppConfiguration appConfiguration, 
					IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
				«FOR aceOperation : aceOperations»
					environment.jersey().register(new «aceOperation.actionName»(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
				«ENDFOR»
			}
		
			public static void registerConsumers(ViewProvider viewProvider, String mode) {
				«FOR aceOperation : aceOperations»
					«registerConsumer(aceOperation, it)»
				«ENDFOR»
		    }
		}
		
		/*                    S.D.G.                    */
	'''
	
	private def dispatch registerConsumer(JAVA_ACE_WRITE it, JAVA java) '''
		«FOR outcome : outcomes»
			«FOR listener : outcome.listeners»
				«addConsumers(java, it, outcome, listener)»
			«ENDFOR»
		«ENDFOR»
	'''
	
	private def dispatch registerConsumer(JAVA_ACE_READ it, JAVA java) ''''''
	
	private def addConsumers(JAVA java, JAVA_ACE aceOperation, JAVA_Outcome outcome, JAVA_ViewFunction listener) '''
		viewProvider.addConsumer("«java.name».events.«aceOperation.eventName(outcome)»", (dataContainer, handle) -> {
			viewProvider.«listener.viewFunctionWithViewNameAsVariable»((«listener.model.dataNameWithPackage») dataContainer, handle);
		});
		
	'''

	def generateAceDataFactory(JAVA it) '''
		package «name».actions;
		
		import java.io.IOException;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import com.anfelisa.ace.IDataContainer;
		import com.anfelisa.ace.JodaObjectMapper;
		import «name».data.*;
		import com.fasterxml.jackson.databind.DeserializationFeature;		
		
		public class AceDataFactory {
			
			private static JodaObjectMapper mapper = new JodaObjectMapper();
			private static final Logger LOG = LoggerFactory.getLogger(AceDataFactory.class);
		
			static {
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			}
		
			public static IDataContainer createAceData(String className, String json) {
				try {
					«FOR ace : aceOperations»
						«ace.createData(it)»
					«ENDFOR»
				} catch (IOException e) {
					LOG.error("failed to create ace data {} with data {}", className, json, e);
				}
		
				return null;
			}
		}
		
	'''
	
	private def dispatch createData(JAVA_ACE_WRITE it, JAVA java) '''
		if (className.equals("«java.name».actions.«actionName»") ||
				className.equals("«java.name».commands.«commandName»") «IF outcomes.length > 0»||«ENDIF»
				«FOR outcome: outcomes SEPARATOR '||'»
					className.equals("«java.name».events.«eventName(outcome)»")
				«ENDFOR»
		) {
			«model.dataName» data = mapper.readValue(json, «model.dataName».class);
			data.migrateLegacyData(json);
			return data;
		}
	'''
	
	private def dispatch createData(JAVA_ACE_READ it, JAVA java) '''
		if (className.equals("«java.name».actions.«actionName»")) {
			«model.dataName» data = mapper.readValue(json, «model.dataName».class);
			data.migrateLegacyData(json);
			return data;
		}
	'''
	
}