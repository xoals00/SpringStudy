package com.icia.solo.controller;

import java.util.HashMap;
import java.util.List;

import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.solo.dto.BoardDto;
import com.icia.solo.dto.MemberDto;
import com.icia.solo.service.BoardService;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {
	@Autowired
	BoardService bSer;
	@GetMapping("/board")
	public String board() {
		return "main";
	}
	
	
	@PostMapping("/board/info")
	public String boardinfo(BoardDto boardDto, Model model ,RedirectAttributes redirectAttributes, HttpSession session, MemberDto memberDto) {
		String userId = (String) session.getAttribute("userId");
		boardDto.setUserId(userId);
		int result = bSer.boardinfo(boardDto);
		if(result == 1) {
			redirectAttributes.addFlashAttribute("msg","글작성");
			List<HashMap<String, String>> bDto = bSer.readboardlist(memberDto);
			model.addAttribute("bDto",bDto);
			log.info("bDDDDDDDDDDDDDDDDDDD:{}",boardDto);
			return "board";
		}else {
			model.addAttribute("msg","글작성 실패");
			return "main";
		}
	}
	
	@GetMapping("/board/read/{bCnt}")
	public String boardread(@PathVariable String bCnt, Model model) {
//		HashMap<String, String> bDtoo = bSer.boardread(bCnt);
//		model.addAttribute("bDto",bDtoo);
		log.info("bCnt:{}",bCnt);
		return "read";
	}
	@GetMapping("/board/update")
	public String boardupdate(HttpSession session,BoardDto boardDto) {
		
		log.info("asdasdasasddasadsadsdasasda:{}",boardDto);
		return "update";
	}
	@PostMapping("/update")
	public String boardupdate(BoardDto boardDto,Model model,MemberDto memberDto) {
		int bser =  bSer.boardupdate(boardDto);
		log.info("ssssssssSSSSSSSSSSSSSSSSS:{}",boardDto);
		log.info("ssssssssSSSSSSSSSSSSSSSSS:{}",bser);
		if(bser == 1) {
			model.addAttribute("msg","수정완료");
			List<HashMap<String, String>> bDto = bSer.readboardlist(memberDto);
			model.addAttribute("bDto",bDto);
			return "board";
		}else {
			model.addAttribute("msg","수정실패");
			List<HashMap<String, String>> bDto = bSer.readboardlist(memberDto);
			model.addAttribute("bDto",bDto);
			return "board";
		}
		
	}
}
