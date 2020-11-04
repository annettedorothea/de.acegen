/**
 * generated by Xtext 2.23.0
 */
package de.acegen.aceGen.impl;

import de.acegen.aceGen.AceGenPackage;
import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.Model;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.impl.AttributeImpl#isUnique <em>Unique</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.AttributeImpl#isPrimaryKey <em>Primary Key</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.AttributeImpl#isNotNull <em>Not Null</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.AttributeImpl#isList <em>List</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.AttributeImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.AttributeImpl#getModel <em>Model</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.AttributeImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.AttributeImpl#getForeignKey <em>Foreign Key</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.AttributeImpl#isNonDeterministic <em>Non Deterministic</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributeImpl extends MinimalEObjectImpl.Container implements Attribute
{
  /**
   * The default value of the '{@link #isUnique() <em>Unique</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUnique()
   * @generated
   * @ordered
   */
  protected static final boolean UNIQUE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isUnique() <em>Unique</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUnique()
   * @generated
   * @ordered
   */
  protected boolean unique = UNIQUE_EDEFAULT;

  /**
   * The default value of the '{@link #isPrimaryKey() <em>Primary Key</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPrimaryKey()
   * @generated
   * @ordered
   */
  protected static final boolean PRIMARY_KEY_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isPrimaryKey() <em>Primary Key</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPrimaryKey()
   * @generated
   * @ordered
   */
  protected boolean primaryKey = PRIMARY_KEY_EDEFAULT;

  /**
   * The default value of the '{@link #isNotNull() <em>Not Null</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNotNull()
   * @generated
   * @ordered
   */
  protected static final boolean NOT_NULL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isNotNull() <em>Not Null</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNotNull()
   * @generated
   * @ordered
   */
  protected boolean notNull = NOT_NULL_EDEFAULT;

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
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final String TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected String type = TYPE_EDEFAULT;

  /**
   * The cached value of the '{@link #getModel() <em>Model</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModel()
   * @generated
   * @ordered
   */
  protected Model model;

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
   * The cached value of the '{@link #getForeignKey() <em>Foreign Key</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getForeignKey()
   * @generated
   * @ordered
   */
  protected Attribute foreignKey;

  /**
   * The default value of the '{@link #isNonDeterministic() <em>Non Deterministic</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNonDeterministic()
   * @generated
   * @ordered
   */
  protected static final boolean NON_DETERMINISTIC_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isNonDeterministic() <em>Non Deterministic</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNonDeterministic()
   * @generated
   * @ordered
   */
  protected boolean nonDeterministic = NON_DETERMINISTIC_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AttributeImpl()
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
    return AceGenPackage.Literals.ATTRIBUTE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isUnique()
  {
    return unique;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setUnique(boolean newUnique)
  {
    boolean oldUnique = unique;
    unique = newUnique;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.ATTRIBUTE__UNIQUE, oldUnique, unique));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isPrimaryKey()
  {
    return primaryKey;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setPrimaryKey(boolean newPrimaryKey)
  {
    boolean oldPrimaryKey = primaryKey;
    primaryKey = newPrimaryKey;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.ATTRIBUTE__PRIMARY_KEY, oldPrimaryKey, primaryKey));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isNotNull()
  {
    return notNull;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setNotNull(boolean newNotNull)
  {
    boolean oldNotNull = notNull;
    notNull = newNotNull;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.ATTRIBUTE__NOT_NULL, oldNotNull, notNull));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.ATTRIBUTE__LIST, oldList, list));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setType(String newType)
  {
    String oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.ATTRIBUTE__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Model getModel()
  {
    if (model != null && model.eIsProxy())
    {
      InternalEObject oldModel = (InternalEObject)model;
      model = (Model)eResolveProxy(oldModel);
      if (model != oldModel)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AceGenPackage.ATTRIBUTE__MODEL, oldModel, model));
      }
    }
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model basicGetModel()
  {
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setModel(Model newModel)
  {
    Model oldModel = model;
    model = newModel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.ATTRIBUTE__MODEL, oldModel, model));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.ATTRIBUTE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Attribute getForeignKey()
  {
    if (foreignKey != null && foreignKey.eIsProxy())
    {
      InternalEObject oldForeignKey = (InternalEObject)foreignKey;
      foreignKey = (Attribute)eResolveProxy(oldForeignKey);
      if (foreignKey != oldForeignKey)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AceGenPackage.ATTRIBUTE__FOREIGN_KEY, oldForeignKey, foreignKey));
      }
    }
    return foreignKey;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Attribute basicGetForeignKey()
  {
    return foreignKey;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setForeignKey(Attribute newForeignKey)
  {
    Attribute oldForeignKey = foreignKey;
    foreignKey = newForeignKey;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.ATTRIBUTE__FOREIGN_KEY, oldForeignKey, foreignKey));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isNonDeterministic()
  {
    return nonDeterministic;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setNonDeterministic(boolean newNonDeterministic)
  {
    boolean oldNonDeterministic = nonDeterministic;
    nonDeterministic = newNonDeterministic;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.ATTRIBUTE__NON_DETERMINISTIC, oldNonDeterministic, nonDeterministic));
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
      case AceGenPackage.ATTRIBUTE__UNIQUE:
        return isUnique();
      case AceGenPackage.ATTRIBUTE__PRIMARY_KEY:
        return isPrimaryKey();
      case AceGenPackage.ATTRIBUTE__NOT_NULL:
        return isNotNull();
      case AceGenPackage.ATTRIBUTE__LIST:
        return isList();
      case AceGenPackage.ATTRIBUTE__TYPE:
        return getType();
      case AceGenPackage.ATTRIBUTE__MODEL:
        if (resolve) return getModel();
        return basicGetModel();
      case AceGenPackage.ATTRIBUTE__NAME:
        return getName();
      case AceGenPackage.ATTRIBUTE__FOREIGN_KEY:
        if (resolve) return getForeignKey();
        return basicGetForeignKey();
      case AceGenPackage.ATTRIBUTE__NON_DETERMINISTIC:
        return isNonDeterministic();
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
      case AceGenPackage.ATTRIBUTE__UNIQUE:
        setUnique((Boolean)newValue);
        return;
      case AceGenPackage.ATTRIBUTE__PRIMARY_KEY:
        setPrimaryKey((Boolean)newValue);
        return;
      case AceGenPackage.ATTRIBUTE__NOT_NULL:
        setNotNull((Boolean)newValue);
        return;
      case AceGenPackage.ATTRIBUTE__LIST:
        setList((Boolean)newValue);
        return;
      case AceGenPackage.ATTRIBUTE__TYPE:
        setType((String)newValue);
        return;
      case AceGenPackage.ATTRIBUTE__MODEL:
        setModel((Model)newValue);
        return;
      case AceGenPackage.ATTRIBUTE__NAME:
        setName((String)newValue);
        return;
      case AceGenPackage.ATTRIBUTE__FOREIGN_KEY:
        setForeignKey((Attribute)newValue);
        return;
      case AceGenPackage.ATTRIBUTE__NON_DETERMINISTIC:
        setNonDeterministic((Boolean)newValue);
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
      case AceGenPackage.ATTRIBUTE__UNIQUE:
        setUnique(UNIQUE_EDEFAULT);
        return;
      case AceGenPackage.ATTRIBUTE__PRIMARY_KEY:
        setPrimaryKey(PRIMARY_KEY_EDEFAULT);
        return;
      case AceGenPackage.ATTRIBUTE__NOT_NULL:
        setNotNull(NOT_NULL_EDEFAULT);
        return;
      case AceGenPackage.ATTRIBUTE__LIST:
        setList(LIST_EDEFAULT);
        return;
      case AceGenPackage.ATTRIBUTE__TYPE:
        setType(TYPE_EDEFAULT);
        return;
      case AceGenPackage.ATTRIBUTE__MODEL:
        setModel((Model)null);
        return;
      case AceGenPackage.ATTRIBUTE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case AceGenPackage.ATTRIBUTE__FOREIGN_KEY:
        setForeignKey((Attribute)null);
        return;
      case AceGenPackage.ATTRIBUTE__NON_DETERMINISTIC:
        setNonDeterministic(NON_DETERMINISTIC_EDEFAULT);
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
      case AceGenPackage.ATTRIBUTE__UNIQUE:
        return unique != UNIQUE_EDEFAULT;
      case AceGenPackage.ATTRIBUTE__PRIMARY_KEY:
        return primaryKey != PRIMARY_KEY_EDEFAULT;
      case AceGenPackage.ATTRIBUTE__NOT_NULL:
        return notNull != NOT_NULL_EDEFAULT;
      case AceGenPackage.ATTRIBUTE__LIST:
        return list != LIST_EDEFAULT;
      case AceGenPackage.ATTRIBUTE__TYPE:
        return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
      case AceGenPackage.ATTRIBUTE__MODEL:
        return model != null;
      case AceGenPackage.ATTRIBUTE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case AceGenPackage.ATTRIBUTE__FOREIGN_KEY:
        return foreignKey != null;
      case AceGenPackage.ATTRIBUTE__NON_DETERMINISTIC:
        return nonDeterministic != NON_DETERMINISTIC_EDEFAULT;
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
    result.append(" (unique: ");
    result.append(unique);
    result.append(", primaryKey: ");
    result.append(primaryKey);
    result.append(", notNull: ");
    result.append(notNull);
    result.append(", list: ");
    result.append(list);
    result.append(", type: ");
    result.append(type);
    result.append(", name: ");
    result.append(name);
    result.append(", nonDeterministic: ");
    result.append(nonDeterministic);
    result.append(')');
    return result.toString();
  }

} //AttributeImpl
