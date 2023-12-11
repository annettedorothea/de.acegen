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


package de.acegen.templates.java.scenario

import de.acegen.extensions.CommonExtension

class YamlConfiguration {
	
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