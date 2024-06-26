package com.majustory.biz.psdBoard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PsdServiceImpl implements PsdService {

	@Autowired
	private PsdDao  dao ;
	
	@Override
	public void insert(PsdBoardVO vo) {
		dao.insert(vo);
		
	}

	@Override
	public List<PsdBoardVO> select(PsdBoardVO vo) {
		return dao.select(vo);
	}

	@Override
	public PsdBoardVO edit(PsdBoardVO vo) {
		return dao.edit(vo);
	}

	@Override
	public void delete(PsdBoardVO vo) {
		dao.delete(vo);
	}

}
