package de.acegen.templates.java

import de.acegen.aceGen.AuthUser
import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerAce
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.java.AceExtension
import de.acegen.extensions.java.AttributeExtension
import de.acegen.extensions.java.ModelExtension
import javax.inject.Inject

class ResourceTemplate {
	
	@Inject
	extension ModelExtension

	@Inject
	extension AceExtension

	@Inject
	extension AttributeExtension

	@Inject
	extension CommonExtension
	
	def generateDropwizardResource() '''
		«copyright»
		
		
		package de.acegen;
		
		import javax.ws.rs.core.Response;
		
		public abstract class Resource {
			

			protected Response ok() {
				return Response.status(Response.Status.OK).build();
			}
			
			protected Response badRequest(String message) {
				return Response.status(Response.Status.BAD_REQUEST).entity(message).build();
			}
			
			protected Response unauthorized() {
				return Response.status(Response.Status.UNAUTHORIZED).build();
			}
			
			protected Response internalServerError(Exception x) {
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
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(message).build();
			}
		}
		
		«sdg»
	'''
	
	def generateResourceFile(HttpServerAce it, HttpServer java, AuthUser authUser) '''
		«copyright»
		
		package «java.getName».resources;
		
		import javax.ws.rs.Consumes;
		import javax.ws.rs.Path;
		import javax.ws.rs.Produces;
		import javax.ws.rs.core.MediaType;
		import javax.ws.rs.core.Response;
		import javax.ws.rs.PathParam;
		import javax.ws.rs.QueryParam;
		
		import org.joda.time.DateTime;
		import org.joda.time.DateTimeZone;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import org.apache.commons.lang3.StringUtils;
		
		import de.acegen.CustomAppConfiguration;
		import de.acegen.E2E;
		import de.acegen.IDaoProvider;
		import de.acegen.IDataContainer;
		import de.acegen.ViewProvider;
		import de.acegen.PersistenceConnection;
		import de.acegen.PersistenceHandle;
		import de.acegen.ReadAction;
		import de.acegen.ITimelineItem;
		import de.acegen.NotReplayableDataProvider;
		
		«IF authorize»
			import de.acegen.auth.AuthUser;
			import io.dropwizard.auth.Auth;
		«ENDIF»

		import com.codahale.metrics.annotation.Timed;
		import com.codahale.metrics.annotation.Metered;
		import com.codahale.metrics.annotation.ExceptionMetered;
		import com.codahale.metrics.annotation.ResponseMetered;

		import com.fasterxml.jackson.core.JsonProcessingException;
		
		import javax.ws.rs.GET;
		import javax.ws.rs.POST;
		import javax.ws.rs.PUT;
		import javax.ws.rs.DELETE;
		
		«getModel.dataImport»
		«getModel.dataClassImport»
		
		import de.acegen.Resource;
		
		@Path("«getUrl»")
		@SuppressWarnings("unused")
		public class «resourceName» extends Resource {
		
			static final Logger LOG = LoggerFactory.getLogger(«resourceName».class);
			
			private PersistenceConnection persistenceConnection;
			private CustomAppConfiguration appConfiguration;
			private IDaoProvider daoProvider;
			private ViewProvider viewProvider;
			private E2E e2e;

		public «resourceName»(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
					IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
				this.persistenceConnection = persistenceConnection;
				this.appConfiguration = appConfiguration;
				this.daoProvider = daoProvider;
				this.viewProvider = viewProvider;
				this.e2e = e2e;
			}
		
		«IF getType !== null»@«getType»«ENDIF»
		@Timed(name = "«actionName»Timed")
		@Metered(name = "«actionName»Metered")
		@ExceptionMetered
		@ResponseMetered
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public Response «resourceName.toFirstLower»(
				«IF isAuthorize && authUser !== null»@Auth «authUser.name.toFirstUpper» «authUser.name.toFirstLower», «ENDIF»
				«FOR param : queryParams»
					@QueryParam("«param.attribute.name»") «param.attribute.resourceParamType» «param.attribute.name», 
				«ENDFOR»
				«FOR param : pathParams»
					@PathParam("«param.attribute.name»") «param.attribute.resourceParamType» «param.attribute.name», 
				«ENDFOR»
				«IF payload.size > 0»«getModel.dataParamType» payload)
				«ELSE»@QueryParam("uuid") String uuid)«ENDIF» 
				throws JsonProcessingException {
			«IF payload.size > 0»
				if (payload == null) {
					return badRequest("payload must not be null");
				}
			«ELSE»
				if (StringUtils.isBlank(uuid)) {
					return badRequest("uuid must not be blank or null");
				}
			«ENDIF»
			«getModel.dataInterfaceNameWithPackage» actionData = new «getModel.dataName»(«IF payload.size > 0»payload.getUuid()«ELSE»uuid«ENDIF»);
			«FOR paramRef : queryParams»
				«paramRef.initActionData»
			«ENDFOR»
			«FOR paramRef : pathParams»
				«paramRef.initActionData»
			«ENDFOR»
			«FOR attributeRef : payload»
				«attributeRef.initActionDataFromPayload»
			«ENDFOR»
			«IF isAuthorize && authUser !== null»
				«FOR param : getModel.allAttributes»
						«IF authUser.attributes.containsAttribute(param)»
							actionData.«param.setterCall('''«authUser.name.toFirstLower».«getterCall(param)»''')»;
						«ENDIF»
				«ENDFOR»
			«ENDIF»
			
			«actionNameWithPackage» action = new «actionNameWithPackage»(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e);
			action.setActionData(actionData);
			try {
				action.apply();
				«IF response.size > 0»
					return Response.ok(new «responseDataNameWithPackage(java)»(action.getActionData())).build();
				«ELSE»
					return ok();
				«ENDIF»
			} catch (IllegalArgumentException x) {
				LOG.error("bad request due to {} ", x.getMessage());
				return badRequest(x.getMessage());
			} catch (SecurityException x) {
				LOG.error("unauthorized due to {} ", x.getMessage());
				return unauthorized();
			} catch (Exception x) {
				LOG.error("internal server error due to {} ", x.getMessage());
				return internalServerError(x);
			}
		}

	}
	
	
	«sdg»
		
	'''
}