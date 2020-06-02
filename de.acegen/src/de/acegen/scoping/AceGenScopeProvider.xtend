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
import de.acegen.aceGen.HttpServerAce
import de.acegen.aceGen.HttpServerAceWrite
import de.acegen.aceGen.HttpServerOutcome
import de.acegen.aceGen.HttpServerViewFunction
import de.acegen.aceGen.JsonArray
import de.acegen.aceGen.JsonMember
import de.acegen.aceGen.JsonObject
import de.acegen.aceGen.Model
import de.acegen.aceGen.Scenario
import de.acegen.aceGen.ThenBlock
import de.acegen.aceGen.WhenBlock
import de.acegen.extensions.java.ModelExtension
import java.util.ArrayList
import javax.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.scoping.impl.FilteringScope
import de.acegen.aceGen.AttributeParamRef
import de.acegen.aceGen.PersistenceVerification

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
		if (context instanceof HttpServerAce && reference == AceGenPackage.Literals.HTTP_SERVER_ACE__RESPONSE) {
			val javaAce = context as HttpServerAce;
			val attrs = new ArrayList<Attribute>();
			javaAce.getModel.allAttributesRec(attrs);
			return Scopes.scopeFor(attrs)
		}
		if (context instanceof HttpServerAce && reference == AceGenPackage.Literals.ATTRIBUTE_PARAM_REF__ATTRIBUTE) {
			val javaAce = context as HttpServerAce;
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
		if (context instanceof PersistenceVerification &&
			reference == AceGenPackage.Literals.PERSISTENCE_VERIFICATION__ATTRIBUTE) {
			val persistenceVerification = context as PersistenceVerification
			val model = persistenceVerification.model
			val attrs = new ArrayList<Attribute>();
			model.allAttributesRec(attrs);
			return Scopes.scopeFor(attrs)
		}
		if (context instanceof JsonObject || context instanceof JsonArray || context instanceof JsonMember) {
			var parent = context.eContainer
			var isThen = false
			var isWhen = false
			var isVerification = false
			var PersistenceVerification persistenceVerification = null
			while (parent !== null && !((parent instanceof Scenario) || (parent instanceof JsonMember))) {
				if (parent instanceof ThenBlock) {
					isThen = true
				}
				if (parent instanceof WhenBlock) {
					isWhen = true
				}
				if (parent instanceof PersistenceVerification) {
					isVerification = true
					persistenceVerification = parent as PersistenceVerification
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
				} else if (isThen) {
					return Scopes.scopeFor(scenario.whenBlock.action.response);
				}
			}
			if (parent instanceof JsonMember) {
				val jsonMember = parent as JsonMember;
				if (jsonMember.attribute.model !== null) {
					val model = jsonMember.attribute.model as Model
					return getScopeFor(model);
				}
			}
		}
		return super.getScope(context, reference);
	}

	private def IScope getScopeFor(Model aceModel) {
		val attrs = new ArrayList<Attribute>();
		aceModel.allAttributesRec(attrs);
		return Scopes.scopeFor(attrs)
	}

}
/******* S.D.G. *******/
