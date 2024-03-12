package com.icia.solo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.icia.solo.dao.BoardDao;
import com.icia.solo.dto.BoardDto;

@SpringBootTest
class BoardServiceTest {

	@Autowired
	BoardDao bDao;

	@Test
	public void boardinfo() {
		BoardDto boardDto = new BoardDto();

		boardDto.setUserId("test");
		boardDto.setBTitle("title");
		boardDto.setBDetail("내용 주니티테스트");

		for (int i = 0; i < 1000; i++) {

			bDao.boardinfo(boardDto);
		}

	}

}
