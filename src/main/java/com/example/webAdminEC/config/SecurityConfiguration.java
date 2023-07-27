package com.example.webAdminEC.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import com.example.webAdminEC.service.UserDetailService;


@Configuration
@EnableWebSecurity
public  class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
UserDetailService userDetailService;
	@Bean
	PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf()
        .disable().authorizeRequests().antMatchers("/public/**","/dist/**","/plugins/**","/static/**","/login/**").permitAll()
		.anyRequest().authenticated().and().formLogin()
				.loginPage("/login").permitAll().loginProcessingUrl("/j_spring_security_check").defaultSuccessUrl("/employee/list").and()
			      .logout() // (6)
			        .permitAll()
			        .and()
			      .httpBasic();
		

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
//		auth.inMemoryAuthentication()
//		.withUser("anhchung546@gmail.com").password(passwordEncoder().encode("123456"))
//		.authorities("ROLE_ADMIN");
	}



}
