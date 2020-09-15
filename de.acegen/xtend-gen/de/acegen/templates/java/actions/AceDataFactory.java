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
package de.acegen.templates.java.actions;

import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.HttpServerAceRead;
import de.acegen.aceGen.HttpServerAceWrite;
import de.acegen.aceGen.HttpServerOutcome;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.java.AceExtension;
import de.acegen.extensions.java.ModelExtension;
import java.util.Arrays;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class AceDataFactory {
  @Inject
  @Extension
  private ModelExtension _modelExtension;
  
  @Inject
  @Extension
  private AceExtension _aceExtension;
  
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  public CharSequence generateAceDataFactory(final HttpServer it) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = it.getName();
    _builder.append(_name);
    _builder.append(".actions;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.io.IOException;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import de.acegen.IDataContainer;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.ObjectMapper;");
    _builder.newLine();
    _builder.append("import ");
    String _name_1 = it.getName();
    _builder.append(_name_1);
    _builder.append(".data.*;");
    _builder.newLineIfNotEmpty();
    _builder.append("import com.fasterxml.jackson.databind.DeserializationFeature;\t\t");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class AceDataFactory {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static ObjectMapper mapper = new ObjectMapper();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static final Logger LOG = LoggerFactory.getLogger(AceDataFactory.class);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static IDataContainer createAceData(String className, String json) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("try {");
    _builder.newLine();
    {
      EList<HttpServerAce> _aceOperations = it.getAceOperations();
      for(final HttpServerAce ace : _aceOperations) {
        _builder.append("\t\t\t");
        CharSequence _createData = this.createData(ace, it);
        _builder.append(_createData, "\t\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("} catch (IOException e) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("LOG.error(\"failed to create ace data {} with data {}\", className, json, e);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return null;");
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
  
  private CharSequence _createData(final HttpServerAceWrite it, final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (className.equals(\"");
    String _name = httpServer.getName();
    _builder.append(_name);
    _builder.append(".actions.");
    String _actionName = this._aceExtension.actionName(it);
    _builder.append(_actionName);
    _builder.append("\") ||");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("className.equals(\"");
    String _name_1 = httpServer.getName();
    _builder.append(_name_1, "\t\t");
    _builder.append(".commands.");
    String _commandName = this._aceExtension.commandName(it);
    _builder.append(_commandName, "\t\t");
    _builder.append("\") ");
    {
      int _length = ((Object[])Conversions.unwrapArray(it.getOutcomes(), Object.class)).length;
      boolean _greaterThan = (_length > 0);
      if (_greaterThan) {
        _builder.append("||");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      EList<HttpServerOutcome> _outcomes = it.getOutcomes();
      boolean _hasElements = false;
      for(final HttpServerOutcome outcome : _outcomes) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("||", "\t\t");
        }
        _builder.append("\t\t");
        _builder.append("className.equals(\"");
        String _name_2 = httpServer.getName();
        _builder.append(_name_2, "\t\t");
        _builder.append(".events.");
        String _eventName = this._aceExtension.eventName(it, outcome);
        _builder.append(_eventName, "\t\t");
        _builder.append("\")");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append(") {");
    _builder.newLine();
    _builder.append("\t");
    String _dataName = this._modelExtension.dataName(it.getModel());
    _builder.append(_dataName, "\t");
    _builder.append(" data = mapper.readValue(json, ");
    String _dataName_1 = this._modelExtension.dataName(it.getModel());
    _builder.append(_dataName_1, "\t");
    _builder.append(".class);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("data.migrateLegacyData(json);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return data;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence _createData(final HttpServerAceRead it, final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (className.equals(\"");
    String _name = httpServer.getName();
    _builder.append(_name);
    _builder.append(".actions.");
    String _actionName = this._aceExtension.actionName(it);
    _builder.append(_actionName);
    _builder.append("\")) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _dataName = this._modelExtension.dataName(it.getModel());
    _builder.append(_dataName, "\t");
    _builder.append(" data = mapper.readValue(json, ");
    String _dataName_1 = this._modelExtension.dataName(it.getModel());
    _builder.append(_dataName_1, "\t");
    _builder.append(".class);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("data.migrateLegacyData(json);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return data;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence createData(final HttpServerAce it, final HttpServer httpServer) {
    if (it instanceof HttpServerAceRead) {
      return _createData((HttpServerAceRead)it, httpServer);
    } else if (it instanceof HttpServerAceWrite) {
      return _createData((HttpServerAceWrite)it, httpServer);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, httpServer).toString());
    }
  }
}
