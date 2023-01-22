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
import de.acegen.extensions.java.AttributeExtension
import de.acegen.extensions.java.JavaHttpServerExtension
import de.acegen.extensions.java.ModelExtension
import javax.inject.Inject

class Action {

	@Inject
	extension ModelExtension

	@Inject
	extension JavaHttpServerExtension

	@Inject
	extension AttributeExtension

	@Inject
	extension CommonExtension
	
	def dispatch generateAbstractActionFile(HttpServerAceWrite it, HttpServer httpServer) '''
		«copyright»
		
		package «httpServer.getName».actions;
		
		import java.time.LocalDateTime;
		
		import de.acegen.CustomAppConfiguration;
		import de.acegen.ICommand;
		import de.acegen.IDaoProvider;
		import de.acegen.ViewProvider;
		import de.acegen.SquishyDataProvider;
		import de.acegen.PersistenceConnection;
		import de.acegen.WriteAction;

		«getModel.dataImport»
		import «commandNameWithPackage»;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;

		public abstract class «abstractActionName» extends WriteAction<«model.dataParamType»> {

			static final Logger LOG = LoggerFactory.getLogger(«abstractActionName».class);

			«constructor»
				super("«actionNameWithPackage»", persistenceConnection, appConfiguration, daoProvider, viewProvider);
			}
		
			@Override
			public ICommand<«model.dataParamType»> getCommand() {
				return new «commandName»(daoProvider, viewProvider, this.appConfiguration);
			}
			
			«initActionDataFromSquishyDataProvider»		

			public «getModel.dataParamType» initActionData(«getModel.dataParamType» data) {
				return data;
			}

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
		import de.acegen.SquishyDataProvider;
		
		«getModel.dataImport»
		«getModel.dataClassImport»
		
		@SuppressWarnings("unused")
		public abstract class «abstractActionName» extends ReadAction<«getModel.dataParamType»> {
		
			static final Logger LOG = LoggerFactory.getLogger(«abstractActionName».class);
			
			«constructor»
				super("«actionNameWithPackage»", persistenceConnection, appConfiguration, daoProvider, viewProvider);
			}
		
			protected abstract «getModel.dataParamType» loadDataForGetRequest(«getModel.dataParamType» data, PersistenceHandle readonlyHandle);
		
			«initActionDataFromSquishyDataProvider»

			public «getModel.dataParamType» initActionData(«getModel.dataParamType» data) {
				return data;
			}

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
		«IF model.allSquishyAttributes.size > 0 || getType.equals("GET")»
			«getModel.dataImport»
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
				protected «getModel.dataParamType» loadDataForGetRequest(«getModel.dataParamType» data, PersistenceHandle readonlyHandle) {
					«getModel.interfaceWithPackage» testData = «getModel.dataNameWithPackage».generateTestData();
					«FOR attribute: it.model.attributes»
						data.«attribute.setterCall('''testData.«attribute.getterCall»''')»;
					«ENDFOR»
					return data;
				}
			«ENDIF»
			
			«IF model.allSquishyAttributes.size > 0»
				public «getModel.dataParamType» initActionData(«getModel.dataParamType» data) {
					«FOR attribute: model.allSquishyAttributes»
						// «attribute.name»
					«ENDFOR»
					return data;
				}
			«ENDIF»
		
		}
		
		«sdg»
		
	'''

	def generateAction() '''
		«copyright»
		
		package de.acegen;
		
		public abstract class Action<T extends IDataContainer> implements IAction<T> {
		
			protected String actionName;
		
			public Action(String actionName) {
				super();
				this.actionName = actionName;
			}
			
			public String getActionName() {
				return this.actionName;
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
		import java.time.ZoneOffset;

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
		
			protected abstract T loadDataForGetRequest(T data, PersistenceHandle readonlyHandle);
			
			protected abstract T initActionDataFromSquishyDataProvider(T data);

			public T apply(T data) {
				DatabaseHandle databaseHandle = new DatabaseHandle(persistenceConnection.getJdbi(), appConfiguration);
				databaseHandle.beginTransaction();
				try {
					if (!daoProvider.getAceDao().checkUuid(data.getUuid())) {
						LOG.error("duplicate request {} {} ", actionName, data.getUuid());
						throwIllegalArgumentException("duplicate request " + actionName + " " + data.getUuid());
					}
					
					data.setSystemTime(LocalDateTime.now(ZoneOffset.UTC));
					«addActionToTimeline»

					data = this.initActionData(data);
					if (Config.DEV.equals(appConfiguration.getConfig().getMode())) {
						data = initActionDataFromSquishyDataProvider(data);
					}
					data = this.loadDataForGetRequest(data, databaseHandle.getReadonlyHandle());
					
					databaseHandle.commitTransaction();
					return data;
				«catchFinallyBlock»
				
			}
		
		}
		
		
		«sdg»
		
	'''

	def generateWriteAction() '''
		«copyright»
		
		package de.acegen;
		
		import java.time.LocalDateTime;
		import java.time.ZoneOffset;
		
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
		
			protected abstract T initActionDataFromSquishyDataProvider(T data);

			protected abstract ICommand<T> getCommand();
		
			public T apply(T data) {
				DatabaseHandle databaseHandle = new DatabaseHandle(persistenceConnection.getJdbi(), appConfiguration);
				databaseHandle.beginTransaction();
				try {
					if (!daoProvider.getAceDao().checkUuid(data.getUuid())) {
						LOG.error("duplicate request {} {} ", actionName, data.getUuid());
						throwIllegalArgumentException("duplicate request " + actionName + " " + data.getUuid());
					}

					data.setSystemTime(LocalDateTime.now(ZoneOffset.UTC));
					«addActionToTimeline»

					data = this.initActionData(data);
					if (Config.DEV.equals(appConfiguration.getConfig().getMode())) {
						data = initActionDataFromSquishyDataProvider(data);
					}
					
					ICommand<T> command = this.getCommand();
					data = command.execute(data, databaseHandle.getReadonlyHandle(), databaseHandle.getTimelineHandle());
					command.addEventsToTimeline(data, databaseHandle.getTimelineHandle());
					command.publishEvents(data, databaseHandle.getHandle(), databaseHandle.getTimelineHandle());
					databaseHandle.commitTransaction();
					return data;
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
			
		    T apply(T data);
		    
		    T initActionData(T data);
		    
		}
		
		
		«sdg»
		
	'''
	
	private def constructor(HttpServerAce it) '''
		public «abstractActionName»(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
				IDaoProvider daoProvider, ViewProvider viewProvider) {
	'''
	
	private def initActionDataFromSquishyDataProvider(HttpServerAce it) '''
		@Override
		protected «model.dataParamType» initActionDataFromSquishyDataProvider(«model.dataParamType» data) {
			LocalDateTime systemTime = SquishyDataProvider.consumeSystemTime(data.getUuid());
			if (systemTime != null) {
				data.setSystemTime(systemTime);
			}
			«FOR attribute : getModel.allAttributes»
				«IF attribute.squishy»
					String «attribute.name»Object = SquishyDataProvider.consumeValue(data.getUuid(), "«attribute.name»");
					if («attribute.name»Object != null) {
						try {
							«attribute.javaType» «attribute.name» = («attribute.javaType»)«attribute.name»Object;
							data.«attribute.setterCall(attribute.name)»;
						} catch (Exception x) {
							LOG.warn("«attribute.name» is declared as squishy and failed to parse {} from SquishyDataProvider.", «attribute.name»Object);
						}
					} else {
						LOG.warn("«attribute.name» is declared as squishy but no value was found in SquishyDataProvider.");
					}
				«ENDIF»
			«ENDFOR»
			return data;
		}
	'''
	
	private def addActionToTimeline() '''
		if (appConfiguration.getConfig().writeTimeline()) {
			daoProvider.getAceDao().addActionToTimeline(this.getActionName(), data, databaseHandle.getTimelineHandle());
		}
	'''
	
	private def addExceptionToTimeline() '''
		if (appConfiguration.getConfig().writeError()) {
			daoProvider.getAceDao().addExceptionToTimeline(data.getUuid(), x, databaseHandle.getTimelineHandle());
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