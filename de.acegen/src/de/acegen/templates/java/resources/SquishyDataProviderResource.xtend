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

import de.acegen.extensions.CommonExtension

class SquishyDataProviderResource {

	extension CommonExtension
	
	def generate() '''
		«copyright»
		
		package de.acegen.resources;
		
		import javax.ws.rs.Consumes;
		import javax.ws.rs.PUT;
		import javax.ws.rs.Path;
		import javax.ws.rs.Produces;
		import javax.ws.rs.QueryParam;
		import javax.ws.rs.core.MediaType;
		import javax.ws.rs.core.Response;
		
		import java.time.LocalDateTime;
		import java.time.format.DateTimeFormatter;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import de.acegen.SquishyDataProvider;
		
		@Path("/test/squishy")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public class SquishyDataProviderResource {
		
			static final Logger LOG = LoggerFactory.getLogger(SquishyDataProviderResource.class);
		
			public SquishyDataProviderResource() {
				super();
			}
		
			@PUT
			@Path("/value")
			public Response putValue(@QueryParam("uuid") String uuid, @QueryParam("key") String key,  @QueryParam("value") String value) {
				SquishyDataProvider.put(uuid, key, value);
				return Response.ok().build();
			}
		
			@PUT
			@Path("/system-time")
			public Response putSystemTime(@QueryParam("uuid") String uuid, @QueryParam("system-time") String systemTime) {
				SquishyDataProvider.putSystemTime(uuid, LocalDateTime.parse(systemTime, DateTimeFormatter.ISO_DATE_TIME));
				return Response.ok().build();
			}
			
		}
		
		
		«sdg»
		
	'''

	
}