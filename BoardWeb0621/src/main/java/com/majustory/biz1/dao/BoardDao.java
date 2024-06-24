package com.majustory.biz1.dao;

import java.util.List;

import com.majustory.biz1.BoardVo;

public interface BoardDao {
	void insert(BoardVo vo);
	List<BoardVo> getSelect();
}	
