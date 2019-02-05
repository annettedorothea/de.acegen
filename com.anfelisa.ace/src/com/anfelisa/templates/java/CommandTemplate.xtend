package com.anfelisa.templates.java

import com.anfelisa.ace.JAVA
import com.anfelisa.ace.JAVA_ACE_WRITE
import com.anfelisa.extensions.java.AceExtension
import com.anfelisa.extensions.java.ModelExtension
import javax.inject.Inject

class CommandTemplate {
	@Inject
	extension AceExtension

	@Inject
	extension ModelExtension

	def generateAbstractCommandFile(JAVA_ACE_WRITE it, JAVA java) '''
		package «java.name».commands;
		
		import javax.ws.rs.WebApplicationException;
		import org.jdbi.v3.core.Handle;
		
		import com.anfelisa.ace.Command;
		import com.anfelisa.ace.CustomAppConfiguration;
		import com.anfelisa.ace.IDaoProvider;
		import com.anfelisa.ace.ViewProvider;
		
		«model.dataImport»
		
		public abstract class «abstractCommandName» extends Command<«model.dataParamType»> {
		
			«FOR outcome : outcomes»
				protected static final String «outcome.name» = "«outcome.name»";
			«ENDFOR»
		
			public «abstractCommandName»(«model.dataParamType» commandParam, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
				super("«java.name».commands.«commandName»", commandParam, daoProvider, viewProvider, appConfiguration);
			}
		
			@Override
			public void publishEvents(Handle handle, Handle timelineHandle) {
				switch (this.commandData.getOutcome()) {
				«FOR outcome : outcomes»
					case «outcome.name»:
						«IF outcome.listeners.size > 0»
							new «eventNameWithPackage(outcome)»(this.commandData, daoProvider, viewProvider).publish(handle, timelineHandle);
						«ENDIF»
						break;
				«ENDFOR»
				default:
					throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
				}
			}
			
		}
		
		/*       S.D.G.       */
	'''

	def generateInitialCommandFile(JAVA_ACE_WRITE it, JAVA java) '''
		package «java.name».commands;
		
		import com.anfelisa.ace.ViewProvider;
		import com.anfelisa.ace.IDaoProvider;
		import com.anfelisa.ace.CustomAppConfiguration;
		import org.jdbi.v3.core.Handle;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		«model.dataImport»
		
		public class «commandName» extends «abstractCommandName» {
		
			static final Logger LOG = LoggerFactory.getLogger(«commandName».class);
		
			public «commandName»(«model.dataParamType» commandData, IDaoProvider daoProvider, ViewProvider viewProvider, 
					CustomAppConfiguration appConfiguration) {
				super(commandData, daoProvider, viewProvider, appConfiguration);
			}
		
			@Override
			protected void executeCommand(Handle readonlyHandle) {
				«IF outcomes.size > 0»
					this.commandData.setOutcome(«outcomes.get(0).name»);
				«ENDIF»
			}
		
		}
		
		/*       S.D.G.       */
	'''

	def generateCommand() '''
		package com.anfelisa.ace;
		
		import javax.ws.rs.WebApplicationException;
		import javax.ws.rs.core.Response;
		import com.anfelisa.ace.CustomAppConfiguration;
		
		import org.jdbi.v3.core.Handle;
		
		public abstract class Command<T extends IDataContainer> implements ICommand {
		
			protected T commandData;
			private String commandName;
			protected JodaObjectMapper mapper;
			protected IDaoProvider daoProvider;
			protected ViewProvider viewProvider;
			protected CustomAppConfiguration appConfiguration;
		
			public Command(String commandName, T commandData, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
				super();
				this.commandData = commandData;
				this.commandName = commandName;
				mapper = new JodaObjectMapper();
				this.daoProvider = daoProvider;
				this.viewProvider = viewProvider;
				this.appConfiguration = appConfiguration;
			}
		
			protected abstract void executeCommand(Handle readonlyHandle);
		
			public void execute(Handle readonlyHandle, Handle timelineHandle) {
				this.executeCommand(readonlyHandle);
				daoProvider.getAceDao().addCommandToTimeline(this, timelineHandle);
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
		
			protected void throwUnauthorized() {
				throw new WebApplicationException(Response.Status.UNAUTHORIZED);
			}
		
			protected void throwBadRequest() {
				throw new WebApplicationException(Response.Status.BAD_REQUEST);
			}
		
			protected void throwBadRequest(String error) {
				throw new WebApplicationException(error, Response.Status.BAD_REQUEST);
			}
		
			protected void throwForbidden(String error) {
				throw new WebApplicationException(error, Response.Status.FORBIDDEN);
			}
		
			protected void throwInternalServerError(Exception x) {
				String message = x.getMessage();
				StackTraceElement[] stackTrace = x.getStackTrace();
				int i = 1;
				for (StackTraceElement stackTraceElement : stackTrace) {
					message += "\n" + stackTraceElement.toString();
					if (i > 3) {
						message += "\n" + (stackTrace.length - 4) + " more...";
						break;
					}
					i++;
				}
				throw new WebApplicationException(message, Response.Status.INTERNAL_SERVER_ERROR);
			}
		
		}
		
	'''

	def generateICommand() '''
		package com.anfelisa.ace;
		
		import org.jdbi.v3.core.Handle;
		
		public interface ICommand {
		
			String getCommandName();

			IDataContainer getCommandData();
			
			void setCommandData(IDataContainer data);

			void execute(Handle readonlyHandle, Handle timelineHandle);
		
			void publishEvents(Handle handle, Handle timelineHandle);
		}
		
	'''
	
}
