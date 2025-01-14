package com.icia.BOO.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.icia.BOO.Dto.MemberDto;
import com.icia.BOO.Service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	@Autowired
	MemberService memberService;

	@GetMapping("/")
	public String index() {

		return "index";
	}

	@PostMapping("/join")
	public String join(MemberDto dto , HttpSession session, Model model) {
		
		memberService.insert(dto);
		String userId =  dto.getUserId();
		session.setAttribute("userId", dto.getUserId());
		model.addAttribute("dto",dto);
		System.out.println("댐");
		return "index";

	}

}
