/**
 * generated by Xtext 2.20.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Http Client State Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.HttpClientStateElement#getName <em>Name</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpClientStateElement#isList <em>List</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpClientStateElement#isHash <em>Hash</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpClientStateElement#isStorage <em>Storage</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpClientStateElement#getTypes <em>Types</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getHttpClientStateElement()
 * @model
 * @generated
 */
public interface HttpClientStateElement extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see de.acegen.aceGen.AceGenPackage#getHttpClientStateElement_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.HttpClientStateElement#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>List</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>List</em>' attribute.
   * @see #setList(boolean)
   * @see de.acegen.aceGen.AceGenPackage#getHttpClientStateElement_List()
   * @model
   * @generated
   */
  boolean isList();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.HttpClientStateElement#isList <em>List</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>List</em>' attribute.
   * @see #isList()
   * @generated
   */
  void setList(boolean value);

  /**
   * Returns the value of the '<em><b>Hash</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Hash</em>' attribute.
   * @see #setHash(boolean)
   * @see de.acegen.aceGen.AceGenPackage#getHttpClientStateElement_Hash()
   * @model
   * @generated
   */
  boolean isHash();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.HttpClientStateElement#isHash <em>Hash</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Hash</em>' attribute.
   * @see #isHash()
   * @generated
   */
  void setHash(boolean value);

  /**
   * Returns the value of the '<em><b>Storage</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Storage</em>' attribute.
   * @see #setStorage(boolean)
   * @see de.acegen.aceGen.AceGenPackage#getHttpClientStateElement_Storage()
   * @model
   * @generated
   */
  boolean isStorage();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.HttpClientStateElement#isStorage <em>Storage</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Storage</em>' attribute.
   * @see #isStorage()
   * @generated
   */
  void setStorage(boolean value);

  /**
   * Returns the value of the '<em><b>Types</b></em>' containment reference list.
   * The list contents are of type {@link de.acegen.aceGen.HttpClientTypeDefinition}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Types</em>' containment reference list.
   * @see de.acegen.aceGen.AceGenPackage#getHttpClientStateElement_Types()
   * @model containment="true"
   * @generated
   */
  EList<HttpClientTypeDefinition> getTypes();

} // HttpClientStateElement
