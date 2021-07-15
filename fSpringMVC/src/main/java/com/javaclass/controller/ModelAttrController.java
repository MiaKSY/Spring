package com.javaclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaclass.model.MemberVO;

@Controller
public class ModelAttrController {

	// view페이지에서 불러오고 싶은 내용인데
	// message 라는 이름으로 불러올게요
	@ModelAttribute("message")
	public String attr1() {
		return "결과를 전송";
	}
	
	// view페이지에서 불러오고 싶은 내용인데
	// memberVO라는 이름으로 불러올게요
	// 그 안에 있는거는 memberVO.id 이런 느낌으로 가져옵니다.
	@ModelAttribute("memberVO")
	public MemberVO attr2() {
		MemberVO vo = new MemberVO();
		vo.setId("1234");
		vo.setName("박길자");
		vo.setAge(23);
		return vo;
	}
	
	
	@RequestMapping("modelAttr.do")
	public String test() {
		return "modelAttrResult";
	}
	
	
	// 반환형이 void면 메소드 이름과 같은 jsp파일을 views안에서 찾는다.
//	@RequestMapping("insert.do")
//	public void insert() {
//		
//	}
	
	// ▲ Controller 에서 Controller 로 갈 수는 없을까?  ▼
	
	@RequestMapping("insert.do")
	public String insert() {
		// Controller 에서 Controller 로 갈 수는 없을까? 
		// 사용자의 요청을 바꿔버리는 : 리다이렉트
		// 리다이렉트의 리턴형은 스트링이다.
		// return "select.do";
		// ▲ 단순 페이지 요청
		return "redirect:select.do";
	}
	// ▲ 추후에 여기다가 DB에 입력한다.
	
	
	@RequestMapping("select.do")
	public void select() {
		
	}
	// ▲ 추후에 여기서 DB의 데이터를 가져온다.
	
}



