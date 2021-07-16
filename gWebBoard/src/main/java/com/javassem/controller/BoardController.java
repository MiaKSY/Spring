package com.javassem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javassem.domain.BoardVO;
import com.javassem.service.BoardService;

@Controller
public class BoardController {
	
	
	// 인터페이스를 가져왔다.
	// 가져온 인터페이스에 대해서 스프링이 자동으로 주입하라고 시키는 스티커
	@Autowired
	private BoardService boardService;
	
	
	// ModelAndView, Model 두가지 방법이 있는데, 
	// 이미 이름을 다 맞춰놨다면 Model 방법이 더 간편하다. 
	
	
	
	
	//***********************************************
	// ▼ DB 데이터를 가져오기!!! (select로 만든 검색기능 추가 전)
	//***********************************************
	// @RequestMapping("getBoardList.do")
	// ▲ 슬래시 있고 없고 현재는 상관없다. ▼
	//***********************************************
//	@RequestMapping("/getBoardList.do")
//	public void getBoardList(Model m) {
//		m.addAttribute("boardList", boardService.getBoardList());
//	}
	//***********************************************
	// select => addAttribute 넘겨주자
	// 그 변수를 ""지정을해서 view단에 넘겨주자
	//***********************************************
	
	
	
	
	
	//***********************************************
	// ▼ DB 데이터를 가져오기!!! (select로 만든 검색기능 추가 후)
	//***********************************************
	// 인터페이스 BoardService에 가서 인자를 추가해주고
	// BoardServiceImpl에 가서 인자를 추가해주고
	// 인터페이스 BoardDAO에 가서 인자를 추가해주고
	// BoardDAOImpl에 가서 인자를 추가해준다
	// BoardMapper.xml에 가서 WHERE절을 추가해준다
	//***********************************************
	@RequestMapping("/getBoardList.do")
	public void getBoardList(Model m, String searchCondition, String searchKeyword) {
		m.addAttribute("boardList", boardService.getBoardList(searchCondition, searchKeyword));
	}
	
	
	
	
	
	//***********************************************
	// ▼ 이것이 가장 어려움!!!
	//***********************************************
	//***********************************************
	// ▼ DB 데이터를 가져오기!!!
	//***********************************************
	@RequestMapping("getBoard.do")
	  public void getBoard(Model m, BoardVO vo) {
       m.addAttribute("board", boardService.getBoard(vo));
    }
	
	
	
	
	
	
	// (단순 화면 전환) 화면 입력시키는 곳으로 보내기
	@RequestMapping("insertBoard.do")
	public void insertBoard() {
		
	}


	
	//***********************************************
	// ▼ DB에 입력시키고!!!! 목록으로 가져오기!!!
	//***********************************************
	@RequestMapping("saveBoard.do")
	public String saveBoard(BoardVO vo) {
		boardService.insertBoard(vo);
		// 여기까지 하고,, 보낼 화면은?
		// 현재 saveBoard 페이지가 있어야 하지만, 별로 그 페이지에서 할 말이 없다.
		// 바로 다른 페이지로 넘겨주자
		// 리다이렉트!!
		// 반환형은 String
		return "redirect:getBoardList.do";
	}
	
	
	
	
	//***********************************************
	// ▼ DB에 삭제시키고!!!! 목록으로 가져오기!!!
	//***********************************************	
	@RequestMapping("deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	
	
	
	//***********************************************
	// ▼ DB에 수정시키고!!!! 목록으로 가져오기!!!
	//***********************************************
	@RequestMapping("updateBoard.do")
	public String updateBoard(BoardVO vo) {
		boardService.updateBoard(vo);
		return "redirect:getBoardList.do";
	}

	
	
	
}


