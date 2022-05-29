/**
 * generated by Xtext 2.26.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ui Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.UiAction#getType <em>Type</em>}</li>
 *   <li>{@link de.acegen.aceGen.UiAction#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getUiAction()
 * @model
 * @generated
 */
public interface UiAction extends EObject
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see #setType(String)
   * @see de.acegen.aceGen.AceGenPackage#getUiAction_Type()
   * @model
   * @generated
   */
  String getType();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.UiAction#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(HttpClientAce)
   * @see de.acegen.aceGen.AceGenPackage#getUiAction_Target()
   * @model
   * @generated
   */
  HttpClientAce getTarget();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.UiAction#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(HttpClientAce value);

} // UiAction
