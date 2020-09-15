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


package de.acegen.templates.java

import de.acegen.extensions.CommonExtension
import javax.inject.Inject

class DropwizardResource {

	@Inject
	extension CommonExtension

	def generateDropwizardResource() '''
		«copyright»
		
		package de.acegen;
		
		import javax.ws.rs.core.Response;
		
		public abstract class Resource {
			

			protected Response ok() {
				return Response.status(Response.Status.OK).build();
			}
			
			protected Response badRequest(String message) {
				return Response.status(Response.Status.BAD_REQUEST).entity(message).build();
			}
			
			protected Response unauthorized() {
				return Response.status(Response.Status.UNAUTHORIZED).build();
			}
			
			protected Response internalServerError(Exception x) {
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
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(message).build();
			}
		}
		
		«sdg»
	'''

	
}