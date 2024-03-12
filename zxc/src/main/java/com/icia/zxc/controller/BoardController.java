package com.icia.zxc.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.zxc.dto.BoardDto;
import com.icia.zxc.paging.Paging;
import com.icia.zxc.service.BoardService;
import com.icia.zxc.service.MemberService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {
	@Autowired
	BoardService BoardService;
	@Autowired
	MemberService MemberService;
	
	@GetMapping("/board")
	public String board() {
		return "board";
	}
	
	@GetMapping("/read")
	public String read(BoardDto boardDto,Model model) {
		log.info("WWWWWWWWWWWWWWWWW:{}",boardDto);
		HashMap<String, String> bDto = BoardService.boardread(boardDto);
		model.addAttribute("bDto",bDto);
		log.info("++++++++++++++++++++++++++:{}",bDto);
		return "read";
	}
	@PostMapping("/board/info")
	public String boardinfo(BoardDto boardDto, RedirectAttributes redirectAttributes,Paging paging) {
		int bSer = BoardService.boardinfo(boardDto);
		if(bSer == 1) {
			
			return "redirect:/main?nowPage="+paging.getNowPage();
		}else {
			
			return "redirect:/board";
		}	
	}
	@GetMapping("/board/update")
	public String boardupdate(BoardDto boardDto, RedirectAttributes redirectAttributes,Paging paging) {
		int bSer = BoardService.boardupdate(boardDto);
		log.info("UUUUUUUUUUUUUUUUUUUUU:{}",boardDto);
		log.info("UUUUUUUUUbserU:{}",bSer);
		if(bSer == 1) {
			log.info("===========확인용");
			redirectAttributes.addFlashAttribute("msg","글 수정완료");
			return "redirect:/main?nowPage="+paging.getNowPage();
		}else {
			redirectAttributes.addFlashAttribute("msg","글 수정실패");
			return "redirect:/read";
		}
		
	}
	@GetMapping("/board/delete")
	public String boarddelete(BoardDto boardDto, RedirectAttributes redirectAttributes,Paging paging) {
		int bSer = BoardService.boarddelete(boardDto);
		if(bSer == 1) {
			redirectAttributes.addFlashAttribute("msg","글 삭제 성공");
			return "redirect:/main?nowPage="+paging.getNowPage();
		}else {
			redirectAttributes.addFlashAttribute("msg","글 삭제 실패");
			return "redirect:/read";			
		}
	}
	
}
