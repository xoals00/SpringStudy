package com.icia.zxc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icia.zxc.dao.MemberDao;
import com.icia.zxc.dto.MemberDto;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RestMemberController {
	
	
	@Autowired
	MemberDao memberDao;
	
	@PostMapping("/checkId")
	public MemberDto checkId(MemberDto memberDto) {
		
		return memberDao.memberfind(memberDto);
	}

}
