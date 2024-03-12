package com.icia.zxcv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.icia.zxcv.dto.MemberDto;
import com.icia.zxcv.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService MemberService;
	
	@GetMapping("/")
	public String index() {
		return "/index";
	}
	@GetMapping("/login")
	public String login() {
		return "/login";
	}
	
	@GetMapping("/member/login")
	public String memberlogin(MemberDto MemberDto) {
		MemberService.memberlogin(MemberDto);
		
		return "";
	}
	
	
}
