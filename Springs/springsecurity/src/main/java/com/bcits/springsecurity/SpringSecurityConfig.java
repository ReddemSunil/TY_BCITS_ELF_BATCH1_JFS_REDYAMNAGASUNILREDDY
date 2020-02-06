package com.bcits.springsecurity;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configurable
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@SuppressWarnings("deprecation")
	@Bean
	public InMemoryUserDetailsManager getInMemoryUserDetailsManger() {

		InMemoryUserDetailsManager inMemoryManager = new InMemoryUserDetailsManager();

		inMemoryManager
				.createUser(User.withDefaultPasswordEncoder().username("user").password("sunil").roles("user").build());

		inMemoryManager.createUser(
				User.withDefaultPasswordEncoder().username("admin").password("qwerty").roles("admin").build());

		return inMemoryManager;
	}// End of getInMemoryUserDetailsManager()

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests().antMatchers("/index").permitAll()
		.and().authorizeRequests().antMatchers("/userSecureHome").hasRole("user")
		.and().authorizeRequests().antMatchers("/adminSecureHome").hasRole("admin")
		. and().formLogin().loginPage("/login")
		.and().logout().logoutSuccessUrl("/index");
	}// End of configure()

}// End of class
