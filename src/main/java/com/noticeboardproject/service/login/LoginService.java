package com.noticeboardproject.service.login;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noticeboardproject.entity.BoardMember;
import com.noticeboardproject.repository.LoginRepository;
import com.noticeboardproject.token.Token;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	
	public Token loginCheck(BoardMember boardMember) {
		
		Optional<BoardMember> loginInfo = loginRepository.findById(boardMember.getUserId());
		
		if(loginInfo.isEmpty()) {
			return Token.LOGINFAIL;
		}
		
		if(!loginInfo.get().getUserPwd().equals(boardMember.getUserPwd())) {
			return Token.LOGINFAIL;
		}
		
		return Token.LOGINSUCCESS;
	}
	
}
