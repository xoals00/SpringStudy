package com.icia.song.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.song.dto.MemberDto;
import com.icia.song.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
	@Autowired
	private MemberService mSer;
	
	@GetMapping("/member/joinfrm")
	public String join() {
		log.info("========회원가입 양식========");
		return "join";
	}
	@PostMapping("/member/join")
	public String join(MemberDto member,Model model, RedirectAttributes rttr) {
		log.info("member:{}",member);
		boolean result = mSer.join(member);
		if(result) {
			rttr.addAttribute("msg","가입성공");
			return "redirect:/";
		}else {
			rttr.addAttribute("msg","가잆실패");
			return "join";
		}
	}
}
