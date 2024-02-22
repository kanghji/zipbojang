package com.example.zipbojang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration{
	 
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		http.headers().frameOptions().sameOrigin();
		
		http
			.authorizeHttpRequests((authz) -> authz
					.anyRequest().permitAll()
			);
		
		System.out.println("********** SpringSecurity start *************");
		
		return http.build();
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        System.out.println("********** PasswordEncoder ***********");
        return new BCryptPasswordEncoder();
    }
	

}
