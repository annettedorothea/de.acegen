/**
 * generated by Xtext 2.27.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.DataDefinition#getUuid <em>Uuid</em>}</li>
 *   <li>{@link de.acegen.aceGen.DataDefinition#getSystemtime <em>Systemtime</em>}</li>
 *   <li>{@link de.acegen.aceGen.DataDefinition#getPattern <em>Pattern</em>}</li>
 *   <li>{@link de.acegen.aceGen.DataDefinition#getData <em>Data</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getDataDefinition()
 * @model
 * @generated
 */
public interface DataDefinition extends EObject
{
  /**
   * Returns the value of the '<em><b>Uuid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Uuid</em>' attribute.
   * @see #setUuid(String)
   * @see de.acegen.aceGen.AceGenPackage#getDataDefinition_Uuid()
   * @model
   * @generated
   */
  String getUuid();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.DataDefinition#getUuid <em>Uuid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Uuid</em>' attribute.
   * @see #getUuid()
   * @generated
   */
  void setUuid(String value);

  /**
   * Returns the value of the '<em><b>Systemtime</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Systemtime</em>' attribute.
   * @see #setSystemtime(String)
   * @see de.acegen.aceGen.AceGenPackage#getDataDefinition_Systemtime()
   * @model
   * @generated
   */
  String getSystemtime();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.DataDefinition#getSystemtime <em>Systemtime</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Systemtime</em>' attribute.
   * @see #getSystemtime()
   * @generated
   */
  void setSystemtime(String value);

  /**
   * Returns the value of the '<em><b>Pattern</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pattern</em>' attribute.
   * @see #setPattern(String)
   * @see de.acegen.aceGen.AceGenPackage#getDataDefinition_Pattern()
   * @model
   * @generated
   */
  String getPattern();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.DataDefinition#getPattern <em>Pattern</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pattern</em>' attribute.
   * @see #getPattern()
   * @generated
   */
  void setPattern(String value);

  /**
   * Returns the value of the '<em><b>Data</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Data</em>' containment reference.
   * @see #setData(JsonObject)
   * @see de.acegen.aceGen.AceGenPackage#getDataDefinition_Data()
   * @model containment="true"
   * @generated
   */
  JsonObject getData();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.DataDefinition#getData <em>Data</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Data</em>' containment reference.
   * @see #getData()
   * @generated
   */
  void setData(JsonObject value);

} // DataDefinition
