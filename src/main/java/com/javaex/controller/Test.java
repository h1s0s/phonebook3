package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {

	// 필드

	// 생성자

	// 메소드 gs

	// 메소드 일반
	@RequestMapping("/test")
	public String TestPrint() {// 이 컨트롤러로 요청이 오면 여기로 옴
		System.out.println("TestPrint");
		
		return "/WEB-INF/views/Test.jsp";
	}
	
	@RequestMapping("/aaa")
	public void TestPrint2() {
		System.out.println("TestPrint2");
	}
}
