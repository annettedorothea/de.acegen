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
package de.acegen.validation;

import de.acegen.aceGen.AceGenPackage;
import de.acegen.aceGen.HttpClientStateFunction;
import de.acegen.aceGen.HttpServerAceRead;
import org.eclipse.xtext.validation.Check;

/**
 * This class contains custom validation rules.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
@SuppressWarnings("all")
public class AceGenValidator extends AbstractAceGenValidator {
  @Check
  public void readShouldHaveResponse(final HttpServerAceRead ace) {
    int _size = ace.getResponse().size();
    boolean _equals = (_size == 0);
    if (_equals) {
      this.warning("GET request should have a response", 
        AceGenPackage.Literals.HTTP_SERVER__NAME);
    }
  }

  @Check
  public void doNotSetExclusiveView(final HttpClientStateFunction httpClientStateFunction) {
    boolean _isExclusiveView = httpClientStateFunction.getStateElement().isExclusiveView();
    if (_isExclusiveView) {
      this.warning("Do not set or merge an exclusive view, set or merge the direct child.", 
        AceGenPackage.Literals.HTTP_CLIENT_STATE_FUNCTION__STATE_ELEMENT);
    }
  }
}
