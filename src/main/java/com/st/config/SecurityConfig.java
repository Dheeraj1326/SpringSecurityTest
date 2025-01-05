package com.st.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.st.service.MyUserDetailService;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private MyUserDetailService userDetailService;
	
	@Bean
	public SecurityFilterChain getSecure(HttpSecurity http) throws Exception {

//		 http.csrf(customizer -> customizer.disable()); 
//		 http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
//		 http.formLogin(Customizer.withDefaults()); //This Enable Form Login
//		 http.httpBasic(Customizer.withDefaults());  //This Enable Postman Hit
//		 http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//       return http.build();		 
		 // Same Thing in builder Pattern 
		
		return http
				.csrf(customizer -> customizer.disable())
				.authorizeHttpRequests(request -> request.anyRequest().authenticated())
				.formLogin(Customizer.withDefaults())
				.httpBasic(Customizer.withDefaults())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.build();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setUserDetailsService(userDetailService);
		return provider;
	}

}
