package com.akash.app1.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.akash.app1.service.PersonService;

@EnableWebSecurity
public class SpringSecurityConfigure extends WebSecurityConfigurerAdapter {

	@Autowired
	private PersonService personService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(personService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable() //for post put, patch, delete
		.authorizeRequests()
		.antMatchers(HttpMethod.OPTIONS, "/**").permitAll() //to access by angular client
		.antMatchers("/person/signup").permitAll()
		.anyRequest().authenticated()
		.and()
		.httpBasic()
		.and()
		.formLogin();
		
	}
}
