/**
 * generated by Xtext 2.26.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Http Client State Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.HttpClientStateFunction#getStateFunctionType <em>State Function Type</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpClientStateFunction#getStateElement <em>State Element</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getHttpClientStateFunction()
 * @model
 * @generated
 */
public interface HttpClientStateFunction extends EObject
{
  /**
   * Returns the value of the '<em><b>State Function Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>State Function Type</em>' attribute.
   * @see #setStateFunctionType(String)
   * @see de.acegen.aceGen.AceGenPackage#getHttpClientStateFunction_StateFunctionType()
   * @model
   * @generated
   */
  String getStateFunctionType();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.HttpClientStateFunction#getStateFunctionType <em>State Function Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>State Function Type</em>' attribute.
   * @see #getStateFunctionType()
   * @generated
   */
  void setStateFunctionType(String value);

  /**
   * Returns the value of the '<em><b>State Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>State Element</em>' reference.
   * @see #setStateElement(ClientAttribute)
   * @see de.acegen.aceGen.AceGenPackage#getHttpClientStateFunction_StateElement()
   * @model
   * @generated
   */
  ClientAttribute getStateElement();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.HttpClientStateFunction#getStateElement <em>State Element</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>State Element</em>' reference.
   * @see #getStateElement()
   * @generated
   */
  void setStateElement(ClientAttribute value);

} // HttpClientStateFunction
