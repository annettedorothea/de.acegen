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
package de.acegen.templates.cs.models;

import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.Model;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.java.AttributeExtension;
import de.acegen.extensions.java.ModelExtension;
import java.util.List;
import javax.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class Dao {
  @Inject
  @Extension
  private ModelExtension _modelExtension;
  
  @Inject
  @Extension
  private AttributeExtension _attributeExtension;
  
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  public CharSequence generateAbstractDao(final Model it, final HttpServer httpServer) {
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
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import java.util.Map;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public abstract class ");
    String _abstractModelDao = this._modelExtension.abstractModelDao(it);
    _builder.append(_abstractModelDao);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public abstract void insert(PersistenceHandle handle, ");
    String _modelName = this._modelExtension.modelName(it);
    _builder.append(_modelName, "\t");
    _builder.append(" ");
    String _modelParam = this._modelExtension.modelParam(it);
    _builder.append(_modelParam, "\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      List<Attribute> _allUniqueAttributes = this._modelExtension.allUniqueAttributes(it);
      for(final Attribute attribute : _allUniqueAttributes) {
        _builder.append("\t");
        _builder.append("public abstract void updateBy");
        String _firstUpper = StringExtensions.toFirstUpper(attribute.getName());
        _builder.append(_firstUpper, "\t");
        _builder.append("(PersistenceHandle handle, ");
        String _modelName_1 = this._modelExtension.modelName(it);
        _builder.append(_modelName_1, "\t");
        _builder.append(" ");
        String _modelParam_1 = this._modelExtension.modelParam(it);
        _builder.append(_modelParam_1, "\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public abstract void deleteBy");
        String _firstUpper_1 = StringExtensions.toFirstUpper(attribute.getName());
        _builder.append(_firstUpper_1, "\t");
        _builder.append("(PersistenceHandle handle, ");
        String _javaType = this._attributeExtension.javaType(attribute);
        _builder.append(_javaType, "\t");
        _builder.append(" ");
        String _name_1 = attribute.getName();
        _builder.append(_name_1, "\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public abstract ");
        String _modelName_2 = this._modelExtension.modelName(it);
        _builder.append(_modelName_2, "\t");
        _builder.append(" selectBy");
        String _firstUpper_2 = StringExtensions.toFirstUpper(attribute.getName());
        _builder.append(_firstUpper_2, "\t");
        _builder.append("(PersistenceHandle handle, ");
        String _javaType_1 = this._attributeExtension.javaType(attribute);
        _builder.append(_javaType_1, "\t");
        _builder.append(" ");
        String _name_2 = attribute.getName();
        _builder.append(_name_2, "\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      int _length = ((Object[])Conversions.unwrapArray(this._modelExtension.allPrimaryKeyAttributes(it), Object.class)).length;
      boolean _greaterThan = (_length > 0);
      if (_greaterThan) {
        _builder.append("\t");
        _builder.append("public abstract ");
        String _modelName_3 = this._modelExtension.modelName(it);
        _builder.append(_modelName_3, "\t");
        _builder.append(" selectByPrimaryKey(PersistenceHandle handle, ");
        {
          List<Attribute> _allPrimaryKeyAttributes = this._modelExtension.allPrimaryKeyAttributes(it);
          boolean _hasElements = false;
          for(final Attribute attribute_1 : _allPrimaryKeyAttributes) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(", ", "\t");
            }
            String _javaType_2 = this._attributeExtension.javaType(attribute_1);
            _builder.append(_javaType_2, "\t");
            _builder.append(" ");
            String _name_3 = attribute_1.getName();
            _builder.append(_name_3, "\t");
          }
        }
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public abstract int filterAndCountBy(PersistenceHandle handle, Map<String, String> filterMap);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public abstract List<");
    String _modelName_4 = this._modelExtension.modelName(it);
    _builder.append(_modelName_4, "\t");
    _builder.append("> selectAll(PersistenceHandle handle);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public abstract void truncate(PersistenceHandle handle);");
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
  
  public CharSequence generateDao(final Model it, final HttpServer httpServer) {
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
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import java.util.Map;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _modelDao = this._modelExtension.modelDao(it);
    _builder.append(_modelDao);
    _builder.append(" extends ");
    String _abstractModelDao = this._modelExtension.abstractModelDao(it);
    _builder.append(_abstractModelDao);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
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
    _builder.append("throw new RuntimeException(\"");
    String _modelDao_1 = this._modelExtension.modelDao(it);
    _builder.append(_modelDao_1, "\t\t");
    _builder.append(".insert not implemented\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      List<Attribute> _allUniqueAttributes = this._modelExtension.allUniqueAttributes(it);
      for(final Attribute attribute : _allUniqueAttributes) {
        _builder.append("\t");
        _builder.append("public void updateBy");
        String _firstUpper = StringExtensions.toFirstUpper(attribute.getName());
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
        _builder.append("throw new RuntimeException(\"");
        String _modelDao_2 = this._modelExtension.modelDao(it);
        _builder.append(_modelDao_2, "\t\t");
        _builder.append(".updateBy");
        String _firstUpper_1 = StringExtensions.toFirstUpper(attribute.getName());
        _builder.append(_firstUpper_1, "\t\t");
        _builder.append(" not implemented\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void deleteBy");
        String _firstUpper_2 = StringExtensions.toFirstUpper(attribute.getName());
        _builder.append(_firstUpper_2, "\t");
        _builder.append("(PersistenceHandle handle, ");
        String _javaType = this._attributeExtension.javaType(attribute);
        _builder.append(_javaType, "\t");
        _builder.append(" ");
        String _name_1 = attribute.getName();
        _builder.append(_name_1, "\t");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("throw new RuntimeException(\"");
        String _modelDao_3 = this._modelExtension.modelDao(it);
        _builder.append(_modelDao_3, "\t\t");
        _builder.append(".deleteBy");
        String _firstUpper_3 = StringExtensions.toFirstUpper(attribute.getName());
        _builder.append(_firstUpper_3, "\t\t");
        _builder.append(" not implemented\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        String _modelName_2 = this._modelExtension.modelName(it);
        _builder.append(_modelName_2, "\t");
        _builder.append(" selectBy");
        String _firstUpper_4 = StringExtensions.toFirstUpper(attribute.getName());
        _builder.append(_firstUpper_4, "\t");
        _builder.append("(PersistenceHandle handle, ");
        String _javaType_1 = this._attributeExtension.javaType(attribute);
        _builder.append(_javaType_1, "\t");
        _builder.append(" ");
        String _name_2 = attribute.getName();
        _builder.append(_name_2, "\t");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("throw new RuntimeException(\"");
        String _modelDao_4 = this._modelExtension.modelDao(it);
        _builder.append(_modelDao_4, "\t\t");
        _builder.append(".selectBy");
        String _firstUpper_5 = StringExtensions.toFirstUpper(attribute.getName());
        _builder.append(_firstUpper_5, "\t\t");
        _builder.append(" not implemented\");");
        _builder.newLineIfNotEmpty();
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
        String _modelName_3 = this._modelExtension.modelName(it);
        _builder.append(_modelName_3, "\t");
        _builder.append(" selectByPrimaryKey(PersistenceHandle handle, ");
        {
          List<Attribute> _allPrimaryKeyAttributes = this._modelExtension.allPrimaryKeyAttributes(it);
          boolean _hasElements = false;
          for(final Attribute attribute_1 : _allPrimaryKeyAttributes) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(", ", "\t");
            }
            String _javaType_2 = this._attributeExtension.javaType(attribute_1);
            _builder.append(_javaType_2, "\t");
            _builder.append(" ");
            String _name_3 = attribute_1.getName();
            _builder.append(_name_3, "\t");
          }
        }
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("throw new RuntimeException(\"");
        String _modelDao_5 = this._modelExtension.modelDao(it);
        _builder.append(_modelDao_5, "\t\t");
        _builder.append(".selectByPrimaryKey not implemented\");");
        _builder.newLineIfNotEmpty();
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
    _builder.append("throw new RuntimeException(\"");
    String _modelDao_6 = this._modelExtension.modelDao(it);
    _builder.append(_modelDao_6, "\t\t");
    _builder.append(".filterAndCountBy not implemented\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public List<");
    String _modelName_4 = this._modelExtension.modelName(it);
    _builder.append(_modelName_4, "\t");
    _builder.append("> selectAll(PersistenceHandle handle) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("throw new RuntimeException(\"");
    String _modelDao_7 = this._modelExtension.modelDao(it);
    _builder.append(_modelDao_7, "\t\t");
    _builder.append(".selectAll not implemented\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void truncate(PersistenceHandle handle) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throw new RuntimeException(\"");
    String _modelDao_8 = this._modelExtension.modelDao(it);
    _builder.append(_modelDao_8, "\t\t");
    _builder.append(".truncate not implemented\");");
    _builder.newLineIfNotEmpty();
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
  
  public CharSequence generateAceDao() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("namespace AceGen");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public interface IAceDao {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("bool checkUuid(string uuid);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("void addCommandToTimeLine(string commandName, IDataContainer data);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("void addActionToTimeline(string commandName, IDataContainer data);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("void addEventToTimeline(string commandName, IDataContainer data);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("void addExceptionToTimeline(string commandName, Exception data);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public class AceDao : IAceDao");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("public void addActionToTimeline(string commandName, IDataContainer data) {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("public void addCommandToTimeLine(string commandName, IDataContainer data) {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("public void addEventToTimeline(string commandName, IDataContainer data) {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("public void addExceptionToTimeline(string commandName, Exception data) {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("public bool checkUuid(string uuid)");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("throw new NotImplementedException();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
}
