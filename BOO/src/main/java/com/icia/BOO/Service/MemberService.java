package com.icia.BOO.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.BOO.Dto.MemberDto;
import com.icia.BOO.MemberDao.MemberDao;

@Service
public class MemberService {
	
	@Autowired
	MemberDao memberdao;
	
	public void insert(MemberDto dto) {
		memberdao.save(dto);
		
	}

	
}
