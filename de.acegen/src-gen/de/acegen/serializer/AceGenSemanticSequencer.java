/*
 * generated by Xtext 2.21.0
 */
package de.acegen.serializer;

import com.google.inject.Inject;
import de.acegen.aceGen.AceGenPackage;
import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.AttributeParamRef;
import de.acegen.aceGen.AuthUser;
import de.acegen.aceGen.Authorization;
import de.acegen.aceGen.DataDefinition;
import de.acegen.aceGen.Expectation;
import de.acegen.aceGen.GivenRef;
import de.acegen.aceGen.HttpClient;
import de.acegen.aceGen.HttpClientAce;
import de.acegen.aceGen.HttpClientOutcome;
import de.acegen.aceGen.HttpClientStateElement;
import de.acegen.aceGen.HttpClientStateFunction;
import de.acegen.aceGen.HttpClientTypeDefinition;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAceRead;
import de.acegen.aceGen.HttpServerAceWrite;
import de.acegen.aceGen.HttpServerOutcome;
import de.acegen.aceGen.HttpServerView;
import de.acegen.aceGen.HttpServerViewFunction;
import de.acegen.aceGen.JsonArray;
import de.acegen.aceGen.JsonDateTime;
import de.acegen.aceGen.JsonMember;
import de.acegen.aceGen.JsonObject;
import de.acegen.aceGen.JsonValue;
import de.acegen.aceGen.Model;
import de.acegen.aceGen.PersistenceVerification;
import de.acegen.aceGen.PrimitiveValue;
import de.acegen.aceGen.Project;
import de.acegen.aceGen.Scenario;
import de.acegen.aceGen.ThenBlock;
import de.acegen.aceGen.Verification;
import de.acegen.aceGen.WhenBlock;
import de.acegen.services.AceGenGrammarAccess;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class AceGenSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private AceGenGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == AceGenPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case AceGenPackage.ATTRIBUTE:
				sequence_Attribute(context, (Attribute) semanticObject); 
				return; 
			case AceGenPackage.ATTRIBUTE_PARAM_REF:
				sequence_AttributeParamRef(context, (AttributeParamRef) semanticObject); 
				return; 
			case AceGenPackage.AUTH_USER:
				sequence_AuthUser(context, (AuthUser) semanticObject); 
				return; 
			case AceGenPackage.AUTHORIZATION:
				sequence_Authorization(context, (Authorization) semanticObject); 
				return; 
			case AceGenPackage.DATA_DEFINITION:
				sequence_DataDefinition(context, (DataDefinition) semanticObject); 
				return; 
			case AceGenPackage.EXPECTATION:
				sequence_Expectation(context, (Expectation) semanticObject); 
				return; 
			case AceGenPackage.GIVEN_REF:
				sequence_GivenRef(context, (GivenRef) semanticObject); 
				return; 
			case AceGenPackage.HTTP_CLIENT:
				sequence_HttpClient(context, (HttpClient) semanticObject); 
				return; 
			case AceGenPackage.HTTP_CLIENT_ACE:
				sequence_HttpClientAce(context, (HttpClientAce) semanticObject); 
				return; 
			case AceGenPackage.HTTP_CLIENT_OUTCOME:
				sequence_HttpClientOutcome(context, (HttpClientOutcome) semanticObject); 
				return; 
			case AceGenPackage.HTTP_CLIENT_STATE_ELEMENT:
				sequence_HttpClientStateElement(context, (HttpClientStateElement) semanticObject); 
				return; 
			case AceGenPackage.HTTP_CLIENT_STATE_FUNCTION:
				sequence_HttpClientStateFunction(context, (HttpClientStateFunction) semanticObject); 
				return; 
			case AceGenPackage.HTTP_CLIENT_TYPE_DEFINITION:
				sequence_HttpClientTypeDefinition(context, (HttpClientTypeDefinition) semanticObject); 
				return; 
			case AceGenPackage.HTTP_SERVER:
				sequence_HttpServer(context, (HttpServer) semanticObject); 
				return; 
			case AceGenPackage.HTTP_SERVER_ACE_READ:
				sequence_HttpServerAceRead(context, (HttpServerAceRead) semanticObject); 
				return; 
			case AceGenPackage.HTTP_SERVER_ACE_WRITE:
				sequence_HttpServerAceWrite(context, (HttpServerAceWrite) semanticObject); 
				return; 
			case AceGenPackage.HTTP_SERVER_OUTCOME:
				sequence_HttpServerOutcome(context, (HttpServerOutcome) semanticObject); 
				return; 
			case AceGenPackage.HTTP_SERVER_VIEW:
				sequence_HttpServerView(context, (HttpServerView) semanticObject); 
				return; 
			case AceGenPackage.HTTP_SERVER_VIEW_FUNCTION:
				sequence_HttpServerViewFunction(context, (HttpServerViewFunction) semanticObject); 
				return; 
			case AceGenPackage.JSON_ARRAY:
				sequence_JsonArray(context, (JsonArray) semanticObject); 
				return; 
			case AceGenPackage.JSON_DATE_TIME:
				sequence_JsonDateTime(context, (JsonDateTime) semanticObject); 
				return; 
			case AceGenPackage.JSON_MEMBER:
				sequence_JsonMember(context, (JsonMember) semanticObject); 
				return; 
			case AceGenPackage.JSON_OBJECT:
				sequence_JsonObject(context, (JsonObject) semanticObject); 
				return; 
			case AceGenPackage.JSON_VALUE:
				sequence_JsonValue(context, (JsonValue) semanticObject); 
				return; 
			case AceGenPackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case AceGenPackage.PERSISTENCE_VERIFICATION:
				sequence_PersistenceVerification(context, (PersistenceVerification) semanticObject); 
				return; 
			case AceGenPackage.PRIMITIVE_VALUE:
				sequence_PrimitiveValue(context, (PrimitiveValue) semanticObject); 
				return; 
			case AceGenPackage.PROJECT:
				sequence_Project(context, (Project) semanticObject); 
				return; 
			case AceGenPackage.SCENARIO:
				sequence_Scenario(context, (Scenario) semanticObject); 
				return; 
			case AceGenPackage.THEN_BLOCK:
				sequence_ThenBlock(context, (ThenBlock) semanticObject); 
				return; 
			case AceGenPackage.VERIFICATION:
				sequence_Verification(context, (Verification) semanticObject); 
				return; 
			case AceGenPackage.WHEN_BLOCK:
				sequence_WhenBlock(context, (WhenBlock) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     AttributeParamRef returns AttributeParamRef
	 *
	 * Constraint:
	 *     (attribute=[Attribute|QualifiedName] optional?='optional'?)
	 */
	protected void sequence_AttributeParamRef(ISerializationContext context, AttributeParamRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Attribute returns Attribute
	 *
	 * Constraint:
	 *     (
	 *         unique?='Unique'? 
	 *         primaryKey?='PrimaryKey'? 
	 *         notNull?='NotNull'? 
	 *         list?='List'? 
	 *         (type=Type | model=[Model|QualifiedName]) 
	 *         name=ID 
	 *         foreignKey=[Attribute|QualifiedName]? 
	 *         notReplayable?='notReplayable'?
	 *     )
	 */
	protected void sequence_Attribute(ISerializationContext context, Attribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     AuthUser returns AuthUser
	 *
	 * Constraint:
	 *     (name=ID attributes+=Attribute*)
	 */
	protected void sequence_AuthUser(ISerializationContext context, AuthUser semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Authorization returns Authorization
	 *
	 * Constraint:
	 *     (username=STRING password=STRING)
	 */
	protected void sequence_Authorization(ISerializationContext context, Authorization semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AceGenPackage.Literals.AUTHORIZATION__USERNAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AceGenPackage.Literals.AUTHORIZATION__USERNAME));
			if (transientValues.isValueTransient(semanticObject, AceGenPackage.Literals.AUTHORIZATION__PASSWORD) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AceGenPackage.Literals.AUTHORIZATION__PASSWORD));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAuthorizationAccess().getUsernameSTRINGTerminalRuleCall_1_0(), semanticObject.getUsername());
		feeder.accept(grammarAccess.getAuthorizationAccess().getPasswordSTRINGTerminalRuleCall_3_0(), semanticObject.getPassword());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     DataDefinition returns DataDefinition
	 *
	 * Constraint:
	 *     (uuid=STRING? (systemtime=STRING pattern=STRING)? data=JsonObject?)
	 */
	protected void sequence_DataDefinition(ISerializationContext context, DataDefinition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expectation returns Expectation
	 *
	 * Constraint:
	 *     (object=JsonObject | isNull?='null' | isNotNull?='notNull')
	 */
	protected void sequence_Expectation(ISerializationContext context, Expectation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     GivenRef returns GivenRef
	 *
	 * Constraint:
	 *     (scenario=[Scenario|QualifiedName] times=INT? excludeGiven?='excludeGIVEN'?)
	 */
	protected void sequence_GivenRef(ISerializationContext context, GivenRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     HttpClientAce returns HttpClientAce
	 *
	 * Constraint:
	 *     (
	 *         async?='async'? 
	 *         name=ID 
	 *         (input+=ID input+=ID*)? 
	 *         serverCall=[HttpServerAce|QualifiedName]? 
	 *         loadingFlag=[HttpClientStateElement|QualifiedName]? 
	 *         outcomes+=HttpClientOutcome*
	 *     )
	 */
	protected void sequence_HttpClientAce(ISerializationContext context, HttpClientAce semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     HttpClientOutcome returns HttpClientOutcome
	 *
	 * Constraint:
	 *     (name=ID listeners+=HttpClientStateFunction* aceOperations+=[HttpClientAce|QualifiedName]*)
	 */
	protected void sequence_HttpClientOutcome(ISerializationContext context, HttpClientOutcome semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     HttpClientStateElement returns HttpClientStateElement
	 *
	 * Constraint:
	 *     (name=ID list?='list'? hash?='location.hash'? storage?='storage'? (types+=HttpClientTypeDefinition types+=HttpClientTypeDefinition*)?)
	 */
	protected void sequence_HttpClientStateElement(ISerializationContext context, HttpClientStateElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     HttpClientStateFunction returns HttpClientStateFunction
	 *
	 * Constraint:
	 *     (stateFunctionType=HttpClientStateFunctionType attribute=[HttpClientStateElement|QualifiedName])
	 */
	protected void sequence_HttpClientStateFunction(ISerializationContext context, HttpClientStateFunction semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AceGenPackage.Literals.HTTP_CLIENT_STATE_FUNCTION__STATE_FUNCTION_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AceGenPackage.Literals.HTTP_CLIENT_STATE_FUNCTION__STATE_FUNCTION_TYPE));
			if (transientValues.isValueTransient(semanticObject, AceGenPackage.Literals.HTTP_CLIENT_STATE_FUNCTION__ATTRIBUTE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AceGenPackage.Literals.HTTP_CLIENT_STATE_FUNCTION__ATTRIBUTE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getHttpClientStateFunctionAccess().getStateFunctionTypeHttpClientStateFunctionTypeParserRuleCall_0_0(), semanticObject.getStateFunctionType());
		feeder.accept(grammarAccess.getHttpClientStateFunctionAccess().getAttributeHttpClientStateElementQualifiedNameParserRuleCall_1_0_1(), semanticObject.eGet(AceGenPackage.Literals.HTTP_CLIENT_STATE_FUNCTION__ATTRIBUTE, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     HttpClientTypeDefinition returns HttpClientTypeDefinition
	 *
	 * Constraint:
	 *     (name=ID elements+=HttpClientStateElement*)
	 */
	protected void sequence_HttpClientTypeDefinition(ISerializationContext context, HttpClientTypeDefinition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     HttpClient returns HttpClient
	 *
	 * Constraint:
	 *     (name=QualifiedName aceOperations+=HttpClientAce* appState=HttpClientStateElement?)
	 */
	protected void sequence_HttpClient(ISerializationContext context, HttpClient semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     HttpServerAce returns HttpServerAceRead
	 *     HttpServerAceRead returns HttpServerAceRead
	 *
	 * Constraint:
	 *     (
	 *         proxy?='proxy'? 
	 *         name=ID 
	 *         model=[Model|QualifiedName] 
	 *         type=ReadFunctionType 
	 *         url=STRING 
	 *         authorize?='authorize'? 
	 *         pathParams+=AttributeParamRef* 
	 *         queryParams+=AttributeParamRef* 
	 *         payload+=AttributeParamRef* 
	 *         response+=[Attribute|QualifiedName]*
	 *     )
	 */
	protected void sequence_HttpServerAceRead(ISerializationContext context, HttpServerAceRead semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     HttpServerAce returns HttpServerAceWrite
	 *     HttpServerAceWrite returns HttpServerAceWrite
	 *
	 * Constraint:
	 *     (
	 *         proxy?='proxy'? 
	 *         name=ID 
	 *         model=[Model|QualifiedName] 
	 *         type=WriteFunctionType 
	 *         url=STRING 
	 *         authorize?='authorize'? 
	 *         pathParams+=AttributeParamRef* 
	 *         queryParams+=AttributeParamRef* 
	 *         payload+=AttributeParamRef* 
	 *         response+=[Attribute|QualifiedName]* 
	 *         outcomes+=HttpServerOutcome*
	 *     )
	 */
	protected void sequence_HttpServerAceWrite(ISerializationContext context, HttpServerAceWrite semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     HttpServerOutcome returns HttpServerOutcome
	 *
	 * Constraint:
	 *     (name=ID listeners+=[HttpServerViewFunction|QualifiedName]*)
	 */
	protected void sequence_HttpServerOutcome(ISerializationContext context, HttpServerOutcome semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     HttpServerViewFunction returns HttpServerViewFunction
	 *
	 * Constraint:
	 *     (name=ID model=[Model|QualifiedName])
	 */
	protected void sequence_HttpServerViewFunction(ISerializationContext context, HttpServerViewFunction semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AceGenPackage.Literals.HTTP_SERVER_VIEW_FUNCTION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AceGenPackage.Literals.HTTP_SERVER_VIEW_FUNCTION__NAME));
			if (transientValues.isValueTransient(semanticObject, AceGenPackage.Literals.HTTP_SERVER_VIEW_FUNCTION__MODEL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AceGenPackage.Literals.HTTP_SERVER_VIEW_FUNCTION__MODEL));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getHttpServerViewFunctionAccess().getNameIDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getHttpServerViewFunctionAccess().getModelModelQualifiedNameParserRuleCall_2_0_1(), semanticObject.eGet(AceGenPackage.Literals.HTTP_SERVER_VIEW_FUNCTION__MODEL, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     HttpServerView returns HttpServerView
	 *
	 * Constraint:
	 *     (name=ID renderFunctions+=HttpServerViewFunction*)
	 */
	protected void sequence_HttpServerView(ISerializationContext context, HttpServerView semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     HttpServer returns HttpServer
	 *
	 * Constraint:
	 *     (
	 *         type='Dropwizard'? 
	 *         name=QualifiedName 
	 *         authUser=AuthUser? 
	 *         authUserRef=[AuthUser|QualifiedName]? 
	 *         aceOperations+=HttpServerAce* 
	 *         views+=HttpServerView* 
	 *         models+=Model* 
	 *         scenarios+=Scenario*
	 *     )
	 */
	protected void sequence_HttpServer(ISerializationContext context, HttpServer semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     JsonValue returns JsonArray
	 *     JsonArray returns JsonArray
	 *
	 * Constraint:
	 *     (values+=JsonValue? values+=JsonValue*)
	 */
	protected void sequence_JsonArray(ISerializationContext context, JsonArray semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     JsonDateTime returns JsonDateTime
	 *     JsonValue returns JsonDateTime
	 *
	 * Constraint:
	 *     (dateTime=STRING pattern=STRING)
	 */
	protected void sequence_JsonDateTime(ISerializationContext context, JsonDateTime semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AceGenPackage.Literals.JSON_DATE_TIME__DATE_TIME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AceGenPackage.Literals.JSON_DATE_TIME__DATE_TIME));
			if (transientValues.isValueTransient(semanticObject, AceGenPackage.Literals.JSON_DATE_TIME__PATTERN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AceGenPackage.Literals.JSON_DATE_TIME__PATTERN));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getJsonDateTimeAccess().getDateTimeSTRINGTerminalRuleCall_0_0(), semanticObject.getDateTime());
		feeder.accept(grammarAccess.getJsonDateTimeAccess().getPatternSTRINGTerminalRuleCall_1_0(), semanticObject.getPattern());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     JsonMember returns JsonMember
	 *
	 * Constraint:
	 *     (attribute=[Attribute|QualifiedName] value=JsonValue)
	 */
	protected void sequence_JsonMember(ISerializationContext context, JsonMember semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AceGenPackage.Literals.JSON_MEMBER__ATTRIBUTE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AceGenPackage.Literals.JSON_MEMBER__ATTRIBUTE));
			if (transientValues.isValueTransient(semanticObject, AceGenPackage.Literals.JSON_MEMBER__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AceGenPackage.Literals.JSON_MEMBER__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getJsonMemberAccess().getAttributeAttributeQualifiedNameParserRuleCall_0_0_1(), semanticObject.eGet(AceGenPackage.Literals.JSON_MEMBER__ATTRIBUTE, false));
		feeder.accept(grammarAccess.getJsonMemberAccess().getValueJsonValueParserRuleCall_2_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     JsonObject returns JsonObject
	 *     JsonValue returns JsonObject
	 *
	 * Constraint:
	 *     (members+=JsonMember? members+=JsonMember*)
	 */
	protected void sequence_JsonObject(ISerializationContext context, JsonObject semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     JsonValue returns JsonValue
	 *
	 * Constraint:
	 *     (string=STRING | boolean=JsonBoolean | null=JsonNull | long=INT)
	 */
	protected void sequence_JsonValue(ISerializationContext context, JsonValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Model returns Model
	 *
	 * Constraint:
	 *     (persistent?='persistent'? name=ID (superModels+=[Model|QualifiedName] superModels+=[Model|QualifiedName]*)? attributes+=Attribute*)
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PersistenceVerification returns PersistenceVerification
	 *
	 * Constraint:
	 *     (name=ID model=[Model|QualifiedName] attribute=[Attribute|QualifiedName] value=PrimitiveValue expected=Expectation)
	 */
	protected void sequence_PersistenceVerification(ISerializationContext context, PersistenceVerification semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AceGenPackage.Literals.PERSISTENCE_VERIFICATION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AceGenPackage.Literals.PERSISTENCE_VERIFICATION__NAME));
			if (transientValues.isValueTransient(semanticObject, AceGenPackage.Literals.PERSISTENCE_VERIFICATION__MODEL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AceGenPackage.Literals.PERSISTENCE_VERIFICATION__MODEL));
			if (transientValues.isValueTransient(semanticObject, AceGenPackage.Literals.PERSISTENCE_VERIFICATION__ATTRIBUTE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AceGenPackage.Literals.PERSISTENCE_VERIFICATION__ATTRIBUTE));
			if (transientValues.isValueTransient(semanticObject, AceGenPackage.Literals.PERSISTENCE_VERIFICATION__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AceGenPackage.Literals.PERSISTENCE_VERIFICATION__VALUE));
			if (transientValues.isValueTransient(semanticObject, AceGenPackage.Literals.PERSISTENCE_VERIFICATION__EXPECTED) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AceGenPackage.Literals.PERSISTENCE_VERIFICATION__EXPECTED));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPersistenceVerificationAccess().getNameIDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getPersistenceVerificationAccess().getModelModelQualifiedNameParserRuleCall_1_0_1(), semanticObject.eGet(AceGenPackage.Literals.PERSISTENCE_VERIFICATION__MODEL, false));
		feeder.accept(grammarAccess.getPersistenceVerificationAccess().getAttributeAttributeQualifiedNameParserRuleCall_4_0_1(), semanticObject.eGet(AceGenPackage.Literals.PERSISTENCE_VERIFICATION__ATTRIBUTE, false));
		feeder.accept(grammarAccess.getPersistenceVerificationAccess().getValuePrimitiveValueParserRuleCall_6_0(), semanticObject.getValue());
		feeder.accept(grammarAccess.getPersistenceVerificationAccess().getExpectedExpectationParserRuleCall_9_0(), semanticObject.getExpected());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     PrimitiveValue returns PrimitiveValue
	 *
	 * Constraint:
	 *     (string=STRING | long=INT)
	 */
	protected void sequence_PrimitiveValue(ISerializationContext context, PrimitiveValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Project returns Project
	 *
	 * Constraint:
	 *     (httpClient=HttpClient | httpServer=HttpServer)?
	 */
	protected void sequence_Project(ISerializationContext context, Project semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Scenario returns Scenario
	 *
	 * Constraint:
	 *     (name=ID givenRefs+=GivenRef* whenBlock=WhenBlock thenBlock=ThenBlock)
	 */
	protected void sequence_Scenario(ISerializationContext context, Scenario semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ThenBlock returns ThenBlock
	 *
	 * Constraint:
	 *     (statusCode=INT response=DataDefinition? persistenceVerifications+=PersistenceVerification* verifications+=Verification*)
	 */
	protected void sequence_ThenBlock(ISerializationContext context, ThenBlock semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Verification returns Verification
	 *
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_Verification(ISerializationContext context, Verification semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AceGenPackage.Literals.VERIFICATION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AceGenPackage.Literals.VERIFICATION__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getVerificationAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     WhenBlock returns WhenBlock
	 *
	 * Constraint:
	 *     (action=[HttpServerAce|QualifiedName] dataDefinition=DataDefinition authorization=Authorization?)
	 */
	protected void sequence_WhenBlock(ISerializationContext context, WhenBlock semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
