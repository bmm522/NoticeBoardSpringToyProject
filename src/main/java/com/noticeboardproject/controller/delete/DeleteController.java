package com.noticeboardproject.controller.delete;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.noticeboardproject.service.table.TableService;

@Controller
public class DeleteController {
	
	@Autowired
	private TableService tableService;
	
	@GetMapping("/noticeboard/delete/{id}")
	public void viewDelete(@PathVariable("id")Integer id, HttpServletResponse response) throws IOException {
		tableService.delete(id);
		movePage(response.getWriter());
	}

	private void movePage(PrintWriter out) {
		out.println("<script>");
		out.println("alert('글이 삭제되었습니다.')");
		out.println("location.href='/noticeboard/list'");
		out.println("</script>");
		
	}
}
