/**
 * generated by Xtext 2.21.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.PrimitiveValue#getString <em>String</em>}</li>
 *   <li>{@link de.acegen.aceGen.PrimitiveValue#getLong <em>Long</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getPrimitiveValue()
 * @model
 * @generated
 */
public interface PrimitiveValue extends EObject
{
  /**
   * Returns the value of the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>String</em>' attribute.
   * @see #setString(String)
   * @see de.acegen.aceGen.AceGenPackage#getPrimitiveValue_String()
   * @model
   * @generated
   */
  String getString();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.PrimitiveValue#getString <em>String</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>String</em>' attribute.
   * @see #getString()
   * @generated
   */
  void setString(String value);

  /**
   * Returns the value of the '<em><b>Long</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Long</em>' attribute.
   * @see #setLong(int)
   * @see de.acegen.aceGen.AceGenPackage#getPrimitiveValue_Long()
   * @model
   * @generated
   */
  int getLong();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.PrimitiveValue#getLong <em>Long</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Long</em>' attribute.
   * @see #getLong()
   * @generated
   */
  void setLong(int value);

} // PrimitiveValue
