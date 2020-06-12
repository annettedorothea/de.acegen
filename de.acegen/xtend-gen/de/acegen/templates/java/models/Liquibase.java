package de.acegen.templates.java.models;

import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.Model;
import de.acegen.extensions.java.AttributeExtension;
import de.acegen.extensions.java.ModelExtension;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class Liquibase {
  @Inject
  @Extension
  private ModelExtension _modelExtension;
  
  @Inject
  @Extension
  private AttributeExtension _attributeExtension;
  
  public CharSequence generateMigration(final Model it, final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<createTable tableName=\"");
    String _lowerCase = it.getName().toLowerCase();
    _builder.append(_lowerCase);
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    {
      EList<Attribute> _attributes = it.getAttributes();
      for(final Attribute attribute : _attributes) {
        _builder.append("\t");
        _builder.append("<column name=\"");
        String _lowerCase_1 = attribute.getName().toLowerCase();
        _builder.append(_lowerCase_1, "\t");
        _builder.append("\" type=\"");
        String _sqlType = this._attributeExtension.sqlType(attribute);
        _builder.append(_sqlType, "\t");
        _builder.append("\">");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("<constraints ");
        {
          boolean _isPrimaryKey = attribute.isPrimaryKey();
          if (_isPrimaryKey) {
            _builder.append("primaryKey=\"true\"");
          }
        }
        _builder.append(" ");
        {
          boolean _isNotNull = attribute.isNotNull();
          if (_isNotNull) {
            _builder.append("nullable=\"false\"");
          }
        }
        _builder.append(" ");
        {
          Attribute _foreignKey = attribute.getForeignKey();
          boolean _tripleNotEquals = (_foreignKey != null);
          if (_tripleNotEquals) {
            _builder.append(" references=\"");
            String _tableName = this._attributeExtension.tableName(attribute.getForeignKey());
            _builder.append(_tableName, "\t\t");
            _builder.append("(");
            String _lowerCase_2 = attribute.getForeignKey().getName().toLowerCase();
            _builder.append(_lowerCase_2, "\t\t");
            _builder.append(")\" deleteCascade=\"true\" foreignKeyName=\"fk_");
            String _table = this._modelExtension.table(it);
            _builder.append(_table, "\t\t");
            _builder.append("_");
            String _lowerCase_3 = attribute.getForeignKey().getName().toLowerCase();
            _builder.append(_lowerCase_3, "\t\t");
            _builder.append("\"");
          }
        }
        _builder.append(" />");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("</column>");
        _builder.newLine();
      }
    }
    _builder.append("</createTable>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateAceMigration() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<createTable tableName=\"timeline\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<column name=\"type\" type=\"character varying\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<constraints nullable=\"false\" />");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</column>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<column name=\"name\" type=\"character varying\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<constraints nullable=\"false\" />");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</column>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<column name=\"time\" type=\"timestamp\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<constraints nullable=\"false\" />");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</column>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<column name=\"data\" type=\"text\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<constraints nullable=\"false\" />");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</column>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<column name=\"uuid\" type=\"character varying\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<constraints nullable=\"false\" />");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</column>");
    _builder.newLine();
    _builder.append("</createTable>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("<addUniqueConstraint columnNames=\"type, uuid\" tableName=\"timeline\" />");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
}
