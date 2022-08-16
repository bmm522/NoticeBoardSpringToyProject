package com.noticeboardproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.noticeboardproject.entity.BoardMember;

@Repository
public interface MakeMemberRepository extends JpaRepository<BoardMember, Long>{

	
}
