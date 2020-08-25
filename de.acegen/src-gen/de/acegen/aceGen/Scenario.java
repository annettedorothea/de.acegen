/**
 * generated by Xtext 2.22.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scenario</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.Scenario#getName <em>Name</em>}</li>
 *   <li>{@link de.acegen.aceGen.Scenario#getGivenItems <em>Given Items</em>}</li>
 *   <li>{@link de.acegen.aceGen.Scenario#getWhenBlock <em>When Block</em>}</li>
 *   <li>{@link de.acegen.aceGen.Scenario#getThenBlock <em>Then Block</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getScenario()
 * @model
 * @generated
 */
public interface Scenario extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see de.acegen.aceGen.AceGenPackage#getScenario_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.Scenario#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Given Items</b></em>' containment reference list.
   * The list contents are of type {@link de.acegen.aceGen.Given}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Given Items</em>' containment reference list.
   * @see de.acegen.aceGen.AceGenPackage#getScenario_GivenItems()
   * @model containment="true"
   * @generated
   */
  EList<Given> getGivenItems();

  /**
   * Returns the value of the '<em><b>When Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>When Block</em>' containment reference.
   * @see #setWhenBlock(WhenBlock)
   * @see de.acegen.aceGen.AceGenPackage#getScenario_WhenBlock()
   * @model containment="true"
   * @generated
   */
  WhenBlock getWhenBlock();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.Scenario#getWhenBlock <em>When Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>When Block</em>' containment reference.
   * @see #getWhenBlock()
   * @generated
   */
  void setWhenBlock(WhenBlock value);

  /**
   * Returns the value of the '<em><b>Then Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Then Block</em>' containment reference.
   * @see #setThenBlock(ThenBlock)
   * @see de.acegen.aceGen.AceGenPackage#getScenario_ThenBlock()
   * @model containment="true"
   * @generated
   */
  ThenBlock getThenBlock();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.Scenario#getThenBlock <em>Then Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Then Block</em>' containment reference.
   * @see #getThenBlock()
   * @generated
   */
  void setThenBlock(ThenBlock value);

} // Scenario
