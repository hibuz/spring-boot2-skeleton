package com.hibuz.account.global.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder.encode("pass"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @ConditionalOnProperty(name="spring.h2.console.enabled", havingValue="true")
    protected SecurityFilterChain config(HttpSecurity http,
                                         @Value("${server.servlet.context-path}") String contextPath) throws Exception {
        log.info("http://localhost:8080{}/swagger-ui/index.html", contextPath);

        http.authorizeHttpRequests(authorize ->
                authorize.antMatchers("/v3/api-docs/**", "/swagger-ui/**").permitAll()
                        .antMatchers("/h2-console/**").permitAll()
                        .anyRequest().authenticated());

        http.headers(headers ->
                headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));

        http.csrf().disable();

        return http.build();
    }
}
