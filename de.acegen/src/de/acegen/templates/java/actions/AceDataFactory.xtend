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


package de.acegen.templates.java.actions

import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerAceRead
import de.acegen.aceGen.HttpServerAceWrite
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.java.AceExtension
import de.acegen.extensions.java.ModelExtension
import javax.inject.Inject

class AceDataFactory {

	@Inject
	extension ModelExtension

	@Inject
	extension AceExtension

	@Inject
	extension CommonExtension
	
	def generateAceDataFactory(HttpServer it) '''
		«copyright»
		
		package «name».actions;
		
		import java.io.IOException;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import de.acegen.IDataContainer;
		import com.fasterxml.jackson.databind.ObjectMapper;
		import «name».data.*;
		import com.fasterxml.jackson.databind.DeserializationFeature;		
		
		public class AceDataFactory {
			
			private static ObjectMapper mapper = new ObjectMapper();
			private static final Logger LOG = LoggerFactory.getLogger(AceDataFactory.class);
		
			static {
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			}
		
			public static IDataContainer createAceData(String className, String json) {
				try {
					«FOR ace : aceOperations»
						«ace.createData(it)»
					«ENDFOR»
				} catch (IOException e) {
					LOG.error("failed to create ace data {} with data {}", className, json, e);
				}
		
				return null;
			}
		}
		
		«sdg»
		
	'''
	
	private def dispatch createData(HttpServerAceWrite it, HttpServer httpServer) '''
		if (className.equals("«httpServer.getName».actions.«actionName»") ||
				className.equals("«httpServer.getName».commands.«commandName»") «IF outcomes.length > 0»||«ENDIF»
				«FOR outcome: outcomes SEPARATOR '||'»
					className.equals("«httpServer.getName».events.«eventName(outcome)»")
				«ENDFOR»
		) {
			«getModel.dataName» data = mapper.readValue(json, «getModel.dataName».class);
			data.migrateLegacyData(json);
			return data;
		}
	'''
	
	private def dispatch createData(HttpServerAceRead it, HttpServer httpServer) '''
		if (className.equals("«httpServer.getName».actions.«actionName»")) {
			«getModel.dataName» data = mapper.readValue(json, «getModel.dataName».class);
			data.migrateLegacyData(json);
			return data;
		}
	'''

	
}