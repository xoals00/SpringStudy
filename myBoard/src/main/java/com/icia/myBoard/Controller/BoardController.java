package com.icia.myBoard.Controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.myBoard.Dto.BoardDto;
import com.icia.myBoard.Dto.commentDto;
import com.icia.myBoard.Paging.Paging;
import com.icia.myBoard.Service.BoardService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {
	@Autowired
	BoardService boardService;
	@GetMapping("/write")
	public String write(HttpSession session, RedirectAttributes redirectAttributes) {
		if(session.getAttribute("userId") == null) {
			redirectAttributes.addFlashAttribute("msg","로그인 되어있는 회원만 작성가능");
			return "redirect:/login";
		}
		return "write";
	}
	
	@GetMapping("/board")
	public String board(BoardDto boardDto, Model model, Paging paging) {
		int total = boardService.boardtotal(); // 토탈 게시글 
		paging.makePaging(total);
		
		List<HashMap<String, String>> bDto= boardService.showboard(paging); //20 페이지 가져오기
		
		model.addAttribute("bDto",bDto);
		model.addAttribute("paging",paging);
		model.addAttribute("page",paging.getPList());
		return "board";
	}
	@GetMapping("/board/read")
	public String boardread(BoardDto boardDto ,Model model) {
		HashMap<String, BoardDto>  bSer = boardService.boardread(boardDto);
		List<HashMap<String, String>> bCom= boardService.commentread(boardDto);
		model.addAttribute("bCom",bCom);
		model.addAttribute("bDto",bSer);
		// log.info("=========:{}",bSer);
		return "read";
	}
	
	@PostMapping("/board/insert")
	public String boardinsert(BoardDto boardDto, RedirectAttributes redirectAttributes) {
		int bSer = boardService.boardinsert(boardDto);
		if(bSer == 1) {
			redirectAttributes.addFlashAttribute("msg","글작성 완료");
			return "redirect:/board?nowPage=1";
		}else {
			redirectAttributes.addFlashAttribute("msg","글작성 실패");
			return "redirect:/write";
		}
		
	}
	@GetMapping("/board/update")
	public String boardupdate(BoardDto boardDto , RedirectAttributes redirectAttributes) {
		int bSer = boardService.boardupdate(boardDto);
		if(bSer == 1) {
			redirectAttributes.addFlashAttribute("msg","글 수정 완료");
			return "redirect:/board?nowPage=1";
		}else{
			redirectAttributes.addFlashAttribute("msg","글 수정 실패");
			return "redirect:/board?nowPage=1";			
		}
		
	}
	@GetMapping("/board/delete")
	public String boarddelete(BoardDto boardDto, RedirectAttributes redirectAttributes) {
		int bSer = boardService.boarddelete(boardDto);
		log.info("==============:{}",bSer);
		if(bSer == 1) {
			redirectAttributes.addFlashAttribute("msg","글 삭제 완료");
			return "redirect:/board?nowPage=1";
		}else {
			redirectAttributes.addFlashAttribute("msg","글 삭제 실패");
			return "redirect:/board?nowPage=1";
		}
	}
	
	@GetMapping("/comment/update")
	public String commentupdate(commentDto commentDto, RedirectAttributes redirectAttributes) {
		if(commentDto.getUserId() == "") {
			commentDto.setUserId("비회원");
		}
		int bSer = boardService.commentupdate(commentDto);
		if(bSer == 1) {
			redirectAttributes.addFlashAttribute("msg","댓글 작성 완료");
			return "redirect:/board/read?bCnt="+commentDto.getBCnt();
		}else {
			redirectAttributes.addFlashAttribute("msg","댓글 작성 완료");
			return "redirect:/board/read?bCnt="+commentDto.getBCnt();
		}
	}
	
	
	
}