package com.noticeboardproject.service.makemember;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noticeboardproject.entity.BoardMember;
import com.noticeboardproject.repository.BoardMemberRepository;
import com.noticeboardproject.token.Token;

@Service
public class MakeMemberService {
	
	@Autowired
	private BoardMemberRepository boardMemberRepository;
	
	public Token makeMemberCheck(BoardMember boardMember,String userId) {
		if(boardMember.getEmail().equals("null") || boardMember.getPhoneNum().equals("null") ||
				boardMember.getRegdate().equals("null") || boardMember.getUserId().equals("null")
				|| boardMember.getUserName().equals("null") || boardMember.getUserPwd().equals("null")) {
			
			return Token.MAKEMEMBERERROR;
			
		} else {
			return makeMemberAction(boardMember, userId);
		}
	}

	private Token makeMemberAction(BoardMember boardMember, String userId) {
		if(boardMemberRepository.existsById(userId)) {
			return Token.MAKEMEMBERFAIL;
		} else {
			boardMemberRepository.save(boardMember);
			return Token.MAKEMEMBERSUCCESS;
		}
	}
	
	
}
