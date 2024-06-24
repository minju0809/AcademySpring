package com.majustory.biz1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.majustory.biz1.BoardVo;
import com.majustory.biz1.dao.BoardDao;
import com.majustory.biz1.dao.BoardDaoImpl;

@Service("service")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao dao = new BoardDaoImpl();
	
	public BoardServiceImpl() {
		System.out.println("BoardServiceImpl 생성자");
	}
	
	@Override
	public void insert(BoardVo vo) {
		dao.insert(vo);
	}

	@Override
	public List<BoardVo> getSelect() {
		return dao.getSelect();
	}

}
