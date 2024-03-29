/**
 * generated by Xtext 2.29.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Http Server View Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.HttpServerViewFunction#getName <em>Name</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpServerViewFunction#getModel <em>Model</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getHttpServerViewFunction()
 * @model
 * @generated
 */
public interface HttpServerViewFunction extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see de.acegen.aceGen.AceGenPackage#getHttpServerViewFunction_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.HttpServerViewFunction#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Model</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Model</em>' reference.
   * @see #setModel(Model)
   * @see de.acegen.aceGen.AceGenPackage#getHttpServerViewFunction_Model()
   * @model
   * @generated
   */
  Model getModel();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.HttpServerViewFunction#getModel <em>Model</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Model</em>' reference.
   * @see #getModel()
   * @generated
   */
  void setModel(Model value);

} // HttpServerViewFunction
