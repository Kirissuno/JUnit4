//package com.app.auth;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class Auth extends WebSecurityConfigurerAdapter {
//	
//	@Autowired
//	public void config(final AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("root").password("{noop}root").roles("admin");
//	}
//
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic().and().csrf().disable();
//    }
//	
//
//}
