package com.noticeboardproject.controller.gettableview;

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
	public String getView(Model model) {
		return "view/tableview";
	}
}
