package com.learning.springdemo.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	// add a reference to our security data source @Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	// use jdbc authentication 
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/customer/showForm*").hasAnyRole("MANAGER", "ADMIN")
			.antMatchers("/customer/save*").hasAnyRole("MANAGER", "ADMIN")
			.antMatchers("/customer/delete").hasAnyRole("ADMIN")
			.antMatchers("/customer/**").hasAnyRole("EMPLOYEE")
			.antMatchers("/resources/**").permitAll()
		.and()
			.formLogin()
				.loginPage(".showLoginPage")
				.loginProcessingUrl("/authenticateUser")
				.permitAll()
			.and()
				.logout().permitAll()
			.and()
				.exceptionHandling().accessDeniedPage("/access-denied");
			
	}
}