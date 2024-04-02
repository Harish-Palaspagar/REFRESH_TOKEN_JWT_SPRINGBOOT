package com.refresh.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.refresh.helper.JwtAuthenticationFilter;
import com.refresh.security.JwtAuthenticationEntryPoint;

@Configuration
public class SecurityConfiguration {
	

    @Autowired
    private JwtAuthenticationEntryPoint point;
    
    @Autowired
    private JwtAuthenticationFilter filter;
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

	@Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
                .cors(cors->cors.disable())
                .authorizeHttpRequests(requests -> requests
                		.requestMatchers("/jwt/**").authenticated()
                		.requestMatchers("/auth/login")
                		.permitAll()
                		.requestMatchers("/auth/create")
                		.permitAll()
                        .anyRequest()
                        .authenticated())
                        .exceptionHandling(ex -> ex
                        .authenticationEntryPoint(point))
                        .sessionManagement(session -> session
                		.sessionCreationPolicy(SessionCreationPolicy
                		.STATELESS));// we do not have to store anything on server that is why we used this
                         http
                        .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
                        return http.build();
    }
	
	@Bean
    DaoAuthenticationProvider daoAuthenticationProvider()
    {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
		return daoAuthenticationProvider;
    }

}
