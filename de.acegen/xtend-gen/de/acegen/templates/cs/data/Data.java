package de.acegen.templates.cs.data;

import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.AttributeParamRef;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.cs.AttributeExtension;
import de.acegen.extensions.cs.TypeExtension;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class Data {
  @Inject
  @Extension
  private AttributeExtension _attributeExtension;

  @Inject
  @Extension
  private CommonExtension _commonExtension;

  @Inject
  @Extension
  private TypeExtension _typeExtension;

  public CharSequence generateResponseData(final HttpServerAce it, final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("namespace ");
    CharSequence _dataNamespace = this._typeExtension.dataNamespace(httpServer);
    _builder.append(_dataNamespace);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    CharSequence _responseDataName = this._typeExtension.responseDataName(it);
    _builder.append(_responseDataName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<Attribute> _response = it.getResponse();
      for(final Attribute attribute : _response) {
        _builder.append("\t");
        String _declaration = this._attributeExtension.declaration(attribute);
        _builder.append(_declaration, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    CharSequence _responseDataName_1 = this._typeExtension.responseDataName(it);
    _builder.append(_responseDataName_1, "\t");
    _builder.append("(");
    String _modelClassNameWithPackage = this._typeExtension.modelClassNameWithPackage(it.getModel());
    _builder.append(_modelClassNameWithPackage, "\t");
    _builder.append(" model) {");
    _builder.newLineIfNotEmpty();
    {
      EList<Attribute> _response_1 = it.getResponse();
      for(final Attribute attribute_1 : _response_1) {
        _builder.append("\t\t");
        String _propertyName = this._attributeExtension.propertyName(attribute_1);
        _builder.append(_propertyName, "\t\t");
        _builder.append(" = model.");
        String _propertyName_1 = this._attributeExtension.propertyName(attribute_1);
        _builder.append(_propertyName_1, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
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

  public CharSequence generatePayloadData(final HttpServerAce it, final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("namespace ");
    CharSequence _dataNamespace = this._typeExtension.dataNamespace(httpServer);
    _builder.append(_dataNamespace);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    CharSequence _payloadDataName = this._typeExtension.payloadDataName(it);
    _builder.append(_payloadDataName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<AttributeParamRef> _payload = it.getPayload();
      for(final AttributeParamRef attributeRef : _payload) {
        _builder.append("\t");
        String _declaration = this._attributeExtension.declaration(attributeRef.getAttribute());
        _builder.append(_declaration, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
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
