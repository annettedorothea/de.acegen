/**
 * generated by Xtext 2.26.0
 */
package de.acegen.aceGen.impl;

import de.acegen.aceGen.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AceGenFactoryImpl extends EFactoryImpl implements AceGenFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AceGenFactory init()
  {
    try
    {
      AceGenFactory theAceGenFactory = (AceGenFactory)EPackage.Registry.INSTANCE.getEFactory(AceGenPackage.eNS_URI);
      if (theAceGenFactory != null)
      {
        return theAceGenFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new AceGenFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AceGenFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case AceGenPackage.PROJECT: return createProject();
      case AceGenPackage.HTTP_CLIENT: return createHttpClient();
      case AceGenPackage.HTTP_CLIENT_ACE: return createHttpClientAce();
      case AceGenPackage.FUNCTION: return createFunction();
      case AceGenPackage.FROM_APP_STATE_REF: return createFromAppStateRef();
      case AceGenPackage.INPUT: return createInput();
      case AceGenPackage.HTTP_CLIENT_OUTCOME: return createHttpClientOutcome();
      case AceGenPackage.TRIGGERD_ACE_OPERATION: return createTriggerdAceOperation();
      case AceGenPackage.HTTP_CLIENT_STATE_FUNCTION: return createHttpClientStateFunction();
      case AceGenPackage.FUNCTION_CALL: return createFunctionCall();
      case AceGenPackage.CLIENT_ATTRIBUTE: return createClientAttribute();
      case AceGenPackage.CLIENT_SCENARIO: return createClientScenario();
      case AceGenPackage.CLIENT_WHEN_THEN: return createClientWhenThen();
      case AceGenPackage.CLIENT_GIVEN_REF: return createClientGivenRef();
      case AceGenPackage.CLIENT_WHEN_BLOCK: return createClientWhenBlock();
      case AceGenPackage.SQUISHY_VALUE: return createSquishyValue();
      case AceGenPackage.INPUT_VALUE: return createInputValue();
      case AceGenPackage.CLIENT_THEN_BLOCK: return createClientThenBlock();
      case AceGenPackage.STATE_VERIFICATION: return createStateVerification();
      case AceGenPackage.CUSTOM_VERIFICATION: return createCustomVerification();
      case AceGenPackage.JSON_OBJECT_CLIENT: return createJsonObjectClient();
      case AceGenPackage.JSON_MEMBER_CLIENT: return createJsonMemberClient();
      case AceGenPackage.JSON_VALUE_CLIENT: return createJsonValueClient();
      case AceGenPackage.JSON_ARRAY_CLIENT: return createJsonArrayClient();
      case AceGenPackage.HTTP_SERVER: return createHttpServer();
      case AceGenPackage.HTTP_SERVER_ACE: return createHttpServerAce();
      case AceGenPackage.HTTP_SERVER_ACE_WRITE: return createHttpServerAceWrite();
      case AceGenPackage.HTTP_SERVER_OUTCOME: return createHttpServerOutcome();
      case AceGenPackage.HTTP_SERVER_ACE_READ: return createHttpServerAceRead();
      case AceGenPackage.ATTRIBUTE_PARAM_REF: return createAttributeParamRef();
      case AceGenPackage.HTTP_SERVER_VIEW: return createHttpServerView();
      case AceGenPackage.HTTP_SERVER_VIEW_FUNCTION: return createHttpServerViewFunction();
      case AceGenPackage.AUTH_USER: return createAuthUser();
      case AceGenPackage.MODEL: return createModel();
      case AceGenPackage.SCENARIO: return createScenario();
      case AceGenPackage.WHEN_THEN: return createWhenThen();
      case AceGenPackage.GIVEN: return createGiven();
      case AceGenPackage.CUSTOM_CALL: return createCustomCall();
      case AceGenPackage.GIVEN_REF: return createGivenRef();
      case AceGenPackage.WHEN_BLOCK: return createWhenBlock();
      case AceGenPackage.THEN_BLOCK: return createThenBlock();
      case AceGenPackage.PERSISTENCE_VERIFICATION: return createPersistenceVerification();
      case AceGenPackage.PERSISTENCE_VERIFICATION_EXPRESSION: return createPersistenceVerificationExpression();
      case AceGenPackage.SELECT_BY_PRIMARY_KEYS: return createSelectByPrimaryKeys();
      case AceGenPackage.SELECT_BY_UNIQUE_ATTRIBUTE: return createSelectByUniqueAttribute();
      case AceGenPackage.COUNT: return createCount();
      case AceGenPackage.ATTRIBUTE_AND_VALUE: return createAttributeAndValue();
      case AceGenPackage.VERIFICATION: return createVerification();
      case AceGenPackage.EXTRACTION: return createExtraction();
      case AceGenPackage.SELECT_BY_EXPECTATION: return createSelectByExpectation();
      case AceGenPackage.DATA_DEFINITION: return createDataDefinition();
      case AceGenPackage.AUTHORIZATION: return createAuthorization();
      case AceGenPackage.ATTRIBUTE: return createAttribute();
      case AceGenPackage.JSON_OBJECT: return createJsonObject();
      case AceGenPackage.JSON_OBJECT_ACE: return createJsonObjectAce();
      case AceGenPackage.JSON_MEMBER: return createJsonMember();
      case AceGenPackage.JSON_VALUE: return createJsonValue();
      case AceGenPackage.JSON_ARRAY: return createJsonArray();
      case AceGenPackage.JSON_DATE_TIME: return createJsonDateTime();
      case AceGenPackage.STRING_TYPE: return createStringType();
      case AceGenPackage.BOOLEAN_TYPE: return createBooleanType();
      case AceGenPackage.NULL_TYPE: return createNullType();
      case AceGenPackage.UNDEFINED_TYPE: return createUndefinedType();
      case AceGenPackage.LONG_TYPE: return createLongType();
      case AceGenPackage.PRIMITIVE_VALUE: return createPrimitiveValue();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Project createProject()
  {
    ProjectImpl project = new ProjectImpl();
    return project;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public HttpClient createHttpClient()
  {
    HttpClientImpl httpClient = new HttpClientImpl();
    return httpClient;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public HttpClientAce createHttpClientAce()
  {
    HttpClientAceImpl httpClientAce = new HttpClientAceImpl();
    return httpClientAce;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Function createFunction()
  {
    FunctionImpl function = new FunctionImpl();
    return function;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FromAppStateRef createFromAppStateRef()
  {
    FromAppStateRefImpl fromAppStateRef = new FromAppStateRefImpl();
    return fromAppStateRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Input createInput()
  {
    InputImpl input = new InputImpl();
    return input;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public HttpClientOutcome createHttpClientOutcome()
  {
    HttpClientOutcomeImpl httpClientOutcome = new HttpClientOutcomeImpl();
    return httpClientOutcome;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TriggerdAceOperation createTriggerdAceOperation()
  {
    TriggerdAceOperationImpl triggerdAceOperation = new TriggerdAceOperationImpl();
    return triggerdAceOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public HttpClientStateFunction createHttpClientStateFunction()
  {
    HttpClientStateFunctionImpl httpClientStateFunction = new HttpClientStateFunctionImpl();
    return httpClientStateFunction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FunctionCall createFunctionCall()
  {
    FunctionCallImpl functionCall = new FunctionCallImpl();
    return functionCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ClientAttribute createClientAttribute()
  {
    ClientAttributeImpl clientAttribute = new ClientAttributeImpl();
    return clientAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ClientScenario createClientScenario()
  {
    ClientScenarioImpl clientScenario = new ClientScenarioImpl();
    return clientScenario;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ClientWhenThen createClientWhenThen()
  {
    ClientWhenThenImpl clientWhenThen = new ClientWhenThenImpl();
    return clientWhenThen;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ClientGivenRef createClientGivenRef()
  {
    ClientGivenRefImpl clientGivenRef = new ClientGivenRefImpl();
    return clientGivenRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ClientWhenBlock createClientWhenBlock()
  {
    ClientWhenBlockImpl clientWhenBlock = new ClientWhenBlockImpl();
    return clientWhenBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SquishyValue createSquishyValue()
  {
    SquishyValueImpl squishyValue = new SquishyValueImpl();
    return squishyValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public InputValue createInputValue()
  {
    InputValueImpl inputValue = new InputValueImpl();
    return inputValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ClientThenBlock createClientThenBlock()
  {
    ClientThenBlockImpl clientThenBlock = new ClientThenBlockImpl();
    return clientThenBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public StateVerification createStateVerification()
  {
    StateVerificationImpl stateVerification = new StateVerificationImpl();
    return stateVerification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CustomVerification createCustomVerification()
  {
    CustomVerificationImpl customVerification = new CustomVerificationImpl();
    return customVerification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public JsonObjectClient createJsonObjectClient()
  {
    JsonObjectClientImpl jsonObjectClient = new JsonObjectClientImpl();
    return jsonObjectClient;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public JsonMemberClient createJsonMemberClient()
  {
    JsonMemberClientImpl jsonMemberClient = new JsonMemberClientImpl();
    return jsonMemberClient;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public JsonValueClient createJsonValueClient()
  {
    JsonValueClientImpl jsonValueClient = new JsonValueClientImpl();
    return jsonValueClient;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public JsonArrayClient createJsonArrayClient()
  {
    JsonArrayClientImpl jsonArrayClient = new JsonArrayClientImpl();
    return jsonArrayClient;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public HttpServer createHttpServer()
  {
    HttpServerImpl httpServer = new HttpServerImpl();
    return httpServer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public HttpServerAce createHttpServerAce()
  {
    HttpServerAceImpl httpServerAce = new HttpServerAceImpl();
    return httpServerAce;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public HttpServerAceWrite createHttpServerAceWrite()
  {
    HttpServerAceWriteImpl httpServerAceWrite = new HttpServerAceWriteImpl();
    return httpServerAceWrite;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public HttpServerOutcome createHttpServerOutcome()
  {
    HttpServerOutcomeImpl httpServerOutcome = new HttpServerOutcomeImpl();
    return httpServerOutcome;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public HttpServerAceRead createHttpServerAceRead()
  {
    HttpServerAceReadImpl httpServerAceRead = new HttpServerAceReadImpl();
    return httpServerAceRead;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AttributeParamRef createAttributeParamRef()
  {
    AttributeParamRefImpl attributeParamRef = new AttributeParamRefImpl();
    return attributeParamRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public HttpServerView createHttpServerView()
  {
    HttpServerViewImpl httpServerView = new HttpServerViewImpl();
    return httpServerView;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public HttpServerViewFunction createHttpServerViewFunction()
  {
    HttpServerViewFunctionImpl httpServerViewFunction = new HttpServerViewFunctionImpl();
    return httpServerViewFunction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AuthUser createAuthUser()
  {
    AuthUserImpl authUser = new AuthUserImpl();
    return authUser;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Scenario createScenario()
  {
    ScenarioImpl scenario = new ScenarioImpl();
    return scenario;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public WhenThen createWhenThen()
  {
    WhenThenImpl whenThen = new WhenThenImpl();
    return whenThen;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Given createGiven()
  {
    GivenImpl given = new GivenImpl();
    return given;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CustomCall createCustomCall()
  {
    CustomCallImpl customCall = new CustomCallImpl();
    return customCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public GivenRef createGivenRef()
  {
    GivenRefImpl givenRef = new GivenRefImpl();
    return givenRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public WhenBlock createWhenBlock()
  {
    WhenBlockImpl whenBlock = new WhenBlockImpl();
    return whenBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ThenBlock createThenBlock()
  {
    ThenBlockImpl thenBlock = new ThenBlockImpl();
    return thenBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PersistenceVerification createPersistenceVerification()
  {
    PersistenceVerificationImpl persistenceVerification = new PersistenceVerificationImpl();
    return persistenceVerification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PersistenceVerificationExpression createPersistenceVerificationExpression()
  {
    PersistenceVerificationExpressionImpl persistenceVerificationExpression = new PersistenceVerificationExpressionImpl();
    return persistenceVerificationExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SelectByPrimaryKeys createSelectByPrimaryKeys()
  {
    SelectByPrimaryKeysImpl selectByPrimaryKeys = new SelectByPrimaryKeysImpl();
    return selectByPrimaryKeys;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SelectByUniqueAttribute createSelectByUniqueAttribute()
  {
    SelectByUniqueAttributeImpl selectByUniqueAttribute = new SelectByUniqueAttributeImpl();
    return selectByUniqueAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Count createCount()
  {
    CountImpl count = new CountImpl();
    return count;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AttributeAndValue createAttributeAndValue()
  {
    AttributeAndValueImpl attributeAndValue = new AttributeAndValueImpl();
    return attributeAndValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Verification createVerification()
  {
    VerificationImpl verification = new VerificationImpl();
    return verification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Extraction createExtraction()
  {
    ExtractionImpl extraction = new ExtractionImpl();
    return extraction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SelectByExpectation createSelectByExpectation()
  {
    SelectByExpectationImpl selectByExpectation = new SelectByExpectationImpl();
    return selectByExpectation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DataDefinition createDataDefinition()
  {
    DataDefinitionImpl dataDefinition = new DataDefinitionImpl();
    return dataDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Authorization createAuthorization()
  {
    AuthorizationImpl authorization = new AuthorizationImpl();
    return authorization;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Attribute createAttribute()
  {
    AttributeImpl attribute = new AttributeImpl();
    return attribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public JsonObject createJsonObject()
  {
    JsonObjectImpl jsonObject = new JsonObjectImpl();
    return jsonObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public JsonObjectAce createJsonObjectAce()
  {
    JsonObjectAceImpl jsonObjectAce = new JsonObjectAceImpl();
    return jsonObjectAce;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public JsonMember createJsonMember()
  {
    JsonMemberImpl jsonMember = new JsonMemberImpl();
    return jsonMember;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public JsonValue createJsonValue()
  {
    JsonValueImpl jsonValue = new JsonValueImpl();
    return jsonValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public JsonArray createJsonArray()
  {
    JsonArrayImpl jsonArray = new JsonArrayImpl();
    return jsonArray;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public JsonDateTime createJsonDateTime()
  {
    JsonDateTimeImpl jsonDateTime = new JsonDateTimeImpl();
    return jsonDateTime;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public StringType createStringType()
  {
    StringTypeImpl stringType = new StringTypeImpl();
    return stringType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BooleanType createBooleanType()
  {
    BooleanTypeImpl booleanType = new BooleanTypeImpl();
    return booleanType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NullType createNullType()
  {
    NullTypeImpl nullType = new NullTypeImpl();
    return nullType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public UndefinedType createUndefinedType()
  {
    UndefinedTypeImpl undefinedType = new UndefinedTypeImpl();
    return undefinedType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public LongType createLongType()
  {
    LongTypeImpl longType = new LongTypeImpl();
    return longType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PrimitiveValue createPrimitiveValue()
  {
    PrimitiveValueImpl primitiveValue = new PrimitiveValueImpl();
    return primitiveValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AceGenPackage getAceGenPackage()
  {
    return (AceGenPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static AceGenPackage getPackage()
  {
    return AceGenPackage.eINSTANCE;
  }

} //AceGenFactoryImpl
