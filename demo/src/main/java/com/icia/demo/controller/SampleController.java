package com.icia.demo.controller;

import java.security.Principal;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class SampleController {
	@GetMapping("/")
	public String index(HttpSession session, Model model, Principal principal) {
		System.out.println("Principal:"+principal); //로그인 사용자 정보 출력
		if(session.getAttribute("msg")!=null) {
			model.addAttribute("msg", session.getAttribute("msg"));
			session.removeAttribute("msg");
		}
		return "index";
	}
	@GetMapping("/member/login")
	public String login() {
		return "member/login";
	}
	@GetMapping("/member/login/error")
	public String loginError(Model model) {
		model.addAttribute("msg", "로그인 실패-model");
		return "member/login";
	}
	//@PostMapping("/member/login") 는 SecurityConfig.java의 필터에 정의함
	//@GetMapping("/member/logout") 는 SecurityConfig.java의 필터에 정의함
	
	@GetMapping("/member/anyone")
	public String anyone() {
		return "member/anyone";
	}
	
	@PreAuthorize("isAnonymous()")
	@GetMapping("/member/anonymous")
	public String anonymous() {
		return "member/anonymous";
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/member/authenticated")
	public String authenticated() {
		return "member/authenticated";
	}
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/member/user")
	public String user() {
		return "member/user";
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/member/admin")
	public String admin() {
		return "member/admin";
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/board/list")
	public String list() {
		return "board/list";
	}
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/board/contents")
	public String contents() {
		return "board/contents";
	}
}
