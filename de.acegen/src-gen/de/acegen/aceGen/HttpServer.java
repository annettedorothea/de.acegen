/**
 * generated by Xtext 2.26.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Http Server</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.HttpServer#getLanguage <em>Language</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpServer#getType <em>Type</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpServer#getPersistenceLayer <em>Persistence Layer</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpServer#getMigrations <em>Migrations</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpServer#getName <em>Name</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpServer#getAuthUser <em>Auth User</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpServer#getAuthUserRef <em>Auth User Ref</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpServer#getAceOperations <em>Ace Operations</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpServer#getViews <em>Views</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpServer#getModels <em>Models</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpServer#getScenarios <em>Scenarios</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getHttpServer()
 * @model
 * @generated
 */
public interface HttpServer extends EObject
{
  /**
   * Returns the value of the '<em><b>Language</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Language</em>' attribute.
   * @see #setLanguage(String)
   * @see de.acegen.aceGen.AceGenPackage#getHttpServer_Language()
   * @model
   * @generated
   */
  String getLanguage();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.HttpServer#getLanguage <em>Language</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Language</em>' attribute.
   * @see #getLanguage()
   * @generated
   */
  void setLanguage(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see #setType(String)
   * @see de.acegen.aceGen.AceGenPackage#getHttpServer_Type()
   * @model
   * @generated
   */
  String getType();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.HttpServer#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

  /**
   * Returns the value of the '<em><b>Persistence Layer</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Persistence Layer</em>' attribute.
   * @see #setPersistenceLayer(String)
   * @see de.acegen.aceGen.AceGenPackage#getHttpServer_PersistenceLayer()
   * @model
   * @generated
   */
  String getPersistenceLayer();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.HttpServer#getPersistenceLayer <em>Persistence Layer</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Persistence Layer</em>' attribute.
   * @see #getPersistenceLayer()
   * @generated
   */
  void setPersistenceLayer(String value);

  /**
   * Returns the value of the '<em><b>Migrations</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Migrations</em>' attribute.
   * @see #setMigrations(String)
   * @see de.acegen.aceGen.AceGenPackage#getHttpServer_Migrations()
   * @model
   * @generated
   */
  String getMigrations();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.HttpServer#getMigrations <em>Migrations</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Migrations</em>' attribute.
   * @see #getMigrations()
   * @generated
   */
  void setMigrations(String value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see de.acegen.aceGen.AceGenPackage#getHttpServer_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.HttpServer#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Auth User</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Auth User</em>' containment reference.
   * @see #setAuthUser(AuthUser)
   * @see de.acegen.aceGen.AceGenPackage#getHttpServer_AuthUser()
   * @model containment="true"
   * @generated
   */
  AuthUser getAuthUser();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.HttpServer#getAuthUser <em>Auth User</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Auth User</em>' containment reference.
   * @see #getAuthUser()
   * @generated
   */
  void setAuthUser(AuthUser value);

  /**
   * Returns the value of the '<em><b>Auth User Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Auth User Ref</em>' reference.
   * @see #setAuthUserRef(AuthUser)
   * @see de.acegen.aceGen.AceGenPackage#getHttpServer_AuthUserRef()
   * @model
   * @generated
   */
  AuthUser getAuthUserRef();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.HttpServer#getAuthUserRef <em>Auth User Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Auth User Ref</em>' reference.
   * @see #getAuthUserRef()
   * @generated
   */
  void setAuthUserRef(AuthUser value);

  /**
   * Returns the value of the '<em><b>Ace Operations</b></em>' containment reference list.
   * The list contents are of type {@link de.acegen.aceGen.HttpServerAce}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ace Operations</em>' containment reference list.
   * @see de.acegen.aceGen.AceGenPackage#getHttpServer_AceOperations()
   * @model containment="true"
   * @generated
   */
  EList<HttpServerAce> getAceOperations();

  /**
   * Returns the value of the '<em><b>Views</b></em>' containment reference list.
   * The list contents are of type {@link de.acegen.aceGen.HttpServerView}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Views</em>' containment reference list.
   * @see de.acegen.aceGen.AceGenPackage#getHttpServer_Views()
   * @model containment="true"
   * @generated
   */
  EList<HttpServerView> getViews();

  /**
   * Returns the value of the '<em><b>Models</b></em>' containment reference list.
   * The list contents are of type {@link de.acegen.aceGen.Model}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Models</em>' containment reference list.
   * @see de.acegen.aceGen.AceGenPackage#getHttpServer_Models()
   * @model containment="true"
   * @generated
   */
  EList<Model> getModels();

  /**
   * Returns the value of the '<em><b>Scenarios</b></em>' containment reference list.
   * The list contents are of type {@link de.acegen.aceGen.Scenario}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Scenarios</em>' containment reference list.
   * @see de.acegen.aceGen.AceGenPackage#getHttpServer_Scenarios()
   * @model containment="true"
   * @generated
   */
  EList<Scenario> getScenarios();

} // HttpServer
