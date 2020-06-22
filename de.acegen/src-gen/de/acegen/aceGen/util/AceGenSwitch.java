/**
 * generated by Xtext 2.21.0
 */
package de.acegen.aceGen.util;

import de.acegen.aceGen.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.acegen.aceGen.AceGenPackage
 * @generated
 */
public class AceGenSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static AceGenPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AceGenSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = AceGenPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case AceGenPackage.PROJECT:
      {
        Project project = (Project)theEObject;
        T result = caseProject(project);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.HTTP_CLIENT:
      {
        HttpClient httpClient = (HttpClient)theEObject;
        T result = caseHttpClient(httpClient);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.HTTP_CLIENT_ACE:
      {
        HttpClientAce httpClientAce = (HttpClientAce)theEObject;
        T result = caseHttpClientAce(httpClientAce);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.INPUT:
      {
        Input input = (Input)theEObject;
        T result = caseInput(input);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.HTTP_CLIENT_OUTCOME:
      {
        HttpClientOutcome httpClientOutcome = (HttpClientOutcome)theEObject;
        T result = caseHttpClientOutcome(httpClientOutcome);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.HTTP_CLIENT_STATE_FUNCTION:
      {
        HttpClientStateFunction httpClientStateFunction = (HttpClientStateFunction)theEObject;
        T result = caseHttpClientStateFunction(httpClientStateFunction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.CLIENT_SCENARIO:
      {
        ClientScenario clientScenario = (ClientScenario)theEObject;
        T result = caseClientScenario(clientScenario);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.CLIENT_WHEN_BLOCK:
      {
        ClientWhenBlock clientWhenBlock = (ClientWhenBlock)theEObject;
        T result = caseClientWhenBlock(clientWhenBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.INPUT_VALUE:
      {
        InputValue inputValue = (InputValue)theEObject;
        T result = caseInputValue(inputValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.CLIENT_THEN_BLOCK:
      {
        ClientThenBlock clientThenBlock = (ClientThenBlock)theEObject;
        T result = caseClientThenBlock(clientThenBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.TRIGGERED_ACTION:
      {
        TriggeredAction triggeredAction = (TriggeredAction)theEObject;
        T result = caseTriggeredAction(triggeredAction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.STATE_VERIFICATION:
      {
        StateVerification stateVerification = (StateVerification)theEObject;
        T result = caseStateVerification(stateVerification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.HTTP_SERVER:
      {
        HttpServer httpServer = (HttpServer)theEObject;
        T result = caseHttpServer(httpServer);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.HTTP_SERVER_ACE:
      {
        HttpServerAce httpServerAce = (HttpServerAce)theEObject;
        T result = caseHttpServerAce(httpServerAce);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.HTTP_SERVER_ACE_WRITE:
      {
        HttpServerAceWrite httpServerAceWrite = (HttpServerAceWrite)theEObject;
        T result = caseHttpServerAceWrite(httpServerAceWrite);
        if (result == null) result = caseHttpServerAce(httpServerAceWrite);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.HTTP_SERVER_OUTCOME:
      {
        HttpServerOutcome httpServerOutcome = (HttpServerOutcome)theEObject;
        T result = caseHttpServerOutcome(httpServerOutcome);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.HTTP_SERVER_ACE_READ:
      {
        HttpServerAceRead httpServerAceRead = (HttpServerAceRead)theEObject;
        T result = caseHttpServerAceRead(httpServerAceRead);
        if (result == null) result = caseHttpServerAce(httpServerAceRead);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.ATTRIBUTE_PARAM_REF:
      {
        AttributeParamRef attributeParamRef = (AttributeParamRef)theEObject;
        T result = caseAttributeParamRef(attributeParamRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.HTTP_SERVER_VIEW:
      {
        HttpServerView httpServerView = (HttpServerView)theEObject;
        T result = caseHttpServerView(httpServerView);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.HTTP_SERVER_VIEW_FUNCTION:
      {
        HttpServerViewFunction httpServerViewFunction = (HttpServerViewFunction)theEObject;
        T result = caseHttpServerViewFunction(httpServerViewFunction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.AUTH_USER:
      {
        AuthUser authUser = (AuthUser)theEObject;
        T result = caseAuthUser(authUser);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.MODEL:
      {
        Model model = (Model)theEObject;
        T result = caseModel(model);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.SCENARIO:
      {
        Scenario scenario = (Scenario)theEObject;
        T result = caseScenario(scenario);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.GIVEN_REF:
      {
        GivenRef givenRef = (GivenRef)theEObject;
        T result = caseGivenRef(givenRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.WHEN_BLOCK:
      {
        WhenBlock whenBlock = (WhenBlock)theEObject;
        T result = caseWhenBlock(whenBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.THEN_BLOCK:
      {
        ThenBlock thenBlock = (ThenBlock)theEObject;
        T result = caseThenBlock(thenBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.PERSISTENCE_VERIFICATION:
      {
        PersistenceVerification persistenceVerification = (PersistenceVerification)theEObject;
        T result = casePersistenceVerification(persistenceVerification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.PERSISTENCE_VERIFICATION_EXPRESSION:
      {
        PersistenceVerificationExpression persistenceVerificationExpression = (PersistenceVerificationExpression)theEObject;
        T result = casePersistenceVerificationExpression(persistenceVerificationExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.SELECT_BY_PRIMARY_KEYS:
      {
        SelectByPrimaryKeys selectByPrimaryKeys = (SelectByPrimaryKeys)theEObject;
        T result = caseSelectByPrimaryKeys(selectByPrimaryKeys);
        if (result == null) result = casePersistenceVerificationExpression(selectByPrimaryKeys);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.SELECT_BY_UNIQUE_ATTRIBUTE:
      {
        SelectByUniqueAttribute selectByUniqueAttribute = (SelectByUniqueAttribute)theEObject;
        T result = caseSelectByUniqueAttribute(selectByUniqueAttribute);
        if (result == null) result = casePersistenceVerificationExpression(selectByUniqueAttribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.COUNT:
      {
        Count count = (Count)theEObject;
        T result = caseCount(count);
        if (result == null) result = casePersistenceVerificationExpression(count);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.ATTRIBUTE_AND_VALUE:
      {
        AttributeAndValue attributeAndValue = (AttributeAndValue)theEObject;
        T result = caseAttributeAndValue(attributeAndValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.VERIFICATION:
      {
        Verification verification = (Verification)theEObject;
        T result = caseVerification(verification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.SELECT_BY_EXPECTATION:
      {
        SelectByExpectation selectByExpectation = (SelectByExpectation)theEObject;
        T result = caseSelectByExpectation(selectByExpectation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.DATA_DEFINITION:
      {
        DataDefinition dataDefinition = (DataDefinition)theEObject;
        T result = caseDataDefinition(dataDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.AUTHORIZATION:
      {
        Authorization authorization = (Authorization)theEObject;
        T result = caseAuthorization(authorization);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.ATTRIBUTE:
      {
        Attribute attribute = (Attribute)theEObject;
        T result = caseAttribute(attribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.JSON_DATE_TIME:
      {
        JsonDateTime jsonDateTime = (JsonDateTime)theEObject;
        T result = caseJsonDateTime(jsonDateTime);
        if (result == null) result = caseJsonValue(jsonDateTime);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.JSON_OBJECT:
      {
        JsonObject jsonObject = (JsonObject)theEObject;
        T result = caseJsonObject(jsonObject);
        if (result == null) result = caseJsonValue(jsonObject);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.JSON_MEMBER:
      {
        JsonMember jsonMember = (JsonMember)theEObject;
        T result = caseJsonMember(jsonMember);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.JSON_VALUE:
      {
        JsonValue jsonValue = (JsonValue)theEObject;
        T result = caseJsonValue(jsonValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.JSON_ARRAY:
      {
        JsonArray jsonArray = (JsonArray)theEObject;
        T result = caseJsonArray(jsonArray);
        if (result == null) result = caseJsonValue(jsonArray);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AceGenPackage.PRIMITIVE_VALUE:
      {
        PrimitiveValue primitiveValue = (PrimitiveValue)theEObject;
        T result = casePrimitiveValue(primitiveValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Project</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Project</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProject(Project object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Http Client</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Http Client</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseHttpClient(HttpClient object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Http Client Ace</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Http Client Ace</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseHttpClientAce(HttpClientAce object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Input</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Input</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInput(Input object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Http Client Outcome</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Http Client Outcome</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseHttpClientOutcome(HttpClientOutcome object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Http Client State Function</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Http Client State Function</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseHttpClientStateFunction(HttpClientStateFunction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Client Scenario</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Client Scenario</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClientScenario(ClientScenario object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Client When Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Client When Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClientWhenBlock(ClientWhenBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Input Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Input Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInputValue(InputValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Client Then Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Client Then Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClientThenBlock(ClientThenBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Triggered Action</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Triggered Action</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTriggeredAction(TriggeredAction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>State Verification</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>State Verification</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStateVerification(StateVerification object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Http Server</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Http Server</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseHttpServer(HttpServer object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Http Server Ace</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Http Server Ace</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseHttpServerAce(HttpServerAce object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Http Server Ace Write</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Http Server Ace Write</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseHttpServerAceWrite(HttpServerAceWrite object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Http Server Outcome</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Http Server Outcome</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseHttpServerOutcome(HttpServerOutcome object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Http Server Ace Read</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Http Server Ace Read</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseHttpServerAceRead(HttpServerAceRead object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute Param Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute Param Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttributeParamRef(AttributeParamRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Http Server View</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Http Server View</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseHttpServerView(HttpServerView object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Http Server View Function</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Http Server View Function</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseHttpServerViewFunction(HttpServerViewFunction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Auth User</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Auth User</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAuthUser(AuthUser object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModel(Model object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Scenario</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Scenario</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseScenario(Scenario object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Given Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Given Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGivenRef(GivenRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>When Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>When Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWhenBlock(WhenBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Then Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Then Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseThenBlock(ThenBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Persistence Verification</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Persistence Verification</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePersistenceVerification(PersistenceVerification object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Persistence Verification Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Persistence Verification Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePersistenceVerificationExpression(PersistenceVerificationExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Select By Primary Keys</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Select By Primary Keys</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSelectByPrimaryKeys(SelectByPrimaryKeys object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Select By Unique Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Select By Unique Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSelectByUniqueAttribute(SelectByUniqueAttribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Count</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Count</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCount(Count object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute And Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute And Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttributeAndValue(AttributeAndValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Verification</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Verification</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVerification(Verification object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Select By Expectation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Select By Expectation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSelectByExpectation(SelectByExpectation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Data Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Data Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDataDefinition(DataDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Authorization</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Authorization</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAuthorization(Authorization object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttribute(Attribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Json Date Time</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Json Date Time</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseJsonDateTime(JsonDateTime object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Json Object</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Json Object</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseJsonObject(JsonObject object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Json Member</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Json Member</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseJsonMember(JsonMember object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Json Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Json Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseJsonValue(JsonValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Json Array</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Json Array</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseJsonArray(JsonArray object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Primitive Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Primitive Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrimitiveValue(PrimitiveValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //AceGenSwitch
