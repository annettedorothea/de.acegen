/**
 * Copyright (c) 2016 itemis AG (http://www.itemis.de) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package de.acegen.ide;

import com.google.inject.Guice;
import com.google.inject.Inject;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.concurrent.Future;
import org.eclipse.lsp4j.jsonrpc.Launcher;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.xtext.ide.server.LanguageServerImpl;
import org.eclipse.xtext.ide.server.ServerModule;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.11
 */
@SuppressWarnings("all")
public class ServerLauncher {
  private static boolean IS_DEBUG = true;
  
  public static void main(final String[] args) {
    final InputStream stdin = System.in;
    final PrintStream stdout = System.out;
    ServerLauncher.redirectStandardStreams();
    ServerModule _serverModule = new ServerModule();
    final ServerLauncher launcher = Guice.createInjector(_serverModule).<ServerLauncher>getInstance(ServerLauncher.class);
    launcher.start(stdin, stdout);
  }
  
  @Inject
  private LanguageServerImpl languageServer;
  
  public void start(final InputStream in, final OutputStream out) {
    try {
      System.err.println("Starting Xtext Language Server.");
      String _name = ServerLauncher.class.getName();
      String _plus = (_name + "-");
      long _currentTimeMillis = System.currentTimeMillis();
      String _replaceAll = new Timestamp(_currentTimeMillis).toString().replaceAll(" ", "_");
      final String id = (_plus + _replaceAll);
      FileOutputStream _fileOutputStream = new FileOutputStream((("/Users/dietrich/logs/xxx-" + id) + ".log"));
      PrintWriter _printWriter = new PrintWriter(_fileOutputStream, true);
      final Launcher<LanguageClient> launcher = Launcher.<LanguageClient>createLauncher(this.languageServer, LanguageClient.class, in, out, true, _printWriter);
      this.languageServer.connect(launcher.getRemoteProxy());
      final Future<Void> future = launcher.startListening();
      System.err.println("started.");
      while ((!future.isDone())) {
        Thread.sleep(10_000l);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static void redirectStandardStreams() {
    try {
      byte[] _newByteArrayOfSize = new byte[0];
      ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_newByteArrayOfSize);
      System.setIn(_byteArrayInputStream);
      String _name = ServerLauncher.class.getName();
      String _plus = (_name + "-");
      long _currentTimeMillis = System.currentTimeMillis();
      String _replaceAll = new Timestamp(_currentTimeMillis).toString().replaceAll(" ", "_");
      final String id = (_plus + _replaceAll);
      if (ServerLauncher.IS_DEBUG) {
        final FileOutputStream stdFileOut = new FileOutputStream((("/Users/dietrich/logs/out-" + id) + ".log"));
        PrintStream _printStream = new PrintStream(stdFileOut, true);
        System.setOut(_printStream);
        final FileOutputStream stdFileErr = new FileOutputStream((("/Users/dietrich/logs/error-" + id) + ".log"));
        PrintStream _printStream_1 = new PrintStream(stdFileErr, true);
        System.setErr(_printStream_1);
      } else {
        ByteArrayOutputStream _byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream _printStream_2 = new PrintStream(_byteArrayOutputStream);
        System.setOut(_printStream_2);
        ByteArrayOutputStream _byteArrayOutputStream_1 = new ByteArrayOutputStream();
        PrintStream _printStream_3 = new PrintStream(_byteArrayOutputStream_1);
        System.setErr(_printStream_3);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
