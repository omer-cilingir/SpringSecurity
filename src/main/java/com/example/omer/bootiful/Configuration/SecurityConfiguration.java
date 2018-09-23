package com.example.omer.bootiful.Configuration;

import static org.springframework.security.core.userdetails.User.withUsername;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfiguration {


  @Bean
  public SecurityWebFilterChain securitygWebFilterChain(
      ServerHttpSecurity http) {
    return http.authorizeExchange()
        .pathMatchers("authHello").authenticated()
        .anyExchange().permitAll()
        .and().build();
  }

  @Bean
  public MapReactiveUserDetailsService userDetailsService() {
    UserDetails user = withUsername("user")
        .password("password")
        .roles("USER")
        .build();
    UserDetails admin = User
        .withUsername("admin")
        .password("password")
        .roles("ADMIN")
        .build();
    return new MapReactiveUserDetailsService(user, admin);
  }
}
