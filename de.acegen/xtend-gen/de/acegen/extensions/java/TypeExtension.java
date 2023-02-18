package de.acegen.extensions.java;

import com.google.common.base.Objects;
import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.HttpServerOutcome;
import de.acegen.aceGen.Model;
import javax.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class TypeExtension {
  @Inject
  @Extension
  private EcoreExtension _ecoreExtension;

  public String dataPackageName(final HttpServer it) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = it.getName();
    _builder.append(_name);
    _builder.append(".data");
    return _builder.toString();
  }

  public String dataWithGenericModel(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Data<");
    String _modelClassNameWithPackage = this.modelClassNameWithPackage(it);
    _builder.append(_modelClassNameWithPackage);
    _builder.append(">");
    return _builder.toString();
  }

  public String payloadDataName(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Payload");
    return _builder.toString();
  }

  public String payloadDataNameWithPackage(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    String _dataPackageName = this.dataPackageName(this._ecoreExtension.parent(it));
    _builder.append(_dataPackageName);
    _builder.append(".");
    String _payloadDataName = this.payloadDataName(it);
    _builder.append(_payloadDataName);
    return _builder.toString();
  }

  public String responseDataName(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Response");
    return _builder.toString();
  }

  public String responseDataNameWithPackage(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    String _dataPackageName = this.dataPackageName(this._ecoreExtension.parent(it));
    _builder.append(_dataPackageName);
    _builder.append(".");
    String _responseDataName = this.responseDataName(it);
    _builder.append(_responseDataName);
    return _builder.toString();
  }

  public String javaType(final Attribute it) {
    String _type = it.getType();
    boolean _tripleNotEquals = (_type != null);
    if (_tripleNotEquals) {
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _isList = it.isList();
        if (_isList) {
          _builder.append("java.util.List<");
        }
      }
      {
        boolean _equals = it.getType().equals("DateTime");
        if (_equals) {
          _builder.append("java.time.LocalDateTime");
        } else {
          boolean _equals_1 = it.getType().equals("FormData");
          if (_equals_1) {
            _builder.append("de.acegen.FormData");
          } else {
            String _type_1 = it.getType();
            _builder.append(_type_1);
          }
        }
      }
      {
        boolean _isList_1 = it.isList();
        if (_isList_1) {
          _builder.append(">");
        }
      }
      return _builder.toString();
    }
    Model _model = it.getModel();
    boolean _tripleNotEquals_1 = (_model != null);
    if (_tripleNotEquals_1) {
      StringConcatenation _builder_1 = new StringConcatenation();
      {
        boolean _isList_2 = it.isList();
        if (_isList_2) {
          _builder_1.append("java.util.List<");
        }
      }
      String _modelClassNameWithPackage = this.modelClassNameWithPackage(it.getModel());
      _builder_1.append(_modelClassNameWithPackage);
      {
        boolean _isList_3 = it.isList();
        if (_isList_3) {
          _builder_1.append(">");
        }
      }
      return _builder_1.toString();
    }
    return null;
  }

  public String javaTypeNew(final Attribute it) {
    String _type = it.getType();
    boolean _tripleNotEquals = (_type != null);
    if (_tripleNotEquals) {
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _isList = it.isList();
        if (_isList) {
          _builder.append("java.util.ArrayList<");
        }
      }
      {
        boolean _equals = it.getType().equals("DateTime");
        if (_equals) {
          _builder.append("java.time.LocalDateTime");
        } else {
          String _type_1 = it.getType();
          _builder.append(_type_1);
        }
      }
      {
        boolean _isList_1 = it.isList();
        if (_isList_1) {
          _builder.append(">");
        }
      }
      return _builder.toString();
    }
    Model _model = it.getModel();
    boolean _tripleNotEquals_1 = (_model != null);
    if (_tripleNotEquals_1) {
      StringConcatenation _builder_1 = new StringConcatenation();
      {
        boolean _isList_2 = it.isList();
        if (_isList_2) {
          _builder_1.append("java.util.ArrayList<");
        }
      }
      String _modelClassNameWithPackage = this.modelClassNameWithPackage(it.getModel());
      _builder_1.append(_modelClassNameWithPackage);
      {
        boolean _isList_3 = it.isList();
        if (_isList_3) {
          _builder_1.append(">");
        }
      }
      return _builder_1.toString();
    }
    return null;
  }

  public String sqlType(final Attribute it) {
    String _xifexpression = null;
    String _type = it.getType();
    boolean _tripleNotEquals = (_type != null);
    if (_tripleNotEquals) {
      String _switchResult = null;
      String _type_1 = it.getType();
      boolean _matched = false;
      if (Objects.equal(_type_1, "Integer")) {
        _matched=true;
        _switchResult = "integer";
      }
      if (!_matched) {
        if (Objects.equal(_type_1, "Long")) {
          _matched=true;
          _switchResult = "bigint";
        }
      }
      if (!_matched) {
        if (Objects.equal(_type_1, "String")) {
          _matched=true;
          _switchResult = "character varying";
        }
      }
      if (!_matched) {
        if (Objects.equal(_type_1, "Float")) {
          _matched=true;
          _switchResult = "numeric";
        }
      }
      if (!_matched) {
        if (Objects.equal(_type_1, "Boolean")) {
          _matched=true;
          _switchResult = "boolean";
        }
      }
      if (!_matched) {
        if (Objects.equal(_type_1, "DateTime")) {
          _matched=true;
          _switchResult = "timestamp with time zone";
        }
      }
      _xifexpression = _switchResult;
    }
    return _xifexpression;
  }

  public String modelPackageName(final HttpServer it) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = it.getName();
    _builder.append(_name);
    _builder.append(".models");
    return _builder.toString();
  }

  public String modelPackageName(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = this._ecoreExtension.parent(it).getName();
    _builder.append(_name);
    _builder.append(".models");
    return _builder.toString();
  }

  public String modelClassName(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Model");
    return _builder.toString();
  }

  public String modelClassNameWithPackage(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    String _modelPackageName = this.modelPackageName(it);
    _builder.append(_modelPackageName);
    _builder.append(".");
    String _modelClassName = this.modelClassName(it);
    _builder.append(_modelClassName);
    return _builder.toString();
  }

  public String modelParamName(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstLower = StringExtensions.toFirstLower(it.getName());
    _builder.append(_firstLower);
    _builder.append("Model");
    return _builder.toString();
  }

  public String modelDao(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Dao");
    return _builder.toString();
  }

  public String modelDaoWithPackage(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    EObject _eContainer = it.eContainer();
    String _name = ((HttpServer) _eContainer).getName();
    _builder.append(_name);
    _builder.append(".models.");
    String _modelDao = this.modelDao(it);
    _builder.append(_modelDao);
    return _builder.toString();
  }

  public String abstractModelDao(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Abstract");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Dao");
    return _builder.toString();
  }

  public String tableName(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\\\"");
    String _lowerCase = it.getName().toLowerCase();
    _builder.append(_lowerCase);
    _builder.append("\\\"");
    return _builder.toString();
  }

  public String resourcePackageName(final HttpServer it) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = it.getName();
    _builder.append(_name);
    _builder.append(".resources");
    return _builder.toString();
  }

  public String resourceName(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Resource");
    return _builder.toString();
  }

  public String actionPackageName(final HttpServer it) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = it.getName();
    _builder.append(_name);
    _builder.append(".actions");
    return _builder.toString();
  }

  public String actionName(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Action");
    return _builder.toString();
  }

  public String abstractActionName(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Abstract");
    String _actionName = this.actionName(it);
    _builder.append(_actionName);
    return _builder.toString();
  }

  public String actionNameWithPackage(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    String _actionPackageName = this.actionPackageName(this._ecoreExtension.parent(it));
    _builder.append(_actionPackageName);
    _builder.append(".");
    String _actionName = this.actionName(it);
    _builder.append(_actionName);
    return _builder.toString();
  }

  public String commandPackage(final HttpServer it) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = it.getName();
    _builder.append(_name);
    _builder.append(".commands");
    return _builder.toString();
  }

  public String commandName(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Command");
    return _builder.toString();
  }

  public String abstractCommandName(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Abstract");
    String _commandName = this.commandName(it);
    _builder.append(_commandName);
    return _builder.toString();
  }

  public String commandNameWithPackage(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    String _commandPackage = this.commandPackage(this._ecoreExtension.parent(it));
    _builder.append(_commandPackage);
    _builder.append(".");
    String _commandName = this.commandName(it);
    _builder.append(_commandName);
    return _builder.toString();
  }

  public String eventName(final HttpServerAce it, final HttpServerOutcome outcome) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = this._ecoreExtension.parent(it).getName();
    _builder.append(_name);
    _builder.append(".events.");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    String _firstUpper_1 = StringExtensions.toFirstUpper(outcome.getName());
    _builder.append(_firstUpper_1);
    _builder.append("Event");
    return _builder.toString();
  }

  public String fileExtension() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(".java");
    return _builder.toString();
  }

  public String packageFolder(final HttpServer it) {
    StringConcatenation _builder = new StringConcatenation();
    String _replace = it.getName().replace(".", "/");
    _builder.append(_replace);
    return _builder.toString();
  }

  public String modelMapper(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Mapper");
    return _builder.toString();
  }
}
