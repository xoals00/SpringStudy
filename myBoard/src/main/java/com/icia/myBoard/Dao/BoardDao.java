package com.icia.myBoard.Dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.icia.myBoard.Dto.BoardDto;
import com.icia.myBoard.Dto.commentDto;
import com.icia.myBoard.Paging.Paging;

@Mapper
public interface BoardDao {

	List<HashMap<String, String>> showboard(Paging paging);

	int boardinsert(BoardDto boardDto);

	HashMap<String, BoardDto> boardread(BoardDto boardDto);

	int boardupdate(BoardDto boardDto);

	int boarddelete(BoardDto boardDto);

	int boardtotal();

	int commentupdate(commentDto commentDto);

	List<HashMap<String, String>> commentread(BoardDto boardDto);

}
