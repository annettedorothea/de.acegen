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
package de.acegen.extensions.java;

import com.google.common.base.Objects;
import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.Model;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class AttributeExtension {
  @Extension
  private TypeExtension _typeExtension;

  public String propertyName(final Attribute it) {
    return StringExtensions.toFirstLower(it.getName());
  }

  public String declaration(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private ");
    String _javaType = this._typeExtension.javaType(it);
    _builder.append(_javaType);
    _builder.append(" ");
    String _propertyName = this.propertyName(it);
    _builder.append(_propertyName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }

  public String getterName(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("get");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    return _builder.toString();
  }

  public String setterName(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("set");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    return _builder.toString();
  }

  public String getter(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public ");
    String _javaType = this._typeExtension.javaType(it);
    _builder.append(_javaType);
    _builder.append(" ");
    String _terName = this.getterName(it);
    _builder.append(_terName);
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return this.");
    String _propertyName = this.propertyName(it);
    _builder.append(_propertyName, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }

  public String setter(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public void ");
    String _setterName = this.setterName(it);
    _builder.append(_setterName);
    _builder.append("(");
    String _javaType = this._typeExtension.javaType(it);
    _builder.append(_javaType);
    _builder.append(" ");
    String _propertyName = this.propertyName(it);
    _builder.append(_propertyName);
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("this.");
    String _propertyName_1 = this.propertyName(it);
    _builder.append(_propertyName_1, "\t");
    _builder.append(" = ");
    String _propertyName_2 = this.propertyName(it);
    _builder.append(_propertyName_2, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }

  public String setterWithFrozen(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public void ");
    String _setterName = this.setterName(it);
    _builder.append(_setterName);
    _builder.append("(");
    String _javaType = this._typeExtension.javaType(it);
    _builder.append(_javaType);
    _builder.append(" ");
    String _propertyName = this.propertyName(it);
    _builder.append(_propertyName);
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("if (this.frozen) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throw new RuntimeException(\"");
    String _propertyName_1 = this.propertyName(it);
    _builder.append(_propertyName_1, "\t\t");
    _builder.append(" is frozen\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("this.");
    String _propertyName_2 = this.propertyName(it);
    _builder.append(_propertyName_2, "\t");
    _builder.append(" = ");
    String _propertyName_3 = this.propertyName(it);
    _builder.append(_propertyName_3, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }

  public String jsonProperty(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@JsonProperty");
    _builder.newLine();
    {
      if (((it.getType() != null) && it.getType().equals("DateTime"))) {
        _builder.append("@JsonSerialize(converter = DateTimeToStringConverter.class)");
        _builder.newLineIfNotEmpty();
        _builder.append("@JsonDeserialize(converter = StringToDateTimeConverter.class)");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }

  public String randomValue(final Attribute it) {
    String _xifexpression = null;
    String _type = it.getType();
    boolean _tripleNotEquals = (_type != null);
    if (_tripleNotEquals) {
      String _switchResult = null;
      String _type_1 = it.getType();
      boolean _matched = false;
      if (Objects.equal(_type_1, "Integer")) {
        _matched=true;
        _switchResult = "random.nextInt(50)";
      }
      if (!_matched) {
        if (Objects.equal(_type_1, "Long")) {
          _matched=true;
          _switchResult = "random.nextLong()";
        }
      }
      if (!_matched) {
        if (Objects.equal(_type_1, "String")) {
          _matched=true;
          _switchResult = "randomString(random)";
        }
      }
      if (!_matched) {
        if (Objects.equal(_type_1, "Float")) {
          _matched=true;
          _switchResult = "random.nextFloat()";
        }
      }
      if (!_matched) {
        if (Objects.equal(_type_1, "Boolean")) {
          _matched=true;
          _switchResult = "random.nextBoolean()";
        }
      }
      if (!_matched) {
        if (Objects.equal(_type_1, "DateTime")) {
          _matched=true;
          _switchResult = "random.nextBoolean() ? java.time.LocalDateTime.now().plusMinutes(random.nextInt(60)) : java.time.LocalDateTime.now().minusMinutes(random.nextInt(60)) ";
        }
      }
      if (!_matched) {
        if (Objects.equal(_type_1, "FormData")) {
          _matched=true;
          _switchResult = "null";
        }
      }
      _xifexpression = _switchResult;
    }
    return _xifexpression;
  }

  public String paramAsJsonProperty(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@JsonProperty(\"");
    String _name = it.getName();
    _builder.append(_name);
    _builder.append("\") ");
    String _param = this.param(it);
    _builder.append(_param);
    return _builder.toString();
  }

  public String assign(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("this.");
    String _propertyName = this.propertyName(it);
    _builder.append(_propertyName);
    _builder.append(" = ");
    String _propertyName_1 = this.propertyName(it);
    _builder.append(_propertyName_1);
    _builder.append(";");
    return _builder.toString();
  }

  public String param(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    String _javaType = this._typeExtension.javaType(it);
    _builder.append(_javaType);
    _builder.append(" ");
    String _propertyName = this.propertyName(it);
    _builder.append(_propertyName);
    return _builder.toString();
  }

  public String formDataAttributeName(final Model it) {
    EList<Attribute> _attributes = it.getAttributes();
    for (final Attribute attr : _attributes) {
      String _type = attr.getType();
      boolean _equals = Objects.equal(_type, "FormData");
      if (_equals) {
        return attr.getName();
      }
    }
    return "formData";
  }
}
