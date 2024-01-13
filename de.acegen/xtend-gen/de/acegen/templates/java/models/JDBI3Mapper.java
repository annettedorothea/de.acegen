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
package de.acegen.templates.java.models;

import com.google.common.base.Objects;
import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.Model;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.java.TypeExtension;
import jakarta.inject.Inject;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class JDBI3Mapper {
  @Inject
  @Extension
  private TypeExtension _typeExtension;

  @Inject
  @Extension
  private CommonExtension _commonExtension;

  public CharSequence generate(final Model it, final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _modelPackageName = this._typeExtension.modelPackageName(it);
    _builder.append(_modelPackageName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.sql.ResultSet;");
    _builder.newLine();
    _builder.append("import java.sql.SQLException;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.statement.StatementContext;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import de.acegen.AbstractMapper;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _modelMapper = this._typeExtension.modelMapper(it);
    _builder.append(_modelMapper);
    _builder.append(" extends AbstractMapper<");
    String _modelClassName = this._typeExtension.modelClassName(it);
    _builder.append(_modelClassName);
    _builder.append("> {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _modelClassName_1 = this._typeExtension.modelClassName(it);
    _builder.append(_modelClassName_1, "\t");
    _builder.append(" map(ResultSet r, StatementContext ctx) throws SQLException {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("return new ");
    String _modelClassName_2 = this._typeExtension.modelClassName(it);
    _builder.append(_modelClassName_2, "\t\t");
    _builder.append("(");
    _builder.newLineIfNotEmpty();
    {
      List<Attribute> _allAttributes = this._commonExtension.allAttributes(it);
      boolean _hasElements = false;
      for(final Attribute attribute : _allAttributes) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "\t\t\t");
        }
        _builder.append("\t\t\t");
        String _mapperInit = this.mapperInit(attribute);
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
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }

  public CharSequence generateAbstractMapper(final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.sql.ResultSet;");
    _builder.newLine();
    _builder.append("import java.sql.SQLException;");
    _builder.newLine();
    _builder.append("import java.time.LocalDateTime;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.mapper.RowMapper;");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("public abstract class AbstractMapper<T> implements RowMapper<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected Integer mapToInteger(ResultSet r, String key) throws SQLException {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return r.getObject(key) != null ? r.getInt(key) : null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected Long mapToLong(ResultSet r, String key) throws SQLException {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return r.getObject(key) != null ? r.getLong(key) : null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected String mapToString(ResultSet r, String key) throws SQLException {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return r.getString(key);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected Float mapToFloat(ResultSet r, String key) throws SQLException {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return r.getObject(key) != null ? r.getFloat(key) : null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected Boolean mapToBoolean(ResultSet r, String key) throws SQLException {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return r.getObject(key) != null ? r.getBoolean(key) : null;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// SQLite: return r.getObject(key) != null ? (r.getInt(key) == 1 ? true : false) : null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected LocalDateTime mapToDateTime(ResultSet r, String key) throws SQLException {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return r.getTimestamp(key) != null ? r.getTimestamp(key).toLocalDateTime() : null;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// SQLite: return r.getString(key) != null ? Instant.ofEpochMilli(Long.parseLong(r.getString(key))).atZone(ZoneId.systemDefault()).toLocalDateTime() : null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
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

  private String mapperInit(final Attribute it) {
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
            String _type_2 = it.getType();
            boolean _equals_1 = Objects.equal(_type_2, "FormData");
            if (_equals_1) {
              _builder.append("null");
            } else {
              _builder.append("this.mapTo");
              String _javaType = this._typeExtension.javaType(it);
              _builder.append(_javaType);
              _builder.append("(r, \"");
              String _name_1 = it.getName();
              _builder.append(_name_1);
              _builder.append("\")");
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
}
