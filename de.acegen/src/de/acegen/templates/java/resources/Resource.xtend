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

import de.acegen.aceGen.AttributeParamRef
import de.acegen.aceGen.AuthUser
import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerAce
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.java.AttributeExtension
import de.acegen.extensions.java.EcoreExtension
import de.acegen.extensions.java.TypeExtension
import javax.inject.Inject

class Resource {

	@Inject
	extension EcoreExtension

	@Inject
	extension AttributeExtension

	@Inject
	extension TypeExtension

	@Inject
	extension CommonExtension
	
	def generate(HttpServerAce it, HttpServer httpServer, AuthUser authUser) '''
		«copyright»
		
		package «httpServer.resourcePackageName»;
		
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

		«IF isMulitpartFormData»
			import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
			import org.glassfish.jersey.media.multipart.FormDataParam;
			import java.io.InputStream;
		«ENDIF»
		
		import de.acegen.CustomAppConfiguration;
		import de.acegen.IDaoProvider;
		import de.acegen.ViewProvider;
		import de.acegen.PersistenceConnection;
		import de.acegen.Config;
		import de.acegen.Data;
		
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
			«IF isMulitpartFormData»
				@Consumes(MediaType.MULTIPART_FORM_DATA)
			«ELSE»
				@Consumes(MediaType.APPLICATION_JSON)
			«ENDIF»
			public Response «resourceName.toFirstLower»(
					«IF isAuthorize && authUser !== null»@Auth «authUser.name.toFirstUpper» «authUser.name.toFirstLower», «ENDIF»
					«FOR param : queryParams»
						@QueryParam("«param.attribute.propertyName»") String «param.attribute.propertyName», 
					«ENDFOR»
					«FOR param : pathParams»
						@PathParam("«param.attribute.propertyName»") String «param.attribute.propertyName», 
					«ENDFOR»
					«IF isMulitpartFormData»
						@FormDataParam("«model.formDataAttributeName»")FormDataContentDisposition contentDisposition,
						@FormDataParam("«model.formDataAttributeName»")InputStream inputStream,
					«ENDIF»
					@QueryParam("uuid") String uuid«IF payload.size > 0», 
					«payloadDataNameWithPackage» payload«ENDIF») 
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
					«model.dataWithGenericModel» data = new «model.dataWithGenericModel»(uuid);
					«model.modelClassNameWithPackage» model = new «model.modelClassNameWithPackage»();
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
						«FOR param : model.allAttributes»
								«IF authUser.attributes.containsAttribute(param)»
									model.«param.setterName»(«authUser.name.toFirstLower».«param.getterName»());
								«ENDIF»
						«ENDFOR»
					«ENDIF»
					«IF isMulitpartFormData»
						«FOR param : model.allAttributes»
								«IF param.type == "FormData"»
									model.«param.setterName»(new de.acegen.FormData(contentDisposition, inputStream));
								«ENDIF»
						«ENDFOR»
					«ENDIF»
					
					data.setModel(model);
					«actionNameWithPackage» action = new «actionNameWithPackage»(persistenceConnection, appConfiguration, daoProvider, viewProvider);
					data = action.apply(data);
					«IF response.size > 0»
						return Response.ok(new «responseDataNameWithPackage»(data.getModel())).build();
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
	
	private def String initActionDataFromPayload(AttributeParamRef it) '''
		«IF notNull»
			«IF "String".equals(attribute.type) && !attribute.list»
				if (StringUtils.isBlank(payload.«attribute.getterName»()) || "null".equals(payload.«attribute.getterName»())) {
					return badRequest("«attribute.propertyName» is mandatory");
				}
			«ELSE»
				if (payload.«attribute.getterName»() == null) {
					return badRequest("«attribute.propertyName» is mandatory");
				}
			«ENDIF»
		«ENDIF»
		model.«attribute.setterName»(payload.«attribute.getterName»());
	'''
	
	private def String initActionData(AttributeParamRef it) '''
		«IF attribute.type !== null && attribute.type.equals('DateTime') && !attribute.list»
			«IF notNull»
				if (StringUtils.isBlank(«attribute.propertyName») || "null".equals(«attribute.propertyName»)) {
					return badRequest("«attribute.propertyName» is mandatory");
				}
			«ENDIF»
			if (StringUtils.isNotBlank(«attribute.propertyName»)) {
				try {
					model.«attribute.setterName»(«IF attribute.type !== null && attribute.type.equals('DateTime')»LocalDateTime.parse(«attribute.propertyName», DateTimeFormatter.ISO_DATE_TIME)«ELSE»«attribute.propertyName»«ENDIF»);
				} catch (Exception x) {
					LOG.warn("failed to parse dateTime «attribute.propertyName» - {}", «attribute.propertyName»);
				}
			}
		«ELSE»
			«IF notNull»
				if («attribute.name» == null || StringUtils.isBlank(«attribute.propertyName») || "null".equals(«attribute.propertyName»)) {
					return badRequest("«attribute.propertyName» is mandatory");
				}
			«ENDIF»
			«IF "Integer".equals(attribute.type)»
				if («attribute.propertyName» != null) {
					model.«attribute.setterName»("null".equals(«attribute.propertyName») ? null : «attribute.type».parseInt(«attribute.propertyName»));
				}
			«ELSEIF "String".equals(attribute.type)»
				if («attribute.propertyName» != null) {
					model.«attribute.setterName»(«attribute.propertyName»);
				}
			«ELSE»
				if («attribute.propertyName» != null) {
					model.«attribute.setterName»("null".equals(«attribute.propertyName») ? null : «attribute.type».parse«attribute.type.toFirstUpper»(«attribute.propertyName»));
				}
			«ENDIF»
		«ENDIF»
	'''
	
	
	
}