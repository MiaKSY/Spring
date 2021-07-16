package com.javassem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javassem.dao.BoardDAOImpl;
import com.javassem.domain.BoardVO;

// 서비스 스티커 부착, 그리고 별칭지정
@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	// 스티커 부착
	@Autowired
	private BoardDAOImpl boardDAO;

	public void insertBoard(BoardVO vo) {

		boardDAO.insertBoard(vo);
	}

	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

//	public List<BoardVO> getBoardList() {
//		return boardDAO.getBoardList();
//	}

	public List<BoardVO> getBoardList(String searchCondition, String searchKeyword) {
		return boardDAO.getBoardList(searchCondition, searchKeyword);
	}
}