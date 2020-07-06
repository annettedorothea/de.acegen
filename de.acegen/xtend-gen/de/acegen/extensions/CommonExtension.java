/**
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 * 
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */
package de.acegen.extensions;

import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class CommonExtension {
  public String copyright() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/* ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Copyright (c) 2020, Annette Pohl, Koblenz, Germany");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Permission to use, copy, modify, and/or distribute this software for any");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* purpose with or without fee is hereby granted, provided that the above");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* copyright notice and this permission notice appear in all copies.");
    _builder.newLine();
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* THE SOFTWARE IS PROVIDED \"AS IS\" AND THE AUTHOR DISCLAIMS ALL WARRANTIES");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* generated with de.acegen 0.9.2");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    return _builder.toString();
  }
  
  public String sdg() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.newLine();
    _builder.append("/******* S.D.G. *******/");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    return _builder.toString();
  }
}
