/**
 * generated by Xtext 2.26.0
 */
package de.acegen.aceGen.impl;

import de.acegen.aceGen.AceGenPackage;
import de.acegen.aceGen.AttributeAndValue;
import de.acegen.aceGen.Count;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Count</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.impl.CountImpl#getAttributeAndValues <em>Attribute And Values</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.CountImpl#getExpected <em>Expected</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CountImpl extends PersistenceVerificationExpressionImpl implements Count
{
  /**
   * The cached value of the '{@link #getAttributeAndValues() <em>Attribute And Values</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributeAndValues()
   * @generated
   * @ordered
   */
  protected EList<AttributeAndValue> attributeAndValues;

  /**
   * The default value of the '{@link #getExpected() <em>Expected</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpected()
   * @generated
   * @ordered
   */
  protected static final int EXPECTED_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getExpected() <em>Expected</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpected()
   * @generated
   * @ordered
   */
  protected int expected = EXPECTED_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CountImpl()
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
    return AceGenPackage.Literals.COUNT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<AttributeAndValue> getAttributeAndValues()
  {
    if (attributeAndValues == null)
    {
      attributeAndValues = new EObjectContainmentEList<AttributeAndValue>(AttributeAndValue.class, this, AceGenPackage.COUNT__ATTRIBUTE_AND_VALUES);
    }
    return attributeAndValues;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getExpected()
  {
    return expected;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setExpected(int newExpected)
  {
    int oldExpected = expected;
    expected = newExpected;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.COUNT__EXPECTED, oldExpected, expected));
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
      case AceGenPackage.COUNT__ATTRIBUTE_AND_VALUES:
        return ((InternalEList<?>)getAttributeAndValues()).basicRemove(otherEnd, msgs);
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
      case AceGenPackage.COUNT__ATTRIBUTE_AND_VALUES:
        return getAttributeAndValues();
      case AceGenPackage.COUNT__EXPECTED:
        return getExpected();
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
      case AceGenPackage.COUNT__ATTRIBUTE_AND_VALUES:
        getAttributeAndValues().clear();
        getAttributeAndValues().addAll((Collection<? extends AttributeAndValue>)newValue);
        return;
      case AceGenPackage.COUNT__EXPECTED:
        setExpected((Integer)newValue);
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
      case AceGenPackage.COUNT__ATTRIBUTE_AND_VALUES:
        getAttributeAndValues().clear();
        return;
      case AceGenPackage.COUNT__EXPECTED:
        setExpected(EXPECTED_EDEFAULT);
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
      case AceGenPackage.COUNT__ATTRIBUTE_AND_VALUES:
        return attributeAndValues != null && !attributeAndValues.isEmpty();
      case AceGenPackage.COUNT__EXPECTED:
        return expected != EXPECTED_EDEFAULT;
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
    result.append(" (expected: ");
    result.append(expected);
    result.append(')');
    return result.toString();
  }

} //CountImpl
