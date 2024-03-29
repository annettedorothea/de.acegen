/**
 * generated by Xtext 2.29.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Http Server Ace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.HttpServerAce#getName <em>Name</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpServerAce#getModel <em>Model</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpServerAce#getType <em>Type</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpServerAce#getUrl <em>Url</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpServerAce#isAuthorize <em>Authorize</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpServerAce#getPathParams <em>Path Params</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpServerAce#getQueryParams <em>Query Params</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpServerAce#getPayload <em>Payload</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpServerAce#getResponse <em>Response</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getHttpServerAce()
 * @model
 * @generated
 */
public interface HttpServerAce extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see de.acegen.aceGen.AceGenPackage#getHttpServerAce_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.HttpServerAce#getName <em>Name</em>}' attribute.
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
   * @see de.acegen.aceGen.AceGenPackage#getHttpServerAce_Model()
   * @model
   * @generated
   */
  Model getModel();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.HttpServerAce#getModel <em>Model</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Model</em>' reference.
   * @see #getModel()
   * @generated
   */
  void setModel(Model value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see #setType(String)
   * @see de.acegen.aceGen.AceGenPackage#getHttpServerAce_Type()
   * @model
   * @generated
   */
  String getType();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.HttpServerAce#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

  /**
   * Returns the value of the '<em><b>Url</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Url</em>' attribute.
   * @see #setUrl(String)
   * @see de.acegen.aceGen.AceGenPackage#getHttpServerAce_Url()
   * @model
   * @generated
   */
  String getUrl();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.HttpServerAce#getUrl <em>Url</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Url</em>' attribute.
   * @see #getUrl()
   * @generated
   */
  void setUrl(String value);

  /**
   * Returns the value of the '<em><b>Authorize</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Authorize</em>' attribute.
   * @see #setAuthorize(boolean)
   * @see de.acegen.aceGen.AceGenPackage#getHttpServerAce_Authorize()
   * @model
   * @generated
   */
  boolean isAuthorize();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.HttpServerAce#isAuthorize <em>Authorize</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Authorize</em>' attribute.
   * @see #isAuthorize()
   * @generated
   */
  void setAuthorize(boolean value);

  /**
   * Returns the value of the '<em><b>Path Params</b></em>' containment reference list.
   * The list contents are of type {@link de.acegen.aceGen.AttributeParamRef}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Path Params</em>' containment reference list.
   * @see de.acegen.aceGen.AceGenPackage#getHttpServerAce_PathParams()
   * @model containment="true"
   * @generated
   */
  EList<AttributeParamRef> getPathParams();

  /**
   * Returns the value of the '<em><b>Query Params</b></em>' containment reference list.
   * The list contents are of type {@link de.acegen.aceGen.AttributeParamRef}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Query Params</em>' containment reference list.
   * @see de.acegen.aceGen.AceGenPackage#getHttpServerAce_QueryParams()
   * @model containment="true"
   * @generated
   */
  EList<AttributeParamRef> getQueryParams();

  /**
   * Returns the value of the '<em><b>Payload</b></em>' containment reference list.
   * The list contents are of type {@link de.acegen.aceGen.AttributeParamRef}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Payload</em>' containment reference list.
   * @see de.acegen.aceGen.AceGenPackage#getHttpServerAce_Payload()
   * @model containment="true"
   * @generated
   */
  EList<AttributeParamRef> getPayload();

  /**
   * Returns the value of the '<em><b>Response</b></em>' reference list.
   * The list contents are of type {@link de.acegen.aceGen.Attribute}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Response</em>' reference list.
   * @see de.acegen.aceGen.AceGenPackage#getHttpServerAce_Response()
   * @model
   * @generated
   */
  EList<Attribute> getResponse();

} // HttpServerAce
