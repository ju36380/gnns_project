package com.gnns.web.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class AuthFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        
    	String msg = "";
    	
        if (exception instanceof AuthenticationServiceException || exception instanceof BadCredentialsException) {
        	msg="아이디 또는 비밀번호가 틀렸습니다.";
			
		} else if(exception instanceof LockedException) {
			msg="잠긴 계정입니다.";
			
		} else if(exception instanceof DisabledException) {
			msg="비활성화된 계정입니다";
			
		} else if(exception instanceof AccountExpiredException) {
			msg="만료된 계정입니다.";
			
		} else if(exception instanceof CredentialsExpiredException) {
			msg="비밀번호가 만료되었습니다.";
		}
       
        request.setAttribute("usrId", request.getParameter("username"));
        request.setAttribute("usrPw", request.getParameter("password"));
        
        if(request.getRequestURI().equals("/login/login")) {
        	request.getRequestDispatcher("/login/login?msg="+msg).forward(request, response);
        }else {
        	request.getRequestDispatcher("/login/adminLogin?msg="+msg).forward(request, response);
        }
        
    }
}