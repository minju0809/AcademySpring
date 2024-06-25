package com.majustory.biz.board;

import java.util.List;

public interface BoardService {
   void  insert(BoardVO vo);
   List<BoardVO>  select(BoardVO vo); 
   void delete(BoardVO vo);
   BoardVO edit(BoardVO vo);
   int totalCount();
}
