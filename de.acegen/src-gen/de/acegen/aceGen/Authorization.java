/**
 * generated by Xtext 2.23.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Authorization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.Authorization#getUsername <em>Username</em>}</li>
 *   <li>{@link de.acegen.aceGen.Authorization#getPassword <em>Password</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getAuthorization()
 * @model
 * @generated
 */
public interface Authorization extends EObject
{
  /**
   * Returns the value of the '<em><b>Username</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Username</em>' attribute.
   * @see #setUsername(String)
   * @see de.acegen.aceGen.AceGenPackage#getAuthorization_Username()
   * @model
   * @generated
   */
  String getUsername();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.Authorization#getUsername <em>Username</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Username</em>' attribute.
   * @see #getUsername()
   * @generated
   */
  void setUsername(String value);

  /**
   * Returns the value of the '<em><b>Password</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Password</em>' attribute.
   * @see #setPassword(String)
   * @see de.acegen.aceGen.AceGenPackage#getAuthorization_Password()
   * @model
   * @generated
   */
  String getPassword();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.Authorization#getPassword <em>Password</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Password</em>' attribute.
   * @see #getPassword()
   * @generated
   */
  void setPassword(String value);

} // Authorization
