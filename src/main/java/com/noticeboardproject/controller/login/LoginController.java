package com.noticeboardproject.controller.login;

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
	public String noticeBoardLoginAction(BoardMember login) {
		switch(loginService.loginCheck(login)) {
		case LOGINSUCCESS:
			return "redirect:/noticeboard/loginsuccess";
		case LOGINFAIL:
			return "redirect:/noticeboard/loginfail";
		}
		return "redirect:/noticeboard/loginfail";
		
	}
}
