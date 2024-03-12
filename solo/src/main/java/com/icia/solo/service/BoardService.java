package com.icia.solo.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.solo.dao.BoardDao;
import com.icia.solo.dto.BoardDto;
import com.icia.solo.dto.MemberDto;

@Service
public class BoardService {
	@Autowired
	BoardDao bDao;
	
	public int boardinfo(BoardDto boardDto) {
		return bDao.boardinfo(boardDto);
	}

	public List<HashMap<String, String>> readboardlist(MemberDto memberDto) {
		return bDao.readboardlist(memberDto);
		
	}

	public HashMap<String, String> boardread(BoardDto boardDto) {
		return bDao.boardread(boardDto);
		
	}

	public int boardupdate(BoardDto boardDto) {
		return bDao.boardupdate(boardDto);
		
	}
}
