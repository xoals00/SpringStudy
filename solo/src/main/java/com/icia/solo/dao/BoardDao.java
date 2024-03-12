package com.icia.solo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.icia.solo.dto.BoardDto;
import com.icia.solo.dto.MemberDto;

@Mapper
public interface BoardDao {

	int boardinfo(BoardDto boardDto);

	List<HashMap<String, String>> readboardlist(MemberDto memberDto);

	HashMap<String, String> boardread(BoardDto boardDto);

	int boardupdate(BoardDto boardDto);

}
