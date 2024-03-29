/**
 * generated by Xtext 2.29.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Json Object Client</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.JsonObjectClient#getMembers <em>Members</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getJsonObjectClient()
 * @model
 * @generated
 */
public interface JsonObjectClient extends JsonValueClient
{
  /**
   * Returns the value of the '<em><b>Members</b></em>' containment reference list.
   * The list contents are of type {@link de.acegen.aceGen.JsonMemberClient}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Members</em>' containment reference list.
   * @see de.acegen.aceGen.AceGenPackage#getJsonObjectClient_Members()
   * @model containment="true"
   * @generated
   */
  EList<JsonMemberClient> getMembers();

} // JsonObjectClient
