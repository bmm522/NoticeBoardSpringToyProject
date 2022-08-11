package com.noticeboardproject.controller.write;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/noticeboard/writemove")
public class WriteMoveController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		movePage(response.getWriter());
		
	}

	private void movePage(PrintWriter out) {
		out.println("<script>");
		out.println("alert('글이 생성되었습니다.')");
		out.println("location.href='/noticeboard/list'");
		out.println("</script>");
		
	}
}
