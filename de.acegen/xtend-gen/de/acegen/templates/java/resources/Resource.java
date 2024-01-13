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
package de.acegen.templates.java.resources;

import com.google.common.base.Objects;
import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.AttributeParamRef;
import de.acegen.aceGen.AuthUser;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.java.AttributeExtension;
import de.acegen.extensions.java.EcoreExtension;
import de.acegen.extensions.java.TypeExtension;
import jakarta.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class Resource {
  @Inject
  @Extension
  private EcoreExtension _ecoreExtension;

  @Inject
  @Extension
  private AttributeExtension _attributeExtension;

  @Inject
  @Extension
  private TypeExtension _typeExtension;

  @Inject
  @Extension
  private CommonExtension _commonExtension;

  public CharSequence generate(final HttpServerAce it, final HttpServer httpServer, final AuthUser authUser) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _resourcePackageName = this._typeExtension.resourcePackageName(httpServer);
    _builder.append(_resourcePackageName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.UUID;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import javax.ws.rs.Consumes;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.Path;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.Produces;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.core.MediaType;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.core.Response;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.PathParam;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.QueryParam;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.time.LocalDateTime;");
    _builder.newLine();
    _builder.append("import java.time.format.DateTimeFormatter;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.apache.commons.lang3.StringUtils;");
    _builder.newLine();
    _builder.newLine();
    {
      Boolean _isMulitpartFormData = this._ecoreExtension.isMulitpartFormData(it);
      if ((_isMulitpartFormData).booleanValue()) {
        _builder.append("import org.glassfish.jersey.media.multipart.FormDataContentDisposition;");
        _builder.newLine();
        _builder.append("import org.glassfish.jersey.media.multipart.FormDataParam;");
        _builder.newLine();
        _builder.append("import java.io.InputStream;");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("import de.acegen.CustomAppConfiguration;");
    _builder.newLine();
    _builder.append("import de.acegen.IDaoProvider;");
    _builder.newLine();
    _builder.append("import de.acegen.ViewProvider;");
    _builder.newLine();
    _builder.append("import de.acegen.PersistenceConnection;");
    _builder.newLine();
    _builder.append("import de.acegen.Config;");
    _builder.newLine();
    _builder.append("import de.acegen.Data;");
    _builder.newLine();
    _builder.newLine();
    {
      if ((it.isAuthorize() && (authUser != null))) {
        _builder.append("import de.acegen.auth.");
        String _firstUpper = StringExtensions.toFirstUpper(authUser.getName());
        _builder.append(_firstUpper);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("import io.dropwizard.auth.Auth;");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("import com.codahale.metrics.annotation.Timed;");
    _builder.newLine();
    _builder.append("import com.codahale.metrics.annotation.Metered;");
    _builder.newLine();
    _builder.append("import com.codahale.metrics.annotation.ExceptionMetered;");
    _builder.newLine();
    _builder.append("import com.codahale.metrics.annotation.ResponseMetered;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.core.JsonProcessingException;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import javax.ws.rs.GET;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.POST;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.PUT;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.DELETE;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import de.acegen.Resource;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Path(\"");
    String _url = it.getUrl();
    _builder.append(_url);
    _builder.append("\")");
    _builder.newLineIfNotEmpty();
    _builder.append("@SuppressWarnings(\"unused\")");
    _builder.newLine();
    _builder.append("public class ");
    String _resourceName = this._typeExtension.resourceName(it);
    _builder.append(_resourceName);
    _builder.append(" extends Resource {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(");
    String _resourceName_1 = this._typeExtension.resourceName(it);
    _builder.append(_resourceName_1, "\t");
    _builder.append(".class);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private PersistenceConnection persistenceConnection;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private CustomAppConfiguration appConfiguration;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private IDaoProvider daoProvider;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private ViewProvider viewProvider;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _resourceName_2 = this._typeExtension.resourceName(it);
    _builder.append(_resourceName_2, "\t");
    _builder.append("(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append("IDaoProvider daoProvider, ViewProvider viewProvider) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("this.persistenceConnection = persistenceConnection;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("this.appConfiguration = appConfiguration;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("this.daoProvider = daoProvider;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("this.viewProvider = viewProvider;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    {
      String _type = it.getType();
      boolean _tripleNotEquals = (_type != null);
      if (_tripleNotEquals) {
        _builder.append("@");
        String _type_1 = it.getType();
        _builder.append(_type_1, "\t");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("@Timed(name = \"");
    String _actionName = this._typeExtension.actionName(it);
    _builder.append(_actionName, "\t");
    _builder.append("Timed\")");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("@Metered(name = \"");
    String _actionName_1 = this._typeExtension.actionName(it);
    _builder.append(_actionName_1, "\t");
    _builder.append("Metered\")");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("@ExceptionMetered");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@ResponseMetered");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Produces(MediaType.APPLICATION_JSON)");
    _builder.newLine();
    {
      Boolean _isMulitpartFormData_1 = this._ecoreExtension.isMulitpartFormData(it);
      if ((_isMulitpartFormData_1).booleanValue()) {
        _builder.append("\t");
        _builder.append("@Consumes(MediaType.MULTIPART_FORM_DATA)");
        _builder.newLine();
      } else {
        _builder.append("\t");
        _builder.append("@Consumes(MediaType.APPLICATION_JSON)");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("public Response ");
    String _firstLower = StringExtensions.toFirstLower(this._typeExtension.resourceName(it));
    _builder.append(_firstLower, "\t");
    _builder.append("(");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    {
      if ((it.isAuthorize() && (authUser != null))) {
        _builder.append("@Auth ");
        String _firstUpper_1 = StringExtensions.toFirstUpper(authUser.getName());
        _builder.append(_firstUpper_1, "\t\t\t");
        _builder.append(" ");
        String _firstLower_1 = StringExtensions.toFirstLower(authUser.getName());
        _builder.append(_firstLower_1, "\t\t\t");
        _builder.append(", ");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      EList<AttributeParamRef> _queryParams = it.getQueryParams();
      for(final AttributeParamRef param : _queryParams) {
        _builder.append("\t\t\t");
        _builder.append("@QueryParam(\"");
        String _propertyName = this._attributeExtension.propertyName(param.getAttribute());
        _builder.append(_propertyName, "\t\t\t");
        _builder.append("\") String ");
        String _propertyName_1 = this._attributeExtension.propertyName(param.getAttribute());
        _builder.append(_propertyName_1, "\t\t\t");
        _builder.append(", ");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<AttributeParamRef> _pathParams = it.getPathParams();
      for(final AttributeParamRef param_1 : _pathParams) {
        _builder.append("\t\t\t");
        _builder.append("@PathParam(\"");
        String _propertyName_2 = this._attributeExtension.propertyName(param_1.getAttribute());
        _builder.append(_propertyName_2, "\t\t\t");
        _builder.append("\") String ");
        String _propertyName_3 = this._attributeExtension.propertyName(param_1.getAttribute());
        _builder.append(_propertyName_3, "\t\t\t");
        _builder.append(", ");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      Boolean _isMulitpartFormData_2 = this._ecoreExtension.isMulitpartFormData(it);
      if ((_isMulitpartFormData_2).booleanValue()) {
        _builder.append("\t\t\t");
        _builder.append("@FormDataParam(\"");
        String _formDataAttributeName = this._attributeExtension.formDataAttributeName(it.getModel());
        _builder.append(_formDataAttributeName, "\t\t\t");
        _builder.append("\")FormDataContentDisposition contentDisposition,");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("@FormDataParam(\"");
        String _formDataAttributeName_1 = this._attributeExtension.formDataAttributeName(it.getModel());
        _builder.append(_formDataAttributeName_1, "\t\t\t");
        _builder.append("\")InputStream inputStream,");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t");
    _builder.append("@QueryParam(\"uuid\") String uuid");
    {
      int _size = it.getPayload().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _builder.append(", ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        String _payloadDataNameWithPackage = this._typeExtension.payloadDataNameWithPackage(it);
        _builder.append(_payloadDataNameWithPackage, "\t\t\t");
        _builder.append(" payload");
      }
    }
    _builder.append(") ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("throws JsonProcessingException {");
    _builder.newLine();
    {
      int _size_1 = it.getPayload().size();
      boolean _greaterThan_1 = (_size_1 > 0);
      if (_greaterThan_1) {
        _builder.append("\t\t");
        _builder.append("if (payload == null) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("return badRequest(\"payload must not be null\");");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.append("if (StringUtils.isBlank(uuid)) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("uuid = UUID.randomUUID().toString();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t");
    String _dataWithGenericModel = this._typeExtension.dataWithGenericModel(it.getModel());
    _builder.append(_dataWithGenericModel, "\t\t\t");
    _builder.append(" data = new ");
    String _dataWithGenericModel_1 = this._typeExtension.dataWithGenericModel(it.getModel());
    _builder.append(_dataWithGenericModel_1, "\t\t\t");
    _builder.append("(uuid);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    String _modelClassNameWithPackage = this._typeExtension.modelClassNameWithPackage(it.getModel());
    _builder.append(_modelClassNameWithPackage, "\t\t\t");
    _builder.append(" model = new ");
    String _modelClassNameWithPackage_1 = this._typeExtension.modelClassNameWithPackage(it.getModel());
    _builder.append(_modelClassNameWithPackage_1, "\t\t\t");
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    {
      EList<AttributeParamRef> _queryParams_1 = it.getQueryParams();
      for(final AttributeParamRef paramRef : _queryParams_1) {
        _builder.append("\t\t\t");
        String _initActionData = this.initActionData(paramRef);
        _builder.append(_initActionData, "\t\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<AttributeParamRef> _pathParams_1 = it.getPathParams();
      for(final AttributeParamRef paramRef_1 : _pathParams_1) {
        _builder.append("\t\t\t");
        String _initActionData_1 = this.initActionData(paramRef_1);
        _builder.append(_initActionData_1, "\t\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<AttributeParamRef> _payload = it.getPayload();
      for(final AttributeParamRef attributeRef : _payload) {
        _builder.append("\t\t\t");
        String _initActionDataFromPayload = this.initActionDataFromPayload(attributeRef);
        _builder.append(_initActionDataFromPayload, "\t\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      if ((it.isAuthorize() && (authUser != null))) {
        {
          List<Attribute> _allAttributes = this._commonExtension.allAttributes(it.getModel());
          for(final Attribute param_2 : _allAttributes) {
            {
              boolean _containsAttribute = this._commonExtension.containsAttribute(authUser.getAttributes(), param_2);
              if (_containsAttribute) {
                _builder.append("\t\t\t");
                _builder.append("model.");
                String _setterName = this._attributeExtension.setterName(param_2);
                _builder.append(_setterName, "\t\t\t");
                _builder.append("(");
                String _firstLower_2 = StringExtensions.toFirstLower(authUser.getName());
                _builder.append(_firstLower_2, "\t\t\t");
                _builder.append(".");
                String _terName = this._attributeExtension.getterName(param_2);
                _builder.append(_terName, "\t\t\t");
                _builder.append("());");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    {
      Boolean _isMulitpartFormData_3 = this._ecoreExtension.isMulitpartFormData(it);
      if ((_isMulitpartFormData_3).booleanValue()) {
        {
          List<Attribute> _allAttributes_1 = this._commonExtension.allAttributes(it.getModel());
          for(final Attribute param_3 : _allAttributes_1) {
            {
              String _type_2 = param_3.getType();
              boolean _equals = Objects.equal(_type_2, "FormData");
              if (_equals) {
                _builder.append("\t\t\t");
                _builder.append("model.");
                String _setterName_1 = this._attributeExtension.setterName(param_3);
                _builder.append(_setterName_1, "\t\t\t");
                _builder.append("(new de.acegen.FormData(contentDisposition, inputStream));");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("data.setModel(model);");
    _builder.newLine();
    _builder.append("\t\t\t");
    String _actionNameWithPackage = this._typeExtension.actionNameWithPackage(it);
    _builder.append(_actionNameWithPackage, "\t\t\t");
    _builder.append(" action = new ");
    String _actionNameWithPackage_1 = this._typeExtension.actionNameWithPackage(it);
    _builder.append(_actionNameWithPackage_1, "\t\t\t");
    _builder.append("(persistenceConnection, appConfiguration, daoProvider, viewProvider);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("data = action.apply(data);");
    _builder.newLine();
    {
      int _size_2 = it.getResponse().size();
      boolean _greaterThan_2 = (_size_2 > 0);
      if (_greaterThan_2) {
        _builder.append("\t\t\t");
        _builder.append("return Response.ok(new ");
        String _responseDataNameWithPackage = this._typeExtension.responseDataNameWithPackage(it);
        _builder.append(_responseDataNameWithPackage, "\t\t\t");
        _builder.append("(data.getModel())).build();");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("\t\t\t");
        _builder.append("return ok();");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.append("} catch (IllegalArgumentException x) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("LOG.error(\"bad request due to {} \", x.getMessage());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (Config.DEV.equals(appConfiguration.getConfig().getMode())) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("x.printStackTrace();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return badRequest(x.getMessage());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} catch (SecurityException x) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("LOG.error(\"unauthorized due to {} \", x.getMessage());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (Config.DEV.equals(appConfiguration.getConfig().getMode())) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("x.printStackTrace();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return unauthorized(\"authorization needed for ");
    String _url_1 = it.getUrl();
    _builder.append(_url_1, "\t\t\t");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("} catch (Exception x) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("LOG.error(\"internal server error due to {} \", x.getMessage());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (Config.DEV.equals(appConfiguration.getConfig().getMode())) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("x.printStackTrace();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return internalServerError(x);");
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
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  private String initActionDataFromPayload(final AttributeParamRef it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isNotNull = it.isNotNull();
      if (_isNotNull) {
        {
          if (("String".equals(it.getAttribute().getType()) && (!it.getAttribute().isList()))) {
            _builder.append("if (StringUtils.isBlank(payload.");
            String _terName = this._attributeExtension.getterName(it.getAttribute());
            _builder.append(_terName);
            _builder.append("()) || \"null\".equals(payload.");
            String _terName_1 = this._attributeExtension.getterName(it.getAttribute());
            _builder.append(_terName_1);
            _builder.append("())) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("return badRequest(\"");
            String _propertyName = this._attributeExtension.propertyName(it.getAttribute());
            _builder.append(_propertyName, "\t");
            _builder.append(" is mandatory\");");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          } else {
            _builder.append("if (payload.");
            String _terName_2 = this._attributeExtension.getterName(it.getAttribute());
            _builder.append(_terName_2);
            _builder.append("() == null) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("return badRequest(\"");
            String _propertyName_1 = this._attributeExtension.propertyName(it.getAttribute());
            _builder.append(_propertyName_1, "\t");
            _builder.append(" is mandatory\");");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("model.");
    String _setterName = this._attributeExtension.setterName(it.getAttribute());
    _builder.append(_setterName);
    _builder.append("(payload.");
    String _terName_3 = this._attributeExtension.getterName(it.getAttribute());
    _builder.append(_terName_3);
    _builder.append("());");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }

  private String initActionData(final AttributeParamRef it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((((it.getAttribute().getType() != null) && it.getAttribute().getType().equals("DateTime")) && (!it.getAttribute().isList()))) {
        {
          boolean _isNotNull = it.isNotNull();
          if (_isNotNull) {
            _builder.append("if (StringUtils.isBlank(");
            String _propertyName = this._attributeExtension.propertyName(it.getAttribute());
            _builder.append(_propertyName);
            _builder.append(") || \"null\".equals(");
            String _propertyName_1 = this._attributeExtension.propertyName(it.getAttribute());
            _builder.append(_propertyName_1);
            _builder.append(")) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("return badRequest(\"");
            String _propertyName_2 = this._attributeExtension.propertyName(it.getAttribute());
            _builder.append(_propertyName_2, "\t");
            _builder.append(" is mandatory\");");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("if (StringUtils.isNotBlank(");
        String _propertyName_3 = this._attributeExtension.propertyName(it.getAttribute());
        _builder.append(_propertyName_3);
        _builder.append(")) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("try {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("model.");
        String _setterName = this._attributeExtension.setterName(it.getAttribute());
        _builder.append(_setterName, "\t\t");
        _builder.append("(");
        {
          if (((it.getAttribute().getType() != null) && it.getAttribute().getType().equals("DateTime"))) {
            _builder.append("LocalDateTime.parse(");
            String _propertyName_4 = this._attributeExtension.propertyName(it.getAttribute());
            _builder.append(_propertyName_4, "\t\t");
            _builder.append(", DateTimeFormatter.ISO_DATE_TIME)");
          } else {
            String _propertyName_5 = this._attributeExtension.propertyName(it.getAttribute());
            _builder.append(_propertyName_5, "\t\t");
          }
        }
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("} catch (Exception x) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("LOG.warn(\"failed to parse dateTime ");
        String _propertyName_6 = this._attributeExtension.propertyName(it.getAttribute());
        _builder.append(_propertyName_6, "\t\t");
        _builder.append(" - {}\", ");
        String _propertyName_7 = this._attributeExtension.propertyName(it.getAttribute());
        _builder.append(_propertyName_7, "\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      } else {
        {
          boolean _isNotNull_1 = it.isNotNull();
          if (_isNotNull_1) {
            _builder.append("if (");
            String _name = it.getAttribute().getName();
            _builder.append(_name);
            _builder.append(" == null || StringUtils.isBlank(");
            String _propertyName_8 = this._attributeExtension.propertyName(it.getAttribute());
            _builder.append(_propertyName_8);
            _builder.append(") || \"null\".equals(");
            String _propertyName_9 = this._attributeExtension.propertyName(it.getAttribute());
            _builder.append(_propertyName_9);
            _builder.append(")) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("return badRequest(\"");
            String _propertyName_10 = this._attributeExtension.propertyName(it.getAttribute());
            _builder.append(_propertyName_10, "\t");
            _builder.append(" is mandatory\");");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          }
        }
        {
          boolean _equals = "Integer".equals(it.getAttribute().getType());
          if (_equals) {
            _builder.append("if (");
            String _propertyName_11 = this._attributeExtension.propertyName(it.getAttribute());
            _builder.append(_propertyName_11);
            _builder.append(" != null) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("model.");
            String _setterName_1 = this._attributeExtension.setterName(it.getAttribute());
            _builder.append(_setterName_1, "\t");
            _builder.append("(\"null\".equals(");
            String _propertyName_12 = this._attributeExtension.propertyName(it.getAttribute());
            _builder.append(_propertyName_12, "\t");
            _builder.append(") ? null : ");
            String _type = it.getAttribute().getType();
            _builder.append(_type, "\t");
            _builder.append(".parseInt(");
            String _propertyName_13 = this._attributeExtension.propertyName(it.getAttribute());
            _builder.append(_propertyName_13, "\t");
            _builder.append("));");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          } else {
            boolean _equals_1 = "String".equals(it.getAttribute().getType());
            if (_equals_1) {
              _builder.append("if (");
              String _propertyName_14 = this._attributeExtension.propertyName(it.getAttribute());
              _builder.append(_propertyName_14);
              _builder.append(" != null) {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("model.");
              String _setterName_2 = this._attributeExtension.setterName(it.getAttribute());
              _builder.append(_setterName_2, "\t");
              _builder.append("(");
              String _propertyName_15 = this._attributeExtension.propertyName(it.getAttribute());
              _builder.append(_propertyName_15, "\t");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
              _builder.append("}");
              _builder.newLine();
            } else {
              _builder.append("if (");
              String _propertyName_16 = this._attributeExtension.propertyName(it.getAttribute());
              _builder.append(_propertyName_16);
              _builder.append(" != null) {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("model.");
              String _setterName_3 = this._attributeExtension.setterName(it.getAttribute());
              _builder.append(_setterName_3, "\t");
              _builder.append("(\"null\".equals(");
              String _propertyName_17 = this._attributeExtension.propertyName(it.getAttribute());
              _builder.append(_propertyName_17, "\t");
              _builder.append(") ? null : ");
              String _type_1 = it.getAttribute().getType();
              _builder.append(_type_1, "\t");
              _builder.append(".parse");
              String _firstUpper = StringExtensions.toFirstUpper(it.getAttribute().getType());
              _builder.append(_firstUpper, "\t");
              _builder.append("(");
              String _propertyName_18 = this._attributeExtension.propertyName(it.getAttribute());
              _builder.append(_propertyName_18, "\t");
              _builder.append("));");
              _builder.newLineIfNotEmpty();
              _builder.append("}");
              _builder.newLine();
            }
          }
        }
      }
    }
    return _builder.toString();
  }
}
