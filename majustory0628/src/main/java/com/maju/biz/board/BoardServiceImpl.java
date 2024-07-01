package com.maju.biz.board;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao  dao ;
	
	@Override
	public void insert(BoardVO vo) {
		dao.insert(vo);
		
	}

	@Override
	public void update(BoardVO vo) {
		dao.update(vo);
		
	}

	@Override
	public void delete(BoardVO vo) {
		dao.delete(vo);		
	}

	@Override
	public HashMap<String, Object> getSelectOne(BoardVO vo) {
		return dao.getSelectOne(vo);
	}

	@Override
	public List<HashMap<String, Object>> getSelectAll(String ch1, String Ch2) {
		return dao.getSelectAll( ch1,  Ch2);
	}

}
