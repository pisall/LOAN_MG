package com.system.loan.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.system.loan.CustomAuthenticationSuccessHandler;
import com.system.loan.service.MyUserDetailsService;



@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	private CustomAuthenticationSuccessHandler suc=new CustomAuthenticationSuccessHandler();
	//@Autowired
	//@Qualifier("MYuserDetailsService")
	UserDetailsService  userDetailsService = new MyUserDetailsService();
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("testtttttt");
		auth.inMemoryAuthentication().withUser("root").password("root").roles("SYS");
//		auth.inMemoryAuthentication().withUser("admin").password("root123").roles("ADMIN");
//		auth.inMemoryAuthentication().withUser("dba").password("root123").roles("ADMIN","DBA");
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		auth.eraseCredentials(false);
	}
	@Override
	public void configure(org.springframework.security.config.annotation.web.builders.WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	};
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuu");
		http.authorizeRequests()
		.antMatchers("/login").permitAll()
		///.antMatchers("/", "/**").authenticated()
		//.antMatchers("/", "/**").access("hasRole('ADMIN')")
        .antMatchers("/","/home","/co_001_controller/**","/customer/**","/LoanAgreement/**","/Income/**","/Outcome/**","/report/**")
        .access("hasRole('ADMIN')")
       // .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
        .antMatchers("/sys/**").access("hasRole('SYS')")
        .and().formLogin().loginPage("/login").successHandler(suc)
        .usernameParameter("ssoId").passwordParameter("password")
        .and().csrf().disable()
        .exceptionHandling().accessDeniedPage("/Access_Denied").and().headers().frameOptions().sameOrigin();
	
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}
