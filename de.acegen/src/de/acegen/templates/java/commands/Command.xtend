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


package de.acegen.templates.java.commands

import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerAceWrite
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.java.TypeExtension
import javax.inject.Inject

class Command {

	@Inject
	extension CommonExtension
	
	@Inject
	extension TypeExtension
	
	def generateAbstractCommandFile(HttpServerAceWrite it, HttpServer java) '''
		«copyright»
		
		package «java.commandPackage»;
		
		import de.acegen.Data;
		import de.acegen.Command;
		import de.acegen.CustomAppConfiguration;
		import de.acegen.IDaoProvider;
		import de.acegen.ViewProvider;
		import de.acegen.PersistenceHandle;
		import de.acegen.Event;
		
		import «model.modelClassNameWithPackage»;
		
		@SuppressWarnings("unused")
		public abstract class «abstractCommandName» extends Command<«model.modelClassNameWithPackage»> {
		
			public «abstractCommandName»(IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
				super("«java.getName».commands.«commandName»", daoProvider, viewProvider, appConfiguration);
			}
		
			«FOR outcome : outcomes»
				protected void add«outcome.getName.toFirstUpper»Outcome(«model.dataWithGenericModel» data) {
					data.addOutcome("«outcome.getName»");
				}
			«ENDFOR»
			
			@Override
			public void addEventsToTimeline(«model.dataWithGenericModel» data, PersistenceHandle timelineHandle) {
				if (appConfiguration.getConfig().writeTimeline()) {
					«FOR outcome : outcomes»
						«IF outcome.listeners.size > 0»
							if (data.hasOutcome("«outcome.getName»")){
								daoProvider.getAceDao().addEventToTimeline("«eventName(outcome)»", data, timelineHandle);
							}
						«ENDIF»
					«ENDFOR»
				}
			}
			
			@Override
			public void publishEvents(«model.dataWithGenericModel» data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
				data.freeze();
				«FOR outcome : outcomes»
					«IF outcome.listeners.size > 0»
						if (data.hasOutcome("«outcome.getName»")){
							new Event<«model.modelClassNameWithPackage»>("«eventName(outcome)»", viewProvider).publish(data, handle, timelineHandle);
						}
					«ENDIF»
				«ENDFOR»
			}
			
		}
		
		
		«sdg»
		
	'''

	def generateInitialCommandFile(HttpServerAceWrite it, HttpServer java) '''
		«copyright»
		
		package «java.commandPackage»;
		
		import de.acegen.ViewProvider;
		import de.acegen.IDaoProvider;
		import de.acegen.CustomAppConfiguration;
		import de.acegen.PersistenceHandle;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import «model.modelClassNameWithPackage»
		
		public class «commandName» extends «abstractCommandName» {
		
			static final Logger LOG = LoggerFactory.getLogger(«commandName».class);
		
			public «commandName»(IDaoProvider daoProvider, ViewProvider viewProvider, 
					CustomAppConfiguration appConfiguration) {
				super(daoProvider, viewProvider, appConfiguration);
			}
		
			@Override
			protected «model.dataWithGenericModel» executeCommand(«model.dataWithGenericModel» data, PersistenceHandle readonlyHandle) {
				«IF outcomes.size > 0»
					this.add«outcomes.get(0).getName.toFirstUpper»Outcome(data);
				«ENDIF»
				return data;
			}
		
		}
		
		
		«sdg»
		
	'''

	def generateCommand() '''
		«copyright»
		
		package de.acegen;
		
		import com.fasterxml.jackson.databind.ObjectMapper;
		
		public abstract class Command<T extends AbstractModel> implements ICommand<T> {
		
			private String commandName;
			protected ObjectMapper mapper;
			protected IDaoProvider daoProvider;
			protected ViewProvider viewProvider;
			protected CustomAppConfiguration appConfiguration;
		
			public Command(String commandName, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
				super();
				this.commandName = commandName;
				mapper = new ObjectMapper();
				this.daoProvider = daoProvider;
				this.viewProvider = viewProvider;
				this.appConfiguration = appConfiguration;
			}
		
			protected abstract Data<T> executeCommand(Data<T> data, PersistenceHandle readonlyHandle);
		
			public Data<T> execute(Data<T> data, PersistenceHandle readonlyHandle, PersistenceHandle timelineHandle) {
				if (appConfiguration.getConfig().writeTimeline()) {
					daoProvider.getAceDao().addCommandToTimeline(this.getCommandName(), data, timelineHandle);
				}
				return this.executeCommand(data, readonlyHandle);
			}
		
			public String getCommandName() {
				return commandName;
			}
		
			protected void throwSecurityException() {
				throw new SecurityException();
			}
		
			protected void throwIllegalArgumentException(String error) {
				throw new IllegalArgumentException(error);
			}
		
		}		

		
		«sdg»
		
	'''

	def generateICommand() '''
		«copyright»
		
		package de.acegen;
		
		public interface ICommand<T extends AbstractModel> {
		
			String getCommandName();
		
			Data<T> execute(Data<T> data, PersistenceHandle readonlyHandle, PersistenceHandle timelineHandle);
		
			void addEventsToTimeline(Data<T> data, PersistenceHandle timelineHandle);
		
			void publishEvents(Data<T> data, PersistenceHandle handle, PersistenceHandle timelineHandle);
		
		}
		
		
		«sdg»
		
	'''
	
	
}