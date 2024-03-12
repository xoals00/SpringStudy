package com.icia.solo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.icia.solo.dto.MemberDto;

@Mapper
public interface MemberDao {

	MemberDto memberlogin(MemberDto memberDto);

	int memberjoin(MemberDto memberDto);
	
}
