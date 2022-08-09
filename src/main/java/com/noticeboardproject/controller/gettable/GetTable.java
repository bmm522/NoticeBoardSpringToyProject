package com.noticeboardproject.controller.gettable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.noticeboardproject.entity.TableList;
import com.noticeboardproject.service.gettable.GetTableService;

@Controller
public class GetTable {
	
	@Autowired
	private GetTableService getTableService;
	
	@GetMapping("/noticeboard/list")
	public String getTable(Model model,
			@PageableDefault(page = 0, size = 10, sort ="id", direction = Sort.Direction.DESC)Pageable pageable) {
	
		Page<TableList> table = getTableService.getTableList(pageable);
		int nowPage = table.getPageable().getPageNumber();
		int startPage = Math.max(nowPage - 4, 1);
		int endPage = Math.min(nowPage + 5, table.getTotalPages());
		
		model.addAttribute("table", table);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		return "table";
	}
	
	
}
