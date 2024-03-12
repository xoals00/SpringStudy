package com.icia.zxc.dao;

import org.apache.ibatis.annotations.Mapper;

import com.icia.zxc.dto.MemberDto;

@Mapper
public interface MemberDao {
	MemberDto memberlogin(MemberDto memberdto);

	MemberDto memberfind(MemberDto memberDto);

	int memberjoin(MemberDto memberDto);

	int countboard();

	

}
