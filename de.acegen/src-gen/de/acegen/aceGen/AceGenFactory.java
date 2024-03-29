/**
 * generated by Xtext 2.29.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.acegen.aceGen.AceGenPackage
 * @generated
 */
public interface AceGenFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  AceGenFactory eINSTANCE = de.acegen.aceGen.impl.AceGenFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Project</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Project</em>'.
   * @generated
   */
  Project createProject();

  /**
   * Returns a new object of class '<em>Http Client</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Http Client</em>'.
   * @generated
   */
  HttpClient createHttpClient();

  /**
   * Returns a new object of class '<em>Http Client Ace</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Http Client Ace</em>'.
   * @generated
   */
  HttpClientAce createHttpClientAce();

  /**
   * Returns a new object of class '<em>From App State Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>From App State Ref</em>'.
   * @generated
   */
  FromAppStateRef createFromAppStateRef();

  /**
   * Returns a new object of class '<em>Input</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Input</em>'.
   * @generated
   */
  Input createInput();

  /**
   * Returns a new object of class '<em>Http Client Outcome</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Http Client Outcome</em>'.
   * @generated
   */
  HttpClientOutcome createHttpClientOutcome();

  /**
   * Returns a new object of class '<em>Triggerd Ace Operation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Triggerd Ace Operation</em>'.
   * @generated
   */
  TriggerdAceOperation createTriggerdAceOperation();

  /**
   * Returns a new object of class '<em>Http Client State Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Http Client State Function</em>'.
   * @generated
   */
  HttpClientStateFunction createHttpClientStateFunction();

  /**
   * Returns a new object of class '<em>Client Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Client Attribute</em>'.
   * @generated
   */
  ClientAttribute createClientAttribute();

  /**
   * Returns a new object of class '<em>Ui Action</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ui Action</em>'.
   * @generated
   */
  UiAction createUiAction();

  /**
   * Returns a new object of class '<em>Client Scenario</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Client Scenario</em>'.
   * @generated
   */
  ClientScenario createClientScenario();

  /**
   * Returns a new object of class '<em>Client When Then</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Client When Then</em>'.
   * @generated
   */
  ClientWhenThen createClientWhenThen();

  /**
   * Returns a new object of class '<em>Client Given Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Client Given Ref</em>'.
   * @generated
   */
  ClientGivenRef createClientGivenRef();

  /**
   * Returns a new object of class '<em>Client When Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Client When Block</em>'.
   * @generated
   */
  ClientWhenBlock createClientWhenBlock();

  /**
   * Returns a new object of class '<em>Squishy Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Squishy Value</em>'.
   * @generated
   */
  SquishyValue createSquishyValue();

  /**
   * Returns a new object of class '<em>Input Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Input Value</em>'.
   * @generated
   */
  InputValue createInputValue();

  /**
   * Returns a new object of class '<em>Client Then Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Client Then Block</em>'.
   * @generated
   */
  ClientThenBlock createClientThenBlock();

  /**
   * Returns a new object of class '<em>State Verification</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>State Verification</em>'.
   * @generated
   */
  StateVerification createStateVerification();

  /**
   * Returns a new object of class '<em>Custom Verification</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Custom Verification</em>'.
   * @generated
   */
  CustomVerification createCustomVerification();

  /**
   * Returns a new object of class '<em>Json Object Client</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Json Object Client</em>'.
   * @generated
   */
  JsonObjectClient createJsonObjectClient();

  /**
   * Returns a new object of class '<em>Json Member Client</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Json Member Client</em>'.
   * @generated
   */
  JsonMemberClient createJsonMemberClient();

  /**
   * Returns a new object of class '<em>Json Value Client</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Json Value Client</em>'.
   * @generated
   */
  JsonValueClient createJsonValueClient();

  /**
   * Returns a new object of class '<em>Json Array Client</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Json Array Client</em>'.
   * @generated
   */
  JsonArrayClient createJsonArrayClient();

  /**
   * Returns a new object of class '<em>Http Server</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Http Server</em>'.
   * @generated
   */
  HttpServer createHttpServer();

  /**
   * Returns a new object of class '<em>Http Server Ace</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Http Server Ace</em>'.
   * @generated
   */
  HttpServerAce createHttpServerAce();

  /**
   * Returns a new object of class '<em>Http Server Ace Write</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Http Server Ace Write</em>'.
   * @generated
   */
  HttpServerAceWrite createHttpServerAceWrite();

  /**
   * Returns a new object of class '<em>Http Server Outcome</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Http Server Outcome</em>'.
   * @generated
   */
  HttpServerOutcome createHttpServerOutcome();

  /**
   * Returns a new object of class '<em>Http Server Ace Read</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Http Server Ace Read</em>'.
   * @generated
   */
  HttpServerAceRead createHttpServerAceRead();

  /**
   * Returns a new object of class '<em>Attribute Param Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute Param Ref</em>'.
   * @generated
   */
  AttributeParamRef createAttributeParamRef();

  /**
   * Returns a new object of class '<em>Http Server View</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Http Server View</em>'.
   * @generated
   */
  HttpServerView createHttpServerView();

  /**
   * Returns a new object of class '<em>Http Server View Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Http Server View Function</em>'.
   * @generated
   */
  HttpServerViewFunction createHttpServerViewFunction();

  /**
   * Returns a new object of class '<em>Auth User</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Auth User</em>'.
   * @generated
   */
  AuthUser createAuthUser();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Scenario</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Scenario</em>'.
   * @generated
   */
  Scenario createScenario();

  /**
   * Returns a new object of class '<em>When Then</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>When Then</em>'.
   * @generated
   */
  WhenThen createWhenThen();

  /**
   * Returns a new object of class '<em>Given</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Given</em>'.
   * @generated
   */
  Given createGiven();

  /**
   * Returns a new object of class '<em>Custom Call</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Custom Call</em>'.
   * @generated
   */
  CustomCall createCustomCall();

  /**
   * Returns a new object of class '<em>Given Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Given Ref</em>'.
   * @generated
   */
  GivenRef createGivenRef();

  /**
   * Returns a new object of class '<em>When Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>When Block</em>'.
   * @generated
   */
  WhenBlock createWhenBlock();

  /**
   * Returns a new object of class '<em>Then Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Then Block</em>'.
   * @generated
   */
  ThenBlock createThenBlock();

  /**
   * Returns a new object of class '<em>Persistence Verification</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Persistence Verification</em>'.
   * @generated
   */
  PersistenceVerification createPersistenceVerification();

  /**
   * Returns a new object of class '<em>Persistence Verification Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Persistence Verification Expression</em>'.
   * @generated
   */
  PersistenceVerificationExpression createPersistenceVerificationExpression();

  /**
   * Returns a new object of class '<em>Select By Primary Keys</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Select By Primary Keys</em>'.
   * @generated
   */
  SelectByPrimaryKeys createSelectByPrimaryKeys();

  /**
   * Returns a new object of class '<em>Select By Unique Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Select By Unique Attribute</em>'.
   * @generated
   */
  SelectByUniqueAttribute createSelectByUniqueAttribute();

  /**
   * Returns a new object of class '<em>Count</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Count</em>'.
   * @generated
   */
  Count createCount();

  /**
   * Returns a new object of class '<em>Attribute And Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute And Value</em>'.
   * @generated
   */
  AttributeAndValue createAttributeAndValue();

  /**
   * Returns a new object of class '<em>Verification</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Verification</em>'.
   * @generated
   */
  Verification createVerification();

  /**
   * Returns a new object of class '<em>Extraction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Extraction</em>'.
   * @generated
   */
  Extraction createExtraction();

  /**
   * Returns a new object of class '<em>Select By Expectation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Select By Expectation</em>'.
   * @generated
   */
  SelectByExpectation createSelectByExpectation();

  /**
   * Returns a new object of class '<em>Data Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Data Definition</em>'.
   * @generated
   */
  DataDefinition createDataDefinition();

  /**
   * Returns a new object of class '<em>Authorization</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Authorization</em>'.
   * @generated
   */
  Authorization createAuthorization();

  /**
   * Returns a new object of class '<em>Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute</em>'.
   * @generated
   */
  Attribute createAttribute();

  /**
   * Returns a new object of class '<em>Json Object</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Json Object</em>'.
   * @generated
   */
  JsonObject createJsonObject();

  /**
   * Returns a new object of class '<em>Json Object Ace</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Json Object Ace</em>'.
   * @generated
   */
  JsonObjectAce createJsonObjectAce();

  /**
   * Returns a new object of class '<em>Json Member</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Json Member</em>'.
   * @generated
   */
  JsonMember createJsonMember();

  /**
   * Returns a new object of class '<em>Json Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Json Value</em>'.
   * @generated
   */
  JsonValue createJsonValue();

  /**
   * Returns a new object of class '<em>Json Array</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Json Array</em>'.
   * @generated
   */
  JsonArray createJsonArray();

  /**
   * Returns a new object of class '<em>Json Date Time</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Json Date Time</em>'.
   * @generated
   */
  JsonDateTime createJsonDateTime();

  /**
   * Returns a new object of class '<em>String Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>String Type</em>'.
   * @generated
   */
  StringType createStringType();

  /**
   * Returns a new object of class '<em>Boolean Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Boolean Type</em>'.
   * @generated
   */
  BooleanType createBooleanType();

  /**
   * Returns a new object of class '<em>Null Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Null Type</em>'.
   * @generated
   */
  NullType createNullType();

  /**
   * Returns a new object of class '<em>Undefined Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Undefined Type</em>'.
   * @generated
   */
  UndefinedType createUndefinedType();

  /**
   * Returns a new object of class '<em>Long Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Long Type</em>'.
   * @generated
   */
  LongType createLongType();

  /**
   * Returns a new object of class '<em>Primitive Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Primitive Value</em>'.
   * @generated
   */
  PrimitiveValue createPrimitiveValue();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  AceGenPackage getAceGenPackage();

} //AceGenFactory
