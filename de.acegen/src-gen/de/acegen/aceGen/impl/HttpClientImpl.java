/**
 * generated by Xtext 2.29.0
 */
package de.acegen.aceGen.impl;

import de.acegen.aceGen.AceGenPackage;
import de.acegen.aceGen.ClientAttribute;
import de.acegen.aceGen.ClientModel;
import de.acegen.aceGen.ClientScenario;
import de.acegen.aceGen.HttpClient;
import de.acegen.aceGen.HttpClientAce;

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
 * An implementation of the model object '<em><b>Http Client</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.impl.HttpClientImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpClientImpl#getAceOperations <em>Ace Operations</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpClientImpl#isJsx <em>Jsx</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpClientImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpClientImpl#getScenarios <em>Scenarios</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpClientImpl#getModels <em>Models</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HttpClientImpl extends MinimalEObjectImpl.Container implements HttpClient
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
   * The cached value of the '{@link #getAceOperations() <em>Ace Operations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAceOperations()
   * @generated
   * @ordered
   */
  protected EList<HttpClientAce> aceOperations;

  /**
   * The default value of the '{@link #isJsx() <em>Jsx</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isJsx()
   * @generated
   * @ordered
   */
  protected static final boolean JSX_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isJsx() <em>Jsx</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isJsx()
   * @generated
   * @ordered
   */
  protected boolean jsx = JSX_EDEFAULT;

  /**
   * The cached value of the '{@link #getContainer() <em>Container</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContainer()
   * @generated
   * @ordered
   */
  protected ClientAttribute container;

  /**
   * The cached value of the '{@link #getScenarios() <em>Scenarios</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScenarios()
   * @generated
   * @ordered
   */
  protected EList<ClientScenario> scenarios;

  /**
   * The cached value of the '{@link #getModels() <em>Models</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModels()
   * @generated
   * @ordered
   */
  protected EList<ClientModel> models;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected HttpClientImpl()
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
    return AceGenPackage.Literals.HTTP_CLIENT;
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
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.HTTP_CLIENT__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<HttpClientAce> getAceOperations()
  {
    if (aceOperations == null)
    {
      aceOperations = new EObjectContainmentEList<HttpClientAce>(HttpClientAce.class, this, AceGenPackage.HTTP_CLIENT__ACE_OPERATIONS);
    }
    return aceOperations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isJsx()
  {
    return jsx;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setJsx(boolean newJsx)
  {
    boolean oldJsx = jsx;
    jsx = newJsx;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.HTTP_CLIENT__JSX, oldJsx, jsx));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ClientAttribute getContainer()
  {
    return container;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetContainer(ClientAttribute newContainer, NotificationChain msgs)
  {
    ClientAttribute oldContainer = container;
    container = newContainer;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AceGenPackage.HTTP_CLIENT__CONTAINER, oldContainer, newContainer);
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
  public void setContainer(ClientAttribute newContainer)
  {
    if (newContainer != container)
    {
      NotificationChain msgs = null;
      if (container != null)
        msgs = ((InternalEObject)container).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AceGenPackage.HTTP_CLIENT__CONTAINER, null, msgs);
      if (newContainer != null)
        msgs = ((InternalEObject)newContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AceGenPackage.HTTP_CLIENT__CONTAINER, null, msgs);
      msgs = basicSetContainer(newContainer, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.HTTP_CLIENT__CONTAINER, newContainer, newContainer));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ClientScenario> getScenarios()
  {
    if (scenarios == null)
    {
      scenarios = new EObjectContainmentEList<ClientScenario>(ClientScenario.class, this, AceGenPackage.HTTP_CLIENT__SCENARIOS);
    }
    return scenarios;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ClientModel> getModels()
  {
    if (models == null)
    {
      models = new EObjectContainmentEList<ClientModel>(ClientModel.class, this, AceGenPackage.HTTP_CLIENT__MODELS);
    }
    return models;
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
      case AceGenPackage.HTTP_CLIENT__ACE_OPERATIONS:
        return ((InternalEList<?>)getAceOperations()).basicRemove(otherEnd, msgs);
      case AceGenPackage.HTTP_CLIENT__CONTAINER:
        return basicSetContainer(null, msgs);
      case AceGenPackage.HTTP_CLIENT__SCENARIOS:
        return ((InternalEList<?>)getScenarios()).basicRemove(otherEnd, msgs);
      case AceGenPackage.HTTP_CLIENT__MODELS:
        return ((InternalEList<?>)getModels()).basicRemove(otherEnd, msgs);
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
      case AceGenPackage.HTTP_CLIENT__NAME:
        return getName();
      case AceGenPackage.HTTP_CLIENT__ACE_OPERATIONS:
        return getAceOperations();
      case AceGenPackage.HTTP_CLIENT__JSX:
        return isJsx();
      case AceGenPackage.HTTP_CLIENT__CONTAINER:
        return getContainer();
      case AceGenPackage.HTTP_CLIENT__SCENARIOS:
        return getScenarios();
      case AceGenPackage.HTTP_CLIENT__MODELS:
        return getModels();
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
      case AceGenPackage.HTTP_CLIENT__NAME:
        setName((String)newValue);
        return;
      case AceGenPackage.HTTP_CLIENT__ACE_OPERATIONS:
        getAceOperations().clear();
        getAceOperations().addAll((Collection<? extends HttpClientAce>)newValue);
        return;
      case AceGenPackage.HTTP_CLIENT__JSX:
        setJsx((Boolean)newValue);
        return;
      case AceGenPackage.HTTP_CLIENT__CONTAINER:
        setContainer((ClientAttribute)newValue);
        return;
      case AceGenPackage.HTTP_CLIENT__SCENARIOS:
        getScenarios().clear();
        getScenarios().addAll((Collection<? extends ClientScenario>)newValue);
        return;
      case AceGenPackage.HTTP_CLIENT__MODELS:
        getModels().clear();
        getModels().addAll((Collection<? extends ClientModel>)newValue);
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
      case AceGenPackage.HTTP_CLIENT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case AceGenPackage.HTTP_CLIENT__ACE_OPERATIONS:
        getAceOperations().clear();
        return;
      case AceGenPackage.HTTP_CLIENT__JSX:
        setJsx(JSX_EDEFAULT);
        return;
      case AceGenPackage.HTTP_CLIENT__CONTAINER:
        setContainer((ClientAttribute)null);
        return;
      case AceGenPackage.HTTP_CLIENT__SCENARIOS:
        getScenarios().clear();
        return;
      case AceGenPackage.HTTP_CLIENT__MODELS:
        getModels().clear();
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
      case AceGenPackage.HTTP_CLIENT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case AceGenPackage.HTTP_CLIENT__ACE_OPERATIONS:
        return aceOperations != null && !aceOperations.isEmpty();
      case AceGenPackage.HTTP_CLIENT__JSX:
        return jsx != JSX_EDEFAULT;
      case AceGenPackage.HTTP_CLIENT__CONTAINER:
        return container != null;
      case AceGenPackage.HTTP_CLIENT__SCENARIOS:
        return scenarios != null && !scenarios.isEmpty();
      case AceGenPackage.HTTP_CLIENT__MODELS:
        return models != null && !models.isEmpty();
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
    result.append(", jsx: ");
    result.append(jsx);
    result.append(')');
    return result.toString();
  }

} //HttpClientImpl
