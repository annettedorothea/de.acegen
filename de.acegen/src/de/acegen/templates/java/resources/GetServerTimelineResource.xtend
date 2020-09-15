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

class GetServerTimelineResource {

	@Inject
	extension CommonExtension

	def generate() '''
		«copyright»

		package de.acegen.resources;
		
		import java.util.List;
		
		import javax.ws.rs.Consumes;
		import javax.ws.rs.GET;
		import javax.ws.rs.Path;
		import javax.ws.rs.Produces;
		import javax.ws.rs.WebApplicationException;
		import javax.ws.rs.core.MediaType;
		import javax.ws.rs.core.Response;
		
		import org.jdbi.v3.core.Jdbi;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import de.acegen.AceDao;
		import de.acegen.Config;
		import de.acegen.CustomAppConfiguration;
		import de.acegen.ITimelineItem;
		import de.acegen.PersistenceHandle;
		
		@Path("/e2e")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public class GetServerTimelineResource {
		
			private Jdbi jdbi;
			private CustomAppConfiguration configuration;
		
			static final Logger LOG = LoggerFactory.getLogger(GetServerTimelineResource.class);
		
			private AceDao aceDao = new AceDao();
		
			public GetServerTimelineResource(Jdbi jdbi, CustomAppConfiguration configuration) {
				super();
				this.jdbi = jdbi;
				this.configuration = configuration;
			}
		
			@GET
			@Path("/timeline")
			public Response get() {
				if (Config.LIVE.equals(configuration.getConfig().getMode())) {
					throw new WebApplicationException("get server timeline is not available in a live environment", Response.Status.FORBIDDEN);
				}
				PersistenceHandle timelineHandle = new PersistenceHandle(jdbi.open());
				
				try {
					List<ITimelineItem> serverTimeline = aceDao.selectTimeline(timelineHandle);
					return Response.ok(serverTimeline).build();
				} catch (Exception e) {
					throw new WebApplicationException(e);
				} finally {
					timelineHandle.getHandle().close();
				}
			}
		
		}
		
		«sdg»
		
	'''

	
}