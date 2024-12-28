package com.reactive.rsocket.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.rsocket.EnableRSocketSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;

@Configuration
@EnableRSocketSecurity
@AllArgsConstructor
public class SecurityConfiguration {

  @Bean
  public DefaultSecurityFilterChain securityWebFilterChain(HttpSecurity http) throws Exception {
    return http.authorizeHttpRequests(
            auth ->
                auth.anyRequest()
                    // .requestMatchers(new
                    // AntPathRequestMatcher("/")).permitAll())
                    .permitAll())
        .build();
  }
}
