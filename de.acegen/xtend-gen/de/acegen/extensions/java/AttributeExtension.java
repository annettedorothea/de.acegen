/**
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 * 
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */
package de.acegen.extensions.java;

import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.JsonArray;
import de.acegen.aceGen.JsonDateTime;
import de.acegen.aceGen.JsonMember;
import de.acegen.aceGen.JsonObject;
import de.acegen.aceGen.JsonValue;
import de.acegen.aceGen.Model;
import de.acegen.extensions.java.ModelExtension;
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
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;

@SuppressWarnings("all")
public class AttributeExtension {
  @Inject
  @Extension
  private ModelExtension _modelExtension;
  
  private int index = 0;
  
  public String stringLineBreak = new Function0<String>() {
    @Override
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(",\" + ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("\"");
      return _builder.toString();
    }
  }.apply();
  
  public void resetIndex() {
    this.index = 0;
  }
  
  public String resourceParamType(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _equals = it.getType().equals("DateTime");
      if (_equals) {
        _builder.append("String");
      } else {
        String _type = it.getType();
        _builder.append(_type);
      }
    }
    return _builder.toString();
  }
  
  public String resourceParam(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _equals = it.getType().equals("DateTime");
      if (_equals) {
        _builder.append("new DateTime(");
        String _name = it.getName();
        _builder.append(_name);
        _builder.append(").withZone(DateTimeZone.UTC)");
      } else {
        String _name_1 = it.getName();
        _builder.append(_name_1);
      }
    }
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
          _builder.append("org.joda.time.DateTime");
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
          boolean _equals = it.getType().equals("DateTime");
          if (_equals) {
            _builder.append("r.getTimestamp(\"");
            String _name = it.getName();
            _builder.append(_name);
            _builder.append("\") != null ? new org.joda.time.DateTime(r.getTimestamp(\"");
            String _name_1 = it.getName();
            _builder.append(_name_1);
            _builder.append("\")).withZone(org.joda.time.DateTimeZone.UTC) : null");
          } else {
            boolean _equals_1 = it.getType().equals("Integer");
            if (_equals_1) {
              _builder.append("r.getObject(\"");
              String _name_2 = it.getName();
              _builder.append(_name_2);
              _builder.append("\") != null ? r.getInt(\"");
              String _name_3 = it.getName();
              _builder.append(_name_3);
              _builder.append("\") : null");
            } else {
              boolean _equals_2 = it.getType().equals("Serial");
              if (_equals_2) {
                _builder.append("r.getInt(\"");
                String _name_4 = it.getName();
                _builder.append(_name_4);
                _builder.append("\")");
              } else {
                _builder.append("r.get");
                String _javaType = this.javaType(it);
                _builder.append(_javaType);
                _builder.append("(\"");
                String _name_5 = it.getName();
                _builder.append(_name_5);
                _builder.append("\")");
              }
            }
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
  
  public String tableName(final Attribute it) {
    String _xifexpression = null;
    String _type = it.getType();
    boolean _tripleNotEquals = (_type != null);
    if (_tripleNotEquals) {
      StringConcatenation _builder = new StringConcatenation();
      EObject _eContainer = it.eContainer();
      String _table = this._modelExtension.table(((Model) _eContainer));
      _builder.append(_table);
      _xifexpression = _builder.toString();
    }
    return _xifexpression;
  }
  
  public String declaration(final Attribute it) {
    String _type = it.getType();
    boolean _tripleNotEquals = (_type != null);
    if (_tripleNotEquals) {
      StringConcatenation _builder = new StringConcatenation();
      {
        String _constraint = it.getConstraint();
        boolean _tripleNotEquals_1 = (_constraint != null);
        if (_tripleNotEquals_1) {
          _builder.append("@");
          String _constraint_1 = it.getConstraint();
          _builder.append(_constraint_1);
          _builder.newLineIfNotEmpty();
        }
      }
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
    boolean _tripleNotEquals_2 = (_model != null);
    if (_tripleNotEquals_2) {
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
  
  public String param(final Attribute it, final boolean jsonProperty) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (jsonProperty) {
        _builder.append("@JsonProperty(\"");
        String _name = it.getName();
        _builder.append(_name);
        _builder.append("\") ");
      }
    }
    String _javaType = this.javaType(it);
    _builder.append(_javaType);
    _builder.append(" ");
    String _name_1 = it.getName();
    _builder.append(_name_1);
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
  
  public boolean isPrimitive(final Attribute it) {
    return ((!it.isList()) && (it.getModel() == null));
  }
  
  public DateTime dateTimeParse(final String dateString, final String pattern) {
    try {
      return DateTime.parse(dateString, DateTimeFormat.forPattern(pattern)).withZone(DateTimeZone.UTC);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  protected CharSequence _valueFrom(final JsonObject it) {
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
  
  protected CharSequence _valueFrom(final JsonValue it) {
    String _string = it.getString();
    boolean _tripleNotEquals = (_string != null);
    if (_tripleNotEquals) {
      String returnString = it.getString();
      boolean _contains = it.getString().contains("${index}");
      if (_contains) {
        returnString = returnString.replace("${index}", Integer.valueOf(this.index).toString());
        this.index++;
      }
      boolean _contains_1 = it.getString().contains("${random}");
      if (_contains_1) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("\" + this.randomString() + \"");
        returnString = returnString.replace("${random}", _builder);
      }
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("\\\"");
      _builder_1.append(returnString);
      _builder_1.append("\\\"");
      return _builder_1;
    } else {
      String _boolean = it.getBoolean();
      boolean _tripleNotEquals_1 = (_boolean != null);
      if (_tripleNotEquals_1) {
        return it.getBoolean();
      } else {
        StringConcatenation _builder_2 = new StringConcatenation();
        int _long = it.getLong();
        _builder_2.append(_long);
        return _builder_2;
      }
    }
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
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\\\"");
    DateTime _dateTimeParse = this.dateTimeParse(it.getDateTime(), it.getPattern());
    _builder.append(_dateTimeParse);
    _builder.append("\\\"");
    return _builder;
  }
  
  public CharSequence valueFrom(final JsonValue it) {
    if (it instanceof JsonArray) {
      return _valueFrom((JsonArray)it);
    } else if (it instanceof JsonDateTime) {
      return _valueFrom((JsonDateTime)it);
    } else if (it instanceof JsonObject) {
      return _valueFrom((JsonObject)it);
    } else if (it != null) {
      return _valueFrom(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
