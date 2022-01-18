package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
@RequestMapping(value = "/phone")
public class PhoneController {
	// 필드

	// 생성자

	// 메소드 g/s

	// 메소드 일반
	@RequestMapping(value = "/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		System.out.println("PhoneController>writeForm");

		return "/WEB-INF/views/writeForm.jsp";
	}

	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@RequestParam("name") String name, @RequestParam("hp") String hp,
			@RequestParam("company") String company) {// 디스패쳐가 PersonVo를 생성해서 메모리에 올려줌
		System.out.println("PhoneController>write");

		System.out.println(name);
		System.out.println(hp);
		System.out.println(company);

		PersonVo personVo = new PersonVo(name, hp, company);

		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personInsert(personVo);

		return "redirect:/phone/list"; // localhost:8088/phonebook3
	}

	/*
	 * @RequestMapping(value = "/write", method = { RequestMethod.GET,
	 * RequestMethod.POST }) public String write(@ModelAttribute PersonVo personVo,
	 * 
	 * @RequestParam("company") String company){//디스패쳐가 PersonVo를 생성해서 메모리에 올려줌
	 * System.out.println("PhoneController>write");
	 * 
	 * System.out.println(personVo); System.out.println(company); return ""; }
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model){//디스패쳐가 PersonVo를 생성해서 메모리에 올려줌
		System.out.println("PhoneController>list");
		
		//다오에서 리스트를 가져온다
		PhoneDao phoneDao = new PhoneDao();
		List<PersonVo> personList = phoneDao.getPersonList();
		System.out.println(personList.toString());
		
		//컨트롤러 -->> DS로 데이터를 보낸다
		model.addAttribute("personList", personList);
		
		return "/WEB-INF/views/list.jsp";
	}
	@RequestMapping(value = "/updateForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String UpdateForm(@RequestParam("no") int no, Model model){
		System.out.println("PhoneController>updateForm");
		
		//다오에서 Vo를 가져온다
		PhoneDao phoneDao = new PhoneDao();
		PersonVo personVo = phoneDao.getPerson(no);
		
		model.addAttribute("personVo", personVo);
		
		return "/WEB-INF/views/UpdateForm.jsp";
	}
	@RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
	public String Update(@ModelAttribute PersonVo personVo){
		System.out.println("PhoneController>update");
		
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personUpdate(personVo);
		
		return "redirect:/phone/list";
	}
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String Delete(@RequestParam("no") int no){
		System.out.println("PhoneController>delete");
		
		//다오에서 Vo를 가져온다
		PhoneDao phoneDao = new PhoneDao();
		
		phoneDao.personDelete(no);

		return "redirect:/phone/list";
	}
}