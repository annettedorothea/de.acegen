package com.anfelisa.extensions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.Data;
import com.anfelisa.ace.Project;
import com.anfelisa.extensions.DataExtension;
import javax.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ActionExtension {
  @Inject
  @Extension
  private DataExtension _dataExtension;
  
  public String abstractActionName(final Action it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Abstract");
    String _name = it.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append("Action");
    return _builder.toString();
  }
  
  public String actionName(final Action it) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = it.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append("Action");
    return _builder.toString();
  }
  
  public String abstractName(final Action it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Abstract");
    String _name = it.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    return _builder.toString();
  }
  
  public String nameUppercase(final Action it) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = it.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    return _builder.toString();
  }
  
  public String resourceName(final Action it) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = it.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append("Resource");
    return _builder.toString();
  }
  
  public String actionNameWithPackage(final Action it) {
    StringConcatenation _builder = new StringConcatenation();
    EObject _eContainer = it.eContainer();
    String _name = ((Project) _eContainer).getName();
    _builder.append(_name, "");
    _builder.append(".actions.");
    String _actionName = this.actionName(it);
    _builder.append(_actionName, "");
    return _builder.toString();
  }
  
  public String newAction(final Action it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("final ");
    String _actionNameWithPackage = this.actionNameWithPackage(it);
    _builder.append(_actionNameWithPackage, "");
    _builder.append(" action = new ");
    String _actionNameWithPackage_1 = this.actionNameWithPackage(it);
    _builder.append(_actionNameWithPackage_1, "");
    _builder.append("(");
    Data _data = it.getData();
    CharSequence _newFromCommandData = this._dataExtension.newFromCommandData(_data);
    _builder.append(_newFromCommandData, "");
    _builder.append(", DatabaseService.getDatabaseHandle());");
    return _builder.toString();
  }
}
