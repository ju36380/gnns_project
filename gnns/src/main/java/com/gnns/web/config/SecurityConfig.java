package com.gnns.web.config;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.gnns.web.member.service.AdminService;
import com.gnns.web.member.service.MemberService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private MemberService memberService;
	
	@Autowired
    private AdminService adminService;
	

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    

    @Override
    public void configure(WebSecurity web) throws Exception {
    	web.httpFirewall(defaultHttpFirewall()).ignoring().antMatchers(
    			"/static/css/**"
    			, "/static/font/**"
    			, "/static/js/**"
    			, "/static/img/**");
    }
    
    @Order(1)
    @Configuration
    public class MemberSecurity extends WebSecurityConfigurerAdapter {

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	http.antMatcher("/login/l*");
	    	
	    	http.csrf().disable();
	        http.authorizeRequests()
	                .antMatchers("/shipper/**").access("hasRole('ROLE_MEMBER_CHUL')")
	                .antMatchers("/wholesale/**").access("hasRole('ROLE_MEMBER_JUNG')")
	                .antMatchers("/member/management").access("hasRole('ROLE_ADMIN')")
	                .antMatchers("/member/adminUpdate").access("hasRole('ROLE_ADMIN')")
	                .antMatchers("/compost/compostEnrollment").authenticated()
	                .antMatchers("/compost/compostList").authenticated()
	                .antMatchers("/**").permitAll();
	               
	        
	
		        http.formLogin()
		                .loginPage("/login/login") 
		                .usernameParameter("userId")
		                .passwordParameter("userPw")
		                .failureUrl("/login/login?error=true")
		                .failureHandler(authFailureHandler())	// 실패 핸들러
		                .permitAll();
		        
	        http.logout()
	                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
	                .logoutSuccessUrl("/login/login")
	                .invalidateHttpSession(true);
	        
	        http.exceptionHandling()
	                .accessDeniedPage("/accessDeny?msg=");
	    }
	    
	    @Override
	    public void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
	    }
	    
    }
    
    
    @Order(2)
    @Configuration
    public class AdminSecurity extends WebSecurityConfigurerAdapter {

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	
	    	http.csrf().disable();
	        http.authorizeRequests()
			        .antMatchers("/shipper/**").access("hasRole('ROLE_MEMBER_CHUL')")
		            .antMatchers("/wholesale/**").access("hasRole('ROLE_MEMBER_JUNG')")
		            .antMatchers("/member/management").access("hasRole('ROLE_ADMIN')")
	                .antMatchers("/member/adminUpdate").access("hasRole('ROLE_ADMIN')")
	                .antMatchers("/compost/compostList").access("hasRole('ROLE_ADMIN')")
//	                .antMatchers("/compost/compostEnrollment").authenticated()
//	                .antMatchers("/compost/compostList").authenticated()
	                .antMatchers("/**").permitAll();
	               
	        
	
		        http.formLogin()
		                .loginPage("/login/adminLogin") 
		                .usernameParameter("userId")
		                .passwordParameter("userPw")
		                .failureUrl("/login/adminLogin?error=true")
		                .failureHandler(authFailureHandler())	// 실패 핸들러
		                .permitAll();
		        
	        http.logout()
	                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
	                .logoutSuccessUrl("/login/login")
	                .invalidateHttpSession(true)
	                .logoutSuccessHandler( new LogoutSuccessHandler() {
	                	// 로그아웃 성공시 처리할 핸들러
	                	@Override
	                	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
	                		boolean  chk = false;
	                		
	                		Iterator<GrantedAuthority> logOut=  (Iterator<GrantedAuthority>) authentication.getAuthorities().iterator();
	                		
	                		while(logOut.hasNext()) {
	                			if(logOut.next().toString().indexOf("ROLE_ADMIN") > -1) {
	                				chk = true;
	                				break;
	                			}
	                		}
	                		
	                		if(chk) response.sendRedirect("/login/adminLogin");
	                		else response.sendRedirect("/login/xh"); 
	                	} });
	
	        http.exceptionHandling()
	                .accessDeniedPage("/accessDeny?msg=");
	    }
	    
	    
	    @Override
	    public void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(adminService).passwordEncoder(passwordEncoder());
	    }
	    
    }
    
    

    
    
    @Bean
    public HttpFirewall defaultHttpFirewall() {
        return new DefaultHttpFirewall();
    }
    
    @Bean
    public AuthenticationFailureHandler authFailureHandler() {
    	return new AuthFailureHandler();
    }
}  	


