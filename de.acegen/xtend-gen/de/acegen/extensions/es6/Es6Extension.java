/**
 * Copyright (c) 2020 Annette Pohl
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 * 
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */
package de.acegen.extensions.es6;

import com.google.common.base.Objects;
import de.acegen.aceGen.BooleanType;
import de.acegen.aceGen.ClientAttribute;
import de.acegen.aceGen.ClientGivenRef;
import de.acegen.aceGen.ClientScenario;
import de.acegen.aceGen.ClientWhenBlock;
import de.acegen.aceGen.ClientWhenThen;
import de.acegen.aceGen.CustomVerification;
import de.acegen.aceGen.HttpClient;
import de.acegen.aceGen.HttpClientStateFunction;
import de.acegen.aceGen.JsonArrayClient;
import de.acegen.aceGen.JsonMemberClient;
import de.acegen.aceGen.JsonObjectClient;
import de.acegen.aceGen.JsonValueClient;
import de.acegen.aceGen.LongType;
import de.acegen.aceGen.NullType;
import de.acegen.aceGen.PrimitiveValue;
import de.acegen.aceGen.StringType;
import de.acegen.aceGen.UiAction;
import de.acegen.aceGen.UndefinedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class Es6Extension {
  public String packageFolder(final HttpClient it) {
    StringConcatenation _builder = new StringConcatenation();
    String _replace = it.getName().replace(".", "/");
    _builder.append(_replace);
    return _builder.toString();
  }

  public String projectName(final HttpClient it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    return _builder.toString();
  }

  public String appStateFunction(final HttpClientStateFunction it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(data) => {");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _exclusiveViewValidation = this.exclusiveViewValidation(it.getStateElement());
    _builder.append(_exclusiveViewValidation, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    ClientAttribute _stateElement = it.getStateElement();
    StringConcatenation _builder_1 = new StringConcatenation();
    String _stateFunctionType = it.getStateFunctionType();
    _builder_1.append(_stateFunctionType);
    CharSequence _stateFunctionCall = this.stateFunctionCall(_stateElement, _builder_1.toString(), "data");
    _builder.append(_stateFunctionCall, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    return _builder.toString();
  }

  private boolean parentIsExclusiveView(final ClientAttribute it) {
    EObject parent = it.eContainer();
    if (((parent != null) && (parent instanceof ClientAttribute))) {
      final ClientAttribute parentAttribute = ((ClientAttribute) parent);
      return parentAttribute.isExclusiveView();
    }
    return false;
  }

  private ClientAttribute exclusiveParentAsClientAttribute(final ClientAttribute it) {
    EObject parent = it.eContainer();
    if (((parent != null) && (parent instanceof ClientAttribute))) {
      final ClientAttribute parentAttribute = ((ClientAttribute) parent);
      boolean _isExclusiveView = parentAttribute.isExclusiveView();
      if (_isExclusiveView) {
        return parentAttribute;
      }
    }
    return null;
  }

  private CharSequence exclusiveViewValidation(final ClientAttribute it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      List<ClientAttribute> _allParentAttributesExclusiveItem = this.allParentAttributesExclusiveItem(it);
      for(final ClientAttribute attribute : _allParentAttributesExclusiveItem) {
        {
          boolean _parentIsExclusiveView = this.parentIsExclusiveView(attribute);
          if (_parentIsExclusiveView) {
            _builder.append("if (AppState.get(");
            String _path = this.path(this.paramList(attribute));
            _builder.append(_path);
            _builder.append(") === undefined) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("console.warn(\"path ");
            String _replace = this.path(this.paramList(attribute)).replace("\"", "\'");
            _builder.append(_replace, "\t");
            _builder.append(" does not match exclusive view ");
            String _name = this.exclusiveParentAsClientAttribute(attribute).getName();
            _builder.append(_name, "\t");
            _builder.append(" in AppState\", AppState.get(");
            String _path_1 = this.path(this.paramListExclusive(attribute));
            _builder.append(_path_1, "\t");
            _builder.append("));");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("return;");
            _builder.newLine();
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    return _builder;
  }

  public CharSequence stateFunctionCall(final ClientAttribute it, final String functionName, final String data) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((this.parentIsExclusiveView(it) && (!Objects.equal(functionName, "get")))) {
        _builder.append("AppState.set({");
        String _name = this.exclusiveParentAsClientAttribute(it).getName();
        _builder.append(_name);
        _builder.append(": {}}, ");
        String _path = this.path(this.paramListExclusive(it));
        _builder.append(_path);
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("AppState.");
    String _stateFunctionName = this.stateFunctionName(it, functionName);
    _builder.append(_stateFunctionName);
    _builder.append("(");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    {
      boolean _notEquals = (!Objects.equal(functionName, "get"));
      if (_notEquals) {
        _builder.append(data, "\t");
        _builder.append(", ");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _path_1 = this.path(this.paramList(it));
    _builder.append(_path_1, "\t");
    {
      if (((((!Objects.equal(functionName, "get")) && (it.getAttributes().size() > 0)) && (!it.isList())) && (!it.isTree()))) {
        _builder.append(", ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("[");
        {
          EList<ClientAttribute> _attributes = it.getAttributes();
          boolean _hasElements = false;
          for(final ClientAttribute attribute : _attributes) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(", ", "\t");
            }
            _builder.append("\"");
            String _name_1 = attribute.getName();
            _builder.append(_name_1, "\t");
            _builder.append("\"");
          }
        }
        _builder.append("]");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append(")");
    _builder.newLine();
    return _builder;
  }

  private List<String> paramList(final ClientAttribute it) {
    ArrayList<String> paramList = new ArrayList<String>();
    List<ClientAttribute> _allParentAttributesInclusiveItem = this.allParentAttributesInclusiveItem(it);
    for (final ClientAttribute item : _allParentAttributesInclusiveItem) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\"");
      String _name = item.getName();
      _builder.append(_name);
      _builder.append("\"");
      paramList.add(_builder.toString());
    }
    return paramList;
  }

  private List<String> paramListExclusive(final ClientAttribute it) {
    ArrayList<String> paramList = new ArrayList<String>();
    List<ClientAttribute> _allParentAttributesExclusiveItem = this.allParentAttributesExclusiveItem(it);
    for (final ClientAttribute item : _allParentAttributesExclusiveItem) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\"");
      String _name = item.getName();
      _builder.append(_name);
      _builder.append("\"");
      paramList.add(_builder.toString());
    }
    return paramList;
  }

  private String path(final List<String> paramList) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[");
    {
      boolean _hasElements = false;
      for(final String param : paramList) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        _builder.append(param);
      }
    }
    _builder.append("]");
    return _builder.toString();
  }

  private String stateFunctionName(final ClientAttribute it, final String functionName) {
    boolean _isLocation = it.isLocation();
    if (_isLocation) {
      return (functionName + "Location");
    }
    boolean _isStorage = it.isStorage();
    if (_isStorage) {
      return (functionName + "Storage");
    }
    return functionName;
  }

  private List<ClientAttribute> allParentAttributesInclusiveItem(final ClientAttribute it) {
    ArrayList<ClientAttribute> attributes = new ArrayList<ClientAttribute>();
    attributes.add(it);
    return this.allParentAttributes(it, attributes);
  }

  private List<ClientAttribute> allParentAttributesExclusiveItem(final ClientAttribute it) {
    ArrayList<ClientAttribute> _arrayList = new ArrayList<ClientAttribute>();
    return this.allParentAttributes(it, _arrayList);
  }

  private List<ClientAttribute> allParentAttributes(final ClientAttribute it, final List<ClientAttribute> attributes) {
    EObject parent = it.eContainer();
    while ((parent != null)) {
      {
        if ((parent instanceof ClientAttribute)) {
          attributes.add(0, ((ClientAttribute) parent));
        }
        parent = parent.eContainer();
      }
    }
    return attributes;
  }

  public List<HttpClient> allReferencedHttpClients(final ClientScenario it) {
    ArrayList<HttpClient> list = new ArrayList<HttpClient>();
    this.allReferencedHttpClientsRec(it, list);
    return list;
  }

  private void allReferencedHttpClientsRec(final ClientScenario it, final ArrayList<HttpClient> list) {
    EList<ClientWhenThen> _clientWhenThen = it.getClientWhenThen();
    for (final ClientWhenThen whenThenItem : _clientWhenThen) {
      {
        ClientWhenBlock _whenBlock = whenThenItem.getWhenBlock();
        boolean _tripleNotEquals = (_whenBlock != null);
        if (_tripleNotEquals) {
          EObject _eContainer = whenThenItem.getWhenBlock().getAction().eContainer();
          HttpClient httpClient = ((HttpClient) _eContainer);
          boolean _contains = list.contains(httpClient);
          boolean _not = (!_contains);
          if (_not) {
            list.add(httpClient);
          }
        }
        EList<ClientGivenRef> _givenRefs = it.getGivenRefs();
        for (final ClientGivenRef givenRef : _givenRefs) {
          this.allReferencedHttpClientsRec(givenRef.getScenario(), list);
        }
      }
    }
  }

  public CharSequence actionIdName(final HttpClient it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("ActionIds");
    return _builder;
  }

  public Object primitiveValueFrom(final PrimitiveValue it) {
    String _string = it.getString();
    boolean _tripleNotEquals = (_string != null);
    if (_tripleNotEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("`");
      String _string_1 = it.getString();
      _builder.append(_string_1);
      _builder.append("`");
      return _builder.toString();
    }
    return Integer.valueOf(it.getLong());
  }

  public Object primitiveParamFrom(final PrimitiveValue it) {
    String _string = it.getString();
    boolean _tripleNotEquals = (_string != null);
    if (_tripleNotEquals) {
      StringConcatenation _builder = new StringConcatenation();
      String _string_1 = it.getString();
      _builder.append(_string_1);
      return _builder.toString();
    }
    return Integer.valueOf(it.getLong());
  }

  protected CharSequence _valueFrom(final JsonObjectClient it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((((it != null) && (it.getMembers() != null)) && (it.getMembers().size() > 0))) {
        _builder.append("{ ");
        _builder.newLine();
        _builder.append("\t");
        {
          EList<JsonMemberClient> _members = it.getMembers();
          boolean _hasElements = false;
          for(final JsonMemberClient member : _members) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(",\n", "\t");
            }
            String _name = member.getAttribute().getName();
            _builder.append(_name, "\t");
            _builder.append(" : ");
            CharSequence _valueFrom = this.valueFrom(member.getValue());
            _builder.append(_valueFrom, "\t");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("}");
      } else {
        _builder.append("{}");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  protected CharSequence _valueFrom(final JsonValueClient it) {
    if ((it instanceof StringType)) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("`");
      String _string = ((StringType)it).getString();
      _builder.append(_string);
      _builder.append("`");
      return _builder;
    } else {
      if ((it instanceof BooleanType)) {
        return ((BooleanType)it).getBoolean();
      } else {
        if ((it instanceof NullType)) {
          return "null";
        } else {
          if ((it instanceof LongType)) {
            StringConcatenation _builder_1 = new StringConcatenation();
            int _long = ((LongType)it).getLong();
            _builder_1.append(_long);
            return _builder_1;
          } else {
            if ((it instanceof UndefinedType)) {
              StringConcatenation _builder_2 = new StringConcatenation();
              _builder_2.append("undefined");
              return _builder_2;
            } else {
              if ((it instanceof JsonArrayClient)) {
                StringConcatenation _builder_3 = new StringConcatenation();
                _builder_3.append("[");
                _builder_3.newLine();
                _builder_3.append("\t");
                {
                  EList<JsonValueClient> _values = ((JsonArrayClient) it).getValues();
                  boolean _hasElements = false;
                  for(final JsonValueClient value : _values) {
                    if (!_hasElements) {
                      _hasElements = true;
                    } else {
                      _builder_3.appendImmediate(",", "\t");
                    }
                    CharSequence _valueFrom = this.valueFrom(value);
                    _builder_3.append(_valueFrom, "\t");
                  }
                }
                _builder_3.newLineIfNotEmpty();
                _builder_3.append("]");
                _builder_3.newLine();
                return _builder_3;
              }
            }
          }
        }
      }
    }
    return null;
  }

  public String componentName(final ClientAttribute it) {
    if ((it.isList() || it.isTree())) {
      StringConcatenation _builder = new StringConcatenation();
      String _firstUpper = StringExtensions.toFirstUpper(it.getName());
      _builder.append(_firstUpper);
      _builder.append("Item");
      return _builder.toString();
    }
    StringConcatenation _builder_1 = new StringConcatenation();
    String _firstUpper_1 = StringExtensions.toFirstUpper(it.getName());
    _builder_1.append(_firstUpper_1);
    return _builder_1.toString();
  }

  public String componentContainerName(final ClientAttribute it) {
    if ((it.isList() || it.isTree())) {
      StringConcatenation _builder = new StringConcatenation();
      String _firstUpper = StringExtensions.toFirstUpper(it.getName());
      _builder.append(_firstUpper);
      _builder.append("ItemContainer");
      return _builder.toString();
    }
    StringConcatenation _builder_1 = new StringConcatenation();
    String _firstUpper_1 = StringExtensions.toFirstUpper(it.getName());
    _builder_1.append(_firstUpper_1);
    _builder_1.append("Container");
    return _builder_1.toString();
  }

  public String importComponentContainer(final ClientAttribute it, final String subFolder) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((((it.getAttributes().size() > 0) || (it.getActions().size() > 0)) && (!it.isNoComponent()))) {
        _builder.append("import { ");
        String _componentContainerName = this.componentContainerName(it);
        _builder.append(_componentContainerName);
        _builder.append(" } from \".");
        _builder.append(subFolder);
        _builder.append("/");
        String _componentContainerName_1 = this.componentContainerName(it);
        _builder.append(_componentContainerName_1);
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }

  public String importComponent(final ClientAttribute it, final String subFolder) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (((it.isList() || it.isTree()) && (((Object[])Conversions.unwrapArray(it.getAttributes(), Object.class)).length > 0))) {
        _builder.append("import { ");
        String _componentName = this.componentName(it);
        _builder.append(_componentName);
        _builder.append(" } from \"./");
        _builder.append(subFolder);
        _builder.append("/");
        String _componentName_1 = this.componentName(it);
        _builder.append(_componentName_1);
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }

  public boolean hasComplexAttribute(final ClientAttribute it) {
    EList<ClientAttribute> _attributes = it.getAttributes();
    for (final ClientAttribute attribute : _attributes) {
      if (((attribute.getAttributes().size() > 0) || (attribute.getActions().size() > 0))) {
        return true;
      }
    }
    return false;
  }

  public String keyAttributeName(final ClientAttribute it) {
    EList<ClientAttribute> _attributes = it.getAttributes();
    for (final ClientAttribute attribute : _attributes) {
      boolean _isListId = attribute.isListId();
      if (_isListId) {
        return attribute.getName();
      }
    }
    return "id";
  }

  public boolean childrenContain(final ClientAttribute it, final String value) {
    EList<ClientAttribute> _attributes = it.getAttributes();
    for (final ClientAttribute attribute : _attributes) {
      String _name = attribute.getName();
      boolean _equals = Objects.equal(_name, value);
      if (_equals) {
        return true;
      }
    }
    return false;
  }

  public boolean oneChildIsLocationOrStorage(final ClientAttribute it) {
    EList<ClientAttribute> _attributes = it.getAttributes();
    for (final ClientAttribute attribute : _attributes) {
      {
        if ((attribute.isLocation() || attribute.isStorage())) {
          return true;
        }
        EList<ClientAttribute> _attributes_1 = attribute.getAttributes();
        for (final ClientAttribute childAttribute : _attributes_1) {
          if ((childAttribute.isLocation() || childAttribute.isStorage())) {
            return true;
          }
        }
      }
    }
    return false;
  }

  public boolean attributesContain(final List<ClientAttribute> it, final ClientAttribute attribute) {
    for (final ClientAttribute parentAttribute : it) {
      String _name = parentAttribute.getName();
      String _name_1 = attribute.getName();
      boolean _equals = Objects.equal(_name, _name_1);
      if (_equals) {
        return true;
      }
    }
    return false;
  }

  public String depth(final ClientAttribute it, final String prefix) {
    return this.depthRec(it, prefix);
  }

  public String depthRec(final ClientAttribute attr, final String prefix) {
    ClientAttribute clientAttribute = attr;
    final ClientAttribute parent = this.findNextClientAttributeParent(clientAttribute);
    if ((parent != null)) {
      return this.depthRec(parent, (prefix + "../"));
    } else {
      return prefix;
    }
  }

  public String path(final ClientAttribute it) {
    return this.pathRec(it, "");
  }

  public String pathRec(final ClientAttribute attr, final String suffix) {
    ClientAttribute clientAttribute = attr;
    final ClientAttribute parent = this.findNextClientAttributeParent(clientAttribute);
    if ((parent != null)) {
      String _firstLower = StringExtensions.toFirstLower(parent.getName());
      String _plus = (_firstLower + "/");
      String _plus_1 = (_plus + suffix);
      return this.pathRec(parent, _plus_1);
    } else {
      return suffix;
    }
  }

  public List<UiAction> uniqueActions(final ClientAttribute attribute) {
    ArrayList<UiAction> list = new ArrayList<UiAction>();
    EList<UiAction> _actions = attribute.getActions();
    for (final UiAction item : _actions) {
      boolean _contains = this.contains(list, item);
      boolean _not = (!_contains);
      if (_not) {
        list.add(item);
      }
    }
    EList<ClientAttribute> _attributes = attribute.getAttributes();
    for (final ClientAttribute attributeItem : _attributes) {
      EList<UiAction> _actions_1 = attributeItem.getActions();
      for (final UiAction item_1 : _actions_1) {
        boolean _contains_1 = this.contains(list, item_1);
        boolean _not_1 = (!_contains_1);
        if (_not_1) {
          list.add(item_1);
        }
      }
    }
    return list;
  }

  public boolean contains(final List<UiAction> actions, final UiAction action) {
    for (final UiAction item : actions) {
      String _name = item.getTarget().getName();
      String _name_1 = action.getTarget().getName();
      boolean _equals = Objects.equal(_name, _name_1);
      if (_equals) {
        return true;
      }
    }
    return false;
  }

  public String stateRefPath(final ClientAttribute it) {
    return this.elementPathRec(it, "");
  }

  public Boolean isTag(final ClientAttribute it) {
    if ((((((Objects.equal(it.getUiElement(), "TextInput") || Objects.equal(it.getUiElement(), "PasswordInput")) || Objects.equal(it.getUiElement(), "CheckBox")) || 
      Objects.equal(it.getUiElement(), "Select")) || Objects.equal(it.getUiElement(), "Button")) || Objects.equal(it.getUiElement(), "Radio"))) {
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }

  public Boolean isInput(final ClientAttribute it) {
    if ((((Objects.equal(it.getUiElement(), "TextInput") || Objects.equal(it.getUiElement(), "PasswordInput")) || Objects.equal(it.getUiElement(), "CheckBox")) || Objects.equal(it.getUiElement(), "Radio"))) {
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }

  public Boolean isValueInput(final ClientAttribute it) {
    if ((Objects.equal(it.getUiElement(), "TextInput") || Objects.equal(it.getUiElement(), "PasswordInput"))) {
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }

  public Boolean isCheckedInput(final ClientAttribute it) {
    if ((Objects.equal(it.getUiElement(), "CheckBox") || Objects.equal(it.getUiElement(), "Radio"))) {
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }

  public String inputType(final ClientAttribute it) {
    String _uiElement = it.getUiElement();
    boolean _equals = Objects.equal(_uiElement, "TextInput");
    if (_equals) {
      return "text";
    }
    String _uiElement_1 = it.getUiElement();
    boolean _equals_1 = Objects.equal(_uiElement_1, "PasswordInput");
    if (_equals_1) {
      return "password";
    }
    String _uiElement_2 = it.getUiElement();
    boolean _equals_2 = Objects.equal(_uiElement_2, "CheckBox");
    if (_equals_2) {
      return "checkbox";
    }
    String _uiElement_3 = it.getUiElement();
    boolean _equals_3 = Objects.equal(_uiElement_3, "Radio");
    if (_equals_3) {
      return "radio";
    }
    return null;
  }

  public Boolean isSelect(final ClientAttribute it) {
    String _uiElement = it.getUiElement();
    boolean _equals = Objects.equal(_uiElement, "Select");
    if (_equals) {
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }

  public Boolean isButton(final ClientAttribute it) {
    String _uiElement = it.getUiElement();
    boolean _equals = Objects.equal(_uiElement, "Button");
    if (_equals) {
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }

  public Boolean isComponent(final ClientAttribute it) {
    return Boolean.valueOf(((!it.isNoComponent()) && ((it.getAttributes().size() > 0) || (it.getActions().size() > 0))));
  }

  private String elementPathRec(final ClientAttribute attr, final String suffix) {
    ClientAttribute clientAttribute = attr;
    final ClientAttribute parent = this.findNextClientAttributeParent(clientAttribute);
    if ((parent != null)) {
      String _elementPathRec = this.elementPathRec(parent, clientAttribute.getName());
      StringConcatenation _builder = new StringConcatenation();
      {
        int _length = suffix.length();
        boolean _greaterThan = (_length > 0);
        if (_greaterThan) {
          _builder.append(".");
          _builder.append(suffix);
        }
      }
      return (_elementPathRec + _builder);
    } else {
      String _name = clientAttribute.getName();
      StringConcatenation _builder_1 = new StringConcatenation();
      {
        int _length_1 = suffix.length();
        boolean _greaterThan_1 = (_length_1 > 0);
        if (_greaterThan_1) {
          _builder_1.append(".");
          _builder_1.append(suffix);
        }
      }
      return (_name + _builder_1);
    }
  }

  private ClientAttribute findNextClientAttributeParent(final ClientAttribute it) {
    EObject parent = it.eContainer();
    while ((parent != null)) {
      {
        final EObject grandParent = parent.eContainer();
        if ((parent instanceof ClientAttribute)) {
          return ((ClientAttribute) parent);
        }
        parent = grandParent;
      }
    }
    return null;
  }

  public List<CustomVerification> allVerifications(final ClientScenario it) {
    final ArrayList<CustomVerification> verifications = new ArrayList<CustomVerification>();
    EList<ClientWhenThen> _clientWhenThen = it.getClientWhenThen();
    for (final ClientWhenThen clientWhenThenItem : _clientWhenThen) {
      if ((((clientWhenThenItem != null) && (clientWhenThenItem.getThenBlock() != null)) && (clientWhenThenItem.getThenBlock().getVerifications() != null))) {
        verifications.addAll(clientWhenThenItem.getThenBlock().getVerifications());
      }
    }
    return verifications;
  }

  public CharSequence valueFrom(final JsonValueClient it) {
    if (it instanceof JsonObjectClient) {
      return _valueFrom((JsonObjectClient)it);
    } else if (it != null) {
      return _valueFrom(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
