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
	CSGenerator csGenerator;

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		if (resource !== null && resource.contents !== null && resource.contents.size > 0) {
			val project = resource.contents.get(0) as Project

			if (project.httpClient !== null) {
				es6Generator.doGenerate(project.httpClient, fsa);
			} else if (project.httpServer !== null) {
				if (project.httpServer.language == "Java") {
					javaGenerator.doGenerate(project.httpServer, fsa);
				} else if (project.httpServer.language == "C#") {
					csGenerator.doGenerate(project.httpServer, fsa);
				}
			}

		}

	}
}
	
	
/******* S.D.G. *******/
	
	
