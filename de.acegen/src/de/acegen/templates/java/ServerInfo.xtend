package de.acegen.templates.java

import de.acegen.extensions.CommonExtension
import javax.inject.Inject

class ServerInfo {

	@Inject
	extension CommonExtension

	def generate() '''
		«copyright»
		
		package de.acegen;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		
		public class ServerInfo {
		
			private String serverVersion;
			
			public ServerInfo(String serverVersion) {
				super();
				this.serverVersion = serverVersion;
			}
		
			@JsonProperty
			public String getServerVersion() {
				return serverVersion;
			}
			
		}
		
		«sdg»
		
	'''

	
}