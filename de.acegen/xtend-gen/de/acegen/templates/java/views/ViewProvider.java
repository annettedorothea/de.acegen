package de.acegen.templates.java.views;

import de.acegen.extensions.CommonExtension;
import javax.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class ViewProvider {
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  public CharSequence generateViewProvider() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ViewProvider extends AbstractViewProvider {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ViewProvider() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static ViewProvider create(IDaoProvider daoProvider, CustomAppConfiguration configuration) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return new ViewProvider();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateAbstractViewProvider() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.util.ArrayList;");
    _builder.newLine();
    _builder.append("import java.util.HashMap;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import java.util.Map;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class AbstractViewProvider {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private final Map<String, List<EventConsumer>> consumerMap;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public AbstractViewProvider() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("consumerMap = new HashMap<String, List<EventConsumer>>();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void addConsumer(String eventName, EventConsumer eventConsumer) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("List<EventConsumer> consumerForEvent = consumerMap.get(eventName);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (consumerForEvent == null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("consumerForEvent = new ArrayList<EventConsumer>();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("consumerMap.put(eventName, consumerForEvent);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("consumerForEvent.add(eventConsumer);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public List<EventConsumer> getConsumerForEvent(String eventName) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return consumerMap.get(eventName);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
}
