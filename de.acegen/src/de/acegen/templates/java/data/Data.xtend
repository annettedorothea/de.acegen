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


package de.acegen.templates.java.data

import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerAce
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.java.AttributeExtension
import de.acegen.extensions.java.TypeExtension

class Data {

	extension AttributeExtension
	
	extension CommonExtension
	
	extension TypeExtension

	def generateResponseData(HttpServerAce it, HttpServer httpServer) '''
		«copyright»
		
		package «httpServer.dataPackageName»;
		
		public class «responseDataName» {
			
			«FOR attribute : response»
				«attribute.declaration»
				
			«ENDFOR»
			public «responseDataName»() {
			}
			
			public «responseDataName»(«model.modelClassNameWithPackage» model) {
				«FOR attribute : response»
					«attribute.propertyName» = model.«attribute.getterName»();
				«ENDFOR»
			}
			
			«FOR attribute : response»
				«attribute.getter»
				
			«ENDFOR»
			
			
		}
		
		«sdg»
		
	'''
	
	
	def generatePayloadData(HttpServerAce it, HttpServer httpServer) '''
		«copyright»
		
		package «httpServer.dataPackageName»;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		import com.fasterxml.jackson.databind.annotation.JsonSerialize;
		import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
		
		import de.acegen.DateTimeToStringConverter;
		import de.acegen.StringToDateTimeConverter;
		
		@SuppressWarnings("unused")
		public class «payloadDataName» {
			
			«FOR attributeRef : payload»
				«attributeRef.attribute.declaration»
				
			«ENDFOR»
			public «payloadDataName»() {
			}
			
			
			«FOR attributeRef : payload»
				«attributeRef.attribute.jsonProperty»
				«attributeRef.attribute.getter»
				
			«ENDFOR»
		}
		
		«sdg»
		
	'''
	
	def generateAbstractData() '''
		«copyright»
		
		package de.acegen;
		
		import java.time.LocalDateTime;
		import java.util.List;
		import java.util.ArrayList;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
		import com.fasterxml.jackson.databind.annotation.JsonSerialize;
		
		public class Data<T extends AbstractModel> {
		
			private String uuid;
			
			private List<String> outcomes;
			
			private LocalDateTime systemTime;
			
			protected Boolean frozen = false;
			private Boolean systemTimeFrozen = false;
			
			private T model;
			
			public Data( String uuid ) {
				this.uuid = uuid;
				outcomes = new ArrayList<String>();
			}
		
			@JsonProperty
			public String getUuid() {
				return this.uuid;
			}
		
			@JsonProperty
			public void setUuid(String uuid) {
				this.uuid = uuid;
			}
		
			@JsonProperty
			@JsonSerialize(converter = DateTimeToStringConverter.class)
			@JsonDeserialize(converter = StringToDateTimeConverter.class)
			public LocalDateTime getSystemTime() {
				return systemTime;
			}
		
			@JsonProperty
			public void setSystemTime(LocalDateTime systemTime) {
				if (systemTimeFrozen) {
					throw new RuntimeException("system time is frozen");
				}
				this.systemTime = systemTime;
			}
		
			@JsonProperty
			public List<String> getOutcomes() {
				return this.outcomes;
			}
			
			public boolean hasOutcome(String outcome) {
				return outcomes.contains(outcome);
			}
		
			@JsonProperty
			public void addOutcome(String outcome) {
				this.outcomes.add(outcome);
			}
			
			public void freeze() {
				this.frozen = true;
				model.freeze();
			}
			
			public void freezeSystemTime() {
				this.systemTimeFrozen = true;
			}
			
			@JsonProperty
			public T getModel() {
				return model;
			}
			
			@JsonProperty
			public void setModel(T model) {
				if (frozen) {
					throw new RuntimeException(model.getClass() + " is frozen");
				}
				this.model = model;
			}
			
		}
		
		«sdg»
		
	'''
	
	
}