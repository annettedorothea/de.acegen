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
import de.acegen.aceGen.AttributeAndValue;
import de.acegen.aceGen.AttributeParamRef;
import de.acegen.aceGen.ClientWhenBlock;
import de.acegen.aceGen.Count;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.HttpServerAceRead;
import de.acegen.aceGen.HttpServerAceWrite;
import de.acegen.aceGen.HttpServerOutcome;
import de.acegen.aceGen.HttpServerViewFunction;
import de.acegen.aceGen.Input;
import de.acegen.aceGen.InputValue;
import de.acegen.aceGen.JsonArray;
import de.acegen.aceGen.JsonMember;
import de.acegen.aceGen.JsonObject;
import de.acegen.aceGen.Model;
import de.acegen.aceGen.PersistenceVerification;
import de.acegen.aceGen.Scenario;
import de.acegen.aceGen.SelectByPrimaryKeys;
import de.acegen.aceGen.SelectByUniqueAttribute;
import de.acegen.aceGen.ThenBlock;
import de.acegen.aceGen.TriggeredAction;
import de.acegen.aceGen.WhenBlock;
import de.acegen.extensions.java.ModelExtension;
import de.acegen.scoping.AbstractAceGenScopeProvider;
import java.util.ArrayList;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
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
    if (((context instanceof ClientWhenBlock) && Objects.equal(reference, AceGenPackage.Literals.INPUT_VALUE__INPUT))) {
      final ClientWhenBlock clientWhenBlock = ((ClientWhenBlock) context);
      return Scopes.scopeFor(clientWhenBlock.getAction().getInput());
    }
    if (((context instanceof TriggeredAction) && Objects.equal(reference, AceGenPackage.Literals.INPUT_VALUE__INPUT))) {
      final TriggeredAction triggeredAction = ((TriggeredAction) context);
      return Scopes.scopeFor(triggeredAction.getHttpClientAce().getInput());
    }
    if (((context instanceof InputValue) && Objects.equal(reference, AceGenPackage.Literals.INPUT_VALUE__INPUT))) {
      final EObject parent = context.eContainer();
      if ((parent instanceof TriggeredAction)) {
        final TriggeredAction triggeredAction_1 = ((TriggeredAction) parent);
        return Scopes.scopeFor(triggeredAction_1.getHttpClientAce().getInput());
      } else {
        if ((parent instanceof ClientWhenBlock)) {
          final EList<Input> input = ((ClientWhenBlock) parent).getAction().getInput();
          return Scopes.scopeFor(input);
        }
      }
    }
    if (((context instanceof HttpServerAceRead) && 
      Objects.equal(reference, AceGenPackage.Literals.HTTP_SERVER_ACE_READ__RESPONSE))) {
      final HttpServerAceRead javaAce = ((HttpServerAceRead) context);
      final ArrayList<Attribute> attrs = new ArrayList<Attribute>();
      this._modelExtension.allAttributesRec(javaAce.getModel(), attrs);
      return Scopes.scopeFor(attrs);
    }
    if (((context instanceof AttributeParamRef) && 
      Objects.equal(reference, AceGenPackage.Literals.ATTRIBUTE_PARAM_REF__ATTRIBUTE))) {
      final AttributeParamRef attributeParamRef = ((AttributeParamRef) context);
      EObject _eContainer = attributeParamRef.eContainer();
      final HttpServerAce javaAce_1 = ((HttpServerAce) _eContainer);
      final ArrayList<Attribute> attrs_1 = new ArrayList<Attribute>();
      this._modelExtension.allAttributesRec(javaAce_1.getModel(), attrs_1);
      return Scopes.scopeFor(attrs_1);
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
    if (((context instanceof AttributeAndValue) && 
      Objects.equal(reference, AceGenPackage.Literals.ATTRIBUTE_AND_VALUE__ATTRIBUTE))) {
      EObject _eContainer_2 = context.eContainer().eContainer();
      final PersistenceVerification persistenceVerification = ((PersistenceVerification) _eContainer_2);
      final Model model = persistenceVerification.getModel();
      final ArrayList<Attribute> attrs_2 = new ArrayList<Attribute>();
      this._modelExtension.allAttributesRec(model, attrs_2);
      EObject _eContainer_3 = context.eContainer();
      final boolean selectByUnique = (_eContainer_3 instanceof SelectByUniqueAttribute);
      EObject _eContainer_4 = context.eContainer();
      final boolean selectByPrimary = (_eContainer_4 instanceof SelectByPrimaryKeys);
      if ((selectByUnique || selectByPrimary)) {
        final ArrayList<Attribute> filtered = new ArrayList<Attribute>();
        for (final Attribute attribute : attrs_2) {
          if (((attribute.isUnique() && selectByUnique) || (attribute.isPrimaryKey() && selectByPrimary))) {
            filtered.add(attribute);
          }
        }
        return Scopes.scopeFor(filtered);
      }
      return Scopes.scopeFor(attrs_2);
    }
    if (((context instanceof SelectByPrimaryKeys) && 
      Objects.equal(reference, AceGenPackage.Literals.ATTRIBUTE_AND_VALUE__ATTRIBUTE))) {
      EObject _eContainer_5 = context.eContainer();
      final PersistenceVerification persistenceVerification_1 = ((PersistenceVerification) _eContainer_5);
      final Model model_1 = persistenceVerification_1.getModel();
      final ArrayList<Attribute> attrs_3 = new ArrayList<Attribute>();
      this._modelExtension.allAttributesRec(model_1, attrs_3);
      final ArrayList<Attribute> filtered_1 = new ArrayList<Attribute>();
      for (final Attribute attribute_1 : attrs_3) {
        boolean _isPrimaryKey = attribute_1.isPrimaryKey();
        if (_isPrimaryKey) {
          filtered_1.add(attribute_1);
        }
      }
      return Scopes.scopeFor(filtered_1);
    }
    if (((context instanceof SelectByUniqueAttribute) && 
      Objects.equal(reference, AceGenPackage.Literals.ATTRIBUTE_AND_VALUE__ATTRIBUTE))) {
      EObject _eContainer_6 = context.eContainer();
      final PersistenceVerification persistenceVerification_2 = ((PersistenceVerification) _eContainer_6);
      final Model model_2 = persistenceVerification_2.getModel();
      final ArrayList<Attribute> attrs_4 = new ArrayList<Attribute>();
      this._modelExtension.allAttributesRec(model_2, attrs_4);
      final ArrayList<Attribute> filtered_2 = new ArrayList<Attribute>();
      for (final Attribute attribute_2 : attrs_4) {
        boolean _isUnique = attribute_2.isUnique();
        if (_isUnique) {
          filtered_2.add(attribute_2);
        }
      }
      return Scopes.scopeFor(filtered_2);
    }
    if (((context instanceof Count) && Objects.equal(reference, AceGenPackage.Literals.ATTRIBUTE_AND_VALUE__ATTRIBUTE))) {
      EObject _eContainer_7 = context.eContainer();
      final PersistenceVerification persistenceVerification_3 = ((PersistenceVerification) _eContainer_7);
      final Model model_3 = persistenceVerification_3.getModel();
      final ArrayList<Attribute> attrs_5 = new ArrayList<Attribute>();
      this._modelExtension.allAttributesRec(model_3, attrs_5);
      return Scopes.scopeFor(attrs_5);
    }
    if (((context instanceof PersistenceVerification) && 
      Objects.equal(reference, AceGenPackage.Literals.PERSISTENCE_VERIFICATION__MODEL))) {
      final IScope scope_3 = super.getScope(context, reference);
      final ArrayList<Model> models = new ArrayList<Model>();
      Iterable<IEObjectDescription> _allElements = scope_3.getAllElements();
      for (final IEObjectDescription element : _allElements) {
        {
          EObject _resolve = EcoreUtil2.resolve(element.getEObjectOrProxy(), context);
          final Model model_4 = ((Model) _resolve);
          boolean _isPersistent = model_4.isPersistent();
          if (_isPersistent) {
            models.add(model_4);
          }
        }
      }
      return Scopes.scopeFor(models);
    }
    if ((((context instanceof JsonObject) || (context instanceof JsonArray)) || (context instanceof JsonMember))) {
      EObject parent_1 = context.eContainer();
      boolean isThen = false;
      boolean isWhen = false;
      boolean isVerification = false;
      PersistenceVerification persistenceVerification_4 = null;
      while (((parent_1 != null) && (!((parent_1 instanceof Scenario) || (parent_1 instanceof JsonMember))))) {
        {
          if ((parent_1 instanceof ThenBlock)) {
            isThen = true;
          }
          if ((parent_1 instanceof WhenBlock)) {
            isWhen = true;
          }
          if ((parent_1 instanceof PersistenceVerification)) {
            isVerification = true;
            persistenceVerification_4 = ((PersistenceVerification) parent_1);
          }
          parent_1 = parent_1.eContainer();
        }
      }
      if ((parent_1 instanceof Scenario)) {
        final Scenario scenario = ((Scenario) parent_1);
        if (isVerification) {
          final Model model_4 = persistenceVerification_4.getModel();
          final ArrayList<Attribute> attrs_6 = new ArrayList<Attribute>();
          this._modelExtension.allAttributesRec(model_4, attrs_6);
          return Scopes.scopeFor(attrs_6);
        } else {
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
            if ((isThen && (scenario.getWhenBlock().getAction() instanceof HttpServerAceRead))) {
              ArrayList<Attribute> attr_1 = new ArrayList<Attribute>();
              HttpServerAce _action = scenario.getWhenBlock().getAction();
              EList<Attribute> _response = ((HttpServerAceRead) _action).getResponse();
              for (final Attribute attribute_3 : _response) {
                attr_1.add(attribute_3);
              }
              return Scopes.scopeFor(attr_1);
            }
          }
        }
      }
      if ((parent_1 instanceof JsonMember)) {
        final JsonMember jsonMember = ((JsonMember) parent_1);
        Model _model = jsonMember.getAttribute().getModel();
        boolean _tripleNotEquals = (_model != null);
        if (_tripleNotEquals) {
          Model _model_1 = jsonMember.getAttribute().getModel();
          final Model model_5 = ((Model) _model_1);
          return this.getScopeFor(model_5);
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
