package com.majustory.biz.board;

import java.util.List;
import java.util.Map;

public interface BoardDao {
	void  insert(BoardVO vo);
	void  delete(BoardVO vo);
	List<BoardVO>  select(BoardVO vo); 
	BoardVO  edit(BoardVO vo); 
	
	Map<String, Integer> totalCount();
	
	TotalCountVo totalCount2();
}
