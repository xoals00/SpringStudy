package com.icia.lol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.lol.Service.BoardService;
import com.icia.lol.Service.MemberService;
import com.icia.lol.dto.BoardDto;
import com.icia.lol.dto.MemberDto;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	@Autowired
	private MemberService mSer;
	@Autowired
	private BoardService bSer;
	
	@GetMapping("/login")
	public String login(){
		return "login";
	}
	
	@GetMapping("/")
	public String home() {
		return "join";
	}
	
	@GetMapping("/member/join")
	public String join(Model model,MemberDto mDto,HttpSession session) {
		 MemberDto MemberDto = mSer.join(mDto);
		 session.setAttribute("userId", mDto.getUserId());
		 if(MemberDto != null) {
			 model.addAttribute("msg","중복되는 아이디입니다.");
			 return "join";
		 }else {
			 model.addAttribute("msg","가입완료");
			 return "login";
		 }
	}
	
	@PostMapping("/member/login")
	public String login(MemberDto dto, Model model ,HttpSession session) {
		mSer.login(dto);
		session.setAttribute("userId", dto.getUserId());	
		
		return "redirect:/board/main";
	}
	
	@GetMapping("/member/input")//글쓰기 페이지로 이동
	public String input() {
		return "input";
	}
	
	@GetMapping("/logout")//글쓰기 페이지로 이동
	public String logout(HttpSession session) {
		session.invalidate();
		return "join";
	}
	
}
