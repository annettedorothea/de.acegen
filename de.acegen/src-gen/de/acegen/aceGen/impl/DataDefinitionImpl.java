/**
 * generated by Xtext 2.27.0
 */
package de.acegen.aceGen.impl;

import de.acegen.aceGen.AceGenPackage;
import de.acegen.aceGen.DataDefinition;
import de.acegen.aceGen.JsonObject;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.impl.DataDefinitionImpl#getUuid <em>Uuid</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.DataDefinitionImpl#getSystemtime <em>Systemtime</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.DataDefinitionImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.DataDefinitionImpl#getData <em>Data</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataDefinitionImpl extends MinimalEObjectImpl.Container implements DataDefinition
{
  /**
   * The default value of the '{@link #getUuid() <em>Uuid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUuid()
   * @generated
   * @ordered
   */
  protected static final String UUID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getUuid() <em>Uuid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUuid()
   * @generated
   * @ordered
   */
  protected String uuid = UUID_EDEFAULT;

  /**
   * The default value of the '{@link #getSystemtime() <em>Systemtime</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSystemtime()
   * @generated
   * @ordered
   */
  protected static final String SYSTEMTIME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSystemtime() <em>Systemtime</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSystemtime()
   * @generated
   * @ordered
   */
  protected String systemtime = SYSTEMTIME_EDEFAULT;

  /**
   * The default value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPattern()
   * @generated
   * @ordered
   */
  protected static final String PATTERN_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPattern()
   * @generated
   * @ordered
   */
  protected String pattern = PATTERN_EDEFAULT;

  /**
   * The cached value of the '{@link #getData() <em>Data</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getData()
   * @generated
   * @ordered
   */
  protected JsonObject data;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DataDefinitionImpl()
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
    return AceGenPackage.Literals.DATA_DEFINITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getUuid()
  {
    return uuid;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setUuid(String newUuid)
  {
    String oldUuid = uuid;
    uuid = newUuid;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.DATA_DEFINITION__UUID, oldUuid, uuid));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getSystemtime()
  {
    return systemtime;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSystemtime(String newSystemtime)
  {
    String oldSystemtime = systemtime;
    systemtime = newSystemtime;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.DATA_DEFINITION__SYSTEMTIME, oldSystemtime, systemtime));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getPattern()
  {
    return pattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setPattern(String newPattern)
  {
    String oldPattern = pattern;
    pattern = newPattern;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.DATA_DEFINITION__PATTERN, oldPattern, pattern));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public JsonObject getData()
  {
    return data;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetData(JsonObject newData, NotificationChain msgs)
  {
    JsonObject oldData = data;
    data = newData;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AceGenPackage.DATA_DEFINITION__DATA, oldData, newData);
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
  public void setData(JsonObject newData)
  {
    if (newData != data)
    {
      NotificationChain msgs = null;
      if (data != null)
        msgs = ((InternalEObject)data).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AceGenPackage.DATA_DEFINITION__DATA, null, msgs);
      if (newData != null)
        msgs = ((InternalEObject)newData).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AceGenPackage.DATA_DEFINITION__DATA, null, msgs);
      msgs = basicSetData(newData, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.DATA_DEFINITION__DATA, newData, newData));
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
      case AceGenPackage.DATA_DEFINITION__DATA:
        return basicSetData(null, msgs);
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
      case AceGenPackage.DATA_DEFINITION__UUID:
        return getUuid();
      case AceGenPackage.DATA_DEFINITION__SYSTEMTIME:
        return getSystemtime();
      case AceGenPackage.DATA_DEFINITION__PATTERN:
        return getPattern();
      case AceGenPackage.DATA_DEFINITION__DATA:
        return getData();
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
      case AceGenPackage.DATA_DEFINITION__UUID:
        setUuid((String)newValue);
        return;
      case AceGenPackage.DATA_DEFINITION__SYSTEMTIME:
        setSystemtime((String)newValue);
        return;
      case AceGenPackage.DATA_DEFINITION__PATTERN:
        setPattern((String)newValue);
        return;
      case AceGenPackage.DATA_DEFINITION__DATA:
        setData((JsonObject)newValue);
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
      case AceGenPackage.DATA_DEFINITION__UUID:
        setUuid(UUID_EDEFAULT);
        return;
      case AceGenPackage.DATA_DEFINITION__SYSTEMTIME:
        setSystemtime(SYSTEMTIME_EDEFAULT);
        return;
      case AceGenPackage.DATA_DEFINITION__PATTERN:
        setPattern(PATTERN_EDEFAULT);
        return;
      case AceGenPackage.DATA_DEFINITION__DATA:
        setData((JsonObject)null);
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
      case AceGenPackage.DATA_DEFINITION__UUID:
        return UUID_EDEFAULT == null ? uuid != null : !UUID_EDEFAULT.equals(uuid);
      case AceGenPackage.DATA_DEFINITION__SYSTEMTIME:
        return SYSTEMTIME_EDEFAULT == null ? systemtime != null : !SYSTEMTIME_EDEFAULT.equals(systemtime);
      case AceGenPackage.DATA_DEFINITION__PATTERN:
        return PATTERN_EDEFAULT == null ? pattern != null : !PATTERN_EDEFAULT.equals(pattern);
      case AceGenPackage.DATA_DEFINITION__DATA:
        return data != null;
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
    result.append(" (uuid: ");
    result.append(uuid);
    result.append(", systemtime: ");
    result.append(systemtime);
    result.append(", pattern: ");
    result.append(pattern);
    result.append(')');
    return result.toString();
  }

} //DataDefinitionImpl
