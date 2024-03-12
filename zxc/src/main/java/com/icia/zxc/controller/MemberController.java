package com.icia.zxc.controller;

import java.util.HashMap;
import java.util.List;

import org.eclipse.tags.shaded.org.apache.xalan.transformer.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.zxc.dto.BoardDto;
import com.icia.zxc.dto.MemberDto;
import com.icia.zxc.paging.Paging;
import com.icia.zxc.service.BoardService;
import com.icia.zxc.service.MemberService;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemberController {
	@Autowired
	MemberService MemberService;
	@Autowired
	BoardService BoardService;
	
	@GetMapping("/")
	public String index() { //인덱스 페이지
		return "index";
	}
	@GetMapping("/join")
	public String join() {
		return "join";
	}
	@PostMapping("/member/join")
	public String memberjoin(MemberDto memberDto,RedirectAttributes redirectAttributes) {
		MemberDto mDto = MemberService.memberfind(memberDto); 
		if(mDto != null) {
			redirectAttributes.addFlashAttribute("msg","중복되는 아이디 입니다");
			return "redirect:/join";
		}else {
			int mjoin = MemberService.memberjoin(memberDto);
			if(mjoin == 1) {
				redirectAttributes.addFlashAttribute("msg","회원가입 완료");
				return "redirect:/";
			}else {
				redirectAttributes.addFlashAttribute("msg","알 수 없는 오류");
				return "redirect:/join";
			}
			
		}
		
	}
	
	@GetMapping("/login")
	public String login() { // 로그인 페이지
		return "login";
	}
	@PostMapping("/member/login")
	public String memberlogin(MemberDto memberdto, RedirectAttributes redirectAttributes, HttpSession session,Paging paging,Model model) {
		MemberDto mDto = MemberService.memberlogin(memberdto);
		paging.setTotal(MemberService.countboard()); // 게시판 총 갯수
		
		log.info("total:{}",paging.getTotal());
		log.info("pag:{}",paging.getNowPage()); // 현재 페이지 받기
		if(mDto == null) {
			redirectAttributes.addFlashAttribute("msg","로그인 실패");
			return "redirect:/login";
		}else {
			redirectAttributes.addFlashAttribute("msg","로그인 성공");
			 int nowPage = paging.getNowPage(); // 현재 페이지 저장			
			// model.addAttribute("nowPage",nowPage);
			session.setAttribute("userId",mDto.getUserId());
			return "redirect:/main?nowPage="+nowPage+"&total="+paging.getTotal();
			// return "main";
			
		}
		
	}
	@GetMapping("/main")
	public String main(HttpSession session, BoardDto boarddto , Model model, Paging paging) {
	
		int total =MemberService.countboard();
		//log.info("pag :{}",paging.getNowPage()); // 현재 페이지 받기
		
		paging.makePaging(total);
		List<HashMap<String, String>>  bDto = BoardService.showboard(paging);
		model.addAttribute("bDto",bDto);
		model.addAttribute("paging",paging);
		model.addAttribute("page",paging.getPList());
		return "main";	
	}
	@GetMapping("/logout")
	public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("msg", "로그아웃 되었습니다.");
		session.invalidate();
		return "redirect:/";
	}
	
	
}
