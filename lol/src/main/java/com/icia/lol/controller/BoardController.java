package com.icia.lol.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.icia.lol.Service.BoardService;
import com.icia.lol.dto.BoardDto;
import com.icia.lol.dto.MemberDto;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {
	@Autowired
	private BoardService bSer;
	
	
	@GetMapping("/board/main")
	public String boardMain(Model model){
				
		model.addAttribute("bSer",bSer.boardInfo());		
		
		return "main";
	}
	
	@PostMapping("/board/dataInput")//글내용 들어있음
	public String dataInput(BoardDto bDto,Model model, MemberDto mDto,HttpSession session) {
		model.addAttribute("mDto",mDto);
		String userId = (String) session.getAttribute("userId");
		bDto.setUserId(userId);
		log.info("dto:{}",bDto);
		int result =bSer.input(bDto);
		log.info("bDto:{}",result);
		if (result == 1) {
			return "redirect:/board/main";
		}else {
			return "input";
		}

		
	}
	@GetMapping("/board/read")
	public String boardRead(Model model, BoardDto boardDto){
		log.info("boardDto:{}",boardDto);
		HashMap<String, String> bDto= bSer.boardRead(boardDto);
		model.addAttribute("bdto", bDto);
		return "read";
	}
	@GetMapping("/board/updata")
	public String boardUpdata(BoardDto boardDto ,HttpSession session) {
		BoardDto bDto = bSer.selectBoard(boardDto);
		String bDtoid = bDto.getUserId();
		log.info("bDto:{}",bDto);
		String userId = (String) session.getAttribute("userId");
		log.info("userid:{}",userId);
		if (userId.equals(bDtoid)) {
			return "updata";
		}
		return "read";
	}
	
	@PostMapping("/board/reload")
	public String boardUpdataReal(BoardDto boardDto,HttpSession session ,Model model) {
		log.info("data:{}",boardDto);
		bSer.boardUpdata(boardDto);
		
		
		return "main";
	}
	
}
