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


package de.acegen.templates.cs.commands

import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerAceWrite
import de.acegen.aceGen.HttpServerView
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.java.JavaHttpServerExtension
import de.acegen.extensions.java.ModelExtension
import javax.inject.Inject

class Command {

	@Inject
	extension JavaHttpServerExtension

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
		import de.acegen.Event;
		
		«getModel.dataImport»
		
		@SuppressWarnings("unused")
		public abstract class «abstractCommandName» extends Command<«getModel.dataParamType»> {
		
			public «abstractCommandName»(IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
				super("«java.getName».commands.«commandName»", daoProvider, viewProvider, appConfiguration);
			}
		
			«FOR outcome : outcomes»
				protected void add«outcome.getName.toFirstUpper»Outcome(«getModel.dataParamType» data) {
					data.addOutcome("«outcome.getName»");
				}
			«ENDFOR»
			
			@Override
			public void addEventsToTimeline(«getModel.dataParamType» data, PersistenceHandle timelineHandle) {
				if (appConfiguration.getConfig().writeTimeline()) {
					«FOR outcome : outcomes»
						«IF outcome.listeners.size > 0»
							if (data.hasOutcome("«outcome.getName»")){
								daoProvider.getAceDao().addEventToTimeline("«eventNameWithPackage(outcome)»", data, timelineHandle);
							}
						«ENDIF»
					«ENDFOR»
				}
			}
			
			@Override
			public void publishEvents(«model.dataParamType» data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
				«FOR outcome : outcomes»
					«IF outcome.listeners.filter[listenerFunction | !(listenerFunction.eContainer as HttpServerView).afterCommit ].size > 0»
						if (data.hasOutcome("«outcome.getName»")){
							new Event<«model.dataParamType»>("«eventNameWithPackage(outcome)»", viewProvider).publish(data.deepCopy(), handle, timelineHandle);
						}
					«ENDIF»
				«ENDFOR»
			}
			
			@Override
			public void publishAfterCommitEvents(«model.dataParamType» data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
				«FOR outcome : outcomes»
					«IF outcome.listeners.filter[listenerFunction | (listenerFunction.eContainer as HttpServerView).afterCommit ].size > 0»
						if (data.hasOutcome("«outcome.getName»")){
							new Event<«model.dataParamType»>("«eventNameWithPackage(outcome)»", viewProvider).publishAfterCommit(data.deepCopy(), handle, timelineHandle);
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
		
			public «commandName»(IDaoProvider daoProvider, ViewProvider viewProvider, 
					CustomAppConfiguration appConfiguration) {
				super(daoProvider, viewProvider, appConfiguration);
			}
		
			@Override
			protected «model.dataParamType» executeCommand(«model.dataParamType» data, PersistenceHandle readonlyHandle) {
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
		
		namespace AceGen
		{
		    public abstract class Command<T> : ICommand<T> where T : IDataContainer
		    {
		
		        public abstract string CommandName { get; }
		
		        private readonly AppConfiguration appConfiguration;
		        private readonly IAceDao aceDao;
		
		        protected Command(AppConfiguration appConfiguration, IAceDao aceDao)
		        {
		            this.appConfiguration = appConfiguration;
		            this.aceDao = aceDao;
		        }
		
		        public abstract void addEventsToTimeline(T data);
		
		        protected abstract T executeCommand(T data);
		
		        public T execute(T data)
		        {
		            if (appConfiguration.WriteTimeline)
		            {
						aceDao.addCommandToTimeLine(this.CommandName, data);
		            }
		            return this.executeCommand(data);
		        }
		
		        public abstract void publishAfterCommitEvents(T data);
		
		        public abstract void publishEvents(T data);
		
		        protected void throwSecurityException()
		        {
		            throw new UnauthorizedAccessException();
		        }
		
		        protected void throwIllegalArgumentException(String error)
		        {
		            throw new BadHttpRequestException(error);
		        }
		    }
		}
		
		
		«sdg»
		
	'''

	def generateICommand() '''
		«copyright»
		
		namespace AceGen
		{
		    public interface ICommand<T> where T : IDataContainer
		    {
		        string CommandName { get; }
		
				T execute(T data);
		
				void addEventsToTimeline(T data);
		
				void publishEvents(T data);
				void publishAfterCommitEvents(T data);
		
		    }
		}
		
		«sdg»
		
	'''
	
	
}