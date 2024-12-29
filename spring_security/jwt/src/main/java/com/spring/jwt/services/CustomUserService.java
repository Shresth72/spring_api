package com.spring.jwt.services;

import com.spring.jwt.models.CustomUsers;
import com.spring.jwt.repositories.CustomUserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService {

  @Autowired private CustomUserDetailsRepository repository;

  @Autowired AuthenticationManager authManager;

  @Autowired private JWTService jwtService;

  private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

  public CustomUsers register(CustomUsers user) {
    user.setPassword(encoder.encode(user.getPassword()));
    return repository.save(user);
  }

  public String verify(CustomUsers user) {
    Authentication authentication =
        authManager.authenticate(
            new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

    if (authentication.isAuthenticated()) {
      return jwtService.generateToken(user.getUsername());
    } else {
      return "Failure";
    }
  }
}
