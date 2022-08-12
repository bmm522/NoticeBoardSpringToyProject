package com.noticeboardproject.service.makemember;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noticeboardproject.entity.BoardMember;
import com.noticeboardproject.repository.BoardMemberRepository;

@Service
public class MakeMemberService {
	
	@Autowired
	private BoardMemberRepository boardMemberRepository;
	
	public void makeMemberCheck(BoardMember boardMember) {
		if(boardMember.getEmail().equals("null") || boardMember.getPhoneNum().equals("null") ||
				boardMember.getRegdate().equals("null") || boardMember.getUserId().equals("null")
				|| boardMember.getUserName().equals("null") || boardMember.getUserPwd().equals("null")) {
			
		}
	}
	
	
}
