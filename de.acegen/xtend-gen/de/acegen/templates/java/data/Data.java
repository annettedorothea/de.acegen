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
package de.acegen.templates.java.data;

import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.AttributeParamRef;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.java.AttributeExtension;
import de.acegen.extensions.java.TypeExtension;
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
    _builder.append("package ");
    String _dataPackageName = this._typeExtension.dataPackageName(httpServer);
    _builder.append(_dataPackageName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _responseDataName = this._typeExtension.responseDataName(it);
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
    _builder.append("public ");
    String _responseDataName_1 = this._typeExtension.responseDataName(it);
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
    String _responseDataName_2 = this._typeExtension.responseDataName(it);
    _builder.append(_responseDataName_2, "\t");
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
        String _terName = this._attributeExtension.getterName(attribute_1);
        _builder.append(_terName, "\t\t");
        _builder.append("();");
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
        String _ter = this._attributeExtension.getter(attribute_2);
        _builder.append(_ter, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("\t");
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
    _builder.append("package ");
    String _dataPackageName = this._typeExtension.dataPackageName(httpServer);
    _builder.append(_dataPackageName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.annotation.JsonProperty;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.annotation.JsonSerialize;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.annotation.JsonDeserialize;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import de.acegen.DateTimeToStringConverter;");
    _builder.newLine();
    _builder.append("import de.acegen.StringToDateTimeConverter;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"unused\")");
    _builder.newLine();
    _builder.append("public class ");
    String _payloadDataName = this._typeExtension.payloadDataName(it);
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
    _builder.append("public ");
    String _payloadDataName_1 = this._typeExtension.payloadDataName(it);
    _builder.append(_payloadDataName_1, "\t");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<AttributeParamRef> _payload_1 = it.getPayload();
      for(final AttributeParamRef attributeRef_1 : _payload_1) {
        _builder.append("\t");
        String _jsonProperty = this._attributeExtension.jsonProperty(attributeRef_1.getAttribute());
        _builder.append(_jsonProperty, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _ter = this._attributeExtension.getter(attributeRef_1.getAttribute());
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
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import java.util.ArrayList;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.annotation.JsonProperty;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.annotation.JsonDeserialize;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.annotation.JsonSerialize;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class Data<T extends AbstractModel> {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private String uuid;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private List<String> outcomes;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private LocalDateTime systemTime;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected Boolean frozen = false;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private Boolean systemTimeFrozen = false;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private T model;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Data( String uuid ) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.uuid = uuid;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("outcomes = new ArrayList<String>();");
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
    _builder.append("@JsonSerialize(converter = DateTimeToStringConverter.class)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonDeserialize(converter = StringToDateTimeConverter.class)");
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
    _builder.append("if (systemTimeFrozen) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw new RuntimeException(\"system time is frozen\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
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
    _builder.append("public List<String> getOutcomes() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return this.outcomes;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public boolean hasOutcome(String outcome) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return outcomes.contains(outcome);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void addOutcome(String outcome) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.outcomes.add(outcome);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void freeze() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.frozen = true;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("model.freeze();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void freezeSystemTime() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.systemTimeFrozen = true;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public T getModel() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return model;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void setModel(T model) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (frozen) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw new RuntimeException(model.getClass() + \" is frozen\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.model = model;");
    _builder.newLine();
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
}
