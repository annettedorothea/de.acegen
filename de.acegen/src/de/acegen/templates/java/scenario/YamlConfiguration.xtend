package de.acegen.templates.java.scenario

import de.acegen.extensions.CommonExtension
import javax.inject.Inject

class YamlConfiguration {
	
	@Inject
	extension CommonExtension
	
	def generateYamlConfiguration() '''
		«copyright»
		
		package de.acegen;
		
		public class YamlConfiguration {
			
			private Database database;
			
			private Server server;
		
			private Config config;
		
			public Database getDatabase() {
				return database;
			}
		
			public void setDatabase(Database database) {
				this.database = database;
			}
		
			public Server getServer() {
				return server;
			}
		
			public void setServer(Server server) {
				this.server = server;
			}
			
			public Config getConfig() {
				return config;
			}
			
			public void setConfig(Config config) {
				this.config = config;
			}
			
			
		}
		
		«sdg»

	'''
	
	def generateDatabase() '''
		«copyright»
		
		package de.acegen;
		
		public class Database {
		
			private String url;
		
			public String getUrl() {
				return url;
			}
		
			public void setUrl(String url) {
				this.url = url;
			}
		
		}

		
		«sdg»

	'''
	
	def generateServer() '''
		«copyright»
		
		package de.acegen;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		
		public class Server {
		
			private String rootPath;
		
			private Connectors[] applicationConnectors;
		
			@JsonProperty("rootPath")
			public String getRootPath() {
				return rootPath;
			}
		
			@JsonProperty("rootPath")
			public void setRootPath(String rootPath) {
				this.rootPath = rootPath;
			}
		
			@JsonProperty("applicationConnectors")
			public Connectors[] getApplicationConnectors() {
				return applicationConnectors;
			}
		
			@JsonProperty("applicationConnectors")
			public void setApplicationConnectors(Connectors[] applicationConnectors) {
				this.applicationConnectors = applicationConnectors;
			}
			
			
		
		}
		
		
		«sdg»

	'''
	
	def generateConnectors() '''
		«copyright»
		
		package de.acegen;
		
		public class Connectors {
		
			private String type;
			private String port;
			
			public String getType() {
				return type;
			}
			public void setType(String type) {
				this.type = type;
			}
			public String getPort() {
				return port;
			}
			public void setPort(String port) {
				this.port = port;
			}
			
			
		
		}
		
		
		«sdg»

	'''
	
	
}