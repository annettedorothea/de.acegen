package de.acegen.generator.cs;

import de.acegen.aceGen.AuthUser;
import de.acegen.aceGen.HttpServer;
import de.acegen.extensions.cs.TypeExtension;
import de.acegen.generator.ACEOutputConfigurationProvider;
import de.acegen.templates.cs.Controller;
import javax.inject.Inject;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class DotNetGenerator {
  @Inject
  private Controller controller;

  @Inject
  @Extension
  private TypeExtension _typeExtension;

  public void doGenerate(final HttpServer httpServer, final IFileSystemAccess2 fsa) {
    AuthUser authUser = httpServer.getAuthUser();
    if ((authUser == null)) {
      authUser = httpServer.getAuthUserRef();
    }
    CharSequence _controllerDirectory = this._typeExtension.controllerDirectory(httpServer);
    String _plus = (_controllerDirectory + "/");
    CharSequence _controllerName = this._typeExtension.controllerName(httpServer);
    String _plus_1 = (_plus + _controllerName);
    String _plus_2 = (_plus_1 + ".cs");
    fsa.generateFile(_plus_2, 
      ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, this.controller.generate(httpServer, authUser));
    this.controller.generate(httpServer, authUser);
  }
}
