package com.noticeboardproject.controller.gettableview;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.noticeboardproject.service.gettable.GetTableService;

@Controller
public class GetTableViewController {
	
	@Autowired
	private GetTableService getTableService;
	
	@GetMapping("/noticeboard/view")
	public String moveView(Model model, Integer id, HttpServletRequest request) {
		model.addAttribute("view", getTableService.getTableView(id));
		model.addAttribute("sessionUserId",request.getSession().getAttribute("userId"));
		return "view/tableview";
	}
	
	
}
