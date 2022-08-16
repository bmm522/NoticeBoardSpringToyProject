package com.noticeboardproject.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noticeboardproject.entity.BoardMember;
import com.noticeboardproject.repository.BoardMemberRepository;
import com.noticeboardproject.token.Token;

@Service
public class LoginService {
	
	@Autowired
	private BoardMemberRepository boardMemberRepository;
	
	public Token loginCheck(BoardMember boardMember) {
		
		BoardMember loginInfo = boardMemberRepository.findByuserId(boardMember.getUserId());
		
		if(loginInfo==null) {
			return Token.LOGINFAIL;
		}
		
		if(!loginInfo.getUserPwd().equals(boardMember.getUserPwd())) {
			return Token.LOGINFAIL;
		}
		
		return Token.LOGINSUCCESS;
	}
	
}
