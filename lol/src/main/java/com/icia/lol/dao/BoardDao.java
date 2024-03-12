package com.icia.lol.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.icia.lol.dto.BoardDto;

@Mapper
public interface BoardDao {

	int input(BoardDto bDto);

	List<HashMap<String, String>> boardInfo();

	

	HashMap<String, String> boardRead(BoardDto boardDto);


	BoardDto selectBoard(BoardDto boardDto);//수정 전 확인
	
	int boardUpdata(BoardDto boardDto);//수정
}
