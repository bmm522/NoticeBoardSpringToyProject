package com.noticeboardproject.controller.makemember;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MakeMemberFail extends HttpServlet{
	@Override
	@RequestMapping("/noticeboard/makememberfail")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		movePage(response.getWriter());
	}

	private void movePage(PrintWriter out) {
		out.println("<script>");
		out.println("alert('회원가입실패')");
		out.println("location.href='/noticeboard/fail'");
		out.println("</script>");
		
	}
}
