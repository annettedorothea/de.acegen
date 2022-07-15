/**
 * generated by Xtext 2.27.0
 */
package de.acegen.aceGen.impl;

import de.acegen.aceGen.AceGenPackage;
import de.acegen.aceGen.HttpClientAce;
import de.acegen.aceGen.TriggerdAceOperation;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Triggerd Ace Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.impl.TriggerdAceOperationImpl#getDelay <em>Delay</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.TriggerdAceOperationImpl#isTakeLatest <em>Take Latest</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.TriggerdAceOperationImpl#getAceOperation <em>Ace Operation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TriggerdAceOperationImpl extends MinimalEObjectImpl.Container implements TriggerdAceOperation
{
  /**
   * The default value of the '{@link #getDelay() <em>Delay</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDelay()
   * @generated
   * @ordered
   */
  protected static final int DELAY_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getDelay() <em>Delay</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDelay()
   * @generated
   * @ordered
   */
  protected int delay = DELAY_EDEFAULT;

  /**
   * The default value of the '{@link #isTakeLatest() <em>Take Latest</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isTakeLatest()
   * @generated
   * @ordered
   */
  protected static final boolean TAKE_LATEST_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isTakeLatest() <em>Take Latest</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isTakeLatest()
   * @generated
   * @ordered
   */
  protected boolean takeLatest = TAKE_LATEST_EDEFAULT;

  /**
   * The cached value of the '{@link #getAceOperation() <em>Ace Operation</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAceOperation()
   * @generated
   * @ordered
   */
  protected HttpClientAce aceOperation;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TriggerdAceOperationImpl()
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
    return AceGenPackage.Literals.TRIGGERD_ACE_OPERATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getDelay()
  {
    return delay;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDelay(int newDelay)
  {
    int oldDelay = delay;
    delay = newDelay;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.TRIGGERD_ACE_OPERATION__DELAY, oldDelay, delay));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isTakeLatest()
  {
    return takeLatest;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setTakeLatest(boolean newTakeLatest)
  {
    boolean oldTakeLatest = takeLatest;
    takeLatest = newTakeLatest;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.TRIGGERD_ACE_OPERATION__TAKE_LATEST, oldTakeLatest, takeLatest));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public HttpClientAce getAceOperation()
  {
    if (aceOperation != null && aceOperation.eIsProxy())
    {
      InternalEObject oldAceOperation = (InternalEObject)aceOperation;
      aceOperation = (HttpClientAce)eResolveProxy(oldAceOperation);
      if (aceOperation != oldAceOperation)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AceGenPackage.TRIGGERD_ACE_OPERATION__ACE_OPERATION, oldAceOperation, aceOperation));
      }
    }
    return aceOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HttpClientAce basicGetAceOperation()
  {
    return aceOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAceOperation(HttpClientAce newAceOperation)
  {
    HttpClientAce oldAceOperation = aceOperation;
    aceOperation = newAceOperation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.TRIGGERD_ACE_OPERATION__ACE_OPERATION, oldAceOperation, aceOperation));
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
      case AceGenPackage.TRIGGERD_ACE_OPERATION__DELAY:
        return getDelay();
      case AceGenPackage.TRIGGERD_ACE_OPERATION__TAKE_LATEST:
        return isTakeLatest();
      case AceGenPackage.TRIGGERD_ACE_OPERATION__ACE_OPERATION:
        if (resolve) return getAceOperation();
        return basicGetAceOperation();
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
      case AceGenPackage.TRIGGERD_ACE_OPERATION__DELAY:
        setDelay((Integer)newValue);
        return;
      case AceGenPackage.TRIGGERD_ACE_OPERATION__TAKE_LATEST:
        setTakeLatest((Boolean)newValue);
        return;
      case AceGenPackage.TRIGGERD_ACE_OPERATION__ACE_OPERATION:
        setAceOperation((HttpClientAce)newValue);
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
      case AceGenPackage.TRIGGERD_ACE_OPERATION__DELAY:
        setDelay(DELAY_EDEFAULT);
        return;
      case AceGenPackage.TRIGGERD_ACE_OPERATION__TAKE_LATEST:
        setTakeLatest(TAKE_LATEST_EDEFAULT);
        return;
      case AceGenPackage.TRIGGERD_ACE_OPERATION__ACE_OPERATION:
        setAceOperation((HttpClientAce)null);
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
      case AceGenPackage.TRIGGERD_ACE_OPERATION__DELAY:
        return delay != DELAY_EDEFAULT;
      case AceGenPackage.TRIGGERD_ACE_OPERATION__TAKE_LATEST:
        return takeLatest != TAKE_LATEST_EDEFAULT;
      case AceGenPackage.TRIGGERD_ACE_OPERATION__ACE_OPERATION:
        return aceOperation != null;
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
    result.append(" (delay: ");
    result.append(delay);
    result.append(", takeLatest: ");
    result.append(takeLatest);
    result.append(')');
    return result.toString();
  }

} //TriggerdAceOperationImpl
