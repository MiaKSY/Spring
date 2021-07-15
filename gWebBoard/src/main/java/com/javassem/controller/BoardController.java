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
	
	// @RequestMapping("getBoardList.do")
	// ▲ 슬래시 있고 없고 현재는 상관없다. ▼
	@RequestMapping("/getBoardList.do")
	public void getBoardList(Model m) {
		m.addAttribute("boardList", boardService.getBoardList());
	}
	// select => addAttribute 넘겨주자
	// 그 변수를 ""지정을해서 view단에 넘겨주자
	
	
	@RequestMapping("getBoard.do")
	  public void getBoard(Model m, BoardVO vo) {
       m.addAttribute("board", boardService.getBoard(vo));
    }
	
	
	
	
	
	
	
	
	@RequestMapping("insertBoard.do")
	public void insertBoard() {
		
	}

	
//	@RequestMapping("saveBoard.do")
//	public ModelAndView saveBoard(BoardDAO boardDAO) {
//		BoardVO vo = new BoardVO();
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("boardDAO");
//		mv.addObject("seq", vo.getSeq());
//		mv.addObject("title", vo.getTitle());
//		mv.addObject("writer", vo.getWriter());
//		mv.addObject("regDate", vo.getRegDate());
//		mv.addObject("cnt", vo.getCnt());
//		return mv;
//	}
	
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
	
	
	@RequestMapping("deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	
	@RequestMapping("updateBoard.do")
	public String updateBoard(BoardVO vo) {
		boardService.updateBoard(vo);
		return "redirect:getBoardList.do";
	}

	
	
	
	
//	@RequestMapping("getBoard.do")
//	public BoardVO getBoard(Model m) {
//		BoardVO vo = new BoardVO();
//		m.addAttribute("board",boardService.getBoard(vo));
//		return vo;
//	}

	
	
	
//	@Autowired
//	private BoardVO boardVO;
//	
//	@RequestMapping("getBoard.do")
//	public ModelAndView getBoard() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("getBoard");
//		mv.addObject("vo", boardVO);
//		return mv;
//	}
	
	
	
}


