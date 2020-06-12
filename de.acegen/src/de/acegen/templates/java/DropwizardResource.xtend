package de.acegen.templates.java

import de.acegen.extensions.CommonExtension
import javax.inject.Inject

class DropwizardResource {

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

	
}