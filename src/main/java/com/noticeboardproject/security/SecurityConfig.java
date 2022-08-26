package com.noticeboardproject.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() // 요청에 의한 보안검사 시작
			.anyRequest().authenticated() // 어떤 요청에도 보안검사를 한다
			.and()
			.formLogin() // 보안 검증은 formLogin방식으로 하겠다.
			.loginPage("/noticeboard/login") // 사용자 정의 로그인페이지
			.failureUrl("/noticeboard/login") // 로그인 성공 후 이동 페이지
			.usernameParameter("userId") // 아이디 파라미터명 설정
			.passwordParameter("userPwd") // 패스워드 파라미터명 설정
			.loginProcessingUrl("/noticeboard/loginaction") // 로그인 Form Action Url
			.successHandler(new loginSuccessHandler()) // 로그인 성공 후 핸들러(해당 핸들러를 생성하여 핸들링 해준다)
			.failureHandler(new loginFailureHandler())
			.permitAll(); // 사용자 정의 로그인 페이지 접근 권한 승인
	
		
	}

}
