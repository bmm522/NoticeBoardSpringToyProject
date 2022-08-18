package com.noticeboardproject.controller.makemember;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.noticeboardproject.entity.BoardMember;
import com.noticeboardproject.service.makemember.MakeMemberService;
import com.noticeboardproject.token.Token;

@SessionAttributes("userId")
@Controller
public class MakeMemberController {
	
	@Autowired
	private MakeMemberService makeMemberService;
	
	@GetMapping("/noticeboard/makemember")
	public String noticeBoardMakeMemberForm() {
		return "view/makememberpage";
	}
	
	@PostMapping("/noticeboard/makememberaction")
	public void makeMemberAction(BoardMember boardMember,HttpServletRequest request, HttpServletResponse response,Model model) 
			throws IOException {
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String userPhoneNum = request.getParameter("phoneNum");
		String userEmail = request.getParameter("email");
		checkMakeMember(makeMemberService.makeMemberCheck(boardMember,
				userId,userPwd,userName,userPhoneNum,userEmail), response.getWriter(),model, userId);
	}
	

	private void checkMakeMember(Token token, PrintWriter out, Model model, String userId) throws IOException {	
		switch(token) {
		case MAKEMEMBERSUCCESS:
			model.addAttribute("userId", userId);
			out.println("<script>");
			out.println("alert('회원가입 성공')");
			out.println("location.href='/noticeboard/list'");
			out.println("</script>");
			break;
		case MAKEMEMBERERROR:
			out.println("<script>");
			out.println("alert('입력을 안한 곳이 있습니다.')");
			out.println("location.href='/noticeboard/makemember'");
			out.println("</script>");
			break;
		case MAKEMEMBERFAIL:
			out.println("<script>");
			out.println("alert('동일한 아이디가 존재합니다')");
			out.println("location.href='/noticeboard/makemember'");
			out.println("</script>");
			break;
		}
	}
		


}
