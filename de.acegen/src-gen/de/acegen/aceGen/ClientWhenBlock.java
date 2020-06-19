/**
 * generated by Xtext 2.21.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Client When Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.ClientWhenBlock#getAction <em>Action</em>}</li>
 *   <li>{@link de.acegen.aceGen.ClientWhenBlock#getInputValues <em>Input Values</em>}</li>
 *   <li>{@link de.acegen.aceGen.ClientWhenBlock#getStatusCode <em>Status Code</em>}</li>
 *   <li>{@link de.acegen.aceGen.ClientWhenBlock#getResponse <em>Response</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getClientWhenBlock()
 * @model
 * @generated
 */
public interface ClientWhenBlock extends EObject
{
  /**
   * Returns the value of the '<em><b>Action</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Action</em>' reference.
   * @see #setAction(HttpClientAce)
   * @see de.acegen.aceGen.AceGenPackage#getClientWhenBlock_Action()
   * @model
   * @generated
   */
  HttpClientAce getAction();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.ClientWhenBlock#getAction <em>Action</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Action</em>' reference.
   * @see #getAction()
   * @generated
   */
  void setAction(HttpClientAce value);

  /**
   * Returns the value of the '<em><b>Input Values</b></em>' containment reference list.
   * The list contents are of type {@link de.acegen.aceGen.InputValue}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Input Values</em>' containment reference list.
   * @see de.acegen.aceGen.AceGenPackage#getClientWhenBlock_InputValues()
   * @model containment="true"
   * @generated
   */
  EList<InputValue> getInputValues();

  /**
   * Returns the value of the '<em><b>Status Code</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Status Code</em>' attribute.
   * @see #setStatusCode(int)
   * @see de.acegen.aceGen.AceGenPackage#getClientWhenBlock_StatusCode()
   * @model
   * @generated
   */
  int getStatusCode();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.ClientWhenBlock#getStatusCode <em>Status Code</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Status Code</em>' attribute.
   * @see #getStatusCode()
   * @generated
   */
  void setStatusCode(int value);

  /**
   * Returns the value of the '<em><b>Response</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Response</em>' containment reference.
   * @see #setResponse(JsonObject)
   * @see de.acegen.aceGen.AceGenPackage#getClientWhenBlock_Response()
   * @model containment="true"
   * @generated
   */
  JsonObject getResponse();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.ClientWhenBlock#getResponse <em>Response</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Response</em>' containment reference.
   * @see #getResponse()
   * @generated
   */
  void setResponse(JsonObject value);

} // ClientWhenBlock
