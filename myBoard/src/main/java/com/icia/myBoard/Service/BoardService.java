package com.icia.myBoard.Service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.myBoard.Dao.BoardDao;
import com.icia.myBoard.Dto.BoardDto;
import com.icia.myBoard.Dto.commentDto;
import com.icia.myBoard.Paging.Paging;

@Service
public class BoardService {
	@Autowired
	BoardDao boardDao;
	
	public List<HashMap<String, String>> showboard(Paging paging) {
		return boardDao.showboard(paging);
		
	}

	public int boardinsert(BoardDto boardDto) {
		return boardDao.boardinsert(boardDto);
		
	}

	public HashMap<String, BoardDto> boardread(BoardDto boardDto) {
		return boardDao.boardread(boardDto);
	}

	public int boardupdate(BoardDto boardDto) {
		return boardDao.boardupdate(boardDto);
		
	}

	public int boarddelete(BoardDto boardDto) {
			return boardDao.boarddelete(boardDto);
		
	}

	public int boardtotal() {
		return boardDao.boardtotal();
		
	}

	public int commentupdate(commentDto commentDto) {
		return boardDao.commentupdate(commentDto);
		
	}

	public List<HashMap<String, String>> commentread(BoardDto boardDto) {
		return boardDao.commentread(boardDto);
		
	}

}
