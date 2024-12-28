package com.reactive.rsocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class MessageController {

  @MessageMapping("message")
  public Mono<String> message() {
    return Mono.just("Hello");
  }
}
