package com.noticeboardproject.controller.makemember;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.noticeboardproject.entity.BoardMember;
import com.noticeboardproject.service.makemember.MakeMemberService;

@Controller
public class MakeMemberController {
	
	@Autowired
	private MakeMemberService makeMemberService;
	
	@GetMapping("/noticeboard/makemember")
	public String noticeBoardMakeMemberForm() {
		return "view/makememberpage";
	}
	
	@PostMapping("/noticeboard/makememberaction")
	public void noticeBoardMakeMemberAction(BoardMember boardMember, HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		String userId = request.getParameter("user_ID");
		String userPwd = request.getParameter("user_PW");
		String userName = request.getParameter("user_Name");
		String userPhoneNum = request.getParameter("user_Phonenum");
		String userEmail = request.getParameter("user_Email");
		switch(makeMemberService.makeMemberCheck(boardMember,userId,userPwd,userName,userPhoneNum,userEmail)) {
		case MAKEMEMBERERROR:
			makeMemberError(response.getWriter());
			break;
		case MAKEMEMBERSUCCESS:
			makeMemberSuccess(response.getWriter());
			break;
		case MAKEMEMBERFAIL:
			makeMemberFail(response.getWriter());
			break;
		}
		
	}

	private void makeMemberFail(PrintWriter out) {
		out.println("<script>");
		out.println("alert('동일한 아이디가 존재합니다')");
		out.println("location.href='/noticeboard/makemember'");
		out.println("</script>");
		
		
	}

	private void makeMemberSuccess(PrintWriter out) {
		out.println("<script>");
		out.println("alert('회원가입 성공')");
		out.println("location.href='/noticeboard/list'");
		out.println("</script>");
		
	}

	private void makeMemberError(PrintWriter out) {
		out.println("<script>");
		out.println("alert('입력을 안한 곳이 있습니다.')");
		out.println("location.href='/noticeboard/makemember'");
		out.println("</script>");
		
	}
}
