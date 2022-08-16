package com.noticeboardproject.service.gettable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noticeboardproject.TableListRepository;
import com.noticeboardproject.entity.TableList;

@Service
public class GetTableService {
	
	@Autowired
	private TableListRepository tableListRepository;
	
	// 게시글 리스트 처리
	public List<TableList> getTableList(){
		
		return tableListRepository.findAll();
	}

	public TableList getTableView(Integer id) {
		
		return tableListRepository.findById(id).get();
	}
}

