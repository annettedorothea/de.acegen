package de.acegen.generator.java;

import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.Model;
import de.acegen.extensions.java.AceExtension;
import de.acegen.extensions.java.JavaExtension;
import de.acegen.generator.ACEOutputConfigurationProvider;
import de.acegen.templates.java.models.Liquibase;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class LiquibaseGenerator {
  @Inject
  @Extension
  private JavaExtension _javaExtension;
  
  @Inject
  @Extension
  private AceExtension _aceExtension;
  
  @Inject
  private Liquibase liquibase;
  
  public void doGenerate(final HttpServer httpServer, final IFileSystemAccess2 fsa) {
    EList<Model> _models = httpServer.getModels();
    for (final Model modelAce : _models) {
      boolean _isPersistent = modelAce.isPersistent();
      if (_isPersistent) {
        boolean _isLiquibase = this._aceExtension.isLiquibase(httpServer);
        if (_isLiquibase) {
          String _packageFolder = this._javaExtension.packageFolder(httpServer);
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
