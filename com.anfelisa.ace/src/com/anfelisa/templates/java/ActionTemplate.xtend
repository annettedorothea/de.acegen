package com.anfelisa.templates.java

import com.anfelisa.ace.AuthUser
import com.anfelisa.ace.JAVA
import com.anfelisa.ace.JAVA_ACE
import com.anfelisa.ace.JAVA_Outcome
import com.anfelisa.ace.JAVA_View
import com.anfelisa.ace.JAVA_ViewFunction
import com.anfelisa.extensions.java.AceExtension
import com.anfelisa.extensions.java.AttributeExtension
import com.anfelisa.extensions.java.DataExtension
import com.anfelisa.extensions.java.JavaExtension
import com.anfelisa.extensions.java.PrimitiveAttributeExtension
import com.anfelisa.extensions.java.ViewExtension
import javax.inject.Inject

class ActionTemplate {

	@Inject
	extension JavaExtension

	@Inject
	extension AceExtension

	@Inject
	extension ViewExtension

	@Inject
	extension DataExtension

	@Inject
	extension PrimitiveAttributeExtension

	@Inject
	extension AttributeExtension

	def generateAbstractActionFile(JAVA_ACE it, JAVA java, AuthUser authUser) '''
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
		import com.anfelisa.ace.DatabaseHandle;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import com.codahale.metrics.annotation.Timed;
		import com.fasterxml.jackson.core.JsonProcessingException;
		import org.jdbi.v3.core.Jdbi;
		import org.jdbi.v3.core.Jdbi;
		
		import javax.ws.rs.WebApplicationException;
		
		import com.anfelisa.ace.Action;
		import com.anfelisa.ace.HttpMethod;
		import com.anfelisa.ace.ICommand;
		import org.joda.time.DateTime;
		import org.joda.time.DateTimeZone;
		
		«IF authorize && authUser !== null»import com.anfelisa.auth.«authUser.name.toFirstUpper»;«ENDIF»
		
		«data.dataImport»
		
		«IF outcomes.size > 0»
			import «commandNameWithPackage(java)»;
		«ENDIF»
		
		@SuppressWarnings("unused")
		@Path("«url»")
		public abstract class «abstractActionName» extends Action<«data.dataParamType»> {
		
			public «abstractActionName»(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
				super("«actionNameWithPackage(java)»", HttpMethod.«type», jdbi, appConfiguration, daoProvider, viewProvider);
			}
		
			@Override
			public ICommand getCommand() {
				«IF outcomes.size > 0»
					return new «commandName»(this.actionData, databaseHandle, daoProvider, viewProvider);
				«ELSE»
					return null;
				«ENDIF»
			}
		
			«IF !type.equals("GET")»
				protected final void loadDataForGetRequest() {
				}
			«ENDIF»
		
			public void initActionData(String json) {
				try {
					this.actionData = mapper.readValue(json, «data.dataParamType».class);
				} catch (Exception e) {
					throw new WebApplicationException(e);
				}
			}
		
			«IF type !== null»@«type»«ENDIF»
			@Timed
			«IF type !== null && type == "GET"»@Produces(MediaType.APPLICATION_JSON)«ELSE»@Produces(MediaType.TEXT_PLAIN)«ENDIF»
			@Consumes(MediaType.APPLICATION_JSON)
			public Response «resourceName.toFirstLower»(
					«IF authorize && authUser !== null»@Auth «authUser.name.toFirstUpper» «authUser.name.toFirstLower», «ENDIF»
					«FOR param : queryParams»
						@QueryParam("«param.name»") «param.resourceParamType» «param.name», 
					«ENDFOR»
					«FOR param : pathParams»
						@PathParam("«param.name»") «param.resourceParamType» «param.name», 
					«ENDFOR»
					«IF payload !== null»@NotNull «data.dataParamType» payload)
					«ELSE»@NotNull @QueryParam("uuid") String uuid)«ENDIF» 
					throws JsonProcessingException {
				this.actionData = new «data.dataParamType»(«IF payload !== null»payload.getUuid()«ELSE»uuid«ENDIF»);
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
					«FOR param : data.allAttributes»
						«IF authUser.attributes.containsAttribute(param)»this.actionData.«param.setterCall('''«authUser.name.toFirstLower».«getterCall(param)»''')»;«ENDIF»
					«ENDFOR»
				«ENDIF»
				return this.apply();
			}
		}
		
		/*       S.D.G.       */
	'''

	def generateInitialActionFile(JAVA_ACE it, JAVA java) '''
		package «java.name».actions;
		
		import com.anfelisa.ace.CustomAppConfiguration;
		import com.anfelisa.ace.ViewProvider;
		import com.anfelisa.ace.IDaoProvider;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import org.jdbi.v3.core.Jdbi;
		
		public class «actionName» extends «abstractActionName» {
		
			static final Logger LOG = LoggerFactory.getLogger(«actionName».class);
		
			public «actionName»(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
				super(jdbi,appConfiguration, daoProvider, viewProvider);
			}
		
		
			«IF type.equals("GET")»
				protected final void loadDataForGetRequest() {
				}
			«ENDIF»
		
		}
		
		/*       S.D.G.       */
	'''

	def generateAction() '''
		package com.anfelisa.ace;
		
		import java.lang.reflect.Constructor;
		
		import javax.ws.rs.WebApplicationException;
		import javax.ws.rs.core.Response;
		
		import org.joda.time.DateTime;
		import org.jdbi.v3.core.Jdbi;
		
		import org.jdbi.v3.core.Handle;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		public abstract class Action<T extends IDataContainer> implements IAction {
		
			static final Logger LOG = LoggerFactory.getLogger(Action.class);
		
			protected T actionData;
			private String actionName;
			private HttpMethod httpMethod;
			protected DatabaseHandle databaseHandle;
			private Jdbi jdbi;
			protected JodaObjectMapper mapper;
			protected CustomAppConfiguration appConfiguration;
			protected IDaoProvider daoProvider;
			protected ViewProvider viewProvider;
		
			public Action(String actionName, HttpMethod httpMethod, Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
				super();
				this.actionName = actionName;
				this.httpMethod = httpMethod;
				this.jdbi = jdbi;
				mapper = new JodaObjectMapper();
				this.appConfiguration = appConfiguration;
				this.daoProvider = daoProvider;
				this.viewProvider = viewProvider;
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
		
			protected abstract void loadDataForGetRequest();
		
			public Response apply() {
				databaseHandle = new DatabaseHandle(jdbi.open(), jdbi.open());
				databaseHandle.beginTransaction();
				try {
					if (!ServerConfiguration.REPLAY.equals(appConfiguration.getServerConfiguration().getMode())) {
						this.actionData.setSystemTime(new DateTime());
					} else {
						ITimelineItem timelineItem = E2E.selectAction(this.actionData.getUuid());
						if (timelineItem != null) {
							Class<?> cl = Class.forName(timelineItem.getName());
							Constructor<?> con = cl.getConstructor(Jdbi.class, CustomAppConfiguration.class, IDaoProvider.class, ViewProvider.class);
							IAction action = (IAction) con.newInstance(jdbi, appConfiguration, daoProvider, viewProvider);
							action.initActionData(timelineItem.getData());
							this.actionData.setSystemTime(action.getActionData().getSystemTime());
						} else {
							this.actionData.setSystemTime(new DateTime());
						}
					}
					daoProvider.addActionToTimeline(this);
					if (httpMethod != HttpMethod.GET) {
						ICommand command = this.getCommand();
						if (command != null) {
							command.execute();
						} else {
							throw new WebApplicationException(actionName + " returns no command");
						}
					} else {
						this.loadDataForGetRequest();
					}
					databaseHandle.commitTransaction();
					if (httpMethod == HttpMethod.GET) {
						return Response.ok(this.getActionData().toPresentationalData()).build();
					} else if (httpMethod == HttpMethod.POST) {
						return Response.ok(this.getActionData().getUuid()).build();
					} else {
						return Response.ok().build();
					}
				} catch (WebApplicationException x) {
					daoProvider.addExceptionToTimeline(this.actionData.getUuid(), x, databaseHandle);
					databaseHandle.rollbackTransaction();
					LOG.error(actionName + " failed " + x.getMessage());
					x.printStackTrace();
					App.reportException(x);
					return Response.status(x.getResponse().getStatusInfo()).entity(x.getMessage()).build();
				} catch (Exception x) {
					daoProvider.addExceptionToTimeline(this.actionData.getUuid(), x, databaseHandle);
					databaseHandle.rollbackTransaction();
					LOG.error(actionName + " failed " + x.getMessage());
					x.printStackTrace();
					App.reportException(x);
					return Response.status(500).entity(x.getMessage()).build();
				} finally {
					databaseHandle.close();
				}
			}
		
			public DatabaseHandle getDatabaseHandle() {
				return databaseHandle;
			}
		
			public void setDatabaseHandle(DatabaseHandle databaseHandle) {
				this.databaseHandle = databaseHandle;
			}
		
			protected Handle getHandle() {
				if (databaseHandle != null) {
					return databaseHandle.getHandle();
				} else {
					throw new RuntimeException("no database handle");
				}
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
			
			ICommand getCommand();
			
		    DatabaseHandle getDatabaseHandle();
			
		    void setDatabaseHandle(DatabaseHandle databaseHandle);
		
		    Response apply();
			
			void initActionData(String json);
			
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
		
		import org.jdbi.v3.core.Jdbi;

		
		«FOR view : referencedViews()»
			import «view.viewNameWithPackage»;
    	«ENDFOR»
		«IF aceOperations.size > 0»
			import «name».actions.*;
		«ENDIF»

		@SuppressWarnings("all")
		public class AppRegistration {
		
			public void registerResources(Environment environment, Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
				«FOR aceOperation : aceOperations»
					environment.jersey().register(new «aceOperation.actionName»(jdbi, appConfiguration, daoProvider, viewProvider));
				«ENDFOR»
			}
		
			public void registerConsumers(ViewProvider viewProvider, String mode) {
				«FOR aceOperation : aceOperations»
					«FOR outcome : aceOperation.outcomes»
						«FOR listener : outcome.listeners»
							«IF (listener.eContainer as JAVA_View).isExternal»if (ServerConfiguration.LIVE.equals(mode) || ServerConfiguration.DEV.equals(mode)) {
								«addConsumers(it, aceOperation, outcome, listener)»
							}
							«ELSE»
							«addConsumers(it, aceOperation, outcome, listener)»
							«ENDIF»
							«ENDFOR»
					«ENDFOR»
				«ENDFOR»
		    }
		}
		
		/*                    S.D.G.                    */
	'''
	
	private def addConsumers(JAVA java, JAVA_ACE aceOperation, JAVA_Outcome outcome, JAVA_ViewFunction listener) '''
		viewProvider.addConsumer("«java.name».events.«aceOperation.eventName(outcome)»", viewProvider.«listener.viewFunctionWithViewNameAsVariable»);
	'''
	
}