package de.acegen.templates.java.models;

import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.Model;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.java.AttributeExtension;
import de.acegen.extensions.java.ModelExtension;
import java.util.List;
import javax.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class JDBI3Mapper {
  @Inject
  @Extension
  private ModelExtension _modelExtension;
  
  @Inject
  @Extension
  private AttributeExtension _attributeExtension;
  
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
    String _name = httpServer.getName();
    _builder.append(_name);
    _builder.append(".models;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.sql.ResultSet;");
    _builder.newLine();
    _builder.append("import java.sql.SQLException;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.mapper.RowMapper;");
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.statement.StatementContext;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _modelMapper = this._modelExtension.modelMapper(it);
    _builder.append(_modelMapper);
    _builder.append(" implements RowMapper<");
    String _modelName = this._modelExtension.modelName(it);
    _builder.append(_modelName);
    _builder.append("> {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _modelName_1 = this._modelExtension.modelName(it);
    _builder.append(_modelName_1, "\t");
    _builder.append(" map(ResultSet r, StatementContext ctx) throws SQLException {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("return new ");
    String _modelClassName = this._modelExtension.modelClassName(it);
    _builder.append(_modelClassName, "\t\t");
    _builder.append("(");
    _builder.newLineIfNotEmpty();
    {
      List<Attribute> _allAttributes = this._modelExtension.allAttributes(it);
      boolean _hasElements = false;
      for(final Attribute attribute : _allAttributes) {
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
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
}
