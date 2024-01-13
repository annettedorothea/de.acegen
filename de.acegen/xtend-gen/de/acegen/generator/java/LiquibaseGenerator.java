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
package de.acegen.generator.java;

import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.Model;
import de.acegen.extensions.java.TypeExtension;
import de.acegen.generator.ACEOutputConfigurationProvider;
import de.acegen.templates.java.models.Liquibase;
import jakarta.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class LiquibaseGenerator {
  @Inject
  @Extension
  private TypeExtension _typeExtension;

  @Inject
  private Liquibase liquibase;

  public void doGenerate(final HttpServer httpServer, final IFileSystemAccess2 fsa) {
    EList<Model> _models = httpServer.getModels();
    for (final Model modelAce : _models) {
      boolean _isPersistent = modelAce.isPersistent();
      if (_isPersistent) {
        boolean _isLiquibase = httpServer.isLiquibase();
        if (_isLiquibase) {
          String _packageFolder = this._typeExtension.packageFolder(httpServer);
          String _plus = (_packageFolder + "/");
          String _name = modelAce.getName();
          String _plus_1 = (_plus + _name);
          String _plus_2 = (_plus_1 + "_creation.xml");
          fsa.generateFile(_plus_2, 
            ACEOutputConfigurationProvider.DEFAULT_RESOURCE_OUTPUT, 
            this.liquibase.generateMigration(modelAce, httpServer));
        }
      }
    }
    fsa.generateFile("ace_creation.xml", ACEOutputConfigurationProvider.DEFAULT_RESOURCE_OUTPUT, 
      this.liquibase.generateAceMigration());
  }
}
