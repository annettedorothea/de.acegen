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
import de.acegen.extensions.java.AceExtension
import de.acegen.extensions.java.ModelExtension
import javax.inject.Inject
import de.acegen.aceGen.HttpServerView

class Command {

	@Inject
	extension AceExtension

	@Inject
	extension ModelExtension

	@Inject
	extension CommonExtension
	
	def generateAbstractCommandFile(HttpServerAceWrite it, HttpServer java) '''
		«copyright»
		
		package «java.getName».commands;
		
		import de.acegen.Command;
		import de.acegen.CustomAppConfiguration;
		import de.acegen.IDaoProvider;
		import de.acegen.ViewProvider;
		import de.acegen.PersistenceHandle;
		
		«getModel.dataImport»
		
		public abstract class «abstractCommandName» extends Command<«getModel.dataParamType»> {
		
			public «abstractCommandName»(«getModel.dataParamType» commandParam, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
				super("«java.getName».commands.«commandName»", commandParam, daoProvider, viewProvider, appConfiguration);
			}
		
			«FOR outcome : outcomes»
				protected void add«outcome.getName.toFirstUpper»Outcome() {
					this.commandData.addOutcome("«outcome.getName»");
				}

			«ENDFOR»
			@Override
			public void publishEvents(PersistenceHandle handle, PersistenceHandle timelineHandle) {
				«FOR outcome : outcomes»
					«IF outcome.listeners.filter[listenerFunction | !(listenerFunction.eContainer as HttpServerView).afterCommit ].size > 0»
						if (this.commandData.hasOutcome("«outcome.getName»")){
							new «eventNameWithPackage(outcome)»(this.commandData, daoProvider, viewProvider, appConfiguration).publish(handle, timelineHandle);
						}
					«ENDIF»
				«ENDFOR»
			}
			
			@Override
			public void publishAfterCommitEvents(PersistenceHandle handle, PersistenceHandle timelineHandle) {
				«FOR outcome : outcomes»
					«IF outcome.listeners.filter[listenerFunction | (listenerFunction.eContainer as HttpServerView).afterCommit ].size > 0»
						if (this.commandData.hasOutcome("«outcome.getName»")){
							new «eventNameWithPackage(outcome)»(this.commandData, daoProvider, viewProvider, appConfiguration).publishAfterCommit(handle, timelineHandle);
						}
					«ENDIF»
				«ENDFOR»
			}
			
		}
		
		
		«sdg»
		
	'''

	def generateInitialCommandFile(HttpServerAceWrite it, HttpServer java) '''
		«copyright»
		
		package «java.getName».commands;
		
		import de.acegen.ViewProvider;
		import de.acegen.IDaoProvider;
		import de.acegen.CustomAppConfiguration;
		import de.acegen.PersistenceHandle;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		«getModel.dataImport»
		
		public class «commandName» extends «abstractCommandName» {
		
			static final Logger LOG = LoggerFactory.getLogger(«commandName».class);
		
			public «commandName»(«getModel.dataParamType» commandData, IDaoProvider daoProvider, ViewProvider viewProvider, 
					CustomAppConfiguration appConfiguration) {
				super(commandData, daoProvider, viewProvider, appConfiguration);
			}
		
			@Override
			protected void executeCommand(PersistenceHandle readonlyHandle) {
				«IF outcomes.size > 0»
					this.add«outcomes.get(0).getName.toFirstUpper»Outcome();
				«ENDIF»
			}
		
		}
		
		
		«sdg»
		
	'''

	def generateCommand() '''
		«copyright»
		
		package de.acegen;
		
		import com.fasterxml.jackson.databind.ObjectMapper;
		
		public abstract class Command<T extends IDataContainer> implements ICommand {
		
			protected T commandData;
			private String commandName;
			protected ObjectMapper mapper;
			protected IDaoProvider daoProvider;
			protected ViewProvider viewProvider;
			protected CustomAppConfiguration appConfiguration;
		
			public Command(String commandName, T commandData, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
				super();
				this.commandData = commandData;
				this.commandName = commandName;
				mapper = new ObjectMapper();
				this.daoProvider = daoProvider;
				this.viewProvider = viewProvider;
				this.appConfiguration = appConfiguration;
			}
		
			protected abstract void executeCommand(PersistenceHandle readonlyHandle);
		
			public void execute(PersistenceHandle readonlyHandle, PersistenceHandle timelineHandle) {
				if (appConfiguration.getConfig().writeTimeline()) {
					daoProvider.getAceDao().addCommandToTimeline(this, timelineHandle);
				}
				this.executeCommand(readonlyHandle);
			}
		
			public IDataContainer getCommandData() {
				return commandData;
			}
			
			@SuppressWarnings("unchecked")
			public void setCommandData(IDataContainer data) {
				commandData = (T)data;
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
		
		public interface ICommand {
		
			String getCommandName();

			IDataContainer getCommandData();
			
			void setCommandData(IDataContainer data);

			void execute(PersistenceHandle readonlyHandle, PersistenceHandle timelineHandle);
		
			void publishEvents(PersistenceHandle handle, PersistenceHandle timelineHandle);

			void publishAfterCommitEvents(PersistenceHandle handle, PersistenceHandle timelineHandle);

		}
		
		
		«sdg»
		
	'''
	
	
}