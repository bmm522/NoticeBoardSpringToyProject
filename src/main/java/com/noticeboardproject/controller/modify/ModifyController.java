package com.noticeboardproject.controller.modify;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.noticeboardproject.entity.TableList;
import com.noticeboardproject.service.table.TableService;

@Controller
public class ModifyController {
	
	@Autowired
	private TableService tableService;
	
	//기존의 데이터 출력
	@GetMapping("/noticeboard/modify/{id}")
	public String viewModify(@PathVariable("id")Integer id, Model model) {
		model.addAttribute("preTable", tableService.getTableView(id));
		return "view/modifypage";
	}
	
	@PostMapping("/noticeboard/modifyaction/{id}")
	public void viewModifyAction(@PathVariable("id")Integer id, TableList tableList,
			HttpServletResponse response) throws Exception {
		TableList tableListTemp = tableService.getTableView(id);
		tableListTemp.setTitle(tableList.getTitle());
		tableListTemp.setContent(tableList.getContent());
		tableService.write(tableListTemp);
		movePage(response.getWriter());
	}

	private void movePage(PrintWriter out) {
		out.println("<script>");
		out.println("alert('글이 수정되었습니다.')");
		out.println("location.href='/noticeboard/list'");
		out.println("</script>");
	}
}
