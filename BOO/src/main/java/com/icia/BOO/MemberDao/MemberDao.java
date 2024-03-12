package com.icia.BOO.MemberDao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.icia.BOO.Dto.MemberDto;

@Repository
public interface MemberDao extends CrudRepository<MemberDto, String> {

	
}
