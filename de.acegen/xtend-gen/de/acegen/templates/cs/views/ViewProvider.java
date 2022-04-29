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
package de.acegen.templates.cs.views;

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
    _builder.append("namespace AceGen");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public class ViewProvider");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("private Dictionary<string, List<System.Action<IDataContainer>>> ConsumerMap;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("private Dictionary<string, List<System.Action<IDataContainer>>> AfterCommitConsumerMap;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("public ViewProvider()");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("ConsumerMap = new Dictionary<string, List<System.Action<IDataContainer>>>();");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("AfterCommitConsumerMap = new Dictionary<string, List<System.Action<IDataContainer>>>();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("public void AddConsumer(string name, System.Action<IDataContainer> eventConsumer) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("var consumerForEvent = ConsumerMap.FirstOrDefault(e => e.Key == name).Value;");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("if (consumerForEvent == null) {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("consumerForEvent = new List<System.Action<IDataContainer>>();");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("ConsumerMap[name] = (consumerForEvent);");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("consumerForEvent.Add(eventConsumer);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("public void AddAfterCommitConsumer(string name, System.Action<IDataContainer> eventConsumer) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("var consumerForEvent = AfterCommitConsumerMap.FirstOrDefault(e => e.Key == name).Value;");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("if (consumerForEvent == null) {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("consumerForEvent = new List<System.Action<IDataContainer>>();");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("AfterCommitConsumerMap[name] = (consumerForEvent);");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("consumerForEvent.Add(eventConsumer);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("public List<System.Action<IDataContainer>> GetConsumerForEvent(string name) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("return ConsumerMap.FirstOrDefault(e => e.Key == name).Value;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("public List<System.Action<IDataContainer>> GetAfterCommitConsumerForEvent(string name) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("return AfterCommitConsumerMap.FirstOrDefault(e => e.Key == name).Value;");
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
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
}
