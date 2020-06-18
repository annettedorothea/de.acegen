/**
 * generated by Xtext 2.21.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Param Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.AttributeParamRef#isNotNull <em>Not Null</em>}</li>
 *   <li>{@link de.acegen.aceGen.AttributeParamRef#getAttribute <em>Attribute</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getAttributeParamRef()
 * @model
 * @generated
 */
public interface AttributeParamRef extends EObject
{
  /**
   * Returns the value of the '<em><b>Not Null</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Not Null</em>' attribute.
   * @see #setNotNull(boolean)
   * @see de.acegen.aceGen.AceGenPackage#getAttributeParamRef_NotNull()
   * @model
   * @generated
   */
  boolean isNotNull();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.AttributeParamRef#isNotNull <em>Not Null</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Not Null</em>' attribute.
   * @see #isNotNull()
   * @generated
   */
  void setNotNull(boolean value);

  /**
   * Returns the value of the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attribute</em>' reference.
   * @see #setAttribute(Attribute)
   * @see de.acegen.aceGen.AceGenPackage#getAttributeParamRef_Attribute()
   * @model
   * @generated
   */
  Attribute getAttribute();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.AttributeParamRef#getAttribute <em>Attribute</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Attribute</em>' reference.
   * @see #getAttribute()
   * @generated
   */
  void setAttribute(Attribute value);

} // AttributeParamRef
