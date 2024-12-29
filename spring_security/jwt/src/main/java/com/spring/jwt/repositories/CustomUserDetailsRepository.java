package com.spring.jwt.repositories;

import com.spring.jwt.models.CustomUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomUserDetailsRepository extends JpaRepository<CustomUsers, Integer> {
  CustomUsers findByUsername(String username);
}
