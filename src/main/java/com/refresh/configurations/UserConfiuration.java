package com.refresh.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserConfiuration {
	
	
	// we are not using this anymore check class custom user detail service

//	@Bean
// UserDetailsService userDetailsService()
// {
//	 // we will use user from spring security for testing purpose
//	 UserDetails adminUser1 = User.builder()
//	 .username("harish")
//     .password(passwordEncoder().encode("abc"))
//     .roles("ADMIN")
//     .build();
//	 
//	 UserDetails adminUser2 = User.builder()
//			 .username("rahul")
//		     .password(passwordEncoder().encode("abc"))
//		     .roles("ADMIN")
//		     .build();
//	 return new InMemoryUserDetailsManager(adminUser1, adminUser2);
//	 //to store in database make this user detail service custom
//	 // and when you override load user by user name write database logic there
//	 // and done also you can use DAO authentication provider 
// }
	@Bean
	BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	   @Bean
	   AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
	   return builder.getAuthenticationManager();
	   }
}
