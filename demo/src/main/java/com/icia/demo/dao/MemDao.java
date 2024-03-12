package com.icia.demo.dao;

import java.util.Optional;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.icia.demo.dto.Mem;



@Mapper
public interface MemDao {
	//시큐리티에서 id를 username라고 한다.
	@Insert("insert into mem values(#{username},#{password},#{role})")
	public boolean join(Mem member);
	@Select("select * from mem where username=#{username}")
	public Mem getMemberInfo(String username);
	  
}
