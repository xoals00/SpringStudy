package com.icia.song.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.icia.song.dto.MemberDto;

@Mapper
public interface MemberDao {
	boolean login(HashMap<String, String> hMap);
	
	
	boolean join(MemberDto member);
}
