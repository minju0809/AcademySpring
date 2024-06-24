package com.majustory.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDao  dao;
	
	BoardServiceImpl(){
	  System.out.println("===>BoardServiceImpl 생성자 ");	
	}
	@Override
	public void insert(BoardVO vo) {
		dao.insert(vo);
	}

	@Override
	public List<BoardVO> select(BoardVO vo) {
		return dao.select(vo);
	}

}
