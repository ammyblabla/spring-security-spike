package com.example.spikespringsecurity.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.example.spikespringsecurity.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
  private final PasswordEncoder passwordEncoder;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .authorizeRequests()
        .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
        .antMatchers("/api/**").hasRole(STUDENT.name())
        .anyRequest()
        .authenticated()
        .and()
        .httpBasic();
  }

  @Override
  @Bean
  protected UserDetailsService userDetailsService() {
    UserDetails anna = User.builder()
        .username("anna")
        .password(passwordEncoder.encode("password123"))
        .authorities(STUDENT.getGrantedAuthorities())
        .build();

    UserDetails linda = User.builder()
        .username("linda")
        .password(passwordEncoder.encode("password123"))
        .authorities(ADMIN.getGrantedAuthorities())
        .build();

    UserDetails tom = User.builder()
        .username("tom")
        .password(passwordEncoder.encode("password123"))
        .authorities(ADMINTRAINEE.getGrantedAuthorities())
        .build();

    return new InMemoryUserDetailsManager(anna, linda, tom);
  }
}
