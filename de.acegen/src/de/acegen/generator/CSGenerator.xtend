/* 
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 * 
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */


package de.acegen.generator

import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerAceWrite
import de.acegen.extensions.cs.AceExtension
import de.acegen.extensions.cs.CSExtension
import de.acegen.templates.cs.actions.Action
import de.acegen.templates.cs.commands.Command
import de.acegen.templates.cs.events.Event
import javax.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess2
import de.acegen.templates.cs.data.Data

class CSGenerator {

	@Inject
	Action action;

	@Inject
	Command command;

	@Inject
	Event event;

	@Inject
	Data data;

	@Inject
	extension CSExtension

	@Inject
	extension AceExtension

	def void doGenerate(HttpServer httpServer, IFileSystemAccess2 fsa) {
		for (ace : httpServer.aceOperations) {
			fsa.generateFile(httpServer.packageFolder + "/Actions/" + ace.abstractActionName + ".cs",
				ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, action.generateAbstractActionFile(ace, httpServer));
			fsa.generateFile(httpServer.packageFolder + "/Actions/" + ace.actionName + ".cs",
				ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT_ONCE,
				action.generateInitialActionFile(ace, httpServer));
			if (!"GET".equals(ace.getType)) {
				fsa.generateFile(httpServer.packageFolder + "/Commands/" + ace.abstractCommandName + ".cs",
					ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
					command.generateAbstractCommandFile(ace as HttpServerAceWrite, httpServer));
				fsa.generateFile(httpServer.packageFolder + "/Commands/" + ace.commandName + ".cs",
					ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT_ONCE,
					command.generateInitialCommandFile(ace as HttpServerAceWrite, httpServer));
				val aceWrite = ace as HttpServerAceWrite
				for (outcome : aceWrite.outcomes) {
					fsa.generateFile(httpServer.packageFolder + "/Events/" + ace.eventName(outcome) + ".cs",
						ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
						event.generateEventFile(ace, outcome, httpServer));
				}
			}
			if (ace.response.size > 0) {
				fsa.generateFile(httpServer.packageFolder + "/Data/" + ace.responseDataName + ".cs",
					ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, data.generateResponseData(ace, httpServer));
				fsa.generateFile(httpServer.packageFolder + "/Data/" + ace.responseDataInterfaceName + ".cs",
					ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
					data.generateReponseDataInterface(ace, httpServer));
			}
		}
		fsa.generateFile("Acegen/Action.cs", ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			action.generateAction());
		fsa.generateFile("Acegen/ReadAction.cs", ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			action.generateReadAction(false));
		fsa.generateFile("Acegen/ProxyReadAction.cs", ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			action.generateReadAction(true));
		fsa.generateFile("Acegen/WriteAction.cs", ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			action.generateWriteAction(false));
		fsa.generateFile("Acegen/ProxyWriteAction.cs", ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			action.generateWriteAction(true));
		fsa.generateFile("Acegen/HttpMethod.cs", ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			action.generateHttpMethod());
		fsa.generateFile("Acegen/IAction.cs", ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			action.generateIAction());

		fsa.generateFile("Acegen/IDataContainer.cs", ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT,
			data.generateIDataContainer());
	}

}
/******* S.D.G. *******/
