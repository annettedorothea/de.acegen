package com.anfelisa.templates.java

import com.anfelisa.ace.JAVA
import com.anfelisa.ace.JAVA_ACE
import com.anfelisa.extensions.java.AceExtension
import com.anfelisa.extensions.java.ModelExtension
import javax.inject.Inject

class CommandTemplate {
	@Inject
	extension AceExtension

	@Inject
	extension ModelExtension

	def generateAbstractCommandFile(JAVA_ACE it, JAVA java) '''
		package «java.name».commands;
		
		import javax.ws.rs.WebApplicationException;
		
		import com.anfelisa.ace.Command;
		import com.anfelisa.ace.DatabaseHandle;
		import com.anfelisa.ace.IDaoProvider;
		import com.anfelisa.ace.ViewProvider;
		
		«model.dataImport»
		
		public abstract class «abstractCommandName» extends Command<«model.dataParamType»> {
		
			«FOR outcome : outcomes»
				protected static final String «outcome.name» = "«outcome.name»";
			«ENDFOR»
		
			public «abstractCommandName»(«model.dataParamType» commandParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
				super("«java.name».commands.«commandName»", commandParam, databaseHandle, daoProvider, viewProvider);
			}
		
			public «abstractCommandName»(DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
				super("«java.name».commands.«commandName»", null, databaseHandle, daoProvider, viewProvider);
			}
		
			@Override
			public void publishEvents() {
				switch (this.commandData.getOutcome()) {
				«FOR outcome : outcomes»
					case «outcome.name»:
						«IF outcome.listeners.size > 0»
							new «eventNameWithPackage(outcome)»(this.commandData, databaseHandle, daoProvider, viewProvider).publish();
						«ENDIF»
						break;
				«ENDFOR»
				default:
					throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
				}
			}
			
			public void initCommandData(String json) {
				try {
					this.commandData = mapper.readValue(json, «model.dataParamType».class);
				} catch (Exception e) {
					throw new WebApplicationException(e);
				}
			}
		
		}
		
		/*       S.D.G.       */
	'''

	def generateInitialCommandFile(JAVA_ACE it, JAVA java) '''
		package «java.name».commands;
		
		import com.anfelisa.ace.DatabaseHandle;
		import com.anfelisa.ace.ViewProvider;
		import com.anfelisa.ace.IDaoProvider;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		«model.dataImport»
		
		public class «commandName» extends «abstractCommandName» {
		
			static final Logger LOG = LoggerFactory.getLogger(«commandName».class);
		
			public «commandName»(«model.dataParamType» commandData, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
			super(commandData, databaseHandle, daoProvider, viewProvider);
			}
		
			@Override
			protected void executeCommand() {
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
		
		import org.jdbi.v3.core.Handle;
		
		public abstract class Command<T extends IDataContainer> implements ICommand {
		
			protected T commandData;
			private String commandName;
			protected DatabaseHandle databaseHandle;
			protected JodaObjectMapper mapper;
			protected IDaoProvider daoProvider;
			protected ViewProvider viewProvider;
		
			public Command(String commandName, T commandData, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
				super();
				this.commandData = commandData;
				this.commandName = commandName;
				this.databaseHandle = databaseHandle;
				mapper = new JodaObjectMapper();
				this.daoProvider = daoProvider;
				this.viewProvider = viewProvider;
			}
		
			protected void executeCommand() {
			}
		
			public void execute() {
				this.executeCommand();
				daoProvider.addCommandToTimeline(this);
				this.publishEvents();
			}
		
			public IDataContainer getCommandData() {
				return commandData;
			}
		
			public String getCommandName() {
				return commandName;
			}
		
			public DatabaseHandle getDatabaseHandle() {
				return databaseHandle;
			}
		
			protected Handle getHandle() {
				if (databaseHandle != null) {
					return databaseHandle.getHandle();
				} else {
					throw new RuntimeException("no database handle");
				}
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
		
		public interface ICommand {
		
			String getCommandName();

			IDataContainer getCommandData();

			DatabaseHandle getDatabaseHandle();

			void initCommandData(String json);

			void execute();
		
			void publishEvents();
		}
		
	'''
	
}
