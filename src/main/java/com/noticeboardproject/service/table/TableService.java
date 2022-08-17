package com.noticeboardproject.service.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.noticeboardproject.TableListRepository;
import com.noticeboardproject.entity.TableList;

@Service
public class TableService {
	
	@Autowired
	private TableListRepository tableListRepository;
	
	// 게시글 리스트 처리
	public Page<TableList> getTableList(Pageable pageable){
		return tableListRepository.findAll(pageable);
	}
	
	// 해당 id 글 불러오기
	public TableList getTableView(Integer id) {
		return tableListRepository.findById(id).get();
	}
	
	// 글 작성
	public void write(TableList tableList) throws Exception{
		tableListRepository.save(tableList);
	}

	public void delete(Integer id) {
		tableListRepository.deleteById(id);
		
	}
}

