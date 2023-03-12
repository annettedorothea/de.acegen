package de.acegen.extensions.cs;

import com.google.common.base.Objects;
import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.Model;
import de.acegen.extensions.java.EcoreExtension;
import javax.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class TypeExtension {
  @Inject
  @Extension
  private EcoreExtension _ecoreExtension;

  public String namespace(final HttpServer it) {
    return it.getName().substring(0, it.getName().lastIndexOf("."));
  }

  public CharSequence dataNamespace(final HttpServer it) {
    StringConcatenation _builder = new StringConcatenation();
    String _namespace = this.namespace(it);
    _builder.append(_namespace);
    _builder.append(".Data.");
    String _module = this.module(it);
    _builder.append(_module);
    return _builder;
  }

  public CharSequence controllerNamespace(final HttpServer it) {
    StringConcatenation _builder = new StringConcatenation();
    String _namespace = this.namespace(it);
    _builder.append(_namespace);
    _builder.append(".Controller");
    return _builder;
  }

  public CharSequence acegenNamespace(final HttpServer it) {
    StringConcatenation _builder = new StringConcatenation();
    String _namespace = this.namespace(it);
    _builder.append(_namespace);
    _builder.append(".AceGen");
    return _builder;
  }

  public CharSequence modelNamespace(final HttpServer it) {
    StringConcatenation _builder = new StringConcatenation();
    String _namespace = this.namespace(it);
    _builder.append(_namespace);
    _builder.append(".Model.");
    String _module = this.module(it);
    _builder.append(_module);
    return _builder;
  }

  public String module(final HttpServer it) {
    final String[] parts = it.getName().split("\\.");
    int _length = parts.length;
    int _minus = (_length - 1);
    return parts[_minus];
  }

  public CharSequence dataDirectory(final HttpServer it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Data/");
    String _module = this.module(it);
    _builder.append(_module);
    return _builder;
  }

  public CharSequence modelDirectory(final HttpServer it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Model/");
    String _module = this.module(it);
    _builder.append(_module);
    return _builder;
  }

  public CharSequence controllerDirectory(final HttpServer it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Controller");
    return _builder;
  }

  public CharSequence acegenDirectory(final HttpServer it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("AceGen");
    return _builder;
  }

  public CharSequence controllerName(final HttpServer it) {
    StringConcatenation _builder = new StringConcatenation();
    String _module = this.module(it);
    _builder.append(_module);
    return _builder;
  }

  public CharSequence responseDataName(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Response");
    return _builder;
  }

  public CharSequence payloadDataName(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Payload");
    return _builder;
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
    CharSequence _modelNamespace = this.modelNamespace(this._ecoreExtension.parent(it));
    _builder.append(_modelNamespace);
    _builder.append(".");
    String _modelClassName = this.modelClassName(it);
    _builder.append(_modelClassName);
    return _builder.toString();
  }

  public String csType(final Attribute it) {
    String _type = it.getType();
    boolean _tripleNotEquals = (_type != null);
    if (_tripleNotEquals) {
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _isList = it.isList();
        if (_isList) {
          _builder.append("List<");
        }
      }
      {
        boolean _equals = it.getType().equals("DateTime");
        if (_equals) {
          _builder.append("DateTime");
        } else {
          boolean _equals_1 = it.getType().equals("FormData");
          if (_equals_1) {
            _builder.append("de.acegen.FormData");
          } else {
            String _primitiveType = this.primitiveType(it);
            _builder.append(_primitiveType);
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
          _builder_1.append("List<");
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

  public String primitiveType(final Attribute it) {
    String _type = it.getType();
    boolean _equals = Objects.equal(_type, "String");
    if (_equals) {
      return "string";
    }
    String _type_1 = it.getType();
    boolean _equals_1 = Objects.equal(_type_1, "Integer");
    if (_equals_1) {
      return "int";
    }
    String _type_2 = it.getType();
    boolean _equals_2 = Objects.equal(_type_2, "Boolean");
    if (_equals_2) {
      return "bool";
    }
    String _type_3 = it.getType();
    boolean _equals_3 = Objects.equal(_type_3, "Float");
    if (_equals_3) {
      return "float";
    }
    return it.getType();
  }
}
