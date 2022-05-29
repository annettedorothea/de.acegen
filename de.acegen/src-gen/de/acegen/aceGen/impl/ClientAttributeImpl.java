/**
 * generated by Xtext 2.26.0
 */
package de.acegen.aceGen.impl;

import de.acegen.aceGen.AceGenPackage;
import de.acegen.aceGen.ClientAttribute;
import de.acegen.aceGen.UiAction;

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
 * An implementation of the model object '<em><b>Client Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.impl.ClientAttributeImpl#isNoComponent <em>No Component</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.ClientAttributeImpl#isList <em>List</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.ClientAttributeImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.ClientAttributeImpl#isLocation <em>Location</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.ClientAttributeImpl#isStorage <em>Storage</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.ClientAttributeImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.ClientAttributeImpl#getActions <em>Actions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClientAttributeImpl extends MinimalEObjectImpl.Container implements ClientAttribute
{
  /**
   * The default value of the '{@link #isNoComponent() <em>No Component</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNoComponent()
   * @generated
   * @ordered
   */
  protected static final boolean NO_COMPONENT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isNoComponent() <em>No Component</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNoComponent()
   * @generated
   * @ordered
   */
  protected boolean noComponent = NO_COMPONENT_EDEFAULT;

  /**
   * The default value of the '{@link #isList() <em>List</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isList()
   * @generated
   * @ordered
   */
  protected static final boolean LIST_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isList() <em>List</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isList()
   * @generated
   * @ordered
   */
  protected boolean list = LIST_EDEFAULT;

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
   * The default value of the '{@link #isLocation() <em>Location</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isLocation()
   * @generated
   * @ordered
   */
  protected static final boolean LOCATION_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isLocation() <em>Location</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isLocation()
   * @generated
   * @ordered
   */
  protected boolean location = LOCATION_EDEFAULT;

  /**
   * The default value of the '{@link #isStorage() <em>Storage</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStorage()
   * @generated
   * @ordered
   */
  protected static final boolean STORAGE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isStorage() <em>Storage</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStorage()
   * @generated
   * @ordered
   */
  protected boolean storage = STORAGE_EDEFAULT;

  /**
   * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributes()
   * @generated
   * @ordered
   */
  protected EList<ClientAttribute> attributes;

  /**
   * The cached value of the '{@link #getActions() <em>Actions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActions()
   * @generated
   * @ordered
   */
  protected EList<UiAction> actions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClientAttributeImpl()
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
    return AceGenPackage.Literals.CLIENT_ATTRIBUTE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isNoComponent()
  {
    return noComponent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setNoComponent(boolean newNoComponent)
  {
    boolean oldNoComponent = noComponent;
    noComponent = newNoComponent;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.CLIENT_ATTRIBUTE__NO_COMPONENT, oldNoComponent, noComponent));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isList()
  {
    return list;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setList(boolean newList)
  {
    boolean oldList = list;
    list = newList;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.CLIENT_ATTRIBUTE__LIST, oldList, list));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.CLIENT_ATTRIBUTE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isLocation()
  {
    return location;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setLocation(boolean newLocation)
  {
    boolean oldLocation = location;
    location = newLocation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.CLIENT_ATTRIBUTE__LOCATION, oldLocation, location));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isStorage()
  {
    return storage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setStorage(boolean newStorage)
  {
    boolean oldStorage = storage;
    storage = newStorage;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.CLIENT_ATTRIBUTE__STORAGE, oldStorage, storage));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ClientAttribute> getAttributes()
  {
    if (attributes == null)
    {
      attributes = new EObjectContainmentEList<ClientAttribute>(ClientAttribute.class, this, AceGenPackage.CLIENT_ATTRIBUTE__ATTRIBUTES);
    }
    return attributes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<UiAction> getActions()
  {
    if (actions == null)
    {
      actions = new EObjectContainmentEList<UiAction>(UiAction.class, this, AceGenPackage.CLIENT_ATTRIBUTE__ACTIONS);
    }
    return actions;
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
      case AceGenPackage.CLIENT_ATTRIBUTE__ATTRIBUTES:
        return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
      case AceGenPackage.CLIENT_ATTRIBUTE__ACTIONS:
        return ((InternalEList<?>)getActions()).basicRemove(otherEnd, msgs);
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
      case AceGenPackage.CLIENT_ATTRIBUTE__NO_COMPONENT:
        return isNoComponent();
      case AceGenPackage.CLIENT_ATTRIBUTE__LIST:
        return isList();
      case AceGenPackage.CLIENT_ATTRIBUTE__NAME:
        return getName();
      case AceGenPackage.CLIENT_ATTRIBUTE__LOCATION:
        return isLocation();
      case AceGenPackage.CLIENT_ATTRIBUTE__STORAGE:
        return isStorage();
      case AceGenPackage.CLIENT_ATTRIBUTE__ATTRIBUTES:
        return getAttributes();
      case AceGenPackage.CLIENT_ATTRIBUTE__ACTIONS:
        return getActions();
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
      case AceGenPackage.CLIENT_ATTRIBUTE__NO_COMPONENT:
        setNoComponent((Boolean)newValue);
        return;
      case AceGenPackage.CLIENT_ATTRIBUTE__LIST:
        setList((Boolean)newValue);
        return;
      case AceGenPackage.CLIENT_ATTRIBUTE__NAME:
        setName((String)newValue);
        return;
      case AceGenPackage.CLIENT_ATTRIBUTE__LOCATION:
        setLocation((Boolean)newValue);
        return;
      case AceGenPackage.CLIENT_ATTRIBUTE__STORAGE:
        setStorage((Boolean)newValue);
        return;
      case AceGenPackage.CLIENT_ATTRIBUTE__ATTRIBUTES:
        getAttributes().clear();
        getAttributes().addAll((Collection<? extends ClientAttribute>)newValue);
        return;
      case AceGenPackage.CLIENT_ATTRIBUTE__ACTIONS:
        getActions().clear();
        getActions().addAll((Collection<? extends UiAction>)newValue);
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
      case AceGenPackage.CLIENT_ATTRIBUTE__NO_COMPONENT:
        setNoComponent(NO_COMPONENT_EDEFAULT);
        return;
      case AceGenPackage.CLIENT_ATTRIBUTE__LIST:
        setList(LIST_EDEFAULT);
        return;
      case AceGenPackage.CLIENT_ATTRIBUTE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case AceGenPackage.CLIENT_ATTRIBUTE__LOCATION:
        setLocation(LOCATION_EDEFAULT);
        return;
      case AceGenPackage.CLIENT_ATTRIBUTE__STORAGE:
        setStorage(STORAGE_EDEFAULT);
        return;
      case AceGenPackage.CLIENT_ATTRIBUTE__ATTRIBUTES:
        getAttributes().clear();
        return;
      case AceGenPackage.CLIENT_ATTRIBUTE__ACTIONS:
        getActions().clear();
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
      case AceGenPackage.CLIENT_ATTRIBUTE__NO_COMPONENT:
        return noComponent != NO_COMPONENT_EDEFAULT;
      case AceGenPackage.CLIENT_ATTRIBUTE__LIST:
        return list != LIST_EDEFAULT;
      case AceGenPackage.CLIENT_ATTRIBUTE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case AceGenPackage.CLIENT_ATTRIBUTE__LOCATION:
        return location != LOCATION_EDEFAULT;
      case AceGenPackage.CLIENT_ATTRIBUTE__STORAGE:
        return storage != STORAGE_EDEFAULT;
      case AceGenPackage.CLIENT_ATTRIBUTE__ATTRIBUTES:
        return attributes != null && !attributes.isEmpty();
      case AceGenPackage.CLIENT_ATTRIBUTE__ACTIONS:
        return actions != null && !actions.isEmpty();
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
    result.append(" (noComponent: ");
    result.append(noComponent);
    result.append(", list: ");
    result.append(list);
    result.append(", name: ");
    result.append(name);
    result.append(", location: ");
    result.append(location);
    result.append(", storage: ");
    result.append(storage);
    result.append(')');
    return result.toString();
  }

} //ClientAttributeImpl
