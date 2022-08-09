package com.noticeboardproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.noticeboardproject.entity.TableList;

@Repository
public interface TableListRepository extends JpaRepository<TableList,Integer>{

}
