package com.anfelisa.generator;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.Attribute;
import com.anfelisa.ace.Command;
import com.anfelisa.ace.Data;
import com.anfelisa.ace.Event;
import com.anfelisa.ace.EventOnOutcome;
import com.anfelisa.ace.Model;
import com.anfelisa.ace.Project;
import com.anfelisa.ace.View;
import com.anfelisa.ace.ViewFunction;
import com.anfelisa.extensions.ActionExtension;
import com.anfelisa.extensions.AttributeExtension;
import com.anfelisa.extensions.CommandExtension;
import com.anfelisa.extensions.DataExtension;
import com.anfelisa.extensions.EventExtension;
import com.anfelisa.extensions.ModelExtension;
import com.anfelisa.extensions.ViewExtension;
import com.google.common.base.Objects;
import java.util.List;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class JavaTemplate {
  @Inject
  @Extension
  private ActionExtension _actionExtension;
  
  @Inject
  @Extension
  private CommandExtension _commandExtension;
  
  @Inject
  @Extension
  private EventExtension _eventExtension;
  
  @Inject
  @Extension
  private ViewExtension _viewExtension;
  
  @Inject
  @Extension
  private ModelExtension _modelExtension;
  
  @Inject
  @Extension
  private DataExtension _dataExtension;
  
  @Inject
  @Extension
  private AttributeExtension _attributeExtension;
  
  public CharSequence generateModel(final Model it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = project.getName();
    _builder.append(_name, "");
    _builder.append(".models;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.joda.time.DateTime;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"unused\")");
    _builder.newLine();
    _builder.append("public interface ");
    String _modelName = this._modelExtension.modelName(it);
    _builder.append(_modelName, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      EList<Attribute> _attributes = it.getAttributes();
      for(final Attribute attribute : _attributes) {
        _builder.append("\t");
        String _interfaceGetter = this._attributeExtension.interfaceGetter(attribute);
        _builder.append(_interfaceGetter, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateModelClass(final Model it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = project.getName();
    _builder.append(_name, "");
    _builder.append(".models;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.annotation.JsonProperty;");
    _builder.newLine();
    _builder.append("import javax.validation.constraints.NotNull;");
    _builder.newLine();
    _builder.append("import org.hibernate.validator.constraints.NotEmpty;");
    _builder.newLine();
    _builder.append("import org.joda.time.DateTime;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"unused\")");
    _builder.newLine();
    _builder.append("public class ");
    String _modelClassName = this._modelExtension.modelClassName(it);
    _builder.append(_modelClassName, "");
    _builder.append(" implements ");
    String _modelName = this._modelExtension.modelName(it);
    _builder.append(_modelName, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      EList<Attribute> _attributes = it.getAttributes();
      for(final Attribute attribute : _attributes) {
        _builder.append("\t");
        String _declaration = this._attributeExtension.declaration(attribute);
        _builder.append(_declaration, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _modelClassName_1 = this._modelExtension.modelClassName(it);
    _builder.append(_modelClassName_1, "\t");
    _builder.append("(");
    _builder.newLineIfNotEmpty();
    {
      EList<Attribute> _attributes_1 = it.getAttributes();
      boolean _hasElements = false;
      for(final Attribute attribute_1 : _attributes_1) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "\t\t");
        }
        _builder.append("\t\t");
        String _param = this._attributeExtension.param(attribute_1);
        _builder.append(_param, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append(") {");
    _builder.newLine();
    {
      EList<Attribute> _attributes_2 = it.getAttributes();
      for(final Attribute attribute_2 : _attributes_2) {
        _builder.append("\t\t");
        String _assign = this._attributeExtension.assign(attribute_2);
        _builder.append(_assign, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Attribute> _attributes_3 = it.getAttributes();
      for(final Attribute attribute_3 : _attributes_3) {
        _builder.append("\t");
        String _ter = this._attributeExtension.getter(attribute_3);
        _builder.append(_ter, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _setter = this._attributeExtension.setter(attribute_3);
        _builder.append(_setter, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateData(final Data it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = project.getName();
    _builder.append(_name, "");
    _builder.append(".data;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.annotation.JsonProperty;");
    _builder.newLine();
    _builder.append("import javax.validation.constraints.NotNull;");
    _builder.newLine();
    _builder.append("import org.hibernate.validator.constraints.NotEmpty;");
    _builder.newLine();
    _builder.append("import org.joda.time.DateTime;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.IDataContainer;");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Model> _models = it.getModels();
      for(final Model model : _models) {
        String _importModel = this._modelExtension.importModel(model);
        _builder.append(_importModel, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"unused\")");
    _builder.newLine();
    _builder.append("public class ");
    String _dataName = this._dataExtension.dataName(it);
    _builder.append(_dataName, "");
    _builder.append(" implements ");
    {
      EList<Model> _models_1 = it.getModels();
      boolean _hasElements = false;
      for(final Model model_1 : _models_1) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        String _modelName = this._modelExtension.modelName(model_1);
        _builder.append(_modelName, "");
      }
    }
    _builder.append(", IDataContainer {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private String uuid;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      List<Attribute> _allAttributes = this._dataExtension.allAttributes(it);
      for(final Attribute attribute : _allAttributes) {
        _builder.append("\t");
        String _declaration = this._attributeExtension.declaration(attribute);
        _builder.append(_declaration, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _dataName_1 = this._dataExtension.dataName(it);
    _builder.append(_dataName_1, "\t");
    _builder.append("(");
    _builder.newLineIfNotEmpty();
    {
      List<Attribute> _allAttributes_1 = this._dataExtension.allAttributes(it);
      boolean _hasElements_1 = false;
      for(final Attribute attribute_1 : _allAttributes_1) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          _builder.appendImmediate(",", "\t\t");
        }
        _builder.append("\t\t");
        String _param = this._attributeExtension.param(attribute_1);
        _builder.append(_param, "\t\t");
        _builder.newLineIfNotEmpty();
      }
      if (_hasElements_1) {
        _builder.append(",", "\t\t");
      }
    }
    _builder.append("\t\t");
    _builder.append("@JsonProperty(\"uuid\") String uuid");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(") {");
    _builder.newLine();
    {
      List<Attribute> _allAttributes_2 = this._dataExtension.allAttributes(it);
      for(final Attribute attribute_2 : _allAttributes_2) {
        _builder.append("\t\t");
        String _assign = this._attributeExtension.assign(attribute_2);
        _builder.append(_assign, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("this.uuid = uuid;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      List<Attribute> _allAttributes_3 = this._dataExtension.allAttributes(it);
      for(final Attribute attribute_3 : _allAttributes_3) {
        _builder.append("\t");
        String _ter = this._attributeExtension.getter(attribute_3);
        _builder.append(_ter, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _setter = this._attributeExtension.setter(attribute_3);
        _builder.append(_setter, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String getUuid() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return this.uuid;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateDao(final Model it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = project.getName();
    _builder.append(_name, "");
    _builder.append(".models;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.skife.jdbi.v2.Handle;");
    _builder.newLine();
    _builder.append("import org.skife.jdbi.v2.Update;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _modelDao = this._modelExtension.modelDao(it);
    _builder.append(_modelDao, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void create(Handle handle, String schema) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("handle.execute(\"CREATE TABLE IF NOT EXISTS \" + schema + \".");
    String _table = this._modelExtension.table(it);
    _builder.append(_table, "\t\t");
    _builder.append(" (");
    {
      EList<Attribute> _attributes = it.getAttributes();
      boolean _hasElements = false;
      for(final Attribute attribute : _attributes) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "\t\t");
        }
        String _tableDefinition = this._attributeExtension.tableDefinition(attribute);
        _builder.append(_tableDefinition, "\t\t");
      }
    }
    {
      EList<Attribute> _attributes_1 = it.getAttributes();
      for(final Attribute attribute_1 : _attributes_1) {
        String _table_1 = this._modelExtension.table(it);
        String _primaryKey = this._attributeExtension.primaryKey(attribute_1, _table_1);
        _builder.append(_primaryKey, "\t\t");
      }
    }
    {
      EList<Attribute> _attributes_2 = it.getAttributes();
      for(final Attribute attribute_2 : _attributes_2) {
        String _table_2 = this._modelExtension.table(it);
        String _uniqueConstraint = this._attributeExtension.uniqueConstraint(attribute_2, _table_2);
        _builder.append(_uniqueConstraint, "\t\t");
      }
    }
    _builder.append(")\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void insert(Handle handle, ");
    String _modelName = this._modelExtension.modelName(it);
    _builder.append(_modelName, "\t");
    _builder.append(" ");
    String _modelParam = this._modelExtension.modelParam(it);
    _builder.append(_modelParam, "\t");
    _builder.append(", String schema) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("Update statement = handle.createStatement(\"INSERT INTO \" + schema + \".");
    String _table_3 = this._modelExtension.table(it);
    _builder.append(_table_3, "\t\t");
    _builder.append(" (");
    {
      EList<Attribute> _attributes_3 = it.getAttributes();
      boolean _hasElements_1 = false;
      for(final Attribute attribute_3 : _attributes_3) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          _builder.appendImmediate(", ", "\t\t");
        }
        String _name_1 = attribute_3.getName();
        _builder.append(_name_1, "\t\t");
      }
    }
    _builder.append(") VALUES (");
    {
      EList<Attribute> _attributes_4 = it.getAttributes();
      boolean _hasElements_2 = false;
      for(final Attribute attribute_4 : _attributes_4) {
        if (!_hasElements_2) {
          _hasElements_2 = true;
        } else {
          _builder.appendImmediate(", ", "\t\t");
        }
        _builder.append(":");
        String _name_2 = attribute_4.getName();
        _builder.append(_name_2, "\t\t");
      }
    }
    _builder.append(")\");");
    _builder.newLineIfNotEmpty();
    {
      EList<Attribute> _attributes_5 = it.getAttributes();
      for(final Attribute attribute_5 : _attributes_5) {
        _builder.append("\t\t");
        _builder.append("statement.bind(\"");
        String _name_3 = attribute_5.getName();
        _builder.append(_name_3, "\t\t");
        _builder.append("\", ");
        String _modelParam_1 = this._modelExtension.modelParam(it);
        _builder.append(_modelParam_1, "\t\t");
        _builder.append(".");
        String _terCall = this._attributeExtension.getterCall(attribute_5);
        _builder.append(_terCall, "\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("statement.execute();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void update(Handle handle, ");
    String _modelName_1 = this._modelExtension.modelName(it);
    _builder.append(_modelName_1, "\t");
    _builder.append(" ");
    String _modelParam_2 = this._modelExtension.modelParam(it);
    _builder.append(_modelParam_2, "\t");
    _builder.append(", String schema) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("Update statement = handle.createStatement(\"UPDATE \" + schema + \".");
    String _table_4 = this._modelExtension.table(it);
    _builder.append(_table_4, "\t\t");
    _builder.append(" SET ");
    {
      EList<Attribute> _attributes_6 = it.getAttributes();
      boolean _hasElements_3 = false;
      for(final Attribute attribute_6 : _attributes_6) {
        if (!_hasElements_3) {
          _hasElements_3 = true;
        } else {
          _builder.appendImmediate(", ", "\t\t");
        }
        String _name_4 = attribute_6.getName();
        _builder.append(_name_4, "\t\t");
        _builder.append(" = :");
        String _name_5 = attribute_6.getName();
        _builder.append(_name_5, "\t\t");
      }
    }
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    {
      EList<Attribute> _attributes_7 = it.getAttributes();
      for(final Attribute attribute_7 : _attributes_7) {
        _builder.append("\t\t");
        _builder.append("statement.bind(\"");
        String _name_6 = attribute_7.getName();
        _builder.append(_name_6, "\t\t");
        _builder.append("\", ");
        String _modelParam_3 = this._modelExtension.modelParam(it);
        _builder.append(_modelParam_3, "\t\t");
        _builder.append(".");
        String _terCall_1 = this._attributeExtension.getterCall(attribute_7);
        _builder.append(_terCall_1, "\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("statement.execute();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      Attribute _findSerialAttribute = this._modelExtension.findSerialAttribute(it);
      boolean _notEquals = (!Objects.equal(_findSerialAttribute, null));
      if (_notEquals) {
        _builder.append("\t");
        _builder.append("public static void deleteById(Handle handle, ");
        String _modelName_2 = this._modelExtension.modelName(it);
        _builder.append(_modelName_2, "\t");
        _builder.append(" ");
        String _modelParam_4 = this._modelExtension.modelParam(it);
        _builder.append(_modelParam_4, "\t");
        _builder.append(", String schema) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("Update statement = handle.createStatement(\"DELETE FROM \" + schema + \".");
        String _table_5 = this._modelExtension.table(it);
        _builder.append(_table_5, "\t\t");
        _builder.append(" WHERE id = :id\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("statement.bind(\"");
        Attribute _findSerialAttribute_1 = this._modelExtension.findSerialAttribute(it);
        String _name_7 = _findSerialAttribute_1.getName();
        _builder.append(_name_7, "\t\t");
        _builder.append("\", ");
        String _modelParam_5 = this._modelExtension.modelParam(it);
        _builder.append(_modelParam_5, "\t\t");
        _builder.append(".");
        Attribute _findSerialAttribute_2 = this._modelExtension.findSerialAttribute(it);
        String _terCall_2 = this._attributeExtension.getterCall(_findSerialAttribute_2);
        _builder.append(_terCall_2, "\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("statement.execute();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public static ");
        String _modelName_3 = this._modelExtension.modelName(it);
        _builder.append(_modelName_3, "\t");
        _builder.append(" selectById(Handle handle, ");
        String _modelName_4 = this._modelExtension.modelName(it);
        _builder.append(_modelName_4, "\t");
        _builder.append(" ");
        String _modelParam_6 = this._modelExtension.modelParam(it);
        _builder.append(_modelParam_6, "\t");
        _builder.append(", String schema) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return handle.createQuery(\"SELECT * FROM \" + schema + \".");
        String _table_6 = this._modelExtension.table(it);
        _builder.append(_table_6, "\t\t");
        _builder.append(" WHERE id = :id\")");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append(".bind(\"");
        Attribute _findSerialAttribute_3 = this._modelExtension.findSerialAttribute(it);
        String _name_8 = _findSerialAttribute_3.getName();
        _builder.append(_name_8, "\t\t\t");
        _builder.append("\", ");
        String _modelParam_7 = this._modelExtension.modelParam(it);
        _builder.append(_modelParam_7, "\t\t\t");
        _builder.append(".");
        Attribute _findSerialAttribute_4 = this._modelExtension.findSerialAttribute(it);
        String _terCall_3 = this._attributeExtension.getterCall(_findSerialAttribute_4);
        _builder.append(_terCall_3, "\t\t\t");
        _builder.append(")");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append(".map(new ");
        String _modelMapper = this._modelExtension.modelMapper(it);
        _builder.append(_modelMapper, "\t\t\t");
        _builder.append("())");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append(".first();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static List<");
    String _modelName_5 = this._modelExtension.modelName(it);
    _builder.append(_modelName_5, "\t");
    _builder.append("> selectAll(Handle handle, String schema) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("return handle.createQuery(\"SELECT * FROM \" + schema + \".");
    String _table_7 = this._modelExtension.table(it);
    _builder.append(_table_7, "\t\t");
    _builder.append("\")");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append(".map(new ");
    String _modelMapper_1 = this._modelExtension.modelMapper(it);
    _builder.append(_modelMapper_1, "\t\t\t");
    _builder.append("())");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append(".list();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateMapper(final Model it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = project.getName();
    _builder.append(_name, "");
    _builder.append(".models;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.sql.ResultSet;");
    _builder.newLine();
    _builder.append("import java.sql.SQLException;");
    _builder.newLine();
    _builder.append("import org.joda.time.DateTime;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.skife.jdbi.v2.StatementContext;");
    _builder.newLine();
    _builder.append("import org.skife.jdbi.v2.tweak.ResultSetMapper;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _modelMapper = this._modelExtension.modelMapper(it);
    _builder.append(_modelMapper, "");
    _builder.append(" implements ResultSetMapper<");
    String _modelName = this._modelExtension.modelName(it);
    _builder.append(_modelName, "");
    _builder.append("> {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _modelName_1 = this._modelExtension.modelName(it);
    _builder.append(_modelName_1, "\t");
    _builder.append(" map(int index, ResultSet r, StatementContext ctx) throws SQLException {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("return new ");
    String _modelClassName = this._modelExtension.modelClassName(it);
    _builder.append(_modelClassName, "\t\t");
    _builder.append("(");
    _builder.newLineIfNotEmpty();
    {
      EList<Attribute> _attributes = it.getAttributes();
      boolean _hasElements = false;
      for(final Attribute attribute : _attributes) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "\t\t\t");
        }
        _builder.append("\t\t\t");
        String _mapperInit = this._attributeExtension.mapperInit(attribute);
        _builder.append(_mapperInit, "\t\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append(");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateAbstractActionFile(final Action it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = project.getName();
    _builder.append(_name, "");
    _builder.append(".actions;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.Action;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.DatabaseHandle;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.HttpMethod;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.ICommand;");
    _builder.newLine();
    Data _data = it.getData();
    String _dataImport = this._dataExtension.dataImport(_data);
    _builder.append(_dataImport, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      Command _command = it.getCommand();
      boolean _notEquals = (!Objects.equal(_command, null));
      if (_notEquals) {
        _builder.append("import ");
        String _name_1 = project.getName();
        _builder.append(_name_1, "");
        _builder.append(".commands.");
        Command _command_1 = it.getCommand();
        String _commandName = this._commandExtension.commandName(_command_1);
        _builder.append(_commandName, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("public abstract class ");
    String _abstractActionName = this._actionExtension.abstractActionName(it);
    _builder.append(_abstractActionName, "");
    _builder.append(" extends Action<");
    Data _data_1 = it.getData();
    String _dataParamType = this._dataExtension.dataParamType(_data_1);
    _builder.append(_dataParamType, "");
    _builder.append("> {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _abstractActionName_1 = this._actionExtension.abstractActionName(it);
    _builder.append(_abstractActionName_1, "\t");
    _builder.append("(");
    Data _data_2 = it.getData();
    String _dataParamType_1 = this._dataExtension.dataParamType(_data_2);
    _builder.append(_dataParamType_1, "\t");
    _builder.append(" actionParam, DatabaseHandle databaseHandle) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(\"");
    String _actionName = this._actionExtension.actionName(it);
    _builder.append(_actionName, "\t\t");
    _builder.append("\", HttpMethod.");
    String _type = it.getType();
    _builder.append(_type, "\t\t");
    _builder.append(", actionParam, databaseHandle);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ICommand getCommand() {");
    _builder.newLine();
    {
      Command _command_2 = it.getCommand();
      boolean _notEquals_1 = (!Objects.equal(_command_2, null));
      if (_notEquals_1) {
        _builder.append("\t\t");
        _builder.append("return new ");
        Command _command_3 = it.getCommand();
        String _commandName_1 = this._commandExtension.commandName(_command_3);
        _builder.append(_commandName_1, "\t\t");
        _builder.append("(this.actionData, databaseHandle);");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("\t\t");
        _builder.append("return null;");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateAbstractCommandFile(final Command it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = project.getName();
    _builder.append(_name, "");
    _builder.append(".commands;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import javax.ws.rs.WebApplicationException;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.Command;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.DatabaseHandle;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.DatabaseService;");
    _builder.newLine();
    _builder.newLine();
    Data _data = it.getData();
    String _dataImport = this._dataExtension.dataImport(_data);
    _builder.append(_dataImport, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public abstract class ");
    String _abstractCommandName = this._commandExtension.abstractCommandName(it);
    _builder.append(_abstractCommandName, "");
    _builder.append(" extends Command<");
    Data _data_1 = it.getData();
    String _dataParamType = this._dataExtension.dataParamType(_data_1);
    _builder.append(_dataParamType, "");
    _builder.append("> {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      EList<EventOnOutcome> _eventsOnOutcome = it.getEventsOnOutcome();
      for(final EventOnOutcome eventOnOutcome : _eventsOnOutcome) {
        _builder.append("\t");
        _builder.append("protected static final String ");
        String _outcome = eventOnOutcome.getOutcome();
        _builder.append(_outcome, "\t");
        _builder.append(" = \"");
        String _outcome_1 = eventOnOutcome.getOutcome();
        _builder.append(_outcome_1, "\t");
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _abstractCommandName_1 = this._commandExtension.abstractCommandName(it);
    _builder.append(_abstractCommandName_1, "\t");
    _builder.append("(");
    Data _data_2 = it.getData();
    String _dataParamType_1 = this._dataExtension.dataParamType(_data_2);
    _builder.append(_dataParamType_1, "\t");
    _builder.append(" commandParam, DatabaseHandle databaseHandle) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(\"");
    String _commandName = this._commandExtension.commandName(it);
    _builder.append(_commandName, "\t\t");
    _builder.append("\", commandParam, databaseHandle);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void publishEvents() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("switch (this.outcome) {");
    _builder.newLine();
    {
      EList<EventOnOutcome> _eventsOnOutcome_1 = it.getEventsOnOutcome();
      for(final EventOnOutcome eventOnOutcome_1 : _eventsOnOutcome_1) {
        _builder.append("\t\t");
        _builder.append("case ");
        String _outcome_2 = eventOnOutcome_1.getOutcome();
        _builder.append(_outcome_2, "\t\t");
        _builder.append(":");
        _builder.newLineIfNotEmpty();
        {
          EList<Event> _events = eventOnOutcome_1.getEvents();
          for(final Event event : _events) {
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("new ");
            String _eventNameWithPackage = this._eventExtension.eventNameWithPackage(event);
            _builder.append(_eventNameWithPackage, "\t\t\t");
            _builder.append("(this.commandData, databaseHandle).publish();");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          EList<Action> _actions = eventOnOutcome_1.getActions();
          for(final Action action : _actions) {
            _builder.append("\t\t");
            _builder.append("\t");
            String _newAction = this._actionExtension.newAction(action);
            _builder.append(_newAction, "\t\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("Thread actionThread = new Thread(new Runnable() {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("public void run() {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("action.apply();");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("});");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("actionThread.start();");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.newLine();
          }
        }
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("break;");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.append("default:");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw new WebApplicationException(\"unhandled outcome \" + outcome);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateAbstractEventFile(final Event it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = project.getName();
    _builder.append(_name, "");
    _builder.append(".events;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.DatabaseHandle;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.Event;");
    _builder.newLine();
    _builder.newLine();
    Data _data = it.getData();
    String _dataImport = this._dataExtension.dataImport(_data);
    _builder.append(_dataImport, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public abstract class ");
    String _abstractEventName = this._eventExtension.abstractEventName(it);
    _builder.append(_abstractEventName, "");
    _builder.append(" extends Event<");
    Data _data_1 = it.getData();
    String _dataParamType = this._dataExtension.dataParamType(_data_1);
    _builder.append(_dataParamType, "");
    _builder.append("> {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _abstractEventName_1 = this._eventExtension.abstractEventName(it);
    _builder.append(_abstractEventName_1, "\t");
    _builder.append("(");
    Data _data_2 = it.getData();
    String _dataParamType_1 = this._dataExtension.dataParamType(_data_2);
    _builder.append(_dataParamType_1, "\t");
    _builder.append(" eventParam, DatabaseHandle databaseHandle) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(\"");
    String _eventName = this._eventExtension.eventName(it);
    _builder.append(_eventName, "\t\t");
    _builder.append("\", eventParam, databaseHandle);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateInitialActionFile(final Action it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = project.getName();
    _builder.append(_name, "");
    _builder.append(".actions;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.DatabaseHandle;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    Data _data = it.getData();
    String _dataImport = this._dataExtension.dataImport(_data);
    _builder.append(_dataImport, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _actionName = this._actionExtension.actionName(it);
    _builder.append(_actionName, "");
    _builder.append(" extends ");
    String _abstractActionName = this._actionExtension.abstractActionName(it);
    _builder.append(_abstractActionName, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(");
    String _actionName_1 = this._actionExtension.actionName(it);
    _builder.append(_actionName_1, "\t");
    _builder.append(".class);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _actionName_2 = this._actionExtension.actionName(it);
    _builder.append(_actionName_2, "\t");
    _builder.append("(");
    Data _data_1 = it.getData();
    String _dataParamType = this._dataExtension.dataParamType(_data_1);
    _builder.append(_dataParamType, "\t");
    _builder.append(" actionParam, DatabaseHandle databaseHandle) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(actionParam, databaseHandle);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void captureActionParam() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// capture all stuff that we need to replay this action (e.g. system time)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void applyAction() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// init actionData");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.actionData = this.actionParam;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateInitialCommandFile(final Command it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = project.getName();
    _builder.append(_name, "");
    _builder.append(".commands;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.DatabaseHandle;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    Data _data = it.getData();
    String _dataImport = this._dataExtension.dataImport(_data);
    _builder.append(_dataImport, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _commandName = this._commandExtension.commandName(it);
    _builder.append(_commandName, "");
    _builder.append(" extends ");
    String _abstractCommandName = this._commandExtension.abstractCommandName(it);
    _builder.append(_abstractCommandName, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(");
    String _commandName_1 = this._commandExtension.commandName(it);
    _builder.append(_commandName_1, "\t");
    _builder.append(".class);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _commandName_2 = this._commandExtension.commandName(it);
    _builder.append(_commandName_2, "\t");
    _builder.append("(");
    Data _data_1 = it.getData();
    String _dataParamType = this._dataExtension.dataParamType(_data_1);
    _builder.append(_dataParamType, "\t");
    _builder.append(" commandParam, DatabaseHandle databaseHandle) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(commandParam, databaseHandle);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void executeCommand() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// execute command and set outcome");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateInitialEventFile(final Event it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = project.getName();
    _builder.append(_name, "");
    _builder.append(".events;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.DatabaseHandle;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    Data _data = it.getData();
    String _dataImport = this._dataExtension.dataImport(_data);
    _builder.append(_dataImport, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _eventName = this._eventExtension.eventName(it);
    _builder.append(_eventName, "");
    _builder.append(" extends ");
    String _abstractEventName = this._eventExtension.abstractEventName(it);
    _builder.append(_abstractEventName, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(");
    String _eventName_1 = this._eventExtension.eventName(it);
    _builder.append(_eventName_1, "\t");
    _builder.append(".class);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _eventName_2 = this._eventExtension.eventName(it);
    _builder.append(_eventName_2, "\t");
    _builder.append("(");
    Data _data_1 = it.getData();
    String _dataParamType = this._dataExtension.dataParamType(_data_1);
    _builder.append(_dataParamType, "\t");
    _builder.append(" eventParam, DatabaseHandle databaseHandle) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(eventParam, databaseHandle);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void prepareDataForView() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// prepare data for view");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.eventData = this.eventParam;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateInitialResourceFile(final Action it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = project.getName();
    _builder.append(_name, "");
    _builder.append(".resources;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import javax.annotation.security.PermitAll;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.Consumes;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.POST;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.PUT;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.DELETE;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.GET;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.Path;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.Produces;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.core.MediaType;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.core.Response;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.DatabaseService;");
    _builder.newLine();
    _builder.append("import com.codahale.metrics.annotation.Timed;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.core.JsonProcessingException;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import ");
    String _name_1 = project.getName();
    _builder.append(_name_1, "");
    _builder.append(".actions.");
    String _actionName = this._actionExtension.actionName(it);
    _builder.append(_actionName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    Data _data = it.getData();
    String _dataImport = this._dataExtension.dataImport(_data);
    _builder.append(_dataImport, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("@Path(\"/path\")");
    _builder.newLine();
    _builder.append("@Produces(MediaType.APPLICATION_JSON)");
    _builder.newLine();
    _builder.append("@Consumes(MediaType.APPLICATION_JSON)");
    _builder.newLine();
    _builder.append("public class ");
    String _resourceName = this._actionExtension.resourceName(it);
    _builder.append(_resourceName, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(");
    String _resourceName_1 = this._actionExtension.resourceName(it);
    _builder.append(_resourceName_1, "\t");
    _builder.append(".class);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@");
    String _type = it.getType();
    _builder.append(_type, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("@Timed");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Path(\"/path\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@PermitAll // set permission");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Response ");
    String _type_1 = it.getType();
    String _lowerCase = _type_1.toLowerCase();
    _builder.append(_lowerCase, "\t");
    _builder.append("(/* params here */) throws JsonProcessingException {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    Data _data_1 = it.getData();
    String _dataParamType = this._dataExtension.dataParamType(_data_1);
    _builder.append(_dataParamType, "\t\t");
    _builder.append(" actionParam = null;  // init actionParam");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("return new ");
    String _actionName_1 = this._actionExtension.actionName(it);
    _builder.append(_actionName_1, "\t\t");
    _builder.append("(actionParam, DatabaseService.getDatabaseHandle()).apply();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateView(final View it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = project.getName();
    _builder.append(_name, "");
    _builder.append(".views;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.function.BiConsumer;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.skife.jdbi.v2.Handle;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.IDataContainer;");
    _builder.newLine();
    {
      EList<ViewFunction> _renderFunctions = it.getRenderFunctions();
      for(final ViewFunction renderFunction : _renderFunctions) {
        Data _data = renderFunction.getData();
        String _dataImport = this._dataExtension.dataImport(_data);
        _builder.append(_dataImport, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("public class ");
    String _viewName = this._viewExtension.viewName(it);
    _builder.append(_viewName, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      EList<ViewFunction> _renderFunctions_1 = it.getRenderFunctions();
      for(final ViewFunction renderFunction_1 : _renderFunctions_1) {
        _builder.append("\t");
        _builder.append("public BiConsumer<");
        Data _data_1 = renderFunction_1.getData();
        String _dataName = this._dataExtension.dataName(_data_1);
        _builder.append(_dataName, "\t");
        _builder.append(", Handle> ");
        String _name_1 = renderFunction_1.getName();
        _builder.append(_name_1, "\t");
        _builder.append(" = (dataContainer, handle) -> {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("// update view");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("};");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*                    S.D.G.                    */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateAppRegistration(final Project it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = it.getName();
    _builder.append(_name, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import io.dropwizard.setup.Environment;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.AceController;");
    _builder.newLine();
    _builder.newLine();
    {
      EList<View> _views = it.getViews();
      int _size = _views.size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _builder.append("import ");
        String _name_1 = it.getName();
        _builder.append(_name_1, "");
        _builder.append(".views.*;");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Action> _actions = it.getActions();
      int _size_1 = _actions.size();
      boolean _greaterThan_1 = (_size_1 > 0);
      if (_greaterThan_1) {
        _builder.append("import ");
        String _name_2 = it.getName();
        _builder.append(_name_2, "");
        _builder.append(".resources.*;");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("public class AppRegistration {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void registerResources(Environment environment) {");
    _builder.newLine();
    {
      EList<Action> _actions_1 = it.getActions();
      for(final Action action : _actions_1) {
        _builder.append("\t\t");
        _builder.append("environment.jersey().register(new ");
        String _resourceName = this._actionExtension.resourceName(action);
        _builder.append(_resourceName, "\t\t");
        _builder.append("());");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void registerConsumers() {");
    _builder.newLine();
    {
      EList<View> _views_1 = it.getViews();
      for(final View view : _views_1) {
        _builder.append("\t\t");
        String _viewName = this._viewExtension.viewName(view);
        _builder.append(_viewName, "\t\t");
        _builder.append(" ");
        String _viewNameAsVariable = this._viewExtension.viewNameAsVariable(view);
        _builder.append(_viewNameAsVariable, "\t\t");
        _builder.append(" = new ");
        String _viewName_1 = this._viewExtension.viewName(view);
        _builder.append(_viewName_1, "\t\t");
        _builder.append("();");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    {
      EList<Event> _events = it.getEvents();
      for(final Event event : _events) {
        {
          EList<ViewFunction> _listeners = event.getListeners();
          for(final ViewFunction renderFunction : _listeners) {
            _builder.append("\t\t");
            _builder.append("AceController.addConsumer(\"");
            String _eventName = this._eventExtension.eventName(event);
            _builder.append(_eventName, "\t\t");
            _builder.append("\", ");
            String _viewFunctionWithViewNameAsVariable = this._viewExtension.viewFunctionWithViewNameAsVariable(renderFunction);
            _builder.append(_viewFunctionWithViewNameAsVariable, "\t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*                    S.D.G.                    */");
    _builder.newLine();
    return _builder;
  }
}
