package com.icia.lol.dao;

import org.apache.ibatis.annotations.Mapper;

import com.icia.lol.dto.MemberDto;

@Mapper
public interface MemberDao {

	MemberDto login(MemberDto dto);

	int join(MemberDto mDto);
	
	
	
}
