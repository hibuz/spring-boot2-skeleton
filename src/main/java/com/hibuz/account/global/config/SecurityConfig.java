package com.hibuz.account.global.config;

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

import com.hibuz.account.global.common.Constants;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.builder()
                .username(Constants.USER)
                .password(passwordEncoder.encode(Constants.PASSWORD))
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
    protected SecurityFilterChain config(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize ->
                authorize.antMatchers("/v3/api-docs/**", "/swagger-ui/**", "/webjars/**").permitAll()
                        .antMatchers("/h2-console/**").permitAll()
                        .antMatchers("/open/**").permitAll()
                        .antMatchers("/adonis-track/**").permitAll()
                        .anyRequest().authenticated());

        http.headers(headers ->
                headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));

        http.csrf().disable();

        return http.build();
    }
}
