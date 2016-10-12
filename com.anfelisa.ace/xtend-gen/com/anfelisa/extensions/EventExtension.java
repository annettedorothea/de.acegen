package com.anfelisa.extensions;

import com.anfelisa.ace.Event;
import com.anfelisa.ace.Project;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class EventExtension {
  public String eventName(final Event it) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = it.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append("Event");
    return _builder.toString();
  }
  
  public String abstractEventName(final Event it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Abstract");
    String _name = it.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append("Event");
    return _builder.toString();
  }
  
  public String eventNameWithPackage(final Event it) {
    StringConcatenation _builder = new StringConcatenation();
    EObject _eContainer = it.eContainer();
    String _name = ((Project) _eContainer).getName();
    _builder.append(_name, "");
    _builder.append(".events.");
    String _eventName = this.eventName(it);
    _builder.append(_eventName, "");
    return _builder.toString();
  }
}
