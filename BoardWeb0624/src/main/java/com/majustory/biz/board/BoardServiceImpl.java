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
		// dao.insert(vo); 트랜잭션 확인 완료
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
	public int totalCount() {
		return dao.totalCount();
	}

}
