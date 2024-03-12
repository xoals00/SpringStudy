package com.example.test.controller;

import java.awt.Point;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
public class HomeController {
	
	@GetMapping("/a") //MVC
	public String home2(Model model) {
		model.addAttribute("name","홍길동");
		model.addAttribute("age",10);
		return "hello.html"; //tmp/hello.html 포워딩
	}
	
	@GetMapping("/")
	public Point home() {
		Point p = new Point(100,200);
		return p;  //java객체 --> jackson --> json
	}
}
