package com.anfelisa.extensions;

import com.anfelisa.ace.Project;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ProjectExtension {
  public String packageFolder(final Project it) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = it.getName();
    String _replace = _name.replace(".", "/");
    _builder.append(_replace, "");
    return _builder.toString();
  }
  
  public String projectName(final Project it) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = it.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    return _builder.toString();
  }
}
