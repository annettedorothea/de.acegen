/**
 * generated by Xtext 2.22.0
 */
package de.acegen.aceGen.impl;

import de.acegen.aceGen.AceGenPackage;
import de.acegen.aceGen.ClientAttribute;
import de.acegen.aceGen.GroupedClientAttribute;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Grouped Client Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.impl.GroupedClientAttributeImpl#getAttributeGroup <em>Attribute Group</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GroupedClientAttributeImpl extends ClientAttributeImpl implements GroupedClientAttribute
{
  /**
   * The cached value of the '{@link #getAttributeGroup() <em>Attribute Group</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributeGroup()
   * @generated
   * @ordered
   */
  protected EList<ClientAttribute> attributeGroup;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GroupedClientAttributeImpl()
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
    return AceGenPackage.Literals.GROUPED_CLIENT_ATTRIBUTE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ClientAttribute> getAttributeGroup()
  {
    if (attributeGroup == null)
    {
      attributeGroup = new EObjectContainmentEList<ClientAttribute>(ClientAttribute.class, this, AceGenPackage.GROUPED_CLIENT_ATTRIBUTE__ATTRIBUTE_GROUP);
    }
    return attributeGroup;
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
      case AceGenPackage.GROUPED_CLIENT_ATTRIBUTE__ATTRIBUTE_GROUP:
        return ((InternalEList<?>)getAttributeGroup()).basicRemove(otherEnd, msgs);
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
      case AceGenPackage.GROUPED_CLIENT_ATTRIBUTE__ATTRIBUTE_GROUP:
        return getAttributeGroup();
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
      case AceGenPackage.GROUPED_CLIENT_ATTRIBUTE__ATTRIBUTE_GROUP:
        getAttributeGroup().clear();
        getAttributeGroup().addAll((Collection<? extends ClientAttribute>)newValue);
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
      case AceGenPackage.GROUPED_CLIENT_ATTRIBUTE__ATTRIBUTE_GROUP:
        getAttributeGroup().clear();
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
      case AceGenPackage.GROUPED_CLIENT_ATTRIBUTE__ATTRIBUTE_GROUP:
        return attributeGroup != null && !attributeGroup.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //GroupedClientAttributeImpl