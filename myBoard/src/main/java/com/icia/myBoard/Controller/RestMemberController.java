package com.icia.myBoard.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.myBoard.Dto.MemberDto;
import com.icia.myBoard.Service.MemberService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
public class RestMemberController {
	@Autowired
	MemberService memberService;
	
	@PostMapping("/check/userId")
	public String checkUserId(HttpSession session) {
		return (String) session.getAttribute("userId");
	}
	@PostMapping("/join/idCheck")
	public MemberDto joinIdCheck(MemberDto memberDto,Model model) {
		MemberDto mSer = memberService.joinIdCheck(memberDto);
			return mSer;		
		}
	}
	

