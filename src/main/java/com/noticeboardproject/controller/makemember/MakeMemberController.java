package com.noticeboardproject.controller.makemember;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.noticeboardproject.entity.BoardMember;

@Controller
public class MakeMemberController {
	
	@GetMapping("/noticeboard/makemember")
	public String noticeBoardMakeMemberForm() {
		return "view/makememberpage";
	}
	
	@PostMapping("/noticeboard/makememberaction")
	public String noticeBoardMakeMemberAction(BoardMember boardMember) {
		if(boardMember.getEmail().equals("null") || boardMember.getPhoneNum().equals("null") ||
				boardMember.getRegdate().equals("null") || boardMember.getUserId().equals("null")
				|| boardMember.getUserName().equals("null") || boardMember.getUserPwd().equals("null")) {
			return "redirect:/noticeboard/makememberfail";
		}
		return "redirect:/noticeboard/makemembersuccess";
	}
}
