package sample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// 여기다가 스티커 붙이고, 스프링 설정파일에 가서 빈으로 등록해주어야 한다.
@Controller
public class HelloController {

	@RequestMapping("/start.do")
	public ModelAndView test() {
		System.out.println("start.do 요청됨");
		
		ModelAndView mv = new ModelAndView();
		// mv.setViewName("/WEB-INF/view/hello.jsp");
		mv.addObject("name","홍길동");
		mv.addObject("message","오늘은 뭐 먹지?");
		return mv;
	}
	
	
	
}
