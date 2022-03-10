package de.acegen.websockets;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.pmeade.websocket.net.WebSocket;
import com.pmeade.websocket.net.WebSocketServerSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;
import org.apache.log4j.Logger;
import org.eclipse.lsp4j.jsonrpc.Endpoint;
import org.eclipse.lsp4j.jsonrpc.Launcher;
import org.eclipse.lsp4j.jsonrpc.MessageConsumer;
import org.eclipse.lsp4j.jsonrpc.RemoteEndpoint;
import org.eclipse.lsp4j.jsonrpc.json.ConcurrentMessageProcessor;
import org.eclipse.lsp4j.jsonrpc.json.JsonRpcMethod;
import org.eclipse.lsp4j.jsonrpc.json.JsonRpcMethodProvider;
import org.eclipse.lsp4j.jsonrpc.json.MessageJsonHandler;
import org.eclipse.lsp4j.jsonrpc.json.StreamMessageProducer;
import org.eclipse.lsp4j.jsonrpc.services.ServiceEndpoints;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.server.LanguageServerImpl;
import org.eclipse.xtext.ide.server.ServerModule;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.Exceptions;

@Log
@SuppressWarnings("all")
public class RunWebSocketServer2 {
  public static void main(final String[] args) throws InterruptedException, IOException {
    ServerModule _serverModule = new ServerModule();
    Injector injector = Guice.createInjector(_serverModule);
    ServerSocket serverSocket = new ServerSocket(4389);
    WebSocketServerSocket webSocketServerSocket = new WebSocketServerSocket(serverSocket);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Language Server started.");
    RunWebSocketServer2.LOG.info(_builder);
    try {
      while (true) {
        {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("Waiting for client to connect to web socket on port ");
          int _localPort = serverSocket.getLocalPort();
          _builder_1.append(_localPort);
          _builder_1.append(" ...");
          RunWebSocketServer2.LOG.info(_builder_1);
          WebSocket webSocket = webSocketServerSocket.accept();
          try {
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append("Connected.");
            RunWebSocketServer2.LOG.info(_builder_2);
            LanguageServerImpl languageServer = injector.<LanguageServerImpl>getInstance(LanguageServerImpl.class);
            final Function<MessageConsumer, MessageConsumer> _function = (MessageConsumer consumer) -> {
              MessageConsumer result = consumer;
              return result;
            };
            Function<MessageConsumer, MessageConsumer> wrapper = _function;
            Launcher<LanguageClient> launcher = RunWebSocketServer2.<LanguageClient>createSocketLauncher(languageServer, LanguageClient.class, 
              Executors.newCachedThreadPool(), wrapper, webSocket.getInputStream(), 
              webSocket.getOutputStream());
            languageServer.connect(launcher.getRemoteProxy());
            Future<?> future = launcher.startListening();
            while ((!future.isDone())) {
              boolean _isDone = future.isDone();
              if (_isDone) {
                webSocket.close();
                languageServer.shutdown();
              }
            }
          } catch (final Throwable _t) {
            if (_t instanceof Exception) {
              final Exception e = (Exception)_t;
              e.printStackTrace();
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        }
      }
    } finally {
      webSocketServerSocket.close();
      RunWebSocketServer2.LOG.info("Language Server stopped.");
    }
  }
  
  static <T extends Object> Launcher<T> createSocketLauncher(final Object localService, final Class<T> remoteInterface, final ExecutorService executorService, final Function<MessageConsumer, MessageConsumer> wrapper, final InputStream inputStream, final OutputStream outputStream) throws IOException {
    return RunWebSocketServer2.<T>createIoLauncher(localService, remoteInterface, inputStream, outputStream, executorService, wrapper);
  }
  
  static <T extends Object> Launcher<T> createIoLauncher(final Object localService, final Class<T> remoteInterface, final InputStream in, final OutputStream out, final ExecutorService executorService, final Function<MessageConsumer, MessageConsumer> wrapper) {
    Map<String, JsonRpcMethod> supportedMethods = new LinkedHashMap<String, JsonRpcMethod>();
    supportedMethods.putAll(ServiceEndpoints.getSupportedMethods(remoteInterface));
    if ((localService instanceof JsonRpcMethodProvider)) {
      JsonRpcMethodProvider rpcMethodProvider = ((JsonRpcMethodProvider) localService);
      supportedMethods.putAll(rpcMethodProvider.supportedMethods());
    } else {
      supportedMethods.putAll(ServiceEndpoints.getSupportedMethods(localService.getClass()));
    }
    MessageJsonHandler jsonHandler = new MessageJsonHandler(supportedMethods);
    MessageConsumer outGoingMessageStream = new StreamMessageConsumer2(out, jsonHandler);
    outGoingMessageStream = wrapper.apply(outGoingMessageStream);
    Endpoint _endpoint = ServiceEndpoints.toEndpoint(localService);
    final RemoteEndpoint serverEndpoint = new RemoteEndpoint(outGoingMessageStream, _endpoint);
    jsonHandler.setMethodProvider(serverEndpoint);
    final MessageConsumer messageConsumer = wrapper.apply(serverEndpoint);
    final StreamMessageProducer reader = new StreamMessageProducer(in, jsonHandler);
    final T remoteProxy2 = ServiceEndpoints.<T>toServiceObject(serverEndpoint, remoteInterface);
    return new Launcher<T>() {
      @Override
      public Future<Void> startListening() {
        return ConcurrentMessageProcessor.startProcessing(reader, messageConsumer, executorService);
      }
      
      @Override
      public T getRemoteProxy() {
        return remoteProxy2;
      }
      
      @Override
      public RemoteEndpoint getRemoteEndpoint() {
        return serverEndpoint;
      }
    };
  }
  
  private static final Logger LOG = Logger.getLogger(RunWebSocketServer2.class);
}
