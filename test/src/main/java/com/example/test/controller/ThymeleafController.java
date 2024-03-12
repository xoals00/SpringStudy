package com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.test.dto.MemberDto;
import com.example.test.dto.login;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ThymeleafController {
	
	@GetMapping("/th/ex1")
	public String ex1(Model model) {
		MemberDto mb = new MemberDto();
		mb.setName("송태민");
		mb.setId("song");
		mb.setAge(24);
		mb.setAddr("인천");
		
		model.addAttribute("mb",mb);

		return "th/ex1";
	}
	
	@GetMapping("/th/ex2")
	public String ex2() {
		return "th/ex2";
	}
	
	@GetMapping("th/ex3")
	public String ex3(MemberDto member, Model model) {
		log.info("name"+member.getName()+", age="+member.getAge()+", addr="+member.getAddr());
		log.info("MemberDto= "+member);
		model.addAttribute("member",member);
		return "th/ex3";
	}
	
	@PostMapping("th/ex4")
	public String ex4(login login, Model model) {
//		login login = new login();
//		login.setId(id);
//		login.setPw(pw);
		model.addAttribute("login",login);
	
		return "th/ex4";
		
	}
	
		
}
