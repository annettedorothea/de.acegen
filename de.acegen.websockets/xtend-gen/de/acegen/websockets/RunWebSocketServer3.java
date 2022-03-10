package de.acegen.websockets;

import com.google.inject.Guice;
import com.google.inject.Injector;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;
import org.eclipse.lsp4j.jsonrpc.Launcher;
import org.eclipse.lsp4j.jsonrpc.MessageConsumer;
import org.eclipse.lsp4j.launch.LSPLauncher;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.xtext.ide.server.LanguageServerImpl;
import org.eclipse.xtext.ide.server.ServerModule;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class RunWebSocketServer3 {
  public static void main(final String[] args) {
    String host = "localhost";
    int port = 4389;
    ServerModule _serverModule = new ServerModule();
    Injector injector = Guice.createInjector(_serverModule);
    InetSocketAddress _inetSocketAddress = new InetSocketAddress(host, port);
    AceGenWebSocketServer server = new AceGenWebSocketServer(_inetSocketAddress) {
      @Override
      public void run() {
        super.run();
      }
    };
    LanguageServerImpl languageServer = injector.<LanguageServerImpl>getInstance(LanguageServerImpl.class);
    final Function<MessageConsumer, MessageConsumer> _function = (MessageConsumer consumer) -> {
      MessageConsumer result = consumer;
      return result;
    };
    Function<MessageConsumer, MessageConsumer> wrapper = _function;
    Launcher<LanguageClient> launcher = new LSPLauncher.Builder<LanguageClient>().setLocalService(languageServer).setRemoteInterface(LanguageClient.class).setInput(server.in).setOutput(server.out).setExecutorService(Executors.newCachedThreadPool()).wrapMessages(wrapper).create();
    languageServer.connect(launcher.getRemoteProxy());
    Future<?> future = launcher.startListening();
    InputOutput.<String>println("gogogo");
    server.run();
    System.err.println("möööp");
    while ((!future.isDone())) {
      boolean _isDone = future.isDone();
      if (_isDone) {
        languageServer.shutdown();
      }
    }
  }
}
