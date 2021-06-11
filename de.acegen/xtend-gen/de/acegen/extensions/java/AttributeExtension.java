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
package de.acegen.extensions.java;

import com.google.common.base.Objects;
import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.AttributeParamRef;
import de.acegen.aceGen.BooleanType;
import de.acegen.aceGen.JsonArray;
import de.acegen.aceGen.JsonDateTime;
import de.acegen.aceGen.JsonMember;
import de.acegen.aceGen.JsonObjectAce;
import de.acegen.aceGen.JsonValue;
import de.acegen.aceGen.LongType;
import de.acegen.aceGen.Model;
import de.acegen.aceGen.NullType;
import de.acegen.aceGen.PrimitiveValue;
import de.acegen.aceGen.StringType;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class AttributeExtension {
  @Inject
  @Extension
  private ModelExtension _modelExtension;
  
  public String stringLineBreak = new Function0<String>() {
    @Override
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(",\" + ");
      _builder.newLine();
      _builder.append("\"");
      return _builder.toString();
    }
  }.apply();
  
  public String resourceParamType(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("String");
    return _builder.toString();
  }
  
  public String resourceParam(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (((it.getType() != null) && it.getType().equals("DateTime"))) {
        _builder.append("LocalDateTime.parse(");
        String _name = it.getName();
        _builder.append(_name);
        _builder.append(", DateTimeFormatter.ISO_DATE_TIME)");
      } else {
        String _name_1 = it.getName();
        _builder.append(_name_1);
      }
    }
    return _builder.toString();
  }
  
  public String initActionData(final AttributeParamRef it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((((it.getAttribute().getType() != null) && it.getAttribute().getType().equals("DateTime")) && (!it.getAttribute().isList()))) {
        {
          boolean _isNotNull = it.isNotNull();
          if (_isNotNull) {
            _builder.append("if (StringUtils.isBlank(");
            String _name = it.getAttribute().getName();
            _builder.append(_name);
            _builder.append(") || \"null\".equals(");
            String _name_1 = it.getAttribute().getName();
            _builder.append(_name_1);
            _builder.append(")) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("return badRequest(\"");
            String _name_2 = it.getAttribute().getName();
            _builder.append(_name_2, "\t");
            _builder.append(" is mandatory\");");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("if (StringUtils.isNotBlank(");
        String _name_3 = it.getAttribute().getName();
        _builder.append(_name_3);
        _builder.append(")) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("try {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("data.");
        String _setterCall = this.setterCall(it.getAttribute(), this.resourceParam(it.getAttribute()));
        _builder.append(_setterCall, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("} catch (Exception x) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("LOG.warn(\"failed to parse dateTime ");
        String _name_4 = it.getAttribute().getName();
        _builder.append(_name_4, "\t\t");
        _builder.append(" - {}\", ");
        String _name_5 = it.getAttribute().getName();
        _builder.append(_name_5, "\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      } else {
        {
          boolean _isNotNull_1 = it.isNotNull();
          if (_isNotNull_1) {
            _builder.append("if (StringUtils.isBlank(");
            String _name_6 = it.getAttribute().getName();
            _builder.append(_name_6);
            _builder.append(") || \"null\".equals(");
            String _name_7 = it.getAttribute().getName();
            _builder.append(_name_7);
            _builder.append(")) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("return badRequest(\"");
            String _name_8 = it.getAttribute().getName();
            _builder.append(_name_8, "\t");
            _builder.append(" is mandatory\");");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          }
        }
        {
          boolean _equals = "Integer".equals(it.getAttribute().getType());
          if (_equals) {
            _builder.append("data.");
            String _setterCall_1 = this.setterCall(it.getAttribute(), this.resourceParam(it.getAttribute()), it.getAttribute().getType(), "Int");
            _builder.append(_setterCall_1);
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          } else {
            boolean _equals_1 = "String".equals(it.getAttribute().getType());
            if (_equals_1) {
              _builder.append("data.");
              String _setterCall_2 = this.setterCall(it.getAttribute(), this.resourceParam(it.getAttribute()));
              _builder.append(_setterCall_2);
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            } else {
              _builder.append("data.");
              String _setterCall_3 = this.setterCall(it.getAttribute(), this.resourceParam(it.getAttribute()), it.getAttribute().getType());
              _builder.append(_setterCall_3);
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
    }
    return _builder.toString();
  }
  
  public String initActionDataFromPayload(final AttributeParamRef it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isNotNull = it.isNotNull();
      if (_isNotNull) {
        {
          if (("String".equals(it.getAttribute().getType()) && (!it.getAttribute().isList()))) {
            _builder.append("if (StringUtils.isBlank(payload.");
            String _terCall = this.getterCall(it.getAttribute());
            _builder.append(_terCall);
            _builder.append(") || \"null\".equals(payload.");
            String _terCall_1 = this.getterCall(it.getAttribute());
            _builder.append(_terCall_1);
            _builder.append(")) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("return badRequest(\"");
            String _name = it.getAttribute().getName();
            _builder.append(_name, "\t");
            _builder.append(" is mandatory\");");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          } else {
            _builder.append("if (payload.");
            String _terCall_2 = this.getterCall(it.getAttribute());
            _builder.append(_terCall_2);
            _builder.append(" == null) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("return badRequest(\"");
            String _name_1 = it.getAttribute().getName();
            _builder.append(_name_1, "\t");
            _builder.append(" is mandatory\");");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("data.");
    Attribute _attribute = it.getAttribute();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("payload.");
    String _terCall_3 = this.getterCall(it.getAttribute());
    _builder_1.append(_terCall_3);
    String _setterCall = this.setterCall(_attribute, _builder_1.toString());
    _builder.append(_setterCall);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public String getterCall(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("get");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("()");
    return _builder.toString();
  }
  
  public String javaType(final Attribute it) {
    String _type = it.getType();
    boolean _tripleNotEquals = (_type != null);
    if (_tripleNotEquals) {
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _isList = it.isList();
        if (_isList) {
          _builder.append("java.util.List<");
        }
      }
      {
        boolean _equals = it.getType().equals("DateTime");
        if (_equals) {
          _builder.append("java.time.LocalDateTime");
        } else {
          String _type_1 = it.getType();
          _builder.append(_type_1);
        }
      }
      {
        boolean _isList_1 = it.isList();
        if (_isList_1) {
          _builder.append(">");
        }
      }
      return _builder.toString();
    }
    Model _model = it.getModel();
    boolean _tripleNotEquals_1 = (_model != null);
    if (_tripleNotEquals_1) {
      StringConcatenation _builder_1 = new StringConcatenation();
      {
        boolean _isList_2 = it.isList();
        if (_isList_2) {
          _builder_1.append("java.util.List<");
        }
      }
      String _interfaceWithPackage = this._modelExtension.interfaceWithPackage(it.getModel());
      _builder_1.append(_interfaceWithPackage);
      {
        boolean _isList_3 = it.isList();
        if (_isList_3) {
          _builder_1.append(">");
        }
      }
      return _builder_1.toString();
    }
    return null;
  }
  
  public String javaTypeNew(final Attribute it) {
    String _type = it.getType();
    boolean _tripleNotEquals = (_type != null);
    if (_tripleNotEquals) {
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _isList = it.isList();
        if (_isList) {
          _builder.append("java.util.ArrayList<");
        }
      }
      {
        boolean _equals = it.getType().equals("DateTime");
        if (_equals) {
          _builder.append("java.time.LocalDateTime");
        } else {
          String _type_1 = it.getType();
          _builder.append(_type_1);
        }
      }
      {
        boolean _isList_1 = it.isList();
        if (_isList_1) {
          _builder.append(">");
        }
      }
      return _builder.toString();
    }
    Model _model = it.getModel();
    boolean _tripleNotEquals_1 = (_model != null);
    if (_tripleNotEquals_1) {
      StringConcatenation _builder_1 = new StringConcatenation();
      {
        boolean _isList_2 = it.isList();
        if (_isList_2) {
          _builder_1.append("java.util.ArrayList<");
        }
      }
      String _interfaceWithPackage = this._modelExtension.interfaceWithPackage(it.getModel());
      _builder_1.append(_interfaceWithPackage);
      {
        boolean _isList_3 = it.isList();
        if (_isList_3) {
          _builder_1.append(">");
        }
      }
      return _builder_1.toString();
    }
    return null;
  }
  
  public List<Integer> timesIterator(final int length) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    for (int i = 0; (i < length); i++) {
      list.add(Integer.valueOf(i));
    }
    return list;
  }
  
  public String mapperInit(final Attribute it) {
    String _type = it.getType();
    boolean _tripleNotEquals = (_type != null);
    if (_tripleNotEquals) {
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _isList = it.isList();
        if (_isList) {
          _builder.append("null");
        } else {
          String _type_1 = it.getType();
          boolean _equals = Objects.equal(_type_1, "DateTime");
          if (_equals) {
            _builder.append("this.mapToDateTime(r, \"");
            String _name = it.getName();
            _builder.append(_name);
            _builder.append("\")");
          } else {
            _builder.append("this.mapTo");
            String _javaType = this.javaType(it);
            _builder.append(_javaType);
            _builder.append("(r, \"");
            String _name_1 = it.getName();
            _builder.append(_name_1);
            _builder.append("\")");
          }
        }
      }
      return _builder.toString();
    }
    Model _model = it.getModel();
    boolean _tripleNotEquals_1 = (_model != null);
    if (_tripleNotEquals_1) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("null");
      return _builder_1.toString();
    }
    return null;
  }
  
  public String sqlType(final Attribute it) {
    String _xifexpression = null;
    String _type = it.getType();
    boolean _tripleNotEquals = (_type != null);
    if (_tripleNotEquals) {
      String _switchResult = null;
      String _type_1 = it.getType();
      if (_type_1 != null) {
        switch (_type_1) {
          case "Integer":
            _switchResult = "integer";
            break;
          case "Long":
            _switchResult = "bigint";
            break;
          case "String":
            _switchResult = "character varying";
            break;
          case "Float":
            _switchResult = "numeric";
            break;
          case "Boolean":
            _switchResult = "boolean";
            break;
          case "DateTime":
            _switchResult = "timestamp with time zone";
            break;
        }
      }
      _xifexpression = _switchResult;
    }
    return _xifexpression;
  }
  
  public String randomValue(final Attribute it) {
    String _xifexpression = null;
    String _type = it.getType();
    boolean _tripleNotEquals = (_type != null);
    if (_tripleNotEquals) {
      String _switchResult = null;
      String _type_1 = it.getType();
      if (_type_1 != null) {
        switch (_type_1) {
          case "Integer":
            _switchResult = "random.nextInt(50)";
            break;
          case "Long":
            _switchResult = "random.nextLong()";
            break;
          case "String":
            _switchResult = "randomString(random)";
            break;
          case "Float":
            _switchResult = "random.nextFloat()";
            break;
          case "Boolean":
            _switchResult = "random.nextBoolean()";
            break;
          case "DateTime":
            _switchResult = "random.nextBoolean() ? java.time.LocalDateTime.now().plusMinutes(random.nextInt(60)) : java.time.LocalDateTime.now().minusMinutes(random.nextInt(60)) ";
            break;
        }
      }
      _xifexpression = _switchResult;
    }
    return _xifexpression;
  }
  
  public String tableName(final Attribute it) {
    String _xifexpression = null;
    String _type = it.getType();
    boolean _tripleNotEquals = (_type != null);
    if (_tripleNotEquals) {
      StringConcatenation _builder = new StringConcatenation();
      EObject _eContainer = it.eContainer();
      String _tableFkRef = this._modelExtension.tableFkRef(((Model) _eContainer));
      _builder.append(_tableFkRef);
      _xifexpression = _builder.toString();
    }
    return _xifexpression;
  }
  
  public String declaration(final Attribute it) {
    String _type = it.getType();
    boolean _tripleNotEquals = (_type != null);
    if (_tripleNotEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("private ");
      String _javaType = this.javaType(it);
      _builder.append(_javaType);
      _builder.append(" ");
      String _firstLower = StringExtensions.toFirstLower(it.getName());
      _builder.append(_firstLower);
      {
        boolean _equals = it.getType().equals("Boolean");
        if (_equals) {
          _builder.append(" = false");
        }
      }
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      return _builder.toString();
    }
    Model _model = it.getModel();
    boolean _tripleNotEquals_1 = (_model != null);
    if (_tripleNotEquals_1) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("private ");
      String _javaType_1 = this.javaType(it);
      _builder_1.append(_javaType_1);
      _builder_1.append(" ");
      String _name = it.getName();
      _builder_1.append(_name);
      _builder_1.append(";");
      _builder_1.newLineIfNotEmpty();
      return _builder_1.toString();
    }
    return null;
  }
  
  public String paramAsJsonProperty(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@JsonProperty(\"");
    String _name = it.getName();
    _builder.append(_name);
    _builder.append("\") ");
    String _param = this.param(it);
    _builder.append(_param);
    return _builder.toString();
  }
  
  public String param(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    String _javaType = this.javaType(it);
    _builder.append(_javaType);
    _builder.append(" ");
    String _name = it.getName();
    _builder.append(_name);
    return _builder.toString();
  }
  
  public String interfaceGetter(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    String _javaType = this.javaType(it);
    _builder.append(_javaType);
    _builder.append(" get");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("();");
    return _builder.toString();
  }
  
  public String interfaceSetter(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("void set");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("(");
    String _javaType = this.javaType(it);
    _builder.append(_javaType);
    _builder.append(" ");
    String _firstLower = StringExtensions.toFirstLower(it.getName());
    _builder.append(_firstLower);
    _builder.append(");");
    return _builder.toString();
  }
  
  public String assign(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("this.");
    String _name = it.getName();
    _builder.append(_name);
    _builder.append(" = ");
    String _name_1 = it.getName();
    _builder.append(_name_1);
    _builder.append(";");
    return _builder.toString();
  }
  
  public String deepCopy(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isList = it.isList();
      boolean _not = (!_isList);
      if (_not) {
        {
          String _type = it.getType();
          boolean _tripleNotEquals = (_type != null);
          if (_tripleNotEquals) {
            _builder.append("copy.");
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("this.");
            String _terCall = this.getterCall(it);
            _builder_1.append(_terCall);
            String _setterCall = this.setterCall(it, _builder_1.toString());
            _builder.append(_setterCall);
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          } else {
            Model _model = it.getModel();
            boolean _tripleNotEquals_1 = (_model != null);
            if (_tripleNotEquals_1) {
              _builder.append("copy.");
              StringConcatenation _builder_2 = new StringConcatenation();
              _builder_2.append("this.");
              String _terCall_1 = this.getterCall(it);
              _builder_2.append(_terCall_1);
              _builder_2.append(".deepCopy()");
              String _setterCall_1 = this.setterCall(it, _builder_2.toString());
              _builder.append(_setterCall_1);
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      } else {
        {
          String _type_1 = it.getType();
          boolean _tripleNotEquals_2 = (_type_1 != null);
          if (_tripleNotEquals_2) {
            _builder.append("List<");
            String _type_2 = it.getType();
            _builder.append(_type_2);
            _builder.append("> ");
            String _name = it.getName();
            _builder.append(_name);
            _builder.append("Copy = new ArrayList<");
            String _type_3 = it.getType();
            _builder.append(_type_3);
            _builder.append(">();");
            _builder.newLineIfNotEmpty();
            _builder.append("for(");
            String _type_4 = it.getType();
            _builder.append(_type_4);
            _builder.append(" item: this.");
            String _terCall_2 = this.getterCall(it);
            _builder.append(_terCall_2);
            _builder.append(") {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            String _name_1 = it.getName();
            _builder.append(_name_1, "\t");
            _builder.append("Copy.add(item);");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          } else {
            Model _model_1 = it.getModel();
            boolean _tripleNotEquals_3 = (_model_1 != null);
            if (_tripleNotEquals_3) {
              _builder.append("List<");
              String _interfaceWithPackage = this._modelExtension.interfaceWithPackage(it.getModel());
              _builder.append(_interfaceWithPackage);
              _builder.append("> ");
              String _name_2 = it.getName();
              _builder.append(_name_2);
              _builder.append("Copy = new ArrayList<");
              String _interfaceWithPackage_1 = this._modelExtension.interfaceWithPackage(it.getModel());
              _builder.append(_interfaceWithPackage_1);
              _builder.append(">();");
              _builder.newLineIfNotEmpty();
              _builder.append("for(");
              String _interfaceWithPackage_2 = this._modelExtension.interfaceWithPackage(it.getModel());
              _builder.append(_interfaceWithPackage_2);
              _builder.append(" item: this.");
              String _terCall_3 = this.getterCall(it);
              _builder.append(_terCall_3);
              _builder.append(") {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              String _name_3 = it.getName();
              _builder.append(_name_3, "\t");
              _builder.append("Copy.add(item.deepCopy());");
              _builder.newLineIfNotEmpty();
              _builder.append("}");
              _builder.newLine();
            }
          }
        }
        _builder.append("copy.");
        StringConcatenation _builder_3 = new StringConcatenation();
        String _name_4 = it.getName();
        _builder_3.append(_name_4);
        _builder_3.append("Copy");
        String _setterCall_2 = this.setterCall(it, _builder_3.toString());
        _builder.append(_setterCall_2);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  public String getter(final Attribute it, final boolean jsonProperty) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (jsonProperty) {
        _builder.append("@JsonProperty");
        _builder.newLine();
        {
          if (((it.getType() != null) && it.getType().equals("DateTime"))) {
            _builder.append("@JsonSerialize(converter = DateTimeToStringConverter.class)");
            _builder.newLineIfNotEmpty();
            _builder.append("@JsonDeserialize(converter = StringToDateTimeConverter.class)");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public ");
    String _javaType = this.javaType(it);
    _builder.append(_javaType);
    _builder.append(" get");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return this.");
    String _name = it.getName();
    _builder.append(_name, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  public String with(final Attribute it, final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public ");
    String _dataInterfaceName = this._modelExtension.dataInterfaceName(model);
    _builder.append(_dataInterfaceName);
    _builder.append(" with");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("(");
    String _javaType = this.javaType(it);
    _builder.append(_javaType);
    _builder.append(" ");
    String _name = it.getName();
    _builder.append(_name);
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("this.");
    String _name_1 = it.getName();
    _builder.append(_name_1, "\t");
    _builder.append(" = ");
    String _name_2 = it.getName();
    _builder.append(_name_2, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return this;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  public String setter(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public void set");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("(");
    String _javaType = this.javaType(it);
    _builder.append(_javaType);
    _builder.append(" ");
    String _name = it.getName();
    _builder.append(_name);
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("this.");
    String _name_1 = it.getName();
    _builder.append(_name_1, "\t");
    _builder.append(" = ");
    String _name_2 = it.getName();
    _builder.append(_name_2, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  public String setterCall(final Attribute it, final String param) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("set");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("(");
    _builder.append(param);
    _builder.append(")");
    return _builder.toString();
  }
  
  public String setterCall(final Attribute it, final String param, final String type) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("set");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("(\"null\".equals(");
    _builder.append(param);
    _builder.append(") ? null : ");
    _builder.append(type);
    _builder.append(".parse");
    String _firstUpper_1 = StringExtensions.toFirstUpper(type);
    _builder.append(_firstUpper_1);
    _builder.append("(");
    _builder.append(param);
    _builder.append("))");
    return _builder.toString();
  }
  
  public String setterCall(final Attribute it, final String param, final String type, final String parse) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("set");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("(\"null\".equals(");
    _builder.append(param);
    _builder.append(") ? null : ");
    _builder.append(type);
    _builder.append(".parse");
    _builder.append(parse);
    _builder.append("(");
    _builder.append(param);
    _builder.append("))");
    return _builder.toString();
  }
  
  public boolean isPrimitive(final Attribute it) {
    return ((!it.isList()) && (it.getModel() == null));
  }
  
  public LocalDateTime dateTimeParse(final String dateString, final String pattern) {
    try {
      return LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern(pattern));
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  protected CharSequence _valueFrom(final JsonObjectAce it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((((it != null) && (it.getMembers() != null)) && (it.getMembers().size() > 0))) {
        _builder.append("{ ");
        {
          EList<JsonMember> _members = it.getMembers();
          boolean _hasElements = false;
          for(final JsonMember member : _members) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(this.stringLineBreak, "");
            }
            _builder.append("\\\"");
            String _name = member.getAttribute().getName();
            _builder.append(_name);
            _builder.append("\\\" : ");
            CharSequence _valueFrom = this.valueFrom(member.getValue());
            _builder.append(_valueFrom);
          }
        }
        _builder.append("}");
      } else {
        _builder.append("{}");
      }
    }
    return _builder;
  }
  
  protected CharSequence _valueFrom(final String it) {
    return this.valueFromString(it);
  }
  
  protected CharSequence _valueFrom(final JsonValue it) {
    if ((it instanceof StringType)) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\\\"");
      CharSequence _valueFromString = this.valueFromString(((StringType)it).getString());
      _builder.append(_valueFromString);
      _builder.append("\\\"");
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
          }
        }
      }
    }
    return null;
  }
  
  protected CharSequence _nonDeterministicValueFrom(final JsonObjectAce it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("null");
    return _builder;
  }
  
  protected CharSequence _nonDeterministicValueFrom(final String it) {
    return this.valueFromString(it);
  }
  
  protected CharSequence _nonDeterministicValueFrom(final JsonValue it) {
    if ((it instanceof StringType)) {
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _valueFromString = this.valueFromString(((StringType)it).getString());
      _builder.append(_valueFromString);
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
          }
        }
      }
    }
    return null;
  }
  
  public CharSequence valueFromString(final String it) {
    String returnString = it;
    boolean _contains = it.contains("${random}");
    if (_contains) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\" + this.randomString() + \"");
      returnString = returnString.replace("${random}", _builder);
    }
    boolean _contains_1 = it.contains("${testId}");
    if (_contains_1) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("\" + this.getTestId() + \"");
      returnString = returnString.replace("${testId}", _builder_1);
    }
    while (returnString.contains("${")) {
      {
        final int beginIndex = returnString.indexOf("${");
        final int endIndex = returnString.indexOf("}");
        final String templateString = returnString.substring(beginIndex, (endIndex + 1));
        final String templateStringName = returnString.substring((beginIndex + 2), endIndex);
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("\" + this.extractedValues.get(\"");
        _builder_2.append(templateStringName);
        _builder_2.append("\").toString() + \"");
        returnString = returnString.replace(templateString, _builder_2);
      }
    }
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append(returnString);
    return _builder_2;
  }
  
  protected CharSequence _valueFrom(final JsonArray it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((((it != null) && (it.getValues() != null)) && (it.getValues().size() > 0))) {
        _builder.append("[ ");
        {
          EList<JsonValue> _values = it.getValues();
          boolean _hasElements = false;
          for(final JsonValue value : _values) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(this.stringLineBreak, "");
            }
            CharSequence _valueFrom = this.valueFrom(value);
            _builder.append(_valueFrom);
          }
        }
        _builder.append("]");
      } else {
        _builder.append("[]");
      }
    }
    return _builder;
  }
  
  protected CharSequence _valueFrom(final JsonDateTime it) {
    boolean _contains = it.getDateTime().contains("${");
    if (_contains) {
      final int beginIndex = it.getDateTime().indexOf("${");
      final int endIndex = it.getDateTime().indexOf("}");
      final String templateStringName = it.getDateTime().substring((beginIndex + 2), endIndex);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\\\"\" + LocalDateTime.parse(this.extractedValues.get(\"");
      _builder.append(templateStringName);
      _builder.append("\").toString(), DateTimeFormatter.ofPattern(\"");
      String _pattern = it.getPattern();
      _builder.append(_pattern);
      _builder.append("\"))  + \"\\\"");
      return _builder;
    }
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("\\\"");
    LocalDateTime _dateTimeParse = this.dateTimeParse(it.getDateTime(), it.getPattern());
    _builder_1.append(_dateTimeParse);
    _builder_1.append("\\\"");
    return _builder_1;
  }
  
  public Object primitiveValueFrom(final PrimitiveValue it) {
    String _string = it.getString();
    boolean _tripleNotEquals = (_string != null);
    if (_tripleNotEquals) {
      String returnString = it.getString();
      boolean _contains = it.getString().contains("${testId}");
      if (_contains) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("\" + this.getTestId() + \"");
        returnString = returnString.replace("${testId}", _builder);
      } else {
        boolean _contains_1 = it.getString().contains("${");
        if (_contains_1) {
          final int beginIndex = it.getString().indexOf("${");
          final int endIndex = it.getString().indexOf("}");
          final String templateString = it.getString().substring(beginIndex, (endIndex + 1));
          final String templateStringName = it.getString().substring((beginIndex + 2), endIndex);
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("\" + this.extractedValues.get(\"");
          _builder_1.append(templateStringName);
          _builder_1.append("\").toString() + \"");
          returnString = returnString.replace(templateString, _builder_1);
        }
      }
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("\"");
      _builder_2.append(returnString);
      _builder_2.append("\"");
      return _builder_2.toString();
    }
    return Integer.valueOf(it.getLong());
  }
  
  public CharSequence valueFrom(final Object it) {
    if (it instanceof JsonObjectAce) {
      return _valueFrom((JsonObjectAce)it);
    } else if (it instanceof JsonArray) {
      return _valueFrom((JsonArray)it);
    } else if (it instanceof JsonDateTime) {
      return _valueFrom((JsonDateTime)it);
    } else if (it instanceof JsonValue) {
      return _valueFrom((JsonValue)it);
    } else if (it instanceof String) {
      return _valueFrom((String)it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
  
  public CharSequence nonDeterministicValueFrom(final Object it) {
    if (it instanceof JsonObjectAce) {
      return _nonDeterministicValueFrom((JsonObjectAce)it);
    } else if (it instanceof JsonValue) {
      return _nonDeterministicValueFrom((JsonValue)it);
    } else if (it instanceof String) {
      return _nonDeterministicValueFrom((String)it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
