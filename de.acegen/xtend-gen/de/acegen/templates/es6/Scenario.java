package de.acegen.templates.es6;

import de.acegen.aceGen.ClientGivenRef;
import de.acegen.aceGen.ClientScenario;
import de.acegen.extensions.CommonExtension;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class Scenario {
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  public CharSequence generateScenarioUtils() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateScenario(final ClientScenario it) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("context(\'");
    String _name = it.getName();
    _builder.append(_name);
    _builder.append("\', () => {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("beforeEach(() => {");
    _builder.newLine();
    {
      EList<ClientGivenRef> _givenRefs = it.getGivenRefs();
      for(final ClientGivenRef givenRef : _givenRefs) {
        _builder.append("    \t");
        _builder.append("// ");
        String _name_1 = givenRef.getScenario().getName();
        _builder.append(_name_1, "    \t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("    \t");
    _builder.newLine();
    {
      String _uuid = it.getWhenBlock().getUuid();
      boolean _tripleNotEquals = (_uuid != null);
      if (_tripleNotEquals) {
        _builder.append("    \t");
        _builder.append("localStorage.setItem(\"uuid\", \"whenBlock.uuid\")");
        _builder.newLine();
      }
    }
    _builder.append("        ");
    _builder.append("AppUtils.httpPut(\'/api/test/non-deterministic/system-time?uuid=9d0723a3&system-time=2020-07-07T16:30:21\')");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("cy.visit(\'http://127.0.0.1:9999/\')");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("cy.get(\'#newTodoInput\').type(\'NEW\')");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("})");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("it(\'should reset newTodo and reload todoList\', () => {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("const lastAppState = JSON.parse(localStorage.getItem(\'appState\'));");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("cy.get(\'#newTodoInput\').type(String.fromCharCode(13)).should(() => {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("const appState = JSON.parse(localStorage.getItem(\'appState\'));");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("expect(appState.newTodo, \'reset newTodo\').to.eq(\'\')");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("expect(appState.todoList.length).to.eq(lastAppState.todoList.length + 1)");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("expect(appState.todoList[appState.todoList.length - 1].description).to.eq(\'NEW\')");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("expect(appState.todoList[appState.todoList.length - 1].done).to.eq(false)");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("})");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("})");
    _builder.newLine();
    _builder.append("})");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
}
