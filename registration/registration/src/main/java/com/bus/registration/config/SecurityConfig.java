package com.bus.registration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//Tags the class as a source of bean definitions for the application context.
@Configuration
public class SecurityConfig {

	//Spring is used to indicate that a method produces a bean to be managed by the Spring container.
	@Bean
	public PasswordEncoder passwordEncoder()
	{
        return new BCryptPasswordEncoder(); 
	}
}
