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
package de.acegen.extensions.cs;

import de.acegen.aceGen.Attribute;
import javax.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class AttributeExtension {
  @Inject
  @Extension
  private TypeExtension _typeExtension;

  public String propertyName(final Attribute it) {
    return StringExtensions.toFirstUpper(it.getName());
  }

  public String declaration(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public ");
    String _csType = this._typeExtension.csType(it);
    _builder.append(_csType);
    _builder.append(" ");
    String _propertyName = this.propertyName(it);
    _builder.append(_propertyName);
    _builder.append(" {get; set;}");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }

  public String param(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    String _csType = this._typeExtension.csType(it);
    _builder.append(_csType);
    _builder.append(" ");
    String _firstLower = StringExtensions.toFirstLower(this.propertyName(it));
    _builder.append(_firstLower);
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }

  public String assign(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("this.");
    String _propertyName = this.propertyName(it);
    _builder.append(_propertyName);
    _builder.append(" = ");
    String _firstLower = StringExtensions.toFirstLower(this.propertyName(it));
    _builder.append(_firstLower);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
}
