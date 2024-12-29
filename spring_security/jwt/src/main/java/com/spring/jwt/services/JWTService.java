package com.spring.jwt.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import org.springframework.stereotype.Service;

@Service
public class JWTService {

  private String secretKey = "";

  public JWTService() {
    try {
      KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
      SecretKey sk = keyGen.generateKey();
      secretKey = Base64.getEncoder().encodeToString(sk.getEncoded());
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }

  public String generateToken(String username) {

    Map<String, Object> claims = new HashMap<>();

    return Jwts.builder()
        .claims()
        .add(claims)
        .subject(username)
        .issuedAt(new Date(System.currentTimeMillis()))
        .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
        .and()
        .signWith(getKey())
        .compact();
  }

  public Key getKey() {
    byte[] keyBytes = Decoders.BASE64.decode(secretKey);
    return Keys.hmacShaKeyFor(keyBytes);
  }
}