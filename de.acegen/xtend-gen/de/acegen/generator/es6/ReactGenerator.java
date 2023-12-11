package de.acegen.generator.es6;

import de.acegen.aceGen.ClientAttribute;
import de.acegen.aceGen.HttpClient;
import de.acegen.extensions.es6.Es6Extension;
import de.acegen.generator.ACEOutputConfigurationProvider;
import de.acegen.templates.es6.JsxTemplate;
import jakarta.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ReactGenerator {
  @Inject
  private JsxTemplate reactTemplate;

  @Extension
  private Es6Extension _es6Extension;

  public void doGenerate(final HttpClient httpClient, final IFileSystemAccess2 fsa) {
    ClientAttribute _container = httpClient.getContainer();
    boolean _tripleNotEquals = (_container != null);
    if (_tripleNotEquals) {
      this.doGenerate(httpClient.getContainer(), fsa, "", true);
    }
  }

  public void doGenerate(final ClientAttribute it, final IFileSystemAccess2 fsa, final String subFolder, final boolean isRoot) {
    Boolean _isComponent = this._es6Extension.isComponent(it);
    if ((_isComponent).booleanValue()) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("components");
      _builder.append(subFolder);
      _builder.append("/");
      String _componentName = this._es6Extension.componentName(it);
      _builder.append(_componentName);
      _builder.append(".js");
      fsa.generateFile(_builder.toString(), 
        ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE, 
        this.reactTemplate.generateComponent(it, this.folderPrefix(subFolder)));
      Boolean _isTag = this._es6Extension.isTag(it);
      boolean _not = (!(_isTag).booleanValue());
      if (_not) {
        if (isRoot) {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("components");
          _builder_1.append(subFolder);
          _builder_1.append("/");
          String _componentContainerName = this._es6Extension.componentContainerName(it);
          _builder_1.append(_componentContainerName);
          _builder_1.append(".js");
          fsa.generateFile(_builder_1.toString(), 
            IFileSystemAccess.DEFAULT_OUTPUT, 
            this.reactTemplate.generateComponentContainer(it, this.folderPrefix(subFolder), true));
        } else {
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("components");
          _builder_2.append(subFolder);
          _builder_2.append("/");
          String _componentContainerName_1 = this._es6Extension.componentContainerName(it);
          _builder_2.append(_componentContainerName_1);
          _builder_2.append(".js");
          fsa.generateFile(_builder_2.toString(), 
            IFileSystemAccess.DEFAULT_OUTPUT, 
            this.reactTemplate.generateComponentContainer(it, this.folderPrefix(subFolder), false));
        }
      }
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append(subFolder);
      _builder_3.append("/");
      String _firstLower = StringExtensions.toFirstLower(it.getName());
      _builder_3.append(_firstLower);
      final String nextSubFolder = _builder_3.toString();
      EList<ClientAttribute> _attributes = it.getAttributes();
      for (final ClientAttribute attribute : _attributes) {
        this.doGenerate(attribute, fsa, nextSubFolder, false);
      }
    }
  }

  private String folderPrefix(final String subFolder) {
    int _length = subFolder.split("/").length;
    final int count = (_length - 1);
    String folderPrefix = "";
    for (int i = 0; (i < count); i++) {
      String _folderPrefix = folderPrefix;
      folderPrefix = (_folderPrefix + "../");
    }
    return folderPrefix;
  }
}
