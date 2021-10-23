package com.example.demo;

import java.security.AuthProvider;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	 String[] resources = new String[]{
	            "/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"
	    };
	
	@Autowired
	private DataSource dataSource;
	 
	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailsService();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider autoProvider = new DaoAuthenticationProvider();
		autoProvider.setUserDetailsService(userDetailsService());
		autoProvider.setPasswordEncoder(passwordEncoder());
		return autoProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .authorizeRequests()
        .antMatchers(resources).permitAll()  
        .antMatchers("/","/index").permitAll()
        .antMatchers("/register").permitAll()
        .antMatchers("/process_register").permitAll()
        .antMatchers("/register_success").permitAll()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login")
            .permitAll()
            .defaultSuccessUrl("/menu")
            .failureUrl("/login?error=true")
            .usernameParameter("username")
            .and()
        .logout()
            .permitAll()
            .logoutSuccessUrl("/login?logout");
	}
	
}
