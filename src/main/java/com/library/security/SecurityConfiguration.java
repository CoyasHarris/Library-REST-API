package com.library.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.DELETE).hasRole("LIBRARIAN")
                .antMatchers(HttpMethod.POST).hasRole("LIBRARIAN")
                .antMatchers("/client/**").hasRole("LIBRARIAN")
                .antMatchers("/librarian/**").hasRole("LIBRARIAN")
                .antMatchers("/lending/**").hasRole("LIBRARIAN")
                .antMatchers(HttpMethod.GET , "/book").permitAll()
                
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                 .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();
    }

    @Bean
    public UserDetailsService users() {
        UserDetails admin = User.builder()
                .username("librarian")
                .password(passwordEncoder().encode("1234"))
                .roles("LIBRARIAN")
                .build();

        UserDetails user = User.builder()
                .username("client")
                .password(passwordEncoder().encode("1234"))
                .roles("CLIENT")
                .build();

        return new InMemoryUserDetailsManager(admin, user);

    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
