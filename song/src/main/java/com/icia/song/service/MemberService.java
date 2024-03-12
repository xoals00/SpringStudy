package com.icia.song.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.icia.song.dao.MemberDao;
import com.icia.song.dto.MemberDto;

@Service
public class MemberService {
	@Autowired
	private MemberDao mDao;
	
	public boolean login(HashMap<String, String> hMap) {
		return mDao.login(hMap);
	}
	//public boolean join()

	public boolean join(MemberDto member) {
		BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
		member.setS_pw(pwEncoder.encode(member.getS_pw()));
		return mDao.join(member);
	}
}
