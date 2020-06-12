package de.acegen.templates.java.models;

import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.Model;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.java.AttributeExtension;
import de.acegen.extensions.java.ModelExtension;
import java.util.List;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class JDBI3Dao {
  @Inject
  @Extension
  private ModelExtension _modelExtension;
  
  @Inject
  @Extension
  private AttributeExtension _attributeExtension;
  
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  public CharSequence generateAbstractJdbiDao(final Model it, final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = httpServer.getName();
    _builder.append(_name);
    _builder.append(".models;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import de.acegen.PersistenceHandle;");
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.statement.Update;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import java.util.Map;");
    _builder.newLine();
    _builder.append("import java.util.Optional;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"all\")");
    _builder.newLine();
    _builder.append("public class ");
    String _abstractModelDao = this._modelExtension.abstractModelDao(it);
    _builder.append(_abstractModelDao);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void insert(PersistenceHandle handle, ");
    String _modelName = this._modelExtension.modelName(it);
    _builder.append(_modelName, "\t");
    _builder.append(" ");
    String _modelParam = this._modelExtension.modelParam(it);
    _builder.append(_modelParam, "\t");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("Update statement = handle.getHandle().createUpdate(\"INSERT INTO ");
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
        String _lowerCase = attribute.getName().toLowerCase();
        _builder.append(_lowerCase, "\t\t");
      }
    }
    _builder.append(") VALUES (");
    {
      EList<Attribute> _attributes_1 = it.getAttributes();
      boolean _hasElements_1 = false;
      for(final Attribute attribute_1 : _attributes_1) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          _builder.appendImmediate(", ", "\t\t");
        }
        String _modelAttributeSqlValue = this._modelExtension.modelAttributeSqlValue(it, attribute_1);
        _builder.append(_modelAttributeSqlValue, "\t\t");
      }
    }
    _builder.append(")\");");
    _builder.newLineIfNotEmpty();
    {
      EList<Attribute> _attributes_2 = it.getAttributes();
      for(final Attribute attribute_2 : _attributes_2) {
        _builder.append("\t\t");
        _builder.append("statement.bind(\"");
        String _lowerCase_1 = attribute_2.getName().toLowerCase();
        _builder.append(_lowerCase_1, "\t\t");
        _builder.append("\", ");
        String _modelGetAttribute = this._modelExtension.modelGetAttribute(it, attribute_2);
        _builder.append(_modelGetAttribute, "\t\t");
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
    _builder.newLine();
    {
      List<Attribute> _allUniqueAttributes = this._modelExtension.allUniqueAttributes(it);
      for(final Attribute attribute_3 : _allUniqueAttributes) {
        _builder.append("\t");
        _builder.append("public void updateBy");
        String _firstUpper = StringExtensions.toFirstUpper(attribute_3.getName());
        _builder.append(_firstUpper, "\t");
        _builder.append("(PersistenceHandle handle, ");
        String _modelName_1 = this._modelExtension.modelName(it);
        _builder.append(_modelName_1, "\t");
        _builder.append(" ");
        String _modelParam_1 = this._modelExtension.modelParam(it);
        _builder.append(_modelParam_1, "\t");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("Update statement = handle.getHandle().createUpdate(\"UPDATE ");
        String _table_1 = this._modelExtension.table(it);
        _builder.append(_table_1, "\t\t");
        _builder.append(" SET ");
        {
          EList<Attribute> _attributes_3 = it.getAttributes();
          boolean _hasElements_2 = false;
          for(final Attribute attr : _attributes_3) {
            if (!_hasElements_2) {
              _hasElements_2 = true;
            } else {
              _builder.appendImmediate(", ", "\t\t");
            }
            String _lowerCase_2 = attr.getName().toLowerCase();
            _builder.append(_lowerCase_2, "\t\t");
            _builder.append(" = :");
            String _lowerCase_3 = attr.getName().toLowerCase();
            _builder.append(_lowerCase_3, "\t\t");
          }
        }
        _builder.append(" WHERE ");
        String _lowerCase_4 = attribute_3.getName().toLowerCase();
        _builder.append(_lowerCase_4, "\t\t");
        _builder.append(" = :");
        String _lowerCase_5 = attribute_3.getName().toLowerCase();
        _builder.append(_lowerCase_5, "\t\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        {
          EList<Attribute> _attributes_4 = it.getAttributes();
          for(final Attribute attr_1 : _attributes_4) {
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("statement.bind(\"");
            String _lowerCase_6 = attr_1.getName().toLowerCase();
            _builder.append(_lowerCase_6, "\t\t");
            _builder.append("\", ");
            String _modelGetAttribute_1 = this._modelExtension.modelGetAttribute(it, attr_1);
            _builder.append(_modelGetAttribute_1, "\t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("statement.bind(\"");
        String _lowerCase_7 = attribute_3.getName().toLowerCase();
        _builder.append(_lowerCase_7, "\t\t");
        _builder.append("\", ");
        String _modelGetAttribute_2 = this._modelExtension.modelGetAttribute(it, attribute_3);
        _builder.append(_modelGetAttribute_2, "\t\t");
        _builder.append(" );");
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
        _builder.append("public void deleteBy");
        String _firstUpper_1 = StringExtensions.toFirstUpper(attribute_3.getName());
        _builder.append(_firstUpper_1, "\t");
        _builder.append("(PersistenceHandle handle, ");
        String _javaType = this._attributeExtension.javaType(attribute_3);
        _builder.append(_javaType, "\t");
        _builder.append(" ");
        String _name_1 = attribute_3.getName();
        _builder.append(_name_1, "\t");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("Update statement = handle.getHandle().createUpdate(\"DELETE FROM ");
        String _table_2 = this._modelExtension.table(it);
        _builder.append(_table_2, "\t\t");
        _builder.append(" WHERE ");
        String _lowerCase_8 = attribute_3.getName().toLowerCase();
        _builder.append(_lowerCase_8, "\t\t");
        _builder.append(" = :");
        String _lowerCase_9 = attribute_3.getName().toLowerCase();
        _builder.append(_lowerCase_9, "\t\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("statement.bind(\"");
        String _lowerCase_10 = attribute_3.getName().toLowerCase();
        _builder.append(_lowerCase_10, "\t\t");
        _builder.append("\", ");
        String _name_2 = attribute_3.getName();
        _builder.append(_name_2, "\t\t");
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
        _builder.append("public ");
        String _modelName_2 = this._modelExtension.modelName(it);
        _builder.append(_modelName_2, "\t");
        _builder.append(" selectBy");
        String _firstUpper_2 = StringExtensions.toFirstUpper(attribute_3.getName());
        _builder.append(_firstUpper_2, "\t");
        _builder.append("(PersistenceHandle handle, ");
        String _javaType_1 = this._attributeExtension.javaType(attribute_3);
        _builder.append(_javaType_1, "\t");
        _builder.append(" ");
        String _name_3 = attribute_3.getName();
        _builder.append(_name_3, "\t");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("Optional<");
        String _modelName_3 = this._modelExtension.modelName(it);
        _builder.append(_modelName_3, "\t\t");
        _builder.append("> optional = handle.getHandle().createQuery(\"SELECT ");
        {
          EList<Attribute> _attributes_5 = it.getAttributes();
          boolean _hasElements_3 = false;
          for(final Attribute attr_2 : _attributes_5) {
            if (!_hasElements_3) {
              _hasElements_3 = true;
            } else {
              _builder.appendImmediate(", ", "\t\t");
            }
            String _lowerCase_11 = attr_2.getName().toLowerCase();
            _builder.append(_lowerCase_11, "\t\t");
          }
        }
        _builder.append(" FROM ");
        String _table_3 = this._modelExtension.table(it);
        _builder.append(_table_3, "\t\t");
        _builder.append(" WHERE ");
        String _lowerCase_12 = attribute_3.getName().toLowerCase();
        _builder.append(_lowerCase_12, "\t\t");
        _builder.append(" = :");
        String _lowerCase_13 = attribute_3.getName().toLowerCase();
        _builder.append(_lowerCase_13, "\t\t");
        _builder.append("\")");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append(".bind(\"");
        String _lowerCase_14 = attribute_3.getName().toLowerCase();
        _builder.append(_lowerCase_14, "\t\t\t");
        _builder.append("\", ");
        String _name_4 = attribute_3.getName();
        _builder.append(_name_4, "\t\t\t");
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
        _builder.append(".findFirst();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return optional.isPresent() ? optional.get() : null;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      int _length = ((Object[])Conversions.unwrapArray(this._modelExtension.allPrimaryKeyAttributes(it), Object.class)).length;
      boolean _greaterThan = (_length > 0);
      if (_greaterThan) {
        _builder.append("\t");
        _builder.append("public ");
        String _modelName_4 = this._modelExtension.modelName(it);
        _builder.append(_modelName_4, "\t");
        _builder.append(" selectByPrimaryKey(PersistenceHandle handle, ");
        {
          List<Attribute> _allPrimaryKeyAttributes = this._modelExtension.allPrimaryKeyAttributes(it);
          boolean _hasElements_4 = false;
          for(final Attribute attribute_4 : _allPrimaryKeyAttributes) {
            if (!_hasElements_4) {
              _hasElements_4 = true;
            } else {
              _builder.appendImmediate(", ", "\t");
            }
            String _javaType_2 = this._attributeExtension.javaType(attribute_4);
            _builder.append(_javaType_2, "\t");
            _builder.append(" ");
            String _name_5 = attribute_4.getName();
            _builder.append(_name_5, "\t");
          }
        }
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("Optional<");
        String _modelName_5 = this._modelExtension.modelName(it);
        _builder.append(_modelName_5, "\t\t");
        _builder.append("> optional = handle.getHandle().createQuery(\"SELECT ");
        {
          EList<Attribute> _attributes_6 = it.getAttributes();
          boolean _hasElements_5 = false;
          for(final Attribute attr_3 : _attributes_6) {
            if (!_hasElements_5) {
              _hasElements_5 = true;
            } else {
              _builder.appendImmediate(", ", "\t\t");
            }
            String _lowerCase_15 = attr_3.getName().toLowerCase();
            _builder.append(_lowerCase_15, "\t\t");
          }
        }
        _builder.append(" FROM ");
        String _table_4 = this._modelExtension.table(it);
        _builder.append(_table_4, "\t\t");
        _builder.append(" WHERE ");
        {
          List<Attribute> _allPrimaryKeyAttributes_1 = this._modelExtension.allPrimaryKeyAttributes(it);
          boolean _hasElements_6 = false;
          for(final Attribute attribute_5 : _allPrimaryKeyAttributes_1) {
            if (!_hasElements_6) {
              _hasElements_6 = true;
            } else {
              _builder.appendImmediate(" AND ", "\t\t");
            }
            String _lowerCase_16 = attribute_5.getName().toLowerCase();
            _builder.append(_lowerCase_16, "\t\t");
            _builder.append(" = :");
            String _lowerCase_17 = attribute_5.getName().toLowerCase();
            _builder.append(_lowerCase_17, "\t\t");
          }
        }
        _builder.append("\")");
        _builder.newLineIfNotEmpty();
        {
          List<Attribute> _allPrimaryKeyAttributes_2 = this._modelExtension.allPrimaryKeyAttributes(it);
          for(final Attribute attribute_6 : _allPrimaryKeyAttributes_2) {
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append(".bind(\"");
            String _lowerCase_18 = attribute_6.getName().toLowerCase();
            _builder.append(_lowerCase_18, "\t\t\t");
            _builder.append("\", ");
            String _name_6 = attribute_6.getName();
            _builder.append(_name_6, "\t\t\t");
            _builder.append(")");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append(".map(new ");
        String _modelMapper_1 = this._modelExtension.modelMapper(it);
        _builder.append(_modelMapper_1, "\t\t\t");
        _builder.append("())");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append(".findFirst();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return optional.isPresent() ? optional.get() : null;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public int filterAndCountBy(PersistenceHandle handle, Map<String, String> filterMap) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String sql = \"SELECT count(*) FROM ");
    String _table_5 = this._modelExtension.table(it);
    _builder.append(_table_5, "\t\t");
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("if (filterMap != null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("int i = 0;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("for(String key : filterMap.keySet()) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (i == 0) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("sql += \" WHERE \" + key + \" = \'\" + filterMap.get(key) + \"\'\";");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("sql += \" AND \" + key + \" = \'\" + filterMap.get(key) + \"\'\";");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("i++;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return handle.getHandle().createQuery(sql).mapTo(Integer.class).first();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public List<");
    String _modelName_6 = this._modelExtension.modelName(it);
    _builder.append(_modelName_6, "\t");
    _builder.append("> selectAll(PersistenceHandle handle) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("return handle.getHandle().createQuery(\"SELECT ");
    {
      EList<Attribute> _attributes_7 = it.getAttributes();
      boolean _hasElements_7 = false;
      for(final Attribute attr_4 : _attributes_7) {
        if (!_hasElements_7) {
          _hasElements_7 = true;
        } else {
          _builder.appendImmediate(", ", "\t\t");
        }
        String _lowerCase_19 = attr_4.getName().toLowerCase();
        _builder.append(_lowerCase_19, "\t\t");
      }
    }
    _builder.append(" FROM ");
    String _table_6 = this._modelExtension.table(it);
    _builder.append(_table_6, "\t\t");
    _builder.append("\")");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append(".map(new ");
    String _modelMapper_2 = this._modelExtension.modelMapper(it);
    _builder.append(_modelMapper_2, "\t\t\t");
    _builder.append("())");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append(".list();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void truncate(PersistenceHandle handle) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Update statement = handle.getHandle().createUpdate(\"TRUNCATE TABLE ");
    String _table_7 = this._modelExtension.table(it);
    _builder.append(_table_7, "\t\t");
    _builder.append(" CASCADE\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("statement.execute();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
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
  
  public CharSequence generateJdbiDao(final Model it, final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = httpServer.getName();
    _builder.append(_name);
    _builder.append(".models;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _modelDao = this._modelExtension.modelDao(it);
    _builder.append(_modelDao);
    _builder.append(" extends ");
    String _abstractModelDao = this._modelExtension.abstractModelDao(it);
    _builder.append(_abstractModelDao);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
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
}
