package com.noticeboardproject.service.gettable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.noticeboardproject.TableListRepository;
import com.noticeboardproject.entity.TableList;

@Service
public class GetTableService {
	
	@Autowired
	private TableListRepository tableListRepository;
	
	// 게시글 리스트 처리
	public Page<TableList> getTableList(Pageable pageable){
		
		return tableListRepository.findAll(pageable);
	}
}
