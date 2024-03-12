package com.icia.zxcv.dao;

import org.apache.ibatis.annotations.Mapper;

import com.icia.zxcv.dto.MemberDto;

@Mapper
public interface MemberDao {

	void memberlogin(MemberDto memberDto);

}
