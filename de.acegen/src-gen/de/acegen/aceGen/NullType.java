/**
 * generated by Xtext 2.22.0
 */
package de.acegen.aceGen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Null Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.NullType#isNull <em>Null</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getNullType()
 * @model
 * @generated
 */
public interface NullType extends JsonValueClient, JsonValue
{
  /**
   * Returns the value of the '<em><b>Null</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Null</em>' attribute.
   * @see #setNull(boolean)
   * @see de.acegen.aceGen.AceGenPackage#getNullType_Null()
   * @model
   * @generated
   */
  boolean isNull();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.NullType#isNull <em>Null</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Null</em>' attribute.
   * @see #isNull()
   * @generated
   */
  void setNull(boolean value);

} // NullType