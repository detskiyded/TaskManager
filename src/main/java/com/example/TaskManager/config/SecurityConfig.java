package com.example.TaskManager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final PasswordEncoder pwEncoder =
            PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                // Отключаем сессии для stateless REST API
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )

                // Отключаем CSRF для REST
                .csrf(AbstractHttpConfigurer::disable)

                // Включаем Http Basic Auth для api-клиентов
                .httpBasic(basic -> basic.realmName("TaskManager API"))

                // Отключение form login (не нужно для REST)
                .formLogin(AbstractHttpConfigurer::disable)

                // Правила авторизации
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/tasks/**").authenticated() // Все задачи - только авторизованным
                        .anyRequest().permitAll() // Остальное - всем
                );
        return http.build();
    }

    @Bean
    UserDetailsService authentication(){
        UserDetails admin = User.builder()
                .username("admin")
                .password(pwEncoder.encode("adminpass"))
                .roles("USER", "ADMIN")
                .build();
        UserDetails user = User.builder()
                .username("user")
                .password(pwEncoder.encode("qwerty"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

}
