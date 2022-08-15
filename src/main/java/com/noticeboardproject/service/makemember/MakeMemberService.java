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
	
	public Token makeMemberCheck(BoardMember boardMember,String userId,String userPwd, String userName, String userPhoneNum, String userEmail) {
		if(userId.equals("null")||userPwd.equals("null")||userName.equals("null")||userEmail.equals("null")||
				userPhoneNum.equals("null")) {
			
			return Token.MAKEMEMBERERROR;
			
		} else {
			return makeMemberAction(boardMember, userId);
		}
	}

	private Token makeMemberAction(BoardMember boardMember, String userId) {
		if(boardMemberRepository.existsByuserID(userId)) {
			return Token.MAKEMEMBERFAIL;
		} else {
			boardMemberRepository.save(boardMember);
			return Token.MAKEMEMBERSUCCESS;
		}
	}
	
	
}
