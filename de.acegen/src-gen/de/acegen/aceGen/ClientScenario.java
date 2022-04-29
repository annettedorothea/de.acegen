/**
 * generated by Xtext 2.26.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Client Scenario</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.ClientScenario#getName <em>Name</em>}</li>
 *   <li>{@link de.acegen.aceGen.ClientScenario#getGivenRefs <em>Given Refs</em>}</li>
 *   <li>{@link de.acegen.aceGen.ClientScenario#getClientWhenThen <em>Client When Then</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getClientScenario()
 * @model
 * @generated
 */
public interface ClientScenario extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see de.acegen.aceGen.AceGenPackage#getClientScenario_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.ClientScenario#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Given Refs</b></em>' containment reference list.
   * The list contents are of type {@link de.acegen.aceGen.ClientGivenRef}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Given Refs</em>' containment reference list.
   * @see de.acegen.aceGen.AceGenPackage#getClientScenario_GivenRefs()
   * @model containment="true"
   * @generated
   */
  EList<ClientGivenRef> getGivenRefs();

  /**
   * Returns the value of the '<em><b>Client When Then</b></em>' containment reference list.
   * The list contents are of type {@link de.acegen.aceGen.ClientWhenThen}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Client When Then</em>' containment reference list.
   * @see de.acegen.aceGen.AceGenPackage#getClientScenario_ClientWhenThen()
   * @model containment="true"
   * @generated
   */
  EList<ClientWhenThen> getClientWhenThen();

} // ClientScenario
