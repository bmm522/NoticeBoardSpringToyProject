package com.noticeboardproject.controller.write;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.noticeboardproject.entity.TableList;
import com.noticeboardproject.service.write.WriteService;

@Controller
public class WriteController extends HttpServlet{
	
	@Autowired
	private WriteService writeService;
	
	
	@GetMapping("/noticeboard/write")
	public String noticeBoardWriteForm() {
		return "view/tablewrite";
	}
	
	@PostMapping("/noticeboard/writeaction")
	public String noticeBoardWriteAction(TableList tableList, HttpServletRequest request) throws Exception {
		tableList.setWriter_id((String)request.getSession().getAttribute("userId"));
		writeService.write(tableList);
		return "redirect:/noticeboard/writemove";
	}

	
	
}
