package com.javassem.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javassem.domain.BoardVO;


// 스티커 부착하고 별칭지정
@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO{

	// 스티커부착
	@Autowired
	private SqlSessionTemplate mybatis;

	// 아래는 다들 mapper 호출
	
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Mybatis insertBoard() 호출");
		mybatis.insert("BoardDAO.insertBoard", vo);
	}

	public void updateBoard(BoardVO vo) {
		System.out.println("===> Mybatis updateBoard() 호출");
		mybatis.update("BoardDAO.updateBoard", vo);
	}

	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Mybatis deleteBoard() 호출");
		mybatis.delete("BoardDAO.deleteBoard", vo);
	}

	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Mybatis getBoard() 호출");
		return mybatis.selectOne("BoardDAO.getBoard", vo);
	}

//	public List<BoardVO> getBoardList() {
//		System.out.println("===> Mybatis getBoardList() 호출");
//		return mybatis.selectList("BoardDAO.getBoardList");
//	}
	
	public List<BoardVO> getBoardList(String searchCondition, String searchKeyword) {
		System.out.println("===> Mybatis getBoardList() 호출");
		HashMap map = new HashMap();
		map.put("searchCondition", searchCondition);
		map.put("searchKeyword", searchKeyword);
		return mybatis.selectList("BoardDAO.getBoardList", map);
	}
}