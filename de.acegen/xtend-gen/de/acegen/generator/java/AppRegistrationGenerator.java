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
import de.acegen.extensions.java.JavaHttpServerExtension;
import de.acegen.generator.ACEOutputConfigurationProvider;
import de.acegen.templates.java.AppRegistration;
import javax.inject.Inject;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class AppRegistrationGenerator {
  @Inject
  private AppRegistration appRegistration;

  @Inject
  @Extension
  private JavaHttpServerExtension _javaHttpServerExtension;

  public void doGenerate(final HttpServer httpServer, final IFileSystemAccess2 fsa) {
    int _size = httpServer.getAceOperations().size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      String _packageFolder = this._javaHttpServerExtension.packageFolder(httpServer);
      String _plus = (_packageFolder + "/AppRegistration.java");
      fsa.generateFile(_plus, 
        ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
        this.appRegistration.generateAppRegistration(httpServer));
    }
    fsa.generateFile("de/acegen/AppRegistration.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, 
      this.appRegistration.generateAppRegistration());
  }
}
