package com.appsdeveloperblog.tutorials.legacyusersservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity(debug = true)
@EnableMethodSecurity(prePostEnabled = true)
public class WebSecurity {

	@Bean 
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
		
		http.csrf(csrf -> csrf.disable());
		http.cors( cors -> cors.disable()); 
		http.sessionManagement((
				SessionManagementConfigurer<HttpSecurity> httpSecuritySessionManagementConfigurer) -> httpSecuritySessionManagementConfigurer
						.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		return http.build();

	}
}
