package de.acegen.generator.java;

import de.acegen.aceGen.HttpServer;
import de.acegen.extensions.java.JavaExtension;
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
  private JavaExtension _javaExtension;
  
  public void doGenerate(final HttpServer httpServer, final IFileSystemAccess2 fsa) {
    String _packageFolder = this._javaExtension.packageFolder(httpServer);
    String _plus = (_packageFolder + "/AppRegistration.java");
    fsa.generateFile(_plus, 
      ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.appRegistration.generateAppRegistration(httpServer));
    fsa.generateFile("de/acegen/AppRegistration.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, 
      this.appRegistration.generateAppRegistration());
  }
}
