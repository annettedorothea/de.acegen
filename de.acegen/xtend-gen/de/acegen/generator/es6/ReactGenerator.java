package de.acegen.generator.es6;

import de.acegen.aceGen.ClientAttribute;
import de.acegen.aceGen.HttpClient;
import de.acegen.extensions.es6.Es6Extension;
import de.acegen.generator.ACEOutputConfigurationProvider;
import de.acegen.templates.es6.JsxTemplate;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ReactGenerator {
  @Inject
  private JsxTemplate reactTemplate;
  
  @Inject
  @Extension
  private Es6Extension _es6Extension;
  
  public void doGenerate(final HttpClient httpClient, final IFileSystemAccess2 fsa) {
    ClientAttribute _container = httpClient.getContainer();
    boolean _tripleNotEquals = (_container != null);
    if (_tripleNotEquals) {
      this.doGenerate(httpClient.getContainer(), fsa, "", false);
    }
  }
  
  public void doGenerate(final ClientAttribute it, final IFileSystemAccess2 fsa, final String subFolder, final boolean isGroupedChild) {
    if (((!it.isNoComponent()) && ((it.getAttributes().size() > 0) || isGroupedChild))) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("components");
      _builder.append(subFolder);
      _builder.append("/");
      String _componentName = this._es6Extension.componentName(it);
      _builder.append(_componentName);
      _builder.append(".js");
      fsa.generateFile(_builder.toString(), 
        ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE, 
        this.reactTemplate.generateComponentStruct(it, this.folderPrefix(subFolder)));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(subFolder);
      _builder_1.append("/");
      String _firstLower = StringExtensions.toFirstLower(it.getName());
      _builder_1.append(_firstLower);
      final String nextSubFolder = _builder_1.toString();
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
