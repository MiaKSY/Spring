package com.javaclass.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javaclass.model.MemberVO;

@Controller
public class ParamController {

//	// 나......
//	@Autowired
//	private MemberVO memberVO;
//	
//	@RequestMapping(value="paramForm.do",method=RequestMethod.POST)
//	public ModelAndView request() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("04_param");
//		mv.addObject("id", memberVO.getId());
//		mv.addObject("name", memberVO.getName());
//		mv.addObject("age", memberVO.getAge());
//		return mv;
//	}
//	// 내꺼 잘 작동 됨!	
	
	
	// 강사님
	@RequestMapping("param.do")
	// public String test(String id, String age) {
	// ▲ String 으로 된 age
	// ▼ int 로된 age
	// public String test(String id, @RequestParam(defaultValue="0") int age) {
	// ▼ Integer 로된 age
	public String test(String id, Integer age) {
		System.out.println("아이디 : " + id);
		System.out.println("나이 : " + age);
		return "04_param";
	}
	
	
	// 04_form.jsp를 만드셨다.
	//***************************
	// 세션이 필요할 때
	// 인자로 HttpSession session 를 추가해주면 된다.!
	//***************************
	@RequestMapping("paramForm.do")
	public String form(MemberVO vo, HttpSession session) {
		String dbid = "kosmo";
		String dbname = "홍길자";
		// 로그인처리
		if(vo.getId().equals(dbid) && vo.getName().equals(dbname)) {

			session.setAttribute("login", dbname + "님 접속");
		}
		return "04_form";
	}
	
	
	
}
