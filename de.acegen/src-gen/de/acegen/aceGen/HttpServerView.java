/**
 * generated by Xtext 2.26.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Http Server View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.HttpServerView#isAfterCommit <em>After Commit</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpServerView#getName <em>Name</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpServerView#getRenderFunctions <em>Render Functions</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getHttpServerView()
 * @model
 * @generated
 */
public interface HttpServerView extends EObject
{
  /**
   * Returns the value of the '<em><b>After Commit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>After Commit</em>' attribute.
   * @see #setAfterCommit(boolean)
   * @see de.acegen.aceGen.AceGenPackage#getHttpServerView_AfterCommit()
   * @model
   * @generated
   */
  boolean isAfterCommit();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.HttpServerView#isAfterCommit <em>After Commit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>After Commit</em>' attribute.
   * @see #isAfterCommit()
   * @generated
   */
  void setAfterCommit(boolean value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see de.acegen.aceGen.AceGenPackage#getHttpServerView_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.HttpServerView#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Render Functions</b></em>' containment reference list.
   * The list contents are of type {@link de.acegen.aceGen.HttpServerViewFunction}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Render Functions</em>' containment reference list.
   * @see de.acegen.aceGen.AceGenPackage#getHttpServerView_RenderFunctions()
   * @model containment="true"
   * @generated
   */
  EList<HttpServerViewFunction> getRenderFunctions();

} // HttpServerView
