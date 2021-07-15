package com.javaclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaclass.model.MemberVO;
import com.javaclass.model.MemberVOList;

@Controller
public class multiInsertController {

	// ▼ 어떤 요청이 불려졌을 때 이 메소드를 부르나요?
	@RequestMapping("multiInsert.do")
	public void setList(MemberVOList MemberVOList) {
		for(MemberVO vo : MemberVOList.getList()) {
			System.out.println(vo.getId());
			System.out.println(vo.getName());
			System.out.println(vo.getAge());
			
		}
	}
	
	
	
}
