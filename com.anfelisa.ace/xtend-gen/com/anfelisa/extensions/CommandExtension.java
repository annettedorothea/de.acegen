package com.anfelisa.extensions;

import com.anfelisa.ace.Command;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class CommandExtension {
  public String abstractCommandName(final Command it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Abstract");
    String _name = it.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append("Command");
    return _builder.toString();
  }
  
  public String commandName(final Command it) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = it.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append("Command");
    return _builder.toString();
  }
}
