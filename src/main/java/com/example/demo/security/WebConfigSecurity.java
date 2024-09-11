package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebConfigSecurity {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .csrf().disable()  // Desativa o CSRF para testes, certifique-se de ajustar no ambiente de produção
	        .authorizeRequests(authorizeRequests ->
	            authorizeRequests
	                .requestMatchers(HttpMethod.GET, "/api/**").permitAll()  // Permite GET em todos os endpoints dentro de /api
	                .requestMatchers(HttpMethod.POST, "/api/**").permitAll() // Permite POST em todos os endpoints dentro de /api
	                .requestMatchers(HttpMethod.DELETE, "/api/**").permitAll() // Permite DELETE em todos os endpoints dentro de /api
	                .anyRequest().authenticated()  // Exige autenticação para outras requisições
	        )
	        .formLogin(formLogin ->
	            formLogin
	                .loginPage("/login")
	                .permitAll()
	        )
	        .logout(logout -> logout.permitAll());

	    return http.build();
	}
}
