package com.icia.zxc.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.zxc.dao.BoardDao;
import com.icia.zxc.dto.BoardDto;
import com.icia.zxc.paging.Paging;

@Service
public class BoardService {
	@Autowired
	BoardDao boarddao;
	
	public List<HashMap<String, String>>  showboard(Paging paging) {
		System.out.println(paging.getNewboard());
		return boarddao.showboard(paging);
		
	}

	public HashMap<String, String> boardread(BoardDto boardDto) {
		return boarddao.boardread(boardDto);
		
	}

	public int boardinfo(BoardDto boardDto) {
		return boarddao.boardinfo(boardDto);
		
	}

	public int boardupdate(BoardDto boardDto) {
		return boarddao.boardupdate(boardDto);
		
	}

	public int boarddelete(BoardDto boardDto) {
		return boarddao.boarddelete(boardDto);
		
	}


}
