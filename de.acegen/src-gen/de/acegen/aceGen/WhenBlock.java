/**
 * generated by Xtext 2.23.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>When Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.WhenBlock#getAction <em>Action</em>}</li>
 *   <li>{@link de.acegen.aceGen.WhenBlock#getDataDefinition <em>Data Definition</em>}</li>
 *   <li>{@link de.acegen.aceGen.WhenBlock#getAuthorization <em>Authorization</em>}</li>
 *   <li>{@link de.acegen.aceGen.WhenBlock#getExtractions <em>Extractions</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getWhenBlock()
 * @model
 * @generated
 */
public interface WhenBlock extends EObject
{
  /**
   * Returns the value of the '<em><b>Action</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Action</em>' reference.
   * @see #setAction(HttpServerAce)
   * @see de.acegen.aceGen.AceGenPackage#getWhenBlock_Action()
   * @model
   * @generated
   */
  HttpServerAce getAction();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.WhenBlock#getAction <em>Action</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Action</em>' reference.
   * @see #getAction()
   * @generated
   */
  void setAction(HttpServerAce value);

  /**
   * Returns the value of the '<em><b>Data Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Data Definition</em>' containment reference.
   * @see #setDataDefinition(DataDefinition)
   * @see de.acegen.aceGen.AceGenPackage#getWhenBlock_DataDefinition()
   * @model containment="true"
   * @generated
   */
  DataDefinition getDataDefinition();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.WhenBlock#getDataDefinition <em>Data Definition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Data Definition</em>' containment reference.
   * @see #getDataDefinition()
   * @generated
   */
  void setDataDefinition(DataDefinition value);

  /**
   * Returns the value of the '<em><b>Authorization</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Authorization</em>' containment reference.
   * @see #setAuthorization(Authorization)
   * @see de.acegen.aceGen.AceGenPackage#getWhenBlock_Authorization()
   * @model containment="true"
   * @generated
   */
  Authorization getAuthorization();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.WhenBlock#getAuthorization <em>Authorization</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Authorization</em>' containment reference.
   * @see #getAuthorization()
   * @generated
   */
  void setAuthorization(Authorization value);

  /**
   * Returns the value of the '<em><b>Extractions</b></em>' containment reference list.
   * The list contents are of type {@link de.acegen.aceGen.Extraction}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extractions</em>' containment reference list.
   * @see de.acegen.aceGen.AceGenPackage#getWhenBlock_Extractions()
   * @model containment="true"
   * @generated
   */
  EList<Extraction> getExtractions();

} // WhenBlock
