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

import de.acegen.aceGen.BooleanType;
import de.acegen.aceGen.ClientAttribute;
import de.acegen.aceGen.ClientGivenRef;
import de.acegen.aceGen.ClientScenario;
import de.acegen.aceGen.ClientWhenBlock;
import de.acegen.aceGen.GroupedClientAttribute;
import de.acegen.aceGen.HttpClient;
import de.acegen.aceGen.HttpClientAce;
import de.acegen.aceGen.HttpClientOutcome;
import de.acegen.aceGen.HttpClientStateFunction;
import de.acegen.aceGen.JsonArrayClient;
import de.acegen.aceGen.JsonMemberClient;
import de.acegen.aceGen.JsonObjectClient;
import de.acegen.aceGen.JsonValueClient;
import de.acegen.aceGen.LongType;
import de.acegen.aceGen.NullType;
import de.acegen.aceGen.PrimitiveValue;
import de.acegen.aceGen.SingleClientAttribute;
import de.acegen.aceGen.StringType;
import de.acegen.aceGen.TriggerdAceOperation;
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
  
  public String appStateFunction(final HttpClientStateFunction it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(data) => ");
    SingleClientAttribute _stateElement = it.getStateElement();
    StringConcatenation _builder_1 = new StringConcatenation();
    String _stateFunctionType = it.getStateFunctionType();
    _builder_1.append(_stateFunctionType);
    CharSequence _stateFunctionCall = this.stateFunctionCall(_stateElement, _builder_1.toString(), "data");
    _builder.append(_stateFunctionCall);
    return _builder.toString();
  }
  
  public CharSequence stateFunctionCall(final SingleClientAttribute it, final String functionName, final String data) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("AppUtils.");
    String _stateFunctionName = this.stateFunctionName(it, functionName);
    _builder.append(_stateFunctionName);
    _builder.append("(");
    {
      if ((functionName != "get")) {
        _builder.append(data);
        _builder.append(", ");
      }
    }
    _builder.append("[");
    {
      List<String> _paramList = this.paramList(it);
      boolean _hasElements = false;
      for(final String param : _paramList) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        _builder.append(param);
      }
    }
    _builder.append("]");
    {
      if (((it.getAttributes().size() > 0) && (functionName == "merge"))) {
        _builder.append(", [");
        {
          EList<ClientAttribute> _attributes = it.getAttributes();
          boolean _hasElements_1 = false;
          for(final ClientAttribute attribute : _attributes) {
            if (!_hasElements_1) {
              _hasElements_1 = true;
            } else {
              _builder.appendImmediate(", ", "");
            }
            _builder.append("\"");
            String _name = attribute.getName();
            _builder.append(_name);
            _builder.append("\"");
          }
        }
        _builder.append("]");
      }
    }
    _builder.append(")");
    return _builder;
  }
  
  public List<String> paramList(final SingleClientAttribute it) {
    ArrayList<String> paramList = new ArrayList<String>();
    List<ClientAttribute> _allParentAttributesInclusiveItem = this.allParentAttributesInclusiveItem(it);
    for (final ClientAttribute item : _allParentAttributesInclusiveItem) {
      EObject _eContainer = item.eContainer();
      if ((_eContainer instanceof GroupedClientAttribute)) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("[\"");
        EObject _eContainer_1 = item.eContainer();
        String _name = ((GroupedClientAttribute) _eContainer_1).getName();
        _builder.append(_name);
        _builder.append("\", \"");
        String _name_1 = item.getName();
        _builder.append(_name_1);
        _builder.append("\"]");
        paramList.add(_builder.toString());
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("\"");
        String _name_2 = item.getName();
        _builder_1.append(_name_2);
        _builder_1.append("\"");
        paramList.add(_builder_1.toString());
      }
    }
    return paramList;
  }
  
  public String stateFunctionName(final SingleClientAttribute it, final String functionName) {
    boolean _isHash = it.isHash();
    if (_isHash) {
      return (functionName + "Hash");
    }
    boolean _isStorage = it.isStorage();
    if (_isStorage) {
      return (functionName + "Storage");
    }
    return functionName;
  }
  
  public String functionName(final SingleClientAttribute it) {
    StringConcatenation _builder = new StringConcatenation();
    String _functionNameRec = this.functionNameRec(it, "");
    _builder.append(_functionNameRec);
    return _builder.toString();
  }
  
  public String functionNameRec(final ClientAttribute it, final String suffix) {
    final SingleClientAttribute parent = this.findNextSingleClientAttributeParent(it);
    if ((parent != null)) {
      String _functionNameRec = this.functionNameRec(parent, it.getName());
      StringConcatenation _builder = new StringConcatenation();
      {
        int _length = suffix.length();
        boolean _greaterThan = (_length > 0);
        if (_greaterThan) {
          _builder.append("_");
          _builder.append(suffix);
        }
      }
      return (_functionNameRec + _builder);
    } else {
      String _name = it.getName();
      StringConcatenation _builder_1 = new StringConcatenation();
      {
        int _length_1 = suffix.length();
        boolean _greaterThan_1 = (_length_1 > 0);
        if (_greaterThan_1) {
          _builder_1.append("_");
          _builder_1.append(suffix);
        }
      }
      return (_name + _builder_1);
    }
  }
  
  public String elementPath(final ClientAttribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("appState.");
    String _elementPathRec = this.elementPathRec(it, "");
    _builder.append(_elementPathRec);
    return _builder.toString();
  }
  
  public String elementPathRec(final ClientAttribute attr, final String suffix) {
    ClientAttribute clientAttribute = attr;
    EObject _eContainer = clientAttribute.eContainer();
    if ((_eContainer instanceof GroupedClientAttribute)) {
      EObject _eContainer_1 = attr.eContainer();
      clientAttribute = ((ClientAttribute) _eContainer_1);
    }
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
  
  public SingleClientAttribute findNextSingleClientAttributeParent(final ClientAttribute it) {
    EObject parent = it.eContainer();
    while ((parent != null)) {
      {
        if ((parent instanceof SingleClientAttribute)) {
          return ((SingleClientAttribute) parent);
        }
        parent = parent.eContainer();
      }
    }
    return null;
  }
  
  public SingleClientAttribute findNextNonListSingleClientAttributeParent(final ClientAttribute it) {
    SingleClientAttribute _xblockexpression = null;
    {
      ArrayList<SingleClientAttribute> parentList = new ArrayList<SingleClientAttribute>();
      if ((it instanceof SingleClientAttribute)) {
        final SingleClientAttribute me = ((SingleClientAttribute) it);
        int _size = me.getAttributes().size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          parentList.add(me);
        }
      }
      EObject parent = it.eContainer();
      while ((parent != null)) {
        {
          if ((parent instanceof SingleClientAttribute)) {
            parentList.add(((SingleClientAttribute) parent));
          }
          parent = parent.eContainer();
        }
      }
      int _size_1 = parentList.size();
      boolean _tripleEquals = (_size_1 == 0);
      if (_tripleEquals) {
        return null;
      }
      int _size_2 = parentList.size();
      int i = (_size_2 - 1);
      while ((i >= 0)) {
        {
          boolean _isList = parentList.get(i).isList();
          if (_isList) {
            int _size_3 = parentList.size();
            int _minus = (_size_3 - 1);
            boolean _lessEqualsThan = ((i + 1) <= _minus);
            if (_lessEqualsThan) {
              return parentList.get((i + 1));
            } else {
              return null;
            }
          }
          i--;
        }
      }
      SingleClientAttribute _xifexpression = null;
      boolean _isList = parentList.get(0).isList();
      if (_isList) {
        return null;
      } else {
        _xifexpression = parentList.get(0);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  private ClientAttribute findNextClientAttributeParent(final ClientAttribute it) {
    EObject parent = it.eContainer();
    while ((parent != null)) {
      {
        final EObject grandParent = parent.eContainer();
        if (((grandParent != null) && (grandParent instanceof GroupedClientAttribute))) {
          return ((GroupedClientAttribute) grandParent);
        } else {
          if ((parent instanceof SingleClientAttribute)) {
            return ((SingleClientAttribute) parent);
          }
        }
        parent = grandParent;
      }
    }
    return null;
  }
  
  public List<ClientAttribute> allParentAttributesInclusiveItem(final ClientAttribute it) {
    ArrayList<ClientAttribute> attributes = new ArrayList<ClientAttribute>();
    attributes.add(it);
    EObject parent = it.eContainer();
    while ((parent != null)) {
      {
        final EObject grandParent = parent.eContainer();
        if ((parent instanceof SingleClientAttribute)) {
          attributes.add(0, ((SingleClientAttribute) parent));
        }
        parent = grandParent;
      }
    }
    return attributes;
  }
  
  public List<ClientAttribute> allParentAttributes(final ClientAttribute it) {
    ArrayList<ClientAttribute> attributes = new ArrayList<ClientAttribute>();
    EObject parent = it.eContainer();
    while ((parent != null)) {
      {
        final EObject grandParent = parent.eContainer();
        if ((parent instanceof SingleClientAttribute)) {
          attributes.add(0, ((SingleClientAttribute) parent));
        }
        parent = grandParent;
      }
    }
    return attributes;
  }
  
  public List<HttpClient> allReferencedHttpClients(final ClientScenario it) {
    ArrayList<HttpClient> list = new ArrayList<HttpClient>();
    this.allReferencedHttpClientsRec(it, list);
    return list;
  }
  
  public void allReferencedHttpClientsRec(final ClientScenario it, final ArrayList<HttpClient> list) {
    ClientWhenBlock _whenBlock = it.getWhenBlock();
    boolean _tripleNotEquals = (_whenBlock != null);
    if (_tripleNotEquals) {
      EObject _eContainer = it.getWhenBlock().getAction().eContainer();
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
        _builder.newLine();
        _builder.append("\t\t");
      } else {
        _builder.append("{}");
        _builder.newLineIfNotEmpty();
      }
    }
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
  
  public int numberOfAsyncCalls(final HttpClientAce it) {
    int number = 0;
    if ((it.isAsync() || (it.getServerCall() != null))) {
      number = 1;
    }
    EList<HttpClientOutcome> _outcomes = it.getOutcomes();
    for (final HttpClientOutcome outcome : _outcomes) {
      int _size = outcome.getTriggerdAceOperations().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        EList<TriggerdAceOperation> _triggerdAceOperations = outcome.getTriggerdAceOperations();
        for (final TriggerdAceOperation triggered : _triggerdAceOperations) {
          if ((triggered.getAceOperation().isAsync() || (triggered.getAceOperation().getServerCall() != null))) {
            number = 2;
          }
        }
      }
    }
    return number;
  }
  
  public int numberOfSyncCalls(final HttpClientAce it) {
    int number = 0;
    if (((!it.isAsync()) && (it.getServerCall() == null))) {
      number = 1;
    }
    EList<HttpClientOutcome> _outcomes = it.getOutcomes();
    for (final HttpClientOutcome outcome : _outcomes) {
      int _size = outcome.getTriggerdAceOperations().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        EList<TriggerdAceOperation> _triggerdAceOperations = outcome.getTriggerdAceOperations();
        for (final TriggerdAceOperation triggered : _triggerdAceOperations) {
          if (((!triggered.getAceOperation().isAsync()) && (triggered.getAceOperation().getServerCall() == null))) {
            number = 2;
          }
        }
      }
    }
    return number;
  }
  
  protected String _componentName(final SingleClientAttribute it) {
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
  
  protected String _componentName(final GroupedClientAttribute it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    return _builder.toString();
  }
  
  protected String _importComponent(final SingleClientAttribute it, final String subFolder) {
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
  
  protected String _importComponent(final GroupedClientAttribute it, final String subFolder) {
    StringConcatenation _builder = new StringConcatenation();
    {
      int _size = it.getAttributeGroup().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
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
  
  protected String _stateRefPath(final GroupedClientAttribute it) {
    return this.elementPathRec(it, "");
  }
  
  protected String _stateRefPath(final SingleClientAttribute it) {
    return this.elementPathRec(it, "");
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
  
  public String componentName(final ClientAttribute it) {
    if (it instanceof GroupedClientAttribute) {
      return _componentName((GroupedClientAttribute)it);
    } else if (it instanceof SingleClientAttribute) {
      return _componentName((SingleClientAttribute)it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
  
  public String importComponent(final ClientAttribute it, final String subFolder) {
    if (it instanceof GroupedClientAttribute) {
      return _importComponent((GroupedClientAttribute)it, subFolder);
    } else if (it instanceof SingleClientAttribute) {
      return _importComponent((SingleClientAttribute)it, subFolder);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, subFolder).toString());
    }
  }
  
  public String stateRefPath(final ClientAttribute it) {
    if (it instanceof GroupedClientAttribute) {
      return _stateRefPath((GroupedClientAttribute)it);
    } else if (it instanceof SingleClientAttribute) {
      return _stateRefPath((SingleClientAttribute)it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
