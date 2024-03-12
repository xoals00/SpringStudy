package com.icia.zxcv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.zxcv.dao.MemberDao;
import com.icia.zxcv.dto.MemberDto;

@Service
public class MemberService {
	@Autowired
	MemberDao MemberDao;
	
	public void memberlogin(MemberDto memberDto) {
		MemberDao.memberlogin(memberDto);
	}

}
