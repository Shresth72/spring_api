package com.reactive.rclient;

import io.rsocket.core.RSocketConnector;
import io.rsocket.transport.netty.client.TcpClientTransport;

public class RSocketClient {

  public static void main(String[] args) {
    var rSocket =
        RSocketConnector.create().connect(TcpClientTransport.create("localhost", 7000)).block();
  }
}
