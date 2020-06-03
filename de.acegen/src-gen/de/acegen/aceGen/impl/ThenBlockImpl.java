/**
 * generated by Xtext 2.21.0
 */
package de.acegen.aceGen.impl;

import de.acegen.aceGen.AceGenPackage;
import de.acegen.aceGen.DataDefinition;
import de.acegen.aceGen.PersistenceVerification;
import de.acegen.aceGen.ThenBlock;
import de.acegen.aceGen.Verification;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Then Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.impl.ThenBlockImpl#getStatusCode <em>Status Code</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.ThenBlockImpl#getResponse <em>Response</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.ThenBlockImpl#getPersistenceVerifications <em>Persistence Verifications</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.ThenBlockImpl#getVerifications <em>Verifications</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ThenBlockImpl extends MinimalEObjectImpl.Container implements ThenBlock
{
  /**
   * The default value of the '{@link #getStatusCode() <em>Status Code</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatusCode()
   * @generated
   * @ordered
   */
  protected static final int STATUS_CODE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getStatusCode() <em>Status Code</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatusCode()
   * @generated
   * @ordered
   */
  protected int statusCode = STATUS_CODE_EDEFAULT;

  /**
   * The cached value of the '{@link #getResponse() <em>Response</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResponse()
   * @generated
   * @ordered
   */
  protected DataDefinition response;

  /**
   * The cached value of the '{@link #getPersistenceVerifications() <em>Persistence Verifications</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPersistenceVerifications()
   * @generated
   * @ordered
   */
  protected EList<PersistenceVerification> persistenceVerifications;

  /**
   * The cached value of the '{@link #getVerifications() <em>Verifications</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVerifications()
   * @generated
   * @ordered
   */
  protected EList<Verification> verifications;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ThenBlockImpl()
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
    return AceGenPackage.Literals.THEN_BLOCK;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getStatusCode()
  {
    return statusCode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setStatusCode(int newStatusCode)
  {
    int oldStatusCode = statusCode;
    statusCode = newStatusCode;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.THEN_BLOCK__STATUS_CODE, oldStatusCode, statusCode));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DataDefinition getResponse()
  {
    return response;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetResponse(DataDefinition newResponse, NotificationChain msgs)
  {
    DataDefinition oldResponse = response;
    response = newResponse;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AceGenPackage.THEN_BLOCK__RESPONSE, oldResponse, newResponse);
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
  public void setResponse(DataDefinition newResponse)
  {
    if (newResponse != response)
    {
      NotificationChain msgs = null;
      if (response != null)
        msgs = ((InternalEObject)response).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AceGenPackage.THEN_BLOCK__RESPONSE, null, msgs);
      if (newResponse != null)
        msgs = ((InternalEObject)newResponse).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AceGenPackage.THEN_BLOCK__RESPONSE, null, msgs);
      msgs = basicSetResponse(newResponse, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.THEN_BLOCK__RESPONSE, newResponse, newResponse));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<PersistenceVerification> getPersistenceVerifications()
  {
    if (persistenceVerifications == null)
    {
      persistenceVerifications = new EObjectContainmentEList<PersistenceVerification>(PersistenceVerification.class, this, AceGenPackage.THEN_BLOCK__PERSISTENCE_VERIFICATIONS);
    }
    return persistenceVerifications;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Verification> getVerifications()
  {
    if (verifications == null)
    {
      verifications = new EObjectContainmentEList<Verification>(Verification.class, this, AceGenPackage.THEN_BLOCK__VERIFICATIONS);
    }
    return verifications;
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
      case AceGenPackage.THEN_BLOCK__RESPONSE:
        return basicSetResponse(null, msgs);
      case AceGenPackage.THEN_BLOCK__PERSISTENCE_VERIFICATIONS:
        return ((InternalEList<?>)getPersistenceVerifications()).basicRemove(otherEnd, msgs);
      case AceGenPackage.THEN_BLOCK__VERIFICATIONS:
        return ((InternalEList<?>)getVerifications()).basicRemove(otherEnd, msgs);
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
      case AceGenPackage.THEN_BLOCK__STATUS_CODE:
        return getStatusCode();
      case AceGenPackage.THEN_BLOCK__RESPONSE:
        return getResponse();
      case AceGenPackage.THEN_BLOCK__PERSISTENCE_VERIFICATIONS:
        return getPersistenceVerifications();
      case AceGenPackage.THEN_BLOCK__VERIFICATIONS:
        return getVerifications();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case AceGenPackage.THEN_BLOCK__STATUS_CODE:
        setStatusCode((Integer)newValue);
        return;
      case AceGenPackage.THEN_BLOCK__RESPONSE:
        setResponse((DataDefinition)newValue);
        return;
      case AceGenPackage.THEN_BLOCK__PERSISTENCE_VERIFICATIONS:
        getPersistenceVerifications().clear();
        getPersistenceVerifications().addAll((Collection<? extends PersistenceVerification>)newValue);
        return;
      case AceGenPackage.THEN_BLOCK__VERIFICATIONS:
        getVerifications().clear();
        getVerifications().addAll((Collection<? extends Verification>)newValue);
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
      case AceGenPackage.THEN_BLOCK__STATUS_CODE:
        setStatusCode(STATUS_CODE_EDEFAULT);
        return;
      case AceGenPackage.THEN_BLOCK__RESPONSE:
        setResponse((DataDefinition)null);
        return;
      case AceGenPackage.THEN_BLOCK__PERSISTENCE_VERIFICATIONS:
        getPersistenceVerifications().clear();
        return;
      case AceGenPackage.THEN_BLOCK__VERIFICATIONS:
        getVerifications().clear();
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
      case AceGenPackage.THEN_BLOCK__STATUS_CODE:
        return statusCode != STATUS_CODE_EDEFAULT;
      case AceGenPackage.THEN_BLOCK__RESPONSE:
        return response != null;
      case AceGenPackage.THEN_BLOCK__PERSISTENCE_VERIFICATIONS:
        return persistenceVerifications != null && !persistenceVerifications.isEmpty();
      case AceGenPackage.THEN_BLOCK__VERIFICATIONS:
        return verifications != null && !verifications.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (statusCode: ");
    result.append(statusCode);
    result.append(')');
    return result.toString();
  }

} //ThenBlockImpl
