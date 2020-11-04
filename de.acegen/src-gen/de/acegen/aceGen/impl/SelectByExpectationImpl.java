/**
 * generated by Xtext 2.23.0
 */
package de.acegen.aceGen.impl;

import de.acegen.aceGen.AceGenPackage;
import de.acegen.aceGen.JsonObject;
import de.acegen.aceGen.SelectByExpectation;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Select By Expectation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.impl.SelectByExpectationImpl#getObject <em>Object</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.SelectByExpectationImpl#isIsNotNull <em>Is Not Null</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.SelectByExpectationImpl#isIsNull <em>Is Null</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SelectByExpectationImpl extends MinimalEObjectImpl.Container implements SelectByExpectation
{
  /**
   * The cached value of the '{@link #getObject() <em>Object</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObject()
   * @generated
   * @ordered
   */
  protected JsonObject object;

  /**
   * The default value of the '{@link #isIsNotNull() <em>Is Not Null</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsNotNull()
   * @generated
   * @ordered
   */
  protected static final boolean IS_NOT_NULL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsNotNull() <em>Is Not Null</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsNotNull()
   * @generated
   * @ordered
   */
  protected boolean isNotNull = IS_NOT_NULL_EDEFAULT;

  /**
   * The default value of the '{@link #isIsNull() <em>Is Null</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsNull()
   * @generated
   * @ordered
   */
  protected static final boolean IS_NULL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsNull() <em>Is Null</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsNull()
   * @generated
   * @ordered
   */
  protected boolean isNull = IS_NULL_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SelectByExpectationImpl()
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
    return AceGenPackage.Literals.SELECT_BY_EXPECTATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public JsonObject getObject()
  {
    return object;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetObject(JsonObject newObject, NotificationChain msgs)
  {
    JsonObject oldObject = object;
    object = newObject;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AceGenPackage.SELECT_BY_EXPECTATION__OBJECT, oldObject, newObject);
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
  public void setObject(JsonObject newObject)
  {
    if (newObject != object)
    {
      NotificationChain msgs = null;
      if (object != null)
        msgs = ((InternalEObject)object).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AceGenPackage.SELECT_BY_EXPECTATION__OBJECT, null, msgs);
      if (newObject != null)
        msgs = ((InternalEObject)newObject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AceGenPackage.SELECT_BY_EXPECTATION__OBJECT, null, msgs);
      msgs = basicSetObject(newObject, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.SELECT_BY_EXPECTATION__OBJECT, newObject, newObject));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isIsNotNull()
  {
    return isNotNull;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setIsNotNull(boolean newIsNotNull)
  {
    boolean oldIsNotNull = isNotNull;
    isNotNull = newIsNotNull;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.SELECT_BY_EXPECTATION__IS_NOT_NULL, oldIsNotNull, isNotNull));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isIsNull()
  {
    return isNull;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setIsNull(boolean newIsNull)
  {
    boolean oldIsNull = isNull;
    isNull = newIsNull;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.SELECT_BY_EXPECTATION__IS_NULL, oldIsNull, isNull));
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
      case AceGenPackage.SELECT_BY_EXPECTATION__OBJECT:
        return basicSetObject(null, msgs);
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
      case AceGenPackage.SELECT_BY_EXPECTATION__OBJECT:
        return getObject();
      case AceGenPackage.SELECT_BY_EXPECTATION__IS_NOT_NULL:
        return isIsNotNull();
      case AceGenPackage.SELECT_BY_EXPECTATION__IS_NULL:
        return isIsNull();
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
      case AceGenPackage.SELECT_BY_EXPECTATION__OBJECT:
        setObject((JsonObject)newValue);
        return;
      case AceGenPackage.SELECT_BY_EXPECTATION__IS_NOT_NULL:
        setIsNotNull((Boolean)newValue);
        return;
      case AceGenPackage.SELECT_BY_EXPECTATION__IS_NULL:
        setIsNull((Boolean)newValue);
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
      case AceGenPackage.SELECT_BY_EXPECTATION__OBJECT:
        setObject((JsonObject)null);
        return;
      case AceGenPackage.SELECT_BY_EXPECTATION__IS_NOT_NULL:
        setIsNotNull(IS_NOT_NULL_EDEFAULT);
        return;
      case AceGenPackage.SELECT_BY_EXPECTATION__IS_NULL:
        setIsNull(IS_NULL_EDEFAULT);
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
      case AceGenPackage.SELECT_BY_EXPECTATION__OBJECT:
        return object != null;
      case AceGenPackage.SELECT_BY_EXPECTATION__IS_NOT_NULL:
        return isNotNull != IS_NOT_NULL_EDEFAULT;
      case AceGenPackage.SELECT_BY_EXPECTATION__IS_NULL:
        return isNull != IS_NULL_EDEFAULT;
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
    result.append(" (isNotNull: ");
    result.append(isNotNull);
    result.append(", isNull: ");
    result.append(isNull);
    result.append(')');
    return result.toString();
  }

} //SelectByExpectationImpl
