/**
 * generated by Xtext 2.27.0
 */
package de.acegen.aceGen.impl;

import de.acegen.aceGen.AceGenPackage;
import de.acegen.aceGen.Given;
import de.acegen.aceGen.Scenario;
import de.acegen.aceGen.WhenThen;

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
 * An implementation of the model object '<em><b>Scenario</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.impl.ScenarioImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.ScenarioImpl#getGivenItems <em>Given Items</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.ScenarioImpl#getWhenThen <em>When Then</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScenarioImpl extends MinimalEObjectImpl.Container implements Scenario
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getGivenItems() <em>Given Items</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGivenItems()
   * @generated
   * @ordered
   */
  protected EList<Given> givenItems;

  /**
   * The cached value of the '{@link #getWhenThen() <em>When Then</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWhenThen()
   * @generated
   * @ordered
   */
  protected EList<WhenThen> whenThen;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ScenarioImpl()
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
    return AceGenPackage.Literals.SCENARIO;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.SCENARIO__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Given> getGivenItems()
  {
    if (givenItems == null)
    {
      givenItems = new EObjectContainmentEList<Given>(Given.class, this, AceGenPackage.SCENARIO__GIVEN_ITEMS);
    }
    return givenItems;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<WhenThen> getWhenThen()
  {
    if (whenThen == null)
    {
      whenThen = new EObjectContainmentEList<WhenThen>(WhenThen.class, this, AceGenPackage.SCENARIO__WHEN_THEN);
    }
    return whenThen;
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
      case AceGenPackage.SCENARIO__GIVEN_ITEMS:
        return ((InternalEList<?>)getGivenItems()).basicRemove(otherEnd, msgs);
      case AceGenPackage.SCENARIO__WHEN_THEN:
        return ((InternalEList<?>)getWhenThen()).basicRemove(otherEnd, msgs);
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
      case AceGenPackage.SCENARIO__NAME:
        return getName();
      case AceGenPackage.SCENARIO__GIVEN_ITEMS:
        return getGivenItems();
      case AceGenPackage.SCENARIO__WHEN_THEN:
        return getWhenThen();
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
      case AceGenPackage.SCENARIO__NAME:
        setName((String)newValue);
        return;
      case AceGenPackage.SCENARIO__GIVEN_ITEMS:
        getGivenItems().clear();
        getGivenItems().addAll((Collection<? extends Given>)newValue);
        return;
      case AceGenPackage.SCENARIO__WHEN_THEN:
        getWhenThen().clear();
        getWhenThen().addAll((Collection<? extends WhenThen>)newValue);
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
      case AceGenPackage.SCENARIO__NAME:
        setName(NAME_EDEFAULT);
        return;
      case AceGenPackage.SCENARIO__GIVEN_ITEMS:
        getGivenItems().clear();
        return;
      case AceGenPackage.SCENARIO__WHEN_THEN:
        getWhenThen().clear();
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
      case AceGenPackage.SCENARIO__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case AceGenPackage.SCENARIO__GIVEN_ITEMS:
        return givenItems != null && !givenItems.isEmpty();
      case AceGenPackage.SCENARIO__WHEN_THEN:
        return whenThen != null && !whenThen.isEmpty();
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //ScenarioImpl
