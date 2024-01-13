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


package de.acegen.generator.java

import de.acegen.aceGen.HttpServer
import de.acegen.extensions.java.TypeExtension
import de.acegen.generator.ACEOutputConfigurationProvider
import de.acegen.templates.java.models.JDBI3Dao
import de.acegen.templates.java.models.JDBI3Mapper
import javax.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess2

class JDBI3Generator {

	@Inject
	JDBI3Dao jdbi3Dao;

	@Inject
	JDBI3Mapper jdbi3Mapper;

	@Inject
	extension TypeExtension

	def void doGenerate(HttpServer httpServer, IFileSystemAccess2 fsa) {
		fsa.generateFile('de/acegen/AbstractMapper.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, jdbi3Mapper.generateAbstractMapper(httpServer));
		for (modelAce : httpServer.models) {
			fsa.generateFile(httpServer.packageFolder + '/models/' + modelAce.modelMapper + '.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, jdbi3Mapper.generate(modelAce, httpServer));
			if (modelAce.persistent) {
				fsa.generateFile(httpServer.packageFolder + '/models/' + modelAce.abstractModelDao + '.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
					jdbi3Dao.generateAbstractJdbiDao(modelAce, httpServer));
				fsa.generateFile(httpServer.packageFolder + '/models/' + modelAce.modelDao + '.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE,
					jdbi3Dao.generateJdbiDao(modelAce, httpServer));
			}
		}

	}

}
