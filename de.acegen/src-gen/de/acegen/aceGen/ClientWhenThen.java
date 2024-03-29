/**
 * generated by Xtext 2.29.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Client When Then</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.ClientWhenThen#getWhenBlock <em>When Block</em>}</li>
 *   <li>{@link de.acegen.aceGen.ClientWhenThen#getDelayInMillis <em>Delay In Millis</em>}</li>
 *   <li>{@link de.acegen.aceGen.ClientWhenThen#getThenBlock <em>Then Block</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getClientWhenThen()
 * @model
 * @generated
 */
public interface ClientWhenThen extends EObject
{
  /**
   * Returns the value of the '<em><b>When Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>When Block</em>' containment reference.
   * @see #setWhenBlock(ClientWhenBlock)
   * @see de.acegen.aceGen.AceGenPackage#getClientWhenThen_WhenBlock()
   * @model containment="true"
   * @generated
   */
  ClientWhenBlock getWhenBlock();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.ClientWhenThen#getWhenBlock <em>When Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>When Block</em>' containment reference.
   * @see #getWhenBlock()
   * @generated
   */
  void setWhenBlock(ClientWhenBlock value);

  /**
   * Returns the value of the '<em><b>Delay In Millis</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Delay In Millis</em>' attribute.
   * @see #setDelayInMillis(int)
   * @see de.acegen.aceGen.AceGenPackage#getClientWhenThen_DelayInMillis()
   * @model
   * @generated
   */
  int getDelayInMillis();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.ClientWhenThen#getDelayInMillis <em>Delay In Millis</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Delay In Millis</em>' attribute.
   * @see #getDelayInMillis()
   * @generated
   */
  void setDelayInMillis(int value);

  /**
   * Returns the value of the '<em><b>Then Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Then Block</em>' containment reference.
   * @see #setThenBlock(ClientThenBlock)
   * @see de.acegen.aceGen.AceGenPackage#getClientWhenThen_ThenBlock()
   * @model containment="true"
   * @generated
   */
  ClientThenBlock getThenBlock();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.ClientWhenThen#getThenBlock <em>Then Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Then Block</em>' containment reference.
   * @see #getThenBlock()
   * @generated
   */
  void setThenBlock(ClientThenBlock value);

} // ClientWhenThen
