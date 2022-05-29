package de.acegen.templates.es6;

import com.google.common.base.Objects;
import de.acegen.aceGen.ClientAttribute;
import de.acegen.aceGen.HttpClient;
import de.acegen.aceGen.Input;
import de.acegen.aceGen.UiAction;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.es6.Es6Extension;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
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
  
  public CharSequence generateComponent(final ClientAttribute it, final String folderPrefix) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import React from \"react\";");
    _builder.newLine();
    _builder.newLine();
    CharSequence _componentImports = this.componentImports(it);
    _builder.append(_componentImports);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("export const ");
    String _componentName = this._es6Extension.componentName(it);
    _builder.append(_componentName);
    _builder.append(" = (props) => {");
    _builder.newLineIfNotEmpty();
    {
      Boolean _isInput = this._es6Extension.isInput(it);
      if ((_isInput).booleanValue()) {
        _builder.append("\t");
        _builder.append("return <input ");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("type=\"");
        String _inputType = this._es6Extension.inputType(it);
        _builder.append(_inputType, "\t\t");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        {
          boolean _childrenContain = this._es6Extension.childrenContain(it, "value");
          if (_childrenContain) {
            _builder.append("value={props.value}");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        {
          boolean _childrenContain_1 = this._es6Extension.childrenContain(it, "disabled");
          if (_childrenContain_1) {
            _builder.append("value={props.disabled}");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        {
          boolean _childrenContain_2 = this._es6Extension.childrenContain(it, "readonly");
          if (_childrenContain_2) {
            _builder.append("value={props.readonly}");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        {
          boolean _childrenContain_3 = this._es6Extension.childrenContain(it, "checked");
          if (_childrenContain_3) {
            _builder.append("checked={props.checked}");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("placeholder=\"");
        String _name = it.getName();
        _builder.append(_name, "\t\t");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("className=\"text-input\"");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("id=\"");
        String _name_1 = it.getName();
        _builder.append(_name_1, "\t\t");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
        {
          EList<UiAction> _actions = it.getActions();
          for(final UiAction action : _actions) {
            _builder.append("\t");
            _builder.append("\t");
            String _type = action.getType();
            _builder.append(_type, "\t\t");
            _builder.append("={(event) => ");
            String _firstLower = StringExtensions.toFirstLower(action.getTarget().getName());
            _builder.append(_firstLower, "\t\t");
            _builder.append("(");
            {
              EList<Input> _input = action.getTarget().getInput();
              boolean _hasElements = false;
              for(final Input param : _input) {
                if (!_hasElements) {
                  _hasElements = true;
                } else {
                  _builder.appendImmediate(",", "\t\t");
                }
                {
                  String _name_2 = param.getName();
                  boolean _equals = Objects.equal(_name_2, "value");
                  if (_equals) {
                    _builder.append("event.target.value");
                  } else {
                    String _name_3 = param.getName();
                    boolean _equals_1 = Objects.equal(_name_3, "keyCode");
                    if (_equals_1) {
                      _builder.append("event.keyCode");
                    } else {
                      _builder.append("props.");
                      String _name_4 = param.getName();
                      _builder.append(_name_4, "\t\t");
                    }
                  }
                }
              }
            }
            _builder.append(")}");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("/>");
        _builder.newLine();
      } else {
        Boolean _isSelect = this._es6Extension.isSelect(it);
        if ((_isSelect).booleanValue()) {
          _builder.append("\t");
          _builder.append("const options = [");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("{value: 1, option: \"1\"},");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("{value: 2, option: \"2\"},");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("{value: 3, option: \"3\"},");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("]");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("return <select ");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          {
            boolean _childrenContain_4 = this._es6Extension.childrenContain(it, "value");
            if (_childrenContain_4) {
              _builder.append("value={props.value}");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          {
            boolean _childrenContain_5 = this._es6Extension.childrenContain(it, "disabled");
            if (_childrenContain_5) {
              _builder.append("value={props.disabled}");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          {
            boolean _childrenContain_6 = this._es6Extension.childrenContain(it, "readonly");
            if (_childrenContain_6) {
              _builder.append("value={props.readonly}");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("className=\"select\"");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("id=\"");
          String _name_5 = it.getName();
          _builder.append(_name_5, "\t\t");
          _builder.append("\"");
          _builder.newLineIfNotEmpty();
          {
            EList<UiAction> _actions_1 = it.getActions();
            for(final UiAction action_1 : _actions_1) {
              _builder.append("\t");
              _builder.append("\t");
              String _type_1 = action_1.getType();
              _builder.append(_type_1, "\t\t");
              _builder.append("={(event) => ");
              String _firstLower_1 = StringExtensions.toFirstLower(action_1.getTarget().getName());
              _builder.append(_firstLower_1, "\t\t");
              _builder.append("(");
              {
                EList<Input> _input_1 = action_1.getTarget().getInput();
                boolean _hasElements_1 = false;
                for(final Input param_1 : _input_1) {
                  if (!_hasElements_1) {
                    _hasElements_1 = true;
                  } else {
                    _builder.appendImmediate(",", "\t\t");
                  }
                  {
                    String _name_6 = param_1.getName();
                    boolean _equals_2 = Objects.equal(_name_6, "value");
                    if (_equals_2) {
                      _builder.append("event.target.value");
                    } else {
                      String _name_7 = param_1.getName();
                      boolean _equals_3 = Objects.equal(_name_7, "keyCode");
                      if (_equals_3) {
                        _builder.append("event.keyCode");
                      } else {
                        _builder.append("props.");
                        String _name_8 = param_1.getName();
                        _builder.append(_name_8, "\t\t");
                      }
                    }
                  }
                }
              }
              _builder.append(")}");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.append(">");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("{options.map(item => <option value={item.value}>{item.option}</option>)}");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("</select>");
          _builder.newLine();
        } else {
          Boolean _isButton = this._es6Extension.isButton(it);
          if ((_isButton).booleanValue()) {
            _builder.append("\t");
            _builder.append("return <button ");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            {
              boolean _childrenContain_7 = this._es6Extension.childrenContain(it, "disabled");
              if (_childrenContain_7) {
                _builder.append("value={props.disabled}");
              }
            }
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            {
              boolean _childrenContain_8 = this._es6Extension.childrenContain(it, "readonly");
              if (_childrenContain_8) {
                _builder.append("value={props.readonly}");
              }
            }
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("className=\"button\"");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("id=\"");
            String _name_9 = it.getName();
            _builder.append(_name_9, "\t\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
            {
              EList<UiAction> _actions_2 = it.getActions();
              for(final UiAction action_2 : _actions_2) {
                _builder.append("\t");
                _builder.append("\t");
                String _type_2 = action_2.getType();
                _builder.append(_type_2, "\t\t");
                _builder.append("={(event) => ");
                String _firstLower_2 = StringExtensions.toFirstLower(action_2.getTarget().getName());
                _builder.append(_firstLower_2, "\t\t");
                _builder.append("(");
                {
                  EList<Input> _input_2 = action_2.getTarget().getInput();
                  boolean _hasElements_2 = false;
                  for(final Input param_2 : _input_2) {
                    if (!_hasElements_2) {
                      _hasElements_2 = true;
                    } else {
                      _builder.appendImmediate(",", "\t\t");
                    }
                    {
                      String _name_10 = param_2.getName();
                      boolean _equals_4 = Objects.equal(_name_10, "value");
                      if (_equals_4) {
                        _builder.append("event.target.value");
                      } else {
                        String _name_11 = param_2.getName();
                        boolean _equals_5 = Objects.equal(_name_11, "keyCode");
                        if (_equals_5) {
                          _builder.append("event.keyCode");
                        } else {
                          _builder.append("props.");
                          String _name_12 = param_2.getName();
                          _builder.append(_name_12, "\t\t");
                        }
                      }
                    }
                  }
                }
                _builder.append(")}");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t");
            _builder.append(">");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            String _name_13 = it.getName();
            _builder.append(_name_13, "\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("</button>");
            _builder.newLine();
          } else {
            _builder.append("\t");
            _builder.append("return <>");
            _builder.newLine();
            {
              EList<ClientAttribute> _attributes = it.getAttributes();
              for(final ClientAttribute attribute : _attributes) {
                _builder.append("\t");
                _builder.append("\t");
                CharSequence _renderChild = this.renderChild(attribute);
                _builder.append(_renderChild, "\t\t");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _hasComplexAttribute = this._es6Extension.hasComplexAttribute(it);
              if (_hasComplexAttribute) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("{props.children}");
                _builder.newLine();
              }
            }
            _builder.append("\t");
            _builder.append("</> ");
            _builder.newLine();
          }
        }
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
  
  public CharSequence generateComponentContainer(final ClientAttribute it, final String folderPrefix) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import React from \"react\";");
    _builder.newLine();
    _builder.newLine();
    CharSequence _componentContainerImports = this.componentContainerImports(it, "");
    _builder.append(_componentContainerImports);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("export const ");
    String _componentContainerName = this._es6Extension.componentContainerName(it);
    _builder.append(_componentContainerName);
    _builder.append(" = (props) => {");
    _builder.newLineIfNotEmpty();
    {
      boolean _hasComplexAttribute = this._es6Extension.hasComplexAttribute(it);
      if (_hasComplexAttribute) {
        _builder.append("\t");
        _builder.append("return <");
        String _componentName = this._es6Extension.componentName(it);
        _builder.append(_componentName, "\t");
        _builder.append(" {...props}>");
        _builder.newLineIfNotEmpty();
        {
          EList<ClientAttribute> _attributes = it.getAttributes();
          for(final ClientAttribute attribute : _attributes) {
            {
              Boolean _isTag = this._es6Extension.isTag(attribute);
              boolean _not = (!(_isTag).booleanValue());
              if (_not) {
                _builder.append("\t");
                _builder.append("\t");
                CharSequence _renderChildContainer = this.renderChildContainer(attribute);
                _builder.append(_renderChildContainer, "\t\t");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.append("\t");
        _builder.append("</");
        String _componentName_1 = this._es6Extension.componentName(it);
        _builder.append(_componentName_1, "\t");
        _builder.append("> ");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("\t");
        _builder.append("return <");
        String _componentName_2 = this._es6Extension.componentName(it);
        _builder.append(_componentName_2, "\t");
        _builder.append(" {...props} /> ");
        _builder.newLineIfNotEmpty();
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
  
  public CharSequence generateRootComponentContainer(final ClientAttribute it, final String folderPrefix) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import React, {useState} from \"react\";");
    _builder.newLine();
    _builder.newLine();
    CharSequence _componentContainerImports = this.componentContainerImports(it, "");
    _builder.append(_componentContainerImports);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("export let setContainerState;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export const ");
    String _componentContainerName = this._es6Extension.componentContainerName(it);
    _builder.append(_componentContainerName);
    _builder.append(" = () => {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("const [props, setProps] = useState();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("setContainerState = setProps;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (!props) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      boolean _hasComplexAttribute = this._es6Extension.hasComplexAttribute(it);
      if (_hasComplexAttribute) {
        _builder.append("\t");
        _builder.append("return <");
        String _componentName = this._es6Extension.componentName(it);
        _builder.append(_componentName, "\t");
        _builder.append(" {...props}>");
        _builder.newLineIfNotEmpty();
        {
          EList<ClientAttribute> _attributes = it.getAttributes();
          for(final ClientAttribute attribute : _attributes) {
            {
              Boolean _isTag = this._es6Extension.isTag(attribute);
              boolean _not = (!(_isTag).booleanValue());
              if (_not) {
                _builder.append("\t");
                _builder.append("\t");
                CharSequence _renderChildContainer = this.renderChildContainer(attribute);
                _builder.append(_renderChildContainer, "\t\t");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.append("\t");
        _builder.append("</");
        String _componentName_1 = this._es6Extension.componentName(it);
        _builder.append(_componentName_1, "\t");
        _builder.append("> ");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("\t");
        _builder.append("return <");
        String _componentName_2 = this._es6Extension.componentName(it);
        _builder.append(_componentName_2, "\t");
        _builder.append(" {...props} /> ");
        _builder.newLineIfNotEmpty();
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
  
  public CharSequence renderChild(final ClientAttribute it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Boolean _isTag = this._es6Extension.isTag(it);
      if ((_isTag).booleanValue()) {
        _builder.append("<");
        String _componentName = this._es6Extension.componentName(it);
        _builder.append(_componentName);
        _builder.append(" {...props} />");
        _builder.newLineIfNotEmpty();
      } else {
        int _size = it.getAttributes().size();
        boolean _equals = (_size == 0);
        if (_equals) {
          _builder.append("<div>");
          String _firstLower = StringExtensions.toFirstLower(it.getName());
          _builder.append(_firstLower);
          _builder.append(": {props.");
          String _firstLower_1 = StringExtensions.toFirstLower(it.getName());
          _builder.append(_firstLower_1);
          _builder.append("}</div>");
          _builder.newLineIfNotEmpty();
        } else {
          boolean _isList = it.isList();
          if (_isList) {
            _builder.append("{ props.");
            String _name = it.getName();
            _builder.append(_name);
            _builder.append(" ? props.");
            String _name_1 = it.getName();
            _builder.append(_name_1);
            _builder.append(".map(i => <");
            String _componentName_1 = this._es6Extension.componentName(it);
            _builder.append(_componentName_1);
            _builder.append(" {...i} />) : [] }");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence renderChildContainer(final ClientAttribute it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Boolean _isComponent = this._es6Extension.isComponent(it);
      if ((_isComponent).booleanValue()) {
        {
          boolean _isList = it.isList();
          boolean _not = (!_isList);
          if (_not) {
            _builder.append("{ props.");
            String _name = it.getName();
            _builder.append(_name);
            _builder.append(" && <");
            String _componentContainerName = this._es6Extension.componentContainerName(it);
            _builder.append(_componentContainerName);
            _builder.append(" {...props.");
            String _firstLower = StringExtensions.toFirstLower(it.getName());
            _builder.append(_firstLower);
            _builder.append("} /> }");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence componentContainerImports(final ClientAttribute it, final String subFolder) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import { ");
    String _componentName = this._es6Extension.componentName(it);
    _builder.append(_componentName);
    _builder.append(" } from \"");
    String _depth = this._es6Extension.depth(it);
    _builder.append(_depth);
    _builder.append("src/components/");
    _builder.append(subFolder);
    String _path = this._es6Extension.path(it);
    _builder.append(_path);
    String _componentName_1 = this._es6Extension.componentName(it);
    _builder.append(_componentName_1);
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    {
      EList<ClientAttribute> _attributes = it.getAttributes();
      for(final ClientAttribute attribute : _attributes) {
        {
          if (((!(this._es6Extension.isTag(attribute)).booleanValue()) && (!attribute.isList()))) {
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append(subFolder);
            _builder_1.append("/");
            String _firstLower = StringExtensions.toFirstLower(it.getName());
            _builder_1.append(_firstLower);
            String _importComponentContainer = this._es6Extension.importComponentContainer(attribute, _builder_1.toString());
            _builder.append(_importComponentContainer);
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence componentImports(final ClientAttribute it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<ClientAttribute> _attributes = it.getAttributes();
      for(final ClientAttribute attribute : _attributes) {
        String _importComponent = this._es6Extension.importComponent(attribute, StringExtensions.toFirstLower(it.getName()));
        _builder.append(_importComponent);
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<UiAction> _actions = it.getActions();
      for(final UiAction action : _actions) {
        _builder.append("import { ");
        String _firstLower = StringExtensions.toFirstLower(action.getTarget().getName());
        _builder.append(_firstLower);
        _builder.append(" } from \"");
        String _depth = this._es6Extension.depth(it);
        _builder.append(_depth);
        _builder.append("gen/");
        EObject _eContainer = action.getTarget().eContainer();
        String _name = ((HttpClient) _eContainer).getName();
        _builder.append(_name);
        _builder.append("/ActionFunctions\";");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
}
