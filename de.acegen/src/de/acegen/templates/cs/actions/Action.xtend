package de.acegen.templates.cs.actions

import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerAce
import de.acegen.aceGen.HttpServerAceRead
import de.acegen.aceGen.HttpServerAceWrite
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.cs.AceExtension
import de.acegen.extensions.cs.AttributeExtension
import de.acegen.extensions.cs.ModelExtension
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
		
		// C#
		package «httpServer.getName».actions;
		
		import java.time.LocalDateTime;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import org.apache.commons.lang3.StringUtils;
		
		import de.acegen.CustomAppConfiguration;
		import de.acegen.E2E;
		import de.acegen.HttpMethod;
		import de.acegen.ICommand;
		import de.acegen.IDaoProvider;
		import de.acegen.IDataContainer;
		import de.acegen.ITimelineItem;
		import de.acegen.ViewProvider;
		import de.acegen.NotReplayableDataProvider;
		import de.acegen.PersistenceConnection;
		import de.acegen.«IF proxy»Proxy«ENDIF»WriteAction;
		
		«getModel.dataImport»
		«getModel.dataClassImport»
		«IF outcomes.size > 0»
			import «commandNameWithPackage(httpServer)»;
		«ENDIF»
		
		@SuppressWarnings("unused")
		public abstract class «abstractActionName» extends «IF isProxy»Proxy«ENDIF»WriteAction<«getModel.dataParamType»> {
		
			static final Logger LOG = LoggerFactory.getLogger(«abstractActionName».class);
			
			«constructor»
				super("«actionNameWithPackage(httpServer)»", persistenceConnection, appConfiguration, daoProvider,
								viewProvider, e2e);
			}
		
			@Override
			public ICommand getCommand() {
				«IF outcomes.size > 0»
					return new «commandName»(this.actionData, daoProvider, viewProvider, this.appConfiguration);
				«ELSE»
					return null;
				«ENDIF»
			}
			
			«initActionDataFrom»
		
			«IF proxy»
			@Override
			protected «getModel.dataParamType» createDataFrom(ITimelineItem timelineItem) {
				IDataContainer originalData = AceDataFactory.createAceData(timelineItem.getName(), timelineItem.getData());
				return («getModel.dataParamType»)originalData;
			}
			«ENDIF»
		
			«initActionDataFromNotReplayableDataProvider»		
		
		}
		
		
		«sdg»
		
	'''

	def dispatch generateAbstractActionFile(HttpServerAceRead it, HttpServer httpServer) '''
		«copyright»
		
		
		«IF authorize»
			//using de.acegen.auth.AuthUser;
		«ENDIF»
		
		//«getModel.dataImport»
		//«getModel.dataClassImport»
		
		namespace «httpServer.getName».Actions {

			public abstract class «abstractActionName» : «IF isProxy»Proxy«ENDIF»ReadAction<«getModel.dataParamType»> {
			
				«constructor»
					super("«actionNameWithPackage(httpServer)»", persistenceConnection, appConfiguration, daoProvider,
				}
			
				protected abstract void loadDataForGetRequest(PersistenceHandle readonlyHandle);
			
				«initActionDataFrom»
				
				«initActionDataFromNotReplayableDataProvider»
			
				«IF proxy»
				@Override
				protected «getModel.dataParamType» createDataFrom(ITimelineItem timelineItem) {
					IDataContainer originalData = AceDataFactory.createAceData(timelineItem.getName(), timelineItem.getData());
					return («getModel.dataParamType»)originalData;
				}
				«ENDIF»
			
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
		import de.acegen.E2E;
		import de.acegen.PersistenceConnection;
		«IF getType.equals("GET")»
			import de.acegen.PersistenceHandle;
		«ENDIF»
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		public class «actionName» extends «abstractActionName» {
		
			static final Logger LOG = LoggerFactory.getLogger(«actionName».class);
		
			public «actionName»(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, 
					ViewProvider viewProvider, E2E e2e) {
				super(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e);
			}
		
		
			«IF getType.equals("GET")»
				@Override
				protected void loadDataForGetRequest(PersistenceHandle readonlyHandle) {
				}
			«ENDIF»
			
			public void initActionData() {
				// init not replayable data here
				«FOR attribute: model.allNotReplayableAttributes»
					// «attribute.name»
				«ENDFOR»
			}
		
		}
		
		
		«sdg»
		
	'''

	def generateAction() '''
		«copyright»
		
		namespace Acegen {
		
			public abstract class Action<T> : IAction<T> where T : IDataContainer {
			
				protected T _actionData;
				protected string _actionName;
			
				public Action(string actionName) 
				{
					this._actionName = actionName;
				}
				
				public string ActionName
			    {
			      get => _actionName;
			      set => _actionName = value;
			    }
				
				public T ActionData
			    {
			      get => _actionData;
			      set => _actionData = value;
			    }
				
				protected void throwSecurityException() {
					throw new System.AccessViolationException();
				}
			
				protected void throwIllegalArgumentException(string error) {
					throw new System.ArgumentException(error);
				}

		        public abstract void apply();
		
		        public abstract void initActionData();
			
			}

		}
		
		«sdg»
		
	'''
	
	def generateReadAction(boolean isProxy) '''
		«copyright»
		
		namespace Acegen
		
		import java.time.LocalDateTime;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		public abstract class «IF isProxy»Proxy«ENDIF»ReadAction<T extends IDataContainer> extends Action<T> {
		
			static final Logger LOG = LoggerFactory.getLogger(ReadAction.class);
			
			private PersistenceConnection persistenceConnection;
			protected CustomAppConfiguration appConfiguration;
			protected IDaoProvider daoProvider;
			private E2E e2e;
			
			public «IF isProxy»Proxy«ENDIF»ReadAction(String actionName, PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
					IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
				super(actionName);
				this.persistenceConnection = persistenceConnection;
				this.appConfiguration = appConfiguration;
				this.daoProvider = daoProvider;
				this.e2e = e2e;
			}
		
			protected abstract void loadDataForGetRequest(PersistenceHandle readonlyHandle);
			
			protected abstract void initActionDataFrom(ITimelineItem timelineItem);
		
			protected abstract void initActionDataFromNotReplayableDataProvider();
		
			«IF isProxy»protected abstract T createDataFrom(ITimelineItem timelineItem);«ENDIF»
		
			public void apply() {
			DatabaseHandle databaseHandle = new DatabaseHandle(persistenceConnection.getJdbi(), appConfiguration);
			databaseHandle.beginTransaction();
			try {
				if (Config.DEV.equals(appConfiguration.getConfig().getMode())
						|| Config.LIVE.equals(appConfiguration.getConfig().getMode())
						|| Config.TEST.equals(appConfiguration.getConfig().getMode())) {
					if (!daoProvider.getAceDao().checkUuid(this.actionData.getUuid())) {
						databaseHandle.rollbackTransaction();
						LOG.warn("duplicate request {} {} ", actionName, this.actionData.getUuid());
						databaseHandle.rollbackTransaction();
						return;
					}
					this.actionData.setSystemTime(LocalDateTime.now());
					this.initActionData();
				} else if (Config.REPLAY.equals(appConfiguration.getConfig().getMode())) {
					ITimelineItem timelineItem = e2e.selectAction(this.actionData.getUuid());
					initActionDataFrom(timelineItem);
				}
				if (Config.TEST.equals(appConfiguration.getConfig().getMode())) {
					initActionDataFromNotReplayableDataProvider();
				}
				«IF isProxy»
					if (Config.REPLAY.equals(appConfiguration.getConfig().getMode())) {
						ITimelineItem timelineItem = e2e.selectAction(this.actionData.getUuid());
						T originalData = this.createDataFrom(timelineItem);
						this.setActionData(originalData);
					} else {
						this.loadDataForGetRequest(databaseHandle.getReadonlyHandle());
					}
				«ELSE»
					this.loadDataForGetRequest(databaseHandle.getReadonlyHandle());
				«ENDIF»
				
				«addActionToTimeline»
				databaseHandle.commitTransaction();
			«catchFinallyBlock»
			
			}
		
		}
		
		
		«sdg»
		
	'''

	def generateWriteAction(boolean isProxy) '''
		«copyright»
		
		namespace Acegen
		
		import java.time.LocalDateTime;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		public abstract class «IF isProxy»Proxy«ENDIF»WriteAction<T extends IDataContainer> extends Action<T> {
		
			static final Logger LOG = LoggerFactory.getLogger(«IF isProxy»Proxy«ENDIF»WriteAction.class);
			
			private PersistenceConnection persistenceConnection;
			protected CustomAppConfiguration appConfiguration;
			protected IDaoProvider daoProvider;
			protected ViewProvider viewProvider;
			private E2E e2e;
			
			public «IF isProxy»Proxy«ENDIF»WriteAction(String actionName, PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
					IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
				super(actionName);
				this.persistenceConnection = persistenceConnection;
				this.appConfiguration = appConfiguration;
				this.daoProvider = daoProvider;
				this.viewProvider = viewProvider;
				this.e2e = e2e;
			}
		
			protected abstract void initActionDataFrom(ITimelineItem timelineItem);
		
			«IF isProxy»protected abstract T createDataFrom(ITimelineItem timelineItem);«ENDIF»
			
			protected abstract void initActionDataFromNotReplayableDataProvider();
		
			protected abstract ICommand getCommand();
		
			public void apply() {
				DatabaseHandle databaseHandle = new DatabaseHandle(persistenceConnection.getJdbi(), appConfiguration);
				databaseHandle.beginTransaction();
				try {
					if (Config.DEV.equals(appConfiguration.getConfig().getMode())
							|| Config.LIVE.equals(appConfiguration.getConfig().getMode())
							|| Config.TEST.equals(appConfiguration.getConfig().getMode())) {
						if (!daoProvider.getAceDao().checkUuid(this.actionData.getUuid())) {
							LOG.warn("duplicate request {} {} ", actionName, this.actionData.getUuid());
							databaseHandle.rollbackTransaction();
							return;
						}
						this.actionData.setSystemTime(LocalDateTime.now());
						this.initActionData();
					} else if (Config.REPLAY.equals(appConfiguration.getConfig().getMode())) {
						ITimelineItem timelineItem = e2e.selectAction(this.actionData.getUuid());
						initActionDataFrom(timelineItem);
					}
					if (Config.TEST.equals(appConfiguration.getConfig().getMode())) {
						initActionDataFromNotReplayableDataProvider();
					}
					«addActionToTimeline»
					
					ICommand command = this.getCommand();
					«IF isProxy»
						if (Config.REPLAY.equals(appConfiguration.getConfig().getMode())) {
							ITimelineItem timelineItem = e2e.selectCommand(this.actionData.getUuid());
							T originalData = this.createDataFrom(timelineItem);
							command.setCommandData(originalData);
						} else {
							command.execute(databaseHandle.getReadonlyHandle(), databaseHandle.getTimelineHandle());
						}
					«ELSE»
						command.execute(databaseHandle.getReadonlyHandle(), databaseHandle.getTimelineHandle());
					«ENDIF»
					command.publishEvents(databaseHandle.getHandle(), databaseHandle.getTimelineHandle());
					databaseHandle.commitTransaction();
				«catchFinallyBlock»
			}
		
		}
		
		
		«sdg»
		
	'''
	
	def generateHttpMethod() '''
		«copyright»
		
		namespace Acegen
		
		public enum HttpMethod {
			GET, POST, PUT, DELETE
		}
		
		
		«sdg»
		
	'''
	
	def generateIAction() '''
		«copyright»
		
		namespace Acegen {
			
			public interface IAction<T> where T : IDataContainer {
			
				string ActionName { get; set; }
		
				T ActionData { get; set; }
		
			    void apply();
		
			    void initActionData();
		
			}
		}
		
		
		«sdg»
		
	'''
	
	private def constructor(HttpServerAce it) '''
		public «abstractActionName»(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
				IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
	'''
	
	private def initActionDataFrom(HttpServerAce it) '''
		protected override void initActionDataFrom(ITimelineItem timelineItem) {
			IDataContainer originalData = AceDataFactory.createAceData(timelineItem.getName(), timelineItem.getData());
			«getModel.dataParamType» originalActionData = («getModel.dataParamType»)originalData;
			this.actionData.setSystemTime(originalActionData.getSystemTime());
			«FOR attribute : getModel.allAttributes»
				«IF attribute.notReplayable»
					this.actionData.«attribute.setterCall('''(originalActionData.«attribute.getterCall»)''')»;
				«ENDIF»
			«ENDFOR»
		}
	'''
	
	private def initActionDataFromNotReplayableDataProvider(HttpServerAce it) '''
		protected override void initActionDataFromNotReplayableDataProvider() {
			LocalDateTime systemTime = NotReplayableDataProvider.consumeSystemTime(this.actionData.getUuid());
			if (systemTime != null) {
				this.actionData.setSystemTime(systemTime);
			} else {
				this.actionData.setSystemTime(LocalDateTime.now());
			}
			«FOR attribute : getModel.allAttributes»
				«IF attribute.notReplayable»
					Object value = NotReplayableDataProvider.consumeValue(this.actionData.getUuid(), "«attribute.name»");
					if (value != null) {
						try {
							«attribute.javaType» «attribute.name» = («attribute.javaType»)value;
							this.actionData.«attribute.setterCall(attribute.name)»;
						} catch (Exception x) {
							LOG.warn("«attribute.name» is declared as not replayable and failed to parse {} from NotReplayableDataProvider.", value);
						}
					} else {
						LOG.warn("«attribute.name» is declared as not replayable but no value was found in NotReplayableDataProvider.");
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
			LOG.error(actionName + " SecurityException {} ", x.getMessage());
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
