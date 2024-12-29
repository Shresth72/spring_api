package com.spring.jwt.services;

import com.spring.jwt.models.CustomUserDetails;
import com.spring.jwt.models.CustomUsers;
import com.spring.jwt.repositories.CustomUserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired private CustomUserDetailsRepository repository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    CustomUsers user = repository.findByUsername(username);
    if (user == null) {
      System.out.println("User Not Found");
      throw new UsernameNotFoundException("user not found");
    }

    return new CustomUserDetails(user);
  }
}
