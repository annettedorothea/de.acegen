/**
 * generated by Xtext 2.27.0
 */
package de.acegen.aceGen.impl;

import de.acegen.aceGen.AceGenPackage;
import de.acegen.aceGen.HttpServerView;
import de.acegen.aceGen.HttpServerViewFunction;

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
 * An implementation of the model object '<em><b>Http Server View</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.impl.HttpServerViewImpl#isAfterCommit <em>After Commit</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpServerViewImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpServerViewImpl#getRenderFunctions <em>Render Functions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HttpServerViewImpl extends MinimalEObjectImpl.Container implements HttpServerView
{
  /**
   * The default value of the '{@link #isAfterCommit() <em>After Commit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAfterCommit()
   * @generated
   * @ordered
   */
  protected static final boolean AFTER_COMMIT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAfterCommit() <em>After Commit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAfterCommit()
   * @generated
   * @ordered
   */
  protected boolean afterCommit = AFTER_COMMIT_EDEFAULT;

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
   * The cached value of the '{@link #getRenderFunctions() <em>Render Functions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRenderFunctions()
   * @generated
   * @ordered
   */
  protected EList<HttpServerViewFunction> renderFunctions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected HttpServerViewImpl()
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
    return AceGenPackage.Literals.HTTP_SERVER_VIEW;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isAfterCommit()
  {
    return afterCommit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAfterCommit(boolean newAfterCommit)
  {
    boolean oldAfterCommit = afterCommit;
    afterCommit = newAfterCommit;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.HTTP_SERVER_VIEW__AFTER_COMMIT, oldAfterCommit, afterCommit));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.HTTP_SERVER_VIEW__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<HttpServerViewFunction> getRenderFunctions()
  {
    if (renderFunctions == null)
    {
      renderFunctions = new EObjectContainmentEList<HttpServerViewFunction>(HttpServerViewFunction.class, this, AceGenPackage.HTTP_SERVER_VIEW__RENDER_FUNCTIONS);
    }
    return renderFunctions;
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
      case AceGenPackage.HTTP_SERVER_VIEW__RENDER_FUNCTIONS:
        return ((InternalEList<?>)getRenderFunctions()).basicRemove(otherEnd, msgs);
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
      case AceGenPackage.HTTP_SERVER_VIEW__AFTER_COMMIT:
        return isAfterCommit();
      case AceGenPackage.HTTP_SERVER_VIEW__NAME:
        return getName();
      case AceGenPackage.HTTP_SERVER_VIEW__RENDER_FUNCTIONS:
        return getRenderFunctions();
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
      case AceGenPackage.HTTP_SERVER_VIEW__AFTER_COMMIT:
        setAfterCommit((Boolean)newValue);
        return;
      case AceGenPackage.HTTP_SERVER_VIEW__NAME:
        setName((String)newValue);
        return;
      case AceGenPackage.HTTP_SERVER_VIEW__RENDER_FUNCTIONS:
        getRenderFunctions().clear();
        getRenderFunctions().addAll((Collection<? extends HttpServerViewFunction>)newValue);
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
      case AceGenPackage.HTTP_SERVER_VIEW__AFTER_COMMIT:
        setAfterCommit(AFTER_COMMIT_EDEFAULT);
        return;
      case AceGenPackage.HTTP_SERVER_VIEW__NAME:
        setName(NAME_EDEFAULT);
        return;
      case AceGenPackage.HTTP_SERVER_VIEW__RENDER_FUNCTIONS:
        getRenderFunctions().clear();
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
      case AceGenPackage.HTTP_SERVER_VIEW__AFTER_COMMIT:
        return afterCommit != AFTER_COMMIT_EDEFAULT;
      case AceGenPackage.HTTP_SERVER_VIEW__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case AceGenPackage.HTTP_SERVER_VIEW__RENDER_FUNCTIONS:
        return renderFunctions != null && !renderFunctions.isEmpty();
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
    result.append(" (afterCommit: ");
    result.append(afterCommit);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //HttpServerViewImpl
