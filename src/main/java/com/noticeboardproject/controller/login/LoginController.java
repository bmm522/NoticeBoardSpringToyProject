package com.noticeboardproject.controller.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.noticeboardproject.entity.BoardMember;
import com.noticeboardproject.service.login.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	
	@GetMapping("/noticeboard/login")
	public String noticeBoardLoginForm() {
		return "view/loginpage";
	}
	
	
	
	@PostMapping("/noticeboard/loginaction")
	public void noticeBoardLoginAction(BoardMember login, HttpServletResponse response) 
			throws IOException {
		switch(loginService.loginCheck(login)) {
		case LOGINSUCCESS:
			successLogin(response.getWriter());
			break;
		case LOGINFAIL:
			failLogin(response.getWriter());
		}
		
	}


	private void successLogin(PrintWriter out) {
		out.println("<script>");
		out.println("alert('로그인 성공')");
		out.println("location.href='/noticeboard/list'");
		out.println("</script>");
		
	}


	private void failLogin(PrintWriter out) {
		out.println("<script>");
		out.println("alert('로그인 실패')");
		out.println("location.href='/noticeboard/login'");
		out.println("</script>");
		
	}

}
