package com.icia.song.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.icia.song.dto.MemberDto;

@SpringBootTest
class MemberDaoTest {
	@Autowired
	private MemberDao mDao;
	
	@Test
	@DisplayName("회원가입 테스트")
	@Transactional
	void joinTest() {
		MemberDto mb = MemberDto.builder().s_id("eee").s_pw("1111").s_name("비비")
				.s_birth("20001111").s_addr("인천").s_phone("010-1111-1111").build();
		//boolean result = mDao.join(mb);
		//System.out.println("========"+result);
		assertEquals(true, mDao.join(mb));
	}

}
