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
package de.acegen.scoping;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import de.acegen.aceGen.AceGenPackage;
import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.AttributeAndValue;
import de.acegen.aceGen.AttributeParamRef;
import de.acegen.aceGen.ClientScenario;
import de.acegen.aceGen.ClientThenBlock;
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
import de.acegen.aceGen.JsonArrayClient;
import de.acegen.aceGen.JsonMember;
import de.acegen.aceGen.JsonMemberClient;
import de.acegen.aceGen.JsonObject;
import de.acegen.aceGen.JsonObjectClient;
import de.acegen.aceGen.Model;
import de.acegen.aceGen.PersistenceVerification;
import de.acegen.aceGen.Scenario;
import de.acegen.aceGen.SelectByPrimaryKeys;
import de.acegen.aceGen.SelectByUniqueAttribute;
import de.acegen.aceGen.StateVerification;
import de.acegen.aceGen.ThenBlock;
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
    if (((context instanceof InputValue) && Objects.equal(reference, AceGenPackage.Literals.INPUT_VALUE__INPUT))) {
      final EObject parent = context.eContainer();
      if ((parent instanceof ClientWhenBlock)) {
        final EList<Input> input = ((ClientWhenBlock) parent).getAction().getInput();
        return Scopes.scopeFor(input);
      }
    }
    if ((((context instanceof HttpServerAceRead) || (context instanceof HttpServerAceWrite)) && 
      Objects.equal(reference, AceGenPackage.Literals.HTTP_SERVER_ACE__RESPONSE))) {
      final HttpServerAce javaAce = ((HttpServerAce) context);
      final ArrayList<Attribute> attrs = new ArrayList<Attribute>();
      this._modelExtension.allAttributesRec(javaAce.getModel(), attrs);
      return Scopes.scopeFor(attrs);
    }
    if ((((context instanceof HttpServerAceRead) || (context instanceof HttpServerAceWrite)) && 
      Objects.equal(reference, AceGenPackage.Literals.ATTRIBUTE_PARAM_REF__ATTRIBUTE))) {
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
    if (((context instanceof AttributeAndValue) && 
      Objects.equal(reference, AceGenPackage.Literals.ATTRIBUTE_AND_VALUE__ATTRIBUTE))) {
      EObject _eContainer_2 = context.eContainer().eContainer();
      final PersistenceVerification persistenceVerification = ((PersistenceVerification) _eContainer_2);
      final Model model = persistenceVerification.getModel();
      final ArrayList<Attribute> attrs_3 = new ArrayList<Attribute>();
      this._modelExtension.allAttributesRec(model, attrs_3);
      EObject _eContainer_3 = context.eContainer();
      final boolean selectByUnique = (_eContainer_3 instanceof SelectByUniqueAttribute);
      EObject _eContainer_4 = context.eContainer();
      final boolean selectByPrimary = (_eContainer_4 instanceof SelectByPrimaryKeys);
      if ((selectByUnique || selectByPrimary)) {
        final ArrayList<Attribute> filtered = new ArrayList<Attribute>();
        for (final Attribute attribute : attrs_3) {
          if (((attribute.isUnique() && selectByUnique) || (attribute.isPrimaryKey() && selectByPrimary))) {
            filtered.add(attribute);
          }
        }
        return Scopes.scopeFor(filtered);
      }
      return Scopes.scopeFor(attrs_3);
    }
    if (((context instanceof SelectByPrimaryKeys) && 
      Objects.equal(reference, AceGenPackage.Literals.ATTRIBUTE_AND_VALUE__ATTRIBUTE))) {
      EObject _eContainer_5 = context.eContainer();
      final PersistenceVerification persistenceVerification_1 = ((PersistenceVerification) _eContainer_5);
      final Model model_1 = persistenceVerification_1.getModel();
      final ArrayList<Attribute> attrs_4 = new ArrayList<Attribute>();
      this._modelExtension.allAttributesRec(model_1, attrs_4);
      final ArrayList<Attribute> filtered_1 = new ArrayList<Attribute>();
      for (final Attribute attribute_1 : attrs_4) {
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
      final ArrayList<Attribute> attrs_5 = new ArrayList<Attribute>();
      this._modelExtension.allAttributesRec(model_2, attrs_5);
      final ArrayList<Attribute> filtered_2 = new ArrayList<Attribute>();
      for (final Attribute attribute_2 : attrs_5) {
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
      final ArrayList<Attribute> attrs_6 = new ArrayList<Attribute>();
      this._modelExtension.allAttributesRec(model_3, attrs_6);
      return Scopes.scopeFor(attrs_6);
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
      while (((parent_1 != null) && (!(((parent_1 instanceof Scenario) || (parent_1 instanceof JsonMember)) || (parent_1 instanceof ClientScenario))))) {
        {
          if (((parent_1 instanceof ThenBlock) || (parent_1 instanceof ClientThenBlock))) {
            isThen = true;
          }
          if (((parent_1 instanceof WhenBlock) || (parent_1 instanceof ClientWhenBlock))) {
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
          final ArrayList<Attribute> attrs_7 = new ArrayList<Attribute>();
          this._modelExtension.allAttributesRec(model_4, attrs_7);
          return Scopes.scopeFor(attrs_7);
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
            attr.addAll(this._modelExtension.allNonDeterministicAttributes(scenario.getWhenBlock().getAction().getModel()));
            return Scopes.scopeFor(attr);
          } else {
            if (isThen) {
              ArrayList<Attribute> attr_1 = new ArrayList<Attribute>();
              EList<Attribute> _response = scenario.getWhenBlock().getAction().getResponse();
              for (final Attribute attribute_3 : _response) {
                attr_1.add(attribute_3);
              }
              return Scopes.scopeFor(attr_1);
            }
          }
        }
      }
      if ((parent_1 instanceof ClientScenario)) {
        final ClientScenario scenario_1 = ((ClientScenario) parent_1);
        if (isWhen) {
          return Scopes.scopeFor(scenario_1.getWhenBlock().getAction().getServerCall().getResponse());
        }
        if (isThen) {
          ArrayList<Attribute> attr_2 = new ArrayList<Attribute>();
          HttpServerAce _serverCall = scenario_1.getWhenBlock().getAction().getServerCall();
          boolean _tripleNotEquals = (_serverCall != null);
          if (_tripleNotEquals) {
            final HttpServerAce serverCall = scenario_1.getWhenBlock().getAction().getServerCall();
            EList<AttributeParamRef> _payload_1 = serverCall.getPayload();
            for (final AttributeParamRef attributeRef_3 : _payload_1) {
              attr_2.add(attributeRef_3.getAttribute());
            }
            EList<AttributeParamRef> _queryParams_1 = serverCall.getQueryParams();
            for (final AttributeParamRef attributeRef_4 : _queryParams_1) {
              attr_2.add(attributeRef_4.getAttribute());
            }
            EList<AttributeParamRef> _pathParams_1 = serverCall.getPathParams();
            for (final AttributeParamRef attributeRef_5 : _pathParams_1) {
              attr_2.add(attributeRef_5.getAttribute());
            }
          }
          return Scopes.scopeFor(attr_2);
        }
      }
      if ((parent_1 instanceof JsonMember)) {
        ArrayList<Attribute> attr_3 = new ArrayList<Attribute>();
        final JsonMember jsonMember = ((JsonMember) parent_1);
        if (((jsonMember.getAttribute() != null) && (jsonMember.getAttribute().getModel() != null))) {
          Model _model = jsonMember.getAttribute().getModel();
          final Model model_5 = ((Model) _model);
          this._modelExtension.allAttributesRec(model_5, attr_3);
        }
        return Scopes.scopeFor(attr_3);
      }
    }
    if ((((context instanceof JsonObjectClient) || (context instanceof JsonArrayClient)) || 
      (context instanceof JsonMemberClient))) {
      EObject parent_2 = context.eContainer();
      while (((parent_2 != null) && (!((parent_2 instanceof StateVerification) || (parent_2 instanceof JsonMemberClient))))) {
        parent_2 = parent_2.eContainer();
      }
      if ((parent_2 != null)) {
        if ((parent_2 instanceof StateVerification)) {
          final StateVerification stateVerification = ((StateVerification) parent_2);
          return Scopes.scopeFor(stateVerification.getStateRef().getAttributes());
        }
        if ((parent_2 instanceof JsonMemberClient)) {
          final JsonMemberClient jsonMemberClient = ((JsonMemberClient) parent_2);
          return Scopes.scopeFor(jsonMemberClient.getAttribute().getAttributes());
        }
      }
    }
    return super.getScope(context, reference);
  }
}
