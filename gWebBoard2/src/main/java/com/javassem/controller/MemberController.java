package com.javassem.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.javassem.dao.MemberDAO;
import com.javassem.domain.MemberVO;
import com.javassem.service.MemberService;

@Controller
@RequestMapping("/user/")  // 상위 폴더를 한번에 지정해주었다.
public class MemberController {

	
	// userJoin.do 라고 일일이 써야하는 것을 변수처리해서 {url}.do 라고 써줬다.
	@RequestMapping("{url}.do")
	public String sample(@PathVariable String url) {
		return "/user/" + url;
		// 상위폴더 경로를 앞에 따로 써줘야 한다. 
	}
	
	// 객체가 자동으로 주입되라는 스티커
	@Autowired
	MemberService memberService;
	
	@RequestMapping("userInsert.do")
	public ModelAndView insert(MemberVO memberVO) {
		// System.out.println("userInsert.do 요청확인");	// index에서 클릭했을 때, 컨트롤러까지 불려졌다면 콘솔에 찍힌다.
		// System.out.println(memberVO.getUserId());
		// System.out.println(memberVO.getUserName());
		// System.out.println(memberVO.getUserPass());
		int result = memberService.userInsert(memberVO);
		
		String message = "가입되지 않았습니다.";
		if(result>0) {
			message = memberVO.getUserName() + "님, 가입을 축하합니다.";
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/user/userJoin_ok"); // 뷰페이지 지정
		mv.addObject("result", result);
		mv.addObject("message", message);
		return mv;
	}
	
	@RequestMapping("login.do")
	// 									▼ 세션을 사용하고 싶다면 인자에 추가하기만 하면 된다.
	public String login(MemberVO vo, HttpSession session) {
						// ▲ 1번
		/*
		 * 1. 사용자 입력값 받아오기
		 * 2. DB에 해당 정보가 있는지 확인
		 * 3. 해당 정보가 있다면 (로그인 성공이라면) /user/Main.jsp 뷰페이지 지정
		 * 4. 그렇지 않다면 (로그인 실패시) /user/userLogin.jsp 뷰페이지 지정
		 * 
		 * */
		MemberVO result = memberService.idCheck_Login(vo);
								// ▲ 2번
		if(result == null || result.getUserId() == null) {
			return "/user/userLogin";	// 로그인 계속 시도
		} else { // 로그인 성공
			session.setAttribute("userName", result.getUserId());
			session.setAttribute("sessionTime", new Date());
			return "/user/Main";		// 메인페이지로 이동
		}
	}
	

	// 아이디 중복확인
	// ajax에서 보낼때도 한글처리 했었고, 여기서 받을 때도 한글처리 해야한다.
	@RequestMapping(value="idCheck.do", produces = "application/text; charset=UTF-8")
	//******************************************************
	@ResponseBody    // Ajax인 경우, 이 어노테이션을 꼭 써야한다.
	//******************************************************
	public String idCheck(MemberVO vo) {
		MemberVO result = memberService.idCheck_Login(vo);
		String message = "사용가능한 아이디입니다.";
		if(result != null) {
			message = "이미 사용중인 아이디입니다.";
		}
		return message;
	}
	
}
