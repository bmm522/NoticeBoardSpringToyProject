package com.noticeboardproject.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.noticeboardproject.entity.BoardMember;

@Repository
public interface BoardMemberRepository extends JpaRepository<BoardMember, Long>{

	BoardMember findByuserId(String userId);

	boolean existsByuserId(String userId);
	
	

}
