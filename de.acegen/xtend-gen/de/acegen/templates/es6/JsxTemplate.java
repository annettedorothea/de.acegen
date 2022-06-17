package de.acegen.templates.es6;

import com.google.common.base.Objects;
import de.acegen.aceGen.ClientAttribute;
import de.acegen.aceGen.HttpClient;
import de.acegen.aceGen.Input;
import de.acegen.aceGen.UiAction;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.es6.Es6Extension;
import java.util.List;
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
        {
          EList<ClientAttribute> _attributes = it.getAttributes();
          for(final ClientAttribute attribute : _attributes) {
            _builder.append("\t");
            _builder.append("\t");
            String _firstLower = StringExtensions.toFirstLower(attribute.getName());
            _builder.append(_firstLower, "\t\t");
            _builder.append("={props.");
            String _firstLower_1 = StringExtensions.toFirstLower(attribute.getName());
            _builder.append(_firstLower_1, "\t\t");
            _builder.append("}");
            _builder.newLineIfNotEmpty();
          }
        }
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
        {
          EList<UiAction> _actions = it.getActions();
          for(final UiAction action : _actions) {
            _builder.append("\t");
            _builder.append("\t");
            String _name_1 = action.getName();
            _builder.append(_name_1, "\t\t");
            _builder.append("={(event) => props.");
            String _name_2 = action.getName();
            _builder.append(_name_2, "\t\t");
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
                  String _name_3 = param.getName();
                  boolean _equals = Objects.equal(_name_3, "value");
                  if (_equals) {
                    _builder.append("event.target.value");
                  } else {
                    String _name_4 = param.getName();
                    boolean _equals_1 = Objects.equal(_name_4, "keyCode");
                    if (_equals_1) {
                      _builder.append("event.keyCode");
                    } else {
                      _builder.append("props.");
                      String _name_5 = param.getName();
                      _builder.append(_name_5, "\t\t");
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
          {
            EList<String> _options = it.getOptions();
            for(final String option : _options) {
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("{value: \"");
              _builder.append(option, "\t\t");
              _builder.append("\", option: \"");
              _builder.append(option, "\t\t");
              _builder.append("\"},");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.append("]");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("return <select ");
          _builder.newLine();
          {
            EList<ClientAttribute> _attributes_1 = it.getAttributes();
            for(final ClientAttribute attribute_1 : _attributes_1) {
              _builder.append("\t");
              _builder.append("\t");
              String _firstLower_2 = StringExtensions.toFirstLower(attribute_1.getName());
              _builder.append(_firstLower_2, "\t\t");
              _builder.append("={props.");
              String _firstLower_3 = StringExtensions.toFirstLower(attribute_1.getName());
              _builder.append(_firstLower_3, "\t\t");
              _builder.append("}");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("className=\"select\"");
          _builder.newLine();
          {
            EList<UiAction> _actions_1 = it.getActions();
            for(final UiAction action_1 : _actions_1) {
              _builder.append("\t");
              _builder.append("\t");
              String _name_6 = action_1.getName();
              _builder.append(_name_6, "\t\t");
              _builder.append("={(event) => props.");
              String _name_7 = action_1.getName();
              _builder.append(_name_7, "\t\t");
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
                    String _name_8 = param_1.getName();
                    boolean _equals_2 = Objects.equal(_name_8, "value");
                    if (_equals_2) {
                      _builder.append("event.target.value");
                    } else {
                      String _name_9 = param_1.getName();
                      boolean _equals_3 = Objects.equal(_name_9, "keyCode");
                      if (_equals_3) {
                        _builder.append("event.keyCode");
                      } else {
                        _builder.append("props.");
                        String _name_10 = param_1.getName();
                        _builder.append(_name_10, "\t\t");
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
          _builder.append("{options.map(item => <option value={item.value} key={item.value}>{item.option}</option>)}");
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
            {
              EList<ClientAttribute> _attributes_2 = it.getAttributes();
              for(final ClientAttribute attribute_2 : _attributes_2) {
                _builder.append("\t");
                _builder.append("\t");
                String _firstLower_4 = StringExtensions.toFirstLower(attribute_2.getName());
                _builder.append(_firstLower_4, "\t\t");
                _builder.append("={props.");
                String _firstLower_5 = StringExtensions.toFirstLower(attribute_2.getName());
                _builder.append(_firstLower_5, "\t\t");
                _builder.append("}");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("className=\"button\"");
            _builder.newLine();
            {
              EList<UiAction> _actions_2 = it.getActions();
              for(final UiAction action_2 : _actions_2) {
                _builder.append("\t");
                _builder.append("\t");
                String _name_11 = action_2.getName();
                _builder.append(_name_11, "\t\t");
                _builder.append("={(event) => props.");
                String _name_12 = action_2.getName();
                _builder.append(_name_12, "\t\t");
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
                      String _name_13 = param_2.getName();
                      boolean _equals_4 = Objects.equal(_name_13, "value");
                      if (_equals_4) {
                        _builder.append("event.target.value");
                      } else {
                        String _name_14 = param_2.getName();
                        boolean _equals_5 = Objects.equal(_name_14, "keyCode");
                        if (_equals_5) {
                          _builder.append("event.keyCode");
                        } else {
                          _builder.append("props.");
                          String _name_15 = param_2.getName();
                          _builder.append(_name_15, "\t\t");
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
            String _name_16 = it.getName();
            _builder.append(_name_16, "\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("</button>");
            _builder.newLine();
          } else {
            _builder.append("\t");
            _builder.append("return <>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("<h1>");
            String _componentName_1 = this._es6Extension.componentName(it);
            _builder.append(_componentName_1, "\t\t");
            _builder.append("</h1>");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("<ul>");
            _builder.newLine();
            {
              EList<ClientAttribute> _attributes_3 = it.getAttributes();
              for(final ClientAttribute attribute_3 : _attributes_3) {
                _builder.append("\t");
                _builder.append("\t\t");
                CharSequence _renderChild = this.renderChild(attribute_3);
                _builder.append(_renderChild, "\t\t\t");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("</ul>");
            _builder.newLine();
            {
              EList<UiAction> _actions_3 = it.getActions();
              for(final UiAction action_3 : _actions_3) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("<a ");
                String _name_17 = action_3.getName();
                _builder.append(_name_17, "\t\t");
                _builder.append("={(event) => props.");
                String _name_18 = action_3.getName();
                _builder.append(_name_18, "\t\t");
                _builder.append("(");
                {
                  EList<Input> _input_3 = action_3.getTarget().getInput();
                  boolean _hasElements_3 = false;
                  for(final Input param_3 : _input_3) {
                    if (!_hasElements_3) {
                      _hasElements_3 = true;
                    } else {
                      _builder.appendImmediate(",", "\t\t");
                    }
                    {
                      String _name_19 = param_3.getName();
                      boolean _equals_6 = Objects.equal(_name_19, "value");
                      if (_equals_6) {
                        _builder.append("event.target.value");
                      } else {
                        String _name_20 = param_3.getName();
                        boolean _equals_7 = Objects.equal(_name_20, "keyCode");
                        if (_equals_7) {
                          _builder.append("event.keyCode");
                        } else {
                          _builder.append("props.");
                          String _name_21 = param_3.getName();
                          _builder.append(_name_21, "\t\t");
                        }
                      }
                    }
                  }
                }
                _builder.append(")}>");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\t");
                String _name_22 = action_3.getTarget().getName();
                _builder.append(_name_22, "\t\t\t");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("</a>");
                _builder.newLine();
              }
            }
            {
              if ((this._es6Extension.hasComplexAttribute(it) || it.isTree())) {
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
  
  public CharSequence generateComponentContainer(final ClientAttribute it, final String folderPrefix, final boolean root) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import React");
    {
      if (root) {
        _builder.append(", {useState}");
      }
    }
    _builder.append(" from \"react\";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _componentContainerImports = this.componentContainerImports(it, "");
    _builder.append(_componentContainerImports);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      if (root) {
        _builder.append("export let setContainerState;");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("export const ");
    String _componentContainerName = this._es6Extension.componentContainerName(it);
    _builder.append(_componentContainerName);
    _builder.append(" = (");
    {
      if ((!root)) {
        _builder.append(" props ");
      }
    }
    _builder.append(") => {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      if (root) {
        _builder.append("\t");
        _builder.append("const [props, setProps] = useState();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("setContainerState = setProps;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("if (!props) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return null;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    {
      boolean _hasComplexAttribute = this._es6Extension.hasComplexAttribute(it);
      if (_hasComplexAttribute) {
        _builder.append("\t");
        _builder.append("return <");
        String _componentName = this._es6Extension.componentName(it);
        _builder.append(_componentName, "\t");
        _builder.append(" {...props} ");
        CharSequence _actionProps = this.actionProps(it);
        _builder.append(_actionProps, "\t");
        _builder.append(">");
        _builder.newLineIfNotEmpty();
        {
          EList<ClientAttribute> _attributes = it.getAttributes();
          for(final ClientAttribute attribute : _attributes) {
            _builder.append("\t");
            _builder.append("\t");
            CharSequence _renderChildContainer = this.renderChildContainer(attribute, it.getAttributes(), it.isGroup());
            _builder.append(_renderChildContainer, "\t\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("</");
        String _componentName_1 = this._es6Extension.componentName(it);
        _builder.append(_componentName_1, "\t");
        _builder.append("> ");
        _builder.newLineIfNotEmpty();
      } else {
        boolean _isTree = it.isTree();
        if (_isTree) {
          _builder.append("\t");
          _builder.append("return <");
          String _componentName_2 = this._es6Extension.componentName(it);
          _builder.append(_componentName_2, "\t");
          _builder.append(" {...props} ");
          CharSequence _actionProps_1 = this.actionProps(it);
          _builder.append(_actionProps_1, "\t");
          _builder.append(">");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("{ props.");
          String _name = it.getName();
          _builder.append(_name, "\t\t");
          _builder.append(" ? props.");
          String _name_1 = it.getName();
          _builder.append(_name_1, "\t\t");
          _builder.append(".map((item, index) => <");
          String _componentContainerName_1 = this._es6Extension.componentContainerName(it);
          _builder.append(_componentContainerName_1, "\t\t");
          _builder.append(" {...item} key={item.");
          String _keyAttributeName = this._es6Extension.keyAttributeName(it);
          _builder.append(_keyAttributeName, "\t\t");
          _builder.append("} depth={props.depth+1} index={index} ");
          CharSequence _fromParentTreeProps = this.fromParentTreeProps(it);
          _builder.append(_fromParentTreeProps, "\t\t");
          _builder.append(" ");
          CharSequence _storageAndLocationPart = this.storageAndLocationPart(it);
          _builder.append(_storageAndLocationPart, "\t\t");
          _builder.append(" ");
          CharSequence _actionProps_2 = this.actionProps(it);
          _builder.append(_actionProps_2, "\t\t");
          _builder.append(" />) : [] }");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("</");
          String _componentName_3 = this._es6Extension.componentName(it);
          _builder.append(_componentName_3, "\t");
          _builder.append("> ");
          _builder.newLineIfNotEmpty();
        } else {
          _builder.append("\t");
          _builder.append("return <");
          String _componentName_4 = this._es6Extension.componentName(it);
          _builder.append(_componentName_4, "\t");
          _builder.append(" {...props} ");
          CharSequence _actionProps_3 = this.actionProps(it);
          _builder.append(_actionProps_3, "\t");
          _builder.append(" /> ");
          _builder.newLineIfNotEmpty();
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
  
  public CharSequence renderChild(final ClientAttribute it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (((it.getAttributes().size() == 0) && (!(this._es6Extension.isTag(it)).booleanValue()))) {
        _builder.append("<li>");
        String _firstLower = StringExtensions.toFirstLower(it.getName());
        _builder.append(_firstLower);
        _builder.append(": {props.");
        String _firstLower_1 = StringExtensions.toFirstLower(it.getName());
        _builder.append(_firstLower_1);
        _builder.append(" !== null && props.");
        String _firstLower_2 = StringExtensions.toFirstLower(it.getName());
        _builder.append(_firstLower_2);
        _builder.append(" !== undefined ? props.");
        String _firstLower_3 = StringExtensions.toFirstLower(it.getName());
        _builder.append(_firstLower_3);
        _builder.append(".toString() : \"\"}</li>");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence renderChildContainer(final ClientAttribute it, final List<ClientAttribute> parentAttributes, final boolean parentIsGroup) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Boolean _isTag = this._es6Extension.isTag(it);
      if ((_isTag).booleanValue()) {
        _builder.append("<");
        String _componentName = this._es6Extension.componentName(it);
        _builder.append(_componentName);
        _builder.append(" ");
        CharSequence _props = this.props(it, parentAttributes);
        _builder.append(_props);
        _builder.append(" ");
        CharSequence _actionProps = this.actionProps(it);
        _builder.append(_actionProps);
        _builder.append(" />");
        _builder.newLineIfNotEmpty();
      } else {
        Boolean _isComponent = this._es6Extension.isComponent(it);
        if ((_isComponent).booleanValue()) {
          {
            if (((!it.isList()) && (!it.isTree()))) {
              {
                if (parentIsGroup) {
                  _builder.append("{ props.");
                  String _name = it.getName();
                  _builder.append(_name);
                  _builder.append(" && <");
                  String _componentContainerName = this._es6Extension.componentContainerName(it);
                  _builder.append(_componentContainerName);
                  _builder.append(" ");
                  CharSequence _props_1 = this.props(it, parentAttributes);
                  _builder.append(_props_1);
                  _builder.append(" ");
                  CharSequence _actionProps_1 = this.actionProps(it);
                  _builder.append(_actionProps_1);
                  _builder.append(" /> }");
                  _builder.newLineIfNotEmpty();
                } else {
                  _builder.append("<");
                  String _componentContainerName_1 = this._es6Extension.componentContainerName(it);
                  _builder.append(_componentContainerName_1);
                  _builder.append(" ");
                  CharSequence _props_2 = this.props(it, parentAttributes);
                  _builder.append(_props_2);
                  _builder.append(" ");
                  CharSequence _actionProps_2 = this.actionProps(it);
                  _builder.append(_actionProps_2);
                  _builder.append(" />");
                  _builder.newLineIfNotEmpty();
                }
              }
            } else {
              _builder.append("{ props.");
              String _name_1 = it.getName();
              _builder.append(_name_1);
              _builder.append(" ? props.");
              String _name_2 = it.getName();
              _builder.append(_name_2);
              _builder.append(".map((item, index) => <");
              String _componentContainerName_2 = this._es6Extension.componentContainerName(it);
              _builder.append(_componentContainerName_2);
              _builder.append(" {...item} key={item.");
              String _keyAttributeName = this._es6Extension.keyAttributeName(it);
              _builder.append(_keyAttributeName);
              _builder.append("} ");
              {
                boolean _isList = it.isList();
                if (_isList) {
                  _builder.append("index={index} ");
                  CharSequence _parentPart = this.parentPart(it, parentAttributes);
                  _builder.append(_parentPart);
                  _builder.append(" ");
                } else {
                  _builder.append("depth={1} index={index} ");
                  CharSequence _fromParentTreeProps = this.fromParentTreeProps(it);
                  _builder.append(_fromParentTreeProps);
                  _builder.append(" ");
                }
              }
              CharSequence _storageAndLocationPart = this.storageAndLocationPart(it);
              _builder.append(_storageAndLocationPart);
              _builder.append(" ");
              CharSequence _actionProps_3 = this.actionProps(it);
              _builder.append(_actionProps_3);
              _builder.append(" />) : [] }");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence props(final ClientAttribute it, final List<ClientAttribute> parentAttributes) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{...props.");
    String _firstLower = StringExtensions.toFirstLower(it.getName());
    _builder.append(_firstLower);
    _builder.append(" } ");
    CharSequence _storageAndLocationPart = this.storageAndLocationPart(it);
    _builder.append(_storageAndLocationPart);
    _builder.append(" ");
    CharSequence _parentPart = this.parentPart(it, parentAttributes);
    _builder.append(_parentPart);
    return _builder;
  }
  
  public CharSequence storageAndLocationPart(final ClientAttribute it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<ClientAttribute> _attributes = it.getAttributes();
      for(final ClientAttribute attribute : _attributes) {
        {
          if ((attribute.isStorage() || attribute.isLocation())) {
            String _firstLower = StringExtensions.toFirstLower(attribute.getName());
            _builder.append(_firstLower);
            _builder.append("={");
            CharSequence _stateFunctionCall = this._es6Extension.stateFunctionCall(attribute, "get", "data");
            _builder.append(_stateFunctionCall);
            _builder.append("} ");
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence parentPart(final ClientAttribute it, final List<ClientAttribute> parentAttributes) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<ClientAttribute> _attributes = it.getAttributes();
      for(final ClientAttribute attribute : _attributes) {
        {
          boolean _attributesContain = this._es6Extension.attributesContain(parentAttributes, attribute);
          if (_attributesContain) {
            String _firstLower = StringExtensions.toFirstLower(attribute.getName());
            _builder.append(_firstLower);
            _builder.append("={props.");
            String _firstLower_1 = StringExtensions.toFirstLower(attribute.getName());
            _builder.append(_firstLower_1);
            _builder.append("} ");
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence actionProps(final ClientAttribute it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<UiAction> _actions = it.getActions();
      for(final UiAction action : _actions) {
        String _name = action.getName();
        _builder.append(_name);
        _builder.append("={");
        String _firstLower = StringExtensions.toFirstLower(action.getTarget().getName());
        _builder.append(_firstLower);
        _builder.append("} ");
      }
    }
    return _builder;
  }
  
  public CharSequence fromParentTreeProps(final ClientAttribute it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<ClientAttribute> _attributes = it.getAttributes();
      for(final ClientAttribute attribute : _attributes) {
        {
          boolean _isFromParent = attribute.isFromParent();
          if (_isFromParent) {
            String _firstLower = StringExtensions.toFirstLower(attribute.getName());
            _builder.append(_firstLower);
            _builder.append("={props.");
            String _firstLower_1 = StringExtensions.toFirstLower(attribute.getName());
            _builder.append(_firstLower_1);
            _builder.append("} ");
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
    String _depth = this._es6Extension.depth(it, "../../");
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
          Boolean _isTag = this._es6Extension.isTag(attribute);
          if ((_isTag).booleanValue()) {
            _builder.append("import { ");
            String _componentName_2 = this._es6Extension.componentName(attribute);
            _builder.append(_componentName_2);
            _builder.append(" } from \"");
            String _depth_1 = this._es6Extension.depth(it, "../../");
            _builder.append(_depth_1);
            _builder.append("src/components/");
            _builder.append(subFolder);
            String _path_1 = this._es6Extension.path(it);
            _builder.append(_path_1);
            String _firstLower = StringExtensions.toFirstLower(it.getName());
            _builder.append(_firstLower);
            _builder.append("/");
            String _componentName_3 = this._es6Extension.componentName(attribute);
            _builder.append(_componentName_3);
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
          } else {
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append(subFolder);
            _builder_1.append("/");
            String _firstLower_1 = StringExtensions.toFirstLower(it.getName());
            _builder_1.append(_firstLower_1);
            String _importComponentContainer = this._es6Extension.importComponentContainer(attribute, _builder_1.toString());
            _builder.append(_importComponentContainer);
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      boolean _oneChildIsLocationOrStorage = this._es6Extension.oneChildIsLocationOrStorage(it);
      if (_oneChildIsLocationOrStorage) {
        _builder.append("import * as AppState from \"");
        String _depth_2 = this._es6Extension.depth(it, "../../");
        _builder.append(_depth_2);
        _builder.append("src/AppState\";");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      List<UiAction> _uniqueActions = this._es6Extension.uniqueActions(it);
      for(final UiAction action : _uniqueActions) {
        _builder.append("import { ");
        String _firstLower_2 = StringExtensions.toFirstLower(action.getTarget().getName());
        _builder.append(_firstLower_2);
        _builder.append(" } from \"");
        String _depth_3 = this._es6Extension.depth(it, "../");
        _builder.append(_depth_3);
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
