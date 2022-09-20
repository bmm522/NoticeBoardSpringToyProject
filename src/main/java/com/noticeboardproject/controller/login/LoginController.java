package com.noticeboardproject.controller.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.noticeboardproject.entity.BoardMember;
import com.noticeboardproject.service.login.LoginService;

@SessionAttributes("userId")
@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	
	@GetMapping("/noticeboard/login")
	public String noticeBoardLoginForm() {
		return "view/loginpage";
	}
	
	
	
	@PostMapping("noticeboard/loginAction")
	public void noticeBoardLoginAction(@ModelAttribute BoardMember boardmember, HttpServletResponse response,Model model) 
			throws IOException {
		switch(loginService.loginCheck(boardmember)) {
		case LOGINSUCCESS:
			successLogin(response.getWriter(),model,boardmember.getUserId());
			break;
		case LOGINFAIL:
			failLogin(response.getWriter());
		default:
			failLogin(response.getWriter());
		}
		
	}


	private void successLogin(PrintWriter out, Model model, String userId) {
		model.addAttribute("userId", userId);
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
