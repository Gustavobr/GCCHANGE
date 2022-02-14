package com.grpbg.Poc.UTIL;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration

public class Security extends WebSecurityConfigurerAdapter {

	protected void configure(HttpSecurity http) throws Exception {
		try {
			//http.authorizeRequests().antMatchers("/").permitAll().anyRequest().authenticated();

		} catch (SecurityException ex) {
			ex.printStackTrace();
		}
	}

}
