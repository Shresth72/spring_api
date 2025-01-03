package com.reactive.rsocket.repositories;

import com.reactive.rsocket.models.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User, Long> {
  Mono<User> findByUsername(String username);
}
