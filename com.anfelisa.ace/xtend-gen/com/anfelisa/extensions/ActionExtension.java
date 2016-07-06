package com.anfelisa.extensions;

import com.anfelisa.ace.Action;
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
}
