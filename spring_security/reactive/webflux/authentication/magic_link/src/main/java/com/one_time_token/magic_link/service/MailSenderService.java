package com.one_time_token.magic_link.service;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service("MailSender")
@AllArgsConstructor
public class MailSenderService {

  private final JavaMailSender mailSender;

  public Mono<Void> send(String to, String subject, String text) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom("noreply@example.com");
    message.setTo(to);
    message.setSubject(subject);
    message.setText(text);

    return Mono.fromRunnable(() -> this.mailSender.send(message));
  }
}
