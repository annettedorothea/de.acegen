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

class Persistence {

	extension CommonExtension
	
	def generatePersistenceHandle() '''
		«copyright»

		package de.acegen;
		
		import org.jdbi.v3.core.Handle;
		
		public class PersistenceHandle {
			
			private Handle handle;
		
			public PersistenceHandle(Handle handle) {
				super();
				this.handle = handle;
			}
		
			public Handle getHandle() {
				return handle;
			}
		
		}
		
		«sdg»
		
	'''

	def generatePersistenceConnection() '''
		«copyright»

		package de.acegen;
		
		import org.jdbi.v3.core.Jdbi;
		
		public class PersistenceConnection {
		
			private Jdbi jdbi;
		
			public PersistenceConnection(Jdbi jdbi) {
				super();
				this.jdbi = jdbi;
			}
		
			public Jdbi getJdbi() {
				return jdbi;
			}
			
		}
		
		«sdg»
		
	'''

	
}