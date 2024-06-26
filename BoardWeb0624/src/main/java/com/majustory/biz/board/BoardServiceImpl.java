package com.majustory.biz.board;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.majustory.biz.comm.LogAdvice;

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
		dao.insert(vo);
	}

	@Override
	public List<BoardVO> select(BoardVO vo) {
		return dao.select(vo);
	}
	@Override
	public void delete(BoardVO vo) {
		dao.delete(vo);		
	}
	@Override
	public BoardVO edit(BoardVO vo) {
		return dao.edit(vo);
	}
	@Override
	public Map<String, Integer> totalCount() {
		// TODO Auto-generated method stub
		return dao.totalCount();
	}
	@Override
	public TotalCountVo totalCount2() {
		// TODO Auto-generated method stub
		return dao.totalCount2();
	}


}
