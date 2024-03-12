package com.icia.demo.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.icia.demo.dto.Mem;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class MemDaoTest {

	@Autowired
	MemDao memberDao;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Test
	public void joinTest() {
		log.info("pwEncoder:{}",passwordEncoder);
		String encodedPassword = passwordEncoder.encode("1234");
		memberDao.join(new Mem("ddd", encodedPassword, "USER"));
	}
}