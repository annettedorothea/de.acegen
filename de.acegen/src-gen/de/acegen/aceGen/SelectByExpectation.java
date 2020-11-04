/**
 * generated by Xtext 2.23.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Select By Expectation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.SelectByExpectation#getObject <em>Object</em>}</li>
 *   <li>{@link de.acegen.aceGen.SelectByExpectation#isIsNotNull <em>Is Not Null</em>}</li>
 *   <li>{@link de.acegen.aceGen.SelectByExpectation#isIsNull <em>Is Null</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getSelectByExpectation()
 * @model
 * @generated
 */
public interface SelectByExpectation extends EObject
{
  /**
   * Returns the value of the '<em><b>Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Object</em>' containment reference.
   * @see #setObject(JsonObject)
   * @see de.acegen.aceGen.AceGenPackage#getSelectByExpectation_Object()
   * @model containment="true"
   * @generated
   */
  JsonObject getObject();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.SelectByExpectation#getObject <em>Object</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Object</em>' containment reference.
   * @see #getObject()
   * @generated
   */
  void setObject(JsonObject value);

  /**
   * Returns the value of the '<em><b>Is Not Null</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Not Null</em>' attribute.
   * @see #setIsNotNull(boolean)
   * @see de.acegen.aceGen.AceGenPackage#getSelectByExpectation_IsNotNull()
   * @model
   * @generated
   */
  boolean isIsNotNull();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.SelectByExpectation#isIsNotNull <em>Is Not Null</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Not Null</em>' attribute.
   * @see #isIsNotNull()
   * @generated
   */
  void setIsNotNull(boolean value);

  /**
   * Returns the value of the '<em><b>Is Null</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Null</em>' attribute.
   * @see #setIsNull(boolean)
   * @see de.acegen.aceGen.AceGenPackage#getSelectByExpectation_IsNull()
   * @model
   * @generated
   */
  boolean isIsNull();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.SelectByExpectation#isIsNull <em>Is Null</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Null</em>' attribute.
   * @see #isIsNull()
   * @generated
   */
  void setIsNull(boolean value);

} // SelectByExpectation
