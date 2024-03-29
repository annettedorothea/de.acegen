/**
 * generated by Xtext 2.29.0
 */
package de.acegen.aceGen.impl;

import de.acegen.aceGen.AceGenPackage;
import de.acegen.aceGen.ClientWhenBlock;
import de.acegen.aceGen.HttpClientAce;
import de.acegen.aceGen.InputValue;
import de.acegen.aceGen.SquishyValue;

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
 * An implementation of the model object '<em><b>Client When Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.impl.ClientWhenBlockImpl#getAction <em>Action</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.ClientWhenBlockImpl#getInputValues <em>Input Values</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.ClientWhenBlockImpl#getSquishyValues <em>Squishy Values</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClientWhenBlockImpl extends MinimalEObjectImpl.Container implements ClientWhenBlock
{
  /**
   * The cached value of the '{@link #getAction() <em>Action</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAction()
   * @generated
   * @ordered
   */
  protected HttpClientAce action;

  /**
   * The cached value of the '{@link #getInputValues() <em>Input Values</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInputValues()
   * @generated
   * @ordered
   */
  protected EList<InputValue> inputValues;

  /**
   * The cached value of the '{@link #getSquishyValues() <em>Squishy Values</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSquishyValues()
   * @generated
   * @ordered
   */
  protected EList<SquishyValue> squishyValues;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClientWhenBlockImpl()
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
    return AceGenPackage.Literals.CLIENT_WHEN_BLOCK;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public HttpClientAce getAction()
  {
    if (action != null && action.eIsProxy())
    {
      InternalEObject oldAction = (InternalEObject)action;
      action = (HttpClientAce)eResolveProxy(oldAction);
      if (action != oldAction)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AceGenPackage.CLIENT_WHEN_BLOCK__ACTION, oldAction, action));
      }
    }
    return action;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HttpClientAce basicGetAction()
  {
    return action;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAction(HttpClientAce newAction)
  {
    HttpClientAce oldAction = action;
    action = newAction;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.CLIENT_WHEN_BLOCK__ACTION, oldAction, action));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<InputValue> getInputValues()
  {
    if (inputValues == null)
    {
      inputValues = new EObjectContainmentEList<InputValue>(InputValue.class, this, AceGenPackage.CLIENT_WHEN_BLOCK__INPUT_VALUES);
    }
    return inputValues;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<SquishyValue> getSquishyValues()
  {
    if (squishyValues == null)
    {
      squishyValues = new EObjectContainmentEList<SquishyValue>(SquishyValue.class, this, AceGenPackage.CLIENT_WHEN_BLOCK__SQUISHY_VALUES);
    }
    return squishyValues;
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
      case AceGenPackage.CLIENT_WHEN_BLOCK__INPUT_VALUES:
        return ((InternalEList<?>)getInputValues()).basicRemove(otherEnd, msgs);
      case AceGenPackage.CLIENT_WHEN_BLOCK__SQUISHY_VALUES:
        return ((InternalEList<?>)getSquishyValues()).basicRemove(otherEnd, msgs);
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
      case AceGenPackage.CLIENT_WHEN_BLOCK__ACTION:
        if (resolve) return getAction();
        return basicGetAction();
      case AceGenPackage.CLIENT_WHEN_BLOCK__INPUT_VALUES:
        return getInputValues();
      case AceGenPackage.CLIENT_WHEN_BLOCK__SQUISHY_VALUES:
        return getSquishyValues();
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
      case AceGenPackage.CLIENT_WHEN_BLOCK__ACTION:
        setAction((HttpClientAce)newValue);
        return;
      case AceGenPackage.CLIENT_WHEN_BLOCK__INPUT_VALUES:
        getInputValues().clear();
        getInputValues().addAll((Collection<? extends InputValue>)newValue);
        return;
      case AceGenPackage.CLIENT_WHEN_BLOCK__SQUISHY_VALUES:
        getSquishyValues().clear();
        getSquishyValues().addAll((Collection<? extends SquishyValue>)newValue);
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
      case AceGenPackage.CLIENT_WHEN_BLOCK__ACTION:
        setAction((HttpClientAce)null);
        return;
      case AceGenPackage.CLIENT_WHEN_BLOCK__INPUT_VALUES:
        getInputValues().clear();
        return;
      case AceGenPackage.CLIENT_WHEN_BLOCK__SQUISHY_VALUES:
        getSquishyValues().clear();
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
      case AceGenPackage.CLIENT_WHEN_BLOCK__ACTION:
        return action != null;
      case AceGenPackage.CLIENT_WHEN_BLOCK__INPUT_VALUES:
        return inputValues != null && !inputValues.isEmpty();
      case AceGenPackage.CLIENT_WHEN_BLOCK__SQUISHY_VALUES:
        return squishyValues != null && !squishyValues.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ClientWhenBlockImpl
