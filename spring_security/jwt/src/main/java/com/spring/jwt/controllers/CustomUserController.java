package com.spring.jwt.controllers;

import com.spring.jwt.models.CustomUsers;
import com.spring.jwt.services.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomUserController {

  @Autowired private CustomUserService service;

  @PostMapping("/register")
  public CustomUsers register(@RequestBody CustomUsers user) {
    return service.register(user);
  }

  @PostMapping("/login")
  public String login(@RequestBody CustomUsers user) {
    return service.verify(user);
  }
}
