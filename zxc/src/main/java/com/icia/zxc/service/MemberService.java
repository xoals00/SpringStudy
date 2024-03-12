package com.icia.zxc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.zxc.dao.MemberDao;
import com.icia.zxc.dto.MemberDto;

@Service
public class MemberService {
	@Autowired
	MemberDao memberdao;
	
	public MemberDto memberlogin(MemberDto memberdto) {
		return memberdao.memberlogin(memberdto);
	}

	public MemberDto memberfind(MemberDto memberDto) {
		 return memberdao.memberfind(memberDto);
		
	}

	public int memberjoin(MemberDto memberDto) {
		return memberdao.memberjoin(memberDto);
		
	}

	public int countboard() {
		return memberdao.countboard();
		
	}

}
