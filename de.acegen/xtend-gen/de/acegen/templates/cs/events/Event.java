/**
 * Copyright (c) 2020 Annette Pohl
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 * 
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */
package de.acegen.templates.cs.events;

import de.acegen.extensions.CommonExtension;
import javax.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class Event {
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  public CharSequence generateEvent() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("namespace AceGen");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public class Event<T> : IEvent<T> where T : IDataContainer");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("public string EventName { get; set; }");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("private ViewProvider viewProvider;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("public Event(string eventName, ViewProvider viewProvider)");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("this.EventName = eventName;");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("this.viewProvider = viewProvider;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("public void notifyListeners(T data)");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("var consumerList = this.viewProvider.GetConsumerForEvent(this.EventName);");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("if (consumerList != null)");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("foreach (System.Action<IDataContainer> consumer in consumerList)");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("consumer(data);");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("else if (this.viewProvider.GetAfterCommitConsumerForEvent(this.EventName) == null)");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("Console.WriteLine($\"No listeners for {this.EventName} found. Did you forget to register them?\");");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("public void notifyAfterCommitListeners(T data)");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("var consumerList = this.viewProvider.GetAfterCommitConsumerForEvent(this.EventName);");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("if (consumerList != null)");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("foreach (System.Action<IDataContainer> consumer in consumerList)");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("consumer(data);");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("else if (this.viewProvider.GetConsumerForEvent(this.EventName) == null)");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("{");
    _builder.newLine();
    _builder.newLine();
    _builder.append("                ");
    _builder.append("Console.WriteLine($\"No listeners for {this.EventName} found. Did you forget to register them?\");");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("public void publish(T data)");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("this.notifyListeners(data);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("public void publishAfterCommit(T data)");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("this.notifyAfterCommitListeners(data);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateIEvent() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("namespace AceGen");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public interface IEvent<T> where T : IDataContainer");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("string EventName { get; set; }");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("void publish(T data);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("void publishAfterCommit(T data);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("void notifyListeners(T data);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("void notifyAfterCommitListeners(T data);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
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
