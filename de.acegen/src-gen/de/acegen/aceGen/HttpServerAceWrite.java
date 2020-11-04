/**
 * generated by Xtext 2.23.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Http Server Ace Write</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.HttpServerAceWrite#getOutcomes <em>Outcomes</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getHttpServerAceWrite()
 * @model
 * @generated
 */
public interface HttpServerAceWrite extends HttpServerAce
{
  /**
   * Returns the value of the '<em><b>Outcomes</b></em>' containment reference list.
   * The list contents are of type {@link de.acegen.aceGen.HttpServerOutcome}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Outcomes</em>' containment reference list.
   * @see de.acegen.aceGen.AceGenPackage#getHttpServerAceWrite_Outcomes()
   * @model containment="true"
   * @generated
   */
  EList<HttpServerOutcome> getOutcomes();

} // HttpServerAceWrite
