package com.majustory.biz1.service;

import java.util.List;

import com.majustory.biz1.BoardVo;

public interface BoardService {
	void insert(BoardVo vo);
	List<BoardVo> getSelect();
}
