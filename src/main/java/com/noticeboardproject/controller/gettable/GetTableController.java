package com.noticeboardproject.controller.gettable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.noticeboardproject.entity.TableList;
import com.noticeboardproject.service.gettable.GetTableService;

@Controller
public class GetTableController {
	
	@Autowired
	private GetTableService getTableService;
	
	@GetMapping("/noticeboard/list")
	public String getTable(Model model) {
//			@PageableDefault(page = 0, size = 10, sort ="id", direction = Sort.Direction.DESC)Pageable pageable) {
	
//		int nowPage = table.getPageable().getPageNumber();
//		int startPage = Math.max(nowPage - 4, 1);
//		int endPage = Math.min(nowPage + 5, table.getTotalPages());
		
		model.addAttribute("tableList", getTableService.getTableList());
//		model.addAttribute("nowPage", nowPage);
//		model.addAttribute("startPage", startPage);
//		model.addAttribute("endPage", endPage);
		
		return "table";
	}
	
	
}
