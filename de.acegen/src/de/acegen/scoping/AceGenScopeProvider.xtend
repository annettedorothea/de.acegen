/* 
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 * 
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */


package de.acegen.scoping

import de.acegen.aceGen.AceGenPackage
import de.acegen.aceGen.Attribute
import de.acegen.aceGen.AttributeAndValue
import de.acegen.aceGen.AttributeParamRef
import de.acegen.aceGen.ClientScenario
import de.acegen.aceGen.ClientThenBlock
import de.acegen.aceGen.ClientWhenBlock
import de.acegen.aceGen.Count
import de.acegen.aceGen.HttpServerAce
import de.acegen.aceGen.HttpServerAceRead
import de.acegen.aceGen.HttpServerAceWrite
import de.acegen.aceGen.HttpServerOutcome
import de.acegen.aceGen.HttpServerViewFunction
import de.acegen.aceGen.InputValue
import de.acegen.aceGen.JsonArray
import de.acegen.aceGen.JsonArrayClient
import de.acegen.aceGen.JsonMember
import de.acegen.aceGen.JsonMemberClient
import de.acegen.aceGen.JsonObject
import de.acegen.aceGen.JsonObjectClient
import de.acegen.aceGen.Model
import de.acegen.aceGen.PersistenceVerification
import de.acegen.aceGen.Scenario
import de.acegen.aceGen.SelectByPrimaryKeys
import de.acegen.aceGen.SelectByUniqueAttribute
import de.acegen.aceGen.ServerCall
import de.acegen.aceGen.StateVerification
import de.acegen.aceGen.ThenBlock
import de.acegen.aceGen.TriggeredAction
import de.acegen.aceGen.WhenBlock
import de.acegen.extensions.java.ModelExtension
import java.util.ArrayList
import javax.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.scoping.impl.FilteringScope

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
class AceGenScopeProvider extends AbstractAceGenScopeProvider {

	@Inject
	extension ModelExtension

	override getScope(EObject context, EReference reference) {
		if (context instanceof ClientWhenBlock && reference == AceGenPackage.Literals.INPUT_VALUE__INPUT) {
			val clientWhenBlock = context as ClientWhenBlock;
			return Scopes.scopeFor(clientWhenBlock.action.input)
		}
		if (context instanceof TriggeredAction && reference == AceGenPackage.Literals.INPUT_VALUE__INPUT) {
			val triggeredAction = context as TriggeredAction;
			return Scopes.scopeFor(triggeredAction.httpClientAce.input)
		}
		if (context instanceof InputValue && reference == AceGenPackage.Literals.INPUT_VALUE__INPUT) {
			val parent = context.eContainer
			if (parent instanceof TriggeredAction) {
				val triggeredAction = parent as TriggeredAction;
				return Scopes.scopeFor(triggeredAction.httpClientAce.input)
			} else if (parent instanceof ClientWhenBlock) {
				val input = (parent as ClientWhenBlock).action.input
				return Scopes.scopeFor(input)
			}
		}
		if (context instanceof HttpServerAceRead &&
			reference == AceGenPackage.Literals.HTTP_SERVER_ACE_READ__RESPONSE) {
			val javaAce = context as HttpServerAceRead;
			val attrs = new ArrayList<Attribute>();
			javaAce.getModel.allAttributesRec(attrs);
			return Scopes.scopeFor(attrs)
		}
		if (context instanceof AttributeParamRef &&
			reference == AceGenPackage.Literals.ATTRIBUTE_PARAM_REF__ATTRIBUTE) {
			val attributeParamRef = context as AttributeParamRef;
			val javaAce = attributeParamRef.eContainer as HttpServerAce;
			val attrs = new ArrayList<Attribute>();
			javaAce.getModel.allAttributesRec(attrs);
			return Scopes.scopeFor(attrs)
		}
		if (context instanceof HttpServerOutcome) {
			val aceModel = (context.eContainer as HttpServerAceWrite).getModel
			if (reference.name.equals("listeners")) {
				val scope = super.getScope(context, reference)
				return new FilteringScope(scope, [
					(getEObjectOrProxy as HttpServerViewFunction).getModel.equals(aceModel)
				])
			} else if (reference.name.equals("aceOperations")) {
				val scope = super.getScope(context, reference)
				return new FilteringScope(scope, [(getEObjectOrProxy as HttpServerAceWrite).getModel.equals(aceModel)])
			}
		}
		if (context instanceof Model) {
			val aceModel = context as Model
			val scope = super.getScope(context, reference)
			return new FilteringScope(scope, [!(getEObjectOrProxy as Model).equals(aceModel)])
		}
		if (context instanceof AttributeAndValue &&
			reference == AceGenPackage.Literals.ATTRIBUTE_AND_VALUE__ATTRIBUTE) {
			val persistenceVerification = context.eContainer.eContainer as PersistenceVerification
			val model = persistenceVerification.model
			val attrs = new ArrayList<Attribute>();
			model.allAttributesRec(attrs);
			val selectByUnique = context.eContainer instanceof SelectByUniqueAttribute
			val selectByPrimary = context.eContainer instanceof SelectByPrimaryKeys
			if (selectByUnique || selectByPrimary) {
				val filtered = new ArrayList<Attribute>();
				for (attribute : attrs) {
					if (attribute.unique && selectByUnique || attribute.primaryKey && selectByPrimary) {
						filtered.add(attribute)
					}
				}
				return Scopes.scopeFor(filtered)
			}
			return Scopes.scopeFor(attrs)
		}
		if (context instanceof SelectByPrimaryKeys &&
			reference == AceGenPackage.Literals.ATTRIBUTE_AND_VALUE__ATTRIBUTE) {
			val persistenceVerification = context.eContainer as PersistenceVerification
			val model = persistenceVerification.model
			val attrs = new ArrayList<Attribute>();
			model.allAttributesRec(attrs);
			val filtered = new ArrayList<Attribute>();
			for (attribute : attrs) {
				if (attribute.primaryKey) {
					filtered.add(attribute)
				}
			}
			return Scopes.scopeFor(filtered)
		}
		if (context instanceof SelectByUniqueAttribute &&
			reference == AceGenPackage.Literals.ATTRIBUTE_AND_VALUE__ATTRIBUTE) {
			val persistenceVerification = context.eContainer as PersistenceVerification
			val model = persistenceVerification.model
			val attrs = new ArrayList<Attribute>();
			model.allAttributesRec(attrs);
			val filtered = new ArrayList<Attribute>();
			for (attribute : attrs) {
				if (attribute.unique) {
					filtered.add(attribute)
				}
			}
			return Scopes.scopeFor(filtered)
		}
		if (context instanceof Count && reference == AceGenPackage.Literals.ATTRIBUTE_AND_VALUE__ATTRIBUTE) {
			val persistenceVerification = context.eContainer as PersistenceVerification
			val model = persistenceVerification.model
			val attrs = new ArrayList<Attribute>();
			model.allAttributesRec(attrs);
			return Scopes.scopeFor(attrs)
		}
		if (context instanceof PersistenceVerification &&
			reference == AceGenPackage.Literals.PERSISTENCE_VERIFICATION__MODEL) {
			val scope = super.getScope(context, reference);
			val models = new ArrayList<Model>();
			for (element : scope.allElements) {
				val model = EcoreUtil2.resolve(element.EObjectOrProxy, context) as Model
				if (model.persistent) {
					models.add(model)
				}
			}
			return Scopes.scopeFor(models)
		}
		if (context instanceof JsonObject || context instanceof JsonArray || context instanceof JsonMember) {
			var parent = context.eContainer
			var isThen = false
			var isWhen = false
			var isVerification = false
			var isServerCall = false
			var PersistenceVerification persistenceVerification = null
			while (parent !== null && !(
				parent instanceof Scenario || parent instanceof JsonMember || parent instanceof ClientScenario
			)) {
				if (parent instanceof ThenBlock || parent instanceof ClientThenBlock) {
					isThen = true
				}
				if (parent instanceof WhenBlock || parent instanceof ClientWhenBlock) {
					isWhen = true
				}
				if (parent instanceof PersistenceVerification) {
					isVerification = true
					persistenceVerification = parent as PersistenceVerification
				}
				if (parent instanceof ServerCall) {
					isServerCall = true
				}
				parent = parent.eContainer
			}
			if (parent instanceof Scenario) {
				val scenario = parent as Scenario;
				if (isVerification) {
					val model = persistenceVerification.model
					val attrs = new ArrayList<Attribute>();
					model.allAttributesRec(attrs);
					return Scopes.scopeFor(attrs)
				} else if (isWhen) {
					var attr = new ArrayList<Attribute>();
					for (attributeRef : scenario.whenBlock.action.payload) {
						attr.add(attributeRef.attribute)
					}
					for (attributeRef : scenario.whenBlock.action.queryParams) {
						attr.add(attributeRef.attribute)
					}
					for (attributeRef : scenario.whenBlock.action.pathParams) {
						attr.add(attributeRef.attribute)
					}
					attr.addAll(scenario.whenBlock.action.model.allNotReplayableAttributes)
					return Scopes.scopeFor(attr);
				} else if (isThen && scenario.whenBlock.action instanceof HttpServerAceRead) {
					var attr = new ArrayList<Attribute>();
					for (attribute : (scenario.whenBlock.action as HttpServerAceRead).response) {
						attr.add(attribute)
					}
					return Scopes.scopeFor(attr);
				}
			}
			if (parent instanceof ClientScenario) {
				val scenario = parent as ClientScenario;
				if (isWhen) {
					if (scenario.whenBlock.action.serverCall instanceof HttpServerAceRead) {
						val ace = scenario.whenBlock.action.serverCall as HttpServerAceRead
						return Scopes.scopeFor(ace.response);
					}
				}
				if (isThen && isServerCall) {
					var attr = new ArrayList<Attribute>();
					if (scenario.whenBlock.action.serverCall !== null) {
						val serverCall = scenario.whenBlock.action.serverCall
						for (attributeRef : serverCall.payload) {
							attr.add(attributeRef.attribute)
						}
						for (attributeRef : serverCall.queryParams) {
							attr.add(attributeRef.attribute)
						}
						for (attributeRef : serverCall.pathParams) {
							attr.add(attributeRef.attribute)
						}
					}
					return Scopes.scopeFor(attr);
				}
			}
			if (parent instanceof JsonMember) {
				var attr = new ArrayList<Attribute>();
				val jsonMember = parent as JsonMember;
				if (jsonMember.attribute.getModel !== null) {
					val model = jsonMember.attribute.model as Model
					model.allAttributesRec(attr)
				}
				return Scopes.scopeFor(attr);
			}
		}
		if (context instanceof JsonObjectClient || context instanceof JsonArrayClient ||
			context instanceof JsonMemberClient) {
			var parent = context.eContainer
			while (parent !== null && !(parent instanceof StateVerification || parent instanceof JsonMemberClient)) {
				parent = parent.eContainer
			}
			if (parent !== null) {
				if (parent instanceof StateVerification) {
					val stateVerification = parent as StateVerification
					return Scopes.scopeFor(stateVerification.stateRef.attributes)
				}
				if (parent instanceof JsonMemberClient) {
					val jsonMemberClient = parent as JsonMemberClient
					return Scopes.scopeFor(jsonMemberClient.attribute.attributes)
				}
			}
		}
		return super.getScope(context, reference);
	}

}
/******* S.D.G. *******/
