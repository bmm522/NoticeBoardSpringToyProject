package com.noticeboardproject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.noticeboardproject.entity.TableList;

@Repository
public interface TableListRepository extends JpaRepository<TableList,Integer>{
	Page<TableList> findByTitleContaining(Pageable pageable, String searchKeyword);
	
	@Modifying
	@Query("update TableList t set t.hit = t.hit + 1 where t.id = id")
	int updateHit(Integer id);
}
