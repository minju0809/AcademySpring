package com.majustory.biz.board;

import java.util.List;

public interface BoardDao {
	   void  insert(BoardVO vo);
	   List<BoardVO>  select(BoardVO vo); 
}
