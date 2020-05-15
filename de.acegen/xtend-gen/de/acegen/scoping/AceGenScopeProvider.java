/**
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 * 
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */
package de.acegen.scoping;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import de.acegen.aceGen.AceGenPackage;
import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.AttributeParamRef;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.HttpServerAceWrite;
import de.acegen.aceGen.HttpServerOutcome;
import de.acegen.aceGen.HttpServerViewFunction;
import de.acegen.aceGen.JsonArray;
import de.acegen.aceGen.JsonMember;
import de.acegen.aceGen.JsonObject;
import de.acegen.aceGen.Model;
import de.acegen.aceGen.Scenario;
import de.acegen.aceGen.ThenBlock;
import de.acegen.aceGen.WhenBlock;
import de.acegen.extensions.java.ModelExtension;
import de.acegen.scoping.AbstractAceGenScopeProvider;
import java.util.ArrayList;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.FilteringScope;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
@SuppressWarnings("all")
public class AceGenScopeProvider extends AbstractAceGenScopeProvider {
  @Inject
  @Extension
  private ModelExtension _modelExtension;
  
  @Override
  public IScope getScope(final EObject context, final EReference reference) {
    if (((context instanceof HttpServerAce) && Objects.equal(reference, AceGenPackage.Literals.HTTP_SERVER_ACE__RESPONSE))) {
      final HttpServerAce javaAce = ((HttpServerAce) context);
      final ArrayList<Attribute> attrs = new ArrayList<Attribute>();
      this._modelExtension.allAttributesRec(javaAce.getModel(), attrs);
      return Scopes.scopeFor(attrs);
    }
    if (((context instanceof HttpServerAce) && Objects.equal(reference, AceGenPackage.Literals.ATTRIBUTE_PARAM_REF__ATTRIBUTE))) {
      final HttpServerAce javaAce_1 = ((HttpServerAce) context);
      final ArrayList<Attribute> attrs_1 = new ArrayList<Attribute>();
      this._modelExtension.allAttributesRec(javaAce_1.getModel(), attrs_1);
      return Scopes.scopeFor(attrs_1);
    }
    if (((context instanceof AttributeParamRef) && 
      Objects.equal(reference, AceGenPackage.Literals.ATTRIBUTE_PARAM_REF__ATTRIBUTE))) {
      final AttributeParamRef attributeParamRef = ((AttributeParamRef) context);
      EObject _eContainer = attributeParamRef.eContainer();
      final HttpServerAce javaAce_2 = ((HttpServerAce) _eContainer);
      final ArrayList<Attribute> attrs_2 = new ArrayList<Attribute>();
      this._modelExtension.allAttributesRec(javaAce_2.getModel(), attrs_2);
      return Scopes.scopeFor(attrs_2);
    }
    if ((context instanceof HttpServerOutcome)) {
      EObject _eContainer_1 = ((HttpServerOutcome)context).eContainer();
      final Model aceModel = ((HttpServerAceWrite) _eContainer_1).getModel();
      boolean _equals = reference.getName().equals("listeners");
      if (_equals) {
        final IScope scope = super.getScope(context, reference);
        final Predicate<IEObjectDescription> _function = (IEObjectDescription it) -> {
          EObject _eObjectOrProxy = it.getEObjectOrProxy();
          return ((HttpServerViewFunction) _eObjectOrProxy).getModel().equals(aceModel);
        };
        return new FilteringScope(scope, _function);
      } else {
        boolean _equals_1 = reference.getName().equals("aceOperations");
        if (_equals_1) {
          final IScope scope_1 = super.getScope(context, reference);
          final Predicate<IEObjectDescription> _function_1 = (IEObjectDescription it) -> {
            EObject _eObjectOrProxy = it.getEObjectOrProxy();
            return ((HttpServerAceWrite) _eObjectOrProxy).getModel().equals(aceModel);
          };
          return new FilteringScope(scope_1, _function_1);
        }
      }
    }
    if ((context instanceof Model)) {
      final Model aceModel_1 = ((Model) context);
      final IScope scope_2 = super.getScope(context, reference);
      final Predicate<IEObjectDescription> _function_2 = (IEObjectDescription it) -> {
        EObject _eObjectOrProxy = it.getEObjectOrProxy();
        boolean _equals_2 = ((Model) _eObjectOrProxy).equals(aceModel_1);
        return (!_equals_2);
      };
      return new FilteringScope(scope_2, _function_2);
    }
    if ((((context instanceof JsonObject) || (context instanceof JsonArray)) || (context instanceof JsonMember))) {
      EObject parent = context.eContainer();
      boolean isThen = false;
      boolean isWhen = false;
      while (((parent != null) && (!((parent instanceof Scenario) || (parent instanceof JsonMember))))) {
        {
          parent = parent.eContainer();
          if ((parent instanceof ThenBlock)) {
            isThen = true;
          }
          if ((parent instanceof WhenBlock)) {
            isWhen = true;
          }
        }
      }
      if ((parent instanceof Scenario)) {
        final Scenario scenario = ((Scenario) parent);
        if (isWhen) {
          ArrayList<Attribute> attr = new ArrayList<Attribute>();
          EList<AttributeParamRef> _payload = scenario.getWhenBlock().getAction().getPayload();
          for (final AttributeParamRef attributeRef : _payload) {
            attr.add(attributeRef.getAttribute());
          }
          EList<AttributeParamRef> _queryParams = scenario.getWhenBlock().getAction().getQueryParams();
          for (final AttributeParamRef attributeRef_1 : _queryParams) {
            attr.add(attributeRef_1.getAttribute());
          }
          EList<AttributeParamRef> _pathParams = scenario.getWhenBlock().getAction().getPathParams();
          for (final AttributeParamRef attributeRef_2 : _pathParams) {
            attr.add(attributeRef_2.getAttribute());
          }
          attr.addAll(this._modelExtension.allNotReplayableAttributes(scenario.getWhenBlock().getAction().getModel()));
          return Scopes.scopeFor(attr);
        } else {
          if (isThen) {
            return Scopes.scopeFor(scenario.getWhenBlock().getAction().getResponse());
          }
        }
      }
      if ((parent instanceof JsonMember)) {
        final JsonMember jsonMember = ((JsonMember) parent);
        Model _model = jsonMember.getAttribute().getModel();
        boolean _tripleNotEquals = (_model != null);
        if (_tripleNotEquals) {
          Model _model_1 = jsonMember.getAttribute().getModel();
          final Model model = ((Model) _model_1);
          return this.getScopeFor(model);
        }
      }
    }
    return super.getScope(context, reference);
  }
  
  private IScope getScopeFor(final Model aceModel) {
    final ArrayList<Attribute> attrs = new ArrayList<Attribute>();
    this._modelExtension.allAttributesRec(aceModel, attrs);
    return Scopes.scopeFor(attrs);
  }
}
