package com.icia.myBoard.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.myBoard.Dto.BoardDto;
import com.icia.myBoard.Dto.MemberDto;
import com.icia.myBoard.Service.MemberService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@GetMapping("/")
	public String index(RedirectAttributes redirectAttributes) {
		return "redirect:/board?nowPage=1";
	}
	
	@GetMapping("/login")
	public String login(BoardDto boardDto) {
		return "login";
	}
	@PostMapping("/member/login")
	public String memberlogin(MemberDto memberDto, HttpSession session, RedirectAttributes redirectAttributes) {
		MemberDto mDto = memberService.memberlogin(memberDto);
		log.info("=================mDto:{}",mDto);
		if(mDto == null) {
			redirectAttributes.addFlashAttribute("msg","로그인 실패");
			return "redirect:/login";			
		}else {
			redirectAttributes.addFlashAttribute("msg","로그인 성공");
			session.setAttribute("userId", mDto.getUserId());
			return "redirect:/board?nowPage=1";
		}
		
	}
	
	@GetMapping("/join")
	public String join() {
		return "join";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session,RedirectAttributes redirectAttributes) {
		session.invalidate();
		redirectAttributes.addFlashAttribute("msg","로그아웃 성공");
		return "redirect:/board?nowPage=1";
	}
	@PostMapping("/member/join")
	public String memberjoin(MemberDto memberDto, RedirectAttributes redirectAttributes) {
				if(memberDto.getUserPw()=="") {
					redirectAttributes.addFlashAttribute("msg","비밀번호 기입은 필수입니다.");
					return "redirect:/join";
				}
		int mSer = memberService.memberjoin(memberDto);
		log.info("=========:{}",mSer);
		if(mSer == 1) {
			redirectAttributes.addFlashAttribute("msg","회원가입 되었습니다.");
			return "redirect:/login";	
		}else {
			redirectAttributes.addFlashAttribute("msg","알 수 없는 오류.");
			return "redirect:/join";
		}
		
		
	}
}
