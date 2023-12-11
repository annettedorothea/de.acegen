package de.acegen.templates.java;

import de.acegen.extensions.CommonExtension;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class FormData {
  @Extension
  private CommonExtension _commonExtension;

  public CharSequence generate() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.io.InputStream;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.glassfish.jersey.media.multipart.ContentDisposition;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.annotation.JsonIgnoreType;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@JsonIgnoreType");
    _builder.newLine();
    _builder.append("public class FormData {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private ContentDisposition contentDisposition;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private InputStream inputStream;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public FormData(ContentDisposition contentDisposition, InputStream inputStream) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.contentDisposition = contentDisposition;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.inputStream = inputStream;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ContentDisposition getContentDisposition() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return contentDisposition;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public InputStream getInputStream() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return inputStream;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
}
