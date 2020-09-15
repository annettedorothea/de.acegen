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
import javax.inject.Inject

class StopE2ESessionResource {

	@Inject
	extension CommonExtension
	
	def generate() '''
		«copyright»
		
		package de.acegen.resources;
		
		import javax.ws.rs.Consumes;
		import javax.ws.rs.PUT;
		import javax.ws.rs.Path;
		import javax.ws.rs.Produces;
		import javax.ws.rs.core.MediaType;
		import javax.ws.rs.core.Response;
		import javax.ws.rs.WebApplicationException;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import de.acegen.Config;
		import de.acegen.CustomAppConfiguration;
		import de.acegen.E2E;

		@Path("/e2e")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public class StopE2ESessionResource {
		
			static final Logger LOG = LoggerFactory.getLogger(StopE2ESessionResource.class);
		
			private E2E e2e;
			private CustomAppConfiguration configuration;
			
			public StopE2ESessionResource(E2E e2e, CustomAppConfiguration configuration) {
				super();
				this.e2e = e2e;
				this.configuration = configuration;
			}
		
			@PUT
			@Path("/stop")
			public Response put() {
				if (Config.LIVE.equals(configuration.getConfig().getMode())) {
					throw new WebApplicationException("stop e2e session is not available in a live environment", Response.Status.FORBIDDEN);
				}
				e2e.reset();
				return Response.ok().build();
			}
		
		}
		
		
		«sdg»
		
	'''

	
}