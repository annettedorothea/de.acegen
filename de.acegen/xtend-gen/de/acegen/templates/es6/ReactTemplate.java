package de.acegen.templates.es6;

import de.acegen.aceGen.ClientAttribute;
import de.acegen.aceGen.GroupedClientAttribute;
import de.acegen.aceGen.HttpClient;
import de.acegen.aceGen.SingleClientAttribute;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.es6.Es6Extension;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ReactTemplate {
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  @Inject
  @Extension
  private Es6Extension _es6Extension;
  
  protected CharSequence _generateComponent(final SingleClientAttribute it, final String subFolder, final String folderPrefix) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import React, {useState} from \'react\';");
    _builder.newLine();
    _builder.append("import { uiElement } from \"");
    _builder.append(folderPrefix);
    _builder.append("../../src/components");
    _builder.append(subFolder);
    _builder.append("/");
    String _componentName = this._es6Extension.componentName(it);
    _builder.append(_componentName);
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      boolean _isList = it.isList();
      boolean _not = (!_isList);
      if (_not) {
        _builder.append("export const set");
        String _componentName_1 = this._es6Extension.componentName(it);
        _builder.append(_componentName_1);
        _builder.append("State = (newState) => {");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("if (functions.setState) {");
        _builder.newLine();
        _builder.append("        ");
        _builder.append("functions.setState(newState);");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("let functions = {};");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("export const ");
    String _reactComponentName = this._es6Extension.reactComponentName(it);
    _builder.append(_reactComponentName);
    _builder.append(" = (props) => {");
    _builder.newLineIfNotEmpty();
    {
      boolean _isList_1 = it.isList();
      boolean _not_1 = (!_isList_1);
      if (_not_1) {
        _builder.append("\t");
        _builder.append("const [state, setState] = useState();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("functions.setState = setState;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("return uiElement({...props, ...state});");
        _builder.newLine();
      } else {
        _builder.append("\t");
        _builder.append("return uiElement({...props});");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _generateComponent(final GroupedClientAttribute it, final String subFolder, final String folderPrefix) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import React, {useState} from \'react\';");
    _builder.newLine();
    _builder.append("import { uiElement } from \"");
    _builder.append(folderPrefix);
    _builder.append("../../src/components");
    _builder.append(subFolder);
    _builder.append("/");
    String _componentName = this._es6Extension.componentName(it);
    _builder.append(_componentName);
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("export const set");
    String _componentName_1 = this._es6Extension.componentName(it);
    _builder.append(_componentName_1);
    _builder.append("State = (newState) => {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("if (functions.setState) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("functions.setState(newState);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("let functions = {};");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export const ");
    String _reactComponentName = this._es6Extension.reactComponentName(it);
    _builder.append(_reactComponentName);
    _builder.append(" = (props) => {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("const [state, setState] = useState();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("functions.setState = setState;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return uiElement({...props, ...state});");
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
  
  protected CharSequence _generateComponentStruct(final SingleClientAttribute it, final String folderPrefix, final List<SingleClientAttribute> passOnAttributes) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    this.addPassOnAttributes(passOnAttributes, it.getAttributes());
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import { div, h1, label, input, table, tbody, ul, li, tr, td");
    {
      final Function1<ClientAttribute, Boolean> _function = new Function1<ClientAttribute, Boolean>() {
        public Boolean apply(final ClientAttribute a) {
          return Boolean.valueOf((((a instanceof SingleClientAttribute) && (((SingleClientAttribute) a).getAttributes().size() > 0)) || (a instanceof GroupedClientAttribute)));
        }
      };
      Iterable<ClientAttribute> _filter = IterableExtensions.<ClientAttribute>filter(it.getAttributes(), _function);
      boolean _hasElements = false;
      for(final ClientAttribute attribute : _filter) {
        if (!_hasElements) {
          _hasElements = true;
          _builder.append(",");
        } else {
          _builder.appendImmediate(",", "");
        }
        _builder.append(" ");
        String _reactTagName = this._es6Extension.reactTagName(attribute);
        _builder.append(_reactTagName);
      }
    }
    _builder.append(" } from \"");
    _builder.append(folderPrefix);
    _builder.append("../../gen/components/ReactHelper\";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("export function uiElement(attributes) {");
    _builder.newLine();
    {
      boolean _isList = it.isList();
      if (_isList) {
        _builder.append("\t");
        _builder.append("return tr({class: \"\"}, [");
        _builder.newLine();
        {
          EList<ClientAttribute> _attributes = it.getAttributes();
          boolean _hasElements_1 = false;
          for(final ClientAttribute attribute_1 : _attributes) {
            if (!_hasElements_1) {
              _hasElements_1 = true;
            } else {
              _builder.appendImmediate(",", "\t\t");
            }
            _builder.append("\t");
            _builder.append("\t");
            CharSequence _generateChild = this.generateChild(attribute_1, "td", passOnAttributes);
            _builder.append(_generateChild, "\t\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("]);");
        _builder.newLine();
      } else {
        _builder.append("\t");
        _builder.append("return div({}, [");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("h1({}, [\"");
        String _upperCase = it.getName().toUpperCase();
        _builder.append(_upperCase, "\t\t");
        _builder.append("\"])");
        {
          int _size = it.getAttributes().size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            _builder.append(",");
          }
        }
        _builder.newLineIfNotEmpty();
        {
          EList<ClientAttribute> _attributes_1 = it.getAttributes();
          boolean _hasElements_2 = false;
          for(final ClientAttribute attribute_2 : _attributes_1) {
            if (!_hasElements_2) {
              _hasElements_2 = true;
            } else {
              _builder.appendImmediate(",", "\t\t");
            }
            _builder.append("\t");
            _builder.append("\t");
            CharSequence _generateChild_1 = this.generateChild(attribute_2, "div", passOnAttributes);
            _builder.append(_generateChild_1, "\t\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("]);");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  private void addPassOnAttributes(final List<SingleClientAttribute> passOnAttributes, final List<ClientAttribute> attributes) {
    for (final ClientAttribute attribute : attributes) {
      if ((attribute instanceof SingleClientAttribute)) {
        boolean _isPassOn = ((SingleClientAttribute)attribute).isPassOn();
        if (_isPassOn) {
          passOnAttributes.add(((SingleClientAttribute)attribute));
        }
      }
    }
  }
  
  protected CharSequence _generateComponentStruct(final GroupedClientAttribute it, final String folderPrefix, final List<SingleClientAttribute> passOnAttributes) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import { ");
    {
      EList<ClientAttribute> _attributeGroup = it.getAttributeGroup();
      boolean _hasElements = false;
      for(final ClientAttribute attribute : _attributeGroup) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "");
        }
        _builder.append(" ");
        String _reactTagName = this._es6Extension.reactTagName(attribute);
        _builder.append(_reactTagName);
      }
    }
    _builder.append("} from \"");
    _builder.append(folderPrefix);
    _builder.append("../../gen/components/ReactHelper\";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("export function uiElement(attributes) {");
    _builder.newLine();
    {
      EList<ClientAttribute> _attributeGroup_1 = it.getAttributeGroup();
      for(final ClientAttribute attribute_1 : _attributeGroup_1) {
        _builder.append("\t");
        _builder.append("if (attributes.is");
        String _firstUpper = StringExtensions.toFirstUpper(attribute_1.getName());
        _builder.append(_firstUpper, "\t");
        _builder.append(" === true) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return ");
        String _reactTagName_1 = this._es6Extension.reactTagName(attribute_1);
        _builder.append(_reactTagName_1, "\t\t");
        _builder.append("(attributes);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("return null;");
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
  
  protected CharSequence _generateChild(final SingleClientAttribute it, final String enclosingTag, final List<SingleClientAttribute> passOnAttributes) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (((!it.isStorage()) && (!it.isHash()))) {
        {
          boolean _isList = it.isList();
          if (_isList) {
            _builder.append(enclosingTag);
            _builder.append("({}, [");
            _builder.newLineIfNotEmpty();
            {
              int _size = it.getAttributes().size();
              boolean _greaterThan = (_size > 1);
              if (_greaterThan) {
                _builder.append("\t");
                _builder.append("table({class: \"\"}, [");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("tbody({}, [");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t\t");
                _builder.append("attributes.");
                String _firstLower = StringExtensions.toFirstLower(it.getName());
                _builder.append(_firstLower, "\t\t\t");
                _builder.append(".map((item) => ");
                CharSequence _reactTagCall = this.reactTagCall(it, "item", passOnAttributes);
                _builder.append(_reactTagCall, "\t\t\t");
                _builder.append(")");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("])");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("])");
                _builder.newLine();
              } else {
                _builder.append("\t");
                _builder.append("ul({class: \"\"}, [");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("attributes.");
                String _firstLower_1 = StringExtensions.toFirstLower(it.getName());
                _builder.append(_firstLower_1, "\t\t");
                _builder.append(".map((item) => li({}, [item]))");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("])");
                _builder.newLine();
              }
            }
            _builder.append("])");
            _builder.newLine();
          } else {
            if ((((it.getAttributes().size() == 0) && (!it.isStorage())) && (!it.isHash()))) {
              _builder.append(enclosingTag);
              _builder.append("({class: \"\"}, [");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("label({");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("class: \"\",");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("htmlFor: \"");
              String _name = it.getName();
              _builder.append(_name, "\t\t");
              _builder.append("\"");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("}, [\"");
              String _upperCase = it.getName().toUpperCase();
              _builder.append(_upperCase, "\t");
              _builder.append("\"]), ");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("input({");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("id: \"");
              String _name_1 = it.getName();
              _builder.append(_name_1, "\t\t");
              _builder.append("\",");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("value: attributes.");
              String _name_2 = it.getName();
              _builder.append(_name_2, "\t\t");
              _builder.append(", ");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("class: \"\", ");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("onChange:(e) => console.log(e.target.value),");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("type: \"text\"");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("}), ");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("div({class: \"\"}, [attributes.");
              String _name_3 = it.getName();
              _builder.append(_name_3, "\t");
              _builder.append("])");
              _builder.newLineIfNotEmpty();
              _builder.append("])");
              _builder.newLine();
            } else {
              CharSequence _reactTagCall_1 = this.reactTagCall(it, "attributes", passOnAttributes);
              _builder.append(_reactTagCall_1);
              _builder.newLineIfNotEmpty();
            }
          }
        }
      } else {
        _builder.append("// ");
        String _xifexpression = null;
        boolean _isStorage = it.isStorage();
        if (_isStorage) {
          _xifexpression = "storage";
        } else {
          _xifexpression = "";
        }
        _builder.append(_xifexpression);
        String _xifexpression_1 = null;
        boolean _isHash = it.isHash();
        if (_isHash) {
          _xifexpression_1 = "hash";
        } else {
          _xifexpression_1 = "";
        }
        _builder.append(_xifexpression_1);
        _builder.append(" ");
        String _name_4 = it.getName();
        _builder.append(_name_4);
        _builder.append(" ");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  protected CharSequence _generateChild(final GroupedClientAttribute it, final String enclosingTag, final List<SingleClientAttribute> passOnAttributes) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _reactTagCall = this.reactTagCall(it, "attributes", passOnAttributes);
    _builder.append(_reactTagCall);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence reactTagCall(final ClientAttribute it, final String props, final List<SingleClientAttribute> passOnAttributes) {
    StringConcatenation _builder = new StringConcatenation();
    {
      int _size = passOnAttributes.size();
      boolean _tripleEquals = (_size == 0);
      if (_tripleEquals) {
        String _reactTagName = this._es6Extension.reactTagName(it);
        _builder.append(_reactTagName);
        _builder.append("(");
        _builder.append(props);
        _builder.append(")");
      } else {
        String _reactTagName_1 = this._es6Extension.reactTagName(it);
        _builder.append(_reactTagName_1);
        _builder.append("({ ...");
        _builder.append(props);
        _builder.append(".mainView");
        {
          boolean _hasElements = false;
          for(final SingleClientAttribute attribute : passOnAttributes) {
            if (!_hasElements) {
              _hasElements = true;
              _builder.append(",");
            } else {
              _builder.appendImmediate(",", "");
            }
            _builder.append(" ");
            String _firstLower = StringExtensions.toFirstLower(attribute.getName());
            _builder.append(_firstLower);
            _builder.append(": ");
            _builder.append(props);
            _builder.append(".");
            String _firstLower_1 = StringExtensions.toFirstLower(attribute.getName());
            _builder.append(_firstLower_1);
          }
        }
        _builder.append(" })");
      }
    }
    return _builder;
  }
  
  public CharSequence generateReactHelper(final HttpClient httpClient) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import React from \'react\';");
    _builder.newLine();
    {
      EList<ClientAttribute> _attributes = httpClient.getContainer().getAttributes();
      for(final ClientAttribute attribute : _attributes) {
        String _firstLower = StringExtensions.toFirstLower(httpClient.getContainer().getName());
        String _plus = ("/" + _firstLower);
        CharSequence _componentImports = this.componentImports(attribute, _plus);
        _builder.append(_componentImports);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("const normalize = (options) => {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if (options && options.class !== undefined) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("options.className = options.class");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("delete options.class;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if (options && options.id) {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("options.key = options.id;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return options;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export const generic = (type, options, children) => {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return React.createElement(");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("type,");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("normalize(options),");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("children ? [...children] : undefined");
    _builder.newLine();
    _builder.append("    ");
    _builder.append(")");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export const br = () => {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return generic(\"br\");");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export const hr = () => {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return generic(\"hr\");");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export const p = (options, children) => {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return generic(\"p\", options, children);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export const ul = (options, children) => {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return generic(\"ul\", options, children);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export const ol = (options, children) => {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return generic(\"ol\", options, children);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export const li = (options, children) => {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return generic(\"li\", options, children);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export const label = (options, children) => {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return generic(\"label\", options, children);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export const button = (options, children) => {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return generic(\"button\", options, children);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export const div = (options, children) => {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return generic(\"div\", options, children);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export const span = (options, children) => {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return generic(\"span\", options, children);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export const a = (options, children) => {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return generic(\"a\", options, children);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export const h1 = (options, children) => {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return generic(\"h1\", options, children);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export const h2 = (options, children) => {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return generic(\"h2\", options, children);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export const h3 = (options, children) => {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return generic(\"h3\", options, children);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export const h4 = (options, children) => {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return generic(\"h4\", options, children);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export const h5 = (options, children) => {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return generic(\"h5\", options, children);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export const h6 = (options, children) => {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return generic(\"h6\", options, children);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export const pre = (options, children) => {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return generic(\"pre\", options, children);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export const table = (options, children) => {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return generic(\"table\", options, children);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export const tbody = (options, children) => {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return generic(\"tbody\", options, children);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export const tr = (options, children) => {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return generic(\"tr\", options, children);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export const td = (options, children) => {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return generic(\"td\", options, children);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export const i = (options, children) => {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return generic(\"i\", options, children);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export const input = (options) => {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return <input {...normalize(options)}/>");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    {
      EList<ClientAttribute> _attributes_1 = httpClient.getContainer().getAttributes();
      for(final ClientAttribute attribute_1 : _attributes_1) {
        CharSequence _components = this.components(attribute_1, false);
        _builder.append(_components);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _componentImports(final SingleClientAttribute it, final String subFolder) {
    StringConcatenation _builder = new StringConcatenation();
    {
      int _size = it.getAttributes().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _builder.append("import { ");
        String _reactComponentName = this._es6Extension.reactComponentName(it);
        _builder.append(_reactComponentName);
        _builder.append(" } from \".");
        _builder.append(subFolder);
        _builder.append("/");
        String _reactComponentName_1 = this._es6Extension.reactComponentName(it);
        _builder.append(_reactComponentName_1);
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
        {
          EList<ClientAttribute> _attributes = it.getAttributes();
          for(final ClientAttribute attribute : _attributes) {
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append(subFolder);
            _builder_1.append("/");
            String _firstLower = StringExtensions.toFirstLower(it.getName());
            _builder_1.append(_firstLower);
            CharSequence _componentImports = this.componentImports(attribute, _builder_1.toString());
            _builder.append(_componentImports);
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  protected CharSequence _componentImports(final GroupedClientAttribute it, final String subFolder) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import { ");
    String _reactComponentName = this._es6Extension.reactComponentName(it);
    _builder.append(_reactComponentName);
    _builder.append(" } from \".");
    _builder.append(subFolder);
    _builder.append("/");
    String _reactComponentName_1 = this._es6Extension.reactComponentName(it);
    _builder.append(_reactComponentName_1);
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    {
      int _size = it.getAttributeGroup().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        {
          EList<ClientAttribute> _attributeGroup = it.getAttributeGroup();
          for(final ClientAttribute attribute : _attributeGroup) {
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append(subFolder);
            _builder_1.append("/");
            String _firstLower = StringExtensions.toFirstLower(it.getName());
            _builder_1.append(_firstLower);
            CharSequence _componentImports = this.componentImports(attribute, _builder_1.toString());
            _builder.append(_componentImports);
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  protected CharSequence _components(final SingleClientAttribute it, final boolean isGroupedChild) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (((it.getAttributes().size() > 0) || isGroupedChild)) {
        _builder.append("export const ");
        String _reactTagName = this._es6Extension.reactTagName(it);
        _builder.append(_reactTagName);
        _builder.append(" = (options) => {");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("return <");
        String _reactComponentName = this._es6Extension.reactComponentName(it);
        _builder.append(_reactComponentName, "    ");
        _builder.append(" {...normalize(options)}/>");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        {
          EList<ClientAttribute> _attributes = it.getAttributes();
          for(final ClientAttribute attribute : _attributes) {
            CharSequence _components = this.components(attribute, false);
            _builder.append(_components);
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  protected CharSequence _components(final GroupedClientAttribute it, final boolean isGroupedChild) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("export const ");
    String _reactTagName = this._es6Extension.reactTagName(it);
    _builder.append(_reactTagName);
    _builder.append(" = (options) => {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("return <");
    String _reactComponentName = this._es6Extension.reactComponentName(it);
    _builder.append(_reactComponentName, "    ");
    _builder.append(" {...normalize(options)}/>");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    {
      int _size = it.getAttributeGroup().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        {
          EList<ClientAttribute> _attributeGroup = it.getAttributeGroup();
          for(final ClientAttribute attribute : _attributeGroup) {
            CharSequence _components = this.components(attribute, true);
            _builder.append(_components);
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence generateComponent(final ClientAttribute it, final String subFolder, final String folderPrefix) {
    if (it instanceof GroupedClientAttribute) {
      return _generateComponent((GroupedClientAttribute)it, subFolder, folderPrefix);
    } else if (it instanceof SingleClientAttribute) {
      return _generateComponent((SingleClientAttribute)it, subFolder, folderPrefix);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, subFolder, folderPrefix).toString());
    }
  }
  
  public CharSequence generateComponentStruct(final ClientAttribute it, final String folderPrefix, final List<SingleClientAttribute> passOnAttributes) {
    if (it instanceof GroupedClientAttribute) {
      return _generateComponentStruct((GroupedClientAttribute)it, folderPrefix, passOnAttributes);
    } else if (it instanceof SingleClientAttribute) {
      return _generateComponentStruct((SingleClientAttribute)it, folderPrefix, passOnAttributes);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, folderPrefix, passOnAttributes).toString());
    }
  }
  
  public CharSequence generateChild(final ClientAttribute it, final String enclosingTag, final List<SingleClientAttribute> passOnAttributes) {
    if (it instanceof GroupedClientAttribute) {
      return _generateChild((GroupedClientAttribute)it, enclosingTag, passOnAttributes);
    } else if (it instanceof SingleClientAttribute) {
      return _generateChild((SingleClientAttribute)it, enclosingTag, passOnAttributes);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, enclosingTag, passOnAttributes).toString());
    }
  }
  
  public CharSequence componentImports(final ClientAttribute it, final String subFolder) {
    if (it instanceof GroupedClientAttribute) {
      return _componentImports((GroupedClientAttribute)it, subFolder);
    } else if (it instanceof SingleClientAttribute) {
      return _componentImports((SingleClientAttribute)it, subFolder);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, subFolder).toString());
    }
  }
  
  public CharSequence components(final ClientAttribute it, final boolean isGroupedChild) {
    if (it instanceof GroupedClientAttribute) {
      return _components((GroupedClientAttribute)it, isGroupedChild);
    } else if (it instanceof SingleClientAttribute) {
      return _components((SingleClientAttribute)it, isGroupedChild);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, isGroupedChild).toString());
    }
  }
}
