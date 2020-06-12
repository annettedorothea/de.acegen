package de.acegen.generator.java;

import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.Model;
import de.acegen.extensions.java.JavaExtension;
import de.acegen.extensions.java.ModelExtension;
import de.acegen.generator.ACEOutputConfigurationProvider;
import de.acegen.templates.java.models.JDBI3Dao;
import de.acegen.templates.java.models.JDBI3Mapper;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class JDBI3Generator {
  @Inject
  private JDBI3Dao jdbi3Dao;
  
  @Inject
  private JDBI3Mapper jdbi3Mapper;
  
  @Inject
  @Extension
  private JavaExtension _javaExtension;
  
  @Inject
  @Extension
  private ModelExtension _modelExtension;
  
  public void doGenerate(final HttpServer httpServer, final IFileSystemAccess2 fsa) {
    EList<Model> _models = httpServer.getModels();
    for (final Model modelAce : _models) {
      {
        String _packageFolder = this._javaExtension.packageFolder(httpServer);
        String _plus = (_packageFolder + "/models/");
        String _modelMapper = this._modelExtension.modelMapper(modelAce);
        String _plus_1 = (_plus + _modelMapper);
        String _plus_2 = (_plus_1 + ".java");
        fsa.generateFile(_plus_2, 
          ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, this.jdbi3Mapper.generate(modelAce, httpServer));
        boolean _isPersistent = modelAce.isPersistent();
        if (_isPersistent) {
          String _packageFolder_1 = this._javaExtension.packageFolder(httpServer);
          String _plus_3 = (_packageFolder_1 + "/models/");
          String _abstractModelDao = this._modelExtension.abstractModelDao(modelAce);
          String _plus_4 = (_plus_3 + _abstractModelDao);
          String _plus_5 = (_plus_4 + ".java");
          fsa.generateFile(_plus_5, 
            ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, 
            this.jdbi3Dao.generateAbstractJdbiDao(modelAce, httpServer));
          String _packageFolder_2 = this._javaExtension.packageFolder(httpServer);
          String _plus_6 = (_packageFolder_2 + "/models/");
          String _modelDao = this._modelExtension.modelDao(modelAce);
          String _plus_7 = (_plus_6 + _modelDao);
          String _plus_8 = (_plus_7 + ".java");
          fsa.generateFile(_plus_8, 
            ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, 
            this.jdbi3Dao.generateJdbiDao(modelAce, httpServer));
        }
      }
    }
  }
}
