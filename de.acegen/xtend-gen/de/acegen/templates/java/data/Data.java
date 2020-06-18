package de.acegen.templates.java.data;

import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAceRead;
import de.acegen.aceGen.Model;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.java.AceExtension;
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
public class Data {
  @Inject
  @Extension
  private ModelExtension _modelExtension;
  
  @Inject
  @Extension
  private AttributeExtension _attributeExtension;
  
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  @Inject
  @Extension
  private AceExtension _aceExtension;
  
  public CharSequence generateDataInterface(final Model it, final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = httpServer.getName();
    _builder.append(_name);
    _builder.append(".data;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.annotation.JsonDeserialize;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import de.acegen.IDataContainer;");
    _builder.newLine();
    _builder.newLine();
    String _importModel = this._modelExtension.importModel(it);
    _builder.append(_importModel);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("@JsonDeserialize(as=");
    String _dataName = this._modelExtension.dataName(it);
    _builder.append(_dataName);
    _builder.append(".class)");
    _builder.newLineIfNotEmpty();
    _builder.append("public interface ");
    String _dataInterfaceName = this._modelExtension.dataInterfaceName(it);
    _builder.append(_dataInterfaceName);
    _builder.append(" extends ");
    String _modelName = this._modelExtension.modelName(it);
    _builder.append(_modelName);
    _builder.append(", IDataContainer {");
    _builder.newLineIfNotEmpty();
    {
      EList<Model> _superModels = it.getSuperModels();
      for(final Model superModel : _superModels) {
        _builder.append("\t");
        _builder.append("void mapFrom(");
        String _interfaceWithPackage = this._modelExtension.interfaceWithPackage(superModel);
        _builder.append(_interfaceWithPackage, "\t");
        _builder.append(" model);");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      List<Attribute> _allAttributes = this._modelExtension.allAttributes(it);
      for(final Attribute attribute : _allAttributes) {
        _builder.append("\t");
        String _dataInterfaceName_1 = this._modelExtension.dataInterfaceName(it);
        _builder.append(_dataInterfaceName_1, "\t");
        _builder.append(" with");
        String _firstUpper = StringExtensions.toFirstUpper(attribute.getName());
        _builder.append(_firstUpper, "\t");
        _builder.append("(");
        String _javaType = this._attributeExtension.javaType(attribute);
        _builder.append(_javaType, "\t");
        _builder.append(" ");
        String _name_1 = attribute.getName();
        _builder.append(_name_1, "\t");
        _builder.append(");");
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
  
  public CharSequence generateAbstractData(final Model it, final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = httpServer.getName();
    _builder.append(_name);
    _builder.append(".data;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.annotation.JsonProperty;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.annotation.JsonSerialize;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.annotation.JsonDeserialize;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.time.LocalDateTime;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.append("import java.util.ArrayList;");
    _builder.newLine();
    String _importModel = this._modelExtension.importModel(it);
    _builder.append(_importModel);
    _builder.newLineIfNotEmpty();
    {
      EList<Model> _superModels = it.getSuperModels();
      for(final Model superModel : _superModels) {
        String _importModel_1 = this._modelExtension.importModel(superModel);
        _builder.append(_importModel_1);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("import de.acegen.AbstractData;");
    _builder.newLine();
    _builder.append("import de.acegen.IDataContainer;");
    _builder.newLine();
    _builder.append("import de.acegen.DateTimeToStringConverter;");
    _builder.newLine();
    _builder.append("import de.acegen.StringToDateTimeConverter;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"unused\")");
    _builder.newLine();
    _builder.append("public abstract class ");
    String _abstractDataName = this._modelExtension.abstractDataName(it);
    _builder.append(_abstractDataName);
    _builder.append(" extends AbstractData implements ");
    String _dataInterfaceName = this._modelExtension.dataInterfaceName(it);
    _builder.append(_dataInterfaceName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(");
    String _abstractDataName_1 = this._modelExtension.abstractDataName(it);
    _builder.append(_abstractDataName_1, "\t");
    _builder.append(".class);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      List<Attribute> _allAttributes = this._modelExtension.allAttributes(it);
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
    String _abstractDataName_2 = this._modelExtension.abstractDataName(it);
    _builder.append(_abstractDataName_2, "\t");
    _builder.append("(");
    _builder.newLineIfNotEmpty();
    {
      List<Attribute> _allAttributes_1 = this._modelExtension.allAttributes(it);
      boolean _hasElements = false;
      for(final Attribute attribute_1 : _allAttributes_1) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "\t\t");
        }
        _builder.append("\t\t");
        String _paramAsJsonProperty = this._attributeExtension.paramAsJsonProperty(attribute_1);
        _builder.append(_paramAsJsonProperty, "\t\t");
        _builder.newLineIfNotEmpty();
      }
      if (_hasElements) {
        _builder.append(",", "\t\t");
      }
    }
    _builder.append("\t\t");
    _builder.append("@JsonProperty(\"uuid\") String uuid");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(") {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super(uuid);");
    _builder.newLine();
    {
      List<Attribute> _allAttributes_2 = this._modelExtension.allAttributes(it);
      for(final Attribute attribute_2 : _allAttributes_2) {
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
      int _length = ((Object[])Conversions.unwrapArray(this._modelExtension.allAttributes(it), Object.class)).length;
      boolean _greaterThan = (_length > 0);
      if (_greaterThan) {
        _builder.append("\t");
        _builder.append("public ");
        String _abstractDataName_3 = this._modelExtension.abstractDataName(it);
        _builder.append(_abstractDataName_3, "\t");
        _builder.append("( String uuid ) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("super(uuid);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    {
      List<Attribute> _allAttributes_3 = this._modelExtension.allAttributes(it);
      for(final Attribute attribute_3 : _allAttributes_3) {
        _builder.append("\t");
        String _ter = this._attributeExtension.getter(attribute_3, true);
        _builder.append(_ter, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _setter = this._attributeExtension.setter(attribute_3);
        _builder.append(_setter, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _with = this._attributeExtension.with(attribute_3, it);
        _builder.append(_with, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      EList<Model> _superModels_1 = it.getSuperModels();
      for(final Model superModel_1 : _superModels_1) {
        _builder.append("\t");
        _builder.append("public void mapFrom(");
        String _interfaceWithPackage = this._modelExtension.interfaceWithPackage(superModel_1);
        _builder.append(_interfaceWithPackage, "\t");
        _builder.append(" model) {");
        _builder.newLineIfNotEmpty();
        {
          List<Attribute> _allAttributes_4 = this._modelExtension.allAttributes(superModel_1);
          for(final Attribute attribute_4 : _allAttributes_4) {
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("this.");
            String _name_1 = attribute_4.getName();
            _builder.append(_name_1, "\t\t");
            _builder.append(" = model.");
            String _terCall = this._attributeExtension.getterCall(attribute_4);
            _builder.append(_terCall, "\t\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("}");
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
  
  public CharSequence generateData(final Model it, final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = httpServer.getName();
    _builder.append(_name);
    _builder.append(".data;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.annotation.JsonProperty;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.time.LocalDateTime;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import de.acegen.AbstractData;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _dataName = this._modelExtension.dataName(it);
    _builder.append(_dataName);
    _builder.append(" extends ");
    String _abstractDataName = this._modelExtension.abstractDataName(it);
    _builder.append(_abstractDataName);
    _builder.append(" implements ");
    String _dataInterfaceName = this._modelExtension.dataInterfaceName(it);
    _builder.append(_dataInterfaceName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _dataName_1 = this._modelExtension.dataName(it);
    _builder.append(_dataName_1, "\t");
    _builder.append("(");
    _builder.newLineIfNotEmpty();
    {
      List<Attribute> _allAttributes = this._modelExtension.allAttributes(it);
      for(final Attribute attribute : _allAttributes) {
        _builder.append("\t\t");
        String _paramAsJsonProperty = this._attributeExtension.paramAsJsonProperty(attribute);
        _builder.append(_paramAsJsonProperty, "\t\t");
        _builder.append(", ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("@JsonProperty(\"uuid\") String uuid");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(") {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super(");
    _builder.newLine();
    {
      List<Attribute> _allAttributes_1 = this._modelExtension.allAttributes(it);
      for(final Attribute attribute_1 : _allAttributes_1) {
        _builder.append("\t\t\t");
        String _name_1 = attribute_1.getName();
        _builder.append(_name_1, "\t\t\t");
        _builder.append(",");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t");
    _builder.append("uuid");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append(");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      int _length = ((Object[])Conversions.unwrapArray(this._modelExtension.allAttributes(it), Object.class)).length;
      boolean _greaterThan = (_length > 0);
      if (_greaterThan) {
        _builder.append("\t");
        _builder.append("public ");
        String _dataName_2 = this._modelExtension.dataName(it);
        _builder.append(_dataName_2, "\t");
        _builder.append("( String uuid ) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("super(uuid);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("public void migrateLegacyData(String json) {");
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
  
  public CharSequence generateResponseData(final HttpServerAceRead it, final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = httpServer.getName();
    _builder.append(_name);
    _builder.append(".data;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.annotation.JsonProperty;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.annotation.JsonIgnore;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.annotation.JsonSerialize;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.annotation.JsonDeserialize;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.time.LocalDateTime;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import de.acegen.IDataContainer;");
    _builder.newLine();
    _builder.append("import de.acegen.DateTimeToStringConverter;");
    _builder.newLine();
    _builder.append("import de.acegen.StringToDateTimeConverter;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"all\")");
    _builder.newLine();
    _builder.append("public class ");
    String _responseDataName = this._aceExtension.responseDataName(it);
    _builder.append(_responseDataName);
    _builder.append(" implements ");
    String _responseDataInterfaceName = this._aceExtension.responseDataInterfaceName(it);
    _builder.append(_responseDataInterfaceName);
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
    _builder.append("public ");
    String _responseDataName_1 = this._aceExtension.responseDataName(it);
    _builder.append(_responseDataName_1, "\t");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _responseDataName_2 = this._aceExtension.responseDataName(it);
    _builder.append(_responseDataName_2, "\t");
    _builder.append("(");
    String _interfaceWithPackage = this._modelExtension.interfaceWithPackage(it.getModel());
    _builder.append(_interfaceWithPackage, "\t");
    _builder.append(" data) {");
    _builder.newLineIfNotEmpty();
    {
      EList<Attribute> _response_1 = it.getResponse();
      for(final Attribute attribute_1 : _response_1) {
        _builder.append("\t\t");
        String _name_1 = attribute_1.getName();
        _builder.append(_name_1, "\t\t");
        _builder.append(" = data.");
        String _terCall = this._attributeExtension.getterCall(attribute_1);
        _builder.append(_terCall, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<Attribute> _response_2 = it.getResponse();
      for(final Attribute attribute_2 : _response_2) {
        _builder.append("\t");
        String _ter = this._attributeExtension.getter(attribute_2, true);
        _builder.append(_ter, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateReponseDataInterface(final HttpServerAceRead it, final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = httpServer.getName();
    _builder.append(_name);
    _builder.append(".data;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public interface ");
    String _responseDataInterfaceName = this._aceExtension.responseDataInterfaceName(it);
    _builder.append(_responseDataInterfaceName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    {
      EList<Attribute> _response = it.getResponse();
      for(final Attribute attribute : _response) {
        _builder.append("\t");
        String _interfaceGetter = this._attributeExtension.interfaceGetter(attribute);
        _builder.append(_interfaceGetter, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
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
  
  public CharSequence generateIDataContainer() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.time.LocalDateTime;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public interface IDataContainer {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String getUuid();");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("void setUuid(String uuid);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String getOutcome();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("void setOutcome(String outcome);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("LocalDateTime getSystemTime();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("void setSystemTime(LocalDateTime systemTime);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("void migrateLegacyData(String json);");
    _builder.newLine();
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
  
  public CharSequence generateAbstractData() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.time.LocalDateTime;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.annotation.JsonProperty;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public abstract class AbstractData implements IDataContainer {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private String uuid;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private String outcome;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private LocalDateTime systemTime;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public AbstractData( String uuid ) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.uuid = uuid;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
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
    _builder.append("\t");
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void setUuid(String uuid) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.uuid = uuid;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public LocalDateTime getSystemTime() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return systemTime;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void setSystemTime(LocalDateTime systemTime) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.systemTime = systemTime;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String getOutcome() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return outcome;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void setOutcome(String outcome) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.outcome = outcome;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
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
