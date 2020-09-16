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

import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.AttributeParamRef;
import de.acegen.aceGen.AuthUser;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.java.AceExtension;
import de.acegen.extensions.java.AttributeExtension;
import de.acegen.extensions.java.ModelExtension;
import java.util.List;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class Resource {
  @Inject
  @Extension
  private ModelExtension _modelExtension;
  
  @Inject
  @Extension
  private AceExtension _aceExtension;
  
  @Inject
  @Extension
  private AttributeExtension _attributeExtension;
  
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  public CharSequence generate(final HttpServerAce it, final HttpServer httpServer, final AuthUser authUser) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("package ");
    String _name = httpServer.getName();
    _builder.append(_name, "\t");
    _builder.append(".resources;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import java.util.UUID;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import javax.ws.rs.Consumes;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import javax.ws.rs.Path;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import javax.ws.rs.Produces;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import javax.ws.rs.core.MediaType;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import javax.ws.rs.core.Response;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import javax.ws.rs.PathParam;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import javax.ws.rs.QueryParam;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import java.time.LocalDateTime;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import java.time.format.DateTimeFormatter;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import org.apache.commons.lang3.StringUtils;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import de.acegen.CustomAppConfiguration;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import de.acegen.E2E;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import de.acegen.IDaoProvider;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import de.acegen.IDataContainer;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import de.acegen.ViewProvider;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import de.acegen.PersistenceConnection;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import de.acegen.PersistenceHandle;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import de.acegen.ReadAction;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import de.acegen.ITimelineItem;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import de.acegen.NotReplayableDataProvider;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      boolean _isAuthorize = it.isAuthorize();
      if (_isAuthorize) {
        _builder.append("\t");
        _builder.append("import de.acegen.auth.AuthUser;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("import io.dropwizard.auth.Auth;");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import com.codahale.metrics.annotation.Timed;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import com.codahale.metrics.annotation.Metered;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import com.codahale.metrics.annotation.ExceptionMetered;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import com.codahale.metrics.annotation.ResponseMetered;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import com.fasterxml.jackson.core.JsonProcessingException;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import javax.ws.rs.GET;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import javax.ws.rs.POST;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import javax.ws.rs.PUT;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import javax.ws.rs.DELETE;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    String _dataImport = this._modelExtension.dataImport(it.getModel());
    _builder.append(_dataImport, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _dataClassImport = this._modelExtension.dataClassImport(it.getModel());
    _builder.append(_dataClassImport, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import de.acegen.Resource;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Path(\"");
    String _url = it.getUrl();
    _builder.append(_url, "\t");
    _builder.append("\")");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("@SuppressWarnings(\"unused\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public class ");
    String _resourceName = this._aceExtension.resourceName(it);
    _builder.append(_resourceName, "\t");
    _builder.append(" extends Resource {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(");
    String _resourceName_1 = this._aceExtension.resourceName(it);
    _builder.append(_resourceName_1, "\t\t");
    _builder.append(".class);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("private PersistenceConnection persistenceConnection;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("private CustomAppConfiguration appConfiguration;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("private IDaoProvider daoProvider;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("private ViewProvider viewProvider;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("private E2E e2e;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _resourceName_2 = this._aceExtension.resourceName(it);
    _builder.append(_resourceName_2, "\t");
    _builder.append("(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append("IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {");
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
    _builder.append("\t\t\t");
    _builder.append("this.e2e = e2e;");
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
    String _actionName = this._aceExtension.actionName(it);
    _builder.append(_actionName, "\t");
    _builder.append("Timed\")");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("@Metered(name = \"");
    String _actionName_1 = this._aceExtension.actionName(it);
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
    _builder.append("\t");
    _builder.append("@Consumes(MediaType.APPLICATION_JSON)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Response ");
    String _firstLower = StringExtensions.toFirstLower(this._aceExtension.resourceName(it));
    _builder.append(_firstLower, "\t");
    _builder.append("(");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    {
      if ((it.isAuthorize() && (authUser != null))) {
        _builder.append("@Auth ");
        String _firstUpper = StringExtensions.toFirstUpper(authUser.getName());
        _builder.append(_firstUpper, "\t\t\t");
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
        String _name_1 = param.getAttribute().getName();
        _builder.append(_name_1, "\t\t\t");
        _builder.append("\") ");
        String _resourceParamType = this._attributeExtension.resourceParamType(param.getAttribute());
        _builder.append(_resourceParamType, "\t\t\t");
        _builder.append(" ");
        String _name_2 = param.getAttribute().getName();
        _builder.append(_name_2, "\t\t\t");
        _builder.append(", ");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<AttributeParamRef> _pathParams = it.getPathParams();
      for(final AttributeParamRef param_1 : _pathParams) {
        _builder.append("\t\t\t");
        _builder.append("@PathParam(\"");
        String _name_3 = param_1.getAttribute().getName();
        _builder.append(_name_3, "\t\t\t");
        _builder.append("\") ");
        String _resourceParamType_1 = this._attributeExtension.resourceParamType(param_1.getAttribute());
        _builder.append(_resourceParamType_1, "\t\t\t");
        _builder.append(" ");
        String _name_4 = param_1.getAttribute().getName();
        _builder.append(_name_4, "\t\t\t");
        _builder.append(", ");
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
        String _dataParamType = this._modelExtension.dataParamType(it.getModel());
        _builder.append(_dataParamType, "\t\t\t");
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
    String _dataInterfaceNameWithPackage = this._modelExtension.dataInterfaceNameWithPackage(it.getModel());
    _builder.append(_dataInterfaceNameWithPackage, "\t\t");
    _builder.append(" actionData = new ");
    String _dataName = this._modelExtension.dataName(it.getModel());
    _builder.append(_dataName, "\t\t");
    _builder.append("(uuid);");
    _builder.newLineIfNotEmpty();
    {
      EList<AttributeParamRef> _queryParams_1 = it.getQueryParams();
      for(final AttributeParamRef paramRef : _queryParams_1) {
        _builder.append("\t\t");
        String _initActionData = this._attributeExtension.initActionData(paramRef);
        _builder.append(_initActionData, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<AttributeParamRef> _pathParams_1 = it.getPathParams();
      for(final AttributeParamRef paramRef_1 : _pathParams_1) {
        _builder.append("\t\t");
        String _initActionData_1 = this._attributeExtension.initActionData(paramRef_1);
        _builder.append(_initActionData_1, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<AttributeParamRef> _payload = it.getPayload();
      for(final AttributeParamRef attributeRef : _payload) {
        _builder.append("\t\t");
        String _initActionDataFromPayload = this._attributeExtension.initActionDataFromPayload(attributeRef);
        _builder.append(_initActionDataFromPayload, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      if ((it.isAuthorize() && (authUser != null))) {
        {
          List<Attribute> _allAttributes = this._modelExtension.allAttributes(it.getModel());
          for(final Attribute param_2 : _allAttributes) {
            {
              boolean _containsAttribute = this._modelExtension.containsAttribute(authUser.getAttributes(), param_2);
              if (_containsAttribute) {
                _builder.append("\t\t");
                _builder.append("actionData.");
                StringConcatenation _builder_1 = new StringConcatenation();
                String _firstLower_2 = StringExtensions.toFirstLower(authUser.getName());
                _builder_1.append(_firstLower_2);
                _builder_1.append(".");
                String _terCall = this._attributeExtension.getterCall(param_2);
                _builder_1.append(_terCall);
                String _setterCall = this._attributeExtension.setterCall(param_2, _builder_1.toString());
                _builder.append(_setterCall, "\t\t");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    String _actionNameWithPackage = this._aceExtension.actionNameWithPackage(it);
    _builder.append(_actionNameWithPackage, "\t\t");
    _builder.append(" action = new ");
    String _actionNameWithPackage_1 = this._aceExtension.actionNameWithPackage(it);
    _builder.append(_actionNameWithPackage_1, "\t\t");
    _builder.append("(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("action.setActionData(actionData);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("action.apply();");
    _builder.newLine();
    {
      int _size_2 = it.getResponse().size();
      boolean _greaterThan_2 = (_size_2 > 0);
      if (_greaterThan_2) {
        _builder.append("\t\t\t");
        _builder.append("return Response.ok(new ");
        String _responseDataNameWithPackage = this._aceExtension.responseDataNameWithPackage(it, httpServer);
        _builder.append(_responseDataNameWithPackage, "\t\t\t");
        _builder.append("(action.getActionData())).build();");
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
    _builder.append("return badRequest(x.getMessage());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} catch (SecurityException x) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("LOG.error(\"unauthorized due to {} \", x.getMessage());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return unauthorized();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} catch (Exception x) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("LOG.error(\"internal server error due to {} \", x.getMessage());");
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
