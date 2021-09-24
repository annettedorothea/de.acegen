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


package de.acegen.templates.java.resources

import de.acegen.aceGen.AuthUser
import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerAce
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.java.AceExtension
import de.acegen.extensions.java.AttributeExtension
import de.acegen.extensions.java.ModelExtension
import javax.inject.Inject

class Resource {

	@Inject
	extension ModelExtension

	@Inject
	extension AceExtension

	@Inject
	extension AttributeExtension

	@Inject
	extension CommonExtension
	
	def generate(HttpServerAce it, HttpServer httpServer, AuthUser authUser) '''
		«copyright»
		
		package «httpServer.name».resources;
		
		import java.util.UUID;
		
		import javax.ws.rs.Consumes;
		import javax.ws.rs.Path;
		import javax.ws.rs.Produces;
		import javax.ws.rs.core.MediaType;
		import javax.ws.rs.core.Response;
		import javax.ws.rs.PathParam;
		import javax.ws.rs.QueryParam;
		
		import java.time.LocalDateTime;
		import java.time.format.DateTimeFormatter;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import org.apache.commons.lang3.StringUtils;
		
		import de.acegen.CustomAppConfiguration;
		import de.acegen.IDaoProvider;
		import de.acegen.IDataContainer;
		import de.acegen.ViewProvider;
		import de.acegen.PersistenceConnection;
		import de.acegen.PersistenceHandle;
		import de.acegen.ReadAction;
		import de.acegen.ITimelineItem;
		import de.acegen.SquishyDataProvider;
		import de.acegen.Config;
		
		«IF authorize && authUser !== null»
			import de.acegen.auth.«authUser.name.toFirstUpper»;
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

			public «resourceName»(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
						IDaoProvider daoProvider, ViewProvider viewProvider) {
					this.persistenceConnection = persistenceConnection;
					this.appConfiguration = appConfiguration;
					this.daoProvider = daoProvider;
					this.viewProvider = viewProvider;
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
					@QueryParam("uuid") String uuid«IF payload.size > 0», 
					«getModel.dataParamType» payload«ENDIF») 
					throws JsonProcessingException {
				«IF payload.size > 0»
					if (payload == null) {
						return badRequest("payload must not be null");
					}
				«ENDIF»
				if (StringUtils.isBlank(uuid)) {
					uuid = UUID.randomUUID().toString();
				}
				try {
					«getModel.dataInterfaceNameWithPackage» data = new «getModel.dataName»(uuid);
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
									data.«param.setterCall('''«authUser.name.toFirstLower».«getterCall(param)»''')»;
								«ENDIF»
						«ENDFOR»
					«ENDIF»
					
					«actionNameWithPackage» action = new «actionNameWithPackage»(persistenceConnection, appConfiguration, daoProvider, viewProvider);
					data = action.apply(data);
					«IF response.size > 0»
						return Response.ok(new «responseDataNameWithPackage»(data)).build();
					«ELSE»
						return ok();
					«ENDIF»
				} catch (IllegalArgumentException x) {
					LOG.error("bad request due to {} ", x.getMessage());
					if (Config.DEV.equals(appConfiguration.getConfig().getMode())) {
						x.printStackTrace();
					}
					return badRequest(x.getMessage());
				} catch (SecurityException x) {
					LOG.error("unauthorized due to {} ", x.getMessage());
					if (Config.DEV.equals(appConfiguration.getConfig().getMode())) {
						x.printStackTrace();
					}
					return unauthorized("authorization needed for «getUrl»");
				} catch (Exception x) {
					LOG.error("internal server error due to {} ", x.getMessage());
					if (Config.DEV.equals(appConfiguration.getConfig().getMode())) {
						x.printStackTrace();
					}
					return internalServerError(x);
				}
			}
		}
		
		
		«sdg»
	'''
	
}