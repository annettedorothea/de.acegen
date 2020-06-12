package de.acegen.templates.java.events;

import de.acegen.extensions.CommonExtension;
import javax.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class EventConsumer {
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  public CharSequence generateEventconsumer() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@FunctionalInterface");
    _builder.newLine();
    _builder.append("public interface EventConsumer {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void consumeEvent(IDataContainer data, PersistenceHandle handle);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
}
