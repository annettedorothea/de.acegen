/**
 * generated by Xtext 2.29.0
 */
package de.acegen.aceGen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.StringType#getString <em>String</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getStringType()
 * @model
 * @generated
 */
public interface StringType extends JsonValueClient, JsonObject
{
  /**
   * Returns the value of the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>String</em>' attribute.
   * @see #setString(String)
   * @see de.acegen.aceGen.AceGenPackage#getStringType_String()
   * @model
   * @generated
   */
  String getString();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.StringType#getString <em>String</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>String</em>' attribute.
   * @see #getString()
   * @generated
   */
  void setString(String value);

} // StringType
