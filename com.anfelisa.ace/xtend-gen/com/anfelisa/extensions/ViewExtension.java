package com.anfelisa.extensions;

import com.anfelisa.ace.View;
import com.anfelisa.ace.ViewFunction;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ViewExtension {
  public String viewName(final View it) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = it.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append("View");
    return _builder.toString();
  }
  
  public String viewFunctionWithViewName(final ViewFunction it) {
    StringConcatenation _builder = new StringConcatenation();
    EObject _eContainer = it.eContainer();
    String _viewName = this.viewName(((View) _eContainer));
    _builder.append(_viewName, "");
    _builder.append(".");
    String _name = it.getName();
    _builder.append(_name, "");
    return _builder.toString();
  }
}
