package de.acegen.templates.java.resources

import de.acegen.extensions.CommonExtension
import javax.inject.Inject

class GetServerInfoResource {

	@Inject
	extension CommonExtension

	def generate() '''
		«copyright»
		
		package de.acegen.resources;
		
		import javax.ws.rs.Consumes;
		import javax.ws.rs.GET;
		import javax.ws.rs.Path;
		import javax.ws.rs.Produces;
		import javax.ws.rs.core.MediaType;
		import javax.ws.rs.core.Response;
		
		import de.acegen.App;
		import de.acegen.ServerInfo;
		
		@Path("/server")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public class GetServerInfoResource {
		
			public GetServerInfoResource() {
				super();
			}
		
			@GET
			@Path("/info")
			public Response put() {
				return Response.ok(new ServerInfo(App.getVersion())).build();
			}
		
		}
		
		«sdg»
		
	'''

	
}