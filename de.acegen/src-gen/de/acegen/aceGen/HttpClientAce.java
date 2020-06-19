/**
 * generated by Xtext 2.21.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Http Client Ace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.HttpClientAce#isAsync <em>Async</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpClientAce#getName <em>Name</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpClientAce#getInput <em>Input</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpClientAce#getStateElements <em>State Elements</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpClientAce#getServerCall <em>Server Call</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpClientAce#getLoadingFlag <em>Loading Flag</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpClientAce#getOutcomes <em>Outcomes</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getHttpClientAce()
 * @model
 * @generated
 */
public interface HttpClientAce extends EObject
{
  /**
   * Returns the value of the '<em><b>Async</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Async</em>' attribute.
   * @see #setAsync(boolean)
   * @see de.acegen.aceGen.AceGenPackage#getHttpClientAce_Async()
   * @model
   * @generated
   */
  boolean isAsync();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.HttpClientAce#isAsync <em>Async</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Async</em>' attribute.
   * @see #isAsync()
   * @generated
   */
  void setAsync(boolean value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see de.acegen.aceGen.AceGenPackage#getHttpClientAce_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.HttpClientAce#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Input</b></em>' containment reference list.
   * The list contents are of type {@link de.acegen.aceGen.Input}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Input</em>' containment reference list.
   * @see de.acegen.aceGen.AceGenPackage#getHttpClientAce_Input()
   * @model containment="true"
   * @generated
   */
  EList<Input> getInput();

  /**
   * Returns the value of the '<em><b>State Elements</b></em>' reference list.
   * The list contents are of type {@link de.acegen.aceGen.HttpClientStateElement}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>State Elements</em>' reference list.
   * @see de.acegen.aceGen.AceGenPackage#getHttpClientAce_StateElements()
   * @model
   * @generated
   */
  EList<HttpClientStateElement> getStateElements();

  /**
   * Returns the value of the '<em><b>Server Call</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Server Call</em>' reference.
   * @see #setServerCall(HttpServerAce)
   * @see de.acegen.aceGen.AceGenPackage#getHttpClientAce_ServerCall()
   * @model
   * @generated
   */
  HttpServerAce getServerCall();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.HttpClientAce#getServerCall <em>Server Call</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Server Call</em>' reference.
   * @see #getServerCall()
   * @generated
   */
  void setServerCall(HttpServerAce value);

  /**
   * Returns the value of the '<em><b>Loading Flag</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Loading Flag</em>' reference.
   * @see #setLoadingFlag(HttpClientStateElement)
   * @see de.acegen.aceGen.AceGenPackage#getHttpClientAce_LoadingFlag()
   * @model
   * @generated
   */
  HttpClientStateElement getLoadingFlag();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.HttpClientAce#getLoadingFlag <em>Loading Flag</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Loading Flag</em>' reference.
   * @see #getLoadingFlag()
   * @generated
   */
  void setLoadingFlag(HttpClientStateElement value);

  /**
   * Returns the value of the '<em><b>Outcomes</b></em>' containment reference list.
   * The list contents are of type {@link de.acegen.aceGen.HttpClientOutcome}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Outcomes</em>' containment reference list.
   * @see de.acegen.aceGen.AceGenPackage#getHttpClientAce_Outcomes()
   * @model containment="true"
   * @generated
   */
  EList<HttpClientOutcome> getOutcomes();

} // HttpClientAce
