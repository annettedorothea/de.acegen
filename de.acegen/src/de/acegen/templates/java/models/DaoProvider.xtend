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


package de.acegen.templates.java.models

import de.acegen.extensions.CommonExtension
import javax.inject.Inject

class DaoProvider {

	@Inject
	extension CommonExtension
	
	def generateAbstractDaoProvider() '''
		«copyright»
		
		package de.acegen;
		
		public abstract class AbstractDaoProvider implements IDaoProvider {
		
			protected final AceDao aceDao = new AceDao();
		
			@Override
			public AceDao getAceDao() {
				return this.aceDao;
			}
			
		}
		
		
		«sdg»
		
	'''

	def generateDaoProvider() '''
		«copyright»
		
		package de.acegen;
		
		public class DaoProvider extends AbstractDaoProvider implements IDaoProvider {
			
			public static IDaoProvider create() {
				return new DaoProvider();
			}
			
			@Override
			public void truncateAllViews(PersistenceHandle handle) {
			}
			
		}
		
		
		«sdg»
		
	'''

	def generateIDaoProvider() '''
		«copyright»
		
		package de.acegen;
		
		public interface IDaoProvider {
			
			void truncateAllViews(PersistenceHandle handle);
			
			AceDao getAceDao();
		
		}
		
		
		«sdg»
		
	'''

	
}