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

class StartE2ESessionResource {
	
	@Inject
	extension CommonExtension
	
	def generate() '''
		«copyright»
		
		package de.acegen.resources;
		
		import java.util.List;
		import java.time.LocalDateTime;
		
		import javax.validation.constraints.NotNull;
		import javax.ws.rs.Consumes;
		import javax.ws.rs.PUT;
		import javax.ws.rs.Path;
		import javax.ws.rs.Produces;
		import javax.ws.rs.WebApplicationException;
		import javax.ws.rs.core.MediaType;
		import javax.ws.rs.core.Response;
		
		import org.jdbi.v3.core.Jdbi;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import com.fasterxml.jackson.core.JsonProcessingException;
		
		import de.acegen.Config;
		import de.acegen.CustomAppConfiguration;
		import de.acegen.DaoProvider;
		import de.acegen.E2E;
		import de.acegen.IDaoProvider;
		import de.acegen.ITimelineItem;
		import de.acegen.PersistenceHandle;
		
		@Path("/e2e")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public class StartE2ESessionResource {
		
			static final Logger LOG = LoggerFactory.getLogger(StartE2ESessionResource.class);
		
			private Jdbi jdbi;			
			private CustomAppConfiguration configuration;
		
			private IDaoProvider daoProvider = new DaoProvider();
			
			private E2E e2e;
		
			public StartE2ESessionResource(Jdbi jdbi, IDaoProvider daoProvider, E2E e2e, CustomAppConfiguration configuration) {
				super();
				this.jdbi = jdbi;
				this.daoProvider = daoProvider;
				this.e2e = e2e;
				this.configuration = configuration;
			}
		
			@PUT
			@Path("/start")
			public Response put(@NotNull List<ITimelineItem> timeline) throws JsonProcessingException {
				if (Config.LIVE.equals(configuration.getConfig().getMode())) {
					throw new WebApplicationException("start e2e session is not available in a live environment", Response.Status.FORBIDDEN);
				}
				if (e2e.isSessionRunning() && e2e.getSessionStartedAt().plusMinutes(1).isAfter(LocalDateTime.now())) {
					throw new WebApplicationException("session is already running", Response.Status.SERVICE_UNAVAILABLE);
				}
				e2e.init(timeline);
				
				PersistenceHandle handle = new PersistenceHandle(jdbi.open());
				try {
					handle.getHandle().begin();
					
					daoProvider.getAceDao().truncateTimelineTable(handle);
		
					daoProvider.truncateAllViews(handle);
		
					handle.getHandle().commit();
		
					return Response.ok().build();
				} catch (Exception e) {
					handle.getHandle().rollback();
					throw new WebApplicationException(e);
				} finally {
					handle.getHandle().close();
				}
			}
		
		}
		
		«sdg»
		
	'''

	
}