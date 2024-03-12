package com.icia.lol.Service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.lol.dao.BoardDao;
import com.icia.lol.dto.BoardDto;

@Service
public class BoardService {
	@Autowired
	private BoardDao mDao;
	
	public int input(BoardDto bDto) {
		return mDao.input(bDto);
	}

	public List<HashMap<String, String>> boardInfo() {
		return mDao.boardInfo();
		
	}

	public HashMap<String, String> boardRead(BoardDto boardDto) {
		return mDao.boardRead(boardDto);
		
	}
	
	public BoardDto selectBoard(BoardDto boardDto) {
		return mDao.selectBoard(boardDto);
		
	}

	public int boardUpdata(BoardDto boardDto) {
		return mDao.boardUpdata(boardDto);
		
	}

	

}
