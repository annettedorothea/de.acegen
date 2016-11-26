/**
 * generated by Xtext 2.10.0
 */
package com.anfelisa.ace;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.anfelisa.ace.Data#getName <em>Name</em>}</li>
 *   <li>{@link com.anfelisa.ace.Data#getModels <em>Models</em>}</li>
 *   <li>{@link com.anfelisa.ace.Data#getDataLists <em>Data Lists</em>}</li>
 * </ul>
 *
 * @see com.anfelisa.ace.AcePackage#getData()
 * @model
 * @generated
 */
public interface Data extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.anfelisa.ace.AcePackage#getData_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.anfelisa.ace.Data#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Models</b></em>' containment reference list.
   * The list contents are of type {@link com.anfelisa.ace.ModelRef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Models</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Models</em>' containment reference list.
   * @see com.anfelisa.ace.AcePackage#getData_Models()
   * @model containment="true"
   * @generated
   */
  EList<ModelRef> getModels();

  /**
   * Returns the value of the '<em><b>Data Lists</b></em>' containment reference list.
   * The list contents are of type {@link com.anfelisa.ace.DataRef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Data Lists</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Data Lists</em>' containment reference list.
   * @see com.anfelisa.ace.AcePackage#getData_DataLists()
   * @model containment="true"
   * @generated
   */
  EList<DataRef> getDataLists();

} // Data
