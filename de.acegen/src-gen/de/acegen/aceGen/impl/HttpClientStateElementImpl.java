/**
 * generated by Xtext 2.16.0
 */
package de.acegen.aceGen.impl;

import de.acegen.aceGen.AceGenPackage;
import de.acegen.aceGen.HttpClientStateElement;
import de.acegen.aceGen.HttpClientTypeDefinition;

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
 * An implementation of the model object '<em><b>Http Client State Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.impl.HttpClientStateElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpClientStateElementImpl#isList <em>List</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpClientStateElementImpl#isHash <em>Hash</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpClientStateElementImpl#isStorage <em>Storage</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpClientStateElementImpl#getTypes <em>Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HttpClientStateElementImpl extends MinimalEObjectImpl.Container implements HttpClientStateElement
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
   * The default value of the '{@link #isHash() <em>Hash</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isHash()
   * @generated
   * @ordered
   */
  protected static final boolean HASH_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isHash() <em>Hash</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isHash()
   * @generated
   * @ordered
   */
  protected boolean hash = HASH_EDEFAULT;

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
   * The cached value of the '{@link #getTypes() <em>Types</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypes()
   * @generated
   * @ordered
   */
  protected EList<HttpClientTypeDefinition> types;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected HttpClientStateElementImpl()
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
    return AceGenPackage.Literals.HTTP_CLIENT_STATE_ELEMENT;
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
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.HTTP_CLIENT_STATE_ELEMENT__NAME, oldName, name));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.HTTP_CLIENT_STATE_ELEMENT__LIST, oldList, list));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isHash()
  {
    return hash;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setHash(boolean newHash)
  {
    boolean oldHash = hash;
    hash = newHash;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.HTTP_CLIENT_STATE_ELEMENT__HASH, oldHash, hash));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.HTTP_CLIENT_STATE_ELEMENT__STORAGE, oldStorage, storage));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<HttpClientTypeDefinition> getTypes()
  {
    if (types == null)
    {
      types = new EObjectContainmentEList<HttpClientTypeDefinition>(HttpClientTypeDefinition.class, this, AceGenPackage.HTTP_CLIENT_STATE_ELEMENT__TYPES);
    }
    return types;
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
      case AceGenPackage.HTTP_CLIENT_STATE_ELEMENT__TYPES:
        return ((InternalEList<?>)getTypes()).basicRemove(otherEnd, msgs);
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
      case AceGenPackage.HTTP_CLIENT_STATE_ELEMENT__NAME:
        return getName();
      case AceGenPackage.HTTP_CLIENT_STATE_ELEMENT__LIST:
        return isList();
      case AceGenPackage.HTTP_CLIENT_STATE_ELEMENT__HASH:
        return isHash();
      case AceGenPackage.HTTP_CLIENT_STATE_ELEMENT__STORAGE:
        return isStorage();
      case AceGenPackage.HTTP_CLIENT_STATE_ELEMENT__TYPES:
        return getTypes();
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
      case AceGenPackage.HTTP_CLIENT_STATE_ELEMENT__NAME:
        setName((String)newValue);
        return;
      case AceGenPackage.HTTP_CLIENT_STATE_ELEMENT__LIST:
        setList((Boolean)newValue);
        return;
      case AceGenPackage.HTTP_CLIENT_STATE_ELEMENT__HASH:
        setHash((Boolean)newValue);
        return;
      case AceGenPackage.HTTP_CLIENT_STATE_ELEMENT__STORAGE:
        setStorage((Boolean)newValue);
        return;
      case AceGenPackage.HTTP_CLIENT_STATE_ELEMENT__TYPES:
        getTypes().clear();
        getTypes().addAll((Collection<? extends HttpClientTypeDefinition>)newValue);
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
      case AceGenPackage.HTTP_CLIENT_STATE_ELEMENT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case AceGenPackage.HTTP_CLIENT_STATE_ELEMENT__LIST:
        setList(LIST_EDEFAULT);
        return;
      case AceGenPackage.HTTP_CLIENT_STATE_ELEMENT__HASH:
        setHash(HASH_EDEFAULT);
        return;
      case AceGenPackage.HTTP_CLIENT_STATE_ELEMENT__STORAGE:
        setStorage(STORAGE_EDEFAULT);
        return;
      case AceGenPackage.HTTP_CLIENT_STATE_ELEMENT__TYPES:
        getTypes().clear();
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
      case AceGenPackage.HTTP_CLIENT_STATE_ELEMENT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case AceGenPackage.HTTP_CLIENT_STATE_ELEMENT__LIST:
        return list != LIST_EDEFAULT;
      case AceGenPackage.HTTP_CLIENT_STATE_ELEMENT__HASH:
        return hash != HASH_EDEFAULT;
      case AceGenPackage.HTTP_CLIENT_STATE_ELEMENT__STORAGE:
        return storage != STORAGE_EDEFAULT;
      case AceGenPackage.HTTP_CLIENT_STATE_ELEMENT__TYPES:
        return types != null && !types.isEmpty();
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
    result.append(", list: ");
    result.append(list);
    result.append(", hash: ");
    result.append(hash);
    result.append(", storage: ");
    result.append(storage);
    result.append(')');
    return result.toString();
  }

} //HttpClientStateElementImpl
