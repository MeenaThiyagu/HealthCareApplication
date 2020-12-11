package com.pharmaceutical.app.HealthcareApplication;
import org.springframework.http.HttpMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.*;


@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired//not creating object
	private UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider authProvider() //COnnect to DB
	{
		DaoAuthenticationProvider daoProvider=new DaoAuthenticationProvider();
		daoProvider.setPreAuthenticationChecks(toCheck -> {});
		daoProvider.setPostAuthenticationChecks(toCheck -> {});
		daoProvider.setUserDetailsService(userDetailsService);
		//daoProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		daoProvider.setPasswordEncoder(new BCryptPasswordEncoder());
		return daoProvider;
	}
	
	
	@Override
	  protected void configure(HttpSecurity http) throws Exception {
		http.cors();
	    http.csrf().disable();
	    http.authorizeRequests().antMatchers("/**").permitAll()
        .anyRequest()
        .authenticated().and().httpBasic();
	  }

	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//	    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	}

//	@Bean//providing object of UserDetailsService
//	@Override
//	protected UserDetailsService userDetailsService() {
//		List<UserDetails> users=new ArrayList<>();
//		users.add(User.withDefaultPasswordEncoder().username("Meena").password("hello").build());
//		users.add(User.withDefaultPasswordEncoder().username("Thiyagu").password("world").build());
//		return new InMemoryUserDetailsManager(users);
//		
//	}
}
