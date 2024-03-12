package com.icia.solo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.solo.dao.MemberDao;
import com.icia.solo.dto.MemberDto;

@Service
public class MemberService {
	@Autowired
	MemberDao mDao;
	
	public MemberDto memberlogin(MemberDto memberDto) {
		 return mDao.memberlogin(memberDto);
	}

	public int memberjoin(MemberDto memberDto) {
		return mDao.memberjoin(memberDto);
		
	}
	
	
}
