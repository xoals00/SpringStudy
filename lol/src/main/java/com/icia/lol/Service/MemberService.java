package com.icia.lol.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.lol.dao.MemberDao;
import com.icia.lol.dto.MemberDto;
@Service
public class MemberService {
	@Autowired
	MemberDao mDao;
	
	public MemberDto login(MemberDto dto) {
		return mDao.login(dto);
	}

	public MemberDto join(MemberDto mDto){
		MemberDto dto =  mDao.login(mDto);
		if(dto==null) {
			mDao.join(mDto);
			return dto;
		}		
		return dto;
	}


}
