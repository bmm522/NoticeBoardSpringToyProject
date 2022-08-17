package com.noticeboardproject.controller.write;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.noticeboardproject.entity.TableList;
import com.noticeboardproject.service.table.TableService;

@Controller
public class WriteController extends HttpServlet{
	
	@Autowired
	private TableService tableService;
	
	
	@GetMapping("/noticeboard/write")
	public String noticeBoardWriteForm() {
		return "view/tablewrite";
	}
	
	@PostMapping("/noticeboard/writeaction")
	public String noticeBoardWriteAction(TableList tableList, HttpServletRequest request) throws Exception {
		tableList.setWriter_id((String)request.getSession().getAttribute("userId"));
		tableService.write(tableList);
		return "redirect:/noticeboard/writemove";
	}
	
	@RequestMapping("/noticeboard/writemove")
	public void movePage(HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('글이 생성되었습니다.')");
		out.println("location.href='/noticeboard/list'");
		out.println("</script>");
		
		
	}

	
	
}
