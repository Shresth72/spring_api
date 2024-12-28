package com.one_time_token.magic_link.service;

import java.net.URI;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.ott.OneTimeToken;
import org.springframework.security.web.server.DefaultServerRedirectStrategy;
import org.springframework.security.web.server.ServerRedirectStrategy;
import org.springframework.security.web.server.authentication.ott.ServerOneTimeTokenGenerationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class MagiCLinkOneTimeTokenGenerationSuccessHandler
    implements ServerOneTimeTokenGenerationSuccessHandler {

  private final MailSenderService mailSender;

  private final ServerRedirectStrategy redirectStrategy = new DefaultServerRedirectStrategy();

  @Override
  public Mono<Void> handle(ServerWebExchange exchange, OneTimeToken oneTimeToken) {
    UriComponentsBuilder builder =
        UriComponentsBuilder.fromUri(exchange.getRequest().getURI())
            .replacePath(null)
            .replaceQuery(null)
            .fragment(null)
            .path("/login/ott")
            .queryParam("token", oneTimeToken.getTokenValue());

    String magicLink = builder.toUriString();
    builder.replacePath(null).replaceQuery(null).path("/ott/sent");

    String redirectLink = builder.toUriString();
    return this.mailSender
        .send(
            "johndoe@example.com",
            "Your Spring Security One Time Token",
            "Use the following link to sign in into the application: " + magicLink)
        .then(this.redirectStrategy.sendRedirect(exchange, URI.create(redirectLink)));
  }
}
