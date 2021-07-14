package com.javaclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javaclass.model.MemberVO;

@Controller
public class AutoScanController {

	@Autowired
	private MemberVO memberVO;
	
	@RequestMapping("autoScan.do")
	public ModelAndView autoScan() {
		System.out.println("autoScan.do 요청확인");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("01_autoScan"); // 뷰페이지 지정
		mv.addObject("name","홍길자");
		mv.addObject("vo",memberVO); // vo라는 이름으로 memberVO를 추가한다.
		return mv;
	}
}
