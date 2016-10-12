package com.anfelisa.extensions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.Project;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ActionExtension {
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
}
