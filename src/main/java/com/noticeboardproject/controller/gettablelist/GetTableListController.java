package com.noticeboardproject.controller.gettablelist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.noticeboardproject.entity.TableList;
import com.noticeboardproject.service.table.TableService;

@Controller
public class GetTableListController {
	
	@Autowired
	private TableService tableService;
	
	@GetMapping("/noticeboard/list")
	public String getTable(Model model,
			@PageableDefault(sort = "id", direction = Sort.Direction.DESC)Pageable pageable, String searchKeyword) {
		Page<TableList> tableList = null;
		if(searchKeyword == null) {
			tableList = tableService.getTableList(pageable);
		} else {
			tableList = tableService
		}
		int totalPage = tableList.getTotalPages()+1;
		int nowPage = tableList.getPageable().getPageNumber();
		System.out.println("totalPage : " + totalPage);
		System.out.println("nowPage : " + nowPage);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("tableList",tableList);
		return "view/tablelist";
	}
	
	
}
