/**
 * generated by Xtext 2.27.0
 */
package de.acegen.aceGen.impl;

import de.acegen.aceGen.AceGenPackage;
import de.acegen.aceGen.HttpClient;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.Project;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.impl.ProjectImpl#getHttpClient <em>Http Client</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.ProjectImpl#getHttpServer <em>Http Server</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProjectImpl extends MinimalEObjectImpl.Container implements Project
{
  /**
   * The cached value of the '{@link #getHttpClient() <em>Http Client</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHttpClient()
   * @generated
   * @ordered
   */
  protected HttpClient httpClient;

  /**
   * The cached value of the '{@link #getHttpServer() <em>Http Server</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHttpServer()
   * @generated
   * @ordered
   */
  protected HttpServer httpServer;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ProjectImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return AceGenPackage.Literals.PROJECT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public HttpClient getHttpClient()
  {
    return httpClient;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetHttpClient(HttpClient newHttpClient, NotificationChain msgs)
  {
    HttpClient oldHttpClient = httpClient;
    httpClient = newHttpClient;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AceGenPackage.PROJECT__HTTP_CLIENT, oldHttpClient, newHttpClient);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setHttpClient(HttpClient newHttpClient)
  {
    if (newHttpClient != httpClient)
    {
      NotificationChain msgs = null;
      if (httpClient != null)
        msgs = ((InternalEObject)httpClient).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AceGenPackage.PROJECT__HTTP_CLIENT, null, msgs);
      if (newHttpClient != null)
        msgs = ((InternalEObject)newHttpClient).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AceGenPackage.PROJECT__HTTP_CLIENT, null, msgs);
      msgs = basicSetHttpClient(newHttpClient, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.PROJECT__HTTP_CLIENT, newHttpClient, newHttpClient));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public HttpServer getHttpServer()
  {
    return httpServer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetHttpServer(HttpServer newHttpServer, NotificationChain msgs)
  {
    HttpServer oldHttpServer = httpServer;
    httpServer = newHttpServer;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AceGenPackage.PROJECT__HTTP_SERVER, oldHttpServer, newHttpServer);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setHttpServer(HttpServer newHttpServer)
  {
    if (newHttpServer != httpServer)
    {
      NotificationChain msgs = null;
      if (httpServer != null)
        msgs = ((InternalEObject)httpServer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AceGenPackage.PROJECT__HTTP_SERVER, null, msgs);
      if (newHttpServer != null)
        msgs = ((InternalEObject)newHttpServer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AceGenPackage.PROJECT__HTTP_SERVER, null, msgs);
      msgs = basicSetHttpServer(newHttpServer, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.PROJECT__HTTP_SERVER, newHttpServer, newHttpServer));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case AceGenPackage.PROJECT__HTTP_CLIENT:
        return basicSetHttpClient(null, msgs);
      case AceGenPackage.PROJECT__HTTP_SERVER:
        return basicSetHttpServer(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case AceGenPackage.PROJECT__HTTP_CLIENT:
        return getHttpClient();
      case AceGenPackage.PROJECT__HTTP_SERVER:
        return getHttpServer();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case AceGenPackage.PROJECT__HTTP_CLIENT:
        setHttpClient((HttpClient)newValue);
        return;
      case AceGenPackage.PROJECT__HTTP_SERVER:
        setHttpServer((HttpServer)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case AceGenPackage.PROJECT__HTTP_CLIENT:
        setHttpClient((HttpClient)null);
        return;
      case AceGenPackage.PROJECT__HTTP_SERVER:
        setHttpServer((HttpServer)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case AceGenPackage.PROJECT__HTTP_CLIENT:
        return httpClient != null;
      case AceGenPackage.PROJECT__HTTP_SERVER:
        return httpServer != null;
    }
    return super.eIsSet(featureID);
  }

} //ProjectImpl
