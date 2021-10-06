package de.acegen.templates.es6;

import de.acegen.aceGen.ClientAttribute;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.es6.Es6Extension;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class JsxTemplate {
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  @Inject
  @Extension
  private Es6Extension _es6Extension;
  
  public CharSequence generateComponentStruct(final ClientAttribute it, final String folderPrefix) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import React from \"react\";");
    _builder.newLine();
    _builder.newLine();
    CharSequence _componentImports = this.componentImports(it, "");
    _builder.append(_componentImports);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("export const ");
    String _componentName = this._es6Extension.componentName(it);
    _builder.append(_componentName);
    _builder.append(" = (props) => {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("const json = JSON.stringify(props, null, \'\\t\');");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return <div>");
    _builder.newLine();
    {
      EList<ClientAttribute> _attributes = it.getAttributes();
      for(final ClientAttribute attribute : _attributes) {
        _builder.append("\t\t");
        CharSequence _renderChild = this.renderChild(attribute);
        _builder.append(_renderChild, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("<pre>{json}</pre>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</div> ");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence renderChild(final ClientAttribute it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (((!it.isNoComponent()) && (it.getAttributes().size() > 0))) {
        {
          boolean _isList = it.isList();
          if (_isList) {
            _builder.append("{ props.");
            String _name = it.getName();
            _builder.append(_name);
            _builder.append(" ? props.");
            String _name_1 = it.getName();
            _builder.append(_name_1);
            _builder.append(".map(i => <");
            String _componentName = this._es6Extension.componentName(it);
            _builder.append(_componentName);
            _builder.append(" {...i} />) : [] }");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("<");
            String _componentName_1 = this._es6Extension.componentName(it);
            _builder.append(_componentName_1);
            _builder.append(" {...props.");
            String _firstLower = StringExtensions.toFirstLower(it.getName());
            _builder.append(_firstLower);
            _builder.append("} />");
            _builder.newLineIfNotEmpty();
          }
        }
      } else {
        if ((it.isNoComponent() && (it.getAttributes().size() > 0))) {
          _builder.append("{props.");
          String _firstLower_1 = StringExtensions.toFirstLower(it.getName());
          _builder.append(_firstLower_1);
          _builder.append(" && <div>");
          _builder.newLineIfNotEmpty();
          {
            EList<ClientAttribute> _attributes = it.getAttributes();
            for(final ClientAttribute attribute : _attributes) {
              _builder.append("\t");
              _builder.append("<div>{props.");
              String _firstLower_2 = StringExtensions.toFirstLower(it.getName());
              _builder.append(_firstLower_2, "\t");
              _builder.append(".");
              String _firstLower_3 = StringExtensions.toFirstLower(attribute.getName());
              _builder.append(_firstLower_3, "\t");
              _builder.append("}</div>");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("</div>}");
          _builder.newLine();
        } else {
          _builder.append("<div>{props.");
          String _firstLower_4 = StringExtensions.toFirstLower(it.getName());
          _builder.append(_firstLower_4);
          _builder.append("}</div>");
          _builder.newLineIfNotEmpty();
        }
      }
    }
    return _builder;
  }
  
  public CharSequence componentImports(final ClientAttribute it, final String subFolder) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<ClientAttribute> _attributes = it.getAttributes();
      for(final ClientAttribute attribute : _attributes) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append(subFolder);
        _builder_1.append("/");
        String _firstLower = StringExtensions.toFirstLower(it.getName());
        _builder_1.append(_firstLower);
        String _importComponent = this._es6Extension.importComponent(attribute, _builder_1.toString());
        _builder.append(_importComponent);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
}
