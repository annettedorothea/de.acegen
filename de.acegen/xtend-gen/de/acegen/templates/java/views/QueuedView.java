package de.acegen.templates.java.views;

import de.acegen.extensions.CommonExtension;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class QueuedView {
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
    _builder.append("import java.util.concurrent.ArrayBlockingQueue;");
    _builder.newLine();
    _builder.append("import java.util.concurrent.BlockingQueue;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import io.dropwizard.lifecycle.Managed;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public abstract class QueuedView implements Managed {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private Thread thread;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private final BlockingQueue<Runnable> queue;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private boolean stop;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(QueuedView.class);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public QueuedView() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("queue = new ArrayBlockingQueue<>(20);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void addToQueue(Runnable runnable) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("queue.add(runnable);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void start() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("thread = new Thread(() -> {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("LOG.info(\"started queued view\");");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("while (!stop || queue.size() > 0) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("queue.take().run();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("} catch (InterruptedException e) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("LOG.error(\"error in queued view\", e);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("});");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("thread.start();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void stop() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for (int i = 0; i < 3; i++) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("LOG.info(\"stopping queued view...\");");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (!canStop()) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("LOG.info(\"waiting for queued view to complete...\");");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("Thread.sleep(1000);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("} catch (InterruptedException e) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("LOG.error(\"error when stopping queued view\", e);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("break;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("LOG.info(\"queued view stopped\");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract boolean canStop(); ");
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
