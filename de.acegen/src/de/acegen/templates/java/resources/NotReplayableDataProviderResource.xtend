package de.acegen.templates.java.resources

import de.acegen.extensions.CommonExtension
import javax.inject.Inject

class NotReplayableDataProviderResource {

	@Inject
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
		
		import de.acegen.NotReplayableDataProvider;
		
		@Path("/test/not-replayable")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public class NotReplayableDataProviderResource {
		
			static final Logger LOG = LoggerFactory.getLogger(NotReplayableDataProviderResource.class);
		
			public NotReplayableDataProviderResource() {
				super();
			}
		
			@PUT
			@Path("/value")
			public Response putValue(@QueryParam("uuid") String uuid, @QueryParam("key") String key, String json) {
				NotReplayableDataProvider.put(uuid, key, json);
				return Response.ok().build();
			}
		
			@PUT
			@Path("/system-time")
			public Response putSystemTime(@QueryParam("uuid") String uuid, @QueryParam("system-time") String systemTime) {
				NotReplayableDataProvider.putSystemTime(uuid, LocalDateTime.parse(systemTime, DateTimeFormatter.ISO_DATE_TIME));
				return Response.ok().build();
			}
			
		}
		
		
		«sdg»
		
	'''

	
}