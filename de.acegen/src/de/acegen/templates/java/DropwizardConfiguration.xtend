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


package de.acegen.templates.java

import de.acegen.extensions.CommonExtension

class DropwizardConfiguration {

	extension CommonExtension

	def generateCustomAppConfiguration() '''
		«copyright»
		
		package de.acegen;
		
		public class CustomAppConfiguration extends AppConfiguration {
		
		}
		
		«sdg»
		
	'''

	
	def generateAppConfiguration() '''
		«copyright»
		
		package de.acegen;
		
		import javax.validation.Valid;
		import javax.validation.constraints.NotNull;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		
		import io.dropwizard.Configuration;
		import io.dropwizard.db.DataSourceFactory;
		import io.dropwizard.server.DefaultServerFactory;
		import io.dropwizard.server.ServerFactory;
		
		public class AppConfiguration extends Configuration {
		
		    @Valid
		    @NotNull
		    private ServerFactory server = new DefaultServerFactory();
		
		    @JsonProperty("server")
		    public ServerFactory getServerFactory() {
		        return server;
		    }
		
		    @JsonProperty("server")
		    public void setServerFactory(ServerFactory factory) {
		        this.server = factory;
		    }
		
		    @Valid
			@NotNull
			private DataSourceFactory database = new DataSourceFactory();
		
			@JsonProperty("database")
			public DataSourceFactory getDataSourceFactory() {
				return database;
			}
		
			@JsonProperty("database")
			public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {
				this.database = dataSourceFactory;
			}
		
			@Valid
			@NotNull
			private Config config = new Config();
		
			@JsonProperty("config")
			public Config getConfig() {
				return config;
			}
		
			@JsonProperty("config")
			public void setConfig(Config config) {
				this.config = config;
			}
			
		}
		
		«sdg»
		
	'''

	def generateConfig() '''
		«copyright»
		
		package de.acegen;
		
		import com.fasterxml.jackson.annotation.JsonProperty;

		public class Config {
			public static final String LIVE = "LIVE";
			public static final String DEV = "DEV";
		
			public static final String ALWAYS = "ALWAYS";
			public static final String ON_ERROR = "ON_ERROR";
			public static final String NEVER = "NEVER";
			
			private String mode = DEV;
			
			private String writeTimeline = ON_ERROR;
		
			@JsonProperty("mode")
			public String getMode() {
				return mode;
			}
		
			@JsonProperty("mode")
			public void setMode(String mode) {
				this.mode = mode;
			}
		
			@JsonProperty("writeTimeline")
			public String getWriteTimeline() {
				return writeTimeline;
			}
		
			@JsonProperty("writeTimeline")
			public void setWriteTimeline(String writeTimeline) {
				this.writeTimeline = writeTimeline;
			}
			
			public boolean writeTimeline() {
				return !NEVER.equals(writeTimeline);
			}
			
			public boolean writeError() {
				return ON_ERROR.equals(writeTimeline) || ALWAYS.equals(writeTimeline);
			}
	
		}
		
		«sdg»
		
	'''

	
}