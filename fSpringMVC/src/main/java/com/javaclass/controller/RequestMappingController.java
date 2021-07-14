package com.javaclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaclass.model.MemberVO;

// webapp/02_requestMapping.jsp 페이지 보면서 하면 됩니다!

@Controller
// ▼ 클래스에도 @RequestMapping을 해줄 수 있다.
@RequestMapping("re")
public class RequestMappingController {

	
	
	// -------------------------------------------------------------
	// RequestMapping 실습
	// -------------------------------------------------------------
	
	
	// @RequestMapping(value= {"re/a.do", "re/b.do"})
	// ▲클래스에 @RequestMapping("re") 걸어주기 전
	// ▼클래스에 @RequestMapping("re") 걸어주기 후
	@RequestMapping(value= {"/a.do", "/b.do"})
	// 						▲ 여러개의 요청에 대하여 동일한 메소드를 불러오는 방법
	public String test() {
		System.out.println("re/a.do 요청확인");
		// 1) ModelAndView를 만들어서 리턴하는 방법
		// *****************************************************
		// 2) 리턴형이 String인 경우
		// - 뷰페이지 지정임(views아래에 있는 페이지 불러옴)
		// *****************************************************
		return "start";
	}
	
	
	
	@RequestMapping(value="/c.do")
	public void sample(String id) {
		// *****************************************************
		// 3) 리턴형이 void인 경우
		// - 요청명과 동일한 뷰 페이지를 지정
		// 요청명 : re/c.do
		// *****************************************************
		// 파라메터 값 받는경우 : 받고싶은 파라메터를 메소드(여기)에 적어주면 된다
		// *****************************************************
		// 파라메터가 두개 이상인 경우는?
		// 인철) 보내는 매개변수 id pass 순으로 보내고 받는 매개변수 pass id 순으로 받고 출력해봤는데 순서 상관없이 id psss 이름따라 받는것같습니다!
		// *****************************************************
		System.out.println("이전 페이지(클라이언트)로 부터 받은 데이터 : " + id);
		// ▼ 요청3, 요청4 눌러보고 ▼아래 콘솔▼에 어떻게 찍히는지 확인!▼
	}



	// -------------------------------------------------------------
	// get / post 구분
	// -------------------------------------------------------------
	
	
	
	// 이전화면(폼태그 안)에서 사용자 입력값을 얻어와서 MemberVO 객체의 멤버 저장
	
	// @RequestMapping("/request.do")
	// ▲ GET  방식
	// ▼ POST 방식
	 @RequestMapping(value="/request.do", method=RequestMethod.POST)
	// 				▲ 속성을 여러개 쓸 때는 value를 꼭 앞에 써 줘야 한다.
	// 										▲ RequestMethod 임포트해줘야한다.
	public void request(@ModelAttribute("vo") MemberVO vo) {
		System.out.println("멤버의 아이디 : " + vo.getId());
		System.out.println("멤버의 이름 : " + vo.getName());
		System.out.println("멤버의 나이 : " + vo.getAge());
	}
	// 파라메터 값 받는경우 : 받고싶은 파라메터를 메소드(여기)에 적어주면 된다
	// 감동...!
	
	// 값을 가져올때는 param이나 클래스명(객체명)으로 가져와야 한다. 바로 별칭으로 가져올 수는 없다.
	// 별칭으로 가져오고 싶다면
	// @ModelAttribute("vo") 를 해줘야 별칭으로 가져올 수 있다.
	// 대신에 별칭으로 가져오면 클래스명(객체명)으로는 가져올 수 없다.
	// 별칭이나 클래스명, 둘 중에 선택해서 사용해야 한다.

	
	
	
	// -------------------------------------------------------------
	// Model 객체 리턴
	// -------------------------------------------------------------
	
	@RequestMapping("/model.do")
	public void model(Model m) {
		// *****************************************************
		// 4) 뷰 단으로 Model 객체에 데이터를 저장해서 넘김
		// Model 변수 선언이 인자(메소드(여기))로 지정, 리턴은 안 한다.
		// *****************************************************
		m.addAttribute("message","오늘도 우리 조 화이팅");
		m.addAttribute("data","스프링 만세");
	}
	// void 말고 원하는 다른거로 바꿔도 된다.
	
	
	// 프로젝트 할 때, 팀 별로 Model방식으로 할지, 다른 방식으로 할 지 마
	
	
}
