package com.javaclass.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class ReviewController {

	
//	// Model 방식
//	@RequestMapping("review.do")
//	public String view(Model v) {
//		v.addAttribute("message", "화이팅");
//		v.addAttribute("greeting", "안녕하세요");
//		return "09_exercise";
//	}
	
	
	
	/*
	 * 1) 리턴형이 String -> 뷰페이지명 지정
	 * 2) 데이터 전송
	 * 		1 - ModelAndView
	 * 		2 - Model (****리턴하지 않음)
	 * 		3 - Map(HashMap)
	 * */
	
	
//	// ModelAndView 방식
//	@RequestMapping("review.do")
//	public ModelAndView view() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("09_excercise");
//		mv.addObject("message", "화이팅");
//		mv.addObject("greeting", "안녕하세요");
//		return mv;
//	}
	
	
	// Map 방식
	@RequestMapping("review.do")
	public Map view() {
		Map<String, String> m = new HashMap<String, String>();
			m.put("message", "화이팅");
			m.put("greeting", "안녕하세요");
			return m;
	// 뷰페이지를 지정하지 않으면 review.jsp
	}	
}
