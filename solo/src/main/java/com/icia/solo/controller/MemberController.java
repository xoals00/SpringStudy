package com.icia.solo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.solo.dto.BoardDto;
import com.icia.solo.dto.MemberDto;
import com.icia.solo.service.BoardService;
import com.icia.solo.service.MemberService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import retrofit2.http.GET;

@Slf4j
@Controller
public class MemberController {
	@Autowired
	MemberService mSer;
	@Autowired
	BoardService bSer;
	@GetMapping("/login")
	public String login() { // 로그인 jsp 파일로 이동
		return "login";
	}// 로그인 jsp 
	
	@PostMapping("/member/login")
	public String memberlogin(MemberDto MemberDto, Model model,HttpSession session,RedirectAttributes redirectAttributes) { // 로그인
		MemberDto mDto = mSer.memberlogin(MemberDto);
		log.info("mDto:{}",mDto);
		if(mDto == null) {
			model.addAttribute("msg","없는 아이디 입니다.");
			return "index";
		}else {
			session.setAttribute("userId",mDto.getUserId()); // 아이디가 있을경우 세션에 저장
			redirectAttributes.addFlashAttribute("msg","로그인성공");
			List<HashMap<String, String>> bDto = bSer.readboardlist(MemberDto);
			model.addAttribute("bDto", bDto);
			log.info("bDto:{}",bDto);
			return "redirect:/board";
		}
	} // 로그인 메서드
	
	@GetMapping("/join")
	public String join() { // 회원가입 jsp 파일로 이동
		return "join";
	}// 회원가입 jsp
	
	@PostMapping("/member/join")
	public String memberjoin(MemberDto memberDto, Model model) {// 회원가입 메소드
		MemberDto mDto =  mSer.memberlogin(memberDto);
		if(mDto == null) {
			int result = mSer.memberjoin(memberDto);
			log.info("result:{}",result);
			if(result == 1) {
				model.addAttribute("msg","회원가입 성공");
				return "login";
			}else {
				model.addAttribute("msg","알 수 없는 오류발생");
				return "index";
			}
		}else {
			model.addAttribute("msg","중복되는 아이디입니다.");
			return "index";
		}
		
	}
	@GetMapping("/logout")//글쓰기 페이지로 이동
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
}
