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
import de.acegen.aceGen.HttpServerAce
import de.acegen.aceGen.HttpServerAceRead
import de.acegen.aceGen.HttpServerAceWrite
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.java.AceExtension
import de.acegen.extensions.java.AttributeExtension
import de.acegen.extensions.java.ModelExtension
import javax.inject.Inject

class Action {

	@Inject
	extension ModelExtension

	@Inject
	extension AceExtension

	@Inject
	extension AttributeExtension

	@Inject
	extension CommonExtension
	
	def dispatch generateAbstractActionFile(HttpServerAceWrite it, HttpServer httpServer) '''
		«copyright»
		
		package «httpServer.getName».actions;
		
		import java.time.LocalDateTime;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import org.apache.commons.lang3.StringUtils;
		
		import de.acegen.CustomAppConfiguration;
		import de.acegen.HttpMethod;
		import de.acegen.ICommand;
		import de.acegen.IDaoProvider;
		import de.acegen.IDataContainer;
		import de.acegen.ITimelineItem;
		import de.acegen.ViewProvider;
		import de.acegen.NonDeterministicDataProvider;
		import de.acegen.PersistenceConnection;
		import de.acegen.WriteAction;

		«getModel.dataImport»
		«getModel.dataClassImport»
		«IF outcomes.size > 0»
			import «commandNameWithPackage»;
		«ENDIF»
		
		@SuppressWarnings("unused")
		public abstract class «abstractActionName» extends WriteAction<«getModel.dataParamType»> {

			static final Logger LOG = LoggerFactory.getLogger(«abstractActionName».class);
			
			«constructor»
				super("«actionNameWithPackage»", persistenceConnection, appConfiguration, daoProvider,
								viewProvider);
			}
		
			@Override
			public ICommand getCommand() {
				«IF outcomes.size > 0»
					return new «commandName»(this.actionData, daoProvider, viewProvider, this.appConfiguration);
				«ELSE»
					return null;
				«ENDIF»
			}
			
			«initActionDataFromNonDeterministicDataProvider»		

		}
		
		
		«sdg»
		
	'''

	def dispatch generateAbstractActionFile(HttpServerAceRead it, HttpServer httpServer) '''
		«copyright»
		
		package «httpServer.getName».actions;
		
		import java.time.LocalDateTime;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import org.apache.commons.lang3.StringUtils;
		
		import de.acegen.CustomAppConfiguration;
		import de.acegen.IDaoProvider;
		import de.acegen.IDataContainer;
		import de.acegen.ViewProvider;
		import de.acegen.PersistenceConnection;
		import de.acegen.PersistenceHandle;
		import de.acegen.ReadAction;
		import de.acegen.ITimelineItem;
		import de.acegen.NonDeterministicDataProvider;
		
		«getModel.dataImport»
		«getModel.dataClassImport»
		
		@SuppressWarnings("unused")
		public abstract class «abstractActionName» extends ReadAction<«getModel.dataParamType»> {
		
			static final Logger LOG = LoggerFactory.getLogger(«abstractActionName».class);
			
			«constructor»
				super("«actionNameWithPackage»", persistenceConnection, appConfiguration, daoProvider, viewProvider);
			}
		
			protected abstract void loadDataForGetRequest(PersistenceHandle readonlyHandle);
		
			«initActionDataFromNonDeterministicDataProvider»

		}
		
		«sdg»
		
	'''

	def generateInitialActionFile(HttpServerAce it, HttpServer httpServer) '''
		«copyright»
		
		package «httpServer.getName».actions;
		
		import de.acegen.CustomAppConfiguration;
		import de.acegen.ViewProvider;
		import de.acegen.IDaoProvider;
		import de.acegen.PersistenceConnection;
		«IF getType.equals("GET")»
			import de.acegen.PersistenceHandle;
		«ENDIF»
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;

		public class «actionName» extends «abstractActionName» {
		
			static final Logger LOG = LoggerFactory.getLogger(«actionName».class);
		
			public «actionName»(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, 
					ViewProvider viewProvider) {
				super(persistenceConnection, appConfiguration, daoProvider, viewProvider);
			}
		
		
			«IF getType.equals("GET")»
				@Override
				protected void loadDataForGetRequest(PersistenceHandle readonlyHandle) {
					«getModel.interfaceWithPackage» testData = «getModel.dataNameWithPackage».generateTestData();
					«FOR attribute: it.model.attributes»
						this.actionData.«attribute.setterCall('''testData.«attribute.getterCall»''')»;
					«ENDFOR»
				}
			«ENDIF»
			
			public void initActionData() {
				// init not replayable data here
				«FOR attribute: model.allNonDeterministicAttributes»
					// «attribute.name»
				«ENDFOR»
			}
		
		}
		
		
		«sdg»
		
	'''

	def generateAction() '''
		«copyright»
		
		package de.acegen;
		
		public abstract class Action<T extends IDataContainer> implements IAction<T> {
		
			protected T actionData;
			protected String actionName;
		
			public Action(String actionName) {
				super();
				this.actionName = actionName;
			}
			
			public void setActionData(T actionData) {
				this.actionData = actionData;
			}
		
			public String getActionName() {
				return this.actionName;
			}
		
			public T getActionData() {
				return this.actionData;
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
	
	def generateReadAction() '''
		«copyright»
		
		package de.acegen;
		
		import java.time.LocalDateTime;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		public abstract class ReadAction<T extends IDataContainer> extends Action<T> {
		
			static final Logger LOG = LoggerFactory.getLogger(ReadAction.class);
			
			private PersistenceConnection persistenceConnection;
			protected CustomAppConfiguration appConfiguration;
			protected IDaoProvider daoProvider;
			
			public ReadAction(String actionName, PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
					IDaoProvider daoProvider, ViewProvider viewProvider) {
				super(actionName);
				this.persistenceConnection = persistenceConnection;
				this.appConfiguration = appConfiguration;
				this.daoProvider = daoProvider;
			}
		
			protected abstract void loadDataForGetRequest(PersistenceHandle readonlyHandle);
			
			protected abstract void initActionDataFromNonDeterministicDataProvider();

			public void apply() {
				DatabaseHandle databaseHandle = new DatabaseHandle(persistenceConnection.getJdbi(), appConfiguration);
				databaseHandle.beginTransaction();
				try {
					if (!daoProvider.getAceDao().checkUuid(this.actionData.getUuid())) {
						databaseHandle.rollbackTransaction();
						LOG.warn("duplicate request {} {} ", actionName, this.actionData.getUuid());
						databaseHandle.rollbackTransaction();
						return;
					}
					
					«addActionToTimeline»

					this.actionData.setSystemTime(LocalDateTime.now());
					this.initActionData();
					if (Config.DEV.equals(appConfiguration.getConfig().getMode())) {
						initActionDataFromNonDeterministicDataProvider();
					}
					this.loadDataForGetRequest(databaseHandle.getReadonlyHandle());
					
					databaseHandle.commitTransaction();
				«catchFinallyBlock»
				
			}
		
		}
		
		
		«sdg»
		
	'''

	def generateWriteAction() '''
		«copyright»
		
		package de.acegen;
		
		import java.time.LocalDateTime;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		public abstract class WriteAction<T extends IDataContainer> extends Action<T> {
		
			static final Logger LOG = LoggerFactory.getLogger(WriteAction.class);
			
			private PersistenceConnection persistenceConnection;
			protected CustomAppConfiguration appConfiguration;
			protected IDaoProvider daoProvider;
			protected ViewProvider viewProvider;
			
			public WriteAction(String actionName, PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
					IDaoProvider daoProvider, ViewProvider viewProvider) {
				super(actionName);
				this.persistenceConnection = persistenceConnection;
				this.appConfiguration = appConfiguration;
				this.daoProvider = daoProvider;
				this.viewProvider = viewProvider;
			}
		
			protected abstract void initActionDataFromNonDeterministicDataProvider();

			protected abstract ICommand getCommand();
		
			public void apply() {
				DatabaseHandle databaseHandle = new DatabaseHandle(persistenceConnection.getJdbi(), appConfiguration);
				databaseHandle.beginTransaction();
				try {
					if (!daoProvider.getAceDao().checkUuid(this.actionData.getUuid())) {
						LOG.warn("duplicate request {} {} ", actionName, this.actionData.getUuid());
						databaseHandle.rollbackTransaction();
						return;
					}

					«addActionToTimeline»

					this.actionData.setSystemTime(LocalDateTime.now());
					this.initActionData();
					if (Config.DEV.equals(appConfiguration.getConfig().getMode())) {
						initActionDataFromNonDeterministicDataProvider();
					}
					
					ICommand command = this.getCommand();
					command.execute(databaseHandle.getReadonlyHandle(), databaseHandle.getTimelineHandle());
					command.publishEvents(databaseHandle.getHandle(), databaseHandle.getTimelineHandle());
					databaseHandle.commitTransaction();
				«catchFinallyBlock»
			}
		
		}
		
		
		«sdg»
		
	'''
	
	def generateHttpMethod() '''
		«copyright»
		
		package de.acegen;
		
		public enum HttpMethod {
			GET, POST, PUT, DELETE
		}
		
		
		«sdg»
		
	'''
	
	def generateIAction() '''
		«copyright»
		
		package de.acegen;
		
		public interface IAction<T> {
		
			String getActionName();
			
			void setActionData(T actionData);
			
			IDataContainer getActionData();
			
		    void apply();
		    
		    void initActionData();
		    
		}
		
		
		«sdg»
		
	'''
	
	private def constructor(HttpServerAce it) '''
		public «abstractActionName»(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
				IDaoProvider daoProvider, ViewProvider viewProvider) {
	'''
	
	private def initActionDataFromNonDeterministicDataProvider(HttpServerAce it) '''
		@Override
		protected void initActionDataFromNonDeterministicDataProvider() {
			LocalDateTime systemTime = NonDeterministicDataProvider.consumeSystemTime(this.actionData.getUuid());
			if (systemTime != null) {
				this.actionData.setSystemTime(systemTime);
			}
			«FOR attribute : getModel.allAttributes»
				«IF attribute.nonDeterministic»
					Object value = NonDeterministicDataProvider.consumeValue(this.actionData.getUuid(), "«attribute.name»");
					if (value != null) {
						try {
							«attribute.javaType» «attribute.name» = («attribute.javaType»)value;
							this.actionData.«attribute.setterCall(attribute.name)»;
						} catch (Exception x) {
							LOG.warn("«attribute.name» is declared as non-deterministnic and failed to parse {} from NonDeterministicDataProvider.", value);
						}
					} else {
						LOG.warn("«attribute.name» is declared as non-deterministnic but no value was found in NonDeterministicDataProvider.");
					}
				«ENDIF»
			«ENDFOR»
		}
	'''
	
	private def addActionToTimeline() '''
		if (appConfiguration.getConfig().writeTimeline()) {
			daoProvider.getAceDao().addActionToTimeline(this, databaseHandle.getTimelineHandle());
		}
	'''
	
	private def addExceptionToTimeline() '''
		if (appConfiguration.getConfig().writeError()) {
			daoProvider.getAceDao().addExceptionToTimeline(this.actionData.getUuid(), x, databaseHandle.getTimelineHandle());
		}
	'''
	
	private def catchFinallyBlock() '''
		} catch (IllegalArgumentException x) {
			LOG.error(actionName + " IllegalArgumentException {} ", x.getMessage());
			try {
				«addExceptionToTimeline»
				databaseHandle.rollbackTransaction();
			} catch (Exception ex) {
				LOG.error(actionName + ": failed to rollback or to save or report exception " + ex.getMessage());
			}
			throw x;
		} catch (SecurityException x) {
			LOG.error(actionName + " SecurityException");
			try {
				«addExceptionToTimeline»
				databaseHandle.rollbackTransaction();
			} catch (Exception ex) {
				LOG.error(actionName + ": failed to rollback or to save or report exception " + ex.getMessage());
			}
			throw x;
		} catch (Exception x) {
			LOG.error(actionName + " Exception {} ", x.getMessage());
			try {
				«addExceptionToTimeline»
				databaseHandle.rollbackTransaction();
			} catch (Exception ex) {
				LOG.error(actionName + ": failed to rollback or to save or report exception " + ex.getMessage());
			}
			throw x;
		} finally {
			databaseHandle.close();
		}
	''' 

	
	
}