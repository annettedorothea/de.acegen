/**
 * generated by Xtext 2.20.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Then Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.ThenBlock#getStatusCode <em>Status Code</em>}</li>
 *   <li>{@link de.acegen.aceGen.ThenBlock#getResponse <em>Response</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getThenBlock()
 * @model
 * @generated
 */
public interface ThenBlock extends EObject
{
  /**
   * Returns the value of the '<em><b>Status Code</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Status Code</em>' attribute.
   * @see #setStatusCode(int)
   * @see de.acegen.aceGen.AceGenPackage#getThenBlock_StatusCode()
   * @model
   * @generated
   */
  int getStatusCode();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.ThenBlock#getStatusCode <em>Status Code</em>}' attribute.
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
   * @see #setResponse(DataDefinition)
   * @see de.acegen.aceGen.AceGenPackage#getThenBlock_Response()
   * @model containment="true"
   * @generated
   */
  DataDefinition getResponse();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.ThenBlock#getResponse <em>Response</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Response</em>' containment reference.
   * @see #getResponse()
   * @generated
   */
  void setResponse(DataDefinition value);

} // ThenBlock
