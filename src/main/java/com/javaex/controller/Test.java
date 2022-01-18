package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/board")
public class Test {

	// 필드

	// 생성자

	// 메소드 gs

	// 메소드 일반
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST}) // 메소드에는 get/post중 어떤 방식으로 할지
	public String TestPrint() {// 이 컨트롤러로 요청이 오면 여기로 옴
		System.out.println("TestPrint");

		return "/WEB-INF/views/Test.jsp";
	}

	@RequestMapping(value = "/writeForm", method = RequestMethod.GET)
	public String TestPrint2() {
		System.out.println("TestPrint2");
		
		return "/WEB-INF/views/Test.jsp";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String TestPrint3() {
		System.out.println("TestPrint3");
		
		return "/WEB-INF/views/Test.jsp";
	}
}