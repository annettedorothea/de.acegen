package com.anfelisa.extensions;

import com.anfelisa.ace.Attribute;
import com.anfelisa.ace.Model;
import com.anfelisa.extensions.ModelExtension;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class AttributeExtension {
  @Inject
  @Extension
  private ModelExtension _modelExtension;
  
  public String declaration(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      String _constraint = it.getConstraint();
      boolean _notEquals = (!Objects.equal(_constraint, null));
      if (_notEquals) {
        _builder.append("@");
        String _constraint_1 = it.getConstraint();
        _builder.append(_constraint_1, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("private ");
    String _javaType = this.javaType(it);
    _builder.append(_javaType, "");
    _builder.append(" ");
    String _name = it.getName();
    _builder.append(_name, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public String javaType(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isList = it.isList();
      if (_isList) {
        _builder.append("java.util.List<");
      }
    }
    {
      String _type = it.getType();
      boolean _equals = _type.equals("Serial");
      if (_equals) {
        _builder.append("Integer");
      } else {
        String _type_1 = it.getType();
        boolean _equals_1 = _type_1.equals("DateTime");
        if (_equals_1) {
          _builder.append("org.joda.time.DateTime");
        } else {
          String _type_2 = it.getType();
          _builder.append(_type_2, "");
        }
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
  
  public String sqlType(final Attribute it) {
    String _switchResult = null;
    String _type = it.getType();
    switch (_type) {
      case "Serial":
        _switchResult = "serial";
        break;
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
    return _switchResult;
  }
  
  public String mapperInit(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      String _type = it.getType();
      boolean _equals = _type.equals("DateTime");
      if (_equals) {
        _builder.append("new org.joda.time.DateTime(r.getDate(\"");
        String _name = it.getName();
        _builder.append(_name, "");
        _builder.append("\"))");
      } else {
        String _type_1 = it.getType();
        boolean _equals_1 = _type_1.equals("Integer");
        if (_equals_1) {
          _builder.append("r.getInt(\"");
          String _name_1 = it.getName();
          _builder.append(_name_1, "");
          _builder.append("\")");
        } else {
          String _type_2 = it.getType();
          boolean _equals_2 = _type_2.equals("Serial");
          if (_equals_2) {
            _builder.append("r.getInt(\"");
            String _name_2 = it.getName();
            _builder.append(_name_2, "");
            _builder.append("\")");
          } else {
            _builder.append("r.get");
            String _javaType = this.javaType(it);
            _builder.append(_javaType, "");
            _builder.append("(\"");
            String _name_3 = it.getName();
            _builder.append(_name_3, "");
            _builder.append("\")");
          }
        }
      }
    }
    return _builder.toString();
  }
  
  public String param(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@JsonProperty(\"");
    String _name = it.getName();
    _builder.append(_name, "");
    _builder.append("\") ");
    String _javaType = this.javaType(it);
    _builder.append(_javaType, "");
    _builder.append(" ");
    String _name_1 = it.getName();
    _builder.append(_name_1, "");
    return _builder.toString();
  }
  
  public String bind(final Attribute it, final String modelName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("statement.bind(\"");
    String _name = it.getName();
    _builder.append(_name, "");
    _builder.append("\", ");
    _builder.append(modelName, "");
    _builder.append(".get");
    String _name_1 = it.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name_1);
    _builder.append(_firstUpper, "");
    _builder.append("());");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public String tableName(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    EObject _eContainer = it.eContainer();
    String _table = this._modelExtension.table(((Model) _eContainer));
    _builder.append(_table, "");
    return _builder.toString();
  }
  
  public String tableDefinition(final Attribute it, final String tableName) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = it.getName();
    _builder.append(_name, "");
    _builder.append(" ");
    String _sqlType = this.sqlType(it);
    _builder.append(_sqlType, "");
    _builder.append(" ");
    {
      if (((!Objects.equal(it.getConstraint(), null)) && it.getConstraint().equals("NotNull"))) {
        _builder.append("NOT NULL ");
      }
    }
    _builder.append(" ");
    return _builder.toString();
  }
  
  public String primaryKey(final Attribute it, final String tableName) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isPrimaryKey = it.isPrimaryKey();
      if (_isPrimaryKey) {
        _builder.append(", CONSTRAINT ");
        _builder.append(tableName, "");
        _builder.append("_pkey PRIMARY KEY (");
        String _name = it.getName();
        _builder.append(_name, "");
        _builder.append(")");
      }
    }
    return _builder.toString();
  }
  
  public String foreignKey(final Attribute it, final String tableName, final String schema) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Attribute _foreignKey = it.getForeignKey();
      boolean _notEquals = (!Objects.equal(_foreignKey, null));
      if (_notEquals) {
        _builder.append(", CONSTRAINT ");
        _builder.append(tableName, "");
        _builder.append("_");
        String _name = it.getName();
        _builder.append(_name, "");
        _builder.append("_fkey FOREIGN KEY (");
        String _name_1 = it.getName();
        _builder.append(_name_1, "");
        _builder.append(") REFERENCES ");
        _builder.append(schema, "");
        _builder.append(".");
        Attribute _foreignKey_1 = it.getForeignKey();
        String _tableName = this.tableName(_foreignKey_1);
        _builder.append(_tableName, "");
        _builder.append(" ( ");
        Attribute _foreignKey_2 = it.getForeignKey();
        String _name_2 = _foreignKey_2.getName();
        _builder.append(_name_2, "");
        _builder.append(" ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE");
      }
    }
    return _builder.toString();
  }
  
  public boolean primaryKey(final Attribute it) {
    String _type = it.getType();
    return _type.equals("Serial");
  }
  
  public String uniqueConstraint(final Attribute it, final String tableName) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isUnique = it.isUnique();
      if (_isUnique) {
        _builder.append(", CONSTRAINT ");
        _builder.append(tableName, "");
        _builder.append("_");
        String _name = it.getName();
        _builder.append(_name, "");
        _builder.append("_unique UNIQUE (");
        String _name_1 = it.getName();
        _builder.append(_name_1, "");
        _builder.append(")");
      }
    }
    return _builder.toString();
  }
  
  public String interfaceGetter(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    String _javaType = this.javaType(it);
    _builder.append(_javaType, "");
    _builder.append(" get");
    String _name = it.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append("();");
    return _builder.toString();
  }
  
  public String getter(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("public ");
    String _javaType = this.javaType(it);
    _builder.append(_javaType, "");
    _builder.append(" get");
    String _name = it.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return this.");
    String _name_1 = it.getName();
    _builder.append(_name_1, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    return _builder.toString();
  }
  
  public String getterCall(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("get");
    String _name = it.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append("()");
    return _builder.toString();
  }
  
  public String setter(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public void set");
    String _name = it.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append("(");
    String _javaType = this.javaType(it);
    _builder.append(_javaType, "");
    _builder.append(" ");
    String _name_1 = it.getName();
    _builder.append(_name_1, "");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("this.");
    String _name_2 = it.getName();
    _builder.append(_name_2, "\t");
    _builder.append(" = ");
    String _name_3 = it.getName();
    _builder.append(_name_3, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    return _builder.toString();
  }
  
  public String initializer(final Attribute it, final String className) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public ");
    _builder.append(className, "");
    _builder.append(" with");
    String _name = it.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append("(");
    String _javaType = this.javaType(it);
    _builder.append(_javaType, "");
    _builder.append(" ");
    String _name_1 = it.getName();
    _builder.append(_name_1, "");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("this.");
    String _name_2 = it.getName();
    _builder.append(_name_2, "\t");
    _builder.append(" = ");
    String _name_3 = it.getName();
    _builder.append(_name_3, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return this;");
    _builder.newLine();
    _builder.append("}");
    return _builder.toString();
  }
  
  public String assign(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("this.");
    String _name = it.getName();
    _builder.append(_name, "");
    _builder.append(" = ");
    String _name_1 = it.getName();
    _builder.append(_name_1, "");
    _builder.append(";");
    return _builder.toString();
  }
}
