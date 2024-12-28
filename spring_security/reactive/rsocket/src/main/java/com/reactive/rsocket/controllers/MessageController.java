package com.reactive.rsocket.controllers;

import com.reactive.rsocket.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
@AllArgsConstructor
public class MessageController {

  private final UserService userService;

  @MessageMapping("message")
  public Mono<String> message() {
    return Mono.just("Hello");
  }

  @MessageMapping("user.details")
  public Mono<UserDetails> getUserDetails(String username) {
    return userService.findByUsername(username);
  }
}
