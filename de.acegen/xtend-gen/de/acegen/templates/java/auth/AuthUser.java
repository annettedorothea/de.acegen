package de.acegen.templates.java.auth;

import de.acegen.aceGen.Attribute;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.java.AttributeExtension;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class AuthUser {
  @Inject
  @Extension
  private AttributeExtension _attributeExtension;
  
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  public CharSequence generateAuthUser(final de.acegen.aceGen.AuthUser it) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen.auth;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.security.Principal;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append(" implements Principal {");
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
    String _firstUpper_1 = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper_1, "\t");
    _builder.append(" (");
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
        String _ter = this._attributeExtension.getter(attribute_3, false);
        _builder.append(_ter, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("public String getName() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return \"AuthUser\";");
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
