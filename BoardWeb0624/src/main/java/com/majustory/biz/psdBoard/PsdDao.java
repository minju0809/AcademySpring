package com.majustory.biz.psdBoard;

import java.util.List;

public interface PsdDao {
	void  insert(PsdBoardVO  vo);
	void  delete(PsdBoardVO  vo);	   
	PsdBoardVO  edit(PsdBoardVO  vo);
	List<PsdBoardVO>  select(PsdBoardVO  vo);
	
	void UPDATEFILEINSQL(PsdBoardVO  vo);
	void UPDATEFILENOTSQL(PsdBoardVO  vo);
}
