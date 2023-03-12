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


 

package de.acegen.generator

import de.acegen.aceGen.Project
import javax.inject.Inject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class AceGenGenerator extends AbstractGenerator {

	@Inject
	Es6Generator es6Generator;

	@Inject
	JavaGenerator javaGenerator;

	@Inject
	CsGenerator csGenerator;


	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		if (resource !== null && resource.contents !== null && resource.contents.size > 0) {
			val project = resource.contents.get(0) as Project

			if (project.httpClient !== null) {
				es6Generator.doGenerate(project.httpClient, fsa);
			} else if (project.httpServer !== null && project.httpServer.java) {
				javaGenerator.doGenerate(project.httpServer, fsa);
			} else if (project.httpServer !== null && project.httpServer.cs) {
				csGenerator.doGenerate(project.httpServer, fsa);
			}

		}

	}
}
	
	
/******* S.D.G. *******/
	
	
