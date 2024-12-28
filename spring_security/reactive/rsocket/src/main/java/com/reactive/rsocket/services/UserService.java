package com.reactive.rsocket.services;

import com.reactive.rsocket.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UserService implements ReactiveUserDetailsService {

  private final UserRepository userRepository;

  public Mono<UserDetails> findByUsername(String username) {

    return userRepository
        .findByUsername(username)
        .map(
            user ->
                User.withUsername(user.getUsername())
                    .password(user.getPassword())
                    .roles(user.getRole())
                    .build());
  }

  public Mono<com.reactive.rsocket.models.User> findByUsernameNormal(String username) {
    return userRepository.findByUsername(username);
  }
}
