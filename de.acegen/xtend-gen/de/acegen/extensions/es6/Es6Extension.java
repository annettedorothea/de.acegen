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
import de.acegen.aceGen.FunctionCall;
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
import de.acegen.aceGen.UndefinedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
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
  
  protected String _appStateFunction(final HttpClientStateFunction it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(data) => {");
    _builder.newLine();
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
  
  protected String _appStateFunction(final FunctionCall it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(data) => {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("AppState.");
    String _name = it.getFunction().getName();
    _builder.append(_name, "\t\t");
    _builder.append("(");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("data");
    {
      ClientAttribute _stateElement = it.getFunction().getStateElement();
      boolean _tripleNotEquals = (_stateElement != null);
      if (_tripleNotEquals) {
        _builder.append(",");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        String _path = this.path(this.paramList(it.getFunction().getStateElement()));
        _builder.append(_path, "\t\t\t");
        {
          if (((it.getFunction().getStateElement().getAttributes().size() > 0) && (!it.getFunction().getStateElement().isList()))) {
            _builder.append(", ");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t");
            _builder.append("[");
            {
              EList<ClientAttribute> _attributes = it.getFunction().getStateElement().getAttributes();
              boolean _hasElements = false;
              for(final ClientAttribute attribute : _attributes) {
                if (!_hasElements) {
                  _hasElements = true;
                } else {
                  _builder.appendImmediate(", ", "\t\t\t");
                }
                _builder.append("\"");
                String _name_1 = attribute.getName();
                _builder.append(_name_1, "\t\t\t");
                _builder.append("\"");
              }
            }
            _builder.append("]");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append(")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    return _builder.toString();
  }
  
  public CharSequence stateFunctionCall(final ClientAttribute it, final String functionName, final String data) {
    StringConcatenation _builder = new StringConcatenation();
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
    String _path = this.path(this.paramList(it));
    _builder.append(_path, "\t");
    {
      if ((((!Objects.equal(functionName, "get")) && (it.getAttributes().size() > 0)) && (!it.isList()))) {
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
            String _name = attribute.getName();
            _builder.append(_name, "\t");
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
    boolean _isList = it.isList();
    if (_isList) {
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
  
  public String importComponent(final ClientAttribute it, final String subFolder) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (((it.getAttributes().size() > 0) && (!it.isNoComponent()))) {
        _builder.append("import { ");
        String _componentName = this.componentName(it);
        _builder.append(_componentName);
        _builder.append(" } from \".");
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
  
  public String stateRefPath(final ClientAttribute it) {
    return this.elementPathRec(it, "");
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
  
  public List<String> allVerifications(final ClientScenario it) {
    final ArrayList<String> verifications = new ArrayList<String>();
    EList<ClientWhenThen> _clientWhenThen = it.getClientWhenThen();
    for (final ClientWhenThen clientWhenThenItem : _clientWhenThen) {
      if ((((clientWhenThenItem != null) && (clientWhenThenItem.getThenBlock() != null)) && (clientWhenThenItem.getThenBlock().getVerifications() != null))) {
        verifications.addAll(clientWhenThenItem.getThenBlock().getVerifications());
      }
    }
    return verifications;
  }
  
  public String appStateFunction(final EObject it) {
    if (it instanceof FunctionCall) {
      return _appStateFunction((FunctionCall)it);
    } else if (it instanceof HttpClientStateFunction) {
      return _appStateFunction((HttpClientStateFunction)it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
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
