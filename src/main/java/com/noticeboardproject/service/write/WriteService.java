package com.noticeboardproject.service.write;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noticeboardproject.TableListRepository;
import com.noticeboardproject.entity.TableList;

@Service
public class WriteService {
	
	@Autowired
	private TableListRepository tableListRepository;
	
	public void write(TableList tableList) throws Exception{
		tableListRepository.save(tableList);
	}
}
