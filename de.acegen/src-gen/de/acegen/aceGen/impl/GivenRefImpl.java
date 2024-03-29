/**
 * generated by Xtext 2.29.0
 */
package de.acegen.aceGen.impl;

import de.acegen.aceGen.AceGenPackage;
import de.acegen.aceGen.GivenRef;
import de.acegen.aceGen.Scenario;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Given Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.impl.GivenRefImpl#getScenario <em>Scenario</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.GivenRefImpl#isExcludeGiven <em>Exclude Given</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GivenRefImpl extends GivenImpl implements GivenRef
{
  /**
   * The cached value of the '{@link #getScenario() <em>Scenario</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScenario()
   * @generated
   * @ordered
   */
  protected Scenario scenario;

  /**
   * The default value of the '{@link #isExcludeGiven() <em>Exclude Given</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isExcludeGiven()
   * @generated
   * @ordered
   */
  protected static final boolean EXCLUDE_GIVEN_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isExcludeGiven() <em>Exclude Given</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isExcludeGiven()
   * @generated
   * @ordered
   */
  protected boolean excludeGiven = EXCLUDE_GIVEN_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GivenRefImpl()
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
    return AceGenPackage.Literals.GIVEN_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Scenario getScenario()
  {
    if (scenario != null && scenario.eIsProxy())
    {
      InternalEObject oldScenario = (InternalEObject)scenario;
      scenario = (Scenario)eResolveProxy(oldScenario);
      if (scenario != oldScenario)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AceGenPackage.GIVEN_REF__SCENARIO, oldScenario, scenario));
      }
    }
    return scenario;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Scenario basicGetScenario()
  {
    return scenario;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setScenario(Scenario newScenario)
  {
    Scenario oldScenario = scenario;
    scenario = newScenario;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.GIVEN_REF__SCENARIO, oldScenario, scenario));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isExcludeGiven()
  {
    return excludeGiven;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setExcludeGiven(boolean newExcludeGiven)
  {
    boolean oldExcludeGiven = excludeGiven;
    excludeGiven = newExcludeGiven;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.GIVEN_REF__EXCLUDE_GIVEN, oldExcludeGiven, excludeGiven));
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
      case AceGenPackage.GIVEN_REF__SCENARIO:
        if (resolve) return getScenario();
        return basicGetScenario();
      case AceGenPackage.GIVEN_REF__EXCLUDE_GIVEN:
        return isExcludeGiven();
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
      case AceGenPackage.GIVEN_REF__SCENARIO:
        setScenario((Scenario)newValue);
        return;
      case AceGenPackage.GIVEN_REF__EXCLUDE_GIVEN:
        setExcludeGiven((Boolean)newValue);
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
      case AceGenPackage.GIVEN_REF__SCENARIO:
        setScenario((Scenario)null);
        return;
      case AceGenPackage.GIVEN_REF__EXCLUDE_GIVEN:
        setExcludeGiven(EXCLUDE_GIVEN_EDEFAULT);
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
      case AceGenPackage.GIVEN_REF__SCENARIO:
        return scenario != null;
      case AceGenPackage.GIVEN_REF__EXCLUDE_GIVEN:
        return excludeGiven != EXCLUDE_GIVEN_EDEFAULT;
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
    result.append(" (excludeGiven: ");
    result.append(excludeGiven);
    result.append(')');
    return result.toString();
  }

} //GivenRefImpl
