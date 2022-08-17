package com.noticeboardproject.controller.gettablelist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.noticeboardproject.service.table.TableService;

@Controller
public class GetTableListController {
	
	@Autowired
	private TableService tableService;
	
	@GetMapping("/noticeboard/list")
	public String getTable(Model model,
			@PageableDefault(sort = "id", direction = Sort.Direction.DESC)Pageable pageable) {
		model.addAttribute("tableList", tableService.getTableList(pageable));
		return "view/tablelist";
	}
	
	
}
