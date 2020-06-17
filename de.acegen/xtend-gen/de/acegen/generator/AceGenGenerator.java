/**
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 * 
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */
package de.acegen.generator;

import com.google.common.base.Objects;
import de.acegen.aceGen.HttpClient;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.Project;
import de.acegen.generator.CSGenerator;
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
  
  @Inject
  private CSGenerator csGenerator;
  
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
          String _language = project.getHttpServer().getLanguage();
          boolean _equals = Objects.equal(_language, "Java");
          if (_equals) {
            this.javaGenerator.doGenerate(project.getHttpServer(), fsa);
          } else {
            String _language_1 = project.getHttpServer().getLanguage();
            boolean _equals_1 = Objects.equal(_language_1, "C#");
            if (_equals_1) {
              this.csGenerator.doGenerate(project.getHttpServer(), fsa);
            }
          }
        }
      }
    }
  }
}
