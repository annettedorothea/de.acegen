package de.acegen.websockets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

@SuppressWarnings("all")
public class AceGenWebSocketServer extends WebSocketServer {
  public ByteArrayOutputStream out = new ByteArrayOutputStream() {
    @Override
    public void flush() throws IOException {
      super.flush();
      byte[] _byteArray = this.toByteArray();
      String s = new String(_byteArray, StandardCharsets.UTF_8);
      int i = s.indexOf("\r\n\r\n");
      if ((i > 0)) {
        s = s.substring((i + 4));
      }
      InputOutput.<String>println(s);
      AceGenWebSocketServer.this.conn.send(s);
      this.reset();
    }
  };
  
  private PipedOutputStream pipe = new PipedOutputStream();
  
  public PipedInputStream in = new Function0<PipedInputStream>() {
    @Override
    public PipedInputStream apply() {
      try {
        PipedInputStream _pipedInputStream = new PipedInputStream(AceGenWebSocketServer.this.pipe);
        return _pipedInputStream;
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
  }.apply();
  
  private WebSocket conn;
  
  public AceGenWebSocketServer(final InetSocketAddress a) {
    super(a);
  }
  
  @Override
  public void onClose(final WebSocket conn, final int code, final String reason, final boolean remote) {
  }
  
  @Override
  public void onError(final WebSocket conn, final Exception ex) {
    ex.printStackTrace();
  }
  
  @Override
  public void onMessage(final WebSocket conn, final String message) {
    try {
      System.err.println(("message: " + message));
      int _length = message.length();
      String _plus = ("Content-Length: " + Integer.valueOf(_length));
      this.pipe.write((_plus + "\r\n\r\n").getBytes(StandardCharsets.US_ASCII));
      this.pipe.write(message.getBytes(StandardCharsets.UTF_8));
      this.pipe.flush();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public void onOpen(final WebSocket conn, final ClientHandshake handshake) {
    System.err.println("open");
    this.conn = conn;
  }
  
  @Override
  public void onStart() {
    System.err.println("start");
  }
}
