package com.maju.biz.board;

import java.util.HashMap;
import java.util.List;

public interface BoardDao {
	
   void  insert(BoardVO  vo);
   void  update(BoardVO  vo);
   void  delete(BoardVO  vo);
   
   HashMap<String, Object>  getSelectOne(BoardVO  vo);
   List<HashMap<String, Object>>  getSelectAll(String ch1, String Ch2);
	   
}
