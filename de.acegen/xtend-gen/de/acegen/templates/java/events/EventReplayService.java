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
package de.acegen.templates.java.events;

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
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class EventReplayService {
  @Inject
  @Extension
  private AceExtension _aceExtension;
  
  @Inject
  @Extension
  private ModelExtension _modelExtension;
  
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  public CharSequence generateEventReplayService() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class EventReplayService {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void replayEvent(String eventClass, String json, PersistenceHandle handle, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("//delegate to package EventReplayService");
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
  
  public CharSequence generateEventReplayService(final HttpServer it) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = it.getName();
    _builder.append(_name);
    _builder.append(".events;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import de.acegen.IDaoProvider;");
    _builder.newLine();
    _builder.append("import de.acegen.IEvent;");
    _builder.newLine();
    _builder.append("import de.acegen.Event;");
    _builder.newLine();
    _builder.append("import de.acegen.ViewProvider;");
    _builder.newLine();
    _builder.append("import ");
    String _name_1 = it.getName();
    _builder.append(_name_1);
    _builder.append(".data.*;");
    _builder.newLineIfNotEmpty();
    _builder.append("import com.fasterxml.jackson.databind.DeserializationFeature;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.ObjectMapper;");
    _builder.newLine();
    _builder.append("import de.acegen.IDataContainer;");
    _builder.newLine();
    _builder.append("import de.acegen.CustomAppConfiguration;");
    _builder.newLine();
    _builder.append("import de.acegen.PersistenceHandle;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.io.IOException;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"all\")");
    _builder.newLine();
    _builder.append("public class EventReplayService {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static ObjectMapper mapper = new ObjectMapper();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static final Logger LOG = LoggerFactory.getLogger(EventReplayService.class);");
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
    _builder.append("public static void replayEvent(String eventClass, String json, PersistenceHandle handle, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {");
    _builder.newLine();
    {
      int _eventCount = this.eventCount(it);
      boolean _greaterThan = (_eventCount > 0);
      if (_greaterThan) {
        _builder.append("\t\t");
        _builder.append("try {");
        _builder.newLine();
        {
          EList<HttpServerAce> _aceOperations = it.getAceOperations();
          for(final HttpServerAce ace : _aceOperations) {
            _builder.append("\t\t");
            _builder.append("\t");
            CharSequence _createEvent = this.createEvent(ace, it);
            _builder.append(_createEvent, "\t\t\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t");
        _builder.append("} catch (IOException e) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("LOG.error(\"failed to replay event {} with data {}\", eventClass, json, e);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
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
  
  private int eventCount(final HttpServer it) {
    int count = 0;
    EList<HttpServerAce> _aceOperations = it.getAceOperations();
    for (final HttpServerAce ace : _aceOperations) {
      if ((ace instanceof HttpServerAceWrite)) {
        final HttpServerAceWrite writeOp = ((HttpServerAceWrite) ace);
        EList<HttpServerOutcome> _outcomes = writeOp.getOutcomes();
        for (final HttpServerOutcome outcome : _outcomes) {
          int _count = count;
          int _size = outcome.getListeners().size();
          count = (_count + _size);
        }
      }
    }
    return count;
  }
  
  private CharSequence _createEvent(final HttpServerAceWrite it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<HttpServerOutcome> _outcomes = it.getOutcomes();
      for(final HttpServerOutcome outcome : _outcomes) {
        {
          int _size = outcome.getListeners().size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            _builder.append("if (eventClass.equals(\"");
            String _name = java.getName();
            _builder.append(_name);
            _builder.append(".events.");
            String _eventName = this._aceExtension.eventName(it, outcome);
            _builder.append(_eventName);
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
            _builder.append("Event event = new Event<");
            String _dataName_2 = this._modelExtension.dataName(it.getModel());
            _builder.append(_dataName_2, "\t");
            _builder.append(">(\"");
            String _name_1 = java.getName();
            _builder.append(_name_1, "\t");
            _builder.append(".events.");
            String _eventName_1 = this._aceExtension.eventName(it, outcome);
            _builder.append(_eventName_1, "\t");
            _builder.append("\", daoProvider, viewProvider, appConfiguration);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("event.notifyListeners(data, handle);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("event.notifyAfterCommitListeners(data, handle);");
            _builder.newLine();
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    return _builder;
  }
  
  private CharSequence _createEvent(final HttpServerAceRead it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  private CharSequence createEvent(final HttpServerAce it, final HttpServer java) {
    if (it instanceof HttpServerAceRead) {
      return _createEvent((HttpServerAceRead)it, java);
    } else if (it instanceof HttpServerAceWrite) {
      return _createEvent((HttpServerAceWrite)it, java);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, java).toString());
    }
  }
}
