package com.icia.myBoard.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.myBoard.Dao.MemberDao;
import com.icia.myBoard.Dto.MemberDto;

@Service
public class MemberService {
	@Autowired
	MemberDao memberDao;
	
	public MemberDto memberlogin(MemberDto memberDto) {
		return memberDao.memberlogin(memberDto);
	}

	public MemberDto joinIdCheck(MemberDto memberDto) {
		return memberDao.joinIdCheck(memberDto);
		
	}

	public int memberjoin(MemberDto memberDto) {
		
		return memberDao.memberjoin(memberDto);
		
	}

}
