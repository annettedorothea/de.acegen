/**
 * generated by Xtext 2.29.0
 */
package de.acegen.aceGen.impl;

import de.acegen.aceGen.AceGenPackage;
import de.acegen.aceGen.ThenBlock;
import de.acegen.aceGen.WhenBlock;
import de.acegen.aceGen.WhenThen;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>When Then</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.impl.WhenThenImpl#getWhenBlock <em>When Block</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.WhenThenImpl#getThenBlock <em>Then Block</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WhenThenImpl extends MinimalEObjectImpl.Container implements WhenThen
{
  /**
   * The cached value of the '{@link #getWhenBlock() <em>When Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWhenBlock()
   * @generated
   * @ordered
   */
  protected WhenBlock whenBlock;

  /**
   * The cached value of the '{@link #getThenBlock() <em>Then Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getThenBlock()
   * @generated
   * @ordered
   */
  protected ThenBlock thenBlock;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected WhenThenImpl()
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
    return AceGenPackage.Literals.WHEN_THEN;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public WhenBlock getWhenBlock()
  {
    return whenBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetWhenBlock(WhenBlock newWhenBlock, NotificationChain msgs)
  {
    WhenBlock oldWhenBlock = whenBlock;
    whenBlock = newWhenBlock;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AceGenPackage.WHEN_THEN__WHEN_BLOCK, oldWhenBlock, newWhenBlock);
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
  public void setWhenBlock(WhenBlock newWhenBlock)
  {
    if (newWhenBlock != whenBlock)
    {
      NotificationChain msgs = null;
      if (whenBlock != null)
        msgs = ((InternalEObject)whenBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AceGenPackage.WHEN_THEN__WHEN_BLOCK, null, msgs);
      if (newWhenBlock != null)
        msgs = ((InternalEObject)newWhenBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AceGenPackage.WHEN_THEN__WHEN_BLOCK, null, msgs);
      msgs = basicSetWhenBlock(newWhenBlock, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.WHEN_THEN__WHEN_BLOCK, newWhenBlock, newWhenBlock));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ThenBlock getThenBlock()
  {
    return thenBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetThenBlock(ThenBlock newThenBlock, NotificationChain msgs)
  {
    ThenBlock oldThenBlock = thenBlock;
    thenBlock = newThenBlock;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AceGenPackage.WHEN_THEN__THEN_BLOCK, oldThenBlock, newThenBlock);
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
  public void setThenBlock(ThenBlock newThenBlock)
  {
    if (newThenBlock != thenBlock)
    {
      NotificationChain msgs = null;
      if (thenBlock != null)
        msgs = ((InternalEObject)thenBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AceGenPackage.WHEN_THEN__THEN_BLOCK, null, msgs);
      if (newThenBlock != null)
        msgs = ((InternalEObject)newThenBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AceGenPackage.WHEN_THEN__THEN_BLOCK, null, msgs);
      msgs = basicSetThenBlock(newThenBlock, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.WHEN_THEN__THEN_BLOCK, newThenBlock, newThenBlock));
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
      case AceGenPackage.WHEN_THEN__WHEN_BLOCK:
        return basicSetWhenBlock(null, msgs);
      case AceGenPackage.WHEN_THEN__THEN_BLOCK:
        return basicSetThenBlock(null, msgs);
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
      case AceGenPackage.WHEN_THEN__WHEN_BLOCK:
        return getWhenBlock();
      case AceGenPackage.WHEN_THEN__THEN_BLOCK:
        return getThenBlock();
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
      case AceGenPackage.WHEN_THEN__WHEN_BLOCK:
        setWhenBlock((WhenBlock)newValue);
        return;
      case AceGenPackage.WHEN_THEN__THEN_BLOCK:
        setThenBlock((ThenBlock)newValue);
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
      case AceGenPackage.WHEN_THEN__WHEN_BLOCK:
        setWhenBlock((WhenBlock)null);
        return;
      case AceGenPackage.WHEN_THEN__THEN_BLOCK:
        setThenBlock((ThenBlock)null);
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
      case AceGenPackage.WHEN_THEN__WHEN_BLOCK:
        return whenBlock != null;
      case AceGenPackage.WHEN_THEN__THEN_BLOCK:
        return thenBlock != null;
    }
    return super.eIsSet(featureID);
  }

} //WhenThenImpl
