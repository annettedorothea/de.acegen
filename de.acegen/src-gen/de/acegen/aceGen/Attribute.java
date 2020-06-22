/**
 * generated by Xtext 2.21.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.Attribute#isUnique <em>Unique</em>}</li>
 *   <li>{@link de.acegen.aceGen.Attribute#isPrimaryKey <em>Primary Key</em>}</li>
 *   <li>{@link de.acegen.aceGen.Attribute#isNotNull <em>Not Null</em>}</li>
 *   <li>{@link de.acegen.aceGen.Attribute#isList <em>List</em>}</li>
 *   <li>{@link de.acegen.aceGen.Attribute#getType <em>Type</em>}</li>
 *   <li>{@link de.acegen.aceGen.Attribute#getModel <em>Model</em>}</li>
 *   <li>{@link de.acegen.aceGen.Attribute#getName <em>Name</em>}</li>
 *   <li>{@link de.acegen.aceGen.Attribute#getForeignKey <em>Foreign Key</em>}</li>
 *   <li>{@link de.acegen.aceGen.Attribute#isNotReplayable <em>Not Replayable</em>}</li>
 *   <li>{@link de.acegen.aceGen.Attribute#isHash <em>Hash</em>}</li>
 *   <li>{@link de.acegen.aceGen.Attribute#isStorage <em>Storage</em>}</li>
 *   <li>{@link de.acegen.aceGen.Attribute#getSuperModels <em>Super Models</em>}</li>
 *   <li>{@link de.acegen.aceGen.Attribute#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends EObject
{
  /**
   * Returns the value of the '<em><b>Unique</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unique</em>' attribute.
   * @see #setUnique(boolean)
   * @see de.acegen.aceGen.AceGenPackage#getAttribute_Unique()
   * @model
   * @generated
   */
  boolean isUnique();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.Attribute#isUnique <em>Unique</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unique</em>' attribute.
   * @see #isUnique()
   * @generated
   */
  void setUnique(boolean value);

  /**
   * Returns the value of the '<em><b>Primary Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Primary Key</em>' attribute.
   * @see #setPrimaryKey(boolean)
   * @see de.acegen.aceGen.AceGenPackage#getAttribute_PrimaryKey()
   * @model
   * @generated
   */
  boolean isPrimaryKey();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.Attribute#isPrimaryKey <em>Primary Key</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Primary Key</em>' attribute.
   * @see #isPrimaryKey()
   * @generated
   */
  void setPrimaryKey(boolean value);

  /**
   * Returns the value of the '<em><b>Not Null</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Not Null</em>' attribute.
   * @see #setNotNull(boolean)
   * @see de.acegen.aceGen.AceGenPackage#getAttribute_NotNull()
   * @model
   * @generated
   */
  boolean isNotNull();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.Attribute#isNotNull <em>Not Null</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Not Null</em>' attribute.
   * @see #isNotNull()
   * @generated
   */
  void setNotNull(boolean value);

  /**
   * Returns the value of the '<em><b>List</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>List</em>' attribute.
   * @see #setList(boolean)
   * @see de.acegen.aceGen.AceGenPackage#getAttribute_List()
   * @model
   * @generated
   */
  boolean isList();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.Attribute#isList <em>List</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>List</em>' attribute.
   * @see #isList()
   * @generated
   */
  void setList(boolean value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see #setType(String)
   * @see de.acegen.aceGen.AceGenPackage#getAttribute_Type()
   * @model
   * @generated
   */
  String getType();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.Attribute#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

  /**
   * Returns the value of the '<em><b>Model</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Model</em>' reference.
   * @see #setModel(Model)
   * @see de.acegen.aceGen.AceGenPackage#getAttribute_Model()
   * @model
   * @generated
   */
  Model getModel();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.Attribute#getModel <em>Model</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Model</em>' reference.
   * @see #getModel()
   * @generated
   */
  void setModel(Model value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see de.acegen.aceGen.AceGenPackage#getAttribute_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.Attribute#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Foreign Key</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Foreign Key</em>' reference.
   * @see #setForeignKey(Attribute)
   * @see de.acegen.aceGen.AceGenPackage#getAttribute_ForeignKey()
   * @model
   * @generated
   */
  Attribute getForeignKey();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.Attribute#getForeignKey <em>Foreign Key</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Foreign Key</em>' reference.
   * @see #getForeignKey()
   * @generated
   */
  void setForeignKey(Attribute value);

  /**
   * Returns the value of the '<em><b>Not Replayable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Not Replayable</em>' attribute.
   * @see #setNotReplayable(boolean)
   * @see de.acegen.aceGen.AceGenPackage#getAttribute_NotReplayable()
   * @model
   * @generated
   */
  boolean isNotReplayable();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.Attribute#isNotReplayable <em>Not Replayable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Not Replayable</em>' attribute.
   * @see #isNotReplayable()
   * @generated
   */
  void setNotReplayable(boolean value);

  /**
   * Returns the value of the '<em><b>Hash</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Hash</em>' attribute.
   * @see #setHash(boolean)
   * @see de.acegen.aceGen.AceGenPackage#getAttribute_Hash()
   * @model
   * @generated
   */
  boolean isHash();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.Attribute#isHash <em>Hash</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Hash</em>' attribute.
   * @see #isHash()
   * @generated
   */
  void setHash(boolean value);

  /**
   * Returns the value of the '<em><b>Storage</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Storage</em>' attribute.
   * @see #setStorage(boolean)
   * @see de.acegen.aceGen.AceGenPackage#getAttribute_Storage()
   * @model
   * @generated
   */
  boolean isStorage();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.Attribute#isStorage <em>Storage</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Storage</em>' attribute.
   * @see #isStorage()
   * @generated
   */
  void setStorage(boolean value);

  /**
   * Returns the value of the '<em><b>Super Models</b></em>' reference list.
   * The list contents are of type {@link de.acegen.aceGen.Model}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Super Models</em>' reference list.
   * @see de.acegen.aceGen.AceGenPackage#getAttribute_SuperModels()
   * @model
   * @generated
   */
  EList<Model> getSuperModels();

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link de.acegen.aceGen.Attribute}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see de.acegen.aceGen.AceGenPackage#getAttribute_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<Attribute> getAttributes();

} // Attribute
