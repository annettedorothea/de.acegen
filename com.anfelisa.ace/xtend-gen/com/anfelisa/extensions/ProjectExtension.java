package com.anfelisa.extensions;

import com.anfelisa.ace.Project;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class ProjectExtension {
  public String packageFolder(final Project it) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = it.getName();
    String _replace = _name.replace(".", "/");
    _builder.append(_replace, "");
    return _builder.toString();
  }
}
