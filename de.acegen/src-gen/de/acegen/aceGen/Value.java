/**
 * generated by Xtext 2.20.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.Value#getStringValue <em>String Value</em>}</li>
 *   <li>{@link de.acegen.aceGen.Value#getIntValue <em>Int Value</em>}</li>
 *   <li>{@link de.acegen.aceGen.Value#getDateValue <em>Date Value</em>}</li>
 *   <li>{@link de.acegen.aceGen.Value#getPattern <em>Pattern</em>}</li>
 *   <li>{@link de.acegen.aceGen.Value#getAttributeDefinitionList <em>Attribute Definition List</em>}</li>
 *   <li>{@link de.acegen.aceGen.Value#getListAttributeDefinitionList <em>List Attribute Definition List</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getValue()
 * @model
 * @generated
 */
public interface Value extends EObject
{
  /**
   * Returns the value of the '<em><b>String Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>String Value</em>' attribute.
   * @see #setStringValue(String)
   * @see de.acegen.aceGen.AceGenPackage#getValue_StringValue()
   * @model
   * @generated
   */
  String getStringValue();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.Value#getStringValue <em>String Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>String Value</em>' attribute.
   * @see #getStringValue()
   * @generated
   */
  void setStringValue(String value);

  /**
   * Returns the value of the '<em><b>Int Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Int Value</em>' attribute.
   * @see #setIntValue(int)
   * @see de.acegen.aceGen.AceGenPackage#getValue_IntValue()
   * @model
   * @generated
   */
  int getIntValue();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.Value#getIntValue <em>Int Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Int Value</em>' attribute.
   * @see #getIntValue()
   * @generated
   */
  void setIntValue(int value);

  /**
   * Returns the value of the '<em><b>Date Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Date Value</em>' attribute.
   * @see #setDateValue(String)
   * @see de.acegen.aceGen.AceGenPackage#getValue_DateValue()
   * @model
   * @generated
   */
  String getDateValue();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.Value#getDateValue <em>Date Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Date Value</em>' attribute.
   * @see #getDateValue()
   * @generated
   */
  void setDateValue(String value);

  /**
   * Returns the value of the '<em><b>Pattern</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pattern</em>' attribute.
   * @see #setPattern(String)
   * @see de.acegen.aceGen.AceGenPackage#getValue_Pattern()
   * @model
   * @generated
   */
  String getPattern();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.Value#getPattern <em>Pattern</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pattern</em>' attribute.
   * @see #getPattern()
   * @generated
   */
  void setPattern(String value);

  /**
   * Returns the value of the '<em><b>Attribute Definition List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attribute Definition List</em>' containment reference.
   * @see #setAttributeDefinitionList(AttributeDefinitionList)
   * @see de.acegen.aceGen.AceGenPackage#getValue_AttributeDefinitionList()
   * @model containment="true"
   * @generated
   */
  AttributeDefinitionList getAttributeDefinitionList();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.Value#getAttributeDefinitionList <em>Attribute Definition List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Attribute Definition List</em>' containment reference.
   * @see #getAttributeDefinitionList()
   * @generated
   */
  void setAttributeDefinitionList(AttributeDefinitionList value);

  /**
   * Returns the value of the '<em><b>List Attribute Definition List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>List Attribute Definition List</em>' containment reference.
   * @see #setListAttributeDefinitionList(ListAttributeDefinitionList)
   * @see de.acegen.aceGen.AceGenPackage#getValue_ListAttributeDefinitionList()
   * @model containment="true"
   * @generated
   */
  ListAttributeDefinitionList getListAttributeDefinitionList();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.Value#getListAttributeDefinitionList <em>List Attribute Definition List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>List Attribute Definition List</em>' containment reference.
   * @see #getListAttributeDefinitionList()
   * @generated
   */
  void setListAttributeDefinitionList(ListAttributeDefinitionList value);

} // Value
