/**
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
 */
package de.acegen.generator;

import de.acegen.aceGen.HttpClient;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.Project;
import de.acegen.generator.Es6Generator;
import de.acegen.generator.JavaGenerator;
import javax.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class AceGenGenerator extends AbstractGenerator {
  @Inject
  private Es6Generator es6Generator;
  
  @Inject
  private JavaGenerator javaGenerator;
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    if ((((resource != null) && (resource.getContents() != null)) && (resource.getContents().size() > 0))) {
      EObject _get = resource.getContents().get(0);
      final Project project = ((Project) _get);
      HttpClient _httpClient = project.getHttpClient();
      boolean _tripleNotEquals = (_httpClient != null);
      if (_tripleNotEquals) {
        this.es6Generator.doGenerate(project.getHttpClient(), fsa);
      } else {
        HttpServer _httpServer = project.getHttpServer();
        boolean _tripleNotEquals_1 = (_httpServer != null);
        if (_tripleNotEquals_1) {
          this.javaGenerator.doGenerate(project.getHttpServer(), fsa);
        }
      }
    }
  }
}
