package com.produto.faturamento.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();

    }
	
	@Override
	protected void configure(HttpSecurity http)throws Exception{
		http.cors().and()
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/*").permitAll();
//		.antMatchers("/login").permitAll()
//		.antMatchers(HttpMethod.POST,"/alunos").permitAll()//hasAnyRole("MANAGER")
//		.antMatchers(HttpMethod.GET,"/alunos").permitAll()//hasAnyRole("USERS", "MANAGER")
//		.antMatchers("/adm-crud").permitAll()
//		.anyRequest().authenticated().and().httpBasic();
		
	
	}

}
