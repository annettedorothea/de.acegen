/**
 * generated by Xtext 2.27.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Given</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.Given#getTimes <em>Times</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getGiven()
 * @model
 * @generated
 */
public interface Given extends EObject
{
  /**
   * Returns the value of the '<em><b>Times</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Times</em>' attribute.
   * @see #setTimes(int)
   * @see de.acegen.aceGen.AceGenPackage#getGiven_Times()
   * @model
   * @generated
   */
  int getTimes();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.Given#getTimes <em>Times</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Times</em>' attribute.
   * @see #getTimes()
   * @generated
   */
  void setTimes(int value);

} // Given
