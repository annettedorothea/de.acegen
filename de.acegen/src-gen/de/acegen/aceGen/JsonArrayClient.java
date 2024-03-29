/**
 * generated by Xtext 2.29.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Json Array Client</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.JsonArrayClient#getValues <em>Values</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getJsonArrayClient()
 * @model
 * @generated
 */
public interface JsonArrayClient extends JsonValueClient
{
  /**
   * Returns the value of the '<em><b>Values</b></em>' containment reference list.
   * The list contents are of type {@link de.acegen.aceGen.JsonValueClient}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Values</em>' containment reference list.
   * @see de.acegen.aceGen.AceGenPackage#getJsonArrayClient_Values()
   * @model containment="true"
   * @generated
   */
  EList<JsonValueClient> getValues();

} // JsonArrayClient
