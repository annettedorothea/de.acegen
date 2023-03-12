package de.acegen.generator;

import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.extensions.cs.TypeExtension;
import de.acegen.generator.cs.DotNetGenerator;
import de.acegen.generator.cs.EntityFrameworkGenerator;
import de.acegen.templates.cs.data.Data;
import de.acegen.templates.cs.models.Model;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class CsGenerator {
  @Inject
  private EntityFrameworkGenerator entityFrameworkGenerator;

  @Inject
  private DotNetGenerator dotNetGenerator;

  @Inject
  @Extension
  private TypeExtension _typeExtension;

  @Inject
  private Data data;

  @Inject
  private Model model;

  public void doGenerate(final HttpServer httpServer, final IFileSystemAccess2 fsa) {
    boolean _isEF = httpServer.isEF();
    if (_isEF) {
      this.entityFrameworkGenerator.doGenerate(httpServer, fsa);
    }
    boolean _isDotnet = httpServer.isDotnet();
    if (_isDotnet) {
      this.dotNetGenerator.doGenerate(httpServer, fsa);
    }
    EList<HttpServerAce> _aceOperations = httpServer.getAceOperations();
    for (final HttpServerAce ace : _aceOperations) {
      {
        int _size = ace.getResponse().size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          CharSequence _dataDirectory = this._typeExtension.dataDirectory(httpServer);
          String _plus = (_dataDirectory + "/");
          CharSequence _responseDataName = this._typeExtension.responseDataName(ace);
          String _plus_1 = (_plus + _responseDataName);
          String _plus_2 = (_plus_1 + ".cs");
          fsa.generateFile(_plus_2, 
            ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, this.data.generateResponseData(ace, httpServer));
        }
        int _size_1 = ace.getPayload().size();
        boolean _greaterThan_1 = (_size_1 > 0);
        if (_greaterThan_1) {
          CharSequence _dataDirectory_1 = this._typeExtension.dataDirectory(httpServer);
          String _plus_3 = (_dataDirectory_1 + "/");
          CharSequence _payloadDataName = this._typeExtension.payloadDataName(ace);
          String _plus_4 = (_plus_3 + _payloadDataName);
          String _plus_5 = (_plus_4 + ".cs");
          fsa.generateFile(_plus_5, 
            ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, this.data.generatePayloadData(ace, httpServer));
        }
      }
    }
    EList<de.acegen.aceGen.Model> _models = httpServer.getModels();
    for (final de.acegen.aceGen.Model modelAce : _models) {
      CharSequence _modelDirectory = this._typeExtension.modelDirectory(httpServer);
      String _plus = (_modelDirectory + "/");
      String _modelClassName = this._typeExtension.modelClassName(modelAce);
      String _plus_1 = (_plus + _modelClassName);
      String _plus_2 = (_plus_1 + ".cs");
      fsa.generateFile(_plus_2, 
        ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, this.model.generateClass(modelAce, httpServer));
    }
    CharSequence _acegenDirectory = this._typeExtension.acegenDirectory(httpServer);
    String _plus_3 = (_acegenDirectory + "/AbstractModel.cs");
    fsa.generateFile(_plus_3, ACEOutputConfigurationProvider.DEFAULT_CS_OUTPUT, 
      this.model.generateAbstractModel(httpServer));
  }
}
