package com.icia.myBoard.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.icia.myBoard.Dto.MemberDto;

@Mapper
public interface MemberDao {

	MemberDto memberlogin(MemberDto memberDto);

	MemberDto joinIdCheck(MemberDto memberDto);

	int memberjoin(MemberDto memberDto);

}
